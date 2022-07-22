package com.talhanation.smallships.client.render;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCannon;
import com.talhanation.smallships.entities.AbstractCannonShip;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderCannon{
    private static final ModelCannon MODEL = new ModelCannon();

    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/ship_cannon.png"),
    };

    public RenderCannon(EntityRendererManager entityRenderDispatcher) {

    }

    public static void renderCannon(double Zoffset, double Xoffset, double height, float angle, AbstractCannonShip cannonShip, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLight) {
        matrixStackIn.pushPose();
        //                               vorne       //- hoch/ + runter      //rechts/links
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(angle));
        matrixStackIn.translate(Xoffset, height,       Zoffset);

        //scale
        matrixStackIn.scale(0.75F, 0.75F, 0.75F);


        MODEL.setupAnim(cannonShip, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(MODEL.renderType(getCannonTexture()));
        MODEL.renderToBuffer(matrixStackIn, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.popPose();
    }

    public static ResourceLocation getCannonTexture(){
        return TEXTURES[0];
    }
}