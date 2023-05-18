package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CogModel;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
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
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.5F;
    }

    public Vector3f getWaveAngleRotation(){
        return Vector3f.ZN;//wtf
    }
    @Override
    public void render(@NotNull CogEntity cogEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.7D,0.0D);
        super.render(cogEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
