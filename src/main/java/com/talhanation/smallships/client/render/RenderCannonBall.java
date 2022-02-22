package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannonBall;
import com.talhanation.smallships.entities.projectile.CannonBallEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderCannonBall extends EntityRenderer<CannonBallEntity>{
    private static final ResourceLocation[] COG_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/cannonball.png"),
    };

    private final ModelCannonBall model = new ModelCannonBall();

    public RenderCannonBall(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.shadowRadius = 0.25F;
    }

    @Override
    public void render(CannonBallEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(1F, 1F, 1F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(CannonBallEntity entity) {
        return COG_TEXTURES[0];
    }

}
