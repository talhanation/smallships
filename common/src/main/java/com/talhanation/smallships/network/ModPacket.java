package com.talhanation.smallships.network;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;

public interface ModPacket extends CustomPacketPayload {
    void handler(Player player);

    Side side();

    enum Side {
        CLIENTBOUND,
        SERVERBOUND
    }
}
