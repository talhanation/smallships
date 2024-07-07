package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ServerboundUpdateShipControlPacket(boolean forward, boolean backward, boolean left, boolean right) implements ModPacket {
    public static final Type<ServerboundUpdateShipControlPacket> TYPE = new Type<>(ModPackets.id("server_update_ship_control"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundUpdateShipControlPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundUpdateShipControlPacket::forward, ByteBufCodecs.BOOL, ServerboundUpdateShipControlPacket::backward, ByteBufCodecs.BOOL, ServerboundUpdateShipControlPacket::left, ByteBufCodecs.BOOL, ServerboundUpdateShipControlPacket::right, ServerboundUpdateShipControlPacket::new);

    @Override
    public @NotNull Type<ServerboundUpdateShipControlPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship) {
            ship.updateControls(forward, backward, left, right, player);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
