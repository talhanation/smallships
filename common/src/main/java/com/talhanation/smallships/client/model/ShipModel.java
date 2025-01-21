package com.talhanation.smallships.client.model;

import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

public abstract class ShipModel<T extends Ship> extends EntityModel<ShipRenderState> {
    protected ShipModel(ModelPart modelPart) {
        super(modelPart);
    }
}
