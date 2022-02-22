package com.talhanation.smallships.entities;

import com.talhanation.smallships.DamageSourceShip;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public abstract class AbstractShipDamage extends AbstractBannerUser {
    private static final DataParameter<Float> DAMAGE = EntityDataManager.defineId(AbstractShipDamage.class, DataSerializers.FLOAT);

    public AbstractShipDamage(EntityType<? extends AbstractShipDamage> type, World world) {
        super(type, world);

    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, 0F);
    }

    ////////////////////////////////////TICK////////////////////////////////////

    @Override
    public void tick() {
        super.tick();
        if (isInLava()) {
            setShipDamage(getShipDamage() + 1.5F);
        }

        if (isOnFire()) {
            setShipDamage(getShipDamage() + 0.5F);
        }
        if (getShipDamage() >= 100) sinkShip();
    }

    ////////////////////////////////////SAVE////////////////////////////////////

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putFloat("Damage", getShipDamage());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        setShipDamage(nbt.getFloat("Damage"));
    }

    ////////////////////////////////////GET////////////////////////////////////

    public float getShipDamage() {
        return entityData.get(DAMAGE);
    }

    public abstract double getShipDefense(); // how much incoming dmg gets reduced in % e.g: 30
    //public double getShipHealth(){


    ////////////////////////////////////SET////////////////////////////////////

    public void setShipDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (isInvulnerable()) {
            return false;
        }

        if (level.isClientSide || !isAlive()) {
            return false;
        }

        if (source.getDirectEntity() instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) source.getDirectEntity();
            if (player == null) {
                return false;
            }

            if (hasPassenger(player)) {
                return false;
            }

            if (player.abilities.instabuild) {
                if (player.isShiftKeyDown()) {
                    destroyShip(source);
                    return true;
                }
            }
            if (amount >= 2) damageShip(amount);
            this.markHurt();
            return false;
        }
        if (source.isProjectile()){
            if (amount >= 2) damageShip(amount);
            this.markHurt();
        }
        if (getShipDamage() >= 100) destroyShip(source);
        if (amount >= 2) damageShip(amount);
        return false;
    }

    public abstract ResourceLocation getLootTable();

    public void destroyShip(DamageSource source) {
        super.destroyShip(source);
        kill();
    }

    public void sinkShip() {
        this.setDeltaMovement(0, -0.2D,0);
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void damageShip(double damage) {
        setShipDamage((float) (((getShipDamage()) + (damage - (damage * getShipDefense()/100)))));
    }

    @Override
    public boolean canCollideWith(Entity entity) {
        if (entity instanceof LivingEntity && !getPassengers().contains(entity)) {
            if (entity.getBoundingBox().intersects(getBoundingBox())) {
                double speed = getDeltaMovement().length();
                if (speed > 0.35F) {
                    float damage = Math.min((float) (speed * 10D), 15F);
                    entity.hurt(DamageSourceShip.DAMAGE_SHIP, damage);
                }

            }
        }
        return super.canCollideWith(entity);
    }

}