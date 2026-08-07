package com.talhanation.smallships.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Draws nothing. Ship parts are pure collision geometry - the ship model is
 * drawn by the ship itself.
 *
 * This class exists only because vanilla refuses to start with an entity type
 * that has no renderer: EntityRenderers validates every registered type on
 * client init and throws.
 *
 * Deliberately NOT overriding shouldRender: the hitbox wireframe is drawn by
 * EntityRenderDispatcher after this method, so leaving the entity in the render
 * pass is what makes the parts visible on F3 + B. That is the only way to check
 * whether a part really sits where it was meant to.
 */
public class ShipPartRenderer extends EntityRenderer<ShipPartEntity> {

    public ShipPartRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(@NotNull ShipPartEntity partEntity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight) {
    }

    /**
     * Keeps the parts out of the render loop entirely unless the hitboxes are
     * on. A brigg carries nine of them and every one would otherwise be culled,
     * sorted and dispatched every frame just to draw nothing.
     */
    @Override
    public boolean shouldRender(@NotNull ShipPartEntity partEntity, @NotNull Frustum frustum, double camX, double camY, double camZ) {
        return this.entityRenderDispatcher.shouldRenderHitBoxes() && super.shouldRender(partEntity, frustum, camX, camY, camZ);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ShipPartEntity partEntity) {
        return MissingTextureAtlasSprite.getLocation();
    }
}