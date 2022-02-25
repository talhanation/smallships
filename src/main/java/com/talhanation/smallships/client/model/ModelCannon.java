package com.talhanation.smallships.client.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.AbstractCannonShip;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelCannon extends EntityModel<AbstractCannonShip> {
	private final ModelRenderer cannon;
	private final ModelRenderer achse2_r1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer lauf;

	public ModelCannon() {
		texWidth = 128;
		texHeight = 64;

		cannon = new ModelRenderer(this);
		cannon.setPos(0.9F, 24.75F, 0.0F);
		cannon.texOffs(80, 29).addBox(1.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, 0.0F, false);
		cannon.texOffs(80, 29).addBox(-6.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, 0.0F, false);
		cannon.texOffs(80, 29).addBox(-3.5F, -6.0F, 2.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cannon.texOffs(80, 29).addBox(-3.5F, -6.0F, -4.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cannon.texOffs(75, 15).addBox(5.1F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cannon.texOffs(75, 15).addBox(5.1F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cannon.texOffs(75, 15).addBox(-8.0F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		cannon.texOffs(75, 15).addBox(-7.9F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		achse2_r1 = new ModelRenderer(this);
		achse2_r1.setPos(-0.5F, -2.4F, 5.0F);
		cannon.addChild(achse2_r1);
		setRotationAngle(achse2_r1, 0.7854F, 0.0F, 0.0F);
		achse2_r1.texOffs(87, 58).addBox(-8.0F, -7.5F, -7.7F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		achse2_r1.texOffs(87, 58).addBox(-8.0F, -0.4F, -0.6F, 15.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-10.0F, -6.0173F, 0.8198F);
		cannon.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
		cube_r1.texOffs(80, 29).addBox(12.0F, -1.8F, -7.1F, 2.0F, 5.0F, 14.0F, 0.0F, false);
		cube_r1.texOffs(80, 29).addBox(4.0F, -1.85F, -7.1F, 2.0F, 5.0F, 14.0F, 0.0F, false);

		lauf = new ModelRenderer(this);
		lauf.setPos(-1.0F, -8.9833F, -2.75F);
		cannon.addChild(lauf);
		setRotationAngle(lauf, -0.0873F, 0.0F, 0.0F);
		lauf.texOffs(89, 3).addBox(-2.0F, 1.9833F, -4.25F, 4.0F, 1.0F, 10.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, -3.0167F, -4.25F, 4.0F, 1.0F, 10.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-3.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(2.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, -2.5167F, -12.25F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, 1.4833F, -12.25F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(1.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, 1.7833F, -13.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(1.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, -2.8167F, -13.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-2.0F, -2.0167F, 4.75F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-1.5F, -1.4167F, 7.75F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		lauf.texOffs(89, 3).addBox(-1.0F, -0.9167F, 8.75F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(AbstractCannonShip entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		cannon.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}