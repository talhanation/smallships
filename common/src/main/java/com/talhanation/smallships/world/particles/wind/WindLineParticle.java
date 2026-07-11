package com.talhanation.smallships.world.particles.wind;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

/**
 * A white streak on the water surface that drifts with the wind.
 * Spawned client side by WindEffects, velocity encodes wind direction and strength.
 */
public class WindLineParticle extends TextureSheetParticle {
    protected WindLineParticle(ClientLevel level, double x, double y, double z, double vx, double vy, double vz, SpriteSet sprites) {
        super(level, x, y, z, vx, vy, vz);
        this.xd = vx;
        this.yd = 0.0D;
        this.zd = vz;
        this.setSize(0.3F, 0.05F);
        this.quadSize = 0.25F + this.random.nextFloat() * 0.2F;
        this.lifetime = 25 + this.random.nextInt(15);
        this.friction = 1.0F;
        this.gravity = 0.0F;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.alpha = 0.0F;
        this.setSpriteFromAge(sprites);
        this.spriteSet = sprites;
    }

    private final SpriteSet spriteSet;

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
