package com.talhanation.smallships.world.inventory;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
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

    @ExpectPlatform
    public static void openCannonMenu(Player player, GroundCannonEntity groundCannonEntity) {
        throw new AssertionError();
    }

    public static void loadAllItems(CompoundTag tag, NonNullList<ItemStack> itemStacks) {
        ListTag listTag = tag.getList("Items", 10);

        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag = listTag.getCompound(i);
            short slot = compoundTag.getShort("Slot");
            if (slot < itemStacks.size()) {
                ItemStack stack = ItemStack.of(compoundTag);
                itemStacks.set(slot, stack.isEmpty() ? ItemStack.EMPTY : stack);
            }
        }
    }

    public static void saveAllItems(CompoundTag tag, NonNullList<ItemStack> itemStacks) {
        ListTag listTag = new ListTag();

        for (int i = 0; i < itemStacks.size(); ++i) {
            ItemStack itemStack = itemStacks.get(i);
            if (!itemStack.isEmpty()) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putShort("Slot", (short) i);
                listTag.add(itemStack.save(compoundTag));
            }
        }

        tag.put("Items", listTag);
    }
}
