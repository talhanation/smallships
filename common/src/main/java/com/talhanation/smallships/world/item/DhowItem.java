package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DhowEntity;
import net.minecraft.world.entity.vehicle.Boat;

public class DhowItem extends ShipItem {
    public DhowItem(Boat.Type type, Properties properties) {
        super(type, DhowEntity::summon, properties);
    }
}
