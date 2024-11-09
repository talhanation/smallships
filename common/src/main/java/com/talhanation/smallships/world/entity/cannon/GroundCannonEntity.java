package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.packet.ServerboundEnterCannonBarrelPacket;
import com.talhanation.smallships.network.packet.ServerboundShootGroundCannonPacket;
import com.talhanation.smallships.world.entity.IEntityRemovePassenger;
import com.talhanation.smallships.world.entity.IMixinEntity;
import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.entity.projectile.ICannonProjectile;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3f;

import java.util.Optional;
import java.util.UUID;

public class GroundCannonEntity extends Minecart implements ICannonBallContainer, IEntityRemovePassenger {
    public static final String ID = "ground_cannon";
    private static final EntityDataAccessor<Optional<UUID>> UUID = SynchedEntityData.defineId(GroundCannonEntity.class, EntityDataSerializers.OPTIONAL_UUID);
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

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(UUID, Optional.empty());
    }

    public Optional<UUID> getEntityInBarrelUUID() {
        return this.entityData.get(UUID);
    }

    protected final void setEntityInBarrelUUID(UUID uuid) {
        this.entityData.set(UUID, Optional.ofNullable(uuid));
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
        this.cannon.tick(this.getX(), this.getY(), this.getZ());

        /* detect when a player enters to set the player head yaw and pitch to continue shooting */
        boolean isDriven = this.getPassengerDriver() != null;
        final LivingEntity driver = this.getPassengerDriver();
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

        this.setYRot(yRot);
        this.setXRot(xRot);
        this.cannon.setYaw(-yRot);
        this.cannon.setPitch(xRot);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand interactionHand) {
        /* copied from Minecart.interact */
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else if (this.getPassengers().size() == 2) {
            return InteractionResult.PASS;
        } else if (!this.level().isClientSide()) {
            return this.tryRiding(player) ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    protected boolean tryRiding(Entity entity) {
        if (this.level().isClientSide()) return false;

        if (this.getPassengerInBarrel() == null && !this.getPassengers().isEmpty()) {
            return this.tryPuttingIntoBarrel(entity);
        }

        return entity.startRiding(this);
    }

    protected boolean tryPuttingIntoBarrel(Entity entity) {
        if (this.level().isClientSide()) return false;

        if (this.getCannon().isFuzing()) return false;

        if (this.getPassengers().contains(entity)) {
            Optional<UUID> uuid = this.getEntityInBarrelUUID();
            if (uuid.isPresent() && uuid.get().equals(entity.getUUID())) {
                return true;
            } else if (uuid.isPresent()) {
                return false;
            }
        } else if (this.getPassengers().size() == 2) {
            return false;
        } else if (this.getEntityInBarrelUUID().isPresent()) {
            return false;
        }

        entity.startRiding(this);
        this.setEntityInBarrelUUID(entity.getUUID());

        return true;
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void putEntityIntoBarrel(Entity entity) {
        if (this.level().isClientSide()) {
            ModPackets.clientSendPacket(new ServerboundEnterCannonBarrelPacket(false));
            return;
        }

        this.tryPuttingIntoBarrel(entity);
    }

    @Override
    protected boolean canAddPassenger(Entity entity) {
        return this.getPassengers().size() < 2;
    }

    @Override
    protected void removePassenger(Entity entity) {
        if (this.getPassengerInBarrel() == entity) {
            this.setEntityInBarrelUUID(null);
        }
        super.removePassenger(entity);
    }

    @Override
    public void removePassengerWithoutGameEvent(Entity entity) {
        if (this.getPassengerInBarrel() == entity) {
            this.setEntityInBarrelUUID(null);
        }
        ((IMixinEntity) this).simpleRemovePassenger(entity);
    }

    /**
     * Can be executed on both client and server, it encapsulates the handling logic.
     */
    public void trigger() {
        //TODO don't trigger fuze on client.
        CannonBallItem cannonBallToShoot = this.getPassengerInBarrel() == null ? this.getCannonBallToShoot() : null;
        boolean canFuze = cannonBallToShoot != null || this.getPassengerInBarrel() != null;

        if (this.level().isClientSide()) {
            //TODO just for the particle.
            this.cannon.triggerFuze(() -> {});
            ModPackets.clientSendPacket(new ServerboundShootGroundCannonPacket(false));
            return;
        }

        if (canFuze) {
            /* consume the cannonball, if it's available, and shoot it after a delay.
             * If no cannonball is available, try to shoot an entity from the barrel if it is still available after fuzing */
            if (cannonBallToShoot != null) {
                this.consumeCannonBall();
            }

            this.cannon.triggerFuze(() -> {
                if (cannonBallToShoot != null) {
                    this.shootCannonBall(cannonBallToShoot);
                } else {
                    this.tryShootBarrelEntity();
                }
            });
        }
    }

    private void tryShootBarrelEntity() {
        LivingEntity driver = this.getPassengerDriver();
        if (driver != null) {
            this.cannon.setYaw(-driver.getYRot());
            this.cannon.setPitch(driver.getXRot());
        }

        Entity barrelEntity = this.getPassengerInBarrel();
        if (barrelEntity != null) {
            this.cannon.shoot((ICannonProjectile) barrelEntity);
        }
    }

    private void shootCannonBall(CannonBallItem cannonBallItem) {
        final LivingEntity driver;
        if ((driver = this.getPassengerDriver()) == null) return;

        this.cannon.setYaw(-driver.getYRot());
        this.cannon.setPitch(driver.getXRot());
        this.cannon.shoot(new CannonBallEntity(this.level()));
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        if (this.getPassengerInBarrel() == entity) {
            Vector3d endPoint = this.cannon.getBarrelEndPointLocal();
            return new Vec3(endPoint.x, endPoint.y, endPoint.z);
        } else {
            Vector3f relativePoint = new Vector3f(0,0,-0.5F).rotateAxis(-(float) Math.toRadians(this.getYRot()), 0, 1, 0);
            return new Vec3(relativePoint.x, relativePoint.y, relativePoint.z);
        }
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
    public LivingEntity getPassengerDriver() {
        for (Entity passenger : this.getPassengers()) {
            if (passenger != this.getPassengerInBarrel() && passenger instanceof LivingEntity living) {
                return living;
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

    public static GroundCannonEntity factory(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        return new GroundCannonEntity(entityType, level);
    }

    @Override
    public void consumeCannonBall() {
        if (this.getPassengerDriver() == null || this.getPassengerDriver().hasInfiniteMaterials()) return;

        //TODO might be cool to add a one slot inventory to the cannon and consume them from there
        //TODO inject ICannonBallContainer into Player
        if (this.getPassengerDriver() instanceof ICannonBallContainer container) {
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
    public CannonBallItem getCannonBallToShoot() {
        if (this.getPassengerDriver() == null) return null;

        if (this.getPassengerDriver() instanceof ICannonBallContainer container) {
            return container.getCannonBallToShoot();
        } else if (this.getPassengerDriver() instanceof Player player) {
            return player.getInventory().items.stream().anyMatch(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL)) ? ModItems.CANNON_BALL : null;
        } else {
            return null;
        }
    }
}
