package com.talhanation.smallships.client.model;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

public abstract class ShipModel<T extends Ship> extends EntityModel<ShipRenderState> {
    protected ModelPart[] chests;
    protected Pair<ModelPart[], ModelPart[]> paddles;
    protected ModelPart steer;

    protected ShipModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public void setupAnim(ShipRenderState state) {
        if (state.hasContainer) {
            this.chests[0].visible = state.invFillState >= 15;
            this.chests[1].visible = state.invFillState >= 30;
            this.chests[2].visible = state.invFillState >= 60;
            this.chests[3].visible = state.invFillState >= 90;
        }

        if (state.paddleable != null) {
            state.paddleable.setupAnim(state, paddles);
        }

        this.steer.yRot = -state.rotationSpeed * 0.25F;

        super.setupAnim(state);
    }
}
