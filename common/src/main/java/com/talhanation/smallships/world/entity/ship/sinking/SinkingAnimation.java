package com.talhanation.smallships.world.entity.ship.sinking;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

/**
 * The four ways a hull goes down, and the only place the movement of a sinking
 * ship is described.
 *
 * One of them is drawn once, server side, when the ship enters the sinking
 * state and travels to the client with her, see {@link Ship#getSinkingAnimation()}.
 * Everything below is plain math on a progress value in [0..1] - the same
 * numbers come out on both sides, so a client can draw the attitude of a hull
 * that is going down without a single further packet.
 *
 * The angles are given in the frame the renderer hands in:
 * - pitch, positive: the bow rises and the stern goes under
 * - roll, positive: she heels to starboard
 * - yaw, positive: she slews her bow to starboard
 *
 * Every angle a variant asks for goes through {@link #MAX_PITCH}, {@link #MAX_ROLL}
 * and {@link #MAX_YAW} before it leaves this class. The ceilings are not a
 * suggestion the variants are trusted to keep to: they are applied in the
 * getters, so a curve that overshoots - now or after someone has tuned it -
 * cannot throw a hull further than a ship can go.
 *
 * A ship only ever TURNS on the client. How deep she is sits in her real
 * position instead, because her crew, her collision parts and the water surface
 * all have to agree on that one - see {@link #getSinkSpeed(float)}.
 */
public enum SinkingAnimation {
    /** Holed forward: she goes down by the head, stern last. */
    BOW_FIRST(260, 0.050F) {
        @Override
        protected float pitch(float progress) {
            return -TRIM * easeIn(progress);
        }

        @Override
        protected float roll(float progress) {
            return 6.0F * Mth.sin(progress * Mth.PI);
        }
    },
    /** Holed aft: the stern settles first and the bow lifts out of the water. */
    STERN_FIRST(260, 0.050F) {
        @Override
        protected float pitch(float progress) {
            return TRIM * easeIn(progress);
        }

        @Override
        protected float roll(float progress) {
            return -5.0F * Mth.sin(progress * Mth.PI);
        }
    },
    /**
     * She goes over on her side. The heel used to be thrown on in the first
     * third and read as a hull being flipped rather than one giving way, so it
     * is now spread over nearly the whole way down and stops well short of
     * lying flat - she goes under leaning, not upside down.
     */
    CAPSIZE(240, 0.055F) {
        @Override
        protected float pitch(float progress) {
            return 7.0F * Mth.sin(progress * Mth.PI);
        }

        @Override
        protected float roll(float progress) {
            return HEEL * smoothStep(Math.min(progress / CAPSIZE_SHARE, 1.0F));
        }
    },
    /**
     * Foundering on an even keel: hardly any trim, but she loses her way and
     * slews slowly around while the water takes her. The longest of the four.
     */
    EVEN_KEEL(300, 0.040F) {
        @Override
        protected float pitch(float progress) {
            return 3.5F * Mth.sin(progress * Mth.PI * 2.0F);
        }

        @Override
        protected float roll(float progress) {
            return 4.0F * Mth.sin(progress * Mth.PI * 2.0F);
        }

        @Override
        protected float yaw(float progress) {
            return SLEW * Mth.sin(progress * Mth.PI * 0.5F);
        }
    };

    /* ---------------- ceilings ---------------- */

    /** no ship ever trims further than this, in degrees */
    public static final float MAX_PITCH = 40.0F;
    /** no ship ever heels further than this, in degrees */
    public static final float MAX_ROLL = 55.0F;
    /** no ship ever slews further than this, in degrees */
    public static final float MAX_YAW = 25.0F;

    /* ---------------- curve shape ---------------- */

    /** how far bow or stern goes over before she is gone, in degrees */
    private static final float TRIM = 36.0F;
    /** how far she leans when she goes over on her side, in degrees */
    private static final float HEEL = 52.0F;
    /** how far a ship foundering upright slews around, in degrees */
    private static final float SLEW = 20.0F;
    /** share of a capsize spent leaning over; the rest of it is the way down */
    private static final float CAPSIZE_SHARE = 0.9F;
    /**
     * The rate she starts to settle at, in blocks per tick. Deliberately close
     * to nothing: the first seconds are the ship taking water, not the ship
     * dropping, and the whole animation reads wrong if she moves off at once.
     */
    private static final float START_SINK_SPEED = 0.003F;

    private static final SinkingAnimation[] VALUES = values();

    /** how long she takes to go under, in ticks */
    private final int durationTicks;
    /** the rate she is going down at by the end, in blocks per tick */
    private final float maxSinkSpeed;

    SinkingAnimation(int durationTicks, float maxSinkSpeed) {
        this.durationTicks = durationTicks;
        this.maxSinkSpeed = maxSinkSpeed;
    }

    public int getDurationTicks() {
        return this.durationTicks;
    }

    /**
     * @return how far the animation has run, 0 to 1. Everything else in this
     * class is a function of this one number, so a client that knows the tick
     * count and the type knows the whole attitude of the ship.
     */
    public float getProgress(int ticks, float partialTicks) {
        return this.getProgress(ticks + partialTicks);
    }

    /**
     * The same thing off a clock that is already smooth. The client runs one of
     * those rather than reading the synched tick count straight, see
     * Ship#getSinkingProgress - a counter that arrives over the network does not
     * arrive once per frame, and an angle taken from it steps instead of turning.
     */
    public float getProgress(float ticks) {
        return Mth.clamp(ticks / this.durationTicks, 0.0F, 1.0F);
    }

    /** blocks per tick she drops at this point of the animation */
    public float getSinkSpeed(float progress) {
        return Mth.lerp(easeIn(progress), START_SINK_SPEED, this.maxSinkSpeed);
    }

    /* ---------------- angles, capped ---------------- */

    public final float getPitch(float progress) {
        return Mth.clamp(this.pitch(progress), -MAX_PITCH, MAX_PITCH);
    }

    public final float getRoll(float progress) {
        return Mth.clamp(this.roll(progress), -MAX_ROLL, MAX_ROLL);
    }

    public final float getYaw(float progress) {
        return Mth.clamp(this.yaw(progress), -MAX_YAW, MAX_YAW);
    }

    protected float pitch(float progress) {
        return 0.0F;
    }

    protected float roll(float progress) {
        return 0.0F;
    }

    protected float yaw(float progress) {
        return 0.0F;
    }

    /* ---------------- curves ---------------- */

    /** slow at first, then it runs away with her */
    protected static float easeIn(float progress) {
        return progress * progress;
    }

    /** soft at both ends, so nothing snaps into place */
    protected static float smoothStep(float progress) {
        return progress * progress * (3.0F - 2.0F * progress);
    }

    /* ---------------- sync ---------------- */

    public byte getId() {
        return (byte) this.ordinal();
    }

    /**
     * @return the animation this id stands for. An id that means nothing - an
     * old save, an addon that wrote its own - falls back to going down by the
     * head rather than throwing: a wrong looking wreck beats a crash.
     */
    public static SinkingAnimation byId(byte id) {
        return id >= 0 && id < VALUES.length ? VALUES[id] : BOW_FIRST;
    }

    public static SinkingAnimation pick(RandomSource random) {
        return VALUES[random.nextInt(VALUES.length)];
    }
}