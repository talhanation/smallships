package com.talhanation.smallships;

import com.talhanation.smallships.config.SmallshipsConfig;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallShipsMod {
    public static final String MOD_ID = "smallships";
    @SuppressWarnings("unused")
    public static final Logger LOGGER = LoggerFactory.getLogger(SmallShipsMod.MOD_ID);

    public static void init() {
        SmallshipsConfig.registerConfigs(MOD_ID, ModConfig.Type.COMMON, SmallshipsConfig.COMMON_SPEC);
        SmallshipsConfig.registerConfigs(MOD_ID, ModConfig.Type.CLIENT, SmallshipsConfig.CLIENT_SPEC);
    }
}
