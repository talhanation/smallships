package com.talhanation.smallships.entities.projectile;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class CannonBallEntity extends AbstractCannonBall {

    public CannonBallEntity(EntityType<? extends AbstractCannonBall> type, World world) {
        super(type, world);
    }

    public CannonBallEntity(World world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.CANNON_BALL.get(), owner, d1, d2, d3, world);
    }
}
