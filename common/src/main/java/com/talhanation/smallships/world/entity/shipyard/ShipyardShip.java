package com.talhanation.smallships.world.entity.shipyard;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ShipyardShip extends BlockEntity {

    public ShipyardShip(BlockPos blockPos, BlockState blockState) {
        super(ModEntityTypes.SHIPYARD_SHIP, blockPos, blockState);
    }
}
