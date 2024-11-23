package com.talhanation.smallships.world.particles.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class CustomPoofParticle extends ExplodeParticle {
    protected CustomPoofParticle(ClientLevel clientLevel, Vector3f col, double d, double e, double f, double g, double h, double i, SpriteSet spriteSet) {
        super(clientLevel, d, e, f, g, h, i, spriteSet);
        float brightness = this.random.nextFloat() * 0.3F + 0.7F;
        this.rCol = col.x * brightness;
        this.gCol = col.y * brightness;
        this.bCol = col.z * brightness;
    }

    @Override
    public int getLightColor(float partialTicks) {
        return 15728880;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public static class Provider implements ParticleProvider<CustomPoofParticleOptions> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(CustomPoofParticleOptions particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new CustomPoofParticle(clientLevel, particleOptions.color(), d, e, f, g, h, i, this.sprites);
        }
    }
}
