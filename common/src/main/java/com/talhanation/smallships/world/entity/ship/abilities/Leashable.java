package com.talhanation.smallships.world.entity.ship.abilities;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public interface Leashable extends Ability {
    @Nullable
    Vec3 applyLeashOffset();
    default float getDefaultShipWeight() {
        return (float)self().getBoundingBoxForCulling().getSize();
    }
}
