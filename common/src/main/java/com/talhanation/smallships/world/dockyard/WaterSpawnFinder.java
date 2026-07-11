package com.talhanation.smallships.world.dockyard;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

/**
 * Finds a suitable water spot near the dockyard to spawn a built ship:
 * a spot needs a 5x5 area of water surface with 3 blocks of air above.
 * Searches in an outward spiral up to the given radius.
 */
public class WaterSpawnFinder {
    public static final int SEARCH_RADIUS = 24;
    private static final int AREA_HALF = 2; // 5x5
    private static final int AIR_HEIGHT = 3;

    @Nullable
    public static BlockPos findSpawnSpot(Level level, BlockPos origin) {
        // scan an expanding square ring around the origin; check several y levels
        for (int r = 1; r <= SEARCH_RADIUS; r++) {
            for (int dx = -r; dx <= r; dx++) {
                for (int dz = -r; dz <= r; dz++) {
                    if (Math.max(Math.abs(dx), Math.abs(dz)) != r) continue; // ring only
                    for (int dy = -4; dy <= 4; dy++) {
                        BlockPos candidate = origin.offset(dx, dy, dz);
                        if (isValidSpawnSpot(level, candidate)) return candidate;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param center the water surface block the ship would be centered on
     * @return true if a 5x5 water surface with 3 blocks of air above exists here
     */
    public static boolean isValidSpawnSpot(Level level, BlockPos center) {
        if (!isWaterSurface(level, center)) return false;
        for (int dx = -AREA_HALF; dx <= AREA_HALF; dx++) {
            for (int dz = -AREA_HALF; dz <= AREA_HALF; dz++) {
                BlockPos pos = center.offset(dx, 0, dz);
                if (!isWaterSurface(level, pos)) return false;
                for (int dy = 1; dy <= AIR_HEIGHT; dy++) {
                    if (!level.getBlockState(pos.above(dy)).isAir()) return false;
                }
            }
        }
        return true;
    }

    private static boolean isWaterSurface(Level level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        return fluidState.getType().isSame(Fluids.WATER) && level.getBlockState(pos.above()).isAir();
    }
}
