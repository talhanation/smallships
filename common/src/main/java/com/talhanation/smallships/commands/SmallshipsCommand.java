package com.talhanation.smallships.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.talhanation.smallships.world.wind.WindManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;

/**
 * /smallships wind setDirection <degrees>
 *
 * Sets the global wind direction of the current dimension. The input uses the
 * intuitive compass convention: NORTH = 0 degrees, counting CLOCKWISE
 * (east = 90, south = 180, west = 270). Internally this is converted to the
 * minecraft yaw convention (south = 0) used by the wind system.
 */
public class SmallshipsCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("smallships")
                .then(Commands.literal("wind")
                        .executes(context -> windInfo(context.getSource()))
                        .then(Commands.literal("info")
                                .executes(context -> windInfo(context.getSource())))
                        .then(Commands.literal("setDirection")
                                .requires(source -> source.hasPermission(2))
                                .then(Commands.argument("degrees", FloatArgumentType.floatArg(0.0F, 360.0F))
                                        .executes(context -> setWindDirection(context.getSource(), FloatArgumentType.getFloat(context, "degrees")))))
                        .then(Commands.literal("setStrength")
                                .requires(source -> source.hasPermission(2))
                                .then(Commands.argument("strength", FloatArgumentType.floatArg(0.0F, 1.0F))
                                        .executes(context -> setWindStrength(context.getSource(), FloatArgumentType.getFloat(context, "strength")))))));
    }

    private static int setWindStrength(CommandSourceStack source, float strength) {
        ServerLevel level = source.getLevel();
        WindManager.get(level).setWindStrength(level, strength);
        source.sendSuccess(() -> Component.translatable("commands.smallships.wind.set_strength", String.format("%.2f", strength)), true);
        return 1;
    }

    /** Debug output: current server side wind direction (compass) and strength. */
    private static int windInfo(CommandSourceStack source) {
        ServerLevel level = source.getLevel();
        var wind = WindManager.get(level).getWind();
        // mc yaw -> compass convention (north = 0, clockwise)
        float compass = Mth.wrapDegrees(wind.direction() + 180.0F);
        if (compass < 0.0F) compass += 360.0F;
        final float compassFinal = compass;
        source.sendSuccess(() -> Component.translatable("commands.smallships.wind.info", String.format("%.0f", compassFinal), String.format("%.2f", wind.strength())), false);
        return 1;
    }

    private static int setWindDirection(CommandSourceStack source, float compassDegrees) {
        ServerLevel level = source.getLevel();

        // compass convention (north = 0, clockwise) -> mc yaw convention (south = 0):
        // north(0)->180, east(90)->-90, south(180)->0, west(270)->90
        float mcYaw = Mth.wrapDegrees(compassDegrees - 180.0F);

        WindManager.get(level).setWindDirection(level, mcYaw);

        source.sendSuccess(() -> Component.translatable("commands.smallships.wind.set_direction", String.format("%.0f", compassDegrees)), true);
        return 1;
    }
}