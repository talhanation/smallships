package com.talhanation.smallships.world.wind;

import net.minecraft.util.Mth;

/**
 * Immutable snapshot of the global wind state.
 * direction is in degrees [0, 360), using the same convention as entity yaw
 * (0 = south/+Z, 90 = west/-X). strength is in [0, 1].
 */
public record Wind(float direction, float strength) {
    public static final Wind CALM = new Wind(0.0F, 0.0F);

    /**
     * @param yaw the yaw of e.g. a ship in degrees
     * @return alignment between wind direction and the given yaw:
     * +1 = tailwind (wind blows the same way the ship is heading),
     * -1 = headwind, 0 = crosswind.
     */
    public float getAlignment(float yaw) {
        return Mth.cos((float) Math.toRadians(Mth.wrapDegrees(this.direction - yaw)));
    }

    /**
     * @return the normalized x component of the wind movement direction.
     */
    public float getMotionX() {
        return -Mth.sin((float) Math.toRadians(this.direction));
    }

    /**
     * @return the normalized z component of the wind movement direction.
     */
    public float getMotionZ() {
        return Mth.cos((float) Math.toRadians(this.direction));
    }
}
