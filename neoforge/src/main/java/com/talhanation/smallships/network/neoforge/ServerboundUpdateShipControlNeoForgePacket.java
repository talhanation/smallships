package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class ServerboundUpdateShipControlNeoForgePacket implements NeoForgePacket {
    private static final ResourceLocation ID = ModPackets.id("server_update_ship_control");

    private final boolean forward;
    private final boolean backward;
    private final boolean left;
    private final boolean right;

    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlNeoForgePacket(boolean forward, boolean backward, boolean left, boolean right) {
        this.forward = forward;
        this.backward = backward;
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlNeoForgePacket(FriendlyByteBuf buf) {
        this.forward = buf.readBoolean();
        this.backward = buf.readBoolean();
        this.left = buf.readBoolean();
        this.right = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        this.write(buf);
    }

    @Override
    public void handle(NeoForgePacket packet, PlayPayloadContext ctx) {
        if (ctx.player().isEmpty()) return;
        Player player = ctx.player().get();
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship) {
            ship.updateControls(forward, backward, left, right, player);
        }
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buffer) {
        buffer.writeBoolean(forward);
        buffer.writeBoolean(backward);
        buffer.writeBoolean(left);
        buffer.writeBoolean(right);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }
}
