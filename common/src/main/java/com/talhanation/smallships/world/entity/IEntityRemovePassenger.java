package com.talhanation.smallships.world.entity;

import net.minecraft.world.entity.Entity;

/**
 * Interface to allow overriding the {@link com.talhanation.smallships.mixin.entity.EntityMixin#simpleRemovePassenger(Entity)}
 * behavior.
 */
public interface IEntityRemovePassenger {
    default void removePassengerWithoutGameEvent(Entity passenger) {
        if (this instanceof IMixinEntity thisMixin) {
            thisMixin.simpleRemovePassenger(passenger);
        }
    }
}
