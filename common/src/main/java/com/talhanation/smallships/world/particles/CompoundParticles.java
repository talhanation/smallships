package com.talhanation.smallships.world.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import org.joml.Vector3d;

/**
 * Useful for spawning other minecraft particles
 */
public abstract class CompoundParticles extends Particle {
    private final Vector3d speed;

    public CompoundParticles(ClientLevel clientLevel, int lifetime, double x, double y, double z) {
        this(clientLevel, lifetime, x, y, z, 0, 0, 0);
    }

    public CompoundParticles(ClientLevel clientLevel, int lifetime, double x, double y, double z, double vx, double vy, double vz) {
        super(clientLevel, x, y, z, 0, 0, 0);
        this.speed = new Vector3d(vx, vy, vz);
        this.lifetime = lifetime;
    }

    public Vector3d getPos() {
        return new Vector3d(this.x, this.y, this.z);
    }

    public Vector3d getNormalizedDirection() {
        return this.speed.length() == 0 ? new Vector3d(0) : new Vector3d(this.speed).normalize();
    }

    public Vector3d getSpeed() {
        return new Vector3d(this.speed);
    }

    @Override
    public final void tick() {
        if (this.age == 0) {
            this.spawn();
        } else {
            this.update();
        }

        if (this.age++ >= this.lifetime) {
            this.remove();
        }
    }

    public abstract void spawn();

    public void update() {

    }

    @Override
    public final void render(VertexConsumer vertexConsumer, Camera camera, float f) { }

    @Override
    public final ParticleRenderType getRenderType() {
        return ParticleRenderType.NO_RENDER;
    }
}
