package com.talhanation.smallships.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.entities.AbstractSailShip;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ModelBriggSail extends ModelSail{
	//Does this happen in reality?
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "model_sailbrigg"), "main");
	private final ModelPart sail_brigg;

	public ModelBriggSail() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.sail_brigg = root.getChild("sail_brigg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sail_brigg = partdefinition.addOrReplaceChild("sail_brigg", CubeListBuilder.create(), PartPose.offset(0.0F, -98.5F, 20.5F));

		PartDefinition Sail_4 = sail_brigg.addOrReplaceChild("Sail_4", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_11 = Sail_4.addOrReplaceChild("rope_11", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.7031F, -0.2749F, -1.7985F));

		PartDefinition cube_r17 = rope_11.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(79, 2).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r18 = rope_11.addOrReplaceChild("cube_r18", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r19 = rope_11.addOrReplaceChild("cube_r19", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_10 = Sail_4.addOrReplaceChild("rope_10", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.6595F, -0.2749F, -1.7985F));

		PartDefinition cube_r14 = rope_10.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(79, 2).addBox(41.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r15 = rope_10.addOrReplaceChild("cube_r15", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r16 = rope_10.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_12 = Sail_4.addOrReplaceChild("rope_12", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -19.0F, -24.0F, 1.8829F, -1.1671F, -1.9075F));

		PartDefinition cube_r20 = rope_12.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r21 = rope_12.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r22 = rope_12.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6 = Sail_4.addOrReplaceChild("rope_6", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.0F, -19.0F, -11.0F, 1.1315F, -1.18F, -1.6497F));

		PartDefinition cube_r5 = rope_6.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r6 = rope_6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r7 = rope_6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_4 = Sail_4.addOrReplaceChild("rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -21.0F, 38.0F, 1.1062F, -0.9992F, -1.7985F));

		PartDefinition cube_r99 = rope_4.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(79, 2).addBox(59.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = rope_4.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(-10, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101 = rope_4.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(24, 21).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_9 = Sail_4.addOrReplaceChild("rope_9", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.5308F, 0.6108F, 1.6319F));

		PartDefinition cube_r11 = rope_9.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(79, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r12 = rope_9.addOrReplaceChild("cube_r12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r13 = rope_9.addOrReplaceChild("cube_r13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_8 = Sail_4.addOrReplaceChild("rope_8", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.5308F, 0.6108F, 1.5883F));

		PartDefinition cube_r8 = rope_8.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(79, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r9 = rope_8.addOrReplaceChild("cube_r9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r10 = rope_8.addOrReplaceChild("cube_r10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_5 = Sail_4.addOrReplaceChild("rope_5", CubeListBuilder.create(), PartPose.offsetAndRotation(21.5F, -19.0F, -12.5F, 1.0783F, 1.2103F, 1.6033F));

		PartDefinition cube_r2 = rope_5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(79, 2).addBox(43.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r3 = rope_5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-10, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = rope_5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 21).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = Sail_4.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.1345F, 0.925F, 1.7628F));

		PartDefinition cube_r96 = rope_3.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(79, 2).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97 = rope_3.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(-10, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98 = rope_3.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(24, 21).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_2 = Sail_4.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r1 = rope_2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(79, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r151 = rope_2.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(79, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r152 = rope_2.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(9, 25).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition sail_6 = Sail_4.addOrReplaceChild("sail_6", CubeListBuilder.create().texOffs(79, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -59.0F, -67.0F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r153 = sail_6.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(94, 7).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(85, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(70, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(84, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(84, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_5 = Sail_4.addOrReplaceChild("segel_5", CubeListBuilder.create().texOffs(79, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(83, 2).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(86, 2).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(86, 5).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(88, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(98, 4).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(84, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 7).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -73.7376F, 28.1006F));

		PartDefinition rope_7 = segel_5.addOrReplaceChild("rope_7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r154 = rope_7.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(79, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition segel_4 = Sail_4.addOrReplaceChild("segel_4", CubeListBuilder.create(), PartPose.offset(29.5F, -79.669F, 20.9006F));

		PartDefinition cube_r155 = segel_4.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(79, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1747F, -2.9013F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r156 = segel_4.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(85, 6).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r157 = segel_4.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(79, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9249F, -6.7434F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r158 = segel_4.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(79, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9576F, -8.2717F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r159 = segel_4.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(79, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.9877F, -8.8184F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r160 = segel_4.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(79, 6).addBox(-49.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-66.0F, -1.25F, -2.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-60.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-38.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-27.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 6).addBox(-16.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.9045F, -8.4668F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r161 = segel_4.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(79, 8).addBox(-49.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-66.0F, 0.75F, -1.7112F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-60.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-38.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-27.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-16.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.1896F, -8.8894F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r162 = segel_4.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(79, 5).addBox(-16.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-66.0F, -1.0F, -3.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-61.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-50.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-39.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 7).addBox(-28.0F, -1.0F, -3.5F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-5.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.3623F, -6.0111F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r163 = segel_4.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(89, 2).addBox(-66.0F, -0.4519F, -2.0478F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-60.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-49.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-38.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-27.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-16.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -0.4519F, -2.0478F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 34.9409F, -3.1328F, 2.2227F, 0.0F, 0.0F));

		PartDefinition cube_r164 = segel_4.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(82, 29).addBox(-5.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-66.0F, -2.3929F, -3.0737F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-60.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-49.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-38.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-27.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-16.0F, -2.3929F, -3.0737F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 36.5319F, 0.9331F, 2.3562F, 0.0F, 0.0F));

		PartDefinition segel_3 = Sail_4.addOrReplaceChild("segel_3", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r165 = segel_3.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(79, 2).addBox(-5.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(68, 30).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-66.0F, -39.0F, 16.6905F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -50.3067F, 14.8895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r166 = segel_3.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(79, 7).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(84, 6).addBox(-66.0F, -40.25F, 11.2888F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -52.4794F, 12.0112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r167 = segel_3.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(79, 5).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-66.0F, -43.5F, 4.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-5.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -58.7644F, 12.4338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r168 = segel_3.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(86, 5).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -63.6813F, 12.0822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r169 = segel_3.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(91, 2).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -68.7113F, 12.6289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r170 = segel_3.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(86, 28).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -71.7441F, 14.1572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r171 = segel_3.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(84, 28).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r172 = segel_3.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(91, 2).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -76.4943F, 17.9993F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r173 = segel_3.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(79, 4).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 28).addBox(-5.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-66.0F, -34.7019F, 23.9822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -44.7281F, 17.7678F, 2.2227F, 0.0F, 0.0F));

		PartDefinition cube_r174 = segel_3.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(79, 6).addBox(-60.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-49.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-38.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-27.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(-16.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-5.0F, -32.8929F, 27.4263F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-66.0F, -32.8929F, 27.4263F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -43.1371F, 21.8337F, 2.3562F, 0.0F, 0.0F));

		PartDefinition segel_2 = Sail_4.addOrReplaceChild("segel_2", CubeListBuilder.create(), PartPose.offset(0.0F, -114.0F, 25.0F));

		PartDefinition cube_r175 = segel_2.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(67, 24).addBox(-6.0F, -15.75F, -21.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(9.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(20.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(31.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-2.0F, -15.75F, -21.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 2.75F, -3.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r176 = segel_2.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(68, 30).addBox(20.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(9.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-6.0F, -11.0F, -20.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-2.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(31.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r177 = segel_2.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(82, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r178 = segel_2.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(93, 2).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r179 = segel_2.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(79, 5).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r180 = segel_2.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(79, 5).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(83, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r181 = segel_2.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(79, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 4).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_1 = Sail_4.addOrReplaceChild("segel_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -112.0F, -18.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r182 = segel_1.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(81, 8).addBox(-2.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(84, 28).addBox(9.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(81, 8).addBox(20.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(31.0F, -49.5F, 6.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(81, 8).addBox(-6.0F, -49.5F, 6.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 0.75F, 39.5F, 2.2689F, 0.0F, 0.0F));

		PartDefinition cube_r183 = segel_1.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(91, 7).addBox(-6.0F, -50.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(-2.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(9.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(20.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(31.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r184 = segel_1.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(90, 6).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.9199F, 0.0F, 0.0F));

		PartDefinition cube_r185 = segel_1.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(79, 5).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(87, 28).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 6).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r186 = segel_1.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(66, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 6).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(86, 7).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r187 = segel_1.addOrReplaceChild("cube_r187", CubeListBuilder.create().texOffs(91, 2).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r188 = segel_1.addOrReplaceChild("cube_r188", CubeListBuilder.create().texOffs(85, 8).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(79, 5).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rope_13 = Sail_4.addOrReplaceChild("rope_13", CubeListBuilder.create(), PartPose.offset(0.0F, -122.5F, 20.5F));

		PartDefinition cube_r189 = rope_13.addOrReplaceChild("cube_r189", CubeListBuilder.create().texOffs(81, 16).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(81, 16).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(76, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Sail_3 = sail_brigg.addOrReplaceChild("Sail_3", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_14 = Sail_3.addOrReplaceChild("rope_14", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.6226F, -0.3589F, -1.9596F));

		PartDefinition cube_r23 = rope_14.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r24 = rope_14.addOrReplaceChild("cube_r24", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r25 = rope_14.addOrReplaceChild("cube_r25", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_15 = Sail_3.addOrReplaceChild("rope_15", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.6407F, -0.3095F, -1.8826F));

		PartDefinition cube_r26 = rope_15.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = rope_15.addOrReplaceChild("cube_r27", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r28 = rope_15.addOrReplaceChild("cube_r28", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_16 = Sail_3.addOrReplaceChild("rope_16", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -19.0F, -24.0F, 1.8829F, -1.1671F, -1.9075F));

		PartDefinition cube_r29 = rope_16.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = rope_16.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r31 = rope_16.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_17 = Sail_3.addOrReplaceChild("rope_17", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -20.0F, -12.0F, 1.2787F, -1.0972F, -1.7157F));

		PartDefinition cube_r32 = rope_17.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(91, 2).addBox(66.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 37.6555F, -8.0034F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r33 = rope_17.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(2, 21).addBox(8.8796F, 20.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 3.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = rope_17.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(7, 29).addBox(12.1296F, 23.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 15.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_18 = Sail_3.addOrReplaceChild("rope_18", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -21.0F, 38.0F, 1.2166F, -0.9585F, -1.8265F));

		PartDefinition cube_r35 = rope_18.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(91, 2).addBox(67.9409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(58.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r36 = rope_18.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(2, 21).addBox(9.8796F, 21.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r37 = rope_18.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(7, 29).addBox(13.1296F, 24.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_19 = Sail_3.addOrReplaceChild("rope_19", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.4352F, 0.6911F, 1.762F));

		PartDefinition cube_r38 = rope_19.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r39 = rope_19.addOrReplaceChild("cube_r39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r40 = rope_19.addOrReplaceChild("cube_r40", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_20 = Sail_3.addOrReplaceChild("rope_20", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.4854F, 0.6605F, 1.664F));

		PartDefinition cube_r41 = rope_20.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r42 = rope_20.addOrReplaceChild("cube_r42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r43 = rope_20.addOrReplaceChild("cube_r43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_21 = Sail_3.addOrReplaceChild("rope_21", CubeListBuilder.create(), PartPose.offsetAndRotation(21.5F, -19.0F, -12.5F, 1.2397F, 1.1288F, 1.6837F));

		PartDefinition cube_r44 = rope_21.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(91, 2).addBox(51.9F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(21.9F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r45 = rope_21.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(2, 21).addBox(4.25F, 4.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r46 = rope_21.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(7, 29).addBox(7.5F, 7.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_22 = Sail_3.addOrReplaceChild("rope_22", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.2218F, 0.925F, 1.7628F));

		PartDefinition cube_r47 = rope_22.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(91, 2).addBox(51.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = rope_22.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(2, 21).addBox(4.25F, 4.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = rope_22.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 29).addBox(7.5F, 7.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_23 = Sail_3.addOrReplaceChild("rope_23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r190 = rope_23.addOrReplaceChild("cube_r190", CubeListBuilder.create().texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r191 = rope_23.addOrReplaceChild("cube_r191", CubeListBuilder.create().texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r192 = rope_23.addOrReplaceChild("cube_r192", CubeListBuilder.create().texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_7 = Sail_3.addOrReplaceChild("segel_7", CubeListBuilder.create().texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -59.0F, -67.0F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r193 = segel_7.addOrReplaceChild("cube_r193", CubeListBuilder.create().texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_8 = Sail_3.addOrReplaceChild("segel_8", CubeListBuilder.create().texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -73.7376F, 28.1006F));

		PartDefinition rope_24 = segel_8.addOrReplaceChild("rope_24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r194 = rope_24.addOrReplaceChild("cube_r194", CubeListBuilder.create().texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition segel_9 = Sail_3.addOrReplaceChild("segel_9", CubeListBuilder.create(), PartPose.offset(29.5F, -79.669F, 20.9006F));

		PartDefinition cube_r195 = segel_9.addOrReplaceChild("cube_r195", CubeListBuilder.create().texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1747F, -2.9013F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r196 = segel_9.addOrReplaceChild("cube_r196", CubeListBuilder.create().texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r197 = segel_9.addOrReplaceChild("cube_r197", CubeListBuilder.create().texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9249F, -6.7434F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r198 = segel_9.addOrReplaceChild("cube_r198", CubeListBuilder.create().texOffs(91, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9576F, -8.2717F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r199 = segel_9.addOrReplaceChild("cube_r199", CubeListBuilder.create().texOffs(91, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.9877F, -8.8184F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r200 = segel_9.addOrReplaceChild("cube_r200", CubeListBuilder.create().texOffs(73, 36).addBox(-49.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 6).addBox(-66.0F, -1.25F, -2.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-38.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 36).addBox(-16.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -1.25F, -2.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.9045F, -8.4668F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r201 = segel_9.addOrReplaceChild("cube_r201", CubeListBuilder.create().texOffs(91, 8).addBox(-49.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 6).addBox(-66.0F, 0.75F, -1.7112F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-27.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-16.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, 0.75F, -1.7112F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.1896F, -8.8894F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r202 = segel_9.addOrReplaceChild("cube_r202", CubeListBuilder.create().texOffs(80, 35).addBox(-16.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-66.0F, -1.0F, -3.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-61.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-50.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-39.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 7).addBox(-28.0F, -1.0F, -3.5F, 12.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-5.0F, -1.0F, -3.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.3623F, -6.0111F, 2.0595F, 0.0F, 0.0F));

		PartDefinition segel_10 = Sail_3.addOrReplaceChild("segel_10", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r203 = segel_10.addOrReplaceChild("cube_r203", CubeListBuilder.create().texOffs(91, 2).addBox(-5.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 30).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 16).addBox(-66.0F, -39.0F, 16.6905F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -50.3067F, 14.8895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r204 = segel_10.addOrReplaceChild("cube_r204", CubeListBuilder.create().texOffs(91, 7).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 20).addBox(-66.0F, -40.25F, 11.2888F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -52.4794F, 12.0112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r205 = segel_10.addOrReplaceChild("cube_r205", CubeListBuilder.create().texOffs(80, 35).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 16).addBox(-66.0F, -43.5F, 4.75F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -58.7644F, 12.4338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r206 = segel_10.addOrReplaceChild("cube_r206", CubeListBuilder.create().texOffs(72, 19).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -63.6813F, 12.0822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r207 = segel_10.addOrReplaceChild("cube_r207", CubeListBuilder.create().texOffs(77, 16).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -68.7113F, 12.6289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r208 = segel_10.addOrReplaceChild("cube_r208", CubeListBuilder.create().texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -71.7441F, 14.1572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r209 = segel_10.addOrReplaceChild("cube_r209", CubeListBuilder.create().texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r210 = segel_10.addOrReplaceChild("cube_r210", CubeListBuilder.create().texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -76.4943F, 17.9993F, 0.829F, 0.0F, 0.0F));

		PartDefinition segel_11 = Sail_3.addOrReplaceChild("segel_11", CubeListBuilder.create(), PartPose.offset(0.0F, -114.0F, 25.0F));

		PartDefinition cube_r211 = segel_11.addOrReplaceChild("cube_r211", CubeListBuilder.create().texOffs(80, 30).addBox(20.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-6.0F, -11.0F, -20.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-2.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -11.0F, -20.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r212 = segel_11.addOrReplaceChild("cube_r212", CubeListBuilder.create().texOffs(94, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r213 = segel_11.addOrReplaceChild("cube_r213", CubeListBuilder.create().texOffs(79, 16).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r214 = segel_11.addOrReplaceChild("cube_r214", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r215 = segel_11.addOrReplaceChild("cube_r215", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r216 = segel_11.addOrReplaceChild("cube_r216", CubeListBuilder.create().texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_12 = Sail_3.addOrReplaceChild("segel_12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -112.0F, -18.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r217 = segel_12.addOrReplaceChild("cube_r217", CubeListBuilder.create().texOffs(77, 21).addBox(-6.0F, -50.0F, -4.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(9.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(20.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -50.0F, -4.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r218 = segel_12.addOrReplaceChild("cube_r218", CubeListBuilder.create().texOffs(76, 20).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.9199F, 0.0F, 0.0F));

		PartDefinition cube_r219 = segel_12.addOrReplaceChild("cube_r219", CubeListBuilder.create().texOffs(80, 35).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 23).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r220 = segel_12.addOrReplaceChild("cube_r220", CubeListBuilder.create().texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r221 = segel_12.addOrReplaceChild("cube_r221", CubeListBuilder.create().texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r222 = segel_12.addOrReplaceChild("cube_r222", CubeListBuilder.create().texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rope_25 = Sail_3.addOrReplaceChild("rope_25", CubeListBuilder.create(), PartPose.offset(0.0F, -122.5F, 20.5F));

		PartDefinition cube_r223 = rope_25.addOrReplaceChild("cube_r223", CubeListBuilder.create().texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r80 = Sail_3.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(91, 3).addBox(-64.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(88, 28).addBox(-93.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(73, 41).addBox(-51.0F, -41.6933F, 18.2105F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(85, 4).addBox(-33.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -48.8067F, 18.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r50 = Sail_3.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(91, 3).addBox(-64.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(88, 28).addBox(-93.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(73, 41).addBox(-51.0F, -41.6933F, 18.2105F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(85, 4).addBox(-33.0F, -41.6933F, 18.2105F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -48.8067F, 61.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition Sail_2 = sail_brigg.addOrReplaceChild("Sail_2", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_26 = Sail_2.addOrReplaceChild("rope_26", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.5789F, -0.577F, -1.9596F));

		PartDefinition cube_r51 = rope_26.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(91, 2).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r52 = rope_26.addOrReplaceChild("cube_r52", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r53 = rope_26.addOrReplaceChild("cube_r53", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_27 = Sail_2.addOrReplaceChild("rope_27", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.5534F, -0.7022F, -1.8826F));

		PartDefinition cube_r54 = rope_27.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r55 = rope_27.addOrReplaceChild("cube_r55", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r56 = rope_27.addOrReplaceChild("cube_r56", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_28 = Sail_2.addOrReplaceChild("rope_28", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -19.0F, -24.0F, 1.8829F, -1.1671F, -1.9075F));

		PartDefinition cube_r57 = rope_28.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r58 = rope_28.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r59 = rope_28.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_29 = Sail_2.addOrReplaceChild("rope_29", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -20.0F, -12.0F, 1.3374F, -1.1564F, -1.6807F));

		PartDefinition cube_r60 = rope_29.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(91, 2).addBox(74.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(65.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(57.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(57.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 37.6555F, -8.0034F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r61 = rope_29.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(2, 21).addBox(14.8796F, 26.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 3.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r62 = rope_29.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(7, 29).addBox(18.1296F, 29.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 15.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_30 = Sail_2.addOrReplaceChild("rope_30", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -21.0F, 38.0F, 1.3963F, -1.0283F, -1.8265F));

		PartDefinition cube_r63 = rope_30.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(91, 2).addBox(75.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(66.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(58.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(58.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r64 = rope_30.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(2, 21).addBox(15.8796F, 27.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r65 = rope_30.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(7, 29).addBox(19.1296F, 30.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_31 = Sail_2.addOrReplaceChild("rope_31", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.3916F, 0.822F, 1.762F));

		PartDefinition cube_r66 = rope_31.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(91, 2).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r67 = rope_31.addOrReplaceChild("cube_r67", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r68 = rope_31.addOrReplaceChild("cube_r68", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_32 = Sail_2.addOrReplaceChild("rope_32", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.3545F, 0.966F, 1.664F));

		PartDefinition cube_r69 = rope_32.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r70 = rope_32.addOrReplaceChild("cube_r70", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r71 = rope_32.addOrReplaceChild("cube_r71", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_33 = Sail_2.addOrReplaceChild("rope_33", CubeListBuilder.create(), PartPose.offsetAndRotation(21.5F, -19.0F, -12.5F, 1.3502F, 1.1715F, 1.6614F));

		PartDefinition cube_r72 = rope_33.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(91, 2).addBox(59.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(21.9F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r73 = rope_33.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(2, 21).addBox(10.25F, 10.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r74 = rope_33.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(7, 29).addBox(13.5F, 13.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_34 = Sail_2.addOrReplaceChild("rope_34", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3527F, 0.9948F, 1.7628F));

		PartDefinition cube_r75 = rope_34.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(91, 2).addBox(60.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(51.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(43.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(43.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(33.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r76 = rope_34.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(2, 21).addBox(10.25F, 10.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r77 = rope_34.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(7, 29).addBox(13.5F, 13.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_35 = Sail_2.addOrReplaceChild("rope_35", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r224 = rope_35.addOrReplaceChild("cube_r224", CubeListBuilder.create().texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r225 = rope_35.addOrReplaceChild("cube_r225", CubeListBuilder.create().texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r226 = rope_35.addOrReplaceChild("cube_r226", CubeListBuilder.create().texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_13 = Sail_2.addOrReplaceChild("segel_13", CubeListBuilder.create().texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -59.0F, -67.0F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r227 = segel_13.addOrReplaceChild("cube_r227", CubeListBuilder.create().texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_14 = Sail_2.addOrReplaceChild("segel_14", CubeListBuilder.create().texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -73.7376F, 28.1006F));

		PartDefinition rope_36 = segel_14.addOrReplaceChild("rope_36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r228 = rope_36.addOrReplaceChild("cube_r228", CubeListBuilder.create().texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition segel_15 = Sail_2.addOrReplaceChild("segel_15", CubeListBuilder.create(), PartPose.offset(29.5F, -79.669F, 20.9006F));

		PartDefinition cube_r229 = segel_15.addOrReplaceChild("cube_r229", CubeListBuilder.create().texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1747F, -2.9013F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r230 = segel_15.addOrReplaceChild("cube_r230", CubeListBuilder.create().texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r231 = segel_15.addOrReplaceChild("cube_r231", CubeListBuilder.create().texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9249F, -6.7434F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r232 = segel_15.addOrReplaceChild("cube_r232", CubeListBuilder.create().texOffs(91, 7).addBox(-66.0F, -0.4187F, -3.4689F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-49.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-38.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-27.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-16.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -0.4187F, -3.4689F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.9576F, -8.2717F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r233 = segel_15.addOrReplaceChild("cube_r233", CubeListBuilder.create().texOffs(91, 8).addBox(-16.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-66.0F, -1.0887F, -3.1322F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-60.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-49.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-38.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -1.0887F, -3.1322F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.9877F, -8.8184F, 1.5272F, 0.0F, 0.0F));

		PartDefinition segel_16 = Sail_2.addOrReplaceChild("segel_16", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r234 = segel_16.addOrReplaceChild("cube_r234", CubeListBuilder.create().texOffs(72, 19).addBox(-66.0F, -44.0887F, -4.8822F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-5.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -63.6813F, 12.0822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r235 = segel_16.addOrReplaceChild("cube_r235", CubeListBuilder.create().texOffs(77, 16).addBox(-66.0F, -40.9587F, -18.0289F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-5.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -68.7113F, 12.6289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r236 = segel_16.addOrReplaceChild("cube_r236", CubeListBuilder.create().texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -71.7441F, 14.1572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r237 = segel_16.addOrReplaceChild("cube_r237", CubeListBuilder.create().texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r238 = segel_16.addOrReplaceChild("cube_r238", CubeListBuilder.create().texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -76.4943F, 17.9993F, 0.829F, 0.0F, 0.0F));

		PartDefinition segel_17 = Sail_2.addOrReplaceChild("segel_17", CubeListBuilder.create(), PartPose.offset(0.0F, -114.0F, 25.0F));

		PartDefinition cube_r239 = segel_17.addOrReplaceChild("cube_r239", CubeListBuilder.create().texOffs(80, 30).addBox(20.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(73, 34).addBox(9.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-7.0F, -12.0F, -17.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(73, 34).addBox(-2.0F, -12.0F, -17.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -12.0F, -17.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r240 = segel_17.addOrReplaceChild("cube_r240", CubeListBuilder.create().texOffs(94, 29).addBox(31.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(20.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(9.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-6.0F, -9.75F, -16.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -9.75F, -16.0F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r241 = segel_17.addOrReplaceChild("cube_r241", CubeListBuilder.create().texOffs(79, 16).addBox(-6.0F, -6.5F, -13.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(20.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-2.0F, -6.5F, -13.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r242 = segel_17.addOrReplaceChild("cube_r242", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r243 = segel_17.addOrReplaceChild("cube_r243", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r244 = segel_17.addOrReplaceChild("cube_r244", CubeListBuilder.create().texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_18 = Sail_2.addOrReplaceChild("segel_18", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -112.0F, -18.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r245 = segel_18.addOrReplaceChild("cube_r245", CubeListBuilder.create().texOffs(85, 37).addBox(-7.0F, -50.5F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(73, 37).addBox(-2.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(73, 35).addBox(9.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(20.0F, -50.5F, 0.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -50.5F, 0.0F, 12.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r246 = segel_18.addOrReplaceChild("cube_r246", CubeListBuilder.create().texOffs(76, 20).addBox(-6.0F, -50.0F, -3.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-2.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(9.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 3).addBox(31.0F, -50.0F, -3.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.9199F, 0.0F, 0.0F));

		PartDefinition cube_r247 = segel_18.addOrReplaceChild("cube_r247", CubeListBuilder.create().texOffs(80, 35).addBox(20.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(70, 23).addBox(-6.0F, -48.75F, -11.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-2.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(9.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(31.0F, -48.75F, -11.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.6581F, 0.0F, 0.0F));

		PartDefinition cube_r248 = segel_18.addOrReplaceChild("cube_r248", CubeListBuilder.create().texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r249 = segel_18.addOrReplaceChild("cube_r249", CubeListBuilder.create().texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r250 = segel_18.addOrReplaceChild("cube_r250", CubeListBuilder.create().texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rope_37 = Sail_2.addOrReplaceChild("rope_37", CubeListBuilder.create(), PartPose.offset(0.0F, -122.5F, 20.5F));

		PartDefinition cube_r251 = rope_37.addOrReplaceChild("cube_r251", CubeListBuilder.create().texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r78 = Sail_2.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(80, 33).addBox(-64.0F, -40.6933F, 21.2105F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -40.6933F, 21.2105F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(67, 39).addBox(-93.0F, -40.6933F, 21.2105F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 30).addBox(-51.0F, -40.6933F, 21.2105F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(74, 34).addBox(-33.0F, -40.6933F, 21.2105F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -56.8067F, 15.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r79 = Sail_2.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(80, 33).addBox(-64.0F, -40.6933F, 30.2105F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -40.6933F, 30.2105F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(67, 39).addBox(-93.0F, -40.6933F, 30.2105F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(80, 30).addBox(-51.0F, -40.6933F, 30.2105F, 18.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(74, 34).addBox(-33.0F, -40.6933F, 30.2105F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -48.8067F, 61.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition Sail_1 = sail_brigg.addOrReplaceChild("Sail_1", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_38 = Sail_1.addOrReplaceChild("rope_38", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.4917F, -1.1006F, -1.9596F));

		PartDefinition cube_r81 = rope_38.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(91, 2).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r82 = rope_38.addOrReplaceChild("cube_r82", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r83 = rope_38.addOrReplaceChild("cube_r83", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_39 = Sail_1.addOrReplaceChild("rope_39", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.5098F, -0.964F, -1.8826F));

		PartDefinition cube_r84 = rope_39.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(91, 2).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(55.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r85 = rope_39.addOrReplaceChild("cube_r85", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r86 = rope_39.addOrReplaceChild("cube_r86", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_40 = Sail_1.addOrReplaceChild("rope_40", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -19.0F, -24.0F, 1.8829F, -1.1671F, -1.9075F));

		PartDefinition cube_r87 = rope_40.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(91, 2).addBox(59.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(67.4409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(37.4409F, 7.4794F, 7.8814F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r88 = rope_40.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(2, 21).addBox(3.8796F, 15.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r89 = rope_40.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(7, 29).addBox(7.1296F, 18.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_41 = Sail_1.addOrReplaceChild("rope_41", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -20.0F, -12.0F, 1.381F, -1.2436F, -1.6807F));

		PartDefinition cube_r90 = rope_41.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(91, 2).addBox(82.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(73.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(65.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(65.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(36.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 37.6555F, -8.0034F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r91 = rope_41.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(2, 21).addBox(20.8796F, 32.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 3.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r92 = rope_41.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(7, 29).addBox(24.1296F, 35.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 15.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_42 = Sail_1.addOrReplaceChild("rope_42", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -21.0F, 38.0F, 1.4399F, -1.1592F, -1.8265F));

		PartDefinition cube_r93 = rope_42.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(91, 2).addBox(84.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(75.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(67.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(67.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(59.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r94 = rope_42.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(2, 21).addBox(21.8796F, 33.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r95 = rope_42.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(7, 29).addBox(25.1296F, 36.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_43 = Sail_1.addOrReplaceChild("rope_43", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.2607F, 1.1274F, 1.762F));

		PartDefinition cube_r102 = rope_43.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(91, 2).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(40.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r103 = rope_43.addOrReplaceChild("cube_r103", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r104 = rope_43.addOrReplaceChild("cube_r104", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_44 = Sail_1.addOrReplaceChild("rope_44", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.18F, 1.0532F, 1.664F));

		PartDefinition cube_r105 = rope_44.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(91, 2).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(38.5F, 0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r106 = rope_44.addOrReplaceChild("cube_r106", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r107 = rope_44.addOrReplaceChild("cube_r107", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_45 = Sail_1.addOrReplaceChild("rope_45", CubeListBuilder.create(), PartPose.offsetAndRotation(21.5F, -19.0F, -12.5F, 1.3938F, 1.2588F, 1.6614F));

		PartDefinition cube_r108 = rope_45.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(91, 2).addBox(68.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(59.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(51.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(51.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.9F, -0.5F, -17.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r109 = rope_45.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(2, 21).addBox(16.25F, 16.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r110 = rope_45.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(7, 29).addBox(19.5F, 19.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_46 = Sail_1.addOrReplaceChild("rope_46", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3963F, 1.1257F, 1.7628F));

		PartDefinition cube_r111 = rope_46.addOrReplaceChild("cube_r111", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r112 = rope_46.addOrReplaceChild("cube_r112", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r113 = rope_46.addOrReplaceChild("cube_r113", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_47 = Sail_1.addOrReplaceChild("rope_47", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r252 = rope_47.addOrReplaceChild("cube_r252", CubeListBuilder.create().texOffs(91, 2).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r253 = rope_47.addOrReplaceChild("cube_r253", CubeListBuilder.create().texOffs(91, 2).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r254 = rope_47.addOrReplaceChild("cube_r254", CubeListBuilder.create().texOffs(7, 29).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_19 = Sail_1.addOrReplaceChild("segel_19", CubeListBuilder.create().texOffs(91, 2).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -59.0F, -67.0F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r255 = segel_19.addOrReplaceChild("cube_r255", CubeListBuilder.create().texOffs(77, 2).addBox(-0.5F, 16.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -7.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -15.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -23.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 32.0F, -31.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 32.0F, -32.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 33.0F, -33.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 34.0F, -34.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 35.0F, -35.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 36.0F, -36.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 37.0F, -37.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 38.0F, -38.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 24.0F, -24.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 27.0F, -27.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 26.0F, -26.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 25.0F, -25.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 7).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 21).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(97, 6).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(82, 2).addBox(-0.5F, 17.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_20 = Sail_1.addOrReplaceChild("segel_20", CubeListBuilder.create().texOffs(91, 2).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(69, 16).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(72, 16).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 17.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 5.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(72, 19).addBox(-0.5F, 22.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 12.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(100, 3).addBox(-0.5F, 8.0686F, 35.8F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(77, 18).addBox(-0.5F, 1.0686F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(84, 18).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -0.9314F, 26.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 8.8F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 12.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 8.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 26.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 19.0686F, 17.8F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(96, 2).addBox(-0.5F, 19.0686F, 35.8F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 17.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 26.8F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-0.5F, 26.0686F, 30.8F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 2).addBox(-0.5F, 26.0686F, -0.2F, 1.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -73.7376F, 28.1006F));

		PartDefinition rope_48 = segel_20.addOrReplaceChild("rope_48", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r256 = rope_48.addOrReplaceChild("cube_r256", CubeListBuilder.create().texOffs(91, 2).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition segel_21 = Sail_1.addOrReplaceChild("segel_21", CubeListBuilder.create(), PartPose.offset(29.5F, -79.669F, 20.9006F));

		PartDefinition cube_r257 = segel_21.addOrReplaceChild("cube_r257", CubeListBuilder.create().texOffs(91, 8).addBox(-38.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-27.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-16.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-49.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 6).addBox(-66.0F, -1.0057F, -3.1993F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-60.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -1.0057F, -3.1993F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1747F, -2.9013F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r258 = segel_21.addOrReplaceChild("cube_r258", CubeListBuilder.create().texOffs(71, 20).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r259 = segel_21.addOrReplaceChild("cube_r259", CubeListBuilder.create().texOffs(91, 2).addBox(-66.0F, -0.5359F, -1.8872F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-49.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-27.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(-16.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-5.0F, -0.5359F, -1.8872F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.9249F, -6.7434F, 1.0908F, 0.0F, 0.0F));

		PartDefinition segel_22 = Sail_1.addOrReplaceChild("segel_22", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r260 = segel_22.addOrReplaceChild("cube_r260", CubeListBuilder.create().texOffs(69, 23).addBox(-66.0F, -38.7859F, -21.6372F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -71.7441F, 14.1572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r261 = segel_22.addOrReplaceChild("cube_r261", CubeListBuilder.create().texOffs(67, 23).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r262 = segel_22.addOrReplaceChild("cube_r262", CubeListBuilder.create().texOffs(77, 16).addBox(-66.0F, -32.7857F, -32.1293F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 28).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(94, 29).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 36).addBox(-5.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -76.4943F, 17.9993F, 0.829F, 0.0F, 0.0F));

		PartDefinition segel_23 = Sail_1.addOrReplaceChild("segel_23", CubeListBuilder.create(), PartPose.offset(0.0F, -114.0F, 25.0F));

		PartDefinition cube_r263 = segel_23.addOrReplaceChild("cube_r263", CubeListBuilder.create().texOffs(80, 30).addBox(20.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-7.0F, -10.0F, -10.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-2.0F, -10.0F, -10.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 8).addBox(31.0F, -10.0F, -10.0F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r264 = segel_23.addOrReplaceChild("cube_r264", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 4).addBox(-6.0F, -5.0F, -9.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(-2.0F, -5.0F, -9.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r265 = segel_23.addOrReplaceChild("cube_r265", CubeListBuilder.create().texOffs(80, 35).addBox(31.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(20.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(9.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(95, 5).addBox(-6.0F, -3.25F, -5.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -3.25F, -5.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r266 = segel_23.addOrReplaceChild("cube_r266", CubeListBuilder.create().texOffs(91, 7).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_24 = Sail_1.addOrReplaceChild("segel_24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -112.0F, -18.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r267 = segel_24.addOrReplaceChild("cube_r267", CubeListBuilder.create().texOffs(77, 21).addBox(-7.0F, -50.5F, 5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(-2.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(9.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 8).addBox(20.0F, -50.5F, 5.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(77, 8).addBox(31.0F, -50.5F, 5.0F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 2.0071F, 0.0F, 0.0F));

		PartDefinition cube_r268 = segel_24.addOrReplaceChild("cube_r268", CubeListBuilder.create().texOffs(78, 30).addBox(-2.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(71, 36).addBox(9.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -46.75F, -15.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 21).addBox(-6.0F, -46.75F, -15.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r269 = segel_24.addOrReplaceChild("cube_r269", CubeListBuilder.create().texOffs(77, 16).addBox(-6.0F, -40.25F, -25.75F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(89, 5).addBox(-2.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(9.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 7).addBox(20.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 8).addBox(31.0F, -40.25F, -25.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r270 = segel_24.addOrReplaceChild("cube_r270", CubeListBuilder.create().texOffs(71, 22).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rope_49 = Sail_1.addOrReplaceChild("rope_49", CubeListBuilder.create(), PartPose.offset(0.0F, -122.5F, 20.5F));

		PartDefinition cube_r271 = rope_49.addOrReplaceChild("cube_r271", CubeListBuilder.create().texOffs(79, 27).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(79, 27).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(88, 16).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r114 = Sail_1.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(80, 33).addBox(-64.0F, -35.6933F, 29.2105F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -35.6933F, 29.2105F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 28).addBox(-93.0F, -35.6933F, 29.2105F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 30).addBox(-51.0F, -35.6933F, 29.2105F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 34).addBox(-33.0F, -35.6933F, 29.2105F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -56.8067F, 15.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r115 = Sail_1.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(80, 33).addBox(-64.0F, -34.6933F, 37.2105F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-77.0F, -34.6933F, 37.2105F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 28).addBox(-93.0F, -34.6933F, 37.2105F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(80, 30).addBox(-51.0F, -34.6933F, 37.2105F, 18.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(74, 34).addBox(-33.0F, -34.6933F, 37.2105F, 16.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -48.8067F, 61.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition rope_62 = Sail_1.addOrReplaceChild("rope_62", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3963F, 1.1257F, 1.7628F));

		PartDefinition cube_r145 = rope_62.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(91, 2).addBox(68.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(59.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(51.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(51.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(33.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(91, 2).addBox(41.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r146 = rope_62.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(2, 21).addBox(16.25F, 16.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r147 = rope_62.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(7, 29).addBox(19.5F, 19.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition Sail_0 = sail_brigg.addOrReplaceChild("Sail_0", CubeListBuilder.create(), PartPose.offset(0.0F, 122.5F, -20.5F));

		PartDefinition rope_50 = Sail_0.addOrReplaceChild("rope_50", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, 22.6F, 2.4044F, -1.537F, -1.9596F));

		PartDefinition cube_r116 = rope_50.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(92, 32).addBox(47.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(59.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r117 = rope_50.addOrReplaceChild("cube_r117", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r118 = rope_50.addOrReplaceChild("cube_r118", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_51 = Sail_0.addOrReplaceChild("rope_51", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.0F, -81.7F, -19.4F, 2.3352F, -1.5312F, -1.8826F));

		PartDefinition cube_r119 = rope_51.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(92, 32).addBox(43.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(55.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r120 = rope_51.addOrReplaceChild("cube_r120", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r121 = rope_51.addOrReplaceChild("cube_r121", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_52 = Sail_0.addOrReplaceChild("rope_52", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -19.0F, -24.0F, 2.1931F, -1.2592F, -2.034F));

		PartDefinition cube_r122 = rope_52.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(92, 32).addBox(84.4409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(92.4409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(75.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(67.4409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(67.4409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(37.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(52.4409F, 7.4794F, 7.8814F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r123 = rope_52.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(20, 23).addBox(21.8796F, 33.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r124 = rope_52.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(22, 29).addBox(25.1296F, 36.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_53 = Sail_0.addOrReplaceChild("rope_53", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -20.0F, -12.0F, 1.381F, -1.4182F, -1.637F));

		PartDefinition cube_r125 = rope_53.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(92, 32).addBox(91.9409F, 7.4794F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(82.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(74.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(74.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(36.4409F, 7.4794F, 7.8814F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(48.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(57.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(66.4409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 37.6555F, -8.0034F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r126 = rope_53.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(20, 23).addBox(26.8796F, 38.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 3.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r127 = rope_53.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(22, 29).addBox(30.1296F, 41.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9251F, 15.6555F, -25.0034F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_54 = Sail_0.addOrReplaceChild("rope_54", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -21.0F, 38.0F, 1.4835F, -1.3075F, -1.8265F));

		PartDefinition cube_r128 = rope_54.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(92, 32).addBox(92.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(83.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(75.9409F, 8.7294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(75.9409F, 6.2294F, 7.8814F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(36.9409F, 7.4794F, 7.8814F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(57.9409F, 7.4794F, 7.8814F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(49.9409F, 7.4794F, 7.8814F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(67.9409F, 7.4794F, 7.8814F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 37.0F, -9.5F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r129 = rope_54.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(13, 27).addBox(27.8796F, 39.1642F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 3.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r130 = rope_54.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(21, 24).addBox(31.1296F, 42.4142F, 24.3814F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 15.0F, -26.5F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_55 = Sail_0.addOrReplaceChild("rope_55", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, 23.6F, 2.1298F, 1.5201F, 1.762F));

		PartDefinition cube_r131 = rope_55.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(92, 32).addBox(32.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(40.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(20.5F, 0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r132 = rope_55.addOrReplaceChild("cube_r132", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r133 = rope_55.addOrReplaceChild("cube_r133", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_56 = Sail_0.addOrReplaceChild("rope_56", CubeListBuilder.create(), PartPose.offsetAndRotation(34.5F, -82.5F, -18.8F, 2.0927F, 1.5332F, 1.664F));

		PartDefinition cube_r134 = rope_56.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(92, 32).addBox(28.5F, 0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(38.5F, 0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(20.5F, 0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r135 = rope_56.addOrReplaceChild("cube_r135", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r136 = rope_56.addOrReplaceChild("cube_r136", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_57 = Sail_0.addOrReplaceChild("rope_57", CubeListBuilder.create(), PartPose.offsetAndRotation(21.5F, -19.0F, -12.5F, 1.2719F, 1.4299F, 1.4923F));

		PartDefinition cube_r137 = rope_57.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(92, 32).addBox(77.9F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(68.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(60.9F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(60.9F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(20.9F, -0.5F, -17.5F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(33.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(42.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(51.9F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r138 = rope_57.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(11, 22).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r139 = rope_57.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(18, 27).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_58 = Sail_0.addOrReplaceChild("rope_58", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3963F, 1.1257F, 1.7628F));

		PartDefinition cube_r140 = rope_58.addOrReplaceChild("cube_r140", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r141 = rope_58.addOrReplaceChild("cube_r141", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r142 = rope_58.addOrReplaceChild("cube_r142", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_59 = Sail_0.addOrReplaceChild("rope_59", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -43.0F, -79.5F, -0.672F, 0.0F, 0.0F));

		PartDefinition cube_r272 = rope_59.addOrReplaceChild("cube_r272", CubeListBuilder.create().texOffs(92, 32).addBox(19.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(94.5F, -0.5F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(79.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(11.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r273 = rope_59.addOrReplaceChild("cube_r273", CubeListBuilder.create().texOffs(92, 32).addBox(105.5F, -0.5F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r274 = rope_59.addOrReplaceChild("cube_r274", CubeListBuilder.create().texOffs(21, 28).addBox(-4.5F, -4.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_25 = Sail_0.addOrReplaceChild("segel_25", CubeListBuilder.create().texOffs(92, 32).addBox(-0.7F, -44.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.7F, -29.0F, 0.0F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.7F, 0.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.7F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -59.0F, -67.0F, -0.8233F, -0.5571F, 0.5184F));

		PartDefinition cube_r275 = segel_25.addOrReplaceChild("cube_r275", CubeListBuilder.create().texOffs(92, 32).addBox(-2.3F, 8.9F, -16.0F, 3.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.3F, 8.9F, -24.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.3F, 8.9F, -32.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.3F, 8.9F, -40.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 1.309F, 0.0F, 0.0F));

		PartDefinition cube_r276 = segel_25.addOrReplaceChild("cube_r276", CubeListBuilder.create().texOffs(92, 32).addBox(-0.5F, 31.0F, -31.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 30.0F, -30.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 29.0F, -29.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(70, 32).addBox(-0.5F, 28.0F, -28.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 23.0F, -23.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 22.0F, -22.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 21.0F, -21.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(70, 32).addBox(-0.5F, 20.0F, -20.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 19.0F, -19.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(75, 32).addBox(-0.5F, 18.0F, -18.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 17.0F, -17.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 16.0F, -16.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 15.0F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 14.0F, -14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 13.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(70, 32).addBox(-0.5F, 12.0F, -12.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 11.0F, -11.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(75, 32).addBox(-0.5F, 10.0F, -10.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 9.0F, -9.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 7.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 6.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(70, 32).addBox(-0.5F, 4.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 3.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(75, 32).addBox(-0.5F, 2.0F, -2.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(69, 31).addBox(-0.5F, 1.0F, -1.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(78, 32).addBox(-0.5F, 8.0F, -8.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(68, 27).addBox(-0.5F, 9.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(68, 27).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -44.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition segel_26 = Sail_0.addOrReplaceChild("segel_26", CubeListBuilder.create().texOffs(92, 32).addBox(-0.5F, -3.9314F, 6.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(67, 27).addBox(-0.5F, -3.9314F, 15.8F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -3.9314F, 26.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -6.9314F, 12.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -6.9314F, 21.8F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(70, 27).addBox(-0.5F, -12.9314F, 25.8F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -17.9314F, 36.8F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -16.9314F, 34.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -15.9314F, 32.8F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -11.9314F, 23.8F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -7.9314F, 16.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -8.9314F, 18.8F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -4.9314F, 10.8F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -1.9314F, 3.8F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -14.9314F, 29.8F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -9.9314F, 19.8F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -0.9314F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, 2.0686F, -0.2F, 1.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -0.9314F, 8.8F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -5.9314F, 35.8F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(82, 29).addBox(-0.5F, -12.9314F, 35.8F, 1.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-0.5F, -9.9314F, 28.8F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -73.7376F, 28.1006F));

		PartDefinition cube_r277 = segel_26.addOrReplaceChild("cube_r277", CubeListBuilder.create().texOffs(68, 27).addBox(-2.5F, -4.5F, 15.75F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.5F, -4.5F, -2.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.5F, -4.5F, 6.75F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.5F, -4.5F, -11.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-2.5F, -4.5F, -20.25F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5686F, 21.05F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rope_60 = segel_26.addOrReplaceChild("rope_60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -48.7624F, -0.5006F, -2.2427F, 0.0F, 0.0F));

		PartDefinition cube_r278 = rope_60.addOrReplaceChild("cube_r278", CubeListBuilder.create().texOffs(92, 32).addBox(20.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(50.5F, -0.5F, -16.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(35.5F, -0.5F, -16.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(11.5F, -0.5F, -16.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition segel_27 = Sail_0.addOrReplaceChild("segel_27", CubeListBuilder.create(), PartPose.offset(29.5F, -79.669F, 20.9006F));

		PartDefinition cube_r279 = segel_27.addOrReplaceChild("cube_r279", CubeListBuilder.create().texOffs(69, 31).addBox(-66.0F, -0.75F, -2.4706F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 37).addBox(-60.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(-49.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(-38.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 40).addBox(-27.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 36).addBox(-16.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 40).addBox(-5.0F, -0.75F, -2.4706F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition segel_28 = Sail_0.addOrReplaceChild("segel_28", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r280 = segel_28.addOrReplaceChild("cube_r280", CubeListBuilder.create().texOffs(94, 39).addBox(-66.0F, -1.0F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 37).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 36).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 36).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(-5.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5F, -79.4356F, -21.9095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition segel_29 = Sail_0.addOrReplaceChild("segel_29", CubeListBuilder.create(), PartPose.offset(0.0F, -114.0F, 25.0F));

		PartDefinition cube_r281 = segel_29.addOrReplaceChild("cube_r281", CubeListBuilder.create().texOffs(74, 37).addBox(-2.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 34).addBox(-7.0F, -44.5F, 7.5F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(83, 34).addBox(9.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 41).addBox(20.0F, -44.5F, 7.5F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 38).addBox(31.0F, -44.5F, 7.5F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r282 = segel_29.addOrReplaceChild("cube_r282", CubeListBuilder.create().texOffs(78, 41).addBox(20.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 34).addBox(9.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 34).addBox(-7.0F, -3.3F, -3.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(92, 34).addBox(-2.0F, -3.3F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(78, 38).addBox(31.0F, -3.3F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r283 = segel_29.addOrReplaceChild("cube_r283", CubeListBuilder.create().texOffs(92, 37).addBox(31.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 37).addBox(20.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 34).addBox(9.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 37).addBox(-6.0F, -2.0F, -2.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 37).addBox(-2.0F, -2.0F, -2.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 3.0F, -3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition segel_30 = Sail_0.addOrReplaceChild("segel_30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -112.0F, -18.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r284 = segel_30.addOrReplaceChild("cube_r284", CubeListBuilder.create().texOffs(69, 33).addBox(-6.0F, -22.75F, -39.25F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(-2.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(9.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(20.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(92, 35).addBox(31.0F, -22.75F, -39.25F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5F, 1.0F, 39.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rope_61 = Sail_0.addOrReplaceChild("rope_61", CubeListBuilder.create(), PartPose.offset(0.0F, -122.5F, 20.5F));

		PartDefinition cube_r285 = rope_61.addOrReplaceChild("cube_r285", CubeListBuilder.create().texOffs(122, 11).addBox(-0.5F, 8.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(122, 11).addBox(-0.5F, -6.5F, 0.75F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(86, 27).addBox(-0.5F, 23.5F, 0.75F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r143 = Sail_0.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(72, 39).addBox(-64.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(80, 32).addBox(-77.0F, -25.6933F, 33.2105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 39).addBox(-93.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(69, 37).addBox(-51.0F, -25.6933F, 33.2105F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 45).addBox(-33.0F, -25.6933F, 33.2105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -56.8067F, 15.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r144 = Sail_0.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(72, 37).addBox(-64.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(72, 37).addBox(-77.0F, -24.6933F, 41.8105F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 38).addBox(-93.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(71, 37).addBox(-51.0F, -24.6933F, 41.8105F, 18.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 36).addBox(-33.0F, -24.6933F, 41.8105F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.5F, -48.8067F, 61.2895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition rope_63 = Sail_0.addOrReplaceChild("rope_63", CubeListBuilder.create(), PartPose.offsetAndRotation(17.5F, -21.0F, 38.5F, 1.3722F, 1.2975F, 1.69F));

		PartDefinition cube_r148 = rope_63.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(92, 32).addBox(77.5F, -0.5F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(68.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(60.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(60.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(21.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(42.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(33.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(92, 32).addBox(50.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r149 = rope_63.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(11, 22).addBox(22.25F, 22.25F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r150 = rope_63.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(16, 28).addBox(25.5F, 25.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(AbstractSailShip entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int state = entityIn.getSailState();
		switch (state) {
			case 0 -> {
				this.sail_brigg.getChild("Sail_0").visible = true;
				this.sail_brigg.getChild("Sail_1").visible = false;
				this.sail_brigg.getChild("Sail_2").visible = false;
				this.sail_brigg.getChild("Sail_3").visible = false;
				this.sail_brigg.getChild("Sail_4").visible = false;
			}
			case 1 -> {
				this.sail_brigg.getChild("Sail_0").visible = false;
				this.sail_brigg.getChild("Sail_1").visible = true;
				this.sail_brigg.getChild("Sail_2").visible = false;
				this.sail_brigg.getChild("Sail_3").visible = false;
				this.sail_brigg.getChild("Sail_4").visible = false;
			}
			case 2 -> {
				this.sail_brigg.getChild("Sail_0").visible = false;
				this.sail_brigg.getChild("Sail_1").visible = false;
				this.sail_brigg.getChild("Sail_2").visible = true;
				this.sail_brigg.getChild("Sail_3").visible = false;
				this.sail_brigg.getChild("Sail_4").visible = false;
			}
			case 3 -> {
				this.sail_brigg.getChild("Sail_0").visible = false;
				this.sail_brigg.getChild("Sail_1").visible = false;
				this.sail_brigg.getChild("Sail_2").visible = false;
				this.sail_brigg.getChild("Sail_3").visible = true;
				this.sail_brigg.getChild("Sail_4").visible = false;
			}
			case 4 -> {
				this.sail_brigg.getChild("Sail_0").visible = false;
				this.sail_brigg.getChild("Sail_1").visible = false;
				this.sail_brigg.getChild("Sail_2").visible = false;
				this.sail_brigg.getChild("Sail_3").visible = false;
				this.sail_brigg.getChild("Sail_4").visible = true;
			}
		}
	}
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		sail_brigg.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}
}