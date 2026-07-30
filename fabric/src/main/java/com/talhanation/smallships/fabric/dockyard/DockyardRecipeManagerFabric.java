package com.talhanation.smallships.fabric.dockyard;

import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 * Fabric needs every data pack reload listener to carry an id, the shared
 * loader itself stays platform independent.
 */
public class DockyardRecipeManagerFabric extends DockyardRecipeManager implements IdentifiableResourceReloadListener {
    @Override
    public @NotNull ResourceLocation getFabricId() {
        return DockyardRecipeManager.ID;
    }
}