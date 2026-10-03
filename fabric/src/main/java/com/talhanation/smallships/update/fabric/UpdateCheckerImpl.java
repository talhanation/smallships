package com.talhanation.smallships.update.fabric;

import com.talhanation.smallships.SmallShipsMod;
import net.fabricmc.loader.api.FabricLoader;

public class UpdateCheckerImpl {
    public static String getModVersion() {
        return FabricLoader.getInstance().getModContainer(SmallShipsMod.MOD_ID)
                .map(container -> container.getMetadata().getVersion().getFriendlyString())
                .orElse("0");
    }
}
