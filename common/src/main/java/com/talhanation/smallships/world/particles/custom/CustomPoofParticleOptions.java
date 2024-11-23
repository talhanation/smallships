package com.talhanation.smallships.world.particles.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import org.joml.Vector3f;

public record CustomPoofParticleOptions(Vector3f color) implements ParticleOptions {
    public static final StreamCodec<RegistryFriendlyByteBuf, CustomPoofParticleOptions> STREAM_CODEC;
    public static final MapCodec<CustomPoofParticleOptions> MAP_CODEC;

    static {
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.VECTOR3F, CustomPoofParticleOptions::color,
                CustomPoofParticleOptions::new);
        MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(ExtraCodecs.VECTOR3F.fieldOf("color").forGetter(CustomPoofParticleOptions::color))
                        .apply(instance, CustomPoofParticleOptions::new));
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.COLORED_POOF;
    }
}
