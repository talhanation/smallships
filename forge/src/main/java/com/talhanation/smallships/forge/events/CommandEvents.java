package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.commands.SmallshipsCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommandEvents {

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        SmallshipsCommand.register(event.getDispatcher());
    }
}
