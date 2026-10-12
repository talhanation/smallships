package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.particles.sail.SailShreds;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * A ball has gone through the rigging: where, what colour the canvas is, and
 * how hard. The sail counterpart of {@link ClientboundShipImpactPacket}, see
 * {@link SailShreds}.
 */
public record ClientboundSailImpactPacket(double x, double y, double z, String color, int count, float power) implements ModPacket {
    public static final Type<ClientboundSailImpactPacket> TYPE = new Type<>(ModPackets.id("client_sail_impact"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundSailImpactPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, ClientboundSailImpactPacket::x,
            ByteBufCodecs.DOUBLE, ClientboundSailImpactPacket::y,
            ByteBufCodecs.DOUBLE, ClientboundSailImpactPacket::z,
            ByteBufCodecs.STRING_UTF8, ClientboundSailImpactPacket::color,
            ByteBufCodecs.VAR_INT, ClientboundSailImpactPacket::count,
            ByteBufCodecs.FLOAT, ClientboundSailImpactPacket::power,
            ClientboundSailImpactPacket::new);

    @Override
    public @NotNull Type<ClientboundSailImpactPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        SailShreds.spawn(player.level(), this.x, this.y, this.z, DyeColor.byName(this.color, DyeColor.WHITE), this.count, this.power);
    }

    @Override
    public Side side() {
        return Side.CLIENTBOUND;
    }
}