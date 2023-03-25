package com.talhanation.smallships.client.model;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.mixin.controlling.BoatAccessor;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CogModel extends ShipModel<CogEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, CogEntity.ID + "_model"), "main");
	private final ModelPart root;
	private final ModelPart chest1;
	private final ModelPart chest2;
	private final ModelPart chest3;
	private final ModelPart chest4;
	private final ModelPart steer;

	public CogModel(ModelPart modelPart) {
		this.root = modelPart;
		ModelPart cog = this.root.getChild("cog");
		this.chest1 = cog.getChild("chest_1");
		this.chest2 = cog.getChild("chest_2");
		this.chest3 = cog.getChild("chest_3");
		this.chest4 = cog.getChild("chest_4");
		this.steer = cog.getChild("steer");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cog = partdefinition.addOrReplaceChild("cog", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition deck = cog.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(28.0F, 0.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(28.0F, -13.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-40.0F, -6.5F, 7.0F, 12.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-13.0F, -16.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-13.0F, 13.0F, 2.0F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -13.0F, 2.0F, 28.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, 16.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -19.0F, 2.0F, 18.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom = cog.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(4, 1).addBox(42.0F, -11.0F, -3.5F, 4.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(4, 1).addBox(-3.0F, -13.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(4, 1).addBox(-3.0F, -6.5F, -3.5F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.44F, 2.4938F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(38.0F, -2.0F, -10.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(16.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -4.0F, -10.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, 2.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-28.0F, -12.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(18.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(18.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sides = cog.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(-28.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-13.0F, -11.0F, -19.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(0.0F, -11.0F, -22.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(18.0F, -11.0F, -19.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-28.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-13.0F, -11.0F, 16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(28.0F, -11.0F, -16.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(28.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(37.0F, -17.0F, -16.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(28.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(37.0F, -17.0F, 13.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-35.0F, -16.0F, -6.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-35.0F, -16.0F, 4.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-31.0F, -16.0F, 4.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-31.0F, -16.0F, -6.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-38.0F, -16.0F, 4.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-38.0F, -16.0F, -6.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(28.0F, -11.0F, 13.0F, 14.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(0.0F, -11.0F, 19.0F, 18.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(18.0F, -11.0F, 16.0F, 10.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 36).addBox(-23.0F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-6.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-11.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-16.0F, -8.0F, -75.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-23.0F, -9.0F, 6.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-1.5F, -9.0F, 6.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-14.0F, -9.0F, 6.5F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 36).addBox(3.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 36).addBox(-9.5F, -3.0F, 6.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition mast_1 = cog.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(8, 0).addBox(-3.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-3.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-3.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-3.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-3.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -5.0F, -1.0F));

		PartDefinition cube_r6 = mast_1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(8, 0).addBox(-6.0F, -7.5F, -1.5F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-47.5F, -15.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition mast_oben = cog.addOrReplaceChild("mast_oben", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(9.0F, -69.0F, -32.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(9.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(9.0F, -69.0F, 16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest_1 = cog.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(96, 38).addBox(24.0F, -13.0F, -13.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = chest_1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 55).addBox(-2.75F, -4.25F, -2.25F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.75F, -11.75F, -8.25F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = chest_1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 55).addBox(-1.0F, 5.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -15.5F, -18.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r9 = chest_1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 55).addBox(57.0F, -19.0F, 25.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, 9.0F, -75.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r10 = chest_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(96, 38).addBox(-19.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -9.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_4 = cog.addOrReplaceChild("chest_4", CubeListBuilder.create(), PartPose.offset(-23.0F, -11.5F, 9.0F));

		PartDefinition cube_r11 = chest_4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 29).addBox(-3.0F, -1.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = chest_4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 55).addBox(39.0F, -22.0F, -5.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r13 = chest_4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 47).addBox(38.0F, -17.0F, -9.25F, 7.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, -42.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition chest_2 = cog.addOrReplaceChild("chest_2", CubeListBuilder.create(), PartPose.offset(19.0F, -15.5F, 15.0F));

		PartDefinition cube_r14 = chest_2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 55).addBox(0.0F, 6.5F, -10.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -1.5708F, 0.0F));

		PartDefinition cube_r15 = chest_2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(30, 55).addBox(57.0F, -19.0F, 14.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 55).addBox(32.0F, -25.0F, -8.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 24.5F, -57.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r16 = chest_2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 38).addBox(-19.0F, -4.0F, 3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.5F, -16.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition chest_3 = cog.addOrReplaceChild("chest_3", CubeListBuilder.create(), PartPose.offset(51.3333F, -8.0F, -11.1667F));

		PartDefinition cube_r17 = chest_3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(30, 55).addBox(33.0F, -19.0F, 53.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(31, 56).addBox(33.0F, -19.0F, 49.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3333F, 17.0F, -33.8333F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r18 = chest_3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(96, 38).addBox(-4.0F, -4.0F, -49.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.3333F, -1.0F, 7.1667F, 0.0F, 1.5708F, 0.0F));

		PartDefinition steer = cog.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(0.0F, -7.0F, -1.0F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(42.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(@NotNull CogEntity cogEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		byte u_byteMaxValueFourth = (-Byte.MIN_VALUE + Byte.MAX_VALUE) / 4;
		this.chest1.visible = cogEntity.getCargo() >= u_byteMaxValueFourth - (-Byte.MIN_VALUE);
		this.chest2.visible = cogEntity.getCargo() >= u_byteMaxValueFourth * 2 - (-Byte.MIN_VALUE);
		this.chest3.visible = cogEntity.getCargo() >= u_byteMaxValueFourth * 3 - (-Byte.MIN_VALUE);
		this.chest4.visible = cogEntity.getCargo() >= u_byteMaxValueFourth * 4 - (-Byte.MIN_VALUE);

		this.steer.yRot = -((BoatAccessor) cogEntity).getDeltaRotation() * 0.25F;
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}
}