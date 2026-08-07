package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.projectile.GrapeShotModel;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.projectile.GrapeShotEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


public class GrapeShotRenderer extends EntityRenderer<GrapeShotEntity>{
    private final GrapeShotModel model;
    private static final float SPIN_DEGREES_PER_TICK = 20.0F;
    public GrapeShotRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new GrapeShotModel();
        this.shadowRadius = 0.25F;
    }

    @Override
    public void render(@NotNull GrapeShotEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        poseStack.pushPose();
        poseStack.scale(0.45F, 0.45F, 0.45F);
        poseStack.translate(0.0D, -1.0D,0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees((entity.tickCount + partialTicks) * SPIN_DEGREES_PER_TICK));
        VertexConsumer vertexConsumer = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entity)));
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 0xFFFFFF);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
    }

    @Override
    public boolean shouldRender(@NotNull GrapeShotEntity entity, @NotNull Frustum frustum, double camX, double camY, double camZ) {
        double distanceSqr = entity.distanceToSqr(camX, camY, camZ);
        return distanceSqr < AbstractCannonBall.RENDER_RANGE * AbstractCannonBall.RENDER_RANGE;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GrapeShotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/cannon/cannon_ball.png");
    }

}