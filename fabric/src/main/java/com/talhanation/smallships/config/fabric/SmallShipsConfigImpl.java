package com.talhanation.smallships.config.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

@SuppressWarnings("removal")
public class SmallShipsConfigImpl {
    public SmallShipsConfigImpl() {
        ModConfigEvents.loading(SmallShipsMod.MOD_ID).register(config -> {
            boolean updated = SmallShipsConfig.updateConfig(new SmallShipsConfig.ModConfigWrapper(config.getType().toString(), config.getFullPath(), config.getFileName(), config.getConfigData()));
            if (updated) config.save();
        });
    }

    public static void registerConfigs(String modId, SmallShipsConfig.ModConfigWrapper.Type type, IConfigSpec<?> spec) {
        ForgeConfigRegistry.INSTANCE.register(modId, ModConfig.Type.valueOf(type.toString()), spec);
    }
}
