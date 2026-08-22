package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
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
public class GalleySailBannerModel extends SailBannerModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, GalleyEntity.ID + "_sail_banner_model"), "main");

    public GalleySailBannerModel() {
        super(createBodyLayer());
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition GalleySailBanner = partdefinition.addOrReplaceChild("GalleySailBanner", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.3F, -7.6F, 7.3F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition segment_0 = GalleySailBanner.addOrReplaceChild("segment_0", CubeListBuilder.create().texOffs(1, 37).addBox(28.431F, -0.8772F, 3.1974F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition segment_1 = segment_0.addOrReplaceChild("segment_1", CubeListBuilder.create().texOffs(1, 33).addBox(28.431F, -4.7383F, 3.2523F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition segment_2 = segment_1.addOrReplaceChild("segment_2", CubeListBuilder.create().texOffs(1, 29).addBox(28.431F, -4.6322F, 3.2465F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition segment_3 = segment_2.addOrReplaceChild("segment_3", CubeListBuilder.create().texOffs(1, 25).addBox(28.431F, -4.6337F, 3.198F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition segment_4 = segment_3.addOrReplaceChild("segment_4", CubeListBuilder.create().texOffs(1, 21).addBox(28.431F, -4.6352F, 3.1744F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition segment_5 = segment_4.addOrReplaceChild("segment_5", CubeListBuilder.create().texOffs(1, 17).addBox(28.431F, -4.5292F, 3.1686F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition segment_6 = segment_5.addOrReplaceChild("segment_6", CubeListBuilder.create().texOffs(1, 13).addBox(28.431F, -4.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition segment_7 = segment_6.addOrReplaceChild("segment_7", CubeListBuilder.create().texOffs(1, 9).addBox(28.431F, -4.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition segment_8 = segment_7.addOrReplaceChild("segment_8", CubeListBuilder.create().texOffs(1, 5).addBox(28.431F, -4.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition segment_9 = segment_8.addOrReplaceChild("segment_9", CubeListBuilder.create().texOffs(1, 1).addBox(28.431F, -4.4249F, 3.164F, 20.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

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