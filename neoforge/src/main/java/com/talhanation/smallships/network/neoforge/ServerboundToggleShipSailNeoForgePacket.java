package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class ServerboundToggleShipSailNeoForgePacket implements NeoForgePacket {
    private static final ResourceLocation ID = ModPackets.id("server_toggle_ship_sail");

    @SuppressWarnings("unused")
    ServerboundToggleShipSailNeoForgePacket() {
    }

    @SuppressWarnings("unused")
    public ServerboundToggleShipSailNeoForgePacket(FriendlyByteBuf buf) {
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        this.write(buf);
    }

    @Override
    public void handle(NeoForgePacket packet, PlayPayloadContext ctx) {
        if (ctx.player().isEmpty()) return;
        Player player = ctx.player().get();
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship && ship instanceof Sailable sailable) {
            sailable.toggleSail();
        }
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buffer) {
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }
}
