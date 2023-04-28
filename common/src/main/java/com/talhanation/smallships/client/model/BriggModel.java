package com.talhanation.smallships.client.model;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


@SuppressWarnings("FieldCanBeLocal")
public class BriggModel extends ShipModel<BriggEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, BriggEntity.ID + "_model"), "main");
	private final ModelPart root;
	private final ModelPart brigg;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;

	public BriggModel(ModelPart modelPart) {
		this.root = modelPart;
		this.brigg = this.root.getChild("ModelBrigg");
		this.chest1 = brigg.getChild("chest_1");
		this.chest2 = brigg.getChild("chest_2");
		this.chest3 = brigg.getChild("chest_3");
		this.chest4 = brigg.getChild("chest_4");
		this.steer = brigg.getChild("steer");
	}
	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ModelBrigg = partdefinition.addOrReplaceChild("ModelBrigg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bottom_brigg = ModelBrigg.addOrReplaceChild("bottom_brigg", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-3.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-28.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-28.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-31.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-3.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-40.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-3.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-31.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-40.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bottom_brigg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -35.0F, 38.9F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -23.0F, 38.9F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -6.0F, 38.9F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -80.669F, 28.9006F, -1.4399F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom_brigg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -41.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -33.0F, 5.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -15.0F, 5.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -80.669F, 28.9006F, -1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bottom_brigg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 12).addBox(-18.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -1.0F, -14.0F, 18.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -6.0F, -14.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -5.0F, -14.0F, 18.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -20.0F, -14.0F, 18.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-28.0F, -22.0F, -14.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(-28.0F, 13.0F, -14.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 3).addBox(16.0F, 13.0F, -14.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.0F, -22.0F, -14.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, -25.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, 13.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, 0.0F, -14.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -19.0F, -14.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-39.0F, -15.0F, -11.0F, 24.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-39.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -16.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(31.0F, -3.0F, -11.0F, 14.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(31.0F, -16.0F, -11.0F, 14.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bottom_brigg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 0).addBox(-7.0F, -3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -29.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bottom_brigg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(3.0F, 0.5F, -11.5F, 16.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -13.5F, -50.0F, 3.1416F, -0.6545F, 1.5708F));

		PartDefinition cube_r6 = bottom_brigg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(3, 0).addBox(42.0F, -15.0F, -2.5F, 6.0F, 15.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(22.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -6.0F, -2.5F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(10.0F, -6.0F, -2.5F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-20.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_1 = ModelBrigg.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(31, 56).addBox(33.0F, -19.0F, 9.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(33.0F, -19.0F, 12.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(41.0F, -27.0F, 10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(38.0F, -19.0F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -18.0F, 41.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, -1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -20.5F, 42.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_3 = ModelBrigg.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.1667F, -18.9167F, -31.4167F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r11 = chest_3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(34.0F, -19.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1667F, 18.9167F, -40.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r12 = chest_3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8333F, 0.9167F, 0.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r13 = chest_3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, -1.5833F, 1.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_4 = ModelBrigg.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8333F, -18.9167F, -31.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r14 = chest_4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 8.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(34.0F, -19.0F, 2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1667F, 18.9167F, -40.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8333F, 0.9167F, 0.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, -1.5833F, 1.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sides_brigg = ModelBrigg.addOrReplaceChild("sides_brigg", CubeListBuilder.create().texOffs(0, 12).addBox(25.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r17 = sides_brigg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -25.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(37.0F, 13.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, -28.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, 19.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 19.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 16.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, -22.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(28.0F, 13.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(37.0F, -22.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(16.0F, 16.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -25.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -28.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, 13.0F, -22.0F, 14.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-45.0F, -2.0F, -24.0F, 3.0F, 15.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(-45.0F, -19.0F, -24.0F, 3.0F, 15.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -22.0F, -22.0F, 14.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = sides_brigg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -2.0F, -3.0F, 25.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -12.5335F, 47.4516F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r19 = sides_brigg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-23.5F, -3.0F, -3.0F, 14.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.6155F, 46.111F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r20 = sides_brigg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -10.0F, 3.0F, 22.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -6.5F, -3.0F, 14.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -24.5F, -3.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -2.5F, -3.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -17.0F, 48.0F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r21 = sides_brigg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 4).addBox(-44.0F, -1.0F, -13.5F, 16.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(13.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-2.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 4).addBox(-28.0F, -1.0F, -13.5F, 26.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -13.5F, -46.0F, 3.1416F, -1.0996F, 1.5708F));

		PartDefinition cube_r22 = sides_brigg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(3, 2).mirror().addBox(-13.7F, -2.5F, -17.0F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -13.5F, -62.0F, 3.1416F, -0.0436F, 1.5708F));

		PartDefinition cube_r23 = sides_brigg.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0.0F, -4.5F, -21.0F, 13.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 2).mirror().addBox(0.0F, 0.5F, -21.0F, 13.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -13.5F, -62.0F, 3.1416F, -0.6545F, 1.5708F));

		PartDefinition cube_r24 = sides_brigg.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(3.0F, -5.5F, -11.5F, 16.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -13.5F, -50.0F, 3.1416F, -0.6545F, 1.5708F));

		PartDefinition BannerStick = ModelBrigg.addOrReplaceChild("BannerStick", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r25 = BannerStick.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(6, 0).addBox(26.0F, -3.5F, -137.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition chest_2 = ModelBrigg.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r26 = chest_2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(96, 38).addBox(-17.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(96, 38).addBox(-8.5F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -18.0F, 41.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r27 = chest_2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(30, 55).addBox(30.0F, -25.0F, 2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(32.0F, -25.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition steer = ModelBrigg.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(-3.0F, -1.8071F, 48.6533F));

		PartDefinition steer_r1 = steer.addOrReplaceChild("steer_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -0.5F, 0.5F, 18.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1222F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}



	@Override
	public void setupAnim(BriggEntity briggEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte u_byteMaxValueFourth = (-Byte.MIN_VALUE + Byte.MAX_VALUE) / 4;
		this.chest1.visible = briggEntity.getContainerFillState() >= u_byteMaxValueFourth - (-Byte.MIN_VALUE);
		this.chest2.visible = briggEntity.getContainerFillState() >= u_byteMaxValueFourth * 2 - (-Byte.MIN_VALUE);
		this.chest3.visible = briggEntity.getContainerFillState() >= u_byteMaxValueFourth * 3 - (-Byte.MIN_VALUE);
		this.chest4.visible = briggEntity.getContainerFillState() >= u_byteMaxValueFourth * 4 - (-Byte.MIN_VALUE);

		this.steer.yRot = -((BoatAccessor) briggEntity).getDeltaRotation() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}