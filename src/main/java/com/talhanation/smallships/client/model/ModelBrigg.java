package com.talhanation.smallships.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.entities.BriggEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class ModelBrigg extends EntityModel<BriggEntity> {

	// Location for the model layer (used by Minecraft to locate the model resource)
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation("modid", "model_brigg"), "main");

	private final ModelPart rootPart; // The root part of the model (main entry point for rendering)
	private final VisibilityHandler visibilityHandler; // Handles setting visibility of model parts
	private final AnimationHandler animationHandler; // Handles animations for the model

	public ModelBrigg() {
		// Initialize the model's root part and subcomponents
		this.rootPart = createBodyLayer().bakeRoot();

		// Set up default handlers for visibility and animations.
		this.visibilityHandler = new DefaultVisibilityHandler(rootPart);
		this.animationHandler = new DefaultAnimationHandler(rootPart);
	}

	/**
	 * Creates the body layer definition of the model.
	 * This includes defining all the parts of the model (e.g., base, chests, banner, etc.).
	 */
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		// Define main body of the ship
		PartDefinition modelBrigg = partDefinition.addOrReplaceChild("ModelBrigg",
				CubeListBuilder.create(), PartPose.offset(3.0F, 24.0F, 0.0F));

		// Example: Adds base (bottom part) of the ship
		modelBrigg.addOrReplaceChild("bottom_brigg",
				CubeListBuilder.create()
						.texOffs(0, 12).addBox(-3.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(0, 12).addBox(-3.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		// Example: Add steer part (wheel) of the ship
		modelBrigg.addOrReplaceChild("steer",
				CubeListBuilder.create().texOffs(0, 0).addBox(
						-9.0F, -0.5F, 0.5F, 18.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.8071F, 48.6533F, 0.0F, 0.1222F, 1.5708F));

		return LayerDefinition.create(meshDefinition, 128, 64);
	}

	@Override
	public void setupAnim(BriggEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// Delegate animation handling to a dedicated handler
		animationHandler.handle(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer,
							   int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		// Renders the model's root part
		rootPart.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	// Interfaces for handling visibility and animations

	/**
	 * Interface for handling visibility of model components based on entity state.
	 */
	public interface VisibilityHandler {
		void apply(BriggEntity entity); // Apply visibility logic
	}

	/**
	 * Interface for handling animations of the model.
	 */
	public interface AnimationHandler {
		void handle(BriggEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch); // Apply animation logic
	}

	/**
	 * Default implementation of the VisibilityHandler.
	 * Handles visibility of chests, banner, and other parts.
	 */
	public static class DefaultVisibilityHandler implements VisibilityHandler {
		private final ModelPart root;

		public DefaultVisibilityHandler(ModelPart root) {
			this.root = root;
		}

		@Override
		public void apply(BriggEntity entity) {
			// Set visibility of individual parts based on cargo and banner presence
			root.getChild("chest_1").visible = entity.getCargo() >= 1;
			root.getChild("chest_2").visible = entity.getCargo() >= 2;
			root.getChild("chest_3").visible = entity.getCargo() >= 3;
			root.getChild("chest_4").visible = entity.getCargo() >= 4;
			root.getChild("BannerStick").visible = entity.getHasBanner();
		}
	}

	/**
	 * Default implementation of the AnimationHandler.
	 * Handles setting rotation and other animations of model parts.
	 */
	public static class DefaultAnimationHandler implements AnimationHandler {
		private final ModelPart root;

		public DefaultAnimationHandler(ModelPart root) {
			this.root = root;
		}

		@Override
		public void handle(BriggEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// Rotate the steer part based on the entity's rotation speed
			root.getChild("steer").yRot = -entity.getRotSpeed();
		}
	}

	/**
	 * Sets a custom VisibilityHandler for extending or modifying visibility logic.
	 * @param handler Custom visibility handler
	 */
	public void setVisibilityHandler(VisibilityHandler handler) {
		if (handler != null) {
			handler.apply(null);
		}
	}

	/**
	 * Sets a custom AnimationHandler for extending or modifying animation logic.
	 * @param handler Custom animation handler
	 */
	public void setAnimationHandler(AnimationHandler handler) {
		// Add custom animation handling when needed
	}
}