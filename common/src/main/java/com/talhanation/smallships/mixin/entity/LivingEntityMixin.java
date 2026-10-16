package com.talhanation.smallships.mixin.entity;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.talhanation.smallships.world.entity.IMixinEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @WrapWithCondition(method = "dismountVehicle", at = @At(value="INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;dismountTo(DDD)V"))
    public boolean wrapDismountTo(LivingEntity instance, double x, double y, double z) {
        IMixinEntity entity = (IMixinEntity) instance;
        if (!instance.level().isClientSide() && entity.doNotDismountToCoordinates()) {
            entity.setPreventDismountToCoordinates(false);
            return false;
        }
        return true;
    }
}
