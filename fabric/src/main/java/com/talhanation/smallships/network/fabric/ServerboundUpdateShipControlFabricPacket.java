package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class ServerboundUpdateShipControlFabricPacket implements FabricPacket, ServerPlayNetworking.PlayChannelHandler {

    private final boolean forward;
    private final boolean backward;
    private final boolean left;
    private final boolean right;
    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlFabricPacket(boolean forward, boolean backward, boolean left, boolean right) {
        this.forward = forward;
        this.backward = backward;
        this.left = left;
        this.right = right;
    }

    @SuppressWarnings("unused")
    public ServerboundUpdateShipControlFabricPacket(FriendlyByteBuf buf) {
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

    @Override
    public ResourceLocation getId() {
        return ModPackets.id("server_update_ship_control");
    }

    @SuppressWarnings("unused")
    @Override
    public void receive(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship) {
            ship.updateControls(forward, backward, left, right, player);
        }
    }
}
