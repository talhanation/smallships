package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/**
 * Stat block for the dockyard screen.
 *
 * Everything is shown as a percentage relative to the neutral 100%: a value
 * above 100% is a bonus (green), below is a penalty (red). The wind values come
 * from the ship class constants and are therefore available for the build
 * preview too. The live penalties (cargo, cannons, biome) only exist once a
 * real ship is docked, because they depend on its current load and position.
 */
public class ShipStatPanel {

    /** neutral, no effect */
    private static final int COLOR_NEUTRAL = 0xFFDDDDDD;
    /** slight bonus / slight penalty */
    private static final int COLOR_GOOD = 0xFF8CD97A;
    private static final int COLOR_BAD = 0xFFE08A7A;
    /** strong bonus / strong penalty */
    private static final int COLOR_BEST = 0xFF4CAF50;
    private static final int COLOR_WORST = 0xFFD9453D;

    private static final int LINE_HEIGHT = 10;
    /** x offset of the value column, relative to the panel x */
    private static final int VALUE_COLUMN = 74;

    /**
     * Maps a multiplier to a color: greener the better, redder the worse.
     * The thresholds are deliberately coarse so a player reads a tendency,
     * not a number.
     */
    public static int colorFor(float multiplier) {
        if (multiplier >= 1.20F) return COLOR_BEST;
        if (multiplier > 1.02F) return COLOR_GOOD;
        if (multiplier >= 0.98F) return COLOR_NEUTRAL;
        if (multiplier > 0.80F) return COLOR_BAD;
        return COLOR_WORST;
    }

    /** 0.55 -> "-45%", 1.45 -> "+45%", 1.0 -> "0%" */
    private static Component asPercent(float multiplier) {
        int percent = Math.round((multiplier - 1.0F) * 100.0F);
        if (percent == 0) return Component.literal("0%");
        return Component.literal((percent > 0 ? "+" : "") + percent + "%");
    }

    /**
     * Draws the panel and returns the y coordinate below it.
     *
     * @param ship        the docked ship, or null in build mode. Without a ship
     *                    only the wind profile is shown.
     * @param profileShip the ship the wind profile is read from - the docked
     *                    ship in modify mode, the build preview otherwise.
     * @return the y coordinate directly below the rendered panel
     */
    public static int render(GuiGraphics guiGraphics, Font font, int x, int y, Ship ship, Ship profileShip) {
        int line = y;

        if (profileShip != null) {
            guiGraphics.drawString(font, Component.translatable("gui.smallships.dockyard.stat.wind"), x, line, 0xFFFFAA33, false);
            line += LINE_HEIGHT + 2;

            line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.head_wind", profileShip.getHeadWindMultiplier());
            line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.side_wind", profileShip.getSideWindMultiplier());
            line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.tail_wind", profileShip.getTailWindMultiplier());

            float oarFactor = profileShip.getOarFactor();
            if (oarFactor > 0.0F) {
                // oars are not a bonus but a floor, so they are shown as an
                // absolute share of max speed instead of a +/- percentage
                line += 2;
                guiGraphics.drawString(font, Component.translatable("gui.smallships.dockyard.stat.oars"), x, line, 0xFFAAAAAA, false);
                guiGraphics.drawString(font, Component.literal(Math.round(oarFactor * 100.0F) + "%"), x + VALUE_COLUMN, line, COLOR_GOOD, false);
                line += LINE_HEIGHT;
            }
        }

        // live penalties: only meaningful for a ship that actually exists
        if (ship != null) {
            line += 6;
            guiGraphics.drawString(font, Component.translatable("gui.smallships.dockyard.stat.penalties"), x, line, 0xFFFFAA33, false);
            line += LINE_HEIGHT + 2;

            if (ship instanceof ContainerShip containerShip) {
                line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.cargo",
                        1.0F - containerShip.getContainerModifier() / 100.0F);
            }
            if (ship instanceof Cannonable cannonShip) {
                line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.cannons",
                        1.0F - cannonShip.getCannonModifier() / 100.0F);
            }
            line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.biome",
                    1.0F + ship.getBiomeModifier() / 100.0F);

            // the resulting ceiling, the product of all three
            line += 2;
            line = drawStat(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.max_speed", getTotalPenalty(ship));
        }

        return line;
    }

    /**
     * @return the product of all speed penalties, i.e. the fraction of the
     * configured max speed this ship can currently reach at best.
     */
    public static float getTotalPenalty(Ship ship) {
        return (1.0F + ship.getBiomeModifier() / 100.0F)
                * (ship instanceof Cannonable cannonShip ? 1.0F - cannonShip.getCannonModifier() / 100.0F : 1.0F)
                * (ship instanceof ContainerShip containerShip ? 1.0F - containerShip.getContainerModifier() / 100.0F : 1.0F);
    }

    private static int drawStat(GuiGraphics guiGraphics, Font font, int x, int y, String translationKey, float multiplier) {
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, 0xFFAAAAAA, false);
        guiGraphics.drawString(font, asPercent(multiplier), x + VALUE_COLUMN, y, colorFor(multiplier), false);
        return y + LINE_HEIGHT;
    }
}