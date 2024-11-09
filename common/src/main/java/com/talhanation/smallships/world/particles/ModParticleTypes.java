package com.talhanation.smallships.world.particles;

import com.mojang.serialization.MapCodec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class ModParticleTypes {
    /**
     * Register a simple particle without options.
     * @param id
     * @param provider
     * @return
     */
    public static SimpleParticleType register(String id, ParticleProvider<SimpleParticleType> provider) {
        return register(id, false, provider);
    }

    public static SimpleParticleType register(String id, boolean overrideLimiter, ParticleProvider<SimpleParticleType> provider) {
        SimpleParticleType type = new SimpleParticleTypeImpl(overrideLimiter);
        register(id, type, provider);
        return type;
    }

    public static <T extends ParticleOptions> ParticleType<T> register(String string,
                                                                       final MapCodec<T> codecSupplier,
                                                                       final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodecSupplier,
                                                                       ParticleProvider<T> provider) {
        ParticleType<T> type = new ParticleType<T>(false) {
            @Override
            public MapCodec<T> codec() {
                return codecSupplier;
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodecSupplier;
            }
        };
        register(string, type, provider);
        return type;
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void register(String string, ParticleType<T> type, ParticleProvider<T> provider) {
        throw new AssertionError();
    }

    private static class SimpleParticleTypeImpl extends SimpleParticleType {
        public SimpleParticleTypeImpl(boolean bl) {
            super(bl);
        }
    }
}
