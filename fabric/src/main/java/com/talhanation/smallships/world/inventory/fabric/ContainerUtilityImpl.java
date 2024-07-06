package com.talhanation.smallships.world.inventory.fabric;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ModMenuTypes;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ContainerUtilityImpl {
    public static void openShipMenu(Player player, ContainerShip containerShip) {
        player.openMenu(new ExtendedScreenHandlerFactory<ContainerUtilityImpl.ContainerMenuData>() {
            @Override
            public ContainerUtilityImpl.ContainerMenuData getScreenOpeningData(ServerPlayer player) {
                return new ContainerUtilityImpl.ContainerMenuData(containerShip.getUUID());
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

    public record ContainerMenuData(UUID ship) {
        public static final StreamCodec<RegistryFriendlyByteBuf, ContainerMenuData> PACKET_CODEC = StreamCodec.composite(UUIDUtil.STREAM_CODEC, ContainerMenuData::ship, ContainerMenuData::new);
    }
}
