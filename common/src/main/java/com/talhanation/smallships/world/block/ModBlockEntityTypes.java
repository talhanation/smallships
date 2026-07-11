package com.talhanation.smallships.world.block;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {

    public static final BlockEntityType<DockyardBlockEntity> DOCKYARD = getBlockEntityType(DockyardBlock.ID);

    @SuppressWarnings("unchecked")
    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntityType(String id) {
        throw new AssertionError();
    }
}
