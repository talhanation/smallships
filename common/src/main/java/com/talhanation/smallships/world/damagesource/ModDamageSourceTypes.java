package com.talhanation.smallships.world.damagesource;

import com.talhanation.smallships.mixin.damaging.DamageSourceAccessor;
import com.talhanation.smallships.world.entity.projectile.AbstractCannonBall;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("DataFlowIssue")
public class ModDamageSourceTypes {
    public static DamageSource cannonBall(AbstractCannonBall cannonBall, @Nullable Entity owner) {
        return ((DamageSourceAccessor)new IndirectEntityDamageSource("cannonBall", cannonBall, owner).setProjectile().setExplosion()).callBypassArmor();
    }

    public static DamageSource shipCollision(Ship ship, @Nullable Entity owner) {
        return ((DamageSourceAccessor)new IndirectEntityDamageSource("shipCollision", ship, owner)).callBypassArmor();
    }
}
