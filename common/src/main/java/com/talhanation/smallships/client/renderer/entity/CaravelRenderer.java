package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.CaravelModel;
import com.talhanation.smallships.client.model.GalleonModel;
import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import com.talhanation.smallships.world.entity.ship.GalleonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class CaravelRenderer extends ShipRenderer<CaravelEntity> {
    public CaravelRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected CaravelModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new CaravelModel(context.bakeLayer(CaravelModel.LAYER_LOCATION));
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.25F;
    }

    @Override
    public void render(@NotNull CaravelEntity caravelEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.15D,0.0D);
        super.render(caravelEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
