package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.BriggEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BriggItem extends ShipItem {
    public BriggItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public Boat getBoat(@NotNull Level level, double x, double y, double z) {
        return BriggEntity.summon(level, x, y, z);
    }
}
