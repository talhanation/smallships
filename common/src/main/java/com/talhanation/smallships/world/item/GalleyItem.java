package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class GalleyItem extends ShipItem {
    public GalleyItem(Boat.Type type, Properties properties) {
        super(type, GalleyEntity::summon, properties);
    }
}
