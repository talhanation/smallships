package com.talhanation.smallships.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public interface ModPacket {
    /** Identifies the packet on the wire and picks the reader on the far side. */
    ResourceLocation id();

    void write(FriendlyByteBuf buf);

    void handler(Player player);

    Side side();

    enum Side {
        CLIENTBOUND,
        SERVERBOUND
    }

    /**
     * The counterpart to {@link #write}. Every packet supplies one as a static
     * method, so a plain method reference is all the registration needs.
     */
    @FunctionalInterface
    interface Reader {
        ModPacket read(FriendlyByteBuf buf);
    }
}