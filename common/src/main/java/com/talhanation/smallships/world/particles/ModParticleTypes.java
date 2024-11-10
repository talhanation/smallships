package com.talhanation.smallships.world.particles;

import com.mojang.serialization.MapCodec;
import com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions;
import com.talhanation.smallships.world.particles.custom.CustomPoofParticleOptions;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class ModParticleTypes {
    public static final SimpleParticleType CANNON_SHOOT;
    public static final ParticleType<DyedCannonShootOptions> DYED_CANNON_SHOOT;
    public static final SimpleParticleType CANNON_BALL_SHOOT;
    public static final ParticleType<CustomPoofParticleOptions> COLORED_POOF;

    static {
        CANNON_SHOOT = register("basic_cannon_shoot");
        DYED_CANNON_SHOOT = register("dyed_cannon_shoot",
                DyedCannonShootOptions.MAP_CODEC, DyedCannonShootOptions.STREAM_CODEC);
        COLORED_POOF = register("colored_poof",
                CustomPoofParticleOptions.MAP_CODEC, CustomPoofParticleOptions.STREAM_CODEC);
        CANNON_BALL_SHOOT = register("cannon_ball_shoot");
    }

    /**
     * Register a simple particle without options.
     * @param id
     * @param provider
     * @return
     */
    public static SimpleParticleType register(String id) {
        return register(id, false);
    }

    public static SimpleParticleType register(String id, boolean overrideLimiter) {
        SimpleParticleType type = new SimpleParticleTypeImpl(overrideLimiter);
        register(id, type);
        return type;
    }

    public static <T extends ParticleOptions> ParticleType<T> register(String string,
                                                                       final MapCodec<T> codecSupplier,
                                                                       final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodecSupplier) {
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
        register(string, type);
        return type;
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void register(String string, ParticleType<T> type) {
        throw new AssertionError();
    }

    private static class SimpleParticleTypeImpl extends SimpleParticleType {
        public SimpleParticleTypeImpl(boolean bl) {
            super(bl);
        }
    }
}
