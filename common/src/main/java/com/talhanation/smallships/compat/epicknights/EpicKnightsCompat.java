package com.talhanation.smallships.compat.epicknights;

import com.talhanation.smallships.compat.ShieldRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Hangs Epic Knights shields on a hull.
 *
 * Nothing of theirs is imported and nothing of theirs is redrawn: the shields
 * are recognised by their common base class and then handed to the ITEM
 * renderer, which runs their own model, their own texture and any heraldry the
 * player has already painted onto the shield. Without the mod installed no
 * stack ever matches and this class does nothing.
 *
 * Recognition is by CLASS, not by id, on purpose. Epic Knights builds every
 * shield shape from eleven materials - {@code iron_kiteshield},
 * {@code bronze_pavese} and so on - which is around a hundred items before its
 * addons (Dark Ages, Slavic Armory, Antique Legacy) add their own. Naming them
 * one by one would mean a release here for every release there. The class
 * catches all of them, including the addons', and the id is then only read to
 * pick the SHAPE: every id ends in its family name, so one entry per shape is
 * enough and the material in front of it does not matter.
 *
 * The numbers below are starting values, not measured ones. They are derived
 * from the vanilla shields' placement, which is the only known good anchor we
 * have - expect one tuning round in game before they sit right.
 */
public final class EpicKnightsCompat implements ShieldRegistry.Provider {

    /**
     * The base class of every Epic Knights shield. Matched by name so this mod
     * builds and runs without theirs on the classpath.
     */
    private static final String SHIELD_ITEM_CLASS = "com.magistuarmory.item.MedievalShieldItem";

    /** lean away from the hull, the same angle the vanilla shield is hung at */
    private static final float PITCH = 20.0F;
    private static final float YAW = 0.0F;
    private static final float ROLL = 180.0F;

    /**
     * The shield shapes, keyed by the suffix Epic Knights puts on every one of
     * their ids. Longest match wins by insertion order, which is why
     * {@code roundshield} sits behind {@code heatershield} - a corrupted round
     * shield ends in the former and must not be caught by a shorter key.
     *
     * The scale is the shields' size on the hull relative to a vanilla shield
     * at 0.8: a buckler is a fist sized boss, a pavise is a wall to kneel behind.
     */
    private static final Map<String, ShieldRegistry.ShieldEntry> FAMILIES = new LinkedHashMap<>();

    /** an Epic Knights shield we do not know the shape of, e.g. from an addon */
    private static final ShieldRegistry.ShieldEntry DEFAULT = ShieldRegistry.ShieldEntry.item(0.8F, PITCH, YAW, ROLL);

    static {
        // round shapes, smallest first
        family("buckler", 0.55F);
        family("target", 0.70F);
        family("rondache", 0.85F);
        family("heatershield", 0.90F);
        family("tartsche", 0.90F);
        // the viking round shield: the shape the drakkar was built for
        family("roundshield", 1.00F);
        family("ellipticalshield", 1.00F);
        family("kiteshield", 1.10F);
        family("pavese", 1.20F);
    }

    private static void family(String idSuffix, float scale) {
        FAMILIES.put(idSuffix, ShieldRegistry.ShieldEntry.item(scale, PITCH, YAW, ROLL));
    }

    private EpicKnightsCompat() {
    }

    /** Called from {@link ShieldRegistry#init()}. */
    public static void register() {
        ShieldRegistry.addProvider(new EpicKnightsCompat());
    }

    @Override
    @Nullable
    public ShieldRegistry.ShieldEntry entryFor(Item item, ResourceLocation id) {
        if (!isMedievalShield(item)) return null;
        String path = id.getPath();
        for (Map.Entry<String, ShieldRegistry.ShieldEntry> family : FAMILIES.entrySet()) {
            if (path.endsWith(family.getKey())) return family.getValue();
        }
        return DEFAULT;
    }

    /**
     * Walks up the class hierarchy looking for their shield base class. String
     * comparison rather than {@code instanceof} because the class only exists
     * when the mod is installed.
     */
    private static boolean isMedievalShield(Item item) {
        for (Class<?> type = item.getClass(); type != null; type = type.getSuperclass()) {
            if (SHIELD_ITEM_CLASS.equals(type.getName())) return true;
        }
        return false;
    }
}