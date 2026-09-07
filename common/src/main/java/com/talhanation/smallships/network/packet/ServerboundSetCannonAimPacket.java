package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import com.talhanation.smallships.world.entity.ship.abilities.Seatable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * Sets the cannon aim.
 * cannonSlot = -1: broadside aim, sender must be the driver.
 * cannonSlot >= 0: per-cannon aim, sender must occupy the CANNON seat mapped
 * to that slot (gunner).
 */
public record ServerboundSetCannonAimPacket(int entityId, int cannonSlot, boolean rightSide, float angle, float rotation) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_set_cannon_aim");

    public static ServerboundSetCannonAimPacket read(FriendlyByteBuf buf) {
        return new ServerboundSetCannonAimPacket(buf.readVarInt(), buf.readVarInt(), buf.readBoolean(), buf.readFloat(), buf.readFloat());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeVarInt(this.entityId);
        // stays a plain VarInt because the broadside marker is -1, and writeVarInt
        // encodes that faithfully even if it spends five bytes on it
        buf.writeVarInt(this.cannonSlot);
        buf.writeBoolean(this.rightSide);
        buf.writeFloat(this.angle);
        buf.writeFloat(this.rotation);
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
