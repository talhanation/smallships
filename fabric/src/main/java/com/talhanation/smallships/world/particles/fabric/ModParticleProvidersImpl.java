package com.talhanation.smallships.world.particles.fabric;

import com.talhanation.smallships.world.particles.ModParticleProviders;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.util.function.Function;

@SuppressWarnings("unused")
public class ModParticleProvidersImpl extends ModParticleProviders {
    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleProvider<T> provider) {
        ParticleFactoryRegistry.getInstance().register(type, provider);
    }

    public static <T extends ParticleOptions> void register(ParticleType<T> type, Function<SpriteSet, ParticleProvider<T>> provider) {
        // use the PendingParticleFactory overload explicitly: it hands us the
        // sprite set loaded from assets/<modid>/particles/<name>.json once the
        // atlas is ready. Passing "provider::apply" directly is ambiguous between
        // the ParticleFactory and PendingParticleFactory overloads, which on
        // Fabric silently binds the sprite-less path and leaves the particle
        // invisible - the FabricSpriteProvider given here IS a SpriteSet.
        ParticleFactoryRegistry.getInstance().register(type, spriteProvider -> provider.apply(spriteProvider));
    }
}