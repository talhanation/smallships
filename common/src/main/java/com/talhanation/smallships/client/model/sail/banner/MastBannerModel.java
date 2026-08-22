package com.talhanation.smallships.client.model.sail.banner;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Base of the flags flying from a mast. Same segmented banner surface as the
 * sail banners, but positioned by the model instead of by a banner position of
 * the ship, so the whole placement is configured in Blockbench.
 * <p>
 * Model structure, on top of the conventions of {@link SailBannerModel}:
 * <ul>
 * <li>the group node sits where the flag is attached to the mast and stays
 * unrotated - it is the pivot the flag turns on with the wind</li>
 * <li>below it one node holds the cloth, rotated into the position the flag
 * flies in; a flag streaming horizontally is a normal 20 wide and 40 long
 * banner surface with that node turned by -90 degrees around Z</li>
 * <li>the strips of the cloth are the {@code segment_N} children of that node,
 * chained from the mast outwards so the wave travels along the cloth</li>
 * </ul>
 * Positions are in the model space of the ship, the same space the sail banner
 * models use. The cloth is modeled at the size of the banner layout and shrunk
 * by {@link #CLOTH_SCALE} at render time. That scale sits on the group node, so
 * it is applied around the pivot: the point the flag is mounted at stays where
 * Blockbench put it and the cloth keeps its proportions, no matter which scale
 * is used. Never scale the pose stack instead - that scales the pivot along
 * with it and moves the flag off its mast.
 */
public abstract class MastBannerModel extends SailBannerModel {
    /**
     * Size of the cloth relative to the modeled 20x40 surface. Uniform on
     * purpose: anything else would squash the banner pattern. Keep it positive,
     * a negative scale mirrors the flag.
     */
    public static final float CLOTH_SCALE = 0.66F;

    protected MastBannerModel(@NotNull LayerDefinition layerDefinition) {
        super(layerDefinition);
    }

    /** Lets a ship fly a smaller or larger flag than the shared default. */
    protected float getClothScale() {
        return CLOTH_SCALE;
    }

    /**
     * Turns the flag into the wind, sizes it and bends the cloth. The wind
     * offset turns the group node on its pivot, the wave angle is spread evenly
     * over the strips: every strip adds the same share, so the cloth reaches
     * the wave angle at its outer edge but bends on the way there.
     */
    public void setupAnim(float windOffset, float bannerWaveAngle) {
        float clothScale = this.getClothScale();
        for (int groupIndex = 0; groupIndex < this.getGroupCount(); groupIndex++) {
            ModelPart groupPart = this.getGroupPart(groupIndex);
            groupPart.yRot = windOffset * Mth.DEG_TO_RAD;
            groupPart.xScale = clothScale;
            groupPart.yScale = clothScale;
            groupPart.zScale = clothScale;
            List<ModelPart> segments = this.getSegmentParts(groupIndex);
            float segmentRot = bannerWaveAngle * Mth.DEG_TO_RAD / segments.size();
            for (ModelPart segment : segments) {
                segment.xRot = segmentRot;
            }
        }
    }
}