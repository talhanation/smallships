package com.talhanation.smallships.client.render;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.entities.AbstractBannerUser;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.BannerTileEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BannerItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import java.util.List;

public class RenderBanner {
    private static final BannerTileEntity BANNER_TE = new BannerTileEntity();

    public static void renderBanner(AbstractBannerUser abstractBannerUser, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, ItemStack banner, int packedLight, ModelRenderer modelRenderer) {

        if (!banner.isEmpty()) {
            matrixStackIn.pushPose();
            EntityType<?> entityType = abstractBannerUser.getType();

            //banner pos for ships:
            matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-180.0F));
            matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));

            if (entityType == ModEntityTypes.COG.get()) {
                //                                hight - = +      vorne
                matrixStackIn.translate(-3.1D, 0.87D, 0.05D);
            /*
            } else if(entityType == ModEntityTypes.BRIGG_ENTITY.get()){

                matrixStackIn.translate(-5.8D, 1.65D, 0.0D);

            } else if(entityType == ModEntityTypes.DRAKKAR_ENTITY.get()){
                matrixStackIn.translate(-3.6D, 0.1D, 0.05D);

            }
            else if(entityType == ModEntityTypes.GALLEY_ENTITY.get()){
                matrixStackIn.translate(-4.3D, 0.5D, 0.05D);

            }
            else if(entityType == ModEntityTypes.WAR_GALLEY_ENTITY.get()){
                matrixStackIn.translate(-5.5D, 1.4D, 0.1D);

            }else if(entityType == ModEntityTypes.DHOW_ENTITY.get()){
                matrixStackIn.translate(-6.2D, -1.4D, 0.05D);

            }

             */
                //scale
                matrixStackIn.scale(0.5F, 0.5F, 0.5F);

                BannerItem item = (BannerItem) banner.getItem();
                BANNER_TE.fromItem(banner, item.getColor());

                //banner waveing here
                float bannerWaveAngle = abstractBannerUser.getBannerWaveAngle(partialTicks);
                if (!MathHelper.equal(bannerWaveAngle, 0F))
                    matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(bannerWaveAngle));

                // getting banner pattern here
                List<Pair<BannerPattern, DyeColor>> list = BANNER_TE.getPatterns();
                BannerTileEntityRenderer.renderPatterns(matrixStackIn, bufferIn, packedLight, OverlayTexture.NO_OVERLAY, modelRenderer, ModelBakery.BANNER_BASE, true, list);
                matrixStackIn.popPose();
            }
        }
    }
}