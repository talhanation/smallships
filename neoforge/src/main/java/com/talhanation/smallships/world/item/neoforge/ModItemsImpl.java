package com.talhanation.smallships.world.item.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
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
        register("sail", () -> new SailItem((new Item.Properties()).stacksTo(16)));

        register("cannon", () -> new CannonItem((new Item.Properties()).stacksTo(1)));
        register("cannon_ball", () -> new CannonBallItem((new Item.Properties()).stacksTo(16)));

        for (Boat.Type type: Boat.Type.values()) {
            String name = type.getName().replaceAll("[^a-z0-9_.-]", "_");
            register(name + "_" + CogEntity.ID,  () -> new CogItem(type, new Item.Properties().stacksTo(1)));
            register(name + "_" + BriggEntity.ID,  () -> new BriggItem(type, new Item.Properties().stacksTo(1)));
            register(name + "_" + GalleyEntity.ID,  () -> new GalleyItem(type, new Item.Properties().stacksTo(1)));
            register(name + "_" + DrakkarEntity.ID,  () -> new DrakkarItem(type, new Item.Properties().stacksTo(1)));
        }
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }
}
