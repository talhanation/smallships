package com.talhanation.smallships.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.fabric.SmallShipsConfigImpl;
import com.talhanation.smallships.fabric.dockyard.DockyardRecipeManagerFabric;
import com.talhanation.smallships.fabric.events.PassengerEvents;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.fabric.ModPacketsImpl;
import com.talhanation.smallships.world.block.ModBlockEntityTypes;
import com.talhanation.smallships.world.block.ModBlocks;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.ModShipTypes;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import com.talhanation.smallships.commands.SmallshipsCommand;
import com.talhanation.smallships.update.UpdateChecker;
import com.talhanation.smallships.world.wind.WindManager;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.level.ServerLevel;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.server.packs.PackType;

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
        ModShipTypes.init();

        ModPackets.registerPackets();
        ModPacketsImpl.registerServerReceivers();

        UseEntityCallback.EVENT.register(new PassengerEvents());

        // mooring: a ship on a lead is tied to the fence post the player right
        // clicks and cast off again on the next click, vanilla only does that for mobs
        UseBlockCallback.EVENT.register((player, level, hand, hitResult) ->
                Leashable.interactFence(player, level, hitResult.getBlockPos()) ? InteractionResult.SUCCESS : InteractionResult.PASS);

        // dockyard recipes come from data packs, one json file per ship
        ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(new DockyardRecipeManagerFabric());

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> SmallshipsCommand.register(dispatcher));

        // wind system: tick per server level, sync to joining players
        ServerTickEvents.END_WORLD_TICK.register(level -> WindManager.get(level).tick(level));
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            if (handler.getPlayer().level() instanceof ServerLevel serverLevel) {
                WindManager.get(serverLevel).sync(handler.getPlayer());
            }
        });

        // update check: the server config is only loaded once the server is up
        ServerLifecycleEvents.SERVER_STARTED.register(server -> UpdateChecker.onServerStarted());
    }
}