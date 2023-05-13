package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.world.damagesource.ModDamageSourceTypes;
import com.talhanation.smallships.world.entity.projectile.Cannon;
import com.talhanation.smallships.world.entity.ship.abilities.Bannerable;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship extends Boat {
    public static final EntityDataAccessor<CompoundTag> ATTRIBUTES = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.COMPOUND_TAG);
    public static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> ROT_SPEED = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> SAIL_STATE = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<String>  SAIL_COLOR = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<ItemStack> BANNER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Float> CANNON_POWER = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Byte> CANNON_COUNT = SynchedEntityData.defineId(Ship.class, EntityDataSerializers.BYTE);

    private float prevWaveAngle;
    private float waveAngle;
    public float prevBannerWaveAngle;
    public float bannerWaveAngle;
    protected boolean cannonKeyPressed;
    public int sailStateCooldown = 0;
    public List<Cannon> CANNONS = new ArrayList<>();

    public Ship(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
        if (this.getCustomName() == null) this.setCustomName(Component.literal(StringUtils.capitalize(EntityType.getKey(this.getType()).getPath())));
        this.maxUpStep = 0.6F;
    }

    @Override
    public void tick() {
        super.tick();
        this.controlBoat();

        //SmallShipsMod.LOGGER.info("Speed: " + this.getSpeed());// Debug the speed

        if (this.getDamage() > 0.0F) {
            this.setDamage(this.getDamage() + 1.0F); //TODO: Replace with Mixin for performance
        }

        if (this instanceof Sailable sailShip) sailShip.tickSailShip();
        if (this instanceof Bannerable bannerShip) bannerShip.tickBannerShip();
        if (this instanceof Cannonable cannonShip) cannonShip.tickCannonShip();
        if (this instanceof Paddleable paddleShip) paddleShip.tickPaddleShip();

        if (sailStateCooldown > 0) sailStateCooldown--;

        // Fixes the data after imminently stop of the ship if the driver ejected
        if ((this.getControllingPassenger() == null)){
            this.setSailState((byte) 0);
            this.setRotSpeed(Kalkuel.subtractToZero(this.getRotSpeed(), getVelocityResistance() * 2.5F));
            this.setSpeed(Kalkuel.subtractToZero(this.getSpeed(), getVelocityResistance()));
        }

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


    @Override
    protected void controlBoat() {
        if(this.isInWater()){
            byte sailstate = this.getSailState();
            Attributes attributes = this.getAttributes();
            float maxSp = (attributes.maxSpeed / (12F * 1.15F));
            float maxBackSp = attributes.maxReverseSpeed;
            float maxRotSp = (attributes.maxRotationSpeed * 0.1F + 1.8F);
            float acceleration = attributes.acceleration;
            float rotAcceleration = attributes.rotationAcceleration;

            //CALCULATE SPEED//
            //Speed calc dependent on sail or paddle
            //Speed needs to calculate before rotation because fabric is shit
            float speed = this.calculateSpeed(this.getSpeed(), acceleration, maxSp, sailstate);
            this.setSpeed(speed);

            //CALCULATE ROTATION SPEED//

            //((BoatAccessor) this).setDeltaRotation(0); // IDK WHAT THIS IS FOR BUT IT WORKS WITHOUT IT
            float rotationSpeed = Kalkuel.subtractToZero(getRotSpeed(), getVelocityResistance() * 2.5F);
            if (((BoatAccessor) this).isInputRight()) {
                if (rotationSpeed < maxRotSp) {
                    rotationSpeed = Math.min(rotationSpeed + rotAcceleration * 1 / 8, maxRotSp);
                }
            }

            if (((BoatAccessor) this).isInputLeft()) {
                if (rotationSpeed > -maxRotSp) {
                    rotationSpeed = Math.max(rotationSpeed - rotAcceleration * 1 / 8, -maxRotSp);
                }
            }
            setRotSpeed(rotationSpeed);
            ((BoatAccessor) this).setDeltaRotation(rotationSpeed);
            setYRot(getYRot() + ((BoatAccessor) this).getDeltaRotation());

            //CONTROL SAIL STATE//
            this.controlSailState(sailstate, speed, rotationSpeed);

            //SET
            setDeltaMovement(Kalkuel.calculateMotionX(this.getSpeed(), this.getYRot()), 0.0F, Kalkuel.calculateMotionZ(this.getSpeed(), this.getYRot()));
        }
    }

    private void controlSailState(byte sailState, float speed, float rotationSpeed) {
        if(sailState != 0){
            //handle sails
            if (((BoatAccessor) this).isInputUp()) {
                if (this instanceof Sailable sailShip && sailState != 4) {
                    Entity entity = this.getControllingPassenger();
                    if(entity instanceof Player player)
                        sailShip.increaseSail(player, speed, rotationSpeed);
                }
            }

            if (((BoatAccessor) this).isInputDown()) {
                if (this instanceof Sailable sailShip && sailState != 1) {
                    Entity entity = this.getControllingPassenger();
                    if (entity instanceof Player player)
                        sailShip.decreaseSail(player, speed, rotationSpeed);
                }
            }
        }
    }

    private float calculateSpeed(float speed, float acceleration, float maxSp, byte sailState) {
        float sollSpeed = 0;

        boolean paddling = this instanceof Paddleable && ((BoatAccessor)this).isInputUp();
        float paddleSpeed = maxSp * 14/16F;

        switch (sailState){ // Speed depending on sail state
            case 0 -> sollSpeed =  0;
            case 1 -> sollSpeed = maxSp * 4/16F;
            case 2 -> sollSpeed = maxSp * 8/16F;
            case 3 -> sollSpeed = maxSp * 11/16F;
            case 4 -> sollSpeed = maxSp * 16/16F;
        }

        if (((BoatAccessor) this).isInputLeft() || ((BoatAccessor) this).isInputRight()) { // Speed decrease when rotating
            sollSpeed = sollSpeed * (1.0F - (Mth.abs(getRotSpeed()) * 0.02F));
        }

        speed = Kalkuel.changeToSoll(speed, acceleration, getVelocityResistance(), sollSpeed);

        return speed;
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

    public abstract CompoundTag createDefaultAttributes();

    /************************************
     * Natural slowdown of the ship
     * increase -> slowdown will be higher
     * decrease -> slowdown will be lower
     ************************************/
    public float getVelocityResistance() {
        return 0.005F;
    }

    protected void waterSplash() {
        Vec3 vector3d = this.getViewVector(0.0F);
        float f0 = (float) (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * this.getBoundingBox().maxX);
        float f1 = (float) (Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * this.getBoundingBox().maxX);
        float f0_1 = (float) (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * this.getBoundingBox().maxX * 2);
        float f1_1 = (float) (Mth.sin(this.getYRot() * ((float) Math.PI / 180F)) * this.getBoundingBox().maxX * 2);
        float f2 =  2.5F - this.random.nextFloat() * 0.7F;
        float f2_ =  -1.3F - this.random.nextFloat() * 0.7F;
        float x = 0;
        for (int i = 0; i < 2; ++i) {
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.5D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 + (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 + (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2 - (double) f0, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) f2 - (double) f1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.SPLASH, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ + (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) + (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);
            this.getLevel().addParticle(ParticleTypes.BUBBLE, this.getX() - vector3d.x * (double) f2_ - (double) f0_1, this.getY() - vector3d.y + 0.8D, this.getZ() - vector3d.z * (double) (f2_ - x) - (double) f1_1 * 1.1, 0.0D, 0.0D, 0.0D);

        }
    }

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
}