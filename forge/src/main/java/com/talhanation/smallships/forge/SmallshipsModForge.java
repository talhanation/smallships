package com.talhanation.smallships.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.event.forge.VillagerEvents;
import com.talhanation.smallships.forge.client.ClientInitializer;
import com.talhanation.smallships.forge.common.CommonModBus;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.forge.ModBlocksImpl;
import com.talhanation.smallships.world.entity.forge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.forge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import com.talhanation.smallships.world.poi.forge.ModPoisImpl;
import com.talhanation.smallships.world.poi.forge.ModProfessionsImpl;
import com.talhanation.smallships.world.sound.forge.ModSoundTypesImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SmallShipsMod.MOD_ID)
public class SmallshipsModForge {
    @SuppressWarnings("InstantiationOfUtilityClass")
    public SmallshipsModForge() {
        new CommonModBus();
        new SmallShipsMod();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        ModPoisImpl.POIS.register(modEventBus);
        ModBlocksImpl.BLOCKS.register(modEventBus);
        ModProfessionsImpl.PROFESSIONS.register(modEventBus);
        ModItemsImpl.ITEMS.register(modEventBus);

        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModEntityTypesImpl.BLOCK_ENTITIES.register(modEventBus);

        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientInitializer::new);
    }

    private void setup(@SuppressWarnings("unused") FMLCommonSetupEvent event) {
        ModPackets.registerPackets();
        MinecraftForge.EVENT_BUS.register(new VillagerEvents());
    }
}
