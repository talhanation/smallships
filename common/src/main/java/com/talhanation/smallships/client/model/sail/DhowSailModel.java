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

public class DhowSailModel extends SailModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, CogEntity.ID + "_sail_model"), "main");

    private final ModelPart DhowSail;

    public DhowSailModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.DhowSail = root.getChild("DhowSail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition DhowSail_1 = partdefinition.addOrReplaceChild("DhowSail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1F, 9.6F, -32.0F, 0.0F, -2.1817F, 0.0F));

        PartDefinition sail_1_4 = DhowSail_1.addOrReplaceChild("sail_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_4_sail = sail_1_4.addOrReplaceChild("sail_1_4_sail", CubeListBuilder.create().texOffs(64, 9).addBox(-7.569F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-9.569F, 0.2228F, 2.0974F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-10.569F, 2.2228F, 2.0974F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 43).addBox(10.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(46.431F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base2 = sail_1_4_sail.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(118, 2).addBox(-3.569F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 4).addBox(-7.569F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-5.569F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 9).addBox(46.431F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(118, 2).addBox(-0.569F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-3.569F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-2.569F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(1.431F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(34.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 2).addBox(46.431F, -4.6322F, 2.0715F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition sail_1_3 = DhowSail_1.addOrReplaceChild("sail_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_3_sail = sail_1_3.addOrReplaceChild("sail_1_3_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base21 = sail_1_3_sail.addOrReplaceChild("Base21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base22 = Base21.addOrReplaceChild("Base22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create().texOffs(118, 3).addBox(2.431F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(-0.569F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(1.431F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 54).addBox(4.431F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(10.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(22.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 41).addBox(34.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 29).addBox(46.431F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base24 = Base23.addOrReplaceChild("Base24", CubeListBuilder.create().texOffs(118, 3).addBox(4.431F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(5.431F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(3.431F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(6.431F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 42).addBox(10.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 47).addBox(22.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(99, 28).addBox(34.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 29).addBox(46.431F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create().texOffs(118, 3).addBox(8.431F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(6.431F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(8.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.4311F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(7.431F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 42).addBox(10.4311F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(14.4311F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 36).addBox(22.4311F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 39).addBox(34.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 20).addBox(46.431F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(118, 3).addBox(11.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(12.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(10.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 52).addBox(13.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 25).addBox(17.4311F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 8).addBox(22.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 16).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 29).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition sail_1_3_bottom = sail_1_3.addOrReplaceChild("sail_1_3_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(14.4632F, -13.7947F, 0.1047F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r1 = sail_1_3_bottom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 28).addBox(60.9385F, -11.676F, -3.1522F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(88, 8).addBox(50.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(78, 24).addBox(40.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 19).addBox(30.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(93, 37).addBox(20.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(10.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_1_2 = DhowSail_1.addOrReplaceChild("sail_1_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_2_sail = sail_1_2.addOrReplaceChild("sail_1_2_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base40 = sail_1_2_sail.addOrReplaceChild("Base40", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base41 = Base40.addOrReplaceChild("Base41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base42 = Base41.addOrReplaceChild("Base42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base43 = Base42.addOrReplaceChild("Base43", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base44 = Base43.addOrReplaceChild("Base44", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base45 = Base44.addOrReplaceChild("Base45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base46 = Base45.addOrReplaceChild("Base46", CubeListBuilder.create().texOffs(118, 3).addBox(14.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(15.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(13.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 23).addBox(16.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.4311F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 6).addBox(22.4311F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 51).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 40).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base47 = Base46.addOrReplaceChild("Base47", CubeListBuilder.create().texOffs(118, 3).addBox(17.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(18.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(16.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 33).addBox(19.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(95, 16).addBox(23.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 39).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 37).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base48 = Base47.addOrReplaceChild("Base48", CubeListBuilder.create().texOffs(118, 3).addBox(21.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(19.4311F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.4311F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 59).addBox(23.4311F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 59).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 59).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base49 = Base48.addOrReplaceChild("Base49", CubeListBuilder.create().texOffs(118, 3).addBox(25.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(26.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(25.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.4311F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.4311F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.4311F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 59).addBox(27.4311F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 44).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_1_2_bottom = sail_1_2.addOrReplaceChild("sail_1_2_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(15.2632F, -24.8947F, -1.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r2 = sail_1_2_bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 33).addBox(53.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(43.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(33.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(22.9385F, -16.676F, -3.1522F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_1_1 = DhowSail_1.addOrReplaceChild("sail_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_1_sail = sail_1_1.addOrReplaceChild("sail_1_1_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base59 = sail_1_1_sail.addOrReplaceChild("Base59", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base60 = Base59.addOrReplaceChild("Base60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base61 = Base60.addOrReplaceChild("Base61", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base62 = Base61.addOrReplaceChild("Base62", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base63 = Base62.addOrReplaceChild("Base63", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base64 = Base63.addOrReplaceChild("Base64", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base65 = Base64.addOrReplaceChild("Base65", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base66 = Base65.addOrReplaceChild("Base66", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base67 = Base66.addOrReplaceChild("Base67", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base68 = Base67.addOrReplaceChild("Base68", CubeListBuilder.create().texOffs(118, 3).addBox(26.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base69 = Base68.addOrReplaceChild("Base69", CubeListBuilder.create().texOffs(118, 3).addBox(28.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(28.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.4311F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(27.4311F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(30.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 57).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 18).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base70 = Base69.addOrReplaceChild("Base70", CubeListBuilder.create().texOffs(118, 3).addBox(31.4311F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(31.4311F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(30.4311F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 52).addBox(33.431F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 47).addBox(38.431F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(46.431F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base71 = Base70.addOrReplaceChild("Base71", CubeListBuilder.create().texOffs(65, 37).addBox(46.431F, -4.4264F, 2.063F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base72 = Base71.addOrReplaceChild("Base72", CubeListBuilder.create().texOffs(118, 3).addBox(32.431F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 32).addBox(34.431F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 10).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base73 = Base72.addOrReplaceChild("Base73", CubeListBuilder.create().texOffs(118, 3).addBox(38.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(38.431F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(36.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(40.431F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 23).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base74 = Base73.addOrReplaceChild("Base74", CubeListBuilder.create().texOffs(118, 3).addBox(41.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(41.431F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(39.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(43.431F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 36).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base75 = Base74.addOrReplaceChild("Base75", CubeListBuilder.create().texOffs(118, 3).addBox(43.431F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(44.431F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 15).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base76 = Base75.addOrReplaceChild("Base76", CubeListBuilder.create().texOffs(118, 3).addBox(45.431F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 24).addBox(47.431F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(51.431F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(49.431F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(48.431F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_1_1_bottom = sail_1_1.addOrReplaceChild("sail_1_1_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(22.2632F, -32.8947F, -3.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r6 = sail_1_1_bottom.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(81, 19).addBox(49.9385F, -23.676F, -3.1522F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 43).addBox(39.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(88, 52).addBox(29.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_1_0 = DhowSail_1.addOrReplaceChild("sail_1_0", CubeListBuilder.create(), PartPose.offset(-25.3F, -33.2F, 3.1F));

        PartDefinition sail_1_0_sail = sail_1_0.addOrReplaceChild("sail_1_0_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3333F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r7 = sail_1_0_sail.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(71, 13).addBox(-30.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(71, 41).addBox(-14.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(71, 31).addBox(-22.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(102, 1).addBox(-38.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 18).addBox(34.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 29).addBox(24.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 41).addBox(14.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 50).addBox(4.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(69, 52).addBox(-6.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(65, 11).addBox(-58.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 13).addBox(-48.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(45.6667F, -7.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition ropes_1 = DhowSail_1.addOrReplaceChild("ropes_1", CubeListBuilder.create(), PartPose.offset(61.2F, -25.0F, 3.1F));

        PartDefinition rope_1_1 = ropes_1.addOrReplaceChild("rope_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, 11.0F, 14.0F, 0.3927F, -0.9512F, 0.0F));

        PartDefinition cube_r19 = rope_1_1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(13, 26).addBox(24.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(54.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(74.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(39.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(12.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(12.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 21).addBox(1.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r20 = rope_1_1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-8.75F, -8.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r21 = rope_1_1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(10, 0).addBox(-8.5F, -8.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition DhowSail_2 = partdefinition.addOrReplaceChild("DhowSail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 10.0F, 24.0F, 0.0F, -2.1817F, 0.0F));

        PartDefinition sail_2_4 = DhowSail_2.addOrReplaceChild("sail_2_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -27.1F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_4_sail = sail_2_4.addOrReplaceChild("sail_2_4_sail", CubeListBuilder.create().texOffs(64, 9).addBox(-7.569F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-9.569F, 0.2228F, 2.0974F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-10.569F, 2.2228F, 2.0974F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 43).addBox(10.4311F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(46.431F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base5 = sail_2_4_sail.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(118, 2).addBox(-3.569F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 4).addBox(-7.569F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-5.569F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.4311F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 9).addBox(46.431F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base6 = Base5.addOrReplaceChild("Base6", CubeListBuilder.create().texOffs(118, 2).addBox(-0.569F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-3.569F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-2.569F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(1.431F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.4311F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 0).addBox(34.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 2).addBox(46.431F, -4.6322F, 2.0715F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition sail_2_3 = DhowSail_2.addOrReplaceChild("sail_2_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -27.1F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_3_sail = sail_2_3.addOrReplaceChild("sail_2_3_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base7 = sail_2_3_sail.addOrReplaceChild("Base7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base8 = Base7.addOrReplaceChild("Base8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base9 = Base8.addOrReplaceChild("Base9", CubeListBuilder.create().texOffs(118, 3).addBox(2.431F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(-0.569F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(1.431F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 54).addBox(4.431F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(10.4311F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(22.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 41).addBox(34.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 29).addBox(46.431F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create().texOffs(118, 3).addBox(4.431F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(5.431F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(3.431F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(6.431F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 42).addBox(10.4311F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 47).addBox(22.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(99, 28).addBox(34.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 29).addBox(46.431F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base11 = Base10.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(118, 3).addBox(8.431F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(6.431F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.4311F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(8.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.4311F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(7.431F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 42).addBox(10.4311F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(14.4311F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 36).addBox(22.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 39).addBox(34.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 20).addBox(46.431F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(118, 3).addBox(11.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(12.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(10.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 52).addBox(13.4311F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 25).addBox(17.431F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 8).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 16).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 29).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition sail_2_3_bottom = sail_2_3.addOrReplaceChild("sail_2_3_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(14.4632F, -13.7947F, 0.1047F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r8 = sail_2_3_bottom.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(66, 28).addBox(60.9385F, -11.676F, -3.1522F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(88, 8).addBox(50.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(78, 24).addBox(40.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 19).addBox(30.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(93, 37).addBox(20.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(10.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_2_2 = DhowSail_2.addOrReplaceChild("sail_2_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -27.1F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_2_sail = sail_2_2.addOrReplaceChild("sail_2_2_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base13 = sail_2_2_sail.addOrReplaceChild("Base13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base14 = Base13.addOrReplaceChild("Base14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base15 = Base14.addOrReplaceChild("Base15", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base16 = Base15.addOrReplaceChild("Base16", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base17 = Base16.addOrReplaceChild("Base17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base18 = Base17.addOrReplaceChild("Base18", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create().texOffs(118, 3).addBox(14.4311F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(15.4311F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(13.4311F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 23).addBox(16.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 6).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 51).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 40).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base20 = Base19.addOrReplaceChild("Base20", CubeListBuilder.create().texOffs(118, 3).addBox(17.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(18.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(16.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 33).addBox(19.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(95, 16).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 39).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 37).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base27 = Base20.addOrReplaceChild("Base27", CubeListBuilder.create().texOffs(118, 3).addBox(21.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(19.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 59).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 59).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 59).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base28 = Base27.addOrReplaceChild("Base28", CubeListBuilder.create().texOffs(118, 3).addBox(25.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(26.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(25.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 59).addBox(27.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 44).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_2_2_bottom = sail_2_2.addOrReplaceChild("sail_2_2_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(15.2632F, -24.8947F, -1.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r9 = sail_2_2_bottom.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(76, 33).addBox(53.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(43.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(33.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(22.9385F, -16.676F, -3.1522F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_2_1 = DhowSail_2.addOrReplaceChild("sail_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -27.1F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_1_sail = sail_2_1.addOrReplaceChild("sail_2_1_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base29 = sail_2_1_sail.addOrReplaceChild("Base29", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base30 = Base29.addOrReplaceChild("Base30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base31 = Base30.addOrReplaceChild("Base31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base32 = Base31.addOrReplaceChild("Base32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base33 = Base32.addOrReplaceChild("Base33", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base34 = Base33.addOrReplaceChild("Base34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base35 = Base34.addOrReplaceChild("Base35", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base36 = Base35.addOrReplaceChild("Base36", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base37 = Base36.addOrReplaceChild("Base37", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base38 = Base37.addOrReplaceChild("Base38", CubeListBuilder.create().texOffs(118, 3).addBox(26.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base39 = Base38.addOrReplaceChild("Base39", CubeListBuilder.create().texOffs(118, 3).addBox(28.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(28.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(27.431F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(30.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 57).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 18).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base50 = Base39.addOrReplaceChild("Base50", CubeListBuilder.create().texOffs(118, 3).addBox(31.431F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(31.431F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(30.431F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 52).addBox(33.431F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 47).addBox(38.431F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(46.431F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base51 = Base50.addOrReplaceChild("Base51", CubeListBuilder.create().texOffs(65, 37).addBox(46.431F, -4.4264F, 2.063F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base52 = Base51.addOrReplaceChild("Base52", CubeListBuilder.create().texOffs(118, 3).addBox(32.431F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 32).addBox(34.431F, -4.425F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 10).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base53 = Base52.addOrReplaceChild("Base53", CubeListBuilder.create().texOffs(118, 3).addBox(38.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(38.431F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(36.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(40.431F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 23).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base54 = Base53.addOrReplaceChild("Base54", CubeListBuilder.create().texOffs(118, 3).addBox(41.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(41.431F, -5.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(39.431F, -3.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(43.431F, -4.425F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 36).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base55 = Base54.addOrReplaceChild("Base55", CubeListBuilder.create().texOffs(118, 3).addBox(43.431F, -3.425F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(44.431F, -4.425F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 15).addBox(46.431F, -4.425F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base56 = Base55.addOrReplaceChild("Base56", CubeListBuilder.create().texOffs(118, 3).addBox(45.431F, -2.425F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 24).addBox(47.431F, -4.425F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(51.431F, -8.425F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(49.431F, -7.425F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(48.431F, -5.425F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_2_1_bottom2 = sail_2_1.addOrReplaceChild("sail_2_1_bottom2", CubeListBuilder.create(), PartPose.offsetAndRotation(22.2632F, -32.8947F, -3.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r10 = sail_2_1_bottom2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(81, 19).addBox(49.9385F, -23.676F, -3.1522F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 43).addBox(39.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(88, 52).addBox(29.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_2_0 = DhowSail_2.addOrReplaceChild("sail_2_0", CubeListBuilder.create(), PartPose.offset(-21.3F, -37.6F, 3.1F));

        PartDefinition sail_2_0_sail = sail_2_0.addOrReplaceChild("sail_2_0_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3333F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r11 = sail_2_0_sail.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(71, 13).addBox(-30.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(71, 41).addBox(-14.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(71, 31).addBox(-22.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(102, 1).addBox(-38.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 18).addBox(34.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 29).addBox(24.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 41).addBox(14.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 50).addBox(4.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(69, 52).addBox(-6.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(65, 11).addBox(-58.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(97, 13).addBox(-48.0F, -2.0F, -1.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(45.6667F, -7.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition rope_2_1 = DhowSail_2.addOrReplaceChild("rope_2_1", CubeListBuilder.create(), PartPose.offsetAndRotation(28.2F, -8.0F, -18.6F, -0.4189F, -0.9774F, 0.0F));

        PartDefinition cube_r3 = rope_2_1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(3, 24).addBox(24.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(54.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(74.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(39.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(12.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(12.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(1.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r4 = rope_2_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-8.75F, -8.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -32.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r5 = rope_2_1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 2).addBox(-8.5F, -8.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(@NotNull Ship cog, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        switch (cog.getData(Ship.SAIL_STATE)) {
            case 0 -> {
                this.DhowSail.getChild("Sail_0").visible = true;
                this.DhowSail.getChild("Sail_1").visible = false;
                this.DhowSail.getChild("Sail_2").visible = false;
                this.DhowSail.getChild("Sail_3").visible = false;
                this.DhowSail.getChild("Sail_4").visible = false;
            }
            case 1 -> {
                this.DhowSail.getChild("Sail_0").visible = false;
                this.DhowSail.getChild("Sail_1").visible = true;
                this.DhowSail.getChild("Sail_2").visible = false;
                this.DhowSail.getChild("Sail_3").visible = false;
                this.DhowSail.getChild("Sail_4").visible = false;
            }
            case 2 -> {
                this.DhowSail.getChild("Sail_0").visible = false;
                this.DhowSail.getChild("Sail_1").visible = false;
                this.DhowSail.getChild("Sail_2").visible = true;
                this.DhowSail.getChild("Sail_3").visible = false;
                this.DhowSail.getChild("Sail_4").visible = false;
            }
            case 3 -> {
                this.DhowSail.getChild("Sail_0").visible = false;
                this.DhowSail.getChild("Sail_1").visible = false;
                this.DhowSail.getChild("Sail_2").visible = false;
                this.DhowSail.getChild("Sail_3").visible = true;
                this.DhowSail.getChild("Sail_4").visible = false;
            }
            case 4 -> {
                this.DhowSail.getChild("Sail_0").visible = false;
                this.DhowSail.getChild("Sail_1").visible = false;
                this.DhowSail.getChild("Sail_2").visible = false;
                this.DhowSail.getChild("Sail_3").visible = false;
                this.DhowSail.getChild("Sail_4").visible = true;
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        DhowSail.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}