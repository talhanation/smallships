package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.projectile.CannonBallEntity;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
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
import net.minecraft.world.phys.Vec3;

public class GroundCannonEntity extends MinecartChest {
    public static final String ID = "ground_cannon";

    public GroundCannonEntity(Level level, Vec3 pos) {
        super(ModEntityTypes.GROUND_CANNON, level);
        this.setPos(pos);
    }

    public GroundCannonEntity(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static GroundCannonEntity factory(EntityType<? extends GroundCannonEntity> entityType, Level level) {
        return new GroundCannonEntity(entityType, level);
    }

    public AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return ChestMenu.threeRows(i, inventory, this); //TODO
    }

    public boolean canPlaceItem(int i, ItemStack itemStack) {
        return itemStack.is(ModItems.CANNON_BALL);
    }
}
