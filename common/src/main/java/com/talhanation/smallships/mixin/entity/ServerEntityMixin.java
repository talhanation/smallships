package com.talhanation.smallships.mixin.entity;

import com.talhanation.smallships.world.entity.IMixinEntity;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.stream.Stream;

@Mixin(ServerEntity.class)
public class ServerEntityMixin {
    @Redirect(method="sendChanges",
            at = @At(value= "INVOKE", target = "Lnet/minecraft/server/level/ServerEntity;removedPassengers(Ljava/util/List;Ljava/util/List;)Ljava/util/stream/Stream;"))
    public Stream<Entity> filterRemovedPassengers(List<Entity> originalPassengers, List<Entity> lastPassengers) {
        return removedPassengers(originalPassengers, lastPassengers)
                .filter(entity -> {
                    if (((IMixinEntity) entity).doNotTeleportOnNextPassengerSync()) {
                        ((IMixinEntity) entity).setPreventTeleportOnNextPassengerSync(false);
                        return false;
                    }
                    return true;
                });
    }

    @Shadow
    private static Stream<Entity> removedPassengers(List<Entity> list, List<Entity> list2) {
        return null;
    }
}
