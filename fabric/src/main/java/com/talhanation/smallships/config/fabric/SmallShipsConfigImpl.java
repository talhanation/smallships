package com.talhanation.smallships.config.fabric;

import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.registerConfig(modId, type, spec);
    }
}
