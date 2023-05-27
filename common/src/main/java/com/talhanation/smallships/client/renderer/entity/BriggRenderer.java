package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.BriggModel;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public class BriggRenderer extends ShipRenderer<BriggEntity> {
    public BriggRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected BriggModel createBoatModel(EntityRendererProvider.Context context, Boat.Type type) {
        return new BriggModel(context.bakeLayer(BriggModel.LAYER_LOCATION));
    }

    @Override
    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, "textures/entity/ship/" + ShipRenderer.getNameFromType(type) + ".png");
    }
    @Override
    protected float getCannonHeightOffset(){
        return -0.25F;
    }

    public Vector3f getWaveAngleRotation(){
        return Vector3f.ZN;//wtf
    }

    @Override
    public void render(@NotNull BriggEntity briggEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        poseStack.translate(0.0D, 2.0D,0.0D);
        super.render(briggEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }
}
