package com.talhanation.smallships.world.particles.wood;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * Which timber the splinters came out of. The whole particle is nothing but
 * this: the wood type decides the texture, so a spruce hull throws spruce and
 * a mangrove hull throws mangrove, without a single texture of our own.
 *
 * Carried as the vanilla name rather than the ordinal, the same way
 * {@link com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions}
 * carries its dye: an ordinal shifts the day a wood type is inserted into the
 * vanilla enum, a name does not.
 */
public class WoodDebrisParticleOptions implements ParticleOptions {
    public static final StreamCodec<RegistryFriendlyByteBuf, WoodDebrisParticleOptions> STREAM_CODEC;
    public static final MapCodec<WoodDebrisParticleOptions> MAP_CODEC;

    private final Boat.Type woodType;

    public WoodDebrisParticleOptions(Boat.Type woodType) {
        this.woodType = woodType;
    }

    protected WoodDebrisParticleOptions(String woodType) {
        this(Boat.Type.byName(woodType));
    }

    public Boat.Type woodType() {
        return this.woodType;
    }

    public String getWoodTypeName() {
        return this.woodType.getName();
    }

    static {
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8, WoodDebrisParticleOptions::getWoodTypeName,
                WoodDebrisParticleOptions::new);
        MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(Codec.STRING.fieldOf("woodType").forGetter(WoodDebrisParticleOptions::getWoodTypeName))
                        .apply(instance, WoodDebrisParticleOptions::new));
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.WOOD_DEBRIS.get();
    }
}