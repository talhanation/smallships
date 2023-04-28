package com.talhanation.smallships.world.sound;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.sounds.SoundEvent;

public class ModSoundTypes {
    public static final SoundEvent SAIL_MOVE = getSoundType("sail_move");
    public static final SoundEvent SAIL_PULL = getSoundType("sail_pull");
    public static final SoundEvent CANNON_SHOOT = getSoundType("cannon_shoot");
    public static final SoundEvent SHIP_IMPACT = getSoundType("ship_impact");

    @ExpectPlatform
    public static SoundEvent getSoundType(String id) {
        throw new AssertionError();
    }
}
