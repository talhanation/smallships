package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.client.camera.ShipCameraHandler;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.Camera;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import org.spongepowered.asm.mixin.injection.ModifyArg;
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
    // fixed downward pitch of the driver's aim camera (positive = looking down).
    // keeps the broadside view steady while the mouse only moves the cannons
    @Unique private static final float DRIVER_AIM_CAMERA_PITCH = 15.0F;
    // fallback deck height, only used by a ship that is not Cannonable at all
    @Unique private static final double DRIVER_AIM_CAMERA_Y = 2.5D;
    // ground cannon: the camera is bolted to the barrel. TRUNNION_Y is the height
    // the barrel pivots around, BORE_FORWARD how far along the bore the camera
    // sits in front of that pivot - so elevating the gun swings the camera up
    // with the muzzle instead of leaving it at a fixed height looking upwards.
    @Unique private static final double GROUND_CANNON_TRUNNION_Y = 0.75D;
    @Unique private static final double GROUND_CANNON_BORE_FORWARD = 0.75D;
    // the eight corner offsets vanilla probes in getMaxZoom
    @Unique private static final double CAMERA_PROBE = 0.1D;
    // never let the zoom factor reach zero or turn negative - the configured
    // minimum zoom can go down to 1.0, which would put the camera in FRONT
    @Unique private static final float MIN_ZOOM_FACTOR = 0.25F;

    @Shadow public abstract Entity getEntity();

    @Shadow protected abstract void setPosition(double x, double y, double z);
    @Shadow protected abstract void setRotation(float yRot, float xRot);

    /**
     * Right click aim mode, SiegeWeapons ballista style:
     * - Ground cannon: the camera rides the barrel and looks along it, so the
     *   player sees the gun move under him while aiming.
     * - Cannon ship: the camera looks into the direction the aimed broadside /
     *   gunner cannon is about to shoot.
     *
     * Every one of these paths cancels setup, so vanillas' own camera collision
     * in getMaxZoom never runs for them - and the mouse swings them around
     * freely. They have to clip for themselves, see smallships$clip.
     *
     * The first person hand is dealt with in ItemInHandRendererMixin: vanilla
     * gates it on the camera TYPE, not on anything this class can reach.
     */
    @Inject(method = "setup", at = @At("HEAD"), cancellable = true)
    private void smallships$aimCamera(BlockGetter blockGetter, Entity cameraEntity, boolean detached, boolean mirrored, float partialTick, CallbackInfo ci) {
        if (!(cameraEntity instanceof Player player)) return;

        // ground cannon: barrel camera while aiming
        if (player.getVehicle() instanceof GroundCannonEntity cannon && cannon.isAiming()) {
            double x = Mth.lerp(partialTick, cannon.xo, cannon.getX());
            double y = Mth.lerp(partialTick, cannon.yo, cannon.getY());
            double z = Mth.lerp(partialTick, cannon.zo, cannon.getZ());

            // read the view straight off the PLAYER, not off the cannon. The
            // cannon is only written once per tick, so a camera following it
            // stands still between ticks and lags a full one behind - which is
            // exactly what made the aim feel heavy. The gun tracks the view
            // one to one anyway, so this is the same angle, just frame accurate.
            float yaw = player.getViewYRot(partialTick);
            float pitch = Mth.clamp(player.getViewXRot(partialTick), GroundCannonEntity.PITCH_MIN, GroundCannonEntity.PITCH_MAX);

            // the offset runs along the BORE, pitch included - that is what makes
            // the camera sit on the gun instead of merely turning with it. A yaw
            // only offset keeps the camera at one height whatever the barrel does,
            // which reads as a floating viewpoint rather than a mounted one.
            Vec3 bore = Vec3.directionFromRotation(pitch, yaw);
            Vec3 anchor = new Vec3(x, y + GROUND_CANNON_TRUNNION_Y, z);
            Vec3 camera = this.smallships$clip(blockGetter, anchor, anchor.add(bore.scale(GROUND_CANNON_BORE_FORWARD)));

            this.setPosition(camera.x, camera.y, camera.z);
            this.setRotation(yaw, pitch);
            ci.cancel();
            return;
        }

        // cannon ship: aim camera while the right click is held
        if (player.getVehicle() instanceof Ship ship && CannonAimHandler.isAimingShip(ship)) {
            float aimYaw = CannonAimHandler.getAimYaw(ship, partialTick);
            float aimPitch = CannonAimHandler.getAimPitch();
            Vec3 aimDirection = CannonAimHandler.getAimDirection(ship, partialTick);
            Cannonable cannonable = ship instanceof Cannonable ? (Cannonable) ship : null;

            int gunnerSlot = CannonAimHandler.getAimSlot();
            if (gunnerSlot >= 0 && cannonable != null && cannonable.getCannonPosition(gunnerSlot) != null) {
                // GUNNER: barrel camera at HIS cannon, like the ground cannon /
                // ballista - behind and above the barrel, looking along it
                Vec3 anchor = new ShipCannon(ship, cannonable.getCannonPosition(gunnerSlot), gunnerSlot).getGlobalPosition().add(0.0D, 1.35D, 0.0D);
                Vec3 camera = this.smallships$clip(blockGetter, anchor, anchor.subtract(aimDirection.scale(1.0D)));

                this.setPosition(camera.x, camera.y, camera.z);
                this.setRotation(aimYaw, aimPitch);
                ci.cancel();
                return;
            }

            // DRIVER: over the deck, pulled back against the shooting direction.
            // The camera yaw follows the broadside, but the PITCH stays fixed - the
            // mouse only elevates the cannons, it must not tilt the driver's view
            // up/down (the gunner keeps the barrel cam with aimPitch above).
            double x = Mth.lerp(partialTick, ship.xo, ship.getX());
            double y = Mth.lerp(partialTick, ship.yo, ship.getY());
            double z = Mth.lerp(partialTick, ship.zo, ship.getZ());
            Vec3 flatDirection = Vec3.directionFromRotation(0.0F, aimYaw);
            // decks sit at very different heights, so the eye level is per ship
            double aimY = cannonable != null ? cannonable.getCannonAimY() : DRIVER_AIM_CAMERA_Y;
            Vec3 anchor = new Vec3(x, y + aimY, z);
            Vec3 camera = this.smallships$clip(blockGetter, anchor, anchor.subtract(flatDirection.scale(-0.75D)));

            this.setPosition(camera.x, camera.y, camera.z);
            this.setRotation(aimYaw, DRIVER_AIM_CAMERA_PITCH);
            ci.cancel();
        }
    }

    /**
     * Pulls a camera position in until the line from the anchor to it is clear
     * of terrain. Same eight corner probes vanilla uses in getMaxZoom, so a
     * camera cannot slip through an edge that the normal third person view
     * would have caught.
     *
     * @param anchor a point that is known to be free - the ship or the cannon
     * @param target where the camera would like to sit
     * @return the furthest point along that line that is still outside the world
     */
    @Unique
    private Vec3 smallships$clip(BlockGetter blockGetter, Vec3 anchor, Vec3 target) {
        Vec3 line = target.subtract(anchor);
        double reach = line.length();
        if (reach < 1.0E-4D) return target;
        Vec3 direction = line.scale(1.0D / reach);

        double free = reach;
        for (int i = 0; i < 8; i++) {
            Vec3 probe = new Vec3(
                    ((i & 1) * 2 - 1) * CAMERA_PROBE,
                    (((i >> 1) & 1) * 2 - 1) * CAMERA_PROBE,
                    (((i >> 2) & 1) * 2 - 1) * CAMERA_PROBE);
            Vec3 from = anchor.add(probe);
            HitResult hit = blockGetter.clip(new ClipContext(from, from.add(direction.scale(reach)),
                    ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, this.getEntity()));
            if (hit.getType() == HitResult.Type.MISS) continue;

            double distance = hit.getLocation().distanceTo(anchor);
            if (distance < free) free = distance;
        }
        return anchor.add(direction.scale(free));
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

    /**
     * Ship zoom, applied to the ARGUMENT of getMaxZoom and not to its result.
     *
     * getMaxZoom IS the collision check - it probes backwards and returns the
     * shortest free distance. Scaling what comes back out multiplies a value
     * that was already clamped against a wall, which is how the camera ended up
     * inside terrain. Scaling what goes in makes vanilla probe the full distance
     * we want and clamp it itself.
     */
    @ModifyArg(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;getMaxZoom(F)F"), index = 0)
    private float smallships$shipZoomDistance(float original) {
        if (!SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) return original;
        if (this.getEntity().getVehicle() instanceof Ship && !Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            return original * Math.max(MIN_ZOOM_FACTOR, this.smallships$getShipZoomData() - 4.0F);
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