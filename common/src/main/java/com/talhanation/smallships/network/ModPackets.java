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
        registerNonPacket(ServerboundOpenShipScreenPacket.TYPE, ServerboundOpenShipScreenPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerNonPacket(ServerboundToggleShipSailPacket.TYPE, ServerboundToggleShipSailPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerNonPacket(ServerboundShootShipCannonPacket.TYPE, ServerboundShootShipCannonPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerNonPacket(ServerboundShootGroundCannonPacket.TYPE, ServerboundShootGroundCannonPacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerNonPacket(ServerboundSetSailStatePacket.TYPE, ServerboundSetSailStatePacket.CODEC, ModPacket.Side.SERVERBOUND);
        registerNonPacket(ServerboundUpdateShipControlPacket.TYPE, ServerboundUpdateShipControlPacket.CODEC, ModPacket.Side.SERVERBOUND);
    }

    @SuppressWarnings("unchecked")
    private static <T extends ModPacket> void registerNonPacket(CustomPacketPayload.Type<T> type, StreamCodec<RegistryFriendlyByteBuf, T> codec, ModPacket.Side side) {
        registerPacket((CustomPacketPayload.Type<ModPacket>)type, (StreamCodec<RegistryFriendlyByteBuf, ModPacket>)codec, side);
    }
    
    @ExpectPlatform
    public static void registerPacket(CustomPacketPayload.Type<ModPacket> type, StreamCodec<RegistryFriendlyByteBuf, ModPacket> codec, ModPacket.Side side) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void clientSendPacket(ModPacket packet) {
        throw new AssertionError();
    }

    @SuppressWarnings("SameParameterValue")
    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id);
    }
}
