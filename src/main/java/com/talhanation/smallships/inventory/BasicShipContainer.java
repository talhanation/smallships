package com.talhanation.smallships.inventory;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractShipDamage;
import de.maxhenkel.corelib.inventory.ContainerBase;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

public class BasicShipContainer extends ContainerBase {

    private final Container shipInventory;
    private final AbstractShipDamage ship;

    public BasicShipContainer(int id, AbstractShipDamage ship, Inventory playerInventory) {
        super(Main.BASIC_SHIP_CONTAINER_TYPE.get(), id, playerInventory, ship.getInventory());
        this.ship = ship;
        this.shipInventory = ship.getInventory();

        addShipInventorySlots();
        addPlayerInventorySlots();
    }

    @Override
    public int getInvOffset() {
        return 55;
    }

    public void addShipInventorySlots() {
        for (int k = 0; k < 6; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(shipInventory, l + k * 9, 8 + l * 18,  18 + k * 18));
            }
        }
    }

    public AbstractShipDamage getShip() {
        return ship;
    }

    @Override
    public boolean stillValid(Player playerIn) {
        return this.shipInventory.stillValid(playerIn) && this.ship.distanceTo(playerIn) < 8.0F;
    }

    @Override
    public void removed(Player playerIn) {
        super.removed(playerIn);
    }
}