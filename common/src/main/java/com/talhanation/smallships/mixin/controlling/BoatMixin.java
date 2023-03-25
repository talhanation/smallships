package com.talhanation.smallships.mixin.controlling;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Boat.class)
public abstract class BoatMixin {
    @SuppressWarnings("DataFlowIssue")
    private Boat self() {
        return (Boat)(Object)this;
    }

    @Shadow protected abstract void controlBoat();

    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;controlBoat()V"))
    private void tickCancelControlBoatHere(Boat instance) {
        if (!(self() instanceof Ship)) {
            this.controlBoat();
        }
    }
}
