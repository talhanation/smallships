package com.talhanation.smallships.entities;

import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ShipPart extends AbstractShipPart{


    public ShipPart(EntityType<ShipPart> type, World world) {
        super(type, world);
    }

    public ShipPart(AbstractShipDamage sailShip, float offset) {
        this(ModEntityTypes.SHIP_PART.get(), sailShip.level);
        this.sailShip = sailShip;
        this.offset = offset;
        this.setDeltaMovement(Vector3d.ZERO);
        updatePosition();
        this.xo = getX();
        this.yo = getY();
        this.zo = getZ();
    }
}
