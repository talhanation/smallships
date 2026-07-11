package com.talhanation.smallships.world.entity.ship;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Ship upgrades installed at the dockyard. Upgrades are stored as booleans in
 * the ship's synched entity data ({@link Ship#UPGRADES}) and applied as
 * multipliers on top of the base attributes in {@link Ship#getAttributes()}.
 */
public enum ShipUpgrade {
    /** +100% durability */
    IRON_SCANTLINGS("IronScantlings", new ItemStack(Items.IRON_INGOT, 32), 45 * 20) {
        @Override
        public void apply(Attributes attributes) {
            attributes.maxHealth *= 2.0F;
        }
    },
    /** +25% ship speed */
    COTTON_SAILS("CottonSails", new ItemStack(Items.WHITE_WOOL, 24), 30 * 20) {
        @Override
        public void apply(Attributes attributes) {
            attributes.maxSpeed *= 1.25F;
        }
    },
    /** +20% maneuverability */
    COPPER_PLATING("CopperPlating", new ItemStack(Items.COPPER_INGOT, 24), 30 * 20) {
        @Override
        public void apply(Attributes attributes) {
            attributes.maxRotationSpeed *= 1.2F;
            attributes.rotationAcceleration *= 1.2F;
        }
    };

    private final String tagKey;
    private final ItemStack cost;
    /** installation time at the dockyard in ticks */
    private final int buildTime;

    ShipUpgrade(String tagKey, ItemStack cost, int buildTime) {
        this.tagKey = tagKey;
        this.cost = cost;
        this.buildTime = buildTime;
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public ItemStack getCost() {
        return this.cost.copy();
    }

    public Item getCostItem() {
        return this.cost.getItem();
    }

    public int getCostAmount() {
        return this.cost.getCount();
    }

    public int getBuildTime() {
        return this.buildTime;
    }

    public String getTranslationKey() {
        return "gui.smallships.upgrade." + this.name().toLowerCase();
    }

    public String getDescriptionTranslationKey() {
        return this.getTranslationKey() + ".description";
    }

    /** Applies this upgrade's modifier to the given attributes. */
    public abstract void apply(Attributes attributes);

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
            if (upgrade.isInstalled(ship)) upgrade.apply(attributes);
        }
    }

    public static ShipUpgrade byOrdinal(int ordinal) {
        ShipUpgrade[] values = values();
        return values[Math.floorMod(ordinal, values.length)];
    }
}
