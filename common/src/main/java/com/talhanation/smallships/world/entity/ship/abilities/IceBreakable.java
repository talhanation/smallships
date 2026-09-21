package com.talhanation.smallships.world.entity.ship.abilities;

import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A hull that sails through ice instead of stopping at it.
 *
 * The breaking itself lives in Ship#tickBreakThrough, together with the lily
 * pads: both have to be cleared along the hull parts, not around the ships'
 * own small box, and scanning the same volume twice per tick buys nothing.
 */
public interface IceBreakable extends Ability{

    /**
     * @return true for the ice an ice breaker goes through. Plain and frosted
     * ice only - packed and blue ice stay solid for every ship.
     */
    static boolean isBreakableIce(BlockState blockState) {
        return blockState.getBlock() instanceof IceBlock;
    }
}