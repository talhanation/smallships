package com.talhanation.smallships.client.model;

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractCannonShip;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ModelCannon extends EntityModel<AbstractCannonShip> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "model_cannon"), "main");
	private final ModelPart cannon;

	public ModelCannon() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.cannon = root.getChild("cannon");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cannon = partdefinition.addOrReplaceChild("cannon", CubeListBuilder.create().texOffs(80, 29).addBox(1.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(80, 29).addBox(-6.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(80, 29).addBox(-3.5F, -6.0F, 2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(80, 29).addBox(-3.5F, -6.0F, -4.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(75, 15).addBox(5.1F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(75, 15).addBox(5.1F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(75, 15).addBox(-8.0F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(75, 15).addBox(-7.9F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 24.75F, 0.0F));

		PartDefinition achse2_r1 = cannon.addOrReplaceChild("achse2_r1", CubeListBuilder.create().texOffs(87, 58).addBox(-8.0F, -7.5F, -7.7F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(87, 58).addBox(-8.0F, -0.4F, -0.6F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.4F, 5.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r1 = cannon.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(80, 29).addBox(12.0F, -1.8F, -7.1F, 2.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(80, 29).addBox(4.0F, -1.85F, -7.1F, 2.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -6.0173F, 0.8198F, -0.2618F, 0.0F, 0.0F));

		PartDefinition lauf = cannon.addOrReplaceChild("lauf", CubeListBuilder.create().texOffs(89, 3).addBox(-2.0F, 1.9833F, -4.25F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, -3.0167F, -4.25F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-3.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(2.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, -2.5167F, -12.25F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, 1.4833F, -12.25F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(1.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, 1.7833F, -13.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(1.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, -2.8167F, -13.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-2.0F, -2.0167F, 4.75F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-1.5F, -1.4167F, 7.75F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(89, 3).addBox(-1.0F, -0.9167F, 8.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.9833F, -2.75F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(AbstractCannonShip entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cannon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}