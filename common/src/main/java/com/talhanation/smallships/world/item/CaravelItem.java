package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CaravelItem extends ShipItem {
    public CaravelItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return CaravelEntity.summon(level, x, y, z);
    }
}
