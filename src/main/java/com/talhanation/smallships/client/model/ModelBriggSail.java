package com.talhanation.smallships.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.talhanation.smallships.entities.AbstractSailShip;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelBriggSail extends ModelSail{
	private final ModelRenderer segel_brigg;
	private final ModelRenderer Sail_4;
	private final ModelRenderer rope_11;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer rope_10;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer rope_12;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer rope_6;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer rope_4;
	private final ModelRenderer cube_r99;
	private final ModelRenderer cube_r100;
	private final ModelRenderer cube_r101;
	private final ModelRenderer rope_9;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer rope_8;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer rope_5;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer rope_3;
	private final ModelRenderer cube_r96;
	private final ModelRenderer cube_r97;
	private final ModelRenderer cube_r98;
	private final ModelRenderer rope_2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r151;
	private final ModelRenderer cube_r152;
	private final ModelRenderer segel_6;
	private final ModelRenderer cube_r153;
	private final ModelRenderer segel_5;
	private final ModelRenderer rope_7;
	private final ModelRenderer cube_r154;
	private final ModelRenderer segel_4;
	private final ModelRenderer cube_r155;
	private final ModelRenderer cube_r156;
	private final ModelRenderer cube_r157;
	private final ModelRenderer cube_r158;
	private final ModelRenderer cube_r159;
	private final ModelRenderer cube_r160;
	private final ModelRenderer cube_r161;
	private final ModelRenderer cube_r162;
	private final ModelRenderer cube_r163;
	private final ModelRenderer cube_r164;
	private final ModelRenderer segel_3;
	private final ModelRenderer cube_r165;
	private final ModelRenderer cube_r166;
	private final ModelRenderer cube_r167;
	private final ModelRenderer cube_r168;
	private final ModelRenderer cube_r169;
	private final ModelRenderer cube_r170;
	private final ModelRenderer cube_r171;
	private final ModelRenderer cube_r172;
	private final ModelRenderer cube_r173;
	private final ModelRenderer cube_r174;
	private final ModelRenderer segel_2;
	private final ModelRenderer cube_r175;
	private final ModelRenderer cube_r176;
	private final ModelRenderer cube_r177;
	private final ModelRenderer cube_r178;
	private final ModelRenderer cube_r179;
	private final ModelRenderer cube_r180;
	private final ModelRenderer cube_r181;
	private final ModelRenderer segel_1;
	private final ModelRenderer cube_r182;
	private final ModelRenderer cube_r183;
	private final ModelRenderer cube_r184;
	private final ModelRenderer cube_r185;
	private final ModelRenderer cube_r186;
	private final ModelRenderer cube_r187;
	private final ModelRenderer cube_r188;
	private final ModelRenderer rope_13;
	private final ModelRenderer cube_r189;
	private final ModelRenderer Sail_3;
	private final ModelRenderer rope_14;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer rope_15;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer rope_16;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer rope_17;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer rope_18;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer rope_19;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer rope_20;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer rope_21;
	private final ModelRenderer cube_r44;
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer rope_22;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer rope_23;
	private final ModelRenderer cube_r190;
	private final ModelRenderer cube_r191;
	private final ModelRenderer cube_r192;
	private final ModelRenderer segel_7;
	private final ModelRenderer cube_r193;
	private final ModelRenderer segel_8;
	private final ModelRenderer rope_24;
	private final ModelRenderer cube_r194;
	private final ModelRenderer segel_9;
	private final ModelRenderer cube_r195;
	private final ModelRenderer cube_r196;
	private final ModelRenderer cube_r197;
	private final ModelRenderer cube_r198;
	private final ModelRenderer cube_r199;
	private final ModelRenderer cube_r200;
	private final ModelRenderer cube_r201;
	private final ModelRenderer cube_r202;
	private final ModelRenderer segel_10;
	private final ModelRenderer cube_r203;
	private final ModelRenderer cube_r204;
	private final ModelRenderer cube_r205;
	private final ModelRenderer cube_r206;
	private final ModelRenderer cube_r207;
	private final ModelRenderer cube_r208;
	private final ModelRenderer cube_r209;
	private final ModelRenderer cube_r210;
	private final ModelRenderer segel_11;
	private final ModelRenderer cube_r211;
	private final ModelRenderer cube_r212;
	private final ModelRenderer cube_r213;
	private final ModelRenderer cube_r214;
	private final ModelRenderer cube_r215;
	private final ModelRenderer cube_r216;
	private final ModelRenderer segel_12;
	private final ModelRenderer cube_r217;
	private final ModelRenderer cube_r218;
	private final ModelRenderer cube_r219;
	private final ModelRenderer cube_r220;
	private final ModelRenderer cube_r221;
	private final ModelRenderer cube_r222;
	private final ModelRenderer rope_25;
	private final ModelRenderer cube_r223;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r50;
	private final ModelRenderer Sail_2;
	private final ModelRenderer rope_26;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer rope_27;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer rope_28;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer rope_29;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer rope_30;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer cube_r65;
	private final ModelRenderer rope_31;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer rope_32;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer rope_33;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer rope_34;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r77;
	private final ModelRenderer rope_35;
	private final ModelRenderer cube_r224;
	private final ModelRenderer cube_r225;
	private final ModelRenderer cube_r226;
	private final ModelRenderer segel_13;
	private final ModelRenderer cube_r227;
	private final ModelRenderer segel_14;
	private final ModelRenderer rope_36;
	private final ModelRenderer cube_r228;
	private final ModelRenderer segel_15;
	private final ModelRenderer cube_r229;
	private final ModelRenderer cube_r230;
	private final ModelRenderer cube_r231;
	private final ModelRenderer cube_r232;
	private final ModelRenderer cube_r233;
	private final ModelRenderer segel_16;
	private final ModelRenderer cube_r234;
	private final ModelRenderer cube_r235;
	private final ModelRenderer cube_r236;
	private final ModelRenderer cube_r237;
	private final ModelRenderer cube_r238;
	private final ModelRenderer segel_17;
	private final ModelRenderer cube_r239;
	private final ModelRenderer cube_r240;
	private final ModelRenderer cube_r241;
	private final ModelRenderer cube_r242;
	private final ModelRenderer cube_r243;
	private final ModelRenderer cube_r244;
	private final ModelRenderer segel_18;
	private final ModelRenderer cube_r245;
	private final ModelRenderer cube_r246;
	private final ModelRenderer cube_r247;
	private final ModelRenderer cube_r248;
	private final ModelRenderer cube_r249;
	private final ModelRenderer cube_r250;
	private final ModelRenderer rope_37;
	private final ModelRenderer cube_r251;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer Sail_1;
	private final ModelRenderer rope_38;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer rope_39;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;
	private final ModelRenderer rope_40;
	private final ModelRenderer cube_r87;
	private final ModelRenderer cube_r88;
	private final ModelRenderer cube_r89;
	private final ModelRenderer rope_41;
	private final ModelRenderer cube_r90;
	private final ModelRenderer cube_r91;
	private final ModelRenderer cube_r92;
	private final ModelRenderer rope_42;
	private final ModelRenderer cube_r93;
	private final ModelRenderer cube_r94;
	private final ModelRenderer cube_r95;
	private final ModelRenderer rope_43;
	private final ModelRenderer cube_r102;
	private final ModelRenderer cube_r103;
	private final ModelRenderer cube_r104;
	private final ModelRenderer rope_44;
	private final ModelRenderer cube_r105;
	private final ModelRenderer cube_r106;
	private final ModelRenderer cube_r107;
	private final ModelRenderer rope_45;
	private final ModelRenderer cube_r108;
	private final ModelRenderer cube_r109;
	private final ModelRenderer cube_r110;
	private final ModelRenderer rope_46;
	private final ModelRenderer cube_r111;
	private final ModelRenderer cube_r112;
	private final ModelRenderer cube_r113;
	private final ModelRenderer rope_47;
	private final ModelRenderer cube_r252;
	private final ModelRenderer cube_r253;
	private final ModelRenderer cube_r254;
	private final ModelRenderer segel_19;
	private final ModelRenderer cube_r255;
	private final ModelRenderer segel_20;
	private final ModelRenderer rope_48;
	private final ModelRenderer cube_r256;
	private final ModelRenderer segel_21;
	private final ModelRenderer cube_r257;
	private final ModelRenderer cube_r258;
	private final ModelRenderer cube_r259;
	private final ModelRenderer segel_22;
	private final ModelRenderer cube_r260;
	private final ModelRenderer cube_r261;
	private final ModelRenderer cube_r262;
	private final ModelRenderer segel_23;
	private final ModelRenderer cube_r263;
	private final ModelRenderer cube_r264;
	private final ModelRenderer cube_r265;
	private final ModelRenderer cube_r266;
	private final ModelRenderer segel_24;
	private final ModelRenderer cube_r267;
	private final ModelRenderer cube_r268;
	private final ModelRenderer cube_r269;
	private final ModelRenderer cube_r270;
	private final ModelRenderer rope_49;
	private final ModelRenderer cube_r271;
	private final ModelRenderer cube_r114;
	private final ModelRenderer cube_r115;
	private final ModelRenderer rope_62;
	private final ModelRenderer cube_r145;
	private final ModelRenderer cube_r146;
	private final ModelRenderer cube_r147;
	private final ModelRenderer Sail_0;
	private final ModelRenderer rope_50;
	private final ModelRenderer cube_r116;
	private final ModelRenderer cube_r117;
	private final ModelRenderer cube_r118;
	private final ModelRenderer rope_51;
	private final ModelRenderer cube_r119;
	private final ModelRenderer cube_r120;
	private final ModelRenderer cube_r121;
	private final ModelRenderer rope_52;
	private final ModelRenderer cube_r122;
	private final ModelRenderer cube_r123;
	private final ModelRenderer cube_r124;
	private final ModelRenderer rope_53;
	private final ModelRenderer cube_r125;
	private final ModelRenderer cube_r126;
	private final ModelRenderer cube_r127;
	private final ModelRenderer rope_54;
	private final ModelRenderer cube_r128;
	private final ModelRenderer cube_r129;
	private final ModelRenderer cube_r130;
	private final ModelRenderer rope_55;
	private final ModelRenderer cube_r131;
	private final ModelRenderer cube_r132;
	private final ModelRenderer cube_r133;
	private final ModelRenderer rope_56;
	private final ModelRenderer cube_r134;
	private final ModelRenderer cube_r135;
	private final ModelRenderer cube_r136;
	private final ModelRenderer rope_57;
	private final ModelRenderer cube_r137;
	private final ModelRenderer cube_r138;
	private final ModelRenderer cube_r139;
	private final ModelRenderer rope_58;
	private final ModelRenderer cube_r140;
	private final ModelRenderer cube_r141;
	private final ModelRenderer cube_r142;
	private final ModelRenderer rope_59;
	private final ModelRenderer cube_r272;
	private final ModelRenderer cube_r273;
	private final ModelRenderer cube_r274;
	private final ModelRenderer segel_25;
	private final ModelRenderer cube_r275;
	private final ModelRenderer cube_r276;
	private final ModelRenderer segel_26;
	private final ModelRenderer cube_r277;
	private final ModelRenderer rope_60;
	private final ModelRenderer cube_r278;
	private final ModelRenderer segel_27;
	private final ModelRenderer cube_r279;
	private final ModelRenderer segel_28;
	private final ModelRenderer cube_r280;
	private final ModelRenderer segel_29;
	private final ModelRenderer cube_r281;
	private final ModelRenderer cube_r282;
	private final ModelRenderer cube_r283;
	private final ModelRenderer segel_30;
	private final ModelRenderer cube_r284;
	private final ModelRenderer rope_61;
	private final ModelRenderer cube_r285;
	private final ModelRenderer cube_r143;
	private final ModelRenderer cube_r144;
	private final ModelRenderer rope_63;
	private final ModelRenderer cube_r148;
	private final ModelRenderer cube_r149;
	private final ModelRenderer cube_r150;

	public ModelBriggSail()
	{
		texWidth = 128;
		texHeight = 64;

		segel_brigg = new ModelRenderer(this);
		segel_brigg.setPos(0.0F, -98.5F, 20.5F);


		Sail_4 = new ModelRenderer(this);
		Sail_4.setPos(0.0F, 122.5F, -20.5F);
		segel_brigg.addChild(Sail_4);


		rope_11 = new ModelRenderer(this);
		rope_11.setPos(-37.0F, -81.7F, 22.6F);
		Sail_4.addChild(rope_11);
		setRotationAngle(rope_11, 2.7031F, -0.2749F, -1.7985F);


		cube_r17 = new ModelRenderer(this);
		cube_r17.setPos(-8.5F, 37.0F, -9.5F);
		rope_11.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -1.5708F);
		cube_r17.texOffs(79, 2).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r17.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setPos(-8.5F, 3.0F, -26.5F);
		rope_11.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, -2.3562F);


		cube_r19 = new ModelRenderer(this);
		cube_r19.setPos(-8.5F, 15.0F, -26.5F);
		rope_11.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -2.3562F);


		rope_10 = new ModelRenderer(this);
		rope_10.setPos(-37.0F, -81.7F, -19.4F);
		Sail_4.addChild(rope_10);
		setRotationAngle(rope_10, 2.6595F, -0.2749F, -1.7985F);


		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(-8.5F, 37.0F, -9.5F);
		rope_10.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -1.5708F);
		cube_r14.texOffs(79, 2).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r14.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-8.5F, 3.0F, -26.5F);
		rope_10.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -2.3562F);


		cube_r16 = new ModelRenderer(this);
		cube_r16.setPos(-8.5F, 15.0F, -26.5F);
		rope_10.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -2.3562F);


		rope_12 = new ModelRenderer(this);
		rope_12.setPos(-21.0F, -19.0F, -24.0F);
		Sail_4.addChild(rope_12);
		setRotationAngle(rope_12, 1.8829F, -1.1671F, -1.9075F);


		cube_r20 = new ModelRenderer(this);
		cube_r20.setPos(-8.5F, 37.0F, -9.5F);
		rope_12.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.0F, -1.5708F);
		cube_r20.texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.texOffs(79, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r20.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setPos(-8.5F, 3.0F, -26.5F);
		rope_12.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.0F, -2.3562F);
		cube_r21.texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setPos(-8.5F, 15.0F, -26.5F);
		rope_12.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.0F, -2.3562F);
		cube_r22.texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_6 = new ModelRenderer(this);
		rope_6.setPos(-23.0F, -19.0F, -11.0F);
		Sail_4.addChild(rope_6);
		setRotationAngle(rope_6, 1.1315F, -1.18F, -1.6497F);


		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-8.5F, 37.0F, -9.5F);
		rope_6.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -1.5708F);
		cube_r5.texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r5.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-8.5F, 3.0F, -26.5F);
		rope_6.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -2.3562F);
		cube_r6.texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(-8.5F, 15.0F, -26.5F);
		rope_6.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -2.3562F);
		cube_r7.texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_4 = new ModelRenderer(this);
		rope_4.setPos(-18.0F, -21.0F, 38.0F);
		Sail_4.addChild(rope_4);
		setRotationAngle(rope_4, 1.1062F, -0.9992F, -1.7985F);


		cube_r99 = new ModelRenderer(this);
		cube_r99.setPos(-8.5F, 37.0F, -9.5F);
		rope_4.addChild(cube_r99);
		setRotationAngle(cube_r99, 0.0F, 0.0F, -1.5708F);
		cube_r99.texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r99.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r100 = new ModelRenderer(this);
		cube_r100.setPos(-8.5F, 3.0F, -26.5F);
		rope_4.addChild(cube_r100);
		setRotationAngle(cube_r100, 0.0F, 0.0F, -2.3562F);
		cube_r100.texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r101 = new ModelRenderer(this);
		cube_r101.setPos(-8.5F, 15.0F, -26.5F);
		rope_4.addChild(cube_r101);
		setRotationAngle(cube_r101, 0.0F, 0.0F, -2.3562F);
		cube_r101.texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_9 = new ModelRenderer(this);
		rope_9.setPos(34.5F, -82.5F, 23.6F);
		Sail_4.addChild(rope_9);
		setRotationAngle(rope_9, 2.5308F, 0.6108F, 1.6319F);


		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(0.0F, 21.5F, 17.0F);
		rope_9.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -1.5708F);
		cube_r11.texOffs(79, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r11.texOffs(79, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, -12.5F, 0.0F);
		rope_9.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -2.3562F);


		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, -0.5F, 0.0F);
		rope_9.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -2.3562F);


		rope_8 = new ModelRenderer(this);
		rope_8.setPos(34.5F, -82.5F, -18.8F);
		Sail_4.addChild(rope_8);
		setRotationAngle(rope_8, 2.5308F, 0.6108F, 1.5883F);


		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 21.5F, 17.0F);
		rope_8.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -1.5708F);
		cube_r8.texOffs(79, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r8.texOffs(79, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, -12.5F, 0.0F);
		rope_8.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -2.3562F);


		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, -0.5F, 0.0F);
		rope_8.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -2.3562F);


		rope_5 = new ModelRenderer(this);
		rope_5.setPos(21.5F, -19.0F, -12.5F);
		Sail_4.addChild(rope_5);
		setRotationAngle(rope_5, 1.0783F, 1.2103F, 1.6033F);


		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 21.5F, 17.0F);
		rope_5.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
		cube_r2.texOffs(79, 2).addBox(43.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(79, 2).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(79, 2).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.texOffs(79, 2).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, -12.5F, 0.0F);
		rope_5.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -2.3562F);
		cube_r3.texOffs(-10, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, -0.5F, 0.0F);
		rope_5.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -2.3562F);
		cube_r4.texOffs(24, 21).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_3 = new ModelRenderer(this);
		rope_3.setPos(17.5F, -21.0F, 38.5F);
		Sail_4.addChild(rope_3);
		setRotationAngle(rope_3, 1.1345F, 0.925F, 1.7628F);


		cube_r96 = new ModelRenderer(this);
		cube_r96.setPos(0.0F, 21.5F, 17.0F);
		rope_3.addChild(cube_r96);
		setRotationAngle(cube_r96, 0.0F, 0.0F, -1.5708F);
		cube_r96.texOffs(79, 2).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(79, 2).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(79, 2).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r96.texOffs(79, 2).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r97 = new ModelRenderer(this);
		cube_r97.setPos(0.0F, -12.5F, 0.0F);
		rope_3.addChild(cube_r97);
		setRotationAngle(cube_r97, 0.0F, 0.0F, -2.3562F);
		cube_r97.texOffs(-10, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r98 = new ModelRenderer(this);
		cube_r98.setPos(0.0F, -0.5F, 0.0F);
		rope_3.addChild(cube_r98);
		setRotationAngle(cube_r98, 0.0F, 0.0F, -2.3562F);
		cube_r98.texOffs(24, 21).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_2 = new ModelRenderer(this);
		rope_2.setPos(0.0F, -43.0F, -79.5F);
		Sail_4.addChild(rope_2);
		setRotationAngle(rope_2, -0.672F, 0.0F, 0.0F);


		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 11.5F, 17.0F);
		rope_2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -1.5708F);
		cube_r1.texOffs(79, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(79, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r151 = new ModelRenderer(this);
		cube_r151.setPos(0.0F, 11.5F, 17.0F);
		rope_2.addChild(cube_r151);
		setRotationAngle(cube_r151, 0.0F, 0.0F, -1.5708F);
		cube_r151.texOffs(79, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r152 = new ModelRenderer(this);
		cube_r152.setPos(0.0F, -10.5F, 0.0F);
		rope_2.addChild(cube_r152);
		setRotationAngle(cube_r152, 0.0F, 0.0F, -2.3562F);
		cube_r152.texOffs(9, 25).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_6 = new ModelRenderer(this);
		segel_6.setPos(-0.2F, -59.0F, -67.0F);
		Sail_4.addChild(segel_6);
		setRotationAngle(segel_6, -0.8233F, -0.5571F, 0.5184F);
		segel_6.texOffs(79, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_6.texOffs(79, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_6.texOffs(79, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		segel_6.texOffs(79, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r153 = new ModelRenderer(this);
		cube_r153.setPos(-0.1F, -44.0F, 0.0F);
		segel_6.addChild(cube_r153);
		setRotationAngle(cube_r153, 0.7854F, 0.0F, 0.0F);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(91, 7).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(86, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(86, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(91, 7).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(86, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(91, 7).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(86, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(91, 7).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(86, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(79, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(91, 7).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(85, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(94, 7).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r153.texOffs(70, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(84, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r153.texOffs(84, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		segel_5 = new ModelRenderer(this);
		segel_5.setPos(0.0F, -73.7376F, 28.1006F);
		Sail_4.addChild(segel_5);
		segel_5.texOffs(79, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(83, 2).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		segel_5.texOffs(86, 2).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(86, 5).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(84, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(88, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(91, 4).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(98, 4).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(84, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		segel_5.texOffs(79, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		segel_5.texOffs(94, 7).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);

		rope_7 = new ModelRenderer(this);
		rope_7.setPos(0.0F, -48.7624F, -0.5006F);
		segel_5.addChild(rope_7);
		setRotationAngle(rope_7, -2.2427F, 0.0F, 0.0F);


		cube_r154 = new ModelRenderer(this);
		cube_r154.setPos(0.0F, 11.5F, 17.0F);
		rope_7.addChild(cube_r154);
		setRotationAngle(cube_r154, 0.0F, 0.0F, -1.5708F);
		cube_r154.texOffs(79, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r154.texOffs(79, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r154.texOffs(79, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r154.texOffs(79, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		segel_4 = new ModelRenderer(this);
		segel_4.setPos(29.5F, -79.669F, 20.9006F);
		Sail_4.addChild(segel_4);


		cube_r155 = new ModelRenderer(this);
		cube_r155.setPos(0.0F, 3.1747F, -2.9013F);
		segel_4.addChild(cube_r155);
		setRotationAngle(cube_r155, 0.829F, 0.0F, 0.0F);
		cube_r155.texOffs(79, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(79, 4).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(79, 5).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(79, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(83, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(79, 6).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r155.texOffs(79, 6).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r156 = new ModelRenderer(this);
		cube_r156.setPos(0.0F, 0.0F, 0.0F);
		segel_4.addChild(cube_r156);
		setRotationAngle(cube_r156, 0.7418F, 0.0F, 0.0F);
		cube_r156.texOffs(85, 6).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(79, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(79, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(79, 5).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(82, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(79, 6).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r156.texOffs(82, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r157 = new ModelRenderer(this);
		cube_r157.setPos(0.0F, 7.9249F, -6.7434F);
		segel_4.addChild(cube_r157);
		setRotationAngle(cube_r157, 1.0908F, 0.0F, 0.0F);
		cube_r157.texOffs(79, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(79, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(79, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(82, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(79, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(79, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r157.texOffs(79, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r158 = new ModelRenderer(this);
		cube_r158.setPos(0.0F, 10.9576F, -8.2717F);
		segel_4.addChild(cube_r158);
		setRotationAngle(cube_r158, 1.2217F, 0.0F, 0.0F);
		cube_r158.texOffs(79, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(79, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(82, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(79, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(79, 5).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(79, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r158.texOffs(79, 5).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r159 = new ModelRenderer(this);
		cube_r159.setPos(0.0F, 15.9877F, -8.8184F);
		segel_4.addChild(cube_r159);
		setRotationAngle(cube_r159, 1.5272F, 0.0F, 0.0F);
		cube_r159.texOffs(79, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(82, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(82, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(79, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(79, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(79, 4).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r159.texOffs(79, 6).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r160 = new ModelRenderer(this);
		cube_r160.setPos(0.0F, 20.9045F, -8.4668F);
		segel_4.addChild(cube_r160);
		setRotationAngle(cube_r160, 1.7453F, 0.0F, 0.0F);
		cube_r160.texOffs(79, 6).addBox(-49.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(79, 6).addBox(-66.0F, -1.25F, -2.75F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(79, 6).addBox(-60.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(79, 8).addBox(-38.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(79, 4).addBox(-27.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(77, 6).addBox(-16.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r160.texOffs(79, 5).addBox(-5.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r161 = new ModelRenderer(this);
		cube_r161.setPos(0.0F, 27.1896F, -8.8894F);
		segel_4.addChild(cube_r161);
		setRotationAngle(cube_r161, 1.8762F, 0.0F, 0.0F);
		cube_r161.texOffs(79, 8).addBox(-49.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(79, 6).addBox(-66.0F, 0.75F, -1.7112F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(79, 6).addBox(-60.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(82, 28).addBox(-38.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(79, 5).addBox(-27.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(79, 5).addBox(-16.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r161.texOffs(79, 5).addBox(-5.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r162 = new ModelRenderer(this);
		cube_r162.setPos(0.0F, 29.3623F, -6.0111F);
		segel_4.addChild(cube_r162);
		setRotationAngle(cube_r162, 2.0595F, 0.0F, 0.0F);
		cube_r162.texOffs(79, 5).addBox(-16.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(79, 7).addBox(-66.0F, -1.0F, -3.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(79, 7).addBox(-61.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(79, 5).addBox(-50.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(79, 7).addBox(-39.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(77, 7).addBox(-28.0F, -1.0F, -3.5F, 12.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r162.texOffs(79, 8).addBox(-5.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r163 = new ModelRenderer(this);
		cube_r163.setPos(0.0F, 34.9409F, -3.1328F);
		segel_4.addChild(cube_r163);
		setRotationAngle(cube_r163, 2.2227F, 0.0F, 0.0F);
		cube_r163.texOffs(89, 2).addBox(-66.0F, -0.4519F, -2.0478F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 5).addBox(-60.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 7).addBox(-49.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 2).addBox(-38.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 7).addBox(-27.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 3).addBox(-16.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r163.texOffs(79, 5).addBox(-5.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r164 = new ModelRenderer(this);
		cube_r164.setPos(0.0F, 36.5319F, 0.9331F);
		segel_4.addChild(cube_r164);
		setRotationAngle(cube_r164, 2.3562F, 0.0F, 0.0F);
		cube_r164.texOffs(82, 29).addBox(-5.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(82, 29).addBox(-66.0F, -2.3929F, -3.0737F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(82, 29).addBox(-60.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(79, 5).addBox(-49.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(79, 8).addBox(-38.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(79, 8).addBox(-27.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r164.texOffs(79, 7).addBox(-16.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_3 = new ModelRenderer(this);
		segel_3.setPos(3.0F, 0.0F, 0.0F);
		Sail_4.addChild(segel_3);


		cube_r165 = new ModelRenderer(this);
		cube_r165.setPos(26.5F, -50.3067F, 14.8895F);
		segel_3.addChild(cube_r165);
		setRotationAngle(cube_r165, 2.0595F, 0.0F, 0.0F);
		cube_r165.texOffs(79, 2).addBox(-5.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(79, 8).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(79, 5).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(79, 3).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(68, 30).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(79, 5).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r165.texOffs(91, 2).addBox(-66.0F, -39.0F, 16.6905F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r166 = new ModelRenderer(this);
		cube_r166.setPos(26.5F, -52.4794F, 12.0112F);
		segel_3.addChild(cube_r166);
		setRotationAngle(cube_r166, 1.8762F, 0.0F, 0.0F);
		cube_r166.texOffs(79, 7).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(79, 5).addBox(-5.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(79, 6).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(79, 8).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(79, 3).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(79, 6).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r166.texOffs(84, 6).addBox(-66.0F, -40.25F, 11.2888F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r167 = new ModelRenderer(this);
		cube_r167.setPos(26.5F, -58.7644F, 12.4338F);
		segel_3.addChild(cube_r167);
		setRotationAngle(cube_r167, 1.7453F, 0.0F, 0.0F);
		cube_r167.texOffs(79, 5).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(91, 2).addBox(-66.0F, -43.5F, 4.75F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(79, 6).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(79, 6).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(79, 7).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(79, 7).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r167.texOffs(79, 6).addBox(-5.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r168 = new ModelRenderer(this);
		cube_r168.setPos(26.5F, -63.6813F, 12.0822F);
		segel_3.addChild(cube_r168);
		setRotationAngle(cube_r168, 1.5272F, 0.0F, 0.0F);
		cube_r168.texOffs(86, 5).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 6).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 5).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 5).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r168.texOffs(79, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r169 = new ModelRenderer(this);
		cube_r169.setPos(26.5F, -68.7113F, 12.6289F);
		segel_3.addChild(cube_r169);
		setRotationAngle(cube_r169, 1.2217F, 0.0F, 0.0F);
		cube_r169.texOffs(91, 2).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 6).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 4).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r169.texOffs(79, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r170 = new ModelRenderer(this);
		cube_r170.setPos(26.5F, -71.7441F, 14.1572F);
		segel_3.addChild(cube_r170);
		setRotationAngle(cube_r170, 1.0908F, 0.0F, 0.0F);
		cube_r170.texOffs(86, 28).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(79, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(82, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(79, 6).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(79, 6).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(82, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r170.texOffs(79, 6).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r171 = new ModelRenderer(this);
		cube_r171.setPos(26.5F, -79.4356F, -21.9095F);
		segel_3.addChild(cube_r171);
		setRotationAngle(cube_r171, 0.6545F, 0.0F, 0.0F);
		cube_r171.texOffs(84, 28).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 5).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 5).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 6).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 6).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r171.texOffs(79, 5).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r172 = new ModelRenderer(this);
		cube_r172.setPos(26.5F, -76.4943F, 17.9993F);
		segel_3.addChild(cube_r172);
		setRotationAngle(cube_r172, 0.829F, 0.0F, 0.0F);
		cube_r172.texOffs(91, 2).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(79, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(79, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(82, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(82, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(79, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r172.texOffs(79, 6).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r173 = new ModelRenderer(this);
		cube_r173.setPos(26.5F, -44.7281F, 17.7678F);
		segel_3.addChild(cube_r173);
		setRotationAngle(cube_r173, 2.2227F, 0.0F, 0.0F);
		cube_r173.texOffs(79, 4).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(79, 7).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(79, 6).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(79, 5).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(79, 5).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(82, 28).addBox(-5.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r173.texOffs(91, 2).addBox(-66.0F, -34.7019F, 23.9822F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r174 = new ModelRenderer(this);
		cube_r174.setPos(26.5F, -43.1371F, 21.8337F);
		segel_3.addChild(cube_r174);
		setRotationAngle(cube_r174, 2.3562F, 0.0F, 0.0F);
		cube_r174.texOffs(79, 6).addBox(-60.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(79, 6).addBox(-49.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(79, 4).addBox(-38.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(79, 5).addBox(-27.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(79, 8).addBox(-16.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(79, 5).addBox(-5.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r174.texOffs(91, 2).addBox(-66.0F, -32.8929F, 27.4263F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		segel_2 = new ModelRenderer(this);
		segel_2.setPos(0.0F, -114.0F, 25.0F);
		Sail_4.addChild(segel_2);


		cube_r175 = new ModelRenderer(this);
		cube_r175.setPos(-17.5F, 2.75F, -3.5F);
		segel_2.addChild(cube_r175);
		setRotationAngle(cube_r175, 2.0071F, 0.0F, 0.0F);
		cube_r175.texOffs(67, 24).addBox(-6.0F, -15.75F, -21.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r175.texOffs(79, 5).addBox(9.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r175.texOffs(79, 6).addBox(20.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r175.texOffs(79, 6).addBox(31.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r175.texOffs(79, 5).addBox(-2.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r176 = new ModelRenderer(this);
		cube_r176.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r176);
		setRotationAngle(cube_r176, 1.7453F, 0.0F, 0.0F);
		cube_r176.texOffs(68, 30).addBox(20.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r176.texOffs(79, 4).addBox(9.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r176.texOffs(79, 4).addBox(-6.0F, -11.0F, -20.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r176.texOffs(79, 4).addBox(-2.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r176.texOffs(79, 8).addBox(31.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r177 = new ModelRenderer(this);
		cube_r177.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r177);
		setRotationAngle(cube_r177, 1.6581F, 0.0F, 0.0F);
		cube_r177.texOffs(82, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r177.texOffs(79, 5).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r177.texOffs(79, 6).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r177.texOffs(79, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r177.texOffs(79, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r178 = new ModelRenderer(this);
		cube_r178.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r178);
		setRotationAngle(cube_r178, 1.3963F, 0.0F, 0.0F);
		cube_r178.texOffs(93, 2).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r178.texOffs(79, 5).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r178.texOffs(79, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r178.texOffs(79, 4).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r178.texOffs(79, 6).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r179 = new ModelRenderer(this);
		cube_r179.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r179);
		setRotationAngle(cube_r179, 1.2217F, 0.0F, 0.0F);
		cube_r179.texOffs(79, 5).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r179.texOffs(79, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r179.texOffs(79, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r179.texOffs(79, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r179.texOffs(79, 4).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r180 = new ModelRenderer(this);
		cube_r180.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r180);
		setRotationAngle(cube_r180, 0.8727F, 0.0F, 0.0F);
		cube_r180.texOffs(79, 5).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r180.texOffs(79, 4).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r180.texOffs(79, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r180.texOffs(83, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r180.texOffs(79, 5).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r181 = new ModelRenderer(this);
		cube_r181.setPos(-17.5F, 3.0F, -3.5F);
		segel_2.addChild(cube_r181);
		setRotationAngle(cube_r181, 0.3054F, 0.0F, 0.0F);
		cube_r181.texOffs(79, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r181.texOffs(79, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r181.texOffs(79, 4).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r181.texOffs(79, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r181.texOffs(79, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_1 = new ModelRenderer(this);
		segel_1.setPos(0.0F, -112.0F, -18.0F);
		Sail_4.addChild(segel_1);
		setRotationAngle(segel_1, -0.2182F, 0.0F, 0.0F);


		cube_r182 = new ModelRenderer(this);
		cube_r182.setPos(-17.5F, 0.75F, 39.5F);
		segel_1.addChild(cube_r182);
		setRotationAngle(cube_r182, 2.2689F, 0.0F, 0.0F);
		cube_r182.texOffs(81, 8).addBox(-2.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r182.texOffs(84, 28).addBox(9.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r182.texOffs(81, 8).addBox(20.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r182.texOffs(80, 7).addBox(31.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r182.texOffs(81, 8).addBox(-6.0F, -49.5F, 6.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r183 = new ModelRenderer(this);
		cube_r183.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r183);
		setRotationAngle(cube_r183, 2.0071F, 0.0F, 0.0F);
		cube_r183.texOffs(91, 7).addBox(-6.0F, -50.0F, -4.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r183.texOffs(79, 7).addBox(-2.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r183.texOffs(79, 5).addBox(9.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r183.texOffs(79, 8).addBox(20.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r183.texOffs(79, 8).addBox(31.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r184 = new ModelRenderer(this);
		cube_r184.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r184);
		setRotationAngle(cube_r184, 1.9199F, 0.0F, 0.0F);
		cube_r184.texOffs(90, 6).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r184.texOffs(79, 6).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r184.texOffs(79, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r184.texOffs(79, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r184.texOffs(79, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r185 = new ModelRenderer(this);
		cube_r185.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r185);
		setRotationAngle(cube_r185, 1.6581F, 0.0F, 0.0F);
		cube_r185.texOffs(79, 5).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r185.texOffs(87, 28).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r185.texOffs(82, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r185.texOffs(79, 6).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r185.texOffs(79, 6).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r186 = new ModelRenderer(this);
		cube_r186.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r186);
		setRotationAngle(cube_r186, 1.4835F, 0.0F, 0.0F);
		cube_r186.texOffs(66, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r186.texOffs(77, 6).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r186.texOffs(79, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r186.texOffs(79, 5).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r186.texOffs(86, 7).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r187 = new ModelRenderer(this);
		cube_r187.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r187);
		setRotationAngle(cube_r187, 1.1345F, 0.0F, 0.0F);
		cube_r187.texOffs(91, 2).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r187.texOffs(91, 2).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r187.texOffs(79, 5).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r187.texOffs(79, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r187.texOffs(79, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r188 = new ModelRenderer(this);
		cube_r188.setPos(-17.5F, 1.0F, 39.5F);
		segel_1.addChild(cube_r188);
		setRotationAngle(cube_r188, 0.5672F, 0.0F, 0.0F);
		cube_r188.texOffs(85, 8).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r188.texOffs(79, 5).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r188.texOffs(79, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r188.texOffs(79, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r188.texOffs(79, 5).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_13 = new ModelRenderer(this);
		rope_13.setPos(0.0F, -122.5F, 20.5F);
		Sail_4.addChild(rope_13);


		cube_r189 = new ModelRenderer(this);
		cube_r189.setPos(0.0F, 0.0F, 0.0F);
		rope_13.addChild(cube_r189);
		setRotationAngle(cube_r189, -1.5708F, 0.0F, 0.0F);
		cube_r189.texOffs(81, 16).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r189.texOffs(81, 16).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r189.texOffs(76, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		Sail_3 = new ModelRenderer(this);
		Sail_3.setPos(0.0F, 122.5F, -20.5F);
		segel_brigg.addChild(Sail_3);


		rope_14 = new ModelRenderer(this);
		rope_14.setPos(-37.0F, -81.7F, 22.6F);
		Sail_3.addChild(rope_14);
		setRotationAngle(rope_14, 2.6226F, -0.3589F, -1.9596F);


		cube_r23 = new ModelRenderer(this);
		cube_r23.setPos(-8.5F, 37.0F, -9.5F);
		rope_14.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.0F, -1.5708F);
		cube_r23.texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r23.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setPos(-8.5F, 3.0F, -26.5F);
		rope_14.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -2.3562F);


		cube_r25 = new ModelRenderer(this);
		cube_r25.setPos(-8.5F, 15.0F, -26.5F);
		rope_14.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, -2.3562F);


		rope_15 = new ModelRenderer(this);
		rope_15.setPos(-37.0F, -81.7F, -19.4F);
		Sail_3.addChild(rope_15);
		setRotationAngle(rope_15, 2.6407F, -0.3095F, -1.8826F);


		cube_r26 = new ModelRenderer(this);
		cube_r26.setPos(-8.5F, 37.0F, -9.5F);
		rope_15.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, -1.5708F);
		cube_r26.texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r26.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setPos(-8.5F, 3.0F, -26.5F);
		rope_15.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -2.3562F);


		cube_r28 = new ModelRenderer(this);
		cube_r28.setPos(-8.5F, 15.0F, -26.5F);
		rope_15.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, -2.3562F);


		rope_16 = new ModelRenderer(this);
		rope_16.setPos(-21.0F, -19.0F, -24.0F);
		Sail_3.addChild(rope_16);
		setRotationAngle(rope_16, 1.8829F, -1.1671F, -1.9075F);


		cube_r29 = new ModelRenderer(this);
		cube_r29.setPos(-8.5F, 37.0F, -9.5F);
		rope_16.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, -1.5708F);
		cube_r29.texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r29.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setPos(-8.5F, 3.0F, -26.5F);
		rope_16.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, -2.3562F);
		cube_r30.texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setPos(-8.5F, 15.0F, -26.5F);
		rope_16.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.0F, -2.3562F);
		cube_r31.texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_17 = new ModelRenderer(this);
		rope_17.setPos(-22.0F, -20.0F, -12.0F);
		Sail_3.addChild(rope_17);
		setRotationAngle(rope_17, 1.2787F, -1.0972F, -1.7157F);


		cube_r32 = new ModelRenderer(this);
		cube_r32.setPos(-7.9251F, 37.6555F, -8.0034F);
		rope_17.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -1.5708F);
		cube_r32.texOffs(91, 2).addBox(66.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r32.texOffs(91, 2).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r32.texOffs(91, 2).addBox(49.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r32.texOffs(91, 2).addBox(49.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r32.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setPos(-7.9251F, 3.6555F, -25.0034F);
		rope_17.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.0F, -2.3562F);
		cube_r33.texOffs(2, 21).addBox(8.8796F, 20.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setPos(-7.9251F, 15.6555F, -25.0034F);
		rope_17.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.0F, -2.3562F);
		cube_r34.texOffs(7, 29).addBox(12.1296F, 23.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_18 = new ModelRenderer(this);
		rope_18.setPos(-18.0F, -21.0F, 38.0F);
		Sail_3.addChild(rope_18);
		setRotationAngle(rope_18, 1.2166F, -0.9585F, -1.8265F);


		cube_r35 = new ModelRenderer(this);
		cube_r35.setPos(-8.5F, 37.0F, -9.5F);
		rope_18.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -1.5708F);
		cube_r35.texOffs(91, 2).addBox(67.9409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r35.texOffs(91, 2).addBox(58.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r35.texOffs(91, 2).addBox(50.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r35.texOffs(91, 2).addBox(50.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r35.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setPos(-8.5F, 3.0F, -26.5F);
		rope_18.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, -2.3562F);
		cube_r36.texOffs(2, 21).addBox(9.8796F, 21.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setPos(-8.5F, 15.0F, -26.5F);
		rope_18.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, 0.0F, -2.3562F);
		cube_r37.texOffs(7, 29).addBox(13.1296F, 24.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_19 = new ModelRenderer(this);
		rope_19.setPos(34.5F, -82.5F, 23.6F);
		Sail_3.addChild(rope_19);
		setRotationAngle(rope_19, 2.4352F, 0.6911F, 1.762F);


		cube_r38 = new ModelRenderer(this);
		cube_r38.setPos(0.0F, 21.5F, 17.0F);
		rope_19.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -1.5708F);
		cube_r38.texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r38.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setPos(0.0F, -12.5F, 0.0F);
		rope_19.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -2.3562F);


		cube_r40 = new ModelRenderer(this);
		cube_r40.setPos(0.0F, -0.5F, 0.0F);
		rope_19.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, -2.3562F);


		rope_20 = new ModelRenderer(this);
		rope_20.setPos(34.5F, -82.5F, -18.8F);
		Sail_3.addChild(rope_20);
		setRotationAngle(rope_20, 2.4854F, 0.6605F, 1.664F);


		cube_r41 = new ModelRenderer(this);
		cube_r41.setPos(0.0F, 21.5F, 17.0F);
		rope_20.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.0F, -1.5708F);
		cube_r41.texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r41.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setPos(0.0F, -12.5F, 0.0F);
		rope_20.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -2.3562F);


		cube_r43 = new ModelRenderer(this);
		cube_r43.setPos(0.0F, -0.5F, 0.0F);
		rope_20.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, 0.0F, -2.3562F);


		rope_21 = new ModelRenderer(this);
		rope_21.setPos(21.5F, -19.0F, -12.5F);
		Sail_3.addChild(rope_21);
		setRotationAngle(rope_21, 1.2397F, 1.1288F, 1.6837F);


		cube_r44 = new ModelRenderer(this);
		cube_r44.setPos(0.0F, 21.5F, 17.0F);
		rope_21.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.0F, -1.5708F);
		cube_r44.texOffs(91, 2).addBox(51.9F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r44.texOffs(91, 2).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r44.texOffs(91, 2).addBox(34.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r44.texOffs(91, 2).addBox(34.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r44.texOffs(91, 2).addBox(21.9F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setPos(0.0F, -12.5F, 0.0F);
		rope_21.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, 0.0F, -2.3562F);
		cube_r45.texOffs(2, 21).addBox(4.25F, 4.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setPos(0.0F, -0.5F, 0.0F);
		rope_21.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, 0.0F, -2.3562F);
		cube_r46.texOffs(7, 29).addBox(7.5F, 7.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_22 = new ModelRenderer(this);
		rope_22.setPos(17.5F, -21.0F, 38.5F);
		Sail_3.addChild(rope_22);
		setRotationAngle(rope_22, 1.2218F, 0.925F, 1.7628F);


		cube_r47 = new ModelRenderer(this);
		cube_r47.setPos(0.0F, 21.5F, 17.0F);
		rope_22.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.0F, -1.5708F);
		cube_r47.texOffs(91, 2).addBox(51.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(91, 2).addBox(42.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(91, 2).addBox(34.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(91, 2).addBox(34.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r47.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setPos(0.0F, -12.5F, 0.0F);
		rope_22.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.0F, -2.3562F);
		cube_r48.texOffs(2, 21).addBox(4.25F, 4.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setPos(0.0F, -0.5F, 0.0F);
		rope_22.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, -2.3562F);
		cube_r49.texOffs(7, 29).addBox(7.5F, 7.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_23 = new ModelRenderer(this);
		rope_23.setPos(0.0F, -43.0F, -79.5F);
		Sail_3.addChild(rope_23);
		setRotationAngle(rope_23, -0.672F, 0.0F, 0.0F);


		cube_r190 = new ModelRenderer(this);
		cube_r190.setPos(0.0F, 11.5F, 17.0F);
		rope_23.addChild(cube_r190);
		setRotationAngle(cube_r190, 0.0F, 0.0F, -1.5708F);
		cube_r190.texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r190.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r191 = new ModelRenderer(this);
		cube_r191.setPos(0.0F, 11.5F, 17.0F);
		rope_23.addChild(cube_r191);
		setRotationAngle(cube_r191, 0.0F, 0.0F, -1.5708F);
		cube_r191.texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r192 = new ModelRenderer(this);
		cube_r192.setPos(0.0F, -10.5F, 0.0F);
		rope_23.addChild(cube_r192);
		setRotationAngle(cube_r192, 0.0F, 0.0F, -2.3562F);
		cube_r192.texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_7 = new ModelRenderer(this);
		segel_7.setPos(-0.2F, -59.0F, -67.0F);
		Sail_3.addChild(segel_7);
		setRotationAngle(segel_7, -0.8233F, -0.5571F, 0.5184F);
		segel_7.texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_7.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_7.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		segel_7.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r193 = new ModelRenderer(this);
		cube_r193.setPos(-0.1F, -44.0F, 0.0F);
		segel_7.addChild(cube_r193);
		setRotationAngle(cube_r193, 0.7854F, 0.0F, 0.0F);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r193.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r193.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		segel_8 = new ModelRenderer(this);
		segel_8.setPos(0.0F, -73.7376F, 28.1006F);
		Sail_3.addChild(segel_8);
		segel_8.texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		segel_8.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		segel_8.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		segel_8.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);

		rope_24 = new ModelRenderer(this);
		rope_24.setPos(0.0F, -48.7624F, -0.5006F);
		segel_8.addChild(rope_24);
		setRotationAngle(rope_24, -2.2427F, 0.0F, 0.0F);


		cube_r194 = new ModelRenderer(this);
		cube_r194.setPos(0.0F, 11.5F, 17.0F);
		rope_24.addChild(cube_r194);
		setRotationAngle(cube_r194, 0.0F, 0.0F, -1.5708F);
		cube_r194.texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r194.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r194.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r194.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		segel_9 = new ModelRenderer(this);
		segel_9.setPos(29.5F, -79.669F, 20.9006F);
		Sail_3.addChild(segel_9);


		cube_r195 = new ModelRenderer(this);
		cube_r195.setPos(0.0F, 3.1747F, -2.9013F);
		segel_9.addChild(cube_r195);
		setRotationAngle(cube_r195, 0.829F, 0.0F, 0.0F);
		cube_r195.texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r195.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r196 = new ModelRenderer(this);
		cube_r196.setPos(0.0F, 0.0F, 0.0F);
		segel_9.addChild(cube_r196);
		setRotationAngle(cube_r196, 0.7418F, 0.0F, 0.0F);
		cube_r196.texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r196.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r197 = new ModelRenderer(this);
		cube_r197.setPos(0.0F, 7.9249F, -6.7434F);
		segel_9.addChild(cube_r197);
		setRotationAngle(cube_r197, 1.0908F, 0.0F, 0.0F);
		cube_r197.texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r197.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r198 = new ModelRenderer(this);
		cube_r198.setPos(0.0F, 10.9576F, -8.2717F);
		segel_9.addChild(cube_r198);
		setRotationAngle(cube_r198, 1.2217F, 0.0F, 0.0F);
		cube_r198.texOffs(91, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(91, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(94, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(91, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(80, 35).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(91, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r198.texOffs(80, 35).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r199 = new ModelRenderer(this);
		cube_r199.setPos(0.0F, 15.9877F, -8.8184F);
		segel_9.addChild(cube_r199);
		setRotationAngle(cube_r199, 1.5272F, 0.0F, 0.0F);
		cube_r199.texOffs(91, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(94, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(94, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(91, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(91, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(80, 34).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r199.texOffs(73, 36).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r200 = new ModelRenderer(this);
		cube_r200.setPos(0.0F, 20.9045F, -8.4668F);
		segel_9.addChild(cube_r200);
		setRotationAngle(cube_r200, 1.7453F, 0.0F, 0.0F);
		cube_r200.texOffs(73, 36).addBox(-49.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(91, 6).addBox(-66.0F, -1.25F, -2.75F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(73, 36).addBox(-60.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(91, 8).addBox(-38.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(80, 34).addBox(-27.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(71, 36).addBox(-16.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r200.texOffs(80, 35).addBox(-5.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r201 = new ModelRenderer(this);
		cube_r201.setPos(0.0F, 27.1896F, -8.8894F);
		segel_9.addChild(cube_r201);
		setRotationAngle(cube_r201, 1.8762F, 0.0F, 0.0F);
		cube_r201.texOffs(91, 8).addBox(-49.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(91, 6).addBox(-66.0F, 0.75F, -1.7112F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(73, 36).addBox(-60.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(94, 28).addBox(-38.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(80, 35).addBox(-27.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(80, 35).addBox(-16.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r201.texOffs(80, 35).addBox(-5.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r202 = new ModelRenderer(this);
		cube_r202.setPos(0.0F, 29.3623F, -6.0111F);
		segel_9.addChild(cube_r202);
		setRotationAngle(cube_r202, 2.0595F, 0.0F, 0.0F);
		cube_r202.texOffs(80, 35).addBox(-16.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(91, 7).addBox(-66.0F, -1.0F, -3.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(91, 7).addBox(-61.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(80, 35).addBox(-50.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(91, 7).addBox(-39.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(89, 7).addBox(-28.0F, -1.0F, -3.5F, 12.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r202.texOffs(91, 8).addBox(-5.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_10 = new ModelRenderer(this);
		segel_10.setPos(3.0F, 0.0F, 0.0F);
		Sail_3.addChild(segel_10);


		cube_r203 = new ModelRenderer(this);
		cube_r203.setPos(26.5F, -50.3067F, 14.8895F);
		segel_10.addChild(cube_r203);
		setRotationAngle(cube_r203, 2.0595F, 0.0F, 0.0F);
		cube_r203.texOffs(91, 2).addBox(-5.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(91, 8).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(80, 35).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(91, 3).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(80, 30).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(80, 35).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r203.texOffs(77, 16).addBox(-66.0F, -39.0F, 16.6905F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r204 = new ModelRenderer(this);
		cube_r204.setPos(26.5F, -52.4794F, 12.0112F);
		segel_10.addChild(cube_r204);
		setRotationAngle(cube_r204, 1.8762F, 0.0F, 0.0F);
		cube_r204.texOffs(91, 7).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(80, 35).addBox(-5.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(73, 36).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(91, 8).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(91, 3).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(73, 36).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r204.texOffs(70, 20).addBox(-66.0F, -40.25F, 11.2888F, 6.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r205 = new ModelRenderer(this);
		cube_r205.setPos(26.5F, -58.7644F, 12.4338F);
		segel_10.addChild(cube_r205);
		setRotationAngle(cube_r205, 1.7453F, 0.0F, 0.0F);
		cube_r205.texOffs(80, 35).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(77, 16).addBox(-66.0F, -43.5F, 4.75F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(73, 36).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(73, 36).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(91, 7).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(91, 7).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r205.texOffs(73, 36).addBox(-5.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r206 = new ModelRenderer(this);
		cube_r206.setPos(26.5F, -63.6813F, 12.0822F);
		segel_10.addChild(cube_r206);
		setRotationAngle(cube_r206, 1.5272F, 0.0F, 0.0F);
		cube_r206.texOffs(72, 19).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(91, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(73, 36).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(80, 35).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(91, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(80, 35).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r206.texOffs(91, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r207 = new ModelRenderer(this);
		cube_r207.setPos(26.5F, -68.7113F, 12.6289F);
		segel_10.addChild(cube_r207);
		setRotationAngle(cube_r207, 1.2217F, 0.0F, 0.0F);
		cube_r207.texOffs(77, 16).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(91, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(73, 36).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(91, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(80, 34).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(91, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r207.texOffs(91, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r208 = new ModelRenderer(this);
		cube_r208.setPos(26.5F, -71.7441F, 14.1572F);
		segel_10.addChild(cube_r208);
		setRotationAngle(cube_r208, 1.0908F, 0.0F, 0.0F);
		cube_r208.texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r208.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r209 = new ModelRenderer(this);
		cube_r209.setPos(26.5F, -79.4356F, -21.9095F);
		segel_10.addChild(cube_r209);
		setRotationAngle(cube_r209, 0.6545F, 0.0F, 0.0F);
		cube_r209.texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r209.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r210 = new ModelRenderer(this);
		cube_r210.setPos(26.5F, -76.4943F, 17.9993F);
		segel_10.addChild(cube_r210);
		setRotationAngle(cube_r210, 0.829F, 0.0F, 0.0F);
		cube_r210.texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r210.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_11 = new ModelRenderer(this);
		segel_11.setPos(0.0F, -114.0F, 25.0F);
		Sail_3.addChild(segel_11);


		cube_r211 = new ModelRenderer(this);
		cube_r211.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r211);
		setRotationAngle(cube_r211, 1.7453F, 0.0F, 0.0F);
		cube_r211.texOffs(80, 30).addBox(20.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r211.texOffs(80, 34).addBox(9.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r211.texOffs(91, 4).addBox(-6.0F, -11.0F, -20.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r211.texOffs(80, 34).addBox(-2.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r211.texOffs(91, 8).addBox(31.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r212 = new ModelRenderer(this);
		cube_r212.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r212);
		setRotationAngle(cube_r212, 1.6581F, 0.0F, 0.0F);
		cube_r212.texOffs(94, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r212.texOffs(80, 35).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r212.texOffs(73, 36).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r212.texOffs(91, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r212.texOffs(91, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r213 = new ModelRenderer(this);
		cube_r213.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r213);
		setRotationAngle(cube_r213, 1.3963F, 0.0F, 0.0F);
		cube_r213.texOffs(79, 16).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r213.texOffs(80, 35).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r213.texOffs(91, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r213.texOffs(80, 34).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r213.texOffs(73, 36).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r214 = new ModelRenderer(this);
		cube_r214.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r214);
		setRotationAngle(cube_r214, 1.2217F, 0.0F, 0.0F);
		cube_r214.texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r214.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r214.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r214.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r214.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r215 = new ModelRenderer(this);
		cube_r215.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r215);
		setRotationAngle(cube_r215, 0.8727F, 0.0F, 0.0F);
		cube_r215.texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r215.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r215.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r215.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r215.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r216 = new ModelRenderer(this);
		cube_r216.setPos(-17.5F, 3.0F, -3.5F);
		segel_11.addChild(cube_r216);
		setRotationAngle(cube_r216, 0.3054F, 0.0F, 0.0F);
		cube_r216.texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r216.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r216.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r216.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r216.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_12 = new ModelRenderer(this);
		segel_12.setPos(0.0F, -112.0F, -18.0F);
		Sail_3.addChild(segel_12);
		setRotationAngle(segel_12, -0.2182F, 0.0F, 0.0F);


		cube_r217 = new ModelRenderer(this);
		cube_r217.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r217);
		setRotationAngle(cube_r217, 2.0071F, 0.0F, 0.0F);
		cube_r217.texOffs(77, 21).addBox(-6.0F, -50.0F, -4.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r217.texOffs(91, 7).addBox(-2.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r217.texOffs(80, 35).addBox(9.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r217.texOffs(91, 8).addBox(20.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r217.texOffs(91, 8).addBox(31.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r218 = new ModelRenderer(this);
		cube_r218.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r218);
		setRotationAngle(cube_r218, 1.9199F, 0.0F, 0.0F);
		cube_r218.texOffs(76, 20).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r218.texOffs(73, 36).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r218.texOffs(91, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r218.texOffs(91, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r218.texOffs(91, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r219 = new ModelRenderer(this);
		cube_r219.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r219);
		setRotationAngle(cube_r219, 1.6581F, 0.0F, 0.0F);
		cube_r219.texOffs(80, 35).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r219.texOffs(70, 23).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r219.texOffs(94, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r219.texOffs(73, 36).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r219.texOffs(73, 36).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r220 = new ModelRenderer(this);
		cube_r220.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r220);
		setRotationAngle(cube_r220, 1.4835F, 0.0F, 0.0F);
		cube_r220.texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r220.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r220.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r220.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r220.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r221 = new ModelRenderer(this);
		cube_r221.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r221);
		setRotationAngle(cube_r221, 1.1345F, 0.0F, 0.0F);
		cube_r221.texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r221.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r221.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r221.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r221.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r222 = new ModelRenderer(this);
		cube_r222.setPos(-17.5F, 1.0F, 39.5F);
		segel_12.addChild(cube_r222);
		setRotationAngle(cube_r222, 0.5672F, 0.0F, 0.0F);
		cube_r222.texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r222.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r222.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r222.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r222.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_25 = new ModelRenderer(this);
		rope_25.setPos(0.0F, -122.5F, 20.5F);
		Sail_3.addChild(rope_25);


		cube_r223 = new ModelRenderer(this);
		cube_r223.setPos(0.0F, 0.0F, 0.0F);
		rope_25.addChild(cube_r223);
		setRotationAngle(cube_r223, -1.5708F, 0.0F, 0.0F);
		cube_r223.texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r223.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r223.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setPos(54.5F, -48.8067F, 18.2895F);
		Sail_3.addChild(cube_r80);
		setRotationAngle(cube_r80, 2.0595F, 0.0F, 0.0F);
		cube_r80.texOffs(91, 3).addBox(-64.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(80, 35).addBox(-77.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(88, 28).addBox(-93.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(73, 41).addBox(-51.0F, -41.6933F, 18.2105F, 18.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r80.texOffs(85, 4).addBox(-33.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setPos(54.5F, -48.8067F, 61.2895F);
		Sail_3.addChild(cube_r50);
		setRotationAngle(cube_r50, 2.0595F, 0.0F, 0.0F);
		cube_r50.texOffs(91, 3).addBox(-64.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r50.texOffs(80, 35).addBox(-77.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r50.texOffs(88, 28).addBox(-93.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r50.texOffs(73, 41).addBox(-51.0F, -41.6933F, 18.2105F, 18.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r50.texOffs(85, 4).addBox(-33.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, 0.0F, false);

		Sail_2 = new ModelRenderer(this);
		Sail_2.setPos(0.0F, 122.5F, -20.5F);
		segel_brigg.addChild(Sail_2);


		rope_26 = new ModelRenderer(this);
		rope_26.setPos(-37.0F, -81.7F, 22.6F);
		Sail_2.addChild(rope_26);
		setRotationAngle(rope_26, 2.5789F, -0.577F, -1.9596F);


		cube_r51 = new ModelRenderer(this);
		cube_r51.setPos(-8.5F, 37.0F, -9.5F);
		rope_26.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, -1.5708F);
		cube_r51.texOffs(91, 2).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r51.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setPos(-8.5F, 3.0F, -26.5F);
		rope_26.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.0F, -2.3562F);


		cube_r53 = new ModelRenderer(this);
		cube_r53.setPos(-8.5F, 15.0F, -26.5F);
		rope_26.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.0F, -2.3562F);


		rope_27 = new ModelRenderer(this);
		rope_27.setPos(-37.0F, -81.7F, -19.4F);
		Sail_2.addChild(rope_27);
		setRotationAngle(rope_27, 2.5534F, -0.7022F, -1.8826F);


		cube_r54 = new ModelRenderer(this);
		cube_r54.setPos(-8.5F, 37.0F, -9.5F);
		rope_27.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, 0.0F, -1.5708F);
		cube_r54.texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r54.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setPos(-8.5F, 3.0F, -26.5F);
		rope_27.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.0F, -2.3562F);


		cube_r56 = new ModelRenderer(this);
		cube_r56.setPos(-8.5F, 15.0F, -26.5F);
		rope_27.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.0F, -2.3562F);


		rope_28 = new ModelRenderer(this);
		rope_28.setPos(-21.0F, -19.0F, -24.0F);
		Sail_2.addChild(rope_28);
		setRotationAngle(rope_28, 1.8829F, -1.1671F, -1.9075F);


		cube_r57 = new ModelRenderer(this);
		cube_r57.setPos(-8.5F, 37.0F, -9.5F);
		rope_28.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.0F, 0.0F, -1.5708F);
		cube_r57.texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r57.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r57.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r57.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r57.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r57.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setPos(-8.5F, 3.0F, -26.5F);
		rope_28.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, -2.3562F);
		cube_r58.texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setPos(-8.5F, 15.0F, -26.5F);
		rope_28.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, 0.0F, -2.3562F);
		cube_r59.texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_29 = new ModelRenderer(this);
		rope_29.setPos(-22.0F, -20.0F, -12.0F);
		Sail_2.addChild(rope_29);
		setRotationAngle(rope_29, 1.3374F, -1.1564F, -1.6807F);


		cube_r60 = new ModelRenderer(this);
		cube_r60.setPos(-7.9251F, 37.6555F, -8.0034F);
		rope_29.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, -1.5708F);
		cube_r60.texOffs(91, 2).addBox(74.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r60.texOffs(91, 2).addBox(65.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r60.texOffs(91, 2).addBox(57.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r60.texOffs(91, 2).addBox(57.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r60.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r60.texOffs(91, 2).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setPos(-7.9251F, 3.6555F, -25.0034F);
		rope_29.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, -2.3562F);
		cube_r61.texOffs(2, 21).addBox(14.8796F, 26.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setPos(-7.9251F, 15.6555F, -25.0034F);
		rope_29.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, 0.0F, -2.3562F);
		cube_r62.texOffs(7, 29).addBox(18.1296F, 29.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_30 = new ModelRenderer(this);
		rope_30.setPos(-18.0F, -21.0F, 38.0F);
		Sail_2.addChild(rope_30);
		setRotationAngle(rope_30, 1.3963F, -1.0283F, -1.8265F);


		cube_r63 = new ModelRenderer(this);
		cube_r63.setPos(-8.5F, 37.0F, -9.5F);
		rope_30.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0F, 0.0F, -1.5708F);
		cube_r63.texOffs(91, 2).addBox(75.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r63.texOffs(91, 2).addBox(66.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r63.texOffs(91, 2).addBox(58.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r63.texOffs(91, 2).addBox(58.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r63.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r63.texOffs(91, 2).addBox(49.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setPos(-8.5F, 3.0F, -26.5F);
		rope_30.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, 0.0F, -2.3562F);
		cube_r64.texOffs(2, 21).addBox(15.8796F, 27.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setPos(-8.5F, 15.0F, -26.5F);
		rope_30.addChild(cube_r65);
		setRotationAngle(cube_r65, 0.0F, 0.0F, -2.3562F);
		cube_r65.texOffs(7, 29).addBox(19.1296F, 30.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_31 = new ModelRenderer(this);
		rope_31.setPos(34.5F, -82.5F, 23.6F);
		Sail_2.addChild(rope_31);
		setRotationAngle(rope_31, 2.3916F, 0.822F, 1.762F);


		cube_r66 = new ModelRenderer(this);
		cube_r66.setPos(0.0F, 21.5F, 17.0F);
		rope_31.addChild(cube_r66);
		setRotationAngle(cube_r66, 0.0F, 0.0F, -1.5708F);
		cube_r66.texOffs(91, 2).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r66.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setPos(0.0F, -12.5F, 0.0F);
		rope_31.addChild(cube_r67);
		setRotationAngle(cube_r67, 0.0F, 0.0F, -2.3562F);


		cube_r68 = new ModelRenderer(this);
		cube_r68.setPos(0.0F, -0.5F, 0.0F);
		rope_31.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.0F, -2.3562F);


		rope_32 = new ModelRenderer(this);
		rope_32.setPos(34.5F, -82.5F, -18.8F);
		Sail_2.addChild(rope_32);
		setRotationAngle(rope_32, 2.3545F, 0.966F, 1.664F);


		cube_r69 = new ModelRenderer(this);
		cube_r69.setPos(0.0F, 21.5F, 17.0F);
		rope_32.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.0F, 0.0F, -1.5708F);
		cube_r69.texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r69.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setPos(0.0F, -12.5F, 0.0F);
		rope_32.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0F, 0.0F, -2.3562F);


		cube_r71 = new ModelRenderer(this);
		cube_r71.setPos(0.0F, -0.5F, 0.0F);
		rope_32.addChild(cube_r71);
		setRotationAngle(cube_r71, 0.0F, 0.0F, -2.3562F);


		rope_33 = new ModelRenderer(this);
		rope_33.setPos(21.5F, -19.0F, -12.5F);
		Sail_2.addChild(rope_33);
		setRotationAngle(rope_33, 1.3502F, 1.1715F, 1.6614F);


		cube_r72 = new ModelRenderer(this);
		cube_r72.setPos(0.0F, 21.5F, 17.0F);
		rope_33.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.0F, 0.0F, -1.5708F);
		cube_r72.texOffs(91, 2).addBox(59.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.texOffs(91, 2).addBox(50.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.texOffs(91, 2).addBox(42.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.texOffs(91, 2).addBox(42.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.texOffs(91, 2).addBox(21.9F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r72.texOffs(91, 2).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setPos(0.0F, -12.5F, 0.0F);
		rope_33.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.0F, 0.0F, -2.3562F);
		cube_r73.texOffs(2, 21).addBox(10.25F, 10.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setPos(0.0F, -0.5F, 0.0F);
		rope_33.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.0F, 0.0F, -2.3562F);
		cube_r74.texOffs(7, 29).addBox(13.5F, 13.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_34 = new ModelRenderer(this);
		rope_34.setPos(17.5F, -21.0F, 38.5F);
		Sail_2.addChild(rope_34);
		setRotationAngle(rope_34, 1.3527F, 0.9948F, 1.7628F);


		cube_r75 = new ModelRenderer(this);
		cube_r75.setPos(0.0F, 21.5F, 17.0F);
		rope_34.addChild(cube_r75);
		setRotationAngle(cube_r75, 0.0F, 0.0F, -1.5708F);
		cube_r75.texOffs(91, 2).addBox(60.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(91, 2).addBox(51.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(91, 2).addBox(43.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(91, 2).addBox(43.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r75.texOffs(91, 2).addBox(33.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setPos(0.0F, -12.5F, 0.0F);
		rope_34.addChild(cube_r76);
		setRotationAngle(cube_r76, 0.0F, 0.0F, -2.3562F);
		cube_r76.texOffs(2, 21).addBox(10.25F, 10.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setPos(0.0F, -0.5F, 0.0F);
		rope_34.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.0F, 0.0F, -2.3562F);
		cube_r77.texOffs(7, 29).addBox(13.5F, 13.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_35 = new ModelRenderer(this);
		rope_35.setPos(0.0F, -43.0F, -79.5F);
		Sail_2.addChild(rope_35);
		setRotationAngle(rope_35, -0.672F, 0.0F, 0.0F);


		cube_r224 = new ModelRenderer(this);
		cube_r224.setPos(0.0F, 11.5F, 17.0F);
		rope_35.addChild(cube_r224);
		setRotationAngle(cube_r224, 0.0F, 0.0F, -1.5708F);
		cube_r224.texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r224.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r225 = new ModelRenderer(this);
		cube_r225.setPos(0.0F, 11.5F, 17.0F);
		rope_35.addChild(cube_r225);
		setRotationAngle(cube_r225, 0.0F, 0.0F, -1.5708F);
		cube_r225.texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r226 = new ModelRenderer(this);
		cube_r226.setPos(0.0F, -10.5F, 0.0F);
		rope_35.addChild(cube_r226);
		setRotationAngle(cube_r226, 0.0F, 0.0F, -2.3562F);
		cube_r226.texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_13 = new ModelRenderer(this);
		segel_13.setPos(-0.2F, -59.0F, -67.0F);
		Sail_2.addChild(segel_13);
		setRotationAngle(segel_13, -0.8233F, -0.5571F, 0.5184F);
		segel_13.texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_13.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_13.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		segel_13.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r227 = new ModelRenderer(this);
		cube_r227.setPos(-0.1F, -44.0F, 0.0F);
		segel_13.addChild(cube_r227);
		setRotationAngle(cube_r227, 0.7854F, 0.0F, 0.0F);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r227.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r227.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		segel_14 = new ModelRenderer(this);
		segel_14.setPos(0.0F, -73.7376F, 28.1006F);
		Sail_2.addChild(segel_14);
		segel_14.texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		segel_14.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		segel_14.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		segel_14.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);

		rope_36 = new ModelRenderer(this);
		rope_36.setPos(0.0F, -48.7624F, -0.5006F);
		segel_14.addChild(rope_36);
		setRotationAngle(rope_36, -2.2427F, 0.0F, 0.0F);


		cube_r228 = new ModelRenderer(this);
		cube_r228.setPos(0.0F, 11.5F, 17.0F);
		rope_36.addChild(cube_r228);
		setRotationAngle(cube_r228, 0.0F, 0.0F, -1.5708F);
		cube_r228.texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r228.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r228.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r228.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		segel_15 = new ModelRenderer(this);
		segel_15.setPos(29.5F, -79.669F, 20.9006F);
		Sail_2.addChild(segel_15);


		cube_r229 = new ModelRenderer(this);
		cube_r229.setPos(0.0F, 3.1747F, -2.9013F);
		segel_15.addChild(cube_r229);
		setRotationAngle(cube_r229, 0.829F, 0.0F, 0.0F);
		cube_r229.texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r229.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r230 = new ModelRenderer(this);
		cube_r230.setPos(0.0F, 0.0F, 0.0F);
		segel_15.addChild(cube_r230);
		setRotationAngle(cube_r230, 0.7418F, 0.0F, 0.0F);
		cube_r230.texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r230.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r231 = new ModelRenderer(this);
		cube_r231.setPos(0.0F, 7.9249F, -6.7434F);
		segel_15.addChild(cube_r231);
		setRotationAngle(cube_r231, 1.0908F, 0.0F, 0.0F);
		cube_r231.texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r231.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r232 = new ModelRenderer(this);
		cube_r232.setPos(0.0F, 10.9576F, -8.2717F);
		segel_15.addChild(cube_r232);
		setRotationAngle(cube_r232, 1.2217F, 0.0F, 0.0F);
		cube_r232.texOffs(91, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(91, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(94, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(91, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(80, 35).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(91, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r232.texOffs(80, 35).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r233 = new ModelRenderer(this);
		cube_r233.setPos(0.0F, 15.9877F, -8.8184F);
		segel_15.addChild(cube_r233);
		setRotationAngle(cube_r233, 1.5272F, 0.0F, 0.0F);
		cube_r233.texOffs(91, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(94, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(94, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(91, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(91, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(80, 34).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r233.texOffs(73, 36).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_16 = new ModelRenderer(this);
		segel_16.setPos(3.0F, 0.0F, 0.0F);
		Sail_2.addChild(segel_16);


		cube_r234 = new ModelRenderer(this);
		cube_r234.setPos(26.5F, -63.6813F, 12.0822F);
		segel_16.addChild(cube_r234);
		setRotationAngle(cube_r234, 1.5272F, 0.0F, 0.0F);
		cube_r234.texOffs(72, 19).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(91, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(73, 36).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(80, 35).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(91, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(80, 35).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r234.texOffs(91, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r235 = new ModelRenderer(this);
		cube_r235.setPos(26.5F, -68.7113F, 12.6289F);
		segel_16.addChild(cube_r235);
		setRotationAngle(cube_r235, 1.2217F, 0.0F, 0.0F);
		cube_r235.texOffs(77, 16).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(91, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(73, 36).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(91, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(80, 34).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(91, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r235.texOffs(91, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r236 = new ModelRenderer(this);
		cube_r236.setPos(26.5F, -71.7441F, 14.1572F);
		segel_16.addChild(cube_r236);
		setRotationAngle(cube_r236, 1.0908F, 0.0F, 0.0F);
		cube_r236.texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r236.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r237 = new ModelRenderer(this);
		cube_r237.setPos(26.5F, -79.4356F, -21.9095F);
		segel_16.addChild(cube_r237);
		setRotationAngle(cube_r237, 0.6545F, 0.0F, 0.0F);
		cube_r237.texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r237.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r238 = new ModelRenderer(this);
		cube_r238.setPos(26.5F, -76.4943F, 17.9993F);
		segel_16.addChild(cube_r238);
		setRotationAngle(cube_r238, 0.829F, 0.0F, 0.0F);
		cube_r238.texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r238.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_17 = new ModelRenderer(this);
		segel_17.setPos(0.0F, -114.0F, 25.0F);
		Sail_2.addChild(segel_17);


		cube_r239 = new ModelRenderer(this);
		cube_r239.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r239);
		setRotationAngle(cube_r239, 1.7453F, 0.0F, 0.0F);
		cube_r239.texOffs(80, 30).addBox(20.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r239.texOffs(73, 34).addBox(9.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r239.texOffs(91, 4).addBox(-7.0F, -12.0F, -17.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r239.texOffs(73, 34).addBox(-2.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r239.texOffs(91, 8).addBox(31.0F, -12.0F, -17.0F, 12.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r240 = new ModelRenderer(this);
		cube_r240.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r240);
		setRotationAngle(cube_r240, 1.6581F, 0.0F, 0.0F);
		cube_r240.texOffs(94, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r240.texOffs(80, 35).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r240.texOffs(73, 36).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r240.texOffs(91, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r240.texOffs(91, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r241 = new ModelRenderer(this);
		cube_r241.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r241);
		setRotationAngle(cube_r241, 1.3963F, 0.0F, 0.0F);
		cube_r241.texOffs(79, 16).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r241.texOffs(80, 35).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r241.texOffs(91, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r241.texOffs(80, 34).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r241.texOffs(73, 36).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r242 = new ModelRenderer(this);
		cube_r242.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r242);
		setRotationAngle(cube_r242, 1.2217F, 0.0F, 0.0F);
		cube_r242.texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r242.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r242.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r242.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r242.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r243 = new ModelRenderer(this);
		cube_r243.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r243);
		setRotationAngle(cube_r243, 0.8727F, 0.0F, 0.0F);
		cube_r243.texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r243.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r243.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r243.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r243.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r244 = new ModelRenderer(this);
		cube_r244.setPos(-17.5F, 3.0F, -3.5F);
		segel_17.addChild(cube_r244);
		setRotationAngle(cube_r244, 0.3054F, 0.0F, 0.0F);
		cube_r244.texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r244.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r244.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r244.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r244.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_18 = new ModelRenderer(this);
		segel_18.setPos(0.0F, -112.0F, -18.0F);
		Sail_2.addChild(segel_18);
		setRotationAngle(segel_18, -0.2182F, 0.0F, 0.0F);


		cube_r245 = new ModelRenderer(this);
		cube_r245.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r245);
		setRotationAngle(cube_r245, 2.0071F, 0.0F, 0.0F);
		cube_r245.texOffs(85, 37).addBox(-7.0F, -50.5F, 0.0F, 5.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r245.texOffs(73, 37).addBox(-2.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r245.texOffs(73, 35).addBox(9.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r245.texOffs(91, 8).addBox(20.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r245.texOffs(91, 8).addBox(31.0F, -50.5F, 0.0F, 12.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r246 = new ModelRenderer(this);
		cube_r246.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r246);
		setRotationAngle(cube_r246, 1.9199F, 0.0F, 0.0F);
		cube_r246.texOffs(76, 20).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r246.texOffs(73, 36).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r246.texOffs(91, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r246.texOffs(91, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r246.texOffs(91, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r247 = new ModelRenderer(this);
		cube_r247.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r247);
		setRotationAngle(cube_r247, 1.6581F, 0.0F, 0.0F);
		cube_r247.texOffs(80, 35).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r247.texOffs(70, 23).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r247.texOffs(94, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r247.texOffs(73, 36).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r247.texOffs(73, 36).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r248 = new ModelRenderer(this);
		cube_r248.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r248);
		setRotationAngle(cube_r248, 1.4835F, 0.0F, 0.0F);
		cube_r248.texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r248.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r248.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r248.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r248.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r249 = new ModelRenderer(this);
		cube_r249.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r249);
		setRotationAngle(cube_r249, 1.1345F, 0.0F, 0.0F);
		cube_r249.texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r249.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r249.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r249.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r249.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r250 = new ModelRenderer(this);
		cube_r250.setPos(-17.5F, 1.0F, 39.5F);
		segel_18.addChild(cube_r250);
		setRotationAngle(cube_r250, 0.5672F, 0.0F, 0.0F);
		cube_r250.texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r250.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r250.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r250.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r250.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_37 = new ModelRenderer(this);
		rope_37.setPos(0.0F, -122.5F, 20.5F);
		Sail_2.addChild(rope_37);


		cube_r251 = new ModelRenderer(this);
		cube_r251.setPos(0.0F, 0.0F, 0.0F);
		rope_37.addChild(cube_r251);
		setRotationAngle(cube_r251, -1.5708F, 0.0F, 0.0F);
		cube_r251.texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r251.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r251.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setPos(54.5F, -56.8067F, 15.2895F);
		Sail_2.addChild(cube_r78);
		setRotationAngle(cube_r78, 2.0595F, 0.0F, 0.0F);
		cube_r78.texOffs(80, 33).addBox(-64.0F, -40.6933F, 21.2105F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r78.texOffs(80, 35).addBox(-77.0F, -40.6933F, 21.2105F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r78.texOffs(67, 39).addBox(-93.0F, -40.6933F, 21.2105F, 16.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r78.texOffs(80, 30).addBox(-51.0F, -40.6933F, 21.2105F, 18.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r78.texOffs(74, 34).addBox(-33.0F, -40.6933F, 21.2105F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setPos(54.5F, -48.8067F, 61.2895F);
		Sail_2.addChild(cube_r79);
		setRotationAngle(cube_r79, 2.0595F, 0.0F, 0.0F);
		cube_r79.texOffs(80, 33).addBox(-64.0F, -40.6933F, 30.2105F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r79.texOffs(80, 35).addBox(-77.0F, -40.6933F, 30.2105F, 13.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r79.texOffs(67, 39).addBox(-93.0F, -40.6933F, 30.2105F, 16.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r79.texOffs(80, 30).addBox(-51.0F, -40.6933F, 30.2105F, 18.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r79.texOffs(74, 34).addBox(-33.0F, -40.6933F, 30.2105F, 16.0F, 4.0F, 4.0F, 0.0F, false);

		Sail_1 = new ModelRenderer(this);
		Sail_1.setPos(0.0F, 122.5F, -20.5F);
		segel_brigg.addChild(Sail_1);


		rope_38 = new ModelRenderer(this);
		rope_38.setPos(-37.0F, -81.7F, 22.6F);
		Sail_1.addChild(rope_38);
		setRotationAngle(rope_38, 2.4917F, -1.1006F, -1.9596F);


		cube_r81 = new ModelRenderer(this);
		cube_r81.setPos(-8.5F, 37.0F, -9.5F);
		rope_38.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.0F, -1.5708F);
		cube_r81.texOffs(91, 2).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r81.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setPos(-8.5F, 3.0F, -26.5F);
		rope_38.addChild(cube_r82);
		setRotationAngle(cube_r82, 0.0F, 0.0F, -2.3562F);


		cube_r83 = new ModelRenderer(this);
		cube_r83.setPos(-8.5F, 15.0F, -26.5F);
		rope_38.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.0F, -2.3562F);


		rope_39 = new ModelRenderer(this);
		rope_39.setPos(-37.0F, -81.7F, -19.4F);
		Sail_1.addChild(rope_39);
		setRotationAngle(rope_39, 2.5098F, -0.964F, -1.8826F);


		cube_r84 = new ModelRenderer(this);
		cube_r84.setPos(-8.5F, 37.0F, -9.5F);
		rope_39.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.0F, -1.5708F);
		cube_r84.texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(91, 2).addBox(55.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r84.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setPos(-8.5F, 3.0F, -26.5F);
		rope_39.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, 0.0F, -2.3562F);


		cube_r86 = new ModelRenderer(this);
		cube_r86.setPos(-8.5F, 15.0F, -26.5F);
		rope_39.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, 0.0F, -2.3562F);


		rope_40 = new ModelRenderer(this);
		rope_40.setPos(-21.0F, -19.0F, -24.0F);
		Sail_1.addChild(rope_40);
		setRotationAngle(rope_40, 1.8829F, -1.1671F, -1.9075F);


		cube_r87 = new ModelRenderer(this);
		cube_r87.setPos(-8.5F, 37.0F, -9.5F);
		rope_40.addChild(cube_r87);
		setRotationAngle(cube_r87, 0.0F, 0.0F, -1.5708F);
		cube_r87.texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r87.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r87.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r87.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r87.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r87.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r88 = new ModelRenderer(this);
		cube_r88.setPos(-8.5F, 3.0F, -26.5F);
		rope_40.addChild(cube_r88);
		setRotationAngle(cube_r88, 0.0F, 0.0F, -2.3562F);
		cube_r88.texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r89 = new ModelRenderer(this);
		cube_r89.setPos(-8.5F, 15.0F, -26.5F);
		rope_40.addChild(cube_r89);
		setRotationAngle(cube_r89, 0.0F, 0.0F, -2.3562F);
		cube_r89.texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_41 = new ModelRenderer(this);
		rope_41.setPos(-22.0F, -20.0F, -12.0F);
		Sail_1.addChild(rope_41);
		setRotationAngle(rope_41, 1.381F, -1.2436F, -1.6807F);


		cube_r90 = new ModelRenderer(this);
		cube_r90.setPos(-7.9251F, 37.6555F, -8.0034F);
		rope_41.addChild(cube_r90);
		setRotationAngle(cube_r90, 0.0F, 0.0F, -1.5708F);
		cube_r90.texOffs(91, 2).addBox(82.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(73.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(65.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(65.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(36.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r90.texOffs(91, 2).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r91 = new ModelRenderer(this);
		cube_r91.setPos(-7.9251F, 3.6555F, -25.0034F);
		rope_41.addChild(cube_r91);
		setRotationAngle(cube_r91, 0.0F, 0.0F, -2.3562F);
		cube_r91.texOffs(2, 21).addBox(20.8796F, 32.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r92 = new ModelRenderer(this);
		cube_r92.setPos(-7.9251F, 15.6555F, -25.0034F);
		rope_41.addChild(cube_r92);
		setRotationAngle(cube_r92, 0.0F, 0.0F, -2.3562F);
		cube_r92.texOffs(7, 29).addBox(24.1296F, 35.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_42 = new ModelRenderer(this);
		rope_42.setPos(-18.0F, -21.0F, 38.0F);
		Sail_1.addChild(rope_42);
		setRotationAngle(rope_42, 1.4399F, -1.1592F, -1.8265F);


		cube_r93 = new ModelRenderer(this);
		cube_r93.setPos(-8.5F, 37.0F, -9.5F);
		rope_42.addChild(cube_r93);
		setRotationAngle(cube_r93, 0.0F, 0.0F, -1.5708F);
		cube_r93.texOffs(91, 2).addBox(84.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(75.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(67.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(67.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(49.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r93.texOffs(91, 2).addBox(59.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r94 = new ModelRenderer(this);
		cube_r94.setPos(-8.5F, 3.0F, -26.5F);
		rope_42.addChild(cube_r94);
		setRotationAngle(cube_r94, 0.0F, 0.0F, -2.3562F);
		cube_r94.texOffs(2, 21).addBox(21.8796F, 33.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r95 = new ModelRenderer(this);
		cube_r95.setPos(-8.5F, 15.0F, -26.5F);
		rope_42.addChild(cube_r95);
		setRotationAngle(cube_r95, 0.0F, 0.0F, -2.3562F);
		cube_r95.texOffs(7, 29).addBox(25.1296F, 36.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_43 = new ModelRenderer(this);
		rope_43.setPos(34.5F, -82.5F, 23.6F);
		Sail_1.addChild(rope_43);
		setRotationAngle(rope_43, 2.2607F, 1.1274F, 1.762F);


		cube_r102 = new ModelRenderer(this);
		cube_r102.setPos(0.0F, 21.5F, 17.0F);
		rope_43.addChild(cube_r102);
		setRotationAngle(cube_r102, 0.0F, 0.0F, -1.5708F);
		cube_r102.texOffs(91, 2).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r102.texOffs(91, 2).addBox(40.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r102.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r103 = new ModelRenderer(this);
		cube_r103.setPos(0.0F, -12.5F, 0.0F);
		rope_43.addChild(cube_r103);
		setRotationAngle(cube_r103, 0.0F, 0.0F, -2.3562F);


		cube_r104 = new ModelRenderer(this);
		cube_r104.setPos(0.0F, -0.5F, 0.0F);
		rope_43.addChild(cube_r104);
		setRotationAngle(cube_r104, 0.0F, 0.0F, -2.3562F);


		rope_44 = new ModelRenderer(this);
		rope_44.setPos(34.5F, -82.5F, -18.8F);
		Sail_1.addChild(rope_44);
		setRotationAngle(rope_44, 2.18F, 1.0532F, 1.664F);


		cube_r105 = new ModelRenderer(this);
		cube_r105.setPos(0.0F, 21.5F, 17.0F);
		rope_44.addChild(cube_r105);
		setRotationAngle(cube_r105, 0.0F, 0.0F, -1.5708F);
		cube_r105.texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r105.texOffs(91, 2).addBox(38.5F, 0.5F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r105.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r106 = new ModelRenderer(this);
		cube_r106.setPos(0.0F, -12.5F, 0.0F);
		rope_44.addChild(cube_r106);
		setRotationAngle(cube_r106, 0.0F, 0.0F, -2.3562F);


		cube_r107 = new ModelRenderer(this);
		cube_r107.setPos(0.0F, -0.5F, 0.0F);
		rope_44.addChild(cube_r107);
		setRotationAngle(cube_r107, 0.0F, 0.0F, -2.3562F);


		rope_45 = new ModelRenderer(this);
		rope_45.setPos(21.5F, -19.0F, -12.5F);
		Sail_1.addChild(rope_45);
		setRotationAngle(rope_45, 1.3938F, 1.2588F, 1.6614F);


		cube_r108 = new ModelRenderer(this);
		cube_r108.setPos(0.0F, 21.5F, 17.0F);
		rope_45.addChild(cube_r108);
		setRotationAngle(cube_r108, 0.0F, 0.0F, -1.5708F);
		cube_r108.texOffs(91, 2).addBox(68.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(59.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(51.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(51.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(20.9F, -0.5F, -17.5F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r108.texOffs(91, 2).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r109 = new ModelRenderer(this);
		cube_r109.setPos(0.0F, -12.5F, 0.0F);
		rope_45.addChild(cube_r109);
		setRotationAngle(cube_r109, 0.0F, 0.0F, -2.3562F);
		cube_r109.texOffs(2, 21).addBox(16.25F, 16.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r110 = new ModelRenderer(this);
		cube_r110.setPos(0.0F, -0.5F, 0.0F);
		rope_45.addChild(cube_r110);
		setRotationAngle(cube_r110, 0.0F, 0.0F, -2.3562F);
		cube_r110.texOffs(7, 29).addBox(19.5F, 19.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_46 = new ModelRenderer(this);
		rope_46.setPos(17.5F, -21.0F, 38.5F);
		Sail_1.addChild(rope_46);
		setRotationAngle(rope_46, 1.3963F, 1.1257F, 1.7628F);


		cube_r111 = new ModelRenderer(this);
		cube_r111.setPos(0.0F, 21.5F, 17.0F);
		rope_46.addChild(cube_r111);
		setRotationAngle(cube_r111, 0.0F, 0.0F, -1.5708F);


		cube_r112 = new ModelRenderer(this);
		cube_r112.setPos(0.0F, -12.5F, 0.0F);
		rope_46.addChild(cube_r112);
		setRotationAngle(cube_r112, 0.0F, 0.0F, -2.3562F);


		cube_r113 = new ModelRenderer(this);
		cube_r113.setPos(0.0F, -0.5F, 0.0F);
		rope_46.addChild(cube_r113);
		setRotationAngle(cube_r113, 0.0F, 0.0F, -2.3562F);


		rope_47 = new ModelRenderer(this);
		rope_47.setPos(0.0F, -43.0F, -79.5F);
		Sail_1.addChild(rope_47);
		setRotationAngle(rope_47, -0.672F, 0.0F, 0.0F);


		cube_r252 = new ModelRenderer(this);
		cube_r252.setPos(0.0F, 11.5F, 17.0F);
		rope_47.addChild(cube_r252);
		setRotationAngle(cube_r252, 0.0F, 0.0F, -1.5708F);
		cube_r252.texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r252.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r253 = new ModelRenderer(this);
		cube_r253.setPos(0.0F, 11.5F, 17.0F);
		rope_47.addChild(cube_r253);
		setRotationAngle(cube_r253, 0.0F, 0.0F, -1.5708F);
		cube_r253.texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r254 = new ModelRenderer(this);
		cube_r254.setPos(0.0F, -10.5F, 0.0F);
		rope_47.addChild(cube_r254);
		setRotationAngle(cube_r254, 0.0F, 0.0F, -2.3562F);
		cube_r254.texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_19 = new ModelRenderer(this);
		segel_19.setPos(-0.2F, -59.0F, -67.0F);
		Sail_1.addChild(segel_19);
		setRotationAngle(segel_19, -0.8233F, -0.5571F, 0.5184F);
		segel_19.texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_19.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_19.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		segel_19.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r255 = new ModelRenderer(this);
		cube_r255.setPos(-0.1F, -44.0F, 0.0F);
		segel_19.addChild(cube_r255);
		setRotationAngle(cube_r255, 0.7854F, 0.0F, 0.0F);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r255.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		cube_r255.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		segel_20 = new ModelRenderer(this);
		segel_20.setPos(0.0F, -73.7376F, 28.1006F);
		Sail_1.addChild(segel_20);
		segel_20.texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		segel_20.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, 0.0F, false);
		segel_20.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		segel_20.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, 0.0F, false);

		rope_48 = new ModelRenderer(this);
		rope_48.setPos(0.0F, -48.7624F, -0.5006F);
		segel_20.addChild(rope_48);
		setRotationAngle(rope_48, -2.2427F, 0.0F, 0.0F);


		cube_r256 = new ModelRenderer(this);
		cube_r256.setPos(0.0F, 11.5F, 17.0F);
		rope_48.addChild(cube_r256);
		setRotationAngle(cube_r256, 0.0F, 0.0F, -1.5708F);
		cube_r256.texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r256.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r256.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r256.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		segel_21 = new ModelRenderer(this);
		segel_21.setPos(29.5F, -79.669F, 20.9006F);
		Sail_1.addChild(segel_21);


		cube_r257 = new ModelRenderer(this);
		cube_r257.setPos(0.0F, 3.1747F, -2.9013F);
		segel_21.addChild(cube_r257);
		setRotationAngle(cube_r257, 0.829F, 0.0F, 0.0F);
		cube_r257.texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r257.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r258 = new ModelRenderer(this);
		cube_r258.setPos(0.0F, 0.0F, 0.0F);
		segel_21.addChild(cube_r258);
		setRotationAngle(cube_r258, 0.7418F, 0.0F, 0.0F);
		cube_r258.texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r258.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r259 = new ModelRenderer(this);
		cube_r259.setPos(0.0F, 7.9249F, -6.7434F);
		segel_21.addChild(cube_r259);
		setRotationAngle(cube_r259, 1.0908F, 0.0F, 0.0F);
		cube_r259.texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r259.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_22 = new ModelRenderer(this);
		segel_22.setPos(3.0F, 0.0F, 0.0F);
		Sail_1.addChild(segel_22);


		cube_r260 = new ModelRenderer(this);
		cube_r260.setPos(26.5F, -71.7441F, 14.1572F);
		segel_22.addChild(cube_r260);
		setRotationAngle(cube_r260, 1.0908F, 0.0F, 0.0F);
		cube_r260.texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r260.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r261 = new ModelRenderer(this);
		cube_r261.setPos(26.5F, -79.4356F, -21.9095F);
		segel_22.addChild(cube_r261);
		setRotationAngle(cube_r261, 0.6545F, 0.0F, 0.0F);
		cube_r261.texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r261.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r262 = new ModelRenderer(this);
		cube_r262.setPos(26.5F, -76.4943F, 17.9993F);
		segel_22.addChild(cube_r262);
		setRotationAngle(cube_r262, 0.829F, 0.0F, 0.0F);
		cube_r262.texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r262.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_23 = new ModelRenderer(this);
		segel_23.setPos(0.0F, -114.0F, 25.0F);
		Sail_1.addChild(segel_23);


		cube_r263 = new ModelRenderer(this);
		cube_r263.setPos(-17.5F, 3.0F, -3.5F);
		segel_23.addChild(cube_r263);
		setRotationAngle(cube_r263, 1.7453F, 0.0F, 0.0F);
		cube_r263.texOffs(80, 30).addBox(20.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r263.texOffs(80, 34).addBox(9.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r263.texOffs(91, 4).addBox(-7.0F, -10.0F, -10.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r263.texOffs(80, 34).addBox(-2.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r263.texOffs(77, 8).addBox(31.0F, -10.0F, -10.0F, 12.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r264 = new ModelRenderer(this);
		cube_r264.setPos(-17.5F, 3.0F, -3.5F);
		segel_23.addChild(cube_r264);
		setRotationAngle(cube_r264, 1.2217F, 0.0F, 0.0F);
		cube_r264.texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r264.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r264.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r264.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r264.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r265 = new ModelRenderer(this);
		cube_r265.setPos(-17.5F, 3.0F, -3.5F);
		segel_23.addChild(cube_r265);
		setRotationAngle(cube_r265, 0.8727F, 0.0F, 0.0F);
		cube_r265.texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r265.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r265.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r265.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r265.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r266 = new ModelRenderer(this);
		cube_r266.setPos(-17.5F, 3.0F, -3.5F);
		segel_23.addChild(cube_r266);
		setRotationAngle(cube_r266, 0.3054F, 0.0F, 0.0F);
		cube_r266.texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r266.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r266.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r266.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r266.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_24 = new ModelRenderer(this);
		segel_24.setPos(0.0F, -112.0F, -18.0F);
		Sail_1.addChild(segel_24);
		setRotationAngle(segel_24, -0.2182F, 0.0F, 0.0F);


		cube_r267 = new ModelRenderer(this);
		cube_r267.setPos(-17.5F, 1.0F, 39.5F);
		segel_24.addChild(cube_r267);
		setRotationAngle(cube_r267, 2.0071F, 0.0F, 0.0F);
		cube_r267.texOffs(77, 21).addBox(-7.0F, -50.5F, 5.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r267.texOffs(91, 7).addBox(-2.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r267.texOffs(80, 35).addBox(9.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r267.texOffs(77, 8).addBox(20.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r267.texOffs(77, 8).addBox(31.0F, -50.5F, 5.0F, 12.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r268 = new ModelRenderer(this);
		cube_r268.setPos(-17.5F, 1.0F, 39.5F);
		segel_24.addChild(cube_r268);
		setRotationAngle(cube_r268, 1.4835F, 0.0F, 0.0F);
		cube_r268.texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r268.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r268.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r268.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r268.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r269 = new ModelRenderer(this);
		cube_r269.setPos(-17.5F, 1.0F, 39.5F);
		segel_24.addChild(cube_r269);
		setRotationAngle(cube_r269, 1.1345F, 0.0F, 0.0F);
		cube_r269.texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r269.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r269.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r269.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r269.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		cube_r270 = new ModelRenderer(this);
		cube_r270.setPos(-17.5F, 1.0F, 39.5F);
		segel_24.addChild(cube_r270);
		setRotationAngle(cube_r270, 0.5672F, 0.0F, 0.0F);
		cube_r270.texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r270.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r270.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r270.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r270.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_49 = new ModelRenderer(this);
		rope_49.setPos(0.0F, -122.5F, 20.5F);
		Sail_1.addChild(rope_49);


		cube_r271 = new ModelRenderer(this);
		cube_r271.setPos(0.0F, 0.0F, 0.0F);
		rope_49.addChild(cube_r271);
		setRotationAngle(cube_r271, -1.5708F, 0.0F, 0.0F);
		cube_r271.texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r271.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r271.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r114 = new ModelRenderer(this);
		cube_r114.setPos(54.5F, -56.8067F, 15.2895F);
		Sail_1.addChild(cube_r114);
		setRotationAngle(cube_r114, 2.0595F, 0.0F, 0.0F);
		cube_r114.texOffs(80, 33).addBox(-64.0F, -35.6933F, 29.2105F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r114.texOffs(80, 35).addBox(-77.0F, -35.6933F, 29.2105F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r114.texOffs(74, 28).addBox(-93.0F, -35.6933F, 29.2105F, 16.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r114.texOffs(80, 30).addBox(-51.0F, -35.6933F, 29.2105F, 18.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r114.texOffs(74, 34).addBox(-33.0F, -35.6933F, 29.2105F, 16.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r115 = new ModelRenderer(this);
		cube_r115.setPos(54.5F, -48.8067F, 61.2895F);
		Sail_1.addChild(cube_r115);
		setRotationAngle(cube_r115, 2.0595F, 0.0F, 0.0F);
		cube_r115.texOffs(80, 33).addBox(-64.0F, -34.6933F, 37.2105F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r115.texOffs(80, 35).addBox(-77.0F, -34.6933F, 37.2105F, 13.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r115.texOffs(74, 28).addBox(-93.0F, -34.6933F, 37.2105F, 16.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r115.texOffs(80, 30).addBox(-51.0F, -34.6933F, 37.2105F, 18.0F, 5.0F, 5.0F, 0.0F, false);
		cube_r115.texOffs(74, 34).addBox(-33.0F, -34.6933F, 37.2105F, 16.0F, 5.0F, 5.0F, 0.0F, false);

		rope_62 = new ModelRenderer(this);
		rope_62.setPos(17.5F, -21.0F, 38.5F);
		Sail_1.addChild(rope_62);
		setRotationAngle(rope_62, 1.3963F, 1.1257F, 1.7628F);


		cube_r145 = new ModelRenderer(this);
		cube_r145.setPos(0.0F, 21.5F, 17.0F);
		rope_62.addChild(cube_r145);
		setRotationAngle(cube_r145, 0.0F, 0.0F, -1.5708F);
		cube_r145.texOffs(91, 2).addBox(68.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(59.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(51.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(51.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(33.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r145.texOffs(91, 2).addBox(41.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r146 = new ModelRenderer(this);
		cube_r146.setPos(0.0F, -12.5F, 0.0F);
		rope_62.addChild(cube_r146);
		setRotationAngle(cube_r146, 0.0F, 0.0F, -2.3562F);
		cube_r146.texOffs(2, 21).addBox(16.25F, 16.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r147 = new ModelRenderer(this);
		cube_r147.setPos(0.0F, -0.5F, 0.0F);
		rope_62.addChild(cube_r147);
		setRotationAngle(cube_r147, 0.0F, 0.0F, -2.3562F);
		cube_r147.texOffs(7, 29).addBox(19.5F, 19.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		Sail_0 = new ModelRenderer(this);
		Sail_0.setPos(0.0F, 122.5F, -20.5F);
		segel_brigg.addChild(Sail_0);


		rope_50 = new ModelRenderer(this);
		rope_50.setPos(-37.0F, -81.7F, 22.6F);
		Sail_0.addChild(rope_50);
		setRotationAngle(rope_50, 2.4044F, -1.537F, -1.9596F);


		cube_r116 = new ModelRenderer(this);
		cube_r116.setPos(-8.5F, 37.0F, -9.5F);
		rope_50.addChild(cube_r116);
		setRotationAngle(cube_r116, 0.0F, 0.0F, -1.5708F);
		cube_r116.texOffs(92, 32).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r116.texOffs(92, 32).addBox(59.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r116.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r117 = new ModelRenderer(this);
		cube_r117.setPos(-8.5F, 3.0F, -26.5F);
		rope_50.addChild(cube_r117);
		setRotationAngle(cube_r117, 0.0F, 0.0F, -2.3562F);


		cube_r118 = new ModelRenderer(this);
		cube_r118.setPos(-8.5F, 15.0F, -26.5F);
		rope_50.addChild(cube_r118);
		setRotationAngle(cube_r118, 0.0F, 0.0F, -2.3562F);


		rope_51 = new ModelRenderer(this);
		rope_51.setPos(-37.0F, -81.7F, -19.4F);
		Sail_0.addChild(rope_51);
		setRotationAngle(rope_51, 2.3352F, -1.5312F, -1.8826F);


		cube_r119 = new ModelRenderer(this);
		cube_r119.setPos(-8.5F, 37.0F, -9.5F);
		rope_51.addChild(cube_r119);
		setRotationAngle(cube_r119, 0.0F, 0.0F, -1.5708F);
		cube_r119.texOffs(92, 32).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r119.texOffs(92, 32).addBox(55.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r119.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r120 = new ModelRenderer(this);
		cube_r120.setPos(-8.5F, 3.0F, -26.5F);
		rope_51.addChild(cube_r120);
		setRotationAngle(cube_r120, 0.0F, 0.0F, -2.3562F);


		cube_r121 = new ModelRenderer(this);
		cube_r121.setPos(-8.5F, 15.0F, -26.5F);
		rope_51.addChild(cube_r121);
		setRotationAngle(cube_r121, 0.0F, 0.0F, -2.3562F);


		rope_52 = new ModelRenderer(this);
		rope_52.setPos(-21.0F, -19.0F, -24.0F);
		Sail_0.addChild(rope_52);
		setRotationAngle(rope_52, 2.1931F, -1.2592F, -2.034F);


		cube_r122 = new ModelRenderer(this);
		cube_r122.setPos(-8.5F, 37.0F, -9.5F);
		rope_52.addChild(cube_r122);
		setRotationAngle(cube_r122, 0.0F, 0.0F, -1.5708F);
		cube_r122.texOffs(92, 32).addBox(84.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(92.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(75.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(67.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(67.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r122.texOffs(92, 32).addBox(52.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r123 = new ModelRenderer(this);
		cube_r123.setPos(-8.5F, 3.0F, -26.5F);
		rope_52.addChild(cube_r123);
		setRotationAngle(cube_r123, 0.0F, 0.0F, -2.3562F);
		cube_r123.texOffs(20, 23).addBox(21.8796F, 33.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r124 = new ModelRenderer(this);
		cube_r124.setPos(-8.5F, 15.0F, -26.5F);
		rope_52.addChild(cube_r124);
		setRotationAngle(cube_r124, 0.0F, 0.0F, -2.3562F);
		cube_r124.texOffs(22, 29).addBox(25.1296F, 36.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_53 = new ModelRenderer(this);
		rope_53.setPos(-22.0F, -20.0F, -12.0F);
		Sail_0.addChild(rope_53);
		setRotationAngle(rope_53, 1.381F, -1.4182F, -1.637F);


		cube_r125 = new ModelRenderer(this);
		cube_r125.setPos(-7.9251F, 37.6555F, -8.0034F);
		rope_53.addChild(cube_r125);
		setRotationAngle(cube_r125, 0.0F, 0.0F, -1.5708F);
		cube_r125.texOffs(92, 32).addBox(91.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(82.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(74.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(74.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(36.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r125.texOffs(92, 32).addBox(66.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r126 = new ModelRenderer(this);
		cube_r126.setPos(-7.9251F, 3.6555F, -25.0034F);
		rope_53.addChild(cube_r126);
		setRotationAngle(cube_r126, 0.0F, 0.0F, -2.3562F);
		cube_r126.texOffs(20, 23).addBox(26.8796F, 38.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r127 = new ModelRenderer(this);
		cube_r127.setPos(-7.9251F, 15.6555F, -25.0034F);
		rope_53.addChild(cube_r127);
		setRotationAngle(cube_r127, 0.0F, 0.0F, -2.3562F);
		cube_r127.texOffs(22, 29).addBox(30.1296F, 41.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_54 = new ModelRenderer(this);
		rope_54.setPos(-18.0F, -21.0F, 38.0F);
		Sail_0.addChild(rope_54);
		setRotationAngle(rope_54, 1.4835F, -1.3075F, -1.8265F);


		cube_r128 = new ModelRenderer(this);
		cube_r128.setPos(-8.5F, 37.0F, -9.5F);
		rope_54.addChild(cube_r128);
		setRotationAngle(cube_r128, 0.0F, 0.0F, -1.5708F);
		cube_r128.texOffs(92, 32).addBox(92.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(83.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(75.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(75.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(57.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(49.9409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r128.texOffs(92, 32).addBox(67.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r129 = new ModelRenderer(this);
		cube_r129.setPos(-8.5F, 3.0F, -26.5F);
		rope_54.addChild(cube_r129);
		setRotationAngle(cube_r129, 0.0F, 0.0F, -2.3562F);
		cube_r129.texOffs(13, 27).addBox(27.8796F, 39.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r130 = new ModelRenderer(this);
		cube_r130.setPos(-8.5F, 15.0F, -26.5F);
		rope_54.addChild(cube_r130);
		setRotationAngle(cube_r130, 0.0F, 0.0F, -2.3562F);
		cube_r130.texOffs(21, 24).addBox(31.1296F, 42.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_55 = new ModelRenderer(this);
		rope_55.setPos(34.5F, -82.5F, 23.6F);
		Sail_0.addChild(rope_55);
		setRotationAngle(rope_55, 2.1298F, 1.5201F, 1.762F);


		cube_r131 = new ModelRenderer(this);
		cube_r131.setPos(0.0F, 21.5F, 17.0F);
		rope_55.addChild(cube_r131);
		setRotationAngle(cube_r131, 0.0F, 0.0F, -1.5708F);
		cube_r131.texOffs(92, 32).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r131.texOffs(92, 32).addBox(40.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r131.texOffs(92, 32).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r132 = new ModelRenderer(this);
		cube_r132.setPos(0.0F, -12.5F, 0.0F);
		rope_55.addChild(cube_r132);
		setRotationAngle(cube_r132, 0.0F, 0.0F, -2.3562F);


		cube_r133 = new ModelRenderer(this);
		cube_r133.setPos(0.0F, -0.5F, 0.0F);
		rope_55.addChild(cube_r133);
		setRotationAngle(cube_r133, 0.0F, 0.0F, -2.3562F);


		rope_56 = new ModelRenderer(this);
		rope_56.setPos(34.5F, -82.5F, -18.8F);
		Sail_0.addChild(rope_56);
		setRotationAngle(rope_56, 2.0927F, 1.5332F, 1.664F);


		cube_r134 = new ModelRenderer(this);
		cube_r134.setPos(0.0F, 21.5F, 17.0F);
		rope_56.addChild(cube_r134);
		setRotationAngle(cube_r134, 0.0F, 0.0F, -1.5708F);
		cube_r134.texOffs(92, 32).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.texOffs(92, 32).addBox(38.5F, 0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r134.texOffs(92, 32).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r135 = new ModelRenderer(this);
		cube_r135.setPos(0.0F, -12.5F, 0.0F);
		rope_56.addChild(cube_r135);
		setRotationAngle(cube_r135, 0.0F, 0.0F, -2.3562F);


		cube_r136 = new ModelRenderer(this);
		cube_r136.setPos(0.0F, -0.5F, 0.0F);
		rope_56.addChild(cube_r136);
		setRotationAngle(cube_r136, 0.0F, 0.0F, -2.3562F);


		rope_57 = new ModelRenderer(this);
		rope_57.setPos(21.5F, -19.0F, -12.5F);
		Sail_0.addChild(rope_57);
		setRotationAngle(rope_57, 1.2719F, 1.4299F, 1.4923F);


		cube_r137 = new ModelRenderer(this);
		cube_r137.setPos(0.0F, 21.5F, 17.0F);
		rope_57.addChild(cube_r137);
		setRotationAngle(cube_r137, 0.0F, 0.0F, -1.5708F);
		cube_r137.texOffs(92, 32).addBox(77.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(68.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(60.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(60.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(20.9F, -0.5F, -17.5F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r137.texOffs(92, 32).addBox(51.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r138 = new ModelRenderer(this);
		cube_r138.setPos(0.0F, -12.5F, 0.0F);
		rope_57.addChild(cube_r138);
		setRotationAngle(cube_r138, 0.0F, 0.0F, -2.3562F);
		cube_r138.texOffs(11, 22).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r139 = new ModelRenderer(this);
		cube_r139.setPos(0.0F, -0.5F, 0.0F);
		rope_57.addChild(cube_r139);
		setRotationAngle(cube_r139, 0.0F, 0.0F, -2.3562F);
		cube_r139.texOffs(18, 27).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rope_58 = new ModelRenderer(this);
		rope_58.setPos(17.5F, -21.0F, 38.5F);
		Sail_0.addChild(rope_58);
		setRotationAngle(rope_58, 1.3963F, 1.1257F, 1.7628F);


		cube_r140 = new ModelRenderer(this);
		cube_r140.setPos(0.0F, 21.5F, 17.0F);
		rope_58.addChild(cube_r140);
		setRotationAngle(cube_r140, 0.0F, 0.0F, -1.5708F);


		cube_r141 = new ModelRenderer(this);
		cube_r141.setPos(0.0F, -12.5F, 0.0F);
		rope_58.addChild(cube_r141);
		setRotationAngle(cube_r141, 0.0F, 0.0F, -2.3562F);


		cube_r142 = new ModelRenderer(this);
		cube_r142.setPos(0.0F, -0.5F, 0.0F);
		rope_58.addChild(cube_r142);
		setRotationAngle(cube_r142, 0.0F, 0.0F, -2.3562F);


		rope_59 = new ModelRenderer(this);
		rope_59.setPos(0.0F, -43.0F, -79.5F);
		Sail_0.addChild(rope_59);
		setRotationAngle(rope_59, -0.672F, 0.0F, 0.0F);


		cube_r272 = new ModelRenderer(this);
		cube_r272.setPos(0.0F, 11.5F, 17.0F);
		rope_59.addChild(cube_r272);
		setRotationAngle(cube_r272, 0.0F, 0.0F, -1.5708F);
		cube_r272.texOffs(92, 32).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r272.texOffs(92, 32).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r273 = new ModelRenderer(this);
		cube_r273.setPos(0.0F, 11.5F, 17.0F);
		rope_59.addChild(cube_r273);
		setRotationAngle(cube_r273, 0.0F, 0.0F, -1.5708F);
		cube_r273.texOffs(92, 32).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r274 = new ModelRenderer(this);
		cube_r274.setPos(0.0F, -10.5F, 0.0F);
		rope_59.addChild(cube_r274);
		setRotationAngle(cube_r274, 0.0F, 0.0F, -2.3562F);
		cube_r274.texOffs(21, 28).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		segel_25 = new ModelRenderer(this);
		segel_25.setPos(-0.2F, -59.0F, -67.0F);
		Sail_0.addChild(segel_25);
		setRotationAngle(segel_25, -0.8233F, -0.5571F, 0.5184F);
		segel_25.texOffs(92, 32).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_25.texOffs(92, 32).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		segel_25.texOffs(92, 32).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		segel_25.texOffs(92, 32).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r275 = new ModelRenderer(this);
		cube_r275.setPos(-0.1F, -44.0F, 0.0F);
		segel_25.addChild(cube_r275);
		setRotationAngle(cube_r275, 1.309F, 0.0F, 0.0F);
		cube_r275.texOffs(92, 32).addBox(-2.3F, 8.9F, -16.0F, 3.0F, 5.0F, 10.0F, 0.0F, false);
		cube_r275.texOffs(92, 32).addBox(-2.3F, 8.9F, -24.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);
		cube_r275.texOffs(92, 32).addBox(-2.3F, 8.9F, -32.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);
		cube_r275.texOffs(92, 32).addBox(-2.3F, 8.9F, -40.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);

		cube_r276 = new ModelRenderer(this);
		cube_r276.setPos(-0.1F, -44.0F, 0.0F);
		segel_25.addChild(cube_r276);
		setRotationAngle(cube_r276, 0.7854F, 0.0F, 0.0F);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(70, 32).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(70, 32).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(75, 32).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(70, 32).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(75, 32).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(70, 32).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(92, 32).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(75, 32).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(69, 31).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(78, 32).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		cube_r276.texOffs(68, 27).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r276.texOffs(68, 27).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		segel_26 = new ModelRenderer(this);
		segel_26.setPos(0.0F, -73.7376F, 28.1006F);
		Sail_0.addChild(segel_26);
		segel_26.texOffs(92, 32).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(67, 27).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		segel_26.texOffs(70, 27).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 4.0F, 9.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		segel_26.texOffs(82, 29).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		segel_26.texOffs(92, 32).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, 0.0F, false);

		cube_r277 = new ModelRenderer(this);
		cube_r277.setPos(0.0F, 2.5686F, 21.05F);
		segel_26.addChild(cube_r277);
		setRotationAngle(cube_r277, 0.1745F, 0.0F, 0.0F);
		cube_r277.texOffs(68, 27).addBox(-2.5F, -4.5F, 15.75F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r277.texOffs(92, 32).addBox(-2.5F, -4.5F, -2.25F, 5.0F, 5.0F, 9.0F, 0.0F, false);
		cube_r277.texOffs(92, 32).addBox(-2.5F, -4.5F, 6.75F, 5.0F, 5.0F, 9.0F, 0.0F, false);
		cube_r277.texOffs(92, 32).addBox(-2.5F, -4.5F, -11.25F, 5.0F, 5.0F, 9.0F, 0.0F, false);
		cube_r277.texOffs(92, 32).addBox(-2.5F, -4.5F, -20.25F, 5.0F, 5.0F, 9.0F, 0.0F, false);

		rope_60 = new ModelRenderer(this);
		rope_60.setPos(0.0F, -48.7624F, -0.5006F);
		segel_26.addChild(rope_60);
		setRotationAngle(rope_60, -2.2427F, 0.0F, 0.0F);


		cube_r278 = new ModelRenderer(this);
		cube_r278.setPos(0.0F, 11.5F, 17.0F);
		rope_60.addChild(cube_r278);
		setRotationAngle(cube_r278, 0.0F, 0.0F, -1.5708F);
		cube_r278.texOffs(92, 32).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r278.texOffs(92, 32).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r278.texOffs(92, 32).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r278.texOffs(92, 32).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		segel_27 = new ModelRenderer(this);
		segel_27.setPos(29.5F, -79.669F, 20.9006F);
		Sail_0.addChild(segel_27);


		cube_r279 = new ModelRenderer(this);
		cube_r279.setPos(0.0F, 0.0F, 0.0F);
		segel_27.addChild(cube_r279);
		setRotationAngle(cube_r279, 0.7418F, 0.0F, 0.0F);
		cube_r279.texOffs(69, 31).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 37).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 32).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 40).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r279.texOffs(92, 40).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_28 = new ModelRenderer(this);
		segel_28.setPos(3.0F, 0.0F, 0.0F);
		Sail_0.addChild(segel_28);


		cube_r280 = new ModelRenderer(this);
		cube_r280.setPos(26.5F, -79.4356F, -21.9095F);
		segel_28.addChild(cube_r280);
		setRotationAngle(cube_r280, 0.6545F, 0.0F, 0.0F);
		cube_r280.texOffs(94, 39).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 37).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r280.texOffs(92, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_29 = new ModelRenderer(this);
		segel_29.setPos(0.0F, -114.0F, 25.0F);
		Sail_0.addChild(segel_29);


		cube_r281 = new ModelRenderer(this);
		cube_r281.setPos(-17.5F, 3.0F, -3.5F);
		segel_29.addChild(cube_r281);
		setRotationAngle(cube_r281, 1.8762F, 0.0F, 0.0F);
		cube_r281.texOffs(74, 37).addBox(-2.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r281.texOffs(92, 34).addBox(-7.0F, -44.5F, 7.5F, 5.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r281.texOffs(83, 34).addBox(9.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r281.texOffs(78, 41).addBox(20.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r281.texOffs(78, 38).addBox(31.0F, -44.5F, 7.5F, 12.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r282 = new ModelRenderer(this);
		cube_r282.setPos(-17.5F, 3.0F, -3.5F);
		segel_29.addChild(cube_r282);
		setRotationAngle(cube_r282, 1.7453F, 0.0F, 0.0F);
		cube_r282.texOffs(78, 41).addBox(20.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r282.texOffs(92, 34).addBox(9.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r282.texOffs(92, 34).addBox(-7.0F, -3.3F, -3.0F, 5.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r282.texOffs(92, 34).addBox(-2.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r282.texOffs(78, 38).addBox(31.0F, -3.3F, -3.0F, 12.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r283 = new ModelRenderer(this);
		cube_r283.setPos(-17.5F, 3.0F, -3.5F);
		segel_29.addChild(cube_r283);
		setRotationAngle(cube_r283, 0.3054F, 0.0F, 0.0F);
		cube_r283.texOffs(92, 37).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r283.texOffs(92, 37).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r283.texOffs(92, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r283.texOffs(92, 37).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r283.texOffs(92, 37).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		segel_30 = new ModelRenderer(this);
		segel_30.setPos(0.0F, -112.0F, -18.0F);
		Sail_0.addChild(segel_30);
		setRotationAngle(segel_30, -0.2182F, 0.0F, 0.0F);


		cube_r284 = new ModelRenderer(this);
		cube_r284.setPos(-17.5F, 1.0F, 39.5F);
		segel_30.addChild(cube_r284);
		setRotationAngle(cube_r284, 0.5672F, 0.0F, 0.0F);
		cube_r284.texOffs(69, 33).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r284.texOffs(92, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r284.texOffs(92, 32).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r284.texOffs(92, 32).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);
		cube_r284.texOffs(92, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, 0.0F, false);

		rope_61 = new ModelRenderer(this);
		rope_61.setPos(0.0F, -122.5F, 20.5F);
		Sail_0.addChild(rope_61);


		cube_r285 = new ModelRenderer(this);
		cube_r285.setPos(0.0F, 0.0F, 0.0F);
		rope_61.addChild(cube_r285);
		setRotationAngle(cube_r285, -1.5708F, 0.0F, 0.0F);
		cube_r285.texOffs(122, 11).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r285.texOffs(122, 11).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		cube_r285.texOffs(86, 27).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r143 = new ModelRenderer(this);
		cube_r143.setPos(54.5F, -56.8067F, 15.2895F);
		Sail_0.addChild(cube_r143);
		setRotationAngle(cube_r143, 2.0595F, 0.0F, 0.0F);
		cube_r143.texOffs(72, 39).addBox(-64.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r143.texOffs(80, 32).addBox(-77.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r143.texOffs(72, 39).addBox(-93.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r143.texOffs(69, 37).addBox(-51.0F, -25.6933F, 33.2105F, 18.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r143.texOffs(66, 45).addBox(-33.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, 0.0F, false);

		cube_r144 = new ModelRenderer(this);
		cube_r144.setPos(54.5F, -48.8067F, 61.2895F);
		Sail_0.addChild(cube_r144);
		setRotationAngle(cube_r144, 2.0595F, 0.0F, 0.0F);
		cube_r144.texOffs(72, 37).addBox(-64.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r144.texOffs(72, 37).addBox(-77.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r144.texOffs(66, 38).addBox(-93.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r144.texOffs(71, 37).addBox(-51.0F, -24.6933F, 41.8105F, 18.0F, 6.0F, 6.0F, 0.0F, false);
		cube_r144.texOffs(66, 36).addBox(-33.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, 0.0F, false);

		rope_63 = new ModelRenderer(this);
		rope_63.setPos(17.5F, -21.0F, 38.5F);
		Sail_0.addChild(rope_63);
		setRotationAngle(rope_63, 1.3722F, 1.2975F, 1.69F);


		cube_r148 = new ModelRenderer(this);
		cube_r148.setPos(0.0F, 21.5F, 17.0F);
		rope_63.addChild(cube_r148);
		setRotationAngle(cube_r148, 0.0F, 0.0F, -1.5708F);
		cube_r148.texOffs(92, 32).addBox(77.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(68.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(60.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(60.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(42.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(33.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r148.texOffs(92, 32).addBox(50.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r149 = new ModelRenderer(this);
		cube_r149.setPos(0.0F, -12.5F, 0.0F);
		rope_63.addChild(cube_r149);
		setRotationAngle(cube_r149, 0.0F, 0.0F, -2.3562F);
		cube_r149.texOffs(11, 22).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r150 = new ModelRenderer(this);
		cube_r150.setPos(0.0F, -0.5F, 0.0F);
		rope_63.addChild(cube_r150);
		setRotationAngle(cube_r150, 0.0F, 0.0F, -2.3562F);
		cube_r150.texOffs(16, 28).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
	}



	@Override
	public void setupAnim(AbstractSailShip entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int state = entityIn.getSailState();
		switch (state){
			case 0:

				this.Sail_0.visible= true;
				this.Sail_1.visible= false;
				this.Sail_2.visible= false;
				this.Sail_3.visible= false;
				this.Sail_4.visible= false;
				break;

			case 1:
				this.Sail_0.visible= false;
				this.Sail_1.visible= true;
				this.Sail_2.visible= false;
				this.Sail_3.visible= false;
				this.Sail_4.visible= false;
				break;

			case 2:
				this.Sail_0.visible= false;
				this.Sail_1.visible= false;
				this.Sail_2.visible= true;
				this.Sail_3.visible= false;
				this.Sail_4.visible= false;
				break;

			case 3:
				this.Sail_0.visible= false;
				this.Sail_1.visible= false;
				this.Sail_2.visible= false;
				this.Sail_3.visible= true;
				this.Sail_4.visible= false;
				break;

			case 4:
				this.Sail_0.visible= false;
				this.Sail_1.visible= false;
				this.Sail_2.visible= false;
				this.Sail_3.visible= false;
				this.Sail_4.visible= true;
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
		segel_brigg.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}