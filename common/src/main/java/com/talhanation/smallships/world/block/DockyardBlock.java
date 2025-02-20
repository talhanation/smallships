package com.talhanation.smallships.world.block;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.minecraft.world.level.block.entity.DropperBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class DockyardBlockEntity extends BlockEntity implements MenuProvider {
    private static final int BUILD_TIME = 200; // 10s
    private int progress = 0;
    private boolean isBuilding = false;
    BrewingStandBlock
    public DockyardBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.DOCKYARD.get(), pos, state);
    }

    public void startBuilding() {
        if (!isBuilding) {
            isBuilding = true;
            progress = 0;
            setChanged();
        }
    }

    public static void tick(ServerLevel level, BlockPos pos, BlockState state, DockyardBlockEntity entity) {
        if (entity.isBuilding) {
            entity.progress++;

            if (entity.progress % 20 == 0) {
                level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                        5, 0.2, 0.2, 0.2, 0.01);
            }

            if (entity.progress >= BUILD_TIME) {
                entity.finishBuilding(level, pos);
            }
        }
    }

    private void finishBuilding(ServerLevel level, BlockPos pos) {
        isBuilding = false;
        progress = 0;
        // TODO: spawn ship in close water area
        setChanged();
    }

    public int getProgress() {
        return progress;
    }

    public boolean isBuilding() {
        return isBuilding;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        progress = tag.getInt("Progress");
        isBuilding = tag.getBoolean("IsBuilding");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Progress", progress);
        tag.putBoolean("IsBuilding", isBuilding);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, net.minecraft.world.entity.player.Inventory inventory, Player player) {
        return new DockyardMenu(id, inventory, this, new ContainerData() {
            @Override
            public int get(int index) {
                return (index == 0) ? progress : BUILD_TIME;
            }

            @Override
            public void set(int index, int value) {}

            @Override
            public int getCount() {
                return 2;
            }
        });
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.dockyard");
    }
}
