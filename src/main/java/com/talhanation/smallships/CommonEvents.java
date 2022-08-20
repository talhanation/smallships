package com.talhanation.smallships;

import com.talhanation.smallships.entities.AbstractWaterVehicle;;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.living.EntityTeleportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class CommonEvents {

    @SubscribeEvent
    public static void onDriverTeleport(EntityTeleportEvent event) {
        Entity entity = event.getEntity();
        Main.LOGGER.debug("Event Triggered");
        if(entity.getVehicle() instanceof AbstractWaterVehicle){
            AbstractWaterVehicle vehicle = (AbstractWaterVehicle) entity.getVehicle();

            vehicle.setPos(event.getTargetX(), event.getTargetY(), event.getTargetZ());

            List<Entity> passengers = vehicle.getPassengers();
            for(Entity passenger : passengers){
                passenger.setPos(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                passenger.startRiding(vehicle);
            }
            entity.setPos(event.getTargetX(), event.getTargetY(), event.getTargetZ());
            entity.startRiding(vehicle);
        }

    }


}
