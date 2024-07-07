package com.talhanation.smallships.mixin.leashing;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(LeadItem.class)
public class LeadItemMixin {
    @Unique
    private static boolean smallships$success;

    @SuppressWarnings("ConstantValue")
    @Inject(method = "bindPlayerMobs", at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void bindPlayerMobsLeashShip(Player player, Level level, BlockPos blockPos, CallbackInfoReturnable<InteractionResult> cir, LeashFenceKnotEntity leashFenceKnotEntity, double d, int i, int j, int k, AABB aabb) {
        smallships$success = false;
        List<Boat> list = level.getEntitiesOfClass(Boat.class, aabb, boat -> ((BoatLeashAccess)boat).smallships$getLeashHolder() == player && (boat instanceof Leashable || boat.getClass().equals(Boat.class) || boat.getClass().equals(ChestBoat.class)));
        for (Boat boat : list) {
            if (leashFenceKnotEntity == null) {
                leashFenceKnotEntity = LeashFenceKnotEntity.getOrCreateKnot(level, blockPos);
                leashFenceKnotEntity.playPlacementSound();
            }

            ((BoatLeashAccess)boat).smallships$setLeashedTo(leashFenceKnotEntity, true);
        }

        smallships$success = !list.isEmpty();
    }

    @WrapOperation(method = "bindPlayerMobs", at = @At(value = "INVOKE", target = "Ljava/util/List;isEmpty()Z"))
    private static boolean bindPlayerMobsShipSuccess(List<Mob> instance, Operation<Boolean> original) {
        return original.call(instance) || smallships$success;
    }
}
