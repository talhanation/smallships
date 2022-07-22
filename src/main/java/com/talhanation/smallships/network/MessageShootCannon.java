package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractCannonShip;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

public class MessageShootCannon implements Message<MessageShootCannon> {

    private boolean shoot;

    public MessageShootCannon() {
    }

    public MessageShootCannon(boolean shoot) {
        this.shoot = shoot;
    }

    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }

    public void executeServerSide(NetworkEvent.Context context) {
        Entity riding = context.getSender().getVehicle();
        if (!(riding instanceof AbstractCannonShip))
            return;
        AbstractCannonShip sailBoat = (AbstractCannonShip) riding;
        if (context.getSender() == (sailBoat.getDriver())) {
            sailBoat.startCannons(shoot);
        }
    }

    public MessageShootCannon fromBytes(FriendlyByteBuf buf) {
        this.shoot = buf.readBoolean();
        return this;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(this.shoot);
    }

}
