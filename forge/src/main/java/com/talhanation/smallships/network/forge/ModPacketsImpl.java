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

public class ModPacketsImpl {
    private static final String PROTOCOL_VERSION = "1";

    /** forge numbers its messages, one index per registered packet class */
    private static int index;

    // acceptMissingOr keeps the channel optional, so a client without the mod is
    // not rejected over the network handshake alone
    static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            ModPackets.id("channel"),
            () -> PROTOCOL_VERSION,
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION),
            NetworkRegistry.acceptMissingOr(PROTOCOL_VERSION));

    /**
     * ONE registration per packet class - a single shared one on ModPacket does
     * NOT work: IndexedMessageCodec looks the codec up with
     * types.get(message.getClass()), an exact map hit, so a supertype key is
     * never found and sending dies with "Invalid message ...".
     *
     * The packet id therefore never goes on the wire here, unlike on fabric:
     * forge already identifies the message by its index.
     */
    public static void registerPacket(ResourceLocation id, ModPacket.Side side, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        registerTyped(side, type, reader);
    }

    @SuppressWarnings("unchecked")
    private static <T extends ModPacket> void registerTyped(ModPacket.Side side, Class<? extends ModPacket> type, ModPacket.Reader reader) {
        CHANNEL.registerMessage(index++, (Class<T>) type,
                (packet, buf) -> packet.write(buf),
                buf -> (T) reader.read(buf),
                (packet, contextSupplier) -> {
                    NetworkEvent.Context context = contextSupplier.get();
                    context.enqueueWork(() -> {
                        if (side == ModPacket.Side.SERVERBOUND) {
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

    public static void serverSendPacket(ServerPlayer player, ModPacket packet) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }

    public static void clientSendPacket(ModPacket packet) {
        CHANNEL.sendToServer(packet);
    }
}