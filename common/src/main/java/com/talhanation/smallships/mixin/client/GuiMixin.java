package com.talhanation.smallships.mixin.client;

import com.talhanation.smallships.client.cannon.CannonAmmoHandler;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Draws the mouse wheel ammo picker on top of the finished HUD.
 *
 * A mixin rather than the platforms' own HUD render events, because those have
 * to be registered separately in every loader module, and a forgotten
 * registration fails silently - the picker simply never appears, with nothing
 * in the log to say why. This class travels with the common module and only
 * needs its entry in the client mixin config, next to MouseHandlerMixin.
 *
 * TAIL, so the icons sit above the crosshair and hotbar rather than under them.
 *
 * The method is matched by NAME only: Gui has a single render method, and the
 * DeltaTracker parameter has moved around between 1.21 point releases, so
 * pinning the full descriptor would only make this brittle for no gain.
 */
@Mixin(Gui.class)
public abstract class GuiMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void smallships$renderAmmoPicker(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        CannonAmmoHandler.render(guiGraphics);
    }
}