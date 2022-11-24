package com.talhanation.smallships.client;

import com.talhanation.smallships.client.gui.screens.inventory.ShipContainerScreen;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;

public class ClientInitializer {
    public static void init() {
        //common client
        MenuScreens.register(ModMenuTypes.SHIP_CONTAINER, ShipContainerScreen::new);
    }
}
