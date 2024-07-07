package com.talhanation.smallships.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CannonModel extends EntityModel<Ship> {
    @SuppressWarnings("unused")
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "cannon_model"), "main");
    private final ModelPart Cannon;

    public CannonModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.Cannon = root.getChild("Cannon");
    }


    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Cannon = partdefinition.addOrReplaceChild("Cannon", CubeListBuilder.create(), PartPose.offset(0.0F, 26.4F, -2.0F));

        PartDefinition AchseFront = Cannon.addOrReplaceChild("AchseFront", CubeListBuilder.create().texOffs(81, 42).addBox(-7.404F, -1.152F, -1.04F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-8.504F, 1.448F, -1.04F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 34).addBox(-8.404F, -1.452F, -0.54F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 34).addBox(-8.404F, 0.548F, -1.54F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(-8.304F, -1.452F, -1.54F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 33).addBox(-8.404F, -0.452F, 0.46F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(7.496F, 1.448F, -1.04F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 34).addBox(7.346F, -1.452F, -0.54F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 34).addBox(7.346F, 0.548F, -1.54F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(7.446F, -1.452F, -1.54F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 33).addBox(7.346F, -0.452F, 0.46F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(-9.304F, -0.452F, -0.54F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 53).addBox(7.296F, -0.452F, -0.54F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.404F, -4.848F, -4.96F));

        PartDefinition cube_r1 = AchseFront.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r2 = AchseFront.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r3 = AchseFront.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r4 = AchseFront.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r5 = AchseFront.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r6 = AchseFront.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r7 = AchseFront.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 0.7854F, 0.0F, 0.0F));

        PartDefinition AchseBack = Cannon.addOrReplaceChild("AchseBack", CubeListBuilder.create().texOffs(81, 42).addBox(-7.404F, -1.152F, -1.04F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-8.504F, 1.448F, -1.04F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 34).addBox(-8.404F, -1.452F, -0.54F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 34).addBox(-8.404F, 0.548F, -1.54F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(-8.304F, -1.452F, -1.54F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(-9.304F, -0.452F, -0.54F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 53).addBox(7.296F, -0.452F, -0.54F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 33).addBox(-8.404F, -0.452F, 0.46F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(7.496F, 1.448F, -1.04F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 34).addBox(7.346F, -1.452F, -0.54F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 34).addBox(7.346F, 0.548F, -1.54F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 48).addBox(7.446F, -1.452F, -1.54F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(92, 33).addBox(7.346F, -0.452F, 0.46F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.404F, -4.848F, 9.04F));

        PartDefinition cube_r8 = AchseBack.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r9 = AchseBack.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r10 = AchseBack.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r11 = AchseBack.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r12 = AchseBack.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r13 = AchseBack.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r14 = AchseBack.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(83, 10).addBox(-0.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 10).addBox(-16.5F, 1.4F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.996F, 0.048F, -0.04F, 0.7854F, 0.0F, 0.0F));

        PartDefinition Lauf = Cannon.addOrReplaceChild("Lauf", CubeListBuilder.create().texOffs(80, 0).addBox(-2.5F, 2.5F, -1.0F, 5.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, -2.5F, 9.2F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-1.5F, -1.4F, 10.3F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-1.0F, -1.0F, 11.2F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, -4.5F, -1.0F, 5.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(88, 0).addBox(-4.5F, -2.5F, -1.0F, 2.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(88, 0).addBox(2.5F, -2.5F, -1.0F, 2.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(78, 3).addBox(1.5F, -2.5F, -10.0F, 2.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(78, 3).addBox(-3.5F, -2.5F, -10.0F, 2.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(78, 3).addBox(1.5F, -2.0F, -17.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, -3.5F, -10.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.0F, 1.5F, -17.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.0F, -2.5F, -17.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(101, 9).addBox(-2.5F, -2.0F, -17.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.0F, -2.75F, -18.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.0F, 1.75F, -18.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(78, 3).addBox(1.75F, -2.0F, -18.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 9).addBox(-2.75F, -2.0F, -18.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, 1.5F, -10.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -13.4F, -2.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r15 = Lauf.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(88, 0).addBox(0.0F, -2.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 11.1F, 0.0F, 0.7418F, 0.0F));

        PartDefinition cube_r16 = Lauf.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(88, 0).addBox(-2.0F, -2.5F, -1.4F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 11.0F, 0.0F, -0.7418F, 0.0F));

        PartDefinition cube_r17 = Lauf.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(80, 0).addBox(-2.5F, -0.425F, -1.75F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 0).addBox(-2.5F, -0.425F, -1.75F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 11.0F, -0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r18 = Lauf.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(80, 0).addBox(-2.5F, -1.6F, -1.1F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 10.5F, 0.733F, 0.0F, 0.0F));

        PartDefinition Sides = Cannon.addOrReplaceChild("Sides", CubeListBuilder.create().texOffs(79, 4).addBox(6.0F, -13.9F, -8.25F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(88, 0).addBox(-6.0F, -9.1F, 11.8F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(73, 38).addBox(-6.5F, -9.0F, -8.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(71, 37).addBox(-6.5F, -9.0F, 2.0F, 2.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(82, 32).addBox(-6.5F, -11.0F, -8.0F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(96, 34).addBox(-6.5F, -14.0F, -8.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(74, 38).addBox(5.5F, -9.0F, 2.0F, 2.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(73, 39).addBox(5.5F, -9.0F, -8.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(84, 33).addBox(5.5F, -11.0F, -8.0F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(96, 34).addBox(5.5F, -14.0F, -8.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(79, 4).addBox(-6.0F, -13.9F, -8.25F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 42).addBox(-6.0F, -7.0F, 2.0F, 13.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(81, 42).addBox(-6.0F, -10.0F, -7.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r19 = Sides.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(88, 0).addBox(-2.0F, 1.9F, -3.7F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -15.0F, 5.0F, 0.7418F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }


    @Override
    public void setupAnim(@NotNull Ship entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        Cannon.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}
