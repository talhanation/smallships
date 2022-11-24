package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ContainerUtility {
    @ExpectPlatform
    public static void openShipMenu(Player player, ContainerShip containerShip) {
        throw new AssertionError();
    }

    public static void loadAllItems(CompoundTag compoundTag, NonNullList<ItemStack> itemStacks) {
        ListTag listTag = compoundTag.getList("Items", 10);

        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag2 = listTag.getCompound(i);
            short slot = compoundTag2.getShort("Slot");
            if (slot < itemStacks.size()) {
                itemStacks.set(slot, ItemStack.of(compoundTag2));
            }
        }
    }

    public static void saveAllItems(CompoundTag compoundTag, NonNullList<ItemStack> itemStacks) {
        ListTag listTag = new ListTag();

        for (int i = 0; i < itemStacks.size(); ++i) {
            ItemStack itemStack = itemStacks.get(i);
            if (!itemStack.isEmpty()) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putShort("Slot", (short) i);
                itemStack.save(compoundTag2);
                listTag.add(compoundTag2);
            }
        }

        compoundTag.put("Items", listTag);
    }
}
