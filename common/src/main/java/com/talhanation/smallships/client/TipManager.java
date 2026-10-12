package com.talhanation.smallships.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.List;

/**
 * The control tips above the hotbar, SiegeWeapons style: a few lines of
 * "[key] - what it does" that stay for a while and then fade out.
 *
 * This class only knows HOW tips are shown. WHICH tips a player gets is decided
 * by whoever calls showTips, see {@link ShipTipHandler}.
 *
 * Hooked like CannonAmmoHandler: tick from ClientTickHandler, render from the
 * platform GUI hook (Forge: RenderGuiEvent.Post in ClientForgeBus, Fabric:
 * GuiMixin).
 */
public class TipManager {
    private static final int TOTAL_DURATION = 300;
    private static final int FADE_DURATION = 40;
    private static final int LINE_SPACING = 2;

    private static int remainingTicks = 0;
    private static List<Component> currentTips = List.of();

    public static void showTips(List<Component> tips) {
        remainingTicks = TOTAL_DURATION;
        currentTips = tips;
    }

    /** Takes the tips off the screen right away, without the fade. */
    public static void clear() {
        remainingTicks = 0;
        currentTips = List.of();
    }

    public static void tick() {
        if (remainingTicks > 0) remainingTicks--;
    }

    public static float getFadeAlpha() {
        if (remainingTicks > FADE_DURATION) return 1.0F;
        return remainingTicks / (float) FADE_DURATION;
    }

    public static List<Component> getCurrentTips() {
        return currentTips;
    }

    public static void render(GuiGraphics guiGraphics) {
        List<Component> tips = getCurrentTips();
        float alpha = getFadeAlpha();
        if (alpha <= 0 || tips.isEmpty()) return;

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.options.hideGui) return;

        Font font   = minecraft.font;
        int sw      = minecraft.getWindow().getGuiScaledWidth();
        int sh      = minecraft.getWindow().getGuiScaledHeight();
        int color   = (int) (alpha * 255) << 24 | 0xFFFFFF;
        int yStart  = (int) (sh / 1.25F);

        // the last tip sits on yStart and the list grows upwards from there,
        // so it reads top down in the order it was handed over
        for (int i = 0; i < tips.size(); i++) {
            guiGraphics.drawString(font, tips.get(i),
                    sw / 2 - 90,
                    yStart - ((tips.size() - 1 - i) * (font.lineHeight + LINE_SPACING)),
                    color, false);
        }
    }
}
