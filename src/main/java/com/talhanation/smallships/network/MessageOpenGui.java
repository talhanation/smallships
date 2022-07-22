package com.talhanation.smallships.network;

import com.talhanation.smallships.InventoryEvents;
import com.talhanation.smallships.entities.AbstractInventoryEntity;
import de.maxhenkel.corelib.net.Message;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.UUID;

public class MessageOpenGui implements Message<MessageOpenGui> {
    private UUID uuid;
    private UUID ship;
    private int startSlot;

    public MessageOpenGui(){
        this.uuid = new UUID(0, 0);
    }

    public MessageOpenGui(Player player, AbstractInventoryEntity inventoryEntity, int startSlot)){
        this.uuid = player.getUUID();
        this.ship = inventoryEntity.getUUID();
        this.startSlot = startSlot;
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
                .ifPresent(entity -> InventoryEvents.openShipGUI(player, entity, startSlot));
    }

    public MessageOpenGui fromBytes(FriendlyByteBuf buf) {
        this.uuid = buf.readUUID();
        this.ship = buf.readUUID();
        this.startSlot = buf.readInt();
        return this;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(uuid);
        buf.writeUUID(ship);
        buf.writeInt(startSlot);
    }
}
