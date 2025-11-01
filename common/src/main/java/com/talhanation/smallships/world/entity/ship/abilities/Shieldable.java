package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public interface Shieldable extends Ability {

    ShieldPosition getShieldPosition(int index);
    byte getMaxShieldsPerSide();

    default void tickShieldShip() {
    }

    default void readShieldShipSaveData(CompoundTag tag) {
        ListTag shieldItems = tag.getList("Shields").orElseThrow();

        for (int i = 0; i < shieldItems.size(); ++i) {
            CompoundTag compoundTag = shieldItems.getCompound(i).orElseThrow();
            ItemStack itemStack = ItemStack.parse(self().registryAccess(), compoundTag).orElse(ItemStack.EMPTY);
            if (!itemStack.isEmpty()) this.getShields().add(itemStack);
        }

        var shieldData = new CompoundTag();
        shieldData.put("Shields", shieldItems);
        self().setData(Ship.SHIELD_DATA, shieldData);
    }

    default void addShieldShipSaveData(CompoundTag tag) {
        ListTag shieldItems = new ListTag();
        for (int i = 0; i < this.getShields().size(); ++i) {
            ItemStack itemStack = this.getShields().get(i);
            if (!itemStack.isEmpty()) {
                CompoundTag inTag = new CompoundTag();
                inTag.putByte("Shields", (byte) i);
                Tag itemTag = itemStack.save(self().registryAccess(), inTag);
                shieldItems.add(itemTag);
            }
        }
        tag.put("Shields", shieldItems);
    }

    default List<ItemStack> getShields() {
        CompoundTag tag = self().getData(Ship.SHIELD_DATA);
        ListTag shieldItems = tag.getList("Shields").orElseThrow();

        List<ItemStack> shields = new ArrayList<>() {
            private <T> T updateDataAndReturn(T out) {
                ListTag shieldItems = new ListTag();
                for (int i = 0; i < this.size(); ++i) {
                    ItemStack itemStack = this.get(i);
                    CompoundTag inTag = new CompoundTag();
                    inTag.putByte("Shields", (byte) i);
                    Tag itemTag = itemStack.save(self().registryAccess(), inTag);
                    shieldItems.add(itemTag);
                }
                CompoundTag newTag = new CompoundTag();
                newTag.put("Shields", shieldItems);
                self().setData(Ship.SHIELD_DATA, newTag);
                return out;
            }

            @Override
            public boolean add(ItemStack newItemStack) {
                return updateDataAndReturn(super.add(newItemStack));
            }

            @Override
            public ItemStack removeLast() {
                return updateDataAndReturn(super.removeLast());
            }
        };

        for (int i = 0; i < shieldItems.size(); ++i) {
            CompoundTag shieldItem = shieldItems.getCompound(i).orElseThrow();
            ItemStack itemStack = ItemStack.parse(self().registryAccess(), shieldItem).orElse(ItemStack.EMPTY);
            if (!itemStack.isEmpty()) shields.add(itemStack);
        }
        return shields;
    }

    default float getDamageModifier() {
        return (float) (1.0F - getShields().size() * SmallShipsConfig.Common.shipGeneralShieldDamageReduction.get()/100F);
    }

   default boolean interactShield(Player player, InteractionHand interactionHand) {
       ItemStack itemStack = player.getItemInHand(interactionHand);
       int shieldCount = this.getShields().size();
       if (itemStack.is(Items.SHIELD)) {
           if (shieldCount >= this.getMaxShieldsPerSide() * 2) {
               return false;
           } else {
               this.getShields().add(itemStack.copy());
               if (!player.isCreative()) itemStack.shrink(1);
               self().getCommandSenderWorld().playSound(player, self().getX(), self().getY() + 4, self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.5F);
               return true;
           }
       } else if (itemStack.getItem() instanceof AxeItem && shieldCount > 0) {
           ItemStack removedShield = this.getShields().removeLast();
           if (self().level() instanceof ServerLevel serverLevel) self().spawnAtLocation(serverLevel, removedShield, 2);
           
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
