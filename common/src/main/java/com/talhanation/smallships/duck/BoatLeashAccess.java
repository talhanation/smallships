package com.talhanation.smallships.duck;

import net.minecraft.world.entity.Entity;

public interface BoatLeashAccess {
    boolean smallships$isLeashed();
    void smallships$dropLeash(boolean shouldUnlink, boolean shouldDropItem);
    void smallships$setDelayedLeashHolderId(int i);
    Entity smallships$getLeashHolder();
    void smallships$setLeashedTo(Entity entity, boolean shouldLink);
}
