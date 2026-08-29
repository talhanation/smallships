package com.talhanation.smallships.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.block.DockyardBlockModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Draws the dockyard item in hand, inventory, item frames and on the ground. It uses the same model
 * and the same transform as the block entity renderer, so the item cannot drift apart from the
 * placed block. The plain json model cannot do this, because the anchor, the plan and the saw use
 * rotations that the block model format does not support.
 */
public class DockyardItemRenderer extends BlockEntityWithoutLevelRenderer {
	private static DockyardItemRenderer instance;

	private DockyardBlockModel model;

	/**
	 * Created on first use rather than in a static initialiser, because the constructor needs
	 * Minecraft.getInstance(), which is not available while the class is being loaded. Only ever
	 * touched from the render thread, so no synchronisation is needed.
	 */
	public static DockyardItemRenderer getInstance() {
		if (instance == null) {
			instance = new DockyardItemRenderer();
		}
		return instance;
	}

	private DockyardItemRenderer() {
		super(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
				Minecraft.getInstance().getEntityModels());
	}

	@Override
	public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext displayContext,
							 @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource,
							 int packedLight, int packedOverlay) {
		// baked lazily: when this renderer is constructed the model set is not filled yet
		if (this.model == null) {
			this.model = new DockyardBlockModel(
					Minecraft.getInstance().getEntityModels().bakeLayer(DockyardBlockModel.LAYER_LOCATION));
		}

		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(DockyardBlockModel.TEXTURE));
		this.model.render(poseStack, vertexConsumer, packedLight, packedOverlay, 0.0F);
	}
}