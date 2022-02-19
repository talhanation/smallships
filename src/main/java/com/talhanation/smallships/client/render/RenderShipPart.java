package com.talhanation.smallships.client.render;
import com.talhanation.smallships.Main;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderShipPart extends EntityRenderer<Entity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID,"textures/entity/cog/oak_cog.png");


    public RenderShipPart(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity entity) {
        return TEXTURE;
    }

}