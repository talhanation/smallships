package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ClientboundShootCannonPacket;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.sound.ModSoundTypes;
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

    public Vector3f getForward() {
        Vector3f dir = new Vector3f(0, 0, 1);
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
            //TODO fuzing/timer is not synchronised. It's better to spawn particles from server
            this.clientFuzingEffects();
            if (this.shootDelayTimer == 1 && this.cachedShoot != null) {
                this.cachedShoot.run();
                this.cachedShoot = null;
            }
            this.shootDelayTimer--;
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
        if (this.isCooldown() || this.isFuzing()) return;
        this.resetTimer();
        if (this.level.isClientSide()) return;
        this.playFuzeSound();
        this.cachedShoot = shot;
    }

    public void shoot(ICannonProjectile projectile) {
        if (!(this.level instanceof ServerLevel serverLevel)) return;

        projectile.shootAndSpawn(this, this.getBarrelEndPoint(), this.getForward(), this.speed, 1, null);
        this.playCannonShotSound();
        //TODO register custom particle type and send particles from server.
        serverLevel.getPlayers(player -> true).forEach(serverPlayer -> {
            ModPackets.serverSendPacket(serverPlayer, new ClientboundShootCannonPacket(this.owner.getId()));
        });
    }

    public void clientFuzingEffects() {
        if (!this.level.isClientSide()) return;

        Vector3d pos = this.getPos().add(0, this.barrelHeight, 0);
        this.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0, 0.05, 0);
        this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, 0, 0, 0);
    }

    public void clientShootingEffects() {
        if (!this.level.isClientSide()) return;

        this.addPoofForwardParticles(100);
        this.addStaticMainPoofParticles(100);
        this.addFlamesForwardParticles(75);
        this.addStaticDarkSmokeParticles(50);
    }

    public void clientShootingEntityEffects() {
        if (!this.level.isClientSide()) return;

        this.addPoofForwardParticles(100);
        this.addStaticMainPoofParticles(100);
        this.addFlamesForwardParticles(75);
        this.addStaticDarkSmokeParticles(50);
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

    private void shoot(Vector3f shootVec, Vector3d pos, LivingEntity driverEntity, double accuracy) {

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

    //TODO do custom particle type - more reusability and less cluttering and synchroniszing from server to clients
    protected void addStaticMainPoofParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.5)
                    .add(new Vector3d(this.getBarrelEndPoint()).add(new Vector3d(this.getForward()).mul(0.25F)));
            Vector3d v = new Vector3d(rand).mul(0.03);
            this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addPoofForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3f forward = new Vector3f(this.getForward());
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getBarrelEndPoint());
            Vector3d v = new Vector3d(rand).mul(0.03)
                    .add(new Vector3d(forward).mul(Math.abs(this.level.random.nextGaussian()) * 0.4F));
            this.level.addParticle(ParticleTypes.POOF, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addFlamesForwardParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3f forward = new Vector3f(this.getForward());
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getBarrelEndPoint());
            Vector3d v = new Vector3d(rand).mul(0.01)
                    .add(new Vector3d(forward).mul(Math.abs(this.level.random.nextGaussian()) * 0.1F));
            this.level.addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    protected void addStaticDarkSmokeParticles(int amount) {
        for (int i = 0; i < amount; i++) {
            Vector3d rand = this.getRandGaussian();
            Vector3d pos = new Vector3d(rand).mul(0.2)
                    .add(this.getBarrelEndPoint());
            Vector3d v = new Vector3d(rand).mul(0.02);

            this.level.addParticle(ParticleTypes.LARGE_SMOKE, pos.x, pos.y, pos.z, v.x, v.y, v.z);
        }
    }

    private Vector3d getRandGaussian() {
        return new Vector3d(this.level.random.nextGaussian(), this.level.random.nextGaussian(), this.level.random.nextGaussian());
    }
}