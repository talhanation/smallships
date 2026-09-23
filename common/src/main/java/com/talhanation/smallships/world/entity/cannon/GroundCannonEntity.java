package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundEnterCannonBarrelPacket;
import com.talhanation.smallships.network.packet.ServerboundShootGroundCannonPacket;
import com.talhanation.smallships.network.packet.ServerboundUdpateGroundCannonControlPacket;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import com.talhanation.smallships.world.item.CannonAmmoSelection;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.*;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.*;

/**
 * @author Chryfi, Talhanation
 */
public class GroundCannonEntity extends Entity implements ICannon{
    public static final String ID = "ground_cannon";
    private static final EntityDataAccessor<Optional<UUID>> UUID = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<String> DYE = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> FORWARD = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BACKWARD = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BARREL_UP = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> BARREL_DOWN = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> AIMING = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> RECENTERING = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> CARRIAGE_YAW = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HEALTH = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.FLOAT);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;
    private final Cannon cannon = new Cannon(this);
    public float maxSpeedInKmH = 15.75F;// 15.75km/h
    /** barrel elevation limits, single source of truth for the entity and the Cannon core */
    public static final float PITCH_MIN = -30.0F;
    public static final float PITCH_MAX = 10.0F;
    /*
     * Barrel geometry, all of it from CannonGeometry. GroundCannonRenderer draws
     * the model with the vanilla -1.5 blocks translate, so its pose origin is the
     * 24 unit one - that is the only thing this entity has to know about it.
     */
    /** height of the trunnions above the entity position */
    public static final float TRUNNION_HEIGHT = CannonGeometry.trunnionHeight(CannonGeometry.MODEL_ORIGIN_Y);
    /** trunnions in front of the entity position, along the yaw */
    public static final float TRUNNION_FORWARD = CannonGeometry.trunnionForward();
    /** trunnions to the spawn point of the ball */
    public static final float MUZZLE_DISTANCE = CannonGeometry.spawnDistance();
    /** barrel elevation speed while the gun traverses back to centre */
    private static final float RECENTER_PITCH_SPEED = 1.5F;
    /** snap-to-center traverse speed, deliberately faster than manual tracking */
    private static final float RECENTER_YAW_SPEED = 6.0F;
    /** the recenter is done once the barrel is within this many degrees of the carriage */
    private static final float RECENTER_EPSILON = 0.5F;
    /** barrel elevation speed in degrees per tick (key-only aiming) */
    private static final float BARREL_PITCH_SPEED = 0.75F;
    /**
     * speed gained per tick while driving. The roll resistance takes the whole
     * speed away every tick, so this step is what the carriage actually rolls at -
     * maxSpeed only caps it.
     */
    private static final float ACCELERATION = 0.0225F;
    /** how far behind the carriage centre the driver stands */
    private static final float DRIVER_STAND_DISTANCE = 1.0F;
    private float maxSpeed = maxSpeedInKmH / (60F * 1.15F);

    private float wheelRotation;
    private int steps;
    private double clientX;
    private double clientY;
    private double clientZ;
    private double clientYaw;
    private double clientPitch;

    protected float deltaRotation;
    private boolean drivenPrevTick;
    private boolean aimingPrevTick;

    public SimpleContainer inventory;

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.cannon.setPitchBounds(PITCH_MIN, PITCH_MAX);
        this.cannon.setBarrelGeometry(TRUNNION_HEIGHT, TRUNNION_FORWARD, MUZZLE_DISTANCE);
        this.setPos(pos);
        recalculateBoundingBox();
        this.inventory = new SimpleContainer(1);
    }

    public GroundCannonEntity(EntityType<? extends Entity> entityType, Level level) {
        super(entityType, level);
        this.cannon.setPitchBounds(PITCH_MIN, PITCH_MAX);
        this.cannon.setBarrelGeometry(TRUNNION_HEIGHT, TRUNNION_FORWARD, MUZZLE_DISTANCE);
    }

    public Item getDropItem() {
        return ModItems.CANNON;
    }

    @Override
    public float maxUpStep() {
        return 1.0F;
    }
    /*
     *
     * DATA
     *
     */

    @Override
    protected void defineSynchedData() {
        this.entityData.define(UUID, Optional.empty());
        this.entityData.define(DYE, "");
        this.entityData.define(FORWARD, false);
        this.entityData.define(BACKWARD, false);
        this.entityData.define(LEFT, false);
        this.entityData.define(RIGHT, false);
        this.entityData.define(BARREL_UP, false);
        this.entityData.define(BARREL_DOWN, false);
        this.entityData.define(AIMING, false);
        this.entityData.define(RECENTERING, false);
        this.entityData.define(CARRIAGE_YAW, 0.0F);
        this.entityData.define(SPEED, 0F);
        this.entityData.define(HEALTH, 100F);
    }

    public Optional<UUID> getEntityInBarrelUUID() {
        return this.entityData.get(UUID);
    }

    protected final void setEntityInBarrelUUID(UUID uuid) {
        this.entityData.set(UUID, Optional.ofNullable(uuid));
    }

    @Nullable
    public DyeColor getDye() {
        String dye = this.entityData.get(DYE);
        return dye.isEmpty() ? null : DyeColor.byName(this.entityData.get(DYE), null);
    }

    @Nullable
    protected final void setDye(@Nullable DyeColor dye) {
        this.entityData.set(DYE, dye != null ? dye.getSerializedName() : "");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        if(inventory != null && !inventory.getItem(0).isEmpty()){
            // 1.20.1 writes item nbt without a registry context
            inventory.getItem(0).save(compoundTag);

            tag.put("Inventory", compoundTag);
        }
        DyeColor dye;
        if ((dye = this.getDye()) != null) tag.putString("Dye", dye.getSerializedName());
        this.getEntityInBarrelUUID().ifPresent(uuid -> tag.putUUID("EntityInBarrelUUID", uuid));
        tag.putFloat("Health", this.getHealth());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        if(tag.contains("Inventory")){
            inventory.setItem(0, ItemStack.of(tag.getCompound("Inventory")));
        }
        if (tag.contains("Dye")) {
            this.setDye(DyeColor.byName(tag.getString("Dye"), null));
        }
        if (tag.contains("EntityInBarrelUUID")) {
            this.setEntityInBarrelUUID(tag.getUUID("EntityInBarrelUUID"));
        }
        // cannons placed before the health system have no tag and start at full health
        if (tag.contains("Health")) {
            this.setHealth(tag.getFloat("Health"));
        }
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    @Override
    public void tick() {
        if (!getLevel().isClientSide) {
            this.xo = getX();
            this.yo = getY();
            this.zo = getZ();
        }

        // super tick resets x rot, cache and reapply
        float xRot = this.getXRot();
        float yRot = this.getYRot();

        super.tick();
        tickLerp();

        this.applyGravity();


        move(MoverType.SELF, getDeltaMovement());

        updateWheelRotation();

        // detect when a player enters to set the player head yaw and pitch to continue shooting
        boolean isDriven = this.getDriver() != null;
        final Entity driver = this.getDriver();
        boolean enteredCannon = !this.drivenPrevTick && isDriven;
        if (enteredCannon) {
            this.getDriver().setYRot(this.getYRot());
            this.getDriver().setXRot(this.getXRot());
            // the orientation at mount time is the neutral forward the recenter returns to
            this.setCarriageYaw(this.getYRot());
        }
        this.drivenPrevTick = isDriven;

        control(driver, xRot, yRot);

        this.cannon.tick(this.getX(), this.getY(), this.getZ(), -this.getYRot(), this.getXRot());
        this.testEntityIntersection();

        recalculateBoundingBox();
    }

    /**
     * 1.20.1 has no Entity#applyGravity, so the fall is done here.
     *
     * Careful when comparing against the 1.21 branch: Entity#getGravity returns
     * 0 for anything that does not override it, and this class never did - so
     * applyGravity() was a no-op there and the carriage only ever sat on the
     * ground it was placed on.
     *
     * The gravity is also what makes maxUpStep work at all: Entity#collide only
     * steps up while the entity is onGround, and onGround needs a downward
     * collision - without any fall the carriage never touched the ground and
     * stopped dead at every block edge instead of climbing it.
     * Same value as a minecart.
     */
    private static final double GRAVITY = 0.04D;

    protected void applyGravity() {
        if (GRAVITY != 0.0D && !this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -GRAVITY, 0.0D));
        }
    }

    public void recalculateBoundingBox() {
        double width = getWidth();
        double height = getHeight();
        setBoundingBox(new AABB(getX() - width / 2D, getY(), getZ() - width / 2D, getX() + width / 2D, getY() + height, getZ() + width / 2D));
    }

    public double getWidth() {
        return 1.0D;
    }

    public double getHeight() {
        return 1.0D;
    }

    /**
     * For pushing any entity into the cannon barrel
     */
    protected void testEntityIntersection() {
        if (this.level().isClientSide()) return;
        List<Entity> list = this.level().getEntities(this, this.getBoundingBox().inflate(0.20000000298023224, 0.0, 0.20000000298023224), EntitySelector.pushableBy(this));
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Entity entity = (Entity) it.next();
                boolean isEntityTypeAllowed = !(entity instanceof Player) && !(entity instanceof IronGolem) && !(entity instanceof AbstractMinecart);
                boolean isBarrelEmpty = this.getPassengerInBarrel() == null;
                if (isEntityTypeAllowed && isBarrelEmpty && !entity.isPassenger()) {
                    this.tryPuttingIntoBarrel(entity);
                }
            }
        }
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand interactionHand) {
        // copied from Minecart.interact
        if (this.itemInteraction(player, interactionHand)) {
            return InteractionResult.CONSUME;
        } else if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (this.getPassengers().size() == 2) {
            return InteractionResult.PASS;
        } else if (!this.level().isClientSide()) {
            return this.tryRiding(player) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }


    protected boolean itemInteraction(Player player, InteractionHand interactionHand) {
        if (!this.level().isClientSide() && interactionHand == InteractionHand.MAIN_HAND) {
            ItemStack item = player.getMainHandItem();
            if (item.getItem() instanceof DyeItem dye) {
                if (!dye.getDyeColor().equals(this.getDye())) {
                    item.shrink(1);
                    this.setDye(dye.getDyeColor());
                }
                return true;
            } else if (item.is(Items.FLINT_AND_STEEL)) {
                this.setDye(null);
                return true;
            }
        }
        return false;
    }

    public void control(Entity driver, float xRot, float yRot) {
        float speed = Kalkuel.subtractToZero(getSpeed(), getRollResistance());
        // detect the start of aim mode, the view is aligned to the gun once there
        boolean isAiming = this.isAiming();
        boolean startedAiming = isAiming && !this.aimingPrevTick;
        this.aimingPrevTick = isAiming;
        if(driver != null) {

            // aiming locks the carriage in place: a loaded gun is not aimed while
            // rolling. Driving inputs are ignored and the cannon brakes to a stop.
            boolean movementLocked = this.isAiming() || this.isRecentering();

            if (isForward() && !movementLocked) {
                if (speed <= maxSpeed) {
                    speed = Math.min(speed + ACCELERATION, maxSpeed);
                }
            }

            if (isBackward() && !movementLocked) {
                if (speed >= -maxSpeed) {
                    speed = Math.max(speed - ACCELERATION, -maxSpeed);
                }
            }

            if (movementLocked) {
                speed = 0.0F;
            }
            // double right click: traverse back to the carriage forward on its own.
            // Runs before the aim tracking and swallows driver input until it is done,
            // so a held right click does not fight the recenter.
            if (this.isRecentering()) {
                float carriageYaw = this.getCarriageYaw();
                float recentered = Mth.approachDegrees(this.getYRot(), carriageYaw, RECENTER_YAW_SPEED);
                this.setYRot(Mth.wrapDegrees(recentered));
                this.setXRot(Mth.clamp(Mth.approachDegrees(this.getXRot(), 0.0F, RECENTER_PITCH_SPEED), PITCH_MIN, PITCH_MAX));

                if (Math.abs(Mth.degreesDifference(this.getYRot(), carriageYaw)) <= RECENTER_EPSILON) {
                    this.setYRot(Mth.wrapDegrees(carriageYaw));
                    this.setRecentering(false);
                    // hand the view back to the driver at the neutral angle so the
                    // camera does not jump when the aim tracking takes over again
                    driver.setYRot(this.getYRot());
                    driver.setXRot(this.getXRot());
                }
            }
            // aim mode (right click held): DIRECT control, the same feel as the
            // captain laying a broadside. The gun IS the view - no tracking
            // lag in between, because a barrel that trails the crosshair means
            // aiming at one thing and shooting at another.
            // NOTE: no early return here - the movement block below must still run,
            // otherwise the cannon keeps its old delta movement and coasts while aiming.
            else if (this.isAiming()) {
                // entering aim mode: the view takes over the guns' current lay,
                // not the other way round - the barrel must not jump to wherever
                // the driver happened to look when he pressed right click
                if (startedAiming) {
                    this.alignDriverToCannon(driver);
                }
                float targetPitch = Mth.clamp(driver.getXRot(), PITCH_MIN, PITCH_MAX);
                this.setYRot(Mth.wrapDegrees(driver.getYRot()));
                this.setXRot(targetPitch);

                // the barrel cannot elevate past its stops, so the view must not
                // either - otherwise the mouse builds up a dead zone the player
                // has to unwind before the gun moves again. Client only: the
                // server has no business turning a players' head.
                if (this.level().isClientSide() && driver.getXRot() != targetPitch) {
                    driver.setXRot(targetPitch);
                    driver.xRotO = targetPitch;
                }
            }
            else {

                // otherwise key controls: A/D rotate the cannon around its own axis,
                // the barrel up/down keys change the elevation.
                deltaRotation = 0;
                if(isLeft()){
                    --deltaRotation;
                }
                if(isRight()){
                    ++deltaRotation;
                }
                // wrap so the yaw never accumulates unbounded over long sessions
                float newYRot = Mth.wrapDegrees(yRot + this.deltaRotation);

                if (isBarrelUp()) {
                    xRot -= BARREL_PITCH_SPEED;
                }
                if (isBarrelDown()) {
                    xRot += BARREL_PITCH_SPEED;
                }
                xRot = Mth.clamp(xRot, PITCH_MIN, PITCH_MAX);

                this.setXRot(xRot);
                this.setYRot(newYRot);
                // driving the carriage redefines what forward means
                this.setCarriageYaw(newYRot);
            }
        }
        else {
            setForward(false);
            setBackward(false);
            setLeft(false);
            setRight(false);
            setRecentering(false);
        }

        this.setSpeed(speed);
        setDeltaMovement(Kalkuel.calculateMotionX(this.getSpeed(), this.getYRot()), getDeltaMovement().y, Kalkuel.calculateMotionZ(this.getSpeed(), this.getYRot()));
    }

    private float getRollResistance() {
        return 1.05F;
    }


    /************************************
     * Used by Workers and Recruits Mod -> Player == null
     ************************************/
    public void updateControls(boolean forward, boolean backward, boolean left, boolean right, @Nullable LivingEntity livingEntity) {
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
        if (this.getCommandSenderWorld().isClientSide && needsUpdate && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(forward, backward, left, right, this.isAimingRaw()));
        }
    }


    public void setBarrelUp(boolean up) {
        entityData.set(BARREL_UP, up);
    }

    public void setBarrelDown(boolean down) {
        entityData.set(BARREL_DOWN, down);
    }

    public boolean isBarrelUp() {
        if (this.getDriver() == null) return false;
        return entityData.get(BARREL_UP);
    }

    public boolean isBarrelDown() {
        if (this.getDriver() == null) return false;
        return entityData.get(BARREL_DOWN);
    }


    public void setAiming(boolean aiming) {
        entityData.set(AIMING, aiming);
    }

    public boolean isAiming() {
        if (this.getDriver() == null) return false;
        return entityData.get(AIMING);
    }

    /**
     * Right click aim mode (SiegeWeapons ballista style): while held, the
     * cannon follows the driver's view and the camera moves behind the barrel.
     */
    public void updateAimingControl(boolean aiming, @Nullable LivingEntity livingEntity) {
        if (this.isAimingRaw() == aiming) return;
        this.setAiming(aiming);
        // align right on the click and not only on the next tick, otherwise the
        // aim camera shows the old view direction for a frame or two
        if (aiming && livingEntity != null && livingEntity == this.getDriver()) {
            this.alignDriverToCannon(livingEntity);
        }
        if (this.getCommandSenderWorld().isClientSide && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(this.isForward(), this.isBackward(), this.isLeft(), this.isRight(), aiming));
        }
    }

    /**
     * Turns the drivers' view onto the current barrel orientation. The old
     * rotation is overwritten as well, so the camera does not swing over from
     * the previous view within the partial ticks.
     */
    private void alignDriverToCannon(Entity driver) {
        float pitch = Mth.clamp(this.getXRot(), PITCH_MIN, PITCH_MAX);
        driver.setYRot(this.getYRot());
        driver.setXRot(pitch);
        driver.yRotO = this.getYRot();
        driver.xRotO = pitch;
        driver.setYHeadRot(this.getYRot());
    }

    private boolean isAimingRaw() {
        return entityData.get(AIMING);
    }

    public void setRecentering(boolean recentering) {
        entityData.set(RECENTERING, recentering);
    }

    public boolean isRecentering() {
        if (this.getDriver() == null) return false;
        return entityData.get(RECENTERING);
    }

    private boolean isRecenteringRaw() {
        return entityData.get(RECENTERING);
    }

    public void setCarriageYaw(float yaw) {
        entityData.set(CARRIAGE_YAW, Mth.wrapDegrees(yaw));
    }

    /** @return the neutral forward angle of the carriage, the recenter target. */
    public float getCarriageYaw() {
        return entityData.get(CARRIAGE_YAW);
    }

    /**
     * Double right click: traverse the barrel back to the carriage forward.
     * Ignored while a recenter is already running so a triple click is harmless.
     */
    public void triggerRecenter(@Nullable LivingEntity livingEntity) {
        if (this.isRecenteringRaw()) return;
        this.setRecentering(true);
        if (this.getCommandSenderWorld().isClientSide && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(this.isForward(), this.isBackward(), this.isLeft(), this.isRight(), this.isAimingRaw()));
        }
    }

    /**
     * Key-only barrel elevation. Kept separate from updateControls so the
     * reflection signature used by the Workers/Recruits mod stays stable.
     */
    public void updateBarrelControls(boolean up, boolean down, @Nullable LivingEntity livingEntity) {
        boolean needsUpdate = false;

        if (this.isBarrelUpRaw() != up) {
            this.setBarrelUp(up);
            needsUpdate = true;
        }

        if (this.isBarrelDownRaw() != down) {
            this.setBarrelDown(down);
            needsUpdate = true;
        }

        if (this.getCommandSenderWorld().isClientSide && needsUpdate && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(this.isForward(), this.isBackward(), this.isLeft(), this.isRight(), this.isAimingRaw()));
        }
    }

    private boolean isBarrelUpRaw() {
        return entityData.get(BARREL_UP);
    }

    private boolean isBarrelDownRaw() {
        return entityData.get(BARREL_DOWN);
    }

    protected boolean tryRiding(Entity entity) {
        if (this.level().isClientSide()) return false;

        if (this.getPassengerInBarrel() == null && !this.getPassengers().isEmpty() && this.canAddPassenger(entity)) {
            return this.tryPuttingIntoBarrel(entity);
        }
        this.cleanEntityInBarrelUUID();

        if(entity.startRiding(this)){
            entity.setYRot(this.getYRot());
            entity.setXRot(this.getXRot());
            return true;
        }
        return false;
    }

    protected boolean tryPuttingIntoBarrel(Entity entity) {
        if (this.level().isClientSide() || entity == null || this.getCannon().isFuzing()) return false;

        Entity barrelEntity = this.getPassengerInBarrel();
        if (barrelEntity == entity) {
            return true;
        } else if (this.getPassengers().size() == 2) {
            return false;
        } else if (barrelEntity != null) {
            return false;
        }

        if (!this.getPassengers().contains(entity)) {
            if (entity.startRiding(this)) {
                this.setEntityInBarrelUUID(entity.getUUID());
                return true;
            }
        } else {
            this.setEntityInBarrelUUID(entity.getUUID());
            return true;
        }

        return false;
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void putEntityIntoBarrel(Entity entity) {
        if (this.level().isClientSide()) {
            ModPackets.clientSendPacket(new ServerboundEnterCannonBarrelPacket(this.getId(), entity.getId()));
            return;
        }

        this.tryPuttingIntoBarrel(entity);
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return this.getPassengers().size() < 2;
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void trigger(Entity triggeredBy) {
        if (this.level().isClientSide()) {
            ModPackets.clientSendPacket(new ServerboundShootGroundCannonPacket(false));
            return;
        }

        CannonBallItem cannonBallToShoot = this.getPassengerInBarrel() == null ? this.getCannonBallToShoot() : null;
        boolean canFuze = cannonBallToShoot != null || this.getPassengerInBarrel() != null;

        if (canFuze) {
            /* consume the cannonball, if it's available, and shoot it after a delay.
             * If no cannonball is available, try to shoot an entity from the barrel if it is still available after fuzing */
            final CannonBallItem.Type ballType = cannonBallToShoot != null ? cannonBallToShoot.getType() : CannonBallItem.Type.BALL;
            if (cannonBallToShoot != null) {
                this.consumeCannonBall();

                float speedMultiplier = ballType.speedMultiplier;
                boolean fineGrain = this.consumeFineGrainPowder();
                if (fineGrain) {
                    speedMultiplier *= 1.5F;
                }
                this.cannon.setSpeedMultiplier(speedMultiplier);
                this.cannon.setFineGrain(fineGrain);
            } else {
                this.cannon.setSpeedMultiplier(1.0F);
                this.cannon.setFineGrain(false);
            }

            this.cannon.triggerFuze(triggeredBy, () -> {
                if (cannonBallToShoot != null) {
                    return ShipCannon.createProjectile(ballType, this.level());
                } else {
                    return (ICannonProjectile) this.getPassengerInBarrel();
                }
            });
        }
    }

    /**
     * 1.20.1 has no getPassengerAttachmentPoint, the vehicle places its riders
     * itself. Deliberately WITHOUT getMyRidingOffset: both of these points are
     * exact positions on the gun - the muzzle and the spot behind the barrel -
     * and a second offset on top would push the rider off them.
     */
    @Override
    public void positionRider(Entity entity) {
        if (!this.hasPassenger(entity)) return;

        Vec3 attachment;
        if (this.getPassengerInBarrel() == entity) {
            Vector3d endPoint = this.cannon.getBarrelEndPointLocal();
            attachment = new Vec3(endPoint.x, endPoint.y, endPoint.z);
        } else {
            attachment = this.getBarrelPassengerAttachmentPoint();
        }
        entity.setPos(this.getX() + attachment.x, this.getY() + attachment.y, this.getZ() + attachment.z);
    }

    /**
     * The driver stands on the ground behind the carriage, his feet at the height
     * of the gun. The standing (and crouching while aiming) pose itself is only
     * a render matter, see LivingEntityRendererMixin.
     */
    protected Vec3 getBarrelPassengerAttachmentPoint() {
        Vector3f relativePoint = new Vector3f(0,0,-DRIVER_STAND_DISTANCE).rotateAxis(-(float) Math.toRadians(this.getYRot()), 0, 1, 0);
        return new Vec3(relativePoint.x, relativePoint.y, relativePoint.z);
    }

    /**
     * The driver steps off exactly where he stood, behind the carriage.
     *
     * Runs after the passenger was already removed, so getDriver() does not
     * know him anymore - the barrel UUID is still set though and tells the two
     * apart. The barrel passenger keeps the vanilla behaviour.
     */
    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        boolean wasInBarrel = this.getEntityInBarrelUUID().map(uuid -> uuid.equals(livingEntity.getUUID())).orElse(false);
        if (!wasInBarrel) {
            Vec3 standPosition = this.position().add(this.getBarrelPassengerAttachmentPoint());
            Vec3 spot = this.findStandDismountSpot(livingEntity, standPosition);
            if (spot != null) return spot;
        }
        return super.getDismountLocationForPassenger(livingEntity);
    }

    /**
     * @return a safe place to stand at the stand position, or null if there is
     * none (wall or drop behind the gun). Same floor and pose checks as
     * Ship#findSeatDismountSpot.
     */
    @Nullable
    private Vec3 findStandDismountSpot(LivingEntity livingEntity, Vec3 standPosition) {
        BlockPos at = BlockPos.containing(standPosition);
        BlockPos below = at.below();

        List<Vec3> candidates = new ArrayList<>();
        double floor = this.level().getBlockFloorHeight(at);
        if (DismountHelper.isBlockFloorValid(floor)) candidates.add(new Vec3(standPosition.x, at.getY() + floor, standPosition.z));
        double floorBelow = this.level().getBlockFloorHeight(below);
        if (DismountHelper.isBlockFloorValid(floorBelow)) candidates.add(new Vec3(standPosition.x, below.getY() + floorBelow, standPosition.z));

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

    /**
     * Seems to be only executed on client side.
     * @param entity
     */
    @Override
    public void onPassengerTurned(Entity entity) {
        super.onPassengerTurned(entity);
        // the cannon is aimed with keys only now, the driver's view is free -
        // the former slow-turn drag of the passenger rotation was removed.
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.CANNON);
    }

    /**
     * @return the controlling passenger.
     * For some reason when overriding {@link #getControllingPassenger()} it cannot be controlled on rails anymore.
     */
    @Nullable
    public Entity getDriver() {
        for (Entity passenger : this.getPassengers()) {
            if (passenger != this.getPassengerInBarrel()) {
                return passenger;
            }
        }

        return null;
    }

    @Nullable
    public Entity getPassengerInBarrel() {
        Optional<UUID> uuid = this.getEntityInBarrelUUID();
        if (uuid.isEmpty()) return null;
        if (this.getPassengers().isEmpty()) return null;

        for (Entity passenger : this.getPassengers()) {
            if (passenger.getUUID().equals(uuid.get())) {
                return passenger;
            }
        }

        return null;
    }

    protected void cleanEntityInBarrelUUID() {
        if (this.getPassengers().isEmpty() || this.getPassengerInBarrel() == null) {
            this.setEntityInBarrelUUID(null);
        }
    }

    public static GroundCannonEntity factory(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        return new GroundCannonEntity(entityType, level);
    }

    @Override
    public void consumeCannonBall() {
        Entity driver = this.getDriver();
        if (driver == null || (driver instanceof Player player && player.isCreative())) return;

        if (driver instanceof ICannonBallSource container) {
            container.consumeCannonBall();
        } else if (driver instanceof Player player) {
            CannonAmmoSelection.consumePreferred(player, player.getInventory().items, null);
        }
    }


    /**
     * Tries to consume one fine grain powder from the driver's inventory.
     * @return true if consumed, the shot then gains 50% projectile speed.
     */
    public boolean consumeFineGrainPowder() {
        if (this.getDriver() instanceof Player player) {
            if (player.isCreative()) return false;
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.is(ModItems.FINE_GRAIN_POWDER)) {
                    itemstack.shrink(1);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Peeks whether a fine grain powder is available WITHOUT consuming it.
     * Used client side for the trajectory preview - the actual shot uses
     * consumeFineGrainPowder(), which shrinks the stack.
     *
     * Mirrors consumeFineGrainPowder: only the driver's inventory is checked,
     * and creative drivers never consume powder, so they never get the bonus.
     *
     * @return true if a fine grain powder is in the driver's inventory
     */
    public boolean hasFineGrainPowder() {
        if (this.getDriver() instanceof Player player) {
            if (player.isCreative()) return false;
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.is(ModItems.FINE_GRAIN_POWDER)) return true;
            }
        }
        return false;
    }

    /**
     * The projectile speed multiplier of the NEXT shot: the loaded ball type's
     * own multiplier, times 1.5 if a fine grain powder is available. Single
     * source of truth so the trajectory preview matches the real shot (see
     * trigger). Returns the BALL default when nothing is loaded, which also
     * covers the entity-in-barrel case.
     *
     * @param peekFineGrain true = only check for fine grain (preview), false =
     *                      caller consumes it separately (real shot uses
     *                      consumeFineGrainPowder instead)
     */
    /**
     * The spawn point of the shot relative to the entity position, for a given
     * view. Same point as Cannon#getBarrelEndPointLocal, but for a yaw and pitch
     * the cannon has not reached yet - the trajectory preview follows the view
     * within the partial ticks.
     *
     * @param yaw   in Minecraft convention, as getYRot
     * @param pitch in Minecraft convention, negative = up
     */
    public static Vec3 getMuzzleOffset(float yaw, float pitch) {
        Vec3 pivot = Vec3.directionFromRotation(0.0F, yaw).scale(TRUNNION_FORWARD).add(0.0D, TRUNNION_HEIGHT, 0.0D);
        return pivot.add(Vec3.directionFromRotation(pitch, yaw).scale(MUZZLE_DISTANCE));
    }

    public float getShotSpeedMultiplier(boolean peekFineGrain) {
        // an entity in the barrel is always shot at base speed, no ammo is loaded
        CannonBallItem ammo = this.getPassengerInBarrel() == null ? this.getCannonBallToShoot() : null;
        float multiplier = ammo != null ? ammo.getType().speedMultiplier : CannonBallItem.Type.BALL.speedMultiplier;
        if (peekFineGrain && this.hasFineGrainPowder()) multiplier *= 1.5F;
        return multiplier;
    }

    @Override
    public ParticleOptions provideShootParticles() {
        if (this.getDye() != null) {
            return new DyedCannonShootOptions(this.getDye());
        }
        return ModParticleTypes.CANNON_SHOOT.get();
    }

    @Override
    public void playSoundAt(SoundEvent soundEvent, float volumeMultiplier, float pitch) {
        this.playSound(soundEvent, volumeMultiplier, pitch);
    }

    @Override
    public Level getLevel() {
        return this.level();
    }

    @Override
    public CannonBallItem getCannonBallToShoot() {
        if (this.getDriver() == null) return null;

        if (this.getDriver() instanceof ICannonBallSource container) {
            return container.getCannonBallToShoot();
        } else if (this.getDriver() instanceof Player player) {
            return CannonAmmoSelection.findPreferred(player, player.getInventory().items, null);
        } else {
            return null;
        }
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
    public void setSpeed(float speed) {
        entityData.set(SPEED, speed);
    }

    public float getSpeed(){
        return entityData.get(SPEED);
    }

    public void setHealth(float health) {
        entityData.set(HEALTH, Mth.clamp(health, 0.0F, this.getMaxHealth()));
    }

    public float getHealth(){
        return entityData.get(HEALTH);
    }

    public boolean isForward() {
        if (this.getDriver() == null) {
            return false;
        }
        return entityData.get(FORWARD);
    }

    public boolean isBackward() {
        if (this.getDriver() == null) {
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

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        }
        // the gun crew cannot damage its own cannon - a shot that clips the
        // carriage on its way out of the barrel is still the drivers' shot
        else if (damageSource.getEntity() != null && this.hasPassenger(damageSource.getEntity())) {
            return false;
        }
        else if (!this.getCommandSenderWorld().isClientSide() && !this.isRemoved()) {
            this.setHealth(this.getHealth() - f);
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());

            boolean bl = damageSource.getEntity() instanceof Player player && player.getAbilities().instabuild && player.isCrouching();

            if (this.getHealth() <= 0.0F) {
                kill();
            }
            if(bl){
                this.discard();
            }

            return true;
        } else {
            return true;
        }
    }

    public void kill() {
        super.kill();
        if(!this.getLevel().isClientSide()){
            if(inventory != null)this.spawnAtLocation(this.inventory.getItem(0));
        }
    }

    public boolean canCollideWith(Entity entity) {
        return canVehicleCollide(this, entity);
    }

    public static boolean canVehicleCollide(Entity entity, Entity entity2) {
        return (entity2.canBeCollidedWith() || entity2.isPushable()) && !entity.isPassengerOfSameVehicle(entity2);
    }

    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean isPushable() {
        return true;
    }

    public float getWheelRotationAmount() {
        return 120F * getSpeed();
    }

    public void updateWheelRotation() {
        wheelRotation += getWheelRotationAmount();
    }

    public float getWheelRotation(float partialTicks) {
        return wheelRotation + getWheelRotationAmount() * partialTicks;
    }


    private void tickLerp() {
        if (this.isControlledByLocalInstance()) {
            this.steps = 0;
            this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
        }

        if (this.steps > 0) {
            double d0 = getX() + (clientX - getX()) / (double) steps;
            double d1 = getY() + (clientY - getY()) / (double) steps;
            double d2 = getZ() + (clientZ - getZ()) / (double) steps;
            double d3 = Mth.wrapDegrees(clientYaw - (double) getYRot());
            setYRot((float) ((double) getYRot() + d3 / (double) steps));
            setXRot((float) ((double) getXRot() + (clientPitch - (double) getXRot()) / (double) steps));
            --steps;
            setPos(d0, d1, d2);
            setRot(getYRot(), getXRot());
        }
    }

    protected boolean updateInWaterStateAndDoFluidPushing() {
        return false;
    }

    public boolean canBeHitByProjectile() {
        return true;
    }

    public boolean isPickable() {
        return true;
    }

    public float getMaxHealth() {
        return 100.00F;
    }
}