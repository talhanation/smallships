package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class ServerboundSetSailStateFabricPacket implements FabricPacket, ServerPlayNetworking.PlayChannelHandler {

    private final byte state;
    private final float speed;
    private final float rotSpeed;
    @SuppressWarnings("unused")
    public ServerboundSetSailStateFabricPacket(byte state, float speed, float rotSpeed) {
        this.state = state;
        this.speed = speed;
        this.rotSpeed = rotSpeed;
    }

    @SuppressWarnings("unused")
    public ServerboundSetSailStateFabricPacket(FriendlyByteBuf buf) {
        this.state = buf.readByte();
        this.speed = buf.readFloat();
        this.rotSpeed = buf.readFloat();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeByte(state);
        buf.writeFloat(speed);
        buf.writeFloat(rotSpeed);
    }

    @Override
    public ResourceLocation getId() {
        return ModPackets.id("server_set_sail_state");
    }

    @SuppressWarnings("unused")
    @Override
    public void receive(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Sailable ship) {
            ship.self().setSailState(state);
            //ship.self().setSpeed(speed);
            //ship.self().setSpeed(rotSpeed); //FABRIC IS SHIT
        }
    }
}
