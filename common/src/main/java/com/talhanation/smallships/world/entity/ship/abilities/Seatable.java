package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;
import java.util.List;
import java.util.UUID;

/**
 * Fixed seat system: every ship type defines a list of {@link ShipSeat}s.
 * The seat assignment is stored per seat id in {@link Ship#SEAT_ASSIGNMENTS}
 * (synced entity data), so a passenger's position NEVER changes when other
 * passengers mount or dismount.
 */
public interface Seatable extends Ability {

    /** The fixed seat layout of this ship type. */
    List<ShipSeat> getSeats();

    /* ---------------- assignment access ---------------- */

    private static String key(int seatId) {
        return "Seat" + seatId;
    }


    @Nullable
    default ShipSeat getSeatById(int seatId) {
        for (ShipSeat seat : this.getSeats()) {
            if (seat.id() == seatId) return seat;
        }
        return null;
    }

    /** @return the seat the given passenger is assigned to, or null. */
    @Nullable
    default ShipSeat getSeatOf(Entity passenger) {
        CompoundTag tag = self().getData(Ship.SEAT_ASSIGNMENTS);
        for (ShipSeat seat : this.getSeats()) {
            if (tag.hasUUID(key(seat.id())) && tag.getUUID(key(seat.id())).equals(passenger.getUUID())) {
                return seat;
            }
        }
        return null;
    }

    /** @return the passenger sitting on the given seat, or null. */
    @Nullable
    default Entity getSeatOccupant(int seatId) {
        CompoundTag tag = self().getData(Ship.SEAT_ASSIGNMENTS);
        if (!tag.hasUUID(key(seatId))) return null;
        UUID uuid = tag.getUUID(key(seatId));
        for (Entity passenger : self().getPassengers()) {
            if (passenger.getUUID().equals(uuid)) return passenger;
        }
        return null;
    }

    default boolean isSeatFree(int seatId) {
        return this.getSeatOccupant(seatId) == null;
    }

    /**
     * @return true when a gun is standing in this seat right now. Only CANNON
     * seats can ever be blocked - they ARE the carriage, so an installed gun
     * occupies the space. A GUNNER post stays open either way.
     */
    default boolean isSeatBlocked(ShipSeat seat) {
        if (seat.type() != SeatType.CANNON) return false;
        if (!(this instanceof Cannonable cannonable)) return false;
        return cannonable.isCannonInSlot(seat.mappedCannonSlot());
    }

    /**
     * @return how many seats can actually be taken right now. This is what the
     * crew counter shows: a carriage with a gun on it is not a seat.
     */
    default int getUsableSeatCount() {
        int usable = 0;
        for (ShipSeat seat : this.getSeats()) {
            if (!this.isSeatBlocked(seat)) usable++;
        }
        return usable;
    }

    default void assignSeat(Entity passenger, int seatId) {
        CompoundTag tag = self().getData(Ship.SEAT_ASSIGNMENTS).copy();
        // a passenger can only occupy one seat
        for (ShipSeat seat : this.getSeats()) {
            if (tag.hasUUID(key(seat.id())) && tag.getUUID(key(seat.id())).equals(passenger.getUUID())) {
                tag.remove(key(seat.id()));
            }
        }
        tag.putUUID(key(seatId), passenger.getUUID());
        self().setData(Ship.SEAT_ASSIGNMENTS, tag);
    }

    default void freeSeatOf(Entity passenger) {
        CompoundTag tag = self().getData(Ship.SEAT_ASSIGNMENTS).copy();
        boolean changed = false;
        for (ShipSeat seat : this.getSeats()) {
            if (tag.hasUUID(key(seat.id())) && tag.getUUID(key(seat.id())).equals(passenger.getUUID())) {
                tag.remove(key(seat.id()));
                changed = true;
            }
        }
        if (changed) self().setData(Ship.SEAT_ASSIGNMENTS, tag);
    }

    /**
     * Removes assignments whose passenger is no longer riding the ship.
     * Called periodically server side.
     */
    default void validateSeatAssignments() {
        CompoundTag tag = self().getData(Ship.SEAT_ASSIGNMENTS);
        CompoundTag cleaned = null;
        for (ShipSeat seat : this.getSeats()) {
            if (!tag.hasUUID(key(seat.id()))) continue;
            UUID uuid = tag.getUUID(key(seat.id()));
            boolean present = self().getPassengers().stream().anyMatch(p -> p.getUUID().equals(uuid));
            if (!present) {
                if (cleaned == null) cleaned = tag.copy();
                cleaned.remove(key(seat.id()));
            }
        }
        if (cleaned != null) self().setData(Ship.SEAT_ASSIGNMENTS, cleaned);
    }

    /* ---------------- nearest seat search ---------------- */

    /**
     * @param worldPos  the position to search from (hit position or entity position)
     *                  seats (falling back to CANNON seats when full, never DRIVER)
     * @return the nearest free seat or null
     *
     * @param canDrive whether this entity is allowed to take the helm, see
     *                 Ship#canDrive. Anything else never lands on a DRIVER seat.
     * @return the seat to put the entity on, or NULL when the ship is full.
     *
     * Null really does mean full and has to be treated as such by the caller -
     * boarding anyway leaves the passenger without an assignment, and an
     * unassigned passenger falls back to the default attachment point, which is
     * why a whole crew used to end up standing in one spot.
     */
    @Nullable
    default ShipSeat findNearestFreeSeat(Vec3 worldPos, boolean canDrive) {
        // the helm first, but only if it is actually free
        if (canDrive) {
            for (ShipSeat seat : this.getSeats()) {
                if (seat.type() == SeatType.DRIVER && this.isSeatFree(seat.id())) return seat;
            }
        }

        ShipSeat best = this.nearestFree(worldPos, seat -> seat.type() == SeatType.PASSENGER);
        // an empty gun carriage is simply a place to sit
        if (best == null) best = this.nearestFree(worldPos, seat -> seat.type() == SeatType.CANNON);
        // gun posts last, so a passenger does not take a station off a gunner
        if (best == null) best = this.nearestFree(worldPos, seat -> seat.type() == SeatType.GUNNER);
        return best;
    }

    @Nullable
    private ShipSeat nearestFree(Vec3 worldPos, Predicate<ShipSeat> filter) {
        ShipSeat best = null;
        double bestDist = Double.MAX_VALUE;
        for (ShipSeat seat : this.getSeats()) {
            if (!filter.test(seat) || !this.isSeatFree(seat.id()) || this.isSeatBlocked(seat)) continue;
            double dist = seat.getWorldPosition(self()).distanceToSqr(worldPos);
            if (dist < bestDist) {
                bestDist = dist;
                best = seat;
            }
        }
        return best;
    }

    /* ---------------- gunner helpers ---------------- */

    /**
     * @return the player manning the CANNON seat mapped to the given cannon
     * slot, or null if the seat is unmanned or doesn't exist.
     */
    @Nullable
    default Player getGunner(int cannonSlot) {
        for (ShipSeat seat : this.getSeats()) {
            if (seat.type() == SeatType.GUNNER && seat.mappedCannonSlot() == cannonSlot) {
                return this.getSeatOccupant(seat.id()) instanceof Player player ? player : null;
            }
        }
        return null;
    }
}