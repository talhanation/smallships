package com.talhanation.smallships.world.entity.cannon;

import com.talhanation.smallships.world.item.CannonBallItem;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * A source of cannonballs for the cannon.
 */
public interface ICannonBallContainer {
    void consumeCannonBall();

    /**
     * //TODO might be useful for future different cannonball types.
     * @return the cannonball item type to shoot. Null if there is none available.
     */
    @Nullable
    CannonBallItem getCannonBallToShoot();
}
