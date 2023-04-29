package com.talhanation.smallships.world.sound.fabric;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.HashMap;
import java.util.Map;

public class ModSoundTypesImpl {
    private static final Map<String, SoundEvent> entries = new HashMap<>();

    public static SoundEvent getSoundType(String id) {
        return entries.get(id);
    }

    static {
        entries.put("sail_move", register("sail_move"));
        entries.put("sail_pull", register("sail_pull"));
        entries.put("cannon_shot", register("cannon_shot"));
    }

    private static SoundEvent register (String id) {
        ResourceLocation location = new ResourceLocation(SmallShipsMod.MOD_ID, id);
        return Registry.register(Registry.SOUND_EVENT, location, new SoundEvent(location));
    }
}
