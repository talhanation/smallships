package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CaravelSailModel extends SailModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, CaravelEntity.ID + "_sail_model"), "main");

	private final ModelPart CaravelSail;
	private final ModelPart sail_1;
	private final ModelPart sail_1_4;
	private final ModelPart Base81;
	private final ModelPart Base82;
	private final ModelPart Base83;
	private final ModelPart Base84;
	private final ModelPart Base85;
	private final ModelPart Base86;
	private final ModelPart Base87;
	private final ModelPart Base88;
	private final ModelPart Base89;
	private final ModelPart Base90;
	private final ModelPart Base91;
	private final ModelPart Base92;
	private final ModelPart Base93;
	private final ModelPart Base94;
	private final ModelPart Base95;
	private final ModelPart Base96;
	private final ModelPart Base97;
	private final ModelPart Base98;
	private final ModelPart Base99;
	private final ModelPart Base100;
	private final ModelPart sail_1_3;
	private final ModelPart Base101;
	private final ModelPart Base102;
	private final ModelPart Base103;
	private final ModelPart Base104;
	private final ModelPart Base105;
	private final ModelPart Base106;
	private final ModelPart Base107;
	private final ModelPart Base108;
	private final ModelPart Base109;
	private final ModelPart Base110;
	private final ModelPart Base111;
	private final ModelPart Base112;
	private final ModelPart Base113;
	private final ModelPart Base114;
	private final ModelPart Base115;
	private final ModelPart sail_1_3_bottom;
	private final ModelPart Base116;
	private final ModelPart Base117;
	private final ModelPart Base118;
	private final ModelPart sail_1_2;
	private final ModelPart Base119;
	private final ModelPart Base120;
	private final ModelPart Base121;
	private final ModelPart Base122;
	private final ModelPart Base123;
	private final ModelPart Base124;
	private final ModelPart Base125;
	private final ModelPart Base126;
	private final ModelPart Base127;
	private final ModelPart Base128;
	private final ModelPart sail_1_2_bottom;
	private final ModelPart Base129;
	private final ModelPart Base130;
	private final ModelPart sail_1_1;
	private final ModelPart Base131;
	private final ModelPart Base132;
	private final ModelPart Base133;
	private final ModelPart Base134;
	private final ModelPart Base135;
	private final ModelPart sail_1_1_bottom;
	private final ModelPart Base136;
	private final ModelPart sail_1_0;
	private final ModelPart sail_1_0_bundle;
	private final ModelPart sail_2;
	private final ModelPart sail_2_4;
	private final ModelPart Base137;
	private final ModelPart Base138;
	private final ModelPart Base139;
	private final ModelPart Base140;
	private final ModelPart Base141;
	private final ModelPart Base142;
	private final ModelPart Base143;
	private final ModelPart Base144;
	private final ModelPart sail_2_3;
	private final ModelPart Base145;
	private final ModelPart Base146;
	private final ModelPart Base147;
	private final ModelPart Base148;
	private final ModelPart Base149;
	private final ModelPart Base150;
	private final ModelPart sail_2_3_bottom;
	private final ModelPart Base151;
	private final ModelPart Base152;
	private final ModelPart sail_2_2;
	private final ModelPart Base153;
	private final ModelPart Base154;
	private final ModelPart Base155;
	private final ModelPart Base156;
	private final ModelPart sail_2_2_bottom;
	private final ModelPart Base157;
	private final ModelPart Base158;
	private final ModelPart sail_2_1;
	private final ModelPart Base159;
	private final ModelPart Base160;
	private final ModelPart Base161;
	private final ModelPart sail_2_1_bottom;
	private final ModelPart Base162;
	private final ModelPart sail_2_0;
	private final ModelPart sail_2_0_bundle;
	private final ModelPart sail_1_rope_4;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart sail_1_rope_0;
	private final ModelPart cube_r1;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart sail_1_rope_1;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart sail_1_rope_2;
	private final ModelPart cube_r10;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart sail_1_rope_3;
	private final ModelPart cube_r13;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart sail_2_rope_4;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart sail_2_rope_0;
	private final ModelPart cube_r19;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart sail_2_rope_1;
	private final ModelPart cube_r22;
	private final ModelPart cube_r23;
	private final ModelPart cube_r24;
	private final ModelPart sail_2_rope_2;
	private final ModelPart cube_r25;
	private final ModelPart cube_r26;
	private final ModelPart cube_r27;
	private final ModelPart sail_2_rope_3;
	private final ModelPart cube_r28;
	private final ModelPart cube_r29;
	private final ModelPart cube_r30;
	private final ModelPart rope_1;
	private final ModelPart cube_r31;
	private final ModelPart cube_r32;
	private final ModelPart cube_r33;
	private final ModelPart rope_2;
	private final ModelPart cube_r34;
	private final ModelPart cube_r35;
	private final ModelPart cube_r36;
	private final ModelPart rope_3;
	private final ModelPart cube_r37;
	private final ModelPart cube_r38;
	private final ModelPart cube_r39;

	public CaravelSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.CaravelSail = root.getChild("CaravelSail");
		this.sail_1 = this.CaravelSail.getChild("sail_1");
		this.sail_1_4 = this.sail_1.getChild("sail_1_4");
		this.Base81 = this.sail_1_4.getChild("Base81");
		this.Base82 = this.Base81.getChild("Base82");
		this.Base83 = this.Base82.getChild("Base83");
		this.Base84 = this.Base83.getChild("Base84");
		this.Base85 = this.sail_1_4.getChild("Base85");
		this.Base86 = this.Base85.getChild("Base86");
		this.Base87 = this.Base86.getChild("Base87");
		this.Base88 = this.Base87.getChild("Base88");
		this.Base89 = this.sail_1_4.getChild("Base89");
		this.Base90 = this.Base89.getChild("Base90");
		this.Base91 = this.Base90.getChild("Base91");
		this.Base92 = this.Base91.getChild("Base92");
		this.Base93 = this.sail_1_4.getChild("Base93");
		this.Base94 = this.Base93.getChild("Base94");
		this.Base95 = this.Base94.getChild("Base95");
		this.Base96 = this.Base95.getChild("Base96");
		this.Base97 = this.sail_1_4.getChild("Base97");
		this.Base98 = this.Base97.getChild("Base98");
		this.Base99 = this.Base98.getChild("Base99");
		this.Base100 = this.Base99.getChild("Base100");
		this.sail_1_3 = this.sail_1.getChild("sail_1_3");
		this.Base101 = this.sail_1_3.getChild("Base101");
		this.Base102 = this.Base101.getChild("Base102");
		this.Base103 = this.Base102.getChild("Base103");
		this.Base104 = this.sail_1_3.getChild("Base104");
		this.Base105 = this.Base104.getChild("Base105");
		this.Base106 = this.Base105.getChild("Base106");
		this.Base107 = this.sail_1_3.getChild("Base107");
		this.Base108 = this.Base107.getChild("Base108");
		this.Base109 = this.Base108.getChild("Base109");
		this.Base110 = this.sail_1_3.getChild("Base110");
		this.Base111 = this.Base110.getChild("Base111");
		this.Base112 = this.Base111.getChild("Base112");
		this.Base113 = this.sail_1_3.getChild("Base113");
		this.Base114 = this.Base113.getChild("Base114");
		this.Base115 = this.Base114.getChild("Base115");
		this.sail_1_3_bottom = this.sail_1_3.getChild("sail_1_3_bottom");
		this.Base116 = this.sail_1_3_bottom.getChild("Base116");
		this.Base117 = this.Base116.getChild("Base117");
		this.Base118 = this.Base117.getChild("Base118");
		this.sail_1_2 = this.sail_1.getChild("sail_1_2");
		this.Base119 = this.sail_1_2.getChild("Base119");
		this.Base120 = this.Base119.getChild("Base120");
		this.Base121 = this.sail_1_2.getChild("Base121");
		this.Base122 = this.Base121.getChild("Base122");
		this.Base123 = this.sail_1_2.getChild("Base123");
		this.Base124 = this.Base123.getChild("Base124");
		this.Base125 = this.sail_1_2.getChild("Base125");
		this.Base126 = this.Base125.getChild("Base126");
		this.Base127 = this.sail_1_2.getChild("Base127");
		this.Base128 = this.Base127.getChild("Base128");
		this.sail_1_2_bottom = this.sail_1_2.getChild("sail_1_2_bottom");
		this.Base129 = this.sail_1_2_bottom.getChild("Base129");
		this.Base130 = this.Base129.getChild("Base130");
		this.sail_1_1 = this.sail_1.getChild("sail_1_1");
		this.Base131 = this.sail_1_1.getChild("Base131");
		this.Base132 = this.sail_1_1.getChild("Base132");
		this.Base133 = this.sail_1_1.getChild("Base133");
		this.Base134 = this.sail_1_1.getChild("Base134");
		this.Base135 = this.sail_1_1.getChild("Base135");
		this.sail_1_1_bottom = this.sail_1_1.getChild("sail_1_1_bottom");
		this.Base136 = this.sail_1_1_bottom.getChild("Base136");
		this.sail_1_0 = this.sail_1.getChild("sail_1_0");
		this.sail_1_0_bundle = this.sail_1_0.getChild("sail_1_0_bundle");
		this.sail_2 = this.CaravelSail.getChild("sail_2");
		this.sail_2_4 = this.sail_2.getChild("sail_2_4");
		this.Base137 = this.sail_2_4.getChild("Base137");
		this.Base138 = this.Base137.getChild("Base138");
		this.Base139 = this.Base138.getChild("Base139");
		this.Base140 = this.sail_2_4.getChild("Base140");
		this.Base141 = this.Base140.getChild("Base141");
		this.Base142 = this.Base141.getChild("Base142");
		this.Base143 = this.sail_2_4.getChild("Base143");
		this.Base144 = this.Base143.getChild("Base144");
		this.sail_2_3 = this.sail_2.getChild("sail_2_3");
		this.Base145 = this.sail_2_3.getChild("Base145");
		this.Base146 = this.Base145.getChild("Base146");
		this.Base147 = this.sail_2_3.getChild("Base147");
		this.Base148 = this.Base147.getChild("Base148");
		this.Base149 = this.sail_2_3.getChild("Base149");
		this.Base150 = this.Base149.getChild("Base150");
		this.sail_2_3_bottom = this.sail_2_3.getChild("sail_2_3_bottom");
		this.Base151 = this.sail_2_3_bottom.getChild("Base151");
		this.Base152 = this.Base151.getChild("Base152");
		this.sail_2_2 = this.sail_2.getChild("sail_2_2");
		this.Base153 = this.sail_2_2.getChild("Base153");
		this.Base154 = this.Base153.getChild("Base154");
		this.Base155 = this.sail_2_2.getChild("Base155");
		this.Base156 = this.sail_2_2.getChild("Base156");
		this.sail_2_2_bottom = this.sail_2_2.getChild("sail_2_2_bottom");
		this.Base157 = this.sail_2_2_bottom.getChild("Base157");
		this.Base158 = this.Base157.getChild("Base158");
		this.sail_2_1 = this.sail_2.getChild("sail_2_1");
		this.Base159 = this.sail_2_1.getChild("Base159");
		this.Base160 = this.sail_2_1.getChild("Base160");
		this.Base161 = this.sail_2_1.getChild("Base161");
		this.sail_2_1_bottom = this.sail_2_1.getChild("sail_2_1_bottom");
		this.Base162 = this.sail_2_1_bottom.getChild("Base162");
		this.sail_2_0 = this.sail_2.getChild("sail_2_0");
		this.sail_2_0_bundle = this.sail_2_0.getChild("sail_2_0_bundle");
		this.sail_1_rope_4 = this.CaravelSail.getChild("sail_1_rope_4");
		this.cube_r14 = this.sail_1_rope_4.getChild("cube_r14");
		this.cube_r15 = this.sail_1_rope_4.getChild("cube_r15");
		this.cube_r16 = this.sail_1_rope_4.getChild("cube_r16");
		this.sail_1_rope_0 = this.CaravelSail.getChild("sail_1_rope_0");
		this.cube_r1 = this.sail_1_rope_0.getChild("cube_r1");
		this.cube_r5 = this.sail_1_rope_0.getChild("cube_r5");
		this.cube_r6 = this.sail_1_rope_0.getChild("cube_r6");
		this.sail_1_rope_1 = this.CaravelSail.getChild("sail_1_rope_1");
		this.cube_r7 = this.sail_1_rope_1.getChild("cube_r7");
		this.cube_r8 = this.sail_1_rope_1.getChild("cube_r8");
		this.cube_r9 = this.sail_1_rope_1.getChild("cube_r9");
		this.sail_1_rope_2 = this.CaravelSail.getChild("sail_1_rope_2");
		this.cube_r10 = this.sail_1_rope_2.getChild("cube_r10");
		this.cube_r11 = this.sail_1_rope_2.getChild("cube_r11");
		this.cube_r12 = this.sail_1_rope_2.getChild("cube_r12");
		this.sail_1_rope_3 = this.CaravelSail.getChild("sail_1_rope_3");
		this.cube_r13 = this.sail_1_rope_3.getChild("cube_r13");
		this.cube_r17 = this.sail_1_rope_3.getChild("cube_r17");
		this.cube_r18 = this.sail_1_rope_3.getChild("cube_r18");
		this.sail_2_rope_4 = this.CaravelSail.getChild("sail_2_rope_4");
		this.cube_r2 = this.sail_2_rope_4.getChild("cube_r2");
		this.cube_r3 = this.sail_2_rope_4.getChild("cube_r3");
		this.cube_r4 = this.sail_2_rope_4.getChild("cube_r4");
		this.sail_2_rope_0 = this.CaravelSail.getChild("sail_2_rope_0");
		this.cube_r19 = this.sail_2_rope_0.getChild("cube_r19");
		this.cube_r20 = this.sail_2_rope_0.getChild("cube_r20");
		this.cube_r21 = this.sail_2_rope_0.getChild("cube_r21");
		this.sail_2_rope_1 = this.CaravelSail.getChild("sail_2_rope_1");
		this.cube_r22 = this.sail_2_rope_1.getChild("cube_r22");
		this.cube_r23 = this.sail_2_rope_1.getChild("cube_r23");
		this.cube_r24 = this.sail_2_rope_1.getChild("cube_r24");
		this.sail_2_rope_2 = this.CaravelSail.getChild("sail_2_rope_2");
		this.cube_r25 = this.sail_2_rope_2.getChild("cube_r25");
		this.cube_r26 = this.sail_2_rope_2.getChild("cube_r26");
		this.cube_r27 = this.sail_2_rope_2.getChild("cube_r27");
		this.sail_2_rope_3 = this.CaravelSail.getChild("sail_2_rope_3");
		this.cube_r28 = this.sail_2_rope_3.getChild("cube_r28");
		this.cube_r29 = this.sail_2_rope_3.getChild("cube_r29");
		this.cube_r30 = this.sail_2_rope_3.getChild("cube_r30");
		this.rope_1 = this.CaravelSail.getChild("rope_1");
		this.cube_r31 = this.rope_1.getChild("cube_r31");
		this.cube_r32 = this.rope_1.getChild("cube_r32");
		this.cube_r33 = this.rope_1.getChild("cube_r33");
		this.rope_2 = this.CaravelSail.getChild("rope_2");
		this.cube_r34 = this.rope_2.getChild("cube_r34");
		this.cube_r35 = this.rope_2.getChild("cube_r35");
		this.cube_r36 = this.rope_2.getChild("cube_r36");
		this.rope_3 = this.CaravelSail.getChild("rope_3");
		this.cube_r37 = this.rope_3.getChild("cube_r37");
		this.cube_r38 = this.rope_3.getChild("cube_r38");
		this.cube_r39 = this.rope_3.getChild("cube_r39");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition CaravelSail = partdefinition.addOrReplaceChild("CaravelSail", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 42.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sail_1 = CaravelSail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offset(-13.6924F, -79.134F, -16.0247F));

		PartDefinition sail_1_4 = sail_1.addOrReplaceChild("sail_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base81 = sail_1_4.addOrReplaceChild("Base81", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, -43.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base82 = Base81.addOrReplaceChild("Base82", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base83 = Base82.addOrReplaceChild("Base83", CubeListBuilder.create().texOffs(80, 7).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base84 = Base83.addOrReplaceChild("Base84", CubeListBuilder.create().texOffs(80, 14).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base85 = sail_1_4.addOrReplaceChild("Base85", CubeListBuilder.create().texOffs(67, 3).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -4.0F, -39.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base86 = Base85.addOrReplaceChild("Base86", CubeListBuilder.create().texOffs(80, 3).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.0F, 0.0249F, 0.0F));

		PartDefinition Base87 = Base86.addOrReplaceChild("Base87", CubeListBuilder.create().texOffs(66, 31).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.0F, 0.0249F, 0.0F));

		PartDefinition Base88 = Base87.addOrReplaceChild("Base88", CubeListBuilder.create().texOffs(80, 17).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.0F, 0.0249F, 0.0F));

		PartDefinition Base89 = sail_1_4.addOrReplaceChild("Base89", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -8.0F, -35.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base90 = Base89.addOrReplaceChild("Base90", CubeListBuilder.create().texOffs(80, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0236F, 0.0F));

		PartDefinition Base91 = Base90.addOrReplaceChild("Base91", CubeListBuilder.create().texOffs(66, 34).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0236F, 0.0F));

		PartDefinition Base92 = Base91.addOrReplaceChild("Base92", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0236F, 0.0F));

		PartDefinition Base93 = sail_1_4.addOrReplaceChild("Base93", CubeListBuilder.create().texOffs(66, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -12.0F, -31.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base94 = Base93.addOrReplaceChild("Base94", CubeListBuilder.create().texOffs(80, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, 0.0F, 0.0223F, 0.0F));

		PartDefinition Base95 = Base94.addOrReplaceChild("Base95", CubeListBuilder.create().texOffs(66, 37).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, 0.0F, 0.0223F, 0.0F));

		PartDefinition Base96 = Base95.addOrReplaceChild("Base96", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, 0.0F, 0.0223F, 0.0F));

		PartDefinition Base97 = sail_1_4.addOrReplaceChild("Base97", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -16.0F, -27.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base98 = Base97.addOrReplaceChild("Base98", CubeListBuilder.create().texOffs(65, 19).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition Base99 = Base98.addOrReplaceChild("Base99", CubeListBuilder.create().texOffs(66, 40).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition Base100 = Base99.addOrReplaceChild("Base100", CubeListBuilder.create().texOffs(65, 3).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition sail_1_3 = sail_1.addOrReplaceChild("sail_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base101 = sail_1_3.addOrReplaceChild("Base101", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -20.0F, -23.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base102 = Base101.addOrReplaceChild("Base102", CubeListBuilder.create().texOffs(80, 15).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base103 = Base102.addOrReplaceChild("Base103", CubeListBuilder.create().texOffs(80, 22).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base104 = sail_1_3.addOrReplaceChild("Base104", CubeListBuilder.create().texOffs(66, 32).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -24.0F, -19.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base105 = Base104.addOrReplaceChild("Base105", CubeListBuilder.create().texOffs(67, 36).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.6667F, 0.0F, 0.0244F, 0.0F));

		PartDefinition Base106 = Base105.addOrReplaceChild("Base106", CubeListBuilder.create().texOffs(67, 2).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.6667F, 0.0F, 0.0244F, 0.0F));

		PartDefinition Base107 = sail_1_3.addOrReplaceChild("Base107", CubeListBuilder.create().texOffs(66, 35).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -28.0F, -15.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base108 = Base107.addOrReplaceChild("Base108", CubeListBuilder.create().texOffs(66, 42).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.3333F, 0.0F, 0.0227F, 0.0F));

		PartDefinition Base109 = Base108.addOrReplaceChild("Base109", CubeListBuilder.create().texOffs(66, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 17.3333F, 0.0F, 0.0227F, 0.0F));

		PartDefinition Base110 = sail_1_3.addOrReplaceChild("Base110", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -32.0F, -11.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base111 = Base110.addOrReplaceChild("Base111", CubeListBuilder.create().texOffs(65, 1).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition Base112 = Base111.addOrReplaceChild("Base112", CubeListBuilder.create().texOffs(65, 26).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition Base113 = sail_1_3.addOrReplaceChild("Base113", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -36.0F, -7.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base114 = Base113.addOrReplaceChild("Base114", CubeListBuilder.create().texOffs(65, 4).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.0192F, 0.0F));

		PartDefinition Base115 = Base114.addOrReplaceChild("Base115", CubeListBuilder.create().texOffs(65, 11).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.0192F, 0.0F));

		PartDefinition sail_1_3_bottom = sail_1_3.addOrReplaceChild("sail_1_3_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -20.0F, -23.5F));

		PartDefinition Base116 = sail_1_3_bottom.addOrReplaceChild("Base116", CubeListBuilder.create().texOffs(80, 8).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base117 = Base116.addOrReplaceChild("Base117", CubeListBuilder.create().texOffs(80, 15).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base118 = Base117.addOrReplaceChild("Base118", CubeListBuilder.create().texOffs(82, 34).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition sail_1_2 = sail_1.addOrReplaceChild("sail_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base119 = sail_1_2.addOrReplaceChild("Base119", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -40.0F, -3.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base120 = Base119.addOrReplaceChild("Base120", CubeListBuilder.create().texOffs(74, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base121 = sail_1_2.addOrReplaceChild("Base121", CubeListBuilder.create().texOffs(71, 26).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -44.0F, 0.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base122 = Base121.addOrReplaceChild("Base122", CubeListBuilder.create().texOffs(73, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0236F, 0.0F));

		PartDefinition Base123 = sail_1_2.addOrReplaceChild("Base123", CubeListBuilder.create().texOffs(65, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -48.0F, 4.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base124 = Base123.addOrReplaceChild("Base124", CubeListBuilder.create().texOffs(80, 6).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0209F, 0.0F));

		PartDefinition Base125 = sail_1_2.addOrReplaceChild("Base125", CubeListBuilder.create().texOffs(65, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -52.0F, 8.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base126 = Base125.addOrReplaceChild("Base126", CubeListBuilder.create().texOffs(80, 9).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, 0.0F, 0.0183F, 0.0F));

		PartDefinition Base127 = sail_1_2.addOrReplaceChild("Base127", CubeListBuilder.create().texOffs(65, 12).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -56.0F, 12.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base128 = Base127.addOrReplaceChild("Base128", CubeListBuilder.create().texOffs(66, 24).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, 0.0F, 0.0157F, 0.0F));

		PartDefinition sail_1_2_bottom = sail_1_2.addOrReplaceChild("sail_1_2_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -40.0F, -3.5F));

		PartDefinition Base129 = sail_1_2_bottom.addOrReplaceChild("Base129", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base130 = Base129.addOrReplaceChild("Base130", CubeListBuilder.create().texOffs(80, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition sail_1_1 = sail_1.addOrReplaceChild("sail_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base131 = sail_1_1.addOrReplaceChild("Base131", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -60.0F, 16.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base132 = sail_1_1.addOrReplaceChild("Base132", CubeListBuilder.create().texOffs(65, 18).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -64.0F, 20.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base133 = sail_1_1.addOrReplaceChild("Base133", CubeListBuilder.create().texOffs(66, 26).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -68.0F, 24.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base134 = sail_1_1.addOrReplaceChild("Base134", CubeListBuilder.create().texOffs(65, 24).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -72.0F, 28.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base135 = sail_1_1.addOrReplaceChild("Base135", CubeListBuilder.create().texOffs(65, 27).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -76.0F, 32.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_1_1_bottom = sail_1_1.addOrReplaceChild("sail_1_1_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -60.0F, 16.5F));

		PartDefinition Base136 = sail_1_1_bottom.addOrReplaceChild("Base136", CubeListBuilder.create().texOffs(78, 0).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_1_0 = sail_1.addOrReplaceChild("sail_1_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_0_bundle = sail_1_0.addOrReplaceChild("sail_1_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r40 = sail_1_0_bundle.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(85, 29).addBox(-3.0F, -3.0F, 100.5663F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(73, 23).addBox(-3.0F, -3.0F, 87.9955F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(90, 41).addBox(-3.0F, -3.0F, 75.4247F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(77, 13).addBox(-3.0F, -3.0F, 62.8539F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(69, 25).addBox(-3.0F, -3.0F, 50.2832F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(89, 9).addBox(-3.0F, -3.0F, 37.7124F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(67, 0).addBox(-3.0F, -3.0F, 25.1416F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(85, 19).addBox(-3.0F, -3.0F, 12.5708F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(65, 22).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition sail_2 = CaravelSail.addOrReplaceChild("sail_2", CubeListBuilder.create(), PartPose.offset(-13.6924F, -79.134F, 42.9753F));

		PartDefinition sail_2_4 = sail_2.addOrReplaceChild("sail_2_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base137 = sail_2_4.addOrReplaceChild("Base137", CubeListBuilder.create().texOffs(92, 32).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, -43.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base138 = Base137.addOrReplaceChild("Base138", CubeListBuilder.create().texOffs(71, 31).addBox(-6.0346F, -4.0F, -6.2172F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0349F, 0.0F));

		PartDefinition Base139 = Base138.addOrReplaceChild("Base139", CubeListBuilder.create().texOffs(80, 7).addBox(-5.8145F, -4.0F, -6.3891F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0349F, 0.0F));

		PartDefinition Base140 = sail_2_4.addOrReplaceChild("Base140", CubeListBuilder.create().texOffs(94, 22).addBox(-6.0F, -4.0F, 0.0F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F))
				.texOffs(102, 30).addBox(-6.0F, -4.0F, -6.0333F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -4.0F, -39.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base141 = Base140.addOrReplaceChild("Base141", CubeListBuilder.create().texOffs(65, 28).addBox(-6.0526F, -4.0F, -6.2025F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.032F, 0.0F));

		PartDefinition Base142 = Base141.addOrReplaceChild("Base142", CubeListBuilder.create().texOffs(65, 17).addBox(-5.8516F, -4.0F, -6.361F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.6667F, 0.0F, 0.032F, 0.0F));

		PartDefinition Base143 = sail_2_4.addOrReplaceChild("Base143", CubeListBuilder.create().texOffs(84, 23).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -8.0F, -35.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base144 = Base143.addOrReplaceChild("Base144", CubeListBuilder.create().texOffs(80, 6).addBox(-5.9801F, -4.0F, -6.2609F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition sail_2_3 = sail_2.addOrReplaceChild("sail_2_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base145 = sail_2_3.addOrReplaceChild("Base145", CubeListBuilder.create().texOffs(80, 2).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -12.0F, -31.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base146 = Base145.addOrReplaceChild("Base146", CubeListBuilder.create().texOffs(80, 9).addBox(-6.0074F, -4.0F, -6.2391F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0393F, 0.0F));

		PartDefinition Base147 = sail_2_3.addOrReplaceChild("Base147", CubeListBuilder.create().texOffs(92, 16).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -16.0F, -27.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base148 = Base147.addOrReplaceChild("Base148", CubeListBuilder.create().texOffs(65, 19).addBox(-6.0346F, -4.0F, -6.2172F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.0349F, 0.0F));

		PartDefinition Base149 = sail_2_3.addOrReplaceChild("Base149", CubeListBuilder.create().texOffs(80, 8).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -20.0F, -23.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base150 = Base149.addOrReplaceChild("Base150", CubeListBuilder.create().texOffs(66, 36).addBox(-6.0616F, -4.0F, -6.1951F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, 0.0F, 0.0305F, 0.0F));

		PartDefinition sail_2_3_bottom = sail_2_3.addOrReplaceChild("sail_2_3_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -12.0F, -31.5F));

		PartDefinition Base151 = sail_2_3_bottom.addOrReplaceChild("Base151", CubeListBuilder.create().texOffs(86, 43).addBox(-6.7485F, -3.0F, -6.0377F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base152 = Base151.addOrReplaceChild("Base152", CubeListBuilder.create().texOffs(86, 14).addBox(-6.5074F, -3.0F, -6.2391F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.0393F, 0.0F));

		PartDefinition sail_2_2 = sail_2.addOrReplaceChild("sail_2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base153 = sail_2_2.addOrReplaceChild("Base153", CubeListBuilder.create().texOffs(80, 11).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -24.0F, -19.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base154 = Base153.addOrReplaceChild("Base154", CubeListBuilder.create().texOffs(66, 39).addBox(-6.0886F, -4.0F, -6.173F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition Base155 = sail_2_2.addOrReplaceChild("Base155", CubeListBuilder.create().texOffs(68, 31).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -28.0F, -15.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base156 = sail_2_2.addOrReplaceChild("Base156", CubeListBuilder.create().texOffs(66, 38).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -32.0F, -11.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_2_2_bottom = sail_2_2.addOrReplaceChild("sail_2_2_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -24.0F, -19.5F));

		PartDefinition Base157 = sail_2_2_bottom.addOrReplaceChild("Base157", CubeListBuilder.create().texOffs(96, 0).addBox(-7.2485F, -4.0F, -6.0377F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base158 = Base157.addOrReplaceChild("Base158", CubeListBuilder.create().texOffs(66, 39).addBox(-7.0886F, -4.0F, -6.173F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, 0.0F, 0.0262F, 0.0F));

		PartDefinition sail_2_1 = sail_2.addOrReplaceChild("sail_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base159 = sail_2_1.addOrReplaceChild("Base159", CubeListBuilder.create().texOffs(66, 41).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -36.0F, -7.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base160 = sail_2_1.addOrReplaceChild("Base160", CubeListBuilder.create().texOffs(65, 0).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -40.0F, -3.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition Base161 = sail_2_1.addOrReplaceChild("Base161", CubeListBuilder.create().texOffs(65, 3).addBox(-6.2485F, -4.0F, -6.0377F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -44.0F, 0.5F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_2_1_bottom = sail_2_1.addOrReplaceChild("sail_2_1_bottom", CubeListBuilder.create(), PartPose.offset(-0.2F, -36.0F, -7.5F));

		PartDefinition Base162 = sail_2_1_bottom.addOrReplaceChild("Base162", CubeListBuilder.create().texOffs(94, 41).addBox(-7.7485F, -5.0F, -6.0377F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -0.1047F, 0.0F));

		PartDefinition sail_2_0 = sail_2.addOrReplaceChild("sail_2_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_0_bundle = sail_2_0.addOrReplaceChild("sail_2_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r41 = sail_2_0_bundle.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(88, 27).addBox(-7.5886F, -7.6338F, 49.672F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(88, 0).addBox(-7.5886F, -7.6338F, 36.0955F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-7.5886F, -7.6338F, 22.5191F, 6.0F, 6.0F, 13.5764F, new CubeDeformation(0.0F))
				.texOffs(88, 44).addBox(-7.5886F, -7.6338F, 8.9426F, 6.0F, 6.0F, 13.5764F, new CubeDeformation(0.0F))
				.texOffs(66, 33).addBox(-7.5886F, -7.6338F, -4.6338F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition sail_1_rope_4 = CaravelSail.addOrReplaceChild("sail_1_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -38.4146F, 10.8099F, 0.0436F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = sail_1_rope_4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = sail_1_rope_4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = sail_1_rope_4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_0 = CaravelSail.addOrReplaceChild("sail_1_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -38.4146F, 10.8099F, -0.0169F, -0.0041F, -0.0693F));

		PartDefinition cube_r1 = sail_1_rope_0.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(24.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(37.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(50.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(63.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(76.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(89.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r5 = sail_1_rope_0.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r6 = sail_1_rope_0.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_1 = CaravelSail.addOrReplaceChild("sail_1_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -38.4146F, 10.8099F, -0.0062F, -0.0052F, -0.1036F));

		PartDefinition cube_r7 = sail_1_rope_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(24.2601F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(39.2602F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(54.2601F, -0.6478F, -17.7881F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(68.2602F, -0.6478F, -17.7881F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r8 = sail_1_rope_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r9 = sail_1_rope_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_2 = CaravelSail.addOrReplaceChild("sail_1_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -38.4146F, 10.8099F, 0.0059F, -0.0058F, -0.1516F));

		PartDefinition cube_r10 = sail_1_rope_2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(24.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(37.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(50.2601F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r11 = sail_1_rope_2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r12 = sail_1_rope_2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_3 = CaravelSail.addOrReplaceChild("sail_1_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -38.4146F, 10.8099F, 0.0208F, -0.005F, -0.2296F));

		PartDefinition cube_r13 = sail_1_rope_3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(24.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(34.2602F, -0.6478F, -17.7881F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r17 = sail_1_rope_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r18 = sail_1_rope_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_4 = CaravelSail.addOrReplaceChild("sail_2_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -46.4146F, 51.8099F, 0.4363F, -0.2618F, -0.0436F));

		PartDefinition cube_r2 = sail_2_rope_4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 26).addBox(-3.4741F, -2.7184F, -24.7915F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(13.5259F, -2.7184F, -24.7915F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(2.5259F, -1.4684F, -24.7915F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(2.5259F, -3.9684F, -24.7915F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = sail_2_rope_4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 10).addBox(-14.5986F, -17.8359F, -8.2915F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = sail_2_rope_4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 4).addBox(-13.4486F, -16.5859F, -8.2915F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_0 = CaravelSail.addOrReplaceChild("sail_2_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -46.4146F, 51.8099F, 0.1038F, -0.2814F, 0.0326F));

		PartDefinition cube_r19 = sail_2_rope_0.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 26).addBox(-5.9432F, -2.8694F, -25.4321F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(11.0568F, -2.8694F, -25.4321F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.0568F, -1.6194F, -25.4321F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.0568F, -4.1194F, -25.4321F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(17.0568F, -2.8694F, -25.4321F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(29.0568F, -2.8694F, -25.4321F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(41.0568F, -2.8694F, -25.4321F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(53.0568F, -2.8694F, -25.4321F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r20 = sail_2_rope_0.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(9, 10).addBox(-16.2377F, -19.6885F, -8.9321F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r21 = sail_2_rope_0.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(16, 4).addBox(-15.0877F, -18.4385F, -8.9321F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_1 = CaravelSail.addOrReplaceChild("sail_2_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -46.4146F, 51.8099F, 0.1402F, -0.2787F, 0.0183F));

		PartDefinition cube_r22 = sail_2_rope_1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 26).addBox(-5.6651F, -2.8485F, -25.404F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(11.3349F, -2.8485F, -25.404F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.3349F, -1.5985F, -25.404F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.3349F, -4.0985F, -25.404F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(17.3349F, -2.8485F, -25.404F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(29.3349F, -2.8485F, -25.404F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(41.3349F, -2.8485F, -25.404F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r23 = sail_2_rope_1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(9, 10).addBox(-16.0559F, -19.4772F, -8.904F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r24 = sail_2_rope_1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(16, 4).addBox(-14.9059F, -18.2272F, -8.904F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_2 = CaravelSail.addOrReplaceChild("sail_2_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -46.4146F, 51.8099F, 0.1911F, -0.2755F, 0.003F));

		PartDefinition cube_r25 = sail_2_rope_2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 26).addBox(-5.2778F, -2.8243F, -25.3463F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(11.7222F, -2.8243F, -25.3463F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.7222F, -1.5743F, -25.3463F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(0.7222F, -4.0743F, -25.3463F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(17.7222F, -2.8243F, -25.3463F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(29.7222F, -2.8243F, -25.3463F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r26 = sail_2_rope_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(9, 10).addBox(-15.7991F, -19.1861F, -8.8463F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r27 = sail_2_rope_2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(16, 4).addBox(-14.6491F, -17.9361F, -8.8463F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_3 = CaravelSail.addOrReplaceChild("sail_2_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -46.4146F, 51.8099F, 0.2766F, -0.2694F, -0.0204F));

		PartDefinition cube_r28 = sail_2_rope_3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 26).addBox(-4.6339F, -2.7769F, -25.2065F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(12.3661F, -2.7769F, -25.2065F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(1.3661F, -1.5269F, -25.2065F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(1.3661F, -4.0269F, -25.2065F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(18.3661F, -2.7769F, -25.2065F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r29 = sail_2_rope_3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(9, 10).addBox(-15.3773F, -18.6973F, -8.7065F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r30 = sail_2_rope_3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(16, 4).addBox(-14.2273F, -17.4473F, -8.7065F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_1 = CaravelSail.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.9F, -46.4146F, 70.8099F, 0.4102F, 0.0F, 0.0F));

		PartDefinition cube_r31 = rope_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 26).addBox(-3.5499F, -0.6478F, -25.1246F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(13.4501F, -0.6478F, -25.1246F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(19.4501F, -0.6478F, -25.1246F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(2.4501F, 0.6022F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(2.4501F, -1.8978F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(27.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(40.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(53.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(66.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(79.4501F, -0.6478F, -25.1246F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = rope_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(9, 10).addBox(-16.1163F, -16.4253F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r33 = rope_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(16, 4).addBox(-14.9663F, -15.1753F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = CaravelSail.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6F, -49.4146F, -70.1901F, -0.5585F, 0.0F, 0.0F));

		PartDefinition cube_r34 = rope_2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(24.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(37.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(50.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(63.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(76.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = rope_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r36 = rope_2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = CaravelSail.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6F, -125.4146F, -22.1901F, -1.5882F, 0.0F, 0.0F));

		PartDefinition cube_r37 = rope_3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(-4, 24).addBox(6.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(16.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(-2, 24).addBox(29.2602F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r38 = rope_3.addOrReplaceChild("cube_r38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r39 = rope_3.addOrReplaceChild("cube_r39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Ship entity, float f, float g, float h, float i, float j) {
		switch (entity.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				this.sail_1_0.visible = true;
				this.sail_1_1.visible = false;
				this.sail_1_2.visible = false;
				this.sail_1_3.visible = false;
				this.sail_1_4.visible = false;

				this.sail_1_1_bottom.visible = false;
				this.sail_1_2_bottom.visible = false;
				this.sail_1_3_bottom.visible = false;

				this.sail_2_0.visible = true;
				this.sail_2_1.visible = false;
				this.sail_2_2.visible = false;
				this.sail_2_3.visible = false;
				this.sail_2_4.visible = false;

				this.sail_2_1_bottom.visible = false;
				this.sail_2_2_bottom.visible = false;
				this.sail_2_3_bottom.visible = false;
			}
			case 1 -> {
				this.sail_1_0.visible = false;
				this.sail_1_1.visible = true;
				this.sail_1_2.visible = false;
				this.sail_1_3.visible = false;
				this.sail_1_4.visible = false;

				this.sail_1_1_bottom.visible = true;
				this.sail_1_2_bottom.visible = false;
				this.sail_1_3_bottom.visible = false;

				this.sail_2_0.visible = false;
				this.sail_2_1.visible = true;
				this.sail_2_2.visible = false;
				this.sail_2_3.visible = false;
				this.sail_2_4.visible = false;

				this.sail_2_1_bottom.visible = true;
				this.sail_2_2_bottom.visible = false;
				this.sail_2_3_bottom.visible = false;
			}
			case 2 -> {
				this.sail_1_0.visible = false;
				this.sail_1_1.visible = true;
				this.sail_1_2.visible = true;
				this.sail_1_3.visible = false;
				this.sail_1_4.visible = false;
				this.sail_1_1_bottom.visible = false;
				this.sail_1_2_bottom.visible = true;
				this.sail_1_3_bottom.visible = false;

				this.sail_2_0.visible = false;
				this.sail_2_1.visible = true;
				this.sail_2_2.visible = true;
				this.sail_2_3.visible = false;
				this.sail_2_4.visible = false;
				this.sail_2_1_bottom.visible = false;
				this.sail_2_2_bottom.visible = true;
				this.sail_2_3_bottom.visible = false;
			}
			case 3 -> {
				this.sail_1_0.visible = false;
				this.sail_1_1.visible = true;
				this.sail_1_2.visible = true;
				this.sail_1_3.visible = true;
				this.sail_1_4.visible = false;
				this.sail_1_1_bottom.visible = false;
				this.sail_1_2_bottom.visible = false;
				this.sail_1_3_bottom.visible = true;

				this.sail_2_0.visible = false;
				this.sail_2_1.visible = true;
				this.sail_2_2.visible = true;
				this.sail_2_3.visible = true;
				this.sail_2_4.visible = false;
				this.sail_2_1_bottom.visible = false;
				this.sail_2_2_bottom.visible = false;
				this.sail_2_3_bottom.visible = true;
			}
			case 4 -> {
				this.sail_1_0.visible = false;
				this.sail_1_1.visible = true;
				this.sail_1_2.visible = true;
				this.sail_1_3.visible = true;
				this.sail_1_4.visible = true;
				this.sail_1_1_bottom.visible = false;
				this.sail_1_2_bottom.visible = false;
				this.sail_1_3_bottom.visible = false;

				this.sail_2_0.visible = false;
				this.sail_2_1.visible = true;
				this.sail_2_2.visible = true;
				this.sail_2_3.visible = true;
				this.sail_2_4.visible = true;
				this.sail_2_1_bottom.visible = false;
				this.sail_2_2_bottom.visible = false;
				this.sail_2_3_bottom.visible = false;
			}
		}

		this.sail_1_rope_0.visible = sail_1_0.visible;
		this.sail_1_rope_1.visible = sail_1_1_bottom.visible;
		this.sail_1_rope_2.visible = sail_1_2_bottom.visible;
		this.sail_1_rope_3.visible = sail_1_3_bottom.visible;
		this.sail_1_rope_4.visible = sail_1_4.visible;

		this.sail_2_rope_0.visible = sail_2_0.visible;
		this.sail_2_rope_1.visible = sail_2_1_bottom.visible;
		this.sail_2_rope_2.visible = sail_2_2_bottom.visible;
		this.sail_2_rope_3.visible = sail_2_3_bottom.visible;
		this.sail_2_rope_4.visible = sail_2_4.visible;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		CaravelSail.render(poseStack, buffer, packedLight, packedOverlay);
	}
}