package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.mixin.container.SimpleContainerAccessor;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import com.talhanation.smallships.world.inventory.ShipContainerMenu;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public abstract class ContainerShip extends Ship implements HasCustomInventoryScreen, ContainerEntity {
    public static final EntityDataAccessor<Integer> CONTAINER_SIZE = SynchedEntityData.defineId(ContainerShip.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Byte> ROWS = SynchedEntityData.defineId(ContainerShip.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> PAGES = SynchedEntityData.defineId(ContainerShip.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> PAGE_INDEX = SynchedEntityData.defineId(ContainerShip.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Byte> CONTAINER_FILL_STATE = SynchedEntityData.defineId(ContainerShip.class, EntityDataSerializers.BYTE);

    private final int originalContainerSize;
    NonNullList<ItemStack> itemStacks;
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;
    public final ContainerData containerData = new ContainerData() {
        public int get(int index) {
            return switch (index) {
                case 0 -> ContainerShip.this.getData(ROWS);
                case 1 -> ContainerShip.this.getData(PAGES);
                case 2 -> ContainerShip.this.getData(PAGE_INDEX);
                default -> 0;
            };
        }
        public void set(int index, int value) {
            switch (index) {
                case 0 -> ContainerShip.this.setData(ROWS, (byte) value);
                case 1 -> ContainerShip.this.setData(PAGES, (byte) value);
                case 2 -> ContainerShip.this.setData(PAGE_INDEX, (byte) value);
            }
        }
        public int getCount() {
            return 3;
        }
    };

    public ContainerShip(EntityType<? extends Boat> entityType, Level level, int containerSize) {
        super(entityType, level);
        this.originalContainerSize = containerSize;
        this.updatePaging(this.originalContainerSize);
        this.setData(CONTAINER_SIZE, this.originalContainerSize);
        this.itemStacks = NonNullList.withSize(this.originalContainerSize, ItemStack.EMPTY);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(CONTAINER_SIZE, this.originalContainerSize);
        this.getEntityData().define(ROWS, (byte) 6);
        this.getEntityData().define(PAGES, (byte) 1);
        this.getEntityData().define(PAGE_INDEX, (byte) 0);
        this.getEntityData().define(CONTAINER_FILL_STATE, (byte) 0);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readContainerSizeSaveData(tag);
        this.readChestVehicleSaveData(tag);

        this.setContainerFillState(tag.getByte("ContainerFillState"));
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addContainerSizeSaveData(tag);
        this.addChestVehicleSaveData(tag);

        tag.putByte("ContainerFillState", this.getContainerFillState());
    }

    @Override
    public void remove(@NotNull RemovalReason removalReason) {
        if (!this.getLevel().isClientSide() && removalReason.shouldDestroy()) {
            Containers.dropContents(this.getLevel(), this, this);
        }

        super.remove(removalReason);
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        if(player.isSecondaryUseActive() && !this.getPassengers().isEmpty()){
            this.ejectPassengers();
            return InteractionResult.SUCCESS;
        }

        return this.canAddPassenger(player) && !player.isSecondaryUseActive() ? super.interact(player, interactionHand) : this.interactWithChestVehicle(this::gameEvent, player);
    }

    @Override
    public void openCustomInventoryScreen(@NotNull Player player) {
        ContainerUtility.openShipMenu(player, this);
        if (!player.getLevel().isClientSide()) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);//lol
        }
    }

    @Nullable
    @Override
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(@Nullable ResourceLocation resourceLocation) {
        this.lootTable = resourceLocation;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long l) {
        this.lootTableSeed = l;
    }

    @Override
    public @NotNull NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    @Override
    public void clearItemStacks() {
        this.itemStacks.clear();
    }

    @Override
    public int getContainerSize() {
        return this.getData(CONTAINER_SIZE);
    }

    @Override
    public @NotNull ItemStack getItem(int i) {
        return this.getChestVehicleItem(i);
    }

    @Override
    public @NotNull ItemStack removeItem(int i, int j) {
        return this.removeChestVehicleItem(i, j);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int i) {
        return this.removeChestVehicleItemNoUpdate(i);
    }

    @Override
    public void setItem(int i, @NotNull ItemStack itemStack) {
        this.setChestVehicleItem(i, itemStack);
        this.updateContainerFillState();
    }

    @Override
    public @NotNull SlotAccess getSlot(int n) {
        return this.getChestVehicleSlot(n);
    }

    @Override
    public void setChanged() {
        this.updateContainerFillState();
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.isChestVehicleStillValid(player);
    }

    @Override
    public void clearContent() {
        this.clearChestVehicleContent();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inventory, @NotNull Player player) {
        if (this.lootTable == null || !player.isSpectator()) {
            this.unpackChestVehicleLootTable(inventory.player);
            this.openCustomInventoryScreen(player);
        }
        return null;
    }

    @Override
    public void readChestVehicleSaveData(@NotNull CompoundTag compoundTag) {
        this.clearItemStacks();
        if (compoundTag.contains("LootTable", 8)) {
            this.setLootTable(new ResourceLocation(compoundTag.getString("LootTable")));
            this.setLootTableSeed(compoundTag.getLong("LootTableSeed"));
        } else {
            ContainerUtility.loadAllItems(compoundTag, this.getItemStacks());
            this.resizeContainer(this.getContainerSize());
        }
    }

    @Override
    public void addChestVehicleSaveData(@NotNull CompoundTag compoundTag) {
        if (this.getLootTable() != null) {
            compoundTag.putString("LootTable", this.getLootTable().toString());
            if (this.getLootTableSeed() != 0L) {
                compoundTag.putLong("LootTableSeed", this.getLootTableSeed());
            }
        } else {
            ContainerUtility.saveAllItems(compoundTag, this.getItemStacks());
        }
    }

    public void readContainerSizeSaveData(CompoundTag tag) {
        if (!tag.contains("ContainerSize", 3)) tag.putInt("ContainerSize", this.originalContainerSize); // If defineSychedData worked, this line wouldn't be needed
        int containerSize = tag.getInt("ContainerSize");
        if (containerSize == 0) containerSize = this.originalContainerSize;
        this.updatePaging(containerSize);
        this.setData(CONTAINER_SIZE, containerSize);
        if (!this.getLevel().isClientSide()) this.getLevel().players()
                .stream()
                .filter(player ->
                        player.containerMenu instanceof ShipContainerMenu shipContainerMenu &&
                                shipContainerMenu.getContainerShip().equals(this))
                .map(player -> (ServerPlayer) player)
                .forEach(ServerPlayer::closeContainer);
    }

    public void addContainerSizeSaveData(CompoundTag tag) {
        tag.putInt("ContainerSize", this.getData(CONTAINER_SIZE));
    }

    private void updatePaging(int containerSize) {
        if (containerSize % ShipContainerMenu.COLUMNS != 0) throw new IllegalArgumentException("ShipContainerMenu can not be created with size " + containerSize + ". Make sure to use a container size that is divisible by " + ShipContainerMenu.COLUMNS + ".");
        int allRows = containerSize / ShipContainerMenu.COLUMNS;
        int rowsPerPage = 6;
        int pages = 1;
        while (true) {
            if (pages * rowsPerPage >= allRows) {
                if (pages * rowsPerPage == allRows) {
                    break;
                } else {
                    rowsPerPage -= 1;
                    pages = 1;
                }
            } else {
                pages += 1;
                if (pages > Byte.MAX_VALUE) throw new IllegalArgumentException("ShipContainerMenu can not be created with size " + containerSize + ". Make sure to use a container size that requires less or equal to " + (Byte.MAX_VALUE + 1) + " pages. Current amount of required pages: " + pages);
            }
        }

        this.setData(ROWS, (byte) rowsPerPage);
        this.setData(PAGES, (byte) pages);
        this.setData(PAGE_INDEX, (byte) 0);
    }

    protected void updateContainerFillState(){
        int percent = (int) getInvFillStateInPercent();
        this.setContainerFillState((byte) percent);
    }

    public byte getInvFillState(){
        return this.entityData.get(CONTAINER_FILL_STATE);
    }

    public double getInvFillStateInPercent(){
        int size = this.getItemStacks().size();
        double invFillStateInPercent = this.getItemStacks().stream().map(itemStack -> !itemStack.isEmpty()? (double) itemStack.getCount() / itemStack.getMaxStackSize() : 0.0D).reduce(0.0D, Double::sum) / size;

        return invFillStateInPercent * 100;
    }

    public void resizeContainer(int containerSize) {
        this.itemStacks = resizeItemStacks(this, containerSize);
    }

    private static NonNullList<ItemStack> resizeItemStacks(ContainerEntity containerEntity, int containerSize) {
        ItemStack[] oldItemStacks = containerEntity.getItemStacks().toArray(ItemStack[]::new);
        SimpleContainer newContainer;

        if (containerSize < oldItemStacks.length) {
            // Decrease container size (harder)
            newContainer = new SimpleContainer(Arrays.copyOfRange(oldItemStacks, 0, containerSize));
            oldItemStacks = Arrays.stream(Arrays.copyOfRange(oldItemStacks, containerSize, oldItemStacks.length)).filter(stack -> !stack.isEmpty()).toArray(ItemStack[]::new);
            SimpleContainer leftoverContainer = new SimpleContainer(oldItemStacks.length);

            // Move fitting leftover items
            for (ItemStack oldItemStack : oldItemStacks) {
                leftoverContainer.addItem(newContainer.addItem(oldItemStack));
            }

            // Drop non-fitting leftover items
            if (!leftoverContainer.isEmpty()) {
                Containers.dropContents(containerEntity.getLevel(), (Entity) containerEntity, leftoverContainer);
            }
        } else {
            // Increase container size (easier)
            newContainer = new SimpleContainer(containerSize);
            for (int i = 0; i < containerSize; i++) {
                if (i < oldItemStacks.length) {
                    newContainer.setItem(i, oldItemStacks[i]);
                }
            }
        }

        return ((SimpleContainerAccessor)newContainer).getItems();
    }

    public byte getContainerFillState() {
        return entityData.get(CONTAINER_FILL_STATE);
    }

    public void setContainerFillState(byte b) {
        this.entityData.set(CONTAINER_FILL_STATE, b);
    }

    public float getContainerModifier() {
        return SmallShipsConfig.Common.shipGeneralContainerModifier.get().floatValue() * (float)(this.getContainerFillState() - Byte.MIN_VALUE) / (-Byte.MIN_VALUE + Byte.MAX_VALUE);
    }
}
