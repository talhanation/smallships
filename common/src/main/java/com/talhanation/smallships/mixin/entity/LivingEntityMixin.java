package com.talhanation.smallships.mixin.entity;

import com.talhanation.smallships.world.entity.IMixinEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Redirect(method = "dismountVehicle", at = @At(value="INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;dismountTo(DDD)V"))
    public void redirectDismountTo(LivingEntity instance, double x, double y, double z) {
        IMixinEntity entity = (IMixinEntity) instance;
        if (!instance.level().isClientSide() && entity.doNotDismountToCoordinates()) {
            entity.setPreventDismountToCoordinates(false);
        } else {
            instance.dismountTo(x, y, z);
        }
    }
}
