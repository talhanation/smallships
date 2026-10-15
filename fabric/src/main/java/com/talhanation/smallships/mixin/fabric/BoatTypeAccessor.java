package com.talhanation.smallships.mixin.fabric;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/**
 * The private Boat.Type constructor, for BoatTypeMixin. The first two
 * arguments are the hidden ones every enum constructor has: the constant name
 * and its ordinal.
 */
@Mixin(Boat.Type.class)
public interface BoatTypeAccessor {
    @Invoker("<init>")
    static Boat.Type smallships$create(String constantName, int ordinal, Block planks, String name) {
        throw new AssertionError();
    }
}
