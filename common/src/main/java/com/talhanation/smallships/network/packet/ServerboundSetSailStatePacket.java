package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ServerboundSetSailStatePacket(byte state) implements ModPacket {
    public static final Type<ServerboundSetSailStatePacket> TYPE = new Type<>(ModPackets.id("server_set_sail_state"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetSailStatePacket> CODEC = StreamCodec.composite(ByteBufCodecs.BYTE, ServerboundSetSailStatePacket::state, ServerboundSetSailStatePacket::new);

    @Override
    public @NotNull Type<ServerboundSetSailStatePacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Sailable sailShip) {
            sailShip.setSailState(state);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
