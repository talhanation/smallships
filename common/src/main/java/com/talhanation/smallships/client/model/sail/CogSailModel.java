package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CogSailModel extends SailModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	@SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, CogEntity.ID + "_sail_model"), "main");

	private final ModelPart CogSail;

	public CogSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.CogSail = root.getChild("CogSail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition CogSail = partdefinition.addOrReplaceChild("CogSail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Sail_4 = CogSail.addOrReplaceChild("Sail_4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_12 = Sail_4.addOrReplaceChild("segel_1_12", CubeListBuilder.create(), PartPose.offsetAndRotation(8.5F, -11.0F, 20.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r87 = segel_1_12.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(86, 16).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(86, 13).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(86, 11).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(86, 19).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(86, 13).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -26.3067F, 36.3895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r88 = segel_1_12.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(83, 13).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 14).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -28.4794F, 33.5112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r89 = segel_1_12.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(83, 21).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 22).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 22).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 14).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 14).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -34.7644F, 33.9338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r90 = segel_1_12.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(89, 5).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 4).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 10).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 4).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -39.6813F, 33.5822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r91 = segel_1_12.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(85, 16).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 19).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 20).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 17).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(85, 20).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r92 = segel_1_12.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(93, 22).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 11).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r93 = segel_1_12.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(89, 4).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 6).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 4).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r94 = segel_1_12.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(89, 6).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 6).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 11).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 12).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 6).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r95 = segel_1_12.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(93, 24).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 6).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 4).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 4).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -20.7281F, 39.2678F, 2.2227F, 0.0F, 0.0F));

		PartDefinition rope_15 = segel_1_12.addOrReplaceChild("rope_15", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.3963F, 0.7941F, 1.7628F));

		PartDefinition cube_r96 = rope_15.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(93, 22).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97 = rope_15.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(7, 20).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98 = rope_15.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(12, 28).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_16 = segel_1_12.addOrReplaceChild("rope_16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2654F, -0.7592F, -1.5708F));

		PartDefinition cube_r99 = rope_16.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(93, 22).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(93, 22).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = rope_16.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(7, 20).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101 = rope_16.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(12, 28).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition Sail_3 = CogSail.addOrReplaceChild("Sail_3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_9 = Sail_3.addOrReplaceChild("segel_1_9", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_10 = segel_1_9.addOrReplaceChild("segel_1_10", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_11 = segel_1_9.addOrReplaceChild("segel_1_11", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r64 = segel_1_11.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(84, 5).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -34.7644F, 33.9338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r65 = segel_1_11.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(84, 6).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 11).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -39.6813F, 33.5822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r66 = segel_1_11.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(88, 24).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 4).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r67 = segel_1_11.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(88, 23).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 13).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r68 = segel_1_11.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(84, 5).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r69 = segel_1_11.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(83, 10).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 13).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_19 = segel_1_11.addOrReplaceChild("rope_19", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5097F, 0.8552F, 1.7628F));

		PartDefinition cube_r70 = rope_19.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(85, 17).addBox(44.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(20.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(25.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r71 = rope_19.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r72 = rope_19.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r73 = rope_19.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(88, 23).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r74 = rope_19.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_20 = segel_1_11.addOrReplaceChild("rope_20", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3422F, -0.8454F, -1.5566F));

		PartDefinition cube_r75 = rope_20.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(88, 23).addBox(45.5F, -1.0F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(19.5F, -1.0F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(25.5F, -1.0F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r76 = rope_20.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r77 = rope_20.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r78 = rope_20.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(88, 23).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r79 = rope_20.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -1.0F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end4 = segel_1_11.addOrReplaceChild("sail_end4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r80 = sail_end4.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(88, 24).addBox(-37.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-50.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(83, 11).addBox(-63.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(83, 14).addBox(-24.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-11.0F, -41.6933F, 18.2105F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(55.5F, -1.8067F, 44.7895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition Sail_2 = CogSail.addOrReplaceChild("Sail_2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_6 = Sail_2.addOrReplaceChild("segel_1_6", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_7 = segel_1_6.addOrReplaceChild("segel_1_7", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_8 = segel_1_6.addOrReplaceChild("segel_1_8", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r43 = segel_1_8.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(88, 24).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 4).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r44 = segel_1_8.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(88, 23).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 13).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r45 = segel_1_8.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(84, 5).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r46 = segel_1_8.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(83, 10).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 13).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_11 = segel_1_8.addOrReplaceChild("rope_11", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5001F, 0.9684F, 1.7506F));

		PartDefinition cube_r47 = rope_11.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(85, 14).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 6).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = rope_11.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = rope_11.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r50 = rope_11.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(88, 23).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r51 = rope_11.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_12 = segel_1_8.addOrReplaceChild("rope_12", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3165F, -0.9301F, -1.5235F));

		PartDefinition cube_r52 = rope_12.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(86, 6).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r53 = rope_12.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r54 = rope_12.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r55 = rope_12.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(88, 23).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r56 = rope_12.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end3 = segel_1_8.addOrReplaceChild("sail_end3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r57 = sail_end3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(88, 24).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(83, 11).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(82, 6).addBox(6.9F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(19.9F, -2.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition Sail_1 = CogSail.addOrReplaceChild("Sail_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_2 = Sail_1.addOrReplaceChild("segel_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_1 = segel_1_2.addOrReplaceChild("segel_1_1", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_5 = segel_1_2.addOrReplaceChild("segel_1_5", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r25 = segel_1_5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(84, 5).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 5).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r26 = segel_1_5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(83, 10).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 12).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 11).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 10).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_7 = segel_1_5.addOrReplaceChild("rope_7", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4794F, 1.1163F, 1.7268F));

		PartDefinition cube_r27 = rope_7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(85, 13).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 6).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r28 = rope_7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r29 = rope_7.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r30 = rope_7.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(88, 23).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r31 = rope_7.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_8 = segel_1_5.addOrReplaceChild("rope_8", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2348F, -1.0973F, -1.4276F));

		PartDefinition cube_r32 = rope_8.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(85, 11).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = rope_8.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -31.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = rope_8.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -19.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r35 = rope_8.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(88, 23).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r36 = rope_8.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(88, 23).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end2 = segel_1_5.addOrReplaceChild("sail_end2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -41.0F, -1.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r102 = sail_end2.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(80, 20).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 18).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 18).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 17).addBox(6.9F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(88, 6).addBox(19.9F, -2.25F, -2.0F, 9.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition Sail_0 = CogSail.addOrReplaceChild("Sail_0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition segel_1_3 = Sail_0.addOrReplaceChild("segel_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_4 = segel_1_3.addOrReplaceChild("segel_1_4", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition rope_4 = segel_1_4.addOrReplaceChild("rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4884F, 1.2464F, 1.6894F));

		PartDefinition cube_r103 = rope_4.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(85, 17).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 6).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r104 = rope_4.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -33.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r105 = rope_4.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r106 = rope_4.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(88, 23).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r107 = rope_4.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(88, 23).addBox(27.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_5 = segel_1_4.addOrReplaceChild("rope_5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.1491F, -1.1947F, -1.3336F));

		PartDefinition cube_r108 = rope_5.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(88, 23).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r109 = rope_5.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -35.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r110 = rope_5.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -23.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r111 = rope_5.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(88, 23).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r112 = rope_5.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(88, 23).addBox(27.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end = segel_1_4.addOrReplaceChild("sail_end", CubeListBuilder.create(), PartPose.offsetAndRotation(22.1F, -54.7898F, -1.4374F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r113 = sail_end.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(78, 16).addBox(-6.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 16).addBox(-19.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 16).addBox(-32.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 17).addBox(6.9F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(90, 23).addBox(19.9F, -3.25F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -2.2166F, 0.0F, 0.0F));

		PartDefinition sail_ropes = CogSail.addOrReplaceChild("sail_ropes", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_1 = sail_ropes.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r114 = rope_1.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(88, 23).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r115 = rope_1.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r116 = rope_1.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = sail_ropes.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r117 = rope_3.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(88, 23).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 23).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r118 = rope_3.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r119 = rope_3.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}



	@Override
	public void setupAnim(@NotNull Ship cog, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		switch (cog.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				this.CogSail.getChild("Sail_0").visible = true;
				this.CogSail.getChild("Sail_1").visible = false;
				this.CogSail.getChild("Sail_2").visible = false;
				this.CogSail.getChild("Sail_3").visible = false;
				this.CogSail.getChild("Sail_4").visible = false;
			}
			case 1 -> {
				this.CogSail.getChild("Sail_0").visible = false;
				this.CogSail.getChild("Sail_1").visible = true;
				this.CogSail.getChild("Sail_2").visible = false;
				this.CogSail.getChild("Sail_3").visible = false;
				this.CogSail.getChild("Sail_4").visible = false;
			}
			case 2 -> {
				this.CogSail.getChild("Sail_0").visible = false;
				this.CogSail.getChild("Sail_1").visible = false;
				this.CogSail.getChild("Sail_2").visible = true;
				this.CogSail.getChild("Sail_3").visible = false;
				this.CogSail.getChild("Sail_4").visible = false;
			}
			case 3 -> {
				this.CogSail.getChild("Sail_0").visible = false;
				this.CogSail.getChild("Sail_1").visible = false;
				this.CogSail.getChild("Sail_2").visible = false;
				this.CogSail.getChild("Sail_3").visible = true;
				this.CogSail.getChild("Sail_4").visible = false;
			}
			case 4 -> {
				this.CogSail.getChild("Sail_0").visible = false;
				this.CogSail.getChild("Sail_1").visible = false;
				this.CogSail.getChild("Sail_2").visible = false;
				this.CogSail.getChild("Sail_3").visible = false;
				this.CogSail.getChild("Sail_4").visible = true;
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		CogSail.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}