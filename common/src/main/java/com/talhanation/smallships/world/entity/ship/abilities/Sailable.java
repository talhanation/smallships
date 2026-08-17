package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;

import static com.talhanation.smallships.world.entity.ship.Ship.SAIL_STATE;

public interface Sailable extends Ability {

    /**
     * @return how many sails this ship carries. Counted from the mast parts,
     * because a mast IS the carrier of a sail and the same definitions already
     * drive the collision, the mass and the preview scale - a ship that gets a
     * second mast gets a second sail without anything else being touched.
     */
    default int getSailCount() {
        int masts = 0;
        for (ShipPartEntity.Definition part : self().getParts()) {
            if (part.mast()) masts++;
        }
        return Math.max(1, masts);
    }

    default void tickSailShip() {
        if (self().sailStateCooldown > 0) self().sailStateCooldown--;
    }

    default void readSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = tag.getCompound("Sail");
        self().setData(SAIL_STATE, compoundTag.getByte("State"));
        self().setData(Ship.SAIL_COLOR, compoundTag.getString("Color"));
        SailDamage.readSaveData(self(), compoundTag);
        // A ship saved before the pool was sized by mast count carries exactly
        // one sails' worth. Topping it up once on load is cheaper and less
        // surprising than making the player pay to repair canvas that was never
        // shot at. Can go once every world has been loaded on this version.
        if (SailDamage.getHealth(self()) == SailDamage.HEALTH_PER_SAIL
                && SailDamage.getMaxHealth(self()) > SailDamage.HEALTH_PER_SAIL) {
            SailDamage.repair(self());
        }

    }

    default void addSailShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("State", self().getData(SAIL_STATE));
        compoundTag.putString("Color", self().getData(Ship.SAIL_COLOR));
        SailDamage.addSaveData(self(), compoundTag);
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
        // sail repair with wool has priority over dyeing
        if (SailDamage.interactRepair(self(), player, interactionHand)) return true;

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
        if(!this.self().isShipLeashed()) {
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