package com.talhanation.smallships.world.entity.ship.hitbox;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Walks NPCs off a deck onto nearby land.
 *
 * The deck is solid for anything that COLLIDES - that is the part entities -
 * but a pathfinder never sees them. WalkNodeEvaluator only reads blocks, and
 * under a deck there is air and water. Every target on the deck is rejected as
 * "air above water", every node on land sits below the deck and is never
 * reached, and onGround is true the whole time. The mob just stands there.
 *
 * A mob that stands on the parts for a while is therefore steered to a landing
 * spot in a straight line with its MoveControl, which does not care about
 * nodes at all, and jumped towards it if walking gets nowhere. Once it has
 * left the deck, vanilla navigation takes over again.
 *
 * The landing spot belongs to the SHIP, not to the mob:
 *
 * - It is searched only when the first mob actually has to get off, by
 *   looking out from the hull in the eight directions of the ship - bow,
 *   stern, both sides and the four quarters in between - a few blocks each.
 * - Whatever is found is kept and every other mob that gets off afterwards
 *   walks to the same spot.
 * - It is thrown away as soon as the ship sails off or turns by more than
 *   {@link #RESET_YAW} degrees; the next mob that has to get off searches
 *   again.
 *
 * No land in reach means nothing happens: out at sea the mob stays on the
 * deck. Nothing runs at all while the ship is under way.
 *
 * Players are never touched, they walk on the deck just fine.
 */
public class DeckEscape {
    /** below this the ship counts as lying still, same value as the parts use */
    private static final float STILL_SPEED = 0.01F;
    /** the same for turning, in degrees per tick */
    private static final float STILL_ROT_SPEED = 0.05F;
    /** ticks between two looks for new mobs on the deck */
    private static final int SCAN_INTERVAL = 10;
    /** ticks a mob may stand on the deck before it is sent ashore */
    private static final int ESCAPE_DELAY = 40;
    /** ticks of walking without leaving the deck, then it jumps towards the land */
    private static final int PUSH_AFTER = 60;
    /** ticks between two looks of a mob at the landing spot, picks up resets */
    private static final int RETARGET_INTERVAL = 20;
    /** blocks past the hull side each direction is searched */
    private static final int SEARCH_DISTANCE = 6;
    /** blocks above the waterline ground may lie */
    private static final int SEARCH_ABOVE_WATERLINE = 4;
    /** free blocks needed above the ground */
    private static final int CLEARANCE = 2;
    /** drift in blocks after which the landing spot is reset */
    private static final double RESET_DISTANCE = 1.5D;
    /** turn in degrees after which the landing spot is reset */
    private static final float RESET_YAW = 25.0F;
    /**
     * Ticks after which a search that found NOTHING may run again while the
     * ship lies still - somebody may have built a jetty in the meantime. A
     * found spot stays until the ship moves.
     */
    private static final int EMPTY_REFRESH = 100;
    /** horizontal speed of the jump ashore */
    private static final double PUSH_SPEED = 0.4D;
    /** vertical speed of the jump ashore, a normal jump */
    private static final double PUSH_JUMP = 0.42D;
    /** ticks a mob may be off the parts before it is let go again */
    private static final int OFF_DECK_GRACE = 10;
    /** feet within this of the top of a part count as standing on it */
    private static final double FEET_TOLERANCE = 0.2D;
    /** the eight search directions in the ships' (v, h) frame, bow first */
    private static final float[][] DIRECTIONS = {
            {1.0F, 0.0F}, {-1.0F, 0.0F}, {0.0F, 1.0F}, {0.0F, -1.0F},
            {0.7071F, 0.7071F}, {0.7071F, -0.7071F}, {-0.7071F, 0.7071F}, {-0.7071F, -0.7071F}
    };

    private final Ship ship;
    /** server side, by entity id: never saved, a restart simply scans again */
    private final Map<Integer, Stranded> stranded = new HashMap<>();

    /** the shared landing spot, null = none found or not searched yet */
    @Nullable
    private Vec3 landSpot;
    /** whether landSpot holds a search result at all */
    private boolean landSearched;
    /** where, when and how the ship lay at that search */
    private int landTick;
    private double landX;
    private double landZ;
    private float landYaw;
    /** half the hull length and beam, read off the part definitions once */
    private float halfLength = -1.0F;
    private float halfBeam;

    private static final class Stranded {
        private int ticksOnDeck;
        private int escapeTicks;
        private int walkTicks;
        private int offDeckTicks;
        @Nullable
        private Vec3 target;
    }

    public DeckEscape(Ship ship) {
        this.ship = ship;
    }

    /**
     * Server side, once per ship tick.
     *
     * @param parts the live part entities of the ship
     */
    public void tick(List<ShipPartEntity> parts) {
        if (parts.isEmpty()) {
            this.stranded.clear();
            return;
        }
        this.checkLandSpot();
        if (!this.isStill()) {
            // under way: nobody gets off, and whoever was waiting starts over
            // once she lies still again
            this.stranded.clear();
            return;
        }
        if (this.ship.tickCount % SCAN_INTERVAL == 0) this.scan(parts);
        if (this.stranded.isEmpty()) return;

        Iterator<Map.Entry<Integer, Stranded>> iterator = this.stranded.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Stranded> entry = iterator.next();
            Entity entity = this.ship.level().getEntity(entry.getKey());
            if (!(entity instanceof Mob mob) || mob.isRemoved()) {
                iterator.remove();
                continue;
            }

            Stranded stranded = entry.getValue();
            if (!this.releaseCheck(mob, stranded, parts)) {
                iterator.remove();
                continue;
            }
            if (stranded.ticksOnDeck < ESCAPE_DELAY) {
                stranded.ticksOnDeck++;
                continue;
            }

            this.steer(mob, stranded);
        }
    }

    private boolean isStill() {
        return Math.abs(this.ship.getSpeed()) < STILL_SPEED && Math.abs(this.ship.getRotSpeed()) < STILL_ROT_SPEED;
    }

    private void scan(List<ShipPartEntity> parts) {
        AABB area = parts.get(0).getBoundingBox();
        for (int i = 1; i < parts.size(); i++) {
            area = area.minmax(parts.get(i).getBoundingBox());
        }
        area = area.inflate(0.5D, 0.0D, 0.5D).expandTowards(0.0D, 2.5D, 0.0D);

        for (Mob mob : this.ship.level().getEntitiesOfClass(Mob.class, area, candidate -> canEscape(candidate) && !this.stranded.containsKey(candidate.getId()) && isOnDeck(candidate, parts))) {
            this.stranded.put(mob.getId(), new Stranded());
        }
    }

    private static boolean canEscape(Mob mob) {
        // no AI means no MoveControl that would ever run, and a leashed mob
        // was put there on purpose by whoever holds the lead
        return !mob.isNoAi() && !mob.isLeashed() && !mob.isPassenger();
    }

    /**
     * @return false once the mob is off our hands: standing in the water or on
     * real ground, riding something, or off the parts for {@link #OFF_DECK_GRACE}
     * ticks. A single tick without ground is NOT enough - onGround flickers at
     * the edge of the deck and while other mobs push it around, and letting go
     * there would hand it back to its own look goals for a moment, which is
     * what makes it spin on the spot
     */
    private boolean releaseCheck(Mob mob, Stranded stranded, List<ShipPartEntity> parts) {
        if (isOnDeck(mob, parts)) {
            stranded.offDeckTicks = 0;
            return true;
        }
        // in the water or on solid blocks it can path on its own again
        if (mob.isInWater() || mob.onGround() || mob.isPassenger()) return false;
        return ++stranded.offDeckTicks < OFF_DECK_GRACE;
    }

    /**
     * Walks the mob towards the landing spot and jumps it over if walking does
     * not get it off the deck in time. Without a spot it is left standing.
     */
    private void steer(Mob mob, Stranded stranded) {
        if (stranded.escapeTicks % RETARGET_INTERVAL == 0) {
            stranded.target = this.getLandSpot();
        }
        stranded.escapeTicks++;

        Vec3 target = stranded.target;
        // nothing to walk to: leave the mob alone entirely, it may still have
        // a way off the deck of its own, over a jetty for example
        if (target == null) {
            stranded.walkTicks = 0;
            return;
        }

        // the navigation would build a path to the water nodes under the hull,
        // turn the mob that way, time out, and hand it back to us facing the
        // other way - over and over. While we steer, we steer alone
        if (!mob.getNavigation().isDone()) mob.getNavigation().stop();
        // has to be set again every tick: MoveControl#tick uses the wanted
        // position up and falls back to waiting right after
        mob.getMoveControl().setWantedPosition(target.x, target.y, target.z, 1.0D);
        // head and body on the same target, otherwise the look goals pull the
        // head away and the body keeps correcting after it
        mob.getLookControl().setLookAt(target.x, target.y + mob.getEyeHeight(), target.z);
        // a raised quarterdeck or a rail in the way - MoveControl only jumps
        // on its own when the target is ABOVE the mob, never on the way down
        if (mob.horizontalCollision && mob.onGround()) mob.getJumpControl().jump();

        if (++stranded.walkTicks >= PUSH_AFTER) {
            Vec3 towards = new Vec3(target.x - mob.getX(), 0.0D, target.z - mob.getZ());
            if (towards.lengthSqr() > 1.0E-4D) {
                towards = towards.normalize().scale(PUSH_SPEED);
                mob.setDeltaMovement(towards.x, PUSH_JUMP, towards.z);
                mob.hasImpulse = true;
            }
            stranded.walkTicks = 0;
        }
    }

    /**
     * @return true if the mob is standing on top of one of the parts. Only the
     * top face counts: a mob on the quay next to the hull touches its side, and
     * that is exactly where it should stay.
     */
    private static boolean isOnDeck(Mob mob, List<ShipPartEntity> parts) {
        if (!mob.onGround() || mob.isInWater() || mob.isPassenger()) return false;

        AABB feet = mob.getBoundingBox();
        AABB probe = new AABB(feet.minX, feet.minY - FEET_TOLERANCE, feet.minZ, feet.maxX, feet.minY + 0.01D, feet.maxZ);
        for (ShipPartEntity part : parts) {
            AABB box = part.getBoundingBox();
            if (box.maxY <= feet.minY + 0.01D && box.intersects(probe)) return true;
        }
        return false;
    }

    /* ---------------- landing spot ---------------- */

    /**
     * Throws the landing spot away once it no longer fits the ship: sailed
     * off, turned too far, or an empty result that is old enough to look again.
     * Cheap, so it can run every tick.
     */
    private void checkLandSpot() {
        if (!this.landSearched) return;

        boolean drifted = Mth.square(this.ship.getX() - this.landX) + Mth.square(this.ship.getZ() - this.landZ) > RESET_DISTANCE * RESET_DISTANCE;
        boolean turned = Math.abs(Mth.wrapDegrees(this.ship.getYRot() - this.landYaw)) > RESET_YAW;
        boolean expired = this.landSpot == null && this.ship.tickCount - this.landTick >= EMPTY_REFRESH;
        if (drifted || turned || expired) {
            this.landSpot = null;
            this.landSearched = false;
        }
    }

    /** @return the shared landing spot, searched now if there is no result yet */
    @Nullable
    private Vec3 getLandSpot() {
        if (!this.landSearched) {
            this.landSpot = this.searchLandSpot();
            this.landSearched = true;
            this.landTick = this.ship.tickCount;
            this.landX = this.ship.getX();
            this.landZ = this.ship.getZ();
            this.landYaw = this.ship.getYRot();
        }
        return this.landSpot;
    }

    /**
     * Looks out from the hull in every direction of the ship and keeps the spot
     * closest to the ship.
     *
     * @return the top of the ground to walk to, or null
     */
    @Nullable
    private Vec3 searchLandSpot() {
        this.readHullSize();

        float angle = -this.ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F);
        float sin = Mth.sin(angle);
        float cos = Mth.cos(angle);
        int waterline = Mth.floor(this.ship.getY());

        Vec3 best = null;
        double bestDistance = Double.MAX_VALUE;
        for (float[] direction : DIRECTIONS) {
            // start at the hull side in this direction, the hull covers only water
            float start = this.halfLength * Math.abs(direction[0]) + this.halfBeam * Math.abs(direction[1]);
            for (int step = 1; step <= SEARCH_DISTANCE; step++) {
                float distance = start + step;
                float v = direction[0] * distance;
                float h = direction[1] * distance;
                // same turn as Definition#boxAt
                int x = Mth.floor(this.ship.getX() + v * cos + h * sin);
                int z = Mth.floor(this.ship.getZ() + h * cos - v * sin);

                Vec3 spot = this.findGround(x, z, waterline);
                if (spot == null) continue;

                double squared = this.ship.distanceToSqr(spot);
                if (squared < bestDistance) {
                    best = spot;
                    bestDistance = squared;
                }
                // further out in this direction can only be further away
                break;
            }
        }
        return best;
    }

    /**
     * Walks one column down from above the deck to the waterline.
     *
     * @return the top of the first block that is neither air nor water and has
     * {@link #CLEARANCE} air blocks above it, or null
     */
    @Nullable
    private Vec3 findGround(int x, int z, int waterline) {
        Level level = this.ship.level();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int y = waterline + SEARCH_ABOVE_WATERLINE; y >= waterline; y--) {
            pos.set(x, y, z);
            // never load a chunk for this
            if (!level.hasChunkAt(pos)) return null;

            BlockState state = level.getBlockState(pos);
            if (state.isAir()) continue;
            // water, waterlogged blocks included: below that there is only sea floor
            if (!state.getFluidState().isEmpty()) return null;

            // grass, flowers and the like are no ground, look below them
            VoxelShape shape = state.getCollisionShape(level, pos);
            if (shape.isEmpty()) continue;

            for (int i = 1; i <= CLEARANCE; i++) {
                // something on top: a wall or an overhang, nothing to stand on
                if (!level.getBlockState(pos.relative(Direction.UP, i)).isAir()) return null;
            }
            return new Vec3(x + 0.5D, y + Math.min(shape.max(Direction.Axis.Y), 1.0D), z + 0.5D);
        }
        return null;
    }

    private void readHullSize() {
        if (this.halfLength >= 0.0F) return;
        float length = 0.0F;
        float beam = 0.0F;
        for (ShipPartEntity.Definition definition : this.ship.getParts()) {
            // masts never reach past the hull
            if (definition.mast()) continue;
            length = Math.max(length, Math.abs(definition.v()) + definition.width() / 2.0F);
            beam = Math.max(beam, Math.abs(definition.h()) + definition.width() / 2.0F);
        }
        this.halfLength = length;
        this.halfBeam = beam;
    }
}