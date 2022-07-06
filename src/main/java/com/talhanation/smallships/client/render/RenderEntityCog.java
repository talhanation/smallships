package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCog;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderEntityCog extends EntityRenderer<CogEntity> {
    private static final ResourceLocation[] COG_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/oak_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/spruce_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/birch_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/jungle_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/acacia_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/cog/dark_oak_cog.png"),
/*
            //BOP//
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_cherry_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_dead_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_fir_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_hellbark_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_jacaranda_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_magic_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_mahogany_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_palm_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_redwood_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_umbran_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/bop/cog/bop_willow_cog.png"),

            //LOTR//
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_apple_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_aspen_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_beech_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_cedar_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_charred_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_cherry_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_cypress_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_fir_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_green_oak_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_holly_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_lairelosse_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_larch_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_lebethron_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_mallorn_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_maple_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_mirk_oak_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_pear_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_pine_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/lotr/cog/lotr_rotten_cog.png"),

            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/envi/cog/envi_cherry_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/envi/cog/envi_wisteria_cog.png"),
            new ResourceLocation(Main.MOD_ID,"textures/entity/mod/envi/cog/envi_willow_cog.png")
*/
    };

    private final ModelCog model;

    public RenderEntityCog(EntityRendererProvider.Context context) {
        super(context);
        model = new ModelCog();
        this.shadowRadius = 1.5F;
    }

    @Override
    public void render(CogEntity entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.4D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));

        if (SmallShipsConfig.MakeWaveAnimation.get()) {
            float waveAngle = entityIn.getWaveAngle(partialTicks);
            if (!Mth.equal(waveAngle, 0F)) {
                matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(waveAngle));
            }
        }

        matrixStackIn.scale(-1.3F, -1.3F, 1.3F);
        //                                x                y               z (- nachhinten)
        matrixStackIn.translate(0.0D, -1.8D,-1.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90F));
        this.model.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(this.model.renderType(getTextureLocation(entityIn)));
        this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        //render Banner
        entityIn.renderBanner(matrixStackIn,bufferIn,packedLightIn,partialTicks);

        //render Sail Color
        entityIn.renderSailColor(matrixStackIn,bufferIn,packedLightIn,partialTicks);

        //render Cannon
        entityIn.renderCannon(matrixStackIn,bufferIn,packedLightIn,partialTicks);

        matrixStackIn.popPose();

    }

    @Override
    public ResourceLocation getTextureLocation(CogEntity entity) {
        return COG_TEXTURES[entity.getWoodType().ordinal()];
    }

}
