package com.talhanation.smallships.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class DhowModel extends ShipModel<DhowEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DhowEntity.ID + "_model"), "main");
	private final ModelPart ModelDhow;
	private final ModelPart bottom;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart chest_1;
	private final ModelPart chest_2;
	private final ModelPart chest_3;
	private final ModelPart chest_4;
	private final ModelPart steer;
	private final ModelPart sides;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart Mast_1;
	private final ModelPart mast;
	private final ModelPart mast_1_2;
	private final ModelPart BannerStick;
	private final ModelPart cube_r6;
	private final ModelPart Mast_2;
	private final ModelPart mast2;
	private final ModelPart mast_1_3;
	private final ModelPart BannerStick2;
	private final ModelPart cube_r2;

	public DhowModel(ModelPart root) {
		this.ModelDhow = root.getChild("ModelDhow");
		this.bottom = this.ModelDhow.getChild("bottom");
		this.bone3 = this.bottom.getChild("bone3");
		this.bone4 = this.bone3.getChild("bone4");
		this.chest_1 = this.ModelDhow.getChild("chest_1");
		this.chest_2 = this.ModelDhow.getChild("chest_2");
		this.chest_3 = this.ModelDhow.getChild("chest_3");
		this.chest_4 = this.ModelDhow.getChild("chest_4");
		this.steer = this.ModelDhow.getChild("steer");
		this.sides = this.ModelDhow.getChild("sides");
		this.bone = this.sides.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.Mast_1 = this.ModelDhow.getChild("Mast_1");
		this.mast = this.Mast_1.getChild("mast");
		this.mast_1_2 = this.mast.getChild("mast_1_2");
		this.BannerStick = this.mast.getChild("BannerStick");
		this.cube_r6 = this.mast.getChild("cube_r6");
		this.Mast_2 = this.ModelDhow.getChild("Mast_2");
		this.mast2 = this.Mast_2.getChild("mast2");
		this.mast_1_3 = this.mast2.getChild("mast_1_3");
		this.BannerStick2 = this.mast2.getChild("BannerStick2");
		this.cube_r2 = this.mast2.getChild("cube_r2");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ModelDhow = partdefinition.addOrReplaceChild("ModelDhow", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bottom = ModelDhow.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bottom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 0).mirror().addBox(25.0F, -6.0F, -14.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.0F, 88.0F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 0).addBox(-3.0F, 1.0F, -5.5F, 8.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -37.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bottom.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 0).addBox(-3.0F, 1.0F, -5.5F, 17.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -29.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bottom.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 0).addBox(-35.0F, -3.0F, -12.0F, 7.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(-35.0F, -12.0F, -12.0F, 7.0F, 9.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 0.0F, -12.0F, 7.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -6.0F, -12.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -16.0F, -12.0F, 7.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(-21.0F, -19.0F, -12.0F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(-21.0F, -6.0F, -12.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(-21.0F, 0.0F, -12.0F, 7.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -14.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = bottom.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 39).addBox(-29.0F, -6.0F, -12.0F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.0F, -34.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = bottom.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-28.0F, -22.0F, -14.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-28.0F, 13.0F, -14.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-35.0F, -3.0F, -11.0F, 20.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = bottom.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(14.0F, -22.0F, -14.0F, 21.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 0.0F, -7.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = bottom.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -22.0F, -14.0F, 19.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 0.0F, 16.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = bottom.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -22.0F, -14.0F, 19.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 16.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = bottom.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(14.0F, -22.0F, -14.0F, 21.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -7.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = bottom.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(4, 0).addBox(-42.0F, -3.0F, -11.0F, 13.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 5.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = bottom.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(2, 0).addBox(-44.0F, -3.0F, -11.0F, 15.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, -1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = bottom.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(4, 0).addBox(-42.0F, -3.0F, -11.0F, 13.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = bottom.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(6, 0).addBox(-35.0F, -3.0F, -11.0F, 20.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = bottom.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(13, 0).addBox(-28.0F, -3.0F, -11.0F, 13.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 25.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 5.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = bottom.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(7, 0).addBox(16.0F, -3.0F, -11.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 12.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = bottom.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(13, 0).addBox(-28.0F, -3.0F, -11.0F, 13.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 25.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = bottom.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(2, 0).addBox(-44.0F, -3.0F, -11.0F, 15.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = bottom.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -3.0F, -11.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 12.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r22 = bottom.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(10, 0).addBox(-14.0F, -4.0F, -0.5F, 13.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(4, 4).addBox(-12.0F, 6.0F, -0.5F, 11.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -8.0F, 40.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = bottom.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(4, 4).addBox(22.0F, -2.0F, -0.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -2.0F, -2.5F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(10.0F, -2.0F, -2.5F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -2.0F, -2.5F, 15.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bone3 = bottom.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(1, 1).addBox(-2.435F, -3.8266F, -5.1F, 20.0F, 7.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-2.435F, -6.8266F, -5.1F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -40.0F, -1.5708F, 0.9163F, -1.5708F));

		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r24 = bone4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(-1, 3).addBox(-4.0F, -6.0F, -4.5F, 13.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.9163F));

		PartDefinition chest_1 = ModelDhow.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(0.5125F, -21.3125F, 52.1875F));

		PartDefinition cube_r25 = chest_1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(31, 56).addBox(33.0F, -19.0F, 9.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.4875F, 18.3125F, -39.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r26 = chest_1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 12.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4875F, 18.3125F, -39.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r27 = chest_1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(30, 55).addBox(41.0F, -27.0F, 10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.4875F, 26.3125F, -48.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r28 = chest_1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0875F, 18.3125F, -38.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r29 = chest_1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(30, 55).addBox(38.0F, -19.0F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5125F, 18.3125F, -43.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r30 = chest_1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5125F, 0.3125F, 1.8125F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r31 = chest_1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, -1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4875F, -2.1875F, 2.8125F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r32 = chest_1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4875F, 18.3125F, -39.1875F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = ModelDhow.addOrReplaceChild("chest_2", CubeListBuilder.create().texOffs(96, 38).addBox(-5.0F, -24.0F, 41.3F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -13.0F));

		PartDefinition cube_r33 = chest_2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(96, 38).addBox(-8.5F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -18.0F, 41.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r34 = chest_2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(30, 55).addBox(30.0F, -25.0F, 2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r35 = chest_2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(30, 55).addBox(-1.75F, -4.25F, -1.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -22.75F, 45.05F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_3 = ModelDhow.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.1667F, -19.9167F, -27.4167F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r36 = chest_3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(30, 55).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.3333F, 3.4167F, -1.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r37 = chest_3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(30, 55).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.3333F, 3.4167F, -13.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r38 = chest_3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(30, 55).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.3333F, 3.4167F, 0.4167F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r39 = chest_3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8333F, 1.9167F, -0.5833F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r40 = chest_3.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, -0.5833F, 6.7167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_4 = ModelDhow.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offsetAndRotation(6.8333F, -20.9167F, -32.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r41 = chest_4.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 8.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3667F, 18.9167F, -45.6833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r42 = chest_4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.1667F, 20.9167F, -47.0833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r43 = chest_4.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(30, 55).addBox(34.0F, -19.0F, 2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1667F, 18.9167F, -37.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r44 = chest_4.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.1667F, 2.9167F, -6.0833F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r45 = chest_4.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.8333F, 0.4167F, 5.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition steer = ModelDhow.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 40.0F));

		PartDefinition steer_r1 = steer.addOrReplaceChild("steer_r1", CubeListBuilder.create().texOffs(7, 37).addBox(-1.1596F, -0.5F, -19.7061F, 14.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1929F, -2.8F, 18.6533F, 0.0F, 0.0F, 1.5708F));

		PartDefinition sides = ModelDhow.addOrReplaceChild("sides", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r46 = sides.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -25.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -25.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r47 = sides.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -28.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r48 = sides.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 19.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 19.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r49 = sides.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, 16.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.0F, 16.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r50 = sides.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(8, 1).addBox(-42.0F, 7.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-28.0F, 13.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -2.0F, -14.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r51 = sides.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(8, 1).addBox(-42.0F, -16.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-28.0F, -22.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -2.0F, -14.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r52 = sides.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(8, 1).addBox(-35.0F, 7.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(8, 1).addBox(-21.0F, 13.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, -14.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r53 = sides.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(8, 1).addBox(-35.0F, -16.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(8, 1).addBox(-21.0F, -22.0F, -19.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -14.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition bone = sides.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-3.0F, -14.6429F, 45.0F));

		PartDefinition cube_r54 = bone.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, -22.0F, -22.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 14.6429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r55 = bone.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(0, 0).addBox(37.0F, -22.0F, -22.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 14.6429F, -47.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r56 = bone.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, 13.0F, -22.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 14.6429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r57 = bone.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 0).addBox(37.0F, 13.0F, -22.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 14.6429F, -47.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r58 = bone.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, -16.0F, -13.0F, 14.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -1.0F, -13.0F, 14.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(28.0F, -5.0F, -13.0F, 14.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 11.6429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r59 = bone.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(0, 0).addBox(22.0F, -5.0F, -13.0F, 23.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 15.6429F, -28.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 14.0F));

		PartDefinition cube_r60 = bone2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, -22.0F, -21.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(37.0F, -22.0F, -21.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 13.6429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r61 = bone2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(13, 17).addBox(44.0F, -21.0F, -21.0F, 2.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 13.6429F, -43.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r62 = bone2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, 13.0F, -21.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(37.0F, 13.0F, -21.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.6429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r63 = bone2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, -15.0F, -13.0F, 18.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 11.5429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r64 = bone2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 0).addBox(28.0F, -1.0F, -13.0F, 18.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 11.5429F, -45.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition Mast_1 = ModelDhow.addOrReplaceChild("Mast_1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -14.0F, -29.0F, 0.0F, -2.1817F, 0.0F));

		PartDefinition mast = Mast_1.addOrReplaceChild("mast", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition mast_2_r1 = mast.addOrReplaceChild("mast_2_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -76.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -61.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -46.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -31.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -16.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -1.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 1.0F, 0.0F, -0.9599F, 0.0F));

		PartDefinition mast_1_2 = mast.addOrReplaceChild("mast_1_2", CubeListBuilder.create().texOffs(7, 0).addBox(0.2957F, -36.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -49.0539F, -0.9F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -21.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -6.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 8.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 23.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 38.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -68.5F, 2.4F, 0.0F, 0.0F, 0.7418F));

		PartDefinition BannerStick = mast.addOrReplaceChild("BannerStick", CubeListBuilder.create(), PartPose.offset(-2.0F, 1.0F, 0.0F));

		PartDefinition cube_r6 = mast.addOrReplaceChild("cube_r6", CubeListBuilder.create(), PartPose.offsetAndRotation(41.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Mast_2 = ModelDhow.addOrReplaceChild("Mast_2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -14.0F, 27.0F, 0.0F, -2.1817F, 0.0F));

		PartDefinition mast2 = Mast_2.addOrReplaceChild("mast2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition mast_2_r2 = mast2.addOrReplaceChild("mast_2_r2", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -76.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -61.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -46.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -31.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -16.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-1.0F, -1.0F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 1.0F, 0.0F, -0.9599F, 0.0F));

		PartDefinition mast_1_3 = mast2.addOrReplaceChild("mast_1_3", CubeListBuilder.create().texOffs(7, 0).addBox(0.2957F, -36.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -49.0539F, -0.9F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -21.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, -6.0539F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 8.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 23.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(7, 0).addBox(0.2957F, 38.9461F, -0.9F, 3.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -68.5F, 2.4F, 0.0F, 0.0F, 0.7418F));

		PartDefinition BannerStick2 = mast2.addOrReplaceChild("BannerStick2", CubeListBuilder.create(), PartPose.offset(-2.0F, 1.0F, 0.0F));

		PartDefinition bannerStick_r1 = BannerStick2.addOrReplaceChild("bannerStick_r1", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, -91.0F, -1.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -15.0F, 1.0F, 0.0F, -0.9599F, 0.0F));

		PartDefinition cube_r2 = mast2.addOrReplaceChild("cube_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(41.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.5672F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(DhowEntity dhowEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = dhowEntity.getInvFillState() >= 15;
		this.chest_2.visible = dhowEntity.getInvFillState() >= 30;
		this.chest_3.visible = dhowEntity.getInvFillState() >= 60;
		this.chest_4.visible = dhowEntity.getInvFillState() >= 90;

		this.steer.yRot = -dhowEntity.getRotSpeed() * 0.25F;
	}
	@Override
	public ModelPart root() {
		return this.ModelDhow;
	}
}