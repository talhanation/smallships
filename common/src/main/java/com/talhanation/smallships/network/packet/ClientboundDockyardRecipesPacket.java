package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Pushes the current data pack dockyard recipes to a player. Sent every time a
 * dockyard is opened, because the material list is drawn client side and has to
 * match what the server will actually charge.
 */
public record ClientboundDockyardRecipesPacket(Map<ResourceLocation, DockyardRecipe> recipes) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("client_dockyard_recipes");

    public static ClientboundDockyardRecipesPacket read(FriendlyByteBuf buf) {
        return new ClientboundDockyardRecipesPacket(buf.readMap(HashMap::new, FriendlyByteBuf::readResourceLocation, DockyardRecipe::read));
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeMap(this.recipes, FriendlyByteBuf::writeResourceLocation, (out, recipe) -> recipe.write(out));
    }

    @Override
    public void handler(Player player) {
        DockyardRecipeManager.applyFromNetwork(this.recipes);
    }

    @Override
    public Side side() {
        return Side.CLIENTBOUND;
    }
}