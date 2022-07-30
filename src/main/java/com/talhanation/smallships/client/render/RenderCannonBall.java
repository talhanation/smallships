package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannonBall;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;


public class RenderCannonBall extends EntityRenderer<CannonBallEntity>{
    private static final ResourceLocation[] CANNON_BALL_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/cannonball.png"),
    };

    private final ModelCannonBall model;

    public RenderCannonBall(EntityRendererProvider.Context context) {
        super(context);
        model = new ModelCannonBall();
        this.shadowRadius = 0.25F;
    }

    @Override
    public void render(CannonBallEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        //                                x                y               z (- nachhinten)
        matrixStackIn.translate(0.0D, -1.0D,0.0D);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(CannonBallEntity entity) {
        return CANNON_BALL_TEXTURES[0];
    }

}
