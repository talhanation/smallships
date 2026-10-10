package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class CogItem extends ShipItem {
    public CogItem(Boat.Type type, Properties properties) {
        super(type, CogEntity::summon, properties);
    }
}
