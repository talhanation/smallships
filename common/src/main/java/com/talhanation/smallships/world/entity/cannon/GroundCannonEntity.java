package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundEnterCannonBarrelPacket;
import com.talhanation.smallships.network.packet.ServerboundShootGroundCannonPacket;
import com.talhanation.smallships.network.packet.ServerboundUdpateGroundCannonControlPacket;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.level.storage.loot.LootTable;
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
public class GroundCannonEntity extends Entity implements ICannon, ContainerEntity, HasCustomInventoryScreen{
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
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> HEALTH = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.FLOAT);
    @Nullable
    private ResourceKey<LootTable> lootTable;
    private long lootTableSeed;
    private final Cannon cannon = new Cannon(this);
    public float maxSpeedInKmH = 7F;// 7km/h
    /** barrel elevation speed in degrees per tick (key-only aiming) */
    private static final float BARREL_PITCH_SPEED = 0.75F;
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

    public SimpleContainer inventory;

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.cannon.setPitchBounds(-60.0F, 20.0F);
        this.setPos(pos);
        recalculateBoundingBox();
        this.inventory = new SimpleContainer(1);
    }

    public GroundCannonEntity(EntityType<? extends Entity> entityType, Level level) {
        super(entityType, level);
        this.cannon.setPitchBounds(-60.0F, 20.0F);
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        builder.define(UUID, Optional.empty());
        builder.define(DYE, "");
        builder.define(FORWARD, false);
        builder.define(BACKWARD, false);
        builder.define(LEFT, false);
        builder.define(RIGHT, false);
        builder.define(BARREL_UP, false);
        builder.define(BARREL_DOWN, false);
        builder.define(AIMING, false);
        builder.define(SPEED, 0F);
        builder.define(HEALTH, 100F);
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
            inventory.getItem(0).save(this.registryAccess(), compoundTag);

            tag.put("Inventory", compoundTag);
        }
        DyeColor dye;
        if ((dye = this.getDye()) != null) tag.putString("Dye", dye.getSerializedName());
        this.getEntityInBarrelUUID().ifPresent(uuid -> tag.putUUID("EntityInBarrelUUID", uuid));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        if(tag.contains("Inventory")){
            inventory.setItem(0, ItemStack.parse(this.registryAccess(), tag.getCompound("Inventory")).orElse(ItemStack.EMPTY));
        }
        if (tag.contains("Dye")) {
            this.setDye(DyeColor.byName(tag.getString("Dye"), null));
        }
        if (tag.contains("EntityInBarrelUUID")) {
            this.setEntityInBarrelUUID(tag.getUUID("EntityInBarrelUUID"));
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
        }
        this.drivenPrevTick = isDriven;

        control(driver, xRot, yRot);

        this.cannon.tick(this.getX(), this.getY(), this.getZ(), -this.getYRot(), this.getXRot());
        this.testEntityIntersection();

        recalculateBoundingBox();
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
        if(driver != null) {

            if (isForward()) {
                if (speed <= maxSpeed) {
                    speed = Math.min(speed + 0.01F, maxSpeed);
                }
            }

            if (isBackward()) {
                if (speed >= -maxSpeed) {
                    speed = Math.max(speed - 0.01F, -maxSpeed);
                }
            }
            // aim mode (right click held, SiegeWeapons ballista style): the cannon
            // follows the driver's view, the camera sits behind the barrel.
            if (this.isAiming()) {
                this.setYRot(driver.getYRot());
                this.setXRot(Math.clamp(driver.getXRot(), -60, 20));
                return;
            }

            // otherwise key controls: A/D rotate the cannon around its own axis,
            // the barrel up/down keys change the elevation.
            deltaRotation = 0;
            if(isLeft()){
                --deltaRotation;
            }
            if(isRight()){
                ++deltaRotation;
            }
            float newYRot = yRot + this.deltaRotation;

            if (isBarrelUp()) {
                xRot -= BARREL_PITCH_SPEED;
            }
            if (isBarrelDown()) {
                xRot += BARREL_PITCH_SPEED;
            }
            xRot = Math.clamp(xRot, -60, 20);

            this.setXRot(xRot);
            this.setYRot(newYRot);
        }
        else {
            setForward(false);
            setBackward(false);
            setLeft(false);
            setRight(false);
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
        if (this.getCommandSenderWorld().isClientSide && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(this.isForward(), this.isBackward(), this.isLeft(), this.isRight(), aiming));
        }
    }

    private boolean isAimingRaw() {
        return entityData.get(AIMING);
    }

    /**
     * Key-only barrel elevation. Kept separate from updateControls so the
     * reflection signature used by the Workers/Recruits mod stays stable.
     */
    public void updateBarrelControls(@Nullable LivingEntity livingEntity) {
        boolean needsUpdate = false;

        if (this.getCommandSenderWorld().isClientSide && needsUpdate && livingEntity instanceof Player) {
            ModPackets.clientSendPacket(new ServerboundUdpateGroundCannonControlPacket(this.isForward(), this.isBackward(), this.isLeft(), this.isRight(), this.isAimingRaw()));
        }
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
                if (this.consumeFineGrainPowder()) {
                    speedMultiplier *= 1.5F;
                }
                this.cannon.setSpeedMultiplier(speedMultiplier);
            } else {
                this.cannon.setSpeedMultiplier(1.0F);
            }

            this.cannon.triggerFuze(triggeredBy, () -> {
                if (cannonBallToShoot != null) {
                    CannonBallEntity ball = new CannonBallEntity(this.level());
                    ball.setBallType(ballType);
                    return ball;
                } else {
                    return (ICannonProjectile) this.getPassengerInBarrel();
                }
            });
        }
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        if (this.getPassengerInBarrel() == entity) {
            Vector3d endPoint = this.cannon.getBarrelEndPointLocal();
            return new Vec3(endPoint.x, endPoint.y, endPoint.z);
        } else {
            return this.getBarrelPassengerAttachmentPoint();
        }
    }

    protected Vec3 getBarrelPassengerAttachmentPoint() {
        Vector3f relativePoint = new Vector3f(0,0,-0.5F).rotateAxis(-(float) Math.toRadians(this.getYRot()), 0, 1, 0);
        return new Vec3(relativePoint.x, relativePoint.y, relativePoint.z);
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
        if (driver == null || (driver instanceof LivingEntity livingDriver && livingDriver.hasInfiniteMaterials())) return;

        if (driver instanceof ICannonBallSource container) {
            container.consumeCannonBall();
        } else if (this.getDriver() instanceof Player player) {
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.getItem() instanceof CannonBallItem) {
                    itemstack.shrink(1);
                    break;
                }
            }
        }
    }


    /**
     * Tries to consume one fine grain powder from the driver's inventory.
     * @return true if consumed, the shot then gains 50% projectile speed.
     */
    public boolean consumeFineGrainPowder() {
        if (this.getDriver() instanceof Player player) {
            if (player.hasInfiniteMaterials()) return false;
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.is(ModItems.FINE_GRAIN_POWDER)) {
                    itemstack.shrink(1);
                    return true;
                }
            }
        }
        return false;
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
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.getItem() instanceof CannonBallItem cannonBallItem) return cannonBallItem;
            }
            return null;
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

    public void setHealth(float speed) {
        entityData.set(HEALTH, speed);
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
        else if (!this.getCommandSenderWorld().isClientSide() && !this.isRemoved()) {
            this.setHealth(this.getHealth() - f);
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());

            boolean bl = damageSource.getEntity() instanceof Player player && player.getAbilities().instabuild && player.isCrouching();

            if (this.getHealth() <= this.getMaxHealth()) {
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

    //IContainerEntity Stuff//
    @Override
    public @Nullable ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long l) {
        this.lootTableSeed = l;
    }

    @Override
    public @NotNull NonNullList<ItemStack> getItemStacks() {
        return this.inventory.getItems();
    }

    @Override
    public void clearItemStacks() {
        this.inventory.getItems().clear();
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public @NotNull ItemStack getItem(int i) {
        return this.getChestVehicleItem(i);
    }

    @Override
    public @NotNull ItemStack removeItem(int i, int j) {
        return this.removeChestVehicleItem(i, j);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int i) {
        return this.removeChestVehicleItemNoUpdate(i);
    }

    @Override
    public void setItem(int i, @NotNull ItemStack itemStack) {
        this.setChestVehicleItem(i, itemStack);
    }

    @Override
    public @NotNull SlotAccess getSlot(int n) {
        return this.getChestVehicleSlot(n);
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.isChestVehicleStillValid(player);
    }

    @Override
    public void clearContent() {
        this.clearChestVehicleContent();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
        if (this.lootTable == null || !player.isSpectator()) {
            this.unpackChestVehicleLootTable(inventory.player);
            this.openCustomInventoryScreen(player);
        }
        return null;
    }

    @Override
    public void openCustomInventoryScreen(@NotNull Player player) {
        ContainerUtility.openCannonMenu(player, this);
        if (!player.level().isClientSide()) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);//lol
        }
    }
}