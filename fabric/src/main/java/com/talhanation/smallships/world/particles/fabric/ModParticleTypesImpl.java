package com.talhanation.smallships.world.particles.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModParticleTypesImpl extends ModParticleTypes {
    public static @NotNull <T extends ParticleOptions> Supplier<ParticleType<T>> register(String string, ParticleType<T> particleType) {
        ParticleType<T> type = Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, string), particleType);
        return () -> type;
    }
}
