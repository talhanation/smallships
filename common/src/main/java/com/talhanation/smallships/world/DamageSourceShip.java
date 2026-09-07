package com.talhanation.smallships.world;

import com.talhanation.smallships.SmallShipsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class DamageSourceShip {

    public static final ResourceKey<DamageType> DAMAGE_SHIP_TYPE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SmallShipsMod.MOD_ID, "ship_hit"));

    public static final ResourceKey<DamageType> DAMAGE_CANNON_TYPE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SmallShipsMod.MOD_ID, "cannon_ball"));

}
