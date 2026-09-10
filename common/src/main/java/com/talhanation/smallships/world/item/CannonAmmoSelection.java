package com.talhanation.smallships.world.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Which cannonball type a player has picked with the mouse wheel while aiming,
 * and the ammo picking that follows from it.
 *
 * Deliberately a map rather than a field mixed into Player: the selection is a
 * single byte of gameplay preference, and a WeakHashMap keyed on the player
 * entity costs nothing, needs no mixin registration, and cannot fail at runtime
 * the way a duck interface cast does when its mixin was not applied. Entries
 * die with the player entity, so nothing has to clean up after a disconnect.
 *
 * Client and server each keep their own map. The client's is authoritative and
 * pushed over with {@link com.talhanation.smallships.network.packet.ServerboundSetCannonAmmoTypePacket},
 * because the driver's broadside is fired server side off the synched cannon
 * key state, not off a per-shot packet.
 */
public final class CannonAmmoSelection {
    private static final Map<Player, CannonBallItem.Type> SELECTION = Collections.synchronizedMap(new WeakHashMap<>());

    private CannonAmmoSelection() {
    }

    public static void set(Player player, CannonBallItem.Type type) {
        SELECTION.put(player, type);
    }

    /**
     * @param shooter the entity pulling the trigger, may be null or a non-player
     * @return his selected type, BALL if he never picked one or is not a player
     */
    public static CannonBallItem.Type get(@Nullable Entity shooter) {
        if (!(shooter instanceof Player player)) return CannonBallItem.Type.BALL;
        return SELECTION.getOrDefault(player, CannonBallItem.Type.BALL);
    }

    /**
     * Picks the ammo for the next shot out of up to two lockers, searched in
     * the given order (ship container first, driver inventory second; the
     * ground cannon passes only one).
     *
     * BOTH lockers are searched for the preferred type before either is
     * allowed to hand over something else. Doing it locker by locker instead
     * lets a chest full of plain shot shadow the chain shot in the gunner's
     * own pockets, which makes the picker look broken while it is in fact
     * working exactly as told.
     *
     * The fallback itself is the point though: running out of the exact type
     * that was scrolled to should not leave a loaded gun silent, it should
     * load whatever is left.
     *
     * @return the preferred type if either locker has it, otherwise the first
     * cannonball of any type. Null if there is none at all.
     */
    @Nullable
    public static CannonBallItem findPreferred(@Nullable Entity shooter, @Nullable Iterable<ItemStack> primary, @Nullable Iterable<ItemStack> secondary) {
        CannonBallItem.Type preferred = get(shooter);

        CannonBallItem exact = findType(primary, preferred);
        if (exact == null) exact = findType(secondary, preferred);
        if (exact != null) return exact;

        CannonBallItem any = findType(primary, null);
        return any != null ? any : findType(secondary, null);
    }

    /**
     * Shrinks one stack, mirroring {@link #findPreferred} pass for pass so what
     * gets consumed is always what was reported as loaded.
     *
     * @return true if a cannonball was consumed
     */
    public static boolean consumePreferred(@Nullable Entity shooter, @Nullable Iterable<ItemStack> primary, @Nullable Iterable<ItemStack> secondary) {
        CannonBallItem.Type preferred = get(shooter);

        ItemStack exact = findStack(primary, preferred);
        if (exact == null) exact = findStack(secondary, preferred);
        if (exact == null) exact = findStack(primary, null);
        if (exact == null) exact = findStack(secondary, null);

        if (exact == null) return false;
        exact.shrink(1);
        return true;
    }

    /**
     * @param type the type to look for, null matches any cannonball
     * @return the first matching stack, or null
     */
    @Nullable
    private static ItemStack findStack(@Nullable Iterable<ItemStack> stacks, @Nullable CannonBallItem.Type type) {
        if (stacks == null) return null;
        for (ItemStack itemStack : stacks) {
            if (itemStack.getItem() instanceof CannonBallItem cannonBallItem
                    && (type == null || cannonBallItem.getType() == type)) {
                return itemStack;
            }
        }
        return null;
    }

    @Nullable
    private static CannonBallItem findType(@Nullable Iterable<ItemStack> stacks, @Nullable CannonBallItem.Type type) {
        ItemStack itemStack = findStack(stacks, type);
        return itemStack != null ? (CannonBallItem) itemStack.getItem() : null;
    }
}