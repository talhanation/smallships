package com.talhanation.smallships.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.talhanation.smallships.world.entity.IMixinEntity;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.stream.Stream;

@Mixin(ServerEntity.class)
public class ServerEntityMixin {
    @ModifyExpressionValue(method="sendChanges",
            at = @At(value= "INVOKE", target = "Lnet/minecraft/server/level/ServerEntity;removedPassengers(Ljava/util/List;Ljava/util/List;)Ljava/util/stream/Stream;"))
    public Stream<Entity> filterRemovedPassengers(Stream<Entity> removedPassengers) {
        return removedPassengers
                .filter(entity -> {
                    if (((IMixinEntity) entity).doNotTeleportOnNextPassengerSync()) {
                        ((IMixinEntity) entity).setPreventTeleportOnNextPassengerSync(false);
                        return false;
                    }
                    return true;
                });
    }
}
