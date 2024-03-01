package com.talhanation.smallships.forge.events;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PassengerEvents {

    @SubscribeEvent
    public void onPlayerInteractWithPassenger(PlayerInteractEvent.EntityInteract event){
        Player player = event.getPlayer();
        Entity entity = event.getTarget();

        if(!player.isCrouching() && entity.isPassenger() && entity.getVehicle() != null && entity.getVehicle() instanceof Ship){
            entity.stopRiding();
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }

        if(player.isPassenger() && player.getVehicle() != null && player.getVehicle() instanceof Ship ship){
            if(ship.canAddPassenger(entity)){
                entity.startRiding(ship);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}
