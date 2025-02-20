package com.talhanation.smallships.world.block;

import dev.architectury.injectables.annotations.ExpectPlatform;

import net.minecraft.world.level.block.Block;

public class ModBlocks {

    public static final Block DOCKYARD = getBlock("dockyard");

    @ExpectPlatform
    public static Block getBlock(String id) {
        throw new AssertionError();
    }

}
