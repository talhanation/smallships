package com.talhanation.smallships.client.model.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.projectile.GrapeShotEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class GrapeShotModel extends EntityModel<GrapeShotEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "grapeshotmodel"), "main");
	private final ModelPart GrapeShot;
	private final ModelPart cannonball;

	public GrapeShotModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.GrapeShot = root.getChild("GrapeShot");
		this.cannonball = this.GrapeShot.getChild("cannonball");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition GrapeShot = partdefinition.addOrReplaceChild("GrapeShot", CubeListBuilder.create(), PartPose.offset(0.3333F, 2.3333F, 0.0F));

		PartDefinition cannonball = GrapeShot.addOrReplaceChild("cannonball", CubeListBuilder.create().texOffs(9, 33).addBox(0.0F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 33).addBox(0.0F, 4.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1, 44).addBox(0.0F, 1.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 44).addBox(0.0F, 1.0F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 45).addBox(-1.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 45).addBox(3.0F, 1.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.6333F, -2.3333F, 0.4F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(GrapeShotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		GrapeShot.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}