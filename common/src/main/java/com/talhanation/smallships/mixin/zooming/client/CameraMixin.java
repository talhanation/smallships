package com.talhanation.smallships.mixin.zooming.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Camera.class)
public abstract class CameraMixin implements CameraZoomAccess {
    @Shadow public abstract Entity getEntity();

    @ModifyExpressionValue(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;getMaxZoom(F)F"))
    private float setupShipZoom(float original) {
        if (!SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) return original;
        if (this.getEntity().getVehicle() instanceof Ship && !Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            return original * (this.smallships$getShipZoomData() - 4.0F);
        } else {
            return original;
        }
    }

    @Unique private float smallships$shipZoom = 6.0F;

    @Unique
    @Override
    public float smallships$getShipZoomData() {
        return this.smallships$shipZoom;
    }

    @Unique
    @Override
    public void smallships$setShipZoomData(float d) {
        this.smallships$shipZoom = d;
    }
}