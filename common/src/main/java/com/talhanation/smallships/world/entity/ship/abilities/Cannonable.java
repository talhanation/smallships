package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.entity.CannonBallEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import oshi.util.tuples.Pair;

import java.util.concurrent.atomic.AtomicBoolean;

public interface Cannonable extends Ability {
    CannonPosition getCannonPosition();
    byte getMaxCannonCountRight();
    byte getMaxCannonCountLeft();

    default void tickCannonShip() {
        if (self().tickCount % 2 == 0) {
            byte rc = this.getCannonCooldownRight();
            if (rc > 0) self().setData(Ship.CANNON_COOLDOWN_RIGHT, (byte) Math.max(rc - this.getCannonCountRight(), 0));
            byte lc = this.getCannonCooldownLeft();
            if (lc > 0) self().setData(Ship.CANNON_COOLDOWN_LEFT, (byte) Math.max(lc - this.getCannonCountLeft(), 0));
        }
    }

    default void defineCannonShipSynchedData() {
        self().getEntityData().define(Ship.CANNON_COUNT_RIGHT, (byte) 0);
        self().getEntityData().define(Ship.CANNON_COUNT_LEFT, (byte) 0);
        self().getEntityData().define(Ship.CANNON_COOLDOWN_RIGHT, (byte) 0);
        self().getEntityData().define(Ship.CANNON_COOLDOWN_LEFT, (byte) 0);
    }

    @SuppressWarnings("unused")
    default void readCannonShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = tag.getCompound("Cannon");
        CompoundTag count = compoundTag.getCompound("Count");
        self().setData(Ship.CANNON_COUNT_RIGHT, count.getByte("R"));
        self().setData(Ship.CANNON_COUNT_LEFT, count.getByte("L"));
        CompoundTag cooldown = tag.getCompound("Cooldown");
        self().setData(Ship.CANNON_COOLDOWN_RIGHT, cooldown.getByte("R"));
        self().setData(Ship.CANNON_COOLDOWN_LEFT, cooldown.getByte("L"));
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag count = new CompoundTag();
        count.putByte("R", self().getData(Ship.CANNON_COUNT_RIGHT));
        count.putByte("L", self().getData(Ship.CANNON_COUNT_LEFT));
        CompoundTag cooldown = new CompoundTag();
        cooldown.putByte("R", self().getData(Ship.CANNON_COOLDOWN_RIGHT));
        cooldown.putByte("L", self().getData(Ship.CANNON_COOLDOWN_LEFT));
        compoundTag.put("Count", count);
        compoundTag.put("Cooldown", cooldown);
        tag.put("Cannon", compoundTag);
    }

    default double getCannonDamage() {
        return 4.0D;
    }

    default byte getCannonCountRight() {
        return self().getData(Ship.CANNON_COUNT_RIGHT);
    }

    default byte getCannonCountLeft() {
        return self().getData(Ship.CANNON_COUNT_LEFT);
    }

    default byte getCannonCooldownRight() {
        return self().getData(Ship.CANNON_COOLDOWN_RIGHT);
    }

    default byte getCannonCooldownLeft() {
        return self().getData(Ship.CANNON_COOLDOWN_LEFT);
    }

    default byte getCooldownTime() {
        return 50;
    }

    default boolean interactCannon(Player player, InteractionHand interactionHand) {
        ItemStack item = player.getItemInHand(interactionHand);
        if (item.getItem() == ModItems.CANNON) {
            Pair<Vec3, Boolean> side = this.getInteractionSide(player);
            boolean isRightSide = side.getB();

            if (!isRightSide) {
                if (this.getCannonCountRight() >= this.getMaxCannonCountRight()) return false;
                else self().setData(Ship.CANNON_COUNT_RIGHT, (byte) (this.getCannonCountRight() + 1));
            } else {
                if (this.getCannonCountLeft() >= this.getMaxCannonCountLeft()) return false;
                else self().setData(Ship.CANNON_COUNT_LEFT, (byte) (this.getCannonCountLeft() + 1));
            }

            if (!player.isCreative()) item.shrink(1);
            self().level.playSound(null, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.5F);
            return true;
        } else if (item.getItem() instanceof AxeItem) {
            Pair<Vec3, Boolean> side = this.getInteractionSide(player);

            if (!side.getB()) {
                if (this.getCannonCountRight() <= 0) return false;
                else self().setData(Ship.CANNON_COUNT_RIGHT, (byte) (this.getCannonCountRight() - 1));
            } else {
                if (this.getCannonCountLeft() <= 0) return false;
                else self().setData(Ship.CANNON_COUNT_LEFT, (byte) (this.getCannonCountLeft() - 1));
            }

            self().spawnAtLocation(ModItems.CANNON);
            self().level.playSound(null, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.0F);
            return true;
        }
        return false;
    }

    default boolean canShoot() {
        AtomicBoolean isPresent = new AtomicBoolean(false);
        if (self() instanceof ContainerEntity containerEntity) containerEntity.getItemStacks().stream()
                .filter(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL))
                .findFirst()
                .ifPresent(itemStack -> {
                    itemStack.shrink(1);
                    isPresent.set(true);
                });
        else if (self().getControllingPassenger() instanceof Player player) player.getInventory().items.stream()
                .filter(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL))
                .findFirst()
                .ifPresent(itemStack -> {
                    itemStack.shrink(1);
                    isPresent.set(true);
                });
        return isPresent.get();
    }

    default void shoot(LivingEntity triggeringEntity) {
        Pair<Vec3, Boolean> side = this.getInteractionSide(triggeringEntity);
        boolean isRightSide = side.getB();
        if ((isRightSide ? this.getCannonCooldownRight() : this.getCannonCooldownLeft()) > 0) return;
        if ((isRightSide ? this.getCannonCountRight() : this.getCannonCountLeft()) <= 0) return;
        if (!this.canShoot()) return;

        double offset = -0.3F - ((isRightSide ? this.getCannonCountRight() : this.getCannonCountLeft()) - 1.0F) * 1.6F;

        float f0 = Mth.cos(self().getYRot() * ((float) Math.PI / 180F)) * (isRightSide ? -1.0F : 1.0F);
        float f1 = Mth.sin(self().getYRot() * ((float) Math.PI / 180F)) * (isRightSide ? -1.0F : 1.0F);

        Vec3 forwardVec = self().getForward().normalize();
        double d = self().getX() - forwardVec.x * offset + (double) f0;
        double e = self().getY() - forwardVec.y + 1;
        double f = self().getZ() - forwardVec.z * offset + (double) f1;

        CannonBallEntity cannonBall = new CannonBallEntity(ModEntityTypes.CANNON_BALL, d, e, f, triggeringEntity.getLevel());
        cannonBall.setBaseDamage(this.getCannonDamage());
        cannonBall.setOwner(triggeringEntity);

        Vec3 positionVec = side.getA();
        double angleY = triggeringEntity.getLookAngle().y;
        cannonBall.shoot(positionVec.x, positionVec.y + (angleY > 0 ? angleY * 0.75D : positionVec.y * 0.25D), positionVec.z, 3.0F, 1.0F);
        self().getLevel().playSound(null, self().getX(), self().getY() + 4, self().getZ(), ModSoundTypes.CANNON_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (self().getLevel().getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
        self().getLevel().addFreshEntity(cannonBall);

        self().setData(isRightSide ? Ship.CANNON_COOLDOWN_RIGHT : Ship.CANNON_COOLDOWN_LEFT, this.getCooldownTime());

        if (triggeringEntity instanceof Player player) player.awardStat(Stats.ITEM_USED.get(ModItems.CANNON));
    }

    default Pair<Vec3, Boolean> getInteractionSide(LivingEntity entity){
        Vec3 forwardVec = self().getForward().normalize();
        Vec3 rightVec = forwardVec.yRot(-3.14F/2).normalize();
        Vec3 leftVec  = forwardVec.yRot(3.14F/2).normalize();

        Vec3 controllerVec = entity.getLookAngle().normalize();

        if (controllerVec.distanceTo(leftVec) > controllerVec.distanceTo(rightVec)) {
            return new Pair<>(rightVec, true);
        } else {
            return new Pair<>(leftVec, false);
        }
    }

    default ResourceLocation getTextureLocation() {
        return new ResourceLocation(SmallshipsMod.MOD_ID,"textures/entity/cannon/ship_cannon.png");
    }

    @SuppressWarnings("ClassCanBeRecord")
    class CannonPosition {
        public final double offsetY;
        public final double offsetZ;
        public final float angle;

        public CannonPosition(double offsetY, double offsetZ, float angle) {
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
            this.angle = angle;
        }
    }
}
