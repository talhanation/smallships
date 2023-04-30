package com.talhanation.smallships.math;

import net.minecraft.util.Mth;

public class Kalkuel {

    /**
     * Subtracts from the provided number, but does not cross zero
     *
     * @param num the number
     * @param sub the amount to subtract
     * @return the resulting number
     */
    public static float subtractToZero(float num, float sub) {
        float erg;
        if (num < 0F) {
            erg = num + sub;
            if (erg > 0F) {
                erg = 0F;
            }
        }
        else {
            erg = num - sub;
            if (erg < 0F) {
                erg = 0F;
            }
        }
        return erg;
    }

    /**
     * Subtracts and adds from the provided number, but does not cross the set point
     *
     * @param current the current number
     * @param positiveChange the amount to add
     * @param negativeChange the amount to subtract
     * @param setPoint the amount to not cross
     * @return the resulting number
     */
    public static float changeToSoll(float current, float positiveChange, float negativeChange, float setPoint) {
        float erg;
        if (current < setPoint) {
            erg = current + positiveChange;
            if (erg > setPoint) {
                erg = setPoint;
            }
        }
        else {
            erg = current - negativeChange;
            if (erg < setPoint) {
                erg = setPoint;
            }
        }
        return erg;
    }

    public static double calculateMotionX(float speed, float rotationYaw) {
        return Mth.sin(-rotationYaw * 0.017453292F) * speed;
    }

    public static double calculateMotionZ(float speed, float rotationYaw) {
        return Mth.cos(rotationYaw * 0.017453292F) * speed;
    }
}
