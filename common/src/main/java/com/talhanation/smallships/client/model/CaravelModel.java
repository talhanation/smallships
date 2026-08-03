package com.talhanation.smallships.client.model;// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CaravelModel extends ShipModel<CaravelEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, CaravelEntity.ID), "main");
	private final ModelPart Caravel;
	private final ModelPart bottom;
	private final ModelPart front;
	private final ModelPart sides;
	private final ModelPart deck;
	private final ModelPart chest_1;
	private final ModelPart chest_2;
	private final ModelPart chest_3;
	private final ModelPart chest_4;
	private final ModelPart mast_2;
	private final ModelPart mast_1;
	private final ModelPart steer;

	public CaravelModel(ModelPart root) {
		this.Caravel = root.getChild("Caravel");
		this.bottom = this.Caravel.getChild("bottom");
		this.front = this.bottom.getChild("front");
		this.sides = this.Caravel.getChild("sides");
		this.deck = this.Caravel.getChild("deck");
		this.chest_1 = this.Caravel.getChild("chest_1");
		this.chest_2 = this.Caravel.getChild("chest_2");
		this.chest_3 = this.Caravel.getChild("chest_3");
		this.chest_4 = this.Caravel.getChild("chest_4");
		this.mast_2 = this.Caravel.getChild("mast_2");
		this.mast_1 = this.Caravel.getChild("mast_1");
		this.steer = this.Caravel.getChild("steer");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Caravel = partdefinition.addOrReplaceChild("Caravel", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bottom = Caravel.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bottom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 0).addBox(-3.0F, -3.342F, -13.0603F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(9, 4).addBox(-3.0F, -3.342F, -23.0603F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.6F, -65.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(56.0F, 0.0F, -10.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(56.0F, -9.0F, -10.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(56.0F, 0.0F, -5.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(56.0F, -9.0F, -5.0F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, 0.0F, -10.0F, 13.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, -11.0F, -10.0F, 13.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 11.0F, -10.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, -16.0F, -10.0F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 19.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 13.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 0.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -22.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -19.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -13.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 19.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 13.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 0.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -22.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -19.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -13.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 19.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 13.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 0.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -22.0F, -10.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -19.0F, -10.0F, 19.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -13.0F, -10.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, 13.0F, -10.0F, 16.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, 0.0F, -10.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, -16.0F, -10.0F, 16.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, -13.0F, -10.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-51.0F, 0.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-58.0F, -10.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-51.0F, -13.0F, -10.0F, 7.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, 0.0F, -5.0F, 11.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, -9.0F, -5.0F, 11.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 0.0F, -5.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, -13.0F, -5.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 13.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 0.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -16.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -13.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 13.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 0.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -16.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -13.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 13.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 0.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -16.0F, -5.0F, 19.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -13.0F, -5.0F, 19.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, 0.0F, -5.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, -13.0F, -5.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1, 0).addBox(-58.0F, 6.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1, 0).addBox(-58.0F, 0.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1, 0).addBox(-58.0F, -9.0F, -5.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1, 0).addBox(-58.0F, -6.0F, -5.0F, 14.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, 0.0F, 0.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, -6.0F, 0.0F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-44.0F, 3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 3.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 3.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 3.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 9.0F, -5.5F, 16.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 9.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 9.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 9.0F, -5.5F, 19.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, 9.0F, -5.5F, 16.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bottom.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 0).addBox(-42.0F, 3.0F, -5.5F, 14.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -16.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bottom.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 9).addBox(-51.0F, -13.0F, -10.0F, 4.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, -4.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r6 = bottom.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(11, 3).addBox(-51.0F, -13.0F, -10.0F, 7.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(-44.0F, -13.0F, -10.0F, 17.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(-44.0F, 0.0F, -10.0F, 17.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(10, 2).addBox(-51.0F, 0.0F, -10.0F, 7.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 2).addBox(-44.0F, 13.0F, -10.0F, 17.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(14, 2).addBox(-44.0F, -16.0F, -10.0F, 17.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r7 = bottom.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 0).addBox(-51.0F, 0.0F, -10.0F, 7.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -7.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r8 = bottom.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(29.0F, -13.0F, -5.0F, 16.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = bottom.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(29.0F, 0.0F, -5.0F, 16.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition front = bottom.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 2.0F, -59.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r10 = front.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(10, 0).addBox(-14.5774F, -3.9063F, -5.5F, 12.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -15.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition cube_r11 = front.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(10, 0).addBox(-14.5774F, -8.9063F, -5.5F, 15.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -15.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition cube_r12 = front.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 0).addBox(-14.5774F, -8.9063F, -5.5F, 15.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 1.5708F));

		PartDefinition sides = Caravel.addOrReplaceChild("sides", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = sides.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(9, 37).addBox(-20.0F, -22.0F, -21.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 38.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = sides.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 38).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -4.0F, 73.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = sides.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 38).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 73.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = sides.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 38).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, 54.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = sides.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 38).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 54.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = sides.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(1, 38).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 19.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = sides.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(1, 37).addBox(-28.0F, -22.0F, -21.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = sides.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(7, 39).addBox(-7.5F, -1.5F, 0.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(7, 39).addBox(-7.5F, -1.5F, -8.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, -22.0F, -51.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r21 = sides.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(12, 37).addBox(-23.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 38).addBox(-16.0F, -22.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -1.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r22 = sides.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(12, 36).addBox(-23.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -1.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = sides.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(12, 36).addBox(-23.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, -9.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r24 = sides.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(12, 37).addBox(-23.0F, -19.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 37).addBox(-16.0F, -22.0F, -21.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -35.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = sides.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.5F, -21.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r26 = sides.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.5F, -29.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r27 = sides.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -21.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r28 = sides.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -29.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r29 = sides.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -29.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r30 = sides.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(4, 39).addBox(-10.5F, -1.5F, -4.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -21.0F, 65.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r31 = sides.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, -1.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -26.0F, -56.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r32 = sides.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, -1.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.0F, -56.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r33 = sides.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, -1.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -26.0F, -59.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r34 = sides.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(-1, 39).addBox(-10.5F, -1.5F, -4.0F, 20.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.0F, -59.5F, -1.5708F, 3.1416F, 0.0F));

		PartDefinition cube_r35 = sides.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -21.0F, 19.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r36 = sides.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(8, 39).addBox(-1.5F, -1.5F, -4.0F, 11.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -21.0F, -18.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r37 = sides.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, -29.0F, 54.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r38 = sides.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.5F, -21.0F, 54.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r39 = sides.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -29.0F, 35.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r40 = sides.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, 35.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r41 = sides.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -21.0F, 0.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r42 = sides.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 39).addBox(-9.5F, -1.5F, -4.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.5F, -21.0F, -34.5F, -1.5708F, 1.5708F, 0.0F));

		PartDefinition cube_r43 = sides.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 39).addBox(-28.0F, -22.0F, -21.0F, 19.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -16.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition deck = Caravel.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r44 = deck.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 0).addBox(45.0F, 0.0F, -23.0F, 19.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r45 = deck.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).addBox(45.0F, -9.0F, -23.0F, 19.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r46 = deck.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(29.0F, 13.0F, -23.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 0.0F, -23.0F, 16.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, -16.0F, -23.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, -13.0F, -23.0F, 16.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, 0.0F, -13.0F, 20.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(45.0F, -13.0F, -13.0F, 20.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, 13.0F, -13.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(29.0F, -19.0F, -13.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, 16.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(10.0F, -22.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 16.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -22.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 16.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -22.0F, -13.0F, 19.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, 16.0F, -13.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, -19.0F, -13.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r47 = deck.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r48 = deck.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -4.0F, 1.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r49 = deck.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -4.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r50 = deck.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -16.0F, -13.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition chest_1 = Caravel.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(8.0F, -17.0F, -26.0F));

		PartDefinition cube_r51 = chest_1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, 5.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 24.0F, 84.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r52 = chest_1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, 5.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 24.0F, 91.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r53 = chest_1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, 5.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 21.0F, 108.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r54 = chest_1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, 5.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 21.0F, 101.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r55 = chest_1.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 65.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_2 = Caravel.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-8.0F, -17.0F, -26.0F));

		PartDefinition cube_r56 = chest_2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, -10.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 24.0F, 85.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r57 = chest_2.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, -10.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 21.0F, 103.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r58 = chest_2.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, -10.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 21.0F, 101.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r59 = chest_2.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(30, 55).addBox(-28.0F, -10.5F, -25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 21.0F, 107.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r60 = chest_2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 66.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_3 = Caravel.addOrReplaceChild("chest_3", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(-8.0F, 2.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(-13.0F, 2.0F, -3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(-13.0F, 2.0F, 3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(9.0F, 2.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(4.0F, 2.0F, -3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(8.0F, 2.0F, 1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -34.0F, 59.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_4 = Caravel.addOrReplaceChild("chest_4", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(-8.0F, -5.5F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(-13.0F, -5.5F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(7.0F, -5.5F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(4.0F, -5.5F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, -50.0F));

		PartDefinition mast_2 = Caravel.addOrReplaceChild("mast_2", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 3.0F));

		PartDefinition cube_r61 = mast_2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 47).addBox(-16.3726F, -1.0F, -0.8293F, 5.3726F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-11.0F, -1.0F, -0.8293F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-4.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(24.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -79.0F, 26.9293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r62 = mast_2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 45).addBox(-18.3726F, -1.0F, -1.9F, 4.3726F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-14.0F, -1.0F, -1.9F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-3.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -77.1716F, 27.0846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r63 = mast_2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(1, 37).addBox(-13.5F, -0.5F, -1.5F, 27.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -89.5F, 29.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r64 = mast_2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -62.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r65 = mast_2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r66 = mast_2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(-3, 36).addBox(-16.5F, -1.5F, -1.5F, 30.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition mast_1 = Caravel.addOrReplaceChild("mast_1", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -56.0F));

		PartDefinition cube_r67 = mast_1.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 47).addBox(-61.6274F, -1.0F, -0.8293F, 22.6274F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-39.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-11.0F, -1.0F, -0.8293F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-4.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(24.0F, -1.0F, -0.8293F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0707F, -79.0F, 26.9293F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r68 = mast_1.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 45).addBox(-63.6274F, -1.0F, -1.9F, 22.6274F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-41.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-14.0F, -1.0F, -1.9F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-3.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(24.0F, -1.0F, -1.9F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.849F, -77.1716F, 27.0846F, 0.7903F, 0.6178F, 1.05F));

		PartDefinition cube_r69 = mast_1.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(1, 37).addBox(-13.5F, -0.5F, -1.5F, 27.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -89.5F, 29.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r70 = mast_1.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -62.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r71 = mast_1.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -35.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r72 = mast_1.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 36).addBox(-13.5F, -1.5F, -1.5F, 27.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 28.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition steer = Caravel.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, 58.0F));

		PartDefinition cube_r73 = steer.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(3, 29).addBox(59.0F, -1.0F, -10.0F, 8.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 13.0F, -55.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r74 = steer.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(2, 28).addBox(59.0F, -2.0F, -11.0F, 3.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, -58.0F, -1.5708F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(CaravelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = entity.getInvFillState() >= 15;
		this.chest_2.visible = entity.getInvFillState() >= 30;
		this.chest_3.visible = entity.getInvFillState() >= 60;
		this.chest_4.visible = entity.getInvFillState() >= 90;

		this.steer.yRot = -entity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.Caravel;
	}
}