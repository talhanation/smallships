package com.talhanation.smallships.world.entity.ship.sail;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * Central handler for the sail damage system.
 *
 * Sails have a single health pool of {@link #MAX_HEALTH} (100) points per ship,
 * stored in the ship's synched entity data ({@link Ship#SAIL_HEALTH}).
 *
 * - The masts are the sails' hit box: a shot through the rigging damages the
 *   sails and leaves the timbers alone, a shot into the hull does the reverse.
 *   How much of a shot lands where is CannonBallItem.Type#sailFactor.
 * - At or below {@link #TORN_THRESHOLD} the sail is rendered with the torn texture.
 * - At 0 the sail is not rendered at all.
 * - Speed: above 50 HP no debuff, at 50 HP or below the sail output is reduced
 *   by 25%, at 0 HP the sail contributes nothing.
 * - Repaired by hand with 6x wool (any color), or completely at the dockyard.
 */
public final class SailDamage {
    public static final float MAX_HEALTH = 100.0F;
    /** at or below half the pool the canvas is rendered torn */
    public static final float TORN_THRESHOLD = 50.0F;

    private SailDamage() {}

    public enum State {
        INTACT,
        TORN,
        DESTROYED
    }

    /* ---------------- health access ---------------- */

    public static float getHealth(Ship ship) {
        return ship.getData(Ship.SAIL_HEALTH);
    }

    public static void setHealth(Ship ship, float health) {
        ship.setData(Ship.SAIL_HEALTH, Mth.clamp(health, 0.0F, MAX_HEALTH));
    }

    public static State getState(Ship ship) {
        float health = getHealth(ship);
        if (health <= 0.0F) return State.DESTROYED;
        if (health <= TORN_THRESHOLD) return State.TORN;
        return State.INTACT;
    }

    /* ---------------- damage ---------------- */

    /**
     * Applies damage to the sails. Must be called server side.
     *
     * The caller decides how much arrives here - since the masts became the
     * sails' own hit box, this is no longer a percentage bled off a hull hit but
     * the damage of a shot that actually went through the rigging.
     */
    /**
     * @return true if a hit on the rigging should land on the canvas rather
     * than on the timbers. Shredded sails cannot absorb anything any more, so
     * from then on a mast hit goes to the hull like every other hit does.
     */
    public static boolean canTakeDamage(Ship ship) {
        return ship instanceof Sailable
                && SmallShipsConfig.Common.sailDamageEnable.get()
                && getHealth(ship) > 0.0F;
    }

    public static void applyCannonHit(Ship ship, float sailDamage) {
        if (!(ship instanceof Sailable)) return;
        if (!SmallShipsConfig.Common.sailDamageEnable.get()) return;
        if (ship.level().isClientSide()) return;
        if (sailDamage <= 0.0F) return;

        float before = getHealth(ship);
        float after = Math.max(0.0F, before - sailDamage);
        setHealth(ship, after);

        if (after <= 0.0F && before > 0.0F) {
            ship.level().playSound(null, ship.getX(), ship.getY() + 4, ship.getZ(), SoundEvents.WOOL_BREAK, SoundSource.NEUTRAL, 3.0F, 0.6F);
        } else if (after <= TORN_THRESHOLD && before > TORN_THRESHOLD) {
            ship.level().playSound(null, ship.getX(), ship.getY() + 4, ship.getZ(), SoundEvents.WOOL_HIT, SoundSource.NEUTRAL, 3.0F, 0.7F);
        }
    }

    /* ---------------- speed ---------------- */

    /**
     * @return the factor the sail speed output has to be multiplied with:
     * 1.0 above 50 HP, 0.75 at 50 HP or below, 0.0 at 0 HP.
     */
    public static float getSpeedFactor(Ship ship) {
        if (!SmallShipsConfig.Common.sailDamageEnable.get()) return 1.0F;
        return switch (getState(ship)) {
            case INTACT -> 1.0F;
            case TORN -> 0.75F;
            case DESTROYED -> 0.0F;
        };
    }

    /* ---------------- repair ---------------- */

    /**
     * Hand repair: right click the ship with at least 6x wool.
     * Consumes the wool and fully repairs the sails.
     */
    public static boolean interactRepair(Ship ship, Player player, InteractionHand interactionHand) {
        if (!(ship instanceof Sailable)) return false;
        if (getHealth(ship) >= MAX_HEALTH) return false;

        ItemStack item = player.getItemInHand(interactionHand);
        int cost = SmallShipsConfig.Common.sailRepairWoolAmount.get();
        if (!item.is(ItemTags.WOOL) || item.getCount() < cost) return false;

        if (!player.isCreative()) item.shrink(cost);
        repair(ship);
        ship.level().playSound(player, ship.getX(), ship.getY() + 4, ship.getZ(), SoundEvents.WOOL_PLACE, ship.getSoundSource(), 10.0F, 1.0F);
        return true;
    }

    /** Full repair, e.g. from the dockyard. */
    public static void repair(Ship ship) {
        setHealth(ship, MAX_HEALTH);
    }

    /* ---------------- save data ---------------- */

    public static void addSaveData(Ship ship, CompoundTag tag) {
        tag.putFloat("SailHealth", getHealth(ship));
    }

    public static void readSaveData(Ship ship, CompoundTag tag) {
        if (tag.contains("SailHealth")) setHealth(ship, tag.getFloat("SailHealth"));
        else setHealth(ship, MAX_HEALTH);
    }
}