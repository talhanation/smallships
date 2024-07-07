package com.talhanation.smallships.mixin.neoforge.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.neoforged.neoforge.network.bundle.PacketAndPayloadAcceptor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ServerEntity.class)
public class ServerEntityMixin {
    @Shadow @Final private Entity entity;

    @SuppressWarnings("UnstableApiUsage")
    @Inject(method = "sendPairingData", at = @At(value = "TAIL"))
    private void sendPairingDataLeashShip(ServerPlayer arg, PacketAndPayloadAcceptor<ClientGamePacketListener> packetAndPayloadAcceptor, CallbackInfo ci) {
        if (this.entity instanceof Boat boat) {
            if (((BoatLeashAccess)boat).smallships$isLeashed()) {
                packetAndPayloadAcceptor.accept(new ClientboundSetEntityLinkPacket(boat, ((BoatLeashAccess)boat).smallships$getLeashHolder()));
            }
        }
    }
}
