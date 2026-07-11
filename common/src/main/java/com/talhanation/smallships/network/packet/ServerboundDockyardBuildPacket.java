package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import com.talhanation.smallships.world.dockyard.DockyardRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

/**
 * Sent when the player presses the build button in the dockyard screen.
 * The server re-validates materials and water spot before starting the build.
 */
public record ServerboundDockyardBuildPacket(BlockPos pos, int shipTypeId, int woodTypeOrdinal) implements ModPacket {
    public static final Type<ServerboundDockyardBuildPacket> TYPE = new Type<>(ModPackets.id("server_dockyard_build"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundDockyardBuildPacket> CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundDockyardBuildPacket::pos,
            ByteBufCodecs.VAR_INT, ServerboundDockyardBuildPacket::shipTypeId,
            ByteBufCodecs.VAR_INT, ServerboundDockyardBuildPacket::woodTypeOrdinal,
            ServerboundDockyardBuildPacket::new);

    @Override
    public @NotNull Type<ServerboundDockyardBuildPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            DockyardRecipe.ShipType shipType = DockyardRecipe.ShipType.byId(this.shipTypeId);
            Boat.Type woodType = Boat.Type.values()[Math.floorMod(this.woodTypeOrdinal, Boat.Type.values().length)];
            dockyard.startBuildShip(serverPlayer, shipType, woodType);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
