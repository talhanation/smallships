package com.talhanation.smallships.mixin.entity;

import com.google.common.collect.ImmutableList;
import com.talhanation.smallships.world.entity.IEntityRemovePassenger;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
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
    private ImmutableList<Entity> passengers;
    @Shadow
    private Entity vehicle;
    @Shadow
    private Level level;

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
    public void simpleStopRiding() {
        /* don't call removeVehicle as it calls teleport methods */
        Entity vehicle = this.vehicle;
        this.vehicle = null;
        Object thisO = this;
        Entity thisEntity = (Entity) thisO;
        if (vehicle instanceof IEntityRemovePassenger vehicle0) {
            vehicle0.removePassengerWithoutGameEvent(thisEntity);
        } else if (vehicle != null) {
            ((IMixinEntity) vehicle).simpleRemovePassenger(thisEntity);
        }
    }

    @Override
    public void simpleRemovePassenger(Entity entity) {
        if (!this.passengers.contains(entity)) return;
        this.passengers = this.passengers.stream().filter((entity2) -> entity2 != entity).collect(ImmutableList.toImmutableList());
    }

    @Override
    public void shootAndSpawn(Cannon cannon, Vector3d startPos, Vector3f direction, float cannonSpeedMultiplier, float cannonAccuracy, LivingEntity shooter) {
        if (this.level.isClientSide()) return;
        Object thisO = this;
        Entity thisEntity = (Entity) thisO;

        if (thisEntity.getVehicle() == cannon.getOwner()) {
            ((IMixinEntity) thisEntity).simpleStopRiding();
        }
        direction.mul(cannonSpeedMultiplier * 3);

        thisEntity.setPos(startPos.x, startPos.y, startPos.z);
        thisEntity.setDeltaMovement(direction.x, direction.y, direction.z);
        thisEntity.hasImpulse = true;
        if (thisEntity instanceof Player player) {
            player.startAutoSpinAttack(40, 8.0F, null);
        }
        thisEntity.hurtMarked = true;
    }
}
