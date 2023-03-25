package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GalleySailModel extends SailModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallShipsMod.MOD_ID, GalleyEntity.ID + "_sail_model"), "main");
    private final ModelPart GalleySail;

    public GalleySailModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.GalleySail = root.getChild("GalleySail");
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition GalleySail = partdefinition.addOrReplaceChild("GalleySail", CubeListBuilder.create(), PartPose.offset(-2.1F, 26.2F, 0.0F));

        PartDefinition Sail_4 = GalleySail.addOrReplaceChild("Sail_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, -31.0F, 2.6F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition Base1 = Sail_4.addOrReplaceChild("Base1", CubeListBuilder.create().texOffs(101, 4).addBox(2.4311F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(0.4311F, 0.2228F, 2.0974F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(-0.5689F, 2.2228F, 2.0974F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(8.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base2 = Base1.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(101, 4).addBox(6.4311F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(2.4311F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(4.4311F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(8.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(20.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(101, 4).addBox(9.4311F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(6.4311F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(7.4311F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(11.4311F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(20.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.6322F, 2.0715F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base4 = Base3.addOrReplaceChild("Base4", CubeListBuilder.create().texOffs(101, 4).addBox(12.4311F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(9.4311F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(11.4311F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(14.4311F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(32.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base5 = Base4.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(101, 4).addBox(14.4311F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(15.4311F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(13.4311F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(16.4311F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base6 = Base5.addOrReplaceChild("Base6", CubeListBuilder.create().texOffs(101, 4).addBox(18.4311F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(16.4311F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(19.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(18.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(19.4311F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(17.4311F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(24.4311F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(32.4311F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base7 = Base6.addOrReplaceChild("Base7", CubeListBuilder.create().texOffs(101, 4).addBox(21.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(22.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(27.4311F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base8 = Base7.addOrReplaceChild("Base8", CubeListBuilder.create().texOffs(101, 4).addBox(24.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(25.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 0).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base9 = Base8.addOrReplaceChild("Base9", CubeListBuilder.create().texOffs(101, 4).addBox(27.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(28.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create().texOffs(101, 4).addBox(31.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base11 = Base10.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(101, 4).addBox(35.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(35.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(101, 4).addBox(38.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(38.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base13 = Base12.addOrReplaceChild("Base13", CubeListBuilder.create().texOffs(101, 4).addBox(41.4311F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(41.4311F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(43.4311F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base14 = Base13.addOrReplaceChild("Base14", CubeListBuilder.create().texOffs(101, 4).addBox(56.4311F, -4.4264F, 2.0629F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base15 = Base14.addOrReplaceChild("Base15", CubeListBuilder.create().texOffs(101, 4).addBox(42.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base16 = Base15.addOrReplaceChild("Base16", CubeListBuilder.create().texOffs(101, 4).addBox(48.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(46.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(50.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base17 = Base16.addOrReplaceChild("Base17", CubeListBuilder.create().texOffs(101, 4).addBox(51.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(51.4311F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(49.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(53.4311F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base18 = Base17.addOrReplaceChild("Base18", CubeListBuilder.create().texOffs(101, 4).addBox(53.4311F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(54.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create().texOffs(101, 4).addBox(55.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(57.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(61.4311F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(59.4311F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(58.4311F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Sail_3 = GalleySail.addOrReplaceChild("Sail_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, -31.0F, 2.6F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition Base20 = Sail_3.addOrReplaceChild("Base20", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base21 = Base20.addOrReplaceChild("Base21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base22 = Base21.addOrReplaceChild("Base22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create().texOffs(101, 4).addBox(12.4311F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(9.4311F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(11.4311F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(14.4311F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(32.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base24 = Base23.addOrReplaceChild("Base24", CubeListBuilder.create().texOffs(101, 4).addBox(14.4311F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(15.4311F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(13.4311F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(16.4311F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create().texOffs(101, 4).addBox(18.4311F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(16.4311F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(19.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(18.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(19.4311F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(17.4311F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(24.4311F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(32.4311F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(101, 4).addBox(21.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(22.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(27.4311F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base27 = Base26.addOrReplaceChild("Base27", CubeListBuilder.create().texOffs(101, 4).addBox(24.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(25.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 0).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base28 = Base27.addOrReplaceChild("Base28", CubeListBuilder.create().texOffs(101, 4).addBox(27.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(28.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base29 = Base28.addOrReplaceChild("Base29", CubeListBuilder.create().texOffs(101, 4).addBox(31.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base30 = Base29.addOrReplaceChild("Base30", CubeListBuilder.create().texOffs(101, 4).addBox(35.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(35.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base31 = Base30.addOrReplaceChild("Base31", CubeListBuilder.create().texOffs(101, 4).addBox(38.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(38.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base32 = Base31.addOrReplaceChild("Base32", CubeListBuilder.create().texOffs(101, 4).addBox(41.4311F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(41.4311F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(43.4311F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base33 = Base32.addOrReplaceChild("Base33", CubeListBuilder.create().texOffs(101, 4).addBox(56.4311F, -4.4264F, 2.0629F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base34 = Base33.addOrReplaceChild("Base34", CubeListBuilder.create().texOffs(101, 4).addBox(42.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base35 = Base34.addOrReplaceChild("Base35", CubeListBuilder.create().texOffs(101, 4).addBox(48.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(46.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(50.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base36 = Base35.addOrReplaceChild("Base36", CubeListBuilder.create().texOffs(101, 4).addBox(51.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(51.4311F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(49.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(53.4311F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base37 = Base36.addOrReplaceChild("Base37", CubeListBuilder.create().texOffs(101, 4).addBox(53.4311F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(54.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base38 = Base37.addOrReplaceChild("Base38", CubeListBuilder.create().texOffs(101, 4).addBox(55.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(57.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(61.4311F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(59.4311F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(58.4311F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition bone = Sail_3.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(14.4632F, -13.7947F, 0.1047F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 2).addBox(70.9385F, -11.676F, -3.1522F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(60.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(50.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(40.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(30.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(20.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition Sail_2 = GalleySail.addOrReplaceChild("Sail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, -31.0F, 2.6F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition Base39 = Sail_2.addOrReplaceChild("Base39", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base40 = Base39.addOrReplaceChild("Base40", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base41 = Base40.addOrReplaceChild("Base41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base42 = Base41.addOrReplaceChild("Base42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base43 = Base42.addOrReplaceChild("Base43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base44 = Base43.addOrReplaceChild("Base44", CubeListBuilder.create().texOffs(101, 4).addBox(19.4311F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base45 = Base44.addOrReplaceChild("Base45", CubeListBuilder.create().texOffs(101, 4).addBox(21.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(22.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(20.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(27.4311F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base46 = Base45.addOrReplaceChild("Base46", CubeListBuilder.create().texOffs(101, 4).addBox(24.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(25.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(23.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 0).addBox(32.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 3).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base47 = Base46.addOrReplaceChild("Base47", CubeListBuilder.create().texOffs(101, 4).addBox(27.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(28.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(26.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base48 = Base47.addOrReplaceChild("Base48", CubeListBuilder.create().texOffs(101, 4).addBox(31.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(29.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(30.4311F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base49 = Base48.addOrReplaceChild("Base49", CubeListBuilder.create().texOffs(101, 4).addBox(35.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(35.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(36.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(32.4311F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(33.4311F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base50 = Base49.addOrReplaceChild("Base50", CubeListBuilder.create().texOffs(101, 4).addBox(38.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(38.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base51 = Base50.addOrReplaceChild("Base51", CubeListBuilder.create().texOffs(101, 4).addBox(41.4311F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(41.4311F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(43.4311F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base52 = Base51.addOrReplaceChild("Base52", CubeListBuilder.create().texOffs(101, 4).addBox(56.4311F, -4.4264F, 2.0629F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base53 = Base52.addOrReplaceChild("Base53", CubeListBuilder.create().texOffs(101, 4).addBox(42.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base54 = Base53.addOrReplaceChild("Base54", CubeListBuilder.create().texOffs(101, 4).addBox(48.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(46.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(50.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base55 = Base54.addOrReplaceChild("Base55", CubeListBuilder.create().texOffs(101, 4).addBox(51.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(51.4311F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(49.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(53.4311F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base56 = Base55.addOrReplaceChild("Base56", CubeListBuilder.create().texOffs(101, 4).addBox(53.4311F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(54.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base57 = Base56.addOrReplaceChild("Base57", CubeListBuilder.create().texOffs(101, 4).addBox(55.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(57.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(61.4311F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(59.4311F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(58.4311F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition bone2 = Sail_2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(15.2632F, -24.8947F, -1.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(97, 2).addBox(70.9385F, -11.676F, -3.1522F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(60.9385F, -11.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(50.9385F, -11.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(40.9385F, -11.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(30.9385F, -11.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition Sail_1 = GalleySail.addOrReplaceChild("Sail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0F, -31.0F, 2.6F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition Base58 = Sail_1.addOrReplaceChild("Base58", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base59 = Base58.addOrReplaceChild("Base59", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base60 = Base59.addOrReplaceChild("Base60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base61 = Base60.addOrReplaceChild("Base61", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base62 = Base61.addOrReplaceChild("Base62", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base63 = Base62.addOrReplaceChild("Base63", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base64 = Base63.addOrReplaceChild("Base64", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base65 = Base64.addOrReplaceChild("Base65", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base66 = Base65.addOrReplaceChild("Base66", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base67 = Base66.addOrReplaceChild("Base67", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base68 = Base67.addOrReplaceChild("Base68", CubeListBuilder.create().texOffs(101, 4).addBox(36.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base69 = Base68.addOrReplaceChild("Base69", CubeListBuilder.create().texOffs(101, 4).addBox(38.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(38.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(39.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(37.4311F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(104, 4).addBox(56.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base70 = Base69.addOrReplaceChild("Base70", CubeListBuilder.create().texOffs(101, 4).addBox(41.4311F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(41.4311F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(40.4311F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(43.4311F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base71 = Base70.addOrReplaceChild("Base71", CubeListBuilder.create().texOffs(101, 4).addBox(56.4311F, -4.4264F, 2.0629F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base72 = Base71.addOrReplaceChild("Base72", CubeListBuilder.create().texOffs(101, 4).addBox(42.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(44.4311F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base73 = Base72.addOrReplaceChild("Base73", CubeListBuilder.create().texOffs(101, 4).addBox(48.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(48.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(46.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(50.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base74 = Base73.addOrReplaceChild("Base74", CubeListBuilder.create().texOffs(101, 4).addBox(51.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(51.4311F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(49.4311F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(53.4311F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base75 = Base74.addOrReplaceChild("Base75", CubeListBuilder.create().texOffs(101, 4).addBox(53.4311F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(54.4311F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(56.4311F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base76 = Base75.addOrReplaceChild("Base76", CubeListBuilder.create().texOffs(101, 4).addBox(55.4311F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(57.4311F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(61.4311F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(59.4311F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 4).addBox(58.4311F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition bone3 = Sail_1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(22.2632F, -32.8947F, -3.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(97, 2).addBox(59.9385F, -23.676F, -3.1522F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(49.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(39.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition Sail_0 = GalleySail.addOrReplaceChild("Sail_0", CubeListBuilder.create(), PartPose.offset(-25.9F, -32.2F, 3.0F));

        PartDefinition bone4 = Sail_0.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3333F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r4 = bone4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(97, 2).addBox(-20.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(-12.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(-28.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(44.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(34.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(24.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(14.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(4.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(-48.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 2).addBox(-38.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(45.6667F, -7.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(Ship briggEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        switch (briggEntity.getData(Ship.SAIL_STATE)) {
            case 0 -> {
                this.GalleySail.getChild("Sail_0").visible = true;
                this.GalleySail.getChild("Sail_1").visible = false;
                this.GalleySail.getChild("Sail_2").visible = false;
                this.GalleySail.getChild("Sail_3").visible = false;
                this.GalleySail.getChild("Sail_4").visible = false;
            }
            case 1 -> {
                this.GalleySail.getChild("Sail_0").visible = false;
                this.GalleySail.getChild("Sail_1").visible = true;
                this.GalleySail.getChild("Sail_2").visible = false;
                this.GalleySail.getChild("Sail_3").visible = false;
                this.GalleySail.getChild("Sail_4").visible = false;
            }
            case 2 -> {
                this.GalleySail.getChild("Sail_0").visible = false;
                this.GalleySail.getChild("Sail_1").visible = false;
                this.GalleySail.getChild("Sail_2").visible = true;
                this.GalleySail.getChild("Sail_3").visible = false;
                this.GalleySail.getChild("Sail_4").visible = false;
            }
            case 3 -> {
                this.GalleySail.getChild("Sail_0").visible = false;
                this.GalleySail.getChild("Sail_1").visible = false;
                this.GalleySail.getChild("Sail_2").visible = false;
                this.GalleySail.getChild("Sail_3").visible = true;
                this.GalleySail.getChild("Sail_4").visible = false;
            }
            case 4 -> {
                this.GalleySail.getChild("Sail_0").visible = false;
                this.GalleySail.getChild("Sail_1").visible = false;
                this.GalleySail.getChild("Sail_2").visible = false;
                this.GalleySail.getChild("Sail_3").visible = false;
                this.GalleySail.getChild("Sail_4").visible = true;
            }
        }
    }

    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        GalleySail.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}
