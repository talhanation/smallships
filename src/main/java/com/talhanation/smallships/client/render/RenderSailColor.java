package com.talhanation.smallships.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.client.model.ModelCogSail;
import com.talhanation.smallships.entities.AbstractSailShip;
import com.talhanation.smallships.entities.CogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RenderSailColor {
    public static void renderSailColor(AbstractSailShip ship, float partialTicks, PoseStack matrixStackIn, String sailColor ,MultiBufferSource bufferIn,  int packedLight) {
        ModelCogSail model = new ModelCogSail();
        matrixStackIn.pushPose();
        model.setupAnim((CogEntity) ship, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(model.renderType(getSailColor(sailColor)));
        model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-90F));
        matrixStackIn.popPose();
    }

    private static final ResourceLocation WHITE =      (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/white_sail.png"));
    private static final ResourceLocation ORANGE =     (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/orange_sail.png"));
    private static final ResourceLocation MAGENTA =    (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/magenta_sail.png"));
    private static final ResourceLocation LIGHT_BLUE = (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/light_blue_sail.png"));
    private static final ResourceLocation YELLOW =     (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/yellow_sail.png"));
    private static final ResourceLocation LIME =       (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/lime_sail.png"));
    private static final ResourceLocation PINK =       (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/pink_sail.png"));
    private static final ResourceLocation GRAY =       (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/gray_sail.png"));
    private static final ResourceLocation LIGHT_GRAY = (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/light_gray_sail.png"));
    private static final ResourceLocation CYAN =       (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/cyan_sail.png"));
    private static final ResourceLocation PURPLE =     (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/purple_sail.png"));
    private static final ResourceLocation BLUE =       (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/blue_sail.png"));
    private static final ResourceLocation BROWN =      (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/brown_sail.png"));
    private static final ResourceLocation GREEN =      (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/green_sail.png"));
    private static final ResourceLocation RED =        (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/red_sail.png"));
    private static final ResourceLocation BLACK =      (new ResourceLocation(Main.MOD_ID,"textures/entity/sail/black_sail.png"));


    private static ResourceLocation getSailColor(String color) {
        return switch (color) {
            case "white" -> WHITE;
            case "orange" -> ORANGE;
            case "magenta" -> MAGENTA;
            case "light_blue" -> LIGHT_BLUE;
            case "yellow" -> YELLOW;
            case "lime" -> LIME;
            case "pink" -> PINK;
            case "purple" -> PURPLE;
            case "gray" -> GRAY;
            case "light_gray" -> LIGHT_GRAY;
            case "cyan" -> CYAN;
            case "blue" -> BLUE;
            case "brown" -> BROWN;
            case "green" -> GREEN;
            case "red" -> RED;
            case "black" -> BLACK;
            default -> WHITE;
        };
    }

}
