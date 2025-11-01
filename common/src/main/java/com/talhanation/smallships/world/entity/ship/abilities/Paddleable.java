package com.talhanation.smallships.world.entity.ship.abilities;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.mixin.controlling.AbstractBoatAccessor;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public interface Paddleable extends Ability {
    default void tickPaddleShip() {
    }

    default float getPaddlingModifier() {
        return self().isForward()? SmallShipsConfig.Common.shipGeneralPaddlingModifier.get().floatValue() : 0.0F;
    }

    default void controlBoatPaddleShip() {
        if(self().isLocalInstanceAuthoritative()) {
            self().setPaddleState(this.shouldPaddleLeft(), this.shouldPaddleRight());
        }
    }

    static void setupAnim(ShipRenderState state, Pair<ModelPart[], ModelPart[]> paddles) {
        for (ModelPart paddle : paddles.getFirst()) {
            animatePaddle(state.rowingTimeLeft, Paddleable.PaddleSide.LEFT, paddle);
        }

        for (ModelPart paddle : paddles.getSecond()) {
            animatePaddle(state.rowingTimeRight, PaddleSide.RIGHT, paddle);
        }
    }

    static void animatePaddle(float f, PaddleSide side, ModelPart modelPart) {
        float xRotChange = Mth.clampedLerp(-1.0471976f, -0.2617994f, (Mth.sin(-f) + 1.0f) / 2.0f);
        float yRotChange = Mth.clampedLerp(-0.7853982f, 0.7853982f, (Mth.sin(-f + 1.0f) + 1.0f) / 2.0f);
        if (side.equals(PaddleSide.LEFT)) {
            modelPart.yRot = -yRotChange;
            modelPart.xRot = 4.55F - (Mth.PI - xRotChange);
        } else {
            modelPart.yRot = Mth.PI + yRotChange;
            modelPart.xRot = (Mth.PI + 1.4F) + xRotChange;
        }
    }

    private boolean shouldPaddleLeft(){
        return (((AbstractBoatAccessor)self()).isInputRight() && !((AbstractBoatAccessor)self()).isInputLeft()) || ((AbstractBoatAccessor)self()).isInputUp();
    }

    private boolean shouldPaddleRight(){
        return (((AbstractBoatAccessor)self()).isInputLeft() && !((AbstractBoatAccessor)self()).isInputRight()) || ((AbstractBoatAccessor)self()).isInputUp();
    }

    enum PaddleSide {
        LEFT,
        RIGHT
    }
}
