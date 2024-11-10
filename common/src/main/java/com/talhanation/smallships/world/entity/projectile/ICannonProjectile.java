package com.talhanation.smallships.world.entity.projectile;

import com.talhanation.smallships.world.entity.cannon.Cannon;
import net.minecraft.world.entity.LivingEntity;
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
    void shootAndSpawn(Cannon cannon, Vector3d startPos, Vector3f direction, float cannonSpeedMultiplier, float cannonAccuracy, LivingEntity shooter);
}
