package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CogItem extends ShipItem {
    public CogItem(Ship.Type type, Properties properties) {
        super(type, ModEntityTypes.COG, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return CogEntity.summon(level, x, y, z);
    }
}
