package com.talhanation.smallships.mixin.interaction;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @SuppressWarnings("DataFlowIssue")
    private Entity self() {
        return (Entity)(Object)this;
    }

    @Inject(method = "interact", at =  @At(value = "HEAD"), cancellable = true)
    private void removeAfterChangingDimensionsLeashedShip(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        if (self().getVehicle() != null && self().getVehicle() instanceof Boat && !player.isCrouching()) {
            self().stopRiding();
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }
}
