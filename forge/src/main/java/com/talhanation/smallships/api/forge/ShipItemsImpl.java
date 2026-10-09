package com.talhanation.smallships.api.forge;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @ExpectPlatform target for ShipItems#registerItem.
 *
 * One deferred register per namespace, hooked onto the event bus of the mod
 * that is being constructed when the first item of that namespace comes in.
 * That is the callers' own bus as long as ShipItems#register is called from
 * the mod constructor, which is the only place Forge still takes items.
 *
 * Called under the ShipItems lock, so the map needs no lock of its own.
 */
public class ShipItemsImpl {
    private static final Map<String, DeferredRegister<Item>> REGISTERS = new HashMap<>();

    public static Supplier<Item> registerItem(String modId, String id, Supplier<Item> item) {
        DeferredRegister<Item> register = REGISTERS.computeIfAbsent(modId, namespace -> {
            DeferredRegister<Item> created = DeferredRegister.create(ForgeRegistries.ITEMS, namespace);
            created.register(FMLJavaModLoadingContext.get().getModEventBus());
            return created;
        });
        return register.register(id, item);
    }
}
