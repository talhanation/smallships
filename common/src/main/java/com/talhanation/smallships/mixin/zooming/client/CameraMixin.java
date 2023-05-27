package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Camera.class)
public abstract class CameraMixin implements CameraZoomAccess {
    @Shadow public abstract Entity getEntity();

    @ModifyConstant(method = "setup", constant = @Constant(doubleValue = 4.0))
    private double setupShipZoom(double constant) {
        if (this.getEntity().getVehicle() instanceof Ship && !Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            return this.getShipZoomData();
        } else {
            return constant;
        }
    }

    private double shipZoom = 6.0D;

    @Override
    public double getShipZoomData() {
        return this.shipZoom;
    }

    @Override
    public void setShipZoomData(double d) {
        this.shipZoom = d;
    }
}
