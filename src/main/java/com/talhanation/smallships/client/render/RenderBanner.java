package com.talhanation.smallships.client.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.entities.AbstractBannerUser;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.List;

public class RenderBanner {

    public static void renderBanner(AbstractBannerUser abstractBannerUser, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, ItemStack banner, int packedLight, ModelPart modelPart) {

        if (!banner.isEmpty()) {
            matrixStackIn.pushPose();
            EntityType<?> entityType = abstractBannerUser.getType();

            //banner pos for ships:


            if (entityType == ModEntityTypes.COG.get()) {
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-180.0F));
                matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                //                                hight - = +    vorne
                matrixStackIn.translate(-3.1D, 0.87D, 0.05D);

            } else if(entityType == ModEntityTypes.BRIGG.get()){
                matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
                matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90F));
                matrixStackIn.translate(-6.4D, 1.65D, 0.0D);
/*
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
                //banner weaving here
                float bannerWaveAngle = abstractBannerUser.getBannerWaveAngle(partialTicks);
                if (!Mth.equal(bannerWaveAngle, 0F))
                    matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(bannerWaveAngle));

                modelPart.getChild("pole").visible = false;
                modelPart.getChild("bar").visible = false;

                // getting banner pattern here
                List<Pair<Holder<BannerPattern>, DyeColor>> patterns = BannerBlockEntity.createPatterns(((BannerItem) banner.getItem()).getColor(), BannerBlockEntity.getItemPatterns(banner));
                BannerRenderer.renderPatterns(matrixStackIn, bufferIn, packedLight, OverlayTexture.NO_OVERLAY, modelPart, ModelBakery.BANNER_BASE, true, patterns);
                matrixStackIn.popPose();
            }
        }
    }
}