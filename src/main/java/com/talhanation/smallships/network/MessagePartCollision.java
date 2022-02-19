package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractShipDamage;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;

public class MessagePartCollision implements Message<MessagePartCollision> {
    private UUID uuid;

    public MessagePartCollision(){
        this.uuid = new UUID(0, 0);
    }

    public MessagePartCollision(PlayerEntity player){
        this.uuid = player.getUUID();
    }

    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }

    public void executeServerSide(NetworkEvent.Context context) {
        if (!context.getSender().getUUID().equals(uuid)) {
            return;
        }

        Entity e = context.getSender().getVehicle();
        if (e instanceof AbstractShipDamage) {
            ((AbstractShipDamage) e).onCollision();
            context.getSender().sendMessage(new StringTextComponent("Collide"), context.getSender().getUUID());
        }
    }

    public MessagePartCollision fromBytes(PacketBuffer buf) {
        this.uuid = buf.readUUID();
        return this;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeUUID(uuid);
    }
}
