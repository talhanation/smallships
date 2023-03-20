package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerboundShootShipCannonForgePacket implements ForgePacket {
    private final boolean trigger;
    @SuppressWarnings("unused")
    ServerboundShootShipCannonForgePacket(boolean trigger) {
        this.trigger = trigger;
    }

    @SuppressWarnings("unused")
    public ServerboundShootShipCannonForgePacket(FriendlyByteBuf buf) {
        this.trigger = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(trigger);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Cannonable cannonShip) {
                cannonShip.self().setCannonKeyPressed(trigger);
            }
            ctx.get().setPacketHandled(true);
        });
    }
}
