package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShipContainerMenu extends AbstractContainerMenu {
    public static final int COLUMNS = 9;
    private final Inventory inventory;
    private final Container container;
    private final ContainerData containerData;

    public ShipContainerMenu(MenuType<ShipContainerMenu> type, int syncId, Inventory inventory, ContainerShip containerShip) {
        super(type, syncId);
        this.containerData = containerShip.containerData;
        checkContainerSize(containerShip, this.getRowCount() * 9);
        this.container = containerShip;
        this.inventory = inventory;
        this.addDataSlots(this.containerData);
        this.openPage();
    }

    private void openPage() {
        this.container.startOpen(this.inventory.player);
        int k = (this.getRowCount() - 4) * 18;

        for(int l = 0; l < this.getRowCount(); ++l) {
            for(int m = 0; m < 9; ++m) {
                this.addSlot(new Slot(this.container, m + l * 9 + this.getPageIndex() * this.getRowCount() * COLUMNS, 8 + m * 18, 18 + l * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int m = 0; m < 9; ++m) {
                this.addSlot(new Slot(this.inventory, m + l * 9 + 9, 8 + m * 18, 103 + l * 18 + k));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(this.inventory, l, 8 + l * 18, 161 + k));
        }
    }

    @Override
    public void initializeContents(int stateId, @NotNull List<ItemStack> list, @NotNull ItemStack itemStack) {
        super.initializeContents(stateId, list, itemStack);
    }

    @Override
    public boolean clickMenuButton(@NotNull Player player, int i) {
        int pageIndex = Mth.clamp(this.getPageIndex() + i, 0, this.getPageCount() - 1);
        ModPackets.clientSendPacket(player, ModPackets.serverOpenShipScreen.apply(container, pageIndex));
        this.updatePaging(this.getRowCount(), this.getPageCount(), pageIndex);
        return true;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot.hasItem()) {
            ItemStack slotItemStack = slot.getItem();
            itemStack = slotItemStack.copy();
            if (i < this.getRowCount() * 9) {
                if (!this.moveItemStackTo(slotItemStack, this.getRowCount() * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItemStack, 0, this.getRowCount() * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (slotItemStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return itemStack;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public int getRowCount() {
        return this.containerData.get(0);
    }

    public int getPageCount() {
        return this.containerData.get(1);
    }

    public int getPageIndex() {
        return this.containerData.get(2);
    }

    public void updatePaging(int rows, int pages, int pageIndex) {
        this.containerData.set(0, rows);
        this.containerData.set(1, pages);
        this.containerData.set(2, pageIndex);
    }

    public ContainerShip getContainerShip() {
        return (ContainerShip) container;
    }

    @Override
    public void addSlotListener(ContainerListener containerListener) {
        super.addSlotListener(containerListener);


    }

    @Override
    public String toString() {
        return "ShipContainerMenu{" +
                "rows=" + this.getRowCount() +
                ", pages=" + this.getPageCount() +
                ", pageIndex=" + this.getPageIndex() +
                ", itemStacksSize=" + this.getContainerShip().getItemStacks().size() +
                '}';
    }
}
