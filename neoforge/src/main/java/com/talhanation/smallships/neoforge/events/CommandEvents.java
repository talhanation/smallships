package com.talhanation.smallships.neoforge.events;

import com.talhanation.smallships.commands.SmallshipsCommand;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public class CommandEvents {

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        SmallshipsCommand.register(event.getDispatcher());
    }
}