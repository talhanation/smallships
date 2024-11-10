package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class GroundCannonRenderer extends EntityRenderer<GroundCannonEntity> {
    public GroundCannonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(GroundCannonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/entity/cannon/ship_cannon.png");
    }

    @Override
    public void render(GroundCannonEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        ResourceLocation resourceLocation = this.getTextureLocation(entity);
        poseStack.pushPose();
        poseStack.scale(-1.3F, -1.3F, 1.3F);

        /* use the cannon to render as it stores orientation and uses that to shoot */
        Cannon cannon = entity.getCannon();
        float lerpYaw = -(cannon.getPrevYaw() + (cannon.getYaw() - cannon.getPrevYaw()) * partialTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(lerpYaw));

        renderCannonModel(cannon, partialTicks, resourceLocation, poseStack, multiBufferSource, packedLight);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    public static void renderCannonModel(Cannon cannon, float partialTicks, ResourceLocation texture, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        /* facing positive Z */
        poseStack.mulPose(Axis.YN.rotationDegrees(180));
        poseStack.scale(0.6F, 0.6F, 0.6F);

        /* I have no idea why the model is offset, maybe the model itself is incorrect */
        poseStack.translate(0, -1.5, 0);

        CannonModel model = new CannonModel();
        float pitch = cannon.getPrevPitch() + partialTicks * (cannon.getPitch() - cannon.getPrevPitch());
        model.setLaufPitch(pitch);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(model.renderType(texture));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
        poseStack.popPose();
    }
}
