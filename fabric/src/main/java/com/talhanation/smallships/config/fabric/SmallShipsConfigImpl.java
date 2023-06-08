package com.talhanation.smallships.config.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.api.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class SmallShipsConfigImpl {
    public SmallShipsConfigImpl() {
        ModConfigEvent.LOADING.register((ModConfig config) -> {
            if (config.getModId().equals(SmallShipsMod.MOD_ID)) {
                SmallShipsConfig.updateConfig(config);
            }
        });
    }

    public static void registerConfigs(String modId, ModConfig.Type type, IConfigSpec<?> spec) {
        ModLoadingContext.registerConfig(modId, type, spec);
    }
}
