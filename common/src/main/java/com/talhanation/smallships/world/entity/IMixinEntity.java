package com.talhanation.smallships.world.entity;

import net.minecraft.world.entity.Entity;

public interface IMixinEntity {
    float getPrevXRot();
    float getPrevYRot();
    /**
     * @return true if on the next syncing of passenger changes this entity should not be teleported
     *
     */
    boolean doNotTeleportOnNextPassengerSync();
    void setPreventTeleportOnNextPassengerSync(boolean prevent);
    boolean doNotDismountToCoordinates();
    void setPreventDismountToCoordinates(boolean prevent);
}
