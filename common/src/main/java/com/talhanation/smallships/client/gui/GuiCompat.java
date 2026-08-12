package com.talhanation.smallships.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

/**
 * The one place in the GUI code that touches version specific drawing calls.
 *
 * Everything else in the dockyard screen draws through these three methods, so
 * a port to another Minecraft version only ever has to change this class
 * instead of hunting blit calls through a 1000 line screen.
 *
 * What actually differs:
 *
 * - 1.20.2+ has the sprite atlas ({@code GuiGraphics#blitSprite}, {@code WidgetSprites}).
 *   The nine slicing is described by the sprite json, the code just names it.
 * - 1.20.1 has no atlas. The same visuals come from
 *   {@code textures/gui/widgets.png} via {@code blitNineSliced(WIDGETS, x, y, w, h, 20, 4, 200, 20, 0, v)}
 *   with v = 46 (disabled), 66 (normal), 86 (hovered), on a 256x256 sheet.
 *   Only the bodies below change, no caller does.
 */
public final class GuiCompat {

    private static final ResourceLocation BUTTON = ResourceLocation.withDefaultNamespace("widget/button");
    private static final ResourceLocation BUTTON_DISABLED = ResourceLocation.withDefaultNamespace("widget/button_disabled");
    private static final ResourceLocation BUTTON_HIGHLIGHTED = ResourceLocation.withDefaultNamespace("widget/button_highlighted");

    private GuiCompat() {
    }

    /**
     * A window background blitted from a plain texture sheet.
     *
     * @param sheetSize edge length of the png the window sits in, top left corner
     */
    public static void blitWindow(GuiGraphics guiGraphics, ResourceLocation texture, int x, int y, int width, int height, int sheetSize) {
        guiGraphics.blit(texture, x, y, 0, 0, width, height, sheetSize, sheetSize);
    }

    /**
     * The vanilla button face, nine sliced to any size. Used for the tabs, the
     * dropdown and the upgrade rows, so nothing in the dockyard is hand drawn
     * pixel art that would fall out of sync with a resource pack.
     */
    public static void blitButton(GuiGraphics guiGraphics, int x, int y, int width, int height, boolean active, boolean highlighted) {
        ResourceLocation sprite = !active ? BUTTON_DISABLED : (highlighted ? BUTTON_HIGHLIGHTED : BUTTON);
        guiGraphics.blitSprite(sprite, x, y, width, height);
    }

    /**
     * A one pixel frame in the given ARGB color. Kept here next to the button
     * face because the two are always drawn as a pair on the upgrade rows.
     */
    public static void frame(GuiGraphics guiGraphics, int x, int y, int width, int height, int color) {
        guiGraphics.fill(x, y, x + width, y + 1, color);
        guiGraphics.fill(x, y + height - 1, x + width, y + height, color);
        guiGraphics.fill(x, y + 1, x + 1, y + height - 1, color);
        guiGraphics.fill(x + width - 1, y + 1, x + width, y + height - 1, color);
    }
}