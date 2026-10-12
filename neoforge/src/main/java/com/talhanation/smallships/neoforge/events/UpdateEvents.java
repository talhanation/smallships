package com.talhanation.smallships.neoforge.events;

import com.talhanation.smallships.update.UpdateChecker;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

/**
 * Tells the update checker that the server is up. Only from here on the server
 * config is loaded, which decides whether the check is wanted at all.
 */
public class UpdateEvents {
    @SubscribeEvent
    public void onServerStarted(ServerStartedEvent event) {
        UpdateChecker.onServerStarted();
    }
}