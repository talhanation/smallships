package com.talhanation.smallships.entities.projectile;


import com.talhanation.smallships.entities.AbstractShipDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public abstract class AbstractCannonBall extends DamagingProjectileEntity {

    protected AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, World world) {
        super(type, world);
    }

    public AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, LivingEntity owner, double d1, double d2, double d3, World world) {
        super(type, owner, d1, d2, d3, world);
    }

    protected void onHit(RayTraceResult rayTraceResult) {
        super.onHit(rayTraceResult);
        if (!this.level.isClientSide) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), 1, flag, flag ? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
            this.remove();
        }
    }

    protected void onHitEntity(EntityRayTraceResult rayTraceResult) {
        super.onHitEntity(rayTraceResult);
        if (!this.level.isClientSide) {
            Entity hit = rayTraceResult.getEntity();
            Entity entity1 = this.getOwner();
            hit.hurt(DamageSource.ANVIL, 10.0F);
            if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity)entity1, hit);
            }

            if (hit instanceof AbstractShipDamage){
                AbstractShipDamage shipDamage = (AbstractShipDamage) hit;
                shipDamage.damageShip(10);
            }
        }
    }

    public boolean isPickable() {
        return false;
    }

    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        return false;
    }

    public float getBrightness() {
        return 0.0F;
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected boolean shouldBurn() {
        return false;
    }
}
