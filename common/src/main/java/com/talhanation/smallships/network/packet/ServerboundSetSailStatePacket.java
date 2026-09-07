package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public record ServerboundSetSailStatePacket(byte state) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_set_sail_state");

    public static ServerboundSetSailStatePacket read(FriendlyByteBuf buf) {
        return new ServerboundSetSailStatePacket(buf.readByte());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeByte(this.state);
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Sailable sailShip) {
            sailShip.setSailState(state);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
