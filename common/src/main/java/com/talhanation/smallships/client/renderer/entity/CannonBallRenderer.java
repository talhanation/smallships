package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonBallModel;
import com.talhanation.smallships.client.renderer.entity.state.CannonBallRenderState;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class CannonBallRenderer extends EntityRenderer<CannonBallEntity, CannonBallRenderState>{
    private final CannonBallModel model;

    public CannonBallRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new CannonBallModel();
        this.shadowRadius = 0.25F;
    }

    @Override
    public @NotNull CannonBallRenderState createRenderState() {
        return new CannonBallRenderState();
    }

    @Override
    public void extractRenderState(CannonBallEntity entity, CannonBallRenderState state, float f) {
        super.extractRenderState(entity, state, f);
        state.renderType = this.model.renderType(getTextureLocation(entity));
    }

    @Override
    public void render(CannonBallRenderState state, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.translate(0.0D, -1.0D,0.0D);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(state.renderType);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
        poseStack.popPose();
        super.render(state, poseStack, multiBufferSource, packedLight);
    }


    public @NotNull ResourceLocation getTextureLocation(@NotNull CannonBallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/cannon/cannon_ball.png");
    }

}
