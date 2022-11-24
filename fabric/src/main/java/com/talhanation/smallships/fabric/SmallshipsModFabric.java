package com.talhanation.smallships.fabric;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.fabricmc.api.ModInitializer;

public class SmallshipsModFabric implements ModInitializer {
    @SuppressWarnings("InstantiationOfUtilityClass")
    @Override
    public void onInitialize() {
        SmallshipsMod.init();
        new ModEntityTypes();
        new ModMenuTypes();
        new ModItems();
        new ModSoundTypes();

        ModPackets.registerPackets();
    }
}
