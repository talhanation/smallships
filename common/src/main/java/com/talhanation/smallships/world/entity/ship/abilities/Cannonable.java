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
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import net.minecraft.world.entity.Entity;
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
    float CANNON_ANGLE_MIN = -10.0F;
    /** Maximum aim angle in degrees (up). */
    float CANNON_ANGLE_MAX = 30.0F;
    /** Maximum aim rotation in degrees to each side. */
    float CANNON_ROTATION_MAX = 10.0F;

    CannonPosition getCannonPosition(int index);
    byte getMaxCannonPerSide();


    /* ---------------- cannon slots (dockyard mounting) ---------------- */

    /** @return true if the given cannon slot is occupied. */
    default boolean isCannonInSlot(int slot) {
        return self().getData(Ship.CANNON_SLOTS).getBoolean("S" + slot);
    }

    default void setCannonInSlot(int slot, boolean occupied) {
        CompoundTag tag = self().getData(Ship.CANNON_SLOTS).copy();
        if (occupied) tag.putBoolean("S" + slot, true);
        else tag.remove("S" + slot);
        self().setData(Ship.CANNON_SLOTS, tag);
        this.updateCannons();
    }

    default int getTotalCannonSlots() {
        return this.getMaxCannonPerSide() * 2;
    }

    default void tickCannonShip() {
        for(ShipCannon cannon : this.getCannons()) {
            cannon.tick();
            if(self().isCannonKeyPressed() && canShoot()){
                // the driver's volley skips manned cannons - their gunners fire themselves
                if (this instanceof Seatable seatable && seatable.getGunner(cannon.getSlotIndex()) != null) continue;
                this.triggerCannon(cannon);
            }
        }
    }

    /**
     * Fires the single cannon in the given slot, triggered by its gunner.
     * The gunner's cannon fires regardless of the driver's look direction.
     */
    default void triggerGunnerCannon(int slot) {
        if (!canShoot()) return;
        for (ShipCannon cannon : this.getCannons()) {
            if (cannon.getSlotIndex() == slot) {
                cannon.trigger(this instanceof Seatable seatable ? seatable.getGunner(slot) : null);
                return;
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


    /* ---------------- per-cannon aim (gunner seats) ---------------- */

    /**
     * @return the effective aim angle for a specific cannon slot: the gunner's
     * per-cannon aim if the mapped seat is manned and set, otherwise the
     * driver's broadside aim.
     */
    default float getCannonAngle(int slot, boolean rightSide) {
        if (this.hasPerCannonAim(slot)) {
            return self().getData(Ship.CANNON_AIM).getFloat("C" + slot + "Angle");
        }
        return this.getCannonAngle(rightSide);
    }

    default float getCannonRotation(int slot, boolean rightSide) {
        if (this.hasPerCannonAim(slot)) {
            return self().getData(Ship.CANNON_AIM).getFloat("C" + slot + "Rotation");
        }
        return this.getCannonRotation(rightSide);
    }

    default boolean hasPerCannonAim(int slot) {
        if (!(this instanceof Seatable seatable) || seatable.getGunner(slot) == null) return false;
        return self().getData(Ship.CANNON_AIM).contains("C" + slot + "Angle");
    }

    /**
     * Sets the per-cannon aim (gunner) or, with slot = -1, the broadside aim
     * of the given side (driver, existing behavior).
     */
    default void setCannonAim(int slot, boolean rightSide, float angle, float rotation) {
        if (slot < 0) {
            this.setCannonAim(rightSide, angle, rotation);
            return;
        }
        angle = Mth.clamp(angle, CANNON_ANGLE_MIN, CANNON_ANGLE_MAX);
        rotation = Mth.clamp(rotation, -CANNON_ROTATION_MAX, CANNON_ROTATION_MAX);
        CompoundTag tag = self().getData(Ship.CANNON_AIM).copy();
        tag.putFloat("C" + slot + "Angle", angle);
        tag.putFloat("C" + slot + "Rotation", rotation);
        self().setData(Ship.CANNON_AIM, tag);
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
        if (tag.contains("CannonSlots")) {
            self().setData(Ship.CANNON_SLOTS, tag.getCompound("CannonSlots"));
        } else if (tag.contains("CannonCount")) {
            // migration from old saves: CannonCount = n fills the slots 0..n-1
            CompoundTag slots = new CompoundTag();
            int count = tag.getByte("CannonCount");
            for (int slot = 0; slot < Math.min(count, this.getTotalCannonSlots()); slot++) {
                slots.putBoolean("S" + slot, true);
            }
            self().setData(Ship.CANNON_SLOTS, slots);
        }
        if (tag.contains("CannonAim")) {
            self().setData(Ship.CANNON_AIM, tag.getCompound("CannonAim"));
        }
        this.updateCannons();
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        tag.putInt("CannonCount", this.getCannonCount());
        tag.put("CannonSlots", self().getData(Ship.CANNON_SLOTS));
        tag.put("CannonAim", self().getData(Ship.CANNON_AIM));
    }

    default float getCannonModifier() {
        return this.getCannonCount() * SmallShipsConfig.Common.shipGeneralCannonModifier.get().floatValue();
    }

    /**
     * Rebuilds the ShipCannon list from the occupied slots.
     */
    default void updateCannons() {
        this.getCannons().clear();
        byte count = 0;
        for (int slot = 0; slot < this.getTotalCannonSlots(); slot++) {
            if (!this.isCannonInSlot(slot)) continue;
            CannonPosition cannonPosition = this.getCannonPosition(slot);
            if (cannonPosition != null) {
                this.getCannons().add(new ShipCannon(self(), cannonPosition, slot));
                count++;
            }
        }
        this.setCannonCount(count);
        this.clearOccupiedCarriages();
    }

    /**
     * Throws whoever is sitting on a carriage off as soon as a gun is put on it.
     *
     * Only CANNON seats are touched, never GUNNER posts - the seat type alone
     * decides, so this stays correct through every world load and every rebuild
     * of the cannon list. A real gunner is never on one of these seats.
     */
    private void clearOccupiedCarriages() {
        if (self().level().isClientSide()) return;
        if (!(this instanceof Seatable seatable)) return;

        for (ShipSeat seat : seatable.getSeats()) {
            if (seat.type() != SeatType.CANNON) continue;
            if (!this.isCannonInSlot(seat.mappedCannonSlot())) continue;

            Entity occupant = seatable.getSeatOccupant(seat.id());
            if (occupant != null) occupant.stopRiding();
        }
    }

    /** @deprecated kept as alias, use {@link #updateCannons()} */
    @Deprecated
    default void updateCannonCount() {
        this.updateCannons();
    }
    // Feature: cannons are mounted/dismounted at the DOCKYARD only,
    // the old field mounting via right click (interactCannon) was removed.

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

    /**
     * Peeks whether a fine grain powder is available WITHOUT consuming it.
     * Used client side for the trajectory preview - the actual shot uses
     * consumeFineGrainPowder(), which shrinks the stack.
     *
     * @return true if a fine grain powder is in the ship container or the
     * driver's inventory
     */
    default boolean hasFineGrainPowder() {
        if (self() instanceof ContainerEntity containerEntity){
            for (ItemStack itemStack : containerEntity.getItemStacks()) {
                if (itemStack.is(ModItems.FINE_GRAIN_POWDER)) return true;
            }
        }
        if(self().getControllingPassenger() instanceof Player player) {
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.is(ModItems.FINE_GRAIN_POWDER)) return true;
            }
        }
        return false;
    }

    /**
     * The projectile speed multiplier of the NEXT shot: the loaded ball type's
     * own multiplier, times 1.5 if a fine grain powder is available. Single
     * source of truth so the trajectory preview matches the real shot (see
     * ShipCannon.trigger). Returns the BALL default when nothing is loaded.
     *
     * @param peekFineGrain true = only check for fine grain (preview), false =
     *                      caller consumes it separately (real shot uses
     *                      consumeFineGrainPowder instead)
     */
    default float getShotSpeedMultiplier(boolean peekFineGrain) {
        CannonBallItem ammo = this.getCannonBallToShoot();
        float multiplier = ammo != null ? ammo.getType().speedMultiplier : CannonBallItem.Type.BALL.speedMultiplier;
        if (peekFineGrain && this.hasFineGrainPowder()) multiplier *= 1.5F;
        return multiplier;
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

    double getCannonAimY();

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