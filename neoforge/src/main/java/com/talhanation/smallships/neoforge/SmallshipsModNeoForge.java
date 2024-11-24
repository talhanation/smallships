package com.talhanation.smallships.neoforge;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.neoforge.events.PassengerEvents;
import com.talhanation.smallships.world.entity.neoforge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.neoforge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.neoforge.ModItemsImpl;
import com.talhanation.smallships.world.particles.neoforge.ModParticleTypesImpl;
import com.talhanation.smallships.world.sound.neoforge.ModSoundTypesImpl;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

import java.nio.file.Path;
import java.util.Arrays;

@Mod(SmallShipsMod.MOD_ID)
public class SmallshipsModNeoForge {
    public static final boolean hasCustomItemGroup = TomlFormat.instance().createParser().parse(Path.of("config", "smallships-client.toml"), (file, configFormat) -> false).getOrElse(Arrays.asList("General", "smallshipsItemGroupEnable"), () -> false); //Forge doesn't do early config initialization. Will have to parse the config ourselves.

    @SuppressWarnings("InstantiationOfUtilityClass")
    public SmallshipsModNeoForge(IEventBus modEventBus) {
        new SmallShipsMod();

        ModItemsImpl.ITEMS.register(modEventBus);
        if (hasCustomItemGroup) ModItemsImpl.CREATIVE_MODE_TABS.register(modEventBus);
        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);
        ModParticleTypesImpl.PARTICLE_TYPES.register(modEventBus);

        NeoForge.EVENT_BUS.register(new PassengerEvents());
    }
}
