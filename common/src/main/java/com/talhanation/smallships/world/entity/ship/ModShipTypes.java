package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

/**
 * The ship types of the main mod. They go through {@link ShipRegistry} exactly
 * like an addons' ships do - this class is nothing but the main mods' own addon
 * entry, so the dockyard never has to know a concrete ship class.
 *
 * The recipes below are the fallbacks. The files under
 * data/smallships/dockyard_recipes/ carry the same values and are what players
 * and pack makers actually edit - keep both in sync when tuning.
 *
 * Feature: ships are ONLY craftable at the dockyard, the vanilla crafting
 * recipes have been removed.
 */
public class ModShipTypes {

    /**
     * Cog - the North Sea trader, 300 hull, 108 cargo.
     * The cog was the first northern hull built with iron nails in quantity
     * instead of lashings, hence the heavy nugget cost, and it carried a single
     * modest square sail. The readable reference recipe for everything else.
     */
    public static final ShipType COG = ShipRegistry.register(ShipType.builder(id(CogEntity.ID), CogEntity::summon)
            .buildTime(180 * 20)
            .ingredient(ItemTags.PLANKS, 192)
            .ingredient(Items.WHITE_WOOL, 36)
            .ingredient(Items.STRING, 12)
            .ingredient(Items.IRON_NUGGET, 36)
            .build());

    /**
     * Brigg - the biggest hull of the mod, 400 hull, 162 cargo, 6 cannons.
     * Two fully square rigged masts mean by far the largest canvas and the most
     * standing and running rigging in the fleet, and the 19th century hull was
     * held together by forged iron knees and bolts rather than nails.
     */
    public static final ShipType BRIGG = ShipRegistry.register(ShipType.builder(id(BriggEntity.ID), BriggEntity::summon)
            .buildTime(320 * 20)
            .ingredient(ItemTags.PLANKS, 288)
            .ingredient(Items.WHITE_WOOL, 96)
            .ingredient(Items.STRING, 36)
            .ingredient(Items.IRON_INGOT, 18)
            .build());

    /**
     * Galley - the Mediterranean oared hull, 200 hull, 54 cargo.
     * Long, narrow and mostly rowing benches and oars, so it eats timber while
     * carrying only a small lateen sail. Its drive is muscle, not canvas.
     */
    public static final ShipType GALLEY = ShipRegistry.register(ShipType.builder(id(GalleyEntity.ID), GalleyEntity::summon)
            .buildTime(220 * 20)
            .ingredient(ItemTags.PLANKS, 216)
            .ingredient(Items.WHITE_WOOL, 18)
            .ingredient(Items.STRING, 12)
            .ingredient(Items.IRON_NUGGET, 18)
            .build());

    /**
     * Dhow - the monsoon runner, 150 hull, 135 cargo, 4 cannons.
     * Sewn-plank construction: the hull was stitched together with coconut coir
     * rope and used no iron nails at all, which is why this is the only recipe
     * in the mod without a single piece of iron and the one that demands rope
     * by the bale. The huge lateen sail explains the wool.
     */
    public static final ShipType DHOW = ShipRegistry.register(ShipType.builder(id(DhowEntity.ID), DhowEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 144)
            .ingredient(Items.WHITE_WOOL, 72)
            .ingredient(Items.STRING, 48)
            .build());

    /**
     * Drakkar - the clinker built Viking hull, 200 hull, 54 cargo.
     * Overlapping strakes were fastened with thousands of iron rivets, and the
     * woolen sail was the single most expensive part of the ship: spinning and
     * weaving one took the fleece of a small flock and years of work. Wool and
     * iron therefore sit far above what its size would suggest.
     */
    public static final ShipType DRAKKAR = ShipRegistry.register(ShipType.builder(id(DrakkarEntity.ID), DrakkarEntity::summon)
            .buildTime(200 * 20)
            .ingredient(ItemTags.PLANKS, 168)
            .ingredient(Items.WHITE_WOOL, 48)
            .ingredient(Items.STRING, 18)
            .ingredient(Items.IRON_NUGGET, 48)
            .build());

    /**
     * Caravel - the clinker built Viking hull, 200 hull, 54 cargo.
     * Overlapping strakes were fastened with thousands of iron rivets, and the
     * woolen sail was the single most expensive part of the ship: spinning and
     * weaving one took the fleece of a small flock and years of work. Wool and
     * iron therefore sit far above what its size would suggest.
     */

    public static final ShipType CARAVEL = ShipRegistry.register(ShipType.builder(id(CaravelEntity.ID), CaravelEntity::summon)
            .buildTime(250 * 20)
            .ingredient(ItemTags.PLANKS, 148)
            .ingredient(Items.WHITE_WOOL, 72)
            .ingredient(Items.STRING, 18)
            .ingredient(Items.IRON_NUGGET, 18)
            .build());


    /**
     * Galleon - the biggest hull of the mod, 400 hull, 162 cargo, 6 cannons.
     * Two fully square rigged masts mean by far the largest canvas and the most
     * standing and running rigging in the fleet, and the 19th century hull was
     * held together by forged iron knees and bolts rather than nails.
     */
    public static final ShipType GALLEON = ShipRegistry.register(ShipType.builder(id(GalleonEntity.ID), GalleonEntity::summon)
            .buildTime(320 * 20)
            .ingredient(ItemTags.PLANKS, 288)
            .ingredient(Items.WHITE_WOOL, 96)
            .ingredient(Items.STRING, 36)
            .ingredient(Items.IRON_INGOT, 18)
            .build());


    /**
     * Loads this class and with it registers the built-in ship types. Must be
     * called after the configs are loaded, because the ship classes read their
     * attributes from them.
     */
    public static void init() {
    }

    private static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, path);
    }
}