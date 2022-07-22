package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.items.CogItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

import static com.talhanation.smallships.entities.AbstractSailShip.Type.OAK;

public class RenderItemCog extends ItemStackTileEntityRenderer {

    private final Minecraft minecraft;
    private RenderEntityCog renderer;

    public RenderItemCog() {
        minecraft = Minecraft.getInstance();
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if (renderer == null) {
            renderer = new RenderEntityCog(minecraft.getEntityRenderDispatcher());
        }
        CogItem cogItem;
        switch (((CogItem) itemStackIn.getItem()).getType()) {
            case BIRCH: cogItem = (CogItem) ModItems.BIRCH_COG_ITEM.get();
            break;

            case ACACIA: cogItem = (CogItem) ModItems.ACACIA_COG_ITEM.get();
            break;

            case JUNGLE : cogItem = (CogItem) ModItems.JUNGLE_COG_ITEM.get();
            break;

            case SPRUCE : cogItem = (CogItem) ModItems.SPRUCE_COG_ITEM.get();
            break;

            case DARK_OAK : cogItem = (CogItem) ModItems.DARK_OAK_COG_ITEM.get();
            break;

            default : cogItem = (CogItem) ModItems.OAK_COG_ITEM.get();
            break;
        }
        renderer.render(cogItem.getCogEntity(minecraft.level), -90F, 1F, matrixStackIn, bufferIn, combinedLightIn);
    }
}
