package com.talhanation.smallships.neoforge.client;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.InputEvent;

@SuppressWarnings("ALL")
@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientGameBus {
    @SubscribeEvent
    static void initRegisterInputEvents(InputEvent.Key event) {
        Minecraft client = Minecraft.getInstance();
        com.talhanation.smallships.client.option.KeyEvent.onKeyInput(client);
    }
}
