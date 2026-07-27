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
     * The three wind zones. Deliberately coarse: a player must be able to read
     * his situation at a glance without learning points of sail terminology.
     * Each ship carries one multiplier per zone (see Ship.getWindMultiplier),
     * and those three multipliers always sum to 3.0 so that no ship is globally
     * better in wind - it only distributes its strength differently.
     */
    public enum Zone {
        /** wind comes from ahead, 0-45 deg off the bow */
        HEAD_WIND,
        /** wind comes from the side, 45-135 deg off the bow */
        SIDE_WIND,
        /** wind comes from astern, 135-180 deg off the bow */
        TAIL_WIND
    }

    /**
     * @param yaw the yaw of e.g. a ship in degrees
     * @return the wind zone the ship is currently in. Note the convention:
     * a small difference between wind direction and ship yaw means the wind
     * blows the SAME way the ship heads, which is a tail wind (same convention
     * as getAlignment, where +1 = tailwind).
     */
    public Zone getZone(float yaw) {
        float angle = Math.abs(Mth.wrapDegrees(this.direction - yaw));
        if (angle <= 45.0F) return Zone.TAIL_WIND;
        if (angle >= 135.0F) return Zone.HEAD_WIND;
        return Zone.SIDE_WIND;
    }

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