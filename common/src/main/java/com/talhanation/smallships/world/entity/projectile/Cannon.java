package com.talhanation.smallships.world.entity.projectile;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class Cannon {
    private final RandomSource random;
    private double x;
    private double y;
    private double z;

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

    public Cannon(Ship ship, Cannonable.CannonPosition cannonPosition) {
        this(ship, cannonPosition.x, cannonPosition.y, cannonPosition.z, cannonPosition.isRightSided, !cannonPosition.isRightSided);
    }

    public Cannon(Ship ship, double offsetX, double offsetY, double offsetZ, boolean isRightSided, boolean isLeftSided) {
        this.ship = ship;
        this.level = ship.getLevel();
        this.random = level.getRandom();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.resetTimer();
        this.coolDown = 0;

        if (isRightSided) this.setRightSided();
        if (isLeftSided) this.setLeftSided();
    }

    public void tick() {
    /*
    this.setX(ship.getX() + this.getOffsetX());
    this.setY(ship.getY() + this.getOffsetY());
    this.setZ(ship.getZ() + this.getOffsetZ());
     */

        this.updatePosition();
        if (coolDown > 0) coolDown--;
    }

    public void updatePosition() {
        Vec3 forward = ship.getForward();
        float x0 = 0; // /-/rechst /+/links //no need

        float f0 = Mth.cos(ship.getYRot() * ((float) Math.PI / 180F)) * x0;
        float f1 = Mth.sin(ship.getYRot() * ((float) Math.PI / 180F)) * x0;
        float f2 = 0; // /-/vorne /+/zurück

        this.setX(ship.getX() + this.getOffsetX() - forward.x * (double) f2 + (double) f0);
        this.setY(ship.getY() + this.getOffsetY() - forward.y);//hoch
        this.setZ(ship.getZ() + this.getOffsetZ() - forward.z * (double) f2 + (double) f1);
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

    private void resetTimer() {
        this.time = random.nextInt(20);
    }

    private void setCoolDown() {
        this.coolDown = 50;
    }

    private void shoot() {
        LivingEntity driverEntity = (LivingEntity) ship.getControllingPassenger();
        if (driverEntity == null) return;

        Vec3 forward = ship.getForward().normalize();
        Vec3 shootVec = getShootVector(forward, driverEntity);


        float f2 = 0.2F;//foward backward
        float x0 = 1F;//right/left pos
        float speed = 2.0F;
        float k = 2F;

        if (shootVec != null) {
            boolean playerView = driverEntity.getLookAngle().y >= 0;
            double yShootVec = playerView ? shootVec.y() + driverEntity.getLookAngle().y * 0.95F : shootVec.y() + 0.25F;

            float f0 = Mth.cos(ship.getYRot() * ((float) Math.PI / 180F)) * x0;
            float f1 = Mth.sin(ship.getYRot() * ((float) Math.PI / 180F)) * x0;
            //float f2 = 0.2F; // /-/vorne /+/zurück
            double d1 = this.getX() - forward.x * (double) f2 + (double) f0;
            double d2 = this.getY() - forward.y + 1;//hoch
            double d3 = this.getZ() - forward.z * (double) f2 + (double) f1;

            CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, (LivingEntity) ship.getControllingPassenger(), d1, d2, d3);
            cannonBallEntity.shoot(shootVec.x(), yShootVec, shootVec.z(), speed, k);
            this.level.addFreshEntity(cannonBallEntity);
            ship.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);
            ship.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);

            if (ship instanceof Cannonable cannonable) cannonable.consumeCannonBall();
        }
    }

    private Vec3 getShootVector(Vec3 forward, LivingEntity driver) {
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
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
}
