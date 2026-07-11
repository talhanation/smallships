package com.talhanation.smallships.world.dockyard;

import com.talhanation.smallships.world.entity.ship.BriggEntity;
import com.talhanation.smallships.world.entity.ship.CogEntity;
import com.talhanation.smallships.world.entity.ship.DrakkarEntity;
import com.talhanation.smallships.world.entity.ship.GalleyEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Static dockyard recipes: which materials and build time each ship type costs.
 * Materials are taken from and validated against the player inventory.
 * (Feature: ships are ONLY craftable at the dockyard, the vanilla crafting
 * recipes have been removed.)
 */
public class DockyardRecipe {

    public enum ShipType {
        COG(0, 90 * 20),
        BRIGG(1, 150 * 20),
        GALLEY(2, 120 * 20),
        DRAKKAR(3, 100 * 20);

        public final int id;
        /** build time in ticks */
        public final int buildTime;

        ShipType(int id, int buildTime) {
            this.id = id;
            this.buildTime = buildTime;
        }

        public static ShipType byId(int id) {
            for (ShipType type : values()) if (type.id == id) return type;
            return COG;
        }

        /**
         * Creates the ship entity at the given position, using the ships'
         * own summon factories.
         */
        public Ship summon(net.minecraft.world.level.Level level, double x, double y, double z) {
            return switch (this) {
                case COG -> CogEntity.summon(level, x, y, z);
                case BRIGG -> BriggEntity.summon(level, x, y, z);
                case GALLEY -> GalleyEntity.summon(level, x, y, z);
                case DRAKKAR -> DrakkarEntity.summon(level, x, y, z);
            };
        }

        public String getTranslationKey() {
            return "entity.smallships." + this.name().toLowerCase();
        }
    }

    /** A single required material: either a tag (planks) or a concrete item. */
    public record Ingredient(TagKey<Item> tag, ItemLike item, int amount) {
        public static Ingredient of(TagKey<Item> tag, int amount) {
            return new Ingredient(tag, null, amount);
        }
        public static Ingredient of(ItemLike item, int amount) {
            return new Ingredient(null, item, amount);
        }

        public boolean matches(ItemStack stack) {
            if (this.tag != null) return stack.is(this.tag);
            return stack.is(this.item.asItem());
        }

        public int countIn(Player player) {
            int count = 0;
            for (ItemStack stack : player.getInventory().items) {
                if (this.matches(stack)) count += stack.getCount();
            }
            return count;
        }

        public ItemStack getDisplayStack(Boat.Type woodType) {
            if (this.tag != null) {
                // display the planks of the selected wood type
                Item planks = plankItemOf(woodType);
                return new ItemStack(planks, this.amount);
            }
            return new ItemStack(this.item, this.amount);
        }
    }

    private static Item plankItemOf(Boat.Type type) {
        return switch (type.getName()) {
            case "spruce" -> Items.SPRUCE_PLANKS;
            case "birch" -> Items.BIRCH_PLANKS;
            case "jungle" -> Items.JUNGLE_PLANKS;
            case "acacia" -> Items.ACACIA_PLANKS;
            case "dark_oak" -> Items.DARK_OAK_PLANKS;
            case "mangrove" -> Items.MANGROVE_PLANKS;
            case "cherry" -> Items.CHERRY_PLANKS;
            case "bamboo" -> Items.BAMBOO_PLANKS;
            default -> Items.OAK_PLANKS;
        };
    }

    private static final Map<ShipType, List<Ingredient>> RECIPES = new LinkedHashMap<>();

    static {
        RECIPES.put(ShipType.COG, List.of(
                Ingredient.of(ItemTags.PLANKS, 96),
                Ingredient.of(Items.WHITE_WOOL, 16),
                Ingredient.of(Items.STRING, 8),
                Ingredient.of(Items.IRON_NUGGET, 12)));
        RECIPES.put(ShipType.BRIGG, List.of(
                Ingredient.of(ItemTags.PLANKS, 160),
                Ingredient.of(Items.WHITE_WOOL, 32),
                Ingredient.of(Items.STRING, 16),
                Ingredient.of(Items.IRON_INGOT, 8)));
        RECIPES.put(ShipType.GALLEY, List.of(
                Ingredient.of(ItemTags.PLANKS, 128),
                Ingredient.of(Items.WHITE_WOOL, 24),
                Ingredient.of(Items.STRING, 12),
                Ingredient.of(Items.IRON_NUGGET, 24)));
        RECIPES.put(ShipType.DRAKKAR, List.of(
                Ingredient.of(ItemTags.PLANKS, 112),
                Ingredient.of(Items.WHITE_WOOL, 20),
                Ingredient.of(Items.STRING, 10),
                Ingredient.of(Items.IRON_NUGGET, 16)));
    }

    public static List<Ingredient> getIngredients(ShipType type) {
        return RECIPES.get(type);
    }

    /**
     * @return true if the player has all required materials in their inventory.
     */
    public static boolean canAfford(ShipType type, Player player) {
        if (player.hasInfiniteMaterials()) return true;
        for (Ingredient ingredient : getIngredients(type)) {
            if (ingredient.countIn(player) < ingredient.amount()) return false;
        }
        return true;
    }

    /**
     * Consumes all required materials from the player inventory.
     * Callers must validate with {@link #canAfford} first.
     */
    public static void consume(ShipType type, Player player) {
        if (player.hasInfiniteMaterials()) return;
        for (Ingredient ingredient : getIngredients(type)) {
            int remaining = ingredient.amount();
            for (ItemStack stack : player.getInventory().items) {
                if (remaining <= 0) break;
                if (ingredient.matches(stack)) {
                    int take = Math.min(remaining, stack.getCount());
                    stack.shrink(take);
                    remaining -= take;
                }
            }
        }
    }

    /**
     * @return a list of display stacks for the GUI material list.
     */
    public static List<ItemStack> getDisplayStacks(ShipType type, Boat.Type woodType) {
        List<ItemStack> list = new ArrayList<>();
        for (Ingredient ingredient : getIngredients(type)) {
            list.add(ingredient.getDisplayStack(woodType));
        }
        return list;
    }
}
