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
 * On 1.20.1 neither loader can extend the enum on its own, so the constants
 * come in through BoatTypeMixin in common, the same on Fabric and Forge.
 *
 * The names carry the mod id with an underscore, not as a namespace: vanilla
 * turns the name into model layer and texture paths ({@code boat/<name>}),
 * where a ':' is not allowed. getWoodName takes them back to {@code warped},
 * so item ids and textures read like the vanilla woods.
 */
public class ModBoatTypes {
    public static final String WARPED = SmallShipsMod.MOD_ID + "_warped";
    public static final String CRIMSON = SmallShipsMod.MOD_ID + "_crimson";

    /** the enum constant names, prefixed with the mod id */
    public static final String WARPED_CONSTANT = "SMALLSHIPS_WARPED";
    public static final String CRIMSON_CONSTANT = "SMALLSHIPS_CRIMSON";

    /**
     * @return the name of a wood type for item ids and texture paths. Our own
     * prefix is dropped, so the added woods read like the vanilla ones
     * ({@code smallships_warped} -> {@code warped_cog}). Wood types of other
     * mods keep their namespace. The namespaced form is the 1.21.1 NeoForge
     * name, understood here as well.
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
        return name.equals(WARPED) || name.equals(CRIMSON);
    }
}
