package com.talhanation.smallships.mixin.port;

import com.talhanation.smallships.duck.port.PassengerSizeAccess;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Boat.class)
public class BoatMixin implements PassengerSizeAccess {
    @Override
    public int getMaxPassengers() {
        return 2;
    }

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 2))
    private int tickChangeHardcodedPassengerSizeOf2ToGetMaxPassengers(int constant) {
        return this.getMaxPassengers();
    }
}
