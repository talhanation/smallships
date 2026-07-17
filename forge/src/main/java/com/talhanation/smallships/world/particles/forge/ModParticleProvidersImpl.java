package com.talhanation.smallships.world.particles.forge;

import net.minecraft.client.particle.ParticleEngine;
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
        // must be stored as SpriteParticleRegistration - the ClientModBus event
        // handler casts to it (a plain Function caused a ClassCastException,
        // which is why the wind particles never registered on forge)
        ParticleEngine.SpriteParticleRegistration<T> registration = provider::apply;
        PARTICLE_PROVIDERS.add(new Pair<>(type, registration));
    }
}