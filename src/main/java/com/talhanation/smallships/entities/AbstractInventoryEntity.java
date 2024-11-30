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
    private static final EntityDataAccessor<Integer> INV_PAGE = SynchedEntityData.defineId(AbstractInventoryEntity.class, EntityDataSerializers.INT);
    
    private final SimpleContainer inventory = new SimpleContainer(this.getInventorySize());

    public AbstractInventoryEntity(EntityType<? extends AbstractInventoryEntity> type, Level world) {
        super(type, world);
    }

    ///////////////////////////////////TICK/////////////////////////////////////////

    public void tick() {
        super.tick();
        //updateCargo();
    }

    public abstract void updateInventory();

    ////////////////////////////////////DATA////////////////////////////////////

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CARGO, 0);
        entityData.define(INV_PAGE, 1);
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
        nbt.putInt("InventoryPage", getInvPage());
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
        this.setInvPage(nbt.getInt("InventoryPage"));
    }

    ////////////////////////////////////GET////////////////////////////////////

    public int getCargo() {
        return entityData.get(CARGO);
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    public abstract int getInventorySize();

    public int getMaxInvPage(){
        if(this.getInventorySize() <= 54) return 1;
        else if (this.getInventorySize() > 54) return 2;
        else
            return 3;
    }

    public int getInvPage(){
        return entityData.get(INV_PAGE);
    }

    ////////////////////////////////////SET////////////////////////////////////
    //Do we need this?
    public boolean setSlot(int slot, ItemStack itemStack) {
        if (super.getSlot(slot).set(itemStack)) {
            return true;
        } else {
            int i = slot - 300;
            if (i >= 0 && i < this.inventory.items.size()) {
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

    public void setInvPage(int page){
        entityData.set(INV_PAGE, page);
    }

    ////////////////////////////////////OTHER FUNCTIONS////////////////////////////////////

    public void destroyShip(DamageSource dmg) {
        for (int i = 0; i < this.inventory.items.size(); i++)
            Containers.dropItemStack(this.level, getX(), getY(), getZ(), this.inventory.getItem(i));
        super.destroyShip(dmg);
    }

    public void updateCargo(){
        int x, slotCount = 0;
        int oldSlots = this.getCargo();

        for (int i = 0; i < this.inventory.items.size(); i++) {
            if (!inventory.getItem(i).isEmpty())
                slotCount++;
        }

        int average = (slotCount + oldSlots) / 2;


        if (average > 27 * getMaxInvPage()) {
            x = 4;
        } else if (average > 16 * getMaxInvPage()) {
            x = 3;
        } else if (average > 8 * getMaxInvPage()) {
            x = 2;
        } else if (average > 2 * getMaxInvPage()) {
            x = 1;
        } else {
            x = 0;
        }

        setCargo(x);
    }
}

