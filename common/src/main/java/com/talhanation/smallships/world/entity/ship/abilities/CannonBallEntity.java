package com.talhanation.smallships.world.entity.ship.abilities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CannonBallEntity extends AbstractArrow {
    private boolean fresh = true;

    public CannonBallEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
        this.init();
    }

    protected CannonBallEntity(EntityType<? extends AbstractArrow> entityType, double d, double e, double f, Level level) {
        super(entityType, d, e, f, level);
        this.init();
    }

    @SuppressWarnings("unused")
    protected CannonBallEntity(EntityType<? extends AbstractArrow> entityType, LivingEntity livingEntity, Level level) {
        super(entityType, livingEntity, level);
        this.init();
    }

    private void init() {
        this.pickup = Pickup.CREATIVE_ONLY;
    }

    @Override
    public void tick() {
        super.tick();
        this.trailParticles();
        if (this.isAlive() && this.fresh) {
            this.fresh = false;
            this.shootParticles();
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        this.onHitCustom();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        this.onHitCustom();
        this.setSoundEvent(SoundEvents.ANVIL_LAND);
    }

    private void onHitCustom() {
        this.getLevel().explode(this.getOwner(), getX(), getY(), getZ(), 1.25F, Explosion.BlockInteraction.BREAK);
        this.remove(RemovalReason.KILLED);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.ANVIL_LAND;
    }

    @Override
    public boolean shotFromCrossbow() {
        return false;
    }

    @Override
    public boolean isCritArrow() {
        return false;
    }

    @Override
    public byte getPierceLevel() {
        return 3;
    }

    public void shootParticles(){
        for (int j = 0; j < 50; ++j) {
            double g = this.random.nextGaussian() * 0.03D;
            double h = this.random.nextGaussian() * 0.03D;
            double i = this.random.nextGaussian() * 0.03D;
            double x = 20.0D;
            this.getLevel().addParticle(ParticleTypes.POOF, this.getX(1.0D) - g * x, this.getRandomY() - h * x, this.getRandomZ(2.0D) - i * x, g, h, i);
        }

        for (int j = 0; j < 25; ++j) {
            double g = this.random.nextGaussian() * 0.03D;
            double h = this.random.nextGaussian() * 0.03D;
            double i = this.random.nextGaussian() * 0.03D;
            double x = 10.0D;
            this.getLevel().addParticle(ParticleTypes.LARGE_SMOKE, this.getX(1.0D) - g * x, this.getRandomY() - h * x, this.getRandomZ(2.0D) - i * x, g, h, i);
            this.getLevel().addParticle(ParticleTypes.FLAME, this.getX(1.0D) - g * x, this.getRandomY() - h * x, this.getRandomZ(2.0D) - i * x, 0.0D, 0.0D, 0.0D);
        }
    }

    public void trailParticles(){
        Vec3 vec = this.getDeltaMovement();
        double e = vec.x;
        double f = vec.y;
        double g = vec.z;

        for (int i = 0; i < 50; ++i) {
            this.getLevel().addParticle(ParticleTypes.POOF, this.getX() + e * (double)i / 4.0D, this.getY() + f * (double)i / 4.0D, this.getZ() + g * (double)i / 4.0D, 0.0D, 0.0D, 0.0D);
        }

        for (int i = 0; i < 25; ++i) {
            this.getLevel().addParticle(ParticleTypes.FLAME, this.getX() + e * (double)i / 4.0D, this.getY() + f * (double)i / 4.0D, this.getZ() + g * (double)i / 4.0D, 0.0D, 0.0D, 0.0D);
        }
    }
}
