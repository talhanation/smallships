package com.talhanation.smallships.world.entity.ship.seat;

public enum SeatType {
    /** The helm. Only the occupant of this seat controls the ship. */
    DRIVER,
    /** A plain passenger seat. */
    PASSENGER,
    /** A gunner seat: the occupant controls the mapped cannon slot. */
    CANNON
}
