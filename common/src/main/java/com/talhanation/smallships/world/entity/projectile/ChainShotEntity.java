package com.talhanation.smallships.world.entity.projectile;


import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ChainShotEntity extends AbstractCannonBall {
    public static final String ID = "cannon_ball";

    public static ChainShotEntity factory(EntityType<? extends AbstractCannonBall> entityType, Level level) {
        return new ChainShotEntity(entityType, level);
    }

    public ChainShotEntity(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
    }

    public ChainShotEntity(Level world) {
        super(ModEntityTypes.CHAIN_SHOT, world);
    }

    public ChainShotEntity(Level world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.CHAIN_SHOT, owner, d1, d2, d3, world);
    }
}
