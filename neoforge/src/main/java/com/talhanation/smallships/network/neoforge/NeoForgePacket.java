package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public interface NeoForgePacket extends ModPacket, CustomPacketPayload {
    void handle(NeoForgePacket packet, PlayPayloadContext ctx);
}
