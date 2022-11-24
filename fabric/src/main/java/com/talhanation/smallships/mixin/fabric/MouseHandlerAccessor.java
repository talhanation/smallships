package com.talhanation.smallships.mixin.fabric;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MouseHandler.class)
public interface MouseHandlerAccessor {
    @Accessor
    void setMouseGrabbed(boolean mouseGrabbed);

    @Accessor
    void setXpos(double xpos);

    @Accessor
    void setYpos(double ypos);
}
