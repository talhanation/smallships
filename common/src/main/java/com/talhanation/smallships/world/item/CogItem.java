package com.talhanation.smallships.world.item;

import com.talhanation.smallships.world.entity.ship.CogEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CogItem extends ShipItem {
    public CogItem(Boat.Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        return super.use(level, player, interactionHand);
    }

    @Override
    public Boat getBoat(@NotNull Level level, double x, double y, double z) {
        return CogEntity.summon(level, x, y, z);
    }
}
