package com.talhanation.smallships.world.entity.projectile;


import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.sail.SailDamage;
import com.talhanation.smallships.world.item.CannonBallItem;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import com.talhanation.smallships.world.entity.cannon.Cannon;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import com.talhanation.smallships.world.entity.ship.hitbox.ShipPartEntity;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3f;

public abstract class AbstractCannonBall extends AbstractHurtingProjectile implements ICannonProjectile {
    private static final EntityDataAccessor<Byte> BALL_TYPE = SynchedEntityData.defineId(AbstractCannonBall.class, EntityDataSerializers.BYTE);
    /**
     * The muzzle trail is only a shot effect, not a permanent tracer: after this
     * many ticks (~1.5s) the projectile stops emitting particles entirely, so
     * long shots do not drag a smoke line across the whole map.
     */
    public static final int TAIL_PARTICLE_TICKS = 7;
    /**
     * Projectiles must stay visible far beyond the vanilla tracking range,
     * otherwise a broadside vanishes mid flight. Used by the renderers.
     */
    public static final double RENDER_RANGE = 200.0D;
    public boolean inWater = false;
    public boolean wasShot = false;
    public int counter = 0;

    public AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
        this.noCulling = true;
    }

    public AbstractCannonBall(EntityType<? extends AbstractCannonBall> type, LivingEntity owner, double d1, double d2, double d3, Level world) {
        super(type, owner, new Vec3(d1, d2, d3), world);
        this.moveTo(d1, d2, d3, this.getYRot(), this.getXRot());
        this.noCulling = true;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(BALL_TYPE, CannonBallItem.Type.BALL.id);
    }

    public CannonBallItem.Type getBallType() {
        return CannonBallItem.Type.byId(this.entityData.get(BALL_TYPE));
    }

    public void setBallType(CannonBallItem.Type type) {
        this.entityData.set(BALL_TYPE, type.id);
    }

    /**
     * Creates a sibling projectile of the same class, used for grape shot pellets.
     */
    protected AbstractCannonBall createSibling() {
        return new CannonBallEntity(this.level());
    }

    @Override
    public void shootAndSpawn(Cannon cannon, Vector3d startPos, Vector3f direction, float cannonSpeedMultiplier, float cannonAccuracy, Entity shooter) {
        Vector3f deltaMovement = direction.normalize().mul((float) this.accelerationPower);
        this.setOwner(shooter);
        this.moveTo(startPos.x, startPos.y, startPos.z, this.getYRot(), this.getXRot());
        this.reapplyPosition();
        this.setDeltaMovement(deltaMovement.x, deltaMovement.y, deltaMovement.z);
        this.hasImpulse = true;

        this.shoot(direction.x(), direction.y(), direction.z(), cannonSpeedMultiplier, cannonAccuracy);
        this.level().addFreshEntity(this);

        // grape shot: spawn additional pellets with spread
        CannonBallItem.Type type = this.getBallType();
        for (int i = 1; i < type.projectileCount; i++) {
            AbstractCannonBall pellet = this.createSibling();
            pellet.setBallType(type);
            pellet.setOwner(shooter);
            pellet.moveTo(startPos.x, startPos.y, startPos.z, pellet.getYRot(), pellet.getXRot());
            pellet.reapplyPosition();
            pellet.setDeltaMovement(deltaMovement.x, deltaMovement.y, deltaMovement.z);
            pellet.hasImpulse = true;
            pellet.shoot(direction.x(), direction.y(), direction.z(), cannonSpeedMultiplier, cannonAccuracy + 6.0F);
            this.level().addFreshEntity(pellet);
        }
    }

    @Override
    public ParticleOptions getAdditionalCannonShootParticles() {
        return ModParticleTypes.CANNON_BALL_SHOOT.get();
    }

    @Override
    public ParticleOptions getAdditionalCannonShootParticles(boolean fineGrain) {
        return fineGrain ? ModParticleTypes.CANNON_BALL_SHOOT_FINE.get() : ModParticleTypes.CANNON_BALL_SHOOT.get();
    }

    @Override
    public void tick() {
        this.baseTick();

        Vec3 vector3d = this.getDeltaMovement();
        HitResult raytraceresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);

        if (raytraceresult.getType() != HitResult.Type.MISS) {
            this.onHit(raytraceresult);
        }

        double d0 = this.getX() + vector3d.x;
        double d1 = this.getY() + vector3d.y;
        double d2 = this.getZ() + vector3d.z;
        this.updateRotation();
        float f = 0.99F;
        float f1 = 0.06F;
        float f2 = -0.05F;
        this.setDeltaMovement(vector3d.scale(f));
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -f1, 0.0D));
        }
        this.setPos(d0, d1, d2);

        if(this.isAlive()){
            this.setWasShot(true);
        }

        if(isInWater()){
            if (this.level().isClientSide() && !isUnderWater()) waterParticles();

            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -f2, 0.0D));
            this.setInWater(true);
        }

        // muzzle trail only, not a permanent tracer
        if (this.level().isClientSide() && this.counter <= TAIL_PARTICLE_TICKS) {
            this.tailParticles();
        }

        if (isInWater() && counter > 200){
            this.discard();
        }

        // grape shot pellets have a much shorter range
        if (this.getBallType() == CannonBallItem.Type.GRAPE && counter > 40) {
            this.discard();
        }

        if (wasShot){
            counter++;
        }
    }

    public void setWasShot(boolean bool){
        if (bool != wasShot){
            wasShot = true;
            boolean spawnedFromShip = this.getOwner() != null && this.getOwner().getVehicle() instanceof Ship;
            if (this.level().isClientSide() && spawnedFromShip) {
                this.shootParticles();
            }
        }
    }

    public void setInWater(boolean bool){
        if (bool != inWater){
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 3.3F, 0.8F + 0.4F * this.random.nextFloat());
            inWater = true;
            //this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (!this.level().isClientSide()) {
            boolean doesSpreadFire = false;

            if(!isInWater()) this.level().explode(this.getOwner(), getX(), getY(), getZ(), SmallShipsConfig.Server.shipGeneralCannonDestruction.get().floatValue() * this.getBallType().damageMultiplier, doesSpreadFire, Level.ExplosionInteraction.MOB);
            this.remove(RemovalReason.KILLED);
        }
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        this.hitParticles();
        // AbstractHurtingProjectile does NOT remove itself on impact - the
        // concrete vanilla fireballs each do that in their own onHit. That is
        // why onHitBlock below always removed by hand; an ENTITY hit never did,
        // so the ball kept flying straight through the ship it had just holed
        // and stayed live for the next one behind it.
        if (!this.level().isClientSide()) this.discard();
    }

    /**
     * The muzzle sits INSIDE the own ships' parts, unlike the small vanilla boat
     * box before them - without this every broadside would detonate on the own
     * hull the moment it leaves the barrel.
     *
     * Note what super does here: AbstractHurtingProjectile#canHitEntity refuses
     * every entity carrying noPhysics. Hitting a ship at all therefore depends
     * on ShipPartEntity NOT setting that flag - see the note in its constructor
     * before touching either side.
     */
    @Override
    protected boolean canHitEntity(@NotNull Entity entity) {
        Entity owner = this.getOwner();
        if (owner != null && entity instanceof ShipPartEntity part && part.getParent() == owner.getVehicle()) return false;
        return super.canHitEntity(entity);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        if (!this.level().isClientSide()) {
            // a hit on a part is a hit on the ship, never on the box itself -
            // but WHICH part was hit decides where the damage lands
            Entity hitPart = hitResult.getEntity();
            boolean hitMast = hitPart instanceof ShipPartEntity part && part.isMast();
            Entity hitEntity = ShipPartEntity.resolve(hitPart);
            Entity ownerEntity = this.getOwner();
            if(ownerEntity == null) return;
            if (hitEntity instanceof Ship shipHitEntity) {
                if(shipHitEntity.getControllingPassenger() != null &&  ownerEntity.getTeam() != null && ownerEntity.isAlliedTo(shipHitEntity.getControllingPassenger()) && !ownerEntity.getTeam().isAllowFriendlyFire()) return;

                CannonBallItem.Type ballType = this.getBallType();
                float shipDamage = (random.nextInt(10) + 10) * ballType.damageMultiplier;
                // the masts ARE the sails' hit box: what goes through the rigging
                // never reaches the timbers, and a ball in the side never reaches
                // the canvas. Which one you hit is now the players' decision.
                if (hitMast) {
                    SailDamage.applyCannonHit(shipHitEntity, shipDamage * ballType.sailFactor);
                } else {
                    shipHitEntity.hurt(this.damageSources().thrown(this, ownerEntity), shipDamage * ballType.hullFactor);
                }
                // The impact sound belongs to the BALL, not to the hull damage.
                // Ship#hurt only plays it above 10 damage, and once hullFactor
                // and sailFactor split a shot up, a hit rarely reaches that -
                // a mast hit never called hurt at all, so it stayed silent.
                this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                        ModSoundTypes.SHIP_HIT, this.getSoundSource(), 3.3F, 0.8F + 0.4F * this.random.nextFloat());
            }
            else if (ownerEntity instanceof LivingEntity livingOwnerEntity) {
                if(ownerEntity.getTeam() != null && ownerEntity.isAlliedTo(hitEntity) && !ownerEntity.getTeam().isAllowFriendlyFire()) return;

                this.level().playSound(null, this.getX(), this.getY() + 4 , this.getZ(), SoundEvents.GENERIC_EXPLODE.value(), this.getSoundSource(), 3.3F, 0.8F + 0.4F * this.random.nextFloat());
            }

            // ships were already dealt with above, by hull or by rigging
            if (hitEntity instanceof Ship) return;

            float damageMultiplier = hitEntity instanceof LivingEntity ? this.getBallType().livingDamageMultiplier : this.getBallType().damageMultiplier;
            hitEntity.hurt(this.damageSources().thrown(this, ownerEntity), SmallShipsConfig.Server.shipGeneralCannonDamage.get().floatValue() * damageMultiplier);
        }
    }

    public void hitParticles(){
        for (int i = 0; i < 300; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            this.level().addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
            this.level().addParticle(ParticleTypes.LARGE_SMOKE, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
        }
    }

    public void waterParticles(){
        for (int i = 0; i < 200; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            this.level().addParticle(ParticleTypes.POOF, this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3  + i * 0.012, this.getRandomZ(2.0D) - d2 * d3, d0, d1, d2);
        }
    }


    public void shootParticles() {
        //TODO uuid workaround so particles spawn at the ground cannon's position....
        boolean spawnedFromShip = this.getOwner() != null && this.getOwner().getVehicle() instanceof Ship;
        Vector3d prevPos = new Vector3d(this.xOld, this.yOld, this.zOld);
        Vector3d movement = new Vector3d(this.getX(), this.getY(), this.getZ()).sub(prevPos);

        for (int i = 0; i < 100; ++i) {
            double d0 = this.random.nextGaussian() * 0.03D;
            double d1 = this.random.nextGaussian() * 0.03D;
            double d2 = this.random.nextGaussian() * 0.03D;
            double d3 = 20.0D;
            Vector3d particlePos = new Vector3d(this.getX(1.0D) - d0 * d3, this.getRandomY() - d1 * d3, this.getRandomZ(2.0D) - d2 * d3);
            if (!spawnedFromShip) particlePos.sub(movement);

            this.level().addParticle(ParticleTypes.POOF, particlePos.x, particlePos.y, particlePos.z, d0, d1, d2);
        }

        for (int i = 0; i < 50; ++i) {
            double d00 = this.random.nextGaussian() * 0.03D;
            double d11 = this.random.nextGaussian() * 0.03D;
            double d22 = this.random.nextGaussian() * 0.03D;
            double d44 = 10.0D;
            Vector3d particlePos = new Vector3d(this.getX(1.0D) - d00 * d44, this.getRandomY() - d11 * d44, this.getRandomZ(2.0D) - d22 * d44);
            if (!spawnedFromShip) particlePos.sub(movement);

            this.level().addParticle(ParticleTypes.LARGE_SMOKE, particlePos.x, particlePos.y, particlePos.z, d00, d11, d22);
            this.level().addParticle(ParticleTypes.FLAME, particlePos.x, particlePos.y, particlePos.z, 0, 0, 0);
        }
    }

    public void tailParticles() {
        /*
         * TODO this again is a workaround because of ships. Please calculate the position of the cannons properly and spawn the
         *  projectiles at the actual cannon position OR spawn particles not in the projectile.
         */
        boolean spawnedFromShip = this.getOwner() != null && this.getOwner().getVehicle() instanceof Ship;

        final int maxShotCounter = spawnedFromShip ? 2 : 3; //on ships the trail is way longer, maybe because of speed differences as we offset..
        final int shipOffsetCounter = 2;
        if (spawnedFromShip && this.counter < shipOffsetCounter) return;
        int counter = this.counter - (spawnedFromShip ? shipOffsetCounter : 0);

        Vector3d prevPos = new Vector3d(this.xOld, this.yOld, this.zOld);
        Vector3d pos = new Vector3d(this.getX(), this.getY(), this.getZ());
        Vector3d speed = new Vector3d(pos).sub(prevPos).mul(0.025F);
        final int totalSteps = 6;
        final int numPoofParticlesPerStep = 150 / totalSteps;
        final int numFlameParticlesPerStep = 100 / totalSteps;

        /* interpolate because at the high speeds of a cannon ball particles spawning each tick look bad. */
        for (int step = 1; step <= totalSteps; step++) {
            float partialStep = (step / (float) totalSteps);
            Vector3d lerp = new Vector3d(prevPos).lerp(pos, partialStep);

            if (counter < maxShotCounter && spawnedFromShip) {
                for (int i = 0; i < numPoofParticlesPerStep; ++i) {
                    /* give particles more spread towards end, when a cannon is shot a plume is formed
                    /* leave out first tick so it's more noticeable towards the end */
                    float counterStep = counter == 0 ? 0 : ((counter + partialStep) / (float) maxShotCounter);
                    double xRand = this.random.nextGaussian() * counterStep * 0.08F;
                    double yRand = this.random.nextGaussian() * counterStep * 0.08F;
                    double zRand = this.random.nextGaussian() * counterStep * 0.08F;

                    this.level().addParticle(ParticleTypes.POOF, lerp.x, lerp.y, lerp.z, xRand, yRand, zRand);
                }

                for (int i = 0; i < numFlameParticlesPerStep; ++i) {
                    double radius = this.getBbWidth() / 2F;
                    double xRand = this.random.nextGaussian() * radius;
                    double yRand = this.random.nextGaussian() * radius;
                    double zRand = this.random.nextGaussian() * radius;

                    this.level().addParticle(ParticleTypes.FLAME, lerp.x + xRand, lerp.y + yRand, lerp.z + zRand, speed.x, speed.y, speed.z);
                }
            }

            /* trail throughout lifetime */
            this.level().addParticle(ParticleTypes.POOF, lerp.x, lerp.y, lerp.z, 0, 0, 0);
        }
    }

    /**
     * Frustum culling is disabled for projectiles: the hitbox is tiny compared
     * to the rendered model and the ball travels fast enough that the vanilla
     * culling check drops it for a frame at a time (flickering).
     */

    @Override
    public boolean shouldRenderAtSqrDistance(double distanceSqr) {
        return distanceSqr < RENDER_RANGE * RENDER_RANGE;
    }

    @Override
    public @NotNull AABB getBoundingBoxForCulling() {
        return super.getBoundingBoxForCulling().inflate(100.0D);
    }


    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
        return false;
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected @NotNull ParticleOptions getTrailParticle() {
        return ParticleTypes.SMOKE;
    }
}