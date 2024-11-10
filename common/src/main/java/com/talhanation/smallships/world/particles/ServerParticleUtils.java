package com.talhanation.smallships.world.particles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import org.joml.Vector3d;

public class ServerParticleUtils {
    public static void sendParticle(ServerLevel level, ParticleOptions options, Vector3d pos, Vector3d speed) {
        level.sendParticles(options, pos.x, pos.y, pos.z, 0, speed.x, speed.y, speed.z, 1);
    }
}
