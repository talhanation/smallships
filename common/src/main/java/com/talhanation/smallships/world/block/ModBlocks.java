package com.talhanation.smallships.world.block;


import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static final Block SHIPYARD_BLOCK = getBlock(ShipyardBlock.class);

    @ExpectPlatform
    public static <T extends Block> Block getBlock(Class<T> block) {
        throw new AssertionError();
    }
}
