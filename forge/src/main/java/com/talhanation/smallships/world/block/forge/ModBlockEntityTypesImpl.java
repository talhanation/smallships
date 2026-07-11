package com.talhanation.smallships.world.block.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.DockyardBlock;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModBlockEntityTypesImpl {
    private static final Map<String, RegistryObject<BlockEntityType<?>>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntityType(String id) {
        return (BlockEntityType<T>) entries.get(id).get();
    }

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SmallShipsMod.MOD_ID);

    static {
        entries.put(DockyardBlock.ID, BLOCK_ENTITY_TYPES.register(DockyardBlock.ID,
                () -> BlockEntityType.Builder.of(DockyardBlockEntity::new, ModBlocks.DOCKYARD).build(null)));
    }
}
