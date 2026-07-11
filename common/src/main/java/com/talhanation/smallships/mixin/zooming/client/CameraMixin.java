package com.talhanation.smallships.mixin.zooming.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.client.camera.ShipCameraHandler;
import net.minecraft.client.Camera;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Camera.class)
public abstract class CameraMixin implements CameraZoomAccess {
    @Shadow public abstract Entity getEntity();

    /**
     * Better Ship Camera: in third person the camera anchor is moved from the
     * player position to the ship center, allowing a full 360 degree orbit
     * around the ship. The transition after mounting is smoothed by
     * ShipCameraHandler (aim and align).
     */
    @ModifyArgs(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;setPosition(DDD)V", ordinal = 0))
    private void smallships$centerCameraOnShip(Args args, BlockGetter blockGetter, Entity entity, boolean detached, boolean mirrored, float partialTick) {
        if (!detached) return;
        if (!SmallShipsConfig.Client.shipGeneralCameraShipCenterEnable.get()) return;
        if (!(entity.getVehicle() instanceof Ship ship)) return;

        double shipX = Mth.lerp(partialTick, ship.xo, ship.getX());
        double shipZ = Mth.lerp(partialTick, ship.zo, ship.getZ());

        float blend = ShipCameraHandler.getAnchorBlend(partialTick);
        args.set(0, Mth.lerp(blend, (Double) args.get(0), shipX));
        args.set(2, Mth.lerp(blend, (Double) args.get(2), shipZ));
    }

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