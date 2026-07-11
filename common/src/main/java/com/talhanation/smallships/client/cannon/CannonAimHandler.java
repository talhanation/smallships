package com.talhanation.smallships.client.cannon;

import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundSetCannonAimPacket;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
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
    private static int lastSlot = -1;
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
        if (cannonable.getCannonCount() <= 0) return false;
        // driver (broadside) or gunner on a CANNON seat (his single cannon)
        if (!player.equals(ship.getDriver()) && getGunnerSlot(player, ship) < 0) return false;
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

        int slot = getGunnerSlot(player, ship);
        boolean rightSide;
        if (slot >= 0) {
            // gunner: the side is fixed by the mounted cannon
            rightSide = cannonable.getCannonPosition(slot) != null && cannonable.getCannonPosition(slot).isRightSided;
        } else {
            rightSide = isLookingAtStarboard(player, ship);
        }
        if (!aiming || rightSide != lastRightSide || slot != lastSlot) {
            // start aiming from the stored values (per-cannon aim falls back to the broadside)
            angle = cannonable.getCannonAngle(slot, rightSide);
            rotation = cannonable.getCannonRotation(slot, rightSide);
            aiming = true;
            lastRightSide = rightSide;
            lastSlot = slot;
        }

        // mouse up = angle up; mouse right = rotate towards the direction the mouse moves
        angle = Mth.clamp(angle - (float) deltaY * MOUSE_SENSITIVITY, Cannonable.CANNON_ANGLE_MIN, Cannonable.CANNON_ANGLE_MAX);
        float rotationDelta = (float) deltaX * MOUSE_SENSITIVITY;
        // on the port side the screen-x direction is mirrored relative to "towards bow"
        rotation = Mth.clamp(rotation + (rightSide ? -rotationDelta : rotationDelta), -Cannonable.CANNON_ROTATION_MAX, Cannonable.CANNON_ROTATION_MAX);

        // instant client side feedback
        cannonable.setCannonAim(slot, rightSide, angle, rotation);
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
                ModPackets.clientSendPacket(new ServerboundSetCannonAimPacket(ship.getId(), lastSlot, lastRightSide, angle, rotation));
            }
            dirty = false;
        }

        if (!active) {
            aiming = false;
        }
    }

    /** @return the cannon slot the player mans as a gunner, or -1. */
    private static int getGunnerSlot(Player player, Ship ship) {
        if (!(ship instanceof Seatable seatable)) return -1;
        ShipSeat seat = seatable.getSeatOf(player);
        return seat != null && seat.type() == SeatType.CANNON ? seat.mappedCannonSlot() : -1;
    }

    private static boolean isLookingAtStarboard(Player player, Ship ship) {
        Vec3 forward = ship.getForward().normalize();
        Vec3 right = forward.yRot(-Mth.HALF_PI).normalize();
        Vec3 look = player.getLookAngle().normalize();
        return look.dot(right) >= 0;
    }
}
