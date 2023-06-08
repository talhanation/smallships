package com.talhanation.smallships;

import com.talhanation.smallships.config.SmallShipsConfig;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallShipsMod {
    public static final String MOD_ID = "smallships";
    public static final Logger LOGGER = LoggerFactory.getLogger(SmallShipsMod.MOD_ID);

    public SmallShipsMod() {
        SmallShipsConfig.registerConfigs(MOD_ID, ModConfig.Type.COMMON, SmallShipsConfig.COMMON_SPEC);
        SmallShipsConfig.registerConfigs(MOD_ID, ModConfig.Type.CLIENT, SmallShipsConfig.CLIENT_SPEC);
    }
}
