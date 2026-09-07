package com.talhanation.smallships.world.particles;

import com.mojang.serialization.Codec;
import com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions;
import com.talhanation.smallships.world.particles.custom.CustomPoofParticleOptions;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModParticleTypes {
    public static final Supplier<SimpleParticleType> CANNON_SHOOT;
    public static final Supplier<ParticleType<DyedCannonShootOptions>> DYED_CANNON_SHOOT;
    public static final Supplier<SimpleParticleType> CANNON_BALL_SHOOT;
    /** same muzzle blast, but half the smoke burnt off into flame - fine grain powder */
    public static final Supplier<SimpleParticleType> CANNON_BALL_SHOOT_FINE;
    public static final Supplier<ParticleType<CustomPoofParticleOptions>> COLORED_POOF;
    public static final Supplier<SimpleParticleType> WIND_LINE;

    static {
        CANNON_SHOOT = register("basic_cannon_shoot");
        DYED_CANNON_SHOOT = register("dyed_cannon_shoot",
                DyedCannonShootOptions.CODEC, DyedCannonShootOptions.DESERIALIZER);
        COLORED_POOF = register("colored_poof",
                CustomPoofParticleOptions.CODEC, CustomPoofParticleOptions.DESERIALIZER);
        CANNON_BALL_SHOOT = register("cannon_ball_shoot");
        CANNON_BALL_SHOOT_FINE = register("cannon_ball_shoot_fine");
        WIND_LINE = register("wind_line");
    }

    public static Supplier<SimpleParticleType> register(String id) {
        return register(id, false);
    }

    @SuppressWarnings("unchecked")
    public static Supplier<SimpleParticleType> register(String id, boolean overrideLimiter) {
        SimpleParticleType type = new SimpleParticleTypeImpl(overrideLimiter);
        return (Supplier<SimpleParticleType>) (Supplier<?>) register(id, type);
    }

    /**
     * 1.20.1 splits what later versions put into two codecs: the Codec covers
     * json and the /particle command, the Deserializer is handed to the
     * ParticleType constructor and does the network side.
     */
    public static <T extends ParticleOptions> Supplier<ParticleType<T>> register(String string,
                                                                                 final Codec<T> codec,
                                                                                 final ParticleOptions.Deserializer<T> deserializer) {
        ParticleType<T> type = new ParticleType<>(false, deserializer) {
            @Override
            public @NotNull Codec<T> codec() {
                return codec;
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