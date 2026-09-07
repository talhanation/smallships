package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.client.wind.ClientWindManager;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public record ClientboundWindPacket(float currentDirection, float currentStrength, float targetDirection, float targetStrength, int transitionTicks) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("client_wind_update");

    public static ClientboundWindPacket read(FriendlyByteBuf buf) {
        return new ClientboundWindPacket(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readVarInt());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeFloat(this.currentDirection);
        buf.writeFloat(this.currentStrength);
        buf.writeFloat(this.targetDirection);
        buf.writeFloat(this.targetStrength);
        buf.writeVarInt(this.transitionTicks);
    }

    @Override
    public void handler(Player player) {
        ClientWindManager.handleUpdate(this.currentDirection, this.currentStrength, this.targetDirection, this.targetStrength, this.transitionTicks);
    }

    @Override
    public Side side() {
        return Side.CLIENTBOUND;
    }
}
