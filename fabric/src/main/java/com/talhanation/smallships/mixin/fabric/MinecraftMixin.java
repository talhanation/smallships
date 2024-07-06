package com.talhanation.smallships.mixin.fabric;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import com.talhanation.smallships.client.gui.screens.inventory.ShipContainerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.gui.screens.Screen;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class) // This Mixin prevents the mouse from repositioning in the middle of the screen. This is the default with Forge's NetworkHooks.openScreen and is therefore only needed for the Fabric version.
public abstract class MinecraftMixin {
    @Shadow @Final public MouseHandler mouseHandler;
    @Shadow @Nullable public Screen screen;
    @Shadow public abstract Window getWindow();
    @Unique
    private Screen oldScreen;
    @Unique
    private int seenNull;
    @Unique
    private double oldMousePosX;
    @Unique
    private double oldMousePosY;

    @Inject(method = "setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At(value = "FIELD", target="Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", opcode = Opcodes.PUTFIELD, shift = At.Shift.BEFORE))
    private void setScreenSaveMousePosition(Screen screen, CallbackInfo ci) {
        if (this.screen == null) { // There is always 2 null values in between each ShipContainerScreen while switching pages, this accounts for that
            seenNull++;
            if (seenNull > 2) this.oldScreen = null;
        } else {
            seenNull = 0;
            this.oldScreen = this.screen;
        }

        if (this.screen instanceof ShipContainerScreen) {
            this.oldMousePosX = this.mouseHandler.xpos();
            this.oldMousePosY = this.mouseHandler.ypos();
        }
    }

    @Inject(method = "setScreen(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At(value = "INVOKE", target="Lnet/minecraft/client/gui/screens/Screen;init(Lnet/minecraft/client/Minecraft;II)V", shift = At.Shift.AFTER))
    private void setScreenApplyMousePosition(Screen screen, CallbackInfo ci) {
        if (screen instanceof ShipContainerScreen && this.oldScreen instanceof ShipContainerScreen) {
            // move and release mouse
            ((MouseHandlerAccessor) this.mouseHandler).setXpos(this.oldMousePosX);
            ((MouseHandlerAccessor) this.mouseHandler).setYpos(this.oldMousePosY);
            ((MouseHandlerAccessor) this.mouseHandler).setMouseGrabbed(false);
            InputConstants.grabOrReleaseMouse(this.getWindow().getWindow(), 212993, this.oldMousePosX, this.oldMousePosY);
        }
    }
}
