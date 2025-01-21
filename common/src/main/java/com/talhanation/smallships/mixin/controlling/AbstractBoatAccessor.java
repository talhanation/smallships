package com.talhanation.smallships.mixin.controlling;

import net.minecraft.world.entity.vehicle.AbstractBoat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractBoat.class)
public interface AbstractBoatAccessor {
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
