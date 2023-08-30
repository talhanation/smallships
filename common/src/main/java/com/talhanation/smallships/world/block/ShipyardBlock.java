package com.talhanation.smallships.world.block;

import com.talhanation.smallships.world.entity.shipyard.ShipyardShip;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.RepeaterBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class ShipyardBlock extends Block implements EntityBlock {
    private static final int maxProgress = 4;
    public static final DirectionProperty FACING;
    public static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, maxProgress);

    public ShipyardBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext arg) {
        return (BlockState)this.defaultBlockState().setValue(FACING, arg.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        level.setBlock(pos, (BlockState) state.cycle(PROGRESS), 1);
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
