package com.talhanation.smallships;

import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class InventoryEvents {

    public static void openShipGUI(Player player, AbstractInventoryEntity invEntity, int startSlot) {
        if (startSlot == 0){
            invEntity.setInvPage(1);
        }
        if (player instanceof ServerPlayer) {
            NetworkHooks.openGui((ServerPlayer) player, new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return invEntity.getName();
                }

                @Override
                public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
                    return new BasicShipContainer(i, invEntity, playerInventory, startSlot);
                }
            }, packetBuffer -> {packetBuffer.writeUUID(invEntity.getUUID());
            });
        } else {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGui(player, invEntity, startSlot));
        }
    }


}
