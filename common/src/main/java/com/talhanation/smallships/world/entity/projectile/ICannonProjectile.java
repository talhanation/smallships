package com.talhanation.smallships.world.entity.projectile;

import com.talhanation.smallships.world.entity.cannon.Cannon;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3f;

public interface ICannonProjectile {
    /**
     * @param cannon
     * @param startPos
     * @param direction
     * @param cannonSpeedMultiplier
     * @param cannonAccuracy
     * @param shooter
     */
    void shootAndSpawn(Cannon cannon, Vector3d startPos, Vector3f direction, float cannonSpeedMultiplier, float cannonAccuracy, Entity shooter);
    @Nullable
    default ParticleOptions getAdditionalCannonShootParticles() {
        return null;
    }

    /**
     * @param fineGrain whether the shot was loaded with fine grain powder
     * @return the muzzle particles for this shot. Defaults to the plain ones, so
     * a projectile only has to override this if it actually looks different.
     */
    @Nullable
    default ParticleOptions getAdditionalCannonShootParticles(boolean fineGrain) {
        return this.getAdditionalCannonShootParticles();
    }
}