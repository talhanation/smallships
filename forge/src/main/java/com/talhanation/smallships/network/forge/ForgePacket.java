package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPacket;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public interface ForgePacket extends ModPacket {
    void handle(Supplier<NetworkEvent.Context> ctx);
}
