package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * cannonSlot = -1: driver volley (sets the cannon key state, existing behavior).
 * cannonSlot >= 0: a gunner fires his single mapped cannon.
 */
public record ServerboundShootShipCannonPacket(boolean trigger, int cannonSlot) implements ModPacket {
    public static final Type<ServerboundShootShipCannonPacket> TYPE = new Type<>(ModPackets.id("server_shoot_ship_cannon"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundShootShipCannonPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, ServerboundShootShipCannonPacket::trigger,
            ByteBufCodecs.VAR_INT, ServerboundShootShipCannonPacket::cannonSlot,
            ServerboundShootShipCannonPacket::new);

    @Override
    public @NotNull Type<ServerboundShootShipCannonPacket> type() {
        return TYPE;
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
