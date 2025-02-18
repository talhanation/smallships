package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record ServerboundOpenCannonScreenPacket(UUID uuid) implements ModPacket {
    public static final Type<ServerboundOpenCannonScreenPacket> TYPE = new Type<>(ModPackets.id("server_open_cannon_screen"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundOpenCannonScreenPacket> CODEC = StreamCodec.composite(UUIDUtil.STREAM_CODEC, ServerboundOpenCannonScreenPacket::uuid, ServerboundOpenCannonScreenPacket::new);

    @Override
    public @NotNull Type<ServerboundOpenCannonScreenPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        player.level().getEntitiesOfClass(GroundCannonEntity.class, player.getBoundingBoxForCulling()
                        .inflate(16.0D), entity -> entity.getUUID().equals(this.uuid))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(entity -> {
                    ContainerUtility.openCannonMenu(player, entity);
                });
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
