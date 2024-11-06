package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.client.model.ShipModel;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.abilities.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

public class CannonRenderer extends EntityRenderer<GroundCannonEntity> {
    public CannonRenderer(EntityRendererProvider.Context context) {
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

        renderCannonModel(new Cannon(), resourceLocation, poseStack, multiBufferSource, packedLight);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    public static void renderCannonModel(Cannon cannon, ResourceLocation texture, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        /* facing positive Z */
        poseStack.mulPose(Axis.YN.rotationDegrees(180));
        poseStack.scale(0.6F, 0.6F, 0.6F);

        /* I have no idea why the model is offset, maybe the model itself is incorrect */
        poseStack.translate(0, -1.5, 0);

        CannonModel model = new CannonModel();
        //cannonModel.setupAnim((T)cannonShipEntity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(model.renderType(texture));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
        poseStack.popPose();
    }
}
