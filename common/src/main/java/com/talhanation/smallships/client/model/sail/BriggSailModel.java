package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class BriggSailModel extends SailModel {
	@SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, BriggEntity.ID + "_segel_model"), "main");

	private final ModelPart SegelBrigg;
	private final ModelPart segel_1;
	private final ModelPart segel_1_0;
	private final ModelPart segel_1_0_reff;
	private final ModelPart segel_30;
	private final ModelPart segel_1_1;
	private final ModelPart segel_1_1_bottom;
	private final ModelPart segel_1_2;
	private final ModelPart segel_1_2_bottom;
	private final ModelPart segel_1_3;
	private final ModelPart segel_1_3_bottom;
	private final ModelPart segel_1_4;
	private final ModelPart segel_2;
	private final ModelPart segel_2_0;
	private final ModelPart segel_2_0_reff;
	private final ModelPart segel_2_1;
	private final ModelPart segel_2_1_bottom;
	private final ModelPart segel_2_2;
	private final ModelPart segel_2_2_bottom;
	private final ModelPart segel_2_3;
	private final ModelPart segel_2_3_bottom;
	private final ModelPart segel_2_4;
	private final ModelPart segel_3;
	private final ModelPart segel_3_0;
	private final ModelPart segel_28;
	private final ModelPart cube_r143;
	private final ModelPart segel_3_1;
	private final ModelPart segel_3_1_bottom;
	private final ModelPart segel_3_2;
	private final ModelPart segel_3_2_bottom;
	private final ModelPart segel_3_3;
	private final ModelPart segel_3_3_bottom;
	private final ModelPart segel_3_4;
	private final ModelPart segel_4;
	private final ModelPart segel_4_0;
	private final ModelPart segel_27;
	private final ModelPart cube_r144;
	private final ModelPart segel_4_1;
	private final ModelPart segel_4_1_bottom;
	private final ModelPart segel_4_2;
	private final ModelPart segel_4_2_bottom;
	private final ModelPart segel_4_3;
	private final ModelPart segel_4_3_bottom;
	private final ModelPart segel_4_4;
	private final ModelPart segel_back;
	private final ModelPart rope_7;
	private final ModelPart segel_back_closed;
	private final ModelPart segel_front;
	private final ModelPart segel_front_closed;
	private final ModelPart ropes_0;
	private final ModelPart rope_50;
	private final ModelPart cube_r116;
	private final ModelPart cube_r117;
	private final ModelPart cube_r118;
	private final ModelPart rope_51;
	private final ModelPart cube_r119;
	private final ModelPart cube_r120;
	private final ModelPart cube_r121;
	private final ModelPart rope_52;
	private final ModelPart cube_r122;
	private final ModelPart cube_r123;
	private final ModelPart cube_r124;
	private final ModelPart rope_53;
	private final ModelPart cube_r125;
	private final ModelPart cube_r126;
	private final ModelPart cube_r127;
	private final ModelPart rope_54;
	private final ModelPart cube_r128;
	private final ModelPart cube_r129;
	private final ModelPart cube_r130;
	private final ModelPart rope_55;
	private final ModelPart cube_r131;
	private final ModelPart cube_r132;
	private final ModelPart cube_r133;
	private final ModelPart rope_56;
	private final ModelPart cube_r134;
	private final ModelPart cube_r135;
	private final ModelPart cube_r136;
	private final ModelPart rope_57;
	private final ModelPart cube_r137;
	private final ModelPart cube_r138;
	private final ModelPart cube_r139;
	private final ModelPart rope_58;
	private final ModelPart cube_r140;
	private final ModelPart cube_r141;
	private final ModelPart cube_r142;
	private final ModelPart rope_59;
	private final ModelPart rope_60;
	private final ModelPart rope_14;
	private final ModelPart rope_63;
	private final ModelPart cube_r148;
	private final ModelPart cube_r149;
	private final ModelPart cube_r150;
	private final ModelPart ropes_1;
	private final ModelPart rope_10_1;
	private final ModelPart cube_r14_x132;
	private final ModelPart cube_r15_x133;
	private final ModelPart cube_r16_x134;
	private final ModelPart rope_8_1;
	private final ModelPart cube_r8_x136;
	private final ModelPart cube_r9_x137;
	private final ModelPart cube_r10_x138;
	private final ModelPart rope_11_1;
	private final ModelPart cube_r17_x140;
	private final ModelPart cube_r18_x141;
	private final ModelPart cube_r19_x142;
	private final ModelPart rope_9_1;
	private final ModelPart cube_r11_x144;
	private final ModelPart cube_r12_x145;
	private final ModelPart cube_r13_x146;
	private final ModelPart rope_6_1;
	private final ModelPart cube_r5_x148;
	private final ModelPart cube_r6_x149;
	private final ModelPart cube_r7_x150;
	private final ModelPart rope_5_1;
	private final ModelPart cube_r2_x152;
	private final ModelPart cube_r3_x153;
	private final ModelPart cube_r4_x154;
	private final ModelPart rope_4_1;
	private final ModelPart cube_r99_x156;
	private final ModelPart cube_r100_x157;
	private final ModelPart cube_r101_x158;
	private final ModelPart rope_3_1;
	private final ModelPart cube_r96_x160;
	private final ModelPart cube_r97_x161;
	private final ModelPart cube_r98_x162;
	private final ModelPart ropes_2;
	private final ModelPart rope_10_2;
	private final ModelPart cube_r14_x165;
	private final ModelPart cube_r15_x166;
	private final ModelPart cube_r16_x167;
	private final ModelPart rope_8_2;
	private final ModelPart cube_r8_x169;
	private final ModelPart cube_r9_x170;
	private final ModelPart cube_r10_x171;
	private final ModelPart rope_11_2;
	private final ModelPart cube_r17_x173;
	private final ModelPart cube_r18_x174;
	private final ModelPart cube_r19_x175;
	private final ModelPart rope_9_2;
	private final ModelPart cube_r11_x177;
	private final ModelPart cube_r12_x178;
	private final ModelPart cube_r13_x179;
	private final ModelPart rope_6_2;
	private final ModelPart cube_r5_x181;
	private final ModelPart cube_r6_x182;
	private final ModelPart cube_r7_x183;
	private final ModelPart rope_5_2;
	private final ModelPart cube_r2_x185;
	private final ModelPart cube_r3_x186;
	private final ModelPart cube_r4_x187;
	private final ModelPart rope_4_2;
	private final ModelPart cube_r99_x189;
	private final ModelPart cube_r100_x190;
	private final ModelPart cube_r101_x191;
	private final ModelPart rope_3_2;
	private final ModelPart cube_r96_x193;
	private final ModelPart cube_r97_x194;
	private final ModelPart cube_r98_x195;
	private final ModelPart ropes_3;
	private final ModelPart rope_10_3;
	private final ModelPart cube_r14_x198;
	private final ModelPart cube_r15_x199;
	private final ModelPart cube_r16_x200;
	private final ModelPart rope_8_3;
	private final ModelPart cube_r8_x202;
	private final ModelPart cube_r9_x203;
	private final ModelPart cube_r10_x204;
	private final ModelPart rope_11_3;
	private final ModelPart cube_r17_x206;
	private final ModelPart cube_r18_x207;
	private final ModelPart cube_r19_x208;
	private final ModelPart rope_9_3;
	private final ModelPart cube_r11_x210;
	private final ModelPart cube_r12_x211;
	private final ModelPart cube_r13_x212;
	private final ModelPart rope_6_3;
	private final ModelPart cube_r5_x214;
	private final ModelPart cube_r6_x215;
	private final ModelPart cube_r7_x216;
	private final ModelPart rope_5_3;
	private final ModelPart cube_r2_x218;
	private final ModelPart cube_r3_x219;
	private final ModelPart cube_r4_x220;
	private final ModelPart rope_4_3;
	private final ModelPart cube_r99_x222;
	private final ModelPart cube_r100_x223;
	private final ModelPart cube_r101_x224;
	private final ModelPart rope_3_3;
	private final ModelPart cube_r96_x226;
	private final ModelPart cube_r97_x227;
	private final ModelPart cube_r98_x228;
	private final ModelPart ropes_4;
	private final ModelPart rope_11;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart rope_10;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart rope_12;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart cube_r22;
	private final ModelPart rope_6;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart rope_4;
	private final ModelPart cube_r99;
	private final ModelPart cube_r100;
	private final ModelPart cube_r101;
	private final ModelPart rope_9;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart cube_r13;
	private final ModelPart rope_8;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart rope_5;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart rope_3;
	private final ModelPart cube_r96;
	private final ModelPart cube_r97;
	private final ModelPart cube_r98;

	public BriggSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.SegelBrigg = root.getChild("SegelBrigg");
		this.segel_1 = this.SegelBrigg.getChild("segel_1");
		this.segel_1_0 = this.segel_1.getChild("segel_1_0");
		this.segel_1_0_reff = this.segel_1_0.getChild("segel_1_0_reff");
		this.segel_30 = this.segel_1_0.getChild("segel_30");
		this.segel_1_1 = this.segel_1.getChild("segel_1_1");
		this.segel_1_1_bottom = this.segel_1_1.getChild("segel_1_1_bottom");
		this.segel_1_2 = this.segel_1.getChild("segel_1_2");
		this.segel_1_2_bottom = this.segel_1_2.getChild("segel_1_2_bottom");
		this.segel_1_3 = this.segel_1.getChild("segel_1_3");
		this.segel_1_3_bottom = this.segel_1_3.getChild("segel_1_3_bottom");
		this.segel_1_4 = this.segel_1.getChild("segel_1_4");
		this.segel_2 = this.SegelBrigg.getChild("segel_2");
		this.segel_2_0 = this.segel_2.getChild("segel_2_0");
		this.segel_2_0_reff = this.segel_2_0.getChild("segel_2_0_reff");
		this.segel_2_1 = this.segel_2.getChild("segel_2_1");
		this.segel_2_1_bottom = this.segel_2_1.getChild("segel_2_1_bottom");
		this.segel_2_2 = this.segel_2.getChild("segel_2_2");
		this.segel_2_2_bottom = this.segel_2_2.getChild("segel_2_2_bottom");
		this.segel_2_3 = this.segel_2.getChild("segel_2_3");
		this.segel_2_3_bottom = this.segel_2_3.getChild("segel_2_3_bottom");
		this.segel_2_4 = this.segel_2.getChild("segel_2_4");
		this.segel_3 = this.SegelBrigg.getChild("segel_3");
		this.segel_3_0 = this.segel_3.getChild("segel_3_0");
		this.segel_28 = this.segel_3_0.getChild("segel_28");
		this.cube_r143 = this.segel_3_0.getChild("cube_r143");
		this.segel_3_1 = this.segel_3.getChild("segel_3_1");
		this.segel_3_1_bottom = this.segel_3_1.getChild("segel_3_1_bottom");
		this.segel_3_2 = this.segel_3.getChild("segel_3_2");
		this.segel_3_2_bottom = this.segel_3_2.getChild("segel_3_2_bottom");
		this.segel_3_3 = this.segel_3.getChild("segel_3_3");
		this.segel_3_3_bottom = this.segel_3_3.getChild("segel_3_3_bottom");
		this.segel_3_4 = this.segel_3.getChild("segel_3_4");
		this.segel_4 = this.SegelBrigg.getChild("segel_4");
		this.segel_4_0 = this.segel_4.getChild("segel_4_0");
		this.segel_27 = this.segel_4_0.getChild("segel_27");
		this.cube_r144 = this.segel_4_0.getChild("cube_r144");
		this.segel_4_1 = this.segel_4.getChild("segel_4_1");
		this.segel_4_1_bottom = this.segel_4_1.getChild("segel_4_1_bottom");
		this.segel_4_2 = this.segel_4.getChild("segel_4_2");
		this.segel_4_2_bottom = this.segel_4_2.getChild("segel_4_2_bottom");
		this.segel_4_3 = this.segel_4.getChild("segel_4_3");
		this.segel_4_3_bottom = this.segel_4_3.getChild("segel_4_3_bottom");
		this.segel_4_4 = this.segel_4.getChild("segel_4_4");
		this.segel_back = this.SegelBrigg.getChild("segel_back");
		this.rope_7 = this.segel_back.getChild("rope_7");
		this.segel_back_closed = this.SegelBrigg.getChild("segel_back_closed");
		this.segel_front = this.SegelBrigg.getChild("segel_front");
		this.segel_front_closed = this.SegelBrigg.getChild("segel_front_closed");
		this.ropes_0 = this.SegelBrigg.getChild("ropes_0");
		this.rope_50 = this.ropes_0.getChild("rope_50");
		this.cube_r116 = this.rope_50.getChild("cube_r116");
		this.cube_r117 = this.rope_50.getChild("cube_r117");
		this.cube_r118 = this.rope_50.getChild("cube_r118");
		this.rope_51 = this.ropes_0.getChild("rope_51");
		this.cube_r119 = this.rope_51.getChild("cube_r119");
		this.cube_r120 = this.rope_51.getChild("cube_r120");
		this.cube_r121 = this.rope_51.getChild("cube_r121");
		this.rope_52 = this.ropes_0.getChild("rope_52");
		this.cube_r122 = this.rope_52.getChild("cube_r122");
		this.cube_r123 = this.rope_52.getChild("cube_r123");
		this.cube_r124 = this.rope_52.getChild("cube_r124");
		this.rope_53 = this.ropes_0.getChild("rope_53");
		this.cube_r125 = this.rope_53.getChild("cube_r125");
		this.cube_r126 = this.rope_53.getChild("cube_r126");
		this.cube_r127 = this.rope_53.getChild("cube_r127");
		this.rope_54 = this.ropes_0.getChild("rope_54");
		this.cube_r128 = this.rope_54.getChild("cube_r128");
		this.cube_r129 = this.rope_54.getChild("cube_r129");
		this.cube_r130 = this.rope_54.getChild("cube_r130");
		this.rope_55 = this.ropes_0.getChild("rope_55");
		this.cube_r131 = this.rope_55.getChild("cube_r131");
		this.cube_r132 = this.rope_55.getChild("cube_r132");
		this.cube_r133 = this.rope_55.getChild("cube_r133");
		this.rope_56 = this.ropes_0.getChild("rope_56");
		this.cube_r134 = this.rope_56.getChild("cube_r134");
		this.cube_r135 = this.rope_56.getChild("cube_r135");
		this.cube_r136 = this.rope_56.getChild("cube_r136");
		this.rope_57 = this.ropes_0.getChild("rope_57");
		this.cube_r137 = this.rope_57.getChild("cube_r137");
		this.cube_r138 = this.rope_57.getChild("cube_r138");
		this.cube_r139 = this.rope_57.getChild("cube_r139");
		this.rope_58 = this.ropes_0.getChild("rope_58");
		this.cube_r140 = this.rope_58.getChild("cube_r140");
		this.cube_r141 = this.rope_58.getChild("cube_r141");
		this.cube_r142 = this.rope_58.getChild("cube_r142");
		this.rope_59 = this.ropes_0.getChild("rope_59");
		this.rope_60 = this.ropes_0.getChild("rope_60");
		this.rope_14 = this.ropes_0.getChild("rope_14");
		this.rope_63 = this.ropes_0.getChild("rope_63");
		this.cube_r148 = this.rope_63.getChild("cube_r148");
		this.cube_r149 = this.rope_63.getChild("cube_r149");
		this.cube_r150 = this.rope_63.getChild("cube_r150");
		this.ropes_1 = this.SegelBrigg.getChild("ropes_1");
		this.rope_10_1 = this.ropes_1.getChild("rope_10_1");
		this.cube_r14_x132 = this.rope_10_1.getChild("cube_r14_x132");
		this.cube_r15_x133 = this.rope_10_1.getChild("cube_r15_x133");
		this.cube_r16_x134 = this.rope_10_1.getChild("cube_r16_x134");
		this.rope_8_1 = this.ropes_1.getChild("rope_8_1");
		this.cube_r8_x136 = this.rope_8_1.getChild("cube_r8_x136");
		this.cube_r9_x137 = this.rope_8_1.getChild("cube_r9_x137");
		this.cube_r10_x138 = this.rope_8_1.getChild("cube_r10_x138");
		this.rope_11_1 = this.ropes_1.getChild("rope_11_1");
		this.cube_r17_x140 = this.rope_11_1.getChild("cube_r17_x140");
		this.cube_r18_x141 = this.rope_11_1.getChild("cube_r18_x141");
		this.cube_r19_x142 = this.rope_11_1.getChild("cube_r19_x142");
		this.rope_9_1 = this.ropes_1.getChild("rope_9_1");
		this.cube_r11_x144 = this.rope_9_1.getChild("cube_r11_x144");
		this.cube_r12_x145 = this.rope_9_1.getChild("cube_r12_x145");
		this.cube_r13_x146 = this.rope_9_1.getChild("cube_r13_x146");
		this.rope_6_1 = this.ropes_1.getChild("rope_6_1");
		this.cube_r5_x148 = this.rope_6_1.getChild("cube_r5_x148");
		this.cube_r6_x149 = this.rope_6_1.getChild("cube_r6_x149");
		this.cube_r7_x150 = this.rope_6_1.getChild("cube_r7_x150");
		this.rope_5_1 = this.ropes_1.getChild("rope_5_1");
		this.cube_r2_x152 = this.rope_5_1.getChild("cube_r2_x152");
		this.cube_r3_x153 = this.rope_5_1.getChild("cube_r3_x153");
		this.cube_r4_x154 = this.rope_5_1.getChild("cube_r4_x154");
		this.rope_4_1 = this.ropes_1.getChild("rope_4_1");
		this.cube_r99_x156 = this.rope_4_1.getChild("cube_r99_x156");
		this.cube_r100_x157 = this.rope_4_1.getChild("cube_r100_x157");
		this.cube_r101_x158 = this.rope_4_1.getChild("cube_r101_x158");
		this.rope_3_1 = this.ropes_1.getChild("rope_3_1");
		this.cube_r96_x160 = this.rope_3_1.getChild("cube_r96_x160");
		this.cube_r97_x161 = this.rope_3_1.getChild("cube_r97_x161");
		this.cube_r98_x162 = this.rope_3_1.getChild("cube_r98_x162");
		this.ropes_2 = this.SegelBrigg.getChild("ropes_2");
		this.rope_10_2 = this.ropes_2.getChild("rope_10_2");
		this.cube_r14_x165 = this.rope_10_2.getChild("cube_r14_x165");
		this.cube_r15_x166 = this.rope_10_2.getChild("cube_r15_x166");
		this.cube_r16_x167 = this.rope_10_2.getChild("cube_r16_x167");
		this.rope_8_2 = this.ropes_2.getChild("rope_8_2");
		this.cube_r8_x169 = this.rope_8_2.getChild("cube_r8_x169");
		this.cube_r9_x170 = this.rope_8_2.getChild("cube_r9_x170");
		this.cube_r10_x171 = this.rope_8_2.getChild("cube_r10_x171");
		this.rope_11_2 = this.ropes_2.getChild("rope_11_2");
		this.cube_r17_x173 = this.rope_11_2.getChild("cube_r17_x173");
		this.cube_r18_x174 = this.rope_11_2.getChild("cube_r18_x174");
		this.cube_r19_x175 = this.rope_11_2.getChild("cube_r19_x175");
		this.rope_9_2 = this.ropes_2.getChild("rope_9_2");
		this.cube_r11_x177 = this.rope_9_2.getChild("cube_r11_x177");
		this.cube_r12_x178 = this.rope_9_2.getChild("cube_r12_x178");
		this.cube_r13_x179 = this.rope_9_2.getChild("cube_r13_x179");
		this.rope_6_2 = this.ropes_2.getChild("rope_6_2");
		this.cube_r5_x181 = this.rope_6_2.getChild("cube_r5_x181");
		this.cube_r6_x182 = this.rope_6_2.getChild("cube_r6_x182");
		this.cube_r7_x183 = this.rope_6_2.getChild("cube_r7_x183");
		this.rope_5_2 = this.ropes_2.getChild("rope_5_2");
		this.cube_r2_x185 = this.rope_5_2.getChild("cube_r2_x185");
		this.cube_r3_x186 = this.rope_5_2.getChild("cube_r3_x186");
		this.cube_r4_x187 = this.rope_5_2.getChild("cube_r4_x187");
		this.rope_4_2 = this.ropes_2.getChild("rope_4_2");
		this.cube_r99_x189 = this.rope_4_2.getChild("cube_r99_x189");
		this.cube_r100_x190 = this.rope_4_2.getChild("cube_r100_x190");
		this.cube_r101_x191 = this.rope_4_2.getChild("cube_r101_x191");
		this.rope_3_2 = this.ropes_2.getChild("rope_3_2");
		this.cube_r96_x193 = this.rope_3_2.getChild("cube_r96_x193");
		this.cube_r97_x194 = this.rope_3_2.getChild("cube_r97_x194");
		this.cube_r98_x195 = this.rope_3_2.getChild("cube_r98_x195");
		this.ropes_3 = this.SegelBrigg.getChild("ropes_3");
		this.rope_10_3 = this.ropes_3.getChild("rope_10_3");
		this.cube_r14_x198 = this.rope_10_3.getChild("cube_r14_x198");
		this.cube_r15_x199 = this.rope_10_3.getChild("cube_r15_x199");
		this.cube_r16_x200 = this.rope_10_3.getChild("cube_r16_x200");
		this.rope_8_3 = this.ropes_3.getChild("rope_8_3");
		this.cube_r8_x202 = this.rope_8_3.getChild("cube_r8_x202");
		this.cube_r9_x203 = this.rope_8_3.getChild("cube_r9_x203");
		this.cube_r10_x204 = this.rope_8_3.getChild("cube_r10_x204");
		this.rope_11_3 = this.ropes_3.getChild("rope_11_3");
		this.cube_r17_x206 = this.rope_11_3.getChild("cube_r17_x206");
		this.cube_r18_x207 = this.rope_11_3.getChild("cube_r18_x207");
		this.cube_r19_x208 = this.rope_11_3.getChild("cube_r19_x208");
		this.rope_9_3 = this.ropes_3.getChild("rope_9_3");
		this.cube_r11_x210 = this.rope_9_3.getChild("cube_r11_x210");
		this.cube_r12_x211 = this.rope_9_3.getChild("cube_r12_x211");
		this.cube_r13_x212 = this.rope_9_3.getChild("cube_r13_x212");
		this.rope_6_3 = this.ropes_3.getChild("rope_6_3");
		this.cube_r5_x214 = this.rope_6_3.getChild("cube_r5_x214");
		this.cube_r6_x215 = this.rope_6_3.getChild("cube_r6_x215");
		this.cube_r7_x216 = this.rope_6_3.getChild("cube_r7_x216");
		this.rope_5_3 = this.ropes_3.getChild("rope_5_3");
		this.cube_r2_x218 = this.rope_5_3.getChild("cube_r2_x218");
		this.cube_r3_x219 = this.rope_5_3.getChild("cube_r3_x219");
		this.cube_r4_x220 = this.rope_5_3.getChild("cube_r4_x220");
		this.rope_4_3 = this.ropes_3.getChild("rope_4_3");
		this.cube_r99_x222 = this.rope_4_3.getChild("cube_r99_x222");
		this.cube_r100_x223 = this.rope_4_3.getChild("cube_r100_x223");
		this.cube_r101_x224 = this.rope_4_3.getChild("cube_r101_x224");
		this.rope_3_3 = this.ropes_3.getChild("rope_3_3");
		this.cube_r96_x226 = this.rope_3_3.getChild("cube_r96_x226");
		this.cube_r97_x227 = this.rope_3_3.getChild("cube_r97_x227");
		this.cube_r98_x228 = this.rope_3_3.getChild("cube_r98_x228");
		this.ropes_4 = this.SegelBrigg.getChild("ropes_4");
		this.rope_11 = this.ropes_4.getChild("rope_11");
		this.cube_r17 = this.rope_11.getChild("cube_r17");
		this.cube_r18 = this.rope_11.getChild("cube_r18");
		this.cube_r19 = this.rope_11.getChild("cube_r19");
		this.rope_10 = this.ropes_4.getChild("rope_10");
		this.cube_r14 = this.rope_10.getChild("cube_r14");
		this.cube_r15 = this.rope_10.getChild("cube_r15");
		this.cube_r16 = this.rope_10.getChild("cube_r16");
		this.rope_12 = this.ropes_4.getChild("rope_12");
		this.cube_r20 = this.rope_12.getChild("cube_r20");
		this.cube_r21 = this.rope_12.getChild("cube_r21");
		this.cube_r22 = this.rope_12.getChild("cube_r22");
		this.rope_6 = this.ropes_4.getChild("rope_6");
		this.cube_r5 = this.rope_6.getChild("cube_r5");
		this.cube_r6 = this.rope_6.getChild("cube_r6");
		this.cube_r7 = this.rope_6.getChild("cube_r7");
		this.rope_4 = this.ropes_4.getChild("rope_4");
		this.cube_r99 = this.rope_4.getChild("cube_r99");
		this.cube_r100 = this.rope_4.getChild("cube_r100");
		this.cube_r101 = this.rope_4.getChild("cube_r101");
		this.rope_9 = this.ropes_4.getChild("rope_9");
		this.cube_r11 = this.rope_9.getChild("cube_r11");
		this.cube_r12 = this.rope_9.getChild("cube_r12");
		this.cube_r13 = this.rope_9.getChild("cube_r13");
		this.rope_8 = this.ropes_4.getChild("rope_8");
		this.cube_r8 = this.rope_8.getChild("cube_r8");
		this.cube_r9 = this.rope_8.getChild("cube_r9");
		this.cube_r10 = this.rope_8.getChild("cube_r10");
		this.rope_5 = this.ropes_4.getChild("rope_5");
		this.cube_r2 = this.rope_5.getChild("cube_r2");
		this.cube_r3 = this.rope_5.getChild("cube_r3");
		this.cube_r4 = this.rope_5.getChild("cube_r4");
		this.rope_3 = this.ropes_4.getChild("rope_3");
		this.cube_r96 = this.rope_3.getChild("cube_r96");
		this.cube_r97 = this.rope_3.getChild("cube_r97");
		this.cube_r98 = this.rope_3.getChild("cube_r98");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SegelBrigg = partdefinition.addOrReplaceChild("SegelBrigg", CubeListBuilder.create(), PartPose.offsetAndRotation(11.2F, -96.75F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1 = SegelBrigg.addOrReplaceChild("segel_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.5F, -38.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition segel_1_0 = segel_1.addOrReplaceChild("segel_1_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_0_reff = segel_1_0.addOrReplaceChild("segel_1_0_reff", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 43.0F));

		PartDefinition cube_r1 = segel_1_0_reff.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(65, 13).addBox(-2.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-7.0F, -44.5F, 7.5F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 0).addBox(9.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 1).addBox(20.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 27).addBox(31.0F, -44.5F, 7.5F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.8762F, 0.0F, 0.0F));

		PartDefinition segel_30 = segel_1_0.addOrReplaceChild("segel_30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r23 = segel_30.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(65, 29).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 0).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 10).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition segel_1_1 = segel_1.addOrReplaceChild("segel_1_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r24 = segel_1_1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(97, 6).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 57).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r25 = segel_1_1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(101, 50).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition segel_1_1_bottom = segel_1_1.addOrReplaceChild("segel_1_1_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.7497F, -6.955F, 1.309F, 0.0F, 0.0F));

		PartDefinition segel_1_2 = segel_1.addOrReplaceChild("segel_1_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r26 = segel_1_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(71, 10).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(107, 5).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(96, 20).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r27 = segel_1_2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(88, 45).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(87, 45).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 41).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition segel_1_2_bottom = segel_1_2.addOrReplaceChild("segel_1_2_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.867F, -7.0442F, 1.8326F, 0.0F, 0.0F));

		PartDefinition segel_1_3 = segel_1.addOrReplaceChild("segel_1_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r28 = segel_1_3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(89, 41).addBox(-6.0F, -50.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-2.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(9.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(20.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(31.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r29 = segel_1_3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(98, 15).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.9199F, 0.0F, 0.0F));

		PartDefinition segel_1_3_bottom = segel_1_3.addOrReplaceChild("segel_1_3_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 25.3335F, -3.2186F, 2.1817F, 0.0F, 0.0F));

		PartDefinition segel_1_4 = segel_1.addOrReplaceChild("segel_1_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r30 = segel_1_4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(97, 50).addBox(-2.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(79, 43).addBox(9.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(97, 50).addBox(20.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(96, 49).addBox(31.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(97, 50).addBox(-6.0F, -49.5F, 6.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 0.75F, 39.5F, 2.2689F, 0.0F, 0.0F));

		PartDefinition segel_2 = SegelBrigg.addOrReplaceChild("segel_2", CubeListBuilder.create(), PartPose.offset(0.0F, 8.5F, 4.5F));

		PartDefinition segel_2_0 = segel_2.addOrReplaceChild("segel_2_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_2_0_reff = segel_2_0.addOrReplaceChild("segel_2_0_reff", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r31 = segel_2_0_reff.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(66, 2).addBox(20.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(67, 44).addBox(9.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(97, 42).addBox(-7.0F, -3.3F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(85, 40).addBox(-2.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(69, 39).addBox(31.0F, -3.3F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r32 = segel_2_0_reff.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(67, 9).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 9).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 43).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 46).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 9).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_2_1 = segel_2.addOrReplaceChild("segel_2_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r33 = segel_2_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(71, 10).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 10).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r34 = segel_2_1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(95, 49).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_2_1_bottom = segel_2_1.addOrReplaceChild("segel_2_1_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -2.5F, -5.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9585F, -8.9196F, 1.0472F, 0.0F, 0.0F));

		PartDefinition segel_2_2 = segel_2.addOrReplaceChild("segel_2_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r35 = segel_2_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(104, 2).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r36 = segel_2_2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(71, 10).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 9).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition segel_2_2_bottom = segel_2_2.addOrReplaceChild("segel_2_2_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0936F, -11.2173F, 1.5708F, 0.0F, 0.0F));

		PartDefinition segel_2_3 = segel_2.addOrReplaceChild("segel_2_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r37 = segel_2_3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(90, 45).addBox(20.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(9.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 9).addBox(-6.0F, -11.0F, -20.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-2.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(31.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r38 = segel_2_3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(77, 44).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition segel_2_3_bottom = segel_2_3.addOrReplaceChild("segel_2_3_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(8.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-7.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-23.5F, -1.5F, -3.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.4326F, -9.8751F, 1.9199F, 0.0F, 0.0F));

		PartDefinition segel_2_4 = segel_2.addOrReplaceChild("segel_2_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r39 = segel_2_4.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(101, 19).addBox(-6.0F, -15.75F, -21.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(9.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(20.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(31.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-2.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 2.75F, -3.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition segel_3 = SegelBrigg.addOrReplaceChild("segel_3", CubeListBuilder.create(), PartPose.offset(3.0F, 122.5F, -20.5F));

		PartDefinition segel_3_0 = segel_3.addOrReplaceChild("segel_3_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_28 = segel_3_0.addOrReplaceChild("segel_28", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r40 = segel_28.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(73, 0).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(69, 45).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 10).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(69, 45).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 9).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 9).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(69, 45).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r143 = segel_3_0.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(67, 25).addBox(-64.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(69, 33).addBox(-77.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 47).addBox(-93.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(65, 43).addBox(-51.0F, -25.6933F, 33.2105F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 52).addBox(-33.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(51.5F, -56.8067F, 15.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition segel_3_1 = segel_3.addOrReplaceChild("segel_3_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r41 = segel_3_1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(106, 5).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 44).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -71.7441F, 14.1572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r42 = segel_3_1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(102, 2).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 44).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -76.4943F, 17.9993F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r43 = segel_3_1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(68, 57).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition segel_3_1_bottom = segel_3_1.addOrReplaceChild("segel_3_1_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(14.5F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-3.5F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-21.5F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-39.5F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -69.9992F, -29.3503F, 1.2654F, 0.0F, 0.0F));

		PartDefinition segel_3_2 = segel_3.addOrReplaceChild("segel_3_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r44 = segel_3_2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(71, 10).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(102, 2).addBox(-66.0F, -43.5F, 4.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-5.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -58.7644F, 12.4338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r45 = segel_3_2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(64, 7).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -63.6813F, 12.0822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r46 = segel_3_2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(102, 2).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -68.7113F, 12.6289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition segel_3_2_bottom = segel_3_2.addOrReplaceChild("segel_3_2_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(14.5F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-3.5F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-21.5F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-39.5F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -56.0622F, -30.2453F, 1.9199F, 0.0F, 0.0F));

		PartDefinition segel_3_3 = segel_3.addOrReplaceChild("segel_3_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r47 = segel_3_3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(68, 44).addBox(-5.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(90, 45).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(102, 2).addBox(-66.0F, -39.0F, 16.6905F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -50.3067F, 14.8895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r48 = segel_3_3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(95, 49).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 45).addBox(-66.0F, -40.25F, 11.2888F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -52.4794F, 12.0112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition segel_3_3_bottom = segel_3_3.addOrReplaceChild("segel_3_3_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(14.5F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-3.5F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-21.5F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-39.5F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.2036F, -26.4982F, 2.234F, 0.0F, 0.0F));

		PartDefinition segel_3_4 = segel_3.addOrReplaceChild("segel_3_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r49 = segel_3_4.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(89, 45).addBox(-60.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-49.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-38.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-27.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-16.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(102, 2).addBox(-66.0F, -32.8929F, 27.4263F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -43.1371F, 21.8337F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r50 = segel_3_4.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(71, 9).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-5.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(102, 2).addBox(-66.0F, -34.7019F, 23.9822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -44.7281F, 17.7678F, 2.2227F, 0.0F, 0.0F));

		PartDefinition segel_4 = SegelBrigg.addOrReplaceChild("segel_4", CubeListBuilder.create(), PartPose.offset(29.5F, 42.831F, 0.4006F));

		PartDefinition segel_4_0 = segel_4.addOrReplaceChild("segel_4_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_27 = segel_4_0.addOrReplaceChild("segel_27", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r51 = segel_27.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(76, 10).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 45).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 43).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 9).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(69, 9).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 10).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(69, 9).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r144 = segel_4_0.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(68, 45).addBox(-64.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-77.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 51).addBox(-93.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(80, 42).addBox(-51.0F, -24.6933F, 41.8105F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 31).addBox(-33.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, 30.8623F, 40.3889F, 2.0595F, 0.0F, 0.0F));

		PartDefinition segel_4_1 = segel_4.addOrReplaceChild("segel_4_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r52 = segel_4_1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(80, 19).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9249F, -6.7434F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r53 = segel_4_1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(95, 50).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 45).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1747F, -2.9013F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r54 = segel_4_1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(95, 45).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 44).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 44).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition segel_4_1_bottom = segel_4_1.addOrReplaceChild("segel_4_1_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(-12.0F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-30.0F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-48.0F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-66.0F, -2.5F, -5.0F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.8131F, -7.2032F, 1.2654F, 0.0F, 0.0F));

		PartDefinition segel_4_2 = segel_4.addOrReplaceChild("segel_4_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r55 = segel_4_2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(89, 45).addBox(-49.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 45).addBox(-66.0F, -1.25F, -2.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-60.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-38.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-27.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(87, 45).addBox(-16.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.9045F, -8.4668F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r56 = segel_4_2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(95, 50).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 7).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 9).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.9877F, -8.8184F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r57 = segel_4_2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(95, 49).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9576F, -8.2717F, 1.2217F, 0.0F, 0.0F));

		PartDefinition segel_4_2_bottom = segel_4_2.addOrReplaceChild("segel_4_2_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(-12.0F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-30.0F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-48.0F, -2.0397F, -4.058F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-66.0F, -2.0F, -4.0F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.6561F, -8.2354F, 1.9199F, 0.0F, 0.0F));

		PartDefinition segel_4_3 = segel_4.addOrReplaceChild("segel_4_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r58 = segel_4_3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(71, 10).addBox(-16.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-66.0F, -1.0F, -3.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-61.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-50.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-39.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 49).addBox(-28.0F, -1.0F, -3.5F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-5.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.3623F, -6.0111F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r59 = segel_4_3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(95, 50).addBox(-49.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 45).addBox(-66.0F, 0.75F, -1.7112F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 45).addBox(-60.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 43).addBox(-38.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-27.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-16.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.1896F, -8.8894F, 1.8762F, 0.0F, 0.0F));

		PartDefinition segel_4_3_bottom = segel_4_3.addOrReplaceChild("segel_4_3_bottom", CubeListBuilder.create().texOffs(68, 0).addBox(-12.0F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-30.0F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-48.0F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-66.0F, -1.5F, -3.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 32.4526F, -4.3679F, 2.234F, 0.0F, 0.0F));

		PartDefinition segel_4_4 = segel_4.addOrReplaceChild("segel_4_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r60 = segel_4_4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(77, 44).addBox(-5.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(97, 10).addBox(-66.0F, -2.3929F, -3.0737F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 44).addBox(-60.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-49.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-38.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 50).addBox(-27.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-16.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 36.5319F, 0.9331F, 2.3562F, 0.0F, 0.0F));

		PartDefinition cube_r61 = segel_4_4.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(85, 10).addBox(-66.0F, -0.4519F, -2.0478F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-60.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-49.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 44).addBox(-38.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 49).addBox(-27.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 45).addBox(-16.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 10).addBox(-5.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 34.9409F, -3.1328F, 2.2227F, 0.0F, 0.0F));

		PartDefinition segel_back = SegelBrigg.addOrReplaceChild("segel_back", CubeListBuilder.create().texOffs(92, 42).addBox(-0.5F, -3.9314F, 7.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(89, 6).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 42).addBox(-0.5F, -5.9314F, 12.8F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 43).addBox(-0.5F, -6.9314F, 20.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(85, 37).addBox(-0.5F, -12.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(111, 16).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(85, 23).addBox(-0.5F, -16.9314F, 35.8F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(83, 21).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(84, 22).addBox(-0.5F, -11.9314F, 24.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(96, 1).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(83, 21).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(86, 24).addBox(-0.5F, -14.9314F, 31.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 42).addBox(-0.5F, -9.9314F, 20.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(102, 47).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(112, 13).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(104, 45).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(114, 0).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(68, 20).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(106, 13).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(95, 44).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(85, 19).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(111, 16).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(112, 17).addBox(-0.5F, 26.0686F, 31.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 41).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 48.7624F, 7.6006F));

		PartDefinition rope_7 = segel_back.addOrReplaceChild("rope_7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition segel_back_closed = SegelBrigg.addOrReplaceChild("segel_back_closed", CubeListBuilder.create().texOffs(109, 22).addBox(-0.5F, -3.9314F, 7.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(108, 21).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(109, 22).addBox(-0.5F, -5.9314F, 12.8F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(78, 20).addBox(-0.5F, -6.9314F, 20.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(107, 4).addBox(-0.5F, -12.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 21).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-0.5F, -16.9314F, 35.8F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(80, 26).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(81, 27).addBox(-0.5F, -11.9314F, 24.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(93, 6).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(80, 26).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(83, 29).addBox(-0.5F, -14.9314F, 31.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(109, 22).addBox(-0.5F, -9.9314F, 20.8F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(108, 21).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(108, 21).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(108, 21).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 21).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(99, 24).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(79, 21).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 48.7624F, 7.6006F));

		PartDefinition cube_r62 = segel_back_closed.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(97, 49).addBox(-2.5F, -4.5F, 15.75F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(92, 49).addBox(-2.5F, -4.5F, -2.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 49).addBox(-2.5F, -4.5F, 6.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 49).addBox(-2.5F, -4.5F, -11.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 49).addBox(-2.5F, -4.5F, -20.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5686F, 21.05F, 0.1745F, 0.0F, 0.0F));

		PartDefinition segel_front = SegelBrigg.addOrReplaceChild("segel_front", CubeListBuilder.create().texOffs(69, 0).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 0).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 0).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 0).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 63.5F, -87.5F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r63 = segel_front.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(86, 14).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(114, 3).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(118, 21).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(118, 21).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(114, 3).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(118, 21).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(114, 3).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(118, 21).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(114, 3).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(118, 21).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(114, 3).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(117, 20).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(82, 16).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(116, 16).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(116, 16).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(116, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_front_closed = SegelBrigg.addOrReplaceChild("segel_front_closed", CubeListBuilder.create().texOffs(103, 7).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 63.5F, -87.5F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r64 = segel_front_closed.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(90, 27).addBox(-2.3F, 8.9F, -16.0F, 3.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(90, 27).addBox(-2.3F, 8.9F, -24.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(90, 27).addBox(-2.3F, 8.9F, -32.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(90, 27).addBox(-2.3F, 8.9F, -40.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 1.309F, 0.0F, 0.0F));

		PartDefinition cube_r65 = segel_front_closed.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(103, 7).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 32).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 32).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(115, 12).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(90, 27).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 32).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(115, 12).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 32).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(103, 7).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(115, 12).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 31).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(90, 27).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(106, 49).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(106, 49).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition ropes_0 = SegelBrigg.addOrReplaceChild("ropes_0", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_50 = ropes_0.addOrReplaceChild("rope_50", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 1.8065F, -1.457F, -1.304F));

		PartDefinition cube_r116 = rope_50.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(1, 24).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r117 = rope_50.addOrReplaceChild("cube_r117", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r118 = rope_50.addOrReplaceChild("cube_r118", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_51 = ropes_0.addOrReplaceChild("rope_51", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 1.7548F, -1.405F, -1.2299F));

		PartDefinition cube_r119 = rope_51.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(1, 24).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(55.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 25).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(65.4409F, 7.4794F, 7.8814F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r120 = rope_51.addOrReplaceChild("cube_r120", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r121 = rope_51.addOrReplaceChild("cube_r121", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_52 = ropes_0.addOrReplaceChild("rope_52", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0F, -18.0F, -24.0F, 2.1931F, -1.2592F, -2.034F));

		PartDefinition cube_r122 = rope_52.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(1, 24).addBox(84.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(92.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(75.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(67.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(67.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(37.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(52.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r123 = rope_52.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(6, 6).addBox(21.8796F, 33.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r124 = rope_52.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(20, 1).addBox(25.1296F, 36.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_53 = ropes_0.addOrReplaceChild("rope_53", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, -20.0F, -13.0F, 1.3984F, -1.3912F, -1.6681F));

		PartDefinition cube_r125 = rope_53.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(1, 24).addBox(91.9409F, 7.4794F, 7.8814F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(82.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(74.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(74.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(36.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(66.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 37.6555F, -8.0034F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r126 = rope_53.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(8, 0).addBox(26.8796F, 38.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 3.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r127 = rope_53.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(17, 6).addBox(30.1296F, 41.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 15.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_54 = ropes_0.addOrReplaceChild("rope_54", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -20.0F, 38.0F, 1.5526F, -1.2665F, -1.8334F));

		PartDefinition cube_r128 = rope_54.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(1, 24).addBox(92.9409F, 7.4794F, 7.8814F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(83.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(75.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(75.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(57.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(49.9409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(67.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r129 = rope_54.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(8, 0).addBox(27.8796F, 39.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r130 = rope_54.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(17, 6).addBox(31.1296F, 42.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_55 = ropes_0.addOrReplaceChild("rope_55", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 1.8306F, 1.4291F, 1.3864F));

		PartDefinition cube_r131 = rope_55.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(1, 24).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(40.5F, 0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r132 = rope_55.addOrReplaceChild("cube_r132", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r133 = rope_55.addOrReplaceChild("cube_r133", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_56 = ropes_0.addOrReplaceChild("rope_56", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 1.7046F, 1.3889F, 1.2367F));

		PartDefinition cube_r134 = rope_56.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(1, 24).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(38.5F, 0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(47.5F, 0.5F, -17.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r135 = rope_56.addOrReplaceChild("cube_r135", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r136 = rope_56.addOrReplaceChild("cube_r136", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_57 = ropes_0.addOrReplaceChild("rope_57", CubeListBuilder.create(), PartPose.offsetAndRotation(23.5F, -19.0F, -10.5F, 1.4052F, 1.3489F, 1.5983F));

		PartDefinition cube_r137 = rope_57.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(1, 24).addBox(77.9F, -0.5F, -17.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(68.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(60.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(60.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(20.9F, -0.5F, -17.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(51.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r138 = rope_57.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(6, 0).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r139 = rope_57.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(15, 6).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_58 = ropes_0.addOrReplaceChild("rope_58", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3963F, 1.1257F, 1.7628F));

		PartDefinition cube_r140 = rope_58.addOrReplaceChild("cube_r140", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r141 = rope_58.addOrReplaceChild("cube_r141", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r142 = rope_58.addOrReplaceChild("cube_r142", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_59 = ropes_0.addOrReplaceChild("rope_59", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r66 = rope_59.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(13, 25).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 24).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r67 = rope_59.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(20, 1).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_60 = ropes_0.addOrReplaceChild("rope_60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -122.5F, 27.6F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r68 = rope_60.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(9, 24).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 24).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 24).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_14 = ropes_0.addOrReplaceChild("rope_14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -120.2F, 27.6F, 1.5795F, 0.0F, 0.0F));

		PartDefinition cube_r69 = rope_14.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(9, 24).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 24).addBox(50.5F, -0.5F, -16.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 24).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_63 = ropes_0.addOrReplaceChild("rope_63", CubeListBuilder.create(), PartPose.offsetAndRotation(20.5F, -20.0F, 38.5F, 1.4684F, 1.2472F, 1.716F));

		PartDefinition cube_r148 = rope_63.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(1, 24).addBox(77.5F, -0.5F, -17.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(68.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(60.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(60.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(42.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(33.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 24).addBox(50.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r149 = rope_63.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(6, 0).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r150 = rope_63.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(15, 6).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition ropes_1 = SegelBrigg.addOrReplaceChild("ropes_1", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_10_1 = ropes_1.addOrReplaceChild("rope_10_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.7959F, -0.4516F, -2.3012F));

		PartDefinition cube_r14_x132 = rope_10_1.addOrReplaceChild("cube_r14_x132", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 23).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(55.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15_x133 = rope_10_1.addOrReplaceChild("cube_r15_x133", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16_x134 = rope_10_1.addOrReplaceChild("cube_r16_x134", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_8_1 = ropes_1.addOrReplaceChild("rope_8_1", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.6584F, 0.8731F, 2.1573F));

		PartDefinition cube_r8_x136 = rope_8_1.addOrReplaceChild("cube_r8_x136", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(36.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9_x137 = rope_8_1.addOrReplaceChild("cube_r9_x137", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10_x138 = rope_8_1.addOrReplaceChild("cube_r10_x138", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_11_1 = ropes_1.addOrReplaceChild("rope_11_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.8274F, -0.4611F, -2.3633F));

		PartDefinition cube_r17_x140 = rope_11_1.addOrReplaceChild("cube_r17_x140", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 25).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(55.4409F, 7.4794F, 7.8814F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18_x141 = rope_11_1.addOrReplaceChild("cube_r18_x141", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19_x142 = rope_11_1.addOrReplaceChild("cube_r19_x142", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_9_1 = ropes_1.addOrReplaceChild("rope_9_1", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.6863F, 0.8723F, 2.231F));

		PartDefinition cube_r11_x144 = rope_9_1.addOrReplaceChild("cube_r11_x144", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(36.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12_x145 = rope_9_1.addOrReplaceChild("cube_r12_x145", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13_x146 = rope_9_1.addOrReplaceChild("cube_r13_x146", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6_1 = ropes_1.addOrReplaceChild("rope_6_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -18.0F, -12.0F, 1.3135F, -1.242F, -1.5848F));

		PartDefinition cube_r5_x148 = rope_6_1.addOrReplaceChild("cube_r5_x148", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(63.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(75.4409F, 7.4794F, 7.8814F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6_x149 = rope_6_1.addOrReplaceChild("cube_r6_x149", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7_x150 = rope_6_1.addOrReplaceChild("cube_r7_x150", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_5_1 = ropes_1.addOrReplaceChild("rope_5_1", CubeListBuilder.create(), PartPose.offsetAndRotation(23.5F, -19.0F, -10.5F, 1.4704F, 1.1991F, 1.6585F));

		PartDefinition cube_r2_x152 = rope_5_1.addOrReplaceChild("cube_r2_x152", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(45.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(54.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(63.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3_x153 = rope_5_1.addOrReplaceChild("cube_r3_x153", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4_x154 = rope_5_1.addOrReplaceChild("cube_r4_x154", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_4_1 = ropes_1.addOrReplaceChild("rope_4_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -20.0F, 38.0F, 1.4919F, -1.1097F, -1.7815F));

		PartDefinition cube_r99_x156 = rope_4_1.addOrReplaceChild("cube_r99_x156", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(64.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(76.4409F, 7.4794F, 7.8814F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100_x157 = rope_4_1.addOrReplaceChild("cube_r100_x157", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101_x158 = rope_4_1.addOrReplaceChild("cube_r101_x158", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3_1 = ropes_1.addOrReplaceChild("rope_3_1", CubeListBuilder.create(), PartPose.offsetAndRotation(20.5F, -20.0F, 38.5F, 1.4524F, 1.087F, 1.7015F));

		PartDefinition cube_r96_x160 = rope_3_1.addOrReplaceChild("cube_r96_x160", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(49.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(61.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97_x161 = rope_3_1.addOrReplaceChild("cube_r97_x161", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98_x162 = rope_3_1.addOrReplaceChild("cube_r98_x162", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition ropes_2 = SegelBrigg.addOrReplaceChild("ropes_2", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_10_2 = ropes_2.addOrReplaceChild("rope_10_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.6186F, -0.3959F, -2.0231F));

		PartDefinition cube_r14_x165 = rope_10_2.addOrReplaceChild("cube_r14_x165", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 24).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(55.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15_x166 = rope_10_2.addOrReplaceChild("cube_r15_x166", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16_x167 = rope_10_2.addOrReplaceChild("cube_r16_x167", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_8_2 = ropes_2.addOrReplaceChild("rope_8_2", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.412F, 0.7707F, 1.7934F));

		PartDefinition cube_r8_x169 = rope_8_2.addOrReplaceChild("cube_r8_x169", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(36.5F, 0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9_x170 = rope_8_2.addOrReplaceChild("cube_r9_x170", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10_x171 = rope_8_2.addOrReplaceChild("cube_r10_x171", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_11_2 = ropes_2.addOrReplaceChild("rope_11_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.6324F, -0.3931F, -2.1385F));

		PartDefinition cube_r17_x173 = rope_11_2.addOrReplaceChild("cube_r17_x173", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 25).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(55.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18_x174 = rope_11_2.addOrReplaceChild("cube_r18_x174", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19_x175 = rope_11_2.addOrReplaceChild("cube_r19_x175", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_9_2 = ropes_2.addOrReplaceChild("rope_9_2", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.4351F, 0.7594F, 1.9169F));

		PartDefinition cube_r11_x177 = rope_9_2.addOrReplaceChild("cube_r11_x177", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(36.5F, 0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12_x178 = rope_9_2.addOrReplaceChild("cube_r12_x178", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13_x179 = rope_9_2.addOrReplaceChild("cube_r13_x179", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6_2 = ropes_2.addOrReplaceChild("rope_6_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -18.0F, -12.0F, 1.3371F, -1.1354F, -1.6942F));

		PartDefinition cube_r5_x181 = rope_6_2.addOrReplaceChild("cube_r5_x181", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(63.4409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(70.4409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6_x182 = rope_6_2.addOrReplaceChild("cube_r6_x182", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7_x183 = rope_6_2.addOrReplaceChild("cube_r7_x183", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_5_2 = ropes_2.addOrReplaceChild("rope_5_2", CubeListBuilder.create(), PartPose.offsetAndRotation(23.5F, -19.0F, -10.5F, 1.4218F, 1.0719F, 1.7173F));

		PartDefinition cube_r2_x185 = rope_5_2.addOrReplaceChild("cube_r2_x185", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(45.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3_x186 = rope_5_2.addOrReplaceChild("cube_r3_x186", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4_x187 = rope_5_2.addOrReplaceChild("cube_r4_x187", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_4_2 = ropes_2.addOrReplaceChild("rope_4_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -20.0F, 38.0F, 1.4081F, -0.973F, -1.8314F));

		PartDefinition cube_r99_x189 = rope_4_2.addOrReplaceChild("cube_r99_x189", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(64.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(72.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100_x190 = rope_4_2.addOrReplaceChild("cube_r100_x190", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101_x191 = rope_4_2.addOrReplaceChild("cube_r101_x191", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3_2 = ropes_2.addOrReplaceChild("rope_3_2", CubeListBuilder.create(), PartPose.offsetAndRotation(20.5F, -20.0F, 38.5F, 1.3923F, 0.9452F, 1.7629F));

		PartDefinition cube_r96_x193 = rope_3_2.addOrReplaceChild("cube_r96_x193", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(49.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(57.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97_x194 = rope_3_2.addOrReplaceChild("cube_r97_x194", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98_x195 = rope_3_2.addOrReplaceChild("cube_r98_x195", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition ropes_3 = SegelBrigg.addOrReplaceChild("ropes_3", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_10_3 = ropes_3.addOrReplaceChild("rope_10_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.6575F, -0.223F, -1.6764F));

		PartDefinition cube_r14_x198 = rope_10_3.addOrReplaceChild("cube_r14_x198", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 25).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15_x199 = rope_10_3.addOrReplaceChild("cube_r15_x199", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16_x200 = rope_10_3.addOrReplaceChild("cube_r16_x200", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_8_3 = ropes_3.addOrReplaceChild("rope_8_3", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.5376F, 0.5321F, 1.459F));

		PartDefinition cube_r8_x202 = rope_8_3.addOrReplaceChild("cube_r8_x202", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9_x203 = rope_8_3.addOrReplaceChild("cube_r9_x203", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10_x204 = rope_8_3.addOrReplaceChild("cube_r10_x204", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_11_3 = ropes_3.addOrReplaceChild("rope_11_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.6427F, -0.2588F, -1.7494F));

		PartDefinition cube_r17_x206 = rope_11_3.addOrReplaceChild("cube_r17_x206", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 24).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18_x207 = rope_11_3.addOrReplaceChild("cube_r18_x207", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19_x208 = rope_11_3.addOrReplaceChild("cube_r19_x208", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_9_3 = ropes_3.addOrReplaceChild("rope_9_3", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.4902F, 0.5522F, 1.5292F));

		PartDefinition cube_r11_x210 = rope_9_3.addOrReplaceChild("cube_r11_x210", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(36.5F, 0.5F, -17.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12_x211 = rope_9_3.addOrReplaceChild("cube_r12_x211", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13_x212 = rope_9_3.addOrReplaceChild("cube_r13_x212", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6_3 = ropes_3.addOrReplaceChild("rope_6_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -18.0F, -12.0F, 1.1615F, -1.1693F, -1.6631F));

		PartDefinition cube_r5_x214 = rope_6_3.addOrReplaceChild("cube_r5_x214", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(63.4409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6_x215 = rope_6_3.addOrReplaceChild("cube_r6_x215", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7_x216 = rope_6_3.addOrReplaceChild("cube_r7_x216", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_5_3 = ropes_3.addOrReplaceChild("rope_5_3", CubeListBuilder.create(), PartPose.offsetAndRotation(23.5F, -19.0F, -10.5F, 1.3541F, 1.0816F, 1.7173F));

		PartDefinition cube_r2_x218 = rope_5_3.addOrReplaceChild("cube_r2_x218", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(45.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3_x219 = rope_5_3.addOrReplaceChild("cube_r3_x219", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4_x220 = rope_5_3.addOrReplaceChild("cube_r4_x220", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_4_3 = ropes_3.addOrReplaceChild("rope_4_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -20.0F, 38.0F, 1.2017F, -0.9429F, -1.6864F));

		PartDefinition cube_r99_x222 = rope_4_3.addOrReplaceChild("cube_r99_x222", CubeListBuilder.create().texOffs(14, 24).addBox(60.0264F, 6.674F, 7.7893F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(51.0264F, 6.674F, 7.7893F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 7.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 5.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(37.4409F, 6.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(65.0264F, 6.674F, 7.7893F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5533F));

		PartDefinition cube_r100_x223 = rope_4_3.addOrReplaceChild("cube_r100_x223", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101_x224 = rope_4_3.addOrReplaceChild("cube_r101_x224", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3_3 = ropes_3.addOrReplaceChild("rope_3_3", CubeListBuilder.create(), PartPose.offsetAndRotation(20.5F, -20.0F, 38.5F, 1.3176F, 0.9254F, 1.7668F));

		PartDefinition cube_r96_x226 = rope_3_3.addOrReplaceChild("cube_r96_x226", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(49.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97_x227 = rope_3_3.addOrReplaceChild("cube_r97_x227", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98_x228 = rope_3_3.addOrReplaceChild("cube_r98_x228", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition ropes_4 = SegelBrigg.addOrReplaceChild("ropes_4", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_11 = ropes_4.addOrReplaceChild("rope_11", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.6928F, -0.281F, -1.8064F));

		PartDefinition cube_r17 = rope_11.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 25).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = rope_11.addOrReplaceChild("cube_r18", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19 = rope_11.addOrReplaceChild("cube_r19", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_10 = ropes_4.addOrReplaceChild("rope_10", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.6992F, -0.256F, -1.7522F));

		PartDefinition cube_r14 = rope_10.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(14, 24).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 24).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(53.4409F, 7.4794F, 7.8814F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = rope_10.addOrReplaceChild("cube_r15", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = rope_10.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_12 = ropes_4.addOrReplaceChild("rope_12", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -19.0F, -24.0F, 1.8306F, -1.1671F, -1.9075F));

		PartDefinition cube_r20 = rope_12.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 24).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = rope_12.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(5, 8).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = rope_12.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6 = ropes_4.addOrReplaceChild("rope_6", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -18.0F, -12.0F, 1.0722F, -1.2473F, -1.6702F));

		PartDefinition cube_r5 = rope_6.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = rope_6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7 = rope_6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_4 = ropes_4.addOrReplaceChild("rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -20.0F, 38.0F, 1.2047F, -1.0087F, -1.8034F));

		PartDefinition cube_r99 = rope_4.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(14, 24).addBox(59.4409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = rope_4.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(7, 2).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101 = rope_4.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(16, 8).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_9 = ropes_4.addOrReplaceChild("rope_9", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.6317F, 0.592F, 1.6223F));

		PartDefinition cube_r11 = rope_9.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = rope_9.addOrReplaceChild("cube_r12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13 = rope_9.addOrReplaceChild("cube_r13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_8 = ropes_4.addOrReplaceChild("rope_8", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.5967F, 0.5826F, 1.5527F));

		PartDefinition cube_r8 = rope_8.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 24).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9 = rope_8.addOrReplaceChild("cube_r9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = rope_8.addOrReplaceChild("cube_r10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_5 = ropes_4.addOrReplaceChild("rope_5", CubeListBuilder.create(), PartPose.offsetAndRotation(23.5F, -19.0F, -10.5F, 1.21F, 1.1604F, 1.667F));

		PartDefinition cube_r2 = rope_5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = rope_5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = rope_5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = ropes_4.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(20.5F, -20.0F, 38.5F, 1.2173F, 0.9612F, 1.7443F));

		PartDefinition cube_r96 = rope_3.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(14, 24).addBox(43.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 24).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 26).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97 = rope_3.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(5, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98 = rope_3.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(14, 8).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override
	public void setupAnim(Ship ship, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int state = ship.getData(Ship.SAIL_STATE);
		switch (state) {
			case 0 -> {
				this.segel_1_0.visible = true;
				this.segel_1_1.visible = false;
				this.segel_1_2.visible = false;
				this.segel_1_3.visible = false;
				this.segel_1_4.visible = false;

				this.segel_1_1_bottom.visible = false;
				this.segel_1_2_bottom.visible = false;
				this.segel_1_3_bottom.visible = false;

				this.segel_2_0.visible = true;
				this.segel_2_1.visible = false;
				this.segel_2_2.visible = false;
				this.segel_2_3.visible = false;
				this.segel_2_4.visible = false;
				this.segel_2_1_bottom.visible = false;
				this.segel_2_2_bottom.visible = false;
				this.segel_2_3_bottom.visible = false;

				this.segel_3_0.visible = true;
				this.segel_3_1.visible = false;
				this.segel_3_2.visible = false;
				this.segel_3_3.visible = false;
				this.segel_3_4.visible = false;

				this.segel_3_1_bottom.visible = false;
				this.segel_3_2_bottom.visible = false;
				this.segel_3_3_bottom.visible = false;

				this.segel_4_0.visible = true;
				this.segel_4_1.visible = false;
				this.segel_4_2.visible = false;
				this.segel_4_3.visible = false;
				this.segel_4_4.visible = false;

				this.segel_4_1_bottom.visible = false;
				this.segel_4_2_bottom.visible = false;
				this.segel_4_3_bottom.visible = false;
			}
			case 1 -> {
				this.segel_1_0.visible = false;
				this.segel_1_1.visible = true;
				this.segel_1_2.visible = false;
				this.segel_1_3.visible = false;
				this.segel_1_4.visible = false;

				this.segel_1_1_bottom.visible = true;
				this.segel_1_2_bottom.visible = false;
				this.segel_1_3_bottom.visible = false;

				this.segel_2_0.visible = false;
				this.segel_2_1.visible = true;
				this.segel_2_2.visible = false;
				this.segel_2_3.visible = false;
				this.segel_2_4.visible = false;

				this.segel_2_1_bottom.visible = true;
				this.segel_2_2_bottom.visible = false;
				this.segel_2_3_bottom.visible = false;

				this.segel_3_0.visible = false;
				this.segel_3_1.visible = true;
				this.segel_3_2.visible = false;
				this.segel_3_3.visible = false;
				this.segel_3_4.visible = false;

				this.segel_3_1_bottom.visible = true;
				this.segel_3_2_bottom.visible = false;
				this.segel_3_3_bottom.visible = false;

				this.segel_4_0.visible = false;
				this.segel_4_1.visible = true;
				this.segel_4_2.visible = false;
				this.segel_4_3.visible = false;
				this.segel_4_4.visible = false;

				this.segel_4_1_bottom.visible = true;
				this.segel_4_2_bottom.visible = false;
				this.segel_4_3_bottom.visible = false;
			}
			case 2 -> {
				this.segel_1_0.visible = false;
				this.segel_1_1.visible = true;
				this.segel_1_2.visible = true;
				this.segel_1_3.visible = false;
				this.segel_1_4.visible = false;
				this.segel_1_1_bottom.visible = false;
				this.segel_1_2_bottom.visible = true;
				this.segel_1_3_bottom.visible = false;

				this.segel_2_0.visible = false;
				this.segel_2_1.visible = true;
				this.segel_2_2.visible = true;
				this.segel_2_3.visible = false;
				this.segel_2_4.visible = false;
				this.segel_2_1_bottom.visible = false;
				this.segel_2_2_bottom.visible = true;
				this.segel_2_3_bottom.visible = false;

				this.segel_3_0.visible = false;
				this.segel_3_1.visible = true;
				this.segel_3_2.visible = true;
				this.segel_3_3.visible = false;
				this.segel_3_4.visible = false;

				this.segel_3_1_bottom.visible = false;
				this.segel_3_2_bottom.visible = true;
				this.segel_3_3_bottom.visible = false;

				this.segel_4_0.visible = false;
				this.segel_4_1.visible = true;
				this.segel_4_2.visible = true;
				this.segel_4_3.visible = false;
				this.segel_4_4.visible = false;

				this.segel_4_1_bottom.visible = false;
				this.segel_4_2_bottom.visible = true;
				this.segel_4_3_bottom.visible = false;
			}
			case 3 -> {
				this.segel_1_0.visible = false;
				this.segel_1_1.visible = true;
				this.segel_1_2.visible = true;
				this.segel_1_3.visible = true;
				this.segel_1_4.visible = false;
				this.segel_1_1_bottom.visible = false;
				this.segel_1_2_bottom.visible = false;
				this.segel_1_3_bottom.visible = true;

				this.segel_2_0.visible = false;
				this.segel_2_1.visible = true;
				this.segel_2_2.visible = true;
				this.segel_2_3.visible = true;
				this.segel_2_4.visible = false;
				this.segel_2_1_bottom.visible = false;
				this.segel_2_2_bottom.visible = false;
				this.segel_2_3_bottom.visible = true;

				this.segel_3_0.visible = false;
				this.segel_3_1.visible = true;
				this.segel_3_2.visible = true;
				this.segel_3_3.visible = true;
				this.segel_3_4.visible = false;

				this.segel_3_1_bottom.visible = false;
				this.segel_3_2_bottom.visible = false;
				this.segel_3_3_bottom.visible = true;

				this.segel_4_0.visible = false;
				this.segel_4_1.visible = true;
				this.segel_4_2.visible = true;
				this.segel_4_3.visible = true;
				this.segel_4_4.visible = false;

				this.segel_4_1_bottom.visible = false;
				this.segel_4_2_bottom.visible = false;
				this.segel_4_3_bottom.visible = true;
			}
			case 4 -> {
				this.segel_1_0.visible = false;
				this.segel_1_1.visible = true;
				this.segel_1_2.visible = true;
				this.segel_1_3.visible = true;
				this.segel_1_4.visible = true;
				this.segel_1_1_bottom.visible = false;
				this.segel_1_2_bottom.visible = false;
				this.segel_1_3_bottom.visible = false;

				this.segel_2_0.visible = false;
				this.segel_2_1.visible = true;
				this.segel_2_2.visible = true;
				this.segel_2_3.visible = true;
				this.segel_2_4.visible = true;
				this.segel_2_1_bottom.visible = false;
				this.segel_2_2_bottom.visible = false;
				this.segel_2_3_bottom.visible = false;

				this.segel_3_0.visible = false;
				this.segel_3_1.visible = true;
				this.segel_3_2.visible = true;
				this.segel_3_3.visible = true;
				this.segel_3_4.visible = true;

				this.segel_3_1_bottom.visible = false;
				this.segel_3_2_bottom.visible = false;
				this.segel_3_3_bottom.visible = false;

				this.segel_4_0.visible = false;
				this.segel_4_1.visible = true;
				this.segel_4_2.visible = true;
				this.segel_4_3.visible = true;
				this.segel_4_4.visible = true;

				this.segel_4_1_bottom.visible = false;
				this.segel_4_2_bottom.visible = false;
				this.segel_4_3_bottom.visible = false;
			}
		}

		this.segel_front.visible = state != 0;
		this.segel_back.visible = state != 0;
		this.segel_front_closed.visible = state == 0;
		this.segel_back_closed.visible = state == 0;

		this.ropes_0.visible = state == 0;
		this.ropes_1.visible = state == 1;
		this.ropes_2.visible = state == 2;
		this.ropes_3.visible = state == 3;
		this.ropes_4.visible = state == 4;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		SegelBrigg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}