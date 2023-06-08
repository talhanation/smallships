package com.talhanation.smallships.mixin.port;

import com.talhanation.smallships.world.item.ShipItem;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BoatItem.class)
public class BoatItemMixin {
    @SuppressWarnings("DataFlowIssue")
    @Redirect(method = "use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;", at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/Level;DDD)Lnet/minecraft/world/entity/vehicle/Boat;"))
    private Boat modifyBoatEntity(Level level, double d, double e, double f) {
        if (((BoatItem)(Object)this) instanceof ShipItem shipItem) return shipItem.getBoat(level, d, e, f);
        else return new Boat(level, d, e, f);
    }

}
