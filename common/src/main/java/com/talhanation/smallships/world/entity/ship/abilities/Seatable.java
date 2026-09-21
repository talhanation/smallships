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
     * Picks the seat an entity gets when it BOARDS the ship.
     *
     * Two different rules, because the two groups want different things:
     *
     * - Whoever may steer takes the helm if it is open, wherever he clicked - a
     *   captain boarding a ship is there to sail it. Is the helm taken, he goes
     *   to whatever is closest to the spot he clicked, see {@link #findSeatAt}.
     * - Everyone else fills the ship up from the passenger seats and only ends
     *   up at a gun post when nothing else is left, so a mob being pulled aboard
     *   never takes a station off someone who could work it.
     *
     * @param worldPos the position to search from - the hit position of the
     *                 right click, or the entity position when there is none
     *                 (a mob being pulled aboard, a command, a Recruits captain)
     * @param canDrive whether this entity is allowed to take the helm, see
     *                 Ship#canDrive
     * @return the seat to put the entity on, or NULL when the ship is full.
     *
     * Null really does mean full and has to be treated as such by the caller -
     * boarding anyway leaves the passenger without an assignment, and an
     * unassigned passenger falls back to the default attachment point, which is
     * why a whole crew used to end up standing in one spot.
     */
    @Nullable
    default ShipSeat findNearestFreeSeat(Vec3 worldPos, boolean canDrive) {
        if (canDrive) {
            for (ShipSeat seat : this.getSeats()) {
                if (seat.type() == SeatType.DRIVER && this.isSeatFree(seat.id())) return seat;
            }
            return this.findSeatAt(worldPos, false);
        }

        // an empty gun carriage is simply a place to sit, so it counts as a
        // passenger seat here - only the POST behind the gun is held back
        ShipSeat best = this.nearestFree(worldPos, seat ->
                seat.type() == SeatType.PASSENGER || seat.type() == SeatType.CANNON);
        if (best == null) best = this.nearestFree(worldPos, seat -> seat.type() == SeatType.GUNNER);
        return best;
    }

    /**
     * Picks the seat for a DELIBERATE click on a spot of the ship: purely by
     * distance, no type ranking at all. Used when someone already aboard clicks
     * another station, and as the second half of {@link #findNearestFreeSeat}
     * once the helm is taken.
     *
     * The helm is never jumped to from here even when it is free - a player
     * switching seats clicked at something specific, and teleporting him to the
     * wheel instead is the opposite of what he asked for. It only becomes a
     * candidate when the caller says so.
     *
     * A gun carriage counts as a target even while a gun stands on it: nobody
     * can sit there, but clicking a cannon means the cannon, so the post that
     * works that same slot is handed back instead.
     *
     * @param includeDriver whether the helm may be picked by distance too
     */
    @Nullable
    default ShipSeat findSeatAt(Vec3 worldPos, boolean includeDriver) {
        ShipSeat target = null;
        double bestDist = Double.MAX_VALUE;
        for (ShipSeat seat : this.getSeats()) {

            if (includeDriver && seat.type() == SeatType.DRIVER && this.isSeatFree(seat.id())) return seat;

            boolean carriageWithGun = seat.type() == SeatType.CANNON && this.isSeatBlocked(seat);
            if (!carriageWithGun && !this.isSeatFree(seat.id())) continue;
            double dist = seat.getWorldPosition(self()).distanceToSqr(worldPos);
            if (dist < bestDist) {
                bestDist = dist;
                target = seat;
            }
        }
        if (target == null) return null;

        if (target.type() == SeatType.CANNON && this.isSeatBlocked(target)) {
            ShipSeat gunner = this.freeGunnerSeat(target.mappedCannonSlot());
            // that post is manned as well - fall back to whatever is genuinely
            // free, so a click on a busy gun never refuses the boarding outright
            if (gunner != null) return gunner;
            return this.nearestFree(worldPos, seat -> includeDriver || seat.type() != SeatType.DRIVER);
        }
        return target;
    }

    /** @return the free GUNNER post working the given cannon slot, or null. */
    @Nullable
    private ShipSeat freeGunnerSeat(int cannonSlot) {
        for (ShipSeat seat : this.getSeats()) {
            if (seat.type() == SeatType.GUNNER && seat.mappedCannonSlot() == cannonSlot
                    && this.isSeatFree(seat.id())) {
                return seat;
            }
        }
        return null;
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