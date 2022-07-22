package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractSailShip;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageSailState implements Message<MessageSailState> {

    private int state;

    public MessageSailState() {
    }

    public MessageSailState(int state) {
        this.state = state;
    }

    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }

    public void executeServerSide(NetworkEvent.Context context) {
        Entity riding = context.getSender().getVehicle();
        if (!(riding instanceof AbstractSailShip))
            return;
        AbstractSailShip sailboat = (AbstractSailShip) riding;
        if (context.getSender() == (sailboat.getDriver())) {
            sailboat.setSailState(state);
        }
    }

    public MessageSailState fromBytes(PacketBuffer buf) {
        this.state = buf.readInt();
        return this;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.state);
    }

}