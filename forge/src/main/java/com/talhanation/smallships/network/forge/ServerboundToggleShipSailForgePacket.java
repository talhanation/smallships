package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundToggleShipSailForgePacket implements ForgePacket {
    @SuppressWarnings("unused")
    ServerboundToggleShipSailForgePacket() {
    }

    @SuppressWarnings("unused")
    public ServerboundToggleShipSailForgePacket(FriendlyByteBuf buf) {
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
    }

    public void handle(CustomPayloadEvent.Context ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship && ship instanceof Sailable sailable) {
                sailable.toggleSail();
            }
            ctx.setPacketHandled(true);
        });
    }
}
