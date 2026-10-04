package com.talhanation.smallships.client;

import com.talhanation.smallships.client.cannon.CannonAimHandler;
import com.talhanation.smallships.client.wind.ClientWindManager;
import com.talhanation.smallships.client.wind.WindEffects;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

/**
 * Central per-client-tick logic, hooked from the platform specific
 * client tick events (Forge: TickEvent.ClientTickEvent, Fabric: END_CLIENT_TICK).
 */
public class ClientTickHandler {
    public static void onClientTick(Minecraft minecraft) {
        // before the level check: this one has to see the world come AND go
        UpdateNotifier.tick(minecraft);
        // the tips too: leaving the world aboard a ship has to reset them
        TipManager.tick();
        ShipTipHandler.tick(minecraft);
        if (minecraft.level == null) return;
        ClientWindManager.tick();
        WindEffects.tick(minecraft);
        CannonAimHandler.tick(minecraft);
        tickShipHulls(minecraft);
    }

    /**
     * Pose and collision parts of every ship, see Ship#tickClientHull for why
     * this runs from here and not from the ships' own tick. Not while paused:
     * the entities stand still then, and so does this.
     */
    private static void tickShipHulls(Minecraft minecraft) {
        if (minecraft.isPaused()) return;
        for (Entity entity : minecraft.level.entitiesForRendering()) {
            if (entity instanceof Ship ship) ship.tickClientHull();
        }
    }
}