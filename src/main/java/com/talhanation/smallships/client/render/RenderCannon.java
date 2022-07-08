package com.talhanation.smallships.client.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannon;
import com.talhanation.smallships.entities.AbstractCannonShip;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RenderCannon{
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/ship_cannon.png"),
    };

    public static void renderCannon(double offset,float angle, AbstractCannonShip cannonShip, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLight) {
        matrixStackIn.pushPose();
        //                               vorne       //- hoch/ + runter      //rechts/links
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(angle));
        matrixStackIn.translate( offset, 0.03D,       - 0.65D);

        //scale
        matrixStackIn.scale(0.75F, 0.75F, 0.75F);

        ModelCannon model = new ModelCannon();
        model.setupAnim(cannonShip, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = bufferIn.getBuffer(model.renderType(getCannonTexture()));
        model.renderToBuffer(matrixStackIn, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    public static ResourceLocation getCannonTexture(){
        return TEXTURES[0];
    }
}