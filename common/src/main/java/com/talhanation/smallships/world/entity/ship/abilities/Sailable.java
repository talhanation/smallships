package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.client.model.sail.SailModel;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.duck.BoatLeashAccess;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;

import static com.talhanation.smallships.world.entity.ship.Ship.SAIL_STATE;

public interface Sailable extends Ability {

    default void tickSailShip() {
        if (self().sailStateCooldown > 0) self().sailStateCooldown--;
    }

    default void defineSailShipSynchedData() {
        self().getEntityData().define(SAIL_STATE, (byte) 0);
        self().getEntityData().define(Ship.SAIL_COLOR, SailModel.Color.WHITE.toString());
    }

    default void readSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = tag.getCompound("Sail");
        self().setData(SAIL_STATE, compoundTag.getByte("State"));
        self().setData(Ship.SAIL_COLOR, compoundTag.getString("Color"));

    }

    default void addSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("State", self().getData(SAIL_STATE));
        compoundTag.putString("Color", self().getData(Ship.SAIL_COLOR));
        tag.put("Sail", compoundTag);
    }

    default void controlBoatSailShip() {
        byte sailState = this.getSailState();
        if(sailState != 0) {
            if (self().isForward()) {
                if (sailState != 4) {
                    if(self().sailStateCooldown == 0){
                        sailState++;
                        if (!self().level().isClientSide()) {
                            this.playSailSound(sailState);
                        }
                        self().sailStateCooldown = this.getSailStateCooldown();
                        this.setSailState(sailState);
                    }
                }
            }

            if (self().isBackward()) {
                if (sailState != 1) {
                    if(self().sailStateCooldown == 0) {
                        sailState--;
                        if (!self().level().isClientSide()) {
                            this.playSailSound(sailState);
                        }
                        self().sailStateCooldown = this.getSailStateCooldown();
                        this.setSailState(sailState);
                    }
                }
            }
        }
    }

    default boolean interactSail(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        if (item.getItem() instanceof DyeItem dyeItem) {
            String color = dyeItem.getDyeColor().getName();
            if (color.equals(self().getData(Ship.SAIL_COLOR))) return false;
            self().setData(Ship.SAIL_COLOR, color);
            if (!player.isCreative()) item.shrink(1);
            self().level().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.WOOL_HIT, self().getSoundSource(), 15.0F, 1.5F);
            return true;
        }
        return false;
    }

    default void toggleSail() {
        if(!((BoatLeashAccess)this).isLeashed()) {
            byte state = this.getSailState();
            if (state > 0) state = 0;
            else state = 1;
            this.setSailState(state);
            this.playSailSound(state);
        }
    }

    default void playSailSound(int state) {
        if (state != 0) self().playSound(ModSoundTypes.SAIL_MOVE, 15.0F, Math.max(0.5F, 1.4F - ((float) state / 5.0F)));
        else self().playSound(ModSoundTypes.SAIL_PULL, 10.0F, 1.0F);
    }


    default int getSailStateCooldown(){
        return SmallShipsConfig.Common.shipGeneralSailCooldown.get();
    }

    default void setSailState(byte state) {
        self().setData(SAIL_STATE, state);
    }
    default byte getSailState() {
        return self().getData(SAIL_STATE);
    }
}