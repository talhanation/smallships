package com.talhanation.smallships.mixin.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

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
     * Redirects the write of model.riding and not the isPassenger call: vanilla
     * writes entity.isPassenger() there, Forge its shouldSit - the field write
     * itself exists on both loaders.
     *
     * Only the model is touched, the players' real pose stays as it is. Setting
     * Pose.CROUCHING would fight Player#updatePlayerPose every tick and resize
     * the hitbox with it.
     */
    @Redirect(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/model/EntityModel;riding:Z", opcode = Opcodes.PUTFIELD))
    private void redirectRidingForGroundCannon(EntityModel<?> model, boolean riding, LivingEntity livingEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        if (livingEntity.getVehicle() instanceof GroundCannonEntity cannon && cannon.getDriver() == livingEntity) {
            model.riding = false;
            // only players: PlayerRenderer resets crouching every frame, other
            // humanoid renderers would keep the flag after the aiming ends
            if (livingEntity instanceof Player && model instanceof HumanoidModel<?> humanoidModel && cannon.isAiming()) {
                humanoidModel.crouching = true;
            }
            return;
        }
        model.riding = riding;
    }
}