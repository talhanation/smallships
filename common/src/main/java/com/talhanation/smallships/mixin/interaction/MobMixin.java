package com.talhanation.smallships.mixin.interaction;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobMixin {
    @SuppressWarnings("DataFlowIssue")
    private Mob self() {
        return (Mob)(Object)this;
    }

    @Inject(method = "mobInteract", at =  @At(value = "HEAD"), cancellable = true)
    private void dismountEntityWhileInShip(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        if (self().getVehicle() != null && self().getVehicle() instanceof Boat && !player.isCrouching()) {
            self().stopRiding();
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }

}
