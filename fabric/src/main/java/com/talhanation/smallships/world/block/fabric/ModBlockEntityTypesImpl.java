package com.talhanation.smallships.world.block.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.DockyardBlock;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashMap;
import java.util.Map;

public class ModBlockEntityTypesImpl {
    private static final Map<String, BlockEntityType<?>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntityType(String id) {
        return (BlockEntityType<T>) entries.get(id);
    }

    static {
        entries.put(DockyardBlock.ID, Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DockyardBlock.ID),
                BlockEntityType.Builder.of(DockyardBlockEntity::new, ModBlocks.DOCKYARD).build(null)));
    }
}
