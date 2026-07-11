package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.client.wind.ClientWindManager;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ClientboundWindPacket(float currentDirection, float currentStrength, float targetDirection, float targetStrength, int transitionTicks) implements ModPacket {
    public static final Type<ClientboundWindPacket> TYPE = new Type<>(ModPackets.id("client_wind_update"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundWindPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT, ClientboundWindPacket::currentDirection,
            ByteBufCodecs.FLOAT, ClientboundWindPacket::currentStrength,
            ByteBufCodecs.FLOAT, ClientboundWindPacket::targetDirection,
            ByteBufCodecs.FLOAT, ClientboundWindPacket::targetStrength,
            ByteBufCodecs.VAR_INT, ClientboundWindPacket::transitionTicks,
            ClientboundWindPacket::new);

    @Override
    public @NotNull Type<ClientboundWindPacket> type() {
        return TYPE;
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
