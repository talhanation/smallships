package com.talhanation.smallships.world.particles.cannon;

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

public class DyedCannonShootOptions implements ParticleOptions {
    public static final Codec<DyedCannonShootOptions> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(Codec.STRING.fieldOf("dyeColor").forGetter(DyedCannonShootOptions::getDyeColorName))
                    .apply(instance, DyedCannonShootOptions::new));

    /**
     * The colour travels as its serialized name, exactly as before. An unknown
     * or empty name maps to a null DyeColor, which is a legal state here - the
     * particle then falls back to the undyed smoke.
     */
    public static final Deserializer<DyedCannonShootOptions> DESERIALIZER = new Deserializer<>() {
        @Override
        public DyedCannonShootOptions fromCommand(ParticleType<DyedCannonShootOptions> particleType, StringReader reader) throws CommandSyntaxException {
            reader.expect(' ');
            return new DyedCannonShootOptions(reader.readUnquotedString());
        }

        @Override
        public DyedCannonShootOptions fromNetwork(ParticleType<DyedCannonShootOptions> particleType, FriendlyByteBuf buf) {
            return new DyedCannonShootOptions(buf.readUtf());
        }
    };

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

    @Override
    public ParticleType<?> getType() {
        return ModParticleTypes.DYED_CANNON_SHOOT.get();
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buf) {
        buf.writeUtf(this.getDyeColorName());
    }

    @Override
    public String writeToString() {
        return String.format(Locale.ROOT, "%s %s",
                BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()), this.getDyeColorName());
    }
}