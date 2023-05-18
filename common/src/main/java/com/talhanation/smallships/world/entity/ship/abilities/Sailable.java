package com.talhanation.smallships.world.entity.ship.abilities;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;

import java.util.function.BiConsumer;

public interface Sailable extends Ability {

    default void tickSailShip() {
    }

    default void defineSailShipSynchedData() {
        self().getEntityData().define(Ship.SAIL_STATE, (byte) 0);
        self().getEntityData().define(Ship.SAIL_COLOR, SailModel.Color.WHITE.toString());
    }

    default void readSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = tag.getCompound("Sail");
        self().setData(Ship.SAIL_STATE, compoundTag.getByte("State"));
        self().setData(Ship.SAIL_COLOR, compoundTag.getString("Color"));

    }

    default void addSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("State", self().getData(Ship.SAIL_STATE));
        compoundTag.putString("Color", self().getData(Ship.SAIL_COLOR));
        tag.put("Sail", compoundTag);
    }

    default boolean interactSail(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        if (item.getItem() instanceof DyeItem dyeItem) {
            String color = dyeItem.getDyeColor().getName();
            if (color.equals(self().getData(Ship.SAIL_COLOR))) return false;
            self().setData(Ship.SAIL_COLOR, color);
            if (!player.isCreative()) item.shrink(1);
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOL_HIT, self().getSoundSource(), 15.0F, 1.5F);
            return true;
        }
        return false;
    }

    default void toggleSail() {
        if(!((BoatLeashAccess)this).isLeashed()) {
            byte state = self().getSailState();

            if (state == (byte) 0) {
                state = (byte) 1;

            } else {
                state = (byte) 0;
            }
            this.playSailSound(state);
            self().sailStateCooldown = getSailStateCooldown();
            self().setSailState(state);
        }
    }

    default void playSailSound(int state) {
        BiConsumer<SoundEvent, Pair<Float, Float>> play = (sound, modifier) -> {
            if (!self().getLevel().isClientSide()) self().playSound(sound, modifier.getFirst(), modifier.getSecond());
            else self().getLevel().playLocalSound(self().getX(), self().getY() + 4, self().getZ(), sound, self().getSoundSource(), modifier.getFirst(), modifier.getSecond(), false);
        };
        if (state != 0)
            play.accept(ModSoundTypes.SAIL_MOVE, Pair.of(15.0F, Math.max(0.5F, 1.4F - ((float) state / 5.0F))));
        else play.accept(ModSoundTypes.SAIL_PULL, Pair.of(10.0F, 1.0F));
    }


    default int getSailStateCooldown(){
        return 30; //TODO: CONFIG;
    }
}