package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public record ServerboundShootShipCannonPacket(boolean trigger) implements CustomPacketPayload, ModPacket {
    public static final Type<ServerboundShootShipCannonPacket> TYPE = new Type<>(ModPackets.id("server_shoot_ship_cannon"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundShootShipCannonPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundShootShipCannonPacket::trigger, ServerboundShootShipCannonPacket::new);

    @Override
    public @NotNull Type<ServerboundShootShipCannonPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Cannonable cannonShip) {
            cannonShip.self().setCannonKeyPressed(trigger);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
