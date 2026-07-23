package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.projectile.ChainShotModel;
import com.talhanation.smallships.world.entity.projectile.ChainShotEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class ChainShotRenderer extends EntityRenderer<ChainShotEntity>{
    private final ChainShotModel model;

    public ChainShotRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new ChainShotModel();
        this.shadowRadius = 0.25F;
    }

    @Override
    public void render(@NotNull ChainShotEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        poseStack.pushPose();
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.translate(0.0D, -1.0D,0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(1.2F * partialTicks));
        VertexConsumer vertexConsumer = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ChainShotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/cannon/cannon_ball.png");
    }

}
