package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ChainShotEntity;
import com.talhanation.smallships.world.entity.projectile.GrapeShotEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * A cannon mounted on a ship. This is a plain data class (no longer an Entity!)
 * that composes the shared {@link Cannon} core class, which handles fuzing,
 * cooldown, shooting, sounds and particles.
 *
 * The aim (angle and rotation) is shared per broadside and stored in the
 * ship's synched entity data, see {@link Cannonable}.
 */
public class ShipCannon implements ICannon {
    private final Ship ship;
    private final Level level;
    private final Cannon cannon;

    /** the cannon slot this cannon occupies (stable id for aim + gunner seat mapping) */
    private final int slotIndex;
    private final double offsetX;
    private final double offsetY;
    private final double offsetZ;
    private boolean isRightSided;
    private boolean isLeftSided;
    /** legacy render angle used by the ship renderer (0 = left side, 180 = right side) */
    private double angle;

    public ShipCannon(Ship ship, Cannonable.CannonPosition cannonPosition) {
        this(ship, cannonPosition, -1);
    }

    public ShipCannon(Ship ship, Cannonable.CannonPosition cannonPosition, int slotIndex) {
        this.slotIndex = slotIndex;
        this.ship = ship;
        this.level = ship.level();
        this.offsetX = cannonPosition.x;
        this.offsetY = cannonPosition.y;
        this.offsetZ = cannonPosition.z;
        if (cannonPosition.isRightSided) this.setRightSided();
        else this.setLeftSided();

        this.cannon = new Cannon(this);

        this.cannon.setPitchBounds(-30.0F, 10.0F);
    }

    /**
     * Ticks the cannon core: updates its global position and orientation
     * from the ship position and the broadside aim.
     */
    public void tick() {
        Cannonable cannonable = (Cannonable) this.ship;
        // per-cannon aim when a gunner mans the mapped seat, broadside aim otherwise
        float aimAngle = cannonable.getCannonAngle(this.slotIndex, this.isRightSided);       // -20..60, positive = up
        float aimRotation = cannonable.getCannonRotation(this.slotIndex, this.isRightSided); // -10..10, positive = towards bow

        float sideYaw = this.ship.getYRot() + (this.isRightSided ? 90.0F : -90.0F);
        float entityYaw = sideYaw + (this.isRightSided ? aimRotation : -aimRotation);
        float entityPitch = -aimAngle;

        Vec3 pos = this.getGlobalPosition();
        this.cannon.tick(pos.x, pos.y, pos.z, -entityYaw, entityPitch);
    }

    /**
     * @return the global position of this cannon based on the ship position and the offsets.
     */
    public Vec3 getGlobalPosition() {
        Vec3 forward = this.ship.getForward().normalize();
        Vec3 right = forward.yRot(-Mth.HALF_PI).normalize();

        double side = this.isRightSided ? this.offsetZ : -this.offsetZ;
        double x = this.ship.getX() - forward.x * this.offsetX + right.x * side;
        double y = this.ship.getY() + this.offsetY;
        double z = this.ship.getZ() - forward.z * this.offsetX + right.z * side;
        return new Vec3(x, y, z);
    }

    /**
     * Default trigger: shoots with the current broadside aim.
     */
    public void trigger() {
        this.trigger((Entity) this.ship.getControllingPassenger());
    }

    /**
     * Fires this cannon with the given shooter (driver volley or gunner).
     */
    public void trigger(Entity shooterEntity) {
        Entity driverEntity = shooterEntity;
        if (driverEntity == null || this.level.isClientSide()) return;
        if (!(this.ship instanceof Cannonable cannonable)) return;
        // the trigger fires every tick while the key is held - only consume the
        // cannonball when this cannon can actually start a new shot (reload)
        if (this.cannon.isCooldown() || this.cannon.isFuzing()) return;

        CannonBallItem ammo = cannonable.getCannonBallToShoot();
        if (ammo == null) return;
        CannonBallItem.Type type = ammo.getType();

        // ball type multiplier, +50% if a fine grain powder is actually consumed.
        // getShotSpeedMultiplier(false) gives the type part; the fine grain part
        // is applied here because it must CONSUME the powder, not just peek it
        float speedMultiplier = cannonable.getShotSpeedMultiplier(false);
        if (cannonable.consumeFineGrainPowder()) {
            speedMultiplier *= 1.5F;
        }
        this.cannon.setSpeedMultiplier(speedMultiplier);

        cannonable.consumeCannonBall();

        final int count = type.projectileCount;
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                this.cannon.triggerFuze(driverEntity, () -> this.createProjectile(type));
            }
        }
        // grape shot: additional pellets are spawned by the projectile itself on shoot,
        // see CannonBallEntity/AbstractCannonBall handling of projectileCount
    }

    private AbstractCannonBall createProjectile(CannonBallItem.Type type) {
        AbstractCannonBall ball;

        if(type == CannonBallItem.Type.CHAINED){
            ball = new ChainShotEntity(this.level);
        }
        else if(type == CannonBallItem.Type.GRAPE){
            ball = new GrapeShotEntity(this.level);
        }
        else{
            ball = new CannonBallEntity(this.level);
        }
        ball.setBallType(type);

        return ball;
    }

    /**
     * Advanced trigger, kept for reflection compatibility (Workers/Recruits mod).
     */
    public void trigger(Vec3 shootVec, double yShootVec, LivingEntity driverEntity, double speed, double accuracy) {
        if (shootVec == null || this.level.isClientSide()) return;
        Vec3 pos = this.getGlobalPosition();
        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level, driverEntity, pos.x, pos.y + 1, pos.z);
        cannonBallEntity.shoot(shootVec.x(), yShootVec, shootVec.z(), (float) speed, (float) accuracy);
        this.level.addFreshEntity(cannonBallEntity);
        this.playSoundAt(net.minecraft.sounds.SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);
        if (this.ship instanceof Cannonable cannonable) cannonable.consumeCannonBall();
    }

    public boolean isCooldown() {
        return this.cannon.isCooldown();
    }

    public boolean isFuzing() {
        return this.cannon.isFuzing();
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    /**
     * @return true if the driver is currently looking towards this cannon's broadside.
     */
    public boolean canShootDirection() {
        LivingEntity driver = (LivingEntity) this.ship.getControllingPassenger();
        if (driver == null) return false;

        Vec3 forward = this.ship.getForward().normalize();
        Vec3 vecRight = forward.yRot(-Mth.HALF_PI).normalize();
        Vec3 playerVec = driver.getLookAngle().normalize();
        Vec3 vecLeft = forward.yRot(Mth.HALF_PI).normalize();

        boolean lookingRight = playerVec.distanceTo(vecRight) < playerVec.distanceTo(vecLeft);
        return this.isRightSided == lookingRight;
    }

    public double getOffsetX() {
        return this.offsetX;
    }

    public double getOffsetY() {
        return this.offsetY;
    }

    public double getOffsetZ() {
        return this.offsetZ;
    }

    public float getAngle() {
        return (float) this.angle;
    }

    public void setLeftSided() {
        this.isLeftSided = true;
        this.isRightSided = false;
        this.angle = 0.0F;
    }

    public void setRightSided() {
        this.isRightSided = true;
        this.isLeftSided = false;
        this.angle = 180.0F;
    }

    public boolean isRightSided() {
        return this.isRightSided;
    }

    public int getSlotIndex() {
        return this.slotIndex;
    }

    public CompoundTag getData() {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putDouble("x", this.getOffsetX());
        compoundtag.putDouble("y", this.getOffsetY());
        compoundtag.putDouble("z", this.getOffsetZ());
        compoundtag.putBoolean("isRightSided", this.isRightSided());
        return compoundtag;
    }

    /* ---------------- ICannon ---------------- */

    @Override
    public ParticleOptions provideShootParticles() {
        return ModParticleTypes.CANNON_SHOOT.get();
    }

    @Override
    public void playSoundAt(SoundEvent soundEvent, float volumeMultiplier, float pitch) {
        this.ship.playSound(soundEvent, volumeMultiplier, pitch);
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    /* ---------------- ICannonBallSource (delegates to the ship) ---------------- */

    @Override
    public void consumeCannonBall() {
        if (this.ship instanceof Cannonable cannonable) cannonable.consumeCannonBall();
    }

    @Override
    public CannonBallItem getCannonBallToShoot() {
        if (this.ship instanceof Cannonable cannonable) return cannonable.getCannonBallToShoot();
        return null;
    }
}