package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.entity.ship.ShipUpgrade;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent when the player clicks an upgrade icon in the dockyard screen
 * (install or remove).
 */
public record ServerboundDockyardUpgradePacket(BlockPos pos, int upgradeOrdinal, boolean install) implements ModPacket {
    public static final Type<ServerboundDockyardUpgradePacket> TYPE = new Type<>(ModPackets.id("server_dockyard_upgrade"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardUpgradePacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardUpgradePacket::pos,
            ByteBufCodecs.VAR_INT, ServerboundDockyardUpgradePacket::upgradeOrdinal,
            ByteBufCodecs.BOOL, ServerboundDockyardUpgradePacket::install,
            ServerboundDockyardUpgradePacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardUpgradePacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startUpgradeTask(serverPlayer, ShipUpgrade.byOrdinal(this.upgradeOrdinal), this.install);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
