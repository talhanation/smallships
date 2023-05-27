package com.talhanation.smallships.forge.client;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeBus {
    public ClientForgeBus() {
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.addListener(this::initRegisterInputEvents);
    }

    @SubscribeEvent
    public void initRegisterInputEvents(InputEvent.KeyInputEvent event) {
        Minecraft client = Minecraft.getInstance();
        com.talhanation.smallships.client.option.KeyEvent.onKeyInput(client);
    }
}
