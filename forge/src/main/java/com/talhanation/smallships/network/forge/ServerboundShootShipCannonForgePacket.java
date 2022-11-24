package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerboundShootShipCannonForgePacket implements ForgePacket {
    @SuppressWarnings("unused")
    ServerboundShootShipCannonForgePacket() {
    }

    @SuppressWarnings("unused")
    public ServerboundShootShipCannonForgePacket(FriendlyByteBuf buf) {
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Cannonable cannonShip) {
                cannonShip.shoot(player);
            }
            ctx.get().setPacketHandled(true);
        });
    }
}
