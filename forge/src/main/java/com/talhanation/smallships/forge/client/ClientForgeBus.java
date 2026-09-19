package com.talhanation.smallships.forge.client;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.client.cannon.CannonAmmoHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeBus {
    @SubscribeEvent
    static void initRegisterInputEvents(InputEvent.Key event) {
        Minecraft client = Minecraft.getInstance();
        com.talhanation.smallships.client.option.KeyEvent.onKeyInput(client);
    }

    @SubscribeEvent
    static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        com.talhanation.smallships.client.ClientTickHandler.onClientTick(Minecraft.getInstance());
    }

    @SubscribeEvent
    static void onRenderGui(RenderGuiEvent.Post event) {
        CannonAmmoHandler.render(event.getGuiGraphics());
    }
}
