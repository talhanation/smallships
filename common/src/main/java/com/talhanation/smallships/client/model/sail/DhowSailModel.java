package com.talhanation.smallships.client.model.sail;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
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
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DhowEntity.ID + "_sail_model"), "main");
    private final ModelPart Dhow_Sail;
    private final ModelPart DhowSail_1;
    private final ModelPart sail_1_4;
    private final ModelPart sail_1_4_sail;
    private final ModelPart Base2;
    private final ModelPart Base3;
    private final ModelPart sail_1_3;
    private final ModelPart sail_1_3_sail;
    private final ModelPart Base21;
    private final ModelPart Base22;
    private final ModelPart Base23;
    private final ModelPart Base24;
    private final ModelPart Base25;
    private final ModelPart Base26;
    private final ModelPart sail_1_3_bottom;
    private final ModelPart sail_1_2;
    private final ModelPart sail_1_2_sail;
    private final ModelPart Base40;
    private final ModelPart Base41;
    private final ModelPart Base42;
    private final ModelPart Base43;
    private final ModelPart Base44;
    private final ModelPart Base45;
    private final ModelPart Base46;
    private final ModelPart Base47;
    private final ModelPart Base48;
    private final ModelPart Base49;
    private final ModelPart sail_1_2_bottom;
    private final ModelPart sail_1_1;
    private final ModelPart sail_1_1_sail;
    private final ModelPart Base59;
    private final ModelPart Base60;
    private final ModelPart Base61;
    private final ModelPart Base62;
    private final ModelPart Base63;
    private final ModelPart Base64;
    private final ModelPart Base65;
    private final ModelPart Base66;
    private final ModelPart Base67;
    private final ModelPart Base68;
    private final ModelPart Base69;
    private final ModelPart Base70;
    private final ModelPart Base71;
    private final ModelPart Base72;
    private final ModelPart Base73;
    private final ModelPart Base74;
    private final ModelPart Base75;
    private final ModelPart Base76;
    private final ModelPart sail_1_1_bottom;
    private final ModelPart sail_1_0;
    private final ModelPart sail_1_0_sail;
    private final ModelPart ropes_1;
    private final ModelPart rope_1_1;
    private final ModelPart cube_r19;
    private final ModelPart cube_r20;
    private final ModelPart cube_r21;
    private final ModelPart DhowSail_2;
    private final ModelPart sail_2_4;
    private final ModelPart sail_2_4_sail;
    private final ModelPart Base5;
    private final ModelPart Base6;
    private final ModelPart sail_2_3;
    private final ModelPart sail_2_3_sail;
    private final ModelPart Base7;
    private final ModelPart Base8;
    private final ModelPart Base9;
    private final ModelPart Base10;
    private final ModelPart Base11;
    private final ModelPart Base12;
    private final ModelPart sail_2_3_bottom;
    private final ModelPart sail_2_2;
    private final ModelPart sail_2_2_sail;
    private final ModelPart Base13;
    private final ModelPart Base14;
    private final ModelPart Base15;
    private final ModelPart Base16;
    private final ModelPart Base17;
    private final ModelPart Base18;
    private final ModelPart Base19;
    private final ModelPart Base20;
    private final ModelPart Base27;
    private final ModelPart Base28;
    private final ModelPart sail_2_2_bottom;
    private final ModelPart sail_2_1;
    private final ModelPart sail_2_1_sail;
    private final ModelPart Base29;
    private final ModelPart Base30;
    private final ModelPart Base31;
    private final ModelPart Base32;
    private final ModelPart Base33;
    private final ModelPart Base34;
    private final ModelPart Base35;
    private final ModelPart Base36;
    private final ModelPart Base37;
    private final ModelPart Base38;
    private final ModelPart Base39;
    private final ModelPart Base50;
    private final ModelPart Base51;
    private final ModelPart Base52;
    private final ModelPart Base53;
    private final ModelPart Base54;
    private final ModelPart Base55;
    private final ModelPart Base56;
    private final ModelPart sail_2_1_bottom;
    private final ModelPart sail_2_0;
    private final ModelPart sail_2_0_sail;
    private final ModelPart rope_2_1;
    private final ModelPart cube_r3;
    private final ModelPart cube_r4;
    private final ModelPart cube_r5;

    public DhowSailModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.Dhow_Sail = root.getChild("Dhow_Sail");
        this.DhowSail_1 = this.Dhow_Sail.getChild("DhowSail_1");
        this.sail_1_4 = this.DhowSail_1.getChild("sail_1_4");
        this.sail_1_4_sail = this.sail_1_4.getChild("sail_1_4_sail");
        this.Base2 = this.sail_1_4_sail.getChild("Base2");
        this.Base3 = this.Base2.getChild("Base3");
        this.sail_1_3 = this.DhowSail_1.getChild("sail_1_3");
        this.sail_1_3_sail = this.sail_1_3.getChild("sail_1_3_sail");
        this.Base21 = this.sail_1_3_sail.getChild("Base21");
        this.Base22 = this.Base21.getChild("Base22");
        this.Base23 = this.Base22.getChild("Base23");
        this.Base24 = this.Base23.getChild("Base24");
        this.Base25 = this.Base24.getChild("Base25");
        this.Base26 = this.Base25.getChild("Base26");
        this.sail_1_3_bottom = this.sail_1_3.getChild("sail_1_3_bottom");
        this.sail_1_2 = this.DhowSail_1.getChild("sail_1_2");
        this.sail_1_2_sail = this.sail_1_2.getChild("sail_1_2_sail");
        this.Base40 = this.sail_1_2_sail.getChild("Base40");
        this.Base41 = this.Base40.getChild("Base41");
        this.Base42 = this.Base41.getChild("Base42");
        this.Base43 = this.Base42.getChild("Base43");
        this.Base44 = this.Base43.getChild("Base44");
        this.Base45 = this.Base44.getChild("Base45");
        this.Base46 = this.Base45.getChild("Base46");
        this.Base47 = this.Base46.getChild("Base47");
        this.Base48 = this.Base47.getChild("Base48");
        this.Base49 = this.Base48.getChild("Base49");
        this.sail_1_2_bottom = this.sail_1_2.getChild("sail_1_2_bottom");
        this.sail_1_1 = this.DhowSail_1.getChild("sail_1_1");
        this.sail_1_1_sail = this.sail_1_1.getChild("sail_1_1_sail");
        this.Base59 = this.sail_1_1_sail.getChild("Base59");
        this.Base60 = this.Base59.getChild("Base60");
        this.Base61 = this.Base60.getChild("Base61");
        this.Base62 = this.Base61.getChild("Base62");
        this.Base63 = this.Base62.getChild("Base63");
        this.Base64 = this.Base63.getChild("Base64");
        this.Base65 = this.Base64.getChild("Base65");
        this.Base66 = this.Base65.getChild("Base66");
        this.Base67 = this.Base66.getChild("Base67");
        this.Base68 = this.Base67.getChild("Base68");
        this.Base69 = this.Base68.getChild("Base69");
        this.Base70 = this.Base69.getChild("Base70");
        this.Base71 = this.Base70.getChild("Base71");
        this.Base72 = this.Base71.getChild("Base72");
        this.Base73 = this.Base72.getChild("Base73");
        this.Base74 = this.Base73.getChild("Base74");
        this.Base75 = this.Base74.getChild("Base75");
        this.Base76 = this.Base75.getChild("Base76");
        this.sail_1_1_bottom = this.sail_1_1.getChild("sail_1_1_bottom");
        this.sail_1_0 = this.DhowSail_1.getChild("sail_1_0");
        this.sail_1_0_sail = this.sail_1_0.getChild("sail_1_0_sail");
        this.ropes_1 = this.DhowSail_1.getChild("ropes_1");
        this.rope_1_1 = this.ropes_1.getChild("rope_1_1");
        this.cube_r19 = this.rope_1_1.getChild("cube_r19");
        this.cube_r20 = this.rope_1_1.getChild("cube_r20");
        this.cube_r21 = this.rope_1_1.getChild("cube_r21");
        this.DhowSail_2 = this.Dhow_Sail.getChild("DhowSail_2");
        this.sail_2_4 = this.DhowSail_2.getChild("sail_2_4");
        this.sail_2_4_sail = this.sail_2_4.getChild("sail_2_4_sail");
        this.Base5 = this.sail_2_4_sail.getChild("Base5");
        this.Base6 = this.Base5.getChild("Base6");
        this.sail_2_3 = this.DhowSail_2.getChild("sail_2_3");
        this.sail_2_3_sail = this.sail_2_3.getChild("sail_2_3_sail");
        this.Base7 = this.sail_2_3_sail.getChild("Base7");
        this.Base8 = this.Base7.getChild("Base8");
        this.Base9 = this.Base8.getChild("Base9");
        this.Base10 = this.Base9.getChild("Base10");
        this.Base11 = this.Base10.getChild("Base11");
        this.Base12 = this.Base11.getChild("Base12");
        this.sail_2_3_bottom = this.sail_2_3.getChild("sail_2_3_bottom");
        this.sail_2_2 = this.DhowSail_2.getChild("sail_2_2");
        this.sail_2_2_sail = this.sail_2_2.getChild("sail_2_2_sail");
        this.Base13 = this.sail_2_2_sail.getChild("Base13");
        this.Base14 = this.Base13.getChild("Base14");
        this.Base15 = this.Base14.getChild("Base15");
        this.Base16 = this.Base15.getChild("Base16");
        this.Base17 = this.Base16.getChild("Base17");
        this.Base18 = this.Base17.getChild("Base18");
        this.Base19 = this.Base18.getChild("Base19");
        this.Base20 = this.Base19.getChild("Base20");
        this.Base27 = this.Base20.getChild("Base27");
        this.Base28 = this.Base27.getChild("Base28");
        this.sail_2_2_bottom = this.sail_2_2.getChild("sail_2_2_bottom");
        this.sail_2_1 = this.DhowSail_2.getChild("sail_2_1");
        this.sail_2_1_sail = this.sail_2_1.getChild("sail_2_1_sail");
        this.Base29 = this.sail_2_1_sail.getChild("Base29");
        this.Base30 = this.Base29.getChild("Base30");
        this.Base31 = this.Base30.getChild("Base31");
        this.Base32 = this.Base31.getChild("Base32");
        this.Base33 = this.Base32.getChild("Base33");
        this.Base34 = this.Base33.getChild("Base34");
        this.Base35 = this.Base34.getChild("Base35");
        this.Base36 = this.Base35.getChild("Base36");
        this.Base37 = this.Base36.getChild("Base37");
        this.Base38 = this.Base37.getChild("Base38");
        this.Base39 = this.Base38.getChild("Base39");
        this.Base50 = this.Base39.getChild("Base50");
        this.Base51 = this.Base50.getChild("Base51");
        this.Base52 = this.Base51.getChild("Base52");
        this.Base53 = this.Base52.getChild("Base53");
        this.Base54 = this.Base53.getChild("Base54");
        this.Base55 = this.Base54.getChild("Base55");
        this.Base56 = this.Base55.getChild("Base56");
        this.sail_2_1_bottom = this.sail_2_1.getChild("sail_2_1_bottom");
        this.sail_2_0 = this.DhowSail_2.getChild("sail_2_0");
        this.sail_2_0_sail = this.sail_2_0.getChild("sail_2_0_sail");
        this.rope_2_1 = this.DhowSail_2.getChild("rope_2_1");
        this.cube_r3 = this.rope_2_1.getChild("cube_r3");
        this.cube_r4 = this.rope_2_1.getChild("cube_r4");
        this.cube_r5 = this.rope_2_1.getChild("cube_r5");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Dhow_Sail = partdefinition.addOrReplaceChild("Dhow_Sail", CubeListBuilder.create(), PartPose.offsetAndRotation(1.8F, 27.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition DhowSail_1 = Dhow_Sail.addOrReplaceChild("DhowSail_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1F, -14.4F, -32.0F, 0.0F, -2.1817F, 0.0F));

        PartDefinition sail_1_4 = DhowSail_1.addOrReplaceChild("sail_1_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_4_sail = sail_1_4.addOrReplaceChild("sail_1_4_sail", CubeListBuilder.create().texOffs(64, 9).addBox(-7.569F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-9.5689F, 0.2228F, 2.0974F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-10.5689F, 2.2228F, 2.0974F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.5689F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 43).addBox(10.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(46.431F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base2 = sail_1_4_sail.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(118, 2).addBox(-3.5689F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 4).addBox(-7.569F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-5.5689F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.5689F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 9).addBox(46.431F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base3 = Base2.addOrReplaceChild("Base3", CubeListBuilder.create().texOffs(118, 2).addBox(-0.5689F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-3.5689F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-2.5689F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(1.4311F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(34.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 2).addBox(46.431F, -4.6322F, 2.0715F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition sail_1_3 = DhowSail_1.addOrReplaceChild("sail_1_3", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -26.8F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_1_3_sail = sail_1_3.addOrReplaceChild("sail_1_3_sail", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base21 = sail_1_3_sail.addOrReplaceChild("Base21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base22 = Base21.addOrReplaceChild("Base22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base23 = Base22.addOrReplaceChild("Base23", CubeListBuilder.create().texOffs(118, 3).addBox(2.4311F, -4.6337F, 2.073F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(-0.5689F, -2.6337F, 2.073F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(1.4311F, -4.6337F, 2.073F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 54).addBox(4.4311F, -4.6337F, 2.073F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(10.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(22.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 41).addBox(34.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 29).addBox(46.431F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base24 = Base23.addOrReplaceChild("Base24", CubeListBuilder.create().texOffs(118, 3).addBox(4.4311F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(5.4311F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(3.4311F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(6.4311F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 42).addBox(10.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 47).addBox(22.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(99, 28).addBox(34.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 29).addBox(46.431F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base25 = Base24.addOrReplaceChild("Base25", CubeListBuilder.create().texOffs(118, 3).addBox(8.431F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(6.4311F, -1.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(8.431F, -4.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(9.431F, -5.5292F, 2.0686F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(7.431F, -2.5292F, 2.0686F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 42).addBox(10.431F, -4.5292F, 2.0686F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 53).addBox(14.431F, -4.5292F, 2.0686F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(74, 36).addBox(22.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 39).addBox(34.431F, -4.5292F, 2.0686F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 20).addBox(46.431F, -4.5292F, 2.0686F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

        PartDefinition Base26 = Base25.addOrReplaceChild("Base26", CubeListBuilder.create().texOffs(118, 3).addBox(11.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(12.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(10.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 52).addBox(13.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 25).addBox(17.431F, -4.4249F, 2.064F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 8).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
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

        PartDefinition Base46 = Base45.addOrReplaceChild("Base46", CubeListBuilder.create().texOffs(118, 3).addBox(14.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(15.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(13.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 23).addBox(16.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -4.4249F, 2.064F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 6).addBox(22.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 51).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 40).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base47 = Base46.addOrReplaceChild("Base47", CubeListBuilder.create().texOffs(118, 3).addBox(17.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(18.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(16.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 33).addBox(19.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(95, 16).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 39).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 37).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base48 = Base47.addOrReplaceChild("Base48", CubeListBuilder.create().texOffs(118, 3).addBox(21.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(19.431F, -1.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(20.431F, -2.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(65, 59).addBox(23.431F, -4.4249F, 2.064F, 11.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 59).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(79, 59).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base49 = Base48.addOrReplaceChild("Base49", CubeListBuilder.create().texOffs(118, 3).addBox(25.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(26.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(25.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(22.431F, -1.4249F, 2.064F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -2.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(23.431F, -3.4249F, 2.064F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 59).addBox(27.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
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

        PartDefinition Base68 = Base67.addOrReplaceChild("Base68", CubeListBuilder.create().texOffs(118, 3).addBox(26.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base69 = Base68.addOrReplaceChild("Base69", CubeListBuilder.create().texOffs(118, 3).addBox(28.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(28.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(29.431F, -5.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(27.431F, -3.4249F, 2.064F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 23).addBox(30.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 57).addBox(34.431F, -4.4249F, 2.064F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 18).addBox(46.431F, -4.4249F, 2.064F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base70 = Base69.addOrReplaceChild("Base70", CubeListBuilder.create().texOffs(118, 3).addBox(31.431F, -3.4292F, 2.066F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(31.431F, -4.4292F, 2.066F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(30.431F, -2.4292F, 2.066F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 52).addBox(33.431F, -4.4292F, 2.066F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 47).addBox(38.431F, -4.4292F, 2.066F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(46.431F, -4.4292F, 2.066F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base71 = Base70.addOrReplaceChild("Base71", CubeListBuilder.create().texOffs(65, 37).addBox(46.431F, -4.4264F, 2.063F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0175F, 0.0F, 0.0F));

        PartDefinition Base72 = Base71.addOrReplaceChild("Base72", CubeListBuilder.create().texOffs(118, 3).addBox(32.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 32).addBox(34.431F, -4.4249F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 10).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base73 = Base72.addOrReplaceChild("Base73", CubeListBuilder.create().texOffs(118, 3).addBox(38.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(38.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(36.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(40.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 23).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base74 = Base73.addOrReplaceChild("Base74", CubeListBuilder.create().texOffs(118, 3).addBox(41.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(41.431F, -5.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(39.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(43.431F, -4.4249F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 36).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base75 = Base74.addOrReplaceChild("Base75", CubeListBuilder.create().texOffs(118, 3).addBox(43.431F, -3.4249F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(44.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 15).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base76 = Base75.addOrReplaceChild("Base76", CubeListBuilder.create().texOffs(118, 3).addBox(45.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 24).addBox(47.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(51.4311F, -8.4249F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(49.431F, -7.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(48.431F, -5.4249F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

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

        PartDefinition rope_1_1 = ropes_1.addOrReplaceChild("rope_1_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-84.0F, 11.0F, 14.0F, 0.3752F, -0.9512F, 0.0F));

        PartDefinition cube_r19 = rope_1_1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(13, 26).addBox(24.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(54.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(64.5F, -0.5F, -17.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(74.5F, -0.5F, -17.5F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(39.5F, -0.5F, -17.5F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(12.5F, 0.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 26).addBox(12.5F, -1.75F, -17.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 21).addBox(1.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0175F, 9.7347F, 15.1523F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r20 = rope_1_1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-8.75F, -8.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0175F, -24.2653F, -1.8477F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r21 = rope_1_1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(10, 0).addBox(-8.5F, -8.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0175F, -12.2653F, -1.8477F, 0.0F, 0.0F, -2.3562F));

        PartDefinition DhowSail_2 = Dhow_Sail.addOrReplaceChild("DhowSail_2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -14.0F, 24.0F, 0.0F, -2.1817F, 0.0F));

        PartDefinition sail_2_4 = DhowSail_2.addOrReplaceChild("sail_2_4", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.4F, -27.1F, 5.7F, 0.2443F, -0.2793F, 0.0F));

        PartDefinition sail_2_4_sail = sail_2_4.addOrReplaceChild("sail_2_4_sail", CubeListBuilder.create().texOffs(64, 9).addBox(-7.569F, -0.7772F, 2.0974F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-9.5689F, 0.2228F, 2.0974F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-10.5689F, 2.2228F, 2.0974F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 43).addBox(10.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -0.7772F, 2.0974F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(46.431F, -0.7772F, 2.0974F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9F, -5.1F, -2.9F, -0.0175F, -0.1571F, 0.0F));

        PartDefinition Base5 = sail_2_4_sail.addOrReplaceChild("Base5", CubeListBuilder.create().texOffs(118, 2).addBox(-3.569F, -4.7383F, 2.0773F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(72, 4).addBox(-7.569F, -2.7383F, 2.0773F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-5.569F, -4.7383F, 2.0773F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(-1.569F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(22.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(34.431F, -4.7383F, 2.0773F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(67, 9).addBox(46.431F, -4.7383F, 2.0773F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Base6 = Base5.addOrReplaceChild("Base6", CubeListBuilder.create().texOffs(118, 2).addBox(-0.569F, -4.6322F, 2.0715F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-3.569F, -2.6322F, 2.0715F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 2).addBox(-2.569F, -4.6322F, 2.0715F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 9).addBox(1.431F, -4.6322F, 2.0715F, 9.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 4).addBox(10.431F, -4.6322F, 2.0715F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
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
                .texOffs(87, 53).addBox(10.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 42).addBox(22.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 41).addBox(34.431F, -4.6337F, 2.073F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 29).addBox(46.431F, -4.6337F, 2.073F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base10 = Base9.addOrReplaceChild("Base10", CubeListBuilder.create().texOffs(118, 3).addBox(4.431F, -3.6352F, 2.0744F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(5.431F, -4.6352F, 2.0744F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(3.431F, -2.6352F, 2.0744F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 34).addBox(6.431F, -4.6352F, 2.0744F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 42).addBox(10.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(102, 47).addBox(22.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(99, 28).addBox(34.431F, -4.6352F, 2.0744F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(94, 29).addBox(46.431F, -4.6352F, 2.0744F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.0087F, 0.0F, 0.0F));

        PartDefinition Base11 = Base10.addOrReplaceChild("Base11", CubeListBuilder.create().texOffs(118, 3).addBox(8.431F, -3.5292F, 2.0686F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
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

        PartDefinition Base12 = Base11.addOrReplaceChild("Base12", CubeListBuilder.create().texOffs(118, 3).addBox(11.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(12.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(10.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(66, 52).addBox(13.431F, -4.4249F, 2.064F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
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

        PartDefinition Base19 = Base18.addOrReplaceChild("Base19", CubeListBuilder.create().texOffs(118, 3).addBox(14.431F, -3.4249F, 2.064F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(15.431F, -4.4249F, 2.064F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(13.431F, -2.4249F, 2.064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
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

        PartDefinition Base52 = Base51.addOrReplaceChild("Base52", CubeListBuilder.create().texOffs(118, 3).addBox(32.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 32).addBox(34.431F, -4.4249F, 2.0614F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 10).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, 0.0087F, 0.0F, 0.0F));

        PartDefinition Base53 = Base52.addOrReplaceChild("Base53", CubeListBuilder.create().texOffs(118, 3).addBox(38.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(38.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(36.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 17).addBox(40.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 23).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base54 = Base53.addOrReplaceChild("Base54", CubeListBuilder.create().texOffs(118, 3).addBox(41.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(41.431F, -5.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(39.431F, -3.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(43.431F, -4.4249F, 2.0614F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(111, 36).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base55 = Base54.addOrReplaceChild("Base55", CubeListBuilder.create().texOffs(118, 3).addBox(43.431F, -3.4249F, 2.0614F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(44.431F, -4.4249F, 2.0614F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 15).addBox(46.431F, -4.4249F, 2.0614F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition Base56 = Base55.addOrReplaceChild("Base56", CubeListBuilder.create().texOffs(118, 3).addBox(45.431F, -2.4249F, 2.0614F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(90, 24).addBox(47.431F, -4.4249F, 2.0614F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(51.431F, -8.4249F, 2.0614F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(49.431F, -7.4249F, 2.0614F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 3).addBox(48.431F, -5.4249F, 2.0614F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition sail_2_1_bottom = sail_2_1.addOrReplaceChild("sail_2_1_bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(22.2632F, -32.8947F, -3.1953F, 0.0F, -0.0436F, 0.0F));

        PartDefinition cube_r10 = sail_2_1_bottom.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(81, 19).addBox(49.9385F, -23.676F, -3.1522F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
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
                .texOffs(3, 24).addBox(1.5F, -0.5F, -17.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0332F, 2.2727F, 15.2645F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r4 = rope_2_1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 2).addBox(-8.75F, -8.75F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0332F, -31.7273F, -1.7355F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r5 = rope_2_1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 2).addBox(-8.5F, -8.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0332F, -19.7273F, -1.7355F, 0.0F, 0.0F, -2.3562F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }
    @Override
    public void setupAnim(@NotNull Ship cog, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        switch (cog.getData(Ship.SAIL_STATE)) {
            case 0 -> {
                this.sail_1_0.visible = true;
                this.sail_1_1.visible = false;
                this.sail_1_2.visible = false;
                this.sail_1_3.visible = false;
                this.sail_1_4.visible = false;

                this.sail_1_1_bottom.visible = false;
                this.sail_1_2_bottom.visible = false;
                this.sail_1_3_bottom.visible = false;

                this.sail_2_0.visible = true;
                this.sail_2_1.visible = false;
                this.sail_2_2.visible = false;
                this.sail_2_3.visible = false;
                this.sail_2_4.visible = false;

                this.sail_2_1_bottom.visible = false;
                this.sail_2_2_bottom.visible = false;
                this.sail_2_3_bottom.visible = false;
            }
            case 1 -> {
                this.sail_1_0.visible = false;
                this.sail_1_1.visible = true;
                this.sail_1_2.visible = false;
                this.sail_1_3.visible = false;
                this.sail_1_4.visible = false;

                this.sail_1_1_bottom.visible = true;
                this.sail_1_2_bottom.visible = false;
                this.sail_1_3_bottom.visible = false;

                this.sail_2_0.visible = false;
                this.sail_2_1.visible = true;
                this.sail_2_2.visible = false;
                this.sail_2_3.visible = false;
                this.sail_2_4.visible = false;

                this.sail_2_1_bottom.visible = true;
                this.sail_2_2_bottom.visible = false;
                this.sail_2_3_bottom.visible = false;
            }
            case 2 -> {
                this.sail_1_0.visible = false;
                this.sail_1_1.visible = true;
                this.sail_1_2.visible = true;
                this.sail_1_3.visible = false;
                this.sail_1_4.visible = false;
                this.sail_1_1_bottom.visible = false;
                this.sail_1_2_bottom.visible = true;
                this.sail_1_3_bottom.visible = false;

                this.sail_2_0.visible = false;
                this.sail_2_1.visible = true;
                this.sail_2_2.visible = true;
                this.sail_2_3.visible = false;
                this.sail_2_4.visible = false;
                this.sail_2_1_bottom.visible = false;
                this.sail_2_2_bottom.visible = true;
                this.sail_2_3_bottom.visible = false;
            }
            case 3 -> {
                this.sail_1_0.visible = false;
                this.sail_1_1.visible = true;
                this.sail_1_2.visible = true;
                this.sail_1_3.visible = true;
                this.sail_1_4.visible = false;
                this.sail_1_1_bottom.visible = false;
                this.sail_1_2_bottom.visible = false;
                this.sail_1_3_bottom.visible = true;

                this.sail_2_0.visible = false;
                this.sail_2_1.visible = true;
                this.sail_2_2.visible = true;
                this.sail_2_3.visible = true;
                this.sail_2_4.visible = false;
                this.sail_2_1_bottom.visible = false;
                this.sail_2_2_bottom.visible = false;
                this.sail_2_3_bottom.visible = true;
            }
            case 4 -> {
                this.sail_1_0.visible = false;
                this.sail_1_1.visible = true;
                this.sail_1_2.visible = true;
                this.sail_1_3.visible = true;
                this.sail_1_4.visible = true;
                this.sail_1_1_bottom.visible = false;
                this.sail_1_2_bottom.visible = false;
                this.sail_1_3_bottom.visible = false;

                this.sail_2_0.visible = false;
                this.sail_2_1.visible = true;
                this.sail_2_2.visible = true;
                this.sail_2_3.visible = true;
                this.sail_2_4.visible = true;
                this.sail_2_1_bottom.visible = false;
                this.sail_2_2_bottom.visible = false;
                this.sail_2_3_bottom.visible = false;
            }
        }

/*
        this.rope_4.visible = sail_0.visible;
        this.rope_5.visible = sail_0.visible;

        this.rope_7.visible = sail_1_bottom.visible;
        this.rope_8.visible = sail_1_bottom.visible;

        this.rope_11.visible = sail_2_bottom.visible;
        this.rope_12.visible = sail_2_bottom.visible;

        this.rope_19.visible = sail_3_bottom.visible;
        this.rope_20.visible = sail_3_bottom.visible;

        this.rope_16.visible = sail_4.visible;
        this.rope_15.visible = sail_4.visible;

 */

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        Dhow_Sail.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}