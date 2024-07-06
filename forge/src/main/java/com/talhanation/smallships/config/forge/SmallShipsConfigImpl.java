package com.talhanation.smallships.config.forge;

import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public static void registerConfigs(String modId, SmallShipsConfig.ModConfigWrapper.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.valueOf(type.toString()), spec);
    }
}
