package com.talhanation.smallships.client;

import com.talhanation.smallships.api.client.ShipRenderRegistry;
import com.talhanation.smallships.client.gui.screens.inventory.DockyardScreen;
import com.talhanation.smallships.client.gui.screens.inventory.GroundCannonContainerScreen;
import com.talhanation.smallships.client.gui.screens.inventory.ShipContainerScreen;
import com.talhanation.smallships.client.model.sail.BriggSailModel;
import com.talhanation.smallships.client.model.sail.CogSailModel;
import com.talhanation.smallships.client.model.sail.DhowSailModel;
import com.talhanation.smallships.client.model.sail.DrakkarSailModel;
import com.talhanation.smallships.client.model.sail.GalleySailModel;
import com.talhanation.smallships.client.model.sail.banner.CogSailBannerModel;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;

public class ClientInitializer {
    public static void init() {
        //common client
        MenuScreens.register(ModMenuTypes.SHIP_CONTAINER, ShipContainerScreen::new);
        MenuScreens.register(ModMenuTypes.CANNON_CONTAINER, GroundCannonContainerScreen::new);
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

        ShipRenderRegistry.registerSailBanner(CogEntity.class, new CogSailBannerModel());
    }
}