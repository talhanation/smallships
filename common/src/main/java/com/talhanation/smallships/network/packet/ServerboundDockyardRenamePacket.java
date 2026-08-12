package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent when the name field in the dockyard modify tab loses focus.
 *
 * Renaming is not dockyard work: it costs nothing and takes no time, so it is
 * applied straight away and does not go through the task state machine. An
 * empty name clears the custom name and the ship falls back to its type name.
 */
public record ServerboundDockyardRenamePacket(BlockPos pos, String name) implements ModPacket {
    public static final Type<ServerboundDockyardRenamePacket> TYPE = new Type<>(ModPackets.id("server_dockyard_rename"));

    /** same limit the name field enforces client side */
    public static final int MAX_NAME_LENGTH = 21;

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardRenamePacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardRenamePacket::pos,
            ByteBufCodecs.stringUtf8(MAX_NAME_LENGTH), ServerboundDockyardRenamePacket::name,
            ServerboundDockyardRenamePacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardRenamePacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (!(player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard)) return;

        Ship ship = dockyard.findNearestShip();
        if (ship == null) return;
        if (ship.isServicedByOtherDockyard(dockyard.getBlockPos())) {
            serverPlayer.displayClientMessage(Component.translatable("gui.smallships.dockyard.ship_busy"), true);
            return;
        }

        String trimmed = this.name.trim();
        ship.setCustomName(trimmed.isEmpty() ? null : Component.literal(trimmed));
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}