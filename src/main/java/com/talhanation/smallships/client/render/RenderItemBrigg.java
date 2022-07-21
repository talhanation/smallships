package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.items.BriggItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

public class RenderItemBrigg extends ItemStackTileEntityRenderer {

    private final Minecraft minecraft;
    private RenderEntityBrigg renderer;

    public RenderItemBrigg() {
        minecraft = Minecraft.getInstance();
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if (renderer == null) {
            renderer = new RenderEntityBrigg(minecraft.getEntityRenderDispatcher());
        }
        BriggItem cogItem;
        switch (((BriggItem) itemStackIn.getItem()).getType()) {
            case BIRCH: cogItem = (BriggItem) ModItems.BIRCH_BRIGG_ITEM.get();
            break;

            case ACACIA: cogItem = (BriggItem) ModItems.ACACIA_BRIGG_ITEM.get();
            break;

            case JUNGLE : cogItem = (BriggItem) ModItems.JUNGLE_BRIGG_ITEM.get();
            break;

            case SPRUCE : cogItem = (BriggItem) ModItems.SPRUCE_BRIGG_ITEM.get();
            break;

            case DARK_OAK : cogItem = (BriggItem) ModItems.DARK_OAK_BRIGG_ITEM.get();
            break;

            default : cogItem = (BriggItem) ModItems.OAK_BRIGG_ITEM.get();
            break;
        }
        renderer.render(cogItem.getBriggEntity(minecraft.level), -90F, 1F, matrixStackIn, bufferIn, combinedLightIn);
    }
}
