package com.talhanation.smallships.api;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The central ship registry. Both the main mod and every addon register their
 * ships here, which is what lets a new ship reach the dockyard without a single
 * change inside the main mod.
 *
 * Registration belongs into the loader entry point, after the configs are
 * loaded: {@code FMLCommonSetupEvent} on Forge/NeoForge, {@code onInitialize}
 * on Fabric. The registry is thread safe because Forge dispatches mod setup in
 * parallel, so several mods may register at the same time.
 *
 * Iteration order is registration order, which keeps the dockyard ship list
 * stable for the player instead of shuffling with the mod load order.
 */
public final class ShipRegistry {

    private static final Map<ResourceLocation, ShipType> SHIP_TYPES = new LinkedHashMap<>();
    /** ids from the config whitelist that match no registered ship, warned about once */
    private static final Set<String> WARNED_UNKNOWN_IDS = new HashSet<>();

    private ShipRegistry() {
    }

    /**
     * Registers a ship type. The id must be unique, registering the same id
     * twice is a mod setup error and fails loudly instead of silently
     * shadowing another mods' ship.
     *
     * @return the registered ship type, so it can be kept in a static field
     */
    public static synchronized ShipType register(ShipType shipType) {
        ShipType previous = SHIP_TYPES.putIfAbsent(shipType.getId(), shipType);
        if (previous != null) {
            throw new IllegalStateException("Duplicate smallships ship type: " + shipType.getId());
        }
        return shipType;
    }

    @Nullable
    public static synchronized ShipType get(@Nullable ResourceLocation id) {
        return id == null ? null : SHIP_TYPES.get(id);
    }

    @Nullable
    public static ShipType get(@Nullable String id) {
        return id == null ? null : get(ResourceLocation.tryParse(id));
    }

    /** @return every registered ship type, ignoring the dockyard whitelist. */
    public static synchronized Collection<ShipType> getAll() {
        return Collections.unmodifiableCollection(new ArrayList<>(SHIP_TYPES.values()));
    }

    /**
     * Position of a ship type in the registration order.
     *
     * The dockyard syncs the ship it is currently building through the menus'
     * ContainerData, which carries plain ints - a ResourceLocation does not fit
     * through there. Registration happens identically on both sides at mod
     * setup, and the backing map keeps insertion order, so the index means the
     * same thing on the client. The CONFIG whitelist must not be involved here:
     * it is common config and not synced.
     *
     * @return the index, or -1 if the type is not registered
     */
    public static synchronized int indexOf(@Nullable ShipType shipType) {
        if (shipType == null) return -1;
        int index = 0;
        for (ResourceLocation id : SHIP_TYPES.keySet()) {
            if (id.equals(shipType.getId())) return index;
            index++;
        }
        return -1;
    }

    /** Counterpart of {@link #indexOf(ShipType)}. */
    @Nullable
    public static synchronized ShipType byIndex(int index) {
        if (index < 0) return null;
        int current = 0;
        for (ShipType shipType : SHIP_TYPES.values()) {
            if (current++ == index) return shipType;
        }
        return null;
    }

    /**
     * @return true if this ship may be built at the dockyard. An EMPTY config
     * whitelist means no restriction, so ships added by addons are accepted
     * without the player having to touch the config first.
     */
    public static boolean isBuildable(@Nullable ShipType shipType) {
        if (shipType == null) return false;
        List<String> whiteList = SmallShipsConfig.Server.dockyardBuildableShips.get();
        if (whiteList.isEmpty()) return true;
        return whiteList.contains(shipType.getId().toString());
    }

    /**
     * @return the ship types offered in the dockyard build tab, in registration
     * order. Unknown ids in the config are reported once and skipped.
     */
    public static List<ShipType> getBuildable() {
        List<String> whiteList = SmallShipsConfig.Server.dockyardBuildableShips.get();
        List<ShipType> buildable = new ArrayList<>();
        for (ShipType shipType : getAll()) {
            if (isBuildable(shipType)) buildable.add(shipType);
        }
        warnUnknownIds(whiteList);
        return buildable;
    }

    private static synchronized void warnUnknownIds(List<String> whiteList) {
        for (String id : whiteList) {
            if (get(id) != null || !WARNED_UNKNOWN_IDS.add(id)) continue;
            SmallShipsMod.LOGGER.warn("Unknown ship type '{}' in dockyardBuildableShips, ignoring it. Is the addon providing it installed?", id);
        }
    }
}