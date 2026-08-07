package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.DhowModel;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class DhowRenderer extends ShipRenderer<DhowEntity> {
    public DhowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected DhowModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new DhowModel(context.bakeLayer(DhowModel.LAYER_LOCATION));
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.25F;
    }

    @Override
    public void render(@NotNull DhowEntity dhowEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.15D,0.0D);
        super.render(dhowEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
