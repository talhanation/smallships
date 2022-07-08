package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;

public class MessageOpenGui implements Message<MessageOpenGui> {
    private UUID uuid;

    public MessageOpenGui(){
        this.uuid = new UUID(0, 0);
    }

    public MessageOpenGui(Player player){
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

    public MessageOpenGui fromBytes(FriendlyByteBuf buf) {
        this.uuid = buf.readUUID();
        return this;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(uuid);
    }
}
