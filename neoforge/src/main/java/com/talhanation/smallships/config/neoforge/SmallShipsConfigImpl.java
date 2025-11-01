package com.talhanation.smallships.config.neoforge;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.neoforge.SmallshipsModNeoForge;
import fuzs.forgeconfigapiport.neoforge.impl.forge.ForgeConfigSpecAdapter;
import net.neoforged.fml.config.ModConfig;

@SuppressWarnings("unused")
public class SmallShipsConfigImpl {
    @SuppressWarnings("UnstableApiUsage")
    public static void registerConfigs(String ignoredModId, SmallShipsConfig.ModConfigWrapper.Type type, net.minecraftforge.fml.config.IConfigSpec<?> spec) {
        SmallshipsModNeoForge.modContainer.registerConfig(ModConfig.Type.valueOf(type.toString()), new ForgeConfigSpecAdapter(spec));
    }
}
