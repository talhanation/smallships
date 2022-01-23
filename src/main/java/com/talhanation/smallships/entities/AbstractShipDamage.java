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
        //if (isBurning)
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

        if (!(source.getDirectEntity() instanceof PlayerEntity)) {
            return false;
        }
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
        //if (getShipHealth == getShipDamage())
        //destroyShip(source, player);
        damageShip(amount);
        return false;
    }

    public abstract ResourceLocation getLootTable();

    public void destroyShip(DamageSource source) {
        super.destroyShip(source);

        //LootTable loottable = this.level.getServer().getLootTables().get(getLootTable());
        /*
        LootContext.Builder context = new LootContext.Builder((ServerLevel) level)
                .withParameter(LootContextParams.ORIGIN, position())
                .withParameter(LootContextParams.THIS_ENTITY, this)
                .withParameter(LootContextParams.DAMAGE_SOURCE, source)
                .withParameter(LootContextParams.KILLER_ENTITY, player)
                .withParameter(LootContextParams.DIRECT_KILLER_ENTITY, player);
        loottable.getRandomItems(context.create(LootContextParamSets.ENTITY)).forEach(this::spawnAtLocation);
        */
        kill();
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void damageShip(double damage) {
        setShipDamage((float) (getShipDamage() + damage));
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