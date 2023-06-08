package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GalleyItem extends ShipItem {
    public GalleyItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public Boat getBoat(@NotNull Level level, double x, double y, double z) {
        return GalleyEntity.summon(level, x, y, z);
    }
}
