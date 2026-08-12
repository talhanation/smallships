package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.DockyardAction;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Sent when the player presses the apply button in the dockyard modify tab.
 *
 * The player can tick several rows before pressing it, so this carries the
 * whole batch: the dockyard turns it into ONE task with summed costs and summed
 * work time. The server re-validates every single action - the client only ever
 * gets to say WHAT it wants, never what it costs.
 */
public record ServerboundDockyardApplyPacket(BlockPos pos, List<DockyardAction> actions) implements ModPacket {
    public static final Type<ServerboundDockyardApplyPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_apply"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardApplyPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardApplyPacket::pos,
            DockyardAction.STREAM_CODEC.apply(ByteBufCodecs.list()), ServerboundDockyardApplyPacket::actions,
            ServerboundDockyardApplyPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardApplyPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        // a client could send thousands of entries to stall the server tick
        if (this.actions.isEmpty() || this.actions.size() > 64) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startModifyTask(serverPlayer, this.actions);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}