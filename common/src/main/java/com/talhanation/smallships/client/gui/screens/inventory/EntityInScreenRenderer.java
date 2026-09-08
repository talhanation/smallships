package com.talhanation.smallships.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class EntityInScreenRenderer {

    public static void renderEntityInInventoryRotating(GuiGraphics p_282802_, int p_275688_, int p_275245_, int p_275535_, Entity entity, float rotationSpeed, float scale) {
        Minecraft mc = Minecraft.getInstance();
        float rotation = (mc.level != null ? mc.level.getGameTime() : mc.gui.getGuiTicks()) * rotationSpeed % 360;

        Quaternionf rotationQuaternion =
                new Quaternionf()
                .rotateX((float) Math.PI)
                .rotateY(rotation * ((float) Math.PI / 180F));
        renderEntityInInventory(p_282802_, p_275688_, p_275245_, p_275535_, rotationQuaternion, entity, rotation, scale);
    }

    public static void renderEntityInInventory(GuiGraphics guiGraphics, int p_283622_, int p_283401_, int p_281360_, Quaternionf p_281880_, Entity entity, float rotation, float scale) {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((double) p_283622_, (double) p_283401_, 50.0D);
        guiGraphics.pose().mulPoseMatrix((new Matrix4f()).scaling((float) p_281360_, (float) p_281360_, (float) (-p_281360_)));
        guiGraphics.pose().mulPose(p_281880_);
        guiGraphics.pose().scale(scale,scale,scale);
        Lighting.setupForEntityInInventory();

        EntityRenderDispatcher entityrenderdispatcher = Minecraft.getInstance().getEntityRenderDispatcher();

        float prevYRot = entity.getYRot();
        entity.setYRot(rotation);

        entityrenderdispatcher.setRenderShadow(false);
        RenderSystem.runAsFancy(() -> {
            entityrenderdispatcher.render(entity, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, guiGraphics.pose(), guiGraphics.bufferSource(), 15728880);
        });
        guiGraphics.flush();
        entityrenderdispatcher.setRenderShadow(true);

        entity.setYRot(prevYRot);
        guiGraphics.pose().popPose();
        Lighting.setupFor3DItems();
    }



}