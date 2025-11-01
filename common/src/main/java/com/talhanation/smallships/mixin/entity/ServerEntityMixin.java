package com.talhanation.smallships.mixin.entity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.talhanation.smallships.world.entity.IMixinEntity;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;
import java.util.stream.Stream;

@Mixin(ServerEntity.class)
public class ServerEntityMixin {
    @WrapOperation(method="sendChanges",
            at = @At(value= "INVOKE", target = "Lnet/minecraft/server/level/ServerEntity;mountedOrDismounted(Ljava/util/List;)Ljava/util/stream/Stream;"))
    public Stream<Entity> filterRemovedPassengers(ServerEntity instance, List<Entity> list, Operation<Stream<Entity>> original) {
        return original.call(instance, list).filter(entity -> {
            if (((IMixinEntity) entity).doNotTeleportOnNextPassengerSync()) {
                ((IMixinEntity) entity).setPreventTeleportOnNextPassengerSync(false);
                return false;
            }
            return true;
        });
    }
}
