package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ModMenuTypes {
    public static final MenuType<ShipContainerMenu> SHIP_CONTAINER = getMenuType("ship_container");
    public static final MenuType<GroundCannonContainerMenu> CANNON_CONTAINER = getMenuType("cannon_container");
    public static final MenuType<DockyardMenu> DOCKYARD = getMenuType("dockyard");
    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> getMenuType(String id) {
        throw new AssertionError();
    }

    public static @Nullable ShipContainerMenu extendedShipContainerMenuTypeSupplier(int syncId, Inventory inventory, UUID shipUUID) {
        ContainerShip containerShip = inventory.player.level().getEntitiesOfClass(ContainerShip.class, inventory.player.getBoundingBoxForCulling()
                        .inflate(16.0D), ship -> ship.getUUID().equals(shipUUID))
                .stream()
                .filter(Entity::isAlive)
                .findAny().orElse(null);
        if (containerShip == null) return null;

        //check if clientside container size is equal to serverside container size
        if (containerShip.getContainerSize() != containerShip.getItemStacks().size()) containerShip.resizeContainer(containerShip.getContainerSize());

        return new ShipContainerMenu(ModMenuTypes.SHIP_CONTAINER, syncId, inventory, containerShip);
    }

    public static @Nullable GroundCannonContainerMenu groundCannonContainerMenuTypeSupplier(int syncId, Inventory inventory, UUID uuid) {
        GroundCannonEntity groundCannon = inventory.player.level().getEntitiesOfClass(GroundCannonEntity.class, inventory.player.getBoundingBoxForCulling()
                        .inflate(16.0D), entity -> entity.getUUID().equals(uuid))
                .stream()
                .filter(Entity::isAlive)
                .findAny().orElse(null);


        //check if clientside container size is equal to serverside container size
        //if (groundCannon.getContainer() != containerShip.getItemStacks().size()) containerShip.resizeContainer(containerShip.getContainerSize());

        return new GroundCannonContainerMenu(ModMenuTypes.CANNON_CONTAINER, syncId, groundCannon, inventory);
    }
}
