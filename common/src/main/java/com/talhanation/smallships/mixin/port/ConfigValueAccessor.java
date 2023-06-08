package com.talhanation.smallships.mixin.port;

import net.minecraftforge.common.ForgeConfigSpec;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@Mixin(ForgeConfigSpec.ConfigValue.class)
public interface ConfigValueAccessor {
    @SuppressWarnings("rawtypes")
    @Accessor(remap = false)
    Supplier getDefaultSupplier();
}
