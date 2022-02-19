package com.talhanation.smallships.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class AbstractInventoryEntity extends AbstractSailShip {

    private final Inventory inventory = new Inventory(this.getInventorySize());
    private final Inventory inventory2 = new Inventory(this.getInventory2Size());

    public AbstractInventoryEntity(EntityType<? extends AbstractInventoryEntity> type, World world) {
        super(type, world);
    }

    ///////////////////////////////////TICK/////////////////////////////////////////

    public void tick() {
        super.tick();
    }

    ////////////////////////////////////DATA////////////////////////////////////


    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    public void addAdditionalSaveData(CompoundNBT nbt) {
        super.addAdditionalSaveData(nbt);
        ListNBT list = new ListNBT();
        for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundNBT compoundnbt = new CompoundNBT();
                compoundnbt.putByte("Slot", (byte) i);
                itemstack.save(compoundnbt);
                list.add(compoundnbt);
            }
        }

        nbt.put("Inventory", list);

        ListNBT list2 = new ListNBT();
        for (int i = 0; i < this.inventory2.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory2.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundNBT compoundnbt = new CompoundNBT();
                compoundnbt.putByte("Slot2", (byte) i);
                itemstack.save(compoundnbt);
                list2.add(compoundnbt);
            }
        }

        nbt.put("Inventory2", list);
    }

    public void readAdditionalSaveData(CompoundNBT nbt) {
        super.readAdditionalSaveData(nbt);
        ListNBT list = nbt.getList("Inventory", 10);
        for (int i = 0; i < list.size(); ++i) {
            CompoundNBT compoundnbt = list.getCompound(i);
            int j = compoundnbt.getByte("Slot") & 255;

            this.inventory.setItem(j, ItemStack.of(compoundnbt));
        }

        ListNBT list2 = nbt.getList("Inventory2", 10);
        for (int i = 0; i < list2.size(); ++i) {
            CompoundNBT compoundnbt = list2.getCompound(i);
            int j = compoundnbt.getByte("Slot2") & 255;

            this.inventory.setItem(j, ItemStack.of(compoundnbt));
        }
    }


    ////////////////////////////////////GET////////////////////////////////////

    public Inventory getInventory() {
        return this.inventory;
    }

    public Inventory getInventory2() {
        return this.inventory2;
    }

    public abstract int getInventorySize();
    public abstract int getInventory2Size();

    ////////////////////////////////////SET////////////////////////////////////

    public boolean setSlot(int slot, ItemStack itemStack) {
        if (super.setSlot(slot, itemStack)) {
            return true;
        } else {
            int i = slot - 300;
            if (i >= 0 && i < this.inventory.getContainerSize()) {
                this.inventory.setItem(i, itemStack);
                return true;
            } else {
                return false;
            }
        }
    }

    public abstract boolean hasBiggerInv();

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public abstract void openGUI(PlayerEntity player);
    public abstract void openGUI2(PlayerEntity player);

    public void destroyShip(DamageSource dmg) {
        for (int i = 0; i < this.inventory.getContainerSize(); i++)
            InventoryHelper.dropItemStack(this.level, getX(), getY(), getZ(), this.inventory.getItem(i));

        for (int i = 0; i < this.inventory2.getContainerSize(); i++)
            InventoryHelper.dropItemStack(this.level, getX(), getY(), getZ(), this.inventory2.getItem(i));
        super.destroyShip(dmg);
    }

}

