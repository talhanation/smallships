package com.talhanation.smallships.network.forge;

import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class ServerboundOpenShipScreenForgePacket implements ForgePacket {
    private final UUID ship;
    private final int pageIndex;

    ServerboundOpenShipScreenForgePacket(ContainerShip containerShip, int pageIndex) {
        this.ship = containerShip.getUUID();
        this.pageIndex = pageIndex;
    }

    @SuppressWarnings("unused")
    public ServerboundOpenShipScreenForgePacket(FriendlyByteBuf buf) {
        this.ship = buf.readUUID();
        this.pageIndex = buf.readInt();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(this.ship);
        buf.writeInt(this.pageIndex);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            player.getLevel().getEntitiesOfClass(ContainerShip.class, player.getBoundingBoxForCulling()
                            .inflate(16.0D), containerShip -> containerShip.getUUID().equals(this.ship))
                    .stream()
                    .filter(Entity::isAlive)
                    .findAny()
                    .ifPresent(containerShip -> {
                        int pageIndex = Mth.clamp(this.pageIndex, 0, containerShip.containerData.get(1) - 1);
                        containerShip.containerData.set(2, pageIndex);
                        ContainerUtility.openShipMenu(player, containerShip);
                    });
        });
        ctx.get().setPacketHandled(true);
    }
}
