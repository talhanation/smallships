package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public abstract class ShipItem extends BoatItem {
    public ShipItem(Boat.Type type, Properties properties) {
        super(false, type, properties);
    }

    protected abstract @NotNull Ship getShip(@NotNull Level level, double x, double y, double z);

    protected @NotNull Boat getBoat(@NotNull Level level, @NotNull HitResult hitResult, ItemStack stack, Player player) {
        Ship ship = this.getShip(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
        if (level instanceof ServerLevel serverLevel) {
            EntityType.<Ship>createDefaultStackConfig(serverLevel, stack, player).accept(ship);
        }
        return ship;
    }
}
