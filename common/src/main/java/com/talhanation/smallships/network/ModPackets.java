package com.talhanation.smallships.network;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.network.packet.*;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ModPackets {
    public static void registerPackets() {
        registerPacket(ServerboundOpenShipScreenPacket.TYPE, ServerboundOpenShipScreenPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerPacket(ServerboundToggleShipSailPacket.TYPE, ServerboundToggleShipSailPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerPacket(ServerboundShootShipCannonPacket.TYPE, ServerboundShootShipCannonPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerPacket(ServerboundSetSailStatePacket.TYPE, ServerboundSetSailStatePacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerPacket(ServerboundUpdateShipControlPacket.TYPE, ServerboundUpdateShipControlPacket.CODEC, ModPacket.Side.SERVERBOUND);
    }

    @ExpectPlatform
    public static <T extends CustomPacketPayload & ModPacket> void registerPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, ModPacket.Side side) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends CustomPacketPayload & ModPacket> void serverSendPacket(ServerPlayer player, T packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends CustomPacketPayload & ModPacket> void clientSendPacket(T packet) {
        throw new AssertionError();
    }

    @SuppressWarnings("SameParameterValue")
    public static ResourceLocation id(String id) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, id);
    }
}
