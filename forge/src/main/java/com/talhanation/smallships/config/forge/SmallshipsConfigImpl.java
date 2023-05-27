package com.talhanation.smallships.config.forge;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallshipsConfigImpl {
    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.get().registerConfig(type, spec);
    }
}
