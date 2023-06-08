package com.talhanation.smallships.config.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public SmallShipsConfigImpl() {
        ModConfigEvents.loading(SmallShipsMod.MOD_ID).register(SmallShipsConfig::updateConfig);
    }

    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.registerConfig(modId, type, spec);
    }
}
