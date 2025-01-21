package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BriggItem extends ShipItem {
    public BriggItem(Ship.Type type, Properties properties) {
        super(type, ModEntityTypes.BRIGG, properties);
    }

    @Override
    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return BriggEntity.summon(level, x, y, z);
    }
}
