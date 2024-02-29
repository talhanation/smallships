package com.talhanation.smallships.mixin.controlling;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Boat.class)
public abstract class BoatMixin {
    @Shadow protected abstract void controlBoat();


    @SuppressWarnings("ConstantValue")
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;tickLerp()V"))
    private void tickClientAndServerControlBoat(CallbackInfo ci) {
        if (((Boat)(Object)this instanceof Ship)) {
            this.controlBoat();
        }
    }

    @SuppressWarnings("ConstantValue")
    @Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;controlBoat()V"))
    private void tickCancelControlBoatHereForShip(Boat instance) {
        if (!(((Boat)(Object)this) instanceof Ship)) {
            this.controlBoat();
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;checkInsideBlocks()V"), cancellable = true)
    private void tickCheckPassengersForShip(CallbackInfo ci) {
        if ((((Boat)(Object)this) instanceof Ship ship)) {

            List<Entity> list = ((Boat)(Object)this).getCommandSenderWorld().getEntities(((Boat)(Object)this), ((Boat)(Object)this).getBoundingBox().inflate(0.20000000298023224, -0.009999999776482582, 0.20000000298023224), EntitySelector.pushableBy(((Boat)(Object)this)));
            if (!list.isEmpty()) {
                boolean bl = !((Boat)(Object)this).getCommandSenderWorld().isClientSide && !(((Boat)(Object)this).getControllingPassenger() instanceof Player);

                for(int j = 0; j < list.size(); ++j) {
                    Entity entity = (Entity)list.get(j);
                    if (!entity.hasPassenger(((Boat)(Object)this))) {
                        if (bl && !SmallShipsConfig.Common.mountBlackList.get().contains(entity.getEncodeId()) && !ship.isLocked() && ((Boat)(Object)this).getPassengers().size() < ((Boat)(Object)this).getMaxPassengers() && !entity.isPassenger() && entity.getBbWidth() < ((Boat)(Object)this).getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
                            entity.startRiding(((Boat)(Object)this));
                        } else {
                            ((Boat)(Object)this).push(entity);
                        }
                    }
                }
            }
            ci.cancel();
        }
    }
}
