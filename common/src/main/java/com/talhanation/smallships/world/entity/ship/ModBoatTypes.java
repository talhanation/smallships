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
 * Both use the same names below. NeoForge demands the mod id as namespace for
 * an added constant, so the names carry it on Fabric too - otherwise the same
 * ship would be saved differently depending on the loader.
 */
public class ModBoatTypes {
    public static final String WARPED = SmallShipsMod.MOD_ID + ":warped";
    public static final String CRIMSON = SmallShipsMod.MOD_ID + ":crimson";

    /** the enum constant names, NeoForge wants the mod id as prefix here as well */
    public static final String WARPED_CONSTANT = "SMALLSHIPS_WARPED";
    public static final String CRIMSON_CONSTANT = "SMALLSHIPS_CRIMSON";

    /**
     * @return the name of a wood type for item ids and texture paths. Our own
     * namespace is dropped, so the added woods read like the vanilla ones
     * ({@code smallships:warped} -> {@code warped_cog}). Wood types of other
     * mods keep their namespace.
     */
    public static String getWoodName(Boat.Type type) {
        String name = type.getName();
        String own = SmallShipsMod.MOD_ID + ":";
        return name.startsWith(own) ? name.substring(own.length()) : name;
    }
}
