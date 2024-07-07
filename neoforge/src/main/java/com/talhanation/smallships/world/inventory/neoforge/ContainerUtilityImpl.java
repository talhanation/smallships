package com.talhanation.smallships.world.inventory.neoforge;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;

public class ContainerUtilityImpl {
    public static void openShipMenu(Player player, ContainerShip containerShip) {
        player.openMenu(new MenuProvider() {
            @Override
            public @NotNull Component getDisplayName() {
                return containerShip.getName();
            }

            @Override
            public AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
                return new ShipContainerMenu(ModMenuTypes.SHIP_CONTAINER, syncId, inventory, containerShip);
            }
            }, buf -> buf.writeUUID(containerShip.getUUID()));
    }
}
