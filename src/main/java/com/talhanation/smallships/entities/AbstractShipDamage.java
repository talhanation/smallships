package com.talhanation.smallships.entities;

import com.google.common.collect.ImmutableSet;
import com.talhanation.smallships.DamageSourceShip;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Set;

public abstract class AbstractShipDamage extends AbstractBannerUser {
    public AbstractShipPart shipPart;
    public AbstractShipPart shipMast;


    private static final DataParameter<Float> DAMAGE = EntityDataManager.defineId(AbstractShipDamage.class, DataSerializers.FLOAT);
    public AbstractShipDamage(EntityType<? extends AbstractShipDamage> type, World world) {
        super(type, world);

    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, 0F);
    }

    public static final Set<Item> REPAIR_BLOCKS = ImmutableSet.of(
            Items.OAK_PLANKS,
            Items.BIRCH_PLANKS,
            Items.SPRUCE_PLANKS,
            Items.ACACIA_PLANKS,
            Items.JUNGLE_PLANKS,
            Items.DARK_OAK_PLANKS
    );

    ////////////////////////////////////TICK////////////////////////////////////
    @Override
    public void tick() {
        super.tick();
        updateShipPart();
        if (isInLava()) {
            setShipDamage(getShipDamage() + 1.5F);
        }
        if (this.isOnFire()) {
            setShipDamage(getShipDamage() + 0.5F);
        }

        if (this.isOnFire()) {
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
        shipPart = null;
        shipMast = null;
    }

    ////////////////////////////////////GET////////////////////////////////////

    public float getShipDamage() {
        return entityData.get(DAMAGE);
    }

    public abstract double getShipDefense(); // how much incoming dmg gets reduced in % e.g: 30

    public AbstractShipPart getShipPart(){
        return shipPart;
    }

    public AbstractShipPart getShipMast(){
        return shipPart;
    }

    ////////////////////////////////////SET////////////////////////////////////

    public void setShipDamage(float damage) {
        entityData.set(DAMAGE, damage);
    }

    ////////////////////////////////////ON FUNCTIONS////////////////////////////////////

    public boolean onInteractionWithAxeItem(PlayerEntity player) {
        IInventory inventory = player.inventory;

        for(int i = 0; i < player.inventory.getContainerSize(); i++){
            if (inventory.getItem(i) == Items.IRON_NUGGET.getDefaultInstance()){
                ItemStack nuggets = inventory.getItem(i).getStack();

                if (!player.isCreative()) {
                    nuggets.shrink(1);
                }

                this.damageShip(-5);
                return true;
            }
        }
        return false;
    }

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

    @Override
    public boolean canBeCollidedWith() {
        return super.canBeCollidedWith();
    }

    public abstract void updateShipPart();
}