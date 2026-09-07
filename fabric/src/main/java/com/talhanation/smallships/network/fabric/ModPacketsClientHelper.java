package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

/**
 *  This class exists so that ClientPlayNetworking is not imported on the server side
 */

@Environment(EnvType.CLIENT)
public class ModPacketsClientHelper {
    public static void registerClientReceivers(Map<ResourceLocation, ModPacket.Reader> clientReceivers) {
        for (Map.Entry<ResourceLocation, ModPacket.Reader> entry : clientReceivers.entrySet()) {
            ModPacket.Reader reader = entry.getValue();
            ClientPlayNetworking.registerGlobalReceiver(entry.getKey(), (client, handler, buf, responseSender) -> {
                // read off the network thread while the buffer is still alive,
                // then hand the packet to the render thread
                ModPacket packet = reader.read(buf);
                client.execute(() -> packet.handler(client.player));
            });
        }
    }

    public static void clientSendPacket(ModPacket packet) {
        FriendlyByteBuf buf = PacketByteBufs.create();
        packet.write(buf);
        ClientPlayNetworking.send(packet.id(), buf);
    }
}