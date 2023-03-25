package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public interface Paddleable extends Ability {
    default void animatePaddle(PaddleSide side, ModelPart modelPart, float f) {
        float f2 = self().getRowingTime(side.ordinal(), f);
        modelPart.xRot = Mth.PI - Mth.clampedLerp(-1.0471976f, -0.2617994f, (Mth.sin(-f2) + 1.0f) / 2.0f);
        modelPart.yRot = Mth.PI - Mth.clampedLerp(-0.7853982f, 0.7853982f, (Mth.sin(-f2 + 1.0f) + 1.0f) / 2.0f);
        if (side.equals(PaddleSide.LEFT)) {
            modelPart.yRot = Mth.PI - modelPart.yRot;
        }
    }

    default void tickPaddleShip() {
        if (self().isVehicle()) self().setPaddleState(((BoatAccessor)self()).isInputRight() && !((BoatAccessor)self()).isInputLeft() || ((BoatAccessor)self()).isInputUp(), ((BoatAccessor)self()).isInputLeft() && !((BoatAccessor)self()).isInputRight() || ((BoatAccessor)self()).isInputUp());
    }

    enum PaddleSide {
        LEFT,
        RIGHT
    }
}
