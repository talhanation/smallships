package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.GalleonEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class GalleonItem extends ShipItem {
    public GalleonItem(Boat.Type type, Properties properties) {
        super(type, GalleonEntity::summon, properties);
    }
}
