package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ServerboundToggleShipSailPacket() implements CustomPacketPayload, ModPacket {
    public static final Type<ServerboundToggleShipSailPacket> TYPE = new Type<>(ModPackets.id("server_toggle_ship_sail"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundToggleShipSailPacket> CODEC = StreamCodec.unit(new ServerboundToggleShipSailPacket());

    @Override
    public @NotNull Type<ServerboundToggleShipSailPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship && ship instanceof Sailable sailShip) {
            sailShip.toggleSail();
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
