package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.particles.wood.WoodDebris;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * A ball has gone into a hull: where, what wood, and how hard. Sent to everyone
 * near enough to see it, see {@link WoodDebris} for why this does not go out as
 * an ordinary particle packet.
 */
public record ClientboundShipImpactPacket(double x, double y, double z, String woodType, int count, float power) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("client_ship_impact");

    public static ClientboundShipImpactPacket read(FriendlyByteBuf buf) {
        return new ClientboundShipImpactPacket(buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readUtf(), buf.readInt(), buf.readFloat());
    }
    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeDouble(this.x);
        buf.writeDouble(this.y);
        buf.writeDouble(this.z);
        buf.writeUtf(this.woodType);
        buf.writeInt(count);
        buf.writeFloat(power);
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