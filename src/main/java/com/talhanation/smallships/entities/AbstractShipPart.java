package com.talhanation.smallships.entities;

import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.List;

public abstract class AbstractShipPart extends Entity implements IEntityAdditionalSpawnData {

    protected AbstractShipDamage sailShip;
    protected float offset;
    protected float yOffset;

    public static final DataParameter<Integer> SHIP_ID = EntityDataManager.defineId(AbstractShipPart.class, DataSerializers.INT);

    public AbstractShipPart(EntityType<?> type, World world) {
        super(type, world);
    }

    ////////////////////////////////////TICK////////////////////////////////////

    @Override
    public void tick(){
        if(this.level.isClientSide && sailShip == null){
            setSailShip();
        }
        if(!this.level.isClientSide) {
            if (sailShip == null || !sailShip.isAlive()) {
                this.remove();
            } else {
                AbstractShipPart p = sailShip.getShipPart();
                if (p != null && !p.equals(this)) {
                    this.remove();
                } else {
                    entityData.set(SHIP_ID, sailShip.getId());
                }
            }
        }

        if(this.level.isClientSide && sailShip == null){
            setSailShip();
        }
        if(!this.level.isClientSide) {
            if (sailShip == null || !sailShip.isAlive()) {
                this.remove();
            } else {
                AbstractShipPart p = sailShip.getShipMast();
                if (p != null && !p.equals(this)) {
                    this.remove();
                } else {
                    entityData.set(SHIP_ID, sailShip.getId());
                }
            }
        }
    }

    public void updatePosition(){
        Vector3d forward = sailShip.getForward();
        float x0 = 0; // /-/rechst /+/links //no need

        float f0 = MathHelper.cos(sailShip.yRot * ((float)Math.PI / 180F)) * x0;
        float f1 = MathHelper.sin(sailShip.yRot * ((float)Math.PI / 180F)) * x0;
        float f2 = this.offset; // /-/vorne /+/zurück
        double d1 = sailShip.getX() - forward.x * (double) f2 + (double) f0;
        double d2 = sailShip.getY() - forward.y + yOffset;//hoch
        double d3 = sailShip.getZ() - forward.z * (double) f2 + (double) f1;

        this.moveTo(d1, d2, d3);
    }

    ////////////////////////////////////SAVE DATA////////////////////////////////////

    @Override
    protected void defineSynchedData() {
        entityData.define(SHIP_ID, -1);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT nbt) {
        this.remove();
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT nbt) {
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        if (sailShip != null){
            buffer.writeInt(sailShip.getId());
        }
    }

    @Override
    public void readSpawnData(PacketBuffer buffer) {
        try {
            sailShip = (AbstractShipDamage) this.level.getEntity(buffer.readInt());
        } catch (IndexOutOfBoundsException e){

        }
    }
    ////////////////////////////////////GET////////////////////////////////////

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public AbstractShipDamage getSailShip() {
        return sailShip;
    }

    ////////////////////////////////////SET////////////////////////////////////

    public void setSailShip() {
        Entity potential = level.getEntity(getEntityData().get(SHIP_ID));
        if(potential instanceof AbstractShipDamage){
            sailShip = (AbstractShipDamage) potential;
        }
    }

    ////////////////////////////////////BOOL////////////////////////////////////

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    @Override
    public boolean canCollideWith(Entity entity) {
        /*
        if (entity instanceof AbstractShipDamage){
            AbstractShipDamage shipDamage = (AbstractShipDamage)entity;
            return (shipDamage != this.sailShip);
        }

        if (entity instanceof AbstractShipPart){
            AbstractShipPart shipPart = (AbstractShipPart)entity;
            AbstractShipDamage shipDamage = shipPart.getSailShip();
            return (shipDamage != this.sailShip);
        }
        */
        return (entity.canBeCollidedWith() || entity.isPushable()) && !isPassengerOfSameVehicle(entity);
    }

    public boolean isPickable() {
        return !this.removed;
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void handleCollisionWithEntity() {
        List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), EntityPredicates.pushableBy(this));
        if (!list.isEmpty()) {
            boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof PlayerEntity);

            for (Entity entity : list) {
                if (!entity.hasPassenger(this)) {
                    if (flag && sailShip.canAddPassenger(entity) && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
                        entity.startRiding(sailShip);
                    } else {
                        this.push(entity);
                    }
                }
            }
        }
    }

    public boolean isCollidingWithBlock() {
        if (this.noPhysics) {
            return false;
        } else {
            return this.level.getBlockCollisions(this, this.getBoundingBox(), (predicate, pos) -> {
                return predicate.isCollisionShapeFullBlock(this.level, pos);
            }).findAny().isPresent();
        }
    }

    public boolean isCollidingWithEntity() {
        if (this.noPhysics) {
            return false;
        } else {
            return this.level.getEntityCollisions(this, this.getBoundingBox(), this::canCollideWith).findAny().isPresent();
        }
    }


    @Override
    public ActionResultType interact(PlayerEntity p_184230_1_, Hand p_184230_2_) {
        return sailShip.interact(p_184230_1_, p_184230_2_);
    }


    @Override
    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        return sailShip.hurt(p_70097_1_, p_70097_2_);
    }


    @Override
    public void onSyncedDataUpdated(DataParameter<?> key) {
        super.onSyncedDataUpdated(key);

        if(level.isClientSide) {
            if(SHIP_ID.equals(key)) {
                setSailShip();
            }
        }
    }
}
