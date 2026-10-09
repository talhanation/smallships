package com.talhanation.smallships.world.item.fabric;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipItems;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"CodeBlock2Expr", "UnstableApiUsage"})
public class ModItemsImpl {
    private static final Map<String, Item> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id);
    }

    static {
        if (SmallShipsConfig.Client.smallshipsItemGroupEnable.get()) {
            //CUSTOM CREATIVE MENU TAB
            ResourceKey<CreativeModeTab> creativeModeTab = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(SmallShipsMod.MOD_ID, "creative_mode_tab"));

            CreativeModeTab customCreativeModeTab = FabricItemGroup.builder()
                    .title(Component.translatable(creativeModeTab.location().toString().replace(":", ".")))
                    .icon(() -> new ItemStack(ModItems.CANNON))
                    .displayItems((itemDisplayParameters, output) -> {
                        itemDisplayParameters.holders()
                                .lookup(Registries.ITEM)
                                .ifPresent(registryLookup -> registryLookup.listElementIds()
                                        .filter(itemResourceKey -> SmallShipsMod.MOD_ID.equals(itemResourceKey.location().getNamespace()))
                                        .map(BuiltInRegistries.ITEM::getOrThrow)
                                        // ships are added below, in their own order
                                        .filter(item -> !(item instanceof ShipItem))
                                        .forEach(output::accept)
                                );
                        // every ship item, the addons' included - they belong next
                        // to the ships of the main mod, not scattered over the
                        // vanilla tabs
                        ShipItems.getAll().forEach(output::accept);
                    })
                    .build();

            Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativeModeTab, customCreativeModeTab);
        } else {
            //VANILLA CREATIVE MENU TAB
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
                entries.addAfter(Items.CROSSBOW, ModItems.CANNON, ModItems.CANNON_BALL, ModItems.CHAINED_SHOT, ModItems.GRAPE_SHOT, ModItems.FINE_GRAIN_POWDER);
            });

            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
                List<Item> shipItems = new ArrayList<>();
                shipItems.add(ModItems.DOCKYARD);
                shipItems.add(ModItems.IRON_SCANTLINGS);
                shipItems.add(ModItems.COPPER_PLATING);
                shipItems.add(ModItems.COTTON_SAILS);
                shipItems.addAll(ShipItems.getAll());
                entries.addBefore(Items.RAIL, shipItems.toArray(Item[]::new));
            });
        }

        register("cannon", new CannonItem((new Item.Properties()).stacksTo(1)));
        register("cannon_ball", new CannonBallItem((new Item.Properties()).stacksTo(16)));
        register("chained_shot", new CannonBallItem(CannonBallItem.Type.CHAINED, (new Item.Properties()).stacksTo(16)));
        register("grape_shot", new CannonBallItem(CannonBallItem.Type.GRAPE, (new Item.Properties()).stacksTo(16)));
        register("fine_grain_powder", new Item(new Item.Properties()));

        register("dockyard", new BlockItem(com.talhanation.smallships.world.block.ModBlocks.DOCKYARD, new Item.Properties()));

        register("copper_plating", new Item(new Item.Properties().stacksTo(1)));
        register("cotton_sails", new Item(new Item.Properties().stacksTo(1)));
        register("iron_scantlings", new Item(new Item.Properties().stacksTo(1)));

        // the ship items are not registered here: they go through ShipItems
        // like every addon ship does, see ModShipItems
    }

    private static void register(String id, Item item) {
        entries.put(id, register(new ResourceLocation(SmallShipsMod.MOD_ID, id), item));
    }

    private static Item register(ResourceLocation id, Item item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, blockItem);
        }

        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }
}
