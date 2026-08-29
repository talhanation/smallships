package com.talhanation.smallships.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.client.model.block.DockyardBlockModel;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DockyardBlockRenderer implements BlockEntityRenderer<DockyardBlockEntity> {
	private final DockyardBlockModel model;

	public DockyardBlockRenderer(BlockEntityRendererProvider.Context context) {
		this.model = new DockyardBlockModel(context.bakeLayer(DockyardBlockModel.LAYER_LOCATION));
	}

	@Override
	public void render(DockyardBlockEntity blockEntity, float partialTick, PoseStack poseStack,
					   MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		BlockState state = blockEntity.getBlockState();
		float yRot = state.hasProperty(HorizontalDirectionalBlock.FACING)
				? state.getValue(HorizontalDirectionalBlock.FACING).toYRot()
				: 0.0F;

		// entityCutout, because the net and the saw teeth use alpha
		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(DockyardBlockModel.TEXTURE));
		this.model.render(poseStack, vertexConsumer, this.getLight(blockEntity, packedLight), packedOverlay, yRot);
	}

	/**
	 * As long as the block occludes light, the light level at its own position is 0 and the model
	 * renders black. In that case the light of the neighbour above is used instead. With
	 * noOcclusion() on the block this fallback never kicks in.
	 */
	private int getLight(DockyardBlockEntity blockEntity, int packedLight) {
		if (LightTexture.block(packedLight) > 0 || LightTexture.sky(packedLight) > 0) {
			return packedLight;
		}
		Level level = blockEntity.getLevel();
		if (level == null) {
			return packedLight;
		}
		return LevelRenderer.getLightColor(level, blockEntity.getBlockPos().above());
	}
}