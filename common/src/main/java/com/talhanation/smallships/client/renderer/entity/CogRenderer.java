package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.CogModel;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class CogRenderer extends ShipRenderer<CogEntity> {
    public CogRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected CogModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new CogModel(context.bakeLayer(CogModel.LAYER_LOCATION));
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.5F;
    }

    @Override
    public void render(@NotNull CogEntity cogEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.7D,0.0D);
        super.render(cogEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
