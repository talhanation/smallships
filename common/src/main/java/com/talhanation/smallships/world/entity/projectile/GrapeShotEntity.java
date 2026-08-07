package com.talhanation.smallships.world.entity.projectile;


import com.talhanation.smallships.world.entity.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class GrapeShotEntity extends AbstractCannonBall {
    public static final String ID = "grape_shot";

    public static GrapeShotEntity factory(EntityType<? extends AbstractCannonBall> entityType, Level level) {
        return new GrapeShotEntity(entityType, level);
    }

    public GrapeShotEntity(EntityType<? extends AbstractCannonBall> type, Level world) {
        super(type, world);
    }

    public GrapeShotEntity(Level world) {
        super(ModEntityTypes.GRAPE_SHOT, world);
    }

    public GrapeShotEntity(Level world, LivingEntity owner, double d1, double d2, double d3) {
        super(ModEntityTypes.GRAPE_SHOT, owner, d1, d2, d3, world);
    }

    /**
     * Grape shot is the only type that fires more than one projectile, and the
     * extra pellets have to be grape shot as well - the base class would hand
     * out plain cannon balls, which would render wrong and hit like solid shot.
     */
    @Override
    protected AbstractCannonBall createSibling() {
        return new GrapeShotEntity(this.level());
    }
}