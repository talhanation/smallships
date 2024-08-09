package com.talhanation.smallships.world.entity.ship.abilities;

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
import net.minecraft.world.item.Items;

import java.util.Stack;

public interface Shieldable extends Ability {

    ShieldPosition getShieldPosition(int index);
    byte getMaxShieldsPerSide();

    default void tickShieldShip() {
    }

    default void defineShieldShipSynchedData(SynchedEntityData.Builder builder) {
        builder.define(Ship.SHIELD_DATA, new CompoundTag());
    }

    default void readShieldShipSaveData(CompoundTag tag) {
        ListTag shieldItems = tag.getList("Shields", 10);

        for (int i = 0; i < shieldItems.size(); ++i) {
            CompoundTag compoundTag = shieldItems.getCompound(i);
            ItemStack itemStack = ItemStack.parse(self().registryAccess(), compoundTag).orElse(ItemStack.EMPTY);
            if (!itemStack.isEmpty()) self().SHIELDS.push(itemStack);
        }

        self().setShieldData(tag);
    }

    default void addShieldShipSaveData(CompoundTag tag) {
        ListTag listTag = new ListTag();
        for (int i = 0; i < self().SHIELDS.size(); ++i) {
            ItemStack itemstack = self().SHIELDS.get(i);
            if (!itemstack.isEmpty()) {
                CompoundTag inTag = new CompoundTag();
                inTag.putByte("Shields", (byte) i);
                Tag itemTag = itemstack.save(self().registryAccess(), inTag);
                listTag.add(itemTag);
            }
        }
        tag.put("Shields", listTag);

        self().setShieldData(tag);
    }
    default Stack<ItemStack> getShields() {
        if (self().SHIELDS.isEmpty() && !self().getShieldData().isEmpty() && this.self().getCommandSenderWorld().isClientSide())
            this.readShieldShipSaveData(self().getShieldData());
        return self().SHIELDS;
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
               this.getShields().push(itemStack.copy());
               if (!player.isCreative()) itemStack.shrink(1);
               self().getCommandSenderWorld().playSound(player, self().getX(), self().getY() + 4, self().getZ(), SoundEvents.WOOD_HIT, self().getSoundSource(), 15.0F, 1.5F);
               return true;
           }
       } else if (itemStack.getItem() instanceof AxeItem && shieldCount > 0) {
           ItemStack removedShield = this.getShields().pop();
           self().spawnAtLocation(removedShield, 2);

           // TODO: remove from SHIP_DATA as well
           
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
