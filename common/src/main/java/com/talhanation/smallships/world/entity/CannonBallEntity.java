package com.talhanation.smallships.world.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class CannonBallEntity extends AbstractArrow {
    public CannonBallEntity(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
        this.init();
    }

    public static CannonBallEntity factory(EntityType<? extends AbstractArrow> entityType, Level level) {
        return new CannonBallEntity(entityType, level);
    }

    public CannonBallEntity(EntityType<? extends AbstractArrow> entityType, double d, double e, double f, Level level) {
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
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
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
        this.setSoundEvent(this.getDefaultHitGroundSoundEvent());
    }

    private void onHitCustom() {
        Explosion.BlockInteraction blockInteraction = this.getLevel().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
        this.getLevel().explode(this.getOwner(), getX(), getY(), getZ(), (float) (this.getBaseDamage() / 4), blockInteraction);
        for (int i = 0; i < 100; ++i) {
            this.getLevel().addParticle(ParticleTypes.LARGE_SMOKE, this.getRandomX(2D), this.getRandomY(), this.getRandomZ(2D), 0.0D, 0.0D, 0.0D);
        }
        this.remove(RemovalReason.KILLED);
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
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

    public void trailParticles(){
        for(int i = 0; i < 3; ++i) {
            this.getLevel().addParticle(ParticleTypes.FLAME, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
        }
        for(int i = 0; i < 6; ++i) {
            this.getLevel().addParticle(ParticleTypes.POOF, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
        }
    }
}
