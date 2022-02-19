package com.talhanation.smallships.client.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.CannonBallEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelCannonBall extends EntityModel<CannonBallEntity> {
	private final ModelRenderer cannonball;

	public ModelCannonBall() {
		texWidth = 16;
		texHeight = 16;

		cannonball = new ModelRenderer(this);
		cannonball.setPos(0.0F, 23.5F, 0.0F);
		cannonball.setTexSize(0, 0).addBox(1.5F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-3.0F, -6.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-2.0F, -6.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-2.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-3.0F, -5.0F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-2.0F, -4.0F, 2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cannonball.setTexSize(10, 0).addBox(-2.0F, -4.0F, -3.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-3.0F, -5.0F, -3.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(1.0F, -5.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-4.0F, -5.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		cannonball.setTexSize(0, 0).addBox(-4.5F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(CannonBallEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		cannonball.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}