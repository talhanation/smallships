package com.talhanation.smallships.world.entity.ship;

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

    private final int originalContainerSize;
    NonNullList<ItemStack> itemStacks;
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;
    public final ContainerData dataAccess = new ContainerData() {
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
        this.updatePaging(containerSize);
        this.originalContainerSize = containerSize;
        this.itemStacks = NonNullList.withSize(containerSize, ItemStack.EMPTY);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(CONTAINER_SIZE, this.originalContainerSize);
        this.getEntityData().define(ROWS, (byte) 6);
        this.getEntityData().define(PAGES, (byte) 1);
        this.getEntityData().define(PAGE_INDEX, (byte) 0);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.readChestVehicleSaveData(tag);
        this.readContainerSizeSaveData(tag);
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addChestVehicleSaveData(tag);
        this.addContainerSizeSaveData(tag);
    }

    @Override
    public void destroy(@NotNull DamageSource damageSource) {
        super.destroy(damageSource);
        this.chestVehicleDestroyed(damageSource, this.level, this);
    }

    @Override
    public void remove(@NotNull RemovalReason removalReason) {
        if (!this.level.isClientSide && removalReason.shouldDestroy()) {
            Containers.dropContents(this.level, this, this);
        }

        super.remove(removalReason);
    }

    @Override
    public InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        return this.canAddPassenger(player) && !player.isSecondaryUseActive() ? super.interact(player, interactionHand) : this.interactWithChestVehicle(this::gameEvent, player);
    }

    @Override
    public void openCustomInventoryScreen(@NotNull Player player) {
        if (player.getLevel().isClientSide() && this.getContainerSize() != this.itemStacks.size()) this.itemStacks = resizeItemStacks(this, this.getContainerSize());
        ContainerUtility.openShipMenu(player, this);
        if (!player.getLevel().isClientSide()) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinAi.angerNearbyPiglins(player, true);
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
    public NonNullList<ItemStack> getItemStacks() {
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
    public ItemStack getItem(int i) {
        return this.getChestVehicleItem(i);
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        return this.removeChestVehicleItem(i, j);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return this.removeChestVehicleItemNoUpdate(i);
    }

    @Override
    public void setItem(int i, @NotNull ItemStack itemStack) {
        this.setChestVehicleItem(i, itemStack);
    }

    @Override
    public SlotAccess getSlot(int n) {
        return this.getChestVehicleSlot(n);
    }

    @Override
    public void setChanged() {
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
        this.itemStacks = resizeItemStacks(this, containerSize);
        this.setData(CONTAINER_SIZE, containerSize);
        if (!this.getLevel().isClientSide()) this.getLevel().players()
                .stream()
                .filter(player ->
                        player.containerMenu instanceof ShipContainerMenu shipContainerMenu &&
                        shipContainerMenu.getContainer().equals(this))
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

    private static NonNullList<ItemStack> resizeItemStacks(ContainerEntity containerEntity, int containerSize) {
        ItemStack[] oldItemStacks = containerEntity.getItemStacks().toArray(ItemStack[]::new);
        ItemStack[] newItemStacks;

        if (containerSize < oldItemStacks.length) { // Decrease container size (harder)
            newItemStacks = Arrays.copyOfRange(oldItemStacks, 0, containerSize);
            oldItemStacks = Arrays.stream(Arrays.copyOfRange(oldItemStacks, containerSize, oldItemStacks.length)).filter(stack -> !stack.isEmpty()).toArray(ItemStack[]::new);

            int j = 0;
            for (int i = 0; i < newItemStacks.length; i++) {  // Copy leftover items
                if (newItemStacks[i].isEmpty()) {
                    if (j == oldItemStacks.length) break;
                    newItemStacks[i] = oldItemStacks[j];
                    j++;
                }
            }
            if (j < oldItemStacks.length) {  // Drop non-fitting leftover items
                Containers.dropContents(containerEntity.getLevel(), (Entity) containerEntity, new SimpleContainer(Arrays.copyOfRange(oldItemStacks, j, oldItemStacks.length)));
            }
        } else {  // Increase container size (easier)
            newItemStacks = new ItemStack[containerSize];
            for (int i = 0; i < containerSize; i++) {
                if (i < oldItemStacks.length) {
                    newItemStacks[i] = oldItemStacks[i];
                } else {
                    newItemStacks[i] = ItemStack.EMPTY;
                }
            }
        }

        return NonNullList.of(ItemStack.EMPTY, newItemStacks);
    }
}
