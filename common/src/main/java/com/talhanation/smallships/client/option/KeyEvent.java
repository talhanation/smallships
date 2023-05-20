package com.talhanation.smallships.client.option;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class KeyEvent {

    static boolean wasPressedSailKey;
    public static void onKeyInput(Minecraft client) {
        Player player = client.player;
        if (player == null) return;
        boolean pressedSailKey = ModGameOptions.SAIL_KEY.isDown();
        boolean pressedJumpKey = client.options.keyJump.isDown();
        if (player.getVehicle() instanceof Ship ship) {
            if (player.equals(ship.getDriver())) { // is driver

                if(ship instanceof Sailable){
                    if (pressedSailKey) {
                        ModPackets.clientSendPacket(player, ModPackets.serverToggleShipSail.apply());
                    }
                }

                if (ship instanceof Cannonable cannonable){
                    if(pressedJumpKey)
                        ModPackets.clientSendPacket(player, ModPackets.serverShootShipCannon.apply(true));
                    else
                    if (!cannonable.self().isCannonKeyPressed())
                        ModPackets.clientSendPacket(player, ModPackets.serverShootShipCannon.apply(false));
                }

            }
        }
    }
}
