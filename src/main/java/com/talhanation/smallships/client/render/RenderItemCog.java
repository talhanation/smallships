package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.talhanation.smallships.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;

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
        renderer.render(ModItems.OAK_COG_ITEM.getCogEntity(minecraft.level, itemStackIn), 90F, 1F, matrixStackIn, bufferIn, combinedLightIn);
    }
}
