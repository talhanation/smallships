package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class DhowSailBannerModel extends SailBannerModel {
	@SuppressWarnings("unused")
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DhowEntity.ID + "_sail_banner_model"), "main");

	public DhowSailBannerModel() {
		super(createBodyLayer());
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition DhowSailBanner = partdefinition.addOrReplaceChild("DhowSailBanner", CubeListBuilder.create(), PartPose.offsetAndRotation(-42.125F, -17.175F, 9.6F, 0.2443F, -0.8858F, 0.0F));

		PartDefinition segment_0 = DhowSailBanner.addOrReplaceChild("segment_0", CubeListBuilder.create().texOffs(1, 1).addBox(21.2008F, -21.7469F, 2.7465F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.3563F, -17.6357F, -7.0932F, 0.1484F, -0.1571F, 0.0F));

		PartDefinition segment_1 = segment_0.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(1, 5).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.2302F, -17.322F, -0.4175F));

		PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(1, 9).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(1, 13).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(1, 17).addBox(28.431F, -0.5292F, 3.1686F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0262F, 0.0F, 0.0F));

		PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(1, 21).addBox(28.431F, -0.6352F, 3.1744F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(1, 25).addBox(28.431F, -0.6337F, 3.198F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0087F, 0.0F, 0.0F));

		PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(1, 29).addBox(28.431F, -0.6322F, 3.2465F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0087F, 0.0F, 0.0F));

		PartDefinition segment_8 = segment_7.addOrReplaceChild("segment_8", CubeListBuilder.create().texOffs(1, 33).addBox(28.431F, -0.7383F, 3.2523F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition segment_9 = segment_8.addOrReplaceChild("segment_9", CubeListBuilder.create().texOffs(1, 37).addBox(28.431F, -1.0772F, 3.1974F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition DhowSailBanner2 = partdefinition.addOrReplaceChild("DhowSailBanner2", CubeListBuilder.create(), PartPose.offsetAndRotation(13.875F, -17.175F, 9.6F, 0.2443F, -0.8858F, 0.0F));

		PartDefinition segment_10 = DhowSailBanner2.addOrReplaceChild("segment_10", CubeListBuilder.create().texOffs(1, 1).addBox(47.5191F, -49.6195F, 4.8178F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-46.6746F, 10.2369F, -9.1645F, 0.1484F, -0.1571F, 0.0F));

		PartDefinition segment_11 = segment_10.addOrReplaceChild("segment_11", CubeListBuilder.create().texOffs(1, 5).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(19.0881F, -45.1946F, 1.6538F));

		PartDefinition segment_12 = segment_11.addOrReplaceChild("segment_12", CubeListBuilder.create().texOffs(1, 9).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition segment_13 = segment_12.addOrReplaceChild("segment_13", CubeListBuilder.create().texOffs(1, 13).addBox(28.431F, -0.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition segment_14 = segment_13.addOrReplaceChild("segment_14", CubeListBuilder.create().texOffs(1, 17).addBox(28.431F, -0.5292F, 3.1686F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0262F, 0.0F, 0.0F));

		PartDefinition segment_15 = segment_14.addOrReplaceChild("segment_15", CubeListBuilder.create().texOffs(1, 21).addBox(28.431F, -0.6352F, 3.1744F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition segment_16 = segment_15.addOrReplaceChild("segment_16", CubeListBuilder.create().texOffs(1, 25).addBox(28.431F, -0.6337F, 3.198F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0087F, 0.0F, 0.0F));

		PartDefinition segment_17 = segment_16.addOrReplaceChild("segment_17", CubeListBuilder.create().texOffs(1, 29).addBox(28.431F, -0.6322F, 3.2465F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0087F, 0.0F, 0.0F));

		PartDefinition segment_18 = segment_17.addOrReplaceChild("segment_18", CubeListBuilder.create().texOffs(1, 33).addBox(28.431F, -0.7383F, 3.2523F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition segment_19 = segment_18.addOrReplaceChild("segment_19", CubeListBuilder.create().texOffs(1, 37).addBox(28.431F, -1.0772F, 3.1974F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	@Override
	protected boolean isSegmentVisible(@NotNull Ship ship, int groupIndex, int segment) {
		switch (ship.getData(Ship.SAIL_STATE)) {
			case 0 -> {
				return false;
			}
			case 1 -> {
				return segment == 0;
			}
			case 2 -> {
				return segment == 0 || segment == 1 || segment == 2;
			}
			case 3 -> {
				return segment == 0 || segment == 1 || segment == 2 || segment == 3 || segment == 4;
			}
		}
		return true;
	}
}