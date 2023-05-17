package com.talhanation.smallships.world.entity.ship;

import com.google.common.collect.ImmutableSet;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.damagesource.ModDamageSourceTypes;
import com.talhanation.smallships.world.entity.projectile.Cannon;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private float prevWaveAngle;
    private float waveAngle;
    public float prevBannerWaveAngle;
    public float bannerWaveAngle;
    protected boolean cannonKeyPressed;
    public int sailStateCooldown = 0;
    private float setPoint;
    public List<Cannon> CANNONS = new ArrayList<>();

    public Ship(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
        if (this.getCustomName() == null) this.setCustomName(Component.literal(StringUtils.capitalize(EntityType.getKey(this.getType()).getPath())));
        this.maxUpStep = 0.6F;
    }

    @Override
    public void tick() {
        super.tick();

        //SmallShipsMod.LOGGER.info("Speed: " + this.getSpeed());// Debug the speed

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() + 1.0F); //TODO: Replace with Mixin for performance
        }

        if (this instanceof Sailable sailShip) sailShip.tickSailShip();
        if (this instanceof Bannerable bannerShip) bannerShip.tickBannerShip();
        if (this instanceof Cannonable cannonShip) cannonShip.tickCannonShip();
        if (this instanceof Paddleable paddleShip) paddleShip.tickPaddleShip();

        if (sailStateCooldown > 0) sailStateCooldown--;

        boolean isCruising = (getSpeed() > 0.085F || getSpeed() < -0.085F);
        this.updateShipAmbience(isCruising);
        this.updateCollision(isCruising);
        this.updateWaveAngle();
        this.updateWaterMobs();
        this.floatUp();
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
    }

    public <T> T getData(EntityDataAccessor<T> accessor) {
        return this.getEntityData().get(accessor);
    }

    public <T> void setData(EntityDataAccessor<T> accessor, T value) {
        this.getEntityData().set(accessor, value);
    }

    public float getKilometerPerHour() {
        return (this.getSpeed() * 20 * 60 * 60) / 1000;
    }

    @Override
    protected void controlBoat() {
        if(this.level.isClientSide()){
            if(this.getControllingPassenger() instanceof Player player)
                updateControls(((BoatAccessor) this).isInputUp(),((BoatAccessor) this).isInputDown(), ((BoatAccessor) this).isInputLeft(), ((BoatAccessor) this).isInputRight(), player);
        }

        if(this.isInWater()){
            SmallShipsMod.LOGGER.info("Speed kmh: " + getKilometerPerHour());
            SmallShipsMod.LOGGER.info("getBiomesModifier: " + getBiomesModifier());
            SmallShipsMod.LOGGER.info("getCannonModifier: " + getCannonModifier());
            SmallShipsMod.LOGGER.info("getCargoModifier: " + getCargoModifier());
            Attributes attributes = this.getAttributes();
            float modifier = 1 - (getBiomesModifier() + getCannonModifier() + getCargoModifier());

            float maxSpeed = (attributes.maxSpeed / (12F * 1.15F)) * modifier;
            float maxBackSp = attributes.maxReverseSpeed;
            float maxRotSp = (attributes.maxRotationSpeed * 0.1F + 1.8F);
            float acceleration = attributes.acceleration ;
            float rotAcceleration = attributes.rotationAcceleration;

            //CALCULATE SPEED//
            //Speed calc dependent on sail or paddle
            //Speed needs to calculate before rotation because fabric is shit
            if(this instanceof Paddleable){
                if(isForward()){
                    setPoint = (maxSpeed * 12/16F) * (1 + (int) getSailState() * 0.1F);
                }
            }
            else{
                switch (this.getSailState()){ // Speed depending on sail state
                    case 0 -> setPoint =  0;
                    case 1 -> setPoint = maxSpeed * 4/16F;
                    case 2 -> setPoint = maxSpeed * 8/16F;
                    case 3 -> setPoint = maxSpeed * 12/16F;
                    case 4 -> setPoint = maxSpeed * 16/16F;
                }
            }
            this.calculateSpeed(acceleration, this.getSailState());

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
            setYRot(getYRot() + ((BoatAccessor) this).getDeltaRotation());

            //CONTROL SAIL STATE//
            if(this instanceof Sailable sailShip)
                this.controlSailState(sailShip, this.getSailState());

            //Paddle
            if (this instanceof Paddleable paddleShip) paddleShip.controlBoatPaddleShip();

            //SET
            setDeltaMovement(Kalkuel.calculateMotionX(this.getSpeed(), this.getYRot()), 0.0F, Kalkuel.calculateMotionZ(this.getSpeed(), this.getYRot()));
        }
        else {
            setForward(false);
            setBackward(false);
            setLeft(false);
            setRight(false);
        }
    }

    private void controlSailState(Sailable sailShip, byte sailState) {
        if(sailState != 0){
            if (isForward()) {
                if (sailState != 4) {
                    if(this.sailStateCooldown == 0){
                        sailState++;
                        sailShip.playSailSound(sailState);
                        this.sailStateCooldown = sailShip.getSailStateCooldown();
                    }
                }
            }

            if (isBackward()) {
                if (sailState != 1) {
                    if(this.sailStateCooldown == 0) {
                        sailState--;
                        sailShip.playSailSound(sailState);
                        this.sailStateCooldown = sailShip.getSailStateCooldown();
                    }
                }
            }

            this.setSailState(sailState);
        }
    }

    private void calculateSpeed(float acceleration, byte sailState) {
        // If there is no interaction the speed should get reduced
        float speed;
        if(sailState != 0 || (this.isForward() && this instanceof Paddleable)){
            speed = Kalkuel.changeToSetPoint(this.getSpeed(), acceleration, getVelocityResistance() * 0.5F, setPoint);
        }
        else
            speed = Kalkuel.subtractToZero(this.getSpeed(), getVelocityResistance() * 0.8F);

        if (isLeft() || isRight()) { // Speed decrease when rotating
            speed = speed * (1F - (Mth.abs(getRotSpeed()) * 0.025F));
        }

        this.setSpeed(speed);
    }

    public float getSpeed() {
        return entityData.get(SPEED);
    }
    public float getRotSpeed() {
        return entityData.get(ROT_SPEED);
    }
    public void setSailState(byte state) {
        this.setData(SAIL_STATE, state);
    }
    public byte getSailState() {
        return this.getData(SAIL_STATE);
    }
    public void setSpeed(float f) {
        this.entityData.set(SPEED, f);
    }
    public void setRotSpeed(float f) {
        this.entityData.set(ROT_SPEED, f);
    }
    public void setCannonCount(byte x) {
        this.entityData.set(CANNON_COUNT, x);
    }
    public byte getCannonCount() {
        return entityData.get(CANNON_COUNT);
    }

    public void setForward(boolean forward) {
        entityData.set(FORWARD, forward);
    }

    public void setBackward(boolean backward) {
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

    public static final ImmutableSet<ResourceKey<Biome>> COLD_BIOMES = ImmutableSet.of(
            Biomes.COLD_OCEAN,
            Biomes.DEEP_COLD_OCEAN,
            Biomes.FROZEN_OCEAN,
            Biomes.DEEP_FROZEN_OCEAN,
            Biomes.FROZEN_RIVER
    );

    public static final ImmutableSet<ResourceKey<Biome>> WARM_BIOMES = ImmutableSet.of(
            Biomes.WARM_OCEAN,
            Biomes.LUKEWARM_OCEAN,
            Biomes.DEEP_LUKEWARM_OCEAN
    );

    public static final ImmutableSet<ResourceKey<Biome>> NEUTRAL_BIOMES = ImmutableSet.of(
            Biomes.OCEAN,
            Biomes.DEEP_OCEAN,
            Biomes.RIVER
    );

    public float getBiomesModifier() {
        int biomeType = this.getBiomesModifierType(); // 0 = cold; 1 = neutral; 2 = warm;
        BlockPos pos = new BlockPos(getX(), getY() - 0.1D, getZ());
        Optional<ResourceKey<Biome>> biome = this.level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getResourceKey(level.getBiome(pos).value());;


        if(biome.isPresent()) {
            boolean coldBiomes = COLD_BIOMES.contains(biome.get());;
            boolean neutralBiomes = NEUTRAL_BIOMES.contains(biome.get());
            boolean warmBiomes = WARM_BIOMES.contains(biome.get());

            boolean coldType = biomeType == 0;
            boolean neutralType = biomeType == 1;
            boolean warmType = biomeType == 2;

            if (coldBiomes && coldType || warmBiomes && warmType || neutralBiomes && neutralType) {
                return -0.2F;
            }
            else if (
                    (coldBiomes && warmType || warmBiomes && coldType) || ((coldBiomes || warmBiomes) && neutralType)) {
                return 0.2F;
            }
            else if (neutralBiomes && warmType || neutralBiomes && coldType) {
                return 0.1F;
            }
            else
                return 0;
        }
        return 0;
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (this instanceof Cannonable cannonShip && cannonShip.interactCannon(player, interactionHand)) return InteractionResult.SUCCESS;
        if (this instanceof Sailable sailShip && sailShip.interactSail(player, interactionHand)) return InteractionResult.SUCCESS;
        if (this instanceof Bannerable bannerShip && bannerShip.interactBanner(player, interactionHand)) return InteractionResult.SUCCESS;

        return super.interact(player, interactionHand);
    }
    @Override
    public @NotNull Vec3 getDismountLocationForPassenger(@NotNull LivingEntity livingEntity) {
        if (this instanceof Sailable sailShip && this.getSailState() != 0) sailShip.toggleSail();
        return super.getDismountLocationForPassenger(livingEntity);
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
    protected abstract int getMaxPassengers();
    @Override
    public abstract @NotNull Item getDropItem();
    public abstract int getBiomesModifierType();
    public abstract float getCargoModifier();
    public float getCannonModifier() {
        return (int)this.getCannonCount() * 0.025F;
    }
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
        //if (!SmallShipsConfig.WaterMobFlee.get()) return; //CONFIG
        double radius = 15.0D; //TODO: CONFIG
        List<WaterAnimal> waterAnimals = this.getLevel().getEntitiesOfClass(WaterAnimal.class, new AABB(getX() - radius, getY() - radius, getZ() - radius, getX() + radius, getY() + radius, getZ() + radius));
        for (WaterAnimal waterAnimal : waterAnimals) {
            fleeEntity(waterAnimal);
        }
    }

    private void fleeEntity(Mob entity) {
        double fleeDistance = 10.0D;
        double fleeSpeed = 1.5D; //TODO: CONFIG
        Vec3 vecBoat = new Vec3(getX(), getY(), getZ());
        Vec3 vecEntity = new Vec3(entity.getX(), entity.getY(), entity.getZ());
        Vec3 fleeDir = vecEntity.subtract(vecBoat);
        fleeDir = fleeDir.normalize();
        Vec3 fleePos = new Vec3(vecEntity.x + fleeDir.x * fleeDistance, vecEntity.y + fleeDir.y * fleeDistance, vecEntity.z + fleeDir.z * fleeDistance);
        entity.getNavigation().moveTo(fleePos.x, fleePos.y, fleePos.z, fleeSpeed);
    }

    protected void floatUp(){
        if (this.isEyeInFluid(FluidTags.WATER))
            this.setDeltaMovement(getDeltaMovement().x, 0.2D, getDeltaMovement().z);
    }

    @Override
    public boolean hurt(DamageSource damageSource, float f) {
        if (this.isInvulnerableTo(damageSource)) {
            return false;
        } else if (!this.getLevel().isClientSide() && !this.isRemoved()) {
            //this.setHurtDir(-this.getHurtDir());
            //this.setHurtTime(10);
            this.setDamage(this.getDamage() + f);
            this.markHurt();
            this.gameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getEntity());

            boolean bl = damageSource.getEntity() instanceof Player && ((Player)damageSource.getEntity()).getAbilities().instabuild;

            if (bl || this.getDamage() > this.getAttributes().maxHealth) {
                if (!bl && this.getLevel().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.destroy(damageSource);
                }
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
            entity.setDeltaMovement(getDeltaMovement().add(d2 / d4 * (1.0 + speed), 0.0F, d3 / d4 * (1.0 + speed)));
        }
    }

    private void updateCollision(boolean isCruising){
        if(isCruising) {
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

    private void collisionDamage(Entity entity, float speed) {
        if (speed > 0.1F) {
            float damage = speed * 7.5F;
            entity.hurt(ModDamageSourceTypes.shipCollision(this, this.getControllingPassenger()), damage);
            //SmallShipsMod.LOGGER.info("Damage: " + damage);
        }

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
            ModPackets.clientSendPacket(player, ModPackets.updateShipControl.apply(forward, backward, left, right));
        }
    }
}