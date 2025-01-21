package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.DrakkarModel;
import com.talhanation.smallships.client.renderer.entity.state.ShipRenderState;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DrakkarRenderer extends ShipRenderer<DrakkarEntity> {
    public DrakkarRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected DrakkarModel createBoatModel(EntityRendererProvider.Context context, Ship.Type type) {
        return new DrakkarModel(context.bakeLayer(DrakkarModel.LAYER_LOCATION));
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.25F;
    }

    @Override
    public void render(ShipRenderState state, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - state.yaw));
        poseStack.translate(0.0D, 2.7D,0.0D);
        super.render(state, poseStack, multiBufferSource, packedLight);
    }
}
