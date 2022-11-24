package com.talhanation.smallships.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CannonModel extends EntityModel<Ship> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(SmallshipsMod.MOD_ID, "cannon_model"), "main");
    private final ModelPart cannon;

    public CannonModel() {
        ModelPart root = createBodyLayer().bakeRoot();
        this.cannon = root.getChild("cannon");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition cannon = partdefinition.addOrReplaceChild("cannon", CubeListBuilder.create().texOffs(80, 29).addBox(1.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(80, 29).addBox(-6.5F, -6.0F, -8.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(80, 29).addBox(-3.5F, -6.0F, 2.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(80, 29).addBox(-3.5F, -6.0F, -4.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(5.1F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(5.1F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(-8.0F, -3.75F, -6.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 15).addBox(-7.9F, -3.75F, 3.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.9F, 24.75F, 0.0F));

        PartDefinition achse2_r1 = cannon.addOrReplaceChild("achse2_r1", CubeListBuilder.create().texOffs(87, 58).addBox(-8.0F, -7.5F, -7.7F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(87, 58).addBox(-8.0F, -0.4F, -0.6F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.4F, 5.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r1 = cannon.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(80, 29).addBox(12.0F, -1.8F, -7.1F, 2.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(80, 29).addBox(4.0F, -1.85F, -7.1F, 2.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -6.0173F, 0.8198F, -0.2618F, 0.0F, 0.0F));

        PartDefinition lauf = cannon.addOrReplaceChild("lauf", CubeListBuilder.create().texOffs(89, 3).addBox(-2.0F, 1.9833F, -4.25F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, -3.0167F, -4.25F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-3.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(2.0F, -2.0167F, -4.25F, 1.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, -2.5167F, -12.25F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, 1.4833F, -12.25F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(1.5F, -2.0167F, -12.25F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, 1.7833F, -13.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(1.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, -2.8167F, -13.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.8F, -2.0167F, -13.25F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-2.0F, -2.0167F, 4.75F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-1.5F, -1.4167F, 7.75F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(89, 3).addBox(-1.0F, -0.9167F, 8.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -8.9833F, -2.75F, -0.0873F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(@NotNull Ship entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        cannon.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
