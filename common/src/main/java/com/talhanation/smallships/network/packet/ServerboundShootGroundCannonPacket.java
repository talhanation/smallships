package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import com.talhanation.smallships.world.entity.ship.abilities.Cannonable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/* placeholder bool, I am not a fabric dev, I came from 1.12,
I don't know if there is a way to register packets without payload...*/
public record ServerboundShootGroundCannonPacket(boolean placeholder) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_shoot_ground_cannon");

    public static ServerboundShootGroundCannonPacket read(FriendlyByteBuf buf) {
        return new ServerboundShootGroundCannonPacket(buf.readBoolean());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.placeholder);
    }

    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof GroundCannonEntity cannon) {
            cannon.trigger(player);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}
