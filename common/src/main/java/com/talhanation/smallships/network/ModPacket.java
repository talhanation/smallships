package com.talhanation.smallships.network;

import net.minecraft.world.entity.player.Player;

public interface ModPacket {
    void handler(Player player);

    Side side();

    enum Side {
        CLIENTBOUND,
        SERVERBOUND
    }
}
