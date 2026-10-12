package com.talhanation.smallships.world.item.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.block.ModBlocks;
import com.talhanation.smallships.world.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItemsImpl {
    private static final Map<String, Supplier<Item>> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SmallShipsMod.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SmallShipsMod.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> customCreativeModeTab = CREATIVE_MODE_TABS.register(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "creative_mode_tab").toString().replace(":", "."), () -> CreativeModeTab.builder()
            .title(Component.translatable(ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, "creative_mode_tab").toString().replace(":", ".")))
            .icon(() -> new ItemStack(ModItems.CANNON))
            .build());

    static {
        register("cannon", () -> new CannonItem((new Item.Properties()).stacksTo(1)));
        register("cannon_ball", () -> new CannonBallItem((new Item.Properties()).stacksTo(16)));
        register("chained_shot", () -> new CannonBallItem(CannonBallItem.Type.CHAINED, (new Item.Properties()).stacksTo(16)));
        register("grape_shot", () -> new CannonBallItem(CannonBallItem.Type.GRAPE, (new Item.Properties()).stacksTo(16)));
        register("fine_grain_powder", () -> new Item(new Item.Properties()));

        // the block item stays plain here - neoforge takes the dockyard item
        // renderer through RegisterClientExtensionsEvent in ClientModBus
        register("dockyard", () -> new BlockItem(ModBlocks.DOCKYARD, new Item.Properties()));

        register("copper_plating", () -> new Item(new Item.Properties().stacksTo(1)));
        register("cotton_sails", () -> new Item(new Item.Properties().stacksTo(1)));
        register("iron_scantlings", () -> new Item(new Item.Properties().stacksTo(1)));

        // the ship items are not registered here: they go through ShipItems
        // like every addon ship does, see ModShipItems
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }
}