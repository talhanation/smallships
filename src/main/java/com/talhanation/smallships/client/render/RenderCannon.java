package com.talhanation.smallships.client.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannon;
import com.talhanation.smallships.entities.AbstractCannonShip;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RenderCannon{
    private static ModelCannon<CogEntity> model;

    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/ship_cannon.png"),
    };

    public RenderCannon(EntityRendererProvider.Context context) {
        model = new ModelCannon<>(context.bakeLayer(ModelCannon.LAYER_LOCATION));
    }

    public static void renderCannon(double offset,float angle, AbstractCannonShip cannonShip, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLight) {
        matrixStackIn.pushPose();
        //                               vorne       //- hoch/ + runter      //rechts/links
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(angle));
        matrixStackIn.translate( offset, 0.03D,       - 0.65D);

        //scale
        matrixStackIn.scale(0.75F, 0.75F, 0.75F);


        model.setupAnim((CogEntity) cannonShip, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(model.renderType(getCannonTexture()));
        model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    public static ResourceLocation getCannonTexture(){
        return TEXTURES[0];
    }
}