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

		PartDefinition Galleon = partdefinition.addOrReplaceChild("Galleon", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition lid_left_1 = Galleon.addOrReplaceChild("lid_left_1", CubeListBuilder.create().texOffs(4, 35).addBox(-0.2F, -0.1F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(31.2F, -18.9F, 25.0F));

		PartDefinition lid_left_2 = Galleon.addOrReplaceChild("lid_left_2", CubeListBuilder.create().texOffs(4, 35).addBox(0.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(35.0F, -19.0F, -3.0F));

		PartDefinition lid_left_3 = Galleon.addOrReplaceChild("lid_left_3", CubeListBuilder.create().texOffs(4, 35).addBox(0.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(31.0F, -19.0F, -31.0F));

		PartDefinition lid_right_3 = Galleon.addOrReplaceChild("lid_right_3", CubeListBuilder.create().texOffs(4, 35).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.0F, -19.0F, -31.0F));

		PartDefinition lid_right_2 = Galleon.addOrReplaceChild("lid_right_2", CubeListBuilder.create().texOffs(4, 35).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-35.0F, -19.0F, -3.0F));

		PartDefinition lid_right_1 = Galleon.addOrReplaceChild("lid_right_1", CubeListBuilder.create().texOffs(4, 35).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-31.0F, -19.0F, 25.0F));

		PartDefinition body = Galleon.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 39).addBox(28.0358F, 55.718F, -23.8267F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(112, 88).addBox(28.0358F, 51.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(28.0358F, 54.718F, -36.8267F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(7, 30).addBox(28.0358F, 54.718F, 40.1733F, 4.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 39).addBox(28.0358F, 55.718F, 32.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 42).addBox(28.0358F, 54.718F, 28.1733F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(12, 23).addBox(31.0358F, 39.718F, -11.8267F, 4.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(20, 31).addBox(31.0358F, 39.718F, 4.1733F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 23).addBox(31.0358F, 39.718F, 12.1733F, 4.0F, 9.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(32.0358F, 54.718F, -11.8267F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 39).addBox(32.0358F, 55.718F, 4.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(32.0358F, 54.718F, 12.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(6, 29).addBox(27.0358F, 39.718F, -23.8267F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(5, 24).addBox(27.0358F, 39.718F, -36.8267F, 4.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 38).addBox(27.0358F, 34.718F, -36.8267F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(8, 20).addBox(24.0358F, 51.718F, -54.8267F, 4.0F, 8.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(5, 27).addBox(27.0358F, 34.718F, 37.1733F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(2, 28).addBox(-23.9642F, 30.718F, 69.1733F, 4.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(2, 28).addBox(20.0358F, 30.718F, 69.1733F, 4.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(6, 28).addBox(-26.9642F, 30.718F, 65.1733F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 20).addBox(-26.9642F, 30.718F, 53.1733F, 4.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(5, 27).addBox(-26.9642F, 49.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(6, 28).addBox(23.0358F, 30.718F, 65.1733F, 4.0F, 19.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(2, 22).addBox(23.0358F, 49.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(2, 17).addBox(23.0358F, 30.718F, 53.1733F, 4.0F, 19.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 39).mirror().addBox(-31.9642F, 55.718F, 32.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 29).mirror().addBox(-31.9642F, 54.718F, 40.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(9, 31).mirror().addBox(-30.9642F, 39.718F, 32.1733F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(30, 35).mirror().addBox(-30.9642F, 39.718F, 28.1733F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 39).mirror().addBox(-35.9642F, 55.718F, 4.1733F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 30).mirror().addBox(-35.9642F, 54.718F, -11.8267F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(20, 31).mirror().addBox(-34.9642F, 39.718F, 4.1733F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(9, 23).mirror().addBox(-34.9642F, 39.718F, -11.8267F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(19, 31).mirror().addBox(-30.9642F, 39.718F, -23.8267F, 4.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 19).mirror().addBox(-30.9642F, 39.718F, -15.8267F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 39).mirror().addBox(-31.9642F, 55.718F, -23.8267F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(9, 34).mirror().addBox(-31.9642F, 54.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 26).mirror().addBox(-30.9642F, 39.718F, -36.8267F, 4.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 28).mirror().addBox(-30.9642F, 34.718F, 37.1733F, 4.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(-26.9642F, 34.718F, -54.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(-26.9642F, 34.718F, -45.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(4, 23).mirror().addBox(23.0358F, 42.718F, -54.8267F, 4.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(23.0358F, 34.718F, -54.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(23.0358F, 34.718F, -45.8267F, 4.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(7, 24).mirror().addBox(-26.9642F, 42.718F, -54.8267F, 4.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 20).mirror().addBox(-27.9642F, 51.718F, -54.8267F, 4.0F, 8.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(10, 23).mirror().addBox(-34.9642F, 39.718F, 12.1733F, 4.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 23).mirror().addBox(-30.9642F, 39.718F, 40.1733F, 4.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 23).mirror().addBox(-30.9642F, 51.718F, 40.1733F, 4.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(30, 35).mirror().addBox(-30.9642F, 51.718F, 28.1733F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 23).mirror().addBox(-34.9642F, 51.718F, 12.1733F, 4.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(9, 23).mirror().addBox(-34.9642F, 51.718F, -11.8267F, 4.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 26).mirror().addBox(-30.9642F, 51.718F, -36.8267F, 4.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 38).mirror().addBox(-30.9642F, 34.718F, -36.8267F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 19).mirror().addBox(27.0358F, 39.718F, -15.8267F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(12, 23).addBox(31.0358F, 48.718F, 12.1733F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(12, 23).addBox(31.0358F, 48.718F, -11.8267F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(18, 19).mirror().addBox(27.0358F, 48.718F, -15.8267F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(5, 24).addBox(27.0358F, 48.718F, -36.8267F, 4.0F, 6.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).mirror().addBox(-35.9642F, 54.718F, 12.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 42).mirror().addBox(-31.9642F, 54.718F, 28.1733F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 33).mirror().addBox(-31.9642F, 54.718F, -36.8267F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 30).mirror().addBox(24.0358F, 54.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(4, 25).mirror().addBox(-27.9642F, 54.718F, 53.1733F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 42).mirror().addBox(28.0358F, 54.718F, -15.8267F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.0358F, -66.718F, -11.1733F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 59.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 68.5179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8642F, 68.5179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8642F, 68.5179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8642F, 68.5179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8642F, 68.5179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(7, 0).addBox(-17.0F, -9.0F, 1.0F, 18.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8642F, 68.5179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(7, 0).addBox(-17.0F, -9.0F, 1.0F, 18.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.1358F, 68.618F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.1358F, 68.618F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.1358F, 68.618F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.1358F, 68.618F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1358F, 68.618F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.1358F, 68.618F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-23.0F, -9.0F, 1.0F, 24.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7642F, 74.618F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-23.0F, -9.0F, 1.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7642F, 74.618F, 59.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 24.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7642F, 74.618F, 36.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -9.0F, 1.0F, 22.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7642F, 74.618F, 11.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -8.0F, 1.0F, 22.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7642F, 74.618F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -9.0F, 1.0F, 18.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7642F, 74.618F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-23.0F, -9.0F, 1.0F, 8.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, 59.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-23.0F, -9.0F, 1.0F, 24.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 59.0179F, 67.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 59.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 24.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, 36.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 59.0179F, 42.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 59.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r30 = body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -9.0F, 1.0F, 22.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, 11.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 59.0179F, 17.3733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 59.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -8.0F, 1.0F, 22.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r34 = body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r35 = body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 62.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 59.0179F, -7.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r37 = body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1358F, 59.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 1.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1358F, 59.0179F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -9.0F, 1.0F, 18.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1358F, 74.618F, -32.6267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 77.418F, 67.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r41 = body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 77.418F, 42.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r42 = body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 77.418F, -7.7267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r43 = body.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 77.418F, 17.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r44 = body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(7, 0).addBox(-17.0F, -9.0F, 2.0F, 18.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 77.418F, -32.7267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r45 = body.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 82.418F, 67.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r46 = body.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 82.418F, 42.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r47 = body.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 82.418F, 17.2733F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r48 = body.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -9.0F, 2.0F, 25.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 82.418F, -7.7267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r49 = body.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(2, 0).addBox(-22.0F, -9.0F, 2.0F, 18.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1358F, 82.418F, -27.7267F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r50 = body.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-17.0862F, 78.918F, -8.9642F, 12.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7F, 18.6F, 10.9F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r51 = body.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(8, 0).mirror().addBox(-17.0862F, 78.918F, -8.9642F, 12.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 18.6F, 10.9F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r52 = body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-25.0862F, 78.918F, -8.9642F, 20.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 2.2F, -0.6F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r53 = body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-25.0862F, 78.918F, -9.9642F, 20.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8F, 2.2F, -0.7F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r54 = body.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(54.8267F, 51.718F, 15.0358F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 30).mirror().addBox(50.8267F, 56.718F, 7.0358F, 8.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 62.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 62.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 32).mirror().addBox(58.8267F, 51.718F, 1.0358F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r55 = body.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(4, 34).mirror().addBox(6.5358F, 32.0624F, 75.0404F, 18.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(6, 34).mirror().addBox(-24.4642F, 32.0624F, 75.0404F, 18.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 34).mirror().addBox(-6.4642F, 32.0624F, 75.0404F, 13.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(11.0358F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(0.0358F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(-10.9642F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 34).mirror().addBox(-21.9642F, 16.3133F, 85.1126F, 11.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r56 = body.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(13, 40).mirror().addBox(53.8267F, 54.718F, 12.0358F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-28.0F, 3.3F, 2.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r57 = body.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(12, 39).mirror().addBox(53.8267F, 54.718F, 9.0358F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.0F, 3.3F, 2.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r58 = body.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(13, 40).mirror().addBox(53.8267F, 54.718F, 7.0358F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 3.3F, 2.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r59 = body.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(10, 37).mirror().addBox(53.8267F, 54.718F, 7.0358F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.3F, 2.2F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r60 = body.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(4, 39).mirror().addBox(50.8267F, 56.718F, 9.0358F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r61 = body.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r62 = body.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r63 = body.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r64 = body.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(29, 0).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r65 = body.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r66 = body.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r67 = body.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r68 = body.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r69 = body.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r70 = body.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r71 = body.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r72 = body.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r73 = body.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r74 = body.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r75 = body.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r76 = body.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r77 = body.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r78 = body.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(20.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r79 = body.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r80 = body.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r81 = body.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r82 = body.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r83 = body.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r84 = body.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r85 = body.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r86 = body.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r87 = body.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r88 = body.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r89 = body.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r90 = body.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r91 = body.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r92 = body.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r93 = body.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(44.8267F, 59.718F, -13.9642F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r94 = body.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r95 = body.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r96 = body.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r97 = body.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 16.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r98 = body.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r99 = body.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r100 = body.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 32.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r101 = body.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 24.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r102 = body.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r103 = body.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 40.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r104 = body.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r105 = body.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r106 = body.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 56.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r107 = body.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 48.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r108 = body.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r109 = body.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 64.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r110 = body.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r111 = body.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r112 = body.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 80.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r113 = body.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 72.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r114 = body.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r115 = body.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 88.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r116 = body.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r117 = body.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r118 = body.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(29, 0).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(22.0F, 3.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r119 = body.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(32, 5).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r120 = body.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(3, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 106.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r121 = body.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(26, 5).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 98.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r122 = body.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(32, 5).mirror().addBox(50.8267F, 59.718F, -15.9642F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 96.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r123 = body.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(44.8267F, 59.718F, -15.9642F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 3.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r124 = body.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(28, 7).mirror().addBox(44.8267F, 59.718F, -13.9642F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(30.0F, 3.0F, 114.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r125 = body.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(30, 35).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 54.718F, 30.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r126 = body.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(10, 24).mirror().addBox(-2.0F, -6.0F, -8.5F, 4.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 54.718F, 46.6733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r127 = body.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(10, 24).mirror().addBox(-2.0F, -6.0F, -8.5F, 4.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 45.718F, 46.6733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r128 = body.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(11, 21).mirror().addBox(48.0095F, 43.0631F, 0.0358F, 4.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 28).mirror().addBox(48.0095F, 54.0631F, 0.0358F, 4.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 25).mirror().addBox(45.0095F, 43.0631F, 15.0358F, 4.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 25).mirror().addBox(45.0095F, 43.0631F, -22.9642F, 4.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition cube_r129 = body.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(7, 21).mirror().addBox(48.0095F, 54.0631F, 0.0358F, 4.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(12, 21).mirror().addBox(48.0095F, 43.0631F, 0.0358F, 4.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 0.0F, 0.0F, -1.5708F, 1.3963F, -1.5708F));

		PartDefinition cube_r130 = body.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(6, 29).mirror().addBox(-9.0862F, 72.918F, -7.9642F, 9.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r131 = body.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(5, 31).mirror().addBox(-9.0862F, 72.918F, -7.9642F, 9.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r132 = body.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(6, 30).mirror().addBox(-9.0862F, 72.918F, -7.9642F, 9.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.5708F, 0.6109F, -1.5708F));

		PartDefinition cube_r133 = body.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(2, 31).mirror().addBox(-49.3989F, 79.8744F, -2.9642F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 26).mirror().addBox(-44.3989F, 60.8744F, 5.0358F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

		PartDefinition cube_r134 = body.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0358F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r135 = body.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0358F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r136 = body.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.9642F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r137 = body.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.9642F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r138 = body.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.9642F, 45.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r139 = body.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-22.0F, -15.5F, -5.0F, 25.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.9642F, 48.218F, 57.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r140 = body.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -3.5F, -5.0F, 19.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0358F, 50.218F, -5.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r141 = body.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-21.0F, -3.5F, -5.0F, 21.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0358F, 50.218F, 7.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r142 = body.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(2, 1).mirror().addBox(-21.0F, -3.5F, -5.0F, 21.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.9642F, 50.218F, 7.1733F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r143 = body.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -3.5F, -5.0F, 19.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-30.9642F, 50.218F, -5.8267F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r144 = body.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(30, 35).mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 45.718F, 30.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r145 = body.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(20, 31).mirror().addBox(-2.0F, -3.0F, -4.0F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(29.0358F, 42.718F, 36.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r146 = body.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(3, 26).mirror().addBox(1.2142F, 44.718F, -7.4233F, 12.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, 0.0F, -46.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r147 = body.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(6, 26).mirror().addBox(1.2142F, 44.718F, -7.4233F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, -46.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r148 = body.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(3, 27).mirror().addBox(-3.7858F, 44.718F, -7.4233F, 13.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(21.0F, 0.0F, -46.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r149 = body.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(6, 26).mirror().addBox(1.2142F, 44.718F, -7.4233F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 0.0F, -46.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r150 = body.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(6, 26).mirror().addBox(1.2142F, 44.718F, -7.4233F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 0.0F, -46.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r151 = body.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(6, 26).mirror().addBox(1.2142F, 45.718F, -7.4233F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 0.0F, -33.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r152 = body.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(26.5358F, 61.218F, -24.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r153 = body.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-6.5F, -1.5F, -1.0F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 61.218F, 34.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r154 = body.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 61.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r155 = body.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-25.9642F, 61.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r156 = body.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-12.5F, -1.5F, -1.5F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.4642F, 61.218F, -24.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r157 = body.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 61.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r158 = body.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1.5F, -1.5F, -1.0F, 20.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 61.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r159 = body.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-6.5F, -1.5F, -1.0F, 25.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0358F, 61.218F, 34.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r160 = body.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-32.9642F, 61.218F, 9.6733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r161 = body.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-1.5F, -1.5F, -5.0F, 20.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-32.9642F, 61.218F, -10.3267F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r162 = body.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(2, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 61.218F, -46.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r163 = body.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(1, 8).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 61.218F, 40.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r164 = body.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(1, 5).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 61.218F, 11.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r165 = body.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 61.218F, -17.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r166 = body.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(2, 4).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.4642F, 61.218F, -46.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r167 = body.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 61.218F, -17.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r168 = body.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-28.5F, -1.5F, -0.5F, 29.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(24.5358F, 61.218F, 11.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r169 = body.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 56.718F, 16.0358F, 12.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-63.8267F, 48.718F, 1.0358F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(6, 28).addBox(-59.8267F, 48.718F, 15.0358F, 5.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 3.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r170 = body.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -15.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r171 = body.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -30.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r172 = body.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -45.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r173 = body.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -60.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r174 = body.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r175 = body.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(15, 0).addBox(55.1733F, 59.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -90.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r176 = body.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(19, 0).addBox(55.1733F, 59.718F, 16.0358F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, -96.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r177 = body.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(16, 0).addBox(55.1733F, 56.718F, 16.0358F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 3.0F, -111.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r178 = body.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(18, 0).addBox(-5.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r179 = body.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(16, -1).addBox(-5.5F, -1.5F, -4.0F, 13.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r180 = body.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r181 = body.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r182 = body.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(15, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r183 = body.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r184 = body.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(15, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r185 = body.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(28, 0).addBox(1.5F, -1.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, -33.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r186 = body.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(15, 0).addBox(-7.5F, -1.5F, -4.0F, 15.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0358F, 61.218F, -48.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r187 = body.addOrReplaceChild("cube_r187", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 61.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r188 = body.addOrReplaceChild("cube_r188", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, 62.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r189 = body.addOrReplaceChild("cube_r189", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r190 = body.addOrReplaceChild("cube_r190", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r191 = body.addOrReplaceChild("cube_r191", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r192 = body.addOrReplaceChild("cube_r192", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r193 = body.addOrReplaceChild("cube_r193", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r194 = body.addOrReplaceChild("cube_r194", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(18, 0).addBox(7.5F, -1.5F, -12.0F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0358F, 61.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r195 = body.addOrReplaceChild("cube_r195", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, 1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 47.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r196 = body.addOrReplaceChild("cube_r196", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 61.218F, 32.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r197 = body.addOrReplaceChild("cube_r197", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 61.218F, 17.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r198 = body.addOrReplaceChild("cube_r198", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, 1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, 2.6733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r199 = body.addOrReplaceChild("cube_r199", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 61.218F, -12.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r200 = body.addOrReplaceChild("cube_r200", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, 1.5F, -12.0F, 15.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, -27.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r201 = body.addOrReplaceChild("cube_r201", CubeListBuilder.create().texOffs(3, 0).addBox(-7.5F, 1.5F, -12.0F, 6.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9642F, 58.218F, -42.3267F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r202 = body.addOrReplaceChild("cube_r202", CubeListBuilder.create().texOffs(10, 0).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9285F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r203 = body.addOrReplaceChild("cube_r203", CubeListBuilder.create().texOffs(9, 0).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r204 = body.addOrReplaceChild("cube_r204", CubeListBuilder.create().texOffs(11, 0).addBox(-55.8267F, 39.718F, 8.0358F, 18.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0715F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r205 = body.addOrReplaceChild("cube_r205", CubeListBuilder.create().texOffs(10, 0).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r206 = body.addOrReplaceChild("cube_r206", CubeListBuilder.create().texOffs(10, 0).addBox(-55.8267F, 39.718F, 8.0358F, 19.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r207 = body.addOrReplaceChild("cube_r207", CubeListBuilder.create().texOffs(3, 3).addBox(-55.8267F, 39.718F, 11.0358F, 19.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0715F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r208 = body.addOrReplaceChild("cube_r208", CubeListBuilder.create().texOffs(10, 0).addBox(-55.8267F, 39.718F, 15.0358F, 18.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9285F, 0.0F, 1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r209 = body.addOrReplaceChild("cube_r209", CubeListBuilder.create().texOffs(4, 0).addBox(-57.2533F, 43.282F, -3.4642F, 7.0F, 32.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 14.0F, 125.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r210 = body.addOrReplaceChild("cube_r210", CubeListBuilder.create().texOffs(7, 27).addBox(-56.2533F, 61.282F, -6.4642F, 6.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 1.4F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r211 = body.addOrReplaceChild("cube_r211", CubeListBuilder.create().texOffs(21, 2).addBox(-54.2533F, 62.282F, -6.4642F, 4.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.4285F, -5.5F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r212 = body.addOrReplaceChild("cube_r212", CubeListBuilder.create().texOffs(18, 0).addBox(-54.2533F, 62.282F, -6.4642F, 4.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4285F, -5.5F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r213 = body.addOrReplaceChild("cube_r213", CubeListBuilder.create().texOffs(21, 2).addBox(-54.2533F, 62.282F, -6.4642F, 4.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5715F, -5.5F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r214 = body.addOrReplaceChild("cube_r214", CubeListBuilder.create().texOffs(19, 0).addBox(-54.2533F, 62.282F, -6.4642F, 4.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5715F, -5.5F, 120.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r215 = body.addOrReplaceChild("cube_r215", CubeListBuilder.create().texOffs(6, 38).addBox(11.0862F, 83.918F, -3.9642F, 15.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, -11.0F, -12.7F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r216 = body.addOrReplaceChild("cube_r216", CubeListBuilder.create().texOffs(0, 39).addBox(4.0862F, 83.918F, -3.9642F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 22.55F, 15.7F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r217 = body.addOrReplaceChild("cube_r217", CubeListBuilder.create().texOffs(0, 39).addBox(4.0862F, 83.918F, -3.9642F, 19.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 7.0F, 4.8F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r218 = body.addOrReplaceChild("cube_r218", CubeListBuilder.create().texOffs(0, 39).addBox(4.0862F, 83.918F, -3.9642F, 13.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 25.0F, 12.5F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r219 = body.addOrReplaceChild("cube_r219", CubeListBuilder.create().texOffs(0, 39).addBox(4.0862F, 83.918F, -3.9642F, 22.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 7.0F, -0.1F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r220 = body.addOrReplaceChild("cube_r220", CubeListBuilder.create().texOffs(7, 37).addBox(-5.9138F, 83.918F, -3.9642F, 16.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 2.1F, 1.4F, -1.5708F, -0.6109F, 1.5708F));

		PartDefinition cube_r221 = body.addOrReplaceChild("cube_r221", CubeListBuilder.create().texOffs(2, 25).addBox(44.3989F, 63.8744F, -6.9642F, 5.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(2, 35).addBox(41.3989F, 60.8744F, 5.0358F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 36).addBox(41.3989F, 69.8744F, 3.0358F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 28).addBox(41.3989F, 76.8744F, -2.9642F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 28).addBox(41.3989F, 76.8744F, 1.0358F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(5, 31).addBox(41.3989F, 81.8744F, -0.9642F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(3, 28).addBox(41.3989F, 69.8744F, -4.9642F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(2, 27).addBox(44.3989F, 69.8744F, -4.9642F, 5.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition cube_r222 = body.addOrReplaceChild("cube_r222", CubeListBuilder.create().texOffs(5, 27).addBox(-2.5358F, 70.099F, -79.3951F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 19.075F, 29.65F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r223 = body.addOrReplaceChild("cube_r223", CubeListBuilder.create().texOffs(5, 27).addBox(-2.5358F, 70.099F, -79.3951F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 11.0F, 17.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r224 = body.addOrReplaceChild("cube_r224", CubeListBuilder.create().texOffs(0, 25).addBox(-1.5358F, 71.099F, -79.3951F, 3.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0715F, 0.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition deck = body.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(-25.9642F, 50.218F, 41.1733F));

		PartDefinition cube_r225 = deck.addOrReplaceChild("cube_r225", CubeListBuilder.create().texOffs(7, 29).mirror().addBox(-4.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(14, 31).mirror().addBox(-2.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 31).mirror().addBox(1.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(2, 30).mirror().addBox(-0.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.9642F, -50.218F, -41.1733F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r226 = deck.addOrReplaceChild("cube_r226", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(1.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 33).mirror().addBox(3.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 28).mirror().addBox(7.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 28).mirror().addBox(-4.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(3, 29).mirror().addBox(-8.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.9642F, -50.218F, -41.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r227 = deck.addOrReplaceChild("cube_r227", CubeListBuilder.create().texOffs(4, 28).addBox(5.1733F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-6.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(1, 30).addBox(-8.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 31).addBox(-4.8267F, 45.718F, -8.9642F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0358F, -50.218F, -41.1733F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r228 = deck.addOrReplaceChild("cube_r228", CubeListBuilder.create().texOffs(0, 31).addBox(-0.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-2.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(0, 28).addBox(-6.4642F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(0, 33).addBox(5.5358F, 45.7079F, -7.1733F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0358F, -50.218F, -41.1733F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r229 = deck.addOrReplaceChild("cube_r229", CubeListBuilder.create().texOffs(2, 0).mirror().addBox(-22.0F, -22.5F, -5.0F, 16.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -84.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r230 = deck.addOrReplaceChild("cube_r230", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(-22.0F, -20.5F, -5.0F, 16.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 0.0F, -84.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r231 = deck.addOrReplaceChild("cube_r231", CubeListBuilder.create().texOffs(2, 0).mirror().addBox(-22.0F, -22.5F, -5.0F, 16.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(31.0F, 0.0F, -84.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r232 = deck.addOrReplaceChild("cube_r232", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -10.5F, -5.0F, 19.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r233 = deck.addOrReplaceChild("cube_r233", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r234 = deck.addOrReplaceChild("cube_r234", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r235 = deck.addOrReplaceChild("cube_r235", CubeListBuilder.create().texOffs(10, 1).mirror().addBox(-13.0F, -10.5F, -5.0F, 19.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r236 = deck.addOrReplaceChild("cube_r236", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -10.5F, -5.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r237 = deck.addOrReplaceChild("cube_r237", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r238 = deck.addOrReplaceChild("cube_r238", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r239 = deck.addOrReplaceChild("cube_r239", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -28.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r240 = deck.addOrReplaceChild("cube_r240", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r241 = deck.addOrReplaceChild("cube_r241", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -6.5F, -5.0F, 28.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r242 = deck.addOrReplaceChild("cube_r242", CubeListBuilder.create().texOffs(4, 1).mirror().addBox(-22.0F, -20.5F, -5.0F, 11.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 0.0F, -73.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r243 = deck.addOrReplaceChild("cube_r243", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -15.5F, -5.0F, 28.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r244 = deck.addOrReplaceChild("cube_r244", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-22.0F, -10.5F, -5.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(43.0F, 0.0F, -56.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition steer = Galleon.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(9, 3).addBox(-1.0F, -14.1826F, -0.051F, 2.0F, 24.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(3, 9).addBox(-2.0F, -2.0942F, 3.949F, 4.0F, 18.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(3, 9).addBox(-2.0F, -20.0941F, 3.949F, 4.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.8955F, 63.2775F));

		PartDefinition mast_1 = Galleon.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.5F, -12.0F, 1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition cube_r245 = mast_1.addOrReplaceChild("cube_r245", CubeListBuilder.create().texOffs(4, 8).addBox(-1.0358F, -107.5491F, 9.4171F, 2.0F, 41.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0358F, -78.718F, -11.1733F, -1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r246 = mast_1.addOrReplaceChild("cube_r246", CubeListBuilder.create().texOffs(8, 8).addBox(-1.0358F, -105.4981F, 33.5542F, 2.0F, 40.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0358F, -78.718F, -11.1733F, -1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r247 = mast_1.addOrReplaceChild("cube_r247", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -33.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r248 = mast_1.addOrReplaceChild("cube_r248", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -60.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r249 = mast_1.addOrReplaceChild("cube_r249", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -87.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r250 = mast_1.addOrReplaceChild("cube_r250", CubeListBuilder.create().texOffs(0, 42).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -114.5F, 56.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r251 = mast_1.addOrReplaceChild("cube_r251", CubeListBuilder.create().texOffs(0, 47).addBox(-11.0F, -1.0F, -0.8293F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-4.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(24.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-39.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -104.0F, 54.9293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r252 = mast_1.addOrReplaceChild("cube_r252", CubeListBuilder.create().texOffs(0, 45).addBox(-41.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-14.0F, -1.0F, -1.9F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-3.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -102.1716F, 55.0846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition mast_2 = Galleon.addOrReplaceChild("mast_2", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5358F, -77.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-1.5358F, -125.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(-1.5358F, -173.282F, 12.1733F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(4, 44).addBox(23.9642F, -135.282F, 10.1733F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(1, 46).addBox(3.9642F, -135.282F, 10.1733F, 20.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(1, 46).addBox(-47.0358F, -135.282F, 10.1733F, 23.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(1, 46).addBox(-24.0358F, -135.282F, 10.1733F, 20.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).mirror().addBox(6.9642F, -170.282F, 10.1733F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(13, 36).mirror().addBox(-7.0358F, -170.282F, 10.1733F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 44).addBox(-35.0358F, -170.282F, 10.1733F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(13, 2).addBox(-0.5358F, -195.282F, 13.1733F, 1.0F, 22.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 46).addBox(-4.0358F, -135.282F, 10.1733F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0358F, 19.2821F, -11.1733F));

		PartDefinition mast_3 = Galleon.addOrReplaceChild("mast_3", CubeListBuilder.create().texOffs(5, 0).addBox(-1.5358F, 45.718F, -41.8267F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(5, 0).addBox(-1.5358F, -2.282F, -41.8267F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-14.0358F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 46).addBox(-42.0358F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(13.9642F, -7.282F, -43.8267F, 28.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(5, 0).addBox(-1.5358F, -50.282F, -41.8267F, 3.0F, 48.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(2, 0).addBox(-1.5358F, -57.282F, -41.8267F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(6, 46).mirror().addBox(-7.0358F, -41.282F, -43.8267F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 45).mirror().addBox(-35.0358F, -41.282F, -43.8267F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 47).addBox(6.9642F, -41.282F, -43.8267F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0358F, -90.718F, -11.1733F));

		PartDefinition chest_2 = Galleon.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-4.9642F, -66.718F, 27.8267F));

		PartDefinition cube_r253 = chest_2.addOrReplaceChild("cube_r253", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 50.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r254 = chest_2.addOrReplaceChild("cube_r254", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -10.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r255 = chest_2.addOrReplaceChild("cube_r255", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(1.2142F, 50.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9285F, 1.0F, -22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r256 = chest_2.addOrReplaceChild("cube_r256", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 3.0F, -22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition chest_1 = Galleon.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-4.0358F, 51.718F, 12.1733F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.9642F, -66.718F, -33.1733F));

		PartDefinition cube_r257 = chest_1.addOrReplaceChild("cube_r257", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 51.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r258 = chest_1.addOrReplaceChild("cube_r258", CubeListBuilder.create().texOffs(96, 38).addBox(-9.2142F, 48.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 22.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r259 = chest_1.addOrReplaceChild("cube_r259", CubeListBuilder.create().texOffs(96, 38).addBox(-9.8267F, 48.718F, -10.9642F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 22.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r260 = chest_1.addOrReplaceChild("cube_r260", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(1.2142F, 51.718F, -7.4233F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.9285F, 0.0F, 24.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition chest_4 = Galleon.addOrReplaceChild("chest_4", CubeListBuilder.create().texOffs(30, 55).mirror().addBox(-29.625F, -34.0F, 60.125F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 2.0F));

		PartDefinition cube_r261 = chest_4.addOrReplaceChild("cube_r261", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-2.0F, -4.5F, -68.375F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r262 = chest_4.addOrReplaceChild("cube_r262", CubeListBuilder.create().texOffs(50, 47).addBox(60.125F, 0.5F, -16.0F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(64, 29).mirror().addBox(61.625F, -4.5F, -11.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 29).mirror().addBox(61.625F, -1.5F, 6.25F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_3 = Galleon.addOrReplaceChild("chest_3", CubeListBuilder.create().texOffs(96, 38).mirror().addBox(-11.625F, -37.0F, -67.625F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(10.0F, 2.0F, 2.0F));

		PartDefinition cube_r263 = chest_3.addOrReplaceChild("cube_r263", CubeListBuilder.create().texOffs(30, 55).mirror().addBox(-20.0F, -1.5F, 60.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(30, 55).mirror().addBox(16.0F, -1.5F, 60.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition cube_r264 = chest_3.addOrReplaceChild("cube_r264", CubeListBuilder.create().texOffs(64, 29).mirror().addBox(61.625F, -4.5F, -11.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 29).mirror().addBox(61.625F, -1.5F, 6.25F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.625F, -32.5F, -0.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r265 = chest_3.addOrReplaceChild("cube_r265", CubeListBuilder.create().texOffs(50, 47).addBox(-3.5F, -1.5F, -6.5F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.125F, -30.5F, -63.625F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}


	@Override
	public void setupAnim(GalleonEntity galleonEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = galleonEntity.getInvFillState() >= 15;
		this.chest_2.visible = galleonEntity.getInvFillState() >= 30;
		this.chest_3.visible = galleonEntity.getInvFillState() >= 60;
		this.chest_4.visible = galleonEntity.getInvFillState() >= 90;

		this.steer.yRot = -galleonEntity.getRotSpeed() * 0.25F;

		this.lid_left_1.zRot = galleonEntity.isCannonInSlot(5) ? 40F : 0F;
		this.lid_left_2.zRot = galleonEntity.isCannonInSlot(7) ? 40F : 0F;
		this.lid_left_3.zRot = galleonEntity.isCannonInSlot(9) ? 40F : 0F;
		this.lid_right_1.zRot = galleonEntity.isCannonInSlot(4) ? -40F : 0F;
		this.lid_right_2.zRot = galleonEntity.isCannonInSlot(6) ? -40F : 0F;
		this.lid_right_3.zRot = galleonEntity.isCannonInSlot(8) ? -40F : 0F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.Galleon;
	}

}