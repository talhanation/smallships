package com.talhanation.smallships.entities;

import com.talhanation.smallships.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ShipMast extends AbstractShipPart{

    protected AxisAlignedBB boundingBox;
    private double height;
    private double width;

    public ShipMast(EntityType<ShipMast> type, World world) {
        super(type, world);
    }

    public ShipMast(AbstractShipDamage sailShip, float offset, float yOffset, double height, double width) {
        this(ModEntityTypes.SHIP_MAST.get(), sailShip.level);
        this.sailShip = sailShip;
        this.offset = offset;
        this.yOffset =yOffset;
        this.height = height;
        this.width = width;
        this.setDeltaMovement(Vector3d.ZERO);
        recalculateBoundingBox();
        updatePosition();
        this.xo = getX();
        this.yo = getY();
        this.zo = getZ();

    }


    @Override
    public void tick() {
        super.tick();
        //recalculateBoundingBox();
    }

    public void recalculateBoundingBox() {
        double width = this.width;
        double height = this.height;
        boundingBox = new AxisAlignedBB(getX() - width / 2D, getY(), getZ() - width / 2D, getX() + width / 2D, getY() + height, getZ() + width / 2D);
    }

    @Override
    public AxisAlignedBB getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void setBoundingBox(AxisAlignedBB boundingBox) {
        this.boundingBox = boundingBox;
    }
}
