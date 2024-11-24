package com.talhanation.smallships.world.particles;

import com.talhanation.smallships.world.particles.cannon.CannonBallShootParticles;
import com.talhanation.smallships.world.particles.cannon.CannonPoofParticles;
import com.talhanation.smallships.world.particles.custom.CustomPoofParticle;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModParticleProviders {
    public ModParticleProviders() {
        register(ModParticleTypes.CANNON_SHOOT.get(), CannonPoofParticles.Provider::new);
        register(ModParticleTypes.DYED_CANNON_SHOOT.get(), CannonPoofParticles.DyedProvider::new);
        register(ModParticleTypes.COLORED_POOF.get(), CustomPoofParticle.Provider::new);
        register(ModParticleTypes.CANNON_BALL_SHOOT.get(), CannonBallShootParticles.Provider::new);
    }

    public static <T extends ParticleOptions> void register(ParticleType<T> type, Supplier<ParticleProvider<T>> providerConstructor) {
        register(type, providerConstructor.get());
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void register(ParticleType<T> type, ParticleProvider<T> provider) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void register(ParticleType<T> type, Function<SpriteSet, ParticleProvider<T>> provider) {
        throw new AssertionError();
    }
}
