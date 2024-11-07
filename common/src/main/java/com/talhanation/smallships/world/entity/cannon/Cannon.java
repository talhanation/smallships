package com.talhanation.smallships.world.entity.cannon;

import com.mojang.datafixers.util.Pair;
import com.talhanation.smallships.world.entity.cannon.ICannonBallContainer;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.sound.ModSoundTypes;
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
    private float pitch = 0;
    private float prevPitch = 0;
    private Vector3d pos = new Vector3d();
    private final float barrelHeight = 0.3F;
    private Runnable cachedShoot = null;

    public Cannon(Entity owner) {
        this.owner = owner;
        this.level = owner.level();
        this.random = level.getRandom();
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
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

    public void tick(double x, double y, double z) {
        if (coolDown > 0)coolDown--;
        if (time > 0) {
            if (time == 1 && !this.level.isClientSide() && this.cachedShoot != null) {
                this.cachedShoot.run();
                this.cachedShoot = null;
            }

            time--;
        }

        if (coolDown == 3) {
            this.playReloadedSound();
        }

        this.prevPitch = this.pitch;
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
        if (coolDown == 0 && this.time == 0) {
            this.resetTimer();
            this.owner.playSound(SoundEvents.CREEPER_PRIMED, 0.5F, 1F);
            this.cachedShoot = () -> {
                if (this.owner instanceof ICannonBallContainer container && container.getCannonBallToShoot() == null){
                    return;
                }

                this.shoot(this.getForward(), this.getBarrelEndPoint(), driverEntity, accuracy);
                this.setCoolDown();
            };
        }
    }

    private void shoot(Vector3f shootVec, Vector3d pos, LivingEntity driverEntity, double accuracy) {
        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, driverEntity, pos.x, pos.y, pos.z);
        cannonBallEntity.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 2.6F, (float) accuracy);

        this.level.addFreshEntity(cannonBallEntity);
        this.owner.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);
        this.playCannonShotSound();

        if (this.owner instanceof ICannonBallContainer container) container.consumeCannonBall();
    }

    private void playReloadedSound() {
        SoundEvent soundType = SoundEvents.ARMOR_EQUIP_NETHERITE.value();
        float pitch = 1;
        float volume = 2;
        if (!this.owner.level().isClientSide()) {
            this.owner.playSound(soundType, volume, pitch);
        }
    }

    private void playCannonShotSound() {
        BiConsumer<SoundEvent, Pair<Float, Float>> play = (sound, modifier) -> {
            if (!this.owner.level().isClientSide()) {
                this.owner.playSound(sound, modifier.getFirst(), modifier.getSecond());
            } else {
                this.owner.level().playLocalSound(this.owner.getX(), this.owner.getY() + 4, this.owner.getZ(), sound,
                        this.owner.getSoundSource(), modifier.getFirst(), modifier.getSecond(), false);
            }
        };

        play.accept(ModSoundTypes.CANNON_SHOT, Pair.of(10.0F, 1.0F));
    }

    /**
     * @return the global coordinates where the barrel ends. Useful for shooting and spawning the particles.
     */
    private Vector3d getBarrelEndPoint() {
        Vector3d barrelMiddle = new Vector3d(this.pos);
        barrelMiddle.y += this.barrelHeight;
        return barrelMiddle.add(this.getForward().normalize().mul(1.2F));
    }
}