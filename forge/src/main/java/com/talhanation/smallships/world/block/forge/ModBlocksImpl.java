package com.talhanation.smallships.world.block.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.DockyardBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocksImpl {
    private static final Map<String, RegistryObject<Block>> entries = new HashMap<>();

    public static Block getBlock(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SmallShipsMod.MOD_ID);

    static {
        register(DockyardBlock.ID, () -> new DockyardBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(2.5F)
                .sound(SoundType.WOOD)));
    }

    private static void register(String id, Supplier<Block> blockSupplier) {
        entries.put(id, BLOCKS.register(id, blockSupplier));
    }
}
