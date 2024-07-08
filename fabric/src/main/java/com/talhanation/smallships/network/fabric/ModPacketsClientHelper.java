package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;

import java.util.List;

/**
 *  This class exists so that ClientPlayNetworking is not imported on the server side
 */

@Environment(EnvType.CLIENT)
public class ModPacketsClientHelper {
    public static void registerClientReceivers(List<CustomPacketPayload.Type<ModPacket>> clientReceivers) {
        for (CustomPacketPayload.Type<ModPacket> type : clientReceivers) {
            ClientPlayNetworking.registerGlobalReceiver(type, (packet, context) -> {
                context.client().execute(() -> {
                    Player player = context.client().player;
                    packet.handler(player);
                });
            });
        }
    }

    public static void clientSendPacket(ModPacket packet) {
        ClientPlayNetworking.send(packet);
    }
}
