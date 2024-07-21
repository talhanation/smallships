package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundSetSailStateForgePacket implements ForgePacket {
    private final byte state;
    @SuppressWarnings("unused")
    ServerboundSetSailStateForgePacket(byte state) {
        this.state = state;
    }

    @SuppressWarnings("unused")
    public ServerboundSetSailStateForgePacket(FriendlyByteBuf buf) {
        this.state = buf.readByte();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeByte(state);
    }

    public void handle(CustomPayloadEvent.Context ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Sailable sailShip) {
                sailShip.setSailState(state);
            }
            ctx.setPacketHandled(true);
        });
    }
}
