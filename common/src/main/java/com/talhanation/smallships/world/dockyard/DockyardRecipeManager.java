package com.talhanation.smallships.world.dockyard;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.network.packet.ClientboundDockyardRecipesPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Loads the dockyard recipes from data packs: one json file per ship, named
 * after the ship type it belongs to.
 *
 * {@code data/<namespace>/dockyard_recipes/<ship>.json} feeds the ship type
 * {@code <namespace>:<ship>}, so an addon ships its recipes in its own
 * namespace and pack makers can override any of them without touching code.
 *
 * The map is replaced as a whole on reload and read again on every dockyard
 * access, so an edited pack takes effect on the next /reload without a restart.
 * Clients get the current map pushed when they open a dockyard, because the
 * material list is drawn client side.
 */
public class DockyardRecipeManager extends SimpleJsonResourceReloadListener {

    public static final String DIRECTORY = "dockyard_recipes";
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(SmallShipsMod.MOD_ID, DIRECTORY);
    private static final Gson GSON = new Gson();

    /** replaced atomically, never mutated in place */
    private static volatile Map<ResourceLocation, DockyardRecipe> recipes = Map.of();

    public DockyardRecipeManager() {
        super(GSON, DIRECTORY);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> files, ResourceManager resourceManager, ProfilerFiller profiler) {
        Map<ResourceLocation, DockyardRecipe> loaded = new HashMap<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : files.entrySet()) {
            ShipType shipType = ShipRegistry.get(entry.getKey());
            if (shipType == null) {
                SmallShipsMod.LOGGER.warn("Skipping dockyard recipe '{}': no ship type with that id is registered.", entry.getKey());
                continue;
            }
            try {
                loaded.put(entry.getKey(), DockyardRecipe.fromJson(entry.getValue().getAsJsonObject(), shipType.getDefaultRecipe().buildTime()));
            } catch (Exception exception) {
                // a broken file must not make the ship unbuildable, the ship
                // types' own fallback recipe keeps it working
                SmallShipsMod.LOGGER.error("Could not read dockyard recipe '{}', falling back to the built-in recipe: {}", entry.getKey(), exception.getMessage());
            }
        }
        recipes = Map.copyOf(loaded);
    }

    /**
     * @return the data pack recipe of this ship, or the fallback recipe the
     * ship type was registered with.
     */
    public static DockyardRecipe get(ShipType shipType) {
        DockyardRecipe recipe = recipes.get(shipType.getId());
        return recipe != null ? recipe : shipType.getDefaultRecipe();
    }

    @Nullable
    public static DockyardRecipe getLoaded(ResourceLocation shipTypeId) {
        return recipes.get(shipTypeId);
    }

    /** Server side: the packet handed to a player opening a dockyard. */
    public static ClientboundDockyardRecipesPacket createSyncPacket() {
        return new ClientboundDockyardRecipesPacket(new HashMap<>(recipes));
    }

    /** Client side: takes over the recipes the server sent. */
    public static void applyFromNetwork(Map<ResourceLocation, DockyardRecipe> networkRecipes) {
        recipes = Map.copyOf(networkRecipes);
    }
}