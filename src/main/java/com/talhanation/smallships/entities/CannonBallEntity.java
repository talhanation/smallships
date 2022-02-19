package com.talhanation.smallships.entities;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class CannonBallEntity extends AbstractCannonBall{

    public CannonBallEntity(EntityType<? extends AbstractCannonBall> type, World world) {
        super(type, world);
    }

    public CannonBallEntity(World world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.CANNON_BALL.get(), owner, d1, d2, d3, world);
    }


}
