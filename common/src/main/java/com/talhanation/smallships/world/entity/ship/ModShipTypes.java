package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

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
            .ingredient(ItemTags.PLANKS, 132)
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
            .ingredient(ItemTags.PLANKS, 260)
            .ingredient(Items.WHITE_WOOL, 64)
            .ingredient(Items.STRING, 24)
            .ingredient(Items.IRON_INGOT, 16)
            .build());

    /**
     * Galley - the Mediterranean oared hull. 200 hull, one lateen sail.
     * Long and narrow, but a light shell: its drive is muscle, not canvas, and
     * the hull is mostly joinery rather than ironwork, hence three quarters of
     * the nugget rate.
     */
    public static final ShipType GALLEY = ShipRegistry.register(ShipType.builder(id(GalleyEntity.ID), GalleyEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 84)
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
            .ingredient(ItemTags.PLANKS, 112)
            .ingredient(Items.WHITE_WOOL, 48)
            .ingredient(Items.STRING, 16)
            .build());

    /**
     * Drakkar - the clinker built Viking hull. 200 hull, one square sail.
     * Overlapping strakes were fastened with thousands of iron rivets, so the
     * iron sits at half again the cogs' rate and far above what the size of the
     * hull would suggest.
     */
    public static final ShipType DRAKKAR = ShipRegistry.register(ShipType.builder(id(DrakkarEntity.ID), DrakkarEntity::summon)
            .buildTime(120 * 20)
            .ingredient(ItemTags.PLANKS, 102)
            .ingredient(Items.WHITE_WOOL, 24)
            .ingredient(Items.STRING, 18)
            .ingredient(Items.IRON_NUGGET, 18)
            .build());

    /**
     * Caravel - the Iberian explorer. 250 hull, two masts.
     * Carvel built: flush laid planking over frames, nailed the ordinary way,
     * so it sits on the plain cog rate for iron with no character factor.
     */
    public static final ShipType CARAVEL = ShipRegistry.register(ShipType.builder(id(CaravelEntity.ID), CaravelEntity::summon)
            .buildTime(135 * 20)
            .ingredient(ItemTags.PLANKS, 148)
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
            .ingredient(ItemTags.PLANKS, 358)
            .ingredient(Items.WHITE_WOOL, 128)
            .ingredient(Items.STRING, 53)
            .ingredient(Items.IRON_INGOT, 32)
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