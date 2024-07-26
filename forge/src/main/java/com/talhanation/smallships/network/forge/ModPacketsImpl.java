package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModPacketsImpl {
    private static int id = 0;
    private static final Map<String, ModPackets.SendablePacket<ForgePacket>> entries = new HashMap<>();
    public static final SimpleChannel SIMPLE_CHANNEL = ChannelBuilder.named(SmallShipsMod.MOD_ID).simpleChannel();

    static {
        entries.put("server_open_ship_screen", (params) -> new ServerboundOpenShipScreenForgePacket(((UUID) params[0]), ((Integer) params[1])));
        entries.put("server_toggle_ship_sail", (params) -> new ServerboundToggleShipSailForgePacket());
        entries.put("server_shoot_ship_cannon", (params) -> new ServerboundShootShipCannonForgePacket((Boolean) params[0]));
        entries.put("server_set_sail_state", (params) -> new ServerboundSetSailStateForgePacket((Byte) params[0]));
        entries.put("server_update_ship_control", (params) -> new ServerboundUpdateShipControlForgePacket((Boolean) params[0], (Boolean) params[1], (Boolean) params[2], (Boolean) params[3]));
    }

    public static ModPackets.SendablePacket<ForgePacket> getPacket(String id) {
        return entries.get(id);
    }

    public static void registerPackets() {
        registerPacket(SIMPLE_CHANNEL, ServerboundOpenShipScreenForgePacket.class, NetworkDirection.PLAY_TO_SERVER);
        registerPacket(SIMPLE_CHANNEL, ServerboundToggleShipSailForgePacket.class, NetworkDirection.PLAY_TO_SERVER);
        registerPacket(SIMPLE_CHANNEL, ServerboundShootShipCannonForgePacket.class, NetworkDirection.PLAY_TO_SERVER);
        registerPacket(SIMPLE_CHANNEL, ServerboundSetSailStateForgePacket.class, NetworkDirection.PLAY_TO_SERVER);
        registerPacket(SIMPLE_CHANNEL, ServerboundUpdateShipControlForgePacket.class, NetworkDirection.PLAY_TO_SERVER);
    }

    @SuppressWarnings({"SameParameterValue"})
    private static <T extends ForgePacket> void registerPacket(SimpleChannel channel, Class<T> packetClass, NetworkDirection direction) {
        channel.messageBuilder(packetClass, id++, direction)
                .decoder((buf) -> {
                    try {
                        return packetClass.getConstructor(FriendlyByteBuf.class).newInstance(buf);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .encoder(ForgePacket::toBytes)
                .consumerMainThread(ForgePacket::handle)
                .add();
    }

    public static <T extends ModPacket> void serverSendPacket(ServerPlayer player, T packet) {
        SIMPLE_CHANNEL.send(packet, PacketDistributor.PLAYER.with(player));
    }

    public static <T extends ModPacket> void clientSendPacket(Player player, T packet) {
        SIMPLE_CHANNEL.send(packet, PacketDistributor.SERVER.noArg());
    }
}
