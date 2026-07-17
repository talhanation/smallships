package com.talhanation.smallships.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.fabric.SmallShipsConfigImpl;
import com.talhanation.smallships.fabric.events.PassengerEvents;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.fabric.ModPacketsImpl;
import com.talhanation.smallships.world.block.ModBlockEntityTypes;
import com.talhanation.smallships.world.block.ModBlocks;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.commands.SmallshipsCommand;
import com.talhanation.smallships.world.wind.WindManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerLevel;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class SmallshipsModFabric implements ModInitializer {
    @SuppressWarnings("InstantiationOfUtilityClass")
    @Override
    public void onInitialize() {
        new SmallShipsConfigImpl();
        new SmallShipsMod();
        new ModBlocks();
        new ModBlockEntityTypes();
        new ModEntityTypes();
        new ModMenuTypes();
        new ModItems();
        new ModSoundTypes();
        new ModParticleTypes();

        ModPackets.registerPackets();
        ModPacketsImpl.registerServerReceivers();

        UseEntityCallback.EVENT.register(new PassengerEvents());

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> SmallshipsCommand.register(dispatcher));

        // wind system: tick per server level, sync to joining players
        ServerTickEvents.END_WORLD_TICK.register(level -> WindManager.get(level).tick(level));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            if (handler.getPlayer().level() instanceof ServerLevel serverLevel) {
                WindManager.get(serverLevel).sync(handler.getPlayer());
            }
        });
    }
}
