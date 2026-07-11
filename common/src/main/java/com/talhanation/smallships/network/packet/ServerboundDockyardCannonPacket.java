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
 * Sent when the player clicks a cannon slot in the dockyard screen:
 * mount = true installs a cannon (consumes 1 cannon item from the player
 * inventory), mount = false removes it (drops the cannon at the ship).
 */
public record ServerboundDockyardCannonPacket(BlockPos pos, int cannonSlot, boolean mount) implements ModPacket {
    public static final Type<ServerboundDockyardCannonPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_cannon"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardCannonPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardCannonPacket::pos,
            ByteBufCodecs.VAR_INT, ServerboundDockyardCannonPacket::cannonSlot,
            ByteBufCodecs.BOOL, ServerboundDockyardCannonPacket::mount,
            ServerboundDockyardCannonPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardCannonPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            dockyard.startCannonTask(serverPlayer, this.cannonSlot, this.mount);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
