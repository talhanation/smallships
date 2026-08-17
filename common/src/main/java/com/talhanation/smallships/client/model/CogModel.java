package com.talhanation.smallships.client.model;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CogModel extends ShipModel<CogEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, CogEntity.ID + "_model"), "main");
	private final ModelPart cog;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;

	public CogModel(ModelPart modelPart) {
		this.cog = modelPart;
		ModelPart cog = this.cog.getChild("Cog");
		this.chest1 = cog.getChild("chest_1");
		this.chest2 = cog.getChild("chest_2");
		this.chest3 = cog.getChild("chest_3");
		this.chest4 = cog.getChild("chest_4");
		this.steer = cog.getChild("steer");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Cog = partdefinition.addOrReplaceChild("Cog", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition deck = Cog.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 0).addBox(28.0F, 0.0F, 2.0F, 24.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(28.0F, -15.0F, 2.0F, 24.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(30.0F, 0.0F, 17.0F, 22.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(30.0F, -13.0F, 17.0F, 22.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(-42.5F, -6.5F, 13.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-13.0F, -17.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-13.0F, 14.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -14.0F, 2.0F, 28.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 16.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -19.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom = Cog.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(4, 1).addBox(52.0F, -11.0F, -3.5F, 4.0F, 11.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(52.0F, -24.0F, -3.5F, 4.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 1).addBox(-4.4937F, -19.3774F, -3.5F, 11.0F, 17.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(8, 5).addBox(1.2752F, -40.9843F, -1.5F, 3.0F, 22.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(-4.4937F, -2.3774F, -3.5F, 14.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.44F, 2.4938F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 0).addBox(44.0F, -2.0F, -14.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(52.0F, -2.0F, -14.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(-4, 2).addBox(46.0F, -2.0F, -6.0F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(26.0F, -4.0F, -14.0F, 18.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(19, 5).addBox(48.0F, -4.0F, -3.0F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(17, 3).addBox(44.0F, -4.0F, -8.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(23, 5).addBox(48.0F, -4.0F, 0.0F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -4.0F, -14.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.0F, -4.0F, -14.0F, 10.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -4.0F, -14.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -4.0F, -7.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(5, 5).addBox(-28.0F, -4.0F, 0.0F, 5.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(-24.0F, 4.0F, -3.0F, 18.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(-24.0F, -14.0F, -3.0F, 18.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -14.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -14.0F, -3.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, 4.0F, -3.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -14.0F, -3.0F, 20.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, 4.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, 4.0F, -3.0F, 20.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, 3.0F, -8.0F, 16.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -13.0F, -8.0F, 16.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, 3.0F, -8.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -13.0F, -8.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -13.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, 3.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-20.0F, 3.0F, -8.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-20.0F, -13.0F, -8.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(12, 1).addBox(-17.0F, 1.0F, -12.0F, 11.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-6.0F, 1.0F, -12.0F, 24.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(18.0F, 1.0F, -12.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(28.0F, 1.0F, -12.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(12, 1).addBox(-17.0F, -10.0F, -12.0F, 11.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-6.0F, -10.0F, -12.0F, 24.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(18.0F, -10.0F, -12.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(28.0F, -10.0F, -12.0F, 10.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sides = Cog.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(15, 36).addBox(-21.0F, -11.0F, -16.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(15, 36).addBox(-28.0F, -11.0F, -14.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(15, 36).addBox(-28.0F, -11.0F, 11.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-13.0F, -11.0F, -19.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -11.0F, -21.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, -18.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(16, 36).addBox(-20.0F, -11.0F, 13.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-13.0F, -11.0F, 16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(38.0F, -11.0F, -15.0F, 14.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 37).addBox(37.0F, -17.0F, -15.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(47.0F, -17.0F, -15.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(38.0F, -17.0F, 13.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(28.0F, -17.0F, -15.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(28.0F, -17.0F, 13.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(47.0F, -17.0F, 13.0F, 5.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-37.5F, -22.0F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-37.5F, -22.0F, 4.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-33.5F, -22.0F, 4.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-33.5F, -22.0F, -6.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-40.5F, -22.0F, 4.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-40.5F, -22.0F, -6.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(38.0F, -11.0F, 13.0F, 14.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(13, 37).addBox(28.0F, -11.0F, -15.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(13, 37).addBox(28.0F, -11.0F, 13.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(38.0F, -23.0F, 13.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 36).addBox(28.0F, -23.0F, 13.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -29.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(38.0F, -29.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(47.0F, -29.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(47.0F, -29.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(38.0F, -29.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -29.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(38.0F, -23.0F, -16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 36).addBox(28.0F, -23.0F, -16.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(0.0F, -11.0F, 18.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(18.0F, -11.0F, 15.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 37).addBox(-23.0F, -3.0F, 16.5F, 13.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-6.0F, -14.0F, -77.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-11.0F, -14.0F, -77.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-16.0F, -14.0F, -77.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(-23.0F, -9.0F, 16.5F, 11.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 37).addBox(-6.5F, -9.0F, 16.5F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 37).addBox(-9.5F, -3.0F, 16.5F, 13.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-23.0F, -21.0F, 16.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-14.0F, -21.0F, 16.5F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-23.0F, -15.0F, 16.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5F, -15.0F, 16.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-1.5F, -21.0F, 16.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5F, -15.0F, -8.0F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-1.5F, -21.0F, -8.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-14.0F, -21.0F, -8.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-23.0F, -21.0F, -8.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-23.0F, -15.0F, -8.0F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 36).addBox(4.5F, -3.0F, 7.5F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(11, 36).addBox(-7.5F, -3.0F, 7.5F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition mast_1 = Cog.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(8, 0).addBox(-15.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-15.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-15.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-15.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-15.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -5.0F, -1.0F));

		PartDefinition cube_r6 = mast_1.addOrReplaceChild("cube_r6", CubeListBuilder.create(), PartPose.offsetAndRotation(-47.5F, -15.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition mast_oben = Cog.addOrReplaceChild("mast_oben", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(-3.0F, -69.0F, -34.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(-3.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 6).addBox(-3.0F, -69.0F, 16.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest_1 = Cog.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest_1_r1 = chest_1.addOrReplaceChild("chest_1_r1", CubeListBuilder.create().texOffs(96, 38).addBox(-13.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.0F, -9.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-0.2501F, 3.65F, 9.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-11.2501F, 3.65F, 9.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(-5.2501F, 3.65F, 9.75F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.75F, -11.75F, -8.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(0.0F, 5.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -15.5F, -18.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(58.0F, -19.0F, 25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, 9.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0F, -9.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_4 = Cog.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offset(1.0F, -11.5F, 2.0F));

		PartDefinition cube_r11 = chest_4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 29).addBox(-11.0001F, -1.5F, 28.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = chest_4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 55).addBox(40.9999F, -19.0F, -30.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = chest_4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 47).addBox(45.9999F, -17.0F, -41.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = Cog.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(19.0F, -15.5F, 15.0F));

		PartDefinition cube_r14 = chest_2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 55).addBox(-1.0F, 6.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(56.0F, -19.0F, 14.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(32.0F, -25.0F, -18.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r17_r1 = cube_r16.addOrReplaceChild("cube_r17_r1", CubeListBuilder.create().texOffs(96, 38).addBox(4.0001F, -4.0F, -14.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 0.0F, -1.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r16_r1 = cube_r16.addOrReplaceChild("cube_r16_r1", CubeListBuilder.create().texOffs(96, 38).addBox(4.0001F, -4.0F, -14.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 0.0F, 7.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_3 = Cog.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 0.0F, 12.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r17 = chest_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(30, 55).addBox(32.9999F, -19.0F, 32.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(31, 56).addBox(32.9999F, -19.0F, 28.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 9.0F, -20.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = chest_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0001F, -4.0F, -28.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -9.0F, 20.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition steer = Cog.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(0.0F, 0.0F, -1.0F, 6.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(0.0F, -14.0F, -1.0F, 6.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(56.0F, 2.0F, 0.0F));

		PartDefinition BannerStick = Cog.addOrReplaceChild("BannerStick", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, -94.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
 	@Override
	public void setupAnim(@NotNull CogEntity cogEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest1.visible = cogEntity.getInvFillState() >= 15;
		this.chest2.visible = cogEntity.getInvFillState() >= 30;
		this.chest3.visible = cogEntity.getInvFillState() >= 60;
		this.chest4.visible = cogEntity.getInvFillState() >= 90;

		this.steer.yRot = -cogEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.cog;
	}
}