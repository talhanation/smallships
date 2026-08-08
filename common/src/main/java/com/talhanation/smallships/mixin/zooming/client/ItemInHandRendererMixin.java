package com.talhanation.smallships.mixin.zooming.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Hides the first person hand while an aim camera is active.
 *
 * The camera sits on the gun during aiming, not in the players' head, so a hand
 * drawn at the bottom of the screen belongs to a viewpoint that is not there
 * any more.
 *
 * This has to be a mixin rather than a camera flag: vanilla decides whether to
 * draw the hand from options.getCameraType().isFirstPerson(), which the aim
 * cameras deliberately leave alone - the player never asked to switch to third
 * person and gets his own setting back the moment he lets go.
 */
@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererMixin {

    @Inject(method = "renderHandsWithItems", at = @At("HEAD"), cancellable = true)
    private void smallships$hideHandWhileAiming(float partialTicks, PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, LocalPlayer localPlayer, int packedLight, CallbackInfo ci) {
        if (smallships$isAiming(localPlayer)) ci.cancel();
    }

    @Unique
    private static boolean smallships$isAiming(LocalPlayer localPlayer) {
        if (localPlayer == null) return false;
        // ground cannon: the aim state lives on the entity and is synched
        if (localPlayer.getVehicle() instanceof GroundCannonEntity cannon && cannon.isAiming()) return true;
        // ship: driver broadside and gunner alike, the handler knows both
        return CannonAimHandler.isAiming();
    }
}