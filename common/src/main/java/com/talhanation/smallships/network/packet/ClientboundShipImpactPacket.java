package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.particles.wood.WoodDebris;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

/**
 * A ball has gone into a hull: where, what wood, and how hard. Sent to everyone
 * near enough to see it, see {@link WoodDebris} for why this does not go out as
 * an ordinary particle packet.
 */
public record ClientboundShipImpactPacket(double x, double y, double z, String woodType, int count, float power) implements ModPacket {
    public static final Type<ClientboundShipImpactPacket> TYPE = new Type<>(ModPackets.id("client_ship_impact"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundShipImpactPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, ClientboundShipImpactPacket::x,
            ByteBufCodecs.DOUBLE, ClientboundShipImpactPacket::y,
            ByteBufCodecs.DOUBLE, ClientboundShipImpactPacket::z,
            ByteBufCodecs.STRING_UTF8, ClientboundShipImpactPacket::woodType,
            ByteBufCodecs.VAR_INT, ClientboundShipImpactPacket::count,
            ByteBufCodecs.FLOAT, ClientboundShipImpactPacket::power,
            ClientboundShipImpactPacket::new);

    @Override
    public @NotNull Type<ClientboundShipImpactPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        WoodDebris.spawn(player.level(), this.x, this.y, this.z, Boat.Type.byName(this.woodType), this.count, this.power);
    }

    @Override
    public Side side() {
        return Side.CLIENTBOUND;
    }
}