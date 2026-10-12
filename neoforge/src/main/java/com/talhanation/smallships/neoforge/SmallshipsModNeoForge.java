package com.talhanation.smallships.neoforge;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.neoforge.events.CommandEvents;
import com.talhanation.smallships.neoforge.events.DataPackEvents;
import com.talhanation.smallships.neoforge.events.PassengerEvents;
import com.talhanation.smallships.neoforge.events.UpdateEvents;
import com.talhanation.smallships.neoforge.events.WindEvents;
import com.talhanation.smallships.world.block.neoforge.ModBlockEntityTypesImpl;
import com.talhanation.smallships.world.block.neoforge.ModBlocksImpl;
import com.talhanation.smallships.world.entity.neoforge.ModEntityTypesImpl;
import com.talhanation.smallships.world.inventory.neoforge.ModMenuTypesImpl;
import com.talhanation.smallships.world.item.ModShipItems;
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
    public static final boolean hasCustomItemGroup = TomlFormat.instance().createParser().parse(Path.of("config", "smallships-client.toml"), (file, configFormat) -> false).getOrElse(Arrays.asList("General", "smallshipsItemGroupEnable"), () -> true); //Forge doesn't do early config initialization. Will have to parse the config ourselves. The fallback has to match the default in SmallShipsConfig: on the very first start the file does not exist yet, and an older file does not hold the key.

    @SuppressWarnings("InstantiationOfUtilityClass")
    public SmallshipsModNeoForge(IEventBus modEventBus) {
        new SmallShipsMod();

        ModItemsImpl.ITEMS.register(modEventBus);
        if (hasCustomItemGroup) ModItemsImpl.CREATIVE_MODE_TABS.register(modEventBus);
        ModBlocksImpl.BLOCKS.register(modEventBus);
        ModBlockEntityTypesImpl.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModEntityTypesImpl.ENTITY_TYPES.register(modEventBus);
        ModMenuTypesImpl.MENU_TYPES.register(modEventBus);
        ModSoundTypesImpl.SOUND_EVENTS.register(modEventBus);
        ModParticleTypesImpl.PARTICLE_TYPES.register(modEventBus);
        // the ship items, through the same api the addons use - it has to be
        // called from here, the constructor, see ShipItems
        ModShipItems.register();

        NeoForge.EVENT_BUS.register(new PassengerEvents());
        NeoForge.EVENT_BUS.register(new DataPackEvents());
        NeoForge.EVENT_BUS.register(new WindEvents());
        NeoForge.EVENT_BUS.register(new CommandEvents());
        NeoForge.EVENT_BUS.register(new UpdateEvents());
    }
}