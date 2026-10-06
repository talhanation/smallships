package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Moors a ship on a lead to the fence post the player right clicks, and casts
 * her off again on the next click. Vanilla only ties Mobs to a post, see
 * Leashable#interactFence.
 */
public class LeashEvents {
    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (Leashable.interactFence(event.getEntity(), event.getLevel(), event.getPos())) {
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }
}
