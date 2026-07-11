package com.talhanation.smallships.client.wind;

import com.talhanation.smallships.world.wind.Wind;
import net.minecraft.util.Mth;

/**
 * Client side mirror of the wind state. Updated by ClientboundWindPacket
 * whenever the server rolls a new target; between packets the client
 * interpolates the transition the same way the server does.
 */
public class ClientWindManager {
    private static float currentDirection;
    private static float currentStrength;
    private static float targetDirection;
    private static float targetStrength;
    private static int transitionTicks;

    private static float prevDirection;
    private static float prevStrength;

    public static void handleUpdate(float curDir, float curStr, float tarDir, float tarStr, int ticks) {
        currentDirection = curDir;
        currentStrength = curStr;
        targetDirection = tarDir;
        targetStrength = tarStr;
        transitionTicks = ticks;
        prevDirection = curDir;
        prevStrength = curStr;
    }

    /** Called once per client tick. */
    public static void tick() {
        prevDirection = currentDirection;
        prevStrength = currentStrength;
        if (transitionTicks > 0) {
            float progress = 1.0F / transitionTicks;
            currentDirection = Mth.wrapDegrees(currentDirection + Mth.wrapDegrees(targetDirection - currentDirection) * progress);
            currentStrength = Mth.lerp(progress, currentStrength, targetStrength);
            transitionTicks--;
        }
    }

    public static Wind getWind() {
        return new Wind(currentDirection, currentStrength);
    }

    public static float getDirection(float partialTicks) {
        return prevDirection + Mth.wrapDegrees(currentDirection - prevDirection) * partialTicks;
    }

    public static float getStrength(float partialTicks) {
        return Mth.lerp(partialTicks, prevStrength, currentStrength);
    }
}
