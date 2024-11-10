package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundEnterCannonBarrelPacket;
import com.talhanation.smallships.network.packet.ServerboundShootGroundCannonPacket;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import com.talhanation.smallships.world.particles.ModParticleTypes;
import com.talhanation.smallships.world.particles.cannon.DyedCannonShootOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Chryfi
 */
public class GroundCannonEntity extends Minecart implements ICannon {
    public static final String ID = "ground_cannon";
    private static final EntityDataAccessor<Optional<UUID>> UUID = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.OPTIONAL_UUID);
    private static final EntityDataAccessor<String> DYE = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.STRING);
    private final Cannon cannon = new Cannon(this);
    /**
     * Whether this entity was driven in the previous tick.
     * Used to keep track when a player enters this minecart.
     */
    private boolean drivenPrevTick = false;

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.setPos(pos);
    }

    public GroundCannonEntity(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        super(entityType, level);
    }

    /*
     *
     * DATA
     *
     */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(UUID, Optional.empty());
        builder.define(DYE, "");
    }

    public Optional<UUID> getEntityInBarrelUUID() {
        return this.entityData.get(UUID);
    }

    protected final void setEntityInBarrelUUID(UUID uuid) {
        this.entityData.set(UUID, Optional.ofNullable(uuid));
    }

    @Nullable
    public DyeColor getDye() {
        String dye = this.entityData.get(DYE);
        return dye.isEmpty() ? null : DyeColor.byName(this.entityData.get(DYE), null);
    }

    @Nullable
    protected final void setDye(@Nullable DyeColor dye) {
        this.entityData.set(DYE, dye != null ? dye.getSerializedName() : "");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        DyeColor dye;
        if ((dye = this.getDye()) != null) tag.putString("Dye", dye.getSerializedName());
        this.getEntityInBarrelUUID().ifPresent(uuid -> tag.putUUID("EntityInBarrelUUID", uuid));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Dye")) {
            this.setDye(DyeColor.byName(tag.getString("Dye"), null));
        }
        if (tag.contains("EntityInBarrelUUID")) {
            this.setEntityInBarrelUUID(tag.getUUID("EntityInBarrelUUID"));
        }
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    @Override
    public void tick() {
        /* super tick resets x rot, cache and reapply */
        float xRot = this.getXRot();
        float yRot = this.getYRot();

        super.tick();

        /* detect when a player enters to set the player head yaw and pitch to continue shooting */
        boolean isDriven = this.getPassengerDriver() != null;
        final Entity driver = this.getPassengerDriver();
        boolean enteredCannon = !this.drivenPrevTick && isDriven;

        /* set player to the orientation of the cannon on first time enter */
        if (enteredCannon) {
            this.getPassengerDriver().setYRot(this.getYRot());
            this.getPassengerDriver().setXRot(this.getXRot());
        }
        this.drivenPrevTick = isDriven;

        if (isDriven) {
            xRot = driver.getXRot();
            yRot = driver.getYRot();
        }

        xRot = Math.clamp(xRot, -90, 20);

        this.setYRot(yRot);
        this.setXRot(xRot);
        this.cannon.tick(this.getX(), this.getY(), this.getZ(), -yRot, xRot);
        this.testEntityIntersection();
    }

    /**
     * For pushing any entity into the cannon barrel
     */
    protected void testEntityIntersection() {
        if (this.level().isClientSide()) return;
        List<Entity> list = this.level().getEntities(this, this.getBoundingBox().inflate(0.20000000298023224, 0.0, 0.20000000298023224), EntitySelector.pushableBy(this));
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Entity entity = (Entity) it.next();
                boolean isEntityTypeAllowed = !(entity instanceof Player) && !(entity instanceof IronGolem) && !(entity instanceof AbstractMinecart);
                boolean isBarrelEmpty = this.getPassengerInBarrel() == null;
                if (isEntityTypeAllowed && isBarrelEmpty && !entity.isPassenger()) {
                    this.tryPuttingIntoBarrel(entity);
                }
            }
        }
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand interactionHand) {
        /* copied from Minecart.interact */
        if (this.itemInteraction(player, interactionHand)) {
            return InteractionResult.CONSUME;
        } else if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (this.getPassengers().size() == 2) {
            return InteractionResult.PASS;
        } else if (!this.level().isClientSide()) {
            return this.tryRiding(player) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    protected boolean itemInteraction(Player player, InteractionHand interactionHand) {
        if (!this.level().isClientSide() && interactionHand == InteractionHand.MAIN_HAND) {
            ItemStack item = player.getMainHandItem();
            if (item.getItem() instanceof DyeItem dye) {
                if (!dye.getDyeColor().equals(this.getDye())) {
                    item.shrink(1);
                    this.setDye(dye.getDyeColor());
                }
                return true;
            } else if (item.is(Items.FLINT_AND_STEEL)) {
                this.setDye(null);
                return true;
            }
        }
        return false;
    }

    protected boolean tryRiding(Entity entity) {
        if (this.level().isClientSide()) return false;

        if (this.getPassengerInBarrel() == null && !this.getPassengers().isEmpty() && this.canAddPassenger(entity)) {
            return this.tryPuttingIntoBarrel(entity);
        }
        this.cleanEntityInBarrelUUID();
        return entity.startRiding(this);
    }

    protected boolean tryPuttingIntoBarrel(Entity entity) {
        if (this.level().isClientSide() || entity == null || this.getCannon().isFuzing()) return false;

        Entity barrelEntity = this.getPassengerInBarrel();
        if (barrelEntity == entity) {
            return true;
        } else if (this.getPassengers().size() == 2) {
            return false;
        } else if (barrelEntity != null) {
            return false;
        }

        if (!this.getPassengers().contains(entity)) {
            if (entity.startRiding(this)) {
                this.setEntityInBarrelUUID(entity.getUUID());
                return true;
            }
        } else {
            this.setEntityInBarrelUUID(entity.getUUID());
            return true;
        }

        return false;
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void putEntityIntoBarrel(Entity entity) {
        if (this.level().isClientSide()) {
            ModPackets.clientSendPacket(new ServerboundEnterCannonBarrelPacket(this.getId(), entity.getId()));
            return;
        }

        this.tryPuttingIntoBarrel(entity);
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return this.getPassengers().size() < 2;
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void trigger(Entity triggeredBy) {
        if (this.level().isClientSide()) {
            ModPackets.clientSendPacket(new ServerboundShootGroundCannonPacket(false));
            return;
        }

        CannonBallItem cannonBallToShoot = this.getPassengerInBarrel() == null ? this.getCannonBallToShoot() : null;
        boolean canFuze = cannonBallToShoot != null || this.getPassengerInBarrel() != null;

        if (canFuze) {
            /* consume the cannonball, if it's available, and shoot it after a delay.
             * If no cannonball is available, try to shoot an entity from the barrel if it is still available after fuzing */
            if (cannonBallToShoot != null) {
                this.consumeCannonBall();
            }

            this.cannon.triggerFuze(triggeredBy, () -> {
                if (cannonBallToShoot != null) {
                    return new CannonBallEntity(this.level());
                } else {
                    return (ICannonProjectile) this.getPassengerInBarrel();
                }
            });
        }
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        if (this.getPassengerInBarrel() == entity) {
            Vector3d endPoint = this.cannon.getBarrelEndPointLocal();
            return new Vec3(endPoint.x, endPoint.y, endPoint.z);
        } else {
            return this.getBarrelPassengerAttachmentPoint();
        }
    }

    protected Vec3 getBarrelPassengerAttachmentPoint() {
        Vector3f relativePoint = new Vector3f(0,0,-0.5F).rotateAxis(-(float) Math.toRadians(this.getYRot()), 0, 1, 0);
        return new Vec3(relativePoint.x, relativePoint.y, relativePoint.z);
    }

    /**
     * Seems to be only executed on client side.
     * @param entity
     */
    @Override
    public void onPassengerTurned(Entity entity) {
        super.onPassengerTurned(entity);
        if (this.getPassengerDriver() != entity) return;

        /* slow down turn movement */
        float prevXRot = ((IMixinEntity) entity).getPrevXRot();
        float prevYRot = ((IMixinEntity) entity).getPrevYRot();
        float yRotChange = Math.clamp(0.1F * (entity.getYRot() - prevYRot), -5, 5);
        float xRotChange = Math.clamp(0.1F * (entity.getXRot() - prevXRot), -5, 5);
        entity.setYRot(prevYRot + yRotChange);
        entity.setYBodyRot(prevYRot + yRotChange);
        entity.xRotO = prevXRot + xRotChange;
        entity.setXRot(Math.clamp(prevXRot + xRotChange, -90, 20));
    }

    @Override
    public Item getDropItem() {
        return ModItems.CANNON;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(ModItems.CANNON);
    }

    @Override
    public boolean isPushable() {
        /* cannon is hefty chonky, only push on rails - also more predictable with placement on solid blocks then */
        return this.level().getBlockState(this.blockPosition()).is(BlockTags.RAILS);
    }

    /**
     * @return the controlling passenger.
     * For some reason when overriding {@link #getControllingPassenger()} it cannot be controlled on rails anymore.
     */
    @Nullable
    public Entity getPassengerDriver() {
        for (Entity passenger : this.getPassengers()) {
            if (passenger != this.getPassengerInBarrel()) {
                return passenger;
            }
        }

        return null;
    }

    @Nullable
    public Entity getPassengerInBarrel() {
        Optional<UUID> uuid = this.getEntityInBarrelUUID();
        if (uuid.isEmpty()) return null;
        if (this.getPassengers().isEmpty()) return null;

        for (Entity passenger : this.getPassengers()) {
            if (passenger.getUUID().equals(uuid.get())) {
                return passenger;
            }
        }

        return null;
    }

    protected void cleanEntityInBarrelUUID() {
        if (this.getPassengers().isEmpty() || this.getPassengerInBarrel() == null) {
            this.setEntityInBarrelUUID(null);
        }
    }

    public static GroundCannonEntity factory(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        return new GroundCannonEntity(entityType, level);
    }

    @Override
    public void consumeCannonBall() {
        Entity driver = this.getPassengerDriver();
        if (driver == null || (driver instanceof LivingEntity livingDriver && livingDriver.hasInfiniteMaterials())) return;

        if (driver instanceof ICannonBallSource container) {
            container.consumeCannonBall();
        } else if (this.getPassengerDriver() instanceof Player player) {
            for (ItemStack itemstack : player.getInventory().items) {
                if (itemstack.is((ModItems.CANNON_BALL))) {
                    itemstack.shrink(1);
                    break;
                }
            }
        }
    }

    @Override
    public ParticleOptions provideShootParticles() {
        if (this.getDye() != null) {
            return new DyedCannonShootOptions(this.getDye());
        }
        return ModParticleTypes.CANNON_SHOOT;
    }

    @Override
    public Level getLevel() {
        return this.level();
    }

    @Override
    public CannonBallItem getCannonBallToShoot() {
        if (this.getPassengerDriver() == null) return null;

        if (this.getPassengerDriver() instanceof ICannonBallSource container) {
            return container.getCannonBallToShoot();
        } else if (this.getPassengerDriver() instanceof Player player) {
            return player.getInventory().items.stream().anyMatch(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL)) ? ModItems.CANNON_BALL : null;
        } else {
            return null;
        }
    }
}
