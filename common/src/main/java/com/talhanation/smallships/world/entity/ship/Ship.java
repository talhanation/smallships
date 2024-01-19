package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.damagesource.ModDamageSourceTypes;
import com.talhanation.smallships.world.entity.projectile.Cannon;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
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
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
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
    public static final EntityDataAccessor<CompoundTag> SHIELD_DATA = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    private boolean sunken;
    private int sunkenTime = 0;
    private float prevWaveAngle;
    private float waveAngle;
    public float prevBannerWaveAngle;
    public float bannerWaveAngle;
    protected boolean cannonKeyPressed;
    public int sailStateCooldown = 0;
    private float setPoint;
    public final List<Cannon> CANNONS = new ArrayList<>();
    public final Stack<ItemStack> SHIELDS = new Stack<>();
    public float maxSpeed;
    private CameraType previousCameraType;

    public Ship(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
        if (this.getCustomName() == null) this.setCustomName(Component.literal(StringUtils.capitalize(EntityType.getKey(this.getType()).getPath())));
        this.maxUpStep = 0.6F;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() + 1.0F);
        }

        if(isSunken()){
            if(++this.sunkenTime > SmallShipsConfig.Common.shipGeneralDespawnTimeSunken.get()*20*60) this.destroy(DamageSource.DROWN);
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
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(SPEED, 0.0F);
        this.getEntityData().define(ROT_SPEED, 0.0F);
        this.getEntityData().define(ATTRIBUTES, this.createDefaultAttributes());
        this.getEntityData().define(FORWARD, false);
        this.getEntityData().define(BACKWARD, false);
        this.getEntityData().define(LEFT, false);
        this.getEntityData().define(RIGHT, false);

        if (this instanceof Sailable sailShip) sailShip.defineSailShipSynchedData();
        if (this instanceof Bannerable bannerShip) bannerShip.defineBannerShipSynchedData();
        if (this instanceof Cannonable cannonShip) cannonShip.defineCannonShipSynchedData();
        if (this instanceof Shieldable shieldShip) shieldShip.defineShieldShipSynchedData();
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
    }

    public <T> T getData(EntityDataAccessor<T> accessor) {
        return this.getEntityData().get(accessor);
    }

    public <T> void setData(EntityDataAccessor<T> accessor, T value) {
        this.getEntityData().set(accessor, value);
    }

    @Override
    protected void controlBoat() {
        Attributes attributes = this.getAttributes();
        float speedModifier =
                (1 + (this.getBiomeModifier()/100)) *
                (1 - (this instanceof Cannonable cannonShip? cannonShip.getCannonModifier()/100 : 0.0F)) *
                (1 - (this instanceof ContainerShip containerShip? containerShip.getContainerModifier()/100 : 0.0F)) *
                (1 + (this instanceof Paddleable paddleShip? paddleShip.getPaddlingModifier()/100 : 0.0F));

        this.maxSpeed = (attributes.maxSpeed / (60F * 1.15F)) * speedModifier;
        float maxRotSp = (attributes.maxRotationSpeed * 0.1F + 1.8F);
        float acceleration = attributes.acceleration;
        float rotAcceleration = attributes.rotationAcceleration;

        //SmallShipsMod.LOGGER.info("Speed kmh: " +  Kalkuel.getKilometerPerHour(this.getSpeed()));

        if(this.level.isClientSide() && !this.isSunken()){
            Player player = getDriver();
            if(player != null)
                updateControls(((BoatAccessor) this).isInputUp(),((BoatAccessor) this).isInputDown(), ((BoatAccessor) this).isInputLeft(), ((BoatAccessor) this).isInputRight(), player);
        }

        if(this.isInWater() && !((BoatLeashAccess) this).isLeashed() && !this.isSunken()){
            if(this instanceof Paddleable && this instanceof Sailable sailShip){
                if(isForward() && getDriver() != null){
                    setPoint = (maxSpeed * 12/16F) * (1 + (1 + sailShip.getSailState()) * 0.1F);
                } else
                    switch (sailShip.getSailState()){ // Speed depending on sail state
                    case 0 -> setPoint =  0;
                    case 1 -> setPoint = maxSpeed * 4/16F;
                    case 2 -> setPoint = maxSpeed * 8/16F;
                    case 3 -> setPoint = maxSpeed * 12/16F;
                    case 4 -> setPoint = maxSpeed * 16/16F;
                }
            }
            else if (this instanceof Sailable sailShip) {
                switch (sailShip.getSailState()){ // Speed depending on sail state
                    case 0 -> setPoint =  0;
                    case 1 -> setPoint = maxSpeed * 4/16F;
                    case 2 -> setPoint = maxSpeed * 8/16F;
                    case 3 -> setPoint = maxSpeed * 12/16F;
                    case 4 -> setPoint = maxSpeed * 16/16F;
                }
            }
            this.calculateSpeed(acceleration);

            //CALCULATE ROTATION SPEED//
            //((BoatAccessor) this).setDeltaRotation(0); // IDK WHAT THIS IS FOR BUT IT WORKS WITHOUT IT
            float rotationSpeed = Kalkuel.subtractToZero(getRotSpeed(), getVelocityResistance() * 2.5F);

            if(getDriver() != null) {
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
            }
            this.setRotSpeed(rotationSpeed);

            ((BoatAccessor) this).setDeltaRotation(rotationSpeed);
            setYRot(getYRot() + ((BoatAccessor) this).getDeltaRotation());


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
    }

    private void calculateSpeed(float acceleration) {
        // If there is no interaction the speed should get reduced
        float speed = this.getSpeed();
        if(speed < setPoint){
            speed = Kalkuel.addToSetPoint(speed, acceleration, setPoint); //getVelocityResistance() * 0.5F
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
        BiomeModifierType biomeModifierType = this.getBiomeModifierType();
        if (biomeModifierType == BiomeModifierType.NONE) return 0.0F;

        BlockPos pos = new BlockPos(this.getX(), this.getY(), this.getZ());
        float tmp = this.getLevel().getBiome(pos).value().getBaseTemperature();
        float modifier = SmallShipsConfig.Common.shipGeneralBiomeModifier.get().floatValue();

        return switch (biomeModifierType) {
            case COLD -> modifier * -tmp;
            case NEUTRAL -> modifier * (-2 * Double.valueOf(Math.pow(tmp, 2)).floatValue() + 1);
            case WARM -> modifier * tmp;
            default -> throw new IllegalStateException("Unexpected value: " + biomeModifierType);
        };
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (player.getMainHandItem().is(Items.NAME_TAG) && player.getMainHandItem().hasCustomHoverName() && !player.getCommandSenderWorld().isClientSide){
            this.setCustomName(player.getMainHandItem().getHoverName());
            this.setCustomNameVisible(false);
            if(!player.isCreative()) player.getMainHandItem().shrink(1);
            return InteractionResult.SUCCESS;
        }
        if (this instanceof Cannonable cannonShip && cannonShip.interactCannon(player, interactionHand)) return InteractionResult.SUCCESS;
        if (this instanceof Sailable sailShip && sailShip.interactSail(player, interactionHand)) return InteractionResult.SUCCESS;
        if (this instanceof Bannerable bannerShip && bannerShip.interactBanner(player, interactionHand)) return InteractionResult.SUCCESS;
        if (this instanceof Shieldable shieldShip && shieldShip.interactShield(player, interactionHand)) return InteractionResult.SUCCESS;
        return super.interact(player, interactionHand);
    }

    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        if (this instanceof Sailable sailShip && sailShip.getSailState() != 0) sailShip.toggleSail();
        return super.getDismountLocationForPassenger(livingEntity);
    }

    @Override
    protected void addPassenger(Entity entity) {
        // Auto third person: Enable
        if (this.getLevel().isClientSide() && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get() && Objects.equals(Minecraft.getInstance().player, entity)) {
            this.previousCameraType = Minecraft.getInstance().options.getCameraType();
            Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
        }
        super.addPassenger(entity);
    }

    @Override
    protected void removePassenger(Entity entity) {
        // Auto third person: Disable
        if (this.getLevel().isClientSide() && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get() && Objects.equals(Minecraft.getInstance().player, entity)) {
            Minecraft.getInstance().options.setCameraType(this.previousCameraType);
        }
        super.removePassenger(entity);
    }

    public void setSunken(boolean sunken){
        this.sunken = sunken;
    }
    public boolean isSunken(){
        return sunken;
    }
    @Override
    public double getPassengersRidingOffset() {
        return (double)this.getBbHeight() * 0.75D;
    }

    private void updateWaveAngle(){
        this.prevWaveAngle = this.waveAngle;
        this.waveAngle = (float) Math.sin(getWaveSpeed() * (float) this.tickCount) * getWaveFactor();
    }

    private float getWaveFactor() {
        return this.getLevel().isRaining() ? 3F : 1.25F;
    }

    private float getWaveSpeed() {
        return this.getLevel().isRaining() ? 0.12F : 0.03F;
    }

    public float getWaveAngle(float partialTicks) {
        return Mth.lerp(partialTicks, this.prevWaveAngle, this.waveAngle);
    }

    public Attributes getAttributes() {
        Attributes attributes = new Attributes();
        attributes.loadSaveData(this.getData(ATTRIBUTES));
        return attributes;
    }
    public void setCannonKeyPressed(boolean b){
        cannonKeyPressed = b;
    }
    public boolean isCannonKeyPressed() {
        return cannonKeyPressed;
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
     * Natural slowdown of the ship
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
                this.getLevel().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_SWIM, this.getSoundSource(), 0.05F, 0.8F + 0.4F * this.random.nextFloat());
            }
        }
    }

    private void updateWaterMobs() {
        double radius = SmallShipsConfig.Common.waterAnimalFleeRadius.get();
        List<WaterAnimal> waterAnimals = this.getLevel().getEntitiesOfClass(WaterAnimal.class, new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius));
        for (WaterAnimal waterAnimal : waterAnimals) {
            fleeEntity(waterAnimal);
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
            Vec3 vec = getDeltaMovement();
            this.setDeltaMovement(getDeltaMovement().add(0, 0.2, 0));
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        }
        else if (!this.getLevel().isClientSide() && !this.isRemoved()) {
            this.setDamage(this.getDamage() + f * (this instanceof Shieldable shieldShip ? shieldShip.getDamageModifier() : 1));
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());

            boolean bl = damageSource.getEntity() instanceof Player player && player.getAbilities().instabuild && player.isCrouching();

            if (this.getDamage() > this.getAttributes().maxHealth) {
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
            List<Entity> list = this.level.getEntities(this, boundingBox, EntitySelector.pushableBy(this));
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
        if (canDoCollisionDamage() && speed > 0.1F) {
            float damage = speed * SmallShipsConfig.Common.shipGeneralCollisionDamage.get().floatValue();
            if(damage > 0) entity.hurt(ModDamageSourceTypes.shipCollision(this, this.getControllingPassenger()), damage);
        }

    }
    @Nullable
    public Player getDriver() {
        List<Entity> passengers = getPassengers();
        if (passengers.isEmpty()) {
            return null;
        }

        if (passengers.get(0) instanceof Player player) {
            if(this.level.isClientSide){
                Minecraft minecraft = Minecraft.getInstance();
                Player instancePlayer = minecraft.player;

                return player.equals(instancePlayer) ? player : null;
            }
            else return (Player) passengers.get(0);
        }

        return null;
    }

    public void updateControls(boolean forward, boolean backward, boolean left, boolean right, Player player) {
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
        if (this.level.isClientSide && needsUpdate) {
            ModPackets.clientSendPacket(player, ModPackets.serverUpdateShipControl.apply(forward, backward, left, right));
        }
    }
    @Override
    public void destroy(@NotNull DamageSource damageSource) {
        super.destroy(damageSource);
        if (this.getLevel().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
            if(this instanceof ContainerShip containerShip) containerShip.chestVehicleDestroyed(damageSource, this.getLevel(), this);
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