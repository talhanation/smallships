package com.talhanation.smallships.mixin;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.chunk.LevelChunk;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(ChunkMap.class)
public class ChunkMapMixin {
    //LEASH FEATURE

    private Entity entity;

    @SuppressWarnings("rawtypes")
    @Inject(method = "playerLoadedChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerGamePacketListenerImpl;send(Lnet/minecraft/network/protocol/Packet;)V", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
    private void playerLoadedChunkLeashShipCaptureEntity(ServerPlayer serverPlayer, MutableObject<ClientboundLevelChunkWithLightPacket> mutableObject, LevelChunk levelChunk, CallbackInfo ci, List list, List list2, Iterator var6, Entity entity2) {
        entity = entity2;
    }

    @SuppressWarnings("DataFlowIssue")
    @Redirect(method = "playerLoadedChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerGamePacketListenerImpl;send(Lnet/minecraft/network/protocol/Packet;)V"))
    private void playerLoadedChunkLeashShip(ServerGamePacketListenerImpl instance, Packet<?> packet) {
        if (entity instanceof Leashable || entity.getClass().equals(Boat.class)) {
            instance.send(new ClientboundSetEntityLinkPacket(entity, ((BoatLeashAccess)entity).getLeashHolder()));
        } else {
            instance.send(new ClientboundSetEntityLinkPacket(entity, ((Mob)entity).getLeashHolder()));
        }
    }
}
