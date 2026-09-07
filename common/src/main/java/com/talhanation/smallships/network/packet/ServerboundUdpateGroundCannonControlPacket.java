package com.talhanation.smallships.network.packet;

import com.talhanation.smallships.network.ModPacket;
import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.cannon.GroundCannonEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;


public record ServerboundUdpateGroundCannonControlPacket(boolean forward, boolean backward, boolean left, boolean right, boolean aiming) implements ModPacket {
    public static final ResourceLocation ID = ModPackets.id("server_update_ground_cannon_control");

    public static ServerboundUdpateGroundCannonControlPacket read(FriendlyByteBuf buf) {
        return new ServerboundUdpateGroundCannonControlPacket(buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeBoolean(this.forward);
        buf.writeBoolean(this.backward);
        buf.writeBoolean(this.left);
        buf.writeBoolean(this.right);
        buf.writeBoolean(this.aiming);
    }


    @Override
    public void handler(Player player) {
        if (player.getVehicle() != null && player.getVehicle() instanceof GroundCannonEntity cannon) {
            cannon.updateControls(forward, backward, left, right, player);
            //cannon.updateBarrelControls(barrelUp, barrelDown, player);
            cannon.updateAimingControl(aiming, player);
        }
    }

    @Override
    public Side side() {
        return Side.SERVERBOUND;
    }
}