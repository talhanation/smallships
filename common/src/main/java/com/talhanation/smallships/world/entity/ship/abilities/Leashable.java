package com.talhanation.smallships.world.entity.ship.abilities;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Towing a ship on a lead.
 *
 * The holder is kept as a SYNCHED ENTITY ID on the ship, not through the
 * vanilla entity link packet: ClientPacketListener#handleEntityLinkPacket only
 * ever forwards that packet to a Mob, so a boat never learned about its own
 * leash on the client - no rope was drawn and isLeashed() answered differently
 * on the two sides. Synched data crosses on its own and needs no mixin at all.
 *
 * The other end is a player, or a fence post he moors her to. LeadItem only
 * ever binds Mobs to a post, so the ships are bound by {@link #bindPlayerShips},
 * which the platforms call from their own right click block event - no mixin
 * for that one either.
 */
public interface Leashable extends Ability {

    /** the lead hangs slack up to here, past it the ship is pulled along */
    double LEASH_PULL_DISTANCE = 6.0D;
    /** past this the lead snaps and drops as an item */
    double LEASH_BREAK_DISTANCE = 10.0D;
    /**
     * How hard the lead pulls, in blocks per tick per squared unit of overhang.
     * One number for every hull on purpose: a lead is a rope, not a tugboat -
     * it should feel like the same rope whatever is on the other end of it.
     */
    double LEASH_PULL_STRENGTH = 0.4D;

    /**
     * @return where the rope is tied on, relative to the ship origin and
     * un-rotated - x is athwartships, z fore and aft. The renderer turns it
     * with the hull.
     */
    @Nullable
    Vec3 applyLeashOffset();

    /* ---------------- state ---------------- */

    default boolean isShipLeashed() {
        return self().getData(Ship.LEASH_HOLDER) != -1;
    }

    /**
     * @return the entity holding the lead, or null. Resolved from the id on
     * every call rather than cached: the holder may leave the tracking range
     * and come back, and a stale reference would keep towing a ghost.
     */
    @Nullable
    default Entity getLeashHolder() {
        int id = self().getData(Ship.LEASH_HOLDER);
        return id == -1 ? null : self().level().getEntity(id);
    }

    default void setLeashedTo(Entity holder) {
        self().leashHolderUuid = holder.getUUID();
        LeashFenceKnotEntity knot = holder instanceof LeashFenceKnotEntity fenceKnot ? fenceKnot : null;
        self().leashKnot = knot;
        self().leashKnotPos = knot != null ? knot.getPos() : null;
        self().setData(Ship.LEASH_HOLDER, holder.getId());
    }

    default void dropLeash(boolean dropItem) {
        if (!this.isShipLeashed()) return;
        self().leashHolderUuid = null;
        self().leashKnot = null;
        self().leashKnotPos = null;
        self().setData(Ship.LEASH_HOLDER, -1);
        if (!self().level().isClientSide() && dropItem) self().spawnAtLocation(Items.LEAD);
    }

    /* ---------------- tick ---------------- */

    /** Server side only - the client just draws whatever the synched id says. */
    default void tickLeashShip() {
        if (self().level().isClientSide()) return;

        // after a world load the holder is only a uuid: its chunk may not be
        // there yet, so the lookup is retried until it is - or given up on
        if (self().leashHolderUuid != null && !this.isShipLeashed()) {
            this.restoreLeashHolder();
            return;
        }

        Entity holder = this.getLeashHolder();
        if (holder == null) {
            this.tickLostKnot();
            return;
        }
        if (!holder.isAlive() || holder.level() != self().level()) {
            this.dropLeash(true);
            return;
        }

        double distance = self().distanceTo(holder);
        if (distance > LEASH_BREAK_DISTANCE) {
            self().level().playSound(null, self().getX(), self().getY(), self().getZ(),
                    SoundEvents.LEASH_KNOT_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);
            this.dropLeash(true);
            return;
        }
        if (distance <= LEASH_PULL_DISTANCE) return;

        // squared per axis, so the pull comes on gently at the end of the slack
        // and hardens the further the rope is stretched
        double dx = (holder.getX() - self().getX()) / distance;
        double dy = (holder.getY() - self().getY()) / distance;
        double dz = (holder.getZ() - self().getZ()) / distance;
        self().setDeltaMovement(self().getDeltaMovement().add(
                Math.copySign(dx * dx * LEASH_PULL_STRENGTH, dx),
                Math.copySign(dy * dy * LEASH_PULL_STRENGTH, dy),
                Math.copySign(dz * dz * LEASH_PULL_STRENGTH, dz)));
    }

    /**
     * The level no longer knows the knot she was moored to. Why it went
     * decides what happens to the lead:
     *
     * - taken off the post by a right click, or the post broken under it: she
     *   is untied, the lead drops
     * - only unloaded with its chunk: the mooring stands. The knot is let go
     *   of here and tied on again by restoreLeashHolder once the post is back,
     *   a knot is never saved and would not come back by itself.
     */
    private void tickLostKnot() {
        LeashFenceKnotEntity knot = self().leashKnot;
        // a player: gone for now, he may come back
        if (knot == null) return;

        Entity.RemovalReason reason = knot.getRemovalReason();
        // still there, only out of the levels' sight for the moment
        if (reason == null) return;
        if (reason.shouldDestroy()) {
            this.dropLeash(true);
            return;
        }
        self().leashKnot = null;
        self().setData(Ship.LEASH_HOLDER, -1);
    }

    private void restoreLeashHolder() {
        // a post first: its knot was not saved, so there is no entity to look
        // up - it is tied on again, the way vanilla does it for a mob
        BlockPos knotPos = self().leashKnotPos;
        if (knotPos != null) {
            // the post is not loaded yet: wait for it, however long that takes
            if (!self().level().isLoaded(knotPos)) return;
            if (self().level().getBlockState(knotPos).is(BlockTags.FENCES)) {
                this.setLeashedTo(LeashFenceKnotEntity.getOrCreateKnot(self().level(), knotPos));
                return;
            }
            // the post itself is gone, there is nothing left to wait for
            self().leashHolderUuid = null;
            self().leashKnotPos = null;
            self().spawnAtLocation(Items.LEAD);
            return;
        }
        if (self().level() instanceof ServerLevel serverLevel) {
            Entity holder = serverLevel.getEntity(self().leashHolderUuid);
            if (holder != null) {
                self().setData(Ship.LEASH_HOLDER, holder.getId());
                return;
            }
        }
        // the holder is gone for good - five seconds is long enough for his
        // chunk to have loaded if he was ever going to come back
        if (self().tickCount > 100) {
            self().leashHolderUuid = null;
            self().spawnAtLocation(Items.LEAD);
        }
    }

    /* ---------------- interaction ---------------- */

    /**
     * Right click with a lead ties the ship to the player; right clicking the
     * ship again while holding the other end unties it.
     */
    default boolean interactLead(Player player, InteractionHand interactionHand) {
        if (this.getLeashHolder() == player) {
            this.dropLeash(!player.getAbilities().instabuild);
            return true;
        }

        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (!itemStack.is(Items.LEAD) || this.isShipLeashed()) return false;

        if (!self().level().isClientSide()) {
            this.setLeashedTo(player);
            if (!player.getAbilities().instabuild) itemStack.shrink(1);
            self().level().playSound(null, self().getX(), self().getY(), self().getZ(),
                    SoundEvents.LEASH_KNOT_PLACE, SoundSource.NEUTRAL, 1.0F, 1.0F);
        }
        return true;
    }

    /**
     * Moors every ship the player holds on a lead to the fence post at the
     * given position - what LeadItem#bindPlayerMobs does for mobs, which never
     * looks at anything but a Mob.
     *
     * Called by the platforms when a block is right clicked, on both sides:
     * the client only answers whether there is something to tie, so the hand
     * swings and the click is sent on, the server does the tying. She is
     * untied the vanilla way, by a right click on the knot.
     *
     * @return true if the click was a mooring and is used up by it
     */
    static boolean bindPlayerShips(Player player, Level level, BlockPos pos) {
        if (player.isSpectator() || !level.getBlockState(pos).is(BlockTags.FENCES)) return false;

        // no further out than the lead reaches, or it would snap in the next tick
        List<Ship> ships = level.getEntitiesOfClass(Ship.class, new AABB(pos).inflate(LEASH_BREAK_DISTANCE),
                ship -> ship instanceof Leashable leashShip && leashShip.getLeashHolder() == player);
        if (ships.isEmpty()) return false;
        if (level.isClientSide()) return true;

        LeashFenceKnotEntity knot = LeashFenceKnotEntity.getOrCreateKnot(level, pos);
        knot.playPlacementSound();
        for (Ship ship : ships) ((Leashable) ship).setLeashedTo(knot);
        // the click ends here, so a mob on a lead in the same hand goes onto
        // the post with her - vanilla would have tied it on this very click
        LeadItem.bindPlayerMobs(player, level, pos);
        return true;
    }

    /* ---------------- save data ---------------- */

    default void readLeashShipSaveData(CompoundTag tag) {
        // only the uuid is written: entity ids are handed out per session and
        // would point at something else entirely after a restart
        if (tag.hasUUID("LeashHolder")) self().leashHolderUuid = tag.getUUID("LeashHolder");
        if (tag.contains("LeashKnot", 10)) self().leashKnotPos = NbtUtils.readBlockPos(tag.getCompound("LeashKnot"));
    }

    default void addLeashShipSaveData(CompoundTag tag) {
        UUID holder = self().leashHolderUuid;
        if (holder != null) tag.putUUID("LeashHolder", holder);
        BlockPos knotPos = self().leashKnotPos;
        if (knotPos != null) tag.put("LeashKnot", NbtUtils.writeBlockPos(knotPos));
    }
}