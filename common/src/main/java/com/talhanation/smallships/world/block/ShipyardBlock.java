package com.talhanation.smallships.world.block;

import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.shipyard.ShipyardShip;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class ShipyardBlock extends Block implements EntityBlock {
    public static final int MAX_PROGRESS = 4;
    public static final DirectionProperty FACING;
    public static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, MAX_PROGRESS);

    public ShipyardBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        return this.defaultBlockState().setValue(FACING, arg.getHorizontalDirection().getOpposite());
    }

    public static int incrementProgress(BlockState state, Level level, BlockPos pos) {
        if (state.getValue(ShipyardBlock.PROGRESS) < ShipyardBlock.MAX_PROGRESS) {
            level.setBlockAndUpdate(pos, state.cycle(ShipyardBlock.PROGRESS));
        } else {
            // Spawn ship
            level.setBlockAndUpdate(pos, state.setValue(ShipyardBlock.PROGRESS, 0));

            Direction direction = state.getValue(ShipyardBlock.FACING);
            float spawnX = pos.getX() + 0.38F - (direction.getStepX() * 2.5F);
            float spawnZ = pos.getZ() + 0.38F - (direction.getStepZ() * 2.5F);

            BriggEntity brigg = BriggEntity.summon(level, spawnX, pos.getY() + 0.2F, spawnZ);
            brigg.setYRot(direction.toYRot() - 90F);
            float force = 0.65F;
            brigg.setDeltaMovement(new Vec3(-direction.getStepX() * force, 0.2F, -direction.getStepZ() * force));

            level.addFreshEntity(brigg);
        }

        return state.getValue(ShipyardBlock.PROGRESS);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        incrementProgress(state, level, pos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(PROGRESS);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ShipyardShip(blockPos, blockState);
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
    }
}
