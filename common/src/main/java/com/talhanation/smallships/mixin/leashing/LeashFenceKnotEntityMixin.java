package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.abilities.Leashable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;

@Mixin(LeashFenceKnotEntity.class)
public class LeashFenceKnotEntityMixin {
    private boolean success;

    @SuppressWarnings("DataFlowIssue")
    private LeashFenceKnotEntity self() {
        return (LeashFenceKnotEntity)(Object)this;
    }

    @SuppressWarnings("ConstantValue")
    @Inject(method = "interact", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;", shift = At.Shift.BEFORE))
    private void interactLeashShip(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        this.success = false;
        List<Boat> list = self().getLevel().getEntitiesOfClass(Boat.class, new AABB(self().getX() - 7.0, self().getY() - 7.0, self().getZ() - 7.0, self().getX() + 7.0, self().getY() + 7.0, self().getZ() + 7.0));
        Iterator<Boat> boatIterator = list.iterator();

        Boat boat;
        while(boatIterator.hasNext()) {
            boat = boatIterator.next();
            if (((BoatLeashAccess)boat).getLeashHolder() == player && (boat instanceof Leashable || boat.getClass().equals(Boat.class))) {
                ((BoatLeashAccess)boat).setLeashedTo(self(), true);
                this.success = true;
            }
        }
    }

    @ModifyVariable(method = "interact", at = @At(value = "LOAD"))
    private boolean interactLeashShipSuccess(boolean bl) {
        return bl || this.success;
    }
}
