package com.talhanation.smallships.client.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class DockyardBlockModel {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath("smallships", "dockyard"), "main");

	private final ModelPart dockyardBlock;
	private final ModelPart block;
	private final ModelPart anchorNorth;
	private final ModelPart sailWest;
	private final ModelPart netEast;
	private final ModelPart shelfSouth;
	private final ModelPart planTop;
	private final ModelPart sawTop;
	private final ModelPart anchorNorth2;

	public DockyardBlockModel(ModelPart root) {
		this.dockyardBlock = root.getChild("DockyardBlock");
		this.block = this.dockyardBlock.getChild("block");
		this.anchorNorth = this.dockyardBlock.getChild("anchor_north");
		this.sailWest = this.dockyardBlock.getChild("sail_west");
		this.netEast = this.dockyardBlock.getChild("net_east");
		this.shelfSouth = this.dockyardBlock.getChild("shelf_south");
		this.planTop = this.dockyardBlock.getChild("plan_top");
		this.sawTop = this.dockyardBlock.getChild("saw_top");
		this.anchorNorth2 = this.dockyardBlock.getChild("anchor_north2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition DockyardBlock = partdefinition.addOrReplaceChild("DockyardBlock", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition cube_r1 = DockyardBlock.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 57).addBox(-2.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 57).addBox(-4.0F, -11.0F, 0.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 4.9F, 4.6F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = DockyardBlock.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(15, 57).addBox(-2.0F, -6.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 4.9F, 6.1F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = DockyardBlock.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(15, 57).addBox(-2.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 57).addBox(-4.0F, -11.0F, 0.0F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 4.9F, 8.1F, 0.0F, -1.5708F, 0.0F));

		PartDefinition block = DockyardBlock.addOrReplaceChild("block", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition anchor_north = DockyardBlock.addOrReplaceChild("anchor_north", CubeListBuilder.create().texOffs(0, 0).addBox(-9.5F, 3.2F, 7.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, -6.8F, 7.1F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.5F, -4.4F, 7.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-12.5F, -4.4F, 7.1F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-10.5F, -4.9F, 7.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, -16.0F));

		PartDefinition cube_r4 = anchor_north.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5297F, 3.0821F, 8.3F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r5 = anchor_north.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1297F, 1.3821F, 8.4F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r6 = anchor_north.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0297F, 1.4071F, 8.4F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r7 = anchor_north.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3498F, -6.1884F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2F, 6.2F, 8.2F, 0.0F, 0.0F, 1.1345F));

		PartDefinition cube_r8 = anchor_north.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 6.2F, 8.1F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r9 = anchor_north.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.6502F, -6.1884F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8F, 6.2F, 8.2F, 0.0F, 0.0F, -1.1345F));

		PartDefinition sail_west = DockyardBlock.addOrReplaceChild("sail_west", CubeListBuilder.create().texOffs(42, 47).addBox(-1.5F, -6.0F, -6.0F, 2.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(28, 47).addBox(-0.5F, -7.7F, 0.8F, 1.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(-2.0F, 4.0F, -6.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-2.0F, 3.7F, -4.0F, 3.3F, 3.6F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-2.0F, 3.7F, 2.0F, 3.3F, 3.6F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, 0.0F));

		PartDefinition net_east = DockyardBlock.addOrReplaceChild("net_east", CubeListBuilder.create().texOffs(49, 0).addBox(-0.5F, -6.0F, -7.0F, 1.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(49, 0).addBox(-0.5F, 4.9F, -1.9F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(-1.0F, -7.0F, -7.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition shelf_south = DockyardBlock.addOrReplaceChild("shelf_south", CubeListBuilder.create().texOffs(20, 0).addBox(6.0F, -7.0F, -1.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(35, 1).addBox(-7.0F, -7.0F, -1.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 10).addBox(-6.0F, 4.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 4).addBox(-6.0F, -1.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 7).addBox(-6.0F, -7.0F, -1.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 34).addBox(1.0F, 1.0F, -0.2F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 34).addBox(-1.0F, 2.0F, -0.2F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 32).addBox(-5.0F, -4.0F, -0.3F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 58).addBox(1.0F, -3.0F, -0.3F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 61).addBox(-6.0F, 2.0F, -0.3F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition plan_top = DockyardBlock.addOrReplaceChild("plan_top", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition plan_r1 = plan_top.addOrReplaceChild("plan_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -0.5F, -5.0F, 12.0F, 0.5F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.3F, 2.0F, 0.0F, 3.098F, 0.0F));

		PartDefinition saw_top = DockyardBlock.addOrReplaceChild("saw_top", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5698F, -8.825F, -5.6079F, 0.0F, 0.5236F, 0.0F));

		PartDefinition saw_handle_r1 = saw_top.addOrReplaceChild("saw_handle_r1", CubeListBuilder.create().texOffs(34, 32).addBox(-1.5F, -0.5F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2255F, 0.2657F, -1.3394F, -3.1416F, 0.3927F, -3.1329F));

		PartDefinition saw_blade_r1 = saw_top.addOrReplaceChild("saw_blade_r1", CubeListBuilder.create().texOffs(28, 43).addBox(-4.0F, -1.0F, 3.0F, 11.0F, 0.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5698F, 1.225F, -3.3921F, 0.0F, -0.3927F, 0.0087F));

		PartDefinition anchor_north2 = DockyardBlock.addOrReplaceChild("anchor_north2", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, -16.0F));

		PartDefinition cube_r10 = anchor_north2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -2.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5297F, 3.0821F, 8.3F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r11 = anchor_north2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1297F, 1.3821F, 8.4F, 0.0F, 0.0F, -0.6981F));

		PartDefinition cube_r12 = anchor_north2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0297F, 1.4071F, 8.4F, 0.0F, 0.0F, 0.2618F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void render(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		this.dockyardBlock.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}
}