package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;

/* placeholder bool, I am not a fabric dev, I came from 1.12,
I don't know if there is a way to register packets without payload...*/
public record ServerboundShootGroundCannonPacket(boolean placeholder) implements ModPacket {
    public static final Type<ServerboundShootGroundCannonPacket> TYPE = new Type<>(ModPackets.id("server_shoot_ground_cannon"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundShootGroundCannonPacket> CODEC =
            StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundShootGroundCannonPacket::placeholder, ServerboundShootGroundCannonPacket::new);

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof GroundCannonEntity cannon) {
            cannon.trigger(player);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
