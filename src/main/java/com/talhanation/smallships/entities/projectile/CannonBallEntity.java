package com.talhanation.smallships.entities.projectile;

import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class CannonBallEntity extends AbstractCannonBall {

    public CannonBallEntity(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
    }

    public CannonBallEntity(Level world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.CANNON_BALL.get(), owner, d1, d2, d3, world);
    }
}
