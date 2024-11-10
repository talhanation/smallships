package com.talhanation.smallships.world.entity.cannon;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;

public interface ICannon extends ICannonBallSource {
    ParticleOptions provideShootParticles();
    void playSoundAt(SoundEvent soundEvent, float volumeMultiplier, float pitch);
    Level getLevel();
}
