package com.talhanation.smallships.client.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelCog extends EntityModel<CogEntity> {
	private final ModelRenderer Cog;
	private final ModelRenderer deck;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bottom;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer sides;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer mast_1;
	private final ModelRenderer cube_r6;
	private final ModelRenderer mast_oben;
	private final ModelRenderer chest_1;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer chest_4;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer chest_2;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer chest_3;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer steer;

	public ModelCog() {
		texWidth = 128;
		texHeight = 64;

		Cog = new ModelRenderer(this);
		Cog.setPos(0.0F, 24.0F, 0.0F);
		

		deck = new ModelRenderer(this);
		deck.setPos(14.0F, 0.0F, 0.0F);
		Cog.addChild(deck);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-14.0F, 0.0F, 0.0F);
		deck.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, 0.0F, 0.0F);
		cube_r1.texOffs(28, 0).addBox(28.0F, 0.0F, 2.0F, 14.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(28, 0).addBox(28.0F, -13.0F, 2.0F, 14.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(30, 0).addBox(-40.0F, -6.5F, 7.0F, 12.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-13.0F, -16.0F, 2.0F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-13.0F, 13.0F, 2.0F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(-28.0F, -13.0F, 2.0F, 28.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.0F, 16.0F, 2.0F, 18.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.0F, -19.0F, 2.0F, 18.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);

		bottom = new ModelRenderer(this);
		bottom.setPos(0.0F, 0.0F, 0.0F);
		Cog.addChild(bottom);
		bottom.texOffs(4, 1).addBox(42.0F, -11.0F, -3.5F, 4.0F, 13.0F, 7.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-28.44F, 2.4938F, 0.0F);
		bottom.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.5236F);
		cube_r2.texOffs(4, 1).addBox(-3.0F, -13.5F, -3.5F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		cube_r2.texOffs(4, 1).addBox(-3.0F, -6.5F, -3.5F, 7.0F, 13.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		bottom.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.5708F, 0.0F, 0.0F);
		cube_r3.texOffs(0, 0).addBox(38.0F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(16.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-6.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-28.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-28.0F, 2.0F, -3.0F, 22.0F, 10.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-28.0F, -12.0F, -3.0F, 22.0F, 10.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(18.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-6.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(18.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, 0.0F, false);

		sides = new ModelRenderer(this);
		sides.setPos(0.0F, 0.0F, 0.0F);
		Cog.addChild(sides);
		sides.texOffs(8, 36).addBox(-28.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-13.0F, -11.0F, -19.0F, 14.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(0.0F, -11.0F, -22.0F, 18.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(18.0F, -11.0F, -19.0F, 10.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-28.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-13.0F, -11.0F, 16.0F, 14.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(28.0F, -11.0F, -16.0F, 14.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(28.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(37.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(28.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(37.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-35.0F, -16.0F, -6.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-35.0F, -16.0F, 4.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-31.0F, -16.0F, 4.5F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-31.0F, -16.0F, -6.5F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-38.0F, -16.0F, 4.5F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(-38.0F, -16.0F, -6.5F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(28.0F, -11.0F, 13.0F, 14.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(0.0F, -11.0F, 19.0F, 18.0F, 6.0F, 3.0F, 0.0F, false);
		sides.texOffs(8, 36).addBox(18.0F, -11.0F, 16.0F, 10.0F, 6.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(35.0F, -8.0F, -9.5F);
		sides.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 1.5708F, 0.0F);
		cube_r4.texOffs(8, 36).addBox(-23.0F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-6.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-11.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-16.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-23.0F, -9.0F, 6.0F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-1.5F, -9.0F, 6.5F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-14.0F, -9.0F, 6.5F, 9.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r4.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-20.5F, -8.0F, -3.5F);
		sides.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
		cube_r5.texOffs(8, 36).addBox(3.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r5.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, 0.0F, false);

		mast_1 = new ModelRenderer(this);
		mast_1.setPos(14.0F, -5.0F, -1.0F);
		Cog.addChild(mast_1);
		mast_1.texOffs(8, 0).addBox(-3.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, 0.0F, false);
		mast_1.texOffs(8, 0).addBox(-3.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, 0.0F, false);
		mast_1.texOffs(8, 0).addBox(-3.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, 0.0F, false);
		mast_1.texOffs(8, 0).addBox(-3.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, 0.0F, false);
		mast_1.texOffs(8, 0).addBox(-3.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-47.5F, -15.5F, 1.0F);
		mast_1.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
		cube_r6.texOffs(8, 0).addBox(-6.0F, -7.5F, -1.5F, 3.0F, 17.0F, 3.0F, 0.0F, false);

		mast_oben = new ModelRenderer(this);
		mast_oben.setPos(0.0F, 0.0F, 0.0F);
		Cog.addChild(mast_oben);
		mast_oben.texOffs(0, 0).addBox(9.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		mast_oben.texOffs(0, 0).addBox(9.0F, -69.0F, -32.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		mast_oben.texOffs(0, 0).addBox(9.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);
		mast_oben.texOffs(0, 0).addBox(9.0F, -69.0F, 16.0F, 2.0F, 2.0F, 16.0F, 0.0F, false);

		chest_1 = new ModelRenderer(this);
		chest_1.setPos(0.0F, 0.0F, 0.0F);
		Cog.addChild(chest_1);
		chest_1.texOffs(96, 38).addBox(24.0F, -13.0F, -13.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(27.75F, -11.75F, -8.25F);
		chest_1.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.5708F, 0.0F);
		cube_r7.texOffs(30, 55).addBox(-2.75F, -4.25F, -2.25F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(19.0F, -15.5F, -18.0F);
		chest_1.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.5708F, -1.5708F, 0.0F);
		cube_r8.texOffs(30, 55).addBox(-1.0F, 5.5F, -10.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(31.0F, 9.0F, -75.0F);
		chest_1.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -1.5708F, 0.0F);
		cube_r9.texOffs(30, 55).addBox(57.0F, -19.0F, 25.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(22.0F, -9.0F, -1.0F);
		chest_1.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 3.1416F, 0.0F);
		cube_r10.texOffs(96, 38).addBox(-19.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		chest_4 = new ModelRenderer(this);
		chest_4.setPos(-23.0F, -11.5F, 9.0F);
		Cog.addChild(chest_4);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 0.0F, 0.0F);
		chest_4.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 1.5708F, 0.0F);
		cube_r11.texOffs(64, 29).addBox(-3.0F, -1.5F, -4.0F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(3.0F, 20.5F, -42.0F);
		chest_4.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -1.5708F, 0.0F);
		cube_r12.texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 20.5F, -42.0F);
		chest_4.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -1.5708F, 0.0F);
		cube_r13.texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, 0.0F, false);

		chest_2 = new ModelRenderer(this);
		chest_2.setPos(19.0F, -15.5F, 15.0F);
		Cog.addChild(chest_2);
		

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, 0.0F, 0.0F);
		chest_2.addChild(cube_r14);
		setRotationAngle(cube_r14, 1.5708F, -1.5708F, 0.0F);
		cube_r14.texOffs(30, 55).addBox(0.0F, 6.5F, -10.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(12.0F, 24.5F, -57.0F);
		chest_2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -1.5708F, 0.0F);
		cube_r15.texOffs(30, 55).addBox(57.0F, -19.0F, 14.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r15.texOffs(30, 55).addBox(32.0F, -25.0F, -8.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(3.0F, 6.5F, -16.0F);
		chest_2.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 3.1416F, 0.0F);
		cube_r16.texOffs(96, 38).addBox(-19.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		chest_3 = new ModelRenderer(this);
		chest_3.setPos(51.3333F, -8.0F, -11.1667F);
		Cog.addChild(chest_3);
		

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-20.3333F, 17.0F, -33.8333F);
		chest_3.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -1.5708F, 0.0F);
		cube_r17.texOffs(30, 55).addBox(33.0F, -19.0F, 53.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r17.texOffs(31, 56).addBox(33.0F, -19.0F, 49.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-29.3333F, -1.0F, 7.1667F);
		chest_3.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 1.5708F, 0.0F);
		cube_r18.texOffs(96, 38).addBox(-4.0F, -4.0F, -49.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		steer = new ModelRenderer(this);
		steer.setPos(42.0F, 9.0F, 0.0F);
		Cog.addChild(steer);
		steer.texOffs(4, 1).addBox(0.0F, -7.0F, -1.0F, 4.0F, 14.0F, 2.0F, 0.0F, false);
	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(CogEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.chest_1.visible = (entityIn).getCargo() >= 1;
		this.chest_2.visible = (entityIn).getCargo() >= 2;
		this.chest_3.visible = (entityIn).getCargo() >= 3;
		this.chest_4.visible = (entityIn).getCargo() >= 4;


		this.steer.yRot = -entityIn.getRotSpeed();
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Cog.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}