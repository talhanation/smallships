package com.talhanation.smallships.config.neoforge;

import com.talhanation.smallships.config.SmallShipsConfig;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.minecraftforge.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public static void registerConfigs(String modId, SmallShipsConfig.ModConfigWrapper.Type type, IConfigSpec<?> spec) {
        ForgeConfigRegistry.INSTANCE.register(modId, ModConfig.Type.valueOf(type.toString()), spec);
    }
}
