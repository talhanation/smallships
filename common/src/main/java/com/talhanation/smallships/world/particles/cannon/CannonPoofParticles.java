package com.talhanation.smallships.world.particles.cannon;

import com.talhanation.smallships.utils.Color;
import com.talhanation.smallships.utils.VectorMath;
import com.talhanation.smallships.world.particles.CompoundParticles;
import com.talhanation.smallships.world.particles.custom.CustomPoofParticleOptions;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

public class CannonPoofParticles extends CompoundParticles {
    @Nullable
    private final Integer color;

    public CannonPoofParticles(ClientLevel clientLevel, Integer color, double x, double y, double z, double vx, double vy, double vz) {
        super(clientLevel, 1, x, y, z, vx, vy, vz);
        this.color = color;
    }

    public CannonPoofParticles(ClientLevel clientLevel, double x, double y, double z, double vx, double vy, double vz) {
        this(clientLevel, null, x, y, z, vx, vy, vz);
    }

    @Override
    public void spawn() {
        this.addPoofForwardParticles(200);
        this.addStaticMainPoofParticles(100);
    }

    protected void addStaticMainPoofParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = VectorMath.getRandGaussian(this.random);
            Vector3d pos = new Vector3d(rand).mul(0.3)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.07);

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            if (v.dot(n) < 0) v = VectorMath.projectOntoPlane(v, n);

            if (this.color == null) {
                this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
            } else {
                Color color = new Color(this.color);
                this.level.addParticle(new CustomPoofParticleOptions(color.getAsVector3f()), pos.x, pos.y, pos.z, v.x, v.y, v.z);
            }
        }
    }

    protected void addPoofForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = VectorMath.getRandGaussian(this.random);
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getPos());
            Vector3d v = new Vector3d(rand).mul(0.03)
                    .add(this.getNormalizedDirection().mul(Math.abs(this.random.nextGaussian()) * 0.3F));

            /* prevent particles moving towards the cannon */
            Vector3d n = this.getNormalizedDirection();
            if (v.dot(n) < 0) v = VectorMath.projectOntoPlane(v, n);

            if (this.color == null) {
                this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
            } else {
                Color color = new Color(this.color);
                this.level.addParticle(new CustomPoofParticleOptions(color.getAsVector3f()), pos.x, pos.y, pos.z, v.x, v.y, v.z);
            }
        }
    }

    public static class DyedProvider implements ParticleProvider<DyedCannonShootOptions> {
        @Nullable
        @Override
        public Particle createParticle(DyedCannonShootOptions particleOptions, ClientLevel clientLevel, double x, double y, double z,
                                       double vx, double vy, double vz) {
            DyeColor color = particleOptions.dyeColor();
            Integer col = null;
            if (color != null) {
                col = color.getFireworkColor();
            }
            return new CannonPoofParticles(clientLevel, col, x, y, z, vx, vy, vz);
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double x, double y, double z,
                                       double vx, double vy, double vz) {
            return new CannonPoofParticles(clientLevel, x, y, z, vx, vy, vz);
        }
    }
}
