package com.talhanation.smallships.update.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import net.neoforged.fml.ModList;

public class UpdateCheckerImpl {
    public static String getModVersion() {
        return ModList.get().getModContainerById(SmallShipsMod.MOD_ID)
                .map(container -> container.getModInfo().getVersion().toString())
                .orElse("0");
    }
}