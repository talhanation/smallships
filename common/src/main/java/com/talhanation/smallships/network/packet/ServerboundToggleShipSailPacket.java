package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public record ServerboundToggleShipSailPacket() implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_toggle_ship_sail");

    public static ServerboundToggleShipSailPacket read(FriendlyByteBuf buf) {
        return new ServerboundToggleShipSailPacket();
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    /** Carries nothing - the press itself is the whole message. */
    @Override
    public void write(FriendlyByteBuf buf) {
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof Ship ship && ship instanceof Sailable sailShip) {
            sailShip.toggleSail();
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
