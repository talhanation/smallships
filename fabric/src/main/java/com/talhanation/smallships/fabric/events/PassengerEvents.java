package com.talhanation.smallships.fabric.events;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;


public class PassengerEvents implements UseEntityCallback {

    @Override
    public InteractionResult interact(Player player, Level world, InteractionHand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if(!player.isCrouching() && entity.isPassenger()
                && !(entity instanceof Player)
                && !(entity.getEncodeId() != null && entity.getEncodeId().contains("captain"))
                && entity.getVehicle() != null
                && entity.getVehicle() instanceof Ship){
            entity.stopRiding();
            return InteractionResult.SUCCESS;
        }

        if(player.isPassenger() && player.getVehicle() != null && player.getVehicle() instanceof Ship ship){
            if(ship.canAddPassenger(entity) && !(entity instanceof Player)){
                entity.startRiding(ship);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
