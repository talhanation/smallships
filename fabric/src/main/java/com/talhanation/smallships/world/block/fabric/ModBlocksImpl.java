package com.talhanation.smallships.world.block.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.DockyardBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;
import java.util.Map;

public class ModBlocksImpl {
    private static final Map<String, Block> entries = new HashMap<>();

    public static Block getBlock(String id) {
        return entries.get(id);
    }

    static {
        register(DockyardBlock.ID, new DockyardBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(3.5F)
                .sound(SoundType.WOOD)
                .noCollission()
            )
        );
    }

    private static void register(String id, Block block) {
        entries.put(id, register(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id), block));
    }

    private static Block register(ResourceLocation id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
