package com.talhanation.smallships.world.item.forge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
        register("sail", () -> new SailItem((new Item.Properties()).stacksTo(16)));

        register("cannon", () -> new CannonItem((new Item.Properties()).stacksTo(1)));
        register("cannon_ball", () -> new CannonBallItem((new Item.Properties()).stacksTo(16)));

        for (Boat.Type type: Boat.Type.values()) {
            register(new ResourceLocation(type.getName()).getPath() + "_" + CogEntity.ID,  () -> new CogItem(type, new Item.Properties().stacksTo(1)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + BriggEntity.ID,  () -> new BriggItem(type, new Item.Properties().stacksTo(1)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + GalleyEntity.ID,  () -> new GalleyItem(type, new Item.Properties().stacksTo(1)));
            register(new ResourceLocation(type.getName()).getPath() + "_" + DrakkarEntity.ID,  () -> new DrakkarItem(type, new Item.Properties().stacksTo(1)));
        }
    }

    private static void register(String id, Supplier<Item> itemSupplier) {
        entries.put(id, ITEMS.register(id, itemSupplier));
    }
}
