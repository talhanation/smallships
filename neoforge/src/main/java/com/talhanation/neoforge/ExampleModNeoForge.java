package com.talhanation.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import net.neoforged.fml.common.Mod;

import com.talhanation.ExampleMod;

@Mod(SmallShipsMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
