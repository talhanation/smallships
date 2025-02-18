package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;


public record ServerboundUdpateGroundCannonControlPacket(boolean forward, boolean backward, boolean left, boolean right) implements ModPacket {
    public static final Type<ServerboundUdpateGroundCannonControlPacket> TYPE = new Type<>(ModPackets.id("server_update_ground_cannon_control"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundUdpateGroundCannonControlPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundUdpateGroundCannonControlPacket::forward, ByteBufCodecs.BOOL, ServerboundUdpateGroundCannonControlPacket::backward, ByteBufCodecs.BOOL, ServerboundUdpateGroundCannonControlPacket::left, ByteBufCodecs.BOOL, ServerboundUdpateGroundCannonControlPacket::right, ServerboundUdpateGroundCannonControlPacket::new);

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof GroundCannonEntity cannon) {
            cannon.updateControls(forward, backward, left, right, player);
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
