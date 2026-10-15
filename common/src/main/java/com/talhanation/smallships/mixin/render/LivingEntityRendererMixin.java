package com.talhanation.smallships.mixin.render;


import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    /*
    //TODO: Passengers don`t sit
    @Shadow
    protected EntityModel<?> model;

    @Inject(method = "render*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;setupRotations(Lnet/minecraft/world/entity/LivingEntity;Lcom/mojang/blaze3d/vertex/PoseStack;FFF)V"), cancellable = true)
    private void renderModelToStandOnSmallShip(LivingEntity livingEntity, CallbackInfoReturnable<InteractionResult> cir) {
        if(livingEntity.getVehicle() != null && livingEntity.getVehicle() instanceof Ship){
            model.riding = false;
        }
    }
    */

    /**
     * The driver of a ground cannon stands at the gun instead of sitting on it,
     * and ducks behind it while aiming.
     *
     * Wraps the write of model.riding and not the isPassenger call: vanilla
     * writes entity.isPassenger() there, NeoForge its shouldSit - the field write
     * itself exists on both loaders.
     *
     * A WrapOperation and not a Redirect, so render mods touching the same write
     * still apply instead of crashing the game.
     *
     * Only the model is touched, the players' real pose stays as it is. Setting
     * Pose.CROUCHING would fight Player#updatePlayerPose every tick and resize
     * the hitbox with it.
     */
    @WrapOperation(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/model/EntityModel;riding:Z", opcode = Opcodes.PUTFIELD))
    private void wrapRidingForGroundCannon(EntityModel<?> model, boolean riding, Operation<Void> original, @Local(argsOnly = true) LivingEntity livingEntity) {
        if (livingEntity.getVehicle() instanceof GroundCannonEntity cannon && cannon.getDriver() == livingEntity) {
            original.call(model, false);
            // only players: PlayerRenderer resets crouching every frame, other
            // humanoid renderers would keep the flag after the aiming ends
            if (livingEntity instanceof Player && model instanceof HumanoidModel<?> humanoidModel && cannon.isAiming()) {
                humanoidModel.crouching = true;
            }
            return;
        }
        original.call(model, riding);
    }
}