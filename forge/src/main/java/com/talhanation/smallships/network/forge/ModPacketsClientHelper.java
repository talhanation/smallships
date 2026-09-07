package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.network.ModPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 *  This class exists so that Minecraft is not loaded on the dedicated server.
 *  It is only ever reached through DistExecutor from ModPacketsImpl.
 */

@OnlyIn(Dist.CLIENT)
public class ModPacketsClientHelper {
    public static void handle(ModPacket packet) {
        packet.handler(Minecraft.getInstance().player);
    }
}