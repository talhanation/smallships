package com.talhanation.smallships.client.model;


import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DrakkarModel extends ShipModel<DrakkarEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DrakkarEntity.ID + "_model"), "main");
	private final ModelPart root;
	private final ModelPart drakkar;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;
	private final ModelPart row_L_1;
	private final ModelPart row_L_2;
	private final ModelPart row_L_3;
	private final ModelPart row_L_4;
	private final ModelPart row_R_1;
	private final ModelPart row_R_2;
	private final ModelPart row_R_3;
	private final ModelPart row_R_4;

	public DrakkarModel(ModelPart modelPart) {
		this.root = modelPart;
		this.drakkar = this.root.getChild("Drakkar");
		this.chest1 = drakkar.getChild("chest_1");
		this.chest2 = drakkar.getChild("chest_2");
		this.chest3 = drakkar.getChild("chest_3");
		this.chest4 = drakkar.getChild("chest_4");
		this.steer = drakkar.getChild("steer");
		this.row_L_1 = drakkar.getChild("row_L_1");
		this.row_L_2 = drakkar.getChild("row_L_2");
		this.row_L_3 = drakkar.getChild("row_L_3");
		this.row_L_4 = drakkar.getChild("row_L_4");
		this.row_R_1 = drakkar.getChild("row_R_1");
		this.row_R_2 = drakkar.getChild("row_R_2");
		this.row_R_3 = drakkar.getChild("row_R_3");
		this.row_R_4 = drakkar.getChild("row_R_4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Drakkar = partdefinition.addOrReplaceChild("Drakkar", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition deck = Drakkar.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-55.0F, -13.0F, 2.0F, 13.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-55.0F, 0.0F, 2.0F, 13.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-42.0F, 0.0F, 2.0F, 14.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-42.0F, -16.0F, 2.0F, 14.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(28.0F, -13.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(28.0F, 0.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom = Drakkar.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 2).addBox(-56.0F, 3.0F, -4.0F, 14.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7_r1 = cube_r2.addOrReplaceChild("cube_r7_r1", CubeListBuilder.create().texOffs(7, 4).addBox(-1.6F, 4.8F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-26.6F, 0.8F, -3.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 5.5F, 0.0F, -3.1416F, 0.0F, 1.5708F));

		PartDefinition cube_r6_r1 = cube_r2.addOrReplaceChild("cube_r6_r1", CubeListBuilder.create().texOffs(5, 2).addBox(-3.5F, -5.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.3F, -18.6F, 0.0F, -3.1416F, 0.0F, 0.7854F));

		PartDefinition cube_r5_r1 = cube_r2.addOrReplaceChild("cube_r5_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-7.2F, -3.5F, -3.5F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 5.5F, 0.0F, 3.1416F, 0.0F, 2.4871F));

		PartDefinition cube_r7_r2 = cube_r2.addOrReplaceChild("cube_r7_r2", CubeListBuilder.create().texOffs(5, 2).addBox(-2.85F, -10.425F, -2.5F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-67.3F, -17.1F, 0.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition cube_r5_r2 = cube_r2.addOrReplaceChild("cube_r5_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-26.6F, 0.8F, -3.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-56.0F, 5.5F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r4_r1 = cube_r2.addOrReplaceChild("cube_r4_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-7.2F, -3.5F, -3.5F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-56.0F, 5.5F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -4.0F, -10.0F, 14.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 2.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -12.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -12.0F, -3.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, 2.0F, -3.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, -12.0F, -3.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, 2.0F, -3.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sides = Drakkar.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(-56.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-43.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-56.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-43.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(13.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-28.0F, -11.0F, -19.0F, 11.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-17.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(13.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-17.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-28.0F, -11.0F, 16.0F, 11.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create(), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 36).addBox(3.5001F, -3.0F, 35.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.4999F, -3.0F, 35.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.5001F, 3.0F, 34.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.4999F, 3.0F, 34.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-8.4999F, 6.0F, 34.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.5001F, 6.0F, 34.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5002F, -3.0F, -65.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.4998F, -3.0F, -65.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition steer = Drakkar.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(4.0F, 2.75F, -1.0F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(0.0F, -0.25F, -1.0F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(45.75F, -0.75F, 0.0F));

		PartDefinition row_L_4 = Drakkar.addOrReplaceChild("row_L_4", CubeListBuilder.create().texOffs(33, 3).addBox(-1.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r20 = row_L_4.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(9, 0).addBox(-11.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-11.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_3 = Drakkar.addOrReplaceChild("row_L_3", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r21 = row_L_3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(9, 0).addBox(-11.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-11.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_2 = Drakkar.addOrReplaceChild("row_L_2", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r22 = row_L_2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(9, 0).addBox(-7.0F, 19.0F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-7.0F, 2.0F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_1 = Drakkar.addOrReplaceChild("row_L_1", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r23 = row_L_1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_1 = Drakkar.addOrReplaceChild("row_R_1", CubeListBuilder.create().texOffs(33, 3).addBox(-3.0F, -0.5F, 19.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, -12.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r24 = row_R_1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(9, 0).addBox(-5.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-5.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 9.0F, -13.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_2 = Drakkar.addOrReplaceChild("row_R_2", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 19.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -11.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r25 = row_R_2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -13.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_3 = Drakkar.addOrReplaceChild("row_R_3", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 19.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -11.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r26 = row_R_3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -13.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_4 = Drakkar.addOrReplaceChild("row_R_4", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 19.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -11.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r27 = row_R_4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -13.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition mast_1 = Drakkar.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(8, 0).addBox(-6.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-6.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-6.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-6.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-6.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-6.0F, -81.0F, -0.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -1.0F));

		PartDefinition cube_r6 = mast_1.addOrReplaceChild("cube_r6", CubeListBuilder.create(), PartPose.offsetAndRotation(-47.5F, -15.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition BannerStick = Drakkar.addOrReplaceChild("BannerStick", CubeListBuilder.create().texOffs(8, 0).addBox(9.0F, -100.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -1.0F, 0.0F));

		PartDefinition mast_oben = Drakkar.addOrReplaceChild("mast_oben", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.0F, -69.0F, -32.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.0F, -69.0F, 16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

		PartDefinition chest_1 = Drakkar.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(96, 38).addBox(-25.0F, -13.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(55.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-11.7498F, -4.25F, -51.25F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.75F, -11.75F, -8.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(8.0001F, 40.5F, -10.0001F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -15.5F, -18.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(81.0001F, -19.0F, 54.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, 9.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0001F, -9.0F, -8.5002F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = Drakkar.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(86.0F, -15.5F, 15.0F));

		PartDefinition cube_r14 = chest_2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 55).addBox(-18.9997F, 90.5F, -10.0003F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(42.0003F, -19.0F, 102.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(49.0002F, -25.0F, 58.9999F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 38).addBox(48.0001F, -4.0F, -13.4995F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_3 = Drakkar.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offset(24.3333F, -8.0F, 0.8333F));

		PartDefinition cube_r17 = chest_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(30, 55).addBox(31.0F, -19.0F, 45.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(31, 56).addBox(33.0F, -19.0F, 13.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3333F, 17.0F, -33.8333F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = chest_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(96, 38).addBox(-5.0F, -4.0F, -49.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.3333F, -1.0F, 7.1667F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_4 = Drakkar.addOrReplaceChild("chest_4", CubeListBuilder.create().texOffs(96, 38).addBox(-39.0F, -13.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, 0.0F, 0.0F));

		PartDefinition cube_r11 = chest_4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(30, 55).addBox(-11.7498F, -4.25F, -64.25F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.75F, -11.75F, -8.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = chest_4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 55).addBox(8.0001F, 45.5F, -10.0001F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -15.5F, -18.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = chest_4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(30, 55).addBox(81.0001F, -19.0F, 57.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, 9.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = chest_4.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, 15.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0001F, -9.0F, -8.5002F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}



	@Override
	public void setupAnim(DrakkarEntity drakkarEntity, float f, float g, float h, float i, float j) {

		this.chest1.visible = drakkarEntity.getInvFillState() >= 15;
		this.chest2.visible = drakkarEntity.getInvFillState() >= 30;
		this.chest3.visible = drakkarEntity.getInvFillState() >= 60;
		this.chest4.visible = drakkarEntity.getInvFillState() >= 90;

		this.steer.yRot = -drakkarEntity.getRotSpeed() * 0.25F;

		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_1 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_2 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_3 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_4 , f);

		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_1 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_2 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_3 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_4 , f);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}