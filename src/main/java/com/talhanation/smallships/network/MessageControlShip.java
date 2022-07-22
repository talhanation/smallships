package com.talhanation.smallships.network;

import com.talhanation.smallships.entities.AbstractSailShip;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;

public class MessageControlShip implements Message<MessageControlShip> {

    private boolean forward, backward, left, right;
    private UUID uuid;

    public MessageControlShip() {

    }

    public MessageControlShip(boolean forward, boolean backward, boolean left, boolean right, Player player) {
        this.forward = forward;
        this.backward = backward;
        this.left = left;
        this.right = right;
        this.uuid = player.getUUID();
    }

    @Override
    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }

    @Override
    public void executeServerSide(NetworkEvent.Context context) {
        if (!context.getSender().getUUID().equals(uuid)) {
            //Main.LOGGER.error("The UUID of the sender was not equal to the packet UUID");
            return;
        }

        Entity entity = context.getSender().getVehicle();

        if (!(entity instanceof AbstractSailShip ship)) {
            return;
        }

        ship.updateControls(forward, backward, left, right, context.getSender());
        ship.sendSystemMessage(Component.literal("Forward: " + forward));
    }

    @Override
    public MessageControlShip fromBytes(FriendlyByteBuf buf) {
        this.forward = buf.readBoolean();
        this.backward = buf.readBoolean();
        this.left = buf.readBoolean();
        this.right = buf.readBoolean();
        this.uuid = buf.readUUID();
        return this;
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(forward);
        buf.writeBoolean(backward);
        buf.writeBoolean(left);
        buf.writeBoolean(right);
        buf.writeUUID(uuid);
    }

}
