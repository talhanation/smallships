package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record ServerboundOpenShipScreenPacket(UUID ship, int pageIndex) implements CustomPacketPayload, ModPacket {
    public static final Type<ServerboundOpenShipScreenPacket> TYPE = new Type<>(ModPackets.id("server_open_ship_screen"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundOpenShipScreenPacket> CODEC = StreamCodec.composite(UUIDUtil.STREAM_CODEC, ServerboundOpenShipScreenPacket::ship, ByteBufCodecs.INT, ServerboundOpenShipScreenPacket::pageIndex, ServerboundOpenShipScreenPacket::new);

    @Override
    public @NotNull Type<ServerboundOpenShipScreenPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        player.level().getEntitiesOfClass(ContainerShip.class, player.getBoundingBoxForCulling()
                        .inflate(16.0D), containerShip -> containerShip.getUUID().equals(this.ship))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(containerShip -> {
                    int pageIndex = Mth.clamp(this.pageIndex, 0, containerShip.containerData.get(1) - 1);
                    containerShip.containerData.set(2, pageIndex);
                    ContainerUtility.openShipMenu(player, containerShip);
                });
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
