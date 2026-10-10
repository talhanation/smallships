package com.talhanation.smallships.api;

import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.WaterSpawnFinder;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.wind.Wind;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * The stable contract for NPC helmsmen of other mods (Recruits captain,
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
 * Every method accepts any entity and answers neutrally (false, 0, empty tag,
 * the unchanged delta) for one that is not a ship. All of it is server side.
 */
public final class ShipBridge {
    public static final int VERSION = 1;

    private ShipBridge() {}

    /* ---------------- recognition & state ---------------- */

    public static boolean isShip(@Nullable Entity entity) {
        return entity instanceof Ship;
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
     * How the ship IS RIGHT NOW - cheap enough to read every second. Keys:
     * <pre>
     * Damage, MaxHealth, HandRepairFloor           hull; hand repair stops at HandRepairFloor
     * SailHealth, SailMaxHealth, SailCondition     SailCondition: 0 intact, 1 torn, 2 destroyed
     * SailSpeedFactor                              1.0 / 0.75 / 0.0
     * MaxSpeedNow                                  blocks/tick incl. biome, cargo and cannon penalties
     * WindZone, WindStrength, WindMultiplier       zone: 0 head, 1 side, 2 tail; multiplier 1.0 with wind off
     * CannonBalls                                  balls of any type in the hold
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

        int balls = 0;
        if (s instanceof Container hold) {
            for (int i = 0; i < hold.getContainerSize(); i++) {
                ItemStack stack = hold.getItem(i);
                if (stack.getItem() instanceof CannonBallItem) balls += stack.getCount();
            }
        }
        tag.putInt("CannonBalls", balls);

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

    /* ---------------- repair: the players' prices and limits ---------------- */

    /** One hand repair, paid from the container: 1 iron nugget + 1 plank, up to the HandRepairFloor. */
    public static boolean repairHullByHand(@Nullable Entity ship, @Nullable Container payer) {
        return ship instanceof Ship s && payer != null && s.repairByHand(payer);
    }

    /** One sail patch, paid from the container: 1 string + 1 iron nugget, up to a third of the canvas. */
    public static boolean patchSails(@Nullable Entity ship, @Nullable Container payer) {
        return ship instanceof Ship s && payer != null && SailDamage.patchWith(s, payer);
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

    /* ---------------- geometry ---------------- */

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
}
