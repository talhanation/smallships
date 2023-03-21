package com.talhanation.smallships.duck;

import net.minecraft.world.entity.Entity;

public interface BoatLeashAccess {
    boolean isLeashed();
    void dropLeash(boolean shouldUnlink, boolean shouldDropItem);
    void setDelayedLeashHolderId(int i);
    Entity getLeashHolder();
    void setLeashedTo(Entity entity, boolean shouldLink);
}
