package com.talhanation.smallships.world.entity.projectile;


import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class CannonBallEntity extends AbstractCannonBall {
    public static final String ID = "cannon_ball";

    public static CannonBallEntity factory(EntityType<? extends AbstractCannonBall> entityType, Level level) {
        return new CannonBallEntity(entityType, level);
    }

    public CannonBallEntity(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
    }

    public CannonBallEntity(Level world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.CANNON_BALL, owner, d1, d2, d3, world);
    }
}
