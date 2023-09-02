package com.talhanation.smallships.world.entity.ai;

import com.talhanation.smallships.world.block.ModBlocks;
import com.talhanation.smallships.world.block.ShipyardBlock;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.behavior.WorkAtPoi;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class WorkAtShipwrightTable extends WorkAtPoi {
    public WorkAtShipwrightTable() {
    }

    protected void useWorkstation(ServerLevel serverLevel, Villager arg2) {
        Optional<GlobalPos> optional = arg2.getBrain().getMemory(MemoryModuleType.JOB_SITE);
        if (optional.isPresent()) {
            GlobalPos globalPos = optional.get();
            BlockState blockState = serverLevel.getBlockState(globalPos.pos());

            if (blockState.is(ModBlocks.SHIPYARD_BLOCK)) {
                ShipyardBlock.incrementProgress(blockState, serverLevel, globalPos.pos());
            }
        }
    }
}
