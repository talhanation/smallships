package com.talhanation.smallships.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.talhanation.smallships.client.model.block.DockyardBlockModel;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DockyardBlockRenderer implements BlockEntityRenderer<DockyardBlockEntity> {
	private static final ResourceLocation TEXTURE =
			ResourceLocation.fromNamespaceAndPath("smallships", "textures/block/dockyard.png");

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

		poseStack.pushPose();
		// Blockbench exportiert Entity-Modelle kopfueber: in die Blockmitte schieben und umdrehen
		poseStack.translate(0.5D, 1.5D, 0.5D);
		poseStack.scale(1.0F, -1.0F, -1.0F);
		poseStack.mulPose(Axis.YP.rotationDegrees(yRot));

		// entityCutout, weil Netz und Saegezaehne Alpha nutzen
		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
		this.model.render(poseStack, vertexConsumer, this.getLight(blockEntity, packedLight), packedOverlay);
		poseStack.popPose();
	}

	/**
	 * Solange der Block Licht blockiert, ist das Licht an seiner eigenen Position 0 und das
	 * Modell rendert schwarz. Dann wird das Licht der Nachbarposition oben genommen.
	 * Mit noOcclusion() am Block greift dieser Fallback nicht mehr.
	 */
	private int getLight(DockyardBlockEntity blockEntity, int packedLight) {
		if (LightTexture.block(packedLight) > 0 || LightTexture.sky(packedLight) > 0) {
			return packedLight;
		}
		Level level = blockEntity.getLevel();
		if (level == null) {
			return packedLight;
		}
		BlockPos above = blockEntity.getBlockPos().above();
		return LevelRenderer.getLightColor(level, above);
	}
}