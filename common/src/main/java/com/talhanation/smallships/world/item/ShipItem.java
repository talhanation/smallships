package com.talhanation.smallships.world.item;

import com.talhanation.smallships.api.ShipItems;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

/**
 * Places a ship instead of a boat.
 *
 * One class for every ship: what it places is handed in as the ships' factory.
 * There used to be a subclass per ship that did nothing but name its summon
 * method - and every addon had to write the same again. The items themselves
 * are created by {@link ShipItems}.
 */
public class ShipItem extends BoatItem {
    private final ShipType.Factory factory;

    public ShipItem(Boat.Type type, ShipType.Factory factory, Properties properties) {
        super(false, type, properties);
        this.factory = factory;
    }

    protected @NotNull Ship getShip(@NotNull Level level, double x, double y, double z) {
        return this.factory.summon(level, x, y, z);
    }

    protected @NotNull Boat getBoat(@NotNull Level level, @NotNull HitResult hitResult, ItemStack stack, Player player) {
        Ship ship = this.getShip(level, hitResult.getLocation().x, hitResult.getLocation().y, hitResult.getLocation().z);
        if (level instanceof ServerLevel serverLevel) {
            EntityType.<Ship>createDefaultStackConfig(serverLevel, stack, player).accept(ship);
        }
        return ship;
    }
}
