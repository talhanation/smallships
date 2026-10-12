package com.talhanation.smallships.client.cannon;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundSetCannonAimPacket;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.phys.Vec3;

/**
 * "Better Cannon Gameplay" aiming, SiegeWeapons-ballista style:
 * While the driver (broadside) or a gunner (his single cannon) HOLDS RIGHT
 * CLICK, the aim mode is active:
 * - mouse movement adjusts the aim (captured, the player view doesn't turn)
 * - the camera looks into the shooting direction (see CameraMixin)
 * - the trajectory is rendered as a white line per cannon (see ShipRenderer)
 *
 * Driver and gunner work the SAME way. The gunner used to aim "like the ground
 * cannon", with a free view the barrel followed - which could not be made to
 * feel right, because three things were writing the same value at once: the
 * mouse moved the view, the camera wrote a clamped pitch back onto the player,
 * and the side the traverse is measured against moved with the ship. Captured
 * deltas have none of that: the mouse moves one number and nothing moves it
 * back. The ground cannon gets away with the other model because it stands
 * still and is its own entity.
 *
 * NOTHING HERE IS INTERPOLATED, and that is deliberate. MouseHandler#
 * handleAccumulatedMovement runs once per FRAME, so handleMouseDelta below
 * already writes a frame accurate value - it is as smooth as the mouse itself.
 * Lerping it against the value of the last TICK, the way a model part is
 * interpolated against xRotO, hands back a fraction of the players' own input
 * and catches up in a jump at every tick boundary. That looks exactly like
 * input lag, and it is the one thing that must not be "improved" here.
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
    /** whether the first person hand is switched off for the aim, see updateHandRendering */
    private static boolean handHidden = false;

    /** Called by the MouseHandler mixin on right click press/release. */
    public static void setRightClickHeld(boolean held) {
        rightClickHeld = held;
        // right away, not only on the next tick - or the hand is still there
        // for the first frames of the aim
        updateHandRendering(Minecraft.getInstance());
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
        if (isHoldingUsableItem(player)) return false;
        return player.equals(ship.getDriver()) || getGunnerSlot(player, ship) >= 0;
    }

    /**
     * @return true if the player holds an item with a use of its own in either
     * hand - bow, crossbow, trident, shield, food, potion, spyglass, horn. The
     * right click belongs to that item then, not to the cannon, so a gunner
     * can still draw his bow or eat at his station.
     *
     * Read off the use animation, the one thing every such item declares: an
     * item without one has nothing to hold right click for.
     */
    public static boolean isHoldingUsableItem(Player player) {
        for (InteractionHand hand : InteractionHand.values()) {
            if (player.getItemInHand(hand).getUseAnimation() != UseAnim.NONE) return true;
        }
        return false;
    }

    /**
     * @return true if the aim mode is currently active (right click held).
     */
    public static boolean isAiming() {
        return rightClickHeld && canAim();
    }

    /**
     * The mouse is captured for EVERYONE who is aiming, gunner included: the
     * view must not turn while the deltas are being spent on the barrel, or the
     * player ends up steering two things with one hand.
     */
    public static boolean shouldCaptureMouse() {
        return isAiming();
    }

    /* ---------------- state for camera and trajectory ---------------- */

    /** @return the broadside currently being aimed (frozen at activation). */
    public static boolean getAimSide() {
        return aiming && aimRightSide;
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
        return Vec3.directionFromRotation(getAimPitch(), getAimYaw(ship, partialTicks));
    }

    /**
     * Only the SHIP heading is interpolated here - that one really does move
     * once per tick. The traverse itself is taken raw, see the class comment.
     */
    public static float getAimYaw(Ship ship, float partialTicks) {
        float shipYaw = Mth.rotLerp(partialTicks, ship.yRotO, ship.getYRot());
        return shipYaw + (aimRightSide ? 90.0F : -90.0F) + (aimRightSide ? rotation : -rotation);
    }

    public static float getAimPitch() {
        return -angle;
    }

    /* ---------------- render values for the local player's own gun ---------------- */

    /**
     * The elevation the LOCAL player's own gun should be DRAWN at.
     *
     * The renderer otherwise takes the aim out of the ships' synched data, and
     * that is wrong twice over for the gun this client is working itself:
     *
     * - it is written once per tick, so the barrel moves in 20 Hz steps while
     *   the mouse moves the camera every frame. The two then point at different
     *   things between ticks.
     * - the server writes the SAME synched field when the throttled aim packet
     *   arrives and echoes it back. Four ticks later the local value is replaced
     *   by the one this client sent four ticks ago, and the barrel snaps
     *   backwards - regularly, which is the part that feels violent.
     *
     * So the own gun is drawn from the local value instead, the very same one
     * the camera reads. Both are frame accurate and cannot drift apart.
     *
     * @return the angle in degrees, or Float.NaN when this client is not aiming
     * this particular gun - the caller then keeps the synched value.
     */
    public static float getRenderAngle(Ship ship, int slot, boolean rightSide) {
        return ownsGun(ship, slot, rightSide) ? angle : Float.NaN;
    }

    /** @see #getRenderAngle - the traverse, same rules. */
    public static float getRenderRotation(Ship ship, int slot, boolean rightSide) {
        return ownsGun(ship, slot, rightSide) ? rotation : Float.NaN;
    }

    /**
     * @return whether the given gun is the one this client is aiming right now.
     * A gunner owns exactly his slot, the driver owns the whole broadside he
     * froze on when he pressed.
     */
    private static boolean ownsGun(Ship ship, int slot, boolean rightSide) {
        if (!isAimingShip(ship)) return false;
        return aimSlot >= 0 ? slot == aimSlot : rightSide == aimRightSide;
    }

    /**
     * Called by the MouseHandler mixin with the accumulated mouse deltas
     * while aiming is active - once per FRAME. Identical for driver and gunner,
     * the only difference between them is WHICH guns the result is written to.
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
        // every tick, and before the null check: the ground cannon aim and an
        // item taken into the hand do not come through setRightClickHeld
        updateHandRendering(minecraft);

        Player player = minecraft.player;
        if (player == null) return;

        boolean active = isAiming();
        tickCounter++;

        if (active && !aiming) {
            // activate even before the first mouse movement, so camera and
            // trajectory react immediately on press
            handleMouseDelta(0.0D, 0.0D);
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

    /**
     * No first person hand while any cannon is aimed - ship or ground cannon.
     *
     * Through GameRenderer#setRenderHand, the switch vanilla itself uses for the
     * panorama screenshots. It sits above everything that draws the hand, so it
     * holds whatever the camera type, after an F5 mid aim, and with shader mods
     * that draw the hand in their own pass. Only written on a change, so
     * nothing else using the switch is overridden every tick.
     */
    private static void updateHandRendering(Minecraft minecraft) {
        Player player = minecraft.player;
        boolean hide = player != null && (player.getVehicle() instanceof GroundCannonEntity cannon ? cannon.isAiming() : isAiming());
        if (hide == handHidden) return;
        handHidden = hide;
        minecraft.gameRenderer.setRenderHand(!hide);
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