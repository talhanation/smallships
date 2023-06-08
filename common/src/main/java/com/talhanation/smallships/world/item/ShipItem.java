package com.talhanation.smallships.world.item;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class ShipItem extends BoatItem {
    public ShipItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    public abstract Boat getBoat(@NotNull Level level, double x, double y, double z);
}
