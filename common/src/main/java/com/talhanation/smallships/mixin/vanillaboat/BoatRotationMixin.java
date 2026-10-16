package com.talhanation.smallships.mixin.vanillaboat;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

/**
 * Feature 9, second half: the slowdown of vanilla boats also applies to
 * turning with A and D, with the same factor as the speed (BoatSpeedMixin).
 *
 * Boat.controlBoat turns by adding 1.0F to deltaRotation per tick (left: -1,
 * right: +1), and floatBoat lets it decay multiplicatively with the friction.
 * Like the speed, the turn rate the boat settles at scales linearly with that
 * step - so scaling the 1.0F scales the turn rate by exactly the speed factor.
 *
 * The step is the only 1.0F constant in controlBoat. Scaling deltaRotation
 * itself instead of the yaw keeps the passengers turning with the boat, they
 * are rotated by deltaRotation as well.
 */
@Mixin(Boat.class)
public abstract class BoatRotationMixin {

    @ModifyExpressionValue(method = "controlBoat", at = @At(value = "CONSTANT", args = "floatValue=1.0F"))
    private float smallships$slowdownRotation(float original) {
        return original * this.smallships$getRotationFactor();
    }

    @Unique
    private float smallships$getRotationFactor() {
        if (((Boat) (Object) this) instanceof Ship) return 1.0F;
        if (!SyncedServerConfig.vanillaBoatSlowdownEnable()) return 1.0F;
        return (float) SyncedServerConfig.vanillaBoatSpeedFactor();
    }
}
