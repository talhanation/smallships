package com.talhanation.smallships.client;

import com.talhanation.smallships.client.option.ModGameOptions;
import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Paddleable;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Decides which control tips the local player gets aboard a ship, and hands
 * them to the {@link TipManager}.
 *
 * Only what he can actually do from where he sits, on the ship he sits on:
 * - the helm gets the sail keys only on a ship with sails, the oars only on a
 *   ship with oars, the hold only on a ship with a hold
 * - the cannon keys need a MOUNTED gun - the whole broadside for the helm, the
 *   one gun of his post for a gunner. A ship that could carry cannons but has
 *   none says nothing about them.
 *
 * The tips are read off the ability interfaces and not off the ship class, so
 * an addon ship gets the right ones without registering anything. A new
 * feature only needs its own line in getTips.
 *
 * Watched from the client tick and NOT from a mount event, for the same reason
 * as the auto third person in ShipCameraHandler: the seat is assigned on the
 * server, so at the moment the client adds the passenger it cannot know yet
 * where he sits. It also catches a move to another seat and a gun mounted at
 * the dockyard while he is aboard - both change what the keys do.
 */
public class ShipTipHandler {
    private static final Component SAIL_TOGGLE = Component.translatable("tips.smallships.sail_toggle");
    private static final Component SAIL_ADJUST = Component.translatable("tips.smallships.sail_adjust");
    private static final Component ROW = Component.translatable("tips.smallships.row");
    private static final Component CANNON_AIM = Component.translatable("tips.smallships.cannon_aim");
    private static final Component CANNON_SHOOT = Component.translatable("tips.smallships.cannon_shoot");
    private static final Component CANNON_AMMO = Component.translatable("tips.smallships.cannon_ammo");
    private static final Component INVENTORY = Component.translatable("tips.smallships.inventory");
    private static final Component ZOOM = Component.translatable("tips.smallships.zoom");

    /** the ship, the seat and the gun the tips were last shown for */
    private static int lastShipId = -1;
    @Nullable
    private static SeatType lastSeatType = null;
    private static boolean lastHasCannon = false;

    /** Called once per client tick. */
    public static void tick(Minecraft minecraft) {
        LocalPlayer player = minecraft.player;
        Ship ship = player != null && player.getVehicle() instanceof Ship vehicle ? vehicle : null;
        int shipId = ship != null ? ship.getId() : -1;
        SeatType seatType = ship != null ? getSeatType(player, ship) : null;
        boolean hasCannon = seatType != null && hasCannon(player, ship, seatType);

        if (shipId == lastShipId && seatType == lastSeatType && hasCannon == lastHasCannon) return;
        lastShipId = shipId;
        lastSeatType = seatType;
        lastHasCannon = hasCannon;

        // off the ship the tips go at once, they are about keys that just stopped working
        if (seatType == null) TipManager.clear();
        else TipManager.showTips(getTips(minecraft, ship, seatType, hasCannon));
    }

    /**
     * @return the seat the player sits on, or null while the seat assignment
     * has not arrived from the server yet.
     */
    @Nullable
    private static SeatType getSeatType(Player player, Ship ship) {
        if (ship instanceof Seatable seatable) {
            ShipSeat seat = seatable.getSeatOf(player);
            return seat != null ? seat.type() : null;
        }
        // ships without a seat layout: the first passenger steers
        return player.equals(ship.getDriver()) ? SeatType.DRIVER : SeatType.PASSENGER;
    }

    /** @return true if the player has a mounted gun to work from his seat. */
    private static boolean hasCannon(Player player, Ship ship, SeatType seatType) {
        if (!(ship instanceof Cannonable cannonable)) return false;
        if (seatType == SeatType.DRIVER) return cannonable.getCannonCount() > 0;
        if (seatType == SeatType.GUNNER && ship instanceof Seatable seatable) {
            ShipSeat seat = seatable.getSeatOf(player);
            // an empty post is still a post, but there is nothing to aim or fire on it
            return seat != null && cannonable.isCannonInSlot(seat.mappedCannonSlot());
        }
        return false;
    }

    private static List<Component> getTips(Minecraft minecraft, Ship ship, SeatType seatType, boolean hasCannon) {
        Options options = minecraft.options;
        boolean driver = seatType == SeatType.DRIVER;
        // the aim is bound to the right mouse button itself, not to the use key, see MouseHandlerMixin
        String aim = Component.translatable("key.mouse.right").getString();
        String mouseWheel = Component.translatable("tips.smallships.mouse_wheel").getString();
        List<Component> tips = new ArrayList<>();

        if (driver && ship instanceof Sailable) {
            tips.add(tip(key(ModGameOptions.SAIL_KEY), SAIL_TOGGLE));
            tips.add(tip(key(options.keyUp) + " / " + key(options.keyDown), SAIL_ADJUST));
        }
        if (driver && ship instanceof Paddleable) {
            tips.add(tip(key(options.keyUp), ROW));
        }
        if (hasCannon) {
            tips.add(tip(aim, CANNON_AIM));
            tips.add(tip(aim + " + " + mouseWheel, CANNON_AMMO));
            tips.add(tip(key(options.keyJump), CANNON_SHOOT));
        }
        if (driver && ship instanceof ContainerShip) {
            tips.add(tip(key(options.keyInventory), INVENTORY));
        }
        if (canZoom(options, driver)) {
            tips.add(tip(mouseWheel, ZOOM));
        }
        return tips;
    }

    /**
     * The wheel only zooms from outside, see MouseHandlerMixin. The helm counts
     * as outside if it is about to be switched there: ShipCameraHandler does
     * that in the very tick the player takes it, before or after this class.
     */
    private static boolean canZoom(Options options, boolean driver) {
        if (!SmallShipsConfig.Client.shipGeneralCameraZoomEnable.get()) return false;
        if (!options.getCameraType().isFirstPerson()) return true;
        return driver && SmallShipsConfig.Client.shipGeneralCameraAutoThirdPerson.get();
    }

    private static Component tip(String keys, Component text) {
        return Component.literal("[" + keys + "] - ").append(text);
    }

    private static String key(KeyMapping keyMapping) {
        return keyMapping.getTranslatedKeyMessage().getString();
    }
}
