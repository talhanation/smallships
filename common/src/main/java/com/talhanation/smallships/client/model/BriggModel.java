package com.talhanation.smallships.client.model;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


@SuppressWarnings("FieldCanBeLocal")
public class BriggModel extends ShipModel<BriggEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, BriggEntity.ID + "_model"), "main");
	private final ModelPart ModelBrigg;
	private final ModelPart bottom_brigg;
	private final ModelPart chest_1;
	private final ModelPart chest_2;
	private final ModelPart chest_3;
	private final ModelPart chest_4;
	private final ModelPart sides_brigg;
	private final ModelPart mast_front;
	private final ModelPart mast_back;
	private final ModelPart steer;

	public BriggModel(ModelPart root) {
		this.ModelBrigg = root.getChild("ModelBrigg");
		this.bottom_brigg = this.ModelBrigg.getChild("bottom_brigg");
		this.chest_1 = this.ModelBrigg.getChild("chest_1");
		this.chest_2 = this.ModelBrigg.getChild("chest_2");
		this.chest_3 = this.ModelBrigg.getChild("chest_3");
		this.chest_4 = this.ModelBrigg.getChild("chest_4");
		this.sides_brigg = this.ModelBrigg.getChild("sides_brigg");
		this.mast_front = this.ModelBrigg.getChild("mast_front");
		this.mast_back = this.ModelBrigg.getChild("mast_back");
		this.steer = this.ModelBrigg.getChild("steer");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ModelBrigg = partdefinition.addOrReplaceChild("ModelBrigg", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 26.0F, -3.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bottom_brigg = ModelBrigg.addOrReplaceChild("bottom_brigg", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition cube_r1 = bottom_brigg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 0).addBox(-7.0F, -3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(4, 0).addBox(-7.0F, 3.0F, -5.5F, 16.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, -29.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = bottom_brigg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-20.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -6.0F, -2.5F, 10.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(10.0F, -6.0F, -2.5F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(34.0F, 3.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 3.0F, -2.5F, 14.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-20.0F, 3.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r3 = bottom_brigg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(10.0F, -6.0F, -2.5F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 24.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = bottom_brigg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(10.0F, -6.0F, -2.5F, 12.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 12.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r5 = bottom_brigg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(11, 3).addBox(-12.0F, -6.0F, -2.5F, 15.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -20.1F, -47.6F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition cube_r6 = bottom_brigg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(7, 0).addBox(-9.0F, -6.0F, -3.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.5F, -38.3F, -1.5708F, -0.2618F, 1.5708F));

		PartDefinition cube_r7 = bottom_brigg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(4, 0).addBox(-12.0F, -6.0F, -3.5F, 12.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.5F, 54.2F, -1.5708F, 0.0436F, 1.5708F));

		PartDefinition cube_r8 = bottom_brigg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(4, 0).addBox(-12.0F, -6.0F, -3.5F, 12.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.5F, -44.5F, -1.5708F, -0.2618F, 1.5708F));

		PartDefinition cube_r9 = bottom_brigg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 1).addBox(-12.0F, -6.0F, -4.5F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.2F, -31.8F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r10 = bottom_brigg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(3, 0).addBox(-5.0F, -9.0F, -4.5F, 5.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 3.0F, 54.0F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r11 = bottom_brigg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(9, 1).addBox(-12.0F, -6.0F, -4.5F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(9, 1).addBox(-12.0F, -6.0F, -4.5F, 12.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 3.0F, -36.0F, -1.5708F, -0.7854F, 1.5708F));

		PartDefinition cube_r12 = bottom_brigg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(7, 0).addBox(7.0F, -16.0F, -14.0F, 21.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -6.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = bottom_brigg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 0).addBox(7.0F, -16.0F, -14.0F, 21.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 29.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r14 = bottom_brigg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -19.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -3.0F, -14.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = bottom_brigg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(12, 0).addBox(-16.0F, 5.0F, -14.0F, 16.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -6.0F, -20.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = bottom_brigg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(21, 1).mirror().addBox(-8.0F, 8.0F, -14.0F, 8.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -6.0F, -36.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r17 = bottom_brigg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-28.0F, 9.0F, -11.0F, 13.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = bottom_brigg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-29.0F, 12.0F, -11.0F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -7.0F, -13.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r19 = bottom_brigg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-28.0F, 9.0F, -11.0F, 13.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = bottom_brigg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(11, 0).addBox(-28.0F, -15.0F, -11.0F, 13.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -16.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(41.0F, -16.0F, -11.0F, 10.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(43.0F, -3.0F, -11.0F, 9.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = bottom_brigg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 10.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 22.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r22 = bottom_brigg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(43.0F, -3.0F, -11.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -12.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r23 = bottom_brigg.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(43.0F, -3.0F, -11.0F, 9.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4F, 4.0F, 5.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r24 = bottom_brigg.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(5, 0).mirror().addBox(-34.0F, 9.0F, -11.0F, 19.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -1.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r25 = bottom_brigg.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(21, 1).addBox(-8.0F, -16.0F, -14.0F, 8.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -36.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r26 = bottom_brigg.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(12, 0).addBox(-16.0F, -19.0F, -14.0F, 16.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -20.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r27 = bottom_brigg.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(1, 4).addBox(11.0F, -22.0F, -14.0F, 21.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.0F, -6.0F, 25.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r28 = bottom_brigg.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(1, 4).addBox(11.0F, -22.0F, -14.0F, 21.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -6.0F, 25.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r29 = bottom_brigg.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 3).addBox(-28.0F, -22.0F, -14.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 64.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r30 = bottom_brigg.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 3).addBox(16.0F, 13.0F, -14.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, 13.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 20.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r31 = bottom_brigg.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, -6.0F, -8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r32 = bottom_brigg.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -25.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r33 = bottom_brigg.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, -25.0F, -14.0F, 28.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.0F, 15.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r34 = bottom_brigg.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(10, 0).addBox(-29.0F, -12.0F, -11.0F, 14.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, -13.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r35 = bottom_brigg.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(11, 0).addBox(-28.0F, -15.0F, -11.0F, 13.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -16.0F, -11.0F, 24.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 22.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(41.0F, -16.0F, -10.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r36 = bottom_brigg.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -6.0F, -11.0F, 24.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -6.0F, -11.0F, 22.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -1.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r37 = bottom_brigg.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -6.0F, -11.0F, 22.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -6.0F, -11.0F, 24.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r38 = bottom_brigg.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -6.0F, -11.0F, 22.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -6.0F, -11.0F, 24.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r39 = bottom_brigg.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 10.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 22.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r40 = bottom_brigg.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 10.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, 22.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r41 = bottom_brigg.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 10.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 22.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r42 = bottom_brigg.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 22.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r43 = bottom_brigg.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(1, 1).addBox(41.0F, -16.0F, -10.0F, 16.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -7.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r44 = bottom_brigg.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(5, 0).addBox(-34.0F, -15.0F, -11.0F, 19.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -3.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -16.0F, -11.0F, 24.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -16.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -3.0F, -11.0F, 22.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(43.0F, -3.0F, -11.0F, 14.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(41.0F, -16.0F, -11.0F, 15.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r45 = bottom_brigg.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -6.0F, -11.0F, 22.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-15.0F, -6.0F, -11.0F, 24.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -1.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r46 = bottom_brigg.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(43.0F, -3.0F, -11.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -12.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r47 = bottom_brigg.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 0).addBox(34.0F, -6.0F, -2.5F, 20.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -20.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_1 = ModelBrigg.addOrReplaceChild("chest_1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition cube_r48 = chest_1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(38.0F, -19.0F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r49 = chest_1.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, -1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -20.5F, 42.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r50 = chest_1.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = ModelBrigg.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(-15.0F, 0.0F, 18.0F));

		PartDefinition cube_r51 = chest_2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(96, 38).addBox(-17.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -18.0F, 41.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r52 = chest_2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(96, 38).addBox(-8.5F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -18.0F, 34.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r53 = chest_2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(30, 55).addBox(30.0F, -25.0F, 2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 0.0F, -7.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r54 = chest_2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(30, 55).addBox(32.0F, -25.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_3 = ModelBrigg.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.1667F, -18.9167F, -31.4167F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r55 = chest_3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1667F, 18.9167F, -38.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r56 = chest_3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1667F, 18.9167F, -42.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r57 = chest_3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(30, 55).addBox(34.0F, -19.0F, -1.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1667F, 18.9167F, -29.1833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r58 = chest_3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8333F, 0.9167F, -1.5833F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r59 = chest_3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, -1.5833F, 1.6167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition chest_4 = ModelBrigg.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8333F, -18.9167F, -31.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r60 = chest_4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 8.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 55).addBox(38.0F, -27.0F, 9.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1667F, 18.9167F, -40.5833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r61 = chest_4.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(30, 55).addBox(34.0F, -19.0F, 2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1667F, 18.9167F, -36.3833F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r62 = chest_4.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8333F, 0.9167F, 0.4167F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r63 = chest_4.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, 1.5F, -3.75F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1667F, -1.5833F, -5.5833F, 0.0F, 1.5708F, 0.0F));

		PartDefinition sides_brigg = ModelBrigg.addOrReplaceChild("sides_brigg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r64 = sides_brigg.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(3, 0).addBox(19.0F, -25.0F, -20.0F, 9.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r65 = sides_brigg.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(3, 0).addBox(19.0F, -25.0F, -20.0F, 9.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(44.0F, 0.0F, -3.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r66 = sides_brigg.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(0, 0).addBox(49.0F, 12.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r67 = sides_brigg.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -28.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-12.0F, 19.0F, -20.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 19.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(40.0F, -22.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(40.0F, 13.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-20.0F, -25.0F, -20.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -28.0F, -20.0F, 16.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(-45.0F, -13.0F, -24.0F, 3.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r68 = sides_brigg.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 0).addBox(49.0F, -21.0F, -22.0F, 9.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r69 = sides_brigg.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 0).addBox(-13.8406F, -2.0F, 8.918F, 25.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -12.5335F, 47.4516F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r70 = sides_brigg.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 0).addBox(-24.8406F, -3.0F, 8.918F, 19.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.6155F, 46.111F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r71 = sides_brigg.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(0, 0).addBox(-17.4624F, -10.0F, 14.9106F, 22.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.3406F, -6.5F, 8.918F, 19.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -17.0F, 48.0F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r72 = sides_brigg.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 0).addBox(-7.3406F, -23.5F, 7.918F, 17.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.7F, -17.0F, 48.0F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r73 = sides_brigg.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(0, 0).addBox(-7.3406F, -2.5F, 7.918F, 17.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.4F, -17.0F, 48.0F, 0.0F, 0.1222F, 1.5708F));

		PartDefinition cube_r74 = sides_brigg.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(0, 0).addBox(13.0F, 16.0F, -21.0F, 15.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r75 = sides_brigg.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -25.0F, -21.0F, 15.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r76 = sides_brigg.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(8, 0).addBox(-20.0F, -25.0F, -20.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(41.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r77 = sides_brigg.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(0, 4).addBox(-44.0F, -1.0F, -13.5F, 16.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(13.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-2.0F, -1.0F, -13.5F, 15.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 4).addBox(-28.0F, -1.0F, -13.5F, 26.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -13.5F, -46.0F, 3.1416F, -1.0996F, 1.5708F));

		PartDefinition cube_r78 = sides_brigg.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(9, 3).mirror().addBox(-36.0F, 2.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.0F, 0.0F, 8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r79 = sides_brigg.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(9, 3).mirror().addBox(-36.0F, 2.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r80 = sides_brigg.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(9, 3).mirror().addBox(-36.0F, 2.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 0.0F, -8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r81 = sides_brigg.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(10, 0).addBox(-45.0F, 11.0F, -24.0F, 3.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r82 = sides_brigg.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(9, 3).addBox(-36.0F, -22.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, -8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r83 = sides_brigg.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(9, 3).addBox(-36.0F, -22.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r84 = sides_brigg.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(9, 3).addBox(-36.0F, -22.0F, -19.0F, 8.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition mast_front = ModelBrigg.addOrReplaceChild("mast_front", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-3.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-31.0F, -82.0F, -20.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-40.0F, -82.0F, -20.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-28.0F, -112.0F, -20.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r85 = mast_front.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(0, 12).addBox(-18.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-18.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition mast_back = ModelBrigg.addOrReplaceChild("mast_back", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-31.0F, -82.0F, 22.0F, 28.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-40.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -82.0F, 22.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-3.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-28.0F, -114.0F, 23.0F, 25.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r86 = mast_back.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(6, 0).addBox(26.0F, -3.5F, -137.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -122.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -95.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -68.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(25.0F, -4.5F, -41.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r87 = mast_back.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -6.0F, 38.9F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -23.0F, 38.9F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -35.0F, 38.9F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -80.669F, 28.9006F, -1.4399F, 0.0F, 0.0F));

		PartDefinition cube_r88 = mast_back.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -41.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -15.0F, 5.0F, 2.0F, 19.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(25, 0).addBox(-0.5F, -33.0F, 5.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -80.669F, 28.9006F, -1.1345F, 0.0F, 0.0F));

		PartDefinition steer = ModelBrigg.addOrReplaceChild("steer", CubeListBuilder.create(), PartPose.offset(-3.0F, -1.8071F, 48.6533F));

		PartDefinition steer_r1 = steer.addOrReplaceChild("steer_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.4624F, -0.5F, 12.4106F, 18.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1222F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override
	public void setupAnim(BriggEntity briggEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.chest_1.visible = briggEntity.getInvFillState() >= 15;
		this.chest_2.visible = briggEntity.getInvFillState() >= 30;
		this.chest_3.visible = briggEntity.getInvFillState() >= 60;
		this.chest_4.visible = briggEntity.getInvFillState() >= 90;

		this.steer.yRot = -briggEntity.getRotSpeed() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.ModelBrigg;
	}
}