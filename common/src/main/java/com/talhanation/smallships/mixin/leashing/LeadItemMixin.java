package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(LeadItem.class)
public class LeadItemMixin {
    private static boolean success;

    @SuppressWarnings({"InvalidInjectorMethodSignature", "ConstantValue"})
    @Inject(method = "bindPlayerMobs", at = @At(value = "TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void bindPlayerMobsLeashShip(Player player, Level level, BlockPos blockPos, CallbackInfoReturnable<InteractionResult> cir, LeashFenceKnotEntity leashFenceKnotEntity) {
        success = false;
        List<Boat> list = level.getEntitiesOfClass(Boat.class, new AABB((double)blockPos.getX() - 7.0, (double) blockPos.getY() - 7.0, (double) blockPos.getZ() - 7.0, (double)blockPos.getX() + 7.0, (double)blockPos.getY() + 7.0, (double) blockPos.getZ() + 7.0));
        for (Boat boat : list) {
            if (((BoatLeashAccess)boat).getLeashHolder() != player || !(boat instanceof Leashable || boat.getClass().equals(Boat.class)))  continue;
            if (leashFenceKnotEntity == null) {
                leashFenceKnotEntity = LeashFenceKnotEntity.getOrCreateKnot(level, blockPos);
                leashFenceKnotEntity.playPlacementSound();
            }

            ((BoatLeashAccess)boat).setLeashedTo(leashFenceKnotEntity, true);
            success = true;
        }
    }

    @ModifyVariable(method = "bindPlayerMobs", at = @At(value = "LOAD"))
    private static boolean bindPlayerMobsShipSuccess(boolean bl) {
        return bl || success;
    }
}
