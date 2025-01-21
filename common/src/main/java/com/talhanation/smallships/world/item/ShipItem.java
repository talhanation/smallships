package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public abstract class ShipItem extends BoatItem {
    private final Ship.Type type;

    public ShipItem(Ship.Type type, EntityType<? extends Ship> entityType, Properties properties) {
        super(entityType, properties);
        this.type = type;
    }

    protected abstract @NotNull Ship getShip(@NotNull Level level, double x, double y, double z);

    protected @NotNull AbstractBoat getBoat(@NotNull Level level, @NotNull HitResult hitResult, ItemStack stack, Player player) {
        Ship ship = this.getShip(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
        ship.setVariant(type);
        if (level instanceof ServerLevel serverLevel) {
            EntityType.<Ship>createDefaultStackConfig(serverLevel, stack, player).accept(ship);
        }
        return ship;
    }
}
