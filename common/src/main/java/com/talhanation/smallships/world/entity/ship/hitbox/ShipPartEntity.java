package com.talhanation.smallships.world.entity.ship.hitbox;

import com.talhanation.smallships.world.entity.ModEntityTypes;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * One collision and hit body of a ship, as a standalone entity.
 *
 * Everything that asks a ship for its shape - a player walking into the hull,
 * an arrow flying at a mast, someone trying to place a block where the ship
 * lies - goes through vanilla paths that read a single bounding box off a
 * single entity. A ship has one box and it is far too small, so the parts are
 * that shape instead.
 *
 * A part is a plain box: vanilla entity dimensions are {@code width x height}
 * with a SQUARE footprint, and there is no way around that. The length of a
 * ship is therefore never one long part but several short ones along the keel.
 *
 * Position is never sent over the network. The part only carries the entity id
 * of its ship plus its own local offset, and both sides recompute the world
 * position every tick from the ships' position and yaw - the same math the
 * seats and the cannons use. That costs no bandwidth and cannot desync.
 *
 * The other direction - the ship colliding with the world - cannot use the part
 * entities at all: a part is placed with setPos and has no way to report back.
 * That is what the static collide methods at the bottom are for. They work on
 * the DEFINITIONS, so they can answer for a position and a yaw the ship has not
 * reached yet, which is exactly what sweeping a movement and gating a turn need.
 */
public class ShipPartEntity extends Entity {

    /**
     * A part as a ship declares it, in the same local (v, h) frame the seats
     * use: v runs along the keel and is positive towards the bow, h runs
     * sideways.
     *
     * @param v      offset along the keel
     * @param y      BOTTOM of the box above the entity position - an entity box
     *               grows upwards from its position, it is not centered on it
     * @param h      offset sideways
     * @param width  edge length of the square footprint
     * @param height height of the box
     * @param mast   true for masts, so the two can be told apart later without
     *               keeping a second list around
     */
    public record Definition(float v, float y, float h, float width, float height, boolean mast) {

        /**
         * @param y the keel, as a NEGATIVE offset: the draft below the waterline
         */
        public static Definition hull(float v, float y, float h, float width, float height) {
            return new Definition(v, y, h, width, height, false);
        }

        /**
         * A mast, or any other tall obstacle on the deck. It stands on the
         * waterline and reaches straight up.
         *
         * @param thickness edge length of the square footprint
         */
        public static Definition mast(float v, float h, float thickness, float height) {
            return new Definition(v, 0.0F, h, thickness, height, true);
        }

        /**
         * @return the world box of this part for a ship standing at the given
         * position and yaw - not necessarily the one it is at right now. This is
         * byte for byte the box the part entity itself gets, so the collision
         * can never disagree with what the player sees and walks on.
         */
        /**
         * @return this part cut into pieces no taller than {@link #MAX_HEIGHT}.
         * Only used when the entities are created - the collision math below
         * happily works with one twelve block box and is faster for it.
         */
        public List<Definition> split() {
            if (this.height <= MAX_HEIGHT) return List.of(this);

            int count = Mth.ceil(this.height / MAX_HEIGHT);
            float piece = this.height / count;
            List<Definition> pieces = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                pieces.add(new Definition(this.v, this.y + piece * i, this.h, this.width, piece, this.mast));
            }
            return pieces;
        }

        public AABB boxAt(double shipX, double shipY, double shipZ, float yaw) {
            float angle = -yaw * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F);
            return this.boxAt(shipX, shipY, shipZ, Mth.sin(angle), Mth.cos(angle));
        }

        /**
         * Same thing with the turn already worked out. boxesAt runs up to seven
         * times per tick, so the sine and cosine are computed once for the whole
         * ship instead of once per part - and the rotation is done inline, which
         * saves a Vec3 per part on every single one of those passes.
         */
        public AABB boxAt(double shipX, double shipY, double shipZ, float sin, float cos) {
            double x = shipX + this.v * cos + this.h * sin;
            double y = shipY + this.y;
            double z = shipZ + this.h * cos - this.v * sin;
            double half = this.width / 2.0D;
            return new AABB(x - half, y, z - half, x + half, y + this.height, z + half);
        }
    }

    public static final String ID = "ship_part";

    /**
     * Tallest a single part may be.
     *
     * An entity lives in exactly ONE entity section, the one its position falls
     * into, and EntitySectionStorage#forEachAccessibleNonEmptySection widens a
     * query by four blocks DOWNWARDS and none upwards. Anything taller than that
     * is simply not found by a player standing near its upper end - the box is
     * there, the lookup never reaches it. Vanilla has no entity above four
     * blocks apart from the dragon, which is built from small parts for exactly
     * this reason.
     */
    public static final float MAX_HEIGHT = 4.0F;

    private static final EntityDataAccessor<Integer> PARENT_ID = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> LOCAL_V = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> LOCAL_Y = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> LOCAL_H = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PART_WIDTH = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> PART_HEIGHT = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Boolean> MAST = SynchedEntityData.defineId(ShipPartEntity.class, EntityDataSerializers.BOOLEAN);

    /** below this the ship counts as lying still and the deck turns solid */
    private static final float STILL_SPEED = 0.01F;
    /** the same for turning, in degrees per tick */
    private static final float STILL_ROT_SPEED = 0.05F;
    /** binary search steps of a blocked turn, 4 -> 1/16 of the turn rate */
    private static final int TURN_STEPS = 4;
    /** touching is not overlapping, boxes are shrunk by this for the turn test */
    private static final double EPSILON = 1.0E-5D;

    public ShipPartEntity(EntityType<? extends ShipPartEntity> entityType, Level level) {
        super(entityType, level);
        // a part is carried by its ship, it never moves on its own
        this.noPhysics = true;
        // no blocks where the ship is, hull and masts alike
        this.blocksBuilding = true;
    }

    public static ShipPartEntity factory(EntityType<? extends ShipPartEntity> entityType, Level level) {
        return new ShipPartEntity(entityType, level);
    }

    public ShipPartEntity(Ship ship, Definition definition) {
        this(ModEntityTypes.SHIP_PART, ship.level());
        this.entityData.set(PARENT_ID, ship.getId());
        this.entityData.set(LOCAL_V, definition.v());
        this.entityData.set(LOCAL_Y, definition.y());
        this.entityData.set(LOCAL_H, definition.h());
        this.entityData.set(PART_WIDTH, definition.width());
        this.entityData.set(PART_HEIGHT, definition.height());
        this.entityData.set(MAST, definition.mast());
        this.refreshDimensions();
        this.follow(ship);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        builder.define(PARENT_ID, -1);
        builder.define(LOCAL_V, 0.0F);
        builder.define(LOCAL_Y, 0.0F);
        builder.define(LOCAL_H, 0.0F);
        builder.define(PART_WIDTH, 1.0F);
        builder.define(PART_HEIGHT, 1.0F);
        builder.define(MAST, false);
    }

    @Override
    public void tick() {
        Ship ship = this.getParent();
        if (ship == null || ship.isRemoved()) {
            // orphan guard: a part without its ship is invisible, solid and
            // immortal, the worst thing this class could leave behind. Only the
            // server decides - on the client the ship may simply not have
            // arrived yet.
            if (!this.level().isClientSide()) this.discard();
            return;
        }
        this.follow(ship);
    }

    /** Places this part at its local offset, turned with the ships' yaw. */
    private void follow(Ship ship) {
        Vec3 local = new Vec3(this.entityData.get(LOCAL_V), this.entityData.get(LOCAL_Y), this.entityData.get(LOCAL_H))
                .yRot(-ship.getYRot() * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F));
        this.setPos(ship.getX() + local.x, ship.getY() + local.y, ship.getZ() + local.z);
        this.setYRot(ship.getYRot());
    }

    @Nullable
    public Ship getParent() {
        int id = this.entityData.get(PARENT_ID);
        return id != -1 && this.level().getEntity(id) instanceof Ship ship ? ship : null;
    }

    public boolean isMast() {
        return this.entityData.get(MAST);
    }

    /**
     * @return the ship behind a part, or the entity itself. Anything that reacts
     * to being hit has to go through this, otherwise damage lands on a box
     * instead of on the ship.
     */
    public static Entity resolve(Entity entity) {
        if (entity instanceof ShipPartEntity part) {
            Ship ship = part.getParent();
            if (ship != null) return ship;
        }
        return entity;
    }

    /* ---------------- size ---------------- */

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pose) {
        return EntityDimensions.fixed(this.entityData.get(PART_WIDTH), this.entityData.get(PART_HEIGHT));
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> accessor) {
        // the size lives in the synched data, so the client only learns it with
        // the spawn packet - without this the box stays at the registered default
        if (PART_WIDTH.equals(accessor) || PART_HEIGHT.equals(accessor)) this.refreshDimensions();
        super.onSyncedDataUpdated(accessor);
    }

    /* ---------------- collision ---------------- */

    /**
     * Solid only while the ship lies still. Platform carry does not exist yet,
     * so a moving hull would sweep straight through anyone standing on it and
     * leave them stuck inside a solid box with no way out.
     *
     * This gate is for OTHER entities walking into the ship. The ships' own
     * movement below deliberately ignores it, because two ships have to ram each
     * other at speed, not glide through.
     */
    @Override
    public boolean canBeCollidedWith() {
        Ship ship = this.getParent();
        return ship != null
                && Math.abs(ship.getSpeed()) < STILL_SPEED
                && Math.abs(ship.getRotSpeed()) < STILL_ROT_SPEED;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    /**
     * Always pickable, unlike {@link #canBeCollidedWith()}: a broadside has to
     * connect at full speed, and the whole point of the masts is that they can
     * be shot at.
     */
    @Override
    public boolean isPickable() {
        return true;
    }

    /* ---------------- forwarding ---------------- */

    @Override
    public boolean hurt(@NotNull DamageSource damageSource, float amount) {
        Ship ship = this.getParent();
        return ship != null && ship.hurt(damageSource, amount);
    }

    @Override
    public @NotNull InteractionResult interactAt(@NotNull Player player, @NotNull Vec3 hitVec, @NotNull InteractionHand interactionHand) {
        Ship ship = this.getParent();
        if (ship == null) return InteractionResult.PASS;
        // hand the hit on in the SHIPS frame, so the seat system still gets the
        // exact click point it needs to pick the nearest free seat
        return ship.interactAt(player, this.position().add(hitVec).subtract(ship.position()), interactionHand);
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand interactionHand) {
        Ship ship = this.getParent();
        return ship == null ? InteractionResult.PASS : ship.interact(player, interactionHand);
    }

    /* ---------------- lifecycle ---------------- */

    /**
     * Parts are pure geometry and are rebuilt by their ship on every load.
     * Saving them would only produce orphans, because the parent link is an
     * entity id that does not survive a restart.
     */
    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    /* ---------------- the ship against the world ---------------- */

    /**
     * Clamps a ships' movement so that no part ends up inside the world.
     *
     * Because every part box is axis aligned, this needs no geometry of its own:
     * it is vanillas' own {@link Shapes#collide} run once per part, each pass
     * handing the already shortened movement to the next. The axes are done in
     * order of size, exactly the way vanilla orders its own clamping, so a hull
     * glides along a quay instead of sticking to it.
     *
     * @return the movement that is actually allowed, y untouched
     */
    public static Vec3 collide(Ship ship, Vec3 delta) {
        List<Definition> definitions = ship.getParts();
        if (definitions.isEmpty() || (delta.x == 0.0D && delta.z == 0.0D)) return delta;

        List<AABB> boxes = boxesAt(definitions, ship.position(), ship.getYRot());
        List<VoxelShape> blockers = ship.getBlockers(envelope(boxes).expandTowards(delta.x, 0.0D, delta.z).inflate(1.0D));
        if (blockers.isEmpty()) return delta;

        double x = delta.x;
        double z = delta.z;
        if (Math.abs(x) >= Math.abs(z)) {
            x = clamp(boxes, blockers, Direction.Axis.X, x);
            z = clamp(moved(boxes, x, 0.0D), blockers, Direction.Axis.Z, z);
        } else {
            z = clamp(boxes, blockers, Direction.Axis.Z, z);
            x = clamp(moved(boxes, 0.0D, z), blockers, Direction.Axis.X, x);
        }
        return new Vec3(x, delta.y, z);
    }

    /**
     * Gates a turn. Vanilla never tests a rotation against anything, for no
     * entity in the game - setYRot writes the field and that is it. A hull would
     * swing its bow straight through a cliff without this.
     *
     * A ship that is ALREADY stuck - after a world edit, after a bad spawn - is
     * let through on purpose. Testing for "touches something" instead of
     * "touches something it did not touch before" would lock such a ship in
     * place forever with no way out for the player.
     *
     * @return the yaw the ship is allowed to reach this tick
     */
    public static float collideTurn(Ship ship, float from, float to) {
        List<Definition> definitions = ship.getParts();
        if (definitions.isEmpty() || from == to) return to;

        Vec3 position = ship.position();
        List<AABB> before = boxesAt(definitions, position, from);
        List<AABB> after = boxesAt(definitions, position, to);
        List<VoxelShape> blockers = ship.getBlockers(envelope(before).minmax(envelope(after)).inflate(0.5D));
        if (blockers.isEmpty() || !overlaps(after, blockers)) return to;
        if (overlaps(before, blockers)) return to;

        // turn as far as it goes instead of stopping dead, so a hull settles
        // against an obstacle rather than snapping back from it
        float free = from;
        float blocked = to;
        for (int i = 0; i < TURN_STEPS; i++) {
            float middle = (free + blocked) / 2.0F;
            if (overlaps(boxesAt(definitions, position, middle), blockers)) blocked = middle;
            else free = middle;
        }
        return free;
    }

    private static List<AABB> boxesAt(List<Definition> definitions, Vec3 position, float yaw) {
        float angle = -yaw * (float) (Math.PI / 180.0) - (float) (Math.PI / 2.0F);
        float sin = Mth.sin(angle);
        float cos = Mth.cos(angle);
        List<AABB> boxes = new ArrayList<>(definitions.size());
        for (Definition definition : definitions) {
            boxes.add(definition.boxAt(position.x, position.y, position.z, sin, cos));
        }
        return boxes;
    }

    private static List<AABB> moved(List<AABB> boxes, double dx, double dz) {
        if (dx == 0.0D && dz == 0.0D) return boxes;
        List<AABB> result = new ArrayList<>(boxes.size());
        for (AABB box : boxes) {
            result.add(box.move(dx, 0.0D, dz));
        }
        return result;
    }

    private static AABB envelope(List<AABB> boxes) {
        AABB envelope = boxes.get(0);
        for (int i = 1; i < boxes.size(); i++) {
            envelope = envelope.minmax(boxes.get(i));
        }
        return envelope;
    }

    private static double clamp(List<AABB> boxes, List<VoxelShape> blockers, Direction.Axis axis, double delta) {
        for (AABB box : boxes) {
            delta = Shapes.collide(axis, box, blockers, delta);
            if (delta == 0.0D) break;
        }
        return delta;
    }

    private static boolean overlaps(List<AABB> boxes, List<VoxelShape> blockers) {
        for (AABB box : boxes) {
            AABB shrunk = box.deflate(EPSILON);
            VoxelShape shape = null;
            for (VoxelShape blocker : blockers) {
                // the outer bounds reject almost everything, and they cost a
                // handful of comparisons instead of a shape join
                if (!blocker.bounds().intersects(shrunk)) continue;
                if (shape == null) shape = Shapes.create(shrunk);
                if (Shapes.joinIsNotEmpty(blocker, shape, BooleanOp.AND)) return true;
            }
        }
        return false;
    }

    /**
     * Everything solid in the search area. Living entities are NOT in here on
     * purpose: they are dealt with by the knockback in Ship#updateCollision, and
     * a chicken has no business stopping a brigg.
     *
     * Never call this directly - Ship#getBlockers caches the result for the tick,
     * because the turn gate and the movement sweep both want almost the same area
     * and scanning the world twice was the most expensive thing here.
     */
    public static List<VoxelShape> scanBlockers(Ship ship, AABB area) {
        List<VoxelShape> blockers = new ArrayList<>();
        for (VoxelShape shape : ship.level().getBlockCollisions(ship, area)) {
            blockers.add(shape);
        }
        for (Entity entity : ship.level().getEntities(ship, area, entity -> isHull(ship, entity))) {
            blockers.add(Shapes.create(entity.getBoundingBox()));
        }
        return blockers;
    }

    /** @return every definition cut down to a height vanilla can actually find. */
    public static List<Definition> split(List<Definition> definitions) {
        List<Definition> pieces = new ArrayList<>(definitions.size());
        for (Definition definition : definitions) {
            pieces.addAll(definition.split());
        }
        return pieces;
    }

    /**
     * @return the first foreign ship this hull would run into with the given
     * movement, or null. Used for the ram impulse, which needs the ship itself
     * and not just a shape - collectBlockers throws that identity away.
     */
    @Nullable
    public static Ship findRammedShip(Ship ship, Vec3 delta) {
        List<Definition> definitions = ship.getParts();
        if (definitions.isEmpty()) return null;

        Vec3 target = ship.position().add(delta.x, 0.0D, delta.z);
        List<AABB> boxes = boxesAt(definitions, target, ship.getYRot());
        for (Entity entity : ship.level().getEntities(ship, envelope(boxes), other -> isForeignPart(ship, other))) {
            for (AABB box : boxes) {
                if (box.intersects(entity.getBoundingBox())) return ((ShipPartEntity) entity).getParent();
            }
        }
        return null;
    }

    private static boolean isForeignPart(Ship ship, Entity entity) {
        return entity instanceof ShipPartEntity part && part.getParent() != null && part.getParent() != ship;
    }

    /** @return true for the hull of ANOTHER ship, never for the own parts. */
    private static boolean isHull(Ship ship, Entity entity) {
        if (entity instanceof ShipPartEntity part) return part.getParent() != ship;
        return entity instanceof Boat && entity != ship;
    }
}