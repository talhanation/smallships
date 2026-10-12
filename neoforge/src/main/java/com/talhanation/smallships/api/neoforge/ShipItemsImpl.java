package com.talhanation.smallships.api.neoforge;

import net.minecraft.world.item.Item;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @ExpectPlatform target for ShipItems#registerItem.
 *
 * One deferred register per namespace, hooked onto the event bus of the mod
 * that is being constructed when the first item of that namespace comes in.
 * That is the callers' own bus as long as ShipItems#register is called from
 * the mod constructor, which is the only place NeoForge still takes items.
 *
 * Called under the ShipItems lock, so the map needs no lock of its own.
 */
public class ShipItemsImpl {
    private static final Map<String, DeferredRegister.Items> REGISTERS = new HashMap<>();

    public static Supplier<Item> registerItem(String modId, String id, Supplier<Item> item) {
        DeferredRegister.Items register = REGISTERS.computeIfAbsent(modId, namespace -> {
            DeferredRegister.Items created = DeferredRegister.createItems(namespace);
            created.register(Objects.requireNonNull(ModLoadingContext.get().getActiveContainer().getEventBus()));
            return created;
        });
        return register.register(id, item);
    }
}