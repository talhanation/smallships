package com.talhanation.smallships.client.camera;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

/**
 * Handles the smooth transition of the third person camera anchor from the
 * player position to the ship center after mounting a ship ("aim and align").
 */
public class ShipCameraHandler {
    private static final int TRANSITION_TICKS = 10;

    private static int transitionTicksLeft = 0;

    /** whether the local player sat at a helm last tick */
    private static boolean wasDriving = false;
    /**
     * The camera the player had before the helm switched him to third person.
     * Null if the switch did not happen - he was in third person already, or
     * the config is off - so leaving the helm has nothing to give back.
     */
    @Nullable
    private static CameraType previousCameraType = null;

    /** Called client side when the local player mounts a ship. */
    public static void startTransition() {
        transitionTicksLeft = TRANSITION_TICKS;
    }

    /** Called once per client tick. */
    public static void tick(Minecraft minecraft) {
        if (transitionTicksLeft > 0) transitionTicksLeft--;
        tickAutoThirdPerson(minecraft);
    }

    /**
     * Switches to third person when the local player takes the helm, and back
     * to his own camera when he leaves it - by dismounting or by moving to
     * another seat. Passengers and gunners are left alone.
     *
     * Watched from here and NOT from Ship#addPassenger: the seat is assigned
     * on the server, so at the moment the client adds the passenger it cannot
     * know yet whether he sits at the helm. The old hook asked for the client
     * inside the server only seat branch and therefore never fired.
     */
    private static void tickAutoThirdPerson(Minecraft minecraft) {
        LocalPlayer player = minecraft.player;
        boolean driving = player != null && player.getVehicle() instanceof Ship ship && player.equals(ship.getDriver());
        if (driving == wasDriving) return;
        wasDriving = driving;

        if (driving) {
            if (!SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get()) return;
            CameraType cameraType = minecraft.options.getCameraType();
            // already looking from outside: nothing to switch, nothing to give back
            if (!cameraType.isFirstPerson()) return;

            previousCameraType = cameraType;
            minecraft.options.setCameraType(CameraType.THIRD_PERSON_BACK);
        } else if (previousCameraType != null) {
            // only give it back if the player kept the view the helm gave him -
            // a camera he picked himself at the helm stays his
            if (minecraft.options.getCameraType() == CameraType.THIRD_PERSON_BACK) {
                minecraft.options.setCameraType(previousCameraType);
            }
            previousCameraType = null;
        }
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