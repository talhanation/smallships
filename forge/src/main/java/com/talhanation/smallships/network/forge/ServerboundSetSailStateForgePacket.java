package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.abilities.Sailable;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ServerboundSetSailStateForgePacket implements ForgePacket {
    private final byte state;
    private final float speed;
    private final float rotSpeed;
    @SuppressWarnings("unused")
    ServerboundSetSailStateForgePacket(byte state, float speed, float rotSpeed) {
        this.state = state;
        this.speed = speed;
        this.rotSpeed = rotSpeed;
    }

    @SuppressWarnings("unused")
    public ServerboundSetSailStateForgePacket(FriendlyByteBuf buf) {
        this.state = buf.readByte();
        this.speed = buf.readFloat();
        this.rotSpeed = buf.readFloat();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeByte(state);
        buf.writeFloat(speed);
        buf.writeFloat(rotSpeed);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            assert player != null;
            if (player.getVehicle() != null && player.getVehicle() instanceof Sailable sailable) {
                sailable.self().setSailState(state);
                sailable.self().setSpeed(speed);
                sailable.self().setRotSpeed(rotSpeed);
            }
            ctx.get().setPacketHandled(true);
        });
    }
}
