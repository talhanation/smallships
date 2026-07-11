package com.talhanation.smallships.world.entity.ship.seat;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.phys.Vec3;

/**
 * A fixed seat on a ship. Seats use the same local (v, h) coordinate frame as
 * the old index-based passenger offsets: v = along the ship (negative = stern,
 * where the helm sits), h = sideways. Positions are FIXED per seat id - a
 * passenger assigned to seat 6 stays on seat 6, no matter who else mounts or
 * dismounts.
 *
 * @param id                stable id within the ship type
 * @param v                 lengthwise offset (same frame as the old passenger offsets)
 * @param h                 sideways offset
 * @param type              DRIVER / PASSENGER / CANNON
 * @param mappedCannonSlot  the cannon slot a CANNON seat controls, -1 otherwise
 */
public record ShipSeat(int id, float v, float h, SeatType type, int mappedCannonSlot) {

    public static ShipSeat driver(int id, float v, float h) {
        return new ShipSeat(id, v, h, SeatType.DRIVER, -1);
    }

    public static ShipSeat passenger(int id, float v, float h) {
        return new ShipSeat(id, v, h, SeatType.PASSENGER, -1);
    }

    public static ShipSeat cannon(int id, float v, float h, int mappedCannonSlot) {
        return new ShipSeat(id, v, h, SeatType.CANNON, mappedCannonSlot);
    }

    /**
     * @return the attachment vector for positionRider, identical math to the
     * old getPassengerAttachmentPoint implementations.
     */
    public Vec3 getAttachmentPoint(Ship ship, EntityDimensions dimensions) {
        return new Vec3(this.v, dimensions.height() - 0.1, this.h)
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
    }

    /**
     * @return the world position of this seat, used for the nearest-seat search.
     */
    public Vec3 getWorldPosition(Ship ship) {
        Vec3 local = new Vec3(this.v, 0.0D, this.h)
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
        return ship.position().add(local);
    }
}
