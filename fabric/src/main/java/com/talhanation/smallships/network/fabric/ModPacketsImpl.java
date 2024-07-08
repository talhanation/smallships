package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ModPacketsImpl {
    private static final List<CustomPacketPayload.Type<ModPacket>> clientReceivers = new ArrayList<>();
    private static final List<CustomPacketPayload.Type<ModPacket>> serverReceivers = new ArrayList<>();

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case ModPacket.Side.CLIENTBOUND -> {
                PayloadTypeRegistry.playS2C().register(type, codec);

                clientReceivers.add(type);
            }
            case ModPacket.Side.SERVERBOUND -> {
                PayloadTypeRegistry.playC2S().register(type, codec);

                serverReceivers.add(type);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientReceivers() {
        ModPacketsClientHelper.registerClientReceivers(clientReceivers);
    }

    public static void registerServerReceivers() {
        for (CustomPacketPayload.Type<ModPacket> type : serverReceivers) {
            ServerPlayNetworking.registerGlobalReceiver(type, (packet, context) -> {
                Player player = context.player();
                packet.handler(player);
            });
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        ServerPlayNetworking.send(player, packet);
    }

    @Environment(EnvType.CLIENT)
    public static void clientSendPacket(ModPacket packet) {
        ModPacketsClientHelper.clientSendPacket(packet);
    }
}
