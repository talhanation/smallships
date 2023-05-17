package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ModPacketsImpl {
    private static final Map<String, ModPackets.SendablePacket<FabricPacket>> entries = new HashMap<>();

    static {
        entries.put("server_open_ship_screen", (params) -> new ServerboundOpenShipScreenFabricPacket(((ContainerShip) params[0]), ((Integer) params[1])));
        entries.put("server_toggle_ship_sail", (params) -> new ServerboundToggleShipSailFabricPacket());
        entries.put("server_shoot_ship_cannon", (params) -> new ServerboundShootShipCannonFabricPacket((Boolean) params[0]));
        entries.put("server_set_sail_state", (params) -> new ServerboundSetSailStateFabricPacket((Byte) params[0]));
        entries.put("server_update_ship_control", (params) -> new ServerboundUpdateShipControlFabricPacket((Boolean) params[0], (Boolean) params[1], (Boolean) params[2], (Boolean) params[3]));
    }

    public static ModPackets.SendablePacket<FabricPacket> getPacket(String id) {
        return entries.get(id);
    }

    public static void registerPackets() {
        registerServerPacket(ModPackets.id("server_open_ship_screen"), (server, player, handler, buf, responseSender) -> {
            ServerboundOpenShipScreenFabricPacket packet = new ServerboundOpenShipScreenFabricPacket(buf);
            packet.receive(server, player, handler, buf, responseSender);
        });

        registerServerPacket(ModPackets.id("server_toggle_ship_sail"), (server, player, handler, buf, responseSender) -> {
            ServerboundToggleShipSailFabricPacket packet = new ServerboundToggleShipSailFabricPacket(buf);
            packet.receive(server, player, handler, buf, responseSender);
        });

        registerServerPacket(ModPackets.id("server_shoot_ship_cannon"), (server, player, handler, buf, responseSender) -> {
            ServerboundShootShipCannonFabricPacket packet = new ServerboundShootShipCannonFabricPacket(buf);
            packet.receive(server, player, handler, buf, responseSender);
        });

        registerServerPacket(ModPackets.id("server_set_sail_state"), (server, player, handler, buf, responseSender) -> {
            ServerboundSetSailStateFabricPacket packet = new ServerboundSetSailStateFabricPacket(buf);
            packet.receive(server, player, handler, buf, responseSender);
        });

    }

    @SuppressWarnings({"SameParameterValue", "unused"})
    private static void registerServerPacket(ResourceLocation id, ServerPlayNetworking.PlayChannelHandler channelHandler) {
        ServerPlayNetworking.registerGlobalReceiver(id, channelHandler);
    }

    @SuppressWarnings({"SameParameterValue"})
    private static void registerClientPacket(ResourceLocation id, ClientPlayNetworking.PlayChannelHandler channelHandler) {
        ClientPlayNetworking.registerGlobalReceiver(id, channelHandler);
    }

    public static <T extends ModPacket> void serverSendPacket(ServerPlayer player, T packetIn) {
        FabricPacket packet = (FabricPacket) packetIn;
        FriendlyByteBuf buf = PacketByteBufs.create();
        packet.toBytes(buf);
        ServerPlayNetworking.send(player, packet.getId(), buf);
    }

    public static <T extends ModPacket> void clientSendPacket(Player player, T packetIn) {
        FabricPacket packet = (FabricPacket) packetIn;
        FriendlyByteBuf buf = PacketByteBufs.create();
        packet.toBytes(buf);
        ClientPlayNetworking.send(packet.getId(), buf);
    }
}
