package com.talhanation.smallships.world.inventory.forge;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModMenuTypesImpl {
    private static final Map<String, RegistryObject<MenuType<? extends AbstractContainerMenu>>> entries = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends AbstractContainerMenu> MenuType<T> getMenuType(String id) {
        return (MenuType<T>) entries.get(id).get();
    }
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SmallshipsMod.MOD_ID);

    static {
        entries.put("ship_container", MENU_TYPES.register("ship_container",
                () -> IForgeMenuType.create(ModMenuTypes::extendedShipContainerMenuTypeSupplier)));
    }
}
