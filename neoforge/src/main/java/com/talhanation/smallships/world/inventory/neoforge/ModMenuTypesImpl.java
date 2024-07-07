package com.talhanation.smallships.world.inventory.neoforge;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ModMenuTypesImpl {
    private static final Map<String, DeferredHolder<MenuType<?>, MenuType<? extends AbstractContainerMenu>>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends AbstractContainerMenu> MenuType<T> getMenuType(String id) {
        return (MenuType<T>) entries.get(id).get();
    }
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, SmallShipsMod.MOD_ID);

    static {
        entries.put("ship_container", MENU_TYPES.register("ship_container",
                () -> IMenuTypeExtension.create((IContainerFactory<AbstractContainerMenu>) (i, inv, buf) ->
                        Objects.requireNonNull(ModMenuTypes.extendedShipContainerMenuTypeSupplier(i, inv, buf.readUUID()))
                ))
        );
    }
}
