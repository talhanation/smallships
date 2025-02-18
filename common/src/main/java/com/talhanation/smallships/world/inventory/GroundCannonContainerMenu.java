package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GroundCannonContainerMenu extends AbstractContainerMenu {

    protected Container inventory;
    protected Container playerInventory;
    private GroundCannonEntity groundCannonEntity;

    public GroundCannonContainerMenu(MenuType containerType, int id, @NotNull GroundCannonEntity groundCannonEntity, Container playerInventory) {
        super(containerType, id);
        this.playerInventory = playerInventory;
        this.inventory = groundCannonEntity.getInventory();
        this.groundCannonEntity = groundCannonEntity;
        this.addPlayerInventorySlots();
        this.addGroundCannonInventorySlots();
    }

    protected void addPlayerInventorySlots() {
        if (this.playerInventory != null) {
            int k;
            for(k = 0; k < 3; ++k) {
                for(int j = 0; j < 9; ++j) {
                    this.addSlot(new Slot(this.playerInventory, j + k * 9 + 9, 8 + j * 18, 84 + k * 18 + this.getInvOffset()));
                }
            }

            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(this.playerInventory, k, 8 + k * 18, 142 + this.getInvOffset()));
            }
        }
    }

    protected void addGroundCannonInventorySlots() {
        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, 0, 2 * 18 + 82 + l * 18,  18 + k * 18));
            }
        }
    }

    public int getInvOffset() {
        return 53;
    }

    public int getInventorySize() {
        return this.inventory == null ? 0 : this.inventory.getContainerSize();
    }

    public Container getPlayerInventory() {
        return this.playerInventory;
    }


    public GroundCannonEntity getEntity() {
        return this.groundCannonEntity;
    }
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            if (index < this.getInventorySize()) {
                if (!this.moveItemStackTo(stack, this.getInventorySize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stack, 0, this.getInventorySize(), false)) {
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

    public boolean stillValid(Player player) {
        return this.inventory == null ? true : this.inventory.stillValid(player);
    }

    public void removed(Player player) {
        super.removed(player);
        if (this.inventory != null) {
            this.inventory.stopOpen(player);
        }

    }
}

