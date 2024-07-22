package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPlayPayloadHandler;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.apache.commons.lang3.tuple.Triple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ModPacketsImpl {
    private static final Map<String, ModPackets.SendablePacket<NeoForgePacket>> entries = new HashMap<>();
    private static final boolean DEBUG_PACKETS = false;

    public static final List<Triple<ResourceLocation, FriendlyByteBuf.Reader<NeoForgePacket>, IPlayPayloadHandler<NeoForgePacket>>> serverboundPackets = new ArrayList<>();
    public static final List<Triple<ResourceLocation, FriendlyByteBuf.Reader<NeoForgePacket>, IPlayPayloadHandler<NeoForgePacket>>> clientboundPackets = new ArrayList<>();

    static {
        registerPacket(ServerboundOpenShipScreenNeoForgePacket.class, true);
        registerPacket(ServerboundToggleShipSailNeoForgePacket.class, true);
        registerPacket(ServerboundShootShipCannonNeoForgePacket.class, true);
        registerPacket(ServerboundSetSailStateNeoForgePacket.class, true);
        registerPacket(ServerboundUpdateShipControlNeoForgePacket.class, true);
    }

    public static ModPackets.SendablePacket<NeoForgePacket> getPacket(String id) {
        return entries.get(id);
    }

    public static void registerPackets() {
        // Registration is event based
    }

    @SuppressWarnings({"SameParameterValue"})
    private static <T extends NeoForgePacket> void registerPacket(Class<T> packetClass, boolean serverbound) {
        ResourceLocation id;

        try {
            Field idField = packetClass.getDeclaredField("ID");
            idField.setAccessible(true);
            id = (ResourceLocation) idField.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        entries.put(id.getPath(), args -> {
            try {
                if (DEBUG_PACKETS) {
                    System.out.println("Trying to send " + packetClass.getSimpleName());
                    System.out.println("Available ctors:");
                    System.out.println(Arrays.toString(Arrays.stream(packetClass.getDeclaredConstructors()).map(Constructor::getParameterTypes).map(Arrays::toString).toArray()));
                    System.out.println("Found matching " + Arrays.stream(packetClass.getDeclaredConstructors()).filter(c -> c.getParameterCount() == 0 || !c.getParameterTypes()[0].equals(FriendlyByteBuf.class)).findAny().orElseThrow());
                    System.out.println("Types of args:");
                    System.out.println(Arrays.toString(Arrays.stream(args).map(a -> a.getClass().getSimpleName()).toArray()));
                    System.out.println("Applying args:");
                    System.out.println(Arrays.toString(args));
                }
                return (NeoForgePacket) Arrays.stream(packetClass.getDeclaredConstructors()).filter(c -> c.getParameterCount() == 0 || !c.getParameterTypes()[0].equals(FriendlyByteBuf.class)).findAny().orElseThrow().newInstance(args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                if (DEBUG_PACKETS) {
                    System.out.println("Finished trying to send " + packetClass.getSimpleName());
                }
            }
        });

        Triple<ResourceLocation, FriendlyByteBuf.Reader<NeoForgePacket>, IPlayPayloadHandler<NeoForgePacket>> packet = new Triple<>() {
            @Override
            public ResourceLocation getLeft() {
                return id;
            }

            @Override
            public FriendlyByteBuf.Reader<NeoForgePacket> getMiddle() {
                return buf -> {
                    try {
                        return packetClass.getDeclaredConstructor(FriendlyByteBuf.class).newInstance(buf);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                };
            }

            @Override
            public IPlayPayloadHandler<NeoForgePacket> getRight() {
                try {
                    Method method = packetClass.getMethod("handle", NeoForgePacket.class, PlayPayloadContext.class);
                    return (arg, playPayloadContext) -> {
                        try {
                            method.invoke(arg, arg, playPayloadContext);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    };
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        if (serverbound) {
            serverboundPackets.add(packet);
        } else {
            clientboundPackets.add(packet);
        }
    }

    public static <T extends ModPacket> void serverSendPacket(ServerPlayer player, T packet) {
        PacketDistributor.PLAYER.with(player).send((NeoForgePacket)packet);
    }

    public static <T extends ModPacket> void clientSendPacket(Player player, T packet) {
        PacketDistributor.SERVER.noArg().send((NeoForgePacket)packet);
    }
}
