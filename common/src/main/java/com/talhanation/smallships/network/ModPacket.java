package com.talhanation.smallships.network;

import net.minecraft.network.FriendlyByteBuf;

public interface ModPacket {
    void toBytes(FriendlyByteBuf buf);
}
