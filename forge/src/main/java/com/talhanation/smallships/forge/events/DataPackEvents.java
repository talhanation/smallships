package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

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