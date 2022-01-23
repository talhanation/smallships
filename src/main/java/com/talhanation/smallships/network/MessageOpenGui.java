package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;

public class MessageOpenGui implements Message<MessageOpenGui> {
    private UUID uuid;

    public MessageOpenGui(){
        this.uuid = new UUID(0, 0);
    }

    public MessageOpenGui(PlayerEntity player){
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
        if (e instanceof AbstractInventoryEntity)
            ((AbstractInventoryEntity)e).openGUI(context.getSender());
    }

    public MessageOpenGui fromBytes(PacketBuffer buf) {
        this.uuid = buf.readUUID();
        return this;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeUUID(uuid);
    }
}
