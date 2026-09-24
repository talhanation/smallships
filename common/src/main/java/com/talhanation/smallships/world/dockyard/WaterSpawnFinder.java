package com.talhanation.smallships.world.dockyard;

import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds a suitable water spot near the dockyard to spawn a built ship.
 *
 * The spot is measured against the HULL of the ship that is about to be
 * launched, not against a fixed square: every block column under a hull part -
 * turned the way the ship will face, away from the dockyard - needs enough
 * water for the keel and 3 blocks of air above. A galleon is fourteen blocks
 * long and draws three blocks of water, a 5x5 surface check let it spawn with
 * the bow in the bank and the keel in the sand.
 *
 * Searches in an outward spiral up to the given radius.
 */
public class WaterSpawnFinder {
    public static final int SEARCH_RADIUS = 24;
    /** fallback for a ship without hull parts: the old fixed 5x5 square */
    private static final int AREA_HALF = 2;
    private static final int AIR_HEIGHT = 3;

    /**
     * The hull of a ship type, read off a throwaway dummy - the same trick the
     * build preview uses. getParts is a static list per ship class, so the
     * dummy is never added to the world and has no business being there.
     * Masts are left out, they stand inside the hull footprint anyway.
     */
    public static List<ShipPartEntity.Definition> getHull(Level level, ShipType shipType) {
        Ship dummy = shipType.summon(level, 0.0D, -100.0D, 0.0D);
        if (dummy == null) return List.of();
        List<ShipPartEntity.Definition> hull = new ArrayList<>();
        for (ShipPartEntity.Definition definition : dummy.getParts()) {
            if (!definition.mast()) hull.add(definition);
        }
        return hull;
    }

    /**
     * @return how many blocks of water the hull needs under it. The keel sits
     * below the waterline by the lowest part offset, plus the surface block the
     * ship floats in: Cog 0 -> 1, Brigg -0.4 -> 2, Galleon -1.5 -> 3. An addon
     * ship gets its depth the moment its parts are defined.
     */
    public static int getRequiredDepth(List<ShipPartEntity.Definition> hull) {
        float keel = 0.0F;
        for (ShipPartEntity.Definition definition : hull) {
            keel = Math.min(keel, definition.y());
        }
        return Mth.ceil(-keel) + 1;
    }

    /**
     * The ship is launched facing away from the dockyard. One formula for the
     * spot check and the spawn, or the check would measure a hull turned
     * differently than the one that is actually put into the water.
     */
    public static float getSpawnYaw(BlockPos origin, BlockPos spot) {
        return (float) Math.toDegrees(Math.atan2(-(spot.getX() - origin.getX()), spot.getZ() - origin.getZ()));
    }

    @Nullable
    public static BlockPos findSpawnSpot(Level level, BlockPos origin, List<ShipPartEntity.Definition> hull, int depth) {
        // scan an expanding square ring around the origin; check several y levels
        for (int r = 1; r <= SEARCH_RADIUS; r++) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (Math.max(Math.abs(dx), Math.abs(dz)) != r) continue; // ring only
                    for (int dy = -4; dy <= 4; dy++) {
                        BlockPos candidate = origin.offset(dx, dy, dz);
                        if (isValidSpawnSpot(level, origin, candidate, hull, depth)) return candidate;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param origin the dockyard, it decides which way the hull faces
     * @param center the water surface block the ship would be centered on
     * @param hull   the hull parts of the ship, see {@link #getHull}
     * @param depth  blocks of water every column under the hull needs
     * @return true if the whole hull fits into the water here
     */
    public static boolean isValidSpawnSpot(Level level, BlockPos origin, BlockPos center, List<ShipPartEntity.Definition> hull, int depth) {
        // cheap early out: most candidates of the spiral are not even water
        if (!isWaterSurface(level, center)) return false;

        // a ship without parts has nothing to measure the spot against
        if (hull.isEmpty()) {
            for (int dx = -AREA_HALF; dx <= AREA_HALF; dx++) {
                for (int dz = -AREA_HALF; dz <= AREA_HALF; dz++) {
                    if (!isWaterColumn(level, center.offset(dx, 0, dz), depth)) return false;
                }
            }
            return true;
        }

        // the exact position and yaw finishBuildShip puts the ship at
        float yaw = getSpawnYaw(origin, center);
        double x = center.getX() + 0.5D;
        double y = center.getY() + 1.0D;
        double z = center.getZ() + 0.5D;
        for (ShipPartEntity.Definition part : hull) {
            AABB box = part.boxAt(x, y, z, yaw);
            // every column the box stands over; an edge lying exactly on a
            // block border does not reach into the next block
            for (int bx = Mth.floor(box.minX); bx <= Mth.floor(box.maxX - 1.0E-4D); bx++) {
                for (int bz = Mth.floor(box.minZ); bz <= Mth.floor(box.maxZ - 1.0E-4D); bz++) {
                    if (!isWaterColumn(level, new BlockPos(bx, center.getY(), bz), depth)) return false;
                }
            }
        }
        return true;
    }

    /**
     * @return true if {@code depth} blocks of water go down from the surface
     * block and {@link #AIR_HEIGHT} blocks of air sit above it
     */
    private static boolean isWaterColumn(Level level, BlockPos surface, int depth) {
        if (!isWaterSurface(level, surface)) return false;
        for (int dy = 1; dy < depth; dy++) {
            if (!level.getFluidState(surface.below(dy)).getType().isSame(Fluids.WATER)) return false;
        }
        for (int dy = 1; dy <= AIR_HEIGHT; dy++) {
            if (!level.getBlockState(surface.above(dy)).isAir()) return false;
        }
        return true;
    }

    private static boolean isWaterSurface(Level level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        return fluidState.getType().isSame(Fluids.WATER) && level.getBlockState(pos.above()).isAir();
    }
}
