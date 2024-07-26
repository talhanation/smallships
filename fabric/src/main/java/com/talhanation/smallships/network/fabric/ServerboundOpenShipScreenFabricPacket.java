package com.talhanation.smallships.network.fabric;

import com.talhanation.smallships.network.ModPackets;
import com.talhanation.smallships.world.entity.ship.ContainerShip;
import com.talhanation.smallships.world.inventory.ContainerUtility;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class ServerboundOpenShipScreenFabricPacket implements FabricPacket, ServerPlayNetworking.PlayChannelHandler {
    private final UUID ship;
    private final int pageIndex;

    public ServerboundOpenShipScreenFabricPacket(UUID containerShipUUID, int pageIndex) {
        this.ship = containerShipUUID;
        this.pageIndex = pageIndex;
    }

    public ServerboundOpenShipScreenFabricPacket(FriendlyByteBuf buf) {
        this.ship = buf.readUUID();
        this.pageIndex = buf.readInt();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUUID(this.ship);
        buf.writeInt(this.pageIndex);
    }

    @Override
    public ResourceLocation getId() {
        return ModPackets.id("server_open_ship_screen");
    }

    @SuppressWarnings("unused")
    @Override
    public void receive(MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
        player.level().getEntitiesOfClass(ContainerShip.class, player.getBoundingBoxForCulling()
                        .inflate(16.0D), containerShip -> containerShip.getUUID().equals(this.ship))
                .stream()
                .filter(Entity::isAlive)
                .findAny()
                .ifPresent(containerShip -> {
                    int pageIndex = Mth.clamp(this.pageIndex, 0, containerShip.containerData.get(1) - 1);
                    containerShip.containerData.set(2, pageIndex);
                    ContainerUtility.openShipMenu(player, containerShip);
                });
    }
}
