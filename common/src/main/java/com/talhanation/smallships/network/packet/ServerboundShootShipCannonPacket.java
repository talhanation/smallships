package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/**
 * cannonSlot = -1: driver volley (sets the cannon key state, existing behavior).
 * cannonSlot >= 0: a gunner fires his single mapped cannon.
 */
public record ServerboundShootShipCannonPacket(boolean trigger, int cannonSlot) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_shoot_ship_cannon");

    public static ServerboundShootShipCannonPacket read(FriendlyByteBuf buf) {
        return new ServerboundShootShipCannonPacket(buf.readBoolean(), buf.readVarInt());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.trigger);
        buf.writeVarInt(this.cannonSlot);
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() == null || !(player.getVehicle() instanceof Cannonable cannonShip)) return;

        if (this.cannonSlot < 0) {
            // driver volley: driver only
            if (cannonShip.self().getControllingPassenger() == player) {
                cannonShip.self().setCannonKeyPressed(trigger);
            }
        } else if (this.trigger) {
            // gunner shot: validate seat <-> slot mapping
            if (cannonShip instanceof Seatable seatable && seatable.getGunner(this.cannonSlot) == player) {
                cannonShip.triggerGunnerCannon(this.cannonSlot);
            }
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
