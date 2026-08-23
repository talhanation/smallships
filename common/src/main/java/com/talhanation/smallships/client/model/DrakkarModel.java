package com.talhanation.smallships.client.model;


import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DrakkarModel extends ShipModel<DrakkarEntity> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DrakkarEntity.ID + "_model"), "main");
	private final ModelPart Drakkar;
	private final ModelPart deck;
	private final ModelPart cube_r1;
	private final ModelPart bottom;
	private final ModelPart cube_r2;
	private final ModelPart dragon;
	private final ModelPart dragon_tail;
	private final ModelPart cube_r3;
	private final ModelPart sides;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart steer;
	private final ModelPart row_L_4;
	private final ModelPart row_L_3;
	private final ModelPart row_L_2;
	private final ModelPart row_L_1;
	private final ModelPart row_R_1;
	private final ModelPart row_R_2;
	private final ModelPart row_R_3;
	private final ModelPart row_R_4;
	private final ModelPart mast_1;
	private final ModelPart cube_r6;
	private final ModelPart BannerStick;
	private final ModelPart mast_oben;

	public DrakkarModel(ModelPart modelPart) {
		this.Drakkar = modelPart.getChild("Drakkar");
		this.deck = this.Drakkar.getChild("deck");
		this.cube_r1 = this.deck.getChild("cube_r1");
		this.bottom = this.Drakkar.getChild("bottom");
		this.cube_r2 = this.bottom.getChild("cube_r2");
		this.dragon = this.cube_r2.getChild("dragon");
		this.dragon_tail = this.cube_r2.getChild("dragon_tail");
		this.cube_r3 = this.bottom.getChild("cube_r3");
		this.sides = this.Drakkar.getChild("sides");
		this.cube_r4 = this.sides.getChild("cube_r4");
		this.cube_r5 = this.sides.getChild("cube_r5");
		this.steer = this.Drakkar.getChild("steer");
		this.row_L_4 = this.Drakkar.getChild("row_L_4");
		this.row_L_3 = this.Drakkar.getChild("row_L_3");
		this.row_L_2 = this.Drakkar.getChild("row_L_2");
		this.row_L_1 = this.Drakkar.getChild("row_L_1");
		this.row_R_1 = this.Drakkar.getChild("row_R_1");
		this.row_R_2 = this.Drakkar.getChild("row_R_2");
		this.row_R_3 = this.Drakkar.getChild("row_R_3");
		this.row_R_4 = this.Drakkar.getChild("row_R_4");
		this.mast_1 = this.Drakkar.getChild("mast_1");
		this.cube_r6 = this.mast_1.getChild("cube_r6");
		this.BannerStick = this.Drakkar.getChild("BannerStick");
		this.mast_oben = this.Drakkar.getChild("mast_oben");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Drakkar = partdefinition.addOrReplaceChild("Drakkar", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition deck = Drakkar.addOrReplaceChild("deck", CubeListBuilder.create(), PartPose.offset(14.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = deck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-55.0F, -13.0F, 2.0F, 13.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-55.0F, 0.0F, 2.0F, 13.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-42.0F, 0.0F, 2.0F, 14.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-42.0F, -16.0F, 2.0F, 14.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(28.0F, -13.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(28.0F, 0.0F, 2.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 0.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -16.0F, 2.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bottom = Drakkar.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 2).addBox(-56.0F, 5.0F, -4.0F, 14.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7_r1 = cube_r2.addOrReplaceChild("cube_r7_r1", CubeListBuilder.create().texOffs(7, 4).addBox(-1.6F, 4.8F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 5.5F, 0.0F, -3.1416F, 0.0F, 1.5708F));

		PartDefinition cube_r5_r1 = cube_r2.addOrReplaceChild("cube_r5_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-7.2F, -3.5F, -3.5F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0F, 7.5F, 0.0F, 3.1416F, 0.0F, 2.4871F));

		PartDefinition cube_r4_r1 = cube_r2.addOrReplaceChild("cube_r4_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-7.2F, -3.5F, -3.5F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-56.0F, 7.5F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition dragon = cube_r2.addOrReplaceChild("dragon", CubeListBuilder.create(), PartPose.offset(-56.0F, 7.5F, 0.0F));

		PartDefinition cube_r11_r1 = dragon.addOrReplaceChild("cube_r11_r1", CubeListBuilder.create().texOffs(16, 5).addBox(-0.5F, -3.5F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(16, 5).addBox(-0.5F, -3.5F, 4.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6973F, -50.664F, -2.5F, 0.0F, 0.0F, 2.7489F));

		PartDefinition cube_r9_r1 = dragon.addOrReplaceChild("cube_r9_r1", CubeListBuilder.create().texOffs(11, 4).addBox(-4.5F, -3.5F, -1.0F, 9.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8027F, -39.364F, -0.5F, 0.0F, 0.0F, 1.6144F));

		PartDefinition cube_r8_r1 = dragon.addOrReplaceChild("cube_r8_r1", CubeListBuilder.create().texOffs(9, 1).addBox(2.15F, -12.425F, -2.5F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1F, -42.8F, -0.4F, 0.0F, 0.0F, 0.829F));

		PartDefinition cube_r10_r1 = dragon.addOrReplaceChild("cube_r10_r1", CubeListBuilder.create().texOffs(11, 6).addBox(-1.0F, 3.0F, 1.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 6).addBox(-1.0F, 3.0F, 3.9F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3739F, -41.0035F, -3.1F, 0.0F, 0.0F, 1.2217F));

		PartDefinition cube_r8_r2 = dragon.addOrReplaceChild("cube_r8_r2", CubeListBuilder.create().texOffs(8, 3).addBox(-1.0F, -6.0F, -1.5F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3739F, -40.4036F, -0.4F, 0.0F, 0.0F, 1.2217F));

		PartDefinition cube_r9_r2 = dragon.addOrReplaceChild("cube_r9_r2", CubeListBuilder.create().texOffs(11, 6).addBox(-2.5F, 5.0F, 1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(11, 6).addBox(-2.5F, 5.0F, 5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7228F, -42.873F, -3.8F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r7_r2 = dragon.addOrReplaceChild("cube_r7_r2", CubeListBuilder.create().texOffs(7, 2).addBox(-2.5F, -6.0F, -2.5F, 3.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9228F, -43.673F, 0.0F, 0.0F, 0.0F, 1.5272F));

		PartDefinition cube_r9_r3 = dragon.addOrReplaceChild("cube_r9_r3", CubeListBuilder.create().texOffs(6, 3).addBox(-2.85F, -17.425F, -2.5F, 7.0F, 23.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3F, -19.9F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r8_r3 = dragon.addOrReplaceChild("cube_r8_r3", CubeListBuilder.create().texOffs(5, 2).addBox(-2.85F, -13.425F, -2.5F, 7.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6F, -4.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r5_r2 = dragon.addOrReplaceChild("cube_r5_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-26.6F, 1.8F, -3.0F, 25.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition dragon_tail = cube_r2.addOrReplaceChild("dragon_tail", CubeListBuilder.create(), PartPose.offsetAndRotation(38.0F, 7.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r10_r2 = dragon_tail.addOrReplaceChild("cube_r10_r2", CubeListBuilder.create().texOffs(11, 4).addBox(-4.5F, -3.5F, -1.0F, 9.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8027F, -39.364F, -0.5F, 0.0F, 0.0F, 1.6144F));

		PartDefinition cube_r12_r1 = dragon_tail.addOrReplaceChild("cube_r12_r1", CubeListBuilder.create().texOffs(18, 6).addBox(-1.5F, -3.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8711F, -43.654F, 0.1F, 0.0F, 0.0F, -0.9163F));

		PartDefinition cube_r11_r2 = dragon_tail.addOrReplaceChild("cube_r11_r2", CubeListBuilder.create().texOffs(16, 5).addBox(-2.5F, -3.0F, -0.5F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3711F, -45.554F, -0.4F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r10_r3 = dragon_tail.addOrReplaceChild("cube_r10_r3", CubeListBuilder.create().texOffs(15, 4).addBox(-2.5F, -3.0F, -1.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9711F, -45.554F, 0.1F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r9_r4 = dragon_tail.addOrReplaceChild("cube_r9_r4", CubeListBuilder.create().texOffs(14, 3).addBox(5.15F, -12.425F, -1.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1F, -42.8F, -0.4F, 0.0F, 0.0F, 0.829F));

		PartDefinition cube_r10_r4 = dragon_tail.addOrReplaceChild("cube_r10_r4", CubeListBuilder.create().texOffs(7, 3).addBox(-1.85F, -17.425F, -2.5F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3F, -19.9F, 0.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r9_r5 = dragon_tail.addOrReplaceChild("cube_r9_r5", CubeListBuilder.create().texOffs(6, 2).addBox(-1.85F, -9.425F, -2.5F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -10.8F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r6_r1 = dragon_tail.addOrReplaceChild("cube_r6_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-26.6F, 0.8F, -3.0F, 25.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(16.0F, -4.0F, -12.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -4.0F, -12.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -4.0F, -12.0F, 22.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -4.0F, -12.0F, 14.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, 2.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -12.0F, -3.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -12.0F, -3.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, 2.0F, -3.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, -12.0F, -3.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, 2.0F, -3.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -12.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, 2.0F, -3.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, -2.0F, -8.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -2.0F, -8.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -2.0F, -8.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -2.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -2.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(18.0F, -8.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-6.0F, -8.0F, -8.0F, 24.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-28.0F, -8.0F, -8.0F, 22.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-42.0F, -8.0F, -8.0F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-55.0F, -8.0F, -8.0F, 13.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition sides = Drakkar.addOrReplaceChild("sides", CubeListBuilder.create().texOffs(8, 36).addBox(-56.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-43.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-56.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-43.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, -16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(13.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-28.0F, -11.0F, -19.0F, 11.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-17.0F, -11.0F, -19.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(28.0F, -11.0F, 13.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(13.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-17.0F, -11.0F, 16.0F, 15.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-28.0F, -11.0F, 16.0F, 11.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = sides.addOrReplaceChild("cube_r4", CubeListBuilder.create(), PartPose.offsetAndRotation(35.0F, -8.0F, -9.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = sides.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 36).addBox(3.5001F, -3.0F, 35.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.4999F, -3.0F, 35.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.5001F, 3.0F, 34.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.4999F, 3.0F, 34.5F, 13.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-8.4999F, 6.0F, 34.5F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.5001F, 6.0F, 34.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(1.5001F, 9.0F, 34.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(1.5001F, 12.0F, 34.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.4999F, 12.0F, 34.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-2.4999F, 9.0F, 34.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(-9.5002F, -3.0F, -65.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 36).addBox(3.4998F, -3.0F, -65.5F, 13.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -8.0F, -3.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition steer = Drakkar.addOrReplaceChild("steer", CubeListBuilder.create().texOffs(4, 1).addBox(4.0F, 2.75F, -1.0F, 4.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 1).addBox(0.0F, -0.25F, -1.0F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(45.75F, -0.75F, 0.0F));

		PartDefinition row_L_4 = Drakkar.addOrReplaceChild("row_L_4", CubeListBuilder.create().texOffs(33, 3).addBox(-10.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r7 = row_L_4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(9, 0).addBox(-11.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-11.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_3 = Drakkar.addOrReplaceChild("row_L_3", CubeListBuilder.create().texOffs(33, 3).addBox(-10.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r8 = row_L_3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(9, 0).addBox(-11.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-11.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_2 = Drakkar.addOrReplaceChild("row_L_2", CubeListBuilder.create().texOffs(33, 3).addBox(-6.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r9 = row_L_2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(9, 0).addBox(-7.0F, 19.0F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-7.0F, 2.0F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_L_1 = Drakkar.addOrReplaceChild("row_L_1", CubeListBuilder.create().texOffs(33, 3).addBox(-2.5F, -0.5F, -28.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.5F, -12.0F, -18.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r10 = row_L_1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -23.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_1 = Drakkar.addOrReplaceChild("row_R_1", CubeListBuilder.create().texOffs(33, 3).addBox(-4.0F, -1.5F, 16.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -14.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r11 = row_R_1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(9, 0).addBox(-5.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-5.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_2 = Drakkar.addOrReplaceChild("row_R_2", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 16.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -14.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r12 = row_R_2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_3 = Drakkar.addOrReplaceChild("row_R_3", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 16.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -14.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r13 = row_R_3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition row_R_4 = Drakkar.addOrReplaceChild("row_R_4", CubeListBuilder.create().texOffs(33, 3).addBox(-2.0F, -1.5F, 16.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -14.0F, 18.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r14 = row_R_4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(9, 0).addBox(-3.0F, 18.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(9, 0).addBox(-3.0F, 1.5F, 8.0F, 1.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition mast_1 = Drakkar.addOrReplaceChild("mast_1", CubeListBuilder.create().texOffs(8, 0).addBox(-3.0F, -15.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -30.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -45.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -60.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -75.0F, -0.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-3.0F, -81.0F, -0.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -1.0F));

		PartDefinition cube_r6 = mast_1.addOrReplaceChild("cube_r6", CubeListBuilder.create(), PartPose.offsetAndRotation(-47.5F, -15.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition BannerStick = Drakkar.addOrReplaceChild("BannerStick", CubeListBuilder.create().texOffs(8, 0).addBox(12.0F, -100.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -1.0F, 0.0F));

		PartDefinition mast_oben = Drakkar.addOrReplaceChild("mast_oben", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -69.0F, -16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -69.0F, -32.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -69.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(9.0F, -69.0F, 16.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}


	@Override
	public void setupAnim(DrakkarEntity drakkarEntity, float f, float g, float h, float i, float j) {

		//this.chest_1.visible = drakkarEntity.getInvFillState() >= 15;
		//this.chest_2.visible = drakkarEntity.getInvFillState() >= 30;
		//this.chest_3.visible = drakkarEntity.getInvFillState() >= 60;
		//this.chest_4.visible = drakkarEntity.getInvFillState() >= 90;

		this.steer.yRot = -drakkarEntity.getRotSpeed() * 0.25F;

		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_1 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_2 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_3 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.LEFT, this.row_L_4 , f);

		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_1 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_2 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_3 , f);
		drakkarEntity.animatePaddle(Paddleable.PaddleSide.RIGHT, this.row_R_4 , f);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.Drakkar;
	}
}