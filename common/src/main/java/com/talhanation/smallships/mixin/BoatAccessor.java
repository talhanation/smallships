package com.talhanation.smallships.mixin;

import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Boat.class)
public interface BoatAccessor {
    //controlBoat
    @Accessor
    float getDeltaRotation();

    @Accessor
    void setDeltaRotation(float deltaRotation);

    @Accessor
    boolean isInputLeft();

    @Accessor
    boolean isInputRight();

    @Accessor
    boolean isInputUp();

    @Accessor
    boolean isInputDown();
}
