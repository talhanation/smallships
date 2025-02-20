package com.talhanation.smallships.world.block.forge;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocksImpl {
        private static final Map<String, RegistryObject<Block>> entries = new HashMap<>();

        public static Block getItem(String id) {
            return entries.get(id).get();
        }

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SmallShipsMod.MOD_ID);

        static {
            //register("dockyard", () -> new Dockyard((new Item.Properties()).stacksTo(16)));
        }

        private static void register(String id, Supplier<Block> itemSupplier) {
            entries.put(id, BLOCKS.register(id, itemSupplier));
        }
}
