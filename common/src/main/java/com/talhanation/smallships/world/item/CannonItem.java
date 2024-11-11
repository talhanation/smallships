package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Iterator;
import java.util.List;

public class CannonItem extends Item {
    public CannonItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        if (useOnContext.getPlayer() == null) return InteractionResult.PASS;
        Player player = useOnContext.getPlayer();
        Level level = useOnContext.getLevel();
        BlockPos blockPos = useOnContext.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if ((!blockState.isSolid() && !blockState.is(BlockTags.RAILS)) || useOnContext.getClickedFace() != Direction.UP) {
            return InteractionResult.FAIL;
        }

        ItemStack itemStack = useOnContext.getItemInHand();

        Vec3 pos = new Vec3(blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5);

        /* copied from MinecartItem */
        if (blockState.is(BlockTags.RAILS)) {
            RailShape railShape = blockState.getBlock() instanceof BaseRailBlock ? blockState.getValue(((BaseRailBlock)blockState.getBlock()).getShapeProperty()) : RailShape.NORTH_SOUTH;
            double d = 0.0;
            if (railShape.isAscending()) {
                d = 0.5;
            }

            pos = new Vec3(pos.x, pos.y - 1 + 0.0625 + d, pos.z);
        }

        if (level instanceof ServerLevel serverLevel) {
            GroundCannonEntity cannon = new GroundCannonEntity(level, pos);
            cannon.setYRot(player.getYRot());
            CustomData data = itemStack.get(DataComponents.CUSTOM_DATA);
            if (data != null) data.loadInto(cannon);
            serverLevel.addFreshEntity(cannon);
            serverLevel.gameEvent(GameEvent.ENTITY_PLACE, blockPos, GameEvent.Context.of(useOnContext.getPlayer(), serverLevel.getBlockState(blockPos.below())));
        }

        itemStack.consume(1, player);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
