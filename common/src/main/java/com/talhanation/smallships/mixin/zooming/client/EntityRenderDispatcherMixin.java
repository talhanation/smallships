package com.talhanation.smallships.mixin.zooming.client;

import com.talhanation.smallships.client.cannon.CannonAimHandler;
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
 * Takes everyone riding the ship out of the picture while the local player is
 * laying a gun.
 *
 * The aim camera sits low over the deck, so a crew standing at the rail ends up
 * directly between the gunner and his target. This is a purely local view
 * decision - nothing is hidden from anyone else, and the crew is back the
 * moment the right click is released.
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
        if (!CannonAimHandler.isAiming()) return false;

        Player player = Minecraft.getInstance().player;
        if (player == null || !(player.getVehicle() instanceof Ship ship)) return false;

        // the ship itself has to stay, only what rides it goes. getRootVehicle
        // covers a passenger sitting on a passenger as well.
        return entity != ship && entity.getRootVehicle() == ship;
    }
}