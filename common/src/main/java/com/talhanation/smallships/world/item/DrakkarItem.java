package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class DrakkarItem extends ShipItem {
    public DrakkarItem(Boat.Type type, Properties properties) {
        super(type, DrakkarEntity::summon, properties);
    }
}
