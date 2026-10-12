package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent when the player flips through the ships in range with the arrows of the
 * dockyard modify tab.
 *
 * The client only says which WAY to step, never which ship it wants: the
 * dockyard searches the ships in range itself and keeps the selection, so the
 * ship the screen shows and the ship a job goes to can never drift apart.
 */
public record ServerboundDockyardSelectShipPacket(BlockPos pos, int direction) implements ModPacket {
    public static final Type<ServerboundDockyardSelectShipPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_select_ship"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardSelectShipPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardSelectShipPacket::pos,
            ByteBufCodecs.VAR_INT, ServerboundDockyardSelectShipPacket::direction,
            ServerboundDockyardSelectShipPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardSelectShipPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.cycleShip(this.direction < 0 ? -1 : 1);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}