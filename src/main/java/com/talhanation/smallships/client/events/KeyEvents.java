package com.talhanation.smallships.client.events;

import com.talhanation.smallships.entities.AbstractInventoryEntity;
import com.talhanation.smallships.entities.AbstractSailShip;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
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

            boat.updateControls(RegisterKeyMappings.FORWARD_KEY.isDown(), RegisterKeyMappings.BACKWARD_KEY.isDown(), RegisterKeyMappings.LEFT_KEY.isDown(), RegisterKeyMappings.RIGHT_KEY.isDown(), clientPlayerEntity);

            if (RegisterKeyMappings.SAIL_KEY.isDown()) {
                boat.onKeyPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }

        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (RegisterKeyMappings.SAIL_L_KEY.isDown()) {
                boat.onKeyLowerPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }
        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (RegisterKeyMappings.SAIL_H_KEY.isDown()) {
                boat.onKeyHigherPressed();
                this.wasSailPressed = true;
            }
            else {
                this.wasSailPressed = false;
            }
        }

        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (RegisterKeyMappings.CANNON_KEY.isDown()) {
                boat.onCannonKeyPressed();
                this.wasCannonPressed = true;
            }
            else {
                this.wasCannonPressed = false;
            }
        }

        /*
        if (clientPlayerEntity.equals(boat.getDriver())) {
            if (RegisterKeyMappings.LANTERN_KEY.isDown()) {
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
                if (RegisterKeyMappings.INV_KEY.isDown()) {
                    invboat.openGUI(clientPlayerEntity);
                    this.wasInvPressed = true;
                } else {
                    this.wasInvPressed = false;

                }
            }
        }
    }
}
