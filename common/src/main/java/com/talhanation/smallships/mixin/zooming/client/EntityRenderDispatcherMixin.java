package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Takes everyone riding the ship - or the ground cannon - out of the picture
 * while the local player is laying a gun. The local player himself included.
 *
 * The aim camera sits low over the deck, so a crew standing at the rail ends up
 * directly between the gunner and his target. This is a purely local view
 * decision - nothing is hidden from anyone else, and the crew is back the
 * moment the right click is released.
 *
 * That also makes the aim independent of the camera type. The aim camera
 * cancels Camera#setup, so the camera keeps whatever "detached" it had before:
 * aimed from third person (or after an F5 mid aim) vanilla draws the own body,
 * and its arm and held item sit right in front of the gun camera. The first
 * person hand is the other half, see ItemInHandRendererMixin.
 *
 * shouldRender is the right hook because vanilla calls it per entity per frame
 * and treats false as "not in view" - no render state is touched, so nothing
 * can leak into the next frame.
 */
@Mixin(EntityRenderDispatcher.class)
public abstract class EntityRenderDispatcherMixin {

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    private void smallships$hideCrewWhileAiming(Entity entity, Frustum frustum, double camX, double camY, double camZ, CallbackInfoReturnable<Boolean> cir) {
        if (smallships$isInTheLineOfSight(entity)) cir.setReturnValue(false);
    }

    @Unique
    private static boolean smallships$isInTheLineOfSight(Entity entity) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return false;

        // ground cannon: the aim state lives on the entity and is synched
        if (player.getVehicle() instanceof GroundCannonEntity cannon) {
            return cannon.isAiming() && entity != cannon && entity.getRootVehicle() == cannon;
        }

        if (!CannonAimHandler.isAiming()) return false;
        if (!(player.getVehicle() instanceof Ship ship)) return false;

        // the ship itself has to stay, only what rides it goes. getRootVehicle
        // covers a passenger sitting on a passenger as well.
        return entity != ship && entity.getRootVehicle() == ship;
    }
}