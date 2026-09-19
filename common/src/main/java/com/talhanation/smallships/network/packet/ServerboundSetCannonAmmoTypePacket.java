package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.item.CannonAmmoSelection;
import com.talhanation.smallships.world.item.CannonBallItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/**
 * Sent whenever the player scrolls to a different cannon ammo type while
 * aiming (see CannonAmmoHandler). The server needs its own copy of the
 * selection because the driver's broadside is fired server side off the
 * synched cannon key state, not off a per-shot packet.
 */
public record ServerboundSetCannonAmmoTypePacket(byte ammoType) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_set_cannon_ammo_type");
    public static ServerboundSetCannonAmmoTypePacket read(FriendlyByteBuf buf){
        return new ServerboundSetCannonAmmoTypePacket(buf.readByte());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeByte(this.ammoType);
    }


    @Override
    public void handler(Player player) {
        CannonAmmoSelection.set(player, CannonBallItem.Type.byId(this.ammoType));
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}