package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.config.SmallShipsConfig;
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
import java.util.Objects;
import java.util.Stack;

public abstract class Ship extends Boat {
    public static final EntityDataAccessor<CompoundTag> ATTRIBUTES = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    public static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ROT_SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> SAIL_STATE = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<String>  SAIL_COLOR = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<ItemStack> BANNER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Float> CANNON_POWER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> CANNON_COUNT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> FORWARD = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BACKWARD = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SUNKEN = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BOOLEAN);
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

    /** 1 + coefficient of restitution, wooden hulls barely bounce */
    private static final double RAM_ELASTICITY = 1.1D;
    /**
     * Gain on the physical impulse. Ship speeds in this game are around a
     * tenth of a block per tick, so a textbook impulse comes out below half
     * a block of travel and reads as nothing happening at all.
     */
    private static final double RAM_PUSH = 5.0D;
    /** hard ceiling per ship per hit, in blocks per tick */
    private static final double RAM_MAX_PUSH = 1.0D;
    /** total hull damage per unit of impulse, shared between the two ships */
    private static final double RAM_DAMAGE = 3.0D;
    /** how lopsided the split may get - 0 shares evenly, 1 spares the rammer entirely */
    private static final double RAM_DAMAGE_BIAS = 0.85D;
    /** share of the drive lost when it pointed straight into the hit */
    private static final double RAM_DRIVE_LOSS = 0.8D;
    private static final float RAM_DECAY = 0.88F;
    private static final int RAM_COOLDOWN = 10;

    /** share of the top speed available astern */
    private static final float REVERSE_FACTOR = 0.125F;

    /** below this a ram is not worth looking for */
    private static final float RAM_MIN_SPEED = 0.06F;

    /** ticks until this ship can be rammed again, server side */
    private int ramCooldown;

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
        super.tick();

        if (!this.level().isClientSide() && (this.parts.isEmpty() || this.tickCount % 20 == 0)) this.updateParts();

        if (!this.level().isClientSide()) {
            this.tickRam();
            this.decayRamImpulse();
        }

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() + 1.0F);
        }

        if(isSunken()){
            if(++this.sunkenTime > SmallShipsConfig.Common.shipGeneralDespawnTimeSunken.get()*20*60) this.destroy(this.getCommandSenderWorld().damageSources().drown());
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
        builder.define(ATTRIBUTES, this.createDefaultAttributes());
        builder.define(FORWARD, false);
        builder.define(BACKWARD, false);
        builder.define(LEFT, false);
        builder.define(RIGHT, false);
        builder.define(SUNKEN, false);
        builder.define(IMPULSE_X, 0.0F);
        builder.define(IMPULSE_Z, 0.0F);

        // Sailable
        builder.define(SAIL_STATE, (byte) 0);
        builder.define(Ship.SAIL_COLOR, SailModel.Color.WHITE.toString());

        // Bannerable
        builder.define(Ship.BANNER, ItemStack.EMPTY);

        // Cannonable
        builder.define(Ship.CANNON_POWER, 4.0F);
        builder.define(Ship.CANNON_COUNT, (byte) 0);

        // Shieldable
        builder.define(Ship.SHIELD_DATA, new CompoundTag());

        // Cannon aim (Better Cannon Gameplay)
        builder.define(Ship.CANNON_AIM, new CompoundTag());

        // Sail damage
        builder.define(Ship.SAIL_HEALTH, SailDamage.MAX_HEALTH);

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

        Attributes attributes = new Attributes();
        attributes.loadSaveData(tag, this);
        this.setData(ATTRIBUTES, attributes.getSaveData());

        if (this instanceof Sailable sailShip) sailShip.readSailShipSaveData(tag);
        if (this instanceof Bannerable bannerShip) bannerShip.readBannerShipSaveData(tag);
        if (this instanceof Cannonable cannonShip) cannonShip.readCannonShipSaveData(tag);
        if (this instanceof Shieldable shieldShip) shieldShip.readShieldShipSaveData(tag);

        this.setSunken(tag.getBoolean("Sunken"));
        this.isLocked = (tag.getBoolean("locked"));
        if (tag.contains("Upgrades")) this.setData(UPGRADES, tag.getCompound("Upgrades"));
        if (this instanceof Seatable && tag.contains("SeatAssignments")) this.setData(SEAT_ASSIGNMENTS, tag.getCompound("SeatAssignments"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);

        Attributes attributes = new Attributes();
        attributes.loadSaveData(this.getData(ATTRIBUTES));
        attributes.addSaveData(tag);

        if (this instanceof Sailable sailShip) sailShip.addSailShipSaveData(tag);
        if (this instanceof Bannerable bannerShip) bannerShip.addBannerShipSaveData(tag);
        if (this instanceof Cannonable cannonShip) cannonShip.addCannonShipSaveData(tag);
        if (this instanceof Shieldable shieldShip) shieldShip.addShieldShipSaveData(tag);

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
        return super.canAddPassenger(entity) && !(entity instanceof Ship) && !SmallShipsConfig.Common.mountBlackList.get().contains(entity.getEncodeId()) && !this.isLocked() && this.getPassengers().size() < this.getMaxPassengers() && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal);
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

        this.maxSpeed = (attributes.maxSpeed / (60F * 1.15F)) * speedPenalty;
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

            // a light reverse gear. Canvas cannot back a ship, so this is
            // oars, poles and patience - it exists so a hull that wedged
            // itself into terrain can work its way out, not as a second gear
            if (this.isBackward() && this.getDriver() != null) {
                setPoint = -this.maxSpeed * REVERSE_FACTOR;
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
        if (!SmallShipsConfig.Common.windEnable.get()) return 1.0F;
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
        if(speed < setPoint){
            speed = Kalkuel.addToSetPoint(speed, acceleration, setPoint); //getVelocityResistance() * 0.5F
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
        float modifier = SmallShipsConfig.Common.shipGeneralBiomeModifier.get().floatValue();

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

    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        if (this instanceof Sailable sailShip && sailShip.getSailState() != 0) sailShip.toggleSail();
        return super.getDismountLocationForPassenger(livingEntity);
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
            ShipSeat seat = seatable.findNearestFreeSeat(from, entity instanceof Player);
            if (seat != null) seatable.assignSeat(entity, seat.id());
        }
    }

    @Override
    protected void removePassenger(Entity entity) {
        if (this instanceof Seatable seatable && !this.level().isClientSide()) {
            seatable.freeSeatOf(entity);
        }
        // Auto third person: Disable
        if (this.level().isClientSide() && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get() && Objects.equals(Minecraft.getInstance().player, entity)) {
            Minecraft.getInstance().options.setCameraType(this.previousCameraType);
        }
        super.removePassenger(entity);
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

    public Attributes getAttributes() {
        Attributes attributes = new Attributes();
        attributes.loadSaveData(this.getData(ATTRIBUTES));
        ShipUpgrade.applyAll(this, attributes);
        return attributes;
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

        double wanted = delta.x * delta.x + delta.z * delta.z;
        double reached = allowed.x * allowed.x + allowed.z * allowed.z;
        // running into a cliff stops a ship dead, brushing along a quay does not
        if (reached < wanted * 0.0625D) this.ram();
    }

    /**
     * The displacement of this ship, taken straight from its hull boxes instead
     * of from yet another config value: an addon ship gets a sensible mass the
     * moment its parts are defined. Masts do not count, they carry no water.
     */
    public float getMass() {
        float mass = 0.0F;
        for (ShipPartEntity.Definition definition : this.getParts()) {
            if (definition.mast()) continue;
            mass += definition.width() * definition.width() * definition.height();
        }
        return Math.max(mass, 1.0F);
    }

    /**
     * Ram detection lives here and not in move() on purpose: a ship with a
     * player at the helm is driven by that players' client, the server sets its
     * delta movement to zero and never calls move() for it at all. From tick it
     * runs for crewed and drifting ships alike.
     */
    private void tickRam() {
        if (Math.abs(this.getSpeed()) <= RAM_MIN_SPEED) return;
        Ship rammed = ShipPartEntity.findRammedShip(this, this.getRamVelocity());
        if (rammed != null) this.ramShip(rammed);
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
        if (this.level().isClientSide() || this.ramCooldown > 0) return;

        Vec3 line = new Vec3(other.getX() - this.getX(), 0.0D, other.getZ() - this.getZ());
        if (line.lengthSqr() < 1.0E-4D) return;
        Vec3 normal = line.normalize();

        double closing = this.getRamVelocity().subtract(other.getRamVelocity()).dot(normal);
        if (closing <= 0.0D) return;

        float mass = this.getMass();
        float otherMass = other.getMass();
        double impulse = RAM_ELASTICITY * closing / (1.0D / mass + 1.0D / otherMass);
        double push = impulse * RAM_PUSH;

        this.addRamImpulse(normal.scale(-Math.min(push / mass, RAM_MAX_PUSH)));
        other.addRamImpulse(normal.scale(Math.min(push / otherMass, RAM_MAX_PUSH)));
        // both drives are damped, not just the one that happened to tick
        // first - otherwise a head-on would leave one ship pushing on
        this.dampDrive(normal);
        other.dampDrive(normal.reverse());

        this.ramCooldown = RAM_COOLDOWN;
        other.ramCooldown = RAM_COOLDOWN;

        this.level().playSound(null, this.getX(), this.getY() + 1.0D, this.getZ(), SoundEvents.WOOD_BREAK, this.getSoundSource(), 2.0F, 0.5F + 0.2F * this.random.nextFloat());

        // the pot comes off the physical impulse, never off the boosted push
        double pot = impulse * RAM_DAMAGE;

        // split by who carried the momentum into the hit. A hull driven bow
        // first meets the blow with its stem and its own way behind it, while a
        // ship lying still simply absorbs everything - so the slower one pays.
        double ownClosing = Math.max(0.0D, this.getRamVelocity().dot(normal));
        double otherClosing = Math.max(0.0D, other.getRamVelocity().dot(normal.reverse()));
        double closingSum = ownClosing + otherClosing;
        double share = closingSum <= 1.0E-6D ? 0.5D : otherClosing / closingSum;
        share = 0.5D + (share - 0.5D) * RAM_DAMAGE_BIAS;

        float ownDamage = (float) (pot * share);
        float otherDamage = (float) (pot * (1.0D - share));
        if (ownDamage >= 1.0F) this.hurt(this.damageSources().generic(), ownDamage);
        if (otherDamage >= 1.0F) other.hurt(other.damageSources().generic(), otherDamage);
    }

    /**
     * Takes away the part of the drive that was pushing into the hit. A head-on
     * costs both ships their way, a rear-end only the one that did the ramming,
     * and a parallel scrape almost nothing - the bow stands across the impact
     * line there.
     */
    private void dampDrive(Vec3 into) {
        Vec3 heading = new Vec3(Kalkuel.calculateMotionX(1.0F, this.getYRot()), 0.0D, Kalkuel.calculateMotionZ(1.0F, this.getYRot()))
                .scale(Math.signum(this.getSpeed()));
        double along = heading.dot(into);
        if (along <= 0.0D) return;
        this.setSpeed((float) (this.getSpeed() * (1.0D - RAM_DRIVE_LOSS * along)));
    }

    public void addRamImpulse(Vec3 impulse) {
        this.setData(IMPULSE_X, (float) (this.getData(IMPULSE_X) + impulse.x));
        this.setData(IMPULSE_Z, (float) (this.getData(IMPULSE_Z) + impulse.z));
    }

    /** Water swallows a shove quickly - roughly two seconds until it is gone. */
    private void decayRamImpulse() {
        if (this.ramCooldown > 0) this.ramCooldown--;

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

    /** Full stop against something solid, with the timber to go with it. */
    private void ram() {
        if (this.level().isClientSide()) return;
        if (Math.abs(this.getSpeed()) > 0.05F && this.tickCount % 10 == 0) {
            this.level().playSound(null, this.getX(), this.getY() + 1.0D, this.getZ(), SoundEvents.WOOD_HIT, this.getSoundSource(), 1.6F, 0.6F + 0.2F * this.random.nextFloat());
        }
        this.setSpeed(0.0F);
    }

    @Override
    // keep until multi part entity, otherwise entity just vanishes (stops rendering) on screen edges
    public @NotNull AABB getBoundingBoxForCulling() {
        return this.getBoundingBox().inflate(5.0D);
    }

    @Override
    public abstract int getMaxPassengers();
    @Override
    public abstract @NotNull Item getDropItem();
    public abstract BiomeModifierType getBiomeModifierType();
    public abstract CompoundTag createDefaultAttributes();

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
            double radius = SmallShipsConfig.Common.waterAnimalFleeRadius.get();
            List<WaterAnimal> waterAnimals = this.level().getEntitiesOfClass(WaterAnimal.class, new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius));
            for (WaterAnimal waterAnimal : waterAnimals) {
                if(this.tickCount % 20 == 0) fleeEntity(waterAnimal);
            }
        }
    }

    private void fleeEntity(Mob entity) {
        double fleeDistance = SmallShipsConfig.Common.waterAnimalFleeDistance.get();
        double fleeSpeed = SmallShipsConfig.Common.waterAnimalFleeSpeed.get();
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
            if(f > 10)this.level().playSound(null, this.getX(), this.getY() + 4 , this.getZ(), ModSoundTypes.SHIP_HIT, this.getSoundSource(), 3.3F, 0.8F + 0.4F * this.random.nextFloat());

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
        if(isCruising && canDoKnockBack() && SmallShipsConfig.Common.shipGeneralCollisionKnockBack.get()) {
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
                float damage = speed * SmallShipsConfig.Common.shipGeneralCollisionDamage.get().floatValue();
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