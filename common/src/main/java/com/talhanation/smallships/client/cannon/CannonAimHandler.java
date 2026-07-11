package com.talhanation.smallships.client.cannon;

import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundSetCannonAimPacket;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * Client side handler for the "Better Cannon Gameplay" aiming:
 * While the driver of a cannon ship holds the cannon aim key (default:
 * Left Alt), mouse movement is captured (the camera does not turn) and
 * adjusts the broadside aim instead.
 * Up/Down = angle (-20..+60), Left/Right = rotation (-10..+10).
 *
 * The aim is synced to the server throttled (every 3 ticks while dragging
 * and once on release).
 */
public class CannonAimHandler {
    private static final float MOUSE_SENSITIVITY = 0.15F;
    private static final int SYNC_INTERVAL_TICKS = 3;

    private static boolean aiming = false;
    private static boolean dirty = false;
    private static boolean lastRightSide = false;
    private static float angle;
    private static float rotation;
    private static int tickCounter = 0;

    /**
     * @return true if the aiming mode is currently active, i.e. mouse movement
     * should be captured instead of turning the camera.
     */
    public static boolean isAiming() {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.screen != null) return false;
        if (!(player.getVehicle() instanceof Ship ship) || !(ship instanceof Cannonable cannonable)) return false;
        if (!player.equals(ship.getDriver())) return false;
        if (cannonable.getCannonCount() <= 0) return false;
        return ModGameOptions.CANNON_AIM_KEY.isDown();
    }

    /**
     * Called by the MouseHandler mixin with the accumulated mouse deltas
     * while aiming is active.
     */
    public static void handleMouseDelta(double deltaX, double deltaY) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || !(player.getVehicle() instanceof Ship ship) || !(ship instanceof Cannonable cannonable)) return;

        boolean rightSide = isLookingAtStarboard(player, ship);
        if (!aiming || rightSide != lastRightSide) {
            // start aiming this side from its stored values
            angle = cannonable.getCannonAngle(rightSide);
            rotation = cannonable.getCannonRotation(rightSide);
            aiming = true;
            lastRightSide = rightSide;
        }

        // mouse up = angle up; mouse right = rotate towards the direction the mouse moves
        angle = Mth.clamp(angle - (float) deltaY * MOUSE_SENSITIVITY, Cannonable.CANNON_ANGLE_MIN, Cannonable.CANNON_ANGLE_MAX);
        float rotationDelta = (float) deltaX * MOUSE_SENSITIVITY;
        // on the port side the screen-x direction is mirrored relative to "towards bow"
        rotation = Mth.clamp(rotation + (rightSide ? -rotationDelta : rotationDelta), -Cannonable.CANNON_ROTATION_MAX, Cannonable.CANNON_ROTATION_MAX);

        // instant client side feedback
        cannonable.setCannonAim(rightSide, angle, rotation);
        dirty = true;

        minecraft.gui.setOverlayMessage(Component.translatable("gui.smallships.cannon_aim", String.format("%.0f", angle), String.format("%.0f", rotation)), false);
    }

    /**
     * Called once per client tick: throttled sync and release detection.
     */
    public static void tick(Minecraft minecraft) {
        Player player = minecraft.player;
        if (player == null) return;

        boolean active = isAiming();
        tickCounter++;

        if (dirty && (!active || tickCounter % SYNC_INTERVAL_TICKS == 0)) {
            if (player.getVehicle() instanceof Ship ship) {
                ModPackets.clientSendPacket(new ServerboundSetCannonAimPacket(ship.getId(), lastRightSide, angle, rotation));
            }
            dirty = false;
        }

        if (!active) {
            aiming = false;
        }
    }

    private static boolean isLookingAtStarboard(Player player, Ship ship) {
        Vec3 forward = ship.getForward().normalize();
        Vec3 right = forward.yRot(-Mth.HALF_PI).normalize();
        Vec3 look = player.getLookAngle().normalize();
        return look.dot(right) >= 0;
    }
}
