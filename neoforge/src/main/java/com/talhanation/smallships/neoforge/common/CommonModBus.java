package com.talhanation.smallships.neoforge.common;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.toml.TomlFormat;
import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.neoforge.SmallshipsModNeoForge;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.item.neoforge.ModItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.function.Function;

import static com.talhanation.smallships.network.neoforge.ModPacketsImpl.clientboundPackets;
import static com.talhanation.smallships.network.neoforge.ModPacketsImpl.serverboundPackets;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = SmallShipsMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonModBus {
    @SubscribeEvent
    static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(ModPackets::registerPackets);
    }

    @SubscribeEvent
    static void initRegisterConfigs(ModConfigEvent event) {
        ModConfig config = event.getConfig();
        CommentedConfig commentedConfig = TomlFormat.instance().createParser().parse(config.getFullPath(), (file, configFormat) -> false);
        SmallShipsConfig.updateConfig(new SmallShipsConfig.ModConfigWrapper(config.getType().toString(), config.getFullPath(), config.getFileName(), commentedConfig));
        config.getSpec().correct(commentedConfig); // Probably does not work as expected
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
                event.insertBefore(new ItemStack(Items.WHITE_BANNER), new ItemStack(ModItems.SAIL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.COMBAT).equals(event.getTab())) {
                event.insertAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON_BALL), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.insertAfter(new ItemStack(Items.CROSSBOW), new ItemStack(ModItems.CANNON), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else if (getCreativeModeTab.apply(CreativeModeTabs.TOOLS_AND_UTILITIES).equals(event.getTab())) {
                for (Boat.Type type: Boat.Type.values()) {
                    event.insertBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.COG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.insertBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.BRIGG_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.insertBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.GALLEY_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    event.insertBefore(new ItemStack(Items.RAIL), new ItemStack(ModItems.DRAKKAR_ITEMS.get(type)), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                }
            }
        }
    }

    @SubscribeEvent
    public static void initRegisterPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");

        for (Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>> packet : serverboundPackets) {
            registrar.playToServer(packet.getFirst(), packet.getSecond(), (ModPacket payload, IPayloadContext context) -> payload.handler(context.player()));
        }

        for (Pair<CustomPacketPayload.Type<ModPacket>, StreamCodec<RegistryFriendlyByteBuf, ModPacket>> packet : clientboundPackets) {
            registrar.playToClient(packet.getFirst(), packet.getSecond(), (ModPacket payload, IPayloadContext context) -> payload.handler(context.player()));
        }
    }
}
