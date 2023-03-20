package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.Cannon;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.item.ItemStack;

public interface Cannonable extends Ability {
    float getDefaultCannonPower();
    byte getMaxCannonPerSide();
    void setCannonPos();

    default void tickCannonShip() {
        for(Cannon cannon : self().CANNONS) {
            cannon.tick();
            if(self().isCannonKeyPressed() && canShoot()){

                if(cannon.canShootDirection()) cannon.trigger();
            }
        }
    }

    default byte getCannonCount(){
        byte cannons = 0;
        if(self() instanceof ContainerShip ship) {
            for (int i = 0; i < ship.getContainerSize(); i++) {
                ItemStack stackInSlot = ship.getItem(i);
                if (stackInSlot.is(ModItems.CANNON)) {
                    cannons++;
                }
            }
        }
        return cannons;
    }

    default void defineCannonShipSynchedData() {
        self().getEntityData().define(Ship.CANNON_POWER, this.getDefaultCannonPower());
    }

    @SuppressWarnings("unused")
    default void readCannonShipSaveData(CompoundTag tag) {

    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {

    }

    default void updateCannonCount(){
        this.setCannonPos();
        byte cannons = getCannonCount();

        if (cannons > getMaxCannonPerSide() * 2) {
            cannons = (byte) (getMaxCannonPerSide() * 2);
        }

        self().CANNONS.clear();
        for (int i = 0; i < cannons; i++) {
            CannonPosition cannonPosition = self().getCannonPos(i);

            if(cannonPosition!= null){
                Cannon cannon = new Cannon(self(), cannonPosition);
                self().CANNONS.add(cannon);
            }
        }
    }

    default boolean interactCannon(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        if (item.getItem() == ModItems.CANNON) {

            if (!player.isCreative()) item.shrink(1);
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.5F);
            if(self() instanceof ContainerShip containerShip) containerShip.addItemToFreeSlot(item);
            return true;
        }
        return false;
    }

    default boolean canShoot() {
        if (self() instanceof ContainerEntity containerEntity){
            return containerEntity.getItemStacks()
                    .stream()
                    .anyMatch(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL));
        }
        else if(self().getControllingPassenger() instanceof Player player) {
            return player.getInventory().items
                    .stream()
                    .anyMatch(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL));
        }
        else
            return false;
    }

    default void consumeCannonBall() {
        if (self() instanceof ContainerEntity containerEntity){
            for(ItemStack itemstack: containerEntity.getItemStacks()){
                if(itemstack.is((ModItems.CANNON_BALL))){
                    itemstack.shrink(1);
                    break;
                }
            }
        }

        else if(self().getControllingPassenger() instanceof Player player) {
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.is((ModItems.CANNON_BALL))) {
                    itemstack.shrink(1);
                    break;
                }
            }
        }
    }
    default ResourceLocation getTextureLocation() {
        return new ResourceLocation(SmallShipsMod.MOD_ID,"textures/entity/cannon/ship_cannon.png");
    }


    @SuppressWarnings("ClassCanBeRecord")
    class CannonPosition {
        public final double x;
        public final double y;
        public final double z;
        public final boolean isRightSided;

        public CannonPosition(double x, double y, double z, boolean isRightSided) {
            if(!isRightSided){
                this.x = -x;//dont ask just accept
                this.y = y;
                this.z = -z;//dont ask just accept
            }
            else {
                this.x = x;
                this.y = y;
                this.z = z;
            }

            this.isRightSided = isRightSided;
        }
    }
}

