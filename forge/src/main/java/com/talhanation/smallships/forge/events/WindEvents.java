package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.world.wind.WindManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Server side hooks for the wind system on Forge:
 * ticks the WindManager per level and syncs the wind state to joining players.
 */
public class WindEvents {

    @SubscribeEvent
    public void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (event.level instanceof ServerLevel serverLevel) {
            WindManager.get(serverLevel).tick(serverLevel);
        }
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer && serverPlayer.level() instanceof ServerLevel serverLevel) {
            WindManager.get(serverLevel).sync(serverPlayer);
        }
    }

    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer && serverPlayer.level() instanceof ServerLevel serverLevel) {
            WindManager.get(serverLevel).sync(serverPlayer);
        }
    }
}
