package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.compat.ShieldRegistry;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;

public interface Shieldable extends Ability {

    ShieldPosition getShieldPosition(int index);
    byte getMaxShieldsPerSide();

    default void tickShieldShip() {
    }

    default void defineShieldShipSynchedData(SynchedEntityData.Builder builder) {
        builder.define(Ship.SHIELD_DATA, new CompoundTag());
    }

    /* ---------------- shield slots ---------------- */

    /**
     * One slot per anchor point on the hull, addressed the same way a cannon
     * carriage is. The shields used to live in a push/pop stack next to a
     * synched copy of themselves, which is why taking one off with an axe left
     * the copy behind and the client hung it straight back up.
     */
    default int getTotalShieldSlots() {
        return this.getMaxShieldsPerSide() * 2;
    }

    default ItemStack getShieldInSlot(int slot) {
        CompoundTag tag = self().getShieldData().getCompound(slotKey(slot));
        if (tag.isEmpty()) return ItemStack.EMPTY;
        return ItemStack.parse(self().registryAccess(), tag).orElse(ItemStack.EMPTY);
    }

    default void setShieldInSlot(int slot, ItemStack shield) {
        if (slot < 0 || slot >= this.getTotalShieldSlots()) return;
        CompoundTag tag = self().getShieldData().copy();
        if (shield.isEmpty()) tag.remove(slotKey(slot));
        else tag.put(slotKey(slot), shield.copyWithCount(1).save(self().registryAccess(), new CompoundTag()));
        self().setShieldData(tag);
    }

    default boolean isShieldInSlot(int slot) {
        return self().getShieldData().contains(slotKey(slot), Tag.TAG_COMPOUND);
    }

    /**
     * Counts without parsing: the damage modifier asks on every hit and the
     * ship screen asks on every frame, and neither of them wants the stacks.
     */
    default int getShieldCount() {
        int count = 0;
        for (int slot = 0; slot < this.getTotalShieldSlots(); slot++) {
            if (this.isShieldInSlot(slot)) count++;
        }
        return count;
    }

    /** @return the lowest free slot, or -1 if the hull is fully hung. */
    default int getFreeShieldSlot() {
        for (int slot = 0; slot < this.getTotalShieldSlots(); slot++) {
            if (!this.isShieldInSlot(slot)) return slot;
        }
        return -1;
    }

    /** @return the highest occupied slot, or -1 if there is nothing to take off. */
    default int getLastOccupiedShieldSlot() {
        for (int slot = this.getTotalShieldSlots() - 1; slot >= 0; slot--) {
            if (this.isShieldInSlot(slot)) return slot;
        }
        return -1;
    }

    static String slotKey(int slot) {
        return "S" + slot;
    }

    /* ---------------- save data ---------------- */

    default void readShieldShipSaveData(CompoundTag tag) {
        if (tag.contains("ShieldSlots", Tag.TAG_COMPOUND)) {
            self().setShieldData(tag.getCompound("ShieldSlots"));
            return;
        }
        // a ship saved before the slots existed: the old flat list was drawn in
        // order from the bow, so filling the slots in the same order puts every
        // shield back exactly where its owner last saw it
        ListTag legacy = tag.getList("Shields", Tag.TAG_COMPOUND);
        CompoundTag slots = new CompoundTag();
        for (int slot = 0; slot < legacy.size() && slot < this.getTotalShieldSlots(); slot++) {
            ItemStack itemStack = ItemStack.parse(self().registryAccess(), legacy.getCompound(slot)).orElse(ItemStack.EMPTY);
            if (!itemStack.isEmpty()) {
                slots.put(slotKey(slot), itemStack.copyWithCount(1).save(self().registryAccess(), new CompoundTag()));
            }
        }
        self().setShieldData(slots);
    }

    default void addShieldShipSaveData(CompoundTag tag) {
        tag.put("ShieldSlots", self().getShieldData());
    }

    /* ---------------- effect ---------------- */

    default float getDamageModifier() {
        return (float) (1.0F - this.getShieldCount() * SmallShipsConfig.Server.shipGeneralShieldDamageReduction.get() / 100F);
    }

    /**
     * Field mounting by hand. What counts as a shield is not hardcoded any more
     * but asked of the {@link ShieldRegistry}, so a shield from another mod goes
     * up the same way the vanilla one does.
     */
    default boolean interactShield(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (ShieldRegistry.isShield(itemStack)) {
            int slot = this.getFreeShieldSlot();
            if (slot < 0) return false;
            this.setShieldInSlot(slot, itemStack.copyWithCount(1));
            if (!player.isCreative()) itemStack.shrink(1);
            self().getCommandSenderWorld().playSound(player, self().getX(), self().getY() + 4, self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.5F);
            return true;
        } else if (itemStack.getItem() instanceof AxeItem) {
            int slot = this.getLastOccupiedShieldSlot();
            if (slot < 0) return false;
            ItemStack removedShield = this.getShieldInSlot(slot);
            this.setShieldInSlot(slot, ItemStack.EMPTY);
            self().spawnAtLocation(removedShield, 2);
            self().getCommandSenderWorld().playSound(player, self().getX(), self().getY() + 4, self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.0F);
            return true;
        }
        return false;
    }

    @SuppressWarnings("ClassCanBeRecord")
    class ShieldPosition {
        public final double x;
        public final double y;
        public final double z;
        public final boolean isRightSided;

        public ShieldPosition(double x, double y, double z, boolean isRightSided) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.isRightSided = isRightSided;
        }
    }
}