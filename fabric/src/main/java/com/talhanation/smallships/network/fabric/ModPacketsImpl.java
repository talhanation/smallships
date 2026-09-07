package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModPacketsImpl {
    private static final Map<ResourceLocation, ModPacket.Reader> clientReceivers = new HashMap<>();
    private static final Map<ResourceLocation, ModPacket.Reader> serverReceivers = new HashMap<>();

    public static void registerPacket(ResourceLocation id, ModPacket.Side side, ModPacket.Reader reader) {
        switch (side) {
            case CLIENTBOUND -> clientReceivers.put(id, reader);
            case SERVERBOUND -> serverReceivers.put(id, reader);
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerClientReceivers() {
        ModPacketsClientHelper.registerClientReceivers(clientReceivers);
    }

    public static void registerServerReceivers() {
        for (Map.Entry<ResourceLocation, ModPacket.Reader> entry : serverReceivers.entrySet()) {
            ModPacket.Reader reader = entry.getValue();
            ServerPlayNetworking.registerGlobalReceiver(entry.getKey(), (server, player, handler, buf, responseSender) -> {
                // the buffer is only valid on the network thread, so it has to be
                // read out here - only the finished packet crosses over to the
                // main thread
                ModPacket packet = reader.read(buf);
                server.execute(() -> packet.handler(player));
            });
        }
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        FriendlyByteBuf buf = PacketByteBufs.create();
        packet.write(buf);
        ServerPlayNetworking.send(player, packet.id(), buf);
    }

    @Environment(EnvType.CLIENT)
    public static void clientSendPacket(ModPacket packet) {
        ModPacketsClientHelper.clientSendPacket(packet);
    }
}