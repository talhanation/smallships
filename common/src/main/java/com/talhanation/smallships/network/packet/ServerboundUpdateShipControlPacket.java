package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public record ServerboundUpdateShipControlPacket(boolean forward, boolean backward, boolean left, boolean right) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_update_ship_control");

    public static ServerboundUpdateShipControlPacket read(FriendlyByteBuf buf) {
        return new ServerboundUpdateShipControlPacket(buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.forward);
        buf.writeBoolean(this.backward);
        buf.writeBoolean(this.left);
        buf.writeBoolean(this.right);
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship) {
            ship.updateControls(forward, backward, left, right, player);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
