package com.talhanation.smallships.mixin.vanillaboat;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Feature 9: vanilla boats are slowed down (default 50%).
 *
 * Boat.controlBoat computes an acceleration value f from the constants
 * 0.04F (forward) and 0.005F (backward). Since the equilibrium boat speed
 * scales linearly with the acceleration (the per-tick velocity decay is
 * multiplicative), scaling these constants scales the top speed.
 *
 * SmallShips' own Ship class overrides controlBoat entirely and is therefore
 * not affected; the instanceof guard is kept as a safety net.
 *
 * ModifyExpressionValue and NOT ModifyConstant: a ModifyConstant claims the
 * constant for itself, a second mod on the same constant (e.g. Cluttered's
 * Bestiary crocodile boat boost) then makes the required injection fail and
 * the game crashes at bootstrap. ModifyExpressionValue stacks on top of the
 * other mods' modification instead.
 */
@Mixin(Boat.class)
public abstract class BoatSpeedMixin {

    @ModifyExpressionValue(method = "controlBoat", at = @At(value = "CONSTANT", args = "floatValue=0.04F"))
    private float smallships$slowdownForward(float original) {
        return original * this.smallships$getSpeedFactor();
    }

    @ModifyExpressionValue(method = "controlBoat", at = @At(value = "CONSTANT", args = "floatValue=0.005F"))
    private float smallships$slowdownBackward(float original) {
        return original * this.smallships$getSpeedFactor();
    }

    @org.spongepowered.asm.mixin.Unique
    private float smallships$getSpeedFactor() {
        if (((Boat) (Object) this) instanceof Ship) return 1.0F;
        if (!SyncedServerConfig.vanillaBoatSlowdownEnable()) return 1.0F;
        return (float) SyncedServerConfig.vanillaBoatSpeedFactor();
    }
}