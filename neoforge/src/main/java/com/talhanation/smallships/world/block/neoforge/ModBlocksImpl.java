package com.talhanation.smallships.world.block.neoforge;


import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.DockyardBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class ModBlocksImpl {
    private static final Map<String, Supplier<Block>> entries = new HashMap<>();

    public static Block getBlock(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SmallShipsMod.MOD_ID);

    static {
        register(DockyardBlock.ID, () -> new DockyardBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(3.5F)
                .sound(SoundType.WOOD)
                .noOcclusion()));
    }

    private static void register(String id, Supplier<Block> blockSupplier) {
        entries.put(id, BLOCKS.register(id, blockSupplier));
    }
}