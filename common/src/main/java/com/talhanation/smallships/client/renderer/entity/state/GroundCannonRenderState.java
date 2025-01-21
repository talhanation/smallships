package com.talhanation.smallships.client.renderer.entity.state;

import com.talhanation.smallships.world.entity.cannon.Cannon;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class GroundCannonRenderState extends EntityRenderState {

    public ResourceLocation textureLocation;
    public Cannon cannon;
    public float partialTicks;
}
