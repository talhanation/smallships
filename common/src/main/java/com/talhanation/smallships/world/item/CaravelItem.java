package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.CaravelEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class CaravelItem extends ShipItem {
    public CaravelItem(Boat.Type type, Properties properties) {
        super(type, CaravelEntity::summon, properties);
    }
}
