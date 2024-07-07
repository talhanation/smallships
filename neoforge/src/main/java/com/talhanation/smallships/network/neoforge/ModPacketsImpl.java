package com.talhanation.smallships.network.neoforge;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.network.ModPacket;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;

public class ModPacketsImpl {
    public static final List<Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>>> serverboundPackets = new ArrayList<>();
    public static final List<Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>>> clientboundPackets = new ArrayList<>();

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case ModPacket.Side.CLIENTBOUND -> clientboundPackets.add(new Pair<>(type, codec));
            case ModPacket.Side.SERVERBOUND -> serverboundPackets.add(new Pair<>(type, codec));
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        PacketDistributor.sendToPlayer(player, packet);
    }

    public static void clientSendPacket(ModPacket packet) {
        PacketDistributor.sendToServer(packet);
    }
}
