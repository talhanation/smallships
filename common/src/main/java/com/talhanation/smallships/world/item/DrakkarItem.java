package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DrakkarItem extends ShipItem {
    public DrakkarItem(Ship.Type type, Properties properties) {
        super(type, ModEntityTypes.DRAKKAR, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return DrakkarEntity.summon(level, x, y, z);
    }
}
