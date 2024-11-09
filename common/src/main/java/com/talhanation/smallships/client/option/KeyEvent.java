package com.talhanation.smallships.client.option;

import com.mojang.blaze3d.platform.InputConstants;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundShootShipCannonPacket;
import com.talhanation.smallships.network.packet.ServerboundToggleShipSailPacket;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class KeyEvent {
    static boolean wasPressedSailKey = false;

    public static void onKeyInput(int key, int scanCode, int action, int modifiers) {
        final Player player;
        if ((player = Minecraft.getInstance().player) == null) return;

        if (player.getVehicle() instanceof GroundCannonEntity cannon) {
            if (Minecraft.getInstance().options.keyJump.isDown()) {
                cannon.trigger();
            } else if (ModGameOptions.ENTER_CANNON_BARREL_KEY.matches(key, scanCode) && action == InputConstants.PRESS) {
                cannon.putEntityIntoBarrel(player);
            }
        }
    }

    public static void onKeyInput(Minecraft client) {
        Player player = client.player;
        if (player == null) return;
        boolean pressedSailKey = ModGameOptions.SAIL_KEY.consumeClick();
        boolean pressedEnterKey = ModGameOptions.ENTER_CANNON_BARREL_KEY.consumeClick();
        boolean pressedJumpKey = client.options.keyJump.isDown();
        if (player.getVehicle() instanceof Ship ship) {
            if (player.equals(ship.getDriver())) { // is driver
                if(ship instanceof Sailable){
                    if (pressedSailKey && !wasPressedSailKey) {
                        ModPackets.clientSendPacket(new ServerboundToggleShipSailPacket());
                        wasPressedSailKey = true;
                    }
                    else
                        wasPressedSailKey = false;
                }

                if (ship instanceof Cannonable cannonable){
                    if(pressedJumpKey)
                        ModPackets.clientSendPacket(new ServerboundShootShipCannonPacket(true));
                    else
                    if (!cannonable.self().isCannonKeyPressed())
                        ModPackets.clientSendPacket(new ServerboundShootShipCannonPacket(false));
                }
            }
        }
    }
}
