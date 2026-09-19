package com.talhanation.smallships.world.particles.wood;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Locale;

/**
 * Which timber the splinters came out of. The whole particle is nothing but
 * this: the wood type decides the texture, so a spruce hull throws spruce and
 * a mangrove hull throws mangrove, without a single texture of our own.
 *
 * Carried as the vanilla name rather than the ordinal, the same way
 * {@link com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions}
 * carries its dye: an ordinal shifts the day a wood type is inserted into the
 * vanilla enum, a name does not.
 *
 * 1.20.1 has no StreamCodec for particles. A ParticleType carries a plain Codec
 * for the json and command side and a Deserializer that does the two network
 * directions by hand: fromCommand parses the /particle argument, fromNetwork
 * reads what writeToNetwork below put on the wire.
 */
public class WoodDebrisParticleOptions implements ParticleOptions {
    public static final Codec<WoodDebrisParticleOptions> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(Codec.STRING.fieldOf("woodType").forGetter(WoodDebrisParticleOptions::getWoodTypeName))
                    .apply(instance, WoodDebrisParticleOptions::new));

    public static final Deserializer<WoodDebrisParticleOptions> DESERIALIZER = new Deserializer<>() {
        @Override
        public WoodDebrisParticleOptions fromCommand(ParticleType<WoodDebrisParticleOptions> particleType, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            return new WoodDebrisParticleOptions(reader.readUnquotedString());
        }

        @Override
        public WoodDebrisParticleOptions fromNetwork(ParticleType<WoodDebrisParticleOptions> particleType, FriendlyByteBuf buf) {
            return new WoodDebrisParticleOptions(buf.readUtf());
        }
    };

    private final Boat.Type woodType;

    public WoodDebrisParticleOptions(Boat.Type woodType) {
        this.woodType = woodType;
    }

    /**
     * Boat.Type#byName falls back to OAK on anything it does not know, so a
     * name off the wire or out of a command can never leave this null - the
     * splinters just come out oak.
     */
    protected WoodDebrisParticleOptions(String woodType) {
        this(Boat.Type.byName(woodType));
    }

    public Boat.Type woodType() {
        return this.woodType;
    }

    public String getWoodTypeName() {
        return this.woodType.getName();
    }

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.WOOD_DEBRIS.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeUtf(this.getWoodTypeName());
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %s",
                BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()), this.getWoodTypeName());
    }
}