package com.talhanation.smallships.client.gui.screens.inventory;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.math.Kalkuel;
import com.talhanation.smallships.world.entity.ship.Attributes;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Shieldable;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

/**
 * The left column of the dockyard screen: raw attributes, the wind profile and
 * the ships' special notes.
 *
 * The attribute block shows plain numbers - they are the values a player
 * compares two hulls by. Wind is the exception: those three multipliers only
 * mean something relative to the neutral 100%, so they stay percentages and
 * keep their color coding.
 *
 * A ship is passed twice on purpose: {@code ship} is the DOCKED ship and is
 * null in build mode, {@code displayShip} is whatever is shown in the preview -
 * the docked ship or the build dummy. Only values that need a ship that really
 * exists (current crew, current damage, live penalties) read from {@code ship}.
 */
public class ShipStatPanel {

    private static final int COLOR_HEADER = 0xFFFFAA33;
    private static final int COLOR_LABEL = 0xFFAAAAAA;
    private static final int COLOR_VALUE = 0xFFDDDDDD;

    /** neutral, no effect */
    private static final int COLOR_NEUTRAL = 0xFFDDDDDD;
    /** slight bonus / slight penalty */
    private static final int COLOR_GOOD = 0xFF8CD97A;
    private static final int COLOR_BAD = 0xFFE08A7A;
    /** strong bonus / strong penalty */
    private static final int COLOR_BEST = 0xFF4CAF50;
    private static final int COLOR_WORST = 0xFFD9453D;

    private static final int LINE_HEIGHT = 9;
    private static final int HEADER_HEIGHT = 10;
    /** vertical air between two blocks */
    private static final int BLOCK_GAP = 4;

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
     * Draws the whole column and returns the y coordinate below it.
     *
     * @param width       the usable panel width; values are right aligned to it
     * @param ship        the docked ship, or null in build mode
     * @param displayShip the ship shown in the preview, never null in practice
     */
    public static int render(GuiGraphics guiGraphics, Font font, int x, int y, int width,
                             @Nullable Ship ship, @Nullable Ship displayShip) {
        if (displayShip == null) return y;

        Attributes attributes = displayShip.getAttributes();
        int line = y;

        /* ---------------- attributes ---------------- */

        line = header(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.attributes");
        line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.max_speed", speedText(attributes.maxSpeed));
        line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.turning", number(attributes.maxRotationSpeed));
        line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.crew",
                ship != null ? ship.getPassengers().size() + "/" + ship.getMaxPassengers() : String.valueOf(displayShip.getMaxPassengers()));
        line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.hull_hp",
                ship != null ? Mth.ceil(Math.max(0.0F, attributes.maxHealth - ship.getDamage())) + "/" + Mth.ceil(attributes.maxHealth)
                        : String.valueOf(Mth.ceil(attributes.maxHealth)));

        if (displayShip instanceof Sailable) {
            line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.sails_hp",
                    ship != null ? Mth.ceil(SailDamage.getHealth(ship)) + "/" + Mth.ceil(SailDamage.MAX_HEALTH)
                            : String.valueOf(Mth.ceil(SailDamage.MAX_HEALTH)));
        }
        if (displayShip instanceof Cannonable cannonable) {
            line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.cannons",
                    ship instanceof Cannonable dockedCannons ? dockedCannons.getCannonCount() + "/" + cannonable.getTotalCannonSlots()
                            : String.valueOf(cannonable.getTotalCannonSlots()));
        } else if (displayShip instanceof Shieldable shieldable) {
            line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.shields",
                    ship instanceof Shieldable dockedShields ? dockedShields.getShields().size() + "/" + shieldable.getMaxShieldsPerSide() * 2
                            : String.valueOf(shieldable.getMaxShieldsPerSide() * 2));
        }
        if (displayShip instanceof ContainerShip containerShip) {
            line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.cargo",
                    String.valueOf(containerShip.getContainerSize()));
        }

        /* ---------------- wind profile ---------------- */

        line += BLOCK_GAP;
        line = header(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.wind");
        line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.head_wind", displayShip.getHeadWindMultiplier());
        line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.side_wind", displayShip.getSideWindMultiplier());
        line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.tail_wind", displayShip.getTailWindMultiplier());

        float oarFactor = displayShip.getOarFactor();
        if (oarFactor > 0.0F) {
            // oars are not a bonus but a floor, so they are shown as an
            // absolute share of max speed instead of a +/- percentage
            line = value(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.oars",
                    Math.round(oarFactor * 100.0F) + "%");
        }

        /* ---------------- special ---------------- */

        line += BLOCK_GAP;
        line = header(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.special");

        if (ship != null) {
            // live penalties: only meaningful for a ship that actually exists
            if (ship instanceof ContainerShip containerShip && containerShip.isEffectedByCargoPenalty()) {
                line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.penalty_cargo",
                        1.0F - containerShip.getContainerModifier() / 100.0F);
            }
            if (ship instanceof Cannonable cannonShip) {
                line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.penalty_cannons",
                        1.0F - cannonShip.getCannonModifier() / 100.0F);
            }
            line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.penalty_biome",
                    1.0F + ship.getBiomeModifier() / 100.0F);
            // the resulting ceiling, the product of all of them
            line = multiplier(guiGraphics, font, x, line, width, "gui.smallships.dockyard.stat.penalty_total", getTotalPenalty(ship));
        } else {
            // build mode: name the penalties this hull will never suffer from,
            // that is what makes one type worth building over another
            if (!(displayShip instanceof ContainerShip containerShip) || !containerShip.isEffectedByCargoPenalty()) {
                line = note(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.no_cargo_penalty");
            }
            if (!(displayShip instanceof Cannonable)) {
                line = note(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.no_cannon_penalty");
            }
            if (displayShip.getOarFactor() > 0.0F) {
                line = note(guiGraphics, font, x, line, "gui.smallships.dockyard.stat.wind_independent");
            }
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

    /* ---------------- line helpers ---------------- */

    private static int header(GuiGraphics guiGraphics, Font font, int x, int y, String translationKey) {
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, COLOR_HEADER, false);
        return y + HEADER_HEIGHT;
    }

    /** label left, plain value right aligned to the panel edge */
    private static int value(GuiGraphics guiGraphics, Font font, int x, int y, int width, String translationKey, String value) {
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, COLOR_LABEL, false);
        guiGraphics.drawString(font, value, x + width - font.width(value), y, COLOR_VALUE, false);
        return y + LINE_HEIGHT;
    }

    /** label left, color coded percentage right aligned to the panel edge */
    private static int multiplier(GuiGraphics guiGraphics, Font font, int x, int y, int width, String translationKey, float value) {
        Component percent = asPercent(value);
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, COLOR_LABEL, false);
        guiGraphics.drawString(font, percent, x + width - font.width(percent), y, colorFor(value), false);
        return y + LINE_HEIGHT;
    }

    /** a full width note without a value column */
    private static int note(GuiGraphics guiGraphics, Font font, int x, int y, String translationKey) {
        guiGraphics.drawString(font, Component.translatable(translationKey), x, y, COLOR_GOOD, false);
        return y + LINE_HEIGHT;
    }

    /** one decimal is enough - the raw attribute floats carry no more meaning than that */
    private static String number(float value) {
        return String.format("%.1f", value);
    }

    /** max speed in the unit the player picked in the client config */
    private static String speedText(float maxSpeed) {
        return switch (SmallShipsConfig.Client.shipModSpeedUnit.get()) {
            case 1 -> Mth.ceil(Kalkuel.getMeterPerSecond(maxSpeed)) + " m/s";
            case 2 -> Mth.ceil(Kalkuel.getKnots(maxSpeed)) + " kn";
            case 3 -> Mth.ceil(Kalkuel.getMilesPerHour(maxSpeed)) + " mph";
            default -> Mth.ceil(Kalkuel.getKilometerPerHour(maxSpeed)) + " km/h";
        };
    }
}