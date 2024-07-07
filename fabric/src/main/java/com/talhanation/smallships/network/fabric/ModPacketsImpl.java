package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
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
    private static final List<Runnable> clientReceivers = new ArrayList<>();
    private static final List<Runnable> serverReceivers = new ArrayList<>();

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case ModPacket.Side.CLIENTBOUND -> {
                PayloadTypeRegistry.playS2C().register(type, codec);

                clientReceivers.add(() -> ClientPlayNetworking.registerGlobalReceiver(type, (packet, context) -> {
                    context.client().execute(() -> {
                        Player player = context.client().player;
                        packet.handler(player);
                    });
                }));
            }
            case ModPacket.Side.SERVERBOUND -> {
                PayloadTypeRegistry.playC2S().register(type, codec);

                serverReceivers.add(() -> ServerPlayNetworking.registerGlobalReceiver(type, (packet, context) -> {
                    Player player = context.player();
                    packet.handler(player);
                }));
            }
        }
    }

    public static void registerClientReceivers() {
        for (Runnable r : clientReceivers) {
            r.run();
        }
    }

    public static void registerServerReceivers() {
        for (Runnable r : serverReceivers) {
            r.run();
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        ServerPlayNetworking.send(player, packet);
    }

    public static void clientSendPacket(ModPacket packet) {
        ClientPlayNetworking.send(packet);
    }
}
