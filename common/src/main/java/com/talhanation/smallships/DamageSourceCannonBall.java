package com.talhanation.smallships;

import net.minecraft.world.damagesource.DamageSource;

public class DamageSourceCannonBall extends DamageSource {

    public static final DamageSourceCannonBall DAMAGE_CANNONBALL = new DamageSourceCannonBall();

    protected DamageSourceCannonBall() {
        super("cannonball");
    }

    @Override
    public boolean isBypassInvul() {
        return false;
    }

    @Override
    public boolean isBypassMagic() {
        return false;
    }

    @Override
    public boolean scalesWithDifficulty() {
        return false;
    }

    @Override
    public boolean isBypassArmor() {
        return true;
    }

    @Override
    public boolean isExplosion() {
        return true;
    }

    @Override
    public boolean isFire() {
        return false;
    }

    @Override
    public boolean isMagic() {
        return false;
    }

    @Override
    public boolean isProjectile() {
        return true;
    }
}
