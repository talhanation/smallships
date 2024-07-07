package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.DrakkarModel;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class DrakkarRenderer extends ShipRenderer<DrakkarEntity> {
    public DrakkarRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected DrakkarModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new DrakkarModel(context.bakeLayer(DrakkarModel.LAYER_LOCATION));
    }

    @Override
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }

    @Override
    protected float getCannonAngleOffset() {
        return 0.0F;
    }

    @Override
    protected float getCannonHeightOffset(){
        return 0.25F;
    }

    public Axis getWaveAngleRotation(){
        return Axis.ZN;
    }

    @Override
    public void render(@NotNull DrakkarEntity drakkarEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.7D,0.0D);
        super.render(drakkarEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
