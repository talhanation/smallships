package com.talhanation.smallships.world.particles.cannon;

import com.talhanation.smallships.world.particles.CompoundParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

public class CannonShootParticles extends CompoundParticles {
    private final boolean onlyPoof;

    public CannonShootParticles(ClientLevel clientLevel, boolean onlyPoof, double x, double y, double z, double vx, double vy, double vz) {
        super(clientLevel, 1, x, y, z, vx, vy, vz);
        this.onlyPoof = onlyPoof;
    }

    @Override
    public void spawn() {
        this.addPoofForwardParticles(200);
        this.addStaticMainPoofParticles(100);

        if (!this.onlyPoof) {
            this.addFlamesForwardParticles(100);
            this.addStaticDarkSmokeParticles(50);
        }
    }

    protected void addStaticMainPoofParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.3)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.07);

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            double dotProduct = v.dot(n);
            if (dotProduct < 0) {
                v.sub(n.mul(dotProduct));
            }

            this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addPoofForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.03)
                    .add(new Vector3d(this.getNormalizedDirection()).mul(Math.abs(this.level.random.nextGaussian()) * 0.3F));

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            double dotProduct = v.dot(n);
            if (dotProduct < 0) {
                v.sub(n.mul(dotProduct));
            }

            this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addFlamesForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.01)
                    .add(this.getNormalizedDirection().mul(Math.abs(this.level.random.nextGaussian()) * 0.2F));

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            double dotProduct = v.dot(n);
            if (dotProduct < 0) {
                v.sub(n.mul(dotProduct));
            }

            this.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addStaticDarkSmokeParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.02);

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            double dotProduct = v.dot(n);
            if (dotProduct < 0) {
                v.sub(n.mul(dotProduct));
            }

            this.level.addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected Vector3d getRandGaussian() {
        return new Vector3d(this.level.random.nextGaussian(), this.level.random.nextGaussian(), this.level.random.nextGaussian());
    }

    public static class Provider implements ParticleProvider<CannonShootOptions> {
        @Nullable
        @Override
        public Particle createParticle(CannonShootOptions particleOptions, ClientLevel clientLevel, double x, double y, double z,
                                       double vx, double vy, double vz) {
            return new CannonShootParticles(clientLevel, particleOptions.onlyPoof(), x, y, z, vx, vy, vz);
        }
    }
}
