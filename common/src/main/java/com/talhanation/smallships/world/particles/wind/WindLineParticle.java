package com.talhanation.smallships.world.particles.wind;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

/**
 * A white streak on the water surface that drifts with the wind.
 * Spawned client side by WindEffects, velocity encodes wind direction and strength.
 * The quad is rendered flat on the XZ plane and aligned to the wind direction
 * instead of billboarding towards the camera.
 */
public class WindLineParticle extends TextureSheetParticle {
    private static final float MAX_ALPHA = 0.55F;

    private final SpriteSet spriteSet;
    // horizontal wind direction (normalized), used to orient the flat quad
    private final float dirX;
    private final float dirZ;

    protected WindLineParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet sprites) {
        super(level, x, y, z, vx, vy, vz);
        this.xd = vx;
        this.yd = 0.0D;
        this.zd = vz;
        this.setSize(0.3F, 0.05F);
        this.quadSize = 1.25F + this.random.nextFloat() * 0.35F;
        this.lifetime = 25 + this.random.nextInt(15);
        this.friction = 1.0F;
        this.gravity = 0.0F;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.alpha = 0.0F;
        this.setSpriteFromAge(sprites);
        this.spriteSet = sprites;

        double len = Math.sqrt(vx * vx + vz * vz);
        if (len < 1.0E-4D) {
            this.dirX = 0.0F;
            this.dirZ = 1.0F;
        } else {
            this.dirX = (float) (vx / len);
            this.dirZ = (float) (vz / len);
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.spriteSet);
        // fade in and out
        float lifeProgress = (float) this.age / (float) this.lifetime;
        float maxAlpha = 0.55F;
        if (lifeProgress < 0.25F) this.alpha = maxAlpha * (lifeProgress / 0.25F);
        else if (lifeProgress > 0.75F) this.alpha = maxAlpha * (1.0F - (lifeProgress - 0.75F) / 0.25F);
        else this.alpha = maxAlpha;
    }

        // the quad lies flat on the water: "along" runs with the wind, "across"
        // is perpendicular to it, both on the XZ plane so it never faces the camera
        float halfLength = this.quadSize;
        float halfWidth = this.quadSize * 0.3F;
        float alongX = this.dirX * halfLength;
        float alongZ = this.dirZ * halfLength;
        float acrossX = -this.dirZ * halfWidth;
        float acrossZ = this.dirX * halfWidth;

        Vector3f[] corners = new Vector3f[]{
                new Vector3f(-alongX - acrossX, 0.0F, -alongZ - acrossZ),
                new Vector3f(-alongX + acrossX, 0.0F, -alongZ + acrossZ),
                new Vector3f(alongX + acrossX, 0.0F, alongZ + acrossZ),
                new Vector3f(alongX - acrossX, 0.0F, alongZ - acrossZ)
        };

        float u0 = this.getU0();
        float u1 = this.getU1();
        float v0 = this.getV0();
        float v1 = this.getV1();
        int light = this.getLightColor(partialTicks);

        this.emit(buffer, corners[0], px, py, pz, u1, v1, light);
        this.emit(buffer, corners[1], px, py, pz, u1, v0, light);
        this.emit(buffer, corners[2], px, py, pz, u0, v0, light);
        this.emit(buffer, corners[3], px, py, pz, u0, v1, light);
    }

    private void emit(VertexConsumer buffer, Vector3f corner, float px, float py, float pz, float u, float v, int light) {
        buffer.addVertex(px + corner.x(), py + corner.y(), pz + corner.z())
                .setUv(u, v)
                .setColor(this.rCol, this.gCol, this.bCol, this.alpha)
                .setLight(light);
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType options, ClientLevel level, double x, double y, double z, double vx, double vy, double vz) {
            return new WindLineParticle(level, x, y, z, vx, vy, vz, this.sprites);
        }
    }
}