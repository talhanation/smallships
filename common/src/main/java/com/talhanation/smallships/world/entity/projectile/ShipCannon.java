package com.talhanation.smallships.world.entity.projectile;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;
import java.util.function.BiConsumer;

public class ShipCannon extends Entity { // why is this an entity??
    private final RandomSource random;
    private final double offsetX;
    private final double offsetY;
    private final double offsetZ;
    private int time;
    private int coolDown;
    private final Ship ship;
    private final Level level;
    private double angle;
    private boolean isRightSided;
    private boolean isLeftSided;

    public ShipCannon(Ship ship, Cannonable.CannonPosition cannonPosition) {
        this(ship, cannonPosition.x, cannonPosition.y, cannonPosition.z, cannonPosition.isRightSided, !cannonPosition.isRightSided);
    }

    public ShipCannon(Ship ship, double offsetX, double offsetY, double offsetZ, boolean isRightSided, boolean isLeftSided) {
        super(EntityType.ARMOR_STAND, ship.level());
        this.ship = ship;
        this.level = ship.level();
        this.random = level.getRandom();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.resetTimer();
        this.coolDown = 0;

        if (isRightSided) this.setRightSided();
        if (isLeftSided) this.setLeftSided();
    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    public void tick(){
        if (coolDown > 0) coolDown--;
        this.updatePosition();
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity serverEntity) {
        return null;
    }

    public void trigger() {
        if (coolDown == 0) {
            if (time > 0) time--;

            if (time == 0) {
                this.shoot();
                this.resetTimer();
                this.setCoolDown();
            }
        }
    }

    public void trigger(Vec3 shootVec, double yShootVec, LivingEntity driverEntity, double speed, double accuracy) {
        if (coolDown == 0) {
            if (time > 0) time--;

            if (time == 0) {
                this.shoot(shootVec, yShootVec, driverEntity, speed, accuracy);
                this.resetTimer();
                this.setCoolDown();
            }
        }
    }

    public void updatePosition(){
        Vec3 forward = this.ship.getForward();
        float x0 = 0; // /-/rechst /+/links //no need

        double f0 = (Math.cos(this.ship.getYRot() * ((float)Math.PI / 180F)) * x0);
        double f1 = (Math.sin(this.ship.getYRot() * ((float)Math.PI / 180F)) * x0);
        double f2 = this.getOffsetX(); // /-/vorne /+/zurück
        double d1 = this.ship.getX() - forward.x * f2 + f0;
        double d2 = this.ship.getY() - forward.y + this.getOffsetY();//hoch
        double d3 = this.ship.getZ() - forward.z * f2 + f1;

        this.moveTo(d1, d2, d3);
    }

    private void resetTimer() {
        this.time = 10 + random.nextInt(10);
    }

    private void setCoolDown() {
        this.coolDown = 50;
    }
    public void shoot(){
        LivingEntity driverEntity = (LivingEntity) ship.getControllingPassenger();
        if (driverEntity == null) return;

        Vec3 forward = ship.getForward().normalize();
        Vec3 shootVec = getShootVector(forward, driverEntity);
        double speed = 2.6F;
        double accuracy = 3F;// 0 = 100%

        boolean playerView = driverEntity.getLookAngle().y >= 0;
        double yShootVec = playerView ? shootVec.y() + driverEntity.getLookAngle().y * 0.95F : shootVec.y() + 0.15F;

        this.shoot(shootVec, yShootVec, driverEntity, speed, accuracy);
    }

    public void shoot(Vec3 shootVec, double yShootVec, LivingEntity driverEntity, double speed, double accuracy) {
        if (shootVec != null) {
            CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, driverEntity, this.getX(), this.getY() + 1, this.getZ());
            cannonBallEntity.shoot(shootVec.x(), yShootVec, shootVec.z(), (float) speed, (float) accuracy);
            this.level.addFreshEntity(cannonBallEntity);
            ship.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);

            this.playCannonShotSound();

            if (ship instanceof Cannonable cannonable) cannonable.consumeCannonBall();
        }
    }

    public Vec3 getShootVector(Vec3 forward, LivingEntity driver) {
        Vec3 VecRight = forward.yRot(-3.14F / 2).normalize();
        Vec3 VecLeft = forward.yRot(3.14F / 2).normalize();

        Vec3 playerVec = driver.getLookAngle().normalize();

        if (playerVec.distanceTo(VecLeft) > playerVec.distanceTo(VecRight)) {
            return VecRight;
        }

        if (playerVec.distanceTo(VecLeft) < playerVec.distanceTo(VecRight)) {
            return VecLeft;
        }
        return null;
    }


    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public double getOffsetZ() {
        return offsetZ;
    }

    public float getAngle() {
        return (float) this.angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setLeftSided() {
        this.isLeftSided = true;
        this.setAngle(0F);
    }

    public void setRightSided() {
        this.isRightSided = true;
        this.setAngle(180F);
    }
    public boolean isRightSided() {
        return isRightSided;
    }

    public boolean canShootDirection() {
        LivingEntity driver = (LivingEntity) ship.getControllingPassenger();
        if (driver == null) return false;

        Vec3 forward = ship.getForward().normalize();
        Vec3 shootVec = getShootVector(forward, driver);
        Vec3 VecRight = forward.yRot(-3.14F / 2).normalize();
        Vec3 VecLeft = forward.yRot(3.14F / 2).normalize();

        if (isRightSided && Objects.equals(shootVec, VecRight)) {
            return true;
        } else {
            return isLeftSided && Objects.equals(shootVec, VecLeft);
        }
    }

    public CompoundTag getData(){
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putDouble("x", this.getOffsetX());
        compoundtag.putDouble("y", this.getOffsetY());
        compoundtag.putDouble("z", this.getOffsetZ());
        compoundtag.putBoolean("isRightSided", this.isRightSided());
        return compoundtag;
    }

    private void playCannonShotSound() {
        BiConsumer<SoundEvent, Pair<Float, Float>> play = (sound, modifier) -> {
            if (!ship.level().isClientSide()) ship.playSound(sound, modifier.getFirst(), modifier.getSecond());
            else ship.level().playLocalSound(ship.getX(), ship.getY() + 4, ship.getZ(), sound, ship.getSoundSource(), modifier.getFirst(), modifier.getSecond(), false);
        };
        play.accept(ModSoundTypes.CANNON_SHOT, Pair.of(10.0F, 1.0F));
    }



}
