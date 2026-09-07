package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.api.ShipRegistry;
import com.talhanation.smallships.api.ShipType;
import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.block.DockyardBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * Sent when the player presses the build button in the dockyard screen.
 * The ship type travels as its registry id, so it stays stable no matter in
 * which order the addons providing the ships happen to load.
 * The server re-validates the whitelist, materials and water spot before
 * starting the build.
 */
public record ServerboundDockyardBuildPacket(BlockPos pos, ResourceLocation shipTypeId, int woodTypeOrdinal) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_dockyard_build");

    public static ServerboundDockyardBuildPacket read(FriendlyByteBuf buf) {
        return new ServerboundDockyardBuildPacket(buf.readBlockPos(), buf.readResourceLocation(), buf.readVarInt());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeResourceLocation(this.shipTypeId);
        buf.writeVarInt(this.woodTypeOrdinal);
    }

    @Override
    public void handler(Player player) {
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (player.distanceToSqr(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) > 64.0D) return;
        if (player.level().getBlockEntity(this.pos) instanceof DockyardBlockEntity dockyard) {
            ShipType shipType = ShipRegistry.get(this.shipTypeId);
            if (shipType == null) return;
            Boat.Type woodType = Boat.Type.values()[Math.floorMod(this.woodTypeOrdinal, Boat.Type.values().length)];
            dockyard.startBuildShip(serverPlayer, shipType, woodType);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}