package com.talhanation.smallships.network;

import com.talhanation.smallships.CommonEvents;
import com.talhanation.smallships.Main;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.UUID;

public class MessageOpenGuiSecond implements Message<MessageOpenGuiSecond> {
    private UUID uuid;
    private UUID ship;

    public MessageOpenGuiSecond(){
        this.uuid = new UUID(0, 0);
    }

    public MessageOpenGuiSecond(PlayerEntity player, AbstractInventoryEntity inventoryEntity){
        this.uuid = player.getUUID();
        this.ship = inventoryEntity.getUUID();
    }

    public Dist getExecutingSide() {
        return Dist.DEDICATED_SERVER;
    }

    public void executeServerSide(NetworkEvent.Context context) {
        ServerPlayerEntity player = context.getSender();
        player.level.getEntitiesOfClass(AbstractInventoryEntity.class, player.getBoundingBox()
                        .inflate(16.0D), v -> v
                        .getUUID()
                        .equals(this.ship))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(entity -> CommonEvents.openShipGUI(player, 54, entity));

        Main.LOGGER.debug("Inv Message done");
    }

    public MessageOpenGuiSecond fromBytes(PacketBuffer buf) {
        this.uuid = buf.readUUID();
        this.ship = buf.readUUID();
        return this;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeUUID(uuid);
        buf.writeUUID(ship);
    }
}
