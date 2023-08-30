package com.talhanation.smallships.client.renderer.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.model.BriggModel;
import com.talhanation.smallships.client.model.sail.BriggSailModel;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.world.block.ShipyardBlock;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.shipyard.ShipyardShip;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.stream.Stream;


public class ShipyardShipRenderer<T extends Ship> implements BlockEntityRenderer<ShipyardShip> {
    protected final Map<Boat.Type, Pair<ResourceLocation, BriggModel>> boatResources;

    public ShipyardShipRenderer(BlockEntityRendererProvider.Context context) {
        this.boatResources = Stream.of(Boat.Type.values()).collect(ImmutableMap.toImmutableMap(
                (type) -> type,
                (type) -> Pair.of(
                        this.getTextureLocation(type),
                        this.createModel(context, type))));
    }

    protected BriggModel createModel(BlockEntityRendererProvider.Context context, Boat.Type type) {
        return new BriggModel(context.bakeLayer(BriggModel.LAYER_LOCATION));
    }

    protected ResourceLocation getTextureLocation(Boat.Type type) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, "textures/entity/ship/" + getNameFromType(type) + ".png");
    }

    public static String getNameFromType(Boat.Type type) {
        return type.getName().replace(":", "/");
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

    private void renderProgress(BlockState blockState, BriggModel model, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight) {
        int progress = blockState.getValue(ShipyardBlock.PROGRESS);

        ModelPart root = model.root();
        ModelPart brigg = root.getChild("ModelBrigg");
        ModelPart sides = brigg.getChild("sides_brigg");
        ModelPart banner = brigg.getChild("BannerStick");
        ModelPart steer = brigg.getChild("BannerStick");

        ModelPart bottom = brigg.getChild("bottom_brigg");
        ModelPart part1 = bottom.getChild("cube_r1");
        ModelPart part2 = bottom.getChild("cube_r2");
        ModelPart part3 = bottom.getChild("cube_r3");
        ModelPart part4 = bottom.getChild("cube_r4");
        ModelPart part5 = bottom.getChild("cube_r5");
        ModelPart part6 = bottom.getChild("cube_r6");

        sides.visible = false;
        steer.visible = false;
        banner.visible = false;
        part1.visible = false;
        part2.visible = false;
        part3.visible = false;
        part4.visible = false;
        part5.visible = false;
        part6.visible = false;
        bottom.visible = false;

        if (progress >= 1) {
            bottom.visible = true;
            part5.visible = true; // bottom
            part6.visible = true; // bottom
        }

        if (progress >= 2) {
            steer.visible = true;
            part1.visible = true;
            part2.visible = true;
            part3.visible = true;
            part4.visible = true;
        }

        if (progress >= 3) {

            sides.visible = true;
        }

        if (progress == 4) {
            banner.visible = true;

            BriggSailModel sailModel = new BriggSailModel();
            sailModel.setupAnim(null, 0, 0.0F, -0.1F, 0.0F, 0.0F);
            VertexConsumer sailVertexConsumer = multiBufferSource.getBuffer(sailModel.renderType(SailModel.getSailColor(SailModel.Color.WHITE.toString()).location));
            sailModel.renderToBuffer(poseStack, sailVertexConsumer, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public void render(ShipyardShip blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int j) {
        BlockState blockState = blockEntity.getBlockState();
        Pair<ResourceLocation, BriggModel> pair = this.boatResources.get(Boat.Type.OAK);
        ResourceLocation resourceLocation = pair.getFirst();
        BriggModel shipModel = pair.getSecond();

        shipModel.setupAnim(null, 0 ,0, 0, 0 ,0 );
        Direction direction = blockState.getValue(ShipyardBlock.FACING);

        poseStack.scale(-1.3F, -1.3F, 1.3F);
        float stepX = direction.getStepX();
        float stepZ = direction.getStepZ();
        float xOffset = stepX * 2F - (0.38F * Math.abs(stepX)) - Math.abs(0.4F * stepZ);
        float zOffset = -(stepZ * 2F - (0.38F * Math.abs(stepZ))) + Math.abs(0.4F * stepX);
        poseStack.translate(xOffset, -1.7F, zOffset);

        poseStack.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        renderProgress(blockState, shipModel, poseStack, multiBufferSource, combinedLight);

        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(shipModel.renderType(resourceLocation));
        shipModel.renderToBuffer(poseStack, vertexConsumer, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
