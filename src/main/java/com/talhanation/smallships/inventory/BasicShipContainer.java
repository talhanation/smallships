package com.talhanation.smallships.inventory;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.inventory.ContainerBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class BasicShipContainer extends ContainerBase {

    private final IInventory shipInventory;
    private final AbstractInventoryEntity ship;

    public BasicShipContainer(int id, AbstractInventoryEntity ship, PlayerInventory playerInventory) {
        super(Main.BASIC_SHIP_CONTAINER_TYPE, id, playerInventory, ship.getInventory());
        this.ship = ship;
        this.shipInventory = ship.getInventory();

        addShipInventorySlots();
        addPlayerInventorySlots();
    }

    @Override
    public int getInvOffset() {
        return 0;
    }

    public void addShipInventorySlots() {
        for (int k = 0; k < 6; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(shipInventory, l + k * 9, 8 + l * 18,  18 + k * 18));
            }
        }
    }

    public AbstractInventoryEntity getShip() {
        return ship;
    }

    @Override
    public boolean stillValid(PlayerEntity playerIn) {
        return this.shipInventory.stillValid(playerIn) && this.ship.distanceTo(playerIn) < 8.0F;
    }

    @Override
    public void removed(PlayerEntity playerIn) {
        super.removed(playerIn);
    }
}