package com.talhanation.smallships.world.block.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.ShipyardBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModBlocksImpl {
    private static final Map<Class<? extends Block>, RegistryObject<Block>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Block> Block getBlock(Class<T> blockClass) {
        return entries.get(blockClass).get();
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SmallShipsMod.MOD_ID);

    public static final RegistryObject<Block> SHIPYARD_BLOCK = BLOCKS.register("shipyard_block",
            () -> new ShipyardBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion()));

    static {
        entries.put(ShipyardBlock.class, SHIPYARD_BLOCK);
    }
}
