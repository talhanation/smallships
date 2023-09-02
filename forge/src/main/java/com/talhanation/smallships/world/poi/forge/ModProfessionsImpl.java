package com.talhanation.smallships.world.poi.forge;

import com.google.common.collect.ImmutableSet;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.poi.forge.ModPoisImpl;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModProfessionsImpl {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SmallShipsMod.MOD_ID);

    public static final RegistryObject<VillagerProfession> SHIPWRIGHT = makeProfession("shipwright", ModPoisImpl.POI_SHIPWRIGHT, SoundEvents.VILLAGER_WORK_FLETCHER);

    private static RegistryObject<VillagerProfession> makeProfession(String name, RegistryObject<PoiType> pointOfInterest, SoundEvent soundEvent) {
        return PROFESSIONS.register(name,
                () -> new VillagerProfession(name, poi -> poi.get().equals(pointOfInterest.get()),
                        poi -> poi.get().equals(pointOfInterest.get()), ImmutableSet.of(), ImmutableSet.of(),
                        soundEvent));
    }

    private static RegistryObject<VillagerProfession> makeProfession(String name, RegistryObject<PoiType> pointOfInterest) {
        return makeProfession(name, pointOfInterest, SoundEvents.VILLAGER_CELEBRATE);
    }
}
