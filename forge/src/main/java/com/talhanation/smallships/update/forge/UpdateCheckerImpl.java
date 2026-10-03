package com.talhanation.smallships.update.forge;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraftforge.fml.ModList;

public class UpdateCheckerImpl {
    public static String getModVersion() {
        return ModList.get().getModContainerById(SmallShipsMod.MOD_ID)
                .map(container -> container.getModInfo().getVersion().toString())
                .orElse("0");
    }
}
