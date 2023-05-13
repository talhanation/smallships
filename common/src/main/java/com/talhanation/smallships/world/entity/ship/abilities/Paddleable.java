package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public interface Paddleable extends Ability {
    default void tickPaddleShip() {
        if (self().isVehicle()) {
            self().setPaddleState(this.shouldPaddleLeft(), this.shouldPaddleRight());
        }
        for(int i = 0; i <= 1; ++i) {
            if (!self().getPaddleState(i)) {
                self().paddlePositions[i] = 0.3F;
            }
        }
    }
    default float getPaddlingModifier() {
        return 1.5F;
    }

    default void animatePaddle(PaddleSide side, ModelPart modelPart, float f) {
        float f2 = self().getRowingTime(side.ordinal(), f);

        float xRotChange = Mth.clampedLerp(-1.0471976f, -0.2617994f, (Mth.sin(-f2) + 1.0f) / 2.0f);
        float yRotChange = Mth.clampedLerp(-0.7853982f, 0.7853982f, (Mth.sin(-f2 + 1.0f) + 1.0f) / 2.0f);
        if (side.equals(PaddleSide.LEFT)) {
            modelPart.yRot = -yRotChange;
            modelPart.xRot = 4.55F - (Mth.PI - xRotChange);
        } else {
            modelPart.yRot = Mth.PI + yRotChange;
            modelPart.xRot = (Mth.PI + 1.4F) + xRotChange;
        }
    }

    private boolean shouldPaddleLeft(){
        return (((BoatAccessor)self()).isInputRight() && !((BoatAccessor)self()).isInputLeft()) || ((BoatAccessor)self()).isInputUp();
    }

    private boolean shouldPaddleRight(){
        return (((BoatAccessor)self()).isInputLeft() && !((BoatAccessor)self()).isInputRight()) || ((BoatAccessor)self()).isInputUp();
    }

    enum PaddleSide {
        LEFT,
        RIGHT
    }
}
