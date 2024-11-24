package com.talhanation.smallships.world.particles.cannon;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;

public class DyedCannonShootOptions implements ParticleOptions {
    public static final StreamCodec<RegistryFriendlyByteBuf, DyedCannonShootOptions> STREAM_CODEC;
    public static final MapCodec<DyedCannonShootOptions> MAP_CODEC;

    private final DyeColor dyeColor;

    public DyedCannonShootOptions(DyeColor dyeColor) {
        this.dyeColor = dyeColor;
    }

    protected DyedCannonShootOptions(String dyeColor) {
        this(DyeColor.byName(dyeColor, null));
    }

    public DyeColor dyeColor() {
        return this.dyeColor;
    }

    public String getDyeColorName() {
        return this.dyeColor() == null ? "" : this.dyeColor().getSerializedName();
    }

    static {
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8, DyedCannonShootOptions::getDyeColorName,
                DyedCannonShootOptions::new);
        MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(Codec.STRING.fieldOf("dyeColor").forGetter(DyedCannonShootOptions::getDyeColorName))
                        .apply(instance, DyedCannonShootOptions::new));
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.DYED_CANNON_SHOOT.get();
    }
}
