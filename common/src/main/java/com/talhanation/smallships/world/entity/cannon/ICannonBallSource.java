package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.item.CannonBallItem;
import org.jetbrains.annotations.Nullable;

/**
 * A source of cannonballs. This can also be used
 * to redirect consumption to another source.
 */
public interface ICannonBallSource {
    void consumeCannonBall();

    /**
     * //TODO might be useful for future different cannonball types.
     * @return the cannonball item type to shoot. Null if there is none available.
     */
    @Nullable
    CannonBallItem getCannonBallToShoot();
}
