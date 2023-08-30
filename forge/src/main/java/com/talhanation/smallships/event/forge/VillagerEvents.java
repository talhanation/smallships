package com.talhanation.smallships.event.forge;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.world.entity.ai.WorkAtShipwrightTable;
import com.talhanation.smallships.world.poi.forge.ModProfessionsImpl;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@SuppressWarnings({"unchecked", "rawtypes"})
public class VillagerEvents {

    private static Pair<Integer, Behavior<LivingEntity>> getMinimalLookBehavior() {
        return Pair.of(5, new RunOne(ImmutableList.of(Pair.of(new SetEntityLookTarget(EntityType.VILLAGER, 8.0F), 2), Pair.of(new SetEntityLookTarget(EntityType.PLAYER, 8.0F), 2), Pair.of(new DoNothing(30, 60), 8))));
    }

    private ImmutableList<Pair<Integer, ? extends Behavior<? super Villager>>> getCustomWorkPackage(VillagerProfession profession, float f) {
        Object workAtPoi;
        if (profession == VillagerProfession.FARMER) {
            workAtPoi = new WorkAtComposter();
        } else if (profession == ModProfessionsImpl.SHIPWRIGHT.get()) {
            workAtPoi = new WorkAtShipwrightTable();
        } else {
            workAtPoi = new WorkAtPoi();
        }

        return ImmutableList.of(getMinimalLookBehavior(), Pair.of(5, new RunOne(ImmutableList.of(Pair.of(workAtPoi, 7), Pair.of(new StrollAroundPoi(MemoryModuleType.JOB_SITE, 0.4F, 4), 2), Pair.of(new StrollToPoi(MemoryModuleType.JOB_SITE, 0.4F, 1, 10), 5), Pair.of(new StrollToPoiList(MemoryModuleType.SECONDARY_JOB_SITE, f, 1, 6, MemoryModuleType.JOB_SITE), 5), Pair.of(new HarvestFarmland(), profession == VillagerProfession.FARMER ? 2 : 5), Pair.of(new UseBonemeal(), profession == VillagerProfession.FARMER ? 4 : 7)))), Pair.of(10, new ShowTradesToPlayer(400, 1600)), Pair.of(10, new SetLookAndInteract(EntityType.PLAYER, 4)), Pair.of(2, new SetWalkTargetFromBlockMemory(MemoryModuleType.JOB_SITE, f, 9, 100, 1200)), Pair.of(3, new GiveGiftToHero(100)), Pair.of(99, new UpdateActivityFromSchedule()));
    }

    private void registerShipwrightBrainGoals(Villager villager) {
        Brain<Villager> brain = villager.getBrain();

        VillagerProfession profession = villager.getVillagerData().getProfession();
        brain.addActivityWithConditions(Activity.WORK, this.getCustomWorkPackage(profession, 0.5f), ImmutableSet.of(Pair.of(MemoryModuleType.JOB_SITE, MemoryStatus.VALUE_PRESENT)));
    }

    @SubscribeEvent
    public void onVillagerJoinWorld(EntityJoinLevelEvent entityJoinLevelEvent) {
        Entity entity = entityJoinLevelEvent.getEntity();
        if (entity instanceof Villager villager) {
            registerShipwrightBrainGoals(villager);
        }
    }
}
