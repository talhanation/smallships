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
 *
 * Every value travels as TWO data slots, its low and its high 16 bits - see
 * {@link SplitData} for why a single slot is not enough.
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

    /** the slots as they go over the wire: two per value, low half first */
    private final ContainerData data;
    private final Player player;

    /** Client constructor. The halves arrive here and are joined on read. */
    public DockyardMenu(int syncId, Inventory inventory) {
        this(syncId, inventory.player, new SimpleContainerData(DATA_COUNT * 2));
    }

    /** Server constructor. */
    public DockyardMenu(int syncId, Inventory inventory, ContainerData data) {
        this(syncId, inventory.player, new SplitData(data));
    }

    private DockyardMenu(int syncId, Player player, ContainerData data) {
        super(ModMenuTypes.DOCKYARD, syncId);
        this.data = data;
        this.player = player;
        this.addDataSlots(data);
    }

    /** @return one value, put back together from its two halves */
    private int get(int index) {
        return SplitData.join(this.data.get(index * 2), this.data.get(index * 2 + 1));
    }

    public int getProgress() {
        return this.get(DATA_PROGRESS);
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
        return this.get(DATA_BUILD_SHIP) - 1;
    }

    public int getTotalTime() {
        return this.get(DATA_TOTAL_TIME);
    }

    public boolean isBusy() {
        return this.get(DATA_TASK) != 0;
    }

    public int getTask() {
        return this.get(DATA_TASK);
    }

    public BlockPos getDockyardPos() {
        return new BlockPos(this.get(DATA_POS_X), this.get(DATA_POS_Y), this.get(DATA_POS_Z));
    }

    /**
     * @return the entity id of the ship selected at the dockyard or -1.
     * Shifted by one on the wire for the same reason as
     * {@link #getBuildShipIndex()}: 0 is a valid entity id.
     */
    public int getShipId() {
        return this.get(DATA_SHIP_ID) - 1;
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

    /**
     * Hands every value of the dockyard out in two halves.
     *
     * Vanilla sends a data slot as a SHORT (ClientboundContainerSetDataPacket),
     * so anything outside -32768..32767 arrives cut off. Furnace style numbers
     * never get there - but an entity id does: the counter only ever grows
     * while the server runs, and every ship part, item, arrow and mob that
     * spawns takes a new number. Once the selected ship sat above 32767 the
     * screen got a negative or a foreign id and showed "no ship", although the
     * dockyard had selected one. A restart reset the counter and hid it for a
     * while; on a busy server the harbour could load above the limit right
     * after the restart as well. The dockyard position broke the same way
     * beyond x or z 32767 - every packet of the screen went to the wrong block.
     *
     * Never seen in single player: the integrated server hands the packet over
     * in memory, nothing is written as a short there.
     */
    private static class SplitData implements ContainerData {
        private final ContainerData values;

        private SplitData(ContainerData values) {
            this.values = values;
        }

        @Override
        public int get(int index) {
            int value = this.values.get(index / 2);
            // the high half is shifted arithmetically, so a negative coordinate
            // keeps its sign
            return index % 2 == 0 ? value & 0xFFFF : value >> 16;
        }

        @Override
        public void set(int index, int value) {}

        @Override
        public int getCount() {
            return this.values.getCount() * 2;
        }

        /**
         * The low half comes back sign extended from the short, so it is
         * masked to its 16 bits before the high half goes on top.
         */
        private static int join(int low, int high) {
            return (high << 16) | (low & 0xFFFF);
        }
    }
}