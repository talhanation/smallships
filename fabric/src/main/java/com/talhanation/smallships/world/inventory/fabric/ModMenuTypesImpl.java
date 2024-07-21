package com.talhanation.smallships.world.inventory.fabric;

import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SameParameterValue")
public class ModMenuTypesImpl {
    private static final Map<String, MenuType<? extends AbstractContainerMenu>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends AbstractContainerMenu> MenuType<T> getMenuType(String id) {
        return (MenuType<T>) entries.get(id);
    }

    private static <T extends AbstractContainerMenu> MenuType<T> register(String id, MenuType<T> menuType) {
        return Registry.register(BuiltInRegistries.MENU, id, menuType);
    }

    static {
        entries.put("ship_container", register("ship_container",
                new ExtendedScreenHandlerType<AbstractContainerMenu>((syncId, inventory, buf) -> ModMenuTypes.extendedShipContainerMenuTypeSupplier(syncId, inventory, buf.readUUID()))));
    }
}
