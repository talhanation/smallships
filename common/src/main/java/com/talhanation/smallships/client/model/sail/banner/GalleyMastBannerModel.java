package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

/**
 * Mast flag of the Cog: a banner surface of 8 strips of 20x5 model pixels,
 * turned by -90 degrees so the flag streams horizontally away from the mast,
 * 40 long and 20 high.
 * <p>
 * Same bounds as the single box of the Blockbench export
 * {@code ModelCogMastBanner} - the cloth reaches from 0.5 to 40.5 in front of
 * the pivot and from -10 to 10 across it - only split into strips so the wave
 * can travel along it. See {@link MastBannerModel} for the conventions.
 */
public class GalleyMastBannerModel extends MastBannerModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, GalleyEntity.ID + "_mast_banner_model"), "main");

    public GalleyMastBannerModel() {
        super(createBodyLayer());
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition GalleyMastBanner = partdefinition.addOrReplaceChild("GalleyMastBanner", CubeListBuilder.create(), PartPose.offset(2.5F, -63.0F, 0.0F));

        PartDefinition cloth = GalleyMastBanner.addOrReplaceChild("cloth", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition segment_8 = cloth.addOrReplaceChild("segment_8", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition segment_9 = segment_8.addOrReplaceChild("segment_9", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_10 = segment_9.addOrReplaceChild("segment_10", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_11 = segment_10.addOrReplaceChild("segment_11", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_12 = segment_11.addOrReplaceChild("segment_12", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_13 = segment_12.addOrReplaceChild("segment_13", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_14 = segment_13.addOrReplaceChild("segment_14", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition segment_15 = segment_14.addOrReplaceChild("segment_15", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

}