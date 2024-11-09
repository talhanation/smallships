package com.talhanation.smallships.world.particles.fabric;

import com.mojang.serialization.MapCodec;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class ModParticleTypesImpl extends ModParticleTypes {
    public static <T extends ParticleOptions> void register(String string, ParticleType<T> particleType, ParticleProvider<T> provider) {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, string), particleType);
        ParticleFactoryRegistry.getInstance().register(particleType, provider);
    }
}
