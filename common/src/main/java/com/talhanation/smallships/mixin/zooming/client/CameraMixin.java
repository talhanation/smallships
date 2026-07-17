package com.talhanation.smallships.mixin.zooming.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.client.camera.ShipCameraHandler;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
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
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin implements CameraZoomAccess {
    @Shadow public abstract Entity getEntity();

    @Shadow protected abstract void setPosition(double x, double y, double z);
    @Shadow protected abstract void setRotation(float yRot, float xRot);

    /**
     * Right click aim mode, SiegeWeapons ballista style:
     * - Ground cannon: the camera sits behind and above the barrel and looks
     *   along it, so the player sees the barrel while aiming.
     * - Cannon ship: the camera looks into the direction the aimed broadside /
     *   gunner cannon is about to shoot.
     */
    @Inject(method = "setup", at = @At("HEAD"), cancellable = true)
    private void smallships$aimCamera(BlockGetter blockGetter, Entity cameraEntity, boolean detached, boolean mirrored, float partialTick, CallbackInfo ci) {
        if (!(cameraEntity instanceof Player player)) return;

        // ground cannon: barrel camera while aiming
        if (player.getVehicle() instanceof GroundCannonEntity cannon && cannon.isAiming()) {
            double x = Mth.lerp(partialTick, cannon.xo, cannon.getX());
            double y = Mth.lerp(partialTick, cannon.yo, cannon.getY());
            double z = Mth.lerp(partialTick, cannon.zo, cannon.getZ());

            float yaw = Mth.rotLerp(partialTick, cannon.yRotO, cannon.getYRot());
            float pitch = Mth.lerp(partialTick, cannon.xRotO, cannon.getXRot());

            double yawRad = Math.toRadians(yaw);
            // slightly behind and above the cannon, looking along the barrel
            Vec3 offset = new Vec3(Math.sin(yawRad) * 0.9D, 1.7D, -Math.cos(yawRad) * 0.9D);

            this.setPosition(x + offset.x, y + offset.y, z + offset.z);
            this.setRotation(yaw, pitch);
            ci.cancel();
            return;
        }

        // cannon ship: aim camera while the right click is held
        if (player.getVehicle() instanceof Ship ship && CannonAimHandler.isAimingShip(ship)) {
            float aimYaw = CannonAimHandler.getAimYaw(ship, partialTick);
            float aimPitch = CannonAimHandler.getAimPitch();
            Vec3 aimDirection = CannonAimHandler.getAimDirection(ship, partialTick);

            int gunnerSlot = CannonAimHandler.getAimSlot();
            if (gunnerSlot >= 0 && ship instanceof Cannonable cannonable && cannonable.getCannonPosition(gunnerSlot) != null) {
                // GUNNER: barrel camera at HIS cannon, like the ground cannon /
                // ballista - behind and above the barrel, looking along it
                Vec3 cannonPos = new ShipCannon(ship, cannonable.getCannonPosition(gunnerSlot), gunnerSlot).getGlobalPosition();
                Vec3 cameraPos = cannonPos.add(0.0D, 1.35D, 0.0D).subtract(aimDirection.scale(1.0D));

                this.setPosition(cameraPos.x, cameraPos.y, cameraPos.z);
                this.setRotation(aimYaw, aimPitch);
                ci.cancel();
                return;
            }

            // DRIVER: over the deck, pulled back against the shooting direction
            double x = Mth.lerp(partialTick, ship.xo, ship.getX());
            double y = Mth.lerp(partialTick, ship.yo, ship.getY());
            double z = Mth.lerp(partialTick, ship.zo, ship.getZ());
            Vec3 cameraPos = new Vec3(x, y + 3.5D, z).subtract(aimDirection.scale(3.5D));

            this.setPosition(cameraPos.x, cameraPos.y, cameraPos.z);
            this.setRotation(aimYaw, aimPitch);
            ci.cancel();
        }
    }

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