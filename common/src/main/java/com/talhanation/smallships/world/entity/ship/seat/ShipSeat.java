package com.talhanation.smallships.world.entity.ship.seat;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

/**
 * A fixed seat on a ship. Seats use the same local (v, y, h) coordinate frame as
 * the cannons and the hull parts: v = along the ship (negative = stern, where
 * the helm sits), h = sideways, y = up. Positions are FIXED per seat id - a
 * passenger assigned to seat 6 stays on seat 6, no matter who else mounts or
 * dismounts.
 *
 * y is an offset ON TOP of the deck height the ship reports, not an absolute
 * height. Zero therefore means "wherever this ship puts its deck", which is what
 * every seat did before this field existed - so the three argument factories
 * below keep behaving exactly as they always have, and only a seat that needs to
 * sit on a raised quarterdeck, a rowing bench or a gun carriage has to say so.
 *
 * Two of the factories map to a cannon slot and they are NOT interchangeable:
 * {@link #gunner} is the post next to a gun, {@link #cannon} is the carriage the
 * gun itself stands on. See {@link SeatType}.
 *
 * @param id                stable id within the ship type
 * @param v                 lengthwise offset (negative = stern)
 * @param y                 height offset above deck level, 0 = on the deck
 * @param h                 sideways offset
 * @param type              DRIVER / PASSENGER / GUNNER / CANNON
 * @param mappedCannonSlot  the cannon slot a GUNNER or CANNON seat belongs to,
 *                          -1 otherwise
 */
public record ShipSeat(int id, float v, float y, float h, SeatType type, int mappedCannonSlot) {

    public static ShipSeat driver(int id, float v, float h) {
        return driver(id, v, 0.0F, h);
    }

    public static ShipSeat driver(int id, float v, float y, float h) {
        return new ShipSeat(id, v, y, h, SeatType.DRIVER, -1);
    }

    public static ShipSeat passenger(int id, float v, float h) {
        return passenger(id, v, 0.0F, h);
    }

    public static ShipSeat passenger(int id, float v, float y, float h) {
        return new ShipSeat(id, v, y, h, SeatType.PASSENGER, -1);
    }

    /**
     * The post from which a gun is worked. Place it behind the gun, not on it.
     */
    public static ShipSeat gunner(int id, float v, float h, int mappedCannonSlot) {
        return gunner(id, v, 0.0F, h, mappedCannonSlot);
    }

    public static ShipSeat gunner(int id, float v, float y, float h, int mappedCannonSlot) {
        return new ShipSeat(id, v, y, h, SeatType.GUNNER, mappedCannonSlot);
    }

    /**
     * The gun carriage itself. Put this where the gun of the given slot stands:
     * it seats a passenger while the slot is empty and throws him off as soon as
     * a gun is installed there.
     */
    public static ShipSeat cannon(int id, float v, float h, int mappedCannonSlot) {
        return cannon(id, v, 0.0F, h, mappedCannonSlot);
    }

    public static ShipSeat cannon(int id, float v, float y, float h, int mappedCannonSlot) {
        return new ShipSeat(id, v, y, h, SeatType.CANNON, mappedCannonSlot);
    }

    /**
     * @return the attachment vector for positionRider. The deck height still
     * comes from the entity dimensions, the seats' own y is added on top of it.
     */
    public Vec3 getAttachmentPoint(Ship ship, EntityDimensions dimensions) {
        return new Vec3(this.v, dimensions.height() - 0.1 + this.y, this.h)
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
    }

    /**
     * @return the world position of this seat, used for the nearest-seat search.
     *
     * The deck baseline is deliberately left out here - it is the same constant
     * for every seat of a ship and would only shift the whole set, while the
     * seats' own y really does tell two of them apart.
     */
    public Vec3 getWorldPosition(Ship ship) {
        Vec3 local = new Vec3(this.v, this.y, this.h)
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
        return ship.position().add(local);
    }
}