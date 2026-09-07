package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
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
public class BriggSailBannerModel extends SailBannerModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, BriggEntity.ID + "_sail_banner_model"), "main");

    public BriggSailBannerModel() {
        super(createBodyLayer());
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition BriggSailBanner2 = partdefinition.addOrReplaceChild("BriggSailBanner2", CubeListBuilder.create(), PartPose.offset(0.075F, 24.0F, 0.0F));

        PartDefinition segment_2 = BriggSailBanner2.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(1, 1).addBox(-40.0F, -3.1128F, -0.6559F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8572F, -69.9941F, -29.5F, -0.48F, 1.5708F, 0.0F));

        PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(1, 6).addBox(-40.0F, -1.5311F, -0.5387F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3958F, 0.0447F, 0.1309F, 0.0F, 0.0F));

        PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(1, 11).addBox(-40.0F, -1.8678F, -1.2087F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9137F, 1.2066F, 0.3054F, 0.0F, 0.0F));

        PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(1, 16).addBox(-40.0F, -2.25F, -1.37F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8968F, 0.5658F, 0.2182F, 0.0F, 0.0F));

        PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(1, 21).addBox(-40.0F, -3.2888F, 0.63F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.1162F, -1.5076F, 0.1309F, 0.0F, 0.0F));

        PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(1, 26).addBox(-40.0F, -1.5F, -1.12F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9377F, 2.0918F, 0.1833F, 0.0F, 0.0F));

        PartDefinition segment_16 = segment_7.addOrReplaceChild("segment_16", CubeListBuilder.create().texOffs(1, 31).addBox(-40.0F, -2.9522F, -0.5719F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2769F, -0.0776F, 0.1632F, 0.0F, 0.0F));

        PartDefinition segment_17 = segment_16.addOrReplaceChild("segment_17", CubeListBuilder.create().texOffs(1, 36).addBox(-40.0F, -1.9263F, -2.5129F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7314F, 2.2669F, 0.1335F, 0.0F, 0.0F));

        PartDefinition BriggSailBanner = partdefinition.addOrReplaceChild("BriggSailBanner", CubeListBuilder.create(), PartPose.offset(0.075F, 24.0F, 0.0F));

        PartDefinition segment_0 = BriggSailBanner.addOrReplaceChild("segment_0", CubeListBuilder.create().texOffs(1, 1).addBox(-40.0F, 16.6372F, -38.9059F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8572F, -69.9941F, -29.5F, -0.48F, 1.5708F, 0.0F));

        PartDefinition segment_1 = segment_0.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(1, 6).addBox(-40.0F, 13.0289F, -41.0787F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3958F, 0.0447F, 0.1309F, 0.0F, 0.0F));

        PartDefinition segment_18 = segment_1.addOrReplaceChild("segment_18", CubeListBuilder.create().texOffs(1, 11).addBox(-40.0F, -0.1178F, -44.2087F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.9137F, 1.2066F, 0.3054F, 0.0F, 0.0F));

        PartDefinition segment_19 = segment_18.addOrReplaceChild("segment_19", CubeListBuilder.create().texOffs(1, 16).addBox(-40.0F, -9.75F, -43.62F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.8968F, 0.5658F, 0.2182F, 0.0F, 0.0F));

        PartDefinition segment_20 = segment_19.addOrReplaceChild("segment_20", CubeListBuilder.create().texOffs(1, 21).addBox(-40.0F, -16.2888F, -40.37F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.1162F, -1.5076F, 0.1309F, 0.0F, 0.0F));

        PartDefinition segment_21 = segment_20.addOrReplaceChild("segment_21", CubeListBuilder.create().texOffs(1, 26).addBox(-40.0F, -21.6905F, -39.12F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9377F, 2.0918F, 0.1833F, 0.0F, 0.0F));

        PartDefinition segment_22 = segment_21.addOrReplaceChild("segment_22", CubeListBuilder.create().texOffs(1, 31).addBox(-40.0F, -28.9822F, -34.8219F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2769F, -0.0776F, 0.1632F, 0.0F, 0.0F));

        PartDefinition segment_23 = segment_22.addOrReplaceChild("segment_23", CubeListBuilder.create().texOffs(1, 36).addBox(-40.0F, -32.4263F, -33.0129F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.7314F, 2.2669F, 0.1335F, 0.0F, 0.0F));

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