package com.talhanation.smallships.world.item;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public abstract class ShipItem extends BoatItem {
    public ShipItem(Boat.Type type, Properties properties) {
        super(false, type, properties);
    }

    protected abstract Boat getBoat(@NotNull Level level, @NotNull HitResult hitResult);
}
