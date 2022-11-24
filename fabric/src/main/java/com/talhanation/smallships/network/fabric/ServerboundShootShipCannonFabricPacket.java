package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class ServerboundShootShipCannonFabricPacket implements FabricPacket, ServerPlayNetworking.PlayChannelHandler {
    @SuppressWarnings("unused")
    public ServerboundShootShipCannonFabricPacket() {
    }

    @SuppressWarnings("unused")
    public ServerboundShootShipCannonFabricPacket(FriendlyByteBuf buf) {
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
    }

    @Override
    public ResourceLocation getId() {
        return ModPackets.id("server_shoot_ship_cannon");
    }

    @SuppressWarnings("unused")
    @Override
    public void receive(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Cannonable cannonShip) {
            cannonShip.shoot(player);
        }
    }
}
