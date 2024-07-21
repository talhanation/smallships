package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class ServerboundSetSailStateNeoForgePacket implements NeoForgePacket {
    private static final ResourceLocation ID = ModPackets.id("server_set_sail_state");

    private final byte state;

    @SuppressWarnings("unused")
    ServerboundSetSailStateNeoForgePacket(byte state) {
        this.state = state;
    }

    @SuppressWarnings("unused")
    ServerboundSetSailStateNeoForgePacket(FriendlyByteBuf buf) {
        this.state = buf.readByte();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        this.write(buf);
    }

    @Override
    public void handle(NeoForgePacket packet, PlayPayloadContext ctx) {
        if (ctx.player().isEmpty()) return;
        Player player = ctx.player().get();
        if (player.getVehicle() != null && player.getVehicle() instanceof Sailable sailShip) {
            sailShip.setSailState(state);
        }
    }

    @Override
    public void write(FriendlyByteBuf buffer) {
        buffer.writeByte(state);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }
}
