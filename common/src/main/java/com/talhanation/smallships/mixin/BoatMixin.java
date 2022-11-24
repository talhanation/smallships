package com.talhanation.smallships.mixin;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Boat.class)
public class BoatMixin {
    @ModifyConstant(method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", constant = @Constant(floatValue = 40.0F))
    private float specifyMaxHealth(float defaultMaxHealth) { // could also just override hurt method, if there is more logic needed
        if (((Boat)(Object)this) instanceof Ship ship) {
            return ship.getAttributes().maxHealth;
        }
        return defaultMaxHealth;
    }
}
