package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class DrakkarItem extends ShipItem {
    public DrakkarItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public Boat getBoat(@NotNull Level level, double x, double y, double z) {
        return DrakkarEntity.summon(level, x, y, z);

    }
}
