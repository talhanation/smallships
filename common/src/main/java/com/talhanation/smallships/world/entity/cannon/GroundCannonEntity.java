package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class GroundCannonEntity extends Minecart implements ICannonBallContainer {
    public static final String ID = "ground_cannon";
    private final Cannon cannon = new Cannon(this);
    private boolean drivenPrevTick = false;

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.setPos(pos);
    }

    public GroundCannonEntity(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        super(entityType, level);
    }

    public void trigger() {
        LivingEntity driver;
        if ((driver = this.getDriver()) == null || this.getCannonBallToShoot() == null) return;

        double accuracy = 1F;// 0 = 100%
        double x = this.getX();
        double y = this.getY() + 0.3; //try to shoot approximately from the barrel
        double z = this.getZ();

        this.cannon.trigger(driver.getForward(), driver.getForward().y, new Vec3(x, y, z), driver, accuracy);
    }

    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        Vector3f relativePoint = this.getRelativeAttachmentPoint();
        return new Vec3(relativePoint.x, relativePoint.y, relativePoint.z);
    }

    private Vector3f getRelativeAttachmentPoint() {
        Vector3f attachment = new Vector3f(0,0.0F,-0.65F);
        attachment.rotateAxis(-(float) Math.toRadians(this.getYRot()), 0, 1, 0);
        return attachment;
    }

    @Override
    public void tick() {
        /* super tick resets x rot, cache and reapply */
        float xRot = this.getXRot();
        float yRot = this.getYRot();

        super.tick();
        this.cannon.tick();

        /* detect when a player enters to set the player head yaw and pitch to continue shooting */
        boolean isDriven = this.getDriver() != null;
        if (!this.drivenPrevTick && isDriven) {
            this.getDriver().setYRot(this.getYRot());
            this.getDriver().setXRot(this.getXRot());
        }
        this.drivenPrevTick = isDriven;

        LivingEntity controller = this.getDriver();
        if (controller != null) {
            xRot = controller.getXRot();
            yRot = controller.getYRot();
        }

        this.setYRot(yRot);
        this.setXRot(xRot);
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
     * For some reason when overriding {@link #getControllingPassenger()} it cannot be controller on rails anymore.
     */
    @Nullable
    public LivingEntity getDriver() {
        Entity var2 = this.getFirstPassenger();
        LivingEntity var10000;
        if (var2 instanceof LivingEntity livingEntity) {
            var10000 = livingEntity;
        } else {
            var10000 = super.getControllingPassenger();
        }

        return var10000;
    }

    public static GroundCannonEntity factory(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        return new GroundCannonEntity(entityType, level);
    }

    @Override
    public void consumeCannonBall() {
        if (!(this.getDriver() instanceof Player player)) return;
        if (player.hasInfiniteMaterials()) return;

        //TODO might be cool to add a one slot inventory to the cannon and consume them from there
        for (ItemStack itemstack : player.getInventory().items) {
            if (itemstack.is((ModItems.CANNON_BALL))) {
                itemstack.shrink(1);
                break;
            }
        }
    }

    @Override
    public CannonBallItem getCannonBallToShoot() {
        if (!(this.getDriver() instanceof Player player)) return null;

        return player.getInventory().items.stream().anyMatch(itemStack -> itemStack.getItem().equals(ModItems.CANNON_BALL)) ? ModItems.CANNON_BALL : null;
    }
}
