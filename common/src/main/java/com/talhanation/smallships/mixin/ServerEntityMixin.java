package com.talhanation.smallships.mixin;

import com.talhanation.smallships.duck.BoatLeashAccess;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ServerEntity.class)
public class ServerEntityMixin {
    //LEASH FEATURE

    @Shadow @Final private Entity entity;

    @Inject(method = "sendPairingData", at = @At(value = "TAIL"))
    private void sendPairingDataLeashShip(Consumer<Packet<?>> consumer, CallbackInfo ci) {
        if (this.entity instanceof Boat boat) {
            if (((BoatLeashAccess)boat).isLeashed()) {
                consumer.accept(new ClientboundSetEntityLinkPacket(boat, ((BoatLeashAccess)boat).getLeashHolder()));
            }
        }
    }
}
