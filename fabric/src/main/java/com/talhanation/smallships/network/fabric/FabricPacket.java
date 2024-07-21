package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPacket;
import net.minecraft.resources.ResourceLocation;

public interface FabricPacket extends ModPacket {
    ResourceLocation getId();
}
