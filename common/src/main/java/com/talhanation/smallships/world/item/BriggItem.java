package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.BriggEntity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class BriggItem extends ShipItem {
    public BriggItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public @NotNull Boat getBoat(@NotNull Level level, @NotNull HitResult hitResult) {
        return BriggEntity.summon(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
    }
}
