package com.talhanation.smallships;

import net.minecraft.util.DamageSource;

public class DamageSourceShip extends DamageSource {

    public static final DamageSourceShip DAMAGE_SHIP = new DamageSourceShip();

    public DamageSourceShip() {
        super("hit_ship");
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
        return false;
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
        return false;
    }
}
