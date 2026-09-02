package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundUpdateShipControlPacket;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import com.talhanation.smallships.world.wind.Wind;
import com.talhanation.smallships.world.wind.WindManager;
import com.talhanation.smallships.client.wind.ClientWindManager;
import com.talhanation.smallships.client.camera.ShipCameraHandler;
import net.minecraft.server.level.ServerLevel;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityDimensions;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public abstract class Ship extends Boat {
    public static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ROT_SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> SAIL_STATE = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<String>  SAIL_COLOR = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<ItemStack> BANNER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.ITEM_STACK);
    /**
     * The banner projected onto the canvas, separate from the one on the staff.
     *
     * Two fields on purpose: a ship may fly its colours from the stern and
     * carry a different device on the sail, and the dockyard offers them as two
     * jobs. They used to share BANNER, which made one silently overwrite the
     * other.
     */
    public static final EntityDataAccessor<ItemStack> SAIL_BANNER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Float> CANNON_POWER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> CANNON_COUNT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> FORWARD = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BACKWARD = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SUNKEN = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    /**
     * True while a dockyard is working ON this ship. Synched, not transient
     * like the dockyard claim next to it: the client refuses to board and to
     * steer on its own, and it draws the work particles.
     */
    private static final EntityDataAccessor<Boolean> DOCKYARD_WORK = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    /** external push from a ramming, see ramShip. Synched because the ships' own
     *  drive is a scalar along the bow and cannot express a sideways shove. */
    private static final EntityDataAccessor<Float> IMPULSE_X = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> IMPULSE_Z = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<CompoundTag> SHIELD_DATA = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    /** Broadside aim data (Better Cannon Gameplay), see Cannonable. */
    public static final EntityDataAccessor<CompoundTag> CANNON_AIM = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    /** Sail health pool [0..100], see SailDamage. */
    public static final EntityDataAccessor<Float> SAIL_HEALTH = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    /** Installed dockyard upgrades, see ShipUpgrade. */
    public static final EntityDataAccessor<CompoundTag> UPGRADES = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    /** Occupied cannon slots (dockyard mounting), see Cannonable. */
    public static final EntityDataAccessor<CompoundTag> CANNON_SLOTS = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    /** Fixed seat assignments: Seat<id> -> passenger UUID, see Seatable. */
    public static final EntityDataAccessor<CompoundTag> SEAT_ASSIGNMENTS = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);

    /** live collision parts, server side only, see updateParts */
    private final List<ShipPartEntity> parts = new ArrayList<>();

    /*
     * ---- ramming -------------------------------------------------------
     *
     * Below the threshold nothing happens at all. Above it:
     *
     *     damage = BASE + (closing km/h - threshold) x PER_KMH
     *
     * That number is then split by weight - the lighter hull takes more of it,
     * up to double, the heavier one less. The crew takes a fixed share, and the
     * hit ship is thrown at the speed it was hit with. Nothing else.
     *
     * Speeds are in km/h, the unit the ships report to the player, so the
     * threshold can be checked against the readout on screen. A Cog at full
     * speed makes about 42 km/h; two of them head-on close at roughly 84.
     */

    /** below this closing speed the hulls just bump and nothing is spent */
    private static final double RAM_MIN_CLOSING_KMH = 25.0D;
    /**
     * The same bar for running aground, and lower on purpose. Another hull
     * gives way, takes part of the blow and carries some of it off; rock does
     * none of that, so a lesser knock already tells on the timbers.
     */
    private static final double CRASH_MIN_SPEED_KMH = 20.0D;
    /** damage every ram that counts deals, before the weight split */
    private static final float RAM_BASE_DAMAGE = 7.0F;
    /** further damage per km/h of closing speed above the threshold */
    private static final float RAM_DAMAGE_PER_KMH = 1.0F;
    /** share of the hull damage everyone aboard takes, thrown across the deck */
    private static final float RAM_CREW_DAMAGE_SHARE = 0.15F;

    /** ceiling on how hard a hull is thrown, in blocks per tick */
    private static final double RAM_MAX_SHOVE = 2.5D;
    /** how much of that throw survives each tick, so how far it carries */
    private static final float RAM_DECAY = 0.9F;

    /**
     * How far a ship has to get from the spot it last rammed at before the next
     * ram counts, in blocks.
     *
     * A fixed point, not the other ship: a target that is right in front of you
     * is by definition close, so a distance TO IT can never clear and the block
     * would hold forever. Not a timer either - the drive is back within a
     * second, so a cooldown only throttles grinding against a hull already
     * touched. This says what it should: break off, come about, run in again.
     */
    private static final double RAM_REARM_DISTANCE = 10.0D;
    /**
     * Share of the wanted movement that has to survive the collision test for
     * the way to count as free. Running into a cliff stops a ship dead;
     * brushing along a quay is not an impact.
     */
    private static final double OBSTACLE_STOP_FRACTION = 0.0625D;
    /**
     * Ticks the drive stays shut off in the direction that hit something.
     * Without it the ship would stop, be free again the next tick because it
     * has no way on, accelerate, hit, stop - grinding its way along a wall.
     */
    private static final int OBSTACLE_HOLD_TICKS = 10;

    /**
     * Fixed manoeuvring speed in blocks per tick, ahead and astern alike, and
     * deliberately NOT derived from maxSpeed: warping into a berth or working
     * a wedged hull free should take the same patience on every ship.
     */
    private static final float MANOEUVRE_SPEED = 0.03F;

    /** Server side: where this ship last rammed, see RAM_REARM_DISTANCE. */
    @Nullable private Vec3 ramRearmPos;
    /** ticks left of the drive block after an impact, see OBSTACLE_HOLD_TICKS */
    private int obstructedTicks;
    /** which way was blocked: +1 ahead, -1 astern, 0 nothing */
    private int obstructedDirection;

    private int blockerTick = -1;
    private AABB blockerArea;
    private List<VoxelShape> blockerCache;
    private boolean isLocked = false;
    private int sunkenTime = 0;
    private float prevWaveAngle;
    private float waveAngle;
    public float prevBannerWaveAngle;
    public float bannerWaveAngle;
    protected boolean cannonKeyPressed;
    public int sailStateCooldown = 0;
    private float setPoint;
    public final List<ShipCannon> CANNONS = new ArrayList<>();
    public final Stack<ItemStack> SHIELDS = new Stack<>();
    public float maxSpeed;

    /**
     * The configured maxSpeed attribute is a readability number, not a
     * speed: the physics run on blocks per tick. Everything that shows a
     * speed to the player has to go through here first, or the dockyard
     * and the ship inventory print two different numbers for one hull.
     */
    public static final float SPEED_ATTRIBUTE_DIVISOR = 60F * 1.15F;

    public static float toTickSpeed(float attributeSpeed) {
        return attributeSpeed / SPEED_ATTRIBUTE_DIVISOR;
    }
    private CameraType previousCameraType;

    public Ship(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
        if (this.getCustomName() == null) this.setCustomName(Component.literal(StringUtils.capitalize(EntityType.getKey(this.getType()).getPath())));
    }

    @Override
    public void tick() {
        // seat system: clean up assignments of passengers that left (server, every second)
        if (this instanceof Seatable seatable && !this.level().isClientSide() && this.tickCount % 20 == 0) {
            seatable.validateSeatAssignments();
        }
        // Vanilla Boat.tick() heals the hull by one point per tick. A ship
        // never heals itself - the hull is repaired by hand or at the dockyard
        // and nowhere else - so the value is taken here and put straight back
        // afterwards. This used to be an "+ 1.0F" further down that happened to
        // cancel the vanilla "- 1.0F" out; restoring the exact value instead
        // means neither number can silently start healing ships again, and a
        // single point of damage no longer decays to nothing.
        float hullDamageBeforeVanillaTick = this.getDamage();
        super.tick();
        if (this.getDamage() != hullDamageBeforeVanillaTick) this.setDamage(hullDamageBeforeVanillaTick);

        if (!this.level().isClientSide() && (this.parts.isEmpty() || this.tickCount % 20 == 0)) this.updateParts();

        this.tickObstacleContact();

        if (!this.level().isClientSide()) {
            this.tickRam();
            this.decayRamImpulse();
        }


        // The flag is refreshed by the working dockyard every second. If that
        // stops - block broken, chunk unloaded, task lost on a crash - the ship
        // frees itself instead of staying a locked building site forever.
        if (!this.level().isClientSide() && this.isInDockyardWork()
                && this.level().getGameTime() - this.dockyardWorkTime > 40L) {
            this.setDockyardWork(false);
        }

        // work particles, the same the dockyard block throws while it runs
        if (this.isInDockyardWork() && this.level() instanceof ServerLevel workLevel && this.tickCount % 10 == 0) {
            workLevel.sendParticles(ParticleTypes.CRIT, this.getX(), this.getY() + 1.5D, this.getZ(),
                    5, this.getBbWidth() * 0.5D, 0.6D, this.getBbWidth() * 0.5D, 0.01D);
        }

        if(isSunken()){
            if(++this.sunkenTime > SmallShipsConfig.Server.shipGeneralDespawnTimeSunken.get()*20*60) this.destroy(this.getCommandSenderWorld().damageSources().drown());
            else this.setDeltaMovement (getDeltaMovement().x, - 0.2D, getDeltaMovement().z);
        }
        else {
            if (this instanceof Sailable sailShip) sailShip.tickSailShip();
            if (this instanceof Bannerable bannerShip) bannerShip.tickBannerShip();
            if (this instanceof Cannonable cannonShip) cannonShip.tickCannonShip();
            if (this instanceof Paddleable paddleShip) paddleShip.tickPaddleShip();
            if (this instanceof Shieldable shieldShip) shieldShip.tickShieldShip();
            if (this instanceof IceBreakable iceBreakable) iceBreakable.tickIceBreakable();

            boolean isCruising = (getSpeed() > 0.085F || getSpeed() < -0.085F);
            this.updateShipAmbience(isCruising);
            this.updateCollision(isCruising);
            this.updateWaveAngle();
            this.updateWaterMobs();
            this.floatUp();
            if(outOfControlTicks > 0) --this.outOfControlTicks;
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);

        builder.define(SPEED, 0.0F);
        builder.define(ROT_SPEED, 0.0F);
        builder.define(FORWARD, false);
        builder.define(BACKWARD, false);
        builder.define(LEFT, false);
        builder.define(RIGHT, false);
        builder.define(SUNKEN, false);
        builder.define(DOCKYARD_WORK, false);
        builder.define(IMPULSE_X, 0.0F);
        builder.define(IMPULSE_Z, 0.0F);

        // Sailable
        builder.define(SAIL_STATE, (byte) 0);
        builder.define(Ship.SAIL_COLOR, SailModel.Color.WHITE.toString());

        // Bannerable
        builder.define(Ship.BANNER, ItemStack.EMPTY);
        builder.define(Ship.SAIL_BANNER, ItemStack.EMPTY);

        // Cannonable
        builder.define(Ship.CANNON_POWER, 4.0F);
        builder.define(Ship.CANNON_COUNT, (byte) 0);

        // Shieldable
        builder.define(Ship.SHIELD_DATA, new CompoundTag());

        // Cannon aim (Better Cannon Gameplay)
        builder.define(Ship.CANNON_AIM, new CompoundTag());

        // Sail damage
        // The real maximum, not a placeholder. getParts is a static list per
        // ship class, so it answers correctly even this early - and a two masted
        // hull seeded with one sails' worth would sit exactly ON the torn
        // threshold and show up with shredded canvas the moment it is built.
        builder.define(Ship.SAIL_HEALTH, SailDamage.getMaxHealth(this));

        // Dockyard upgrades
        builder.define(Ship.UPGRADES, new CompoundTag());

        // Cannon slots
        builder.define(Ship.CANNON_SLOTS, new CompoundTag());

        // Seat assignments
        builder.define(Ship.SEAT_ASSIGNMENTS, new CompoundTag());
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);

        if (this instanceof Sailable sailShip) sailShip.readSailShipSaveData(tag);
        if (this instanceof Bannerable bannerShip) bannerShip.readBannerShipSaveData(tag);
        if (this instanceof Cannonable cannonShip) cannonShip.readCannonShipSaveData(tag);
        if (this instanceof Shieldable shieldShip) shieldShip.readShieldShipSaveData(tag);

        // hull damage: vanilla Boat keeps this in synched data only and never
        // writes it, so a damaged ship used to come back whole after a restart
        if (tag.contains("HullDamage")) this.setDamage(tag.getFloat("HullDamage"));

        this.setSunken(tag.getBoolean("Sunken"));
        this.isLocked = (tag.getBoolean("locked"));
        if (tag.contains("Upgrades")) this.setData(UPGRADES, tag.getCompound("Upgrades"));
        if (this instanceof Seatable && tag.contains("SeatAssignments")) this.setData(SEAT_ASSIGNMENTS, tag.getCompound("SeatAssignments"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        if (this instanceof Sailable sailShip) sailShip.addSailShipSaveData(tag);
        if (this instanceof Bannerable bannerShip) bannerShip.addBannerShipSaveData(tag);
        if (this instanceof Cannonable cannonShip) cannonShip.addCannonShipSaveData(tag);
        if (this instanceof Shieldable shieldShip) shieldShip.addShieldShipSaveData(tag);

        tag.putFloat("HullDamage", this.getDamage());
        tag.putBoolean("Sunken", isSunken());
        tag.putBoolean("locked", this.isLocked);
        tag.put("Upgrades", this.getData(UPGRADES));
        if (this instanceof Seatable) tag.put("SeatAssignments", this.getData(SEAT_ASSIGNMENTS));
    }

    public void onAboveBubbleCol(boolean bl) {
        if (!this.level().isClientSide) {
            this.isAboveBubbleColumn = true;
            this.bubbleColumnDirectionIsDown = bl;
            if (this.getBubbleTime() == 0) {
                this.setBubbleTime(1200);
            }
        }

        this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double)this.random.nextFloat(), this.getY() + 0.7, this.getZ() + (double)this.random.nextFloat(), 0.0, 0.0, 0.0);
        if (this.random.nextInt(20) == 0) {
            this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), this.getSwimSplashSound(), this.getSoundSource(), 1.0F, 0.8F + 0.4F * this.random.nextFloat(), false);
            this.gameEvent(GameEvent.SPLASH, this.getControllingPassenger());
        }

    }

    public <T> T getData(EntityDataAccessor<T> accessor) {
        return this.getEntityData().get(accessor);
    }

    @Override
    public boolean canAddPassenger(Entity entity) {
        return super.canAddPassenger(entity) && !(entity instanceof Ship) && !SmallShipsConfig.Server.mountBlackList.get().contains(entity.getEncodeId()) && !this.isLocked() && this.getPassengers().size() < this.getMaxPassengers() && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && this.hasFreeSeatFor(entity);
    }

    /**
     * @return whether there is a station left for this entity. Refusing here is
     * the only correct answer: boarding without a seat leaves the passenger
     * unassigned, and an unassigned passenger is drawn at the default attachment
     * point - which is how a crew ends up piled on one spot.
     */
    public boolean hasFreeSeatFor(Entity entity) {
        if (this.isInDockyardWork()) return false;
        if (!(this instanceof Seatable seatable)) return true;
        return seatable.findNearestFreeSeat(entity.position(), this.canDrive(entity)) != null;
    }

    /**
     * @return whether this entity may take the helm. Players always may; every
     * other entity has to be listed in the driverEntities config, which is how
     * a Recruits captain gets to steer without this class knowing that mod.
     */
    public boolean canDrive(Entity entity) {
        if (this.isInDockyardWork()) return false;
        if (entity instanceof Player) return true;
        String id = entity.getEncodeId();
        return id != null && SmallShipsConfig.Server.driverEntities.get().contains(id);
    }

    /**
     * Everything standing on this ship that could be taken aboard.
     *
     * Vanilla only looks at the entity bounding box, and for a ship that box is
     * a fraction of its deck - a mob standing on the forecastle was simply never
     * seen. The hull parts cover the real footprint, so they are searched too.
     * Masts are left out: nobody boards by climbing the rigging.
     */
    public List<Entity> getBoardingCandidates() {
        List<AABB> areas = new ArrayList<>();
        areas.add(this.getBoundingBox().inflate(0.2D, -0.01D, 0.2D));
        for (ShipPartEntity.Definition definition : this.getParts()) {
            if (definition.mast()) continue;
            areas.add(definition.boxAt(this.getX(), this.getY(), this.getZ(), this.getYRot()).inflate(0.2D, -0.01D, 0.2D));
        }

        AABB envelope = areas.get(0);
        for (AABB area : areas) envelope = envelope.minmax(area);

        List<Entity> candidates = new ArrayList<>();
        for (Entity entity : this.level().getEntities(this, envelope, EntitySelector.pushableBy(this))) {
            for (AABB area : areas) {
                if (area.intersects(entity.getBoundingBox())) {
                    candidates.add(entity);
                    break;
                }
            }
        }
        return candidates;
    }

    public <T> void setData(EntityDataAccessor<T> accessor, T value) {
        this.getEntityData().set(accessor, value);
    }

    @Override
    protected void controlBoat() {
        Attributes attributes = this.getAttributes();
        // PENALTIES only: biome, cargo and cannons can never push a ship above
        // its configured max speed, they only cut into it. This product is the
        // hard ceiling for everything below.
        float speedPenalty =
                (1 + (this.getBiomeModifier()/100)) *
                        (1 - (this instanceof Cannonable cannonShip? cannonShip.getCannonModifier()/100 : 0.0F)) *
                        (1 - (this instanceof ContainerShip containerShip && containerShip.isEffectedByCargoPenalty() ? containerShip.getContainerModifier()/100 : 0.0F));

        this.maxSpeed = toTickSpeed(attributes.maxSpeed) * speedPenalty;
        float maxRotSp = (attributes.maxRotationSpeed * 0.1F + 1.8F);
        float acceleration = attributes.acceleration;
        float rotAcceleration = attributes.rotationAcceleration;

        //SmallShipsMod.LOGGER.info("Speed kmh: " +  Kalkuel.getKilometerPerHour(this.getSpeed()));

        if(this.level().isClientSide() && !this.isSunken()){

            Player player = getDriver();
            if(player != null)
                updateControls(((BoatAccessor) this).isInputUp(),((BoatAccessor) this).isInputDown(), ((BoatAccessor) this).isInputLeft(), ((BoatAccessor) this).isInputRight(), player);
        }

        if(this.isInWater() && !this.isShipLeashed() && !this.isSunken() && !isLocked()){
            // propulsion from canvas: linear in the sail state, scaled by sail
            // damage and by the wind zone the ship is currently in
            float sailDrive = 0.0F;
            if (this instanceof Sailable sailShip) {
                sailDrive = this.maxSpeed * (sailShip.getSailState() / 4.0F)
                        * SailDamage.getSpeedFactor(this) * this.getWindModifier();
            }

            // oars are a wind independent floor, not a bonus: they carry the
            // ship when the sails cannot, but never beyond the ceiling
            float oarDrive = 0.0F;
            if (this instanceof Paddleable && this.isForward() && this.getDriver() != null) {
                oarDrive = this.maxSpeed * this.getOarFactor();
            }

            setPoint = Math.min(Math.max(sailDrive, oarDrive), this.maxSpeed);

            // light manoeuvring gears, ahead and astern. This is oars, poles
            // and patience, not a second sail - so it only exists with the
            // canvas furled, otherwise it would read as braking against the
            // wind. Ahead it is a FLOOR, never an override, or it would cut
            // into an oar drive that is already faster.
            if (this.getDriver() != null && this.canManoeuvre()) {
                if (this.isBackward()) setPoint = -MANOEUVRE_SPEED;
                else if (this.isForward()) setPoint = Math.max(setPoint, MANOEUVRE_SPEED);
            }

            this.calculateSpeed(acceleration);

            //CALCULATE ROTATION SPEED//
            //((BoatAccessor) this).setDeltaRotation(0); // IDK WHAT THIS IS FOR BUT IT WORKS WITHOUT IT
            float rotationSpeed = Kalkuel.subtractToZero(getRotSpeed(), getVelocityResistance() * 2.5F);


            if (isRight()) {
                if (rotationSpeed < maxRotSp) {
                    rotationSpeed = Math.min(rotationSpeed + rotAcceleration * 1 / 8, maxRotSp);
                }
            }

            if (isLeft()) {
                if (rotationSpeed > -maxRotSp) {
                    rotationSpeed = Math.max(rotationSpeed - rotAcceleration * 1 / 8, -maxRotSp);
                }
            }
            this.setRotSpeed(rotationSpeed);

            ((BoatAccessor) this).setDeltaRotation(rotationSpeed);
            // turning collides too: vanilla never tests a rotation against
            // anything, so a hull would swing its bow straight through a cliff
            float wantedYaw = getYRot() + ((BoatAccessor) this).getDeltaRotation();
            float allowedYaw = ShipPartEntity.collideTurn(this, getYRot(), wantedYaw);
            if (allowedYaw != wantedYaw) {
                this.setRotSpeed(0.0F);
                ((BoatAccessor) this).setDeltaRotation(0.0F);
            }
            setYRot(allowedYaw);


            if(getDriver() != null) {
                if (this instanceof Sailable sailShip) sailShip.controlBoatSailShip();
                if (this instanceof Paddleable paddleShip) paddleShip.controlBoatPaddleShip();
            }
            //SET
            setDeltaMovement(Kalkuel.calculateMotionX(this.getSpeed(), this.getYRot()), getDeltaMovement().y, Kalkuel.calculateMotionZ(this.getSpeed(), this.getYRot()));
        }
        else {
            setForward(false);
            setBackward(false);
            setLeft(false);
            setRight(false);
        }

        // the ram push is added on top of the drive, never folded into
        // getSpeed(): that one is a scalar along the bow and would turn a
        // sideways shove into forward motion
        setDeltaMovement(getDeltaMovement().add(this.getData(IMPULSE_X), 0.0D, this.getData(IMPULSE_Z)));
    }

    /**
     * @return the current global wind, taken from the server WindManager or
     * the client mirror depending on the side.
     */
    public Wind getWind() {
        if (this.level() instanceof ServerLevel serverLevel) {
            return WindManager.get(serverLevel).getWind();
        }
        return ClientWindManager.getWind();
    }

    /* ---------------- wind profile ---------------- */

    /**
     * Wind multiplier when the wind comes from ahead. The three zone
     * multipliers of a ship always sum to 3.0, so wind redistributes a ship's
     * strength instead of adding a hidden power axis. Override per ship class.
     */
    public float getHeadWindMultiplier() {
        return 1.0F;
    }

    /** Wind multiplier when the wind comes from the side. See getHeadWindMultiplier. */
    public float getSideWindMultiplier() {
        return 1.0F;
    }

    /** Wind multiplier when the wind comes from astern. See getHeadWindMultiplier. */
    public float getTailWindMultiplier() {
        return 1.0F;
    }

    /**
     * The fraction of max speed this ship reaches under oars alone. Oars are a
     * wind INDEPENDENT emergency drive: they let a ship make way with furled
     * sails, but they can never push it past its max speed. 0 = no oars.
     * Override in oar driven ship classes.
     */
    public float getOarFactor() {
        return 0.0F;
    }

    /** @return the raw wind multiplier of the zone the ship is currently in. */
    public float getWindMultiplier() {
        return switch (this.getWind().getZone(this.getYRot())) {
            case HEAD_WIND -> this.getHeadWindMultiplier();
            case SIDE_WIND -> this.getSideWindMultiplier();
            case TAIL_WIND -> this.getTailWindMultiplier();
        };
    }

    /**
     * @return the effective wind speed modifier for this ship. The raw zone
     * multiplier is faded towards the neutral 1.0 by both the wind strength and
     * the open sail area, because wind can only act on canvas that is actually
     * set:
     *
     *   effective = 1 + (zoneMultiplier - 1) * strength * (sailState / 4)
     *
     * With furled sails (state 0) the result is always 1.0 - the ship takes no
     * head wind penalty and gets no tail wind bonus, and can reach its full max
     * speed under oars. Reefing step by step reduces a head wind penalty
     * proportionally, because the ship offers the wind less area to grab.
     */
    public float getWindModifier() {
        if (!SyncedServerConfig.windEnable()) return 1.0F;
        if (!(this instanceof Sailable sailable)) return 1.0F;

        float sailFactor = sailable.getSailState() / 4.0F;
        if (sailFactor <= 0.0F) return 1.0F;

        Wind wind = this.getWind();
        return 1.0F + (this.getWindMultiplier() - 1.0F) * wind.strength() * sailFactor;
    }


    /* ---------------- dockyard claim: only ONE dockyard may service a ship ---------------- */

    /** transient, server side: the dockyard currently working on this ship */
    @Nullable
    private BlockPos servicingDockyardPos;
    private long servicingDockyardTime;

    /** Called by the working dockyard on task start and refreshed every second. */
    public void setServicingDockyard(BlockPos pos) {
        this.servicingDockyardPos = pos;
        this.servicingDockyardTime = this.level().getGameTime();
    }

    /** Called by the dockyard when its task on this ship finishes or aborts. */
    public void clearServicingDockyard(BlockPos pos) {
        if (pos.equals(this.servicingDockyardPos)) {
            this.servicingDockyardPos = null;
        }
    }

    /**
     * @return true if ANOTHER dockyard is currently working on this ship.
     * The claim expires 2 seconds after the last refresh, so it survives no
     * restarts stale (the working dockyard re-claims every second).
     */
    public boolean isServicedByOtherDockyard(BlockPos requester) {
        if (this.servicingDockyardPos == null || this.servicingDockyardPos.equals(requester)) return false;
        return this.level().getGameTime() - this.servicingDockyardTime < 40L;
    }

    public boolean isLocked(){
        return isLocked;
    }
    public boolean isShipLeashed(){
        return this.isLeashed();
    }
    private void calculateSpeed(float acceleration) {
        // If there is no interaction the speed should get reduced
        float speed = this.getSpeed();
        // A hull pressed against blocks makes no way, so the drive must not
        // wind up behind it either - otherwise a player could sit against a
        // cliff at full sail and charge a ram he never sailed for.
        if (this.isDriveBlocked(setPoint)) setPoint = 0.0F;
        if(speed < setPoint){
            // clamped: addToSetPoint overshoots by a full acceleration step,
            // which is nothing at full sail but almost half the manoeuvring
            // speed - and that one is supposed to be an exact figure
            speed = Math.min(Kalkuel.addToSetPoint(speed, acceleration, setPoint), setPoint);
        }
        else if (setPoint < 0.0F) {
            // reverse needs its own ramp: subtractToZero only ever pulls
            // towards zero and can never push a ship backwards
            speed = Math.max(speed - acceleration, setPoint);
        }
        else
            speed = Kalkuel.subtractToZero(speed, getVelocityResistance() * 0.8F);

        if (isLeft() || isRight()) { // Speed decrease when rotating
            speed = speed * (1F - (Mth.abs(getRotSpeed()) * 0.02F));
        }

        this.setSpeed(speed);
    }

    public CompoundTag getShieldData() {
        return entityData.get(SHIELD_DATA);
    }
    public void setShieldData(CompoundTag f) {
        this.entityData.set(SHIELD_DATA, f);
    }

    public float getSpeed() {
        return entityData.get(SPEED);
    }
    public float getRotSpeed() {
        return entityData.get(ROT_SPEED);
    }
    public void setSpeed(float f) {
        this.entityData.set(SPEED, f);
    }
    public void setRotSpeed(float f) {
        this.entityData.set(ROT_SPEED, f);
    }

    public void setForward(boolean forward) {
        entityData.set(FORWARD, forward);
    }

    public void setBackward(boolean backward ) {
        entityData.set(BACKWARD, backward);
    }

    public void setLeft(boolean left) {
        entityData.set(LEFT, left);
    }

    public void setRight(boolean right) {
        entityData.set(RIGHT, right);
    }

    public boolean isForward() {
        if (this.getControllingPassenger() == null) {
            return false;
        }
        return entityData.get(FORWARD);
    }

    public boolean isBackward() {
        if (this.getControllingPassenger() == null) {
            return false;
        }
        return entityData.get(BACKWARD);
    }

    public boolean isLeft() {
        return entityData.get(LEFT);
    }

    public boolean isRight() {
        return entityData.get(RIGHT);
    }

    public float getBiomeModifier() {
        BiomeModifierType shipBiomeType = this.getBiomeModifierType();
        if (shipBiomeType == BiomeModifierType.NONE) return 0.0F;

        BlockPos pos = new BlockPos((int)this.getX(), (int)this.getY(), (int)this.getZ());
        int tmp = this.getCommandSenderWorld().getBiome(pos).value().getWaterColor();
        float modifier = SmallShipsConfig.Server.shipGeneralBiomeModifier.get().floatValue();

        boolean coldBiomes = tmp < 4100000;
        boolean warmBiomes = tmp > 4300000;
        boolean neutralBiomes = !coldBiomes && !warmBiomes;


        boolean coldType = shipBiomeType == BiomeModifierType.COLD;
        boolean neutralType = shipBiomeType == BiomeModifierType.NEUTRAL;;
        boolean warmType = shipBiomeType == BiomeModifierType.WARM;;

        if (coldBiomes && coldType || warmBiomes && warmType || neutralBiomes && neutralType) {
            return modifier;
        } else if (
                (coldBiomes && warmType || warmBiomes && coldType) || ((coldBiomes || warmBiomes) && neutralType)) {
            return -modifier;
        } else if (neutralBiomes && warmType || neutralBiomes && coldType) {
            return -modifier/4;
        } else
            return 0;

    }

    /**
     * Seat system: vanilla passes the exact hit position on the hitbox here.
     * - Riding this ship + empty hand: switch to the nearest free seat at the click point.
     * - Not riding: remember the hit so addPassenger assigns the nearest seat to it.
     */
    @Override
    public @NotNull InteractionResult interactAt(@NotNull Player player, @NotNull Vec3 hitVec, @NotNull InteractionHand interactionHand) {
        // hands off while the dockyard has her: no boarding, no seat switching,
        // no repairing or dyeing behind the shipwrights' back
        if (this.isInDockyardWork()) return InteractionResult.PASS;
        if (this instanceof Seatable seatable && !this.isLocked()) {
            Vec3 worldHit = this.position().add(hitVec);
            if (player.getVehicle() == this) {
                // seat switch while riding (empty hand only, so item use is not hijacked)
                if (player.getItemInHand(interactionHand).isEmpty()) {
                    if (!this.level().isClientSide()) {
                        ShipSeat target = seatable.findNearestFreeSeat(worldHit, true);
                        if (target != null && !target.equals(seatable.getSeatOf(player))) {
                            seatable.assignSeat(player, target.id());
                            // repositioning happens automatically in the next tick
                        }
                    }
                    return InteractionResult.sidedSuccess(this.level().isClientSide());
                }
            } else if (!this.level().isClientSide()) {
                // remember the click point for the seat assignment in addPassenger
                this.pendingSeatHit = worldHit;
                this.pendingSeatHitFor = player.getUUID();
            }
        }
        return super.interactAt(player, hitVec, interactionHand);
    }

    /** transient, server side: hit position of the mounting right click */
    @Nullable
    private Vec3 pendingSeatHit;
    @Nullable
    private java.util.UUID pendingSeatHitFor;

    /**
     * Where the passenger that is currently getting off was sitting.
     *
     * Needed because LivingEntity#stopRiding frees the seat before it asks for a
     * dismount position: removePassenger runs first, dismountVehicle only after.
     * Same single slot pattern as pendingSeatHit above - the two calls happen in
     * one synchronous stack, so a second passenger cannot get in between.
     */
    private Vec3 dismountSeat;
    private java.util.UUID dismountSeatFor;

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if(!this.isLocked()){
            if(this.interactWithNameTag(player)) return InteractionResult.SUCCESS;
            if(this.interactIronNuggets(player)) return InteractionResult.SUCCESS;
            // cannon mounting moved to the dockyard (no field mounting anymore)
            if (this instanceof Sailable sailShip && sailShip.interactSail(player, interactionHand)) return InteractionResult.SUCCESS;
            if (this instanceof Bannerable bannerShip && bannerShip.interactBanner(player, interactionHand)) return InteractionResult.SUCCESS;
            if (this instanceof Shieldable shieldShip && shieldShip.interactShield(player, interactionHand)) return InteractionResult.SUCCESS;
            return super.interact(player, interactionHand);
        }
        else return InteractionResult.PASS;
    }

    private boolean interactWithNameTag(@NotNull Player player){
        if (player.getMainHandItem().is(Items.NAME_TAG) && player.getMainHandItem().has(DataComponents.CUSTOM_NAME) && !player.getCommandSenderWorld().isClientSide){
            this.setCustomName(player.getMainHandItem().getHoverName());
            this.setCustomNameVisible(false);
            if(!player.isCreative()) player.getMainHandItem().shrink(1);
            return true;
        }
        return false;
    }

    private boolean interactIronNuggets(@NotNull Player player){
        if (this.getDamage() > 0 && player.getMainHandItem().is(Items.IRON_NUGGET) && player.getInventory().hasAnyMatching(stack -> stack.is(ItemTags.PLANKS))){

            this.repairShip((5 + this.level().random.nextInt(5)));

            if(!player.isCreative()){
                player.getMainHandItem().shrink(1);

                for(int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                    ItemStack itemStack = player.getInventory().getItem(i);
                    if (itemStack.is(ItemTags.PLANKS)) {
                        itemStack.shrink(1);
                        break;
                    }
                }
            }

            return true;
        }
        return false;
    }

    public void repairShip(int repairAmount){
        this.getCommandSenderWorld().playSound(null, this.getX(), this.getY() + 1, this.getZ(), SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1F, 0.9F + 0.2F * this.getCommandSenderWorld().getRandom().nextFloat());
        this.getCommandSenderWorld().playSound(null, this.getX(), this.getY() + 2, this.getZ(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1F, 0.9F + 0.2F * this.getCommandSenderWorld().getRandom().nextFloat());

        float newDamage = this.getDamage() - repairAmount;
        if(newDamage < 0) newDamage = 0;
        this.setDamage(newDamage);
    }


    /**
     * Seat system: passengers are positioned by their FIXED seat assignment,
     * never by their index in the passenger list.
     */
    @Override
    public @NotNull Vec3 getPassengerAttachmentPoint(@NotNull Entity entity, @NotNull EntityDimensions dimensions, float partialTick) {
        if (this instanceof Seatable seatable) {
            ShipSeat seat = seatable.getSeatOf(entity);
            if (seat != null) {
                return seat.getAttachmentPoint(this, dimensions);
            }
            // not yet assigned (first tick / edge case): center of the deck
            return new Vec3(1.5F, dimensions.height() - 0.1, 0.0F)
                    .yRot(-this.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
        }
        return super.getPassengerAttachmentPoint(entity, dimensions, partialTick);
    }

    /**
     * Puts a passenger off at HIS SEAT instead of at the middle of the ship.
     *
     * Vanilla only ever looks for a BLOCK to stand on: Boat gives up as soon as
     * there is water under the deck, and Entity#getDismountLocationForPassenger
     * then returns the vehicle centre - which is why a whole crew used to pile up
     * on the same spot amidships.
     */
    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        if (this instanceof Sailable sailShip && sailShip.getSailState() != 0) sailShip.toggleSail();

        Vec3 seatPosition = null;
        if (livingEntity.getUUID().equals(this.dismountSeatFor) && this.dismountSeat != null) {
            seatPosition = this.dismountSeat;
        } else if (this instanceof Seatable seatable) {
            ShipSeat seat = seatable.getSeatOf(livingEntity);
            if (seat != null) seatPosition = seat.getWorldPosition(this);
        }
        this.dismountSeat = null;
        this.dismountSeatFor = null;

        if (seatPosition != null) {
            Vec3 spot = this.findSeatDismountSpot(livingEntity, seatPosition);
            // no solid ground next to the seat - the normal case out at sea.
            // Leave them over their own seat anyway: the hull parts carry them
            // while the ship lies still, and dropping into the water beside
            // their station beats being teleported amidships.
            return spot != null ? spot : new Vec3(seatPosition.x, this.getBoundingBox().maxY + 1.5, seatPosition.z);
        }
        return super.getDismountLocationForPassenger(livingEntity);
    }

    /**
     * @return a safe place to stand at the seats' own x/z, or null if there is
     * none. Same floor and pose checks vanilla runs, only anchored on the seat
     * rather than on the hull centre.
     */
    @Nullable
    private Vec3 findSeatDismountSpot(LivingEntity livingEntity, Vec3 seatPosition) {
        BlockPos at = BlockPos.containing(seatPosition.x, this.getBoundingBox().maxY, seatPosition.z);
        BlockPos below = at.below();
        if (this.level().isWaterAt(below)) return null;

        List<Vec3> candidates = new ArrayList<>();
        double floor = this.level().getBlockFloorHeight(at);
        if (DismountHelper.isBlockFloorValid(floor)) candidates.add(new Vec3(seatPosition.x, at.getY() + floor, seatPosition.z));
        double floorBelow = this.level().getBlockFloorHeight(below);
        if (DismountHelper.isBlockFloorValid(floorBelow)) candidates.add(new Vec3(seatPosition.x, below.getY() + floorBelow, seatPosition.z));

        for (Pose pose : livingEntity.getDismountPoses()) {
            for (Vec3 candidate : candidates) {
                if (DismountHelper.canDismountTo(this.level(), candidate, livingEntity, pose)) {
                    livingEntity.setPose(pose);
                    return candidate;
                }
            }
        }
        return null;
    }

    @Override
    protected void addPassenger(Entity entity) {
        // Auto third person: Enable
        if (this.level().isClientSide() && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get() && Objects.equals(Minecraft.getInstance().player, entity)) {
            this.previousCameraType = Minecraft.getInstance().options.getCameraType();
            Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
        }
        // Better Ship Camera: smoothly move the camera anchor to the ship center,
        // keeping the direction the player was facing when right-clicking (aim and align)
        if (this.level().isClientSide() && Objects.equals(Minecraft.getInstance().player, entity)) {
            ShipCameraHandler.startTransition();
        }
        super.addPassenger(entity);

        // seat system: assign the fixed seat (never index based)
        if (this instanceof Seatable seatable && !this.level().isClientSide() && seatable.getSeatOf(entity) == null) {
            Vec3 from = entity.position();
            if (entity.getUUID().equals(this.pendingSeatHitFor) && this.pendingSeatHit != null) {
                from = this.pendingSeatHit;
            }
            this.pendingSeatHit = null;
            this.pendingSeatHitFor = null;
            ShipSeat seat = seatable.findNearestFreeSeat(from, this.canDrive(entity));
            if (seat != null) seatable.assignSeat(entity, seat.id());
        }
    }

    @Override
    protected void removePassenger(Entity entity) {
        if (this instanceof Seatable seatable && !this.level().isClientSide()) {
            // remember the station BEFORE giving it up, see dismountSeat
            ShipSeat seat = seatable.getSeatOf(entity);
            if (seat != null) {
                this.dismountSeat = seat.getWorldPosition(this);
                this.dismountSeatFor = entity.getUUID();
            }
            seatable.freeSeatOf(entity);
        }
        // Auto third person: Disable
        if (this.level().isClientSide() && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get() && Objects.equals(Minecraft.getInstance().player, entity)) {
            Minecraft.getInstance().options.setCameraType(this.previousCameraType);
        }
        super.removePassenger(entity);
    }

    /**
     * A ship on the stocks is a building site: nobody climbs aboard, nobody
     * takes the helm, and the work is visible from the outside. Set by the
     * dockyard when a task starts and cleared when it ends.
     */
    /** server side: when the working dockyard last refreshed the flag */
    private long dockyardWorkTime;

    public void setDockyardWork(boolean working) {
        if (working) this.dockyardWorkTime = this.level().getGameTime();
        if (this.isInDockyardWork() != working) this.entityData.set(DOCKYARD_WORK, working);
    }

    public boolean isInDockyardWork() {
        return this.entityData.get(DOCKYARD_WORK);
    }

    public void setSunken(boolean sunken){
        this.entityData.set(SUNKEN, sunken);
    }
    public boolean isSunken(){
        return this.entityData.get(SUNKEN);
    }

    private void updateWaveAngle(){
        this.prevWaveAngle = this.waveAngle;
        this.waveAngle = (float) Math.sin(getWaveSpeed() * (float) this.tickCount) * getWaveFactor();
    }

    private float getWaveFactor() {
        return this.level().isRaining() ? 3F : 1.25F;
    }

    private float getWaveSpeed() {
        return this.level().isRaining() ? 0.12F : 0.03F;
    }

    public float getWaveAngle(float partialTicks) {
        return Mth.lerp(partialTicks, this.prevWaveAngle, this.waveAngle);
    }

    /**
     * Read fresh from the config on every call instead of from a copy taken
     * when the ship was built. That copy was the reason a changed config only
     * ever reached newly placed ships - now one global setting moves the whole
     * fleet, loaded chunks included, without a migration or a reset command.
     */
    public Attributes getAttributes() {
        Attributes attributes = this.getConfiguredAttributes().read();
        ShipUpgrade.applyAll(this, attributes);
        return attributes;
    }

    /**
     * What one upgrade costs on THIS hull. A galleon needs far more plating
     * than a dhow, so the price is stated by the ship and not by the upgrade.
     */
    private static final Map<ShipUpgrade, Integer> DEFAULT_UPGRADE_COSTS = Map.of(
            ShipUpgrade.IRON_SCANTLINGS, 4,
            ShipUpgrade.COTTON_SAILS, 4,
            ShipUpgrade.COPPER_PLATING, 4
    );

    /**
     * @return how many units of its material each upgrade costs on this ship.
     * Override with a static map of your own; an upgrade left out of the map
     * falls back to {@link ShipUpgrade#getDefaultCost()}, so a new upgrade
     * never breaks an existing ship - not even one from an addon.
     */
    public Map<ShipUpgrade, Integer> getUpgradeCosts() {
        return DEFAULT_UPGRADE_COSTS;
    }

    /**
     * @return how much material this upgrade costs on this ship, 0 if the ship
     * does not offer it at all. The config modifier never turns a real price
     * into 0, so switching an upgrade off stays a decision of the ship.
     */
    public int getUpgradeCost(ShipUpgrade upgrade) {
        int base = this.getUpgradeCosts().getOrDefault(upgrade, upgrade.getDefaultCost());
        if (base <= 0) return 0;
        double modifier = SyncedServerConfig.upgradeCostModifier() / 100.0D;
        return Math.max(1, (int) Math.round(base * modifier));
    }
    public void setCannonKeyPressed(boolean b){
        cannonKeyPressed = b;
    }
    public boolean isCannonKeyPressed() {
        return cannonKeyPressed;
    }

    /**
     * The collision and hit bodies of this ship, in the same local (v, h) frame
     * the seats and the cannons use. A ship without parts behaves exactly as
     * before, so ships can be converted one at a time.
     */
    public List<ShipPartEntity.Definition> getParts() {
        return List.of();
    }

    /**
     * Keeps the collision parts alive. They are never saved, so this also covers
     * world load and ships that existed before they had parts. On any mismatch
     * the whole set is rebuilt instead of patched - a part that lost its ship is
     * far worse than one respawn.
     */
    private void updateParts() {
        // tall parts are cut up here, not in getParts: vanilla cannot find an
        // entity taller than four blocks from above, see ShipPartEntity.MAX_HEIGHT
        List<ShipPartEntity.Definition> definitions = ShipPartEntity.split(this.getParts());
        this.parts.removeIf(Entity::isRemoved);
        if (this.parts.size() == definitions.size()) return;

        for (ShipPartEntity part : this.parts) part.discard();
        this.parts.clear();
        for (ShipPartEntity.Definition definition : definitions) {
            ShipPartEntity part = new ShipPartEntity(this, definition);
            this.parts.add(part);
            this.level().addFreshEntity(part);
        }
    }

    @Override
    public void remove(@NotNull RemovalReason removalReason) {
        // parts must never outlive their ship, not even for a tick
        for (ShipPartEntity part : this.parts) part.discard();
        this.parts.clear();
        super.remove(removalReason);
    }

    /**
     * The solid shapes around this ship, scanned at most once per tick.
     *
     * The turn gate runs in controlBoat and the movement sweep runs in move,
     * both in the same tick and over almost the same volume - and that volume is
     * large, because the masts drag the search box twelve blocks into the air.
     * The cache remembers what it covered and rescans as soon as a request
     * reaches past it, so it can never hand back too little.
     */
    public List<VoxelShape> getBlockers(AABB area) {
        if (this.blockerTick != this.tickCount || this.blockerArea == null || !covers(this.blockerArea, area)) {
            this.blockerArea = area.inflate(1.0D);
            this.blockerTick = this.tickCount;
            this.blockerCache = ShipPartEntity.scanBlockers(this, this.blockerArea);
        }
        return this.blockerCache;
    }

    private static boolean covers(AABB outer, AABB inner) {
        return outer.minX <= inner.minX && outer.minY <= inner.minY && outer.minZ <= inner.minZ
                && outer.maxX >= inner.maxX && outer.maxY >= inner.maxY && outer.maxZ >= inner.maxZ;
    }

    /**
     * A ship must not collide with its own parts. They sit inside its own hull
     * by definition, so without this it would wedge itself in place the moment
     * it comes to a stop and the parts turn solid.
     */
    @Override
    public boolean canCollideWith(@NotNull Entity entity) {
        if (entity instanceof ShipPartEntity part && part.getParent() == this) return false;
        return super.canCollideWith(entity);
    }

    /**
     * Only the horizontal part of the movement is ours. The vertical axis stays
     * with vanilla on purpose: buoyancy, beaching, the ground flags and portals
     * all hang off Entity#move and keep working untouched that way.
     */
    @Override
    public void move(@NotNull MoverType moverType, @NotNull Vec3 delta) {
        if (this.noPhysics || this.getParts().isEmpty()) {
            super.move(moverType, delta);
            return;
        }

        Vec3 allowed = ShipPartEntity.collide(this, delta);
        super.move(moverType, allowed);

        if (allowed.x == delta.x && allowed.z == delta.z) return;
        // vanilla only ever saw its own small box, so it would miss what we cut
        this.horizontalCollision = true;

        // The impact itself is handled by tickObstacleContact, which runs on
        // both sides - this one only ever runs on the controlling client.
    }

    /**
     * The displacement of this ship, taken straight from its hull boxes instead
     * of from yet another config value: an addon ship gets a sensible mass the
     * moment its parts are defined. Masts do not count, they carry no water.
     */
    /**
     * @return how far the tallest point of this ship reaches above the
     * waterline, in blocks - masthead on a rigged ship, deck rail otherwise.
     *
     * Read off the part definitions, the same data the collision and the mass
     * use, and NOT off getBbWidth: the vanilla bounding box is registered per
     * entity type in a completely separate place and is free to disagree with
     * the model. Anything sizing a ship by that box - the dockyard preview, for
     * one - shows each hull at whatever zoom its registration happened to get,
     * and an addon ship inherits the same lottery.
     */
    public float getModelHeight() {
        float height = 1.0F;
        for (ShipPartEntity.Definition part : this.getParts()) {
            height = Math.max(height, part.y() + part.height());
        }
        return height;
    }

    public float getMass() {
        float mass = 0.0F;
        for (ShipPartEntity.Definition definition : this.getParts()) {
            if (definition.mast()) continue;
            mass += definition.width() * definition.width() * definition.height();
        }
        return Math.max(mass, 1.0F);
    }

    /**
     * @return whether the manoeuvring gears are available. Only with the sails
     * furled - a ship under canvas cannot be rowed or poled, and letting it
     * would look like braking against the wind. Ships without sails always may.
     */
    public boolean canManoeuvre() {
        return !(this instanceof Sailable sailable) || sailable.getSailState() == 0;
    }

    /**
     * Ram detection lives here and not in move() on purpose: a ship with a
     * player at the helm is driven by that players' client, the server sets its
     * delta movement to zero and never calls move() for it at all. From tick it
     * runs for crewed and drifting ships alike.
     */
    private void tickRam() {
        // Half the threshold, because closing speed is the sum of both ships:
        // anything slower than this cannot reach the bar even head-on against
        // an equal, and the search is the expensive part.
        if (Kalkuel.getKilometerPerHour(Math.abs(this.getSpeed())) < RAM_MIN_CLOSING_KMH * 0.5D) return;

        if (!this.isRamReady()) return;
        Ship rammed = ShipPartEntity.findRammedShip(this, this.getRamVelocity());
        if (rammed != null) this.ramShip(rammed);
    }

    /**
     * @return true once this ship has got clear of the spot it last rammed at.
     * Measured against a fixed point, so it keeps growing as the ship sails
     * away and the block releases itself without anything having to tick.
     */
    private boolean isRamReady() {
        if (this.ramRearmPos == null) return true;
        if (this.position().distanceToSqr(this.ramRearmPos) < RAM_REARM_DISTANCE * RAM_REARM_DISTANCE) return false;
        this.ramRearmPos = null;
        return true;
    }

    /**
     * The drive rebuilt from the synched speed plus whatever push is still
     * running. getDeltaMovement is zero on the server for a crewed ship, so it
     * cannot be used for this.
     */
    private Vec3 getRamVelocity() {
        return new Vec3(
                Kalkuel.calculateMotionX(this.getSpeed(), this.getYRot()) + this.getData(IMPULSE_X),
                0.0D,
                Kalkuel.calculateMotionZ(this.getSpeed(), this.getYRot()) + this.getData(IMPULSE_Z));
    }

    /**
     * Elastic impulse along the line between the two hulls. Only the closing
     * component counts, so a parallel scrape does almost nothing while a bow-on
     * hit throws the lighter ship clear.
     */
    private void ramShip(Ship other) {
        if (this.level().isClientSide()) return;

        Vec3 line = new Vec3(other.getX() - this.getX(), 0.0D, other.getZ() - this.getZ());
        if (line.lengthSqr() < 1.0E-4D) return;
        Vec3 normal = line.normalize();

        // Anything under the bar is not a ram and is left entirely alone: no
        // damage, no shove, and the re-arm block stays unarmed so a nudge while
        // manoeuvring cannot eat the run that comes after it. The hulls still
        // stop each other - that is ShipPartEntity#collide, not this.
        double closing = this.getRamVelocity().subtract(other.getRamVelocity()).dot(normal);
        double closingKmh = Kalkuel.getKilometerPerHour((float) closing);
        if (closingKmh < RAM_MIN_CLOSING_KMH) return;

        float hit = RAM_BASE_DAMAGE + (float) (closingKmh - RAM_MIN_CLOSING_KMH) * RAM_DAMAGE_PER_KMH;

        // Split by weight: 1.0 between equals, up to 2.0 for the lighter hull,
        // towards 0 for the heavier one. Running into something bigger than
        // yourself is what hurts.
        float mass = this.getMass();
        float otherMass = other.getMass();
        double ownShare = 2.0D * otherMass / (mass + otherMass);
        double otherShare = 2.0D * mass / (mass + otherMass);

        // Read who is under power into the hit BEFORE dampDrive takes the way
        // off both of them - afterwards the answer would depend on the order
        // the two calls happen to run in.
        boolean ownRamming = this.driveInto(normal) > 0.0D;
        boolean otherRamming = other.driveInto(normal.reverse()) > 0.0D;

        // the stem that drives the hit carries through it, the hull it meets is
        // the one that gets thrown - and at the speed it was hit with
        if (!ownRamming) this.addRamImpulse(normal.scale(-Math.min(closing * ownShare, RAM_MAX_SHOVE)));
        if (!otherRamming) other.addRamImpulse(normal.scale(Math.min(closing * otherShare, RAM_MAX_SHOVE)));
        // both drives are damped, not just the one that happened to tick
        // first - otherwise a head-on would leave one ship pushing on
        this.dampDrive(normal);
        other.dampDrive(normal.reverse());

        this.ramRearmPos = this.position();
        other.ramRearmPos = other.position();

        this.level().playSound(null, this.getX(), this.getY() + 1.0D, this.getZ(), ModSoundTypes.SHIP_HIT, this.getSoundSource(), 2.0F, 0.5F + 0.2F * this.random.nextFloat());

        // A ram bow only spares the hull that is DRIVING the hit - being rammed
        // costs every ship the same, whatever its stem is built like.
        this.takeRamHit((float) (hit * ownShare), ownRamming ? this.getRamSelfDamageFactor() : 1.0F);
        other.takeRamHit((float) (hit * otherShare), otherRamming ? other.getRamSelfDamageFactor() : 1.0F);
    }

    /**
     * Takes away the part of the drive that was pushing into the hit. A head-on
     * costs both ships their way, a rear-end only the one that did the ramming,
     * and a parallel scrape almost nothing - the bow stands across the impact
     * line there.
     */
    private void dampDrive(Vec3 into) {
        double along = this.driveInto(into);
        if (along <= 0.0D) return;
        // the way that was pointing into the target is spent on it, no dial
        this.setSpeed((float) (this.getSpeed() * (1.0D - along)));
        // and the turn with it: a hull that has just buried its bow in another
        // does not keep pivoting around the point of contact
        this.setRotSpeed(0.0F);
    }

    /**
     * @return how much of this ships' DRIVE points the given way, 0 if none of
     * it does.
     *
     * Built from the speed and the heading only, never from getRamVelocity:
     * that one carries the ram impulse, so a ship still lodged in the target it
     * just hit reads as moving away from it a few ticks later - and a ram bow
     * would stop protecting halfway through the very ram it is delivering.
     */
    private double driveInto(Vec3 into) {
        Vec3 heading = new Vec3(Kalkuel.calculateMotionX(1.0F, this.getYRot()), 0.0D, Kalkuel.calculateMotionZ(1.0F, this.getYRot()))
                .scale(Math.signum(this.getSpeed()));
        return Math.max(0.0D, heading.dot(into));
    }

    /**
     * What a ram costs THIS ship: timbers and crew, both read off the same
     * damage figure. Nothing here needs to know about the other hull - the
     * split already happened.
     *
     * Anything under a point of damage is a bump and is dropped, which is also
     * what keeps a gentle nudge from bruising the crew.
     *
     * @param damage     this ships' share of the hit, see ramShip
     * @param hullFactor 1.0 for a normal stem, less for a ram bow. It never
     *                   touches the crew: they are thrown across the deck
     *                   whatever the bow is built like.
     */
    private void takeRamHit(float damage, float hullFactor) {
        float hullDamage = damage * hullFactor;
        if (hullDamage >= 1.0F) this.hurt(this.damageSources().generic(), hullDamage);

        float crewDamage = damage * RAM_CREW_DAMAGE_SHARE;
        if (crewDamage < 1.0F) return;
        for (Entity passenger : this.getPassengers()) {
            passenger.hurt(this.damageSources().flyIntoWall(), crewDamage);
        }
    }

    /**
     * How much of its own share of a ram this hull actually takes.
     *
     * 1.0 is a normal hull: bow timbers that were never meant to be a weapon
     * split the blow with whatever they run into. A hull built around a ram
     * returns less, down to 0.0 for one that pays nothing at all.
     *
     * It applies only to a ram this ship DRIVES: no hull has ever been safe
     * from being rammed, and a beak on the bow does nothing about a stem coming
     * in abeam. It never covers the crew either - they are thrown across the
     * deck whatever the stem is made of.
     */
    public float getRamSelfDamageFactor() {
        return 1.0F;
    }

    private void addRamImpulse(Vec3 impulse) {
        this.setData(IMPULSE_X, (float) (this.getData(IMPULSE_X) + impulse.x));
        this.setData(IMPULSE_Z, (float) (this.getData(IMPULSE_Z) + impulse.z));
    }

    /** Water swallows a shove quickly - roughly two seconds until it is gone. */
    private void decayRamImpulse() {
        float x = this.getData(IMPULSE_X);
        float z = this.getData(IMPULSE_Z);
        if (x == 0.0F && z == 0.0F) return;

        x *= RAM_DECAY;
        z *= RAM_DECAY;
        if (Math.abs(x) < 0.001F && Math.abs(z) < 0.001F) {
            x = 0.0F;
            z = 0.0F;
        }
        this.setData(IMPULSE_X, x);
        this.setData(IMPULSE_Z, z);
    }

    /**
     * Full stop against something solid - terrain, a wall, a wedged hull - with
     * the timber to go with it.
     *
     * Nothing to do with ramShip: this is the ship being brought up short by
     * the world, it costs no damage and knows nothing about the other party.
     */
    /**
     * Watches for the hull running into terrain, on BOTH sides.
     *
     * It cannot live in move(): vanilla only calls that on the controlling
     * client, so for a crewed ship the server never sees the impact at all -
     * and the damage has to be dealt there. controlBoat is driven on both sides
     * by BoatMixin, and so is tick, which is where this hangs.
     */
    private void tickObstacleContact() {
        if (this.obstructedTicks > 0) this.obstructedTicks--;

        float speed = this.getSpeed();
        if (Math.abs(speed) < 1.0E-4F || this.getParts().isEmpty()) return;

        Vec3 wanted = new Vec3(Kalkuel.calculateMotionX(speed, this.getYRot()), 0.0D,
                Kalkuel.calculateMotionZ(speed, this.getYRot()));
        Vec3 allowed = ShipPartEntity.collide(this, wanted);
        if (allowed.lengthSqr() >= wanted.lengthSqr() * OBSTACLE_STOP_FRACTION) return;

        this.obstructedDirection = speed > 0.0F ? 1 : -1;
        this.obstructedTicks = OBSTACLE_HOLD_TICKS;
        this.stopAgainstObstacle();
    }

    /**
     * @return true while the drive must not build any more way this way. The
     * blocked DIRECTION is remembered, so a ship that has buried its bow can
     * still back out of it.
     */
    private boolean isDriveBlocked(float wantedSpeed) {
        return this.obstructedTicks > 0 && this.obstructedDirection != 0
                && Math.signum(wantedSpeed) == this.obstructedDirection;
    }

    private void stopAgainstObstacle() {
        if (!this.level().isClientSide()) {
            float impactKmh = Kalkuel.getKilometerPerHour(Math.abs(this.getSpeed()));
            this.level().playSound(null, this.getX(), this.getY() + 1.0D, this.getZ(), ModSoundTypes.SHIP_HIT, this.getSoundSource(), 1.6F, 0.6F + 0.2F * this.random.nextFloat());

            // Running aground at speed is a ram like any other, against
            // something that cannot be pushed and takes nothing itself. No mass
            // split therefore - the hull keeps the whole hit - and the re-arm
            // gate stops a ship wedged in a cliff from paying for it every tick.
            if (impactKmh >= CRASH_MIN_SPEED_KMH && this.isRamReady()) {
                this.ramRearmPos = this.position();
                this.takeRamHit(RAM_BASE_DAMAGE + (impactKmh - (float) CRASH_MIN_SPEED_KMH) * RAM_DAMAGE_PER_KMH,
                        this.getRamSelfDamageFactor());
                this.level().playSound(null, this.getX(), this.getY() + 1.0D, this.getZ(), ModSoundTypes.SHIP_HIT, this.getSoundSource(), 2.0F, 0.6F);
            }
        }
        // The turn goes with the way. A hull wedged against a cliff that keeps
        // swinging looks like it is grinding its way free, and the rotation
        // would carry the parts through the very blocks that stopped it.
        this.setSpeed(0.0F);
        this.setRotSpeed(0.0F);
    }

    @Override
    // keep until multi part entity, otherwise entity just vanishes (stops rendering) on screen edges
    public @NotNull AABB getBoundingBoxForCulling() {
        return this.getBoundingBox().inflate(5.0D);
    }

    @Override
    /**
     * @return how many stations this ship has open right now.
     *
     * Concrete on purpose: every ship used to override this with the identical
     * body, which meant seven places to keep in sync and an addon ship silently
     * getting it wrong. Override it only if a ship really does count differently.
     */
    public int getMaxPassengers() {
        return this instanceof Seatable seatable ? seatable.getUsableSeatCount() : 0;
    }
    @Override
    public abstract @NotNull Item getDropItem();
    public abstract BiomeModifierType getBiomeModifierType();

    /**
     * @return the config block this ship draws its attributes from. The only
     * thing a ship still has to say about its attributes - the values live in
     * the config, the reading is done once for everybody below.
     */
    public abstract SmallShipsConfig.ShipAttributes getConfiguredAttributes();


    /************************************
     * Natural slowdown of the uuid
     * increase -> slowdown will be higher
     * decrease -> slowdown will be lower
     ************************************/
    public float getVelocityResistance() {
        return 0.007F;
    }

    protected void waterSplash() {}

    private void updateShipAmbience(boolean isSwimming) {
        if (isSwimming) {
            if (this.isInWater()) {
                waterSplash();
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_SWIM, this.getSoundSource(), 0.05F, 0.8F + 0.4F * this.random.nextFloat());
            }
        }
    }

    private void updateWaterMobs() {
        if(!this.getCommandSenderWorld().isClientSide()){
            double radius = SmallShipsConfig.Server.waterAnimalFleeRadius.get();
            List<WaterAnimal> waterAnimals = this.level().getEntitiesOfClass(WaterAnimal.class, new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius));
            for (WaterAnimal waterAnimal : waterAnimals) {
                if(this.tickCount % 20 == 0) fleeEntity(waterAnimal);
            }
        }
    }

    private void fleeEntity(Mob entity) {
        double fleeDistance = SmallShipsConfig.Server.waterAnimalFleeDistance.get();
        double fleeSpeed = SmallShipsConfig.Server.waterAnimalFleeSpeed.get();
        Vec3 vecBoat = new Vec3(getX(), getY(), getZ());
        Vec3 vecEntity = new Vec3(entity.getX(), entity.getY(), entity.getZ());
        Vec3 fleeDir = vecEntity.subtract(vecBoat);
        fleeDir = fleeDir.normalize();
        Vec3 fleePos = new Vec3(vecEntity.x + fleeDir.x * fleeDistance, vecEntity.y + fleeDir.y * fleeDistance, vecEntity.z + fleeDir.z * fleeDistance);
        entity.getNavigation().moveTo(fleePos.x, fleePos.y, fleePos.z, fleeSpeed);
    }

    protected void floatUp(){
        if (this.isEyeInFluid(FluidTags.WATER)){
            this.setDeltaMovement(getDeltaMovement().add(0, 0.2, 0));
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        }
        else if (!this.getCommandSenderWorld().isClientSide() && !this.isRemoved()) {
            this.setDamage(this.getDamage() + f * (this instanceof Shieldable shieldShip ? shieldShip.getDamageModifier() : 1));
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());
            // Projectiles play their own impact sound at the point they struck -
            // see AbstractCannonBall#onHitEntity. Playing it a second time from
            // here would double up on every hull hit that happens to be heavy.
            if (f > 10 && !damageSource.is(DamageTypeTags.IS_PROJECTILE)) {
                this.level().playSound(null, this.getX(), this.getY() + 4, this.getZ(), ModSoundTypes.SHIP_HIT, this.getSoundSource(), 3.3F, 0.8F + 0.4F * this.random.nextFloat());
            }

            boolean bl = damageSource.getEntity() instanceof Player player && player.getAbilities().instabuild && player.isCrouching();

            if (this.getDamage() > this.getAttributes().maxHealth) {
                if(this.isSunken() && this.sunkenTime > 200){
                    this.destroy(this.getCommandSenderWorld().damageSources().drown());
                }
                else
                    this.setSunken(true);
            }
            if(bl){
                this.discard();
            }

            return true;
        } else {
            return true;
        }
    }

    private void knockBack(Entity entity, double speed, AABB boundingBox) {
        double d0 = (boundingBox.minX + boundingBox.maxX) / 2.0D;
        double d1 = (boundingBox.minZ + boundingBox.maxZ) / 2.0D;

        if (entity instanceof LivingEntity) {
            double d2 = entity.getX() - d0;
            double d3 = entity.getZ() - d1;
            double d4 = Math.max(d2 * d2 + d3 * d3, 0.1D);
            entity.setDeltaMovement(getDeltaMovement().add(d2 / d4 * (1.0 + speed * 1.1), 0.0F, d3 / d4 * (1.0 + speed * 1.1)));
        }
    }

    private void updateCollision(boolean isCruising){
        if(isCruising && canDoKnockBack() && SmallShipsConfig.Server.shipGeneralCollisionKnockBack.get()) {
            AABB boundingBox = this.getBoundingBox().inflate(2.25, 1.25, 2.25).move(0.0, -2.0, 0.0);
            List<Entity> list = this.level().getEntities(this, boundingBox, EntitySelector.pushableBy(this));
            for(Entity entity: list) {
                if (entity instanceof LivingEntity && !getPassengers().contains(entity)){
                    this.knockBack(entity, this.getSpeed(), boundingBox);
                    this.collisionDamage(entity, this.getSpeed());
                }
            }
        }
    }
    //Reflection Method
    public boolean canDoKnockBack(){
        return true;
    }
    //Reflection Method
    public boolean canDoCollisionDamage(){
        return true;
    }

    private void collisionDamage(Entity entity, float speed) {
        if(this.getControllingPassenger() != null){
            if(this.getControllingPassenger() .getTeam() != null && this.getControllingPassenger() .getTeam().isAlliedTo(entity.getTeam()) && !this.getControllingPassenger() .getTeam().isAllowFriendlyFire()) return;

            if (canDoCollisionDamage() && speed > 0.1F) {
                float damage = speed * SmallShipsConfig.Server.shipGeneralCollisionDamage.get().floatValue();
                if(damage > 0) entity.hurt(this.getCommandSenderWorld().damageSources().mobAttack(this.getControllingPassenger()), damage);
            }
        }
    }
    @Nullable
    public Player getDriver() {
        Player driver = this.getDriverAnySide();
        if (driver == null) return null;
        if (this.getCommandSenderWorld().isClientSide) {
            // keep the old semantics: client side only "yourself" counts as driver
            return driver.equals(Minecraft.getInstance().player) ? driver : null;
        }
        return driver;
    }

    /**
     * @return the player occupying the DRIVER seat (both sides), independent
     * of the passenger list order. Falls back to the first player passenger
     * for ships without a seat layout.
     */
    @Nullable
    public Player getDriverAnySide() {
        if (this instanceof Seatable seatable) {
            for (ShipSeat seat : seatable.getSeats()) {
                if (seat.type() == SeatType.DRIVER && seatable.getSeatOccupant(seat.id()) instanceof Player player) {
                    return player;
                }
            }
            return null;
        }
        return !this.getPassengers().isEmpty() && this.getPassengers().get(0) instanceof Player player ? player : null;
    }

    @Override
    public LivingEntity getControllingPassenger() {
        if (this instanceof Seatable) {
            // only the DRIVER seat occupant controls the ship - NOT the first passenger
            return this.getDriverAnySide();
        }
        return super.getControllingPassenger();
    }
    /************************************
     * Used by Workers and Recruits Mod -> Player == null
     ************************************/
    public void updateControls(boolean forward, boolean backward, boolean left, boolean right, @Nullable Player player) {
        boolean needsUpdate = false;

        if (this.isForward() != forward) {
            this.setForward(forward);
            needsUpdate = true;
        }

        if (this.isBackward() != backward) {
            this.setBackward(backward);
            needsUpdate = true;
        }

        if (this.isLeft() != left) {
            this.setLeft(left);
            needsUpdate = true;
        }

        if (this.isRight() != right) {
            this.setRight(right);
            needsUpdate = true;
        }
        if (this.getCommandSenderWorld().isClientSide && needsUpdate && player != null) {
            ModPackets.clientSendPacket(new ServerboundUpdateShipControlPacket(forward, backward, left, right));
        }
    }
    @Override
    public void destroy(@NotNull DamageSource damageSource) {
        super.destroy(damageSource);
        if (this.getCommandSenderWorld().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            if(this instanceof ContainerShip containerShip) containerShip.chestVehicleDestroyed(damageSource, this.getCommandSenderWorld(), this);
            if(this instanceof Cannonable cannonableShip) cannonableShip.cannonShipDestroyed(this.getCommandSenderWorld(), this);
        }

        discard();
    }

    public enum BiomeModifierType {
        NONE,
        COLD,
        NEUTRAL,
        WARM
    }
}