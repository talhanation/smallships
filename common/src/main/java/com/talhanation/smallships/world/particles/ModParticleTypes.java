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
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModParticleTypes {
    public static final Supplier<SimpleParticleType> CANNON_SHOOT;
    public static final Supplier<ParticleType<DyedCannonShootOptions>> DYED_CANNON_SHOOT;
    public static final Supplier<SimpleParticleType> CANNON_BALL_SHOOT;
    public static final Supplier<ParticleType<CustomPoofParticleOptions>> COLORED_POOF;

    static {
        CANNON_SHOOT = register("basic_cannon_shoot");
        DYED_CANNON_SHOOT = register("dyed_cannon_shoot",
                DyedCannonShootOptions.MAP_CODEC, DyedCannonShootOptions.STREAM_CODEC);
        COLORED_POOF = register("colored_poof",
                CustomPoofParticleOptions.MAP_CODEC, CustomPoofParticleOptions.STREAM_CODEC);
        CANNON_BALL_SHOOT = register("cannon_ball_shoot");
    }

    public static Supplier<SimpleParticleType> register(String id) {
        return register(id, false);
    }

    @SuppressWarnings("unchecked")
    public static Supplier<SimpleParticleType> register(String id, boolean overrideLimiter) {
        SimpleParticleType type = new SimpleParticleTypeImpl(overrideLimiter);
        return (Supplier<SimpleParticleType>) (Supplier<?>) register(id, type);
    }

    public static <T extends ParticleOptions> Supplier<ParticleType<T>> register(String string,
                                                                       final MapCodec<T> codecSupplier,
                                                                       final StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodecSupplier) {
        ParticleType<T> type = new ParticleType<>(false) {
            @Override
            public @NotNull MapCodec<T> codec() {
                return codecSupplier;
            }

            @Override
            public @NotNull StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return streamCodecSupplier;
            }
        };
        return register(string, type);
    }

    @ExpectPlatform
    public static @NotNull <T extends ParticleOptions> Supplier<ParticleType<T>> register(String string, ParticleType<T> particleType) {
        throw new AssertionError();
    }

    private static class SimpleParticleTypeImpl extends SimpleParticleType {
        public SimpleParticleTypeImpl(boolean bl) {
            super(bl);
        }
    }
}
