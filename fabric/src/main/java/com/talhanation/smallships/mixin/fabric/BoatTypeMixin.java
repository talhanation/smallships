package com.talhanation.smallships.mixin.fabric;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.talhanation.smallships.world.entity.ship.ModBoatTypes;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fabric side of {@link ModBoatTypes}: adds warped and crimson to Boat.Type.
 * NeoForge does the same without a mixin through its enum extension, Fabric
 * has nothing like it - this is the only way to get a new constant in.
 *
 * Hooks values() instead of the hidden $VALUES array. The first call comes from
 * the enum's own static init, where CODEC and BY_ID are built from values() -
 * so byName / byId know the new woods from the start, and so does everything
 * that runs over values() later (items, renderer, dockyard).
 *
 * The constants are created once and cached, every call hands out a copy like
 * the vanilla values() does.
 */
@Mixin(Boat.Type.class)
public abstract class BoatTypeMixin {
    @Unique private static Boat.Type[] smallships$values;

    @ModifyReturnValue(method = "values", at = @At("RETURN"))
    private static Boat.Type[] smallships$addWoodTypes(Boat.Type[] original) {
        if (smallships$values == null) {
            List<Boat.Type> types = new ArrayList<>(Arrays.asList(original));
            types.add(BoatTypeAccessor.smallships$create(ModBoatTypes.WARPED_CONSTANT, types.size(), Blocks.WARPED_PLANKS, ModBoatTypes.WARPED));
            types.add(BoatTypeAccessor.smallships$create(ModBoatTypes.CRIMSON_CONSTANT, types.size(), Blocks.CRIMSON_PLANKS, ModBoatTypes.CRIMSON));
            smallships$values = types.toArray(new Boat.Type[0]);
        }
        return smallships$values.clone();
    }
}
