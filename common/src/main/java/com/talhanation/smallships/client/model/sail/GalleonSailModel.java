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

public class GalleonSailModel extends SailModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, BriggEntity.ID + "_sail_model"), "main");
	private final ModelPart GalleonSail;
	private final ModelPart rope_1;
	private final ModelPart cube_r81;
	private final ModelPart cube_r82;
	private final ModelPart cube_r83;
	private final ModelPart rope_2;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart rope_3;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart rope_back_sail_1;
	private final ModelPart cube_r1;
	private final ModelPart cube_r59;
	private final ModelPart cube_r60;
	private final ModelPart rope_back_sail_2;
	private final ModelPart cube_r61;
	private final ModelPart cube_r62;
	private final ModelPart cube_r63;
	private final ModelPart rope_back_sail_3;
	private final ModelPart cube_r64;
	private final ModelPart cube_r65;
	private final ModelPart cube_r66;
	private final ModelPart rope_back_sail_4;
	private final ModelPart cube_r67;
	private final ModelPart cube_r68;
	private final ModelPart cube_r69;
	private final ModelPart sail_main_rope_right_1;
	private final ModelPart cube_r23;
	private final ModelPart cube_r24;
	private final ModelPart cube_r25;
	private final ModelPart sail_main_rope_right_2;
	private final ModelPart cube_r26;
	private final ModelPart cube_r27;
	private final ModelPart cube_r28;
	private final ModelPart sail_main_rope_right_3;
	private final ModelPart cube_r29;
	private final ModelPart cube_r30;
	private final ModelPart cube_r31;
	private final ModelPart sail_main_rope_right_4;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart sail_main_rope_left_1;
	private final ModelPart cube_r32;
	private final ModelPart cube_r33;
	private final ModelPart cube_r34;
	private final ModelPart sail_main_rope_left_2;
	private final ModelPart cube_r35;
	private final ModelPart cube_r36;
	private final ModelPart cube_r37;
	private final ModelPart sail_main_rope_left_3;
	private final ModelPart cube_r38;
	private final ModelPart cube_r39;
	private final ModelPart cube_r40;
	private final ModelPart sail_main_rope_left_4;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart sail_front_rope_right_1;
	private final ModelPart cube_r41;
	private final ModelPart cube_r42;
	private final ModelPart cube_r43;
	private final ModelPart sail_front_rope_right_2;
	private final ModelPart cube_r44;
	private final ModelPart cube_r45;
	private final ModelPart cube_r46;
	private final ModelPart sail_front_rope_right_3;
	private final ModelPart cube_r47;
	private final ModelPart cube_r48;
	private final ModelPart cube_r49;
	private final ModelPart sail_front_rope_right_4;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart sail_front_rope_left_1;
	private final ModelPart cube_r50;
	private final ModelPart cube_r51;
	private final ModelPart cube_r52;
	private final ModelPart sail_front_rope_left_2;
	private final ModelPart cube_r53;
	private final ModelPart cube_r54;
	private final ModelPart cube_r55;
	private final ModelPart sail_front_rope_left_3;
	private final ModelPart cube_r56;
	private final ModelPart cube_r57;
	private final ModelPart cube_r58;
	private final ModelPart sail_front_rope_left_4;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart cube_r22;
	private final ModelPart sail_front_top;
	private final ModelPart sail_front_top_1;
	private final ModelPart sail_front_top_1_bottom;
	private final ModelPart sail_front_top_2;
	private final ModelPart sail_front_top_2_bottom;
	private final ModelPart sail_front_top_3;
	private final ModelPart sail_front_top_3_bottom;
	private final ModelPart sail_front_top_4;
	private final ModelPart sail_front_top_0;
	private final ModelPart sail_front_top_0_bottom;
	private final ModelPart sail_main;
	private final ModelPart sail_main_1;
	private final ModelPart sail_main_1_bottom;
	private final ModelPart sail_main_2;
	private final ModelPart sail_main_2_bottom;
	private final ModelPart sail_main_3;
	private final ModelPart sail_main_3_bottom;
	private final ModelPart sail_main_4;
	private final ModelPart sail_main_0;
	private final ModelPart sail_main_0_bottom;
	private final ModelPart sail_main_top;
	private final ModelPart sail_main_top_1;
	private final ModelPart sail_main_top_1_bottom;
	private final ModelPart sail_main_top_2;
	private final ModelPart sail_main_top_2_bottom;
	private final ModelPart sail_main_top_3;
	private final ModelPart sail_main_top_3_bottom;
	private final ModelPart sail_main_top_4;
	private final ModelPart sail_main_top_0;
	private final ModelPart sail_main_top_0_bottom;
	private final ModelPart sail_front;
	private final ModelPart sail_front_1;
	private final ModelPart sail_front_1_bottom;
	private final ModelPart sail_front_2;
	private final ModelPart sail_front_2_bottom;
	private final ModelPart sail_front_3;
	private final ModelPart sail_front_3_bottom;
	private final ModelPart sail_front_4;
	private final ModelPart sail_front_0;
	private final ModelPart sail_front_0_bottom;
	private final ModelPart sail_back;
	private final ModelPart sail_back_4;
	private final ModelPart Base1;
	private final ModelPart Base2;
	private final ModelPart Base3;
	private final ModelPart Base4;
	private final ModelPart Base5;
	private final ModelPart Base6;
	private final ModelPart Base7;
	private final ModelPart Base8;
	private final ModelPart Base9;
	private final ModelPart Base10;
	private final ModelPart Base11;
	private final ModelPart Base12;
	private final ModelPart Base13;
	private final ModelPart sail_back_3;
	private final ModelPart Base14;
	private final ModelPart Base15;
	private final ModelPart Base16;
	private final ModelPart Base17;
	private final ModelPart Base18;
	private final ModelPart Base19;
	private final ModelPart Base20;
	private final ModelPart Base21;
	private final ModelPart Base22;
	private final ModelPart Base23;
	private final ModelPart sail_back_3_bottom;
	private final ModelPart Base24;
	private final ModelPart Base25;
	private final ModelPart Base26;
	private final ModelPart sail_back_2;
	private final ModelPart Base27;
	private final ModelPart Base28;
	private final ModelPart Base29;
	private final ModelPart Base30;
	private final ModelPart Base31;
	private final ModelPart Base32;
	private final ModelPart Base33;
	private final ModelPart sail_back_2_bottom;
	private final ModelPart Base34;
	private final ModelPart Base35;
	private final ModelPart sail_back_1;
	private final ModelPart Base36;
	private final ModelPart Base37;
	private final ModelPart Base38;
	private final ModelPart Base39;
	private final ModelPart sail_back_1_bottom;
	private final ModelPart Base40;
	private final ModelPart sail_back_0;
	private final ModelPart sail_back_0_bottom;
	private final ModelPart rope_sail_main_top_1_1;
	private final ModelPart rope_sail_main_top_2_1;
	private final ModelPart rope_sail_main_top_3_1;
	private final ModelPart rope_sail_main_top_4_1;
	private final ModelPart rope_sail_front_top_1_1;
	private final ModelPart rope_sail_front_top_2_1;
	private final ModelPart rope_sail_front_top_3_1;
	private final ModelPart rope_sail_front_top_4_1;
	private final ModelPart rope_sail_main_top_1_2;
	private final ModelPart rope_sail_main_top_2_2;
	private final ModelPart rope_sail_main_top_3_2;
	private final ModelPart rope_sail_main_top_4_2;
	private final ModelPart rope_sail_front_top_1_2;
	private final ModelPart rope_sail_front_top_2_2;
	private final ModelPart rope_sail_front_top_3_2;
	private final ModelPart rope_sail_front_top_4_2;
	public GalleonSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.GalleonSail = root.getChild("GalleonSail");
		this.rope_1 = this.GalleonSail.getChild("rope_1");
		this.cube_r81 = this.rope_1.getChild("cube_r81");
		this.cube_r82 = this.rope_1.getChild("cube_r82");
		this.cube_r83 = this.rope_1.getChild("cube_r83");
		this.rope_2 = this.GalleonSail.getChild("rope_2");
		this.cube_r2 = this.rope_2.getChild("cube_r2");
		this.cube_r3 = this.rope_2.getChild("cube_r3");
		this.cube_r4 = this.rope_2.getChild("cube_r4");
		this.rope_3 = this.GalleonSail.getChild("rope_3");
		this.cube_r5 = this.rope_3.getChild("cube_r5");
		this.cube_r6 = this.rope_3.getChild("cube_r6");
		this.cube_r7 = this.rope_3.getChild("cube_r7");
		this.rope_back_sail_1 = this.GalleonSail.getChild("rope_back_sail_1");
		this.cube_r1 = this.rope_back_sail_1.getChild("cube_r1");
		this.cube_r59 = this.rope_back_sail_1.getChild("cube_r59");
		this.cube_r60 = this.rope_back_sail_1.getChild("cube_r60");
		this.rope_back_sail_2 = this.GalleonSail.getChild("rope_back_sail_2");
		this.cube_r61 = this.rope_back_sail_2.getChild("cube_r61");
		this.cube_r62 = this.rope_back_sail_2.getChild("cube_r62");
		this.cube_r63 = this.rope_back_sail_2.getChild("cube_r63");
		this.rope_back_sail_3 = this.GalleonSail.getChild("rope_back_sail_3");
		this.cube_r64 = this.rope_back_sail_3.getChild("cube_r64");
		this.cube_r65 = this.rope_back_sail_3.getChild("cube_r65");
		this.cube_r66 = this.rope_back_sail_3.getChild("cube_r66");
		this.rope_back_sail_4 = this.GalleonSail.getChild("rope_back_sail_4");
		this.cube_r67 = this.rope_back_sail_4.getChild("cube_r67");
		this.cube_r68 = this.rope_back_sail_4.getChild("cube_r68");
		this.cube_r69 = this.rope_back_sail_4.getChild("cube_r69");
		this.sail_main_rope_right_1 = this.GalleonSail.getChild("sail_main_rope_right_1");
		this.cube_r23 = this.sail_main_rope_right_1.getChild("cube_r23");
		this.cube_r24 = this.sail_main_rope_right_1.getChild("cube_r24");
		this.cube_r25 = this.sail_main_rope_right_1.getChild("cube_r25");
		this.sail_main_rope_right_2 = this.GalleonSail.getChild("sail_main_rope_right_2");
		this.cube_r26 = this.sail_main_rope_right_2.getChild("cube_r26");
		this.cube_r27 = this.sail_main_rope_right_2.getChild("cube_r27");
		this.cube_r28 = this.sail_main_rope_right_2.getChild("cube_r28");
		this.sail_main_rope_right_3 = this.GalleonSail.getChild("sail_main_rope_right_3");
		this.cube_r29 = this.sail_main_rope_right_3.getChild("cube_r29");
		this.cube_r30 = this.sail_main_rope_right_3.getChild("cube_r30");
		this.cube_r31 = this.sail_main_rope_right_3.getChild("cube_r31");
		this.sail_main_rope_right_4 = this.GalleonSail.getChild("sail_main_rope_right_4");
		this.cube_r8 = this.sail_main_rope_right_4.getChild("cube_r8");
		this.cube_r9 = this.sail_main_rope_right_4.getChild("cube_r9");
		this.cube_r10 = this.sail_main_rope_right_4.getChild("cube_r10");
		this.sail_main_rope_left_1 = this.GalleonSail.getChild("sail_main_rope_left_1");
		this.cube_r32 = this.sail_main_rope_left_1.getChild("cube_r32");
		this.cube_r33 = this.sail_main_rope_left_1.getChild("cube_r33");
		this.cube_r34 = this.sail_main_rope_left_1.getChild("cube_r34");
		this.sail_main_rope_left_2 = this.GalleonSail.getChild("sail_main_rope_left_2");
		this.cube_r35 = this.sail_main_rope_left_2.getChild("cube_r35");
		this.cube_r36 = this.sail_main_rope_left_2.getChild("cube_r36");
		this.cube_r37 = this.sail_main_rope_left_2.getChild("cube_r37");
		this.sail_main_rope_left_3 = this.GalleonSail.getChild("sail_main_rope_left_3");
		this.cube_r38 = this.sail_main_rope_left_3.getChild("cube_r38");
		this.cube_r39 = this.sail_main_rope_left_3.getChild("cube_r39");
		this.cube_r40 = this.sail_main_rope_left_3.getChild("cube_r40");
		this.sail_main_rope_left_4 = this.GalleonSail.getChild("sail_main_rope_left_4");
		this.cube_r14 = this.sail_main_rope_left_4.getChild("cube_r14");
		this.cube_r15 = this.sail_main_rope_left_4.getChild("cube_r15");
		this.cube_r16 = this.sail_main_rope_left_4.getChild("cube_r16");
		this.sail_front_rope_right_1 = this.GalleonSail.getChild("sail_front_rope_right_1");
		this.cube_r41 = this.sail_front_rope_right_1.getChild("cube_r41");
		this.cube_r42 = this.sail_front_rope_right_1.getChild("cube_r42");
		this.cube_r43 = this.sail_front_rope_right_1.getChild("cube_r43");
		this.sail_front_rope_right_2 = this.GalleonSail.getChild("sail_front_rope_right_2");
		this.cube_r44 = this.sail_front_rope_right_2.getChild("cube_r44");
		this.cube_r45 = this.sail_front_rope_right_2.getChild("cube_r45");
		this.cube_r46 = this.sail_front_rope_right_2.getChild("cube_r46");
		this.sail_front_rope_right_3 = this.GalleonSail.getChild("sail_front_rope_right_3");
		this.cube_r47 = this.sail_front_rope_right_3.getChild("cube_r47");
		this.cube_r48 = this.sail_front_rope_right_3.getChild("cube_r48");
		this.cube_r49 = this.sail_front_rope_right_3.getChild("cube_r49");
		this.sail_front_rope_right_4 = this.GalleonSail.getChild("sail_front_rope_right_4");
		this.cube_r17 = this.sail_front_rope_right_4.getChild("cube_r17");
		this.cube_r18 = this.sail_front_rope_right_4.getChild("cube_r18");
		this.cube_r19 = this.sail_front_rope_right_4.getChild("cube_r19");
		this.sail_front_rope_left_1 = this.GalleonSail.getChild("sail_front_rope_left_1");
		this.cube_r50 = this.sail_front_rope_left_1.getChild("cube_r50");
		this.cube_r51 = this.sail_front_rope_left_1.getChild("cube_r51");
		this.cube_r52 = this.sail_front_rope_left_1.getChild("cube_r52");
		this.sail_front_rope_left_2 = this.GalleonSail.getChild("sail_front_rope_left_2");
		this.cube_r53 = this.sail_front_rope_left_2.getChild("cube_r53");
		this.cube_r54 = this.sail_front_rope_left_2.getChild("cube_r54");
		this.cube_r55 = this.sail_front_rope_left_2.getChild("cube_r55");
		this.sail_front_rope_left_3 = this.GalleonSail.getChild("sail_front_rope_left_3");
		this.cube_r56 = this.sail_front_rope_left_3.getChild("cube_r56");
		this.cube_r57 = this.sail_front_rope_left_3.getChild("cube_r57");
		this.cube_r58 = this.sail_front_rope_left_3.getChild("cube_r58");
		this.sail_front_rope_left_4 = this.GalleonSail.getChild("sail_front_rope_left_4");
		this.cube_r20 = this.sail_front_rope_left_4.getChild("cube_r20");
		this.cube_r21 = this.sail_front_rope_left_4.getChild("cube_r21");
		this.cube_r22 = this.sail_front_rope_left_4.getChild("cube_r22");
		this.sail_front_top = this.GalleonSail.getChild("sail_front_top");
		this.sail_front_top_1 = this.sail_front_top.getChild("sail_front_top_1");
		this.sail_front_top_1_bottom = this.sail_front_top_1.getChild("sail_front_top_1_bottom");
		this.sail_front_top_2 = this.sail_front_top.getChild("sail_front_top_2");
		this.sail_front_top_2_bottom = this.sail_front_top_2.getChild("sail_front_top_2_bottom");
		this.sail_front_top_3 = this.sail_front_top.getChild("sail_front_top_3");
		this.sail_front_top_3_bottom = this.sail_front_top_3.getChild("sail_front_top_3_bottom");
		this.sail_front_top_4 = this.sail_front_top.getChild("sail_front_top_4");
		this.sail_front_top_0 = this.sail_front_top.getChild("sail_front_top_0");
		this.sail_front_top_0_bottom = this.sail_front_top_0.getChild("sail_front_top_0_bottom");
		this.sail_main = this.GalleonSail.getChild("sail_main");
		this.sail_main_1 = this.sail_main.getChild("sail_main_1");
		this.sail_main_1_bottom = this.sail_main_1.getChild("sail_main_1_bottom");
		this.sail_main_2 = this.sail_main.getChild("sail_main_2");
		this.sail_main_2_bottom = this.sail_main_2.getChild("sail_main_2_bottom");
		this.sail_main_3 = this.sail_main.getChild("sail_main_3");
		this.sail_main_3_bottom = this.sail_main_3.getChild("sail_main_3_bottom");
		this.sail_main_4 = this.sail_main.getChild("sail_main_4");
		this.sail_main_0 = this.sail_main.getChild("sail_main_0");
		this.sail_main_0_bottom = this.sail_main_0.getChild("sail_main_0_bottom");
		this.sail_main_top = this.GalleonSail.getChild("sail_main_top");
		this.sail_main_top_1 = this.sail_main_top.getChild("sail_main_top_1");
		this.sail_main_top_1_bottom = this.sail_main_top_1.getChild("sail_main_top_1_bottom");
		this.sail_main_top_2 = this.sail_main_top.getChild("sail_main_top_2");
		this.sail_main_top_2_bottom = this.sail_main_top_2.getChild("sail_main_top_2_bottom");
		this.sail_main_top_3 = this.sail_main_top.getChild("sail_main_top_3");
		this.sail_main_top_3_bottom = this.sail_main_top_3.getChild("sail_main_top_3_bottom");
		this.sail_main_top_4 = this.sail_main_top.getChild("sail_main_top_4");
		this.sail_main_top_0 = this.sail_main_top.getChild("sail_main_top_0");
		this.sail_main_top_0_bottom = this.sail_main_top_0.getChild("sail_main_top_0_bottom");
		this.sail_front = this.GalleonSail.getChild("sail_front");
		this.sail_front_1 = this.sail_front.getChild("sail_front_1");
		this.sail_front_1_bottom = this.sail_front_1.getChild("sail_front_1_bottom");
		this.sail_front_2 = this.sail_front.getChild("sail_front_2");
		this.sail_front_2_bottom = this.sail_front_2.getChild("sail_front_2_bottom");
		this.sail_front_3 = this.sail_front.getChild("sail_front_3");
		this.sail_front_3_bottom = this.sail_front_3.getChild("sail_front_3_bottom");
		this.sail_front_4 = this.sail_front.getChild("sail_front_4");
		this.sail_front_0 = this.sail_front.getChild("sail_front_0");
		this.sail_front_0_bottom = this.sail_front_0.getChild("sail_front_0_bottom");
		this.sail_back = this.GalleonSail.getChild("sail_back");
		this.sail_back_4 = this.sail_back.getChild("sail_back_4");
		this.Base1 = this.sail_back_4.getChild("Base1");
		this.Base2 = this.Base1.getChild("Base2");
		this.Base3 = this.Base2.getChild("Base3");
		this.Base4 = this.Base3.getChild("Base4");
		this.Base5 = this.sail_back_4.getChild("Base5");
		this.Base6 = this.Base5.getChild("Base6");
		this.Base7 = this.Base6.getChild("Base7");
		this.Base8 = this.sail_back_4.getChild("Base8");
		this.Base9 = this.Base8.getChild("Base9");
		this.Base10 = this.Base9.getChild("Base10");
		this.Base11 = this.sail_back_4.getChild("Base11");
		this.Base12 = this.Base11.getChild("Base12");
		this.Base13 = this.Base12.getChild("Base13");
		this.sail_back_3 = this.sail_back.getChild("sail_back_3");
		this.Base14 = this.sail_back_3.getChild("Base14");
		this.Base15 = this.Base14.getChild("Base15");
		this.Base16 = this.Base15.getChild("Base16");
		this.Base17 = this.sail_back_3.getChild("Base17");
		this.Base18 = this.Base17.getChild("Base18");
		this.Base19 = this.Base18.getChild("Base19");
		this.Base20 = this.sail_back_3.getChild("Base20");
		this.Base21 = this.Base20.getChild("Base21");
		this.Base22 = this.sail_back_3.getChild("Base22");
		this.Base23 = this.Base22.getChild("Base23");
		this.sail_back_3_bottom = this.sail_back_3.getChild("sail_back_3_bottom");
		this.Base24 = this.sail_back_3_bottom.getChild("Base24");
		this.Base25 = this.Base24.getChild("Base25");
		this.Base26 = this.Base25.getChild("Base26");
		this.sail_back_2 = this.sail_back.getChild("sail_back_2");
		this.Base27 = this.sail_back_2.getChild("Base27");
		this.Base28 = this.Base27.getChild("Base28");
		this.Base29 = this.sail_back_2.getChild("Base29");
		this.Base30 = this.Base29.getChild("Base30");
		this.Base31 = this.sail_back_2.getChild("Base31");
		this.Base32 = this.Base31.getChild("Base32");
		this.Base33 = this.sail_back_2.getChild("Base33");
		this.sail_back_2_bottom = this.sail_back_2.getChild("sail_back_2_bottom");
		this.Base34 = this.sail_back_2_bottom.getChild("Base34");
		this.Base35 = this.Base34.getChild("Base35");
		this.sail_back_1 = this.sail_back.getChild("sail_back_1");
		this.Base36 = this.sail_back_1.getChild("Base36");
		this.Base37 = this.sail_back_1.getChild("Base37");
		this.Base38 = this.sail_back_1.getChild("Base38");
		this.Base39 = this.sail_back_1.getChild("Base39");
		this.sail_back_1_bottom = this.sail_back_1.getChild("sail_back_1_bottom");
		this.Base40 = this.sail_back_1_bottom.getChild("Base40");
		this.sail_back_0 = this.sail_back.getChild("sail_back_0");
		this.sail_back_0_bottom = this.sail_back_0.getChild("sail_back_0_bottom");
		this.rope_sail_main_top_1_1 = this.GalleonSail.getChild("rope_sail_main_top_1_1");
		this.rope_sail_main_top_2_1 = this.GalleonSail.getChild("rope_sail_main_top_2_1");
		this.rope_sail_main_top_3_1 = this.GalleonSail.getChild("rope_sail_main_top_3_1");
		this.rope_sail_main_top_4_1 = this.GalleonSail.getChild("rope_sail_main_top_4_1");
		this.rope_sail_front_top_1_1 = this.GalleonSail.getChild("rope_sail_front_top_1_1");
		this.rope_sail_front_top_2_1 = this.GalleonSail.getChild("rope_sail_front_top_2_1");
		this.rope_sail_front_top_3_1 = this.GalleonSail.getChild("rope_sail_front_top_3_1");
		this.rope_sail_front_top_4_1 = this.GalleonSail.getChild("rope_sail_front_top_4_1");
		this.rope_sail_main_top_1_2 = this.GalleonSail.getChild("rope_sail_main_top_1_2");
		this.rope_sail_main_top_2_2 = this.GalleonSail.getChild("rope_sail_main_top_2_2");
		this.rope_sail_main_top_3_2 = this.GalleonSail.getChild("rope_sail_main_top_3_2");
		this.rope_sail_main_top_4_2 = this.GalleonSail.getChild("rope_sail_main_top_4_2");
		this.rope_sail_front_top_1_2 = this.GalleonSail.getChild("rope_sail_front_top_1_2");
		this.rope_sail_front_top_2_2 = this.GalleonSail.getChild("rope_sail_front_top_2_2");
		this.rope_sail_front_top_3_2 = this.GalleonSail.getChild("rope_sail_front_top_3_2");
		this.rope_sail_front_top_4_2 = this.GalleonSail.getChild("rope_sail_front_top_4_2");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition GalleonSail = partdefinition.addOrReplaceChild("GalleonSail", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.9642F, -52.718F, -0.1733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rope_1 = GalleonSail.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5358F, 28.718F, -103.8267F, -0.576F, 0.0F, 0.0F));

		PartDefinition cube_r81 = rope_1.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(12, 24).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 24).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 25).addBox(1.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 25).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 25).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 26).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 25).addBox(94.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 24).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 25).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 24).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r82 = rope_1.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(6, 4).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r83 = rope_1.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(20, 6).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = GalleonSail.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5358F, -40.282F, 67.1733F, 0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r2 = rope_2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(9, 26).addBox(20.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 26).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 26).addBox(1.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 26).addBox(35.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 26).addBox(50.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 26).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = rope_2.addOrReplaceChild("cube_r3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = rope_2.addOrReplaceChild("cube_r4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = GalleonSail.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5358F, -77.482F, 14.1733F, 1.7628F, 0.0F, 0.0F));

		PartDefinition cube_r5 = rope_3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 24).addBox(20.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 27).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 26).addBox(1.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 25).addBox(35.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 25).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = rope_3.addOrReplaceChild("cube_r6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7 = rope_3.addOrReplaceChild("cube_r7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_back_sail_1 = GalleonSail.addOrReplaceChild("rope_back_sail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5358F, 41.718F, 82.1733F, -0.1463F, 0.9071F, -0.2703F));

		PartDefinition cube_r1 = rope_back_sail_1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 27).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 27).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(28, 28).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(24.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(36.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(48.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(59.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r59 = rope_back_sail_1.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(4, 1).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r60 = rope_back_sail_1.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(23, 9).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_back_sail_2 = GalleonSail.addOrReplaceChild("rope_back_sail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5358F, 41.718F, 82.1733F, -0.1606F, 0.8974F, -0.3349F));

		PartDefinition cube_r61 = rope_back_sail_2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(24, 27).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 28).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(24.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(35.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(45.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r62 = rope_back_sail_2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(4, 1).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r63 = rope_back_sail_2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(23, 9).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_back_sail_3 = GalleonSail.addOrReplaceChild("rope_back_sail_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5358F, 41.718F, 82.1733F, -0.191F, 0.8809F, -0.4393F));

		PartDefinition cube_r64 = rope_back_sail_3.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(24, 27).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 27).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 27).addBox(24.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r65 = rope_back_sail_3.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(4, 1).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r66 = rope_back_sail_3.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(23, 9).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_back_sail_4 = GalleonSail.addOrReplaceChild("rope_back_sail_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5358F, 41.718F, 82.1733F, -0.2528F, 0.8443F, -0.6294F));

		PartDefinition cube_r67 = rope_back_sail_4.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(24, 27).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 27).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 27).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 26).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(90, 26).addBox(24.5F, -0.5F, -17.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r68 = rope_back_sail_4.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(4, 1).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r69 = rope_back_sail_4.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(23, 9).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_right_1 = GalleonSail.addOrReplaceChild("sail_main_rope_right_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.5358F, 50.718F, 7.1733F, 1.3885F, 1.4519F, 1.2179F));

		PartDefinition cube_r23 = sail_main_rope_right_1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(11, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 25).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 25).addBox(18.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 26).addBox(25.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(37.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(49.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 24).addBox(60.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = sail_main_rope_right_1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r25 = sail_main_rope_right_1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_right_2 = GalleonSail.addOrReplaceChild("sail_main_rope_right_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.5358F, 50.718F, 7.1733F, 1.4509F, 1.3384F, 1.2365F));

		PartDefinition cube_r26 = sail_main_rope_right_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(11, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 25).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(18.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(25.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(36.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(46.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = sail_main_rope_right_2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(10, 8).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r28 = sail_main_rope_right_2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(17, 3).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_right_3 = GalleonSail.addOrReplaceChild("sail_main_rope_right_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.5358F, 50.718F, 7.1733F, 1.5042F, 1.284F, 1.2136F));

		PartDefinition cube_r29 = sail_main_rope_right_3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(11, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 25).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 25).addBox(18.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 25).addBox(25.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = sail_main_rope_right_3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r31 = sail_main_rope_right_3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_right_4 = GalleonSail.addOrReplaceChild("sail_main_rope_right_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.5358F, 50.718F, 7.1733F, 1.5708F, 1.501F, 1.1694F));

		PartDefinition cube_r8 = sail_main_rope_right_4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 25).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 24).addBox(18.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9 = sail_main_rope_right_4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = sail_main_rope_right_4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_left_1 = GalleonSail.addOrReplaceChild("sail_main_rope_left_1", CubeListBuilder.create(), PartPose.offsetAndRotation(33.4642F, 50.718F, 7.1733F, 1.2905F, 1.4576F, 1.4485F));

		PartDefinition cube_r32 = sail_main_rope_left_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(24.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 26).addBox(36.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(48.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(59.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = sail_main_rope_left_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = sail_main_rope_left_1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_left_2 = GalleonSail.addOrReplaceChild("sail_main_rope_left_2", CubeListBuilder.create(), PartPose.offsetAndRotation(33.4642F, 50.718F, 7.1733F, 1.4662F, 1.3471F, 1.6633F));

		PartDefinition cube_r35 = sail_main_rope_left_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(24.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(35.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(45.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r36 = sail_main_rope_left_2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r37 = sail_main_rope_left_2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_left_3 = GalleonSail.addOrReplaceChild("sail_main_rope_left_3", CubeListBuilder.create(), PartPose.offsetAndRotation(33.4642F, 50.718F, 7.1733F, 1.4636F, 1.2926F, 1.7332F));

		PartDefinition cube_r38 = sail_main_rope_left_3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 26).addBox(24.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r39 = sail_main_rope_left_3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r40 = sail_main_rope_left_3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_main_rope_left_4 = GalleonSail.addOrReplaceChild("sail_main_rope_left_4", CubeListBuilder.create(), PartPose.offsetAndRotation(33.4642F, 50.718F, 7.1733F, 0.7854F, 1.501F, 1.1694F));

		PartDefinition cube_r14 = sail_main_rope_left_4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 25).addBox(-8.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.748F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = sail_main_rope_left_4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = sail_main_rope_left_4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_right_1 = GalleonSail.addOrReplaceChild("sail_front_rope_right_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5358F, 54.718F, -48.8267F, 0.9695F, 1.5613F, 0.6866F));

		PartDefinition cube_r41 = sail_front_rope_right_1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(18.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(33.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(48.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = sail_front_rope_right_1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r43 = sail_front_rope_right_1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_right_2 = GalleonSail.addOrReplaceChild("sail_front_rope_right_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5358F, 54.718F, -48.8267F, 1.4535F, 1.4752F, 1.1277F));

		PartDefinition cube_r44 = sail_front_rope_right_2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(18.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(33.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(43.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r45 = sail_front_rope_right_2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r46 = sail_front_rope_right_2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_right_3 = GalleonSail.addOrReplaceChild("sail_front_rope_right_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5358F, 54.718F, -48.8267F, 1.5126F, 1.4206F, 1.1171F));

		PartDefinition cube_r47 = sail_front_rope_right_3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(18.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 27).addBox(33.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = sail_front_rope_right_3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(9, 9).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = sail_front_rope_right_3.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_right_4 = GalleonSail.addOrReplaceChild("sail_front_rope_right_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5358F, 54.718F, -48.8267F, 1.5708F, 1.5272F, 1.0821F));

		PartDefinition cube_r17 = sail_front_rope_right_4.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 26).addBox(18.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = sail_front_rope_right_4.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19 = sail_front_rope_right_4.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_left_1 = GalleonSail.addOrReplaceChild("sail_front_rope_left_1", CubeListBuilder.create(), PartPose.offsetAndRotation(20.4642F, 53.718F, -48.8267F, 0.2453F, 1.5266F, 0.5407F));

		PartDefinition cube_r50 = sail_front_rope_left_1.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(18.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(32.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(47.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r51 = sail_front_rope_left_1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r52 = sail_front_rope_left_1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_left_2 = GalleonSail.addOrReplaceChild("sail_front_rope_left_2", CubeListBuilder.create(), PartPose.offsetAndRotation(20.4642F, 53.718F, -48.8267F, 1.2242F, 1.4646F, 1.5633F));

		PartDefinition cube_r53 = sail_front_rope_left_2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(18.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(32.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 25).addBox(42.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r54 = sail_front_rope_left_2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r55 = sail_front_rope_left_2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_left_3 = GalleonSail.addOrReplaceChild("sail_front_rope_left_3", CubeListBuilder.create(), PartPose.offsetAndRotation(20.4642F, 53.718F, -48.8267F, 1.3309F, 1.4092F, 1.7431F));

		PartDefinition cube_r56 = sail_front_rope_left_3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 7).addBox(32.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r57 = sail_front_rope_left_3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r58 = sail_front_rope_left_3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_rope_left_4 = GalleonSail.addOrReplaceChild("sail_front_rope_left_4", CubeListBuilder.create(), PartPose.offsetAndRotation(20.4642F, 53.718F, -48.8267F, 0.7854F, 1.501F, 1.3003F));

		PartDefinition cube_r20 = sail_front_rope_left_4.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 24).addBox(1.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(7.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.7479F, 17.1432F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = sail_front_rope_left_4.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(9, 10).addBox(-12.65F, -12.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -42.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = sail_front_rope_left_4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(16, 4).addBox(-11.5F, -11.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.748F, 0.1432F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_front_top = GalleonSail.addOrReplaceChild("sail_front_top", CubeListBuilder.create(), PartPose.offset(-0.0358F, -26.352F, -45.782F));

		PartDefinition sail_front_top_1 = sail_front_top.addOrReplaceChild("sail_front_top_1", CubeListBuilder.create(), PartPose.offset(0.5F, -24.7357F, -2.2981F));

		PartDefinition cube_r11 = sail_front_top_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(95, 52).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 38).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 59).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r12 = sail_front_top_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(64, 8).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(99, 38).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 57).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8284F, 2.1553F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r13 = sail_front_top_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(64, 28).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(99, 40).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 59).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1749F, -1.8051F, 0.8727F, 0.0F, 0.0F));

		PartDefinition sail_front_top_1_bottom = sail_front_top_1.addOrReplaceChild("sail_front_top_1_bottom", CubeListBuilder.create().texOffs(64, 54).addBox(20.0F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 54).addBox(5.0F, -2.5F, -5.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 40).addBox(-6.0F, -2.5F, -5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(-20.0F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(-35.0F, -2.5F, -5.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1749F, -1.8051F, 1.0472F, 0.0F, 0.0F));

		PartDefinition sail_front_top_2 = sail_front_top.addOrReplaceChild("sail_front_top_2", CubeListBuilder.create(), PartPose.offset(0.5F, -20.1055F, -5.5033F));

		PartDefinition cube_r70 = sail_front_top_2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(100, 48).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 29).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 34).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r71 = sail_front_top_2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(76, 43).addBox(-5.5F, -1.0F, -3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 52).addBox(-34.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 59).addBox(5.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.158F, 0.0737F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r72 = sail_front_top_2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(100, 44).addBox(-5.5F, -1.0F, -3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 58).addBox(-34.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 57).addBox(5.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.4927F, -0.9073F, 1.3963F, 0.0F, 0.0F));

		PartDefinition sail_front_top_2_bottom = sail_front_top_2.addOrReplaceChild("sail_front_top_2_bottom", CubeListBuilder.create().texOffs(64, 56).addBox(20.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(5.5F, -2.0F, -4.0F, 15.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 44).addBox(-5.5F, -2.0F, -4.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(-19.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(-34.5F, -2.0F, -4.0F, 15.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.4472F, -1.4282F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sail_front_top_3 = sail_front_top.addOrReplaceChild("sail_front_top_3", CubeListBuilder.create(), PartPose.offset(0.0F, -11.832F, -6.9163F));

		PartDefinition cube_r73 = sail_front_top_3.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(64, 51).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 33).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 58).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r74 = sail_front_top_3.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(64, 58).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 4).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 55).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7808F, 0.5057F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r75 = sail_front_top_3.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(64, 23).addBox(-34.5F, -1.0F, 3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(70, 2).addBox(-5.5F, -1.0F, 3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 33).addBox(5.5F, -1.0F, 3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.2506F, 2.5128F, 1.9199F, 0.0F, 0.0F));

		PartDefinition sail_front_top_3_bottom = sail_front_top_3.addOrReplaceChild("sail_front_top_3_bottom", CubeListBuilder.create().texOffs(64, 33).addBox(20.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 33).addBox(5.5F, -1.5F, -3.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 2).addBox(-5.5F, -1.5F, -3.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 23).addBox(-19.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 23).addBox(-34.5F, -1.5F, -3.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.4315F, 1.4867F, 2.0944F, 0.0F, 0.0F));

		PartDefinition sail_front_top_4 = sail_front_top.addOrReplaceChild("sail_front_top_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r76 = sail_front_top_4.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(64, 36).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(69, 1).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 22).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4435F, 0.0F, 0.0F));

		PartDefinition cube_r77 = sail_front_top_4.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(63, 5).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(70, 2).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 22).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8051F, -2.1749F, 2.2689F, 0.0F, 0.0F));

		PartDefinition cube_r78 = sail_front_top_4.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(64, 24).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 36).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9604F, -4.0033F, 2.0944F, 0.0F, 0.0F));

		PartDefinition sail_front_top_0 = sail_front_top.addOrReplaceChild("sail_front_top_0", CubeListBuilder.create(), PartPose.offset(0.0F, -26.4301F, 5.3434F));

		PartDefinition sail_front_top_0_bottom = sail_front_top_0.addOrReplaceChild("sail_front_top_0_bottom", CubeListBuilder.create().texOffs(64, 52).addBox(20.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 52).addBox(5.5F, -3.0F, -6.0F, 15.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 40).addBox(-5.5F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(-19.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(-34.5F, -3.0F, -6.0F, 15.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition sail_main = GalleonSail.addOrReplaceChild("sail_main", CubeListBuilder.create(), PartPose.offset(-0.0358F, -29.3737F, -0.5084F));

		PartDefinition sail_main_1 = sail_main.addOrReplaceChild("sail_main_1", CubeListBuilder.create(), PartPose.offset(0.5F, -6.7923F, 9.0167F));

		PartDefinition cube_r79 = sail_main_1.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(64, 10).addBox(21.0F, -1.0F, -3.5F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 51).addBox(-1.0F, -1.0F, -3.5F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(74, 19).addBox(-22.0F, -1.0F, -3.5F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 38).addBox(-48.0F, -1.0F, -3.5F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r80 = sail_main_1.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(64, 9).addBox(21.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 36).addBox(-0.5F, -1.0F, 2.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(74, 1).addBox(-21.5F, -1.0F, 2.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 20).addBox(-47.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.7923F, -9.0167F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r84 = sail_main_1.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(64, 45).addBox(21.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 30).addBox(-0.5F, -1.0F, 2.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(73, 25).addBox(-21.5F, -1.0F, 2.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 11.5118F, -12.5036F, 0.8727F, 0.0F, 0.0F));

		PartDefinition sail_main_1_bottom = sail_main_1.addOrReplaceChild("sail_main_1_bottom", CubeListBuilder.create().texOffs(64, 45).addBox(34.5F, -2.5F, -5.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 45).addBox(21.5F, -2.5F, -5.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(10.5F, -2.5F, -5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-0.5F, -2.5F, -5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-10.5F, -2.5F, -5.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-21.5F, -2.5F, -5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-34.5F, -2.5F, -5.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -2.5F, -5.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 9.9797F, -11.218F, 1.0472F, 0.0F, 0.0F));

		PartDefinition sail_main_2 = sail_main.addOrReplaceChild("sail_main_2", CubeListBuilder.create(), PartPose.offset(0.0F, 6.2034F, -4.3437F));

		PartDefinition cube_r85 = sail_main_2.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(67, 56).addBox(-21.5F, -1.0F, -8.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -1.0F, -8.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 39).addBox(-0.5F, -1.0F, -8.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 31).addBox(21.5F, -1.0F, -8.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r86 = sail_main_2.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(64, 9).addBox(-47.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(71, 51).addBox(-21.5F, -1.0F, 2.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 26).addBox(-0.5F, -1.0F, 2.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 27).addBox(21.5F, -1.0F, 2.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7694F, -1.7577F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r87 = sail_main_2.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(64, 42).addBox(21.5F, -1.0F, -6.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 51).addBox(-0.5F, -1.0F, -6.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(65, 54).addBox(-21.5F, -1.0F, -6.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -1.0F, -6.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3492F, -2.691F, 1.3963F, 0.0F, 0.0F));

		PartDefinition sail_main_2_bottom = sail_main_2.addOrReplaceChild("sail_main_2_bottom", CubeListBuilder.create().texOffs(64, 42).addBox(34.5F, -2.0F, -4.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 42).addBox(21.5F, -2.0F, -4.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 51).addBox(10.5F, -2.0F, -4.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 51).addBox(-0.5F, -2.0F, -4.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 54).addBox(-10.5F, -2.0F, -4.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 54).addBox(-21.5F, -2.0F, -4.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-34.5F, -2.0F, -4.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -2.0F, -4.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.258F, -3.7329F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sail_main_3 = sail_main.addOrReplaceChild("sail_main_3", CubeListBuilder.create(), PartPose.offset(0.0F, 26.099F, -7.903F));

		PartDefinition cube_r88 = sail_main_3.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(74, 52).addBox(-21.5F, -1.0F, -5.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 43).addBox(-47.5F, -1.0F, -5.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 1).addBox(-0.5F, -1.0F, -5.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(21.5F, -1.0F, -5.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r89 = sail_main_3.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(64, 9).addBox(-47.5F, -1.0F, -5.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(65, 38).addBox(-21.5F, -1.0F, -5.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 31).addBox(21.5F, -1.0F, -5.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 1).addBox(-0.5F, -1.0F, -5.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.8112F, -0.1585F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r90 = sail_main_3.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(64, 9).addBox(21.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 0).addBox(-0.5F, -1.0F, -9.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(74, 43).addBox(-21.5F, -1.0F, -9.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 2).addBox(-47.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9366F, -0.2029F, 1.9199F, 0.0F, 0.0F));

		PartDefinition sail_main_3_bottom = sail_main_3.addOrReplaceChild("sail_main_3_bottom", CubeListBuilder.create().texOffs(64, 9).addBox(34.5F, -1.5F, -3.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(21.5F, -1.5F, -3.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(10.5F, -1.5F, -3.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-0.5F, -1.5F, -3.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 43).addBox(-10.5F, -1.5F, -3.0F, 10.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 43).addBox(-21.5F, -1.5F, -3.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 2).addBox(-34.5F, -1.5F, -3.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 2).addBox(-47.5F, -1.5F, -3.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.3938F, 2.8752F, 2.0944F, 0.0F, 0.0F));

		PartDefinition sail_main_4 = sail_main.addOrReplaceChild("sail_main_4", CubeListBuilder.create(), PartPose.offset(0.0F, 39.09F, -4.1297F));

		PartDefinition cube_r91 = sail_main_4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(64, 1).addBox(-47.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(74, 41).addBox(-21.5F, -1.0F, -9.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 0).addBox(-0.5F, -1.0F, -9.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(21.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3533F, -2.4717F, 2.0944F, 0.0F, 0.0F));

		PartDefinition cube_r92 = sail_main_4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(65, 0).addBox(-21.5F, -1.0F, -9.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 1).addBox(-47.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-0.5F, -1.0F, -9.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(21.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.2689F, 0.0F, 0.0F));

		PartDefinition cube_r93 = sail_main_4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(64, 9).addBox(21.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(69, 43).addBox(-0.5F, -1.0F, -9.0F, 22.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(65, 3).addBox(-21.5F, -1.0F, -9.0F, 21.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 36).addBox(-47.5F, -1.0F, -9.0F, 26.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8428F, 3.3637F, 2.4435F, 0.0F, 0.0F));

		PartDefinition sail_main_0 = sail_main.addOrReplaceChild("sail_main_0", CubeListBuilder.create(), PartPose.offset(0.0F, -6.4083F, 14.0698F));

		PartDefinition sail_main_0_bottom = sail_main_0.addOrReplaceChild("sail_main_0_bottom", CubeListBuilder.create().texOffs(64, 45).addBox(34.5F, -3.0F, -6.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 45).addBox(21.5F, -3.0F, -6.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(10.5F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-0.5F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-10.5F, -3.0F, -6.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-21.5F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-34.5F, -3.0F, -6.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-47.5F, -3.0F, -6.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition sail_main_top = GalleonSail.addOrReplaceChild("sail_main_top", CubeListBuilder.create(), PartPose.offset(0.4642F, -70.0876F, 5.9199F));

		PartDefinition sail_main_top_1 = sail_main_top.addOrReplaceChild("sail_main_top_1", CubeListBuilder.create(), PartPose.offset(0.0F, -1.8284F, 2.1553F));

		PartDefinition cube_r94 = sail_main_top_1.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(64, 25).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(72, 15).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 35).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r95 = sail_main_top_1.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(64, 25).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 22).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 45).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8284F, -2.1553F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r96 = sail_main_top_1.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(64, 39).addBox(5.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 25).addBox(-6.0F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-35.0F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0033F, -3.9604F, 0.8727F, 0.0F, 0.0F));

		PartDefinition sail_main_top_1_bottom = sail_main_top_1.addOrReplaceChild("sail_main_top_1_bottom", CubeListBuilder.create().texOffs(64, 39).addBox(20.0F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 39).addBox(5.0F, -2.5F, -5.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-6.0F, -2.5F, -5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-20.0F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-35.0F, -2.5F, -5.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0033F, -3.9604F, 1.0472F, 0.0F, 0.0F));

		PartDefinition sail_main_top_2 = sail_main_top.addOrReplaceChild("sail_main_top_2", CubeListBuilder.create(), PartPose.offset(-0.5F, 7.1229F, -4.1124F));

		PartDefinition cube_r97 = sail_main_top_2.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(64, 24).addBox(-34.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(75, 48).addBox(-5.5F, -1.0F, -3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(5.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r98 = sail_main_top_2.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(64, 28).addBox(-34.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(98, 49).addBox(-5.5F, -1.0F, -3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(5.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.6507F, 0.981F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r99 = sail_main_top_2.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(64, 27).addBox(-34.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(73, 39).addBox(-5.5F, -1.0F, -3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 53).addBox(5.5F, -1.0F, -3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0908F, 2.4073F, 1.0472F, 0.0F, 0.0F));

		PartDefinition sail_main_top_2_bottom = sail_main_top_2.addOrReplaceChild("sail_main_top_2_bottom", CubeListBuilder.create().texOffs(64, 28).addBox(20.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 28).addBox(5.5F, -2.0F, -4.0F, 15.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 48).addBox(-5.5F, -2.0F, -4.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 24).addBox(-19.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 24).addBox(-34.5F, -2.0F, -4.0F, 15.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9544F, -0.5209F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sail_main_top_3 = sail_main_top.addOrReplaceChild("sail_main_top_3", CubeListBuilder.create(), PartPose.offset(-0.5F, 15.6844F, -4.1124F));

		PartDefinition cube_r100 = sail_main_top_3.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(64, 30).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 43).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 53).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r101 = sail_main_top_3.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(64, 47).addBox(-34.5F, -1.0F, 3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 3).addBox(-5.5F, -1.0F, 3.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 35).addBox(5.5F, -1.0F, 3.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.4698F, 2.007F, 1.9199F, 0.0F, 0.0F));

		PartDefinition cube_r102 = sail_main_top_3.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(64, 25).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(72, 30).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 1).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7808F, -0.5057F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sail_main_top_3_bottom = sail_main_top_3.addOrReplaceChild("sail_main_top_3_bottom", CubeListBuilder.create().texOffs(64, 35).addBox(20.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 35).addBox(5.5F, -1.5F, -3.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 3).addBox(-5.5F, -1.5F, -3.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-19.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-34.5F, -1.5F, -3.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.6507F, 0.981F, 2.0944F, 0.0F, 0.0F));

		PartDefinition sail_main_top_4 = sail_main_top.addOrReplaceChild("sail_main_top_4", CubeListBuilder.create(), PartPose.offset(-0.5F, 24.7357F, 2.2981F));

		PartDefinition cube_r103 = sail_main_top_4.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(66, 4).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 26).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 6).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.4435F, 0.0F, 0.0F));

		PartDefinition cube_r104 = sail_main_top_4.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(100, 5).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(62, 16).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8051F, -2.1749F, 2.2689F, 0.0F, 0.0F));

		PartDefinition cube_r105 = sail_main_top_4.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(64, 42).addBox(5.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(100, 5).addBox(-5.5F, -1.0F, 0.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 41).addBox(-34.5F, -1.0F, 0.0F, 29.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9604F, -4.0033F, 2.0944F, 0.0F, 0.0F));

		PartDefinition sail_main_top_0 = sail_main_top.addOrReplaceChild("sail_main_top_0", CubeListBuilder.create(), PartPose.offset(-0.5F, -1.6944F, 7.6415F));

		PartDefinition sail_main_top_0_bottom = sail_main_top_0.addOrReplaceChild("sail_main_top_0_bottom", CubeListBuilder.create().texOffs(64, 39).addBox(20.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 39).addBox(5.5F, -3.0F, -6.0F, 15.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 25).addBox(-5.5F, -3.0F, -6.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-19.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-34.5F, -3.0F, -6.0F, 15.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition sail_front = GalleonSail.addOrReplaceChild("sail_front", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0358F, -18.7038F, -43.1695F, 0.0873F, 0.0F, 0.0F));

		PartDefinition sail_front_1 = sail_front.addOrReplaceChild("sail_front_1", CubeListBuilder.create(), PartPose.offset(0.0358F, 4.7038F, 43.1695F));

		PartDefinition cube_r106 = sail_front_1.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(64, 42).addBox(13.4642F, -20.9027F, -43.0912F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 23).addBox(-13.5358F, -20.9027F, -43.0912F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5358F, -20.9027F, -43.0912F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r107 = sail_front_1.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(64, 48).addBox(13.5F, -1.0F, -2.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(65, 16).addBox(-13.5F, -1.0F, -2.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 23).addBox(-41.5F, -1.0F, -2.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0358F, -3.038F, -48.8737F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r108 = sail_front_1.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(64, 56).addBox(13.5F, -1.0F, -2.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 47).addBox(-13.5F, -1.0F, -2.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -1.0F, -2.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0358F, -0.8525F, -51.9951F, 0.6981F, 0.0F, 0.0F));

		PartDefinition sail_front_1_bottom = sail_front_1.addOrReplaceChild("sail_front_1_bottom", CubeListBuilder.create().texOffs(64, 54).addBox(27.5F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 54).addBox(13.5F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-0.5F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-13.5F, -2.5F, -5.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-27.5F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -2.5F, -5.0F, 14.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0358F, 0.4331F, -53.5272F, 0.8727F, 0.0F, 0.0F));

		PartDefinition sail_front_2 = sail_front.addOrReplaceChild("sail_front_2", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, -16.0F));

		PartDefinition cube_r109 = sail_front_2.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(64, 43).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 56).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 8).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r110 = sail_front_2.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(64, 54).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(65, 39).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 29).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.9221F, 3.1944F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r111 = sail_front_2.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(64, 50).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 56).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6008F, 1.2944F, 1.0472F, 0.0F, 0.0F));

		PartDefinition sail_front_2_bottom = sail_front_2.addOrReplaceChild("sail_front_2_bottom", CubeListBuilder.create().texOffs(64, 43).addBox(27.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 43).addBox(13.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(-0.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(-13.5F, -2.0F, -4.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 8).addBox(-27.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 8).addBox(-41.5F, -2.0F, -4.0F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3963F, 0.0F, 0.0F));

		PartDefinition sail_front_3 = sail_front.addOrReplaceChild("sail_front_3", CubeListBuilder.create(), PartPose.offset(0.0F, 26.3628F, -15.9549F));

		PartDefinition cube_r112 = sail_front_3.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(64, 17).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 30).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 24).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r113 = sail_front_3.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(64, 17).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 47).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 38).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5919F, -0.6946F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r114 = sail_front_3.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(64, 9).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 38).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 33).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7656F, -0.6794F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sail_front_3_bottom = sail_front_3.addOrReplaceChild("sail_front_3_bottom", CubeListBuilder.create().texOffs(64, 24).addBox(27.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 24).addBox(13.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-0.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 30).addBox(-13.5F, -1.5F, -3.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-27.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -1.5F, -3.0F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9199F, 0.0F, 0.0F));

		PartDefinition sail_front_4 = sail_front.addOrReplaceChild("sail_front_4", CubeListBuilder.create(), PartPose.offset(0.0F, 38.6286F, -7.2935F));

		PartDefinition cube_r115 = sail_front_4.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(64, 17).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 16).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 7).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4479F, -2.9409F, 2.2689F, 0.0F, 0.0F));

		PartDefinition cube_r116 = sail_front_4.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(64, 44).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 56).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3693F, -5.4121F, 2.0944F, 0.0F, 0.0F));

		PartDefinition cube_r117 = sail_front_4.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(64, 52).addBox(13.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(66, 24).addBox(-13.5F, -1.0F, 0.0F, 27.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 51).addBox(-41.5F, -1.0F, 0.0F, 28.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.6754F, -7.3384F, 1.9199F, 0.0F, 0.0F));

		PartDefinition sail_front_0 = sail_front.addOrReplaceChild("sail_front_0", CubeListBuilder.create(), PartPose.offset(0.0F, 1.3957F, 2.9519F));

		PartDefinition sail_front_0_bottom = sail_front_0.addOrReplaceChild("sail_front_0_bottom", CubeListBuilder.create().texOffs(64, 52).addBox(27.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 52).addBox(13.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-0.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-13.5F, -3.0F, -6.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-27.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 17).addBox(-41.5F, -3.0F, -6.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition sail_back = GalleonSail.addOrReplaceChild("sail_back", CubeListBuilder.create().texOffs(89, 8).addBox(7.1924F, -5.866F, 17.0247F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(92, 17).addBox(7.1924F, -6.866F, 23.0247F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(82, 11).addBox(7.1924F, -4.866F, 11.0247F, 1.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(72, 12).addBox(7.1924F, -3.866F, 6.0247F, 1.0F, 1.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(73, 25).addBox(7.1924F, -2.866F, 0.0247F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(68, 34).addBox(7.1924F, -1.866F, -4.9753F, 1.0F, 1.0F, 29.0F, new CubeDeformation(0.0F))
				.texOffs(80, 32).addBox(7.1924F, -2.866F, 20.0247F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(108, 54).addBox(7.1924F, -1.866F, 24.0247F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(112, 31).addBox(7.1924F, -0.866F, 26.0247F, 1.0F, 26.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(7.1924F, -0.866F, -4.9753F, 1.0F, 26.0F, 31.0F, new CubeDeformation(0.0F))
				.texOffs(79, 46).addBox(7.1924F, 25.134F, 11.0247F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(80, 47).addBox(7.1924F, 25.134F, -4.9753F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(84, 1).addBox(7.1924F, 27.134F, -4.9753F, 1.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(80, 40).addBox(7.1924F, 26.134F, -4.9753F, 1.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.7282F, -0.416F, 74.1486F));

		PartDefinition sail_back_4 = sail_back.addOrReplaceChild("sail_back_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base1 = sail_back_4.addOrReplaceChild("Base1", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, -43.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base2 = Base1.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(64, 7).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(64, 14).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base4 = Base3.addOrReplaceChild("Base4", CubeListBuilder.create().texOffs(64, 21).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base5 = sail_back_4.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(64, 3).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -4.0F, -39.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base6 = Base5.addOrReplaceChild("Base6", CubeListBuilder.create().texOffs(64, 10).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0327F, 0.0F));

		PartDefinition Base7 = Base6.addOrReplaceChild("Base7", CubeListBuilder.create().texOffs(64, 17).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0327F, 0.0F));

		PartDefinition Base8 = sail_back_4.addOrReplaceChild("Base8", CubeListBuilder.create().texOffs(64, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -8.0F, -35.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base9 = Base8.addOrReplaceChild("Base9", CubeListBuilder.create().texOffs(64, 13).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.6667F, 0.0F, 0.0305F, 0.0F));

		PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create().texOffs(64, 20).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.6667F, 0.0F, 0.0305F, 0.0F));

		PartDefinition Base11 = sail_back_4.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(64, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -12.0F, -31.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(64, 16).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.3333F, 0.0F, 0.0284F, 0.0F));

		PartDefinition Base13 = Base12.addOrReplaceChild("Base13", CubeListBuilder.create().texOffs(64, 23).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.3333F, 0.0F, 0.0284F, 0.0F));

		PartDefinition sail_back_3 = sail_back.addOrReplaceChild("sail_back_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base14 = sail_back_3.addOrReplaceChild("Base14", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -16.0F, -27.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base15 = Base14.addOrReplaceChild("Base15", CubeListBuilder.create().texOffs(64, 19).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base16 = Base15.addOrReplaceChild("Base16", CubeListBuilder.create().texOffs(64, 26).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base17 = sail_back_3.addOrReplaceChild("Base17", CubeListBuilder.create().texOffs(64, 15).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -20.0F, -23.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base18 = Base17.addOrReplaceChild("Base18", CubeListBuilder.create().texOffs(64, 22).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.024F, 0.0F));

		PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create().texOffs(64, 29).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.024F, 0.0F));

		PartDefinition Base20 = sail_back_3.addOrReplaceChild("Base20", CubeListBuilder.create().texOffs(64, 18).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -24.0F, -19.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base21 = Base20.addOrReplaceChild("Base21", CubeListBuilder.create().texOffs(64, 25).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0327F, 0.0F));

		PartDefinition Base22 = sail_back_3.addOrReplaceChild("Base22", CubeListBuilder.create().texOffs(64, 21).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -28.0F, -15.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create().texOffs(64, 28).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0295F, 0.0F));

		PartDefinition sail_back_3_bottom = sail_back_3.addOrReplaceChild("sail_back_3_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -16.0F, -27.5F));

		PartDefinition Base24 = sail_back_3_bottom.addOrReplaceChild("Base24", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition sail_back_2 = sail_back.addOrReplaceChild("sail_back_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base27 = sail_back_2.addOrReplaceChild("Base27", CubeListBuilder.create().texOffs(64, 24).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -32.0F, -11.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base28 = Base27.addOrReplaceChild("Base28", CubeListBuilder.create().texOffs(64, 1).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base29 = sail_back_2.addOrReplaceChild("Base29", CubeListBuilder.create().texOffs(64, 27).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -36.0F, -7.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base30 = Base29.addOrReplaceChild("Base30", CubeListBuilder.create().texOffs(64, 4).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, 0.0F, 0.0229F, 0.0F));

		PartDefinition Base31 = sail_back_2.addOrReplaceChild("Base31", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -40.0F, -3.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base32 = Base31.addOrReplaceChild("Base32", CubeListBuilder.create().texOffs(64, 7).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, 0.0F, 0.0196F, 0.0F));

		PartDefinition Base33 = sail_back_2.addOrReplaceChild("Base33", CubeListBuilder.create().texOffs(64, 3).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -44.0F, 0.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_back_2_bottom = sail_back_2.addOrReplaceChild("sail_back_2_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -32.0F, -11.5F));

		PartDefinition Base34 = sail_back_2_bottom.addOrReplaceChild("Base34", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base35 = Base34.addOrReplaceChild("Base35", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition sail_back_1 = sail_back.addOrReplaceChild("sail_back_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base36 = sail_back_1.addOrReplaceChild("Base36", CubeListBuilder.create().texOffs(64, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -48.0F, 4.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base37 = sail_back_1.addOrReplaceChild("Base37", CubeListBuilder.create().texOffs(64, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -52.0F, 8.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base38 = sail_back_1.addOrReplaceChild("Base38", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -56.0F, 12.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base39 = sail_back_1.addOrReplaceChild("Base39", CubeListBuilder.create().texOffs(64, 15).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -60.0F, 16.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_back_1_bottom = sail_back_1.addOrReplaceChild("sail_back_1_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -48.0F, 4.5F));

		PartDefinition Base40 = sail_back_1_bottom.addOrReplaceChild("Base40", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_back_0 = sail_back.addOrReplaceChild("sail_back_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_back_0_bottom = sail_back_0.addOrReplaceChild("sail_back_0_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r118 = sail_back_0_bottom.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(64, 0).addBox(-3.0F, -3.0F, 77.5797F, 6.0F, 6.0F, 12.9299F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 64.6498F, 6.0F, 6.0F, 12.93F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 51.7198F, 6.0F, 6.0F, 12.9299F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 38.7899F, 6.0F, 6.0F, 12.93F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 25.8599F, 6.0F, 6.0F, 12.9299F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 12.93F, 6.0F, 6.0F, 12.93F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 12.93F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rope_sail_main_top_1_1 = GalleonSail.addOrReplaceChild("rope_sail_main_top_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-44.0641F, -37.9027F, 9.8343F, 0.1881F, -0.0238F, 0.2555F));

		PartDefinition cube_r83_r1 = rope_sail_main_top_1_1.addOrReplaceChild("cube_r83_r1", CubeListBuilder.create().texOffs(7, 25).addBox(-31.0F, -0.5F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 25).addBox(-22.0F, -0.5F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 25).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_2_1 = GalleonSail.addOrReplaceChild("rope_sail_main_top_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-44.0641F, -37.9027F, 9.8343F, 0.3271F, 0.0001F, 0.3534F));

		PartDefinition cube_r83_r2 = rope_sail_main_top_2_1.addOrReplaceChild("cube_r83_r2", CubeListBuilder.create().texOffs(7, 25).addBox(-25.0F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 25).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_3_1 = GalleonSail.addOrReplaceChild("rope_sail_main_top_3_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-44.0641F, -37.9027F, 9.8343F, 0.4632F, -0.0193F, 0.534F));

		PartDefinition cube_r83_r3 = rope_sail_main_top_3_1.addOrReplaceChild("cube_r83_r3", CubeListBuilder.create().texOffs(7, 25).addBox(-18.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 25).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_4_1 = GalleonSail.addOrReplaceChild("rope_sail_main_top_4_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-44.0641F, -37.9027F, 9.8343F, 0.2584F, -0.126F, 0.8209F));

		PartDefinition cube_r83_r4 = rope_sail_main_top_4_1.addOrReplaceChild("cube_r83_r4", CubeListBuilder.create().texOffs(7, 25).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_1_1 = GalleonSail.addOrReplaceChild("rope_sail_front_top_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-41.0641F, -19.9027F, -44.1657F, 0.1874F, 0.018F, 0.1526F));

		PartDefinition cube_r84_r1 = rope_sail_front_top_1_1.addOrReplaceChild("cube_r84_r1", CubeListBuilder.create().texOffs(23, 26).addBox(-29.0F, -0.5F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(-19.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(-8.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_2_1 = GalleonSail.addOrReplaceChild("rope_sail_front_top_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-41.0641F, -19.9027F, -44.1657F, 0.3463F, 0.0471F, 0.2366F));

		PartDefinition cube_r84_r2 = rope_sail_front_top_2_1.addOrReplaceChild("cube_r84_r2", CubeListBuilder.create().texOffs(23, 26).addBox(-22.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(-15.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(-8.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_3_1 = GalleonSail.addOrReplaceChild("rope_sail_front_top_3_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-41.0641F, -19.9027F, -44.1657F, 0.5245F, 0.0351F, 0.4008F));

		PartDefinition cube_r84_r3 = rope_sail_front_top_3_1.addOrReplaceChild("cube_r84_r3", CubeListBuilder.create().texOffs(93, 7).addBox(-15.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(23, 26).addBox(-8.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_4_1 = GalleonSail.addOrReplaceChild("rope_sail_front_top_4_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-41.0641F, -19.9027F, -44.1657F, 0.3159F, -0.0916F, 0.6938F));

		PartDefinition cube_r84_r4 = rope_sail_front_top_4_1.addOrReplaceChild("cube_r84_r4", CubeListBuilder.create().texOffs(23, 26).addBox(-8.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_1_2 = GalleonSail.addOrReplaceChild("rope_sail_main_top_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(44.9359F, -37.9027F, 10.2343F, 0.2051F, -0.14F, -0.4673F));

		PartDefinition cube_r84_r5 = rope_sail_main_top_1_2.addOrReplaceChild("cube_r84_r5", CubeListBuilder.create().texOffs(16, 24).addBox(-31.0F, -0.5F, -0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 24).addBox(-22.0F, -0.5F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 24).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_2_2 = GalleonSail.addOrReplaceChild("rope_sail_main_top_2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(44.9359F, -37.9027F, 10.2343F, 0.3496F, -0.1349F, -0.5892F));

		PartDefinition cube_r84_r6 = rope_sail_main_top_2_2.addOrReplaceChild("cube_r84_r6", CubeListBuilder.create().texOffs(16, 24).addBox(-25.0F, -0.5F, -0.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 24).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_3_2 = GalleonSail.addOrReplaceChild("rope_sail_main_top_3_2", CubeListBuilder.create(), PartPose.offsetAndRotation(44.9359F, -37.9027F, 10.2343F, 0.4804F, -0.085F, -0.7896F));

		PartDefinition cube_r84_r7 = rope_sail_main_top_3_2.addOrReplaceChild("cube_r84_r7", CubeListBuilder.create().texOffs(26, 26).addBox(-18.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 24).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_main_top_4_2 = GalleonSail.addOrReplaceChild("rope_sail_main_top_4_2", CubeListBuilder.create(), PartPose.offsetAndRotation(44.9359F, -37.9027F, 10.2343F, 0.2575F, -0.0188F, -1.052F));

		PartDefinition cube_r84_r8 = rope_sail_main_top_4_2.addOrReplaceChild("cube_r84_r8", CubeListBuilder.create().texOffs(16, 24).addBox(-12.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_1_2 = GalleonSail.addOrReplaceChild("rope_sail_front_top_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(41.9359F, -19.9027F, -43.7657F, 0.2327F, -0.1914F, -0.413F));

		PartDefinition cube_r85_r1 = rope_sail_front_top_1_2.addOrReplaceChild("cube_r85_r1", CubeListBuilder.create().texOffs(21, 26).addBox(-30.0F, -0.5F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-20.0F, -0.5F, -0.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-10.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_2_2 = GalleonSail.addOrReplaceChild("rope_sail_front_top_2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(41.9359F, -19.9027F, -43.7657F, 0.3908F, -0.1816F, -0.53F));

		PartDefinition cube_r85_r2 = rope_sail_front_top_2_2.addOrReplaceChild("cube_r85_r2", CubeListBuilder.create().texOffs(21, 26).addBox(-24.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-17.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-10.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_3_2 = GalleonSail.addOrReplaceChild("rope_sail_front_top_3_2", CubeListBuilder.create(), PartPose.offsetAndRotation(41.9359F, -19.9027F, -43.7657F, 0.5481F, -0.1235F, -0.7192F));

		PartDefinition cube_r85_r3 = rope_sail_front_top_3_2.addOrReplaceChild("cube_r85_r3", CubeListBuilder.create().texOffs(21, 26).addBox(-17.0F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 26).addBox(-10.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		PartDefinition rope_sail_front_top_4_2 = GalleonSail.addOrReplaceChild("rope_sail_front_top_4_2", CubeListBuilder.create(), PartPose.offsetAndRotation(41.9359F, -19.9027F, -43.7657F, 0.3423F, -0.041F, -0.9676F));

		PartDefinition cube_r85_r4 = rope_sail_front_top_4_2.addOrReplaceChild("cube_r85_r4", CubeListBuilder.create().texOffs(91, 7).addBox(-10.0F, -0.5F, -0.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0283F, -2.1273F, 1.0822F, 0.0F, 0.0F, 1.6581F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Ship entity, float f, float g, float h, float i, float j) {
		switch (entity.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				this.sail_main_0.visible = true;
				this.sail_main_1.visible = false;
				this.sail_main_2.visible = false;
				this.sail_main_3.visible = false;
				this.sail_main_4.visible = false;

				this.sail_main_1_bottom.visible = false;
				this.sail_main_2_bottom.visible = false;
				this.sail_main_3_bottom.visible = false;

				this.sail_main_top_0.visible = true;
				this.sail_main_top_1.visible = false;
				this.sail_main_top_2.visible = false;
				this.sail_main_top_3.visible = false;
				this.sail_main_top_4.visible = false;

				this.sail_main_top_1_bottom.visible = false;
				this.sail_main_top_2_bottom.visible = false;
				this.sail_main_top_3_bottom.visible = false;

				this.sail_front_0.visible = true;
				this.sail_front_1.visible = false;
				this.sail_front_2.visible = false;
				this.sail_front_3.visible = false;
				this.sail_front_4.visible = false;

				this.sail_front_1_bottom.visible = false;
				this.sail_front_2_bottom.visible = false;
				this.sail_front_3_bottom.visible = false;

				this.sail_front_top_0.visible = true;
				this.sail_front_top_1.visible = false;
				this.sail_front_top_2.visible = false;
				this.sail_front_top_3.visible = false;
				this.sail_front_top_4.visible = false;

				this.sail_front_top_1_bottom.visible = false;
				this.sail_front_top_2_bottom.visible = false;
				this.sail_front_top_3_bottom.visible = false;

				this.sail_back_0.visible = true;
				this.sail_back_1.visible = false;
				this.sail_back_2.visible = false;
				this.sail_back_3.visible = false;
				this.sail_back_4.visible = false;

				this.sail_back_1_bottom.visible = false;
				this.sail_back_2_bottom.visible = false;
				this.sail_back_3_bottom.visible = false;
			}
			case 1 -> {
				this.sail_main_0.visible = false;
				this.sail_main_1.visible = true;
				this.sail_main_2.visible = false;
				this.sail_main_3.visible = false;
				this.sail_main_4.visible = false;

				this.sail_main_1_bottom.visible = true;
				this.sail_main_2_bottom.visible = false;
				this.sail_main_3_bottom.visible = false;

				this.sail_main_top_0.visible = false;
				this.sail_main_top_1.visible = true;
				this.sail_main_top_2.visible = false;
				this.sail_main_top_3.visible = false;
				this.sail_main_top_4.visible = false;

				this.sail_main_top_1_bottom.visible = true;
				this.sail_main_top_2_bottom.visible = false;
				this.sail_main_top_3_bottom.visible = false;

				this.sail_front_0.visible = false;
				this.sail_front_1.visible = true;
				this.sail_front_2.visible = false;
				this.sail_front_3.visible = false;
				this.sail_front_4.visible = false;

				this.sail_front_1_bottom.visible = true;
				this.sail_front_2_bottom.visible = false;
				this.sail_front_3_bottom.visible = false;

				this.sail_front_top_0.visible = false;
				this.sail_front_top_1.visible = true;
				this.sail_front_top_2.visible = false;
				this.sail_front_top_3.visible = false;
				this.sail_front_top_4.visible = false;

				this.sail_front_top_1_bottom.visible = true;
				this.sail_front_top_2_bottom.visible = false;
				this.sail_front_top_3_bottom.visible = false;

				this.sail_back_0.visible = false;
				this.sail_back_1.visible = true;
				this.sail_back_2.visible = false;
				this.sail_back_3.visible = false;
				this.sail_back_4.visible = false;

				this.sail_back_1_bottom.visible = true;
				this.sail_back_2_bottom.visible = false;
				this.sail_back_3_bottom.visible = false;
			}
			case 2 -> {
				this.sail_main_0.visible = false;
				this.sail_main_1.visible = true;
				this.sail_main_2.visible = true;
				this.sail_main_3.visible = false;
				this.sail_main_4.visible = false;

				this.sail_main_1_bottom.visible = false;
				this.sail_main_2_bottom.visible = true;
				this.sail_main_3_bottom.visible = false;

				this.sail_main_top_0.visible = false;
				this.sail_main_top_1.visible = true;
				this.sail_main_top_2.visible = true;
				this.sail_main_top_3.visible = false;
				this.sail_main_top_4.visible = false;

				this.sail_main_top_1_bottom.visible = false;
				this.sail_main_top_2_bottom.visible = true;
				this.sail_main_top_3_bottom.visible = false;

				this.sail_front_0.visible = false;
				this.sail_front_1.visible = true;
				this.sail_front_2.visible = true;
				this.sail_front_3.visible = false;
				this.sail_front_4.visible = false;

				this.sail_front_1_bottom.visible = false;
				this.sail_front_2_bottom.visible = true;
				this.sail_front_3_bottom.visible = false;

				this.sail_front_top_0.visible = false;
				this.sail_front_top_1.visible = true;
				this.sail_front_top_2.visible = true;
				this.sail_front_top_3.visible = false;
				this.sail_front_top_4.visible = false;

				this.sail_front_top_1_bottom.visible = false;
				this.sail_front_top_2_bottom.visible = true;
				this.sail_front_top_3_bottom.visible = false;

				this.sail_back_0.visible = false;
				this.sail_back_1.visible = true;
				this.sail_back_2.visible = true;
				this.sail_back_3.visible = false;
				this.sail_back_4.visible = false;

				this.sail_back_1_bottom.visible = false;
				this.sail_back_2_bottom.visible = true;
				this.sail_back_3_bottom.visible = false;
			}
			case 3 -> {
				this.sail_main_0.visible = false;
				this.sail_main_1.visible = true;
				this.sail_main_2.visible = true;
				this.sail_main_3.visible = true;
				this.sail_main_4.visible = false;

				this.sail_main_1_bottom.visible = false;
				this.sail_main_2_bottom.visible = false;
				this.sail_main_3_bottom.visible = true;

				this.sail_main_top_0.visible = false;
				this.sail_main_top_1.visible = true;
				this.sail_main_top_2.visible = true;
				this.sail_main_top_3.visible = true;
				this.sail_main_top_4.visible = false;

				this.sail_main_top_1_bottom.visible = false;
				this.sail_main_top_2_bottom.visible = false;
				this.sail_main_top_3_bottom.visible = true;

				this.sail_front_0.visible = false;
				this.sail_front_1.visible = true;
				this.sail_front_2.visible = true;
				this.sail_front_3.visible = true;
				this.sail_front_4.visible = false;

				this.sail_front_1_bottom.visible = false;
				this.sail_front_2_bottom.visible = false;
				this.sail_front_3_bottom.visible = true;

				this.sail_front_top_0.visible = false;
				this.sail_front_top_1.visible = true;
				this.sail_front_top_2.visible = true;
				this.sail_front_top_3.visible = true;
				this.sail_front_top_4.visible = false;

				this.sail_front_top_1_bottom.visible = false;
				this.sail_front_top_2_bottom.visible = false;
				this.sail_front_top_3_bottom.visible = true;

				this.sail_back_0.visible = false;
				this.sail_back_1.visible = true;
				this.sail_back_2.visible = true;
				this.sail_back_3.visible = true;
				this.sail_back_4.visible = false;

				this.sail_back_1_bottom.visible = false;
				this.sail_back_2_bottom.visible = false;
				this.sail_back_3_bottom.visible = true;
			}
			case 4 -> {
				this.sail_main_0.visible = false;
				this.sail_main_1.visible = true;
				this.sail_main_2.visible = true;
				this.sail_main_3.visible = true;
				this.sail_main_4.visible = true;

				this.sail_main_1_bottom.visible = false;
				this.sail_main_2_bottom.visible = false;
				this.sail_main_3_bottom.visible = false;

				this.sail_main_top_0.visible = false;
				this.sail_main_top_1.visible = true;
				this.sail_main_top_2.visible = true;
				this.sail_main_top_3.visible = true;
				this.sail_main_top_4.visible = true;

				this.sail_main_top_1_bottom.visible = false;
				this.sail_main_top_2_bottom.visible = false;
				this.sail_main_top_3_bottom.visible = false;

				this.sail_front_0.visible = false;
				this.sail_front_1.visible = true;
				this.sail_front_2.visible = true;
				this.sail_front_3.visible = true;
				this.sail_front_4.visible = true;

				this.sail_front_1_bottom.visible = false;
				this.sail_front_2_bottom.visible = false;
				this.sail_front_3_bottom.visible = false;

				this.sail_front_top_0.visible = false;
				this.sail_front_top_1.visible = true;
				this.sail_front_top_2.visible = true;
				this.sail_front_top_3.visible = true;
				this.sail_front_top_4.visible = true;

				this.sail_front_top_1_bottom.visible = false;
				this.sail_front_top_2_bottom.visible = false;
				this.sail_front_top_3_bottom.visible = false;

				this.sail_back_0.visible = false;
				this.sail_back_1.visible = true;
				this.sail_back_2.visible = true;
				this.sail_back_3.visible = true;
				this.sail_back_4.visible = true;

				this.sail_back_1_bottom.visible = false;
				this.sail_back_2_bottom.visible = false;
				this.sail_back_3_bottom.visible = false;
			}
		}

		this.sail_main_rope_right_1.visible = sail_main_1_bottom.visible;
		this.sail_main_rope_right_2.visible = sail_main_2_bottom.visible;
		this.sail_main_rope_right_3.visible = sail_main_3_bottom.visible;
		this.sail_main_rope_right_4.visible = sail_main_4.visible;
		this.sail_main_rope_left_1.visible = sail_main_1_bottom.visible;
		this.sail_main_rope_left_2.visible = sail_main_2_bottom.visible;
		this.sail_main_rope_left_3.visible = sail_main_3_bottom.visible;
		this.sail_main_rope_left_4.visible = sail_main_4.visible;

		this.rope_sail_main_top_1_1.visible = sail_main_top_1_bottom.visible;
		this.rope_sail_main_top_2_1.visible = sail_main_top_2_bottom.visible;
		this.rope_sail_main_top_3_1.visible = sail_main_top_3_bottom.visible;
		this.rope_sail_main_top_4_1.visible = sail_main_top_4.visible;
		this.rope_sail_main_top_1_2.visible = sail_main_top_1_bottom.visible;
		this.rope_sail_main_top_2_2.visible = sail_main_top_2_bottom.visible;
		this.rope_sail_main_top_3_2.visible = sail_main_top_3_bottom.visible;
		this.rope_sail_main_top_4_2.visible = sail_main_top_4.visible;

		this.sail_front_rope_right_1.visible = sail_front_1_bottom.visible;
		this.sail_front_rope_right_2.visible = sail_front_2_bottom.visible;
		this.sail_front_rope_right_3.visible = sail_front_3_bottom.visible;
		this.sail_front_rope_right_4.visible = sail_front_4.visible;
		this.sail_front_rope_left_1.visible = sail_front_1_bottom.visible;
		this.sail_front_rope_left_2.visible = sail_front_2_bottom.visible;
		this.sail_front_rope_left_3.visible = sail_front_3_bottom.visible;
		this.sail_front_rope_left_4.visible = sail_front_4.visible;

		this.rope_sail_front_top_1_1.visible = sail_front_top_1_bottom.visible;
		this.rope_sail_front_top_2_1.visible = sail_front_top_2_bottom.visible;
		this.rope_sail_front_top_3_1.visible = sail_front_top_3_bottom.visible;
		this.rope_sail_front_top_4_1.visible = sail_front_top_4.visible;
		this.rope_sail_front_top_1_2.visible = sail_front_top_1_bottom.visible;
		this.rope_sail_front_top_2_2.visible = sail_front_top_2_bottom.visible;
		this.rope_sail_front_top_3_2.visible = sail_front_top_3_bottom.visible;
		this.rope_sail_front_top_4_2.visible = sail_front_top_4.visible;

		this.rope_back_sail_1.visible = sail_back_1_bottom.visible;
		this.rope_back_sail_2.visible = sail_back_2_bottom.visible;
		this.rope_back_sail_3.visible = sail_back_3_bottom.visible;
		this.rope_back_sail_4.visible = sail_back_4.visible;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		GalleonSail.render(poseStack, buffer, packedLight, packedOverlay);
	}
}