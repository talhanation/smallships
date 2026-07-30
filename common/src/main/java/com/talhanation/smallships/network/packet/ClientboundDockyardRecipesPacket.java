package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import com.talhanation.smallships.world.dockyard.DockyardRecipeManager;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Pushes the current data pack dockyard recipes to a player. Sent every time a
 * dockyard is opened, because the material list is drawn client side and has to
 * match what the server will actually charge.
 */
public record ClientboundDockyardRecipesPacket(Map<ResourceLocation, DockyardRecipe> recipes) implements ModPacket {
    public static final Type<ClientboundDockyardRecipesPacket> TYPE = new Type<>(ModPackets.id("client_dockyard_recipes"));

    private static final StreamCodec<RegistryFriendlyByteBuf, Map<ResourceLocation, DockyardRecipe>> RECIPE_MAP_CODEC =
            ByteBufCodecs.map(HashMap::new, ResourceLocation.STREAM_CODEC, DockyardRecipe.STREAM_CODEC);

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundDockyardRecipesPacket> CODEC =
            RECIPE_MAP_CODEC.map(ClientboundDockyardRecipesPacket::new, ClientboundDockyardRecipesPacket::recipes);

    @Override
    public @NotNull Type<ClientboundDockyardRecipesPacket> type() {
        return TYPE;
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