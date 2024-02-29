package com.talhanation.smallships.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.fabric.SmallShipsConfigImpl;
import com.talhanation.smallships.fabric.events.PassengerEvents;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class SmallshipsModFabric implements ModInitializer {
    @SuppressWarnings("InstantiationOfUtilityClass")
    @Override
    public void onInitialize() {
        new SmallShipsConfigImpl();
        new SmallShipsMod();
        new ModEntityTypes();
        new ModMenuTypes();
        new ModItems();
        new ModSoundTypes();

        ModPackets.registerPackets();

        UseEntityCallback.EVENT.register(new PassengerEvents());
    }
}
