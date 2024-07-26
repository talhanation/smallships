package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.Channel;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.payload.PayloadConnection;
import net.minecraftforge.network.payload.PayloadFlow;

public class ModPacketsImpl {
    static PayloadConnection<CustomPacketPayload> CHANNEL_PAYLOAD = ChannelBuilder
            .named(ModPackets.id("channel"))
            .optional()
            .payloadChannel();

    static Channel<CustomPacketPayload> CHANNEL;

    public static void buildChannel() {
        CHANNEL = ((PayloadFlow<RegistryFriendlyByteBuf, CustomPacketPayload>) CHANNEL_PAYLOAD).build();
    }

    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        switch (side) {
            case ModPacket.Side.CLIENTBOUND -> CHANNEL_PAYLOAD = CHANNEL_PAYLOAD.play().clientbound().add(type, codec, (packet, context) -> {
                Player player = context.getSender();
                context.enqueueWork(() -> packet.handler(player));
            });
            case ModPacket.Side.SERVERBOUND -> CHANNEL_PAYLOAD = CHANNEL_PAYLOAD.play().serverbound().add(type, codec, (packet, context) -> {
                Player player = context.getSender();
                context.enqueueWork(() -> packet.handler(player));
            });
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        CHANNEL.send(packet, PacketDistributor.PLAYER.with(player));
    }

    public static void clientSendPacket(ModPacket packet) {
        CHANNEL.send(packet, PacketDistributor.SERVER.noArg());
    }
}
