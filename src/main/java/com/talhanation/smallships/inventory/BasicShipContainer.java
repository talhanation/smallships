package com.talhanation.smallships.inventory;

import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.inventory.ContainerBase;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BasicShipContainer extends ContainerBase {

    private final Container shipInventory;
    private final AbstractInventoryEntity ship;
    private final int startSlot;

    public BasicShipContainer(int id, AbstractInventoryEntity ship, Inventory playerInventory, int startSlot) {
        super(Main.BASIC_SHIP_CONTAINER_TYPE.get(), id, playerInventory, ship.getInventory());
        this.ship = ship;
        this.shipInventory = ship.getInventory();
        this.startSlot = startSlot;

        addShipInventorySlots();
        addPlayerInventorySlots();
    }

    @Override
    public int getInvOffset() {
        return 56;
    }

    public void addShipInventorySlots() {
        for (int k = 0; k < 6; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(shipInventory, l + k * 9 + startSlot, 8 + l * 18,  18 + k * 18));
            }
        }
    }

    public AbstractInventoryEntity getShip() {
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

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();

            int invSize = this.shipInventory.getContainerSize();
            if (invSize > 54) {
                invSize -= 54;
            }

            if (index < invSize) {
                if (!this.moveItemStackTo(stack, invSize, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, 0, invSize, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void broadcastChanges() {
        super.broadcastChanges();
        ship.updateCargo();
        ship.updateInventory();
    }
}