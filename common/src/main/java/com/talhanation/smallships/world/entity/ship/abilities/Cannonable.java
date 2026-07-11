package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.cannon.ShipCannon;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public interface Cannonable extends Ability {
    /** Minimum aim angle in degrees (down). */
    float CANNON_ANGLE_MIN = -20.0F;
    /** Maximum aim angle in degrees (up). */
    float CANNON_ANGLE_MAX = 60.0F;
    /** Maximum aim rotation in degrees to each side. */
    float CANNON_ROTATION_MAX = 10.0F;

    CannonPosition getCannonPosition(int index);
    byte getMaxCannonPerSide();

    default void tickCannonShip() {
        for(ShipCannon cannon : this.getCannons()) {
            cannon.tick();
            if(self().isCannonKeyPressed() && canShoot()){
                this.triggerCannon(cannon);
            }
        }
    }
    default void triggerCannon(ShipCannon cannon){
        if(cannon.canShootDirection()) cannon.trigger();
    }

    //Important for reflection
    default void triggerCannons(Vec3 shootVec, double yShootVec, LivingEntity driverEntity, double speed, double accuracy){
        if(canShoot()){
            for(ShipCannon cannon : this.getCannons())
                this.triggerCannonAdvanced(cannon,shootVec, yShootVec, driverEntity, speed, accuracy);
        }
    }
    default void triggerCannonAdvanced(ShipCannon cannon, Vec3 shootVec, double yShootVec, LivingEntity driverEntity, double speed, double accuracy){
        if(cannon.canShootDirection()) cannon.trigger(shootVec, yShootVec, driverEntity, speed, accuracy);
    }

    /* ---------------- Broadside aim (Better Cannon Gameplay) ---------------- */

    /**
     * @param rightSide true = starboard broadside
     * @return the aim angle of the broadside in degrees, positive = up. Range [-20, 60].
     */
    default float getCannonAngle(boolean rightSide) {
        CompoundTag tag = self().getData(Ship.CANNON_AIM);
        String key = rightSide ? "StarboardAngle" : "PortAngle";
        return tag.contains(key) ? tag.getFloat(key) : 0.0F;
    }

    /**
     * @param rightSide true = starboard broadside
     * @return the aim rotation of the broadside in degrees, positive = towards the bow. Range [-10, 10].
     */
    default float getCannonRotation(boolean rightSide) {
        CompoundTag tag = self().getData(Ship.CANNON_AIM);
        String key = rightSide ? "StarboardRotation" : "PortRotation";
        return tag.contains(key) ? tag.getFloat(key) : 0.0F;
    }

    /**
     * Sets and clamps the aim of one broadside. The values are persisted with
     * the ship ("Changed angle will be fix").
     */
    default void setCannonAim(boolean rightSide, float angle, float rotation) {
        angle = Mth.clamp(angle, CANNON_ANGLE_MIN, CANNON_ANGLE_MAX);
        rotation = Mth.clamp(rotation, -CANNON_ROTATION_MAX, CANNON_ROTATION_MAX);
        CompoundTag tag = self().getData(Ship.CANNON_AIM).copy();
        tag.putFloat(rightSide ? "StarboardAngle" : "PortAngle", angle);
        tag.putFloat(rightSide ? "StarboardRotation" : "PortRotation", rotation);
        self().setData(Ship.CANNON_AIM, tag);
    }

    @SuppressWarnings("unused")
    default void readCannonShipSaveData(CompoundTag tag) {
        if (tag.contains("CannonCount")) {
            this.setCannonCount(tag.getByte("CannonCount"));
            this.updateCannonCount();
        }
        if (tag.contains("CannonAim")) {
            self().setData(Ship.CANNON_AIM, tag.getCompound("CannonAim"));
        }
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        tag.putInt("CannonCount", this.getCannonCount());
        tag.put("CannonAim", self().getData(Ship.CANNON_AIM));
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
                ShipCannon cannon = new ShipCannon(self(), cannonPosition);
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

                self().level().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN.value(), self().getSoundSource(), 15.0F, 1.5F);
                if (!player.isCreative()) item.shrink(1);

                this.updateCannonCount();
            }
            return true;
        } else if (item.getItem() instanceof AxeItem && cannonCount > 0) {
            this.setCannonCount((byte) (cannonCount - 1));

            self().spawnAtLocation(ModItems.CANNON);
            self().level().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN.value(), self().getSoundSource(), 15.0F, 1.0F);
            return true;
        }
        return false;
    }

    /* ---------------- ammunition ---------------- */

    default boolean canShoot() {
        return this.getCannonBallToShoot() != null;
    }

    /**
     * @return the cannonball item that would be shot next: the first
     * CannonBallItem of any type found in the ship container or the
     * driver's inventory. Null if there is none.
     */
    default CannonBallItem getCannonBallToShoot() {
        if (self() instanceof ContainerEntity containerEntity){
            for (ItemStack itemStack : containerEntity.getItemStacks()) {
                if (itemStack.getItem() instanceof CannonBallItem cannonBallItem) return cannonBallItem;
            }
        }
        if(self().getControllingPassenger() instanceof Player player) {
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.getItem() instanceof CannonBallItem cannonBallItem) return cannonBallItem;
            }
        }
        return null;
    }

    default void consumeCannonBall() {
        if (self() instanceof ContainerEntity containerEntity){
            for(ItemStack itemstack: containerEntity.getItemStacks()){
                if(itemstack.getItem() instanceof CannonBallItem){
                    itemstack.shrink(1);
                    return;
                }
            }
        }

        if(self().getControllingPassenger() instanceof Player player) {
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.getItem() instanceof CannonBallItem) {
                    itemstack.shrink(1);
                    return;
                }
            }
        }
    }

    /**
     * Tries to consume one fine grain powder from the ship container or the
     * driver's inventory. If successful, the shot gains 50% projectile speed.
     *
     * @return true if a fine grain powder was consumed
     */
    default boolean consumeFineGrainPowder() {
        if (self() instanceof ContainerEntity containerEntity){
            for(ItemStack itemstack: containerEntity.getItemStacks()){
                if(itemstack.is(ModItems.FINE_GRAIN_POWDER)){
                    itemstack.shrink(1);
                    return true;
                }
            }
        }
        if(self().getControllingPassenger() instanceof Player player) {
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.is(ModItems.FINE_GRAIN_POWDER)) {
                    itemstack.shrink(1);
                    return true;
                }
            }
        }
        return false;
    }

    default ResourceLocation getTextureLocation() {
        return ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID,"textures/entity/cannon/ship_cannon.png");
    }

    default void setCannonCount(byte x) {
        self().getEntityData().set(Ship.CANNON_COUNT, x);
    }
    default byte getCannonCount() {
        return self().getEntityData().get(Ship.CANNON_COUNT);
    }

    default List<ShipCannon> getCannons() {
        return self().CANNONS;
    }

    default void cannonShipDestroyed(Level level, Ship ship){
        for(int i = 0; i < getCannonCount(); i++){
            ship.spawnAtLocation(ModItems.CANNON,4);
        }
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
