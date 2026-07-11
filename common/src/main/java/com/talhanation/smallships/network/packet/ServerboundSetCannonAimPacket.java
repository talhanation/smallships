package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent by the driver while aiming the broadside cannons with right click + mouse.
 * The server validates the limits and stores the aim in the ship's entity data.
 */
public record ServerboundSetCannonAimPacket(int entityId, boolean rightSide, float angle, float rotation) implements ModPacket {
    public static final Type<ServerboundSetCannonAimPacket> TYPE = new Type<>(ModPackets.id("server_set_cannon_aim"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetCannonAimPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ServerboundSetCannonAimPacket::entityId,
            ByteBufCodecs.BOOL, ServerboundSetCannonAimPacket::rightSide,
            ByteBufCodecs.FLOAT, ServerboundSetCannonAimPacket::angle,
            ByteBufCodecs.FLOAT, ServerboundSetCannonAimPacket::rotation,
            ServerboundSetCannonAimPacket::new);

    @Override
    public @NotNull Type<ServerboundSetCannonAimPacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        Entity entity = player.level().getEntity(this.entityId);
        // only the driver of the ship may aim
        if (entity instanceof Cannonable cannonable && player.getVehicle() == entity && cannonable.self().getControllingPassenger() == player) {
            cannonable.setCannonAim(this.rightSide, this.angle, this.rotation);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
