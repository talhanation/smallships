package com.talhanation.smallships.mixin.controlling;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractBoat.class)
public abstract class AbstractBoatMixin {
    @Shadow protected abstract void controlBoat();

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/AbstractBoat;isLocalInstanceAuthoritative()Z"))
    private void tickClientAndServerControlBoat(CallbackInfo ci) {
        if (((AbstractBoat)(Object)this instanceof Ship)) {
            this.controlBoat();
        }
    }

    @WrapWithCondition(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/AbstractBoat;controlBoat()V"))
    private boolean tickCancelControlBoatHereForShip(AbstractBoat instance) {
        return !(((AbstractBoat)(Object)this) instanceof Ship);
    }
}
