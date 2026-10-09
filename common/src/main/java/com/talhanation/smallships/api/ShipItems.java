package com.talhanation.smallships.api;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.item.ShipItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * The placeable ship items: one per wood type and ship, registered here for
 * the main mod and every addon alike. An addon names its ship once and gets
 * all of them - no item classes, no item registers of its own, no lookup map
 * for getDropItem.
 *
 * <pre>
 * ShipItems.register("myaddon", LongshipEntity.ID, LongshipEntity::summon);
 * </pre>
 *
 * WHEN matters, and it is NOT when the ship type goes to {@link ShipRegistry}:
 * - Forge: in the mod CONSTRUCTOR. The items go into a register on the event
 *   bus of the mod that is being constructed right now, and Forge only takes
 *   items until the registries freeze - long before FMLCommonSetupEvent, which
 *   is where the ship TYPE is registered.
 * - Fabric: in onInitialize.
 * Nothing here reads a config, which is what makes the early call possible.
 *
 * The items are registered under the CALLERS mod id with the same names the
 * addons used to register themselves, {@code <wood>_<ship>} - e.g.
 * {@code smallships_addon:oak_early_cog}. Existing worlds keep their items.
 *
 * Models, textures and the lang entries stay with the mod that owns the ship:
 * resources live in its own namespace.
 */
public final class ShipItems {

    /** ship id -> one item per wood type, in registration order */
    private static final Map<ResourceLocation, Map<Boat.Type, Supplier<Item>>> ITEMS = new LinkedHashMap<>();

    private ShipItems() {
    }

    /**
     * Registers the items of one ship, one per wood type.
     *
     * Synchronized because Forge constructs mods in parallel, so several
     * addons may register at the same time.
     *
     * @param modId   the namespace the items are registered under - the mod
     *                that owns the ship
     * @param shipId  the ships' id, the same as its entity id, e.g. {@code cog}
     * @param factory what the item places, usually the ships' own summon method
     */
    public static synchronized void register(String modId, String shipId, ShipType.Factory factory) {
        ResourceLocation id = new ResourceLocation(modId, shipId);
        if (ITEMS.containsKey(id)) {
            throw new IllegalStateException("Duplicate smallships ship items: " + id);
        }
        Map<Boat.Type, Supplier<Item>> items = new EnumMap<>(Boat.Type.class);
        for (Boat.Type type : Boat.Type.values()) {
            // a supplier, not the item: Forge wants the item built inside its
            // register event, not here in the constructor
            items.put(type, registerItem(modId, itemId(type, shipId),
                    () -> new ShipItem(type, factory, new Item.Properties().stacksTo(1))));
        }
        ITEMS.put(id, items);
    }

    /**
     * @param shipId the ships' id with namespace - for a ship that is its
     *               entity type key, see Ship#getDropItem
     * @return the item for that wood type, or null if the ship has no items
     */
    @Nullable
    public static synchronized Item get(ResourceLocation shipId, Boat.Type type) {
        Map<Boat.Type, Supplier<Item>> items = ITEMS.get(shipId);
        return items == null ? null : items.get(type).get();
    }

    /**
     * @return every ship item, for the creative tabs. Grouped by WOOD first,
     * then by ship - the order the tab always had, all ships of one wood next
     * to each other.
     *
     * The main mods' ships come first, the addons' after them. Forge constructs
     * mods in parallel, so registration order alone would shuffle the tab
     * from one start to the next.
     */
    public static synchronized List<Item> getAll() {
        List<ResourceLocation> ships = new ArrayList<>(ITEMS.keySet());
        // stable: within each group the registration order stays
        ships.sort(Comparator.comparing(ship -> !SmallShipsMod.MOD_ID.equals(ship.getNamespace())));

        List<Item> all = new ArrayList<>();
        for (Boat.Type type : Boat.Type.values()) {
            for (ResourceLocation ship : ships) {
                all.add(ITEMS.get(ship).get(type).get());
            }
        }
        return all;
    }

    /** Registry name of a ship item, e.g. {@code dark_oak_cog}. */
    public static String itemId(Boat.Type type, String shipId) {
        return type.getName().replaceAll("[^a-z0-9_.-]", "_") + "_" + shipId;
    }

    /**
     * Puts one item into the item registry of the loader.
     *
     * @return a supplier that hands out the registered item once the registry
     * has it - on Forge that is only after the register event
     */
    @ExpectPlatform
    public static Supplier<Item> registerItem(String modId, String id, Supplier<Item> item) {
        throw new AssertionError();
    }
}
