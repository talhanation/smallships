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
 * Sent when the player presses one of the two repair buttons in the dockyard
 * modify tab. Hull and sails are repaired separately - they wear down
 * independently and cost completely different materials, so paying for both at
 * once when only the canvas is torn would be a trap.
 *
 * The server validates the damage, the material costs and the claim.
 */
public record ServerboundDockyardRepairPacket(BlockPos pos, boolean hull, boolean sails) implements ModPacket {
    public static final Type<ServerboundDockyardRepairPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_repair"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardRepairPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardRepairPacket::pos,
            ByteBufCodecs.BOOL, ServerboundDockyardRepairPacket::hull,
            ByteBufCodecs.BOOL, ServerboundDockyardRepairPacket::sails,
            ServerboundDockyardRepairPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardRepairPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (!this.hull && !this.sails) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startRepairTask(serverPlayer, this.hull, this.sails);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}