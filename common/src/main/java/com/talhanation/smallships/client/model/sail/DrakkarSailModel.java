package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DrakkarSailModel extends SailModel {
	@SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DrakkarEntity.ID + "_sail_model"), "main");

	private final ModelPart DrakkarSail;
	private final ModelPart sail_4;
	private final ModelPart segel_1_12;
	private final ModelPart cube_r87;
	private final ModelPart cube_r88;
	private final ModelPart cube_r95;
	private final ModelPart rope_15;
	private final ModelPart cube_r96;
	private final ModelPart cube_r97;
	private final ModelPart cube_r98;
	private final ModelPart rope_16;
	private final ModelPart cube_r99;
	private final ModelPart cube_r100;
	private final ModelPart cube_r101;
	private final ModelPart sail_3;
	private final ModelPart segel_1_9;
	private final ModelPart segel_1_11;
	private final ModelPart cube_r64;
	private final ModelPart cube_r65;
	private final ModelPart rope_19;
	private final ModelPart cube_r70;
	private final ModelPart cube_r71;
	private final ModelPart cube_r72;
	private final ModelPart cube_r73;
	private final ModelPart cube_r74;
	private final ModelPart rope_20;
	private final ModelPart cube_r75;
	private final ModelPart cube_r76;
	private final ModelPart cube_r77;
	private final ModelPart cube_r78;
	private final ModelPart cube_r79;
	private final ModelPart sail_3_bottom;
	private final ModelPart cube_r80;
	private final ModelPart sail_2;
	private final ModelPart segel_1_6;
	private final ModelPart segel_1_8;
	private final ModelPart cube_r43;
	private final ModelPart cube_r44;
	private final ModelPart rope_11;
	private final ModelPart cube_r47;
	private final ModelPart cube_r48;
	private final ModelPart cube_r49;
	private final ModelPart cube_r50;
	private final ModelPart cube_r51;
	private final ModelPart rope_12;
	private final ModelPart cube_r52;
	private final ModelPart cube_r53;
	private final ModelPart cube_r54;
	private final ModelPart cube_r55;
	private final ModelPart cube_r56;
	private final ModelPart sail_2_bottom;
	private final ModelPart cube_r57;
	private final ModelPart sail_1;
	private final ModelPart segel_1_2;
	private final ModelPart segel_1_5;
	private final ModelPart cube_r25;
	private final ModelPart cube_r26;
	private final ModelPart rope_7;
	private final ModelPart cube_r27;
	private final ModelPart cube_r28;
	private final ModelPart cube_r29;
	private final ModelPart cube_r30;
	private final ModelPart cube_r31;
	private final ModelPart rope_8;
	private final ModelPart cube_r32;
	private final ModelPart cube_r33;
	private final ModelPart cube_r34;
	private final ModelPart cube_r35;
	private final ModelPart cube_r36;
	private final ModelPart sail_1_bottom;
	private final ModelPart cube_r102;
	private final ModelPart sail_0;
	private final ModelPart segel_1_3;
	private final ModelPart segel_1_4;
	private final ModelPart rope_4;
	private final ModelPart cube_r103;
	private final ModelPart cube_r104;
	private final ModelPart cube_r105;
	private final ModelPart cube_r106;
	private final ModelPart cube_r107;
	private final ModelPart rope_5;
	private final ModelPart cube_r108;
	private final ModelPart cube_r109;
	private final ModelPart cube_r110;
	private final ModelPart cube_r111;
	private final ModelPart cube_r112;
	private final ModelPart sail_end;
	private final ModelPart cube_r113;
	private final ModelPart ropes;
	private final ModelPart rope_1;
	private final ModelPart cube_r114;
	private final ModelPart cube_r115;
	private final ModelPart cube_r116;
	private final ModelPart rope_2;
	private final ModelPart cube_r117;
	private final ModelPart cube_r118;
	private final ModelPart cube_r119;
	public DrakkarSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.DrakkarSail = root.getChild("DrakkarSail");
		this.sail_4 = this.DrakkarSail.getChild("sail_4");
		this.segel_1_12 = this.sail_4.getChild("segel_1_12");
		this.cube_r87 = this.segel_1_12.getChild("cube_r87");
		this.cube_r88 = this.segel_1_12.getChild("cube_r88");
		this.cube_r95 = this.segel_1_12.getChild("cube_r95");
		this.rope_15 = this.segel_1_12.getChild("rope_15");
		this.cube_r96 = this.rope_15.getChild("cube_r96");
		this.cube_r97 = this.rope_15.getChild("cube_r97");
		this.cube_r98 = this.rope_15.getChild("cube_r98");
		this.rope_16 = this.segel_1_12.getChild("rope_16");
		this.cube_r99 = this.rope_16.getChild("cube_r99");
		this.cube_r100 = this.rope_16.getChild("cube_r100");
		this.cube_r101 = this.rope_16.getChild("cube_r101");
		this.sail_3 = this.DrakkarSail.getChild("sail_3");
		this.segel_1_9 = this.sail_3.getChild("segel_1_9");
		this.segel_1_11 = this.segel_1_9.getChild("segel_1_11");
		this.cube_r64 = this.segel_1_11.getChild("cube_r64");
		this.cube_r65 = this.segel_1_11.getChild("cube_r65");
		this.rope_19 = this.segel_1_11.getChild("rope_19");
		this.cube_r70 = this.rope_19.getChild("cube_r70");
		this.cube_r71 = this.rope_19.getChild("cube_r71");
		this.cube_r72 = this.rope_19.getChild("cube_r72");
		this.cube_r73 = this.rope_19.getChild("cube_r73");
		this.cube_r74 = this.rope_19.getChild("cube_r74");
		this.rope_20 = this.segel_1_11.getChild("rope_20");
		this.cube_r75 = this.rope_20.getChild("cube_r75");
		this.cube_r76 = this.rope_20.getChild("cube_r76");
		this.cube_r77 = this.rope_20.getChild("cube_r77");
		this.cube_r78 = this.rope_20.getChild("cube_r78");
		this.cube_r79 = this.rope_20.getChild("cube_r79");
		this.sail_3_bottom = this.segel_1_11.getChild("sail_3_bottom");
		this.cube_r80 = this.sail_3_bottom.getChild("cube_r80");
		this.sail_2 = this.DrakkarSail.getChild("sail_2");
		this.segel_1_6 = this.sail_2.getChild("segel_1_6");
		this.segel_1_8 = this.segel_1_6.getChild("segel_1_8");
		this.cube_r43 = this.segel_1_8.getChild("cube_r43");
		this.cube_r44 = this.segel_1_8.getChild("cube_r44");
		this.rope_11 = this.segel_1_8.getChild("rope_11");
		this.cube_r47 = this.rope_11.getChild("cube_r47");
		this.cube_r48 = this.rope_11.getChild("cube_r48");
		this.cube_r49 = this.rope_11.getChild("cube_r49");
		this.cube_r50 = this.rope_11.getChild("cube_r50");
		this.cube_r51 = this.rope_11.getChild("cube_r51");
		this.rope_12 = this.segel_1_8.getChild("rope_12");
		this.cube_r52 = this.rope_12.getChild("cube_r52");
		this.cube_r53 = this.rope_12.getChild("cube_r53");
		this.cube_r54 = this.rope_12.getChild("cube_r54");
		this.cube_r55 = this.rope_12.getChild("cube_r55");
		this.cube_r56 = this.rope_12.getChild("cube_r56");
		this.sail_2_bottom = this.segel_1_8.getChild("sail_2_bottom");
		this.cube_r57 = this.sail_2_bottom.getChild("cube_r57");
		this.sail_1 = this.DrakkarSail.getChild("sail_1");
		this.segel_1_2 = this.sail_1.getChild("segel_1_2");
		this.segel_1_5 = this.segel_1_2.getChild("segel_1_5");
		this.cube_r25 = this.segel_1_5.getChild("cube_r25");
		this.cube_r26 = this.segel_1_5.getChild("cube_r26");
		this.rope_7 = this.segel_1_5.getChild("rope_7");
		this.cube_r27 = this.rope_7.getChild("cube_r27");
		this.cube_r28 = this.rope_7.getChild("cube_r28");
		this.cube_r29 = this.rope_7.getChild("cube_r29");
		this.cube_r30 = this.rope_7.getChild("cube_r30");
		this.cube_r31 = this.rope_7.getChild("cube_r31");
		this.rope_8 = this.segel_1_5.getChild("rope_8");
		this.cube_r32 = this.rope_8.getChild("cube_r32");
		this.cube_r33 = this.rope_8.getChild("cube_r33");
		this.cube_r34 = this.rope_8.getChild("cube_r34");
		this.cube_r35 = this.rope_8.getChild("cube_r35");
		this.cube_r36 = this.rope_8.getChild("cube_r36");
		this.sail_1_bottom = this.segel_1_5.getChild("sail_1_bottom");
		this.cube_r102 = this.sail_1_bottom.getChild("cube_r102");
		this.sail_0 = this.DrakkarSail.getChild("sail_0");
		this.segel_1_3 = this.sail_0.getChild("segel_1_3");
		this.segel_1_4 = this.segel_1_3.getChild("segel_1_4");
		this.rope_4 = this.segel_1_4.getChild("rope_4");
		this.cube_r103 = this.rope_4.getChild("cube_r103");
		this.cube_r104 = this.rope_4.getChild("cube_r104");
		this.cube_r105 = this.rope_4.getChild("cube_r105");
		this.cube_r106 = this.rope_4.getChild("cube_r106");
		this.cube_r107 = this.rope_4.getChild("cube_r107");
		this.rope_5 = this.segel_1_4.getChild("rope_5");
		this.cube_r108 = this.rope_5.getChild("cube_r108");
		this.cube_r109 = this.rope_5.getChild("cube_r109");
		this.cube_r110 = this.rope_5.getChild("cube_r110");
		this.cube_r111 = this.rope_5.getChild("cube_r111");
		this.cube_r112 = this.rope_5.getChild("cube_r112");
		this.sail_end = this.segel_1_4.getChild("sail_end");
		this.cube_r113 = this.sail_end.getChild("cube_r113");
		this.ropes = this.DrakkarSail.getChild("ropes");
		this.rope_1 = this.ropes.getChild("rope_1");
		this.cube_r114 = this.rope_1.getChild("cube_r114");
		this.cube_r115 = this.rope_1.getChild("cube_r115");
		this.cube_r116 = this.rope_1.getChild("cube_r116");
		this.rope_2 = this.ropes.getChild("rope_2");
		this.cube_r117 = this.rope_2.getChild("cube_r117");
		this.cube_r118 = this.rope_2.getChild("cube_r118");
		this.cube_r119 = this.rope_2.getChild("cube_r119");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition DrakkarSail = partdefinition.addOrReplaceChild("DrakkarSail", CubeListBuilder.create(), PartPose.offset(-11.0F, 24.0F, 0.0F));

		PartDefinition sail_4 = DrakkarSail.addOrReplaceChild("sail_4", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition segel_1_12 = sail_4.addOrReplaceChild("segel_1_12", CubeListBuilder.create(), PartPose.offsetAndRotation(8.5F, -11.0F, 20.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r87 = segel_1_12.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(88, 0).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(96, 46).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 20).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 3).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(96, 46).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -26.3067F, 36.3895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r88 = segel_1_12.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(93, 46).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 21).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 47).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 3).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 21).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -28.4794F, 33.5112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r95 = segel_1_12.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(65, 33).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 20).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(66, 0).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 18).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 0).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -20.7281F, 39.2678F, 2.2227F, 0.0F, 0.0F));

		PartDefinition rope_15 = segel_1_12.addOrReplaceChild("rope_15", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.3963F, 0.7941F, 1.7628F));

		PartDefinition cube_r96 = rope_15.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(2, 23).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 23).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97 = rope_15.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(20, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98 = rope_15.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(23, 10).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_16 = segel_1_12.addOrReplaceChild("rope_16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2654F, -0.7592F, -1.5708F));

		PartDefinition cube_r99 = rope_16.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(2, 23).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 23).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 24).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = rope_16.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(20, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101 = rope_16.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(15, 4).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_3 = DrakkarSail.addOrReplaceChild("sail_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_9 = sail_3.addOrReplaceChild("segel_1_9", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_11 = segel_1_9.addOrReplaceChild("segel_1_11", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r64 = segel_1_11.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(82, 30).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(76, 43).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 51).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 46).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 46).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -34.7644F, 33.9338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r65 = segel_1_11.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(80, 43).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 24).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 47).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(66, 42).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 31).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -39.6813F, 33.5822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition rope_19 = segel_1_11.addOrReplaceChild("rope_19", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5097F, 0.8552F, 1.7628F));

		PartDefinition cube_r70 = rope_19.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(8, 26).addBox(44.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(3, 22).addBox(20.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 23).addBox(25.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r71 = rope_19.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(14, 6).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r72 = rope_19.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(4, 3).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r73 = rope_19.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(2, 22).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r74 = rope_19.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(15, 22).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_20 = segel_1_11.addOrReplaceChild("rope_20", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3422F, -0.8454F, -1.5566F));

		PartDefinition cube_r75 = rope_20.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(14, 23).addBox(45.5F, -1.0F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(19.5F, -1.0F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 23).addBox(25.5F, -1.0F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r76 = rope_20.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(14, 6).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r77 = rope_20.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(4, 3).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r78 = rope_20.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(2, 22).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r79 = rope_20.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(15, 22).addBox(21.5F, -1.0F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_3_bottom = segel_1_11.addOrReplaceChild("sail_3_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r80 = sail_3_bottom.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(96, 55).addBox(-37.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(81, 17).addBox(-50.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(96, 23).addBox(-63.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(90, 20).addBox(-24.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(101, 13).addBox(-11.0F, -41.6933F, 18.2105F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(55.5F, -1.8067F, 44.7895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition sail_2 = DrakkarSail.addOrReplaceChild("sail_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_6 = sail_2.addOrReplaceChild("segel_1_6", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_8 = segel_1_6.addOrReplaceChild("segel_1_8", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r43 = segel_1_8.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(96, 17).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 14).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 40).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 18).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 55).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r44 = segel_1_8.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(96, 41).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 14).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(96, 38).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 47).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition rope_11 = segel_1_8.addOrReplaceChild("rope_11", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5001F, 0.9684F, 1.7506F));

		PartDefinition cube_r47 = rope_11.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(16, 23).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 24).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 23).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = rope_11.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(14, 6).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = rope_11.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(4, 3).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r50 = rope_11.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(2, 22).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r51 = rope_11.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(15, 22).addBox(21.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_12 = segel_1_8.addOrReplaceChild("rope_12", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3165F, -0.9301F, -1.5235F));

		PartDefinition cube_r52 = rope_12.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(10, 24).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 23).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(17, 22).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r53 = rope_12.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(14, 6).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r54 = rope_12.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(4, 3).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r55 = rope_12.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(2, 22).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r56 = rope_12.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(15, 22).addBox(21.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_2_bottom = segel_1_8.addOrReplaceChild("sail_2_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r57 = sail_2_bottom.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(94, 33).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(94, 35).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(94, 17).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(93, 37).addBox(6.9F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(102, 25).addBox(19.9F, -2.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition sail_1 = DrakkarSail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_2 = sail_1.addOrReplaceChild("segel_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_5 = segel_1_2.addOrReplaceChild("segel_1_5", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r25 = segel_1_5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(84, 52).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(90, 10).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 22).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 14).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 56).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r26 = segel_1_5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(66, 53).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(66, 45).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 40).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 33).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(65, 24).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_7 = segel_1_5.addOrReplaceChild("rope_7", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4794F, 1.1163F, 1.7268F));

		PartDefinition cube_r27 = rope_7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(18, 22).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 23).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 22).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r28 = rope_7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(4, 5).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r29 = rope_7.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(4, 3).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r30 = rope_7.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(2, 22).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(30, 23).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r31 = rope_7.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(2, 22).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_8 = segel_1_5.addOrReplaceChild("rope_8", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2348F, -1.0973F, -1.4276F));

		PartDefinition cube_r32 = rope_8.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(18, 24).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 23).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 22).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = rope_8.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(14, 6).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -31.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = rope_8.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(4, 3).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -19.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r35 = rope_8.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(12, 22).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r36 = rope_8.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(1, 22).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_1_bottom = segel_1_5.addOrReplaceChild("sail_1_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -41.0F, -1.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r102 = sail_1_bottom.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(64, 32).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 42).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 54).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(64, 48).addBox(6.9F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(66, 11).addBox(19.9F, -2.25F, -2.0F, 9.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition sail_0 = DrakkarSail.addOrReplaceChild("sail_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_3 = sail_0.addOrReplaceChild("segel_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_4 = segel_1_3.addOrReplaceChild("segel_1_4", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition rope_4 = segel_1_4.addOrReplaceChild("rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4884F, 1.2464F, 1.6894F));

		PartDefinition cube_r103 = rope_4.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(17, 24).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 23).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(5, 24).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r104 = rope_4.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(4, 3).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -33.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r105 = rope_4.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(4, 3).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r106 = rope_4.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(22, 25).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(29, 24).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r107 = rope_4.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(20, 26).addBox(27.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(31, 27).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_5 = segel_1_4.addOrReplaceChild("rope_5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.1491F, -1.1947F, -1.3336F));

		PartDefinition cube_r108 = rope_5.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(2, 24).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 25).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 22).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r109 = rope_5.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(14, 6).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -35.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r110 = rope_5.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(4, 3).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -23.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r111 = rope_5.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(23, 23).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 23).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r112 = rope_5.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(27, 23).addBox(27.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(19, 23).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end = segel_1_4.addOrReplaceChild("sail_end", CubeListBuilder.create(), PartPose.offsetAndRotation(22.1F, -54.7898F, -1.4374F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r113 = sail_end.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(65, 30).addBox(-6.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 24).addBox(-19.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(67, 35).addBox(-32.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(67, 28).addBox(6.9F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 12).addBox(19.9F, -3.25F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -2.2166F, 0.0F, 0.0F));

		PartDefinition ropes = DrakkarSail.addOrReplaceChild("ropes", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_1 = ropes.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.528F));

		PartDefinition cube_r114 = rope_1.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(11, 23).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 24).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 24).addBox(74.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(20, 24).addBox(84.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(13, 25).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 24).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(9, 22).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r115 = rope_1.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(14, 6).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r116 = rope_1.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(4, 3).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = ropes.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-90.0F, -1.0F, 0.0F, 0.7156F, -1.5708F, 0.0F));

		PartDefinition cube_r117 = rope_2.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(16, 28).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 26).addBox(89.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 26).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 24).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(21, 22).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r118 = rope_2.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(14, 6).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r119 = rope_2.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(4, 3).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}


	@Override
	public void setupAnim(@NotNull Ship cog, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		switch (cog.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				this.sail_0.visible = true;
				this.sail_1.visible = false;
				this.sail_2.visible = false;
				this.sail_3.visible = false;
				this.sail_4.visible = false;

				this.sail_1_bottom.visible = false;
				this.sail_2_bottom.visible = false;
				this.sail_3_bottom.visible = false;
			}
			case 1 -> {
				this.sail_0.visible = false;
				this.sail_1.visible = true;
				this.sail_2.visible = false;
				this.sail_3.visible = false;
				this.sail_4.visible = false;

				this.sail_1_bottom.visible = true;
				this.sail_2_bottom.visible = false;
				this.sail_3_bottom.visible = false;
			}
			case 2 -> {
				this.sail_0.visible = false;
				this.sail_1.visible = true;
				this.sail_2.visible = true;
				this.sail_3.visible = false;
				this.sail_4.visible = false;
				this.sail_1_bottom.visible = false;
				this.sail_2_bottom.visible = true;
				this.sail_3_bottom.visible = false;
			}
			case 3 -> {
				this.sail_0.visible = false;
				this.sail_1.visible = true;
				this.sail_2.visible = true;
				this.sail_3.visible = true;
				this.sail_4.visible = false;
				this.sail_1_bottom.visible = false;
				this.sail_2_bottom.visible = false;
				this.sail_3_bottom.visible = true;
			}
			case 4 -> {
				this.sail_0.visible = false;
				this.sail_1.visible = true;
				this.sail_2.visible = true;
				this.sail_3.visible = true;
				this.sail_4.visible = true;


				this.sail_1_bottom.visible = false;
				this.sail_2_bottom.visible = false;
				this.sail_3_bottom.visible = false;
			}
		}


		this.rope_4.visible = sail_0.visible;
		this.rope_5.visible = sail_0.visible;

		this.rope_7.visible = sail_1_bottom.visible;
		this.rope_8.visible = sail_1_bottom.visible;

		this.rope_11.visible = sail_2_bottom.visible;
		this.rope_12.visible = sail_2_bottom.visible;

		this.rope_19.visible = sail_3_bottom.visible;
		this.rope_20.visible = sail_3_bottom.visible;

		this.rope_16.visible = sail_4.visible;
		this.rope_15.visible = sail_4.visible;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		DrakkarSail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}