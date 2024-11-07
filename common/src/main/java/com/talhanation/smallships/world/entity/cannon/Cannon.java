package com.talhanation.smallships.world.entity.cannon;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.world.entity.cannon.ICannonBallContainer;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import dev.architectury.injectables.annotations.PlatformOnly;
import net.fabricmc.api.Environment;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.function.BiConsumer;

public class Cannon {
    private final RandomSource random;
    private int time;
    private int coolDown;
    private final Level level;
    /**
     * Where to play sounds at and get the cannonballs from
     */
    private final Entity owner;
    private float yaw = 0;
    private float prevYaw = 0;
    private float pitch = 0;
    private float prevPitch = 0;
    private Vector3d pos = new Vector3d();
    private final float barrelHeight = 0.3F;
    private Runnable cachedShoot = null;

    public <T extends Entity & ICannonBallContainer> Cannon(T owner) {
        this.owner = owner;
        this.level = owner.level();
        this.random = level.getRandom();
    }

    public <T extends Entity & ICannonBallContainer> T getOwner() {
        return (T) this.owner;
    }

    public float getYaw() {
        return this.yaw;
    }

    public float getPrevYaw() {
        return this.prevYaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getPrevPitch() {
        return this.prevPitch;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public Vector3f getForward() {
        Vector3f dir = new Vector3f(0, 0, 1);
        dir.rotateX((float) Math.toRadians(this.pitch));
        dir.rotateY((float) Math.toRadians(this.yaw));
        return dir;
    }

    /**
     * @return the global coordinates where the barrel ends. Useful for shooting and spawning the particles.
     */
    private Vector3d getBarrelEndPoint() {
        Vector3d barrelMiddle = new Vector3d(this.pos);
        barrelMiddle.y += this.barrelHeight;
        return barrelMiddle.add(this.getForward().normalize().mul(1.2F));
    }

    public void tick(double x, double y, double z) {
        if (this.coolDown > 0) this.coolDown--;
        if (this.time > 0) {
            if (this.time == 1 && !this.level.isClientSide() && this.cachedShoot != null) {
                this.cachedShoot.run();
                this.cachedShoot = null;
            }
            this.time--;
        }

        if (this.coolDown == 3) {
            this.playReloadedSound();
        }

        this.prevPitch = this.pitch;
        this.prevYaw = this.yaw;
        this.pos.set(x, y, z);
    }

    private void resetTimer() {
        this.time = 5 + random.nextInt(10);
    }

    private void setCoolDown() {
        this.coolDown = 50;
    }

    /**
     * @param driverEntity
     * @param accuracy
     */
    public void trigger(LivingEntity driverEntity, double accuracy) {
        if (driverEntity.level().isClientSide()) return;

        if (this.getOwner().getCannonBallToShoot() == null) {
            return;
        }

        if (this.coolDown == 0 && this.time == 0) {
            this.resetTimer();
            this.owner.playSound(SoundEvents.TNT_PRIMED, 0.5F, 1F);

            this.getOwner().consumeCannonBall();

            this.cachedShoot = () -> {
                this.shoot(this.getForward(), this.getBarrelEndPoint(), driverEntity, accuracy);
                this.setCoolDown();
            };
        }
    }

    private void shoot(Vector3f shootVec, Vector3d pos, LivingEntity driverEntity, double accuracy) {
        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, driverEntity, pos.x, pos.y, pos.z);
        cannonBallEntity.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 2.6F, (float) accuracy);

        this.level.addFreshEntity(cannonBallEntity);
        this.playCannonShotSound();
    }

    private void playReloadedSound() {
        if (this.owner.level().isClientSide()) return;
        this.owner.playSound(SoundEvents.ARMOR_EQUIP_NETHERITE.value(), 2, 1);
    }

    private void playCannonShotSound() {
        if (this.owner.level().isClientSide()) return;
        this.owner.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);
        this.owner.playSound(ModSoundTypes.CANNON_SHOT, 10.0F, 1.0F);
    }
}