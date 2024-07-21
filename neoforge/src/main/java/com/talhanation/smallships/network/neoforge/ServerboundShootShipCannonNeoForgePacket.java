package com.talhanation.smallships.network.neoforge;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class ServerboundShootShipCannonNeoForgePacket implements NeoForgePacket {
    private static final ResourceLocation ID = ModPackets.id("server_shoot_ship_cannon");

    private final boolean trigger;

    @SuppressWarnings("unused")
    ServerboundShootShipCannonNeoForgePacket(boolean trigger) {
        this.trigger = trigger;
    }

    @SuppressWarnings("unused")
    ServerboundShootShipCannonNeoForgePacket(FriendlyByteBuf buf) {
        this.trigger = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        this.write(buf);
    }

    @Override
    public void handle(NeoForgePacket packet, PlayPayloadContext ctx) {
        if (ctx.player().isEmpty()) return;
        Player player = ctx.player().get();
        if (player.getVehicle() != null && player.getVehicle() instanceof Cannonable cannonShip) {
            cannonShip.self().setCannonKeyPressed(trigger);
        }
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buffer) {
        buffer.writeBoolean(trigger);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }
}
