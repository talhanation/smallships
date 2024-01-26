package com.talhanation.smallships.world.entity.ship.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public interface IceBreakable extends Ability{

    default void tickIceBreakable(){
        if(this.self().tickCount % 15 == 0){
            Level level = this.self().getCommandSenderWorld();
            AABB boundingBox = self().getBoundingBox().inflate(1.5);
            double offset = 0.75D;
            BlockPos start = new BlockPos(boundingBox.minX - offset, boundingBox.minY - offset, boundingBox.minZ - offset);
            BlockPos end = new BlockPos(boundingBox.maxX + offset, boundingBox.maxY + offset, boundingBox.maxZ + offset);
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
            boolean hasBroken = false;
            for (int i = start.getX(); i <= end.getX(); ++i) {
                for (int j = start.getY(); j <= end.getY(); ++j) {
                    for (int k = start.getZ(); k <= end.getZ(); ++k) {
                        pos.set(i, j, k);
                        BlockState blockstate = level.getBlockState(pos);
                        if (blockstate.getBlock() instanceof IceBlock) {
                            level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
                            hasBroken = true;
                        }
                    }
                }
            }
            if (hasBroken) {
                level.playSound(null, start.getX(), start.getY(), start.getZ(), SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1F, 0.9F + 0.2F * level.getRandom().nextFloat());
            }
        }
    }
}
