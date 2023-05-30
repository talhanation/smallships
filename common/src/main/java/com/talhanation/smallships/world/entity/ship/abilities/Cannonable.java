package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.world.entity.projectile.Cannon;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;

public interface Cannonable extends Ability {
    float getDefaultCannonPower();
    CannonPosition getCannonPosition(int index);
    byte getMaxCannonPerSide();

    default void tickCannonShip() {
        for(Cannon cannon : self().CANNONS) {
            cannon.tick();
            if(self().isCannonKeyPressed() && canShoot()){

                if(cannon.canShootDirection()) cannon.trigger();
            }
        }
    }

    default void defineCannonShipSynchedData() {
        self().getEntityData().define(Ship.CANNON_POWER, this.getDefaultCannonPower());
        self().getEntityData().define(Ship.CANNON_COUNT, (byte) 0);
    }

    @SuppressWarnings("unused")
    default void readCannonShipSaveData(CompoundTag tag) {
        if (tag.contains("CannonCount")) {
            self().setCannonCount(tag.getByte("CannonCount"));
            this.updateCannonCount();
        }
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        tag.putInt("CannonCount", self().getCannonCount());
    }

    default float getCannonModifier() {
        return (int)self().getCannonCount() * 0.025F;
    }

    default void updateCannonCount(){
        byte cannons = self().getCannonCount();

        self().CANNONS.clear();
        for (int i = 0; i < cannons; i++) {
            CannonPosition cannonPosition = this.getCannonPosition(i);

            if(cannonPosition!= null){
                Cannon cannon = new Cannon(self(), cannonPosition);
                self().CANNONS.add(cannon);
            }
        }

        self().setCannonCount(cannons);
    }
    default boolean interactCannon(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        byte cannons = self().getCannonCount();
        if (item.getItem() == ModItems.CANNON && self() instanceof ContainerShip) {
            if (cannons >= getMaxCannonPerSide() * 2) {
                return false;
            }
            else {
                self().setCannonCount((byte) (cannons + 1));

                self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.5F);
                if (!player.isCreative()) item.shrink(1);

                this.updateCannonCount();
            }
            return true;
        } else if (item.getItem() instanceof AxeItem && cannons > 0) {
            self().setCannonCount((byte) (cannons - 1));

            self().spawnAtLocation(ModItems.CANNON);
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.0F);
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
            this.x = x;
            this.y = y;
            this.z = z;
            this.isRightSided = isRightSided;
        }
    }
}

