package com.talhanation.smallships.world.dockyard;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/**
 * One operation the player queued up in the modify tab.
 *
 * The screen lets the player tick several rows at once and sends the whole
 * batch as a single list. Only the SELECTION travels - what a row costs, how
 * long it takes and whether it is even legal is derived from the ship and the
 * player inventory on the server, so a manipulated client can queue nonsense
 * but never get anything for free.
 *
 * @param index         UPGRADE: the {@link com.talhanation.smallships.world.entity.ship.ShipUpgrade}
 *                      ordinal. CANNON: the cannon slot. Unused otherwise.
 * @param inventorySlot BANNER / SAIL_COLOR: the player inventory slot the item
 *                      comes from. -1 when nothing is taken from the inventory.
 * @param install       true = add it to the ship, false = take it off again
 */
public record DockyardAction(Kind kind, int index, int inventorySlot, boolean install) {

    public enum Kind {
        /** a stat upgrade from the ShipUpgrade enum */
        UPGRADE,
        /** a cannon on one specific carriage slot */
        CANNON,
        /** the ship banner - it doubles as the sail banner, there is only one */
        BANNER,
        /** the device projected onto the canvas, a separate piece of work */
        SAIL_BANNER,
        /** the sail dye */
        SAIL_COLOR;

        public static Kind byOrdinal(int ordinal) {
            Kind[] values = values();
            return values[Math.floorMod(ordinal, values.length)];
        }
    }

    public static final StreamCodec<ByteBuf, DockyardAction> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, action -> action.kind().ordinal(),
            ByteBufCodecs.VAR_INT, DockyardAction::index,
            ByteBufCodecs.VAR_INT, DockyardAction::inventorySlot,
            ByteBufCodecs.BOOL, DockyardAction::install,
            (kind, index, inventorySlot, install) -> new DockyardAction(Kind.byOrdinal(kind), index, inventorySlot, install));

    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("Kind", this.kind.ordinal());
        tag.putInt("Index", this.index);
        tag.putInt("InventorySlot", this.inventorySlot);
        tag.putBoolean("Install", this.install);
        return tag;
    }

    public static DockyardAction load(CompoundTag tag) {
        return new DockyardAction(Kind.byOrdinal(tag.getInt("Kind")), tag.getInt("Index"),
                tag.getInt("InventorySlot"), tag.getBoolean("Install"));
    }

    /** A stable key for the screens' selection set - the row identity, not its state. */
    public String key() {
        return this.kind.name() + ":" + this.index + ":" + this.inventorySlot;
    }
}