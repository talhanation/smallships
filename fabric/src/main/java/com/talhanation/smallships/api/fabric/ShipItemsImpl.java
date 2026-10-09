package com.talhanation.smallships.api.fabric;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

/**
 * @ExpectPlatform target for ShipItems#registerItem.
 *
 * Fabric registers straight away, in onInitialize - there is no register event
 * to wait for, so the item exists the moment this returns.
 */
public class ShipItemsImpl {

    public static Supplier<Item> registerItem(String modId, String id, Supplier<Item> item) {
        Item registered = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(modId, id), item.get());
        return () -> registered;
    }
}
