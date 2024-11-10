package com.talhanation.smallships.world.entity;

import net.minecraft.world.entity.Entity;

public interface IMixinEntity {
    float getPrevXRot();
    float getPrevYRot();

    /**
     * execute {@link Entity#stopRiding()} without the teleport stuff, just removePassenger and set vehicle to null.
     */
    void simpleStopRiding();

    /**
     * execute removePassenger of Entity without executing game events, just modifying the list.
     * @param entity
     */
    void simpleRemovePassenger(Entity entity);
}
