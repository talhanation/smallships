package com.talhanation.smallships.world.particles.sail;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.DyeColor;

import java.util.Locale;

/**
 * Which canvas the scraps were torn out of. Like the splinters next door the
 * whole particle is nothing but this: the sail colour decides which wool the
 * sprite is taken from, so a red sail sheds red cloth without a texture of
 * our own.
 *
 * Carried as the dye name, the same string the ship keeps in
 * {@link com.talhanation.smallships.world.entity.ship.Ship#SAIL_COLOR} - an
 * ordinal would shift the day the vanilla enum grows, a name does not.
 *
 * 1.20.1 has no StreamCodec for particles, see
 * {@link com.talhanation.smallships.world.particles.wood.WoodDebrisParticleOptions}
 * for how the Codec and the Deserializer split the work between them.
 */
public class SailShredParticleOptions implements ParticleOptions {
    public static final Codec<SailShredParticleOptions> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(Codec.STRING.fieldOf("color").forGetter(SailShredParticleOptions::getColorName))
                    .apply(instance, SailShredParticleOptions::new));

    public static final Deserializer<SailShredParticleOptions> DESERIALIZER = new Deserializer<>() {
        @Override
        public SailShredParticleOptions fromCommand(ParticleType<SailShredParticleOptions> particleType, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            return new SailShredParticleOptions(reader.readUnquotedString());
        }

        @Override
        public SailShredParticleOptions fromNetwork(ParticleType<SailShredParticleOptions> particleType, FriendlyByteBuf buf) {
            return new SailShredParticleOptions(buf.readUtf());
        }
    };

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

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.SAIL_SHRED.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeUtf(this.getColorName());
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %s",
                BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()), this.getColorName());
    }
}
