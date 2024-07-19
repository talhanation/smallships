package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.GalleyModel;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class GalleyRenderer extends ShipRenderer<GalleyEntity> {
    public GalleyRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected GalleyModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new GalleyModel(context.bakeLayer(GalleyModel.LAYER_LOCATION));
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.25F;
    }

    @Override
    public void render(@NotNull GalleyEntity galleyEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.7D,0.0D);
        super.render(galleyEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
