package com.talhanation.smallships.compat;

import com.talhanation.smallships.compat.epicknights.EpicKnightsCompat;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Every item that may be hung on a ships' hull, and how it is drawn there.
 *
 * The vanilla shield is drawn by the vanilla {@code ShieldModel} the way it
 * always was. Everything a foreign mod brings is drawn through the ITEM
 * renderer instead: that mods' own model, its own texture and a heraldry it
 * already carries all come along for free, and we never touch a class of theirs.
 *
 * There are two ways in: {@link #register} for a single known item, and
 * {@link #addProvider} for a whole family of them. Epic Knights alone ships
 * nine shield shapes in eleven materials, and its addons add more - naming all
 * of them here would mean a release of this mod for every release of theirs.
 *
 * The registry is common, not client only. The dockyard has to answer "may this
 * go on a hull" on the server, and a transform is plain data that costs nothing
 * to carry there.
 */
public final class ShieldRegistry {

    /**
     * How one shield sits on the hull.
     *
     * The frame is the one the anchor points in {@code Shieldable.ShieldPosition}
     * are written in, AFTER the side flip - so an offset means the same thing to
     * port and starboard, and a positive offset pushes a shield outboard on both
     * sides rather than through the deck on one of them.
     *
     * The mirrored scale is not a typo. The whole ship is drawn Y flipped
     * (see the {@code poseStack.scale(-1.3F, -1.3F, 1.3F)} in ShipRenderer), so
     * anything hung on it has to flip back or it stands on its head.
     *
     * @param vanillaShieldModel true = draw with the vanilla ShieldModel and the
     *                           banner pattern layers, false = draw the item
     * @param displayContext     which of the item models' own transforms to use.
     *                           Only read when the item renderer draws it.
     * @param scale              size on the hull, 0.8 is the vanilla shield
     * @param pitch              lean away from the hull in degrees (X)
     * @param yaw                turn around the hull normal in degrees (Y)
     * @param roll               spin in the shields' own plane in degrees (Z)
     */
    public record ShieldEntry(boolean vanillaShieldModel, ItemDisplayContext displayContext, float scale,
                              float offsetX, float offsetY, float offsetZ,
                              float pitch, float yaw, float roll) {

        /** A shield drawn by the vanilla ShieldModel, banner patterns included. */
        public static ShieldEntry vanilla(float scale, float pitch, float yaw, float roll) {
            return new ShieldEntry(true, ItemDisplayContext.NONE, scale, 0.0F, 0.0F, 0.0F, pitch, yaw, roll);
        }

        /** A shield drawn by the item renderer, i.e. by the mod that owns it. */
        public static ShieldEntry item(float scale, float pitch, float yaw, float roll) {
            return new ShieldEntry(false, ItemDisplayContext.FIXED, scale, 0.0F, 0.0F, 0.0F, pitch, yaw, roll);
        }

        public ShieldEntry withOffset(float x, float y, float z) {
            return new ShieldEntry(this.vanillaShieldModel, this.displayContext, this.scale, x, y, z,
                    this.pitch, this.yaw, this.roll);
        }

        public ShieldEntry withDisplayContext(ItemDisplayContext displayContext) {
            return new ShieldEntry(this.vanillaShieldModel, displayContext, this.scale,
                    this.offsetX, this.offsetY, this.offsetZ, this.pitch, this.yaw, this.roll);
        }

        public ShieldEntry withScale(float scale) {
            return new ShieldEntry(this.vanillaShieldModel, this.displayContext, scale,
                    this.offsetX, this.offsetY, this.offsetZ, this.pitch, this.yaw, this.roll);
        }
    }

    /**
     * Answers for items that cannot be named one by one - a compat layer that
     * recognises a whole mods' shields by their common base class.
     */
    public interface Provider {
        /**
         * @param item the item in question
         * @param id   its registry id, handed over so an implementation does not
         *             have to look it up again
         * @return how to draw it, or null if this provider does not know it
         */
        @Nullable
        ShieldEntry entryFor(Item item, ResourceLocation id);
    }

    /** The vanilla shield, exactly as ShipRenderer has always placed it. */
    public static final ShieldEntry VANILLA_SHIELD = ShieldEntry.vanilla(0.8F, 20.0F, 0.0F, 180.0F);

    private static final Map<ResourceLocation, ShieldEntry> SHIELDS = new LinkedHashMap<>();
    private static final List<Provider> PROVIDERS = new ArrayList<>();
    /**
     * Resolving walks a class hierarchy and hits the item registry, and the
     * renderer asks once per shield per frame - so the answer per item is kept.
     * Concurrent because the dockyard asks from the server thread while the
     * renderer asks from the render thread.
     */
    private static final Map<Item, Optional<ShieldEntry>> RESOLVED = new ConcurrentHashMap<>();

    private ShieldRegistry() {
    }

    /**
     * Registers the built in entries and every compat layer. Belongs into the
     * common entry point; it does not read the config, so mod construction is
     * early enough.
     */
    public static void init() {
        register(Items.SHIELD, VANILLA_SHIELD);
        EpicKnightsCompat.register();
    }

    public static synchronized void register(Item item, ShieldEntry entry) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        SHIELDS.put(id, entry);
        RESOLVED.clear();
    }

    /**
     * Registers an item by id rather than by instance, for a mod that may not
     * be installed - a missing id simply never matches anything.
     */
    public static synchronized void register(ResourceLocation id, ShieldEntry entry) {
        SHIELDS.put(id, entry);
        RESOLVED.clear();
    }

    public static synchronized void addProvider(Provider provider) {
        PROVIDERS.add(provider);
        RESOLVED.clear();
    }

    /** @return how to draw this stack on a hull, or null if it does not belong there. */
    @Nullable
    public static ShieldEntry get(ItemStack stack) {
        if (stack.isEmpty()) return null;
        return RESOLVED.computeIfAbsent(stack.getItem(), ShieldRegistry::resolve).orElse(null);
    }

    /** @return true if this stack may be hung on a hull at all. */
    public static boolean isShield(ItemStack stack) {
        return get(stack) != null;
    }

    private static synchronized Optional<ShieldEntry> resolve(Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        ShieldEntry entry = SHIELDS.get(id);
        if (entry != null) return Optional.of(entry);
        for (Provider provider : PROVIDERS) {
            entry = provider.entryFor(item, id);
            if (entry != null) return Optional.of(entry);
        }
        return Optional.empty();
    }
}