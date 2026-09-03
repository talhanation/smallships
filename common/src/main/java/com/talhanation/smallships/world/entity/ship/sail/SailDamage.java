package com.talhanation.smallships.world.entity.ship.sail;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import com.talhanation.smallships.world.sound.ModSoundTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Central handler for the sail damage system.
 *
 * Sails have a single health pool, stored in the ship's synched entity data
 * ({@link Ship#SAIL_HEALTH}). It is {@link #HEALTH_PER_SAIL} points PER SAIL -
 * a two masted ship carries twice the canvas, so it takes twice the shooting to
 * bring it down. The pool stays a single number even so: which of the two sails
 * a ball went through is not something a gun crew aims for.
 *
 * - The masts are the sails' hit box: a shot through the rigging damages the
 *   sails and leaves the timbers alone, a shot into the hull does the reverse.
 *   How much of a shot lands where is CannonBallItem.Type#sailFactor.
 * - At or below half the pool the sail is rendered with the torn texture.
 * - At 0 the sail is not rendered at all.
 * - Speed: above 50 HP no debuff, at 50 HP or below the sail output is reduced
 *   by 25%, at 0 HP the sail contributes nothing.
 * - Repaired by hand with 6x wool (any color), or completely at the dockyard.
 */
public final class SailDamage {
    /** health one sail is worth; the pool is this times the sail count */
    public static final float HEALTH_PER_SAIL = 100.0F;
    /** share of the pool at or below which the canvas is rendered torn */
    public static final float TORN_FRACTION = 0.5F;
    /**
     * How far a patch job with needle and thread gets the canvas. Anything
     * beyond that needs new cloth: either the full bolt of wool, or a dockyard.
     */
    public static final float PATCH_LIMIT = 0.33F;

    /**
     * @return the full sail health of this ship: {@link #HEALTH_PER_SAIL} for
     * every sail it carries. Anything that shows or repairs sail health has to
     * ask the SHIP, never a constant - the maximum is not the same for a Cog
     * and a Brigg.
     */
    public static float getMaxHealth(Ship ship) {
        return ship instanceof Sailable sailable ? HEALTH_PER_SAIL * sailable.getSailCount() : HEALTH_PER_SAIL;
    }

    public static float getTornThreshold(Ship ship) {
        return getMaxHealth(ship) * TORN_FRACTION;
    }

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
        ship.setData(Ship.SAIL_HEALTH, Mth.clamp(health, 0.0F, getMaxHealth(ship)));
    }

    public static State getState(Ship ship) {
        float health = getHealth(ship);
        if (health <= 0.0F) return State.DESTROYED;
        if (health <= getTornThreshold(ship)) return State.TORN;
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
                && SmallShipsConfig.Server.sailDamageEnable.get()
                && getHealth(ship) > 0.0F;
    }

    public static void applyCannonHit(Ship ship, float sailDamage) {
        if (!(ship instanceof Sailable)) return;
        if (!SmallShipsConfig.Server.sailDamageEnable.get()) return;
        if (ship.level().isClientSide()) return;
        if (sailDamage <= 0.0F) return;

        float before = getHealth(ship);
        float after = Math.max(0.0F, before - sailDamage);
        setHealth(ship, after);

        if (after <= 0.0F && before > 0.0F) {

            ship.level().playSound(null, ship.getX(), ship.getY() + 4, ship.getZ(),
                    ModSoundTypes.SAIL_HIT, SoundSource.NEUTRAL, 3.0F, 0.9F + ship.level().random.nextFloat() * 0.2F);
        }
        else if (after <= getTornThreshold(ship) && before > getTornThreshold(ship)) {
            ship.level().playSound(null, ship.getX(), ship.getY() + 4, ship.getZ(),
                    ModSoundTypes.SAIL_HIT, SoundSource.NEUTRAL, 3.0F, 0.9F + ship.level().random.nextFloat() * 0.2F);

        }
    }

    /* ---------------- speed ---------------- */

    /**
     * @return the factor the sail speed output has to be multiplied with:
     * 1.0 above half the pool, 0.75 at or below it, 0.0 at 0.
     */
    public static float getSpeedFactor(Ship ship) {
        if (!SmallShipsConfig.Server.sailDamageEnable.get()) return 1.0F;
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
        if (getHealth(ship) >= getMaxHealth(ship)) return false;

        ItemStack item = player.getItemInHand(interactionHand);
        int cost = SmallShipsConfig.Server.sailRepairWoolAmount.get();
        if (!item.is(ItemTags.WOOL) || item.getCount() < cost) return false;

        if (!player.isCreative()) item.shrink(cost);
        repair(ship);
        ship.level().playSound(player, ship.getX(), ship.getY() + 4, ship.getZ(), SoundEvents.WOOL_PLACE, ship.getSoundSource(), 10.0F, 1.0F);
        return true;
    }

    /**
     * Patch repair: right click the ship with a string in hand and an iron
     * nugget somewhere in the inventory - needle and thread. It only ever gets
     * the canvas back to {@link #PATCH_LIMIT}; a sail that is more than a third
     * gone needs new cloth, not another seam.
     */
    public static boolean interactPatch(Ship ship, Player player, InteractionHand interactionHand) {
        if (!(ship instanceof Sailable)) return false;

        float limit = getMaxHealth(ship) * PATCH_LIMIT;
        if (getHealth(ship) >= limit) return false;

        ItemStack item = player.getItemInHand(interactionHand);
        if (!item.is(Items.STRING)) return false;
        if (!player.getInventory().hasAnyMatching(stack -> stack.is(Items.IRON_NUGGET))) return false;

        if (!player.isCreative()) {
            item.shrink(1);
            for (int i = 0; i < player.getInventory().getContainerSize(); ++i) {
                ItemStack stack = player.getInventory().getItem(i);
                if (stack.is(Items.IRON_NUGGET)) {
                    stack.shrink(1);
                    break;
                }
            }
        }

        float repaired = 5.0F + ship.level().random.nextInt(5);
        setHealth(ship, Math.min(limit, getHealth(ship) + repaired));
        ship.level().playSound(player, ship.getX(), ship.getY() + 4, ship.getZ(),
                SoundEvents.WOOL_PLACE, ship.getSoundSource(), 6.0F, 1.2F);
        return true;
    }

    /** Full repair, e.g. from the dockyard. */
    public static void repair(Ship ship) {
        setHealth(ship, getMaxHealth(ship));
    }

    /* ---------------- save data ---------------- */

    public static void addSaveData(Ship ship, CompoundTag tag) {
        tag.putFloat("SailHealth", getHealth(ship));
    }

    public static void readSaveData(Ship ship, CompoundTag tag) {
        if (tag.contains("SailHealth")) setHealth(ship, tag.getFloat("SailHealth"));
        else setHealth(ship, getMaxHealth(ship));
    }
}