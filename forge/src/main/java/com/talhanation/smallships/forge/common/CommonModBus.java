package com.talhanation.smallships.forge.common;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.item.forge.ModItemsImpl;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.nio.file.Path;
import java.util.Arrays;

@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModBus {
    @SubscribeEvent
    static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(ModPackets::registerPackets);
    }

    @SubscribeEvent
    static void initRegisterConfigs(ModConfigEvent event) {
        SmallShipsConfig.updateConfig(event.getConfig());
    }

    private static final boolean hasCustomItemGroup = TomlFormat.instance().createParser().parse(Path.of("config", "smallships-client.toml"), (file, configFormat) -> false).getOrElse(Arrays.asList("General", "smallshipsItemGroupEnable"), () -> false);         //Forge doesn't do early config initialization. Will have to parse the config ourselves.
    private static CreativeModeTab CUSTOM_CREATIVE_MENU_TAB;
    @SubscribeEvent
    static void initRegisterCreativeMenuTabs(CreativeModeTabEvent.Register event) {
        if (hasCustomItemGroup) {
            //CUSTOM CREATIVE MENU TAB
            CUSTOM_CREATIVE_MENU_TAB = event.registerCreativeModeTab(new ResourceLocation(SmallShipsMod.MOD_ID, "creative_mode_tab"), builder ->
                    builder.title(Component.translatable(new ResourceLocation(SmallShipsMod.MOD_ID, "creative_mode_tab").toString().replace(":", ".")))
                            .icon(() -> new ItemStack(ModItems.CANNON))
            );
        }
    }

    @SubscribeEvent
    static void initBuildCreativeMenuTabs(CreativeModeTabEvent.BuildContents event) {
        if (hasCustomItemGroup) {
            //CUSTOM CREATIVE MENU TAB
            if (CUSTOM_CREATIVE_MENU_TAB.equals(event.getTab())) {
                ModItemsImpl.ITEMS.getEntries().forEach(key -> event.accept(key.get()));
            }
        } else {
            //VANILLA CREATIVE MENU TAB
            if (CreativeModeTabs.COLORED_BLOCKS.equals(event.getTab())) {
                event.getEntries().putBefore(new ItemStack(Items.WHITE_BANNER), new ItemStack(ModItems.SAIL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (CreativeModeTabs.COMBAT.equals(event.getTab())) {
                event.getEntries().putAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON_BALL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (CreativeModeTabs.TOOLS_AND_UTILITIES.equals(event.getTab())) {
                for (Boat.Type type: Boat.Type.values()) {
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.COG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.BRIGG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.GALLEY_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.DRAKKAR_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                }
            }
        }
    }
}
