package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
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
public class CogSailBannerModel extends SailBannerModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, CogEntity.ID + "_sail_banner_model"), "main");

    public CogSailBannerModel() {
        super(createBodyLayer());
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition CogSailBanner = partdefinition.addOrReplaceChild("CogSailBanner", CubeListBuilder.create(), PartPose.offset(-11.325F, 24.0F, -6.6F));

        PartDefinition segment_0 = CogSailBanner.addOrReplaceChild("segment_0", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, -4.7F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.55F, -62.2F, -4.4F, 0.0F, 0.0F, 0.7418F));

        PartDefinition segment_1 = segment_0.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.0F, 0.0F, -0.2531F));

        PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.2443F));

        PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(3, 3).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

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