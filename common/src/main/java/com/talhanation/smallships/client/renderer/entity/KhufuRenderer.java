package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.KhufuModel;
import com.talhanation.smallships.world.entity.ship.KhufuEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class KhufuRenderer extends ShipRenderer<KhufuEntity> {
    public KhufuRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected KhufuModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new KhufuModel(context.bakeLayer(KhufuModel.LAYER_LOCATION));
    }

    @Override
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    public void render(@NotNull KhufuEntity khufuEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.7D,-0.75D);
        super.render(khufuEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
