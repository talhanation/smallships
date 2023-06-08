package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "Lnet/minecraft/client/MouseHandler;onScroll(JDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;swapPaint(D)V", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void onScrollCaptureScrollDelta(long l, double d, double e, CallbackInfo ci, double scrollDelta) {
        if (SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) {
            assert this.minecraft.player != null;
            if (!this.minecraft.options.getCameraType().isFirstPerson() && this.minecraft.player.getVehicle() instanceof Ship) {
                Camera camera = minecraft.gameRenderer.getMainCamera();
                double shipZoom = Math.min(SmallShipsConfig.Client.shipGeneralCameraZoomMax.get(), Math.max(SmallShipsConfig.Client.shipGeneralCameraZoomMin.get(), ((CameraZoomAccess) camera).getShipZoomData() - scrollDelta));
                ((CameraZoomAccess) camera).setShipZoomData(shipZoom);
                ci.cancel();
            }
        }
    }
}
