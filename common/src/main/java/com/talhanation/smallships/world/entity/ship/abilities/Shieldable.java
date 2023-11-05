package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public interface Shieldable extends Ability {

    ShieldPosition getShieldPosition(int index);
    byte getMaxShieldsPerSide();

    default void tickShieldShip() {

    }

    default void defineShieldShipSynchedData() {
        self().getEntityData().define(Ship.SHIELD_COUNT, (byte) 0);
    }

    default void readShieldShipSaveData(CompoundTag tag) {
        if (tag.contains("ShieldCount")) {
            this.setShieldCount(tag.getByte("ShieldCount"));
            //this.updateShield();
        }

        ListTag shieldItems = tag.getList("Shields", 10);
        for (int i = 0; i < shieldItems.size(); ++i) {
            CompoundTag compoundnbt = shieldItems.getCompound(i);

            ItemStack itemStack = ItemStack.of(compoundnbt);
            self().SHIELDS.add(itemStack);
        }
    }

    @SuppressWarnings("unused")
    default void addShieldShipSaveData(CompoundTag tag) {
        tag.putInt("ShieldCount", this.getShieldCount());

        ListTag listTag = new ListTag();
        for (int i = 0; i < self().SHIELDS.size(); ++i) {
            ItemStack itemstack = self().SHIELDS.get(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundnbt = new CompoundTag();
                compoundnbt.putByte("Shields", (byte) i);
                itemstack.save(compoundnbt);
                listTag.add(compoundnbt);
            }
        }
        tag.put("Shields", listTag);
    }

    default void saveToShieldData(ItemStack itemstack) {
        ListTag listTag = self().getShieldData().getList("Shields", 10);

        if (!itemstack.isEmpty()) {
            CompoundTag compoundnbt = new CompoundTag();
            byte index = (byte) (listTag.size() > 0 ? listTag.size() - 1 : 0);
            compoundnbt.putByte("Shields", index);
            itemstack.save(compoundnbt);
            listTag.add(compoundnbt);
        }

        CompoundTag newShields = new CompoundTag();
        newShields.put("Shields", listTag);

        self().setShieldData(newShields);
    }

    default void setShieldCount(byte x) {
        self().getEntityData().set(Ship.SHIELD_COUNT, x);
    }
    default byte getShieldCount() {
        return self().getEntityData().get(Ship.SHIELD_COUNT);
    }

   default boolean interactShield(Player player, InteractionHand interactionHand) {
       ItemStack item = player.getItemInHand(interactionHand);
       byte shieldCount = this.getShieldCount();
       if (item.getItem() instanceof ShieldItem shieldItem) {
           if (shieldCount >= getMaxShieldsPerSide() * 2) {
               return false;
           }
           else {
               this.setShieldCount((byte) (shieldCount + 1));
               this.saveToShieldData(shieldItem.getDefaultInstance());
               self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.5F);
               if (!player.isCreative()) item.shrink(1);
           }
           return true;
       } else if (item.getItem() instanceof AxeItem && shieldCount > 0) {
           this.setShieldCount((byte) (shieldCount - 1));

           self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.0F);
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
