package com.talhanation.smallships.api;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.WaterSpawnFinder;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.hitbox.DeckEscape;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships.world.item.CannonAmmoSelection;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.wind.Wind;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.ArrayList;
import java.util.List;

/**
 * The stable contract for NPC crews of other mods (Recruits captain and crew,
 * Workers). Everything here takes and returns vanilla or JDK types only, so a
 * caller can bind these methods by name - MethodHandles, reflection - and needs
 * no compile dependency on Small Ships at all.
 *
 * The rule of this class: Small Ships owns every rule. A caller only presses
 * the keys a player has (W/S/A/D and the sail key) and pays with the materials
 * a player pays with. Cooldowns, prices and limits stay in here and in the
 * ship, never on the caller's side.
 *
 * Versioning: {@link #VERSION} goes up when methods are ADDED. An existing
 * signature is never changed or removed - a caller checks VERSION >= what it
 * needs and binds what it uses.
 *
 * Every method accepts any entity and answers neutrally (false, 0, null, an
 * empty tag or list, the unchanged delta) for one that is not a ship. All of it
 * is server side.
 *
 * Item costs in the tags below are lists of {Item: "ns:id" | Tag: "ns:tag",
 * Count: n} - one entry per ingredient, a Tag entry takes any item of it.
 */
public final class ShipBridge {
    public static final int VERSION = 1;

    /**
     * Scoreboard tag (Entity#addTag) that keeps a mob on a still deck instead
     * of being walked ashore, see DeckEscape. Plain vanilla, so a caller sets
     * it by this string without binding anything.
     */
    public static final String STAY_ON_DECK_TAG = DeckEscape.STAY_ON_DECK_TAG;

    private ShipBridge() {}

    /* ---------------- recognition & state ---------------- */

    public static boolean isShip(@Nullable Entity entity) {
        return entity instanceof Ship;
    }

    /**
     * @return the ship itself, the ship behind one of its hull parts, or null.
     * Look rays, projectiles and melee land on the PARTS, not on the ship.
     */
    @Nullable
    public static Entity getShipOf(@Nullable Entity entity) {
        if (entity == null) return null;
        Entity resolved = ShipPartEntity.resolve(entity);
        return resolved instanceof Ship ? resolved : null;
    }

    /** @return whoever stands at the helm and may steer her - player or NPC - or null. */
    @Nullable
    public static Entity getHelmsman(@Nullable Entity ship) {
        return ship instanceof Ship s ? s.getHelmsman() : null;
    }

    /** @return true if the entity stands at the DRIVER seat and may steer this ship (driverEntities config). */
    public static boolean isHelmsman(@Nullable Entity ship, @Nullable Entity entity) {
        if (!(ship instanceof Ship s) || entity == null || !s.canDrive(entity)) return false;
        if (s instanceof Seatable seatable) {
            ShipSeat seat = seatable.getSeatOf(entity);
            return seat != null && seat.type() == SeatType.DRIVER;
        }
        return !s.getPassengers().isEmpty() && s.getPassengers().get(0) == entity;
    }

    /** @return true if the ship can make way at all - afloat, free, not in the dockyard, not going down. */
    public static boolean canMakeWay(@Nullable Entity ship) {
        return ship instanceof Ship s && s.isInWater() && !s.isShipLeashed() && !s.isLocked()
                && !s.isInDockyardWork() && !s.isSinking() && !s.isSunken();
    }

    /** @return the drive along the bow in blocks per tick, negative astern. Not getDeltaMovement: that is zero for a crewed ship on the server. */
    public static float getSpeed(@Nullable Entity ship) {
        return ship instanceof Ship s ? s.getSpeed() : 0.0F;
    }

    /** @return the turn rate in degrees per tick, positive = to starboard (yaw grows). */
    public static float getRotSpeed(@Nullable Entity ship) {
        return ship instanceof Ship s ? s.getRotSpeed() : 0.0F;
    }

    /** @return 0 = furled ... 4 = full sail, 0 for a ship without sails. */
    public static int getSailState(@Nullable Entity ship) {
        return ship instanceof Sailable sailable ? sailable.getSailState() : 0;
    }

    /** @return ticks until W/S may change the sail state again. The sail key is not bound by it. */
    public static int getSailCooldown(@Nullable Entity ship) {
        return ship instanceof Ship s ? s.sailStateCooldown : 0;
    }

    /**
     * What the ship IS - read once when boarding and again after dockyard work
     * (upgrades). Keys:
     * <pre>
     * Length, Beam, AirDraft, Mass                 blocks, from the hull parts (AirDraft = highest mast top)
     * RequiredDepth                                int, blocks of water under the keel, same as the dockyard uses
     * MaxHealth, SailMaxHealth                     hull and sail pools
     * MaxSpeed                                     blocks/tick before penalties
     * Acceleration, SpeedDecay                     blocks/tick per tick, under drive / with nothing driving
     * MaxRotSpeed, RotStep, RotDecay               degrees/tick, degrees/tick per tick with rudder / without
     * ManoeuvreSpeed                               blocks/tick, sails furled + W or S
     * SailCooldown                                 int ticks between two W/S sail steps
     * HasSails, HasOars, OarFactor                 oars: sails 0 + W drives at MaxSpeed * OarFactor
     * RamSelfDamage                                0..1, share of its own ram damage the hull takes
     * HeadWind, SideWind, TailWind                 wind zone multipliers
     * CannonsPort, CannonsStarboard, MaxCannonsPerSide
     * AimMin, AimMax, AimRotationMax               broadside aim limits in degrees
     * </pre>
     */
    public static CompoundTag getProfile(@Nullable Entity ship) {
        CompoundTag tag = new CompoundTag();
        if (!(ship instanceof Ship s)) return tag;

        List<ShipPartEntity.Definition> parts = s.getParts();
        List<ShipPartEntity.Definition> hull = new ArrayList<>();
        float minV = Float.MAX_VALUE, maxV = -Float.MAX_VALUE, minH = Float.MAX_VALUE, maxH = -Float.MAX_VALUE, top = 0.0F;
        for (ShipPartEntity.Definition part : parts) {
            top = Math.max(top, part.y() + part.height());
            if (part.mast()) continue;
            hull.add(part);
            minV = Math.min(minV, part.v() - part.width() / 2.0F);
            maxV = Math.max(maxV, part.v() + part.width() / 2.0F);
            minH = Math.min(minH, part.h() - part.width() / 2.0F);
            maxH = Math.max(maxH, part.h() + part.width() / 2.0F);
        }
        boolean hasHull = !hull.isEmpty();
        tag.putFloat("Length", hasHull ? maxV - minV : s.getBbWidth());
        tag.putFloat("Beam", hasHull ? maxH - minH : s.getBbWidth());
        tag.putFloat("AirDraft", parts.isEmpty() ? s.getBbHeight() : top);
        tag.putFloat("Mass", s.getMass());
        tag.putInt("RequiredDepth", WaterSpawnFinder.getRequiredDepth(hull));

        Attributes attributes = s.getAttributes();
        tag.putFloat("MaxHealth", attributes.maxHealth);
        tag.putFloat("SailMaxHealth", SailDamage.getMaxHealth(s));
        tag.putFloat("MaxSpeed", Ship.toTickSpeed(attributes.maxSpeed));
        tag.putFloat("Acceleration", attributes.acceleration);
        tag.putFloat("SpeedDecay", s.getVelocityResistance() * 0.8F);
        tag.putFloat("MaxRotSpeed", Ship.toMaxRotSpeed(attributes.maxRotationSpeed));
        tag.putFloat("RotStep", Ship.toRotStep(attributes.rotationAcceleration));
        tag.putFloat("RotDecay", s.getVelocityResistance() * 2.5F);
        tag.putFloat("ManoeuvreSpeed", Ship.MANOEUVRE_SPEED);

        tag.putBoolean("HasSails", s instanceof Sailable);
        tag.putInt("SailCooldown", s instanceof Sailable sailable ? sailable.getSailStateCooldown() : 0);
        tag.putBoolean("HasOars", s instanceof Paddleable && s.getOarFactor() > 0.0F);
        tag.putFloat("OarFactor", s instanceof Paddleable ? s.getOarFactor() : 0.0F);
        tag.putFloat("RamSelfDamage", s.getRamSelfDamageFactor());
        tag.putFloat("HeadWind", s.getHeadWindMultiplier());
        tag.putFloat("SideWind", s.getSideWindMultiplier());
        tag.putFloat("TailWind", s.getTailWindMultiplier());

        int port = 0, starboard = 0;
        if (s instanceof Cannonable cannonable) {
            for (ShipCannon cannon : cannonable.getCannons()) {
                if (cannon.isRightSided()) starboard++;
                else port++;
            }
            tag.putInt("MaxCannonsPerSide", cannonable.getMaxCannonPerSide());
        }
        tag.putInt("CannonsPort", port);
        tag.putInt("CannonsStarboard", starboard);
        tag.putFloat("AimMin", Cannonable.CANNON_ANGLE_MIN);
        tag.putFloat("AimMax", Cannonable.CANNON_ANGLE_MAX);
        tag.putFloat("AimRotationMax", Cannonable.CANNON_ROTATION_MAX);
        return tag;
    }

    /**
     * The rules that are the same for every ship - read once. Keys:
     * <pre>
     * ManoeuvreSpeed                               blocks/tick, sails furled + W or S
     * KmhPerSpeed                                  km/h shown to the player per block/tick
     * TailWindAngle, HeadWindAngle                 degrees between wind direction and heading: up to the
     *                                              first it is a tail wind, from the second on a head wind
     * RamMinClosingKmh                             below this closing speed hulls only bump, no damage
     * CrashMinSpeedKmh                             the same for running into blocks
     * RamRearmDistance                             blocks to get away from the last ram before the next one counts
     * HandRepairLimit, SailPatchLimit              share of the pool hand repair / patching gets back, at most
     * HandRepairMin/Max, SailPatchMin/Max          points one hand repair / one patch puts back
     * HandRepairCost, SailPatchCost                item cost of one of them
     * DockyardRange                                blocks around a dockyard a ship has to lie in for work
     * CannonSpeed, FineGrainFactor                 muzzle speed in blocks/tick = CannonSpeed * ammo Speed
     *                                              (* FineGrainFactor if a fine grain powder is in the hold)
     * ShotDrag, ShotGravity                        per tick: position += velocity, then
     *                                              velocity = velocity * ShotDrag - (0, ShotGravity, 0)
     * FuzeMin, FuzeMax                             ticks from the trigger to the shot
     * CannonCooldown                               ticks from the shot to the next trigger
     * AimMin, AimMax, AimRotationMax               broadside aim limits in degrees
     * ShipHitDamageMin/Max                         hull points of a hit on a ship, before the ammo factors
     * LivingHitDamage                              damage of a hit on a living, before the ammo factor
     * AmmoTypes                                    per type name (BALL, CHAINED, GRAPE): Speed, Damage,
     *                                              LivingDamage, Pellets, HullFactor, SailFactor
     * </pre>
     * A hit on the hull deals ShipHitDamage * Damage * HullFactor, a hit in the
     * rigging the same with SailFactor to the canvas instead.
     */
    public static CompoundTag getRules() {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("ManoeuvreSpeed", Ship.MANOEUVRE_SPEED);
        tag.putFloat("KmhPerSpeed", Kalkuel.getKilometerPerHour(1.0F));
        tag.putFloat("TailWindAngle", Wind.TAIL_WIND_ANGLE);
        tag.putFloat("HeadWindAngle", Wind.HEAD_WIND_ANGLE);

        tag.putFloat("RamMinClosingKmh", (float) Ship.RAM_MIN_CLOSING_KMH);
        tag.putFloat("CrashMinSpeedKmh", (float) Ship.CRASH_MIN_SPEED_KMH);
        tag.putFloat("RamRearmDistance", (float) Ship.RAM_REARM_DISTANCE);

        tag.putFloat("HandRepairLimit", Ship.HAND_REPAIR_LIMIT);
        tag.putInt("HandRepairMin", Ship.HAND_REPAIR_MIN);
        tag.putInt("HandRepairMax", Ship.HAND_REPAIR_MIN + Ship.HAND_REPAIR_RANDOM - 1);
        // what Ship#repairByHand and SailDamage#patchWith take out of the container
        tag.put("HandRepairCost", costs(List.of(
                DockyardRecipe.Ingredient.of(Items.IRON_NUGGET, 1), DockyardRecipe.Ingredient.of(ItemTags.PLANKS, 1))));
        tag.putFloat("SailPatchLimit", SailDamage.PATCH_LIMIT);
        tag.putInt("SailPatchMin", SailDamage.PATCH_MIN);
        tag.putInt("SailPatchMax", SailDamage.PATCH_MIN + SailDamage.PATCH_RANDOM - 1);
        tag.put("SailPatchCost", costs(List.of(
                DockyardRecipe.Ingredient.of(Items.STRING, 1), DockyardRecipe.Ingredient.of(Items.IRON_NUGGET, 1))));
        tag.putInt("DockyardRange", DockyardBlockEntity.SHIP_DETECTION_RANGE);

        tag.putFloat("CannonSpeed", Cannon.BASE_SPEED);
        tag.putFloat("FineGrainFactor", Cannon.FINE_GRAIN_SPEED_FACTOR);
        tag.putFloat("ShotDrag", AbstractCannonBall.DRAG);
        tag.putFloat("ShotGravity", AbstractCannonBall.GRAVITY);
        tag.putInt("FuzeMin", Cannon.FUZE_MIN_TICKS);
        tag.putInt("FuzeMax", Cannon.FUZE_MIN_TICKS + Cannon.FUZE_RANDOM_TICKS - 1);
        tag.putInt("CannonCooldown", Cannon.COOL_DOWN_TICKS);
        tag.putFloat("AimMin", Cannonable.CANNON_ANGLE_MIN);
        tag.putFloat("AimMax", Cannonable.CANNON_ANGLE_MAX);
        tag.putFloat("AimRotationMax", Cannonable.CANNON_ROTATION_MAX);
        tag.putInt("ShipHitDamageMin", AbstractCannonBall.SHIP_HIT_DAMAGE_MIN);
        tag.putInt("ShipHitDamageMax", AbstractCannonBall.SHIP_HIT_DAMAGE_MIN + AbstractCannonBall.SHIP_HIT_DAMAGE_RANDOM - 1);
        tag.putFloat("LivingHitDamage", SmallShipsConfig.Server.shipGeneralCannonDamage.get().floatValue());

        CompoundTag types = new CompoundTag();
        for (CannonBallItem.Type type : CannonBallItem.Type.values()) {
            CompoundTag entry = new CompoundTag();
            entry.putFloat("Speed", type.speedMultiplier);
            entry.putFloat("Damage", type.damageMultiplier);
            entry.putFloat("LivingDamage", type.livingDamageMultiplier);
            entry.putInt("Pellets", type.projectileCount);
            entry.putFloat("HullFactor", type.hullFactor);
            entry.putFloat("SailFactor", type.sailFactor);
            types.put(type.name(), entry);
        }
        tag.put("AmmoTypes", types);
        return tag;
    }

    /**
     * How the ship IS RIGHT NOW - cheap enough to read every second. Keys:
     * <pre>
     * Damage, MaxHealth, HandRepairFloor           hull; hand repair stops at HandRepairFloor
     * SailHealth, SailMaxHealth, SailCondition     SailCondition: 0 intact, 1 torn, 2 destroyed
     * SailSpeedFactor                              1.0 / 0.75 / 0.0
     * MaxSpeedNow                                  blocks/tick incl. biome, cargo and cannon penalties
     * WindZone, WindStrength, WindMultiplier       zone: 0 head, 1 side, 2 tail; multiplier 1.0 with wind off
     * WindDirection                                degrees, the way the wind blows, in entity yaw convention
     * CannonBalls                                  balls of any type in the hold
     * Ammo                                         balls in the hold per type name (BALL, CHAINED, GRAPE)
     * FineGrain                                    fine grain powder in the hold
     * PortReady, StarboardReady                    cannons per side that could fire this tick
     * InWater, Leashed, Locked, DockyardWork, Sinking, Sunken
     * </pre>
     * Drive under sail state s (0..4), the same formula controlShip uses:
     * {@code MaxSpeedNow * s/4 * SailSpeedFactor * (1 + (WindMultiplier - 1) * WindStrength * s/4)}
     */
    public static CompoundTag getCondition(@Nullable Entity ship) {
        CompoundTag tag = new CompoundTag();
        if (!(ship instanceof Ship s)) return tag;

        Attributes attributes = s.getAttributes();
        tag.putFloat("Damage", s.getDamage());
        tag.putFloat("MaxHealth", attributes.maxHealth);
        tag.putFloat("HandRepairFloor", s.getHandRepairFloor());

        tag.putFloat("SailHealth", s instanceof Sailable ? SailDamage.getHealth(s) : 0.0F);
        tag.putFloat("SailMaxHealth", SailDamage.getMaxHealth(s));
        tag.putInt("SailCondition", s instanceof Sailable ? SailDamage.getState(s).ordinal() : 0);
        tag.putFloat("SailSpeedFactor", SailDamage.getSpeedFactor(s));
        // maxSpeed is refreshed by controlShip every tick; before the first one it is still 0
        tag.putFloat("MaxSpeedNow", s.maxSpeed > 0.0F ? s.maxSpeed : Ship.toTickSpeed(attributes.maxSpeed));

        Wind wind = s.getWind();
        tag.putInt("WindZone", wind.getZone(s.getYRot()).ordinal());
        tag.putFloat("WindStrength", wind.strength());
        tag.putFloat("WindMultiplier", SyncedServerConfig.windEnable() ? s.getWindMultiplier() : 1.0F);
        tag.putFloat("WindDirection", wind.direction());

        int[] perType = new int[CannonBallItem.Type.values().length];
        int balls = 0, fineGrain = 0;
        if (s instanceof Container hold) {
            for (int i = 0; i < hold.getContainerSize(); i++) {
                ItemStack stack = hold.getItem(i);
                if (stack.getItem() instanceof CannonBallItem ball) {
                    balls += stack.getCount();
                    perType[ball.getType().ordinal()] += stack.getCount();
                } else if (stack.is(ModItems.FINE_GRAIN_POWDER)) {
                    fineGrain += stack.getCount();
                }
            }
        }
        tag.putInt("CannonBalls", balls);
        CompoundTag ammo = new CompoundTag();
        for (CannonBallItem.Type type : CannonBallItem.Type.values()) ammo.putInt(type.name(), perType[type.ordinal()]);
        tag.put("Ammo", ammo);
        tag.putInt("FineGrain", fineGrain);

        int portReady = 0, starboardReady = 0;
        if (s instanceof Cannonable cannonable) {
            for (ShipCannon cannon : cannonable.getCannons()) {
                if (cannon.isCooldown() || cannon.isFuzing()) continue;
                if (cannon.isRightSided()) starboardReady++;
                else portReady++;
            }
        }
        tag.putInt("PortReady", portReady);
        tag.putInt("StarboardReady", starboardReady);

        tag.putBoolean("InWater", s.isInWater());
        tag.putBoolean("Leashed", s.isShipLeashed());
        tag.putBoolean("Locked", s.isLocked());
        tag.putBoolean("DockyardWork", s.isInDockyardWork());
        tag.putBoolean("Sinking", s.isSinking());
        tag.putBoolean("Sunken", s.isSunken());
        return tag;
    }

    /* ---------------- input: the keys a player has ---------------- */

    /**
     * W/S/A/D, exactly what a players' client sends. Only takes effect while a
     * helmsman stands at the helm (isHelmsman). With sails set, W/S step the
     * sails up/down (one step per SailCooldown); with sails furled, W rows or
     * creeps ahead and S goes astern.
     */
    public static void pressKeys(@Nullable Entity ship, boolean forward, boolean backward, boolean left, boolean right) {
        if (!(ship instanceof Ship s) || s.level().isClientSide()) return;
        s.updateControls(forward, backward, left, right, null);
    }

    /** The sail key: furls set sails at once, or sets a furled sail to state 1. */
    public static void pressSailKey(@Nullable Entity ship) {
        if (!(ship instanceof Sailable sailable) || ship.level().isClientSide()) return;
        sailable.toggleSail();
    }

    /* ---------------- broadside ---------------- */

    /**
     * Lays one broadside, like a player aiming. Clamped to AimMin/AimMax and
     * +-AimRotationMax; only written when it changes, the aim is synched data.
     */
    public static void setBroadsideAim(@Nullable Entity ship, boolean starboard, float pitch, float rotation) {
        if (!(ship instanceof Cannonable cannonable)) return;
        float angle = Mth.clamp(pitch, Cannonable.CANNON_ANGLE_MIN, Cannonable.CANNON_ANGLE_MAX);
        float turn = Mth.clamp(rotation, -Cannonable.CANNON_ROTATION_MAX, Cannonable.CANNON_ROTATION_MAX);
        if (Math.abs(cannonable.getCannonAngle(starboard) - angle) < 0.1F
                && Math.abs(cannonable.getCannonRotation(starboard) - turn) < 0.1F) return;
        cannonable.setCannonAim(starboard, angle, turn);
    }

    /**
     * Fires one broadside, the players' volley with the side given instead of
     * read off his look direction. Same path as the player: every cannon goes
     * through ShipCannon#trigger, so cooldown, fuze, ammo type and fine grain
     * powder all apply, and manned guns are skipped - their gunners fire
     * themselves.
     *
     * @return how many cannons were triggered
     */
    public static int fireBroadside(@Nullable Entity ship, @Nullable LivingEntity shooter, boolean starboard) {
        if (!(ship instanceof Ship s) || !(s instanceof Cannonable cannonable) || shooter == null) return 0;
        if (s.level().isClientSide() || s.isSinking() || s.isSunken()) return 0;

        int fired = 0;
        for (ShipCannon cannon : cannonable.getCannons()) {
            if (cannon.isRightSided() != starboard) continue;
            if (s instanceof Seatable seatable && seatable.getGunner(cannon.getSlotIndex()) != null) continue;
            if (cannon.isCooldown() || cannon.isFuzing()) continue;
            if (cannonable.getCannonBallToShoot(shooter) == null) break;
            cannon.trigger(shooter);
            fired++;
        }
        return fired;
    }

    /**
     * The guns as they stand right now, one entry per mounted cannon: Slot,
     * Starboard, X/Y/Z (the muzzle, where the shot starts), Ready (could start
     * a shot now), Manned (a player gunner works it - the broadside skips it).
     */
    public static ListTag getCannons(@Nullable Entity ship) {
        ListTag list = new ListTag();
        if (!(ship instanceof Cannonable cannonable)) return list;
        for (ShipCannon cannon : cannonable.getCannons()) {
            Vector3d muzzle = cannon.getCannon().getBarrelEndPoint();
            CompoundTag entry = new CompoundTag();
            entry.putInt("Slot", cannon.getSlotIndex());
            entry.putBoolean("Starboard", cannon.isRightSided());
            entry.putDouble("X", muzzle.x);
            entry.putDouble("Y", muzzle.y);
            entry.putDouble("Z", muzzle.z);
            entry.putBoolean("Ready", !cannon.isCooldown() && !cannon.isFuzing());
            entry.putBoolean("Manned", ship instanceof Seatable seatable && seatable.getGunner(cannon.getSlotIndex()) != null);
            list.add(entry);
        }
        return list;
    }

    /**
     * Fires the gun of one slot for the NPC working it. Like a player at a gun
     * he has to sit at the GUNNER post of that slot (takeSeat); the gun lies
     * at its broadside's aim, per gun aim stays with players. The broadside
     * still fires this gun as well - only a player gunner takes it out of it.
     * Same path as everyone: ShipCannon#trigger with cooldown, fuze, his ammo
     * choice and the powder in the hold.
     *
     * @return true if the gun was triggered
     */
    public static boolean fireCannon(@Nullable Entity ship, @Nullable LivingEntity gunner, int slot) {
        if (!(ship instanceof Ship s) || !(s instanceof Cannonable cannonable) || !(s instanceof Seatable seatable) || gunner == null) return false;
        if (s.level().isClientSide() || s.isSinking() || s.isSunken()) return false;

        ShipSeat post = seatable.getSeatOf(gunner);
        if (post == null || post.type() != SeatType.GUNNER || post.mappedCannonSlot() != slot) return false;
        for (ShipCannon cannon : cannonable.getCannons()) {
            if (cannon.getSlotIndex() != slot) continue;
            if (cannon.isCooldown() || cannon.isFuzing() || cannonable.getCannonBallToShoot(gunner) == null) return false;
            cannon.trigger(gunner);
            return true;
        }
        return false;
    }

    /**
     * The ammo an NPC shooter loads from now on, as a player picks it with the
     * mouse wheel: a type name of getRules AmmoTypes. Without that type in the
     * hold he loads whatever is there, as a player does. Kept until changed or
     * the entity is gone, not saved. A players' own choice is not touched.
     *
     * @return false for a player or an unknown type
     */
    public static boolean setAmmoPreference(@Nullable Entity shooter, @Nullable String type) {
        if (shooter == null || type == null || shooter instanceof Player || shooter.level().isClientSide()) return false;
        for (CannonBallItem.Type candidate : CannonBallItem.Type.values()) {
            if (candidate.name().equals(type)) {
                CannonAmmoSelection.set(shooter, candidate);
                return true;
            }
        }
        return false;
    }

    /* ---------------- repair: the players' prices and limits ---------------- */

    /** One hand repair, paid from the container: 1 iron nugget + 1 plank, up to the HandRepairFloor. */
    public static boolean repairHullByHand(@Nullable Entity ship, @Nullable Container payer) {
        return ship instanceof Ship s && payer != null && s.repairByHand(payer);
    }

    /** One sail patch, paid from the container: 1 string + 1 iron nugget, up to a third of the canvas. */
    public static boolean patchSails(@Nullable Entity ship, @Nullable Container payer) {
        return ship instanceof Ship s && payer != null && SailDamage.patchWith(s, payer);
    }

    /**
     * What a dockyard repair of this ship costs right now - the numbers the
     * repair buttons show, priced off the missing points. Keys: Costs (item
     * cost, empty if there is nothing to repair), Time (work ticks).
     */
    public static CompoundTag getDockyardRepairCosts(@Nullable Entity ship, boolean hull, boolean sails) {
        CompoundTag tag = new CompoundTag();
        if (!(ship instanceof Ship s)) return tag;
        tag.put("Costs", costs(DockyardBlockEntity.getRepairCosts(s, hull, sails)));
        tag.putInt("Time", DockyardBlockEntity.getRepairTime(s, hull, sails));
        return tag;
    }

    public static boolean isDockyard(@Nullable Level level, @Nullable BlockPos pos) {
        return level != null && pos != null && level.getBlockEntity(pos) instanceof DockyardBlockEntity;
    }

    /**
     * Starts a dockyard repair of this ship, paid from the container - the
     * same costs and work time as the players' repair button. The ship has to
     * lie within the dockyards' range and is locked while the work runs
     * (getCondition: DockyardWork).
     *
     * @return true if the job was started and paid for
     */
    public static boolean startDockyardRepair(@Nullable Level level, @Nullable BlockPos dockyard, @Nullable Entity ship,
                                              @Nullable Container payer, boolean hull, boolean sails) {
        if (level == null || dockyard == null || payer == null || !(ship instanceof Ship s)) return false;
        return level.getBlockEntity(dockyard) instanceof DockyardBlockEntity entity && entity.startRepairTask(s, payer, hull, sails);
    }

    /* ---------------- crew ---------------- */

    /**
     * The stations of the ship, one entry per seat: Id, Type (DRIVER,
     * PASSENGER, GUNNER, CANNON), Slot (cannon slot of a GUNNER or CANNON seat,
     * -1 otherwise), X/Y/Z (world position on the deck baseline), Blocked (a
     * gun stands on this carriage), Occupant (UUID, only while taken).
     *
     * Passengers sit: a moving deck does not carry anyone standing on it.
     */
    public static ListTag getSeats(@Nullable Entity ship) {
        ListTag list = new ListTag();
        if (!(ship instanceof Ship s) || !(s instanceof Seatable seatable)) return list;
        for (ShipSeat seat : seatable.getSeats()) {
            Vec3 pos = seat.getWorldPosition(s);
            CompoundTag entry = new CompoundTag();
            entry.putInt("Id", seat.id());
            entry.putString("Type", seat.type().name());
            entry.putInt("Slot", seat.mappedCannonSlot());
            entry.putDouble("X", pos.x);
            entry.putDouble("Y", pos.y);
            entry.putDouble("Z", pos.z);
            entry.putBoolean("Blocked", seatable.isSeatBlocked(seat));
            Entity occupant = seatable.getSeatOccupant(seat.id());
            if (occupant != null) entry.putUUID("Occupant", occupant.getUUID());
            list.add(entry);
        }
        return list;
    }

    /**
     * Moves a passenger already aboard to another free station. The helm only
     * for whoever may steer (driverEntities config), a gun carriage only while
     * no gun stands on it. Boarding itself stays vanilla - startRiding picks a
     * seat the same way it does for any mob.
     *
     * @return true if he sits there now
     */
    public static boolean takeSeat(@Nullable Entity ship, @Nullable Entity passenger, int seatId) {
        if (!(ship instanceof Ship s) || !(s instanceof Seatable seatable) || passenger == null) return false;
        if (s.level().isClientSide() || passenger.getVehicle() != s) return false;

        ShipSeat seat = seatable.getSeatById(seatId);
        if (seat == null || seatable.isSeatBlocked(seat)) return false;
        Entity occupant = seatable.getSeatOccupant(seatId);
        if (occupant != null) return occupant == passenger;
        if (seat.type() == SeatType.DRIVER && !s.canDrive(passenger)) return false;
        seatable.assignSeat(passenger, seatId);
        return true;
    }

    /* ---------------- geometry ---------------- */

    /**
     * @return the world boxes of the hull where the ship lies right now, masts
     * left out - the deck surface is their top. The vanilla box for a ship
     * without parts, empty for a non-ship.
     */
    public static List<AABB> getHullBoxes(@Nullable Entity ship) {
        return ship instanceof Ship s ? ShipPartEntity.hullBoxes(s) : List.of();
    }

    /**
     * @return the part of the movement the hull - masts included - could make
     * against blocks and other hulls, see ShipPartEntity#collide. The delta
     * itself for a ship without parts or a non-ship.
     */
    public static Vec3 sweep(@Nullable Entity ship, Vec3 delta) {
        return ship instanceof Ship s ? ShipPartEntity.collide(s, delta) : delta;
    }

    /**
     * @return the first other ship this hull would stand in after moving by
     * delta, or null - checked with the real hull boxes of both ships.
     */
    @Nullable
    public static Entity findShipAhead(@Nullable Entity ship, Vec3 delta) {
        return ship instanceof Ship s ? ShipPartEntity.findRammedShip(s, delta) : null;
    }

    private static ListTag costs(List<DockyardRecipe.Ingredient> ingredients) {
        ListTag list = new ListTag();
        for (DockyardRecipe.Ingredient ingredient : ingredients) {
            CompoundTag entry = new CompoundTag();
            if (ingredient.tag() != null) entry.putString("Tag", ingredient.tag().location().toString());
            else entry.putString("Item", BuiltInRegistries.ITEM.getKey(ingredient.item()).toString());
            entry.putInt("Count", ingredient.amount());
            list.add(entry);
        }
        return list;
    }
}
