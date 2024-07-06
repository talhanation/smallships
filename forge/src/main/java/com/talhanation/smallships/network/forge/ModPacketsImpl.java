package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.ModPacket;
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

    public static <T extends CustomPacketPayload & ModPacket> void registerPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, ModPacket.Side side) {
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

    public static <T extends CustomPacketPayload & ModPacket> void serverSendPacket(ServerPlayer player, T packet) {
        if (CHANNEL == null) CHANNEL = ((PayloadFlow<RegistryFriendlyByteBuf, CustomPacketPayload>) CHANNEL_PAYLOAD).build();
        CHANNEL.send(packet, PacketDistributor.PLAYER.with(player));
    }

    public static <T extends CustomPacketPayload & ModPacket> void clientSendPacket(T packet) {
        if (CHANNEL == null) CHANNEL = ((PayloadFlow<RegistryFriendlyByteBuf, CustomPacketPayload>) CHANNEL_PAYLOAD).build();
        CHANNEL.send(packet, PacketDistributor.SERVER.noArg());
    }
}
