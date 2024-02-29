package com.talhanation.smallships.forge;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.forge.events.PassengerEvents;
import com.talhanation.smallships.world.entity.forge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.forge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import com.talhanation.smallships.world.sound.forge.ModSoundTypesImpl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.nio.file.Path;
import java.util.Arrays;

@Mod(SmallShipsMod.MOD_ID)
public class SmallshipsModForge {
    public static final boolean hasCustomItemGroup = TomlFormat.instance().createParser().parse(Path.of("config", "smallships-client.toml"), (file, configFormat) -> false).getOrElse(Arrays.asList("General", "smallshipsItemGroupEnable"), () -> false); //Forge doesn't do early config initialization. Will have to parse the config ourselves.

    @SuppressWarnings("InstantiationOfUtilityClass")
    public SmallshipsModForge() {
        new SmallShipsMod();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItemsImpl.ITEMS.register(modEventBus);
        if (hasCustomItemGroup) ModItemsImpl.CREATIVE_MODE_TABS.register(modEventBus);
        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new PassengerEvents());
    }
}
