package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonBallModel;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class CannonBallRenderer extends EntityRenderer<CannonBallEntity>{
    private final CannonBallModel model;

    public CannonBallRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new CannonBallModel();
        this.shadowRadius = 0.25F;
    }

    @Override
    public void render(@NotNull CannonBallEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        poseStack.pushPose();
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.translate(0.0D, -1.0D,0.0D);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CannonBallEntity entity) {
        return new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/cannon/cannon_ball.png");
    }

}
