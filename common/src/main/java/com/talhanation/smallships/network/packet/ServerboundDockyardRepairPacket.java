package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent when the player presses the repair button in the dockyard screen.
 * The server validates the damage, the material costs and the claim.
 */
public record ServerboundDockyardRepairPacket(BlockPos pos) implements ModPacket {
    public static final Type<ServerboundDockyardRepairPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_repair"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardRepairPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardRepairPacket::pos,
            ServerboundDockyardRepairPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardRepairPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startRepairTask(serverPlayer);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}