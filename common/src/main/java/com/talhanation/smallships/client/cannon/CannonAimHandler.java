package com.talhanation.smallships.client.cannon;

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
 * "Better Cannon Gameplay" aiming, SiegeWeapons-ballista style:
 * While the driver (broadside) or a gunner (his single cannon) HOLDS RIGHT
 * CLICK, the aim mode is active:
 * - mouse movement adjusts the aim (captured, the player view doesn't turn)
 * - the camera looks into the shooting direction (see CameraMixin)
 * - the trajectory is rendered as a white line per cannon (see ShipRenderer)
 *
 * The right click state is fed by the MouseHandler mixin; the aim is synced
 * throttled (every 3 ticks while dragging and once on release).
 */
public class CannonAimHandler {
    private static final float MOUSE_SENSITIVITY = 0.15F;
    private static final int SYNC_INTERVAL_TICKS = 3;

    /** raw right mouse button state, set by the MouseHandler mixin */
    private static boolean rightClickHeld = false;

    private static boolean aiming = false;
    private static boolean dirty = false;
    /** the broadside being aimed, frozen when the aim mode starts */
    private static boolean aimRightSide = false;
    /** the gunner's cannon slot, -1 = driver broadside */
    private static int aimSlot = -1;
    private static float angle;
    private static float rotation;
    private static int tickCounter = 0;

    /** Called by the MouseHandler mixin on right click press/release. */
    public static void setRightClickHeld(boolean held) {
        rightClickHeld = held;
    }

    /**
     * @return true if the local player could aim right now (driver or gunner
     * of a cannon ship with mounted cannons). Used by the mixin to decide
     * whether the right click should be captured.
     */
    public static boolean canAim() {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.screen != null) return false;
        if (!(player.getVehicle() instanceof Ship ship) || !(ship instanceof Cannonable cannonable)) return false;
        if (cannonable.getCannonCount() <= 0) return false;
        return player.equals(ship.getDriver()) || getGunnerSlot(player, ship) >= 0;
    }

    /**
     * @return true if the aim mode is currently active (right click held).
     */
    public static boolean isAiming() {
        return rightClickHeld && canAim();
    }


    /**
     * Only the DRIVER's aim mode captures the mouse (broadside delta aiming).
     * A GUNNER aims like the ground cannon: his view stays free and the cannon
     * follows the view - so the mouse must NOT be captured for him.
     */
    public static boolean shouldCaptureMouse() {
        if (!isAiming()) return false;
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || !(player.getVehicle() instanceof Ship ship)) return false;
        return getGunnerSlot(player, ship) < 0;
    }

    /* ---------------- state for camera and trajectory ---------------- */

    /** @return the broadside currently being aimed (frozen at activation). */
    public static boolean getAimSide() {
        return aiming ? aimRightSide : false;
    }

    /** @return the aimed cannon slot, -1 = broadside (driver). */
    public static int getAimSlot() {
        return aiming ? aimSlot : -1;
    }

    /**
     * @return the world direction the aimed cannons are pointing at,
     * for the camera and the trajectory preview.
     */
    public static Vec3 getAimDirection(Ship ship, float partialTicks) {
        float shipYaw = Mth.rotLerp(partialTicks, ship.yRotO, ship.getYRot());
        float yaw = shipYaw + (aimRightSide ? 90.0F : -90.0F) + (aimRightSide ? rotation : -rotation);
        float pitch = -angle;
        return Vec3.directionFromRotation(pitch, yaw);
    }

    public static float getAimYaw(Ship ship, float partialTicks) {
        float shipYaw = Mth.rotLerp(partialTicks, ship.yRotO, ship.getYRot());
        return shipYaw + (aimRightSide ? 90.0F : -90.0F) + (aimRightSide ? rotation : -rotation);
    }

    public static float getAimPitch() {
        return -angle;
    }

    /**
     * Called by the MouseHandler mixin with the accumulated mouse deltas
     * while aiming is active.
     */
    public static void handleMouseDelta(double deltaX, double deltaY) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || !(player.getVehicle() instanceof Ship ship) || !(ship instanceof Cannonable cannonable)) return;

        if (!aiming) {
            // aim mode starts: freeze the side (driver: side he was looking at;
            // gunner: the fixed side of his cannon) and load the stored aim
            aimSlot = getGunnerSlot(player, ship);
            if (aimSlot >= 0) {
                Cannonable.CannonPosition position = cannonable.getCannonPosition(aimSlot);
                aimRightSide = position != null && position.isRightSided;
            } else {
                aimRightSide = isLookingAtStarboard(player, ship);
            }
            angle = cannonable.getCannonAngle(aimSlot, aimRightSide);
            rotation = cannonable.getCannonRotation(aimSlot, aimRightSide);
            aiming = true;
        }

        // GUNNER: no delta aiming - the cannon follows the view (see tick())
        if (aimSlot >= 0) return;

        // mouse up = angle up; mouse right = rotate right - applied DIRECTLY
        angle = Mth.clamp(angle - (float) deltaY * MOUSE_SENSITIVITY, Cannonable.CANNON_ANGLE_MIN, Cannonable.CANNON_ANGLE_MAX);
        float rotationDelta = (float) deltaX * MOUSE_SENSITIVITY;
        rotation = Mth.clamp(rotation + (aimRightSide ? rotationDelta : -rotationDelta), -Cannonable.CANNON_ROTATION_MAX, Cannonable.CANNON_ROTATION_MAX);

        // instant client side feedback (camera + trajectory + cannon render)
        cannonable.setCannonAim(aimSlot, aimRightSide, angle, rotation);
        dirty = true;
    }

    /**
     * Called once per client tick: throttled sync and release detection.
     */
    public static void tick(Minecraft minecraft) {
        Player player = minecraft.player;
        if (player == null) return;

        boolean active = isAiming();
        tickCounter++;

        if (active && !aiming) {
            // activate even before the first mouse movement, so camera and
            // trajectory react immediately on press
            handleMouseDelta(0.0D, 0.0D);
        }

        // GUNNER mode (like the ground cannon): the cannon follows the free
        // view of the gunner instead of captured mouse deltas
        if (active && aiming && aimSlot >= 0 && player.getVehicle() instanceof Ship gunnerShip && gunnerShip instanceof Cannonable gunnerCannonable) {
            float sideYaw = gunnerShip.getYRot() + (aimRightSide ? 90.0F : -90.0F);
            float viewDelta = Mth.wrapDegrees(player.getYRot() - sideYaw);
            float newRotation = Mth.clamp(aimRightSide ? viewDelta : -viewDelta, -Cannonable.CANNON_ROTATION_MAX, Cannonable.CANNON_ROTATION_MAX);
            float newAngle = Mth.clamp(-player.getXRot(), Cannonable.CANNON_ANGLE_MIN, Cannonable.CANNON_ANGLE_MAX);
            if (newAngle != angle || newRotation != rotation) {
                angle = newAngle;
                rotation = newRotation;
                gunnerCannonable.setCannonAim(aimSlot, aimRightSide, angle, rotation);
                dirty = true;
            }
        }

        if (dirty && (!active || tickCounter % SYNC_INTERVAL_TICKS == 0)) {
            if (player.getVehicle() instanceof Ship ship) {
                ModPackets.clientSendPacket(new ServerboundSetCannonAimPacket(ship.getId(), aimSlot, aimRightSide, angle, rotation));
            }
            dirty = false;
        }

        if (!active) {
            aiming = false;
        }
    }

    /** @return true if the aim mode is active for exactly this ship. */
    public static boolean isAimingShip(Ship ship) {
        Minecraft minecraft = Minecraft.getInstance();
        return aiming && isAiming() && minecraft.player != null && minecraft.player.getVehicle() == ship;
    }

    /** @return the cannon slot the player mans as a gunner, or -1. */
    private static int getGunnerSlot(Player player, Ship ship) {
        if (!(ship instanceof Seatable seatable)) return -1;
        ShipSeat seat = seatable.getSeatOf(player);
        return seat != null && seat.type() == SeatType.GUNNER ? seat.mappedCannonSlot() : -1;
    }

    private static boolean isLookingAtStarboard(Player player, Ship ship) {
        Vec3 forward = ship.getForward().normalize();
        Vec3 right = forward.yRot(-Mth.HALF_PI).normalize();
        Vec3 look = player.getLookAngle().normalize();
        return look.dot(right) >= 0;
    }
}