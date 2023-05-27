package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ModMenuTypes {
    public static final MenuType<ShipContainerMenu> SHIP_CONTAINER = getMenuType("ship_container");

    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> getMenuType(String id) {
        throw new AssertionError();
    }

    public static @Nullable ShipContainerMenu extendedShipContainerMenuTypeSupplier(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        UUID shipUUID = buf.readUUID();
        ContainerShip containerShip = inventory.player.getLevel().getEntitiesOfClass(ContainerShip.class, inventory.player.getBoundingBoxForCulling()
                        .inflate(16.0D), ship -> ship.getUUID().equals(shipUUID))
                .stream()
                .filter(Entity::isAlive)
                .findAny().orElse(null);
        if (containerShip == null) return null;

        //check if clientside container size is equal to serverside container size
        if (containerShip.getContainerSize() != containerShip.getItemStacks().size()) containerShip.resizeContainer(containerShip.getContainerSize());

        return new ShipContainerMenu(ModMenuTypes.SHIP_CONTAINER, syncId, inventory, containerShip);
    }
}
