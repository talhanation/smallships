package com.talhanation.smallships.compat.shouldersurfing;

import com.github.exopandora.shouldersurfing.api.client.event.ComputeTargetCameraOffsetEvent;
import com.github.exopandora.shouldersurfing.api.client.event.handler.ComputeTargetCameraOffsetEventHandler;
import com.github.exopandora.shouldersurfing.api.event.IEventBus;
import com.github.exopandora.shouldersurfing.api.plugin.IShoulderSurfingPlugin;
import com.talhanation.smallships.client.camera.ShipCameraHandler;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.CameraZoomAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.phys.Vec3;

/**
 * Brings the ship zoom to the Shoulder Surfing Reloaded camera.
 *
 * With "replace default perspective" on, Shoulder Surfing redirects the very
 * Camera#move the ship zoom feeds into (see CameraMixin) and puts its own
 * offset there. The mouse wheel still changes the zoom - the camera just never
 * hears of it. This hands the zoom to the offset event instead, the one way
 * Shoulder Surfing offers for it.
 *
 * Loaded by Shoulder Surfing itself, through the shouldersurfing_plugin.json in
 * the jar root, and only when it is installed: nothing in this mod references
 * this class, so without Shoulder Surfing it is never loaded and its api never
 * needed - it is a compileOnly dependency. Shoulder Surfing older than 5.0 has
 * no such event; it logs that the plugin failed to load and carries on.
 */
public class ShoulderSurfingCompat implements IShoulderSurfingPlugin {
    /**
     * After Shoulder Surfing's own OffsetLimits (4000). Those clamp the
     * distance to five blocks by default - run before them and the ship could
     * barely be zoomed out at all. The terrain check still runs afterwards in
     * their camera, so the zoom cannot push it through a wall.
     */
    private static final int PRIORITY = 5000;

    @Override
    public void register(IEventBus eventBus) {
        // the bus has one register overload per event type, the cast says which
        eventBus.register(PRIORITY, (ComputeTargetCameraOffsetEventHandler) ShoulderSurfingCompat::computeShipOffset);
    }

    /**
     * Only the distance is replaced, by exactly what the vanilla camera would
     * use - the ship zooms the same with and without Shoulder Surfing. The
     * sideways and the height offset are left as the player set them up: that
     * look is what he installed the mod for, and at ship distance the shoulder
     * shift hardly shows anyway.
     *
     * The aim cameras of the cannons never get here: they cancel Camera#setup
     * before Shoulder Surfing's redirect is reached.
     */
    private static void computeShipOffset(ComputeTargetCameraOffsetEvent event) {
        if (!SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) return;
        if (!(event.getCameraEntity().getVehicle() instanceof Ship)) return;
        if (!(event.getCamera() instanceof CameraZoomAccess zoomAccess)) return;

        double distance = ShipCameraHandler.VANILLA_CAMERA_DISTANCE * ShipCameraHandler.getZoomFactor(zoomAccess.smallships$getShipZoomData());
        Vec3 offset = event.getResult();
        event.setResult(new Vec3(offset.x(), offset.y(), distance));
    }
}
