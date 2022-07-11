package com.talhanation.smallships;

import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.inventory.BasicShipContainer;
import com.talhanation.smallships.network.MessageOpenGui;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkHooks;

@SubscribeEvent
public class CommonEvents {








    public static void openShipGUI(PlayerEntity player, int startSlot, ) {
        if (player instanceof ServerPlayerEntity) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new INamedContainerProvider() {
                @Override
                public ITextComponent getDisplayName() {
                    return getName();
                }

                @Override
                public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    return new BasicShipContainer(i, CogEntity.this, playerInventory, startSlot);
                }
            }, packetBuffer -> {packetBuffer.writeUUID(getUUID());
            });
        } else {
            Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenGui(player));
        }
    }


}
