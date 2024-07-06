package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {
    @Unique
    @SuppressWarnings("DataFlowIssue")
    private Entity smallships$self() {
        return (Entity)(Object)this;
    }

    @Inject(method = "removeAfterChangingDimensions", at = @At(value = "RETURN"))
    private void removeAfterChangingDimensionsLeashedShip(CallbackInfo ci) {
        if (smallships$self() instanceof Leashable || smallships$self().getClass().equals(Boat.class)) {
            ((BoatLeashAccess)this).smallships$dropLeash(true, false);
        }
    }

    @Inject(method = "getLeashOffset()Lnet/minecraft/world/phys/Vec3;", at = @At(value = "HEAD"), cancellable = true)
    private void getLeashOffsetLeashedShip(CallbackInfoReturnable<Vec3> cir) {
        if (smallships$self() instanceof Leashable leashShipEntity) {
            @Nullable Vec3 offset = leashShipEntity.applyLeashOffset();
            if (offset != null) cir.setReturnValue(offset);
        } else if (smallships$self().getClass().equals(Boat.class)) {
            cir.setReturnValue(new Vec3(0.0, smallships$self().getEyeHeight(), smallships$self().getBbWidth() * 0.3F));
        }
    }
}
