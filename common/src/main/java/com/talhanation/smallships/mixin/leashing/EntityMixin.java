package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @SuppressWarnings("DataFlowIssue")
    private Entity self() {
        return (Entity)(Object)this;
    }
    /*
    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "startRiding(Lnet/minecraft/world/entity/Entity;Z)Z", at = @At(value = "RETURN"))
    private void startRidingLeashedShip(Entity entity, boolean bl, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Leashable || entity.getClass().equals(Boat.class)) {
            if (cir.getReturnValue() && ((BoatLeashAccess)entity).isLeashed()) {
                //((BoatLeashAccess)entity).dropLeash(true, true);
            }
        }
    }
    */

    @Inject(method = "removeAfterChangingDimensions", at = @At(value = "RETURN"))
    private void removeAfterChangingDimensionsLeashedShip(CallbackInfo ci) {
        if (self() instanceof Leashable || self().getClass().equals(Boat.class)) {
            ((BoatLeashAccess)this).dropLeash(true, false);
        }
    }

    @Inject(method = "getLeashOffset", at = @At(value = "HEAD"), cancellable = true)
    private void getLeashOffsetLeashedShip(CallbackInfoReturnable<Vec3> cir) {
        if (self() instanceof Leashable leashShipEntity) {
            @Nullable Vec3 offset = leashShipEntity.applyLeashOffset();
            if (offset != null) cir.setReturnValue(offset);
        } else if (self().getClass().equals(Boat.class)) {
            cir.setReturnValue(new Vec3(0.0, self().getEyeHeight(), self().getBbWidth() * 0.3F));
        }
    }
}
