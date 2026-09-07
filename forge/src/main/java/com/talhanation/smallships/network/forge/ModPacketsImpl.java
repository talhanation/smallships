package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.HashMap;
import java.util.Map;

public class ModPacketsImpl {
    private static final String PROTOCOL_VERSION = "1";

    private static final Map<ResourceLocation, ModPacket.Reader> readers = new HashMap<>();

    // acceptMissingOr keeps the channel optional, so a client without the mod is
    // not rejected over the network handshake alone
    static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            ModPackets.id("channel"),
            () -> PROTOCOL_VERSION,
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION),
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION));

    /**
     * Forge dispatches a SimpleChannel message on its concrete class, and every
     * packet here shares ModPacket, so registering all of them separately is not
     * possible. Instead there is ONE message: the encoder puts the packet id on
     * the wire ahead of the body and the decoder uses it to pick the reader.
     * Costs a ResourceLocation per packet and keeps the common API identical to
     * fabric's.
     */
    public static void buildChannel() {
        CHANNEL.registerMessage(0, ModPacket.class,
                (packet, buf) -> {
                    buf.writeResourceLocation(packet.id());
                    packet.write(buf);
                },
                buf -> {
                    ResourceLocation id = buf.readResourceLocation();
                    ModPacket.Reader reader = readers.get(id);
                    if (reader == null) throw new IllegalStateException("Unknown smallships packet " + id);
                    return reader.read(buf);
                },
                (packet, contextSupplier) -> {
                    NetworkEvent.Context context = contextSupplier.get();
                    context.enqueueWork(() -> {
                        if (packet.side() == ModPacket.Side.SERVERBOUND) {
                            // getSender is null on the client, which is exactly
                            // how a spoofed serverbound packet arrives there
                            ServerPlayer sender = context.getSender();
                            if (sender != null) packet.handler(sender);
                        } else {
                            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ModPacketsClientHelper.handle(packet));
                        }
                    });
                    context.setPacketHandled(true);
                });
    }

    /** The side is carried by the packet itself, the channel only needs the reader. */
    public static void registerPacket(ResourceLocation id, ModPacket.Side side, ModPacket.Reader reader) {
        readers.put(id, reader);
    }

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static void clientSendPacket(ModPacket packet) {
        CHANNEL.sendToServer(packet);
    }
}