package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.client.events.ClientRenderEvent;
import com.talhanation.smallships.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemStack;

public class RenderItemCog extends BlockEntityWithoutLevelRenderer {
    private final RenderEntityCog renderer;

    public RenderItemCog(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet) {
        super(renderDispatcher, modelSet);
        renderer = new RenderEntityCog(ClientRenderEvent.context);
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemTransforms.TransformType transformType, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        renderer.render(ModItems.OAK_COG_ITEM.getCogEntity(Minecraft.getInstance().level), -90F, 1F, matrixStackIn, bufferIn, combinedLightIn);
    }
}
