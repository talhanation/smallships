package com.talhanation.smallships.mixin.damaging;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Boat.class)
public abstract class BoatMixin {
    @SuppressWarnings("DataFlowIssue")
    private Boat self() {
        return (Boat)(Object)this;
    }

    @ModifyConstant(method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", constant = @Constant(floatValue = 40.0F))
    private float specifyMaxHealth(float defaultMaxHealth) { // could also just override hurt method, if there is more logic needed
        if (self() instanceof Ship ship) {
            return ship.getAttributes().maxHealth;
        }
        return defaultMaxHealth;
    }
}
