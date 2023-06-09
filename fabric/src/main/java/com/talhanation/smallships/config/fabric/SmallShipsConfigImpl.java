package com.talhanation.smallships.config.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public SmallShipsConfigImpl() {
        ModConfigEvents.loading(SmallShipsMod.MOD_ID).register(SmallShipsConfig::updateConfig);
    }

    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        ForgeConfigRegistry.INSTANCE.register(modId, type, spec);
    }
}
