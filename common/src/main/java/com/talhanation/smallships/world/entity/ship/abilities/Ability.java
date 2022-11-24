package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;

public interface Ability {
    default Ship self() {
        return (Ship) this;
    }
}
