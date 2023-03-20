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
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, CogEntity.ID + "_sail_model"), "main");

	private final ModelPart Segel_0;
	private final ModelPart Segel_1;
	private final ModelPart Segel_2;
	private final ModelPart Segel_3;
	private final ModelPart Segel_4;

	public CogSailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Segel_0 = root.getChild("Segel_0");
		this.Segel_1 = root.getChild("Segel_1");
		this.Segel_2 = root.getChild("Segel_2");
		this.Segel_3 = root.getChild("Segel_3");
		this.Segel_4 = root.getChild("Segel_4");
	}

	public static LayerDefinition createBodyLayer(){
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Segel_0 = partdefinition.addOrReplaceChild("Segel_0", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition segel_1_3 = Segel_0.addOrReplaceChild("segel_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_0 = segel_1_3.addOrReplaceChild("segel_1_0", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_4 = segel_1_3.addOrReplaceChild("segel_1_4", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition rope_4 = segel_1_4.addOrReplaceChild("rope_4", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4884F, 1.2464F, 1.6894F));

		PartDefinition cube_r1 = rope_4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(98, 12).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = rope_4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -33.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r3 = rope_4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r4 = rope_4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r5 = rope_4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(96, 0).addBox(27.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_5 = segel_1_4.addOrReplaceChild("rope_5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.1491F, -1.1947F, -1.3336F));

		PartDefinition cube_r6 = rope_5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(96, 0).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r7 = rope_5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -35.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r8 = rope_5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -23.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r9 = rope_5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r10 = rope_5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(96, 0).addBox(27.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end = segel_1_4.addOrReplaceChild("sail_end", CubeListBuilder.create(), PartPose.offsetAndRotation(22.1F, -54.7898F, -1.4374F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r11 = sail_end.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(90, 2).addBox(-6.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(90, 2).addBox(-19.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(90, 2).addBox(-32.1F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(90, 3).addBox(6.9F, -3.25F, -3.0F, 13.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(98, 0).addBox(19.9F, -3.25F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -2.2166F, 0.0F, 0.0F));

		PartDefinition sail_ropes = Segel_0.addOrReplaceChild("sail_ropes", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_1 = sail_ropes.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r12 = rope_1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r13 = rope_1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r14 = rope_1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_3 = sail_ropes.addOrReplaceChild("rope_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = rope_3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r16 = rope_3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r17 = rope_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition Segel_1 = partdefinition.addOrReplaceChild("Segel_1", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition sail_ropes2 = Segel_1.addOrReplaceChild("sail_ropes2", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_2 = sail_ropes2.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r18 = rope_2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r19 = rope_2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r20 = rope_2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_6 = sail_ropes2.addOrReplaceChild("rope_6", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r21 = rope_6.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r22 = rope_6.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r23 = rope_6.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_1_2 = Segel_1.addOrReplaceChild("segel_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_1 = segel_1_2.addOrReplaceChild("segel_1_1", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_5 = segel_1_2.addOrReplaceChild("segel_1_5", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r24 = segel_1_5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r25 = segel_1_5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_7 = segel_1_5.addOrReplaceChild("rope_7", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.4794F, 1.1163F, 1.7268F));

		PartDefinition cube_r26 = rope_7.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(98, 8).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r27 = rope_7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r28 = rope_7.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r29 = rope_7.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r30 = rope_7.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_8 = segel_1_5.addOrReplaceChild("rope_8", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2348F, -1.0973F, -1.4276F));

		PartDefinition cube_r31 = rope_8.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(98, 6).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r32 = rope_8.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -31.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r33 = rope_8.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -19.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r34 = rope_8.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r35 = rope_8.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end2 = segel_1_5.addOrReplaceChild("sail_end2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -41.0F, -1.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r36 = sail_end2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(92, 6).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(92, 4).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(92, 4).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(92, 3).addBox(6.9F, -2.25F, -2.0F, 13.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(100, 4).addBox(19.9F, -2.25F, -2.0F, 9.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition Segel_2 = partdefinition.addOrReplaceChild("Segel_2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition sail_ropes3 = Segel_2.addOrReplaceChild("sail_ropes3", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_9 = sail_ropes3.addOrReplaceChild("rope_9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r37 = rope_9.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r38 = rope_9.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r39 = rope_9.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_10 = sail_ropes3.addOrReplaceChild("rope_10", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r40 = rope_10.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r41 = rope_10.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r42 = rope_10.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_1_6 = Segel_2.addOrReplaceChild("segel_1_6", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_7 = segel_1_6.addOrReplaceChild("segel_1_7", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_8 = segel_1_6.addOrReplaceChild("segel_1_8", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r43 = segel_1_8.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r44 = segel_1_8.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r45 = segel_1_8.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r46 = segel_1_8.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_11 = segel_1_8.addOrReplaceChild("rope_11", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5001F, 0.9684F, 1.7506F));

		PartDefinition cube_r47 = rope_11.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(98, 9).addBox(53.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 4).addBox(20.5237F, -0.4798F, -17.3901F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(34.5237F, -0.4798F, -17.3901F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r48 = rope_11.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(2, 21).addBox(4.6164F, 4.645F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r49 = rope_11.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 29).addBox(7.8664F, 7.895F, -0.8901F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r50 = rope_11.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(96, 0).addBox(35.5237F, 0.7702F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5237F, -1.7298F, -17.3901F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r51 = rope_11.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -0.5F, -17.4F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_12 = segel_1_8.addOrReplaceChild("rope_12", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3165F, -0.9301F, -1.5235F));

		PartDefinition cube_r52 = rope_12.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(98, 4).addBox(54.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(19.5005F, -0.8459F, -19.492F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(33.5005F, -0.8459F, -19.492F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r53 = rope_12.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(2, 21).addBox(4.4019F, 4.9799F, -3.0738F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r54 = rope_12.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(7, 29).addBox(7.7553F, 7.9733F, -2.992F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 2.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r55 = rope_12.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(96, 0).addBox(35.5005F, 0.9041F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(35.5005F, -1.5959F, -19.492F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 19.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r56 = rope_12.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -0.875F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end3 = segel_1_8.addOrReplaceChild("sail_end3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r57 = sail_end3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(96, 1).addBox(-6.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-19.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-32.1F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(94, 4).addBox(6.9F, -2.25F, -2.0F, 13.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(19.9F, -2.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6F, -7.5398F, 5.0626F, -2.2166F, 0.0F, 0.0F));

		PartDefinition Segel_3 = partdefinition.addOrReplaceChild("Segel_3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition sail_ropes5 = Segel_3.addOrReplaceChild("sail_ropes5", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_17 = sail_ropes5.addOrReplaceChild("rope_17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r58 = rope_17.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r59 = rope_17.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r60 = rope_17.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_18 = sail_ropes5.addOrReplaceChild("rope_18", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r61 = rope_18.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r62 = rope_18.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r63 = rope_18.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition segel_1_9 = Segel_3.addOrReplaceChild("segel_1_9", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, 13.0F, -6.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition segel_1_10 = segel_1_9.addOrReplaceChild("segel_1_10", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		PartDefinition segel_1_11 = segel_1_9.addOrReplaceChild("segel_1_11", CubeListBuilder.create(), PartPose.offset(-26.5F, -24.0F, -21.5F));

		PartDefinition cube_r64 = segel_1_11.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(96, 3).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -34.7644F, 33.9338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r65 = segel_1_11.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(96, 4).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -39.6813F, 33.5822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r66 = segel_1_11.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r67 = segel_1_11.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r68 = segel_1_11.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r69 = segel_1_11.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition rope_19 = segel_1_11.addOrReplaceChild("rope_19", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.5097F, 0.8552F, 1.7628F));

		PartDefinition cube_r70 = rope_19.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(98, 12).addBox(44.5F, -0.5F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(20.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(25.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r71 = rope_19.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r72 = rope_19.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r73 = rope_19.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r74 = rope_19.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition rope_20 = segel_1_11.addOrReplaceChild("rope_20", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.3422F, -0.8454F, -1.5566F));

		PartDefinition cube_r75 = rope_20.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(96, 0).addBox(45.5F, -1.0F, -17.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(19.5F, -1.0F, -17.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(25.5F, -1.0F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r76 = rope_20.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -29.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r77 = rope_20.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -17.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r78 = rope_20.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r79 = rope_20.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(96, 0).addBox(21.5F, -1.0F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition sail_end4 = segel_1_11.addOrReplaceChild("sail_end4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -31.0F, -9.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r80 = sail_end4.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(96, 1).addBox(-37.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-50.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-63.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 9).addBox(-24.0F, -41.6933F, 18.2105F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-11.0F, -41.6933F, 18.2105F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(55.5F, -1.8067F, 44.7895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition Segel_4 = partdefinition.addOrReplaceChild("Segel_4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition sail_ropes4 = Segel_4.addOrReplaceChild("sail_ropes4", CubeListBuilder.create(), PartPose.offset(43.5F, -16.0F, 0.0F));

		PartDefinition rope_13 = sail_ropes4.addOrReplaceChild("rope_13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -0.5236F));

		PartDefinition cube_r81 = rope_13.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r82 = rope_13.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r83 = rope_13.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_14 = sail_ropes4.addOrReplaceChild("rope_14", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, -5.0F, 0.0F, 0.733F, -1.5708F, 0.0F));

		PartDefinition cube_r84 = rope_14.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(79.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(64.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r85 = rope_14.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r86 = rope_14.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(7, 29).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cog_segel_1_4 = Segel_4.addOrReplaceChild("cog_segel_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(8.5F, -11.0F, 20.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r87 = cog_segel_1_4.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(96, 6).addBox(-60.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-49.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 1).addBox(-38.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 9).addBox(-27.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-16.0F, -39.0F, 16.6905F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -26.3067F, 36.3895F, 2.0595F, 0.0F, 0.0F));

		PartDefinition cube_r88 = cog_segel_1_4.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(96, 5).addBox(-16.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-38.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 1).addBox(-49.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-60.0F, -40.25F, 11.2888F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -28.4794F, 33.5112F, 1.8762F, 0.0F, 0.0F));

		PartDefinition cube_r89 = cog_segel_1_4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(96, 3).addBox(-16.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-60.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-49.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-38.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-27.0F, -43.5F, 4.75F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -34.7644F, 33.9338F, 1.7453F, 0.0F, 0.0F));

		PartDefinition cube_r90 = cog_segel_1_4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(96, 4).addBox(-16.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-60.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 6).addBox(-49.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-27.0F, -44.0887F, -4.8822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -39.6813F, 33.5822F, 1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r91 = cog_segel_1_4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(96, 1).addBox(-60.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-49.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-27.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 2).addBox(-16.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-38.0F, -40.9587F, -18.0289F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -44.7113F, 34.1289F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r92 = cog_segel_1_4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(96, 0).addBox(-60.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-49.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-38.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-16.0F, -38.7859F, -21.6372F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -47.7441F, 35.6572F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r93 = cog_segel_1_4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(96, 3).addBox(-60.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-38.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-16.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-27.0F, -1.0F, -2.5F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -55.4356F, -0.4095F, 0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r94 = cog_segel_1_4.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(96, 5).addBox(-60.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 7).addBox(-38.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 8).addBox(-27.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-16.0F, -32.7857F, -32.1293F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -52.4943F, 39.4993F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r95 = cog_segel_1_4.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(96, 2).addBox(-60.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 5).addBox(-49.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 4).addBox(-38.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-27.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(96, 3).addBox(-16.0F, -34.7019F, 23.9822F, 11.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, -20.7281F, 39.2678F, 2.2227F, 0.0F, 0.0F));

		PartDefinition rope_15 = cog_segel_1_4.addOrReplaceChild("rope_15", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 0.0F, 18.0F, 1.3963F, 0.7941F, 1.7628F));

		PartDefinition cube_r96 = rope_15.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(96, 0).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r97 = rope_15.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r98 = rope_15.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition rope_16 = cog_segel_1_4.addOrReplaceChild("rope_16", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.5F, 19.0F, 1.2654F, -0.7592F, -1.5708F));

		PartDefinition cube_r99 = rope_16.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(96, 0).addBox(43.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(34.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, 0.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(26.5F, -1.75F, -17.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(21.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r100 = rope_16.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(2, 21).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition cube_r101 = rope_16.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(7, 29).addBox(1.5F, 1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull Ship cogEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		switch (cogEntity.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				this.Segel_0.visible = true;
				this.Segel_1.visible = false;
				this.Segel_2.visible = false;
				this.Segel_3.visible = false;
				this.Segel_4.visible = false;
			}
			case 1 -> {
				this.Segel_0.visible = false;
				this.Segel_1.visible = true;
				this.Segel_2.visible = false;
				this.Segel_3.visible = false;
				this.Segel_4.visible = false;
			}
			case 2 -> {
				this.Segel_0.visible = false;
				this.Segel_1.visible = false;
				this.Segel_2.visible = true;
				this.Segel_3.visible = false;
				this.Segel_4.visible = false;
			}
			case 3 -> {
				this.Segel_0.visible = false;
				this.Segel_1.visible = false;
				this.Segel_2.visible = false;
				this.Segel_3.visible = true;
				this.Segel_4.visible = false;
			}
			case 4 -> {
				this.Segel_0.visible = false;
				this.Segel_1.visible = false;
				this.Segel_2.visible = false;
				this.Segel_3.visible = false;
				this.Segel_4.visible = true;
			}
			default -> {}
		}
	}

	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Segel_0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Segel_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Segel_2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Segel_3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Segel_4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}