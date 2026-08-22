package com.talhanation.smallships.api.client;

import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.client.model.sail.banner.MastBannerModel;
import com.talhanation.smallships.client.model.sail.banner.SailBannerModel;
import com.talhanation.smallships.world.entity.ship.Ship;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Client side counterpart of {@link com.talhanation.smallships.api.ShipRegistry}:
 * the sail, sail banner and mast banner models the shared {@code ShipRenderer}
 * draws on top of a ship. All of them are optional - a ship without a
 * registered model simply gets no such layer instead of crashing the renderer.
 *
 * Registration belongs into the clients' entry point, alongside the entity
 * renderers: {@code onInitializeClient} on Fabric, {@code FMLClientSetupEvent}
 * on Forge/NeoForge.
 */
public final class ShipRenderRegistry {

    private static final Map<Class<? extends Ship>, SailModel> SAIL_MODELS = new HashMap<>();
    private static final Map<Class<? extends Ship>, SailBannerModel> SAIL_BANNER_MODELS = new HashMap<>();
    private static final Map<Class<? extends Ship>, MastBannerModel> MAST_BANNER_MODELS = new HashMap<>();

    private ShipRenderRegistry() {
    }

    /** The sail layer drawn for this ship class, dyed and torn by the sail damage state. */
    public static void registerSail(Class<? extends Ship> shipClass, SailModel sailModel) {
        SAIL_MODELS.put(shipClass, sailModel);
    }

    /** The banner layer projected onto the sail of this ship class. */
    public static void registerSailBanner(Class<? extends Ship> shipClass, SailBannerModel sailBannerModel) {
        SAIL_BANNER_MODELS.put(shipClass, sailBannerModel);
    }

    /** The flag flying from the mast of this ship class, placed by the model itself. */
    public static void registerMastBanner(Class<? extends Ship> shipClass, MastBannerModel mastBannerModel) {
        MAST_BANNER_MODELS.put(shipClass, mastBannerModel);
    }

    @Nullable
    public static SailModel getSail(Class<? extends Ship> shipClass) {
        return SAIL_MODELS.get(shipClass);
    }

    @Nullable
    public static SailBannerModel getSailBanner(Class<? extends Ship> shipClass) {
        return SAIL_BANNER_MODELS.get(shipClass);
    }

    @Nullable
    public static MastBannerModel getMastBanner(Class<? extends Ship> shipClass) {
        return MAST_BANNER_MODELS.get(shipClass);
    }
}