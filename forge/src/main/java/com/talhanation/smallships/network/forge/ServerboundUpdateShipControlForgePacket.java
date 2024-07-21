package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class ServerboundUpdateShipControlForgePacket implements ForgePacket {
    private final boolean forward;
    private final boolean backward;
    private final boolean left;
    private final boolean right;
    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlForgePacket(boolean forward, boolean backward, boolean left, boolean right) {
        this.forward = forward;
        this.backward = backward;
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlForgePacket(FriendlyByteBuf buf) {
        this.forward = buf.readBoolean();
        this.backward = buf.readBoolean();
        this.left = buf.readBoolean();
        this.right = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(forward);
        buf.writeBoolean(backward);
        buf.writeBoolean(left);
        buf.writeBoolean(right);
    }

    public void handle(CustomPayloadEvent.Context ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship) {
                ship.updateControls(forward, backward, left, right, player);
            }
            ctx.setPacketHandled(true);
        });
    }
}
