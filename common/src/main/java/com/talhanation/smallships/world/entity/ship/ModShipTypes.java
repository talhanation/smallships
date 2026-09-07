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
 *
 * <h2>How the numbers are found</h2>
 *
 * Every recipe is derived from what the ship IS, not guessed per ship. The
 * dockyard already prices a repair off the missing points
 * ({@code DockyardBlockEntity.HULL_HP_PER_UNIT}, {@code SAIL_HP_PER_WOOL}), and
 * a build is nothing but a repair from zero - so the same rates set the build
 * cost too, and hull, canvas and rigging can never drift apart from what
 * fixing them costs.
 *
 * <pre>
 *   hull units = maxHealth / 10          one unit = 4 planks + 1 nugget = 10 hp
 *   planks     = hull units * 4 * 1.2
 *   iron       = hull units * 1.2 * (fastening of that hull, see below)
 *   wool       = 20 per sail * 1.2       one wool = 5 sail hp, 100 hp per sail
 *   string     = 12 per sail * (rigging of that hull)
 *   build time = 60s + 0.3s per hull point
 * </pre>
 *
 * The 1.2 says building costs a fifth more than fixing: a wreck is always worth
 * hauling back to the dockyard rather than scuttling and starting over. The
 * factor is anchored on the cog, whose 192 planks and 180 seconds came out of
 * the old hand written recipe and are reproduced exactly by the formula.
 *
 * What stays per ship is only the CHARACTER of the fastening and the rigging,
 * because that is the part history actually differs on - the amount always
 * follows the hull.
 */
public class ModShipTypes {

    /**
     * Cog - the North Sea trader. 400 hull, one square sail.
     * The cog was the first northern hull built with iron nails in quantity
     * instead of lashings, which is what the full nugget rate stands for. The
     * readable reference recipe: every number below is exactly what the formula
     * gives, with no character factor applied at all.
     */
    public static final ShipType COG = ShipRegistry.register(ShipType.builder(id(CogEntity.ID), CogEntity::summon)
            .buildTime(180 * 20)
            .ingredient(ItemTags.PLANKS, 192)
            .ingredient(Items.WHITE_WOOL, 24)
            .ingredient(Items.STRING, 12)
            .ingredient(Items.IRON_NUGGET, 48)
            .build());

    /**
     * Brigg - 500 hull, two square rigged masts.
     * The 19th century hull was held together by forged iron knees and bolts
     * rather than nails, so the iron goes up a quarter over the cog and is
     * asked for as ingots - at this size counting nuggets stops being readable.
     */
    public static final ShipType BRIGG = ShipRegistry.register(ShipType.builder(id(BriggEntity.ID), BriggEntity::summon)
            .buildTime(210 * 20)
            .ingredient(ItemTags.PLANKS, 240)
            .ingredient(Items.WHITE_WOOL, 48)
            .ingredient(Items.STRING, 24)
            .ingredient(Items.IRON_INGOT, 8)
            .build());

    /**
     * Galley - the Mediterranean oared hull. 200 hull, one lateen sail.
     * Long and narrow, but a light shell: its drive is muscle, not canvas, and
     * the hull is mostly joinery rather than ironwork, hence three quarters of
     * the nugget rate.
     */
    public static final ShipType GALLEY = ShipRegistry.register(ShipType.builder(id(GalleyEntity.ID), GalleyEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 96)
            .ingredient(Items.WHITE_WOOL, 24)
            .ingredient(Items.STRING, 12)
            .ingredient(Items.IRON_NUGGET, 18)
            .build());

    /**
     * Dhow - the monsoon runner. 200 hull, two lateen sails.
     * Sewn-plank construction: the hull was stitched together with coconut coir
     * rope and used no iron nails at all, which is why this is the only recipe
     * in the mod without a single piece of iron and the only one that asks for
     * double rope - the cordage IS the fastening here.
     */
    public static final ShipType DHOW = ShipRegistry.register(ShipType.builder(id(DhowEntity.ID), DhowEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 96)
            .ingredient(Items.WHITE_WOOL, 48)
            .ingredient(Items.STRING, 48)
            .build());

    /**
     * Drakkar - the clinker built Viking hull. 200 hull, one square sail.
     * Overlapping strakes were fastened with thousands of iron rivets, so the
     * iron sits at half again the cogs' rate and far above what the size of the
     * hull would suggest.
     */
    public static final ShipType DRAKKAR = ShipRegistry.register(ShipType.builder(id(DrakkarEntity.ID), DrakkarEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 96)
            .ingredient(Items.WHITE_WOOL, 24)
            .ingredient(Items.STRING, 12)
            .ingredient(Items.IRON_NUGGET, 36)
            .build());

    /**
     * Caravel - the Iberian explorer. 250 hull, two masts.
     * Carvel built: flush laid planking over frames, nailed the ordinary way,
     * so it sits on the plain cog rate for iron with no character factor.
     */
    public static final ShipType CARAVEL = ShipRegistry.register(ShipType.builder(id(CaravelEntity.ID), CaravelEntity::summon)
            .buildTime(135 * 20)
            .ingredient(ItemTags.PLANKS, 120)
            .ingredient(Items.WHITE_WOOL, 48)
            .ingredient(Items.STRING, 24)
            .ingredient(Items.IRON_NUGGET, 30)
            .build());

    /**
     * Galleon - the biggest hull of the mod. 700 hull, three masts.
     * Heavy frames, forged knees and bolts like the brigg, and by far the
     * largest canvas in the fleet.
     *
     * NOTE: the canvas and rigging here are priced for THREE sails, which is
     * what the ship carries. {@code GalleonEntity} does not override
     * {@code getParts()} yet, so {@code Sailable.getSailCount()} falls back to
     * one and the sail repair prices this ship as if it had a single sail.
     * Adding the mast definitions fixes both at once.
     */
    public static final ShipType GALLEON = ShipRegistry.register(ShipType.builder(id(GalleonEntity.ID), GalleonEntity::summon)
            .buildTime(270 * 20)
            .ingredient(ItemTags.PLANKS, 336)
            .ingredient(Items.WHITE_WOOL, 72)
            .ingredient(Items.STRING, 36)
            .ingredient(Items.IRON_INGOT, 12)
            .build());


    /**
     * Loads this class and with it registers the built-in ship types. Must be
     * called after the configs are loaded, because the ship classes read their
     * attributes from them.
     */
    public static void init() {
    }

    private static ResourceLocation id(String path) {
        return new ResourceLocation(SmallShipsMod.MOD_ID, path);
    }
}