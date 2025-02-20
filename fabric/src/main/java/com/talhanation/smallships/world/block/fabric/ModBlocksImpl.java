package com.talhanation.smallships.world.block.fabric;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ModBlocksImpl {
    private static final Map<String, Block> entries = new HashMap<>();

    public static Block getBlock(String id) {
        return entries.get(id);
    }

    static {
        //register("sail", new SailItem((new Item.Properties()).stacksTo(16)));

    }

    private static void register(String id, Block block) {
        entries.put(id, register(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id), block));
    }

    private static Block register(ResourceLocation id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
}
