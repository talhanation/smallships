package com.talhanation.smallships.mixin.vanillaboat;

import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

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
 */
@Mixin(Boat.class)
public abstract class BoatSpeedMixin {

    @ModifyConstant(method = "controlBoat", constant = @Constant(floatValue = 0.04F))
    private float smallships$slowdownForward(float original) {
        return original * this.smallships$getSpeedFactor();
    }

    @ModifyConstant(method = "controlBoat", constant = @Constant(floatValue = 0.005F))
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