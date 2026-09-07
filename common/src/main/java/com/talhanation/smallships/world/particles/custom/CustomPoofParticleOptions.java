package com.talhanation.smallships.world.particles.custom;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import org.joml.Vector3f;

import java.util.Locale;

/**
 * 1.20.1 has no StreamCodec for particles. A ParticleType carries a plain Codec
 * for the json/command side and a Deserializer that does the two directions by
 * hand: fromCommand parses the /particle argument, fromNetwork reads what
 * writeToNetwork below put on the wire.
 */
public record CustomPoofParticleOptions(Vector3f color) implements ParticleOptions {
    public static final Codec<CustomPoofParticleOptions> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(ExtraCodecs.VECTOR3F.fieldOf("color").forGetter(CustomPoofParticleOptions::color))
                    .apply(instance, CustomPoofParticleOptions::new));

    public static final Deserializer<CustomPoofParticleOptions> DESERIALIZER = new Deserializer<>() {
        @Override
        public CustomPoofParticleOptions fromCommand(ParticleType<CustomPoofParticleOptions> particleType, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            float red = reader.readFloat();
            reader.expect(' ');
            float green = reader.readFloat();
            reader.expect(' ');
            float blue = reader.readFloat();
            return new CustomPoofParticleOptions(new Vector3f(red, green, blue));
        }

        @Override
        public CustomPoofParticleOptions fromNetwork(ParticleType<CustomPoofParticleOptions> particleType, FriendlyByteBuf buf) {
            return new CustomPoofParticleOptions(new Vector3f(buf.readFloat(), buf.readFloat(), buf.readFloat()));
        }
    };

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.COLORED_POOF.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeFloat(this.color.x());
        buf.writeFloat(this.color.y());
        buf.writeFloat(this.color.z());
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %.2f %.2f %.2f",
                BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                this.color.x(), this.color.y(), this.color.z());
    }
}