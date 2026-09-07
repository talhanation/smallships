package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Banner surface for the Cog sail: one group of 8 strips of 20x5 model pixels,
 * chained top to bottom along the sail curvature. Everything below
 * {@code createBodyLayer} is the unchanged Blockbench export, the UVs of the
 * export are unused - see {@link SailBannerModel}.
 */
public class GalleonSailBannerModel extends SailBannerModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, BriggEntity.ID + "_sail_banner_model"), "main");

    public GalleonSailBannerModel() {
        super(createBodyLayer());
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition GalleonSailBanner = partdefinition.addOrReplaceChild("GalleonSailBanner", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition segment_0 = GalleonSailBanner.addOrReplaceChild("segment_0", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -6.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.9596F, -101.3721F, -0.1376F, -0.6981F, 1.5708F, 0.0F));

        PartDefinition segment_1 = segment_0.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -8.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7048F, 1.374F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, 2.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.1433F, -0.3625F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, 0.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.8264F, -0.0152F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -1.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.8112F, 0.1584F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -1.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.8112F, 0.1584F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, 3.0F, -1.12F, 20.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8719F, -0.5361F, 0.1745F, 0.0F, 0.0F));

        PartDefinition GalleonSailBanner2 = partdefinition.addOrReplaceChild("GalleonSailBanner2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition segment_10 = GalleonSailBanner2.addOrReplaceChild("segment_10", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -2.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-62.59F, -90.8159F, -0.1376F, -0.7854F, 1.5708F, 0.0F));

        PartDefinition segment_11 = segment_10.addOrReplaceChild("segment_11", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_12 = segment_11.addOrReplaceChild("segment_12", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_13 = segment_12.addOrReplaceChild("segment_13", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_14 = segment_13.addOrReplaceChild("segment_14", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_15 = segment_14.addOrReplaceChild("segment_15", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_16 = segment_15.addOrReplaceChild("segment_16", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_17 = segment_16.addOrReplaceChild("segment_17", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_18 = segment_17.addOrReplaceChild("segment_18", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

        PartDefinition segment_19 = segment_18.addOrReplaceChild("segment_19", CubeListBuilder.create().texOffs(1, 1).addBox(-10.0F, -4.0F, -1.12F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7656F, 0.6794F, 0.1745F, 0.0F, 0.0F));

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