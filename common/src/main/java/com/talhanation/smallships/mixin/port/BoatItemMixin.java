package com.talhanation.smallships.mixin.port;

import com.talhanation.smallships.world.item.ShipItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BoatItem.class)
public class BoatItemMixin {
    private Level level;
    private HitResult hitResult;

    @Inject(method = "use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;", at = @At(value = "NEW", target = "net/minecraft/world/entity/vehicle/Boat", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureLocals(Level level, Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir, ItemStack itemStack, HitResult hitResult) {
        this.level = level;
        this.hitResult = hitResult;
    }

    @Redirect(method = "use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;", at = @At(value = "NEW", target = "net/minecraft/world/entity/vehicle/Boat"))
    private Boat modifyBoatEntity(Level level, double d, double e, double f) {
        if (((BoatItem)(Object)this) instanceof ShipItem shipItem) return shipItem.getBoat(this.level, this.hitResult);
        else return new Boat(level, d, e, f);
    }

}
