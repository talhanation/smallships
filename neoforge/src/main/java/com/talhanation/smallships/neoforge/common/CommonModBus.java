package com.talhanation.smallships.neoforge.common;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.neoforge.SmallshipsModNeoForge;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.item.neoforge.ModItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

import java.util.function.Function;

import static com.talhanation.smallships.network.neoforge.ModPacketsImpl.clientboundPackets;
import static com.talhanation.smallships.network.neoforge.ModPacketsImpl.serverboundPackets;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModBus {
    @SubscribeEvent
    static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(ModPackets::registerPackets);
    }

    @SubscribeEvent
    static void initRegisterConfigs(ModConfigEvent event) {
        ModConfig config = event.getConfig();
        SmallShipsConfig.updateConfig(new SmallShipsConfig.ModConfigWrapper(config.getType().toString(), config.getFullPath(), config.getFileName(), config.getConfigData()));
    }

    @SubscribeEvent
    public static void initRegisterCreativeMenuTabs(BuildCreativeModeTabContentsEvent event) {
        Function<ResourceKey<CreativeModeTab>, CreativeModeTab> getCreativeModeTab = BuiltInRegistries.CREATIVE_MODE_TAB::get;
        if (SmallshipsModNeoForge.hasCustomItemGroup) {
            //CUSTOM CREATIVE MENU TAB
            if (getCreativeModeTab.apply(ModItemsImpl.customCreativeModeTab.getKey()).equals(event.getTab())) {
                ModItemsImpl.ITEMS.getEntries().forEach(key -> event.accept(key.get()));
            }
        } else {
            //VANILLA CREATIVE MENU TAB
            if (getCreativeModeTab.apply(CreativeModeTabs.COLORED_BLOCKS).equals(event.getTab())) {
                event.getEntries().putBefore(new ItemStack(Items.WHITE_BANNER), new ItemStack(ModItems.SAIL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.COMBAT).equals(event.getTab())) {
                event.getEntries().putAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON_BALL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.TOOLS_AND_UTILITIES).equals(event.getTab())) {
                for (Boat.Type type: Boat.Type.values()) {
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.COG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.BRIGG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.GALLEY_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.getEntries().putBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.DRAKKAR_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                }
            }
        }
    }

    @SubscribeEvent
    public static void initRegisterPackets(RegisterPayloadHandlerEvent event) {
        IPayloadRegistrar registrar = event.registrar(SmallShipsMod.MOD_ID);

        serverboundPackets.forEach(packet -> {
            registrar.play(packet.getLeft(), packet.getMiddle(), handler -> handler.server(packet.getRight()));
        });

        clientboundPackets.forEach(packet -> {
            registrar.play(packet.getLeft(), packet.getMiddle(), handler -> handler.client(packet.getRight()));
        });
    }
}
