package com.talhanation.smallships.client.events;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.entities.AbstractSailShip;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyEvents {

    private boolean wasSailPressed;
    private boolean wasInvPressed;
    private boolean wasLanternPressed;
    private boolean wasCannonPressed;

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer clientPlayerEntity = minecraft.player;
        if (clientPlayerEntity == null)
            return;

        Entity vehicle = clientPlayerEntity.getVehicle();
        if (!(vehicle instanceof AbstractSailShip)){
            return;
        }
        AbstractSailShip boat = (AbstractSailShip) vehicle;
        if (clientPlayerEntity.equals(boat.getDriver())) {

            boat.updateControls(Main.FORWARD_KEY.isDown(), Main.BACK_KEY.isDown(), Main.LEFT_KEY.isDown(), Main.RIGHT_KEY.isDown(), clientPlayerEntity);

            if (Main.SAIL_KEY.isDown()) {
                boat.onKeyPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }

        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (Main.SAIL_L_KEY.isDown()) {
                boat.onKeyLowerPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }
        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (Main.SAIL_H_KEY.isDown()) {
                boat.onKeyHigherPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }

        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (Main.CANNON_KEY.isDown()) {
                boat.onCannonKeyPressed();
                this.wasCannonPressed = true;
            }
            else {
                this.wasCannonPressed = false;
            }
        }

        /*
        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (Main.LANTERN_KEY.isDown()) {
                boat.onLanternPressed();
                this.wasLanternPressed = true;
            }
            else {
                this.wasLanternPressed = false;
            }
        }
         */

        if (vehicle instanceof AbstractInventoryEntity invboat){
            if (boat.getPassengers().contains(clientPlayerEntity)) {
                if (Main.INV_KEY.isDown()) {
                    invboat.openGUI(clientPlayerEntity);
                    this.wasInvPressed = true;
                } else {
                    this.wasInvPressed = false;

                }
            }
        }
    }
}
