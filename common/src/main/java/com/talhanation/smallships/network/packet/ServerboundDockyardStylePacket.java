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
 * Sent when the player clicks a style button (dye or banner from his
 * inventory) in the dockyard screen. The inventory slot is validated server
 * side, the item is consumed and applied to the ship after a work time.
 */
public record ServerboundDockyardStylePacket(BlockPos pos, int inventorySlot) implements ModPacket {
    public static final Type<ServerboundDockyardStylePacket> TYPE = new Type<>(ModPackets.id("server_dockyard_style"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardStylePacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardStylePacket::pos,
            ByteBufCodecs.VAR_INT, ServerboundDockyardStylePacket::inventorySlot,
            ServerboundDockyardStylePacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardStylePacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startStyleTask(serverPlayer, this.inventorySlot);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}