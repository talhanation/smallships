package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sets the cannon aim.
 * cannonSlot = -1: broadside aim, sender must be the driver.
 * cannonSlot >= 0: per-cannon aim, sender must occupy the CANNON seat mapped
 * to that slot (gunner).
 */
public record ServerboundSetCannonAimPacket(int entityId, int cannonSlot, boolean rightSide, float angle, float rotation) implements ModPacket {
    public static final Type<ServerboundSetCannonAimPacket> TYPE = new Type<>(ModPackets.id("server_set_cannon_aim"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetCannonAimPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ServerboundSetCannonAimPacket::entityId,
            ByteBufCodecs.VAR_INT, ServerboundSetCannonAimPacket::cannonSlot,
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
        if (!(entity instanceof Cannonable cannonable) || player.getVehicle() != entity) return;

        if (this.cannonSlot < 0) {
            // broadside: driver only
            if (cannonable.self().getControllingPassenger() == player) {
                cannonable.setCannonAim(this.rightSide, this.angle, this.rotation);
            }
        } else {
            // per-cannon: mapped gunner only
            if (cannonable instanceof Seatable seatable && seatable.getGunner(this.cannonSlot) == player) {
                cannonable.setCannonAim(this.cannonSlot, this.rightSide, this.angle, this.rotation);
            }
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
