package com.talhanation.smallships.entities.projectile;


import com.talhanation.smallships.entities.AbstractShipDamage;
import com.talhanation.smallships.init.SoundInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public abstract class AbstractCannonBall extends AbstractHurtingProjectile {

    public boolean inWater = false;
    public boolean wasShot = false;
    public int counter = 0;

    protected AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
    }

    public AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, LivingEntity owner, double d1, double d2, double d3, Level world) {
        super(type, owner, d1, d2, d3, world);
        this.moveTo(d1, d2, d3, this.getYRot(), this.getXRot());
    }


    @Override
    public void tick() {
        this.baseTick();

        Vec3 vector3d = this.getDeltaMovement();
        HitResult raytraceresult = ProjectileUtil.getHitResult(this, this::canHitEntity);

        if (raytraceresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onHit(raytraceresult);
        }

        double d0 = this.getX() + vector3d.x;
        double d1 = this.getY() + vector3d.y;
        double d2 = this.getZ() + vector3d.z;
        this.updateRotation();
        float f = 0.99F;
        float f1 = 0.06F;
        this.setDeltaMovement(vector3d.scale(f));
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -f1, 0.0D));
        }
        this.setPos(d0, d1, d2);

        if(isAlive()){
            setWasShot(true);
        }

        if(isInWater()){
            setInWater(true);
        }

        if (wasShot){
            counter++;
        }

        if (counter < 4){
            if (this.level.isClientSide) tailParticles();
        }
    }

    public void setWasShot(boolean bool){
        if (bool != wasShot){
            wasShot = true;
            if (this.level.isClientSide) {
                shootParticles();
            }
        }
    }

    public void setInWater(boolean bool){
        if (bool != inWater){
            inWater = true;
            if (this.level.isClientSide) {
                waterParticles();
            }
            if (!this.level.isClientSide) {
                level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 10.0F, 0.8F + 0.4F * this.random.nextFloat());
            }
            this.remove(RemovalReason.KILLED);
        }
    }

    protected void onHit(HitResult rayTraceResult) {
        super.onHit(rayTraceResult);
        if (!this.level.isClientSide) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
            this.level.explode(this.getOwner(), getX(), getY(), getZ(), 1.25F, Explosion.BlockInteraction.BREAK);
            this.remove(RemovalReason.KILLED);
        }
        onHitBlockParticles();
    }

    protected void onHitEntity(EntityHitResult rayTraceResult) {
        super.onHitEntity(rayTraceResult);
        if (!this.level.isClientSide) {
            Entity hit = rayTraceResult.getEntity();
            Entity entity1 = this.getOwner();
            hit.hurt(DamageSource.ANVIL, 20.0F);
            if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity) entity1, hit);
            }

            if (hit instanceof AbstractShipDamage shipDamage) {
                shipDamage.damageShip(random.nextInt(7) + 7);
                this.level.playSound(null, this.getX(), this.getY() + 4 , this.getZ(), SoundInit.SHIP_CANNON_DAMAGE.get(), this.getSoundSource(), 15.0F, 0.8F + 0.4F * this.random.nextFloat());
            }
        }
    }

    protected void onHitBlockParticles(){
        if (this.level.isClientSide) {
                hitParticles();
        }
    }

    public void hitParticles(){
        for (int i = 0; i < 300; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            this.level.addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
        }
    }

    public void waterParticles(){
        for (int i = 0; i < 300; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            this.level.addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3  + i * 0.012, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
            this.level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, this.getX(), this.getY() + i * 0.005, this.getZ(), 0, 0, 0);
        }
    }


    public void shootParticles(){
        for (int i = 0; i < 100; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            this.level.addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
        }

        for (int i = 0; i < 50; ++i) {
            double d00 = this.random.nextGaussian() * 0.03D;
            double d11 = this.random.nextGaussian() * 0.03D;
            double d22 = this.random.nextGaussian() * 0.03D;
            double d44 = 10.0D;
            this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(1.0D) - d00 * d44, this.getRandomY() - d11 * d44, this.getRandomZ(2.0D) - d22 * d44, d00, d11, d22);
            this.level.addParticle(ParticleTypes.FLAME, this.getX(1.0D) - d00 * d44, this.getRandomY() - d11 * d44, this.getRandomZ(2.0D) - d22 * d44, 0, 0, 0);
        }
    }

    public void tailParticles(){
        for (int i = 0; i < 100; ++i) {
            this.level.addParticle(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ() , 0, 0, 0);
        }

        for (int i = 0; i < 50; ++i) {
            //this.level.addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ() , 0, 0, 0);
            this.level.addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
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
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected boolean shouldBurn() {
        return false;
    }

    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.SMOKE;
    }

}

/*
                 if (block == Blocks.WATER) {
                    for (int i = 0; i < 200; ++i) {
                        double d0 = this.random.nextGaussian() * 0.02D;
                        double d1 = this.random.nextGaussian() * 0.02D;
                        double d2 = this.random.nextGaussian() * 0.02D;
                        double d3 = 10.0D;
                        this.level.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
                        this.level.addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);

                    }
                } else
                 */