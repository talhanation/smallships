package com.talhanation.smallships.world.particles.neoforge;

import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@SuppressWarnings("unused")
public class ModParticleProvidersImpl {
    public static List<Pair<ParticleType<?>, Object>> PARTICLE_PROVIDERS = new ArrayList<>();

    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleProvider<T> provider) {
        PARTICLE_PROVIDERS.add(new Pair<>(type, provider));
    }

    public static <T extends ParticleOptions> void register(ParticleType<T> type, Function<SpriteSet, ParticleProvider<T>> provider) {
        PARTICLE_PROVIDERS.add(new Pair<>(type, provider));
    }
}
