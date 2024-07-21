package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPacket;
import net.minecraftforge.event.network.CustomPayloadEvent;

public interface ForgePacket extends ModPacket {
    void handle(CustomPayloadEvent.Context ctx);
}
