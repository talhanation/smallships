package com.talhanation.smallships.api;

import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Everything the dockyard needs to know about a ship without knowing the ship
 * class itself: how to summon it, how long it takes to build and what it costs.
 *
 * A ship type is created with the builder and handed to {@link ShipRegistry},
 * which is the only contact point an addon needs. The main mod registers its
 * own ships exactly the same way, so adding a ship never requires a change
 * inside the main mod.
 *
 * <pre>
 * ShipRegistry.register(ShipType.builder(ResourceLocation.fromNamespaceAndPath("myaddon", "longship"), LongshipEntity::summon)
 *         .buildTime(110 * 20)
 *         .ingredient(ItemTags.PLANKS, 112)
 *         .ingredient(Items.WHITE_WOOL, 20)
 *         .build());
 * </pre>
 *
 * The recipe given here is only the fallback. The recipe players actually see
 * comes from the data pack file {@code data/<namespace>/dockyard_recipes/<path>.json},
 * see {@link DockyardRecipeManager}.
 */
public final class ShipType {

    /**
     * Creates the ship entity at the given position. The entity is NOT added to
     * the world by the factory - the dockyard does that after placing it, and
     * the build preview uses the very same factory for a throwaway client
     * dummy. Usually a ships' own static summon method.
     */
    @FunctionalInterface
    public interface Factory {
        Ship summon(Level level, double x, double y, double z);
    }

    private final ResourceLocation id;
    private final Factory factory;
    private final DockyardRecipe defaultRecipe;

    private ShipType(Builder builder) {
        this.id = builder.id;
        this.factory = builder.factory;
        this.defaultRecipe = new DockyardRecipe(builder.buildTime, Collections.unmodifiableList(new ArrayList<>(builder.ingredients)));
    }

    public static Builder builder(ResourceLocation id, Factory factory) {
        return new Builder(id, factory);
    }

    /** The registry key of this ship type, e.g. {@code smallships:cog}. */
    public ResourceLocation getId() {
        return this.id;
    }

    /**
     * @return the built-in recipe, used whenever no data pack provides one for
     * this ship. Use {@link DockyardRecipeManager#get(ShipType)} to get the
     * recipe that is actually in effect.
     */
    public DockyardRecipe getDefaultRecipe() {
        return this.defaultRecipe;
    }

    public Ship summon(Level level, double x, double y, double z) {
        return this.factory.summon(level, x, y, z);
    }

    /**
     * @return the entity translation key derived from the id, so a ship type
     * reuses the entity name the addon already ships in its lang files
     * ({@code smallships:cog} -> {@code entity.smallships.cog}).
     */
    public String getTranslationKey() {
        return "entity." + this.id.getNamespace() + "." + this.id.getPath();
    }

    public Component getDisplayName() {
        return Component.translatable(this.getTranslationKey());
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ShipType shipType && this.id.equals(shipType.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return this.id.toString();
    }

    public static class Builder {
        private final ResourceLocation id;
        private final Factory factory;
        private final List<DockyardRecipe.Ingredient> ingredients = new ArrayList<>();
        private int buildTime = 100 * 20;

        private Builder(ResourceLocation id, Factory factory) {
            this.id = id;
            this.factory = factory;
        }

        /** @param buildTime fallback build time at the dockyard in ticks */
        public Builder buildTime(int buildTime) {
            this.buildTime = buildTime;
            return this;
        }

        /** Adds a fallback tag ingredient, e.g. planks of any wood type. */
        public Builder ingredient(TagKey<Item> tag, int amount) {
            this.ingredients.add(DockyardRecipe.Ingredient.of(tag, amount));
            return this;
        }

        /** Adds a fallback item ingredient. */
        public Builder ingredient(ItemLike item, int amount) {
            this.ingredients.add(DockyardRecipe.Ingredient.of(item, amount));
            return this;
        }

        public ShipType build() {
            return new ShipType(this);
        }
    }
}