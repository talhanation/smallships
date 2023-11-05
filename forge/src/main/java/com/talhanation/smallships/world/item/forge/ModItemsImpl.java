package com.talhanation.smallships.world.item.forge;

import com.electronwill.nightconfig.toml.TomlFormat;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItemsImpl {
    private static final Map<String, RegistryObject<Item>> entries = new HashMap<>();

    public static Item getItem(String id) {
        return entries.get(id).get();
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SmallShipsMod.MOD_ID);

    static {
        final CreativeModeTab CUSTOM_ITEM_GROUP;
        //Because Forge is not developer-friendly, and they don't want early initializations of configs for whatever reason, we will have to parse the file ourselves (thankfully the Forge Config Port for Fabric does early initializations and therefore this workaround is not needed there)
        boolean hasCustomItemGroup = TomlFormat.instance().createParser().parse(Path.of("config", "smallships-client.toml"), (file, configFormat) -> false).getOrElse(Arrays.asList("General", "smallshipsItemGroupEnable"), () -> false);
        if (hasCustomItemGroup) {
            CUSTOM_ITEM_GROUP = new CreativeModeTab("smallships.smallships") {
                @Override
                public @NotNull ItemStack makeIcon() {
                    return new ItemStack(ModItems.CANNON);
                }
            };
        } else {
            CUSTOM_ITEM_GROUP = null;
        }

        register("sail", () -> new SailItem((new Item.Properties()).stacksTo(16).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_MISC)));

        register("cannon", () -> new CannonItem((new Item.Properties()).stacksTo(1).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_COMBAT)));
        register("cannon_ball", () -> new CannonBallItem((new Item.Properties()).stacksTo(16).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_COMBAT)));

        for (Boat.Type type: Boat.Type.values()) {
            register(new ResourceLocation(type.getName()).getPath() + "_" + CogEntity.ID,  () -> new CogItem(type, new Item.Properties().stacksTo(1).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_TRANSPORTATION)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + BriggEntity.ID,  () -> new BriggItem(type, new Item.Properties().stacksTo(1).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_TRANSPORTATION)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + GalleyEntity.ID,  () -> new GalleyItem(type, new Item.Properties().stacksTo(1).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_TRANSPORTATION)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + DrakkarEntity.ID,  () -> new DrakkarItem(type, new Item.Properties().stacksTo(1).tab(CUSTOM_ITEM_GROUP != null? CUSTOM_ITEM_GROUP : CreativeModeTab.TAB_TRANSPORTATION)));

        }
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }
}
