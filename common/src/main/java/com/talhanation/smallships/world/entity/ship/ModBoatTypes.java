package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * The wood types SmallShips adds to the vanilla boat types: warped and crimson.
 *
 * Every ship variant is a {@link Boat.Type}, so the new woods are added to that
 * enum itself. The rest of the mod - items, renderer textures, dockyard wood
 * picker, save data - runs over {@code Boat.Type.values()} and picks them up
 * without knowing about them.
 *
 * How the constants get into the enum is up to the loader:
 * - NeoForge: enum extension, see META-INF/enumextensions.json and
 *   ModBoatTypeProxies in the neoforge module.
 * - Fabric: BoatTypeMixin in the fabric module.
 *
 * The names differ per loader, because the two loaders disagree on what a
 * name may look like:
 * - NeoForge demands the mod id as namespace ({@code smallships:warped}) and
 *   patches the vanilla code that builds resource locations from it.
 * - Fabric runs that vanilla code unpatched: the boat renderer turns the name
 *   into {@code boat/<name>}, where a ':' is not allowed. So the mod id goes in
 *   front with an underscore there ({@code smallships_warped}).
 * getWoodName takes either back to {@code warped}, so item ids and textures
 * are the same on both loaders. Only the name saved with the ship differs.
 */
public class ModBoatTypes {
    /** NeoForge names, the mod id as namespace */
    public static final String WARPED = SmallShipsMod.MOD_ID + ":warped";
    public static final String CRIMSON = SmallShipsMod.MOD_ID + ":crimson";

    /** Fabric names, no ':' - vanilla builds model layer and texture paths from them */
    public static final String WARPED_FABRIC = SmallShipsMod.MOD_ID + "_warped";
    public static final String CRIMSON_FABRIC = SmallShipsMod.MOD_ID + "_crimson";

    /** the enum constant names, NeoForge wants the mod id as prefix here as well */
    public static final String WARPED_CONSTANT = "SMALLSHIPS_WARPED";
    public static final String CRIMSON_CONSTANT = "SMALLSHIPS_CRIMSON";

    /**
     * @return the name of a wood type for item ids and texture paths. Our own
     * prefix is dropped, on NeoForge and Fabric alike, so the added woods read
     * like the vanilla ones ({@code smallships:warped} / {@code smallships_warped}
     * -> {@code warped_cog}). Wood types of other mods keep their namespace.
     */
    public static String getWoodName(Boat.Type type) {
        String name = type.getName();
        String namespaced = SmallShipsMod.MOD_ID + ":";
        String prefixed = SmallShipsMod.MOD_ID + "_";
        if (name.startsWith(namespaced)) return name.substring(namespaced.length());
        if (name.startsWith(prefixed)) return name.substring(prefixed.length());
        return name;
    }

    /**
     * @return true for the nether woods SmallShips adds. They are not offered
     * at the dockyard from the start, see DockyardRecipe#isWoodSelectable.
     */
    public static boolean isNetherWood(Boat.Type type) {
        String name = type.getName();
        return name.equals(WARPED) || name.equals(CRIMSON)
                || name.equals(WARPED_FABRIC) || name.equals(CRIMSON_FABRIC);
    }
}
