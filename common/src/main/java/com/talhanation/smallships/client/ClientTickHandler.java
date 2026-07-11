package com.talhanation.smallships.client;

import com.talhanation.smallships.client.camera.ShipCameraHandler;
import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.client.wind.ClientWindManager;
import com.talhanation.smallships.client.wind.WindEffects;
import net.minecraft.client.Minecraft;

/**
 * Central per-client-tick logic, hooked from the platform specific
 * client tick events (Forge: TickEvent.ClientTickEvent, Fabric: END_CLIENT_TICK).
 */
public class ClientTickHandler {
    public static void onClientTick(Minecraft minecraft) {
        if (minecraft.level == null) return;
        ClientWindManager.tick();
        WindEffects.tick(minecraft);
        CannonAimHandler.tick(minecraft);
        ShipCameraHandler.tick();
    }
}
