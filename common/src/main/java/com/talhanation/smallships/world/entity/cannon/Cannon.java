package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.particles.ServerParticleUtils;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.joml.Vector3d;
import org.joml.Vector3f;

public class Cannon {
    private final RandomSource random;
    /**
     * Timer that is started when cannon is triggered
     * to shoot when the timer is finished.
     */
    private int shootDelayTimer;
    /**
     * Execute the shoot after timer is finished
     */
    private Runnable cachedShoot = null;
    /**
     * Cooldown timer after a shot
     */
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
    private final float speed = 2.6F;

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

    public Vector3d getForward() {
        Vector3d dir = new Vector3d(0, 0, 1);
        dir.rotateX((float) Math.toRadians(this.pitch));
        dir.rotateY((float) Math.toRadians(this.yaw));
        return dir;
    }

    /**
     * @return the global coordinates where the barrel ends. Useful for shooting and spawning the particles.
     */
    public Vector3d getBarrelEndPoint() {
        return this.getBarrelEndPointLocal().add(this.pos);
    }

    public Vector3d getBarrelEndPointLocal() {
        Vector3d barrelMiddle = new Vector3d();
        barrelMiddle.y += this.barrelHeight;
        return barrelMiddle.add(this.getForward().normalize().mul(1.2F));
    }

    public Vector3d getPos() {
        return new Vector3d(this.pos);
    }

    /**
     * @param x new global x coordinates
     * @param y new global y coordinates
     * @param z new global z coordinates
     */
    public void tick(double x, double y, double z) {
        if (this.coolDown > 0) this.coolDown--;
        if (this.shootDelayTimer > 0) {
            this.shootDelayTimer--;

            if (!this.level.isClientSide() && this.shootDelayTimer == 0 && this.cachedShoot != null) {
                this.cachedShoot.run();
                this.cachedShoot = null;
            }
        }

        if (this.coolDown == 3) {
            this.playReloadedSound();
        }

        this.prevPitch = this.pitch;
        this.prevYaw = this.yaw;
        this.pos.set(x, y, z);
    }

    private void resetTimer() {
        this.shootDelayTimer = 10 + random.nextInt(10);
    }

    private void setCoolDown() {
        this.coolDown = 50;
    }

    public boolean isCooldown() {
        return this.coolDown > 0;
    }

    public boolean isFuzing() {
        return this.shootDelayTimer > 0;
    }

    public void triggerFuze(Runnable shot) {
        if (this.level.isClientSide() || this.isCooldown() || this.isFuzing()) return;
        this.resetTimer();
        this.playFuzeSound();
        this.cachedShoot = shot;
    }

    public void shoot(ICannonProjectile projectile) {
        if (!(this.level instanceof ServerLevel serverLevel)) return;

        Vector3d forward = this.getForward();
        projectile.shootAndSpawn(this, this.getBarrelEndPoint(), new Vector3f((float) forward.x, (float) forward.y, (float) forward.z),
                this.speed, 1, null);
        this.playCannonShotSound();

        Vector3d particlePos = this.getBarrelEndPoint();
        particlePos.add(this.getForward().mul(0.25F));

        if (this.owner instanceof GroundCannonEntity groundCannonEntity) {
            ServerParticleUtils.sendParticle(serverLevel, groundCannonEntity.provideShootParticles(), particlePos, forward);
        }

        ParticleOptions particles = projectile.getAdditionalCannonShootParticles();
        if (particles != null) {
            ServerParticleUtils.sendParticle(serverLevel, particles, particlePos, forward);
        }
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

        if (this.coolDown == 0 && this.shootDelayTimer == 0) {
            this.resetTimer();
            this.owner.playSound(SoundEvents.TNT_PRIMED, 1F, 1.5F);

            this.getOwner().consumeCannonBall();

            this.cachedShoot = () -> {
                this.shoot(this.getForward(), this.getBarrelEndPoint(), driverEntity, accuracy);
                this.setCoolDown();
            };
        }
    }

    private void shoot(Vector3d shootVec, Vector3d pos, LivingEntity driverEntity, double accuracy) {

    }

    private void playReloadedSound() {
        if (this.owner.level().isClientSide()) return;
        this.owner.playSound(SoundEvents.ARMOR_EQUIP_NETHERITE.value(), 2, 1);
    }

    private void playCannonShotSound() {
        if (this.owner.level().isClientSide()) return;
        this.owner.playSound(ModSoundTypes.CANNON_SHOT, 10.0F, 1.0F);
    }

    private void playFuzeSound() {
        this.owner.playSound(SoundEvents.TNT_PRIMED, 1F, 1.5F);
    }
}