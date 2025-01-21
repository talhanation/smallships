package com.talhanation.smallships.client.model;

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.renderer.entity.state.CannonBallRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class CannonBallModel extends EntityModel<CannonBallRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "model_cannonball"), "main");
	private final ModelPart cannonball;

	public CannonBallModel() {
        super(createBodyLayer().bakeRoot());
        ModelPart root = createBodyLayer().bakeRoot();
		this.cannonball = root.getChild("cannonball");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cannonball = partdefinition.addOrReplaceChild("cannonball", CubeListBuilder.create()
				.addBox(1.5F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F)
				.addBox(-3.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F)
				.addBox(-3.0F, -6.0F, -2.0F, 4.0F, 1.0F, 4.0F)
				.addBox(-2.0F, -6.5F, -1.0F, 2.0F, 1.0F, 2.0F)
				.addBox(-2.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F)
				.addBox(-3.0F, -5.0F, 2.0F, 4.0F, 4.0F, 1.0F)
				.addBox(-2.0F, -4.0F, 2.5F, 2.0F, 2.0F, 1.0F)
				.addBox(-2.0F, -4.0F, -3.5F, 2.0F, 2.0F, 1.0F)
				.addBox(-3.0F, -5.0F, -3.0F, 4.0F, 4.0F, 1.0F)
				.addBox(1.0F, -5.0F, -2.0F, 1.0F, 4.0F, 4.0F)
				.addBox(-4.0F, -5.0F, -2.0F, 1.0F, 4.0F, 4.0F)
				.addBox(-4.5F, -4.0F, -1.0F, 1.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 23.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(CannonBallRenderState entityRenderState) {
		super.setupAnim(entityRenderState);
	}
}