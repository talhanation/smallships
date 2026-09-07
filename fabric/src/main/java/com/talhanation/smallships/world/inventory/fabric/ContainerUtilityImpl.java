package com.talhanation.smallships.world.inventory.fabric;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.GroundCannonContainerMenu;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;

/**
 * 1.20.1 has no typed screen opening data - the factory writes into a raw
 * FriendlyByteBuf and the ExtendedScreenHandlerType reads it back on the other
 * side, so the UUID travels by hand instead of through a StreamCodec.
 */
public class ContainerUtilityImpl {
    public static void openShipMenu(Player player, ContainerShip containerShip) {
        player.openMenu(new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf buf) {
                buf.writeUUID(containerShip.getUUID());
            }

            @Override
            public @NotNull AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
                return new ShipContainerMenu(ModMenuTypes.SHIP_CONTAINER, syncId, inventory, containerShip);
            }

            @Override
            public @NotNull Component getDisplayName() {
                return containerShip.getName();
            }
        });
    }

    public static void openCannonMenu(Player player, GroundCannonEntity groundCannonEntity) {
        player.openMenu(new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf buf) {
                buf.writeUUID(groundCannonEntity.getUUID());
            }

            @Override
            public @NotNull AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
                return new GroundCannonContainerMenu(ModMenuTypes.CANNON_CONTAINER, syncId, groundCannonEntity, inventory);
            }

            @Override
            public @NotNull Component getDisplayName() {
                return groundCannonEntity.getName();
            }
        });
    }
}