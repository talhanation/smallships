package com.talhanation.smallships.client.model.sail.banner;

import com.talhanation.smallships.world.entity.ship.Ship;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Banner surface for the Cog sail: one group of 8 horizontal strips
 * (20x5 model pixels each, 20x40 in total), chained top to bottom along the
 * lsail curvature. Geometry taken 1:1 from the Bockbench export
 * {@code ModelCogSailBanner}.
 */
public class CogSailBannerModel extends SailBannerModel {
    private static final List<Group> GROUPS = List.of(new Group(-0.425F, 24.0F, -6.6F, false, List.of(
            //          pivotX  pivotY   pivotZ  zRot      boxX  boxY   boxZ  wPx    hPx   uPx   vPx
            new Segment(1.55F, -62.2F, -4.4F, 0.7418F, 0.0F, -4.7F, 0.0F, 20.0F, 5.0F, 0.0F, 0.0F),
            new Segment(0.0F, 0.3F, 0.0F, -0.2531F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 5.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.1309F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 10.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.3054F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 15.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.2443F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 20.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.0873F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 25.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.2182F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 30.0F),
            new Segment(0.0F, 5.0F, 0.0F, -0.1745F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 35.0F)
    )));

    @Override
    protected @NotNull List<Group> getGroups() {
        return GROUPS;
    }

    @Override
    protected boolean isSegmentVisible(@NotNull Ship ship, int groupIndex, int segment) {
        switch (ship.getData(Ship.SAIL_STATE)) {
            case 0 -> {
                return false;
            }
            case 1 -> {
                return segment == 0;
            }
            case 2 -> {
                return segment == 0 || segment == 1 || segment == 2;
            }
            case 3 -> {
                return segment == 0 || segment == 1 || segment == 2 || segment == 3 || segment == 4;
            }
        }
        return true;
    }
}