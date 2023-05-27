package com.talhanation.smallships.mixin.port;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import port.HasCustomInventoryScreen;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
    @SuppressWarnings("InvalidInjectorMethodSignature")
    @ModifyConstant(method = "isServerControlledInventory", constant = @Constant(classValue = AbstractHorse.class))
    private Class<HasCustomInventoryScreen> isServerControlledInventoryForInterface(Object object, Class<AbstractHorse> constant) {
        return HasCustomInventoryScreen.class;
    }
}
