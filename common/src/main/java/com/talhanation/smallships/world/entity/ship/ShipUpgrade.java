package com.talhanation.smallships.world.entity.ship;

import com.talhanation.smallships.config.SyncedServerConfig;
import com.talhanation.smallships.world.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

/**
 * Ship upgrades installed at the dockyard. Upgrades are stored as booleans in
 * the ship's synched entity data ({@link Ship#UPGRADES}) and applied as
 * multipliers on top of the base attributes in {@link Ship#getAttributes()}.
 *
 * Every upgrade is paid for with its own crafted material. HOW MUCH of it is
 * not decided here but by the ship: a galleon swallows far more plating than a
 * dhow, see {@link Ship#getUpgradeCosts()}. The amount in this enum is only the
 * fallback for a ship that does not state a price of its own.
 */
public enum ShipUpgrade {
    /** +100% durability */
    IRON_SCANTLINGS("IronScantlings", () -> ModItems.IRON_SCANTLINGS, 4, 45 * 20) {
        @Override
        public void apply(Attributes attributes) {
            attributes.maxHealth *= 1.0F + percentOf(SyncedServerConfig.ironScantlingsHealth());
        }

        @Override
        public double getEffectPercent() {
            return SyncedServerConfig.ironScantlingsHealth();
        }
    },
    /** +25% ship speed */
    COTTON_SAILS("CottonSails", () -> ModItems.COTTON_SAILS, 4, 30 * 20) {
        @Override
        public void apply(Attributes attributes) {
            attributes.maxSpeed *= 1.0F + percentOf(SyncedServerConfig.cottonSailsSpeed());
        }

        @Override
        public double getEffectPercent() {
            return SyncedServerConfig.cottonSailsSpeed();
        }
    },
    /** +20% maneuverability */
    COPPER_PLATING("CopperPlating", () -> ModItems.COPPER_PLATING, 4, 30 * 20) {
        @Override
        public void apply(Attributes attributes) {
            float factor = 1.0F + percentOf(SyncedServerConfig.copperPlatingRotation());
            attributes.maxRotationSpeed *= factor;
            attributes.rotationAcceleration *= factor;
        }

        @Override
        public double getEffectPercent() {
            return SyncedServerConfig.copperPlatingRotation();
        }
    };

    private final String tagKey;
    /**
     * A supplier, not the item itself: the enum constants are built when this
     * class is first touched, and that can happen before the platform has
     * filled ModItems.
     */
    private final Supplier<Item> costItem;
    private final int defaultCost;
    /** installation time at the dockyard in ticks */
    private final int buildTime;

    ShipUpgrade(String tagKey, Supplier<Item> costItem, int defaultCost, int buildTime) {
        this.tagKey = tagKey;
        this.costItem = costItem;
        this.defaultCost = defaultCost;
        this.buildTime = buildTime;
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public Item getCostItem() {
        return this.costItem.get();
    }

    /** Amount used for a ship that does not state a price of its own. */
    public int getDefaultCost() {
        return this.defaultCost;
    }

    public int getCostAmount(Ship ship) {
        return ship.getUpgradeCost(this);
    }

    /** The stack this upgrade costs on the given ship, ready for display. */
    public ItemStack getCost(Ship ship) {
        return new ItemStack(this.getCostItem(), this.getCostAmount(ship));
    }

    /** A single item of the material, for icons where no amount is wanted. */
    public ItemStack getCostIcon() {
        return new ItemStack(this.getCostItem());
    }

    public int getBuildTime() {
        return scaleTime(this.buildTime);
    }

    /** Reads a percent value as a plain factor, 25.0 -> 0.25. */
    private static float percentOf(double percent) {
        return (float) (percent / 100.0D);
    }

    private static int scaleTime(int ticks) {
        double modifier = SyncedServerConfig.upgradeTimeModifier() / 100.0D;
        return Math.max(0, (int) Math.round(ticks * modifier));
    }

    /**
     * Whether this upgrade is offered on the given ship at all. A ship that
     * prices an upgrade at 0 does not get it - a galley has no business being
     * copper plated if the pack author says so - and the config switch takes
     * every upgrade off every hull at once.
     */
    public boolean isAvailable(Ship ship) {
        return SyncedServerConfig.upgradeEnable() && this.getCostAmount(ship) > 0;
    }

    /**
     * Taking an upgrade off again is destructive work: the timbers are cut, the
     * plating is unriveted. Only a part of the material survives it.
     */
    public static float getRefundFraction() {
        return percentOf(SyncedServerConfig.upgradeRefundModifier());
    }

    /**
     * @return the amount handed back when this upgrade is removed at the
     * dockyard. Cannons and shields are bolted on and come back whole, so they
     * are refunded in full elsewhere - everything in this enum is built INTO
     * the hull and only returns {@link #getRefundFraction()} of its material.
     */
    public int getRefundAmount(Ship ship) {
        return (int) Math.floor(this.getCostAmount(ship) * getRefundFraction());
    }

    /** The time it takes to take this upgrade off again, shorter than installing it. */
    public int getRemoveTime() {
        return Math.max(20, scaleTime(this.buildTime / 3));
    }

    public String getTranslationKey() {
        return "gui.smallships.upgrade." + this.name().toLowerCase();
    }

    public String getDescriptionTranslationKey() {
        return this.getTranslationKey() + ".description";
    }

    /** Applies this upgrade's modifier to the given attributes. */
    public abstract void apply(Attributes attributes);

    /**
     * How strong this upgrade currently is, in percent. The description in the
     * tooltip used to spell the number out in the language file, so it kept
     * promising +100% while the config had long said something else.
     */
    public abstract double getEffectPercent();

    /** The same number as text, without a pointless ".0" on whole values. */
    public String getEffectPercentText() {
        double percent = this.getEffectPercent();
        return percent == Math.rint(percent) ? String.valueOf((long) percent) : String.valueOf(percent);
    }

    /* ---------------- installed state on a ship ---------------- */

    public boolean isInstalled(Ship ship) {
        return ship.getData(Ship.UPGRADES).getBoolean(this.tagKey);
    }

    public void setInstalled(Ship ship, boolean installed) {
        CompoundTag tag = ship.getData(Ship.UPGRADES).copy();
        tag.putBoolean(this.tagKey, installed);
        ship.setData(Ship.UPGRADES, tag);
    }

    /** Applies all installed upgrades of the ship to the given attributes. */
    public static void applyAll(Ship ship, Attributes attributes) {
        for (ShipUpgrade upgrade : values()) {
            // an upgrade that is no longer offered stops working, otherwise a
            // ship built before the config was changed would keep a bonus that
            // the dockyard does not even list any more
            if (upgrade.isInstalled(ship) && upgrade.isAvailable(ship)) upgrade.apply(attributes);
        }
    }

    public static ShipUpgrade byOrdinal(int ordinal) {
        ShipUpgrade[] values = values();
        return values[Math.floorMod(ordinal, values.length)];
    }
}