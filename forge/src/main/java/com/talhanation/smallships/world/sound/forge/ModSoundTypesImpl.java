package com.talhanation.smallships.world.sound.forge;

import com.talhanation.smallships.SmallshipsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModSoundTypesImpl {
    private static final Map<String, RegistryObject<SoundEvent>> entries = new HashMap<>();

    public static SoundEvent getSoundType(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =  DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SmallshipsMod.MOD_ID);

    static {
        entries.put("sail_move", register("sail_move"));
        entries.put("sail_pull", register("sail_pull"));
        entries.put("cannon_shoot", register("cannon_shoot"));
    }

    private static RegistryObject<SoundEvent> register (String id) {
        return SOUND_EVENTS.register(id, () -> new SoundEvent(new ResourceLocation(SmallshipsMod.MOD_ID, id)));
    }
}
