package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GalleyItem extends ShipItem {
    public GalleyItem(Ship.Type type, Properties properties) {
        super(type, ModEntityTypes.GALLEY, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return GalleyEntity.summon(level, x, y, z);
    }
}
