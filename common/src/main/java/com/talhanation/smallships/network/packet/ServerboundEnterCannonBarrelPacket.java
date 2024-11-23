package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public record ServerboundEnterCannonBarrelPacket(int cannonID, int entityID) implements ModPacket {
    public static final CustomPacketPayload.Type<ServerboundEnterCannonBarrelPacket> TYPE = new CustomPacketPayload.Type<>(ModPackets.id("server_enter_cannon_barrel"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundEnterCannonBarrelPacket> CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.INT, ServerboundEnterCannonBarrelPacket::cannonID,
                    ByteBufCodecs.INT, ServerboundEnterCannonBarrelPacket::entityID,
                    ServerboundEnterCannonBarrelPacket::new);

    @Override
    public void handler(Player player) {
        Entity entity = player.level().getEntity(this.entityID);
        Entity cannon = player.level().getEntity(this.cannonID);
        if (entity != null && cannon != null && cannon instanceof GroundCannonEntity cannonEntity) {
            cannonEntity.putEntityIntoBarrel(entity);
        }
    }

    @Override
    public ModPacket.Side side() {
        return ModPacket.Side.SERVERBOUND;
    }

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
