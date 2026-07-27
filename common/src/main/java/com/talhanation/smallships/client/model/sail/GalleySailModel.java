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

public class GalleySailModel extends SailModel {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, GalleyEntity.ID + "_sail_model"), "main");
    private final ModelPart GalleySail;
    private final ModelPart sail_4;
    private final ModelPart sail_4_sail;
    private final ModelPart Base77;
    private final ModelPart Base78;
    private final ModelPart sail_3;
    private final ModelPart sail_3_sail;
    private final ModelPart Base79;
    private final ModelPart Base80;
    private final ModelPart Base81;
    private final ModelPart Base82;
    private final ModelPart Base83;
    private final ModelPart Base84;
    private final ModelPart sail_3_bottom;
    private final ModelPart sail_2;
    private final ModelPart sail_2_sail;
    private final ModelPart Base85;
    private final ModelPart Base86;
    private final ModelPart Base87;
    private final ModelPart Base88;
    private final ModelPart Base89;
    private final ModelPart Base90;
    private final ModelPart Base91;
    private final ModelPart Base92;
    private final ModelPart Base93;
    private final ModelPart Base94;
    private final ModelPart sail_2_bottom;
    private final ModelPart sail_1;
    private final ModelPart sail_1_sail;
    private final ModelPart Base95;
    private final ModelPart Base96;
    private final ModelPart Base97;
    private final ModelPart Base98;
    private final ModelPart Base99;
    private final ModelPart Base100;
    private final ModelPart Base101;
    private final ModelPart Base102;
    private final ModelPart Base103;
    private final ModelPart Base104;
    private final ModelPart Base105;
    private final ModelPart Base106;
    private final ModelPart Base107;
    private final ModelPart Base108;
    private final ModelPart Base109;
    private final ModelPart Base110;
    private final ModelPart Base111;
    private final ModelPart Base112;
    private final ModelPart sail_1_bottom;
    private final ModelPart sail_0;
    private final ModelPart sail_0_sail;
    private final ModelPart ropes;
    private final ModelPart rope_1;
    private final ModelPart cube_r81;
    private final ModelPart cube_r82;
    private final ModelPart cube_r83;
    private final ModelPart rope_2;
    private final ModelPart cube_r19;
    private final ModelPart cube_r20;
    private final ModelPart cube_r21;

    public GalleySailModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.GalleySail = root.getChild("GalleySail");
        this.sail_4 = this.GalleySail.getChild("sail_4");
        this.sail_4_sail = this.sail_4.getChild("sail_4_sail");
        this.Base77 = this.sail_4_sail.getChild("Base77");
        this.Base78 = this.Base77.getChild("Base78");
        this.sail_3 = this.GalleySail.getChild("sail_3");
        this.sail_3_sail = this.sail_3.getChild("sail_3_sail");
        this.Base79 = this.sail_3_sail.getChild("Base79");
        this.Base80 = this.Base79.getChild("Base80");
        this.Base81 = this.Base80.getChild("Base81");
        this.Base82 = this.Base81.getChild("Base82");
        this.Base83 = this.Base82.getChild("Base83");
        this.Base84 = this.Base83.getChild("Base84");
        this.sail_3_bottom = this.sail_3.getChild("sail_3_bottom");
        this.sail_2 = this.GalleySail.getChild("sail_2");
        this.sail_2_sail = this.sail_2.getChild("sail_2_sail");
        this.Base85 = this.sail_2_sail.getChild("Base85");
        this.Base86 = this.Base85.getChild("Base86");
        this.Base87 = this.Base86.getChild("Base87");
        this.Base88 = this.Base87.getChild("Base88");
        this.Base89 = this.Base88.getChild("Base89");
        this.Base90 = this.Base89.getChild("Base90");
        this.Base91 = this.Base90.getChild("Base91");
        this.Base92 = this.Base91.getChild("Base92");
        this.Base93 = this.Base92.getChild("Base93");
        this.Base94 = this.Base93.getChild("Base94");
        this.sail_2_bottom = this.sail_2.getChild("sail_2_bottom");
        this.sail_1 = this.GalleySail.getChild("sail_1");
        this.sail_1_sail = this.sail_1.getChild("sail_1_sail");
        this.Base95 = this.sail_1_sail.getChild("Base95");
        this.Base96 = this.Base95.getChild("Base96");
        this.Base97 = this.Base96.getChild("Base97");
        this.Base98 = this.Base97.getChild("Base98");
        this.Base99 = this.Base98.getChild("Base99");
        this.Base100 = this.Base99.getChild("Base100");
        this.Base101 = this.Base100.getChild("Base101");
        this.Base102 = this.Base101.getChild("Base102");
        this.Base103 = this.Base102.getChild("Base103");
        this.Base104 = this.Base103.getChild("Base104");
        this.Base105 = this.Base104.getChild("Base105");
        this.Base106 = this.Base105.getChild("Base106");
        this.Base107 = this.Base106.getChild("Base107");
        this.Base108 = this.Base107.getChild("Base108");
        this.Base109 = this.Base108.getChild("Base109");
        this.Base110 = this.Base109.getChild("Base110");
        this.Base111 = this.Base110.getChild("Base111");
        this.Base112 = this.Base111.getChild("Base112");
        this.sail_1_bottom = this.sail_1.getChild("sail_1_bottom");
        this.sail_0 = this.GalleySail.getChild("sail_0");
        this.sail_0_sail = this.sail_0.getChild("sail_0_sail");
        this.ropes = this.GalleySail.getChild("ropes");
        this.rope_1 = this.ropes.getChild("rope_1");
        this.cube_r81 = this.rope_1.getChild("cube_r81");
        this.cube_r82 = this.rope_1.getChild("cube_r82");
        this.cube_r83 = this.rope_1.getChild("cube_r83");
        this.rope_2 = this.ropes.getChild("rope_2");
        this.cube_r19 = this.rope_2.getChild("cube_r19");
        this.cube_r20 = this.rope_2.getChild("cube_r20");
        this.cube_r21 = this.rope_2.getChild("cube_r21");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition GalleySail = partdefinition.addOrReplaceChild("GalleySail", CubeListBuilder.create(), PartPose.offset(5.0F, 16.0F, -3.0F));

        PartDefinition sail_4 = GalleySail.addOrReplaceChild("sail_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-28.3F, -23.6F, 10.3F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_4_sail = sail_4.addOrReplaceChild("sail_4_sail", CubeListBuilder.create().texOffs(69, 5).addBox(-7.569F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-9.569F, -0.7772F, 2.0974F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-10.569F, 1.2228F, 2.0974F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 5).addBox(-1.569F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 43).addBox(10.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 5).addBox(22.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(69, 5).addBox(34.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 1).addBox(46.431F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base77 = sail_4_sail.addOrReplaceChild("Base77", CubeListBuilder.create().texOffs(118, 2).addBox(-3.569F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 6).addBox(-7.569F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-5.569F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 23).addBox(-1.569F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 15).addBox(10.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 13).addBox(22.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 19).addBox(34.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 32).addBox(46.431F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base78 = Base77.addOrReplaceChild("Base78", CubeListBuilder.create().texOffs(118, 2).addBox(-0.569F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-3.569F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-2.569F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 11).addBox(1.431F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(85, 11).addBox(10.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 10).addBox(22.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(34.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 3).addBox(46.431F, -4.6322F, 2.0715F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition sail_3 = GalleySail.addOrReplaceChild("sail_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-28.3F, -23.6F, 10.3F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_3_sail = sail_3.addOrReplaceChild("sail_3_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base79 = sail_3_sail.addOrReplaceChild("Base79", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base80 = Base79.addOrReplaceChild("Base80", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base81 = Base80.addOrReplaceChild("Base81", CubeListBuilder.create().texOffs(118, 3).addBox(2.431F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(-0.569F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(1.431F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 54).addBox(4.431F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(10.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(22.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 41).addBox(34.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 29).addBox(46.431F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base82 = Base81.addOrReplaceChild("Base82", CubeListBuilder.create().texOffs(118, 3).addBox(4.431F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(5.431F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(3.431F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(6.431F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 42).addBox(10.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 47).addBox(22.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(99, 28).addBox(34.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 29).addBox(46.431F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base83 = Base82.addOrReplaceChild("Base83", CubeListBuilder.create().texOffs(118, 3).addBox(8.431F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(6.431F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(8.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.431F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(7.431F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 42).addBox(10.431F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(14.431F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 36).addBox(22.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 39).addBox(34.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 20).addBox(46.431F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base84 = Base83.addOrReplaceChild("Base84", CubeListBuilder.create().texOffs(118, 3).addBox(11.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(12.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(10.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 52).addBox(13.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 25).addBox(17.431F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 8).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 16).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 29).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition sail_3_bottom = sail_3.addOrReplaceChild("sail_3_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(14.4632F, -13.7947F, 0.1047F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r1 = sail_3_bottom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(66, 28).addBox(60.9385F, -11.676F, -3.1522F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(88, 8).addBox(50.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(78, 24).addBox(40.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(97, 19).addBox(30.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(93, 37).addBox(20.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(10.9385F, -11.676F, -3.1522F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_2 = GalleySail.addOrReplaceChild("sail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-28.3F, -23.6F, 10.3F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_sail = sail_2.addOrReplaceChild("sail_2_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base85 = sail_2_sail.addOrReplaceChild("Base85", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base86 = Base85.addOrReplaceChild("Base86", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base87 = Base86.addOrReplaceChild("Base87", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base88 = Base87.addOrReplaceChild("Base88", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base89 = Base88.addOrReplaceChild("Base89", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base90 = Base89.addOrReplaceChild("Base90", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base91 = Base90.addOrReplaceChild("Base91", CubeListBuilder.create().texOffs(118, 3).addBox(14.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(15.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(13.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 23).addBox(16.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 7).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 51).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 40).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base92 = Base91.addOrReplaceChild("Base92", CubeListBuilder.create().texOffs(118, 3).addBox(17.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(18.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(16.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 33).addBox(19.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(95, 16).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 39).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 37).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base93 = Base92.addOrReplaceChild("Base93", CubeListBuilder.create().texOffs(118, 3).addBox(21.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(19.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 59).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 59).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 59).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base94 = Base93.addOrReplaceChild("Base94", CubeListBuilder.create().texOffs(118, 3).addBox(25.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(26.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(25.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 59).addBox(27.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 48).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 44).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_2_bottom = sail_2.addOrReplaceChild("sail_2_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(15.2632F, -24.8947F, -1.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r2 = sail_2_bottom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 33).addBox(53.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(43.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(33.9385F, -16.676F, -3.1522F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(22.9385F, -16.676F, -3.1522F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_1 = GalleySail.addOrReplaceChild("sail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-28.3F, -23.6F, 10.3F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_sail = sail_1.addOrReplaceChild("sail_1_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base95 = sail_1_sail.addOrReplaceChild("Base95", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base96 = Base95.addOrReplaceChild("Base96", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base97 = Base96.addOrReplaceChild("Base97", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base98 = Base97.addOrReplaceChild("Base98", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base99 = Base98.addOrReplaceChild("Base99", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base100 = Base99.addOrReplaceChild("Base100", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0262F, 0.0F, 0.0F));

        PartDefinition Base101 = Base100.addOrReplaceChild("Base101", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base102 = Base101.addOrReplaceChild("Base102", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base103 = Base102.addOrReplaceChild("Base103", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base104 = Base103.addOrReplaceChild("Base104", CubeListBuilder.create().texOffs(118, 3).addBox(26.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base105 = Base104.addOrReplaceChild("Base105", CubeListBuilder.create().texOffs(118, 3).addBox(28.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(28.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(27.431F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(30.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 57).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 18).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base106 = Base105.addOrReplaceChild("Base106", CubeListBuilder.create().texOffs(118, 3).addBox(31.431F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(31.431F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(30.431F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 52).addBox(33.431F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 47).addBox(38.431F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(46.431F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base107 = Base106.addOrReplaceChild("Base107", CubeListBuilder.create().texOffs(65, 37).addBox(46.431F, -4.4264F, 2.0629F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base108 = Base107.addOrReplaceChild("Base108", CubeListBuilder.create().texOffs(118, 3).addBox(32.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 32).addBox(34.431F, -4.4249F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 10).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base109 = Base108.addOrReplaceChild("Base109", CubeListBuilder.create().texOffs(118, 3).addBox(38.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(38.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(36.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(40.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 23).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base110 = Base109.addOrReplaceChild("Base110", CubeListBuilder.create().texOffs(118, 3).addBox(41.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(41.431F, -5.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(39.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(43.431F, -4.4249F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 36).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base111 = Base110.addOrReplaceChild("Base111", CubeListBuilder.create().texOffs(118, 3).addBox(43.431F, -3.4249F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(44.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 15).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base112 = Base111.addOrReplaceChild("Base112", CubeListBuilder.create().texOffs(118, 3).addBox(45.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 24).addBox(47.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(51.431F, -8.4249F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(49.431F, -7.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(48.431F, -5.4249F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_1_bottom = sail_1.addOrReplaceChild("sail_1_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(22.2632F, -32.8947F, -3.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r3 = sail_1_bottom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(81, 19).addBox(49.9385F, -23.676F, -3.1522F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 43).addBox(39.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(88, 52).addBox(29.9385F, -23.676F, -3.1522F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7509F, 9.8947F, -2.2001F, 0.0F, -0.1309F, 0.0F));

        PartDefinition sail_0 = GalleySail.addOrReplaceChild("sail_0", CubeListBuilder.create(), PartPose.offset(-26.9F, -29.2F, 7.0F));

        PartDefinition sail_0_sail = sail_0.addOrReplaceChild("sail_0_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3333F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r4 = sail_0_sail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(71, 13).addBox(-30.0F, -2.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
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

        PartDefinition ropes = GalleySail.addOrReplaceChild("ropes", CubeListBuilder.create(), PartPose.offset(50.5F, -19.0F, 3.0F));

        PartDefinition rope_1 = ropes.addOrReplaceChild("rope_1", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 8.0F, 0.0F, 0.0F, -1.5708F, -0.7854F));

        PartDefinition cube_r81 = rope_1.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(10, 25).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(74.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(84.5F, -0.5F, -17.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 24).addBox(92.5F, -0.5F, -17.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 25).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r82 = rope_1.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(2, 2).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r83 = rope_1.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(20, 1).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition rope_2 = ropes.addOrReplaceChild("rope_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-118.0F, 21.0F, 0.0F, 0.0F, -1.5708F, 0.7418F));

        PartDefinition cube_r19 = rope_2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 24).addBox(34.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 22).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 26).addBox(74.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(84.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(26, 28).addBox(94.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 25).addBox(104.5F, -0.5F, -17.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 27).addBox(49.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 24).addBox(22.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 22).addBox(22.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 26).addBox(11.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.5F, 17.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r20 = rope_2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(8, 3).addBox(-1.75F, -1.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r21 = rope_2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(16, 8).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }


    @Override
    public void setupAnim(Ship galley, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        switch (galley.getData(Ship.SAIL_STATE)) {
            case 0 -> {
                this.sail_0.visible = true;
                this.sail_1.visible = false;
                this.sail_2.visible = false;
                this.sail_3.visible = false;
                this.sail_4.visible = false;

                this.sail_1_bottom.visible = false;
                this.sail_2_bottom.visible = false;
                this.sail_3_bottom.visible = false;
            }
            case 1 -> {
                this.sail_0.visible = false;
                this.sail_1.visible = true;
                this.sail_2.visible = false;
                this.sail_3.visible = false;
                this.sail_4.visible = false;

                this.sail_1_bottom.visible = true;
                this.sail_2_bottom.visible = false;
                this.sail_3_bottom.visible = false;
            }
            case 2 -> {
                this.sail_0.visible = false;
                this.sail_1.visible = true;
                this.sail_2.visible = true;
                this.sail_3.visible = false;
                this.sail_4.visible = false;
                this.sail_1_bottom.visible = false;
                this.sail_2_bottom.visible = true;
                this.sail_3_bottom.visible = false;
            }
            case 3 -> {
                this.sail_0.visible = false;
                this.sail_1.visible = true;
                this.sail_2.visible = true;
                this.sail_3.visible = true;
                this.sail_4.visible = false;
                this.sail_1_bottom.visible = false;
                this.sail_2_bottom.visible = false;
                this.sail_3_bottom.visible = true;
            }
            case 4 -> {
                this.sail_0.visible = false;
                this.sail_1.visible = true;
                this.sail_2.visible = true;
                this.sail_3.visible = true;
                this.sail_4.visible = true;


                this.sail_1_bottom.visible = false;
                this.sail_2_bottom.visible = false;
                this.sail_3_bottom.visible = false;
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        GalleySail.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}
