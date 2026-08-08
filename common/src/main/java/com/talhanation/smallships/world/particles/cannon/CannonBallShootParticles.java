package com.talhanation.smallships.world.particles.cannon;

import com.talhanation.smallships.utils.VectorMath;
import com.talhanation.smallships.world.particles.CompoundParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

public class CannonBallShootParticles extends CompoundParticles {
    private static final int FLAMES = 100;
    private static final int SMOKE = 50;

    /** fine grain powder burns clean: half the smoke never forms and goes off as flame */
    private final boolean fineGrain;

    public CannonBallShootParticles(ClientLevel clientLevel, boolean fineGrain, double x, double y, double z, double vx, double vy, double vz) {
        super(clientLevel, 1, x, y, z, vx, vy, vz);
        this.fineGrain = fineGrain;
    }

    public CannonBallShootParticles(ClientLevel clientLevel,  double x, double y, double z, double vx, double vy, double vz) {
        this(clientLevel, false, x, y, z, vx, vy, vz);
    }

    @Override
    public void spawn() {
        int smoke = this.fineGrain ? SMOKE / 2 : SMOKE;
        // the total count stays the same, only what it is made of changes
        this.addFlamesForwardParticles(FLAMES + (SMOKE - smoke));
        this.addDarkSmokeParticles(smoke);
    }

    protected void addFlamesForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = VectorMath.getRandGaussian(this.random);
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.02)
                    .add(this.getNormalizedDirection().mul(Math.abs(this.random.nextGaussian()) * 0.2F));

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            if (v.dot(n) < 0) v = VectorMath.projectOntoPlane(v, n);

            this.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addDarkSmokeParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = VectorMath.getRandGaussian(this.random);
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.02)
                    .add(this.getNormalizedDirection().mul(Math.max(0, this.random.nextGaussian()) * 0.05F));

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            if (v.dot(n) < 0) v = VectorMath.projectOntoPlane(v, n);

            this.level.addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new CannonBallShootParticles(clientLevel, false, d, e, f, g, h, i);
        }
    }

    public static class FineProvider implements ParticleProvider<SimpleParticleType> {
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new CannonBallShootParticles(clientLevel, true, d, e, f, g, h, i);
        }
    }
}