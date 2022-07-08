package com.talhanation.smallships.items;

import com.talhanation.smallships.client.render.RenderItemCog;
import com.talhanation.smallships.entities.CogEntity;
import com.talhanation.smallships.entities.AbstractWaterVehicle;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;


public class CogItem extends Item {
    private static final Predicate<Entity> X = EntityPredicates.NO_SPECTATORS.and(Entity::canBeCollidedWith);
    private final CogEntity.Type type;

    public CogItem(CogEntity.Type typeIn, Item.Properties properties) {
        super(properties.setISTER(() -> RenderItemCog::new));
        this.type = typeIn;
    }

    public CogEntity getCogEntity(World world) {
        CogEntity cog = new CogEntity(ModEntityTypes.COG_ENTITY.get(), world);
        cog.setWoodType(type);
        cog.setSailState(4);
        return cog;
    }

    public CogEntity.Type getType() {
        return this.type;
    }


    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else {
            Vector3d vector3d = playerIn.getViewVector(1.0F);
            double d0 = 5.0D;
            List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), X);
            if (!list.isEmpty()) {
                Vector3d vector3d1 = playerIn.getEyePosition(1.0F);

                for(Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (axisalignedbb.contains(vector3d1)) {
                        return ActionResult.pass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                CogEntity boatentity = new CogEntity(worldIn, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
                boatentity.setWoodType(this.type);
                boatentity.yRot = playerIn.yRot + 90F;
                if (!worldIn.noCollision(boatentity, boatentity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemstack);
                } else {
                    if (!worldIn.isClientSide) {
                        worldIn.addFreshEntity(boatentity);
                        if (boatentity.getStatus().equals(AbstractWaterVehicle.Status.IN_WATER)) {
                            worldIn.playSound(null, boatentity.getX(), boatentity.getY(), boatentity.getZ(), SoundEvents.PLAYER_SPLASH, SoundCategory.BLOCKS, 0.75F, 0.8F);
                            worldIn.playSound(null, boatentity.getX(), boatentity.getY(), boatentity.getZ(), SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundCategory.BLOCKS, 0.75F, 0.8F);
                        }
                        if (!playerIn.abilities.instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    playerIn.awardStat(Stats.ITEM_USED.get(this));
                    return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
                }
            } else {
                return ActionResult.pass(itemstack);
            }
        }
    }

}