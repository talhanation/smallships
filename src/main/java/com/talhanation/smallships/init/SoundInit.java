package com.talhanation.smallships.init;

import com.talhanation.smallships.Main;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS =  DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);

    public static final RegistryObject<SoundEvent> SHIP_SAIL_0 = SOUNDS.register("sail_0",
            () -> new SoundEvent(new ResourceLocation(Main.MOD_ID,"sail_0")));

    public static final RegistryObject<SoundEvent> SHIP_SAIL_1 = SOUNDS.register("sail_1",
            () -> new SoundEvent(new ResourceLocation(Main.MOD_ID,"sail_1")));

    public static final RegistryObject<SoundEvent> CANNON_SHOOT = SOUNDS.register("ship_cannon_shoot",
            () -> new SoundEvent(new ResourceLocation(Main.MOD_ID,"ship_cannon_shoot")));

/*
    public static final RegistryObject<SoundEvent> SHIP_AMBIENT = SOUNDS.register("shipambient",
            () -> new SoundEvent(new ResourceLocation(Main.MOD_ID,"shipambient")));
*/
}
