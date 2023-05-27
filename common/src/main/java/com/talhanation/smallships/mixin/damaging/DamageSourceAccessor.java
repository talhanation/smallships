package com.talhanation.smallships.mixin.damaging;

import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DamageSource.class)
public interface DamageSourceAccessor {
    @Invoker
    DamageSource callBypassArmor();
}
