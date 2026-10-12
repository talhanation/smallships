package com.talhanation.smallships.world.particles.sail;

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

/**
 * Which canvas the scraps were torn out of. Like the splinters next door the
 * whole particle is nothing but this: the sail colour decides which wool the
 * sprite is taken from, so a red sail sheds red cloth without a texture of
 * our own.
 *
 * Carried as the dye name, the same string the ship keeps in
 * {@link com.talhanation.smallships.world.entity.ship.Ship#SAIL_COLOR} - an
 * ordinal would shift the day the vanilla enum grows, a name does not.
 */
public class SailShredParticleOptions implements ParticleOptions {
    public static final StreamCodec<RegistryFriendlyByteBuf, SailShredParticleOptions> STREAM_CODEC;
    public static final MapCodec<SailShredParticleOptions> MAP_CODEC;

    private final DyeColor color;

    public SailShredParticleOptions(DyeColor color) {
        this.color = color;
    }

    /**
     * DyeColor#byName is handed WHITE as its fallback, so a name off the wire
     * or out of a command can never leave this null - the scraps just come out
     * white, which is what an undyed sail is anyway.
     */
    protected SailShredParticleOptions(String color) {
        this(DyeColor.byName(color, DyeColor.WHITE));
    }

    public DyeColor color() {
        return this.color;
    }

    public String getColorName() {
        return this.color.getName();
    }

    static {
        STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8, SailShredParticleOptions::getColorName,
                SailShredParticleOptions::new);
        MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(Codec.STRING.fieldOf("color").forGetter(SailShredParticleOptions::getColorName))
                        .apply(instance, SailShredParticleOptions::new));
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.SAIL_SHRED.get();
    }
}