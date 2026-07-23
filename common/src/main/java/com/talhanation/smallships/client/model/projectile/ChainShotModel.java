package com.talhanation.smallships.client.model.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.projectile.ChainShotEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ChainShotModel extends EntityModel<ChainShotEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "model_chainshot"), "main");
	private final ModelPart ChainShot;
	private final ModelPart cannonball;
	private final ModelPart chain;
	private final ModelPart cannonball2;

	public ChainShotModel() {
		ModelPart root = createBodyLayer().bakeRoot();

		this.ChainShot = root.getChild("ChainShot");
		this.cannonball = this.ChainShot.getChild("cannonball");
		this.chain = this.ChainShot.getChild("chain");
		this.cannonball2 = this.ChainShot.getChild("cannonball2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ChainShot = partdefinition.addOrReplaceChild("ChainShot", CubeListBuilder.create(), PartPose.offset(0.3333F, 2.3333F, 0.0F));

		PartDefinition cannonball = ChainShot.addOrReplaceChild("cannonball", CubeListBuilder.create().texOffs(9, 33).addBox(0.0F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(26, 33).addBox(0.0F, 4.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 44).addBox(0.0F, 1.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 44).addBox(0.0F, 1.0F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 45).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 45).addBox(3.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.6667F, -0.8333F, 0.0F));

		PartDefinition chain = ChainShot.addOrReplaceChild("chain", CubeListBuilder.create().texOffs(1, 1).addBox(-9.0F, -1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-8.0F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-7.0F, -1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-5.0F, -1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-6.0F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-3.0F, -1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-4.0F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(0.0F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(-2.0F, -0.7F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-1.0F, -1.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.6667F, 1.6667F, 0.0F));

		PartDefinition cannonball2 = ChainShot.addOrReplaceChild("cannonball2", CubeListBuilder.create().texOffs(9, 33).addBox(0.0F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(26, 33).addBox(0.0F, 4.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 44).addBox(0.0F, 1.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(26, 44).addBox(0.0F, 1.0F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(38, 45).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 45).addBox(3.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.3333F, -0.8333F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}


	@Override
	public void setupAnim(ChainShotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		ChainShot.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}