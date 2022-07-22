package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.client.events.ClientRenderEvent;
import com.talhanation.smallships.init.ModItems;
import com.talhanation.smallships.items.BriggItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemStack;

public class RenderItemBrigg extends BlockEntityWithoutLevelRenderer {
    private final RenderEntityBrigg renderer;

    public RenderItemBrigg(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet) {
        super(renderDispatcher, modelSet);
        renderer = new RenderEntityBrigg(ClientRenderEvent.context);
    }

    @Override
    public void renderByItem(ItemStack itemStackIn, ItemTransforms.TransformType transformType, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        BriggItem briggItem;
        switch (((BriggItem) itemStackIn.getItem()).getType()) {
            case BIRCH -> briggItem = (BriggItem) ModItems.BIRCH_BRIGG_ITEM.get();
            case ACACIA -> briggItem = (BriggItem) ModItems.ACACIA_BRIGG_ITEM.get();
            case JUNGLE -> briggItem = (BriggItem) ModItems.JUNGLE_BRIGG_ITEM.get();
            case SPRUCE -> briggItem = (BriggItem) ModItems.SPRUCE_BRIGG_ITEM.get();
            case DARK_OAK -> briggItem = (BriggItem) ModItems.DARK_OAK_BRIGG_ITEM.get();
            default -> briggItem = (BriggItem) ModItems.OAK_BRIGG_ITEM.get();
        }
        renderer.render(briggItem.getBriggEntity(Minecraft.getInstance().level), -90F, 1F, matrixStackIn, bufferIn, combinedLightIn);
    }
}