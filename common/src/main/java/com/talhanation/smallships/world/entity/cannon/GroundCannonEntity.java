package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.entity.vehicle.MinecartChest;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class GroundCannonEntity extends Minecart {
    public static final String ID = "ground_cannon";

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.setPos(pos);
    }

    public GroundCannonEntity(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        super(entityType, level);
    }

    public void shoot() {
        CannonBallEntity cannonBallEntity = new CannonBallEntity(this.level(), this.getControllingPassenger(), this.getX(), this.getY() + 1, this.getZ());
        cannonBallEntity.shoot(0, 1, 1, (float) 2F, (float) 1F);
        this.level().addFreshEntity(cannonBallEntity);
        this.playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F / (0.4F + 1.2F) + 0.5F);

        //this.playCannonShotSound();
    }

    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        Vec3 attachment = super.getPassengerAttachmentPoint(entity, entityDimensions, f);
        return super.getPassengerAttachmentPoint(entity, entityDimensions, f);//new Vec3(-0.65,0.0,0);
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity controller = this.getControllingPassenger();
        if (controller != null) {
            this.setYRot(controller.getYRot());
            this.setXRot(controller.getXRot());
        }
    }

    @Override
    public Item getDropItem() {
        return ModItems.CANNON;
    }

    @Override
    public boolean isPushable() {
        // cannon is hefty chonky, only push on rails
        boolean test = this.level().getBlockState(this.blockPosition()).is(BlockTags.RAILS);
        return this.level().getBlockState(this.blockPosition()).is(BlockTags.RAILS);
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
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
}
