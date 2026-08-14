package com.talhanation.smallships.client;

import com.talhanation.smallships.api.client.ShipRenderRegistry;
import com.talhanation.smallships.client.gui.screens.inventory.DockyardScreen;
import com.talhanation.smallships.client.gui.screens.inventory.ShipContainerScreen;
import com.talhanation.smallships.client.model.sail.*;
import com.talhanation.smallships.client.model.sail.banner.CogSailBannerModel;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;

public class ClientInitializer {
    public static void init() {
        //common client
        MenuScreens.register(ModMenuTypes.SHIP_CONTAINER, ShipContainerScreen::new);
        MenuScreens.register(ModMenuTypes.DOCKYARD, DockyardScreen::new);

        initRegisterShipRenderLayers();
    }

    /**
     * Sail and sail banner layers of the built-in ships. Addons register their
     * own the same way from their client entry point, the shared ShipRenderer
     * picks them up without knowing the ship class.
     */
    private static void initRegisterShipRenderLayers() {
        ShipRenderRegistry.registerSail(CogEntity.class, new CogSailModel());
        ShipRenderRegistry.registerSail(BriggEntity.class, new BriggSailModel());
        ShipRenderRegistry.registerSail(GalleyEntity.class, new GalleySailModel());
        ShipRenderRegistry.registerSail(DhowEntity.class, new DhowSailModel());
        ShipRenderRegistry.registerSail(DrakkarEntity.class, new DrakkarSailModel());
        ShipRenderRegistry.registerSail(GalleonEntity.class, new GalleonSailModel());
        ShipRenderRegistry.registerSail(CaravelEntity.class, new CaravelSailModel());

        ShipRenderRegistry.registerSailBanner(CogEntity.class, new CogSailBannerModel());
    }
}