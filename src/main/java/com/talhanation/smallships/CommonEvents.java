package com.talhanation.smallships;

import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import com.talhanation.smallships.network.MessageOpenGuiSecond;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.NetworkHooks;

public class CommonEvents {

    public static void openShipGUI(PlayerEntity player, int startSlot, AbstractInventoryEntity invEntity) {
        if (player instanceof ServerPlayerEntity) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return invEntity.getName();
                }

                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    Main.LOGGER.debug("Common Event done");
                    return new BasicShipContainer(i, invEntity, playerInventory, startSlot);
                }
            }, packetBuffer -> {packetBuffer.writeUUID(invEntity.getUUID());
            });
        } else {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGuiSecond(player, invEntity));
        }
    }


}
