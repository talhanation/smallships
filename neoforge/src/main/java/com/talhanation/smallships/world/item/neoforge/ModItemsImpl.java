package com.talhanation.smallships.world.item.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.*;
import com.talhanation.smallships.world.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
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
        register("sail", (prop) -> new SailItem(prop.stacksTo(16)));

        register("cannon", (prop) -> new CannonItem(prop.stacksTo(1)));
        register("cannon_ball", (prop) -> new CannonBallItem(prop.stacksTo(16)));

        for (Ship.Type type: Ship.Type.values()) {
            String name = type.getName().replaceAll("[^a-z0-9_.-]", "_");
            register(name + "_" + CogEntity.ID,  (prop) -> new CogItem(type, prop.stacksTo(1)));
            register(name + "_" + BriggEntity.ID,  (prop) -> new BriggItem(type, prop.stacksTo(1)));
            register(name + "_" + GalleyEntity.ID,  (prop) -> new GalleyItem(type, prop.stacksTo(1)));
            register(name + "_" + DrakkarEntity.ID,  (prop) -> new DrakkarItem(type, prop.stacksTo(1)));
        }
    }

    private static void register(String id, Function<Item.Properties, Item> itemSupplier) {
        entries.put(id, ITEMS.registerItem(id, itemSupplier));
    }
}
