package com.talhanation.smallships.mixin.controlling;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Boat.class)
public abstract class BoatMixin {
    @Shadow protected abstract void controlBoat();

    @SuppressWarnings("ConstantValue")
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;tickLerp()V"))
    private void tickClientAndServerControlBoat(CallbackInfo ci) {
        if (((Boat)(Object)this instanceof Ship)) {
            this.controlBoat();
        }
    }

    @SuppressWarnings("ConstantValue")
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;controlBoat()V"))
    private void tickCancelControlBoatHereForShip(Boat instance) {
        if (!(((Boat)(Object)this) instanceof Ship)) {
            this.controlBoat();
        }
    }
}
