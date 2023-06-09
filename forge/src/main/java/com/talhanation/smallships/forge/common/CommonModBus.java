package com.talhanation.smallships.forge.common;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModBus {
    public CommonModBus() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::initRegisterConfigs);
    }

    @SubscribeEvent
    public void initRegisterConfigs(ModConfigEvent event) {
        SmallShipsConfig.updateConfig(event.getConfig());
    }

    @SubscribeEvent
    public static void initRegisterCreativeMenuTabs(BuildCreativeModeTabContentsEvent event) {
        if (SmallShipsConfig.Common.smallshipsItemGroupEnable.get()) {
            ModItemsImpl.ITEMS.getEntries().forEach(key -> event.accept(key.get()));
        } else {
            Function<ResourceKey<CreativeModeTab>, CreativeModeTab> getCreativeModeTab = BuiltInRegistries.CREATIVE_MODE_TAB::get;
            if (getCreativeModeTab.apply(CreativeModeTabs.COLORED_BLOCKS).equals(event.getTab())) {
                event.accept(ModItems.SAIL);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.COMBAT).equals(event.getTab())) {
                event.accept(ModItems.CANNON);
                event.accept(ModItems.CANNON_BALL);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.TOOLS_AND_UTILITIES).equals(event.getTab())) {
                for (Boat.Type type: Boat.Type.values()) {
                    event.accept(ModItems.COG_ITEMS.get(type));
                    event.accept(ModItems.BRIGG_ITEMS.get(type));
                    event.accept(ModItems.GALLEY_ITEMS.get(type));
                }
            }
        }
    }
}
