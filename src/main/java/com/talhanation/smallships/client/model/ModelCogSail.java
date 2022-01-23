package com.talhanation.smallships.client.model;// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelCogSail extends EntityModel<CogEntity> {
	private final ModelRenderer Segel_0;
	private final ModelRenderer segel_1_3;
	private final ModelRenderer segel_1_0;
	private final ModelRenderer segel_1_4;
	private final ModelRenderer rope_4;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer rope_5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer sail_end;
	private final ModelRenderer cube_r11;
	private final ModelRenderer sail_ropes;
	private final ModelRenderer rope_1;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer rope_3;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer Segel_1;
	private final ModelRenderer sail_ropes2;
	private final ModelRenderer rope_2;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer rope_6;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer segel_1_2;
	private final ModelRenderer segel_1_1;
	private final ModelRenderer segel_1_5;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer rope_7;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer rope_8;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer sail_end2;
	private final ModelRenderer cube_r36;
	private final ModelRenderer Segel_2;
	private final ModelRenderer sail_ropes3;
	private final ModelRenderer rope_9;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer rope_10;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer segel_1_6;
	private final ModelRenderer segel_1_7;
	private final ModelRenderer segel_1_8;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer rope_11;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer rope_12;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer sail_end3;
	private final ModelRenderer cube_r57;
	private final ModelRenderer Segel_3;
	private final ModelRenderer sail_ropes5;
	private final ModelRenderer rope_17;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer rope_18;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer segel_1_9;
	private final ModelRenderer segel_1_10;
	private final ModelRenderer segel_1_11;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer rope_19;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer rope_20;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer sail_end4;
	private final ModelRenderer cube_r80;
	private final ModelRenderer Segel_4;
	private final ModelRenderer sail_ropes4;
	private final ModelRenderer rope_13;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer rope_14;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer cog_segel_1_4;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer cube_r89;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer rope_15;
	private final ModelRenderer cube_r96;
	private final ModelRenderer cube_r97;
	private final ModelRenderer cube_r98;
	private final ModelRenderer rope_16;
	private final ModelRenderer cube_r99;
	private final ModelRenderer cube_r100;
	private final ModelRenderer cube_r101;

	public ModelCogSail() {
		texWidth = 128;
		texHeight = 64;

		Segel_0 = new ModelRenderer(this);
		Segel_0.setPos(0.0F, 24.0F, 0.0F);
		

		segel_1_3 = new ModelRenderer(this);
		segel_1_3.setPos(29.0F, 13.0F, -6.0F);
		Segel_0.addChild(segel_1_3);
		setRotationAngle(segel_1_3, 0.0F, 1.5708F, 0.0F);
		

		segel_1_0 = new ModelRenderer(this);
		segel_1_0.setPos(-8.0F, 0.0F, 0.0F);
		segel_1_3.addChild(segel_1_0);
		

		segel_1_4 = new ModelRenderer(this);
		segel_1_4.setPos(-26.5F, -24.0F, -21.5F);
		segel_1_3.addChild(segel_1_4);
		

		rope_4 = new ModelRenderer(this);
		rope_4.setPos(38.0F, 0.0F, 18.0F);
		segel_1_4.addChild(rope_4);
		setRotationAngle(rope_4, 1.4884F, 1.2464F, 1.6894F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 10.5F, 17.0F);
		rope_4.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
		cube_r1.texOffs(98, 12).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, -33.5F, 0.0F);
		rope_4.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -2.3562F);
		cube_r2.texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, -21.5F, 0.0F);
		rope_4.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -2.3562F);
		cube_r3.texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.5F, 17.0F);
		rope_4.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -1.5708F);
		cube_r4.texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r4.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, 21.5F, 17.0F);
		rope_4.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.5708F);
		cube_r5.texOffs(96, 0).addBox(27.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		rope_5 = new ModelRenderer(this);
		rope_5.setPos(3.0F, 0.5F, 19.0F);
		segel_1_4.addChild(rope_5);
		setRotationAngle(rope_5, 1.1491F, -1.1947F, -1.3336F);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.0F, 9.5F, 19.0F);
		rope_5.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -1.5708F);
		cube_r6.texOffs(96, 0).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r6.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r6.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-0.5F, -35.5F, 2.0F);
		rope_5.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -2.3562F);
		cube_r7.texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(-0.5F, -23.5F, 2.0F);
		rope_5.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -2.3562F);
		cube_r8.texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(-0.5F, -1.5F, 19.0F);
		rope_5.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
		cube_r9.texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r9.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 21.5F, 17.0F);
		rope_5.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -1.5708F);
		cube_r10.texOffs(96, 0).addBox(27.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r10.texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		sail_end = new ModelRenderer(this);
		sail_end.setPos(22.1F, -54.7898F, -1.4374F);
		segel_1_4.addChild(sail_end);
		setRotationAngle(sail_end, 0.6545F, 0.0F, 0.0F);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 0.25F, 0.0F);
		sail_end.addChild(cube_r11);
		setRotationAngle(cube_r11, -2.2166F, 0.0F, 0.0F);
		cube_r11.texOffs(90, 2).addBox(-6.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r11.texOffs(90, 2).addBox(-19.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r11.texOffs(90, 2).addBox(-32.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r11.texOffs(90, 3).addBox(6.9F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r11.texOffs(98, 0).addBox(19.9F, -3.25F, -3.0F, 9.0F, 6.0F, 6.0F, 0.0F, false);

		sail_ropes = new ModelRenderer(this);
		sail_ropes.setPos(43.5F, -16.0F, 0.0F);
		Segel_0.addChild(sail_ropes);
		

		rope_1 = new ModelRenderer(this);
		rope_1.setPos(0.0F, 0.0F, 0.0F);
		sail_ropes.addChild(rope_1);
		setRotationAngle(rope_1, 0.0F, -1.5708F, -0.5236F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 11.5F, 17.0F);
		rope_1.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -1.5708F);
		cube_r12.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r12.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, -22.5F, 0.0F);
		rope_1.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -2.3562F);
		cube_r13.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, -10.5F, 0.0F);
		rope_1.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -2.3562F);
		cube_r14.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_3 = new ModelRenderer(this);
		rope_3.setPos(-84.0F, -5.0F, 0.0F);
		sail_ropes.addChild(rope_3);
		setRotationAngle(rope_3, 0.733F, -1.5708F, 0.0F);
		

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(0.0F, 11.5F, 17.0F);
		rope_3.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -1.5708F);
		cube_r15.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r15.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(0.0F, -22.5F, 0.0F);
		rope_3.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -2.3562F);
		cube_r16.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(0.0F, -10.5F, 0.0F);
		rope_3.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -2.3562F);
		cube_r17.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		Segel_1 = new ModelRenderer(this);
		Segel_1.setPos(0.0F, 24.0F, 0.0F);
		

		sail_ropes2 = new ModelRenderer(this);
		sail_ropes2.setPos(43.5F, -16.0F, 0.0F);
		Segel_1.addChild(sail_ropes2);
		

		rope_2 = new ModelRenderer(this);
		rope_2.setPos(0.0F, 0.0F, 0.0F);
		sail_ropes2.addChild(rope_2);
		setRotationAngle(rope_2, 0.0F, -1.5708F, -0.5236F);
		

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(0.0F, 11.5F, 17.0F);
		rope_2.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -1.5708F);
		cube_r18.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r18.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r18.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r18.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r18.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r18.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(0.0F, -22.5F, 0.0F);
		rope_2.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -2.3562F);
		cube_r19.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(0.0F, -10.5F, 0.0F);
		rope_2.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, -2.3562F);
		cube_r20.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_6 = new ModelRenderer(this);
		rope_6.setPos(-84.0F, -5.0F, 0.0F);
		sail_ropes2.addChild(rope_6);
		setRotationAngle(rope_6, 0.733F, -1.5708F, 0.0F);
		

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(0.0F, 11.5F, 17.0F);
		rope_6.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -1.5708F);
		cube_r21.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r21.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(0.0F, -22.5F, 0.0F);
		rope_6.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -2.3562F);
		cube_r22.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(0.0F, -10.5F, 0.0F);
		rope_6.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -2.3562F);
		cube_r23.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_1_2 = new ModelRenderer(this);
		segel_1_2.setPos(29.0F, 13.0F, -6.0F);
		Segel_1.addChild(segel_1_2);
		setRotationAngle(segel_1_2, 0.0F, 1.5708F, 0.0F);
		

		segel_1_1 = new ModelRenderer(this);
		segel_1_1.setPos(-8.0F, 0.0F, 0.0F);
		segel_1_2.addChild(segel_1_1);
		

		segel_1_5 = new ModelRenderer(this);
		segel_1_5.setPos(-26.5F, -24.0F, -21.5F);
		segel_1_2.addChild(segel_1_5);
		

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(53.0F, -55.4356F, -0.4095F);
		segel_1_5.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.6545F, 0.0F, 0.0F);
		cube_r24.texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r24.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r24.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r24.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r24.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(53.0F, -52.4943F, 39.4993F);
		segel_1_5.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.829F, 0.0F, 0.0F);
		cube_r25.texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r25.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r25.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r25.texOffs(96, 6).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r25.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_7 = new ModelRenderer(this);
		rope_7.setPos(38.0F, 0.0F, 18.0F);
		segel_1_5.addChild(rope_7);
		setRotationAngle(rope_7, 1.4794F, 1.1163F, 1.7268F);
		

		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(0.0F, 14.5F, 17.0F);
		rope_7.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, -1.5708F);
		cube_r26.texOffs(98, 8).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r26.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r26.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(0.0F, -29.5F, 0.0F);
		rope_7.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -2.3562F);
		cube_r27.texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(0.0F, -17.5F, 0.0F);
		rope_7.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, -2.3562F);
		cube_r28.texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(0.0F, 4.5F, 17.0F);
		rope_7.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -1.5708F);
		cube_r29.texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(0.0F, 21.5F, 17.0F);
		rope_7.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -1.5708F);
		cube_r30.texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		rope_8 = new ModelRenderer(this);
		rope_8.setPos(3.0F, 0.5F, 19.0F);
		segel_1_5.addChild(rope_8);
		setRotationAngle(rope_8, 1.2348F, -1.0973F, -1.4276F);
		

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(0.0F, 13.5F, 19.0F);
		rope_8.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -1.5708F);
		cube_r31.texOffs(98, 6).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r31.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r31.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(-0.5F, -31.5F, 2.0F);
		rope_8.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -2.3562F);
		cube_r32.texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(-0.5F, -19.5F, 2.0F);
		rope_8.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -2.3562F);
		cube_r33.texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-0.5F, 2.5F, 19.0F);
		rope_8.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, -1.5708F);
		cube_r34.texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r34.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(0.0F, 21.5F, 17.0F);
		rope_8.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -1.5708F);
		cube_r35.texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		sail_end2 = new ModelRenderer(this);
		sail_end2.setPos(-2.5F, -41.0F, -1.5F);
		segel_1_5.addChild(sail_end2);
		setRotationAngle(sail_end2, 1.0472F, 0.0F, 0.0F);
		

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(24.6F, -7.5398F, 5.0626F);
		sail_end2.addChild(cube_r36);
		setRotationAngle(cube_r36, -2.2166F, 0.0F, 0.0F);
		cube_r36.texOffs(92, 6).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r36.texOffs(92, 4).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r36.texOffs(92, 4).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r36.texOffs(92, 3).addBox(6.9F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r36.texOffs(100, 4).addBox(19.9F, -2.25F, -2.0F, 9.0F, 5.0F, 5.0F, 0.0F, false);

		Segel_2 = new ModelRenderer(this);
		Segel_2.setPos(0.0F, 24.0F, 0.0F);
		

		sail_ropes3 = new ModelRenderer(this);
		sail_ropes3.setPos(43.5F, -16.0F, 0.0F);
		Segel_2.addChild(sail_ropes3);
		

		rope_9 = new ModelRenderer(this);
		rope_9.setPos(0.0F, 0.0F, 0.0F);
		sail_ropes3.addChild(rope_9);
		setRotationAngle(rope_9, 0.0F, -1.5708F, -0.5236F);
		

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(0.0F, 11.5F, 17.0F);
		rope_9.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -1.5708F);
		cube_r37.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r37.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(0.0F, -22.5F, 0.0F);
		rope_9.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -2.3562F);
		cube_r38.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(0.0F, -10.5F, 0.0F);
		rope_9.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -2.3562F);
		cube_r39.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_10 = new ModelRenderer(this);
		rope_10.setPos(-84.0F, -5.0F, 0.0F);
		sail_ropes3.addChild(rope_10);
		setRotationAngle(rope_10, 0.733F, -1.5708F, 0.0F);
		

		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(0.0F, 11.5F, 17.0F);
		rope_10.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -1.5708F);
		cube_r40.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r40.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(0.0F, -22.5F, 0.0F);
		rope_10.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -2.3562F);
		cube_r41.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(0.0F, -10.5F, 0.0F);
		rope_10.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -2.3562F);
		cube_r42.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_1_6 = new ModelRenderer(this);
		segel_1_6.setPos(29.0F, 13.0F, -6.0F);
		Segel_2.addChild(segel_1_6);
		setRotationAngle(segel_1_6, 0.0F, 1.5708F, 0.0F);
		

		segel_1_7 = new ModelRenderer(this);
		segel_1_7.setPos(-8.0F, 0.0F, 0.0F);
		segel_1_6.addChild(segel_1_7);
		

		segel_1_8 = new ModelRenderer(this);
		segel_1_8.setPos(-26.5F, -24.0F, -21.5F);
		segel_1_6.addChild(segel_1_8);
		

		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(53.0F, -44.7113F, 34.1289F);
		segel_1_8.addChild(cube_r43);
		setRotationAngle(cube_r43, 1.2217F, 0.0F, 0.0F);
		cube_r43.texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r43.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r43.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r43.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r43.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(53.0F, -47.7441F, 35.6572F);
		segel_1_8.addChild(cube_r44);
		setRotationAngle(cube_r44, 1.0908F, 0.0F, 0.0F);
		cube_r44.texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r44.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r44.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r44.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r44.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(53.0F, -55.4356F, -0.4095F);
		segel_1_8.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.6545F, 0.0F, 0.0F);
		cube_r45.texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r45.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r45.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r45.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r45.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(53.0F, -52.4943F, 39.4993F);
		segel_1_8.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.829F, 0.0F, 0.0F);
		cube_r46.texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r46.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r46.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r46.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r46.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_11 = new ModelRenderer(this);
		rope_11.setPos(38.0F, 0.0F, 18.0F);
		segel_1_8.addChild(rope_11);
		setRotationAngle(rope_11, 1.5001F, 0.9684F, 1.7506F);
		

		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(0.0F, 16.5F, 17.0F);
		rope_11.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -1.5708F);
		cube_r47.texOffs(98, 9).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setPos(0.0F, -27.5F, 0.0F);
		rope_11.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, -2.3562F);
		cube_r48.texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setPos(0.0F, -15.5F, 0.0F);
		rope_11.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, -2.3562F);
		cube_r49.texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setPos(0.0F, 6.5F, 17.0F);
		rope_11.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, -1.5708F);
		cube_r50.texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r50.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setPos(0.0F, 21.5F, 17.0F);
		rope_11.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, -1.5708F);
		cube_r51.texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rope_12 = new ModelRenderer(this);
		rope_12.setPos(3.0F, 0.5F, 19.0F);
		segel_1_8.addChild(rope_12);
		setRotationAngle(rope_12, 1.3165F, -0.9301F, -1.5235F);
		

		cube_r52 = new ModelRenderer(this);
		cube_r52.setPos(0.0F, 15.5F, 19.0F);
		rope_12.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, -1.5708F);
		cube_r52.texOffs(98, 4).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r52.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r52.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setPos(-0.5F, -29.5F, 2.0F);
		rope_12.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.0F, -2.3562F);
		cube_r53.texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setPos(-0.5F, -17.5F, 2.0F);
		rope_12.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, 0.0F, -2.3562F);
		cube_r54.texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setPos(-0.5F, 4.5F, 19.0F);
		rope_12.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.0F, -1.5708F);
		cube_r55.texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r55.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setPos(0.0F, 21.5F, 17.0F);
		rope_12.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.0F, -1.5708F);
		cube_r56.texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		sail_end3 = new ModelRenderer(this);
		sail_end3.setPos(-2.5F, -31.0F, -9.0F);
		segel_1_8.addChild(sail_end3);
		setRotationAngle(sail_end3, 0.7854F, 0.0F, 0.0F);
		

		cube_r57 = new ModelRenderer(this);
		cube_r57.setPos(24.6F, -7.5398F, 5.0626F);
		sail_end3.addChild(cube_r57);
		setRotationAngle(cube_r57, -2.2166F, 0.0F, 0.0F);
		cube_r57.texOffs(96, 1).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r57.texOffs(96, 3).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r57.texOffs(96, 6).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r57.texOffs(94, 4).addBox(6.9F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r57.texOffs(96, 3).addBox(19.9F, -2.25F, -2.0F, 9.0F, 4.0F, 4.0F, 0.0F, false);

		Segel_3 = new ModelRenderer(this);
		Segel_3.setPos(0.0F, 24.0F, 0.0F);
		

		sail_ropes5 = new ModelRenderer(this);
		sail_ropes5.setPos(43.5F, -16.0F, 0.0F);
		Segel_3.addChild(sail_ropes5);
		

		rope_17 = new ModelRenderer(this);
		rope_17.setPos(0.0F, 0.0F, 0.0F);
		sail_ropes5.addChild(rope_17);
		setRotationAngle(rope_17, 0.0F, -1.5708F, -0.5236F);
		

		cube_r58 = new ModelRenderer(this);
		cube_r58.setPos(0.0F, 11.5F, 17.0F);
		rope_17.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, -1.5708F);
		cube_r58.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r58.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setPos(0.0F, -22.5F, 0.0F);
		rope_17.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, 0.0F, -2.3562F);
		cube_r59.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setPos(0.0F, -10.5F, 0.0F);
		rope_17.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, -2.3562F);
		cube_r60.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_18 = new ModelRenderer(this);
		rope_18.setPos(-84.0F, -5.0F, 0.0F);
		sail_ropes5.addChild(rope_18);
		setRotationAngle(rope_18, 0.733F, -1.5708F, 0.0F);
		

		cube_r61 = new ModelRenderer(this);
		cube_r61.setPos(0.0F, 11.5F, 17.0F);
		rope_18.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, -1.5708F);
		cube_r61.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r61.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setPos(0.0F, -22.5F, 0.0F);
		rope_18.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, 0.0F, -2.3562F);
		cube_r62.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setPos(0.0F, -10.5F, 0.0F);
		rope_18.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0F, 0.0F, -2.3562F);
		cube_r63.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_1_9 = new ModelRenderer(this);
		segel_1_9.setPos(29.0F, 13.0F, -6.0F);
		Segel_3.addChild(segel_1_9);
		setRotationAngle(segel_1_9, 0.0F, 1.5708F, 0.0F);
		

		segel_1_10 = new ModelRenderer(this);
		segel_1_10.setPos(-8.0F, 0.0F, 0.0F);
		segel_1_9.addChild(segel_1_10);
		

		segel_1_11 = new ModelRenderer(this);
		segel_1_11.setPos(-26.5F, -24.0F, -21.5F);
		segel_1_9.addChild(segel_1_11);
		

		cube_r64 = new ModelRenderer(this);
		cube_r64.setPos(53.0F, -34.7644F, 33.9338F);
		segel_1_11.addChild(cube_r64);
		setRotationAngle(cube_r64, 1.7453F, 0.0F, 0.0F);
		cube_r64.texOffs(96, 3).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r64.texOffs(96, 4).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r64.texOffs(96, 4).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r64.texOffs(96, 5).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r64.texOffs(96, 5).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setPos(53.0F, -39.6813F, 33.5822F);
		segel_1_11.addChild(cube_r65);
		setRotationAngle(cube_r65, 1.5272F, 0.0F, 0.0F);
		cube_r65.texOffs(96, 4).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r65.texOffs(96, 3).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r65.texOffs(96, 6).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r65.texOffs(96, 3).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r65.texOffs(96, 0).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setPos(53.0F, -44.7113F, 34.1289F);
		segel_1_11.addChild(cube_r66);
		setRotationAngle(cube_r66, 1.2217F, 0.0F, 0.0F);
		cube_r66.texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r66.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r66.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r66.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r66.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setPos(53.0F, -47.7441F, 35.6572F);
		segel_1_11.addChild(cube_r67);
		setRotationAngle(cube_r67, 1.0908F, 0.0F, 0.0F);
		cube_r67.texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r67.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r67.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r67.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r67.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setPos(53.0F, -55.4356F, -0.4095F);
		segel_1_11.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.6545F, 0.0F, 0.0F);
		cube_r68.texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r68.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r68.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r68.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r68.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setPos(53.0F, -52.4943F, 39.4993F);
		segel_1_11.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.829F, 0.0F, 0.0F);
		cube_r69.texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r69.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r69.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r69.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r69.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_19 = new ModelRenderer(this);
		rope_19.setPos(38.0F, 0.0F, 18.0F);
		segel_1_11.addChild(rope_19);
		setRotationAngle(rope_19, 1.5097F, 0.8552F, 1.7628F);
		

		cube_r70 = new ModelRenderer(this);
		cube_r70.setPos(0.0F, 16.5F, 17.0F);
		rope_19.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0F, 0.0F, -1.5708F);
		cube_r70.texOffs(98, 12).addBox(44.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r70.texOffs(96, 0).addBox(20.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r70.texOffs(96, 0).addBox(25.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setPos(0.0F, -27.5F, 0.0F);
		rope_19.addChild(cube_r71);
		setRotationAngle(cube_r71, 0.0F, 0.0F, -2.3562F);
		cube_r71.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setPos(0.0F, -15.5F, 0.0F);
		rope_19.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.0F, 0.0F, -2.3562F);
		cube_r72.texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setPos(0.0F, 6.5F, 17.0F);
		rope_19.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.0F, 0.0F, -1.5708F);
		cube_r73.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r73.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setPos(0.0F, 21.5F, 17.0F);
		rope_19.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.0F, 0.0F, -1.5708F);
		cube_r74.texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		rope_20 = new ModelRenderer(this);
		rope_20.setPos(3.0F, 0.5F, 19.0F);
		segel_1_11.addChild(rope_20);
		setRotationAngle(rope_20, 1.3422F, -0.8454F, -1.5566F);
		

		cube_r75 = new ModelRenderer(this);
		cube_r75.setPos(0.0F, 15.5F, 17.0F);
		rope_20.addChild(cube_r75);
		setRotationAngle(cube_r75, 0.0F, 0.0F, -1.5708F);
		cube_r75.texOffs(96, 0).addBox(45.5F, -1.0F, -17.5F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(96, 0).addBox(19.5F, -1.0F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(96, 0).addBox(25.5F, -1.0F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setPos(-0.5F, -29.5F, 0.0F);
		rope_20.addChild(cube_r76);
		setRotationAngle(cube_r76, 0.0F, 0.0F, -2.3562F);
		cube_r76.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setPos(-0.5F, -17.5F, 0.0F);
		rope_20.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.0F, 0.0F, -2.3562F);
		cube_r77.texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setPos(-0.5F, 4.5F, 17.0F);
		rope_20.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.0F, 0.0F, -1.5708F);
		cube_r78.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r78.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setPos(0.0F, 21.5F, 17.0F);
		rope_20.addChild(cube_r79);
		setRotationAngle(cube_r79, 0.0F, 0.0F, -1.5708F);
		cube_r79.texOffs(96, 0).addBox(21.5F, -1.0F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		sail_end4 = new ModelRenderer(this);
		sail_end4.setPos(-2.5F, -31.0F, -9.0F);
		segel_1_11.addChild(sail_end4);
		setRotationAngle(sail_end4, 0.7854F, 0.0F, 0.0F);
		

		cube_r80 = new ModelRenderer(this);
		cube_r80.setPos(55.5F, -1.8067F, 44.7895F);
		sail_end4.addChild(cube_r80);
		setRotationAngle(cube_r80, 2.0595F, 0.0F, 0.0F);
		cube_r80.texOffs(96, 1).addBox(-37.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(96, 3).addBox(-50.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(96, 6).addBox(-63.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(96, 9).addBox(-24.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(96, 3).addBox(-11.0F, -41.6933F, 18.2105F, 9.0F, 3.0F, 3.0F, 0.0F, false);

		Segel_4 = new ModelRenderer(this);
		Segel_4.setPos(0.0F, 24.0F, 0.0F);
		

		sail_ropes4 = new ModelRenderer(this);
		sail_ropes4.setPos(43.5F, -16.0F, 0.0F);
		Segel_4.addChild(sail_ropes4);
		

		rope_13 = new ModelRenderer(this);
		rope_13.setPos(0.0F, 0.0F, 0.0F);
		sail_ropes4.addChild(rope_13);
		setRotationAngle(rope_13, 0.0F, -1.5708F, -0.5236F);
		

		cube_r81 = new ModelRenderer(this);
		cube_r81.setPos(0.0F, 11.5F, 17.0F);
		rope_13.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.0F, -1.5708F);
		cube_r81.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setPos(0.0F, -22.5F, 0.0F);
		rope_13.addChild(cube_r82);
		setRotationAngle(cube_r82, 0.0F, 0.0F, -2.3562F);
		cube_r82.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setPos(0.0F, -10.5F, 0.0F);
		rope_13.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.0F, -2.3562F);
		cube_r83.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_14 = new ModelRenderer(this);
		rope_14.setPos(-84.0F, -5.0F, 0.0F);
		sail_ropes4.addChild(rope_14);
		setRotationAngle(rope_14, 0.733F, -1.5708F, 0.0F);
		

		cube_r84 = new ModelRenderer(this);
		cube_r84.setPos(0.0F, 11.5F, 17.0F);
		rope_14.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.0F, -1.5708F);
		cube_r84.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setPos(0.0F, -22.5F, 0.0F);
		rope_14.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, 0.0F, -2.3562F);
		cube_r85.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setPos(0.0F, -10.5F, 0.0F);
		rope_14.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, 0.0F, -2.3562F);
		cube_r86.texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cog_segel_1_4 = new ModelRenderer(this);
		cog_segel_1_4.setPos(8.5F, -11.0F, 20.5F);
		Segel_4.addChild(cog_segel_1_4);
		setRotationAngle(cog_segel_1_4, 0.0F, 1.5708F, 0.0F);
		

		cube_r87 = new ModelRenderer(this);
		cube_r87.setPos(53.0F, -26.3067F, 36.3895F);
		cog_segel_1_4.addChild(cube_r87);
		setRotationAngle(cube_r87, 2.0595F, 0.0F, 0.0F);
		cube_r87.texOffs(96, 6).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r87.texOffs(96, 3).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r87.texOffs(96, 1).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r87.texOffs(96, 9).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r87.texOffs(96, 3).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setPos(53.0F, -28.4794F, 33.5112F);
		cog_segel_1_4.addChild(cube_r88);
		setRotationAngle(cube_r88, 1.8762F, 0.0F, 0.0F);
		cube_r88.texOffs(96, 5).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r88.texOffs(96, 4).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r88.texOffs(96, 6).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r88.texOffs(96, 1).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r88.texOffs(96, 4).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setPos(53.0F, -34.7644F, 33.9338F);
		cog_segel_1_4.addChild(cube_r89);
		setRotationAngle(cube_r89, 1.7453F, 0.0F, 0.0F);
		cube_r89.texOffs(96, 3).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r89.texOffs(96, 4).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r89.texOffs(96, 4).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r89.texOffs(96, 5).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r89.texOffs(96, 5).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r90 = new ModelRenderer(this);
		cube_r90.setPos(53.0F, -39.6813F, 33.5822F);
		cog_segel_1_4.addChild(cube_r90);
		setRotationAngle(cube_r90, 1.5272F, 0.0F, 0.0F);
		cube_r90.texOffs(96, 4).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r90.texOffs(96, 3).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r90.texOffs(96, 6).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r90.texOffs(96, 3).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r90.texOffs(96, 0).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setPos(53.0F, -44.7113F, 34.1289F);
		cog_segel_1_4.addChild(cube_r91);
		setRotationAngle(cube_r91, 1.2217F, 0.0F, 0.0F);
		cube_r91.texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r91.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r91.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r91.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r91.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setPos(53.0F, -47.7441F, 35.6572F);
		cog_segel_1_4.addChild(cube_r92);
		setRotationAngle(cube_r92, 1.0908F, 0.0F, 0.0F);
		cube_r92.texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r92.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r92.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r92.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r92.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r93 = new ModelRenderer(this);
		cube_r93.setPos(53.0F, -55.4356F, -0.4095F);
		cog_segel_1_4.addChild(cube_r93);
		setRotationAngle(cube_r93, 0.6545F, 0.0F, 0.0F);
		cube_r93.texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r93.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r93.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r93.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r93.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setPos(53.0F, -52.4943F, 39.4993F);
		cog_segel_1_4.addChild(cube_r94);
		setRotationAngle(cube_r94, 0.829F, 0.0F, 0.0F);
		cube_r94.texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r94.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r94.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r94.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r94.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setPos(53.0F, -20.7281F, 39.2678F);
		cog_segel_1_4.addChild(cube_r95);
		setRotationAngle(cube_r95, 2.2227F, 0.0F, 0.0F);
		cube_r95.texOffs(96, 2).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r95.texOffs(96, 5).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r95.texOffs(96, 4).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r95.texOffs(96, 3).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r95.texOffs(96, 3).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_15 = new ModelRenderer(this);
		rope_15.setPos(38.0F, 0.0F, 18.0F);
		cog_segel_1_4.addChild(rope_15);
		setRotationAngle(rope_15, 1.3963F, 0.7941F, 1.7628F);
		

		cube_r96 = new ModelRenderer(this);
		cube_r96.setPos(0.0F, 21.5F, 17.0F);
		rope_15.addChild(cube_r96);
		setRotationAngle(cube_r96, 0.0F, 0.0F, -1.5708F);
		cube_r96.texOffs(96, 0).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r97 = new ModelRenderer(this);
		cube_r97.setPos(0.0F, -12.5F, 0.0F);
		rope_15.addChild(cube_r97);
		setRotationAngle(cube_r97, 0.0F, 0.0F, -2.3562F);
		cube_r97.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r98 = new ModelRenderer(this);
		cube_r98.setPos(0.0F, -0.5F, 0.0F);
		rope_15.addChild(cube_r98);
		setRotationAngle(cube_r98, 0.0F, 0.0F, -2.3562F);
		cube_r98.texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_16 = new ModelRenderer(this);
		rope_16.setPos(3.0F, 0.5F, 19.0F);
		cog_segel_1_4.addChild(rope_16);
		setRotationAngle(rope_16, 1.2654F, -0.7592F, -1.5708F);
		

		cube_r99 = new ModelRenderer(this);
		cube_r99.setPos(0.0F, 21.5F, 17.0F);
		rope_16.addChild(cube_r99);
		setRotationAngle(cube_r99, 0.0F, 0.0F, -1.5708F);
		cube_r99.texOffs(96, 0).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r100 = new ModelRenderer(this);
		cube_r100.setPos(0.0F, -12.5F, 0.0F);
		rope_16.addChild(cube_r100);
		setRotationAngle(cube_r100, 0.0F, 0.0F, -2.3562F);
		cube_r100.texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r101 = new ModelRenderer(this);
		cube_r101.setPos(0.0F, -0.5F, 0.0F);
		rope_16.addChild(cube_r101);
		setRotationAngle(cube_r101, 0.0F, 0.0F, -2.3562F);
		cube_r101.texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(CogEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int state = entityIn.getSailState();
		switch (state){
			case 0:

				this.Segel_0.visible= true;
				this.Segel_1.visible= false;
				this.Segel_2.visible= false;
				this.Segel_3.visible= false;
				this.Segel_4.visible= false;
				break;

			case 1:
				this.Segel_0.visible= false;
				this.Segel_1.visible= true;
				this.Segel_2.visible= false;
				this.Segel_3.visible= false;
				this.Segel_4.visible= false;
				break;

			case 2:
				this.Segel_0.visible= false;
				this.Segel_1.visible= false;
				this.Segel_2.visible= true;
				this.Segel_3.visible= false;
				this.Segel_4.visible= false;
				break;

			case 3:
				this.Segel_0.visible= false;
				this.Segel_1.visible= false;
				this.Segel_2.visible= false;
				this.Segel_3.visible= true;
				this.Segel_4.visible= false;
				break;

			case 4:
				this.Segel_0.visible= false;
				this.Segel_1.visible= false;
				this.Segel_2.visible= false;
				this.Segel_3.visible= false;
				this.Segel_4.visible= true;
				break;
		}
	}


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Segel_0.render(matrixStack, buffer, packedLight, packedOverlay);
		Segel_1.render(matrixStack, buffer, packedLight, packedOverlay);
		Segel_2.render(matrixStack, buffer, packedLight, packedOverlay);
		Segel_3.render(matrixStack, buffer, packedLight, packedOverlay);
		Segel_4.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}