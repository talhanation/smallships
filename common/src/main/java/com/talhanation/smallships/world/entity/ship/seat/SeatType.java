package com.talhanation.smallships.world.entity.ship.seat;

public enum SeatType {
    /** The helm. Only the occupant of this seat controls the ship. */
    DRIVER,
    /** A plain passenger seat, always available. */
    PASSENGER,
    /**
     * A seat BEHIND a gun: the occupant works the mapped cannon slot. Whether a
     * gun is actually installed does not matter - an empty post is still a post.
     */
    GUNNER,
    /**
     * A seat ON a gun carriage, that is: the spot the gun itself would stand in.
     * Available as a plain passenger seat for as long as the mapped slot carries
     * no gun, and taken back the moment one is installed - the occupant would be
     * sitting inside the barrel otherwise. Not the same thing as GUNNER, which
     * is the post next to it.
     */
    CANNON
}