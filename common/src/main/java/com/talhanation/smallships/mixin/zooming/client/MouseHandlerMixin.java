package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Shadow @Final private Minecraft minecraft;

    /** a second right click within this many ms triggers the barrel recenter */
    @Unique private static final long SMALLSHIPS_DOUBLE_CLICK_MS = 400L;
    @Unique private long smallships$lastCannonRightClick = 0L;


    /**
     * SiegeWeapons-ballista style: right click HOLD activates the aim mode
     * - on cannon ships for the driver (broadside) / gunner (his cannon)
     * - on the ground cannon (view aiming with barrel camera).
     * The press is captured so no vanilla item use / interaction fires.
     */
    @Inject(method = "onPress", at = @At("HEAD"), cancellable = true)
    private void smallships$captureAimRightClick(long windowPointer, int button, int action, int mods, CallbackInfo ci) {
        if (button != 1) return; // right mouse button
        if (this.minecraft.player == null || this.minecraft.screen != null) return;

        boolean press = action == 1;

        // ground cannon: aim mode = camera behind the barrel + view aiming
        if (this.minecraft.player.getVehicle() instanceof GroundCannonEntity cannon) {
            if (press) {
                long now = net.minecraft.Util.getMillis();
                if (now - this.smallships$lastCannonRightClick <= SMALLSHIPS_DOUBLE_CLICK_MS) {
                    // second click inside the window: snap back to neutral
                    cannon.triggerRecenter(this.minecraft.player);
                    this.smallships$lastCannonRightClick = 0L;
                } else {
                    this.smallships$lastCannonRightClick = now;
                }
            }
            cannon.updateAimingControl(press, this.minecraft.player);
            if (press) ci.cancel();
            return;
        }

        // cannon ship: driver / gunner
        if (press) {
            if (CannonAimHandler.canAim()) {
                CannonAimHandler.setRightClickHeld(true);
                ci.cancel();
            }
        } else {
            CannonAimHandler.setRightClickHeld(false);
        }
    }

    @Shadow private double accumulatedDX;
    @Shadow private double accumulatedDY;

    /**
     * Better Cannon Gameplay: while the ship driver holds right click, the
     * accumulated mouse movement adjusts the broadside cannon aim instead of
     * turning the camera.
     * Note: 1.20.3+ renamed this method to "handleAccumulatedMovement", on
     * 1.20.1 it is still called "turnPlayer".
     */
    @Inject(method = "turnPlayer", at = @At("HEAD"), cancellable = true)
    private void smallships$captureAimMovement(CallbackInfo ci) {
        if (CannonAimHandler.shouldCaptureMouse()) {
            CannonAimHandler.handleMouseDelta(this.accumulatedDX, this.accumulatedDY);
            this.accumulatedDX = 0.0D;
            this.accumulatedDY = 0.0D;
            ci.cancel();
            return;
        }
        // ground cannon aiming: slow the raw mouse movement globally so the gun
        // tracks like a heavy carriage. The view still moves freely, it is just
        // damped, which is simpler and feels better than the old per-tick
        // approach limit on the entity.
        if (this.minecraft.player != null
                && this.minecraft.player.getVehicle() instanceof GroundCannonEntity cannon
                && cannon.isAiming()) {
            this.accumulatedDX *= SMALLSHIPS_AIM_SENSITIVITY;
            this.accumulatedDY *= SMALLSHIPS_AIM_SENSITIVITY;
        }
    }

    /** mouse sensitivity multiplier while aiming a ground cannon (heavy carriage feel) */
    @Unique private static final double SMALLSHIPS_AIM_SENSITIVITY = 0.35D;

    /** zoom steps per scroll notch - the /5 of the old sensitivity scaled delta */
    @Unique private static final double SMALLSHIPS_ZOOM_PER_NOTCH = 0.2D;

    /**
     * Ship camera zoom on the scroll wheel.
     *
     * 1.20.1 onScroll does not expose the locals the later versions do - there
     * is no sensitivity scaled delta to capture, only a raw offset and, much
     * later, an int notch count. So the amount is taken straight from the
     * parameter instead. Cancelling at HEAD also makes the WrapWithCondition on
     * swapPaint unnecessary: nothing further down the method runs at all, so the
     * hotbar cannot swap behind our back.
     *
     * The one thing lost against the old version is the mouseWheelSensitivity
     * option, which is applied further down in the method we no longer reach.
     */
    @Inject(method = "onScroll(JDD)V", at = @At("HEAD"), cancellable = true)
    private void onScrollCaptureScrollDelta(long windowPointer, double xOffset, double yOffset, CallbackInfo ci) {
        if (!SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) return;
        if (this.minecraft.player == null || this.minecraft.screen != null || this.minecraft.getOverlay() != null) return;
        if (this.minecraft.options.getCameraType().isFirstPerson()) return;
        if (!(this.minecraft.player.getVehicle() instanceof Ship)) return;

        Camera camera = this.minecraft.gameRenderer.getMainCamera();
        float shipZoom = Math.min(SmallShipsConfig.Client.shipGeneralCameraZoomMax.get().floatValue(),
                Math.max(SmallShipsConfig.Client.shipGeneralCameraZoomMin.get().floatValue(),
                        ((CameraZoomAccess) camera).smallships$getShipZoomData() - (float) (yOffset * SMALLSHIPS_ZOOM_PER_NOTCH)));
        ((CameraZoomAccess) camera).smallships$setShipZoomData(shipZoom);
        ci.cancel();
    }
}