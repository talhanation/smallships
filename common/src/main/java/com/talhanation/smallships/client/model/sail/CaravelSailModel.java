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
	private final ModelPart Base1;
	private final ModelPart Base2;
	private final ModelPart Base3;
	private final ModelPart Base4;
	private final ModelPart Base5;
	private final ModelPart sail_1_3;
	private final ModelPart sail_1_3_bottom;
	private final ModelPart Base6;
	private final ModelPart Base7;
	private final ModelPart Base8;
	private final ModelPart Base9;
	private final ModelPart Base10;
	private final ModelPart Base11;
	private final ModelPart Base12;
	private final ModelPart Base13;
	private final ModelPart Base14;
	private final ModelPart Base15;
	private final ModelPart sail_1_2;
	private final ModelPart sail_1_2_bottom;
	private final ModelPart Base16;
	private final ModelPart Base17;
	private final ModelPart Base18;
	private final ModelPart Base19;
	private final ModelPart Base20;
	private final ModelPart Base21;
	private final ModelPart Base22;
	private final ModelPart Base23;
	private final ModelPart Base24;
	private final ModelPart Base25;
	private final ModelPart Base26;
	private final ModelPart Base27;
	private final ModelPart Base28;
	private final ModelPart Base29;
	private final ModelPart Base30;
	private final ModelPart sail_1_1;
	private final ModelPart sail_1_1_bottom;
	private final ModelPart Base31;
	private final ModelPart Base32;
	private final ModelPart Base33;
	private final ModelPart Base34;
	private final ModelPart Base35;
	private final ModelPart Base36;
	private final ModelPart Base37;
	private final ModelPart Base38;
	private final ModelPart Base39;
	private final ModelPart Base40;
	private final ModelPart Base41;
	private final ModelPart Base42;
	private final ModelPart Base43;
	private final ModelPart Base44;
	private final ModelPart Base45;
	private final ModelPart Base46;
	private final ModelPart Base47;
	private final ModelPart Base48;
	private final ModelPart Base49;
	private final ModelPart Base50;
	private final ModelPart sail_1_0;
	private final ModelPart sail_1_0_bundle;
	private final ModelPart sail_2;
	private final ModelPart sail_2_4;
	private final ModelPart Base51;
	private final ModelPart Base52;
	private final ModelPart Base53;
	private final ModelPart sail_2_3;
	private final ModelPart sail_2_3_bottom;
	private final ModelPart Base54;
	private final ModelPart Base55;
	private final ModelPart Base56;
	private final ModelPart Base57;
	private final ModelPart Base58;
	private final ModelPart Base59;
	private final ModelPart sail_2_2;
	private final ModelPart sail_2_2_bottom;
	private final ModelPart Base60;
	private final ModelPart Base61;
	private final ModelPart Base62;
	private final ModelPart Base63;
	private final ModelPart Base64;
	private final ModelPart Base65;
	private final ModelPart Base66;
	private final ModelPart Base67;
	private final ModelPart Base68;
	private final ModelPart sail_2_1;
	private final ModelPart sail_2_1_bottom;
	private final ModelPart Base69;
	private final ModelPart Base70;
	private final ModelPart Base71;
	private final ModelPart Base72;
	private final ModelPart Base73;
	private final ModelPart Base74;
	private final ModelPart Base75;
	private final ModelPart Base76;
	private final ModelPart Base77;
	private final ModelPart Base78;
	private final ModelPart Base79;
	private final ModelPart Base80;
	private final ModelPart sail_2_0;
	private final ModelPart sail_2_0_bundle;
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
	private final ModelPart sail_1_rope_4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart sail_1_rope_3;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart sail_1_rope_2;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart sail_1_rope_1;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	private final ModelPart cube_r13;
	private final ModelPart sail_1_rope_0;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart sail_2_rope_0;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart cube_r22;
	private final ModelPart sail_2_rope_1;
	private final ModelPart cube_r17;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart sail_2_rope_2;
	private final ModelPart cube_r23;
	private final ModelPart cube_r24;
	private final ModelPart cube_r25;
	private final ModelPart sail_2_rope_3;
	private final ModelPart cube_r26;
	private final ModelPart cube_r27;
	private final ModelPart cube_r28;
	private final ModelPart sail_2_rope_4;
	private final ModelPart cube_r29;
	private final ModelPart cube_r30;
	private final ModelPart cube_r40;
	public CaravelSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.CaravelSail = root.getChild("CaravelSail");

		this.sail_1 = this.CaravelSail.getChild("sail_1");
		this.sail_1_4 = this.sail_1.getChild("sail_1_4");
		this.Base1 = this.sail_1_4.getChild("Base1");
		this.Base2 = this.Base1.getChild("Base2");
		this.Base3 = this.Base2.getChild("Base3");
		this.Base4 = this.Base3.getChild("Base4");
		this.Base5 = this.Base4.getChild("Base5");
		this.sail_1_3 = this.sail_1.getChild("sail_1_3");
		this.sail_1_3_bottom = this.sail_1_3.getChild("sail_1_3_bottom");
		this.Base6 = this.sail_1_3.getChild("Base6");
		this.Base7 = this.Base6.getChild("Base7");
		this.Base8 = this.Base7.getChild("Base8");
		this.Base9 = this.Base8.getChild("Base9");
		this.Base10 = this.Base9.getChild("Base10");
		this.Base11 = this.Base10.getChild("Base11");
		this.Base12 = this.Base11.getChild("Base12");
		this.Base13 = this.Base12.getChild("Base13");
		this.Base14 = this.Base13.getChild("Base14");
		this.Base15 = this.Base14.getChild("Base15");
		this.sail_1_2 = this.sail_1.getChild("sail_1_2");
		this.sail_1_2_bottom = this.sail_1_2.getChild("sail_1_2_bottom");
		this.Base16 = this.sail_1_2.getChild("Base16");
		this.Base17 = this.Base16.getChild("Base17");
		this.Base18 = this.Base17.getChild("Base18");
		this.Base19 = this.Base18.getChild("Base19");
		this.Base20 = this.Base19.getChild("Base20");
		this.Base21 = this.Base20.getChild("Base21");
		this.Base22 = this.Base21.getChild("Base22");
		this.Base23 = this.Base22.getChild("Base23");
		this.Base24 = this.Base23.getChild("Base24");
		this.Base25 = this.Base24.getChild("Base25");
		this.Base26 = this.Base25.getChild("Base26");
		this.Base27 = this.Base26.getChild("Base27");
		this.Base28 = this.Base27.getChild("Base28");
		this.Base29 = this.Base28.getChild("Base29");
		this.Base30 = this.Base29.getChild("Base30");
		this.sail_1_1 = this.sail_1.getChild("sail_1_1");
		this.sail_1_1_bottom = this.sail_1_1.getChild("sail_1_1_bottom");
		this.Base31 = this.sail_1_1.getChild("Base31");
		this.Base32 = this.Base31.getChild("Base32");
		this.Base33 = this.Base32.getChild("Base33");
		this.Base34 = this.Base33.getChild("Base34");
		this.Base35 = this.Base34.getChild("Base35");
		this.Base36 = this.Base35.getChild("Base36");
		this.Base37 = this.Base36.getChild("Base37");
		this.Base38 = this.Base37.getChild("Base38");
		this.Base39 = this.Base38.getChild("Base39");
		this.Base40 = this.Base39.getChild("Base40");
		this.Base41 = this.Base40.getChild("Base41");
		this.Base42 = this.Base41.getChild("Base42");
		this.Base43 = this.Base42.getChild("Base43");
		this.Base44 = this.Base43.getChild("Base44");
		this.Base45 = this.Base44.getChild("Base45");
		this.Base46 = this.Base45.getChild("Base46");
		this.Base47 = this.Base46.getChild("Base47");
		this.Base48 = this.Base47.getChild("Base48");
		this.Base49 = this.Base48.getChild("Base49");
		this.Base50 = this.Base49.getChild("Base50");
		this.sail_1_0 = this.sail_1.getChild("sail_1_0");
		this.sail_1_0_bundle = this.sail_1_0.getChild("sail_1_0_bundle");
		this.sail_2 = this.CaravelSail.getChild("sail_2");
		this.sail_2_4 = this.sail_2.getChild("sail_2_4");
		this.Base51 = this.sail_2_4.getChild("Base51");
		this.Base52 = this.Base51.getChild("Base52");
		this.Base53 = this.Base52.getChild("Base53");
		this.sail_2_3 = this.sail_2.getChild("sail_2_3");
		this.sail_2_3_bottom = this.sail_2_3.getChild("sail_2_3_bottom");
		this.Base54 = this.sail_2_3.getChild("Base54");
		this.Base55 = this.Base54.getChild("Base55");
		this.Base56 = this.Base55.getChild("Base56");
		this.Base57 = this.Base56.getChild("Base57");
		this.Base58 = this.Base57.getChild("Base58");
		this.Base59 = this.Base58.getChild("Base59");
		this.sail_2_2 = this.sail_2.getChild("sail_2_2");
		this.sail_2_2_bottom = this.sail_2_2.getChild("sail_2_2_bottom");
		this.Base60 = this.sail_2_2.getChild("Base60");
		this.Base61 = this.Base60.getChild("Base61");
		this.Base62 = this.Base61.getChild("Base62");
		this.Base63 = this.Base62.getChild("Base63");
		this.Base64 = this.Base63.getChild("Base64");
		this.Base65 = this.Base64.getChild("Base65");
		this.Base66 = this.Base65.getChild("Base66");
		this.Base67 = this.Base66.getChild("Base67");
		this.Base68 = this.Base67.getChild("Base68");
		this.sail_2_1 = this.sail_2.getChild("sail_2_1");
		this.sail_2_1_bottom = this.sail_2_1.getChild("sail_2_1_bottom");
		this.Base69 = this.sail_2_1.getChild("Base69");
		this.Base70 = this.Base69.getChild("Base70");
		this.Base71 = this.Base70.getChild("Base71");
		this.Base72 = this.Base71.getChild("Base72");
		this.Base73 = this.Base72.getChild("Base73");
		this.Base74 = this.Base73.getChild("Base74");
		this.Base75 = this.Base74.getChild("Base75");
		this.Base76 = this.Base75.getChild("Base76");
		this.Base77 = this.Base76.getChild("Base77");
		this.Base78 = this.Base77.getChild("Base78");
		this.Base79 = this.Base78.getChild("Base79");
		this.Base80 = this.Base79.getChild("Base80");
		this.sail_2_0 = this.sail_2.getChild("sail_2_0");
		this.sail_2_0_bundle = this.sail_2_0.getChild("sail_2_0_bundle");
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
		this.sail_1_rope_4 = this.CaravelSail.getChild("sail_1_rope_4");
		this.cube_r5 = this.sail_1_rope_4.getChild("cube_r5");
		this.cube_r6 = this.sail_1_rope_4.getChild("cube_r6");
		this.cube_r7 = this.sail_1_rope_4.getChild("cube_r7");
		this.sail_1_rope_3 = this.CaravelSail.getChild("sail_1_rope_3");
		this.cube_r2 = this.sail_1_rope_3.getChild("cube_r2");
		this.cube_r3 = this.sail_1_rope_3.getChild("cube_r3");
		this.cube_r4 = this.sail_1_rope_3.getChild("cube_r4");
		this.sail_1_rope_2 = this.CaravelSail.getChild("sail_1_rope_2");
		this.cube_r8 = this.sail_1_rope_2.getChild("cube_r8");
		this.cube_r9 = this.sail_1_rope_2.getChild("cube_r9");
		this.cube_r10 = this.sail_1_rope_2.getChild("cube_r10");
		this.sail_1_rope_1 = this.CaravelSail.getChild("sail_1_rope_1");
		this.cube_r11 = this.sail_1_rope_1.getChild("cube_r11");
		this.cube_r12 = this.sail_1_rope_1.getChild("cube_r12");
		this.cube_r13 = this.sail_1_rope_1.getChild("cube_r13");
		this.sail_1_rope_0 = this.CaravelSail.getChild("sail_1_rope_0");
		this.cube_r14 = this.sail_1_rope_0.getChild("cube_r14");
		this.cube_r15 = this.sail_1_rope_0.getChild("cube_r15");
		this.cube_r16 = this.sail_1_rope_0.getChild("cube_r16");
		this.sail_2_rope_0 = this.CaravelSail.getChild("sail_2_rope_0");
		this.cube_r20 = this.sail_2_rope_0.getChild("cube_r20");
		this.cube_r21 = this.sail_2_rope_0.getChild("cube_r21");
		this.cube_r22 = this.sail_2_rope_0.getChild("cube_r22");
		this.sail_2_rope_1 = this.CaravelSail.getChild("sail_2_rope_1");
		this.cube_r17 = this.sail_2_rope_1.getChild("cube_r17");
		this.cube_r18 = this.sail_2_rope_1.getChild("cube_r18");
		this.cube_r19 = this.sail_2_rope_1.getChild("cube_r19");
		this.sail_2_rope_2 = this.CaravelSail.getChild("sail_2_rope_2");
		this.cube_r23 = this.sail_2_rope_2.getChild("cube_r23");
		this.cube_r24 = this.sail_2_rope_2.getChild("cube_r24");
		this.cube_r25 = this.sail_2_rope_2.getChild("cube_r25");
		this.sail_2_rope_3 = this.CaravelSail.getChild("sail_2_rope_3");
		this.cube_r26 = this.sail_2_rope_3.getChild("cube_r26");
		this.cube_r27 = this.sail_2_rope_3.getChild("cube_r27");
		this.cube_r28 = this.sail_2_rope_3.getChild("cube_r28");
		this.sail_2_rope_4 = this.CaravelSail.getChild("sail_2_rope_4");
		this.cube_r29 = this.sail_2_rope_4.getChild("cube_r29");
		this.cube_r30 = this.sail_2_rope_4.getChild("cube_r30");
		this.cube_r40 = this.sail_2_rope_4.getChild("cube_r40");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition CaravelSail = partdefinition.addOrReplaceChild("CaravelSail", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 42.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sail_1 = CaravelSail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offset(-13.6924F, -79.134F, -16.0247F));

		PartDefinition sail_1_4 = sail_1.addOrReplaceChild("sail_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base1 = sail_1_4.addOrReplaceChild("Base1", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, -65.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 0).addBox(-1.0F, -4.0F, -45.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 14).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base2 = Base1.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(67, 3).addBox(-1.0F, -4.0F, -61.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(80, 3).addBox(-1.0F, -4.0F, -42.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(66, 31).addBox(-1.0F, -4.0F, -23.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(80, 17).addBox(-1.0F, -4.0F, -4.5247F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -4.0F, -57.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, -39.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(66, 34).addBox(-1.0F, -4.0F, -21.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(66, 41).addBox(-1.0F, -4.0F, -3.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base4 = Base3.addOrReplaceChild("Base4", CubeListBuilder.create().texOffs(66, 9).addBox(-1.0F, -4.0F, -53.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, -36.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(66, 37).addBox(-1.0F, -4.0F, -19.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(66, 0).addBox(-1.0F, -4.0F, -2.5247F, 2.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base5 = Base4.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, -4.0F, -49.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 19).addBox(-1.0F, -4.0F, -33.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(66, 40).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 3).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition sail_1_3 = sail_1.addOrReplaceChild("sail_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_3_bottom = sail_1_3.addOrReplaceChild("sail_1_3_bottom", CubeListBuilder.create().texOffs(79, 8).addBox(-2.9996F, -1.0F, 0.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(79, 15).addBox(-2.9996F, -1.0F, 20.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(81, 34).addBox(-2.9996F, -1.0F, 40.0F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -20.0F, -23.5F));

		PartDefinition Base6 = sail_1_3.addOrReplaceChild("Base6", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base7 = Base6.addOrReplaceChild("Base7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base8 = Base7.addOrReplaceChild("Base8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base9 = Base8.addOrReplaceChild("Base9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base11 = Base10.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, -45.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 15).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 22).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(66, 32).addBox(-1.0F, -4.0F, -41.5247F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F))
				.texOffs(67, 36).addBox(-1.0F, -4.0F, -22.8581F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F))
				.texOffs(67, 2).addBox(-1.0F, -4.0F, -4.1914F, 2.0F, 4.0F, 18.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base13 = Base12.addOrReplaceChild("Base13", CubeListBuilder.create().texOffs(66, 35).addBox(-1.0F, -4.0F, -37.5247F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F))
				.texOffs(66, 42).addBox(-1.0F, -4.0F, -20.1914F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F))
				.texOffs(66, 5).addBox(-1.0F, -4.0F, -2.8581F, 2.0F, 4.0F, 17.3333F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base14 = Base13.addOrReplaceChild("Base14", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -4.0F, -33.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 1).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 26).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base15 = Base14.addOrReplaceChild("Base15", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, -29.5247F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F))
				.texOffs(65, 4).addBox(-1.0F, -4.0F, -14.8581F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F))
				.texOffs(65, 11).addBox(-1.0F, -4.0F, -0.1914F, 2.0F, 4.0F, 14.6667F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition sail_1_2 = sail_1.addOrReplaceChild("sail_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_2_bottom = sail_1_2.addOrReplaceChild("sail_1_2_bottom", CubeListBuilder.create().texOffs(64, 19).addBox(-4.2996F, -1.0F, 0.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(78, 19).addBox(-4.2996F, -1.0F, 20.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -40.0F, -3.5F));

		PartDefinition Base16 = sail_1_2.addOrReplaceChild("Base16", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base17 = Base16.addOrReplaceChild("Base17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base18 = Base17.addOrReplaceChild("Base18", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base20 = Base19.addOrReplaceChild("Base20", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base21 = Base20.addOrReplaceChild("Base21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base22 = Base21.addOrReplaceChild("Base22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base24 = Base23.addOrReplaceChild("Base24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, -4.0F, -25.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(74, 0).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0172F));

		PartDefinition Base27 = Base26.addOrReplaceChild("Base27", CubeListBuilder.create().texOffs(71, 26).addBox(-1.0F, -4.0F, -21.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(73, 0).addBox(-1.0F, -4.0F, -3.5247F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base28 = Base27.addOrReplaceChild("Base28", CubeListBuilder.create().texOffs(65, 6).addBox(-1.0F, -4.0F, -17.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base29 = Base28.addOrReplaceChild("Base29", CubeListBuilder.create().texOffs(65, 9).addBox(-1.0F, -4.0F, -13.5247F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, 0.4753F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base30 = Base29.addOrReplaceChild("Base30", CubeListBuilder.create().texOffs(65, 12).addBox(-1.0F, -4.0F, -9.5247F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 24).addBox(-1.0F, -4.0F, 2.4753F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition sail_1_1 = sail_1.addOrReplaceChild("sail_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_1_bottom = sail_1_1.addOrReplaceChild("sail_1_1_bottom", CubeListBuilder.create().texOffs(78, 0).addBox(-2.4996F, 0.0F, 0.0F, 5.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -60.0F, 16.5F));

		PartDefinition Base31 = sail_1_1.addOrReplaceChild("Base31", CubeListBuilder.create(), PartPose.offset(-0.1996F, 0.0F, 22.0247F));

		PartDefinition Base32 = Base31.addOrReplaceChild("Base32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition Base33 = Base32.addOrReplaceChild("Base33", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base34 = Base33.addOrReplaceChild("Base34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base35 = Base34.addOrReplaceChild("Base35", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base36 = Base35.addOrReplaceChild("Base36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base37 = Base36.addOrReplaceChild("Base37", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base38 = Base37.addOrReplaceChild("Base38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base39 = Base38.addOrReplaceChild("Base39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base40 = Base39.addOrReplaceChild("Base40", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base41 = Base40.addOrReplaceChild("Base41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0172F));

		PartDefinition Base42 = Base41.addOrReplaceChild("Base42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0163F));

		PartDefinition Base43 = Base42.addOrReplaceChild("Base43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0136F));

		PartDefinition Base44 = Base43.addOrReplaceChild("Base44", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0094F));

		PartDefinition Base45 = Base44.addOrReplaceChild("Base45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0042F));

		PartDefinition Base46 = Base45.addOrReplaceChild("Base46", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, -5.5247F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0014F));

		PartDefinition Base47 = Base46.addOrReplaceChild("Base47", CubeListBuilder.create().texOffs(65, 18).addBox(-1.0F, -4.0F, -1.5247F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0069F));

		PartDefinition Base48 = Base47.addOrReplaceChild("Base48", CubeListBuilder.create().texOffs(66, 26).addBox(-1.0F, -4.0F, 2.4753F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0117F));

		PartDefinition Base49 = Base48.addOrReplaceChild("Base49", CubeListBuilder.create().texOffs(65, 24).addBox(-1.0F, -4.0F, 6.4753F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0152F));

		PartDefinition Base50 = Base49.addOrReplaceChild("Base50", CubeListBuilder.create().texOffs(65, 27).addBox(-1.0F, -4.0F, 10.4753F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.017F));

		PartDefinition sail_1_0 = sail_1.addOrReplaceChild("sail_1_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_1_0_bundle = sail_1_0.addOrReplaceChild("sail_1_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r1 = sail_1_0_bundle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(85, 29).addBox(-3.0F, -3.0F, 100.5663F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(73, 23).addBox(-3.0F, -3.0F, 87.9955F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(90, 41).addBox(-3.0F, -3.0F, 75.4247F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(77, 13).addBox(-3.0F, -3.0F, 62.8539F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(69, 25).addBox(-3.0F, -3.0F, 50.2832F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(89, 9).addBox(-3.0F, -3.0F, 37.7124F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(67, 0).addBox(-3.0F, -3.0F, 25.1416F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(85, 19).addBox(-3.0F, -3.0F, 12.5708F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F))
				.texOffs(65, 22).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 12.5708F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition sail_2 = CaravelSail.addOrReplaceChild("sail_2", CubeListBuilder.create(), PartPose.offset(-11.9424F, -78.409F, 42.4003F));

		PartDefinition sail_2_4 = sail_2.addOrReplaceChild("sail_2_4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Base51 = sail_2_4.addOrReplaceChild("Base51", CubeListBuilder.create().texOffs(92, 32).addBox(-1.0F, -4.0F, -12.5624F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(71, 31).addBox(-1.0F, -4.0F, 3.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base52 = Base51.addOrReplaceChild("Base52", CubeListBuilder.create().texOffs(94, 22).addBox(-1.0F, -4.0F, -8.5581F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F))
				.texOffs(94, 22).addBox(-1.0F, -4.0F, 6.1072F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F))
				.texOffs(65, 28).addBox(-1.0F, -4.0F, 20.7724F, 2.0F, 4.0F, 14.6652F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base53 = Base52.addOrReplaceChild("Base53", CubeListBuilder.create().texOffs(84, 24).addBox(-1.0F, -4.0F, -4.5624F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(80, 6).addBox(-1.0F, -4.0F, 15.4376F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition sail_2_3 = sail_2.addOrReplaceChild("sail_2_3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_3_bottom = sail_2_3.addOrReplaceChild("sail_2_3_bottom", CubeListBuilder.create().texOffs(86, 43).addBox(-6.7486F, 0.0F, -6.0377F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(86, 14).addBox(-6.7486F, 0.0F, 11.9623F, 3.0F, 3.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -12.0F, -31.5F));

		PartDefinition Base54 = sail_2_3.addOrReplaceChild("Base54", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base55 = Base54.addOrReplaceChild("Base55", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base56 = Base55.addOrReplaceChild("Base56", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base57 = Base56.addOrReplaceChild("Base57", CubeListBuilder.create().texOffs(80, 2).addBox(-1.0F, -4.0F, -0.5624F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(80, 9).addBox(-1.0F, -4.0F, 17.4376F, 2.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base58 = Base57.addOrReplaceChild("Base58", CubeListBuilder.create().texOffs(92, 16).addBox(-1.0F, -4.0F, 3.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(65, 19).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base59 = Base58.addOrReplaceChild("Base59", CubeListBuilder.create().texOffs(80, 8).addBox(-1.0F, -4.0F, 7.4376F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(66, 36).addBox(-1.0F, -4.0F, 21.4376F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition sail_2_2 = sail_2.addOrReplaceChild("sail_2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_2_bottom = sail_2_2.addOrReplaceChild("sail_2_2_bottom", CubeListBuilder.create().texOffs(96, 0).addBox(-7.2486F, 0.0F, -6.0377F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 39).addBox(-7.2486F, 0.0F, 5.9623F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -24.0F, -19.5F));

		PartDefinition Base60 = sail_2_2.addOrReplaceChild("Base60", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base61 = Base60.addOrReplaceChild("Base61", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base62 = Base61.addOrReplaceChild("Base62", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base63 = Base62.addOrReplaceChild("Base63", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base64 = Base63.addOrReplaceChild("Base64", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base65 = Base64.addOrReplaceChild("Base65", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base66 = Base65.addOrReplaceChild("Base66", CubeListBuilder.create().texOffs(80, 11).addBox(-1.0F, -4.0F, 11.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(66, 39).addBox(-1.0F, -4.0F, 23.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0295F));

		PartDefinition Base67 = Base66.addOrReplaceChild("Base67", CubeListBuilder.create().texOffs(68, 31).addBox(-1.0F, -4.0F, 15.4376F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base68 = Base67.addOrReplaceChild("Base68", CubeListBuilder.create().texOffs(66, 38).addBox(-1.0F, -4.0F, 19.4376F, 2.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition sail_2_1 = sail_2.addOrReplaceChild("sail_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_1_bottom = sail_2_1.addOrReplaceChild("sail_2_1_bottom", CubeListBuilder.create().texOffs(94, 41).addBox(-7.7486F, 0.0F, -6.0377F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -36.0F, -7.5F));

		PartDefinition Base69 = sail_2_1.addOrReplaceChild("Base69", CubeListBuilder.create(), PartPose.offset(-5.4486F, 0.0F, -36.9753F));

		PartDefinition Base70 = Base69.addOrReplaceChild("Base70", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition Base71 = Base70.addOrReplaceChild("Base71", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base72 = Base71.addOrReplaceChild("Base72", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base73 = Base72.addOrReplaceChild("Base73", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base74 = Base73.addOrReplaceChild("Base74", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base75 = Base74.addOrReplaceChild("Base75", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0295F));

		PartDefinition Base76 = Base75.addOrReplaceChild("Base76", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0248F));

		PartDefinition Base77 = Base76.addOrReplaceChild("Base77", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0123F));

		PartDefinition Base78 = Base77.addOrReplaceChild("Base78", CubeListBuilder.create().texOffs(66, 41).addBox(-1.0F, -4.0F, 23.4376F, 2.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0042F));

		PartDefinition Base79 = Base78.addOrReplaceChild("Base79", CubeListBuilder.create().texOffs(65, 0).addBox(-1.0F, -4.0F, 27.4376F, 2.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0193F));

		PartDefinition Base80 = Base79.addOrReplaceChild("Base80", CubeListBuilder.create().texOffs(65, 3).addBox(-1.0F, -4.0F, 31.4376F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0283F));

		PartDefinition sail_2_0 = sail_2.addOrReplaceChild("sail_2_0", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition sail_2_0_bundle = sail_2_0.addOrReplaceChild("sail_2_0_bundle", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.0F, -43.5F));

		PartDefinition cube_r41 = sail_2_0_bundle.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(88, 27).addBox(-7.5886F, -7.6338F, 49.672F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(88, 0).addBox(-7.5886F, -7.6338F, 36.0955F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-7.5886F, -7.6338F, 22.5191F, 6.0F, 6.0F, 13.5764F, new CubeDeformation(0.0F))
				.texOffs(88, 44).addBox(-7.5886F, -7.6338F, 8.9426F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F))
				.texOffs(66, 33).addBox(-7.5886F, -7.6338F, -4.6338F, 6.0F, 6.0F, 13.5765F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rope_1 = CaravelSail.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.9F, -46.4146F, 70.8099F, 0.4102F, 0.0F, 0.0F));

		PartDefinition cube_r31 = rope_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(3, 26).addBox(-3.5499F, -0.6478F, -25.1246F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(13.4501F, -0.6478F, -25.1246F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(19.4501F, -0.6478F, -25.1246F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(2.4501F, 0.6022F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(2.4501F, -1.8978F, -25.1246F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(27.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(40.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(53.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(66.4501F, -0.6478F, -25.1246F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 24).addBox(79.4501F, -0.6478F, -25.1246F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = rope_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(12, 10).addBox(-16.1163F, -16.4253F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r33 = rope_1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(19, 4).addBox(-14.9663F, -15.1753F, -8.6246F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = CaravelSail.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6F, -47.4146F, -54.1901F, -0.384F, 0.0F, 0.0F));

		PartDefinition cube_r34 = rope_2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7399F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(24.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(37.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(50.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(63.2602F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(76.2601F, -0.6478F, -17.7881F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = rope_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r36 = rope_2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = CaravelSail.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6F, -125.4146F, -22.1901F, -1.5882F, 0.0F, 0.0F));

		PartDefinition cube_r37 = rope_3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(12, 24).addBox(6.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 24).addBox(29.2602F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r38 = rope_3.addOrReplaceChild("cube_r38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r39 = rope_3.addOrReplaceChild("cube_r39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_4 = CaravelSail.addOrReplaceChild("sail_1_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -36.4146F, 10.8099F, -0.0785F, 0.0F, -0.2531F));

		PartDefinition cube_r5 = sail_1_rope_4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = sail_1_rope_4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7 = sail_1_rope_4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_3 = CaravelSail.addOrReplaceChild("sail_1_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -36.4146F, 10.8099F, -0.0349F, 0.0F, -0.1658F));

		PartDefinition cube_r2 = sail_1_rope_3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = sail_1_rope_3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = sail_1_rope_3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_2 = CaravelSail.addOrReplaceChild("sail_1_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -36.4146F, 10.8099F, -0.0174F, 0.0015F, -0.1222F));

		PartDefinition cube_r8 = sail_1_rope_2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9 = sail_1_rope_2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = sail_1_rope_2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_1 = CaravelSail.addOrReplaceChild("sail_1_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -36.4146F, 10.8099F, -0.0174F, 0.0015F, -0.0873F));

		PartDefinition cube_r11 = sail_1_rope_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(73.2601F, -0.6478F, -17.7881F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = sail_1_rope_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13 = sail_1_rope_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_1_rope_0 = CaravelSail.addOrReplaceChild("sail_1_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5F, -36.4146F, 10.8099F, -0.0261F, -0.0159F, -0.0786F));

		PartDefinition cube_r14 = sail_1_rope_0.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(73.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(92.2601F, -0.6478F, -17.7881F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = sail_1_rope_0.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = sail_1_rope_0.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_0 = CaravelSail.addOrReplaceChild("sail_2_rope_0", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -44.4146F, 43.8099F, 0.0873F, 0.2094F, 0.096F));

		PartDefinition cube_r20 = sail_2_rope_0.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(54.2601F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = sail_2_rope_0.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = sail_2_rope_0.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_1 = CaravelSail.addOrReplaceChild("sail_2_rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -44.4146F, 43.8099F, 0.1309F, 0.2313F, 0.1396F));

		PartDefinition cube_r17 = sail_2_rope_1.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(35.2601F, -0.6478F, -17.7881F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = sail_2_rope_1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19 = sail_2_rope_1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_2 = CaravelSail.addOrReplaceChild("sail_2_rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -44.4146F, 43.8099F, 0.1757F, 0.2117F, 0.1808F));

		PartDefinition cube_r23 = sail_2_rope_2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 19.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = sail_2_rope_2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r25 = sail_2_rope_2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_3 = CaravelSail.addOrReplaceChild("sail_2_rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -44.4146F, 43.8099F, 0.2215F, 0.2203F, 0.2392F));

		PartDefinition cube_r26 = sail_2_rope_3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(16.2601F, -0.6478F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = sail_2_rope_3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r28 = sail_2_rope_3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_2_rope_4 = CaravelSail.addOrReplaceChild("sail_2_rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5F, -44.4146F, 43.8099F, 0.3175F, 0.2556F, 0.3628F));

		PartDefinition cube_r29 = sail_2_rope_4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(19, 26).addBox(-6.7398F, -0.6478F, -17.7881F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(10.2601F, -0.6478F, -17.7881F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, 0.6022F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 24).addBox(-0.7398F, -1.8978F, -17.7881F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.3333F, 17.3333F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = sail_2_rope_4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(9, 10).addBox(-18.3719F, -18.681F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r40 = sail_2_rope_4.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(16, 4).addBox(-17.2219F, -17.431F, -1.2881F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.3333F, 0.3333F, 0.0F, 0.0F, -2.3562F));

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