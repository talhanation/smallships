package com.talhanation.smallships.mixin.port;

import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import port.HasCustomInventoryScreen;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerMixin {
    @Shadow public ServerPlayer player;

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @ModifyConstant(method = "handlePlayerCommand", constant = @Constant(classValue = AbstractHorse.class, ordinal = 0))
    private Class<HasCustomInventoryScreen> handlePlayerCommandOpenInventoryWithInterfaceInstanceof(Object object, Class<AbstractHorse> constant) {
        return HasCustomInventoryScreen.class;
    }

    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "handlePlayerCommand", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;getVehicle()Lnet/minecraft/world/entity/Entity;", ordinal = 5), cancellable = true)
    private void handlePlayerCommandOpenInventoryWithInterfaceOpen(ServerboundPlayerCommandPacket serverboundPlayerCommandPacket, CallbackInfo ci) {
        ((HasCustomInventoryScreen)this.player.getVehicle()).openCustomInventoryScreen(this.player);
        ci.cancel();
    }
}
