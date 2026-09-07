package com.talhanation.smallships.neoforge.events;

import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

/**
 * Hooks the dockyard recipe loader into the data pack reload, so editing a
 * recipe file only needs a /reload instead of a restart.
 */
public class DataPackEvents {
    @SubscribeEvent
    public void onAddReloadListener(AddReloadListenerEvent event) {
        event.addListener(new DockyardRecipeManager());
    }
}