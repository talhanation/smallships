package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
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

import java.util.List;

public interface Cannonable extends Ability {
    float getDefaultCannonPower();
    CannonPosition getCannonPosition(int index);
    byte getMaxCannonPerSide();

    default void tickCannonShip() {
        for(Cannon cannon : this.getCannons()) {
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
            this.setCannonCount(tag.getByte("CannonCount"));
            this.updateCannonCount();
        }
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        tag.putInt("CannonCount", this.getCannonCount());
    }

    default float getCannonModifier() {
        return this.getCannonCount() * SmallShipsConfig.Common.shipGeneralCannonModifier.get().floatValue();
    }

    default void updateCannonCount(){
        byte cannons = this.getCannonCount();

        this.getCannons().clear();
        for (int i = 0; i < cannons; i++) {
            CannonPosition cannonPosition = this.getCannonPosition(i);

            if(cannonPosition!= null){
                Cannon cannon = new Cannon(self(), cannonPosition);
                this.getCannons().add(cannon);
            }
        }

        this.setCannonCount(cannons);
    }
    default boolean interactCannon(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        byte cannonCount = this.getCannonCount();
        if (item.getItem() == ModItems.CANNON && self() instanceof ContainerShip) {
            if (cannonCount >= getMaxCannonPerSide() * 2) {
                return false;
            }
            else {
                this.setCannonCount((byte) (cannonCount + 1));

                self().level().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.5F);
                if (!player.isCreative()) item.shrink(1);

                this.updateCannonCount();
            }
            return true;
        } else if (item.getItem() instanceof AxeItem && cannonCount > 0) {
            this.setCannonCount((byte) (cannonCount - 1));

            self().spawnAtLocation(ModItems.CANNON);
            self().level().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.0F);
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

    default void setCannonCount(byte x) {
        self().getEntityData().set(Ship.CANNON_COUNT, x);
    }
    default byte getCannonCount() {
        return self().getEntityData().get(Ship.CANNON_COUNT);
    }

    default List<Cannon> getCannons() {
        return self().CANNONS;
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

