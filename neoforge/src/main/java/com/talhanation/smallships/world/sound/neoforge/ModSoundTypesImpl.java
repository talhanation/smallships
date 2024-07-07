package com.talhanation.smallships.world.sound.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class ModSoundTypesImpl {
    private static final Map<String, DeferredHolder<SoundEvent, SoundEvent>> entries = new HashMap<>();

    public static SoundEvent getSoundType(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =  DeferredRegister.create(Registries.SOUND_EVENT, SmallShipsMod.MOD_ID);

    static {
        entries.put("sail_move", register("sail_move"));
        entries.put("sail_pull", register("sail_pull"));
        entries.put("cannon_shot", register("cannon_shot"));
        entries.put("ship_hit", register("ship_hit"));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> register (String id) {
        return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, id)));
    }
}
