package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.SmallshipsMod;
import com.talhanation.smallships.world.entity.CannonBallEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
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
    float getDefaultCannonPower();

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
        self().getEntityData().define(Ship.CANNON_POWER, this.getDefaultCannonPower());
    }

    @SuppressWarnings("unused")
    default void readCannonShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = tag.getCompound("Cannon");
        CompoundTag countTag = compoundTag.getCompound("Count");
        self().setData(Ship.CANNON_COUNT_RIGHT, countTag.getByte("R"));
        self().setData(Ship.CANNON_COUNT_LEFT, countTag.getByte("L"));
        CompoundTag cooldownTag = compoundTag.getCompound("Cooldown");
        self().setData(Ship.CANNON_COOLDOWN_RIGHT, cooldownTag.getByte("R"));
        self().setData(Ship.CANNON_COOLDOWN_LEFT, cooldownTag.getByte("L"));
        self().setData(Ship.CANNON_POWER, compoundTag.getFloat("Power"));
    }

    @SuppressWarnings("unused")
    default void addCannonShipSaveData(CompoundTag tag) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag countTag = new CompoundTag();
        countTag.putByte("R", self().getData(Ship.CANNON_COUNT_RIGHT));
        countTag.putByte("L", self().getData(Ship.CANNON_COUNT_LEFT));
        CompoundTag cooldownTag = new CompoundTag();
        cooldownTag.putByte("R", self().getData(Ship.CANNON_COOLDOWN_RIGHT));
        cooldownTag.putByte("L", self().getData(Ship.CANNON_COOLDOWN_LEFT));
        compoundTag.put("Count", countTag);
        compoundTag.put("Cooldown", cooldownTag);
        compoundTag.putFloat("Power", self().getData(Ship.CANNON_POWER));
        tag.put("Cannon", compoundTag);
    }

    default float getCannonPower() {
        return self().getData(Ship.CANNON_POWER);
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
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.5F);
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
            self().getLevel().playSound(player, self().getX(), self().getY() + 4 , self().getZ(), SoundEvents.ARMOR_EQUIP_CHAIN, self().getSoundSource(), 15.0F, 1.0F);
            return true;
        }
        return false;
    }

    default boolean canShoot(boolean isRightSide) {
        if ((isRightSide ? this.getCannonCooldownRight() : this.getCannonCooldownLeft()) > 0) return false;
        if ((isRightSide ? this.getCannonCountRight() : this.getCannonCountLeft()) <= 0) return false;
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
        if (!this.canShoot(isRightSide)) return;

        double offset = -0.3F - ((isRightSide ? this.getCannonCountRight() : this.getCannonCountLeft()) - 1.0F) * 1.6F;

        float f0 = Mth.cos(self().getYRot() * ((float) Math.PI / 180F)) * (isRightSide ? -1.0F : 1.0F);
        float f1 = Mth.sin(self().getYRot() * ((float) Math.PI / 180F)) * (isRightSide ? -1.0F : 1.0F);

        Vec3 forwardVec = self().getForward().normalize();
        double d = self().getX() - forwardVec.x * offset + (double) f0;
        double e = self().getY() - forwardVec.y + 1;
        double f = self().getZ() - forwardVec.z * offset + (double) f1;

        CannonBallEntity cannonBall = new CannonBallEntity(ModEntityTypes.CANNON_BALL, d, e, f, triggeringEntity.getLevel());
        cannonBall.setBaseDamage(this.getCannonPower());
        cannonBall.setOwner(triggeringEntity);

        Vec3 positionVec = side.getA();
        double angleY = triggeringEntity.getLookAngle().y;
        this.shootParticles(cannonBall, (int) (20 * this.getCannonPower()));
        cannonBall.shoot(positionVec.x, positionVec.y + (angleY > 0 ? angleY * 0.75D : positionVec.y * 0.25D), positionVec.z, 3.0F, 1.0F);
        self().playSound(ModSoundTypes.CANNON_SHOOT, 1.0F, 1.0F / (self().getLevel().getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
        self().getLevel().addFreshEntity(cannonBall);

        self().setData(isRightSide ? Ship.CANNON_COOLDOWN_RIGHT : Ship.CANNON_COOLDOWN_LEFT, this.getCooldownTime());

        if (triggeringEntity instanceof Player player) player.awardStat(Stats.ITEM_USED.get(ModItems.CANNON));
    }

    default void shootParticles(CannonBallEntity cannonBallEntity, int power){
        for (int i = 0; i < power; ++i) {
            self().getLevel().addParticle(ParticleTypes.POOF, cannonBallEntity.getRandomX(1.5D), cannonBallEntity.getRandomY(), cannonBallEntity.getRandomZ(1.5D), 0.0D, 0.0D, 0.0D);
        }

        for (int i = 0; i < power / 2; ++i) {
            self().getLevel().addParticle(ParticleTypes.LARGE_SMOKE, cannonBallEntity.getRandomX(1.0D), cannonBallEntity.getRandomY(), cannonBallEntity.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
            self().getLevel().addParticle(ParticleTypes.FLAME, cannonBallEntity.getRandomX(0.5D), cannonBallEntity.getRandomY(), cannonBallEntity.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
        }
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
