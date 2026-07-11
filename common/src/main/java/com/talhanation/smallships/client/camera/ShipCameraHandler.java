package com.talhanation.smallships.client.camera;

import net.minecraft.util.Mth;

/**
 * Handles the smooth transition of the third person camera anchor from the
 * player position to the ship center after mounting a ship ("aim and align").
 */
public class ShipCameraHandler {
    private static final int TRANSITION_TICKS = 10;

    private static int transitionTicksLeft = 0;

    /** Called client side when the local player mounts a ship. */
    public static void startTransition() {
        transitionTicksLeft = TRANSITION_TICKS;
    }

    /** Called once per client tick. */
    public static void tick() {
        if (transitionTicksLeft > 0) transitionTicksLeft--;
    }

    /**
     * @return the interpolation factor between player anchor (0.0) and
     * ship center anchor (1.0).
     */
    public static float getAnchorBlend(float partialTicks) {
        if (transitionTicksLeft <= 0) return 1.0F;
        float progress = 1.0F - (transitionTicksLeft - partialTicks) / (float) TRANSITION_TICKS;
        return Mth.clamp(progress, 0.0F, 1.0F);
    }
}
