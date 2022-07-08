package com.talhanation.smallships.entities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class AbstractInventoryEntity extends AbstractSailShip {

    private static final EntityDataAccessor<Integer> CARGO = SynchedEntityData.defineId(AbstractInventoryEntity.class, EntityDataSerializers.INT);
    private final SimpleContainer inventory = new SimpleContainer(this.getInventorySize());

    public AbstractInventoryEntity(EntityType<? extends AbstractInventoryEntity> type, Level world) {
        super(type, world);
    }

    ///////////////////////////////////TICK/////////////////////////////////////////

    public void tick() {
        super.tick();

        updateCargo();
    }

    ////////////////////////////////////DATA////////////////////////////////////

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CARGO, 0);
    }

    ////////////////////////////////////SAVE DATA////////////////////////////////////

    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        ListTag list = new ListTag();
        for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundnbt = new CompoundTag();
                compoundnbt.putByte("Slot", (byte) i);
                itemstack.save(compoundnbt);
                list.add(compoundnbt);
            }
        }

        nbt.put("Inventory", list);
        nbt.putInt("Cargo", getCargo());
    }

    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        ListTag list = nbt.getList("Inventory", 10);
        for (int i = 0; i < list.size(); ++i) {
            CompoundTag compoundnbt = list.getCompound(i);
            int j = compoundnbt.getByte("Slot") & 255;

            this.inventory.setItem(j, ItemStack.of(compoundnbt));
        }
        this.setCargo(nbt.getInt("Cargo"));
    }


    ////////////////////////////////////GET////////////////////////////////////

    public int getCargo() {
        return entityData.get(CARGO);
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    public abstract int getInventorySize();
    ////////////////////////////////////SET////////////////////////////////////


    public boolean setSlot(int slot, ItemStack itemStack) {
        if (super.getSlot(slot).set(itemStack)) {
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

    public void setCargo(int cargo){
        entityData.set(CARGO, cargo);
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public abstract void openGUI(Player player);

    public void destroyShip(DamageSource dmg) {
        for (int i = 0; i < this.inventory.getContainerSize(); i++)
            Containers.dropItemStack(this.level, getX(), getY(), getZ(), this.inventory.getItem(i));
        super.destroyShip(dmg);
    }

    public void updateCargo(){
        SimpleContainer inventory = this.getInventory();
        int x, tempload = 0;
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (!inventory.getItem(i).isEmpty())
                tempload++;
        }
        if (tempload > 31) {
            x = 4;
        } else if (tempload > 16) {
            x = 3;
        } else if (tempload > 8) {
            x = 2;
        } else if (tempload > 3) {
            x = 1;
        } else {
            x = 0;
        }
        setCargo(x);
    }

}

