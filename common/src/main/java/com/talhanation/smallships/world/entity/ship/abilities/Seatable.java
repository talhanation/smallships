package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.seat.SeatType;
import com.talhanation.smallships.world.entity.ship.seat.ShipSeat;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

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
     * @param forPlayer players may take any seat; other entities only PASSENGER
     *                  seats (falling back to CANNON seats when full, never DRIVER)
     * @return the nearest free seat or null
     */
    @Nullable
    default ShipSeat findNearestFreeSeat(Vec3 worldPos, boolean forPlayer) {
        ShipSeat best = null;
        double bestDist = Double.MAX_VALUE;
        for (ShipSeat seat : this.getSeats()) {
            if (forPlayer && this.self().getDriver() == null){
                if(seat.type() != SeatType.DRIVER) continue;
                else{
                    return seat;
                }
                
            }
            if (!this.isSeatFree(seat.id())) continue;

            if (!forPlayer && seat.type() != SeatType.PASSENGER) continue;
            double dist = seat.getWorldPosition(self()).distanceToSqr(worldPos);
            if (dist < bestDist) {
                bestDist = dist;
                best = seat;
            }
        }
        if (best == null && !forPlayer) {
            // mobs: fall back to CANNON seats when all passenger seats are taken
            for (ShipSeat seat : this.getSeats()) {
                if (seat.type() == SeatType.DRIVER || !this.isSeatFree(seat.id())) continue;
                double dist = seat.getWorldPosition(self()).distanceToSqr(worldPos);
                if (dist < bestDist) {
                    bestDist = dist;
                    best = seat;
                }
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
            if (seat.type() == SeatType.CANNON && seat.mappedCannonSlot() == cannonSlot) {
                return this.getSeatOccupant(seat.id()) instanceof Player player ? player : null;
            }
        }
        return null;
    }
}
