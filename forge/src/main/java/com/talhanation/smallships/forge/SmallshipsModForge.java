package com.talhanation.smallships.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.forge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.forge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import com.talhanation.smallships.world.sound.forge.ModSoundTypesImpl;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SmallShipsMod.MOD_ID)
public class SmallshipsModForge {
    @SuppressWarnings("InstantiationOfUtilityClass")
    public SmallshipsModForge() {
        new SmallShipsMod();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItemsImpl.ITEMS.register(modEventBus);
        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);
    }
}
