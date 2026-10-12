package com.talhanation.smallships.world.entity.cannon;

/**
 * The barrel geometry of the cannon model, in ONE place.
 *
 * Everything that has to agree on where a cannon barrel is - the shot, the
 * trajectory preview, the aim camera and the model itself - reads its numbers
 * from here. The values are in Blockbench model units, exactly as they sit in
 * CannonModel, and are converted into blocks with the scales the renderers draw
 * at. Move a part in Blockbench and this class is the one place that follows.
 *
 * Deliberately in the common package and free of any client class: the shot is
 * calculated on the server, which never loads a model.
 */
public final class CannonGeometry {
    private CannonGeometry() {}

    /** the trunnions, the point the barrel pitches around, relative to the model root */
    public static final float TRUNNION_X = 0.5F;
    public static final float TRUNNION_Y = 13.0F;
    public static final float TRUNNION_Z = -4.0F;
    /** trunnions to the muzzle band, the last thing on the barrel before open air */
    public static final float BARREL_LENGTH = 18.0F;
    /** the scale the cannon model is drawn at, see the renderers */
    public static final float MODEL_SCALE = 0.6F;
    /** the scale of the pose the model is drawn in (the hull scale) */
    public static final float POSE_SCALE = 1.3F;
    /** the vanilla entity model origin, 24 units above the feet - the translate in GroundCannonRenderer */
    public static final float MODEL_ORIGIN_Y = 24.0F;
    /** clearance in front of the metal so the ball leaves the barrel and not the muzzle band */
    public static final float MUZZLE_CLEARANCE = 0.2F;
    /** half height of the barrel: the boxes of Lauf run from -4.5 to 4.5 around the trunnions */
    public static final float BARREL_RADIUS = 4.5F;

    /** model units to blocks in the world, both scales included */
    public static float toBlocks(float modelUnits) {
        return modelUnits * MODEL_SCALE * POSE_SCALE / 16.0F;
    }

    /** blocks in the world back to model units */
    public static float toModelUnits(float blocks) {
        return blocks * 16.0F / (MODEL_SCALE * POSE_SCALE);
    }

    /** trunnions to the spawn point, in model units - for the callers that draw in model space */
    public static float spawnLength() {
        return BARREL_LENGTH + toModelUnits(MUZZLE_CLEARANCE);
    }

    /**
     * Height of the trunnions above the origin of the pose the model is drawn in.
     *
     * Model y grows DOWNWARDS and the pose mirrors it, so a part below the model
     * origin ends up above the pose origin in the world.
     *
     * @param originY where the model origin sits in model units - 24 for a renderer
     *                that translates by the vanilla -1.5 blocks, 0 for one that
     *                draws the model straight onto its pose origin
     */
    public static float trunnionHeight(float originY) {
        return toBlocks(originY - TRUNNION_Y);
    }

    /** trunnions in front of the pose origin, along the yaw */
    public static float trunnionForward() {
        return toBlocks(-TRUNNION_Z);
    }

    /** trunnions to the visible muzzle */
    public static float muzzleDistance() {
        return toBlocks(BARREL_LENGTH);
    }

    /** trunnions to the point the projectile spawns at */
    public static float spawnDistance() {
        return muzzleDistance() + MUZZLE_CLEARANCE;
    }

    /**
     * How far above the bore an aiming eye has to sit: exactly the barrel, so
     * the gunner looks ALONG the metal instead of standing inside it.
     */
    public static float sightHeight() {
        return toBlocks(BARREL_RADIUS);
    }

    /**
     * The ground cannon: its renderer translates by the vanilla -1.5 blocks, so
     * the trunnions end up ABOVE the entity position.
     */
    public static float groundTrunnionHeight() {
        return trunnionHeight(MODEL_ORIGIN_Y);
    }

    /**
     * A ship gun: its renderer draws the model straight onto the mounting point,
     * so the trunnions hang BELOW it - the value is negative.
     */
    public static float shipTrunnionHeight() {
        return trunnionHeight(0.0F);
    }
}