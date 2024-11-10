package com.talhanation.smallships.mixin.entity;

import com.google.common.collect.ImmutableList;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.particles.cannon.CannonShootOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Entity.class)
public abstract class EntityMixin implements IMixinEntity, ICannonProjectile {
    private float prevXRot;
    private float prevYRot;
    @Shadow
    private float xRot;
    @Shadow
    private float yRot;
    @Shadow
    private Level level;

    @Shadow public abstract void stopRiding();

    private boolean preventNextPassengerSyncTeleport;
    private boolean preventDismountingToCoordinates;

    @Inject(method = "turn", at = @At("HEAD"))
    public void turn(double x, double y, CallbackInfo ci) {
        this.prevXRot = this.xRot;
        this.prevYRot = this.yRot;
    }

    @Override
    public float getPrevXRot() {
        return this.prevXRot;
    }

    @Override
    public float getPrevYRot() {
        return this.prevYRot;
    }

    @Override
    public void shootAndSpawn(Cannon cannon, Vector3d startPos, Vector3f direction, float cannonSpeedMultiplier, float cannonAccuracy, LivingEntity shooter) {
        if (this.level.isClientSide()) return;
        Object thisO = this;
        Entity thisEntity = (Entity) thisO;

        ((IMixinEntity) this).setPreventTeleportOnNextPassengerSync(true);
        this.stopRiding();
        direction.mul(cannonSpeedMultiplier * 3);

        thisEntity.setPos(startPos.x, startPos.y, startPos.z);
        thisEntity.setDeltaMovement(direction.x, direction.y, direction.z);
        thisEntity.hasImpulse = true;
        if (thisEntity instanceof Player player) {
            player.startAutoSpinAttack(40, 8.0F, null);
        }
        thisEntity.hurtMarked = true;
    }

    @Override
    public boolean doNotTeleportOnNextPassengerSync() {
        return this.preventNextPassengerSyncTeleport;
    }

    @Override
    public void setPreventTeleportOnNextPassengerSync(boolean prevent) {
        this.preventNextPassengerSyncTeleport = prevent;
    }

    @Override
    public boolean doNotDismountToCoordinates() {
        return this.preventDismountingToCoordinates;
    }

    public void setPreventDismountToCoordinates(boolean prevent) {
        this.preventDismountingToCoordinates = prevent;
    }

    @Override
    public ParticleOptions provideCannonShootParticles() {
        return new CannonShootOptions(true);
    }
}
