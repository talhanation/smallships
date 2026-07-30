package com.talhanation.smallships.world.dockyard;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;

/**
 * What a ship costs at the dockyard and how long it takes to build.
 * Materials are taken from and validated against the player inventory.
 * (Feature: ships are ONLY craftable at the dockyard, the vanilla crafting
 * recipes have been removed.)
 *
 * A recipe is loaded from a data pack by the {@link DockyardRecipeManager}, one
 * json file per ship. The recipe registered with the ship type itself is only
 * the fallback used while no data pack provides one, so a ship stays buildable
 * even if its json is missing or broken.
 */
public record DockyardRecipe(int buildTime, List<Ingredient> ingredients) {

    public static final StreamCodec<ByteBuf, DockyardRecipe> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, DockyardRecipe::buildTime,
            Ingredient.STREAM_CODEC.apply(ByteBufCodecs.list()), DockyardRecipe::ingredients,
            DockyardRecipe::new);

    /** A single required material: either a tag (planks) or a concrete item. */
    public record Ingredient(TagKey<Item> tag, Item item, int amount) {

        public static final StreamCodec<ByteBuf, Ingredient> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8, Ingredient::toNetworkKey,
                ByteBufCodecs.VAR_INT, Ingredient::amount,
                Ingredient::fromNetworkKey);

        public static Ingredient of(TagKey<Item> tag, int amount) {
            return new Ingredient(tag, null, amount);
        }
        public static Ingredient of(ItemLike item, int amount) {
            return new Ingredient(null, item.asItem(), amount);
        }

        public boolean matches(ItemStack stack) {
            if (this.tag != null) return stack.is(this.tag);
            return stack.is(this.item);
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

        /** Tags travel with a leading '#', exactly like they are written in json. */
        private String toNetworkKey() {
            if (this.tag != null) return "#" + this.tag.location();
            return BuiltInRegistries.ITEM.getKey(this.item).toString();
        }

        private static Ingredient fromNetworkKey(String key, int amount) {
            if (key.startsWith("#")) {
                return new Ingredient(TagKey.create(Registries.ITEM, ResourceLocation.parse(key.substring(1))), null, amount);
            }
            return new Ingredient(null, BuiltInRegistries.ITEM.get(ResourceLocation.parse(key)), amount);
        }

        /**
         * Reads one entry of the "ingredients" array:
         * {"tag": "minecraft:planks", "count": 128} or
         * {"item": "minecraft:white_wool", "count": 24}.
         *
         * @throws IllegalArgumentException if the entry is malformed, so the
         * manager can drop the whole file and keep the fallback recipe
         */
        public static Ingredient fromJson(JsonObject json) {
            int amount = json.has("count") ? json.get("count").getAsInt() : 1;
            if (amount <= 0) throw new IllegalArgumentException("count must be positive");

            if (json.has("tag")) {
                ResourceLocation tagId = ResourceLocation.parse(json.get("tag").getAsString());
                return of(TagKey.create(Registries.ITEM, tagId), amount);
            }
            if (json.has("item")) {
                ResourceLocation itemId = ResourceLocation.parse(json.get("item").getAsString());
                if (!BuiltInRegistries.ITEM.containsKey(itemId)) throw new IllegalArgumentException("Unknown item " + itemId);
                return of(BuiltInRegistries.ITEM.get(itemId), amount);
            }
            throw new IllegalArgumentException("Ingredient needs either 'item' or 'tag'");
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

    /**
     * Reads a whole recipe file:
     * {"build_time": 1800, "ingredients": [ ... ]}.
     * The build time is optional and falls back to the ship types' default.
     *
     * @throws IllegalArgumentException if the file is malformed
     */
    public static DockyardRecipe fromJson(JsonObject json, int defaultBuildTime) {
        int buildTime = json.has("build_time") ? json.get("build_time").getAsInt() : defaultBuildTime;
        if (buildTime <= 0) throw new IllegalArgumentException("build_time must be positive");

        List<Ingredient> ingredients = new ArrayList<>();
        if (json.has("ingredients")) {
            JsonArray array = json.getAsJsonArray("ingredients");
            for (JsonElement element : array) {
                ingredients.add(Ingredient.fromJson(element.getAsJsonObject()));
            }
        }
        return new DockyardRecipe(buildTime, ingredients);
    }

    /**
     * @return true if the player has all required materials in their inventory.
     */
    public boolean canAfford(Player player) {
        return canAfford(this.ingredients, player);
    }

    /**
     * Consumes all required materials from the player inventory.
     * Callers must validate with {@link #canAfford} first.
     */
    public void consume(Player player) {
        consume(this.ingredients, player);
    }

    /**
     * @return a list of display stacks for the GUI material list.
     */
    public List<ItemStack> getDisplayStacks(Boat.Type woodType) {
        List<ItemStack> list = new ArrayList<>();
        for (Ingredient ingredient : this.ingredients) {
            list.add(ingredient.getDisplayStack(woodType));
        }
        return list;
    }

    /** Cost check for any material list, also used by the repair task. */
    public static boolean canAfford(List<Ingredient> ingredients, Player player) {
        if (player.hasInfiniteMaterials()) return true;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.countIn(player) < ingredient.amount()) return false;
        }
        return true;
    }

    /** Consumes any material list, also used by the repair task. */
    public static void consume(List<Ingredient> ingredients, Player player) {
        if (player.hasInfiniteMaterials()) return;
        for (Ingredient ingredient : ingredients) {
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
}