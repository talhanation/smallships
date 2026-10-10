package com.talhanation.smallships.world.dockyard;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
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

    /** planks one log is worth, the vanilla crafting yield */
    private static final int PLANKS_PER_LOG = 4;
    /** nuggets one iron ingot is worth, the vanilla crafting yield */
    private static final int NUGGETS_PER_INGOT = 9;
    /** ingots one iron block is worth, the vanilla crafting yield */
    private static final int INGOTS_PER_BLOCK = 9;

    public void write(FriendlyByteBuf buf) {
        buf.writeVarInt(this.buildTime);
        buf.writeCollection(this.ingredients, (out, ingredient) -> ingredient.write(out));
    }

    public static DockyardRecipe read(FriendlyByteBuf buf) {
        int buildTime = buf.readVarInt();
        return new DockyardRecipe(buildTime, buf.readList(Ingredient::read));
    }

    /** A single required material: either a tag (planks) or a concrete item. */
    public record Ingredient(TagKey<Item> tag, Item item, int amount) {

        public void write(FriendlyByteBuf buf) {
            buf.writeUtf(this.toNetworkKey());
            buf.writeVarInt(this.amount);
        }

        public static Ingredient read(FriendlyByteBuf buf) {
            String key = buf.readUtf();
            return fromNetworkKey(key, buf.readVarInt());
        }

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

        /** The same count for any container, e.g. the inventory of an NPC paying for a repair. */
        public int countIn(Container container) {
            int count = 0;
            for (int i = 0; i < container.getContainerSize(); i++) {
                ItemStack stack = container.getItem(i);
                if (this.matches(stack)) count += stack.getCount();
            }
            return count;
        }

        /**
         * @return what this ingredient adds to the price of a ship: wood counted
         * in planks, iron counted in nuggets. Everything else - wool, string,
         * whatever an addon asks for - is not part of the price, it only says
         * what KIND of ship it is, not how big.
         *
         * Iron is normalized to nuggets because the recipes ask for it in
         * both sizes: the small hulls in nuggets, brigg and galleon in ingots.
         * Compared as written, eight ingots would come out cheaper than
         * eighteen nuggets.
         */
        public int getBuildCost() {
            if (this.tag != null) {
                if (this.tag.equals(ItemTags.PLANKS)) return this.amount;
                if (this.tag.equals(ItemTags.LOGS)) return this.amount * PLANKS_PER_LOG;
                return 0;
            }
            if (this.item == Items.IRON_NUGGET) return this.amount;
            if (this.item == Items.IRON_INGOT) return this.amount * NUGGETS_PER_INGOT;
            if (this.item == Items.IRON_BLOCK) return this.amount * INGOTS_PER_BLOCK * NUGGETS_PER_INGOT;
            // a data pack may well ask for one concrete wood instead of the tag
            if (new ItemStack(this.item).is(ItemTags.PLANKS)) return this.amount;
            if (new ItemStack(this.item).is(ItemTags.LOGS)) return this.amount * PLANKS_PER_LOG;
            return 0;
        }

        public ItemStack getDisplayStack(Boat.Type woodType) {
            if (this.tag == null) return new ItemStack(this.item, this.amount);
            // ONLY the planks tag follows the selected wood type. Every other
            // tag shows whatever is registered in it first - otherwise a wool
            // ingredient (sail repair) advertised itself as planks.
            if (this.tag.equals(ItemTags.PLANKS)) return new ItemStack(plankItemOf(woodType), this.amount);
            return BuiltInRegistries.ITEM.getTag(this.tag)
                    .flatMap(holders -> holders.stream().findFirst())
                    .map(holder -> new ItemStack(holder.value(), this.amount))
                    // an empty tag is a broken data pack, and it has to look broken
                    .orElseGet(() -> new ItemStack(Items.BARRIER, this.amount));
        }

        /** Tags travel with a leading '#', exactly like they are written in json. */
        private String toNetworkKey() {
            if (this.tag != null) return "#" + this.tag.location();
            return BuiltInRegistries.ITEM.getKey(this.item).toString();
        }

        private static Ingredient fromNetworkKey(String key, int amount) {
            if (key.startsWith("#")) {
                return new Ingredient(TagKey.create(Registries.ITEM, new ResourceLocation(key.substring(1))), null, amount);
            }
            return new Ingredient(null, BuiltInRegistries.ITEM.get(new ResourceLocation(key)), amount);
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
                ResourceLocation tagId = new ResourceLocation(json.get("tag").getAsString());
                return of(TagKey.create(Registries.ITEM, tagId), amount);
            }
            if (json.has("item")) {
                ResourceLocation itemId = new ResourceLocation(json.get("item").getAsString());
                if (!BuiltInRegistries.ITEM.containsKey(itemId)) throw new IllegalArgumentException("Unknown item " + itemId);
                return of(BuiltInRegistries.ITEM.get(itemId), amount);
            }
            throw new IllegalArgumentException("Ingredient needs either 'item' or 'tag'");
        }
    }

    public static Item plankItemOf(Boat.Type type) {
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
     * @return the price of this ship in wood and iron, see
     * {@link Ingredient#getBuildCost()}. Only used to ORDER the ships in the
     * build tab, the dockyard never charges by this number.
     */
    public int getBuildCost() {
        int cost = 0;
        for (Ingredient ingredient : this.ingredients) {
            cost += ingredient.getBuildCost();
        }
        return cost;
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
        if (player.isCreative()) return true;
        for (Ingredient ingredient : ingredients) {
            if (ingredient.countIn(player) < ingredient.amount()) return false;
        }
        return true;
    }

    /** Cost check against any container - an NPC pays exactly what a player would. */
    public static boolean canAfford(List<Ingredient> ingredients, Container container) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.countIn(container) < ingredient.amount()) return false;
        }
        return true;
    }

    /** Consumes any material list from any container. Callers must validate with canAfford first. */
    public static void consume(List<Ingredient> ingredients, Container container) {
        for (Ingredient ingredient : ingredients) {
            int remaining = ingredient.amount();
            for (int i = 0; i < container.getContainerSize() && remaining > 0; i++) {
                ItemStack stack = container.getItem(i);
                if (ingredient.matches(stack)) {
                    int take = Math.min(remaining, stack.getCount());
                    container.removeItem(i, take);
                    remaining -= take;
                }
            }
        }
        container.setChanged();
    }

    /** Consumes any material list, also used by the repair task. */
    public static void consume(List<Ingredient> ingredients, Player player) {
        if (player.isCreative()) return;
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