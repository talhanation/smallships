package com.talhanation.smallships.entities.projectile;
import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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

    public void shootCannonBall(double x,  double y, double z, LivingEntity owner, boolean isAccurate, float speed, float k) {
        CannonBallEntity cannonBall = new CannonBallEntity(ModEntityTypes.CANNON_BALL.get(), level);
        Random random = this.level.random;
        float inaccuracy = 1F;
        float xO = isAccurate ? 0 : (random.nextFloat() - 0.5F) * inaccuracy;
        float yO = isAccurate ? 0 : (random.nextFloat() - 0.5F) * inaccuracy;
        float zO = isAccurate ? 0 : (random.nextFloat() - 0.5F) * inaccuracy;
        cannonBall.shoot(x + xO, y + yO, z + zO, speed, k);

        level.addFreshEntity(cannonBall);
        level.playSound(null, owner.getX(), owner.getY(), owner.getZ(),
                SoundEvents.WOODEN_BUTTON_CLICK_ON, SoundCategory.PLAYERS, 1,
                1f);

    }

}
