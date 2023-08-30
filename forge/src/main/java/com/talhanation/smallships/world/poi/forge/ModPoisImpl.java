package com.talhanation.smallships.world.poi.forge;

import com.google.common.collect.ImmutableSet;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.forge.ModBlocksImpl;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModPoisImpl {
    public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(ForgeRegistries.POI_TYPES, SmallShipsMod.MOD_ID);

    public static final RegistryObject<PoiType> POI_SHIPWRIGHT = makePoi("shipwright", ModBlocksImpl.SHIPYARD_BLOCK);

    private static RegistryObject<PoiType> makePoi(String name, RegistryObject<Block> block) {
        return POIS.register(name, () -> {
            Set<BlockState> blockStates = ImmutableSet.copyOf(block.get().getStateDefinition().getPossibleStates());
            return new PoiType(blockStates, 1, 1);
        });
    }
}
