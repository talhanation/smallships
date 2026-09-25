package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.particles.sail.SailShreds;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;

/**
 * A ball has gone through the rigging: where, what colour the canvas is, and
 * how hard. The sail counterpart of {@link ClientboundShipImpactPacket}, see
 * {@link SailShreds}.
 */
public record ClientboundSailImpactPacket(double x, double y, double z, String color, int count, float power) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("client_sail_impact");

    public static ClientboundSailImpactPacket read(FriendlyByteBuf buf) {
        return new ClientboundSailImpactPacket(buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readUtf(), buf.readInt(), buf.readFloat());
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
        buf.writeUtf(this.color);
        buf.writeInt(count);
        buf.writeFloat(power);
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
