package com.talhanation.smallships.mixin.zooming.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Shadow @Final private Minecraft minecraft;


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
     * Note: in 1.20.3+ mojmap the method that applies the accumulated mouse
     * movement to the player is called "handleAccumulatedMovement".
     */
    @Inject(method = "handleAccumulatedMovement", at = @At("HEAD"), cancellable = true)
    private void smallships$captureAimMovement(CallbackInfo ci) {
        if (CannonAimHandler.isAiming()) {
            CannonAimHandler.handleMouseDelta(this.accumulatedDX, this.accumulatedDY);
            this.accumulatedDX = 0.0D;
            this.accumulatedDY = 0.0D;
            ci.cancel();
        }
    }

    @Unique private boolean smallships$shouldCancel;

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Inject(method = "onScroll(JDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;swapPaint(D)V", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onScrollCaptureScrollDelta(long windowPointer, double xOffset, double yOffset, CallbackInfo ci, boolean bl, double scrollSensitivity, double scrollDeltaX, double scrollDeltaY) {
        if (SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) {
            assert this.minecraft.player != null;
            if (!this.minecraft.options.getCameraType().isFirstPerson() && this.minecraft.player.getVehicle() instanceof Ship) {
                Camera camera = minecraft.gameRenderer.getMainCamera();
                float shipZoom = Math.min(SmallShipsConfig.Client.shipGeneralCameraZoomMax.get().floatValue(), Math.max(SmallShipsConfig.Client.shipGeneralCameraZoomMin.get().floatValue(), ((CameraZoomAccess) camera).smallships$getShipZoomData() - ((float) scrollDeltaY / 5)));
                ((CameraZoomAccess) camera).smallships$setShipZoomData(shipZoom);
                smallships$shouldCancel = true;
            }
        }
    }

    @WrapWithCondition(method = "onScroll(JDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;swapPaint(D)V"))
    private boolean cancelScrollApplyInventoryPaint(Inventory instance, double direction) {
        boolean shouldContinue = !smallships$shouldCancel;
        smallships$shouldCancel = false;
        return shouldContinue;
    }
}