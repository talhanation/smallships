package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.update.UpdateChecker;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
