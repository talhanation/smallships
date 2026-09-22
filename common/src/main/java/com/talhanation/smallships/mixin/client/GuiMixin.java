package com.talhanation.smallships.mixin.client;

import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.client.cannon.CannonAmmoHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Draws the mouse wheel ammo picker on top of the finished HUD.
 *
 * TAIL, so the icons sit above the crosshair and hotbar rather than under them.
 *
 * ON FABRIC ONLY, even though this class sits in common and applies on every
 * loader. Forge 1.20.1 replaces Minecraft#gui with a ForgeGui, and that one
 * OVERRIDES render without calling super - so this inject is applied cleanly
 * and then never runs, with nothing in the log to say so. The forge side draws
 * the picker from RenderGuiEvent.Post instead, see ClientForgeBus; that event
 * is fired at the end of ForgeGui#render, which is the same spot TAIL means
 * here. The two therefore never both fire.
 *
 * 1.21 dropped ForgeGui when Mojang introduced the layered HUD, which is why
 * the mixin alone was enough there.
 *
 * The method is matched by NAME only: Gui has a single render method, and its
 * second parameter is a plain partial tick here while 1.21 hands over a
 * DeltaTracker - pinning the full descriptor would only make this brittle.
 */
@Mixin(Gui.class)
public abstract class GuiMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void smallships$renderAmmoPicker(GuiGraphics guiGraphics, float partialTick, CallbackInfo ci) {
        CannonAmmoHandler.render(guiGraphics);
    }

    /**
     * No crosshair while a cannon is aimed - same check as the hand in
     * ItemInHandRendererMixin. Runs on Forge too: ForgeGui's CROSSHAIR overlay
     * calls this very method instead of overriding it.
     */
    @Inject(method = "renderCrosshair", at = @At("HEAD"), cancellable = true)
    private void smallships$hideCrosshairWhileAiming(GuiGraphics guiGraphics, CallbackInfo ci) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;
        if (player.getVehicle() instanceof GroundCannonEntity cannon ? cannon.isAiming() : CannonAimHandler.isAiming()) ci.cancel();
    }
}