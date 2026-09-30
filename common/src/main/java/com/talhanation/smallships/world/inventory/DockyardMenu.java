package com.talhanation.smallships.world.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * The dockyard menu. It has no item slots: materials are taken directly from
 * the player inventory. The ContainerData syncs progress, task, the dockyard
 * position (for the client to find the block entity) and the entity id of the
 * ship selected for the modify tab (-1 if none).
 */
public class DockyardMenu extends AbstractContainerMenu {
    public static final int DATA_PROGRESS = 0;
    public static final int DATA_TOTAL_TIME = 1;
    public static final int DATA_TASK = 2;
    public static final int DATA_POS_X = 3;
    public static final int DATA_POS_Y = 4;
    public static final int DATA_POS_Z = 5;
    public static final int DATA_SHIP_ID = 6;
    /** registry index + 1 of the ship type currently being built, 0 while idle */
    public static final int DATA_BUILD_SHIP = 7;
    public static final int DATA_COUNT = 8;

    private final ContainerData data;
    private final Player player;

    /** Client constructor. */
    public DockyardMenu(int syncId, Inventory inventory) {
        this(syncId, inventory, new SimpleContainerData(DATA_COUNT));
    }

    /** Server constructor. */
    public DockyardMenu(int syncId, Inventory inventory, ContainerData data) {
        super(ModMenuTypes.DOCKYARD, syncId);
        this.data = data;
        this.player = inventory.player;
        this.addDataSlots(data);
    }

    public int getProgress() {
        return this.data.get(DATA_PROGRESS);
    }

    /**
     * @return the registry index of the ship the dockyard is building, or -1.
     * Lets the build tab come back up on the right ship after the player closed
     * and reopened the screen mid build.
     *
     * The value travels shifted by one (0 = nothing on the stocks): the screen
     * reads this in init, BEFORE the first data sync has arrived, while the
     * client data still holds its default 0. Unshifted that 0 was index 0 of
     * the network order - the brigg - and the build tab jumped to it on every
     * opening.
     */
    public int getBuildShipIndex() {
        return this.data.get(DATA_BUILD_SHIP) - 1;
    }

    public int getTotalTime() {
        return this.data.get(DATA_TOTAL_TIME);
    }

    public boolean isBusy() {
        return this.data.get(DATA_TASK) != 0;
    }

    public int getTask() {
        return this.data.get(DATA_TASK);
    }

    public BlockPos getDockyardPos() {
        return new BlockPos(this.data.get(DATA_POS_X), this.data.get(DATA_POS_Y), this.data.get(DATA_POS_Z));
    }

    /**
     * @return the entity id of the ship selected at the dockyard or -1.
     * Shifted by one on the wire for the same reason as
     * {@link #getBuildShipIndex()}: 0 is a valid entity id.
     */
    public int getShipId() {
        return this.data.get(DATA_SHIP_ID) - 1;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }
}