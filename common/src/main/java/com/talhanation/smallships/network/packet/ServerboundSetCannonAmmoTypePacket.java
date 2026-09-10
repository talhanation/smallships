package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.item.CannonAmmoSelection;
import com.talhanation.smallships.world.item.CannonBallItem;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Sent whenever the player scrolls to a different cannon ammo type while
 * aiming (see CannonAmmoHandler). The server needs its own copy of the
 * selection because the driver's broadside is fired server side off the
 * synched cannon key state, not off a per-shot packet.
 */
public record ServerboundSetCannonAmmoTypePacket(byte ammoType) implements ModPacket {
    public static final Type<ServerboundSetCannonAmmoTypePacket> TYPE = new Type<>(ModPackets.id("server_set_cannon_ammo_type"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetCannonAmmoTypePacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE, ServerboundSetCannonAmmoTypePacket::ammoType,
            ServerboundSetCannonAmmoTypePacket::new);

    @Override
    public @NotNull Type<ServerboundSetCannonAmmoTypePacket> type() {
        return TYPE;
    }

    @Override
    public void handler(Player player) {
        // byId falls back to BALL on a garbage id, so what gets stored is always valid
        CannonAmmoSelection.set(player, CannonBallItem.Type.byId(this.ammoType));
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}