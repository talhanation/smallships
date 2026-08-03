package com.talhanation.smallships.client.model;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.GalleonEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GalleonModel extends ShipModel<GalleonEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, GalleonEntity.ID + "_model"), "main");
	private final ModelPart Galleon;
	private final ModelPart lid_left_1;
	private final ModelPart lid_left_2;
	private final ModelPart lid_left_3;
	private final ModelPart lid_right_1;
	private final ModelPart lid_right_2;
	private final ModelPart lid_right_3;
	private final ModelPart body;
	private final ModelPart deck;
	private final ModelPart steer;
	private final ModelPart mast_1;
	private final ModelPart mast_2;
	private final ModelPart mast_3;
	private final ModelPart chest_2;
	private final ModelPart chest_1;
	private final ModelPart chest_4;
	private final ModelPart chest_3;

	public GalleonModel(ModelPart root) {
		this.Galleon = root.getChild("Galleon");
		this.lid_left_1 = this.Galleon.getChild("lid_left_1");
		this.lid_left_2 = this.Galleon.getChild("lid_left_2");
		this.lid_left_3 = this.Galleon.getChild("lid_left_3");
		this.lid_right_1 = this.Galleon.getChild("lid_right_1");
		this.lid_right_2 = this.Galleon.getChild("lid_right_2");
		this.lid_right_3 = this.Galleon.getChild("lid_right_3");
		this.body = this.Galleon.getChild("body");
		this.deck = this.body.getChild("deck");
		this.steer = this.Galleon.getChild("steer");
		this.mast_1 = this.Galleon.getChild("mast_1");
		this.mast_2 = this.Galleon.getChild("mast_2");
		this.mast_3 = this.Galleon.getChild("mast_3");
		this.chest_2 = this.Galleon.getChild("chest_2");
		this.chest_1 = this.Galleon.getChild("chest_1");
		this.chest_4 = this.Galleon.getChild("chest_4");
		this.chest_3 = this.Galleon.getChild("chest_3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Galleon = partdefinition.addOrReplaceChild("Galleon", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition lid_left_1 = Galleon.addOrReplaceChild("lid_left_1", CubeListBuilder.create().texOffs(4, 35).addBox(0.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(31.0F, -24.0F, 25.0F));

		PartDefinition lid_left_2 = Galleon.addOrReplaceChild("lid_left_2", CubeListBuilder.create().texOffs(4, 35).addBox(0.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(35.0F, -24.0F, -3.0F));

		PartDefinition lid_left_3 = Galleon.addOrReplaceChild("lid_left_3", CubeListBuilder.create().texOffs(4, 35).addBox(0.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(31.0F, -24.0F, -31.0F));

		PartDefinition lid_right_1 = Galleon.addOrReplaceChild("lid_right_1", CubeListBuilder.create().texOffs(4, 35).addBox(10.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-42.0F, -24.0F, -31.0F));

		PartDefinition lid_right_2 = Galleon.addOrReplaceChild("lid_right_2", CubeListBuilder.create().texOffs(4, 35).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-35.0F, -24.0F, -3.0F));

		PartDefinition lid_right_3 = Galleon.addOrReplaceChild("lid_right_3", CubeListBuilder.create().texOffs(4, 35).addBox(10.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-42.0F, -24.0F, 25.0F));

		PartDefinition body = Galleon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 39).addBox(28.0358F, 52.718F, -23.8267F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(112, 88).addBox(28.0358F, 51.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(28.0358F, 51.718F, -36.8267F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(7, 30).addBox(28.0358F, 51.718F, 40.1733F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(28.0358F, 52.718F, 32.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(28.0358F, 51.718F, 28.1733F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 23).addBox(31.0358F, 39.718F, -11.8267F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(20, 31).addBox(31.0358F, 39.718F, 4.1733F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 23).addBox(31.0358F, 39.718F, 12.1733F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(32.0358F, 51.718F, -11.8267F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(32.0358F, 52.718F, 4.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(32.0358F, 51.718F, 12.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(8, 33).addBox(27.0358F, 39.718F, -23.8267F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(5, 24).addBox(27.0358F, 39.718F, -36.8267F, 4.0F, 12.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(27.0358F, 34.718F, -36.8267F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(8, 20).addBox(24.0358F, 51.718F, -54.8267F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(5, 27).addBox(27.0358F, 34.718F, 37.1733F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(20, 39).addBox(23.0358F, 39.718F, 48.1733F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(11, 39).addBox(-26.9642F, 39.718F, 48.1733F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(2, 28).addBox(-23.9642F, 30.718F, 69.1733F, 4.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(2, 28).addBox(20.0358F, 30.718F, 69.1733F, 4.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(6, 28).addBox(-26.9642F, 30.718F, 65.1733F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 20).addBox(-26.9642F, 30.718F, 53.1733F, 4.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 16).addBox(-26.9642F, 49.718F, 53.1733F, 4.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(6, 28).addBox(23.0358F, 30.718F, 65.1733F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 16).addBox(23.0358F, 49.718F, 53.1733F, 4.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(2, 20).addBox(23.0358F, 30.718F, 53.1733F, 4.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).mirror().addBox(16.7858F, 34.718F, 73.1733F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(-31.9642F, 52.718F, 32.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 29).mirror().addBox(-31.9642F, 51.718F, 40.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(20, 31).mirror().addBox(-30.9642F, 39.718F, 32.1733F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 35).mirror().addBox(-30.9642F, 39.718F, 28.1733F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(-35.9642F, 52.718F, 4.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 30).mirror().addBox(-35.9642F, 51.718F, -11.8267F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(20, 31).mirror().addBox(-34.9642F, 39.718F, 4.1733F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(15, 23).mirror().addBox(-34.9642F, 39.718F, -11.8267F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(19, 31).mirror().addBox(-30.9642F, 39.718F, -23.8267F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 19).mirror().addBox(-30.9642F, 39.718F, -15.8267F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(-31.9642F, 52.718F, -23.8267F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 42).mirror().addBox(-31.9642F, 51.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(160, 84).mirror().addBox(-26.9642F, 39.718F, 48.1733F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(17, 26).mirror().addBox(-30.9642F, 39.718F, -36.8267F, 4.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 28).mirror().addBox(-30.9642F, 34.718F, 37.1733F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(-26.9642F, 34.718F, -54.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(-26.9642F, 34.718F, -45.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 24).mirror().addBox(23.0358F, 42.718F, -54.8267F, 4.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(23.0358F, 34.718F, -54.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(23.0358F, 34.718F, -45.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(13, 24).mirror().addBox(-26.9642F, 42.718F, -54.8267F, 4.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 20).mirror().addBox(-27.9642F, 51.718F, -54.8267F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 23).mirror().addBox(-34.9642F, 39.718F, 12.1733F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 23).mirror().addBox(-30.9642F, 39.718F, 40.1733F, 4.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 38).mirror().addBox(-30.9642F, 34.718F, -36.8267F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 19).mirror().addBox(27.0358F, 39.718F, -15.8267F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 30).mirror().addBox(-35.9642F, 51.718F, 12.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 42).mirror().addBox(-31.9642F, 51.718F, 28.1733F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 33).mirror().addBox(-31.9642F, 51.718F, -36.8267F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 30).mirror().addBox(24.0358F, 51.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 30).mirror().addBox(-27.9642F, 51.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 42).mirror().addBox(28.0358F, 51.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.0358F, -68.718F, -11.1733F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 56.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 62.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 56.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 56.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 62.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 56.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 56.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 62.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 56.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 56.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 62.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 56.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 56.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 56.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 62.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 64.8179F, 66.8733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 64.8179F, 41.8733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 64.8179F, 16.8733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 64.8179F, -8.1267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 64.8179F, -33.1267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(7, 20).mirror().addBox(-14.0862F, 72.918F, -8.9642F, 5.0F, 13.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 20).mirror().addBox(-9.0862F, 72.918F, -8.9642F, 5.0F, 13.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 23).mirror().addBox(-4.0862F, 72.918F, -7.9642F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(54.8267F, 51.718F, 15.0358F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 38).mirror().addBox(50.8267F, 56.718F, 7.0358F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 8).mirror().addBox(-6.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 29).mirror().addBox(-4.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(14, 31).mirror().addBox(-2.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 31).mirror().addBox(1.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 30).mirror().addBox(-0.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 8).mirror().addBox(1.8267F, 49.718F, 4.5358F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 40).mirror().addBox(55.8267F, 45.718F, -15.9642F, 1.0F, 3.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(264, 164).mirror().addBox(36.8267F, 39.718F, 22.0358F, 18.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(264, 164).mirror().addBox(36.8267F, 39.718F, -22.9642F, 18.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 5).mirror().addBox(28.8267F, 42.718F, -26.9642F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 32).mirror().addBox(58.8267F, 51.718F, 1.0358F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(12, 34).mirror().addBox(6.5358F, 32.0624F, 75.0404F, 18.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(6, 34).mirror().addBox(-24.4642F, 32.0624F, 75.0404F, 18.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(13, 34).mirror().addBox(-6.4642F, 32.0624F, 75.0404F, 13.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(11.0358F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(0.0358F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(-10.9642F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 34).mirror().addBox(-21.9642F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(4, 39).mirror().addBox(50.8267F, 56.718F, 9.0358F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r30 = body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r34 = body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r35 = body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r37 = body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r41 = body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r42 = body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r43 = body.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r44 = body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r45 = body.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r46 = body.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r47 = body.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r48 = body.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r49 = body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r50 = body.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r51 = body.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r52 = body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r53 = body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r54 = body.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r55 = body.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(32, 5).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r56 = body.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r57 = body.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r58 = body.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(32, 5).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r59 = body.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r60 = body.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 0.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r61 = body.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(10, 24).mirror().addBox(-2.0F, -6.0F, -8.5F, 4.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 45.718F, 46.6733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r62 = body.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(11, 21).mirror().addBox(48.0095F, 43.0631F, 0.0358F, 4.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 28).mirror().addBox(48.0095F, 54.0631F, 0.0358F, 4.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 25).mirror().addBox(45.0095F, 43.0631F, 15.0358F, 4.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 25).mirror().addBox(45.0095F, 43.0631F, -22.9642F, 4.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition cube_r63 = body.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(7, 21).mirror().addBox(48.0095F, 54.0631F, 0.0358F, 4.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 21).mirror().addBox(48.0095F, 43.0631F, 0.0358F, 4.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 0.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition cube_r64 = body.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-1.9642F, 70.599F, -56.3951F, 4.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 25).addBox(-1.4643F, 71.099F, -79.3951F, 3.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r65 = body.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(1.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 33).mirror().addBox(3.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 28).mirror().addBox(7.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 28).mirror().addBox(-4.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 29).mirror().addBox(-8.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 8).mirror().addBox(0.2142F, 49.718F, -3.9233F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r66 = body.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(2, 31).mirror().addBox(-49.3989F, 76.8744F, -2.9642F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(2, 26).mirror().addBox(-44.3989F, 60.8744F, 5.0358F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r67 = body.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0358F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r68 = body.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0358F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r69 = body.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.9642F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r70 = body.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.9642F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r71 = body.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.9642F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r72 = body.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.9642F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r73 = body.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -3.5F, -5.0F, 19.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0358F, 50.218F, -5.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r74 = body.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-21.0F, -3.5F, -5.0F, 21.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0358F, 50.218F, 7.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r75 = body.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-21.0F, -3.5F, -5.0F, 21.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.9642F, 50.218F, 7.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r76 = body.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -3.5F, -5.0F, 19.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.9642F, 50.218F, -5.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r77 = body.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -22.5F, -5.0F, 9.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.9642F, 50.218F, -42.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r78 = body.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -20.5F, -5.0F, 9.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.9642F, 50.218F, -42.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r79 = body.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -22.5F, -5.0F, 9.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0358F, 50.218F, -42.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r80 = body.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(28.8267F, 42.718F, -26.9642F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r81 = body.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(28.8267F, 42.718F, -15.9642F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(32.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r82 = body.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(28.8267F, 42.718F, -15.9642F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(21.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r83 = body.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(28.8267F, 42.718F, -22.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(18.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r84 = body.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(30, 35).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 45.718F, 30.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r85 = body.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(20, 31).mirror().addBox(-2.0F, -3.0F, -4.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 42.718F, 36.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r86 = body.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(6, 30).mirror().addBox(1.2142F, 45.718F, -7.4233F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 0.0F, -34.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r87 = body.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(1.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 0.0F, -22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r88 = body.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(26.5358F, 58.218F, -24.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r89 = body.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-6.5F, -1.5F, -1.0F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 58.218F, 34.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r90 = body.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 58.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r91 = body.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 58.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r92 = body.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.4642F, 58.218F, -24.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r93 = body.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 58.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r94 = body.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 58.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r95 = body.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-6.5F, -1.5F, -1.0F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 58.218F, 34.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r96 = body.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-32.9642F, 58.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r97 = body.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-32.9642F, 58.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r98 = body.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(2, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 58.218F, -46.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r99 = body.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 58.218F, 40.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r100 = body.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 58.218F, 11.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r101 = body.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 58.218F, -17.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r102 = body.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(2, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 58.218F, -46.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r103 = body.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 58.218F, -17.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r104 = body.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 58.218F, 11.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r105 = body.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(3, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 58.218F, 40.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r106 = body.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-56.8267F, 45.718F, -15.9642F, 1.0F, 3.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(264, 164).addBox(-54.8267F, 39.718F, 22.0358F, 18.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(264, 164).addBox(-54.8267F, 39.718F, -22.9642F, 18.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 28).addBox(5.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(56, 8).addBox(3.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-6.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(1, 30).addBox(-8.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-4.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-0.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-63.8267F, 51.718F, 1.0358F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 37).addBox(-59.8267F, 51.718F, 15.0358F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-2.8267F, 49.718F, 4.5358F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r107 = body.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -15.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r108 = body.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -30.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r109 = body.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -45.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r110 = body.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -60.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r111 = body.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r112 = body.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -90.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r113 = body.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 56.718F, 16.0358F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -96.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r114 = body.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(16, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -111.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r115 = body.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(16, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r116 = body.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(19, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r117 = body.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r118 = body.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r119 = body.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(19, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r120 = body.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r121 = body.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(19, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r122 = body.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(28, 0).addBox(1.5F, -1.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, -33.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r123 = body.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(19, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 58.218F, -48.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r124 = body.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r125 = body.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r126 = body.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r127 = body.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r128 = body.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r129 = body.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r130 = body.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(7.5F, -1.5F, -12.0F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 58.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r131 = body.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r132 = body.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r133 = body.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r134 = body.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r135 = body.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r136 = body.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r137 = body.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r138 = body.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, -1.5F, -12.0F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, -42.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r139 = body.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9285F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r140 = body.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r141 = body.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 8.0358F, 18.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0715F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r142 = body.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r143 = body.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r144 = body.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(0, 9).addBox(-55.8267F, 39.718F, 11.0358F, 19.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r145 = body.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(0, 6).addBox(-55.8267F, 39.718F, 15.0358F, 18.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9285F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r146 = body.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(0, 31).addBox(-0.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-2.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-4.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-6.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(5.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-1.2142F, 49.718F, -3.9233F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r147 = body.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(2, 27).addBox(14.0862F, 75.918F, -6.9642F, 10.0F, 10.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(4.0862F, 83.918F, -3.9642F, 22.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(17, 39).addBox(-1.9138F, 83.918F, -3.9642F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r148 = body.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(17, 0).addBox(-56.2533F, 62.282F, -6.4642F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, -5.0F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r149 = body.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(2, 25).addBox(44.3989F, 63.8744F, -6.9642F, 5.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(2, 35).addBox(41.3989F, 60.8744F, 5.0358F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 36).addBox(41.3989F, 69.8744F, 3.0358F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 28).addBox(41.3989F, 76.8744F, -2.9642F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 28).addBox(41.3989F, 76.8744F, 1.0358F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(5, 31).addBox(41.3989F, 81.8744F, -0.9642F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(3, 28).addBox(41.3989F, 69.8744F, -4.9642F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 27).addBox(44.3989F, 69.8744F, -4.9642F, 5.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition cube_r150 = body.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(56, 0).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9285F, 0.0F, -34.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition deck = body.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(-25.9642F, 50.218F, 41.1733F));

		PartDefinition cube_r151 = deck.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -10.5F, -5.0F, 19.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r152 = deck.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r153 = deck.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r154 = deck.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -10.5F, -5.0F, 19.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r155 = deck.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -10.5F, -5.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r156 = deck.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r157 = deck.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r158 = deck.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r159 = deck.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r160 = deck.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -6.5F, -5.0F, 28.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r161 = deck.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -20.5F, -5.0F, 11.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 0.0F, -73.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r162 = deck.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r163 = deck.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -10.5F, -5.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition steer = Galleon.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(0.0F, -9.1045F, 58.2775F));

		PartDefinition cube_r164 = steer.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(3, 9).addBox(-2.0F, -9.0F, -5.5F, 4.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.8616F, 7.5175F, 0.1309F, 0.0F, -3.1416F));

		PartDefinition cube_r165 = steer.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(9, 3).addBox(-1.0F, -13.5F, -9.0F, 2.0F, 24.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.6045F, 9.7225F, -0.1309F, 0.0F, 0.0F));

		PartDefinition mast_1 = Galleon.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5F, -14.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-192, 12).addBox(-24.5F, -22.0F, -53.0F, 49.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r166 = mast_1.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(4, 8).addBox(-1.0358F, -107.5491F, 9.4171F, 2.0F, 41.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0358F, -78.718F, -11.1733F, -1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r167 = mast_1.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0358F, -105.4981F, 33.5542F, 2.0F, 40.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0358F, -78.718F, -11.1733F, -1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r168 = mast_1.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -33.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r169 = mast_1.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r170 = mast_1.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -87.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r171 = mast_1.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -114.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r172 = mast_1.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(0, 47).addBox(-11.0F, -1.0F, -0.8293F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-4.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(24.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-39.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -104.0F, 54.9293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r173 = mast_1.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(0, 45).addBox(-41.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-14.0F, -1.0F, -1.9F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-3.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -102.1716F, 55.0846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition mast_2 = Galleon.addOrReplaceChild("mast_2", CubeListBuilder.create().texOffs(9, 0).addBox(-1.5358F, -79.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(-1.5358F, -127.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(10, 0).addBox(-1.5358F, -175.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(4, 44).addBox(23.9642F, -135.282F, 10.1733F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 46).addBox(3.9642F, -135.282F, 10.1733F, 20.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 46).addBox(-47.0358F, -135.282F, 10.1733F, 23.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 46).addBox(-24.0358F, -135.282F, 10.1733F, 20.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 47).mirror().addBox(6.9642F, -170.282F, 10.1733F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-1, 47).mirror().addBox(-7.0358F, -170.282F, 10.1733F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-1, 47).addBox(-35.0358F, -170.282F, 10.1733F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-0.5358F, -195.282F, 13.1733F, 1.0F, 20.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 46).addBox(-4.0358F, -135.282F, 10.1733F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0358F, 17.2821F, -11.1733F));

		PartDefinition mast_3 = Galleon.addOrReplaceChild("mast_3", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5358F, 45.718F, -41.8267F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-1.5358F, -2.282F, -41.8267F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1, 45).addBox(-14.0358F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-42.0358F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 45).addBox(13.9642F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-1.5358F, -50.282F, -41.8267F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-1.5358F, -57.282F, -41.8267F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-1, 47).mirror().addBox(-7.0358F, -41.282F, -43.8267F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-1, 47).mirror().addBox(-35.0358F, -41.282F, -43.8267F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1, 47).addBox(6.9642F, -41.282F, -43.8267F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0358F, -92.718F, -11.1733F));

		PartDefinition chest_2 = Galleon.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-4.9642F, -68.718F, 27.8267F));

		PartDefinition cube_r174 = chest_2.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r175 = chest_2.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r176 = chest_2.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(1.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9285F, 0.0F, -22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r177 = chest_2.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, -22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition chest_1 = Galleon.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-4.0358F, 48.718F, 12.1733F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.9642F, -68.718F, -33.1733F));

		PartDefinition cube_r178 = chest_1.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r179 = chest_1.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r180 = chest_1.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(96, 38).addBox(-9.8267F, 48.718F, -10.9642F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 22.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r181 = chest_1.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(1.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.9285F, 0.0F, 24.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition chest_4 = Galleon.addOrReplaceChild("chest_4", CubeListBuilder.create().texOffs(30, 55).mirror().addBox(-29.625F, -34.0F, 60.125F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, 2.0F));

		PartDefinition cube_r182 = chest_4.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-2.0F, -4.5F, -68.375F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r183 = chest_4.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(50, 47).addBox(60.125F, 0.5F, -16.0F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(64, 29).mirror().addBox(61.625F, -4.5F, -11.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 29).mirror().addBox(61.625F, -1.5F, 6.25F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_3 = Galleon.addOrReplaceChild("chest_3", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-11.625F, -37.0F, -68.625F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 0.0F, 2.0F));

		PartDefinition cube_r184 = chest_3.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(30, 55).mirror().addBox(-20.0F, -1.5F, 60.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 55).mirror().addBox(16.0F, -1.5F, 60.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r185 = chest_3.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(64, 29).mirror().addBox(61.625F, -4.5F, -11.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 29).mirror().addBox(61.625F, -1.5F, 6.25F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r186 = chest_3.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(50, 47).addBox(-3.5F, -1.5F, -6.5F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.125F, -30.5F, -63.625F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(GalleonEntity galleonEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = galleonEntity.getInvFillState() >= 15;
		this.chest_2.visible = galleonEntity.getInvFillState() >= 30;
		this.chest_3.visible = galleonEntity.getInvFillState() >= 60;
		this.chest_4.visible = galleonEntity.getInvFillState() >= 90;

		this.steer.yRot = -galleonEntity.getRotSpeed() * 0.25F;

		this.lid_left_1.yRot = galleonEntity.isCannonInSlot(0) ? 120F : 0F;
		this.lid_left_2.yRot = galleonEntity.isCannonInSlot(1) ? 120F : 0F;
		this.lid_left_3.yRot = galleonEntity.isCannonInSlot(2) ? 120F : 0F;
		this.lid_right_1.yRot = galleonEntity.isCannonInSlot(3) ? 120F : 0F;
		this.lid_right_2.yRot = galleonEntity.isCannonInSlot(4) ? 120F : 0F;
		this.lid_right_3.yRot = galleonEntity.isCannonInSlot(5) ? 120F : 0F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.Galleon;
	}

}