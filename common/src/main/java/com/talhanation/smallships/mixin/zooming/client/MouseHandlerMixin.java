package com.talhanation.smallships.mixin.zooming.client;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
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

    @Unique private boolean smallships$shouldCancel;

    @Inject(method = "onScroll(JDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getInventory()Lnet/minecraft/world/entity/player/Inventory;", shift = At.Shift.BEFORE))
    private void onScrollCaptureScrollDelta(long windowPointer, double xOffset, double yOffset, CallbackInfo ci, @Local(ordinal = 4) double scrollDeltaY) {
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

    @WrapWithCondition(method = "onScroll(JDD)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getInventory()Lnet/minecraft/world/entity/player/Inventory;"))
    private boolean cancelScrollApplyInventoryPaint(LocalPlayer instance) {
        boolean shouldContinue = !smallships$shouldCancel;
        smallships$shouldCancel = false;
        return shouldContinue;
    }
}
