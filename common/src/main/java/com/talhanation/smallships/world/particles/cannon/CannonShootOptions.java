package com.talhanation.smallships.world.particles.cannon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SculkChargeParticleOptions;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record CannonShootOptions(boolean onlyPoof) implements ParticleOptions {
    public static final StreamCodec<RegistryFriendlyByteBuf, CannonShootOptions> STREAM_CODEC;
    public static final MapCodec<CannonShootOptions> MAP_CODEC;

    static {
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL, CannonShootOptions::onlyPoof,
                CannonShootOptions::new);
        MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(Codec.BOOL.fieldOf("onlyPoof").forGetter(CannonShootOptions::onlyPoof))
                        .apply(instance, CannonShootOptions::new));
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.CANNON_SHOOT;
    }
}
