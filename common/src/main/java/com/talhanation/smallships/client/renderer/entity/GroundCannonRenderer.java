package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.CannonModel;
import com.talhanation.smallships.client.renderer.entity.state.GroundCannonRenderState;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GroundCannonRenderer extends EntityRenderer<GroundCannonEntity, GroundCannonRenderState> {
    public GroundCannonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull GroundCannonRenderState createRenderState() {
        return new GroundCannonRenderState();
    }

    @Override
    public void extractRenderState(GroundCannonEntity entity, GroundCannonRenderState state, float f) {
        super.extractRenderState(entity, state, f);

        state.textureLocation = this.getTextureLocation(entity);
        state.cannon = entity.getCannon();
        state.partialTicks = f;
    }

    public @NotNull ResourceLocation getTextureLocation(GroundCannonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "textures/entity/cannon/ship_cannon.png");
    }

    @Override
    public void render(GroundCannonRenderState state, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        poseStack.scale(-1.3F, -1.3F, 1.3F);

        /* use the cannon to render as it stores orientation and uses that to shoot */
        Cannon cannon = state.cannon;
        float lerpYaw = -(cannon.getPrevYaw() + (cannon.getYaw() - cannon.getPrevYaw()) * state.partialTicks);
        poseStack.mulPose(Axis.YP.rotationDegrees(lerpYaw));

        renderCannonModel(state, poseStack, multiBufferSource, packedLight);

        poseStack.popPose();
        super.render(state, poseStack, multiBufferSource, packedLight);
    }

    private final CannonModel model = new CannonModel();
    public void renderCannonModel(GroundCannonRenderState state, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
        poseStack.pushPose();
        /* facing positive Z */
        poseStack.mulPose(Axis.YN.rotationDegrees(180));
        poseStack.scale(0.6F, 0.6F, 0.6F);

        /* I have no idea why the model is offset, maybe the model itself is incorrect */
        poseStack.translate(0, -1.5, 0);

        float pitch = state.cannon.getPrevPitch() + state.partialTicks * (state.cannon.getPitch() - state.cannon.getPrevPitch());
        model.setLaufPitch(pitch);

        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(state.textureLocation));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
    }
}
