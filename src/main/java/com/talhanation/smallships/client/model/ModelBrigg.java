package com.talhanation.smallships.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.talhanation.smallships.entities.BriggEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelBrigg extends EntityModel<BriggEntity> {
	private final ModelRenderer ModelBrigg;
	private final ModelRenderer bottom_brigg;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer sides_brigg;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer chest_1;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer chest_2;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer chest_3;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer chest_4;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer BannerStick;
	private final ModelRenderer cube_r27;
	private final ModelRenderer steer;
	private final ModelRenderer steer_r1;

	public ModelBrigg() {
		texWidth = 128;
		texHeight = 64;

		ModelBrigg = new ModelRenderer(this);
		ModelBrigg.setPos(3.0F, 24.0F, 0.0F);


		bottom_brigg = new ModelRenderer(this);
		bottom_brigg.setPos(0.0F, 0.0F, 0.0F);
		ModelBrigg.addChild(bottom_brigg);
		bottom_brigg.texOffs(0, 12).addBox(-3.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-3.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-28.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-28.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-31.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-3.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-40.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-3.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(25.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-31.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, 0.0F, false);
		bottom_brigg.texOffs(0, 12).addBox(-40.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-3.5F, -80.669F, 28.9006F);
		bottom_brigg.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.4399F, 0.0F, 0.0F);
		cube_r1.texOffs(25, 0).addBox(-0.5F, -35.0F, 38.9F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(25, 0).addBox(-0.5F, -23.0F, 38.9F, 2.0F, 17.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(25, 0).addBox(-0.5F, -6.0F, 38.9F, 2.0F, 13.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(-3.5F, -80.669F, 28.9006F);
		bottom_brigg.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.1345F, 0.0F, 0.0F);
		cube_r2.texOffs(25, 0).addBox(-0.5F, -41.0F, 5.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(25, 0).addBox(-0.5F, -33.0F, 5.0F, 2.0F, 18.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(25, 0).addBox(-0.5F, -15.0F, 5.0F, 2.0F, 19.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		bottom_brigg.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.5708F, -1.5708F, 0.0F);
		cube_r3.texOffs(0, 12).addBox(-18.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(-18.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(-18.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(-18.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(25.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(25.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(25.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 12).addBox(25.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(28.0F, -1.0F, -14.0F, 18.0F, 15.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-42.0F, -6.0F, -14.0F, 14.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(0.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-28.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(28.0F, -5.0F, -14.0F, 18.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(28.0F, -20.0F, -14.0F, 18.0F, 15.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(0.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 3).addBox(-28.0F, -22.0F, -14.0F, 16.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 3).addBox(-28.0F, 13.0F, -14.0F, 16.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 3).addBox(16.0F, 13.0F, -14.0F, 12.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(16.0F, -22.0F, -14.0F, 12.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-12.0F, -25.0F, -14.0F, 28.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-12.0F, 13.0F, -14.0F, 28.0F, 6.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-28.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-42.0F, 0.0F, -14.0F, 14.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-42.0F, -19.0F, -14.0F, 14.0F, 13.0F, 3.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-39.0F, -15.0F, -11.0F, 24.0F, 12.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-39.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(-15.0F, -16.0F, -11.0F, 24.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 22.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 22.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(31.0F, -3.0F, -11.0F, 14.0F, 13.0F, 5.0F, 0.0F, false);
		cube_r3.texOffs(0, 0).addBox(31.0F, -16.0F, -11.0F, 14.0F, 13.0F, 5.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-3.0F, -3.0F, -29.0F);
		bottom_brigg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.texOffs(4, 0).addBox(-7.0F, -3.0F, -5.5F, 16.0F, 6.0F, 11.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-3.5F, -13.5F, -50.0F);
		bottom_brigg.addChild(cube_r5);
		setRotationAngle(cube_r5, 3.1416F, -0.6545F, 1.5708F);
		cube_r5.texOffs(0, 2).addBox(3.0F, 0.5F, -11.5F, 16.0F, 6.0F, 9.0F, 0.0F, true);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 0.0F, 0.0F);
		bottom_brigg.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
		cube_r6.texOffs(3, 0).addBox(42.0F, -15.0F, -2.5F, 6.0F, 15.0F, 11.0F, 0.0F, false);
		cube_r6.texOffs(0, 0).addBox(22.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, 0.0F, false);
		cube_r6.texOffs(0, 0).addBox(0.0F, -6.0F, -2.5F, 10.0F, 6.0F, 11.0F, 0.0F, false);
		cube_r6.texOffs(0, 0).addBox(10.0F, -6.0F, -2.5F, 12.0F, 6.0F, 11.0F, 0.0F, false);
		cube_r6.texOffs(0, 0).addBox(-20.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, 0.0F, false);

		sides_brigg = new ModelRenderer(this);
		sides_brigg.setPos(0.0F, 0.0F, 0.0F);
		bottom_brigg.addChild(sides_brigg);
		sides_brigg.texOffs(0, 12).addBox(25.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, 0.0F, 0.0F);
		sides_brigg.addChild(cube_r7);
		setRotationAngle(cube_r7, -1.5708F, -1.5708F, 0.0F);
		cube_r7.texOffs(0, 0).addBox(16.0F, -25.0F, -20.0F, 12.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(37.0F, 13.0F, -22.0F, 9.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-12.0F, -28.0F, -20.0F, 12.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-12.0F, 19.0F, -20.0F, 12.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(0.0F, 19.0F, -20.0F, 16.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-28.0F, 16.0F, -20.0F, 16.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(28.0F, -22.0F, -22.0F, 9.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(28.0F, 13.0F, -22.0F, 9.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(37.0F, -22.0F, -22.0F, 9.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(16.0F, 16.0F, -20.0F, 12.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-28.0F, -25.0F, -20.0F, 16.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(0.0F, -28.0F, -20.0F, 16.0F, 3.0F, 6.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-42.0F, 13.0F, -22.0F, 14.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r7.texOffs(8, 0).addBox(-45.0F, -2.0F, -24.0F, 3.0F, 15.0F, 10.0F, 0.0F, false);
		cube_r7.texOffs(10, 0).addBox(-45.0F, -19.0F, -24.0F, 3.0F, 15.0F, 10.0F, 0.0F, false);
		cube_r7.texOffs(0, 0).addBox(-42.0F, -22.0F, -22.0F, 14.0F, 3.0F, 8.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-3.0F, -12.5335F, 47.4516F);
		sides_brigg.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.1222F, 1.5708F);
		cube_r8.texOffs(0, 0).addBox(-12.5F, -2.0F, -3.0F, 25.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, -1.6155F, 46.111F);
		sides_brigg.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.1222F, 1.5708F);
		cube_r9.texOffs(0, 0).addBox(-23.5F, -3.0F, -3.0F, 14.0F, 4.0F, 6.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(-11.5F, -17.0F, 48.0F);
		sides_brigg.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.1222F, 1.5708F);
		cube_r10.texOffs(0, 0).addBox(-16.0F, -10.0F, 3.0F, 22.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r10.texOffs(0, 0).addBox(-8.0F, -6.5F, -3.0F, 14.0F, 4.0F, 6.0F, 0.0F, false);
		cube_r10.texOffs(0, 0).addBox(-6.0F, -24.5F, -3.0F, 12.0F, 10.0F, 6.0F, 0.0F, false);
		cube_r10.texOffs(0, 0).addBox(-6.0F, -2.5F, -3.0F, 12.0F, 10.0F, 6.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(-3.5F, -13.5F, -46.0F);
		sides_brigg.addChild(cube_r11);
		setRotationAngle(cube_r11, 3.1416F, -1.0996F, 1.5708F);
		cube_r11.texOffs(0, 4).addBox(-44.0F, -1.0F, -13.5F, 16.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r11.texOffs(0, 7).addBox(13.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r11.texOffs(0, 7).addBox(-2.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r11.texOffs(0, 4).addBox(-28.0F, -1.0F, -13.5F, 26.0F, 3.0F, 4.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(-3.5F, -13.5F, -62.0F);
		sides_brigg.addChild(cube_r12);
		setRotationAngle(cube_r12, 3.1416F, -0.0436F, 1.5708F);
		cube_r12.texOffs(3, 2).addBox(-13.7F, -2.5F, -17.0F, 7.0F, 6.0F, 7.0F, 0.0F, true);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(-3.5F, -13.5F, -62.0F);
		sides_brigg.addChild(cube_r13);
		setRotationAngle(cube_r13, 3.1416F, -0.6545F, 1.5708F);
		cube_r13.texOffs(0, 2).addBox(0.0F, -4.5F, -21.0F, 13.0F, 5.0F, 9.0F, 0.0F, true);
		cube_r13.texOffs(0, 2).addBox(0.0F, 0.5F, -21.0F, 13.0F, 5.0F, 9.0F, 0.0F, true);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(-3.5F, -13.5F, -50.0F);
		sides_brigg.addChild(cube_r14);
		setRotationAngle(cube_r14, 3.1416F, -0.6545F, 1.5708F);
		cube_r14.texOffs(0, 2).addBox(3.0F, -5.5F, -11.5F, 16.0F, 6.0F, 9.0F, 0.0F, true);

		chest_1 = new ModelRenderer(this);
		chest_1.setPos(0.0F, 0.0F, 0.0F);
		ModelBrigg.addChild(chest_1);


		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(0.0F, 0.0F, 0.0F);
		chest_1.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -1.5708F, 0.0F);
		cube_r15.texOffs(31, 56).addBox(33.0F, -19.0F, 9.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		cube_r15.texOffs(30, 55).addBox(33.0F, -19.0F, 12.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r15.texOffs(30, 55).addBox(41.0F, -27.0F, 10.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r15.texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r15.texOffs(30, 55).addBox(38.0F, -19.0F, -10.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-9.0F, -18.0F, 41.0F);
		chest_1.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 1.5708F, 0.0F);
		cube_r16.texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-3.0F, -20.5F, 42.0F);
		chest_1.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 1.5708F, 0.0F);
		cube_r17.texOffs(64, 29).addBox(-3.0F, -1.5F, -3.75F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-3.0F, 0.0F, 0.0F);
		chest_1.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -1.5708F, 0.0F);
		cube_r18.texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, 0.0F, false);

		chest_2 = new ModelRenderer(this);
		chest_2.setPos(0.0F, 0.0F, 0.0F);
		ModelBrigg.addChild(chest_2);


		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(-9.0F, -18.0F, 41.0F);
		chest_2.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 3.1416F, 0.0F);
		cube_r19.texOffs(96, 38).addBox(-17.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r19.texOffs(96, 38).addBox(-8.5F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, 0.0F, 0.0F);
		chest_2.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, -1.5708F, 0.0F);
		cube_r20.texOffs(30, 55).addBox(30.0F, -25.0F, 2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		cube_r20.texOffs(30, 55).addBox(32.0F, -25.0F, -5.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		chest_3 = new ModelRenderer(this);
		chest_3.setPos(-13.1667F, -18.9167F, -31.4167F);
		ModelBrigg.addChild(chest_3);
		setRotationAngle(chest_3, 0.0F, -1.5708F, 0.0F);


		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(6.1667F, 18.9167F, -40.5833F);
		chest_3.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, -1.5708F, 0.0F);
		cube_r21.texOffs(30, 55).addBox(33.0F, -19.0F, 5.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r21.texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r21.texOffs(30, 55).addBox(34.0F, -19.0F, -1.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(-2.8333F, 0.9167F, 0.4167F);
		chest_3.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 1.5708F, 0.0F);
		cube_r22.texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(3.1667F, -1.5833F, 1.4167F);
		chest_3.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 1.5708F, 0.0F);
		cube_r23.texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		chest_4 = new ModelRenderer(this);
		chest_4.setPos(7.8333F, -18.9167F, -31.4167F);
		ModelBrigg.addChild(chest_4);
		setRotationAngle(chest_4, 0.0F, 1.5708F, 0.0F);


		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(6.1667F, 18.9167F, -40.5833F);
		chest_4.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, -1.5708F, 0.0F);
		cube_r24.texOffs(30, 55).addBox(33.0F, -19.0F, 8.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r24.texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r24.texOffs(30, 55).addBox(34.0F, -19.0F, 2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(-2.8333F, 0.9167F, 0.4167F);
		chest_4.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 1.5708F, 0.0F);
		cube_r25.texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(3.1667F, -1.5833F, 1.4167F);
		chest_4.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 1.5708F, 0.0F);
		cube_r26.texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		BannerStick = new ModelRenderer(this);
		BannerStick.setPos(0.0F, 0.0F, 0.0F);
		ModelBrigg.addChild(BannerStick);


		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(0.0F, 0.0F, 0.0F);
		BannerStick.addChild(cube_r27);
		setRotationAngle(cube_r27, -1.5708F, -1.5708F, 0.0F);
		cube_r27.texOffs(6, 0).addBox(26.0F, -3.5F, -137.0F, 1.0F, 1.0F, 15.0F, 0.0F, false);

		steer = new ModelRenderer(this);
		steer.setPos(-3.0F, -1.8071F, 48.6533F);
		ModelBrigg.addChild(steer);


		steer_r1 = new ModelRenderer(this);
		steer_r1.setPos(0.0F, 0.0F, 0.0F);
		steer.addChild(steer_r1);
		setRotationAngle(steer_r1, 0.0F, 0.1222F, 1.5708F);
		steer_r1.texOffs(0, 0).addBox(-9.0F, -0.5F, 0.5F, 18.0F, 1.0F, 9.0F, 0.0F, false);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void setupAnim(BriggEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.chest_1.visible = (entityIn).getCargo() >= 1;
		this.chest_2.visible = (entityIn).getCargo() >= 2;
		this.chest_3.visible = (entityIn).getCargo() >= 3;
		this.chest_4.visible = (entityIn).getCargo() >= 4;


		this.steer.yRot = -entityIn.getRotSpeed();

		this.BannerStick.visible = entityIn.getHasBanner();
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ModelBrigg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}